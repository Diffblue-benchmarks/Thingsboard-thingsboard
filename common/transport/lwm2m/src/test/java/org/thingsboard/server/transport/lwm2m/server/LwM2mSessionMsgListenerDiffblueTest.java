/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.RegistrationStore;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.server.attributes.DefaultLwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigService;
import org.thingsboard.server.transport.lwm2m.server.ota.LwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.rpc.DefaultLwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.LwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MDtlsSessionStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class LwM2mSessionMsgListenerDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2mSessionMsgListener#onAttributeUpdate(UUID, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testOnAttributeUpdate() {
    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientBySessionInfo(Mockito.<TransportProtos.SessionInfoProto>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService,
        helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService2 = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(transportService2, context,
        attributesService2, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(
        mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    LwM2mSessionMsgListener lwM2mSessionMsgListener = new LwM2mSessionMsgListener(handler, attributesService,
        rpcHandler, sessionInfo,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    UUID sessionId = UUID.randomUUID();

    // Act
    lwM2mSessionMsgListener.onAttributeUpdate(sessionId,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(clientContext).getClientBySessionInfo(isA(TransportProtos.SessionInfoProto.class));
  }

  /**
   * Method under test:
   * {@link LwM2mSessionMsgListener#onToTransportUpdateCredentials(TransportProtos.ToTransportUpdateCredentialsProto)}
   */
  @Test
  void testOnToTransportUpdateCredentials() {
    // Arrange
    LwM2mUplinkMsgHandler handler = mock(LwM2mUplinkMsgHandler.class);
    doNothing().when(handler)
        .onToTransportUpdateCredentials(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.ToTransportUpdateCredentialsProto>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService,
        helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    LwM2mSessionMsgListener lwM2mSessionMsgListener = new LwM2mSessionMsgListener(handler, attributesService,
        rpcHandler, sessionInfo,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));

    // Act
    lwM2mSessionMsgListener
        .onToTransportUpdateCredentials(TransportProtos.ToTransportUpdateCredentialsProto.getDefaultInstance());

    // Assert
    verify(handler).onToTransportUpdateCredentials(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToTransportUpdateCredentialsProto.class));
  }

  /**
   * Method under test:
   * {@link LwM2mSessionMsgListener#onDeviceProfileUpdate(TransportProtos.SessionInfoProto, DeviceProfile)}
   */
  @Test
  void testOnDeviceProfileUpdate() {
    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getLwM2mClients()).thenReturn(new ArrayList<>());
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(transportService, context,
        attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext2 = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext2, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(
        mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    LwM2mSessionMsgListener lwM2mSessionMsgListener = new LwM2mSessionMsgListener(handler, attributesService2,
        rpcHandler, sessionInfo,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    TransportProtos.SessionInfoProto sessionInfo2 = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mSessionMsgListener.onDeviceProfileUpdate(sessionInfo2, new DeviceProfile());

    // Assert that nothing has changed
    verify(clientContext).getLwM2mClients();
  }

  /**
   * Method under test:
   * {@link LwM2mSessionMsgListener#onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)}
   */
  @Test
  void testOnDeviceUpdate() {
    // Arrange
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    when(clientContext.getClientByDeviceId(Mockito.<UUID>any()))
        .thenReturn(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    TransportService transportService = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(transportService, context,
        attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), clientContext, mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext2 = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext2, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(
        mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    LwM2mSessionMsgListener lwM2mSessionMsgListener = new LwM2mSessionMsgListener(handler, attributesService2,
        rpcHandler, sessionInfo,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    TransportProtos.SessionInfoProto sessionInfo2 = TransportProtos.SessionInfoProto.getDefaultInstance();
    Device device = new Device();
    Optional<DeviceProfile> deviceProfileOpt = Optional.of(new DeviceProfile());

    // Act
    lwM2mSessionMsgListener.onDeviceUpdate(sessionInfo2, device, deviceProfileOpt);

    // Assert
    verify(clientContext).getClientByDeviceId(isNull());
  }

  /**
   * Method under test:
   * {@link LwM2mSessionMsgListener#onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testOnToDeviceRpcRequest() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(transportService,
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(transportService2, context,
        attributesService, sessionManager, otaService, new LwM2MTransportServerConfig(),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mTransportServerHelper.class),
        mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class), mock(TbLwM2mSecurityStore.class),
        mock(LwM2MModelConfigService.class));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService3 = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures, transportService3,
        helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(
        mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    LwM2mSessionMsgListener lwM2mSessionMsgListener = new LwM2mSessionMsgListener(handler, attributesService2,
        rpcHandler, sessionInfo,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    UUID sessionId = UUID.randomUUID();

    // Act
    lwM2mSessionMsgListener.onToDeviceRpcRequest(sessionId, TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }
}
