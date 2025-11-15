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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.List;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
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
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MAuthorizer;
import org.thingsboard.server.transport.lwm2m.secure.TbLwM2MDtlsCertificateVerifier;
import org.thingsboard.server.transport.lwm2m.server.attributes.DefaultLwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContextImpl;
import org.thingsboard.server.transport.lwm2m.server.downlink.DefaultLwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigServiceImpl;
import org.thingsboard.server.transport.lwm2m.server.ota.DefaultLwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.rpc.DefaultLwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.session.DefaultLwM2MSessionManager;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientOtaInfoStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbDummyLwM2MClientStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemoryRegistrationStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbInMemorySecurityStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbL2M2MDtlsSessionInMemoryStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;

class DefaultLwM2mTransportServiceDiffblueTest {
  /**
   * Method under test: {@link DefaultLwM2mTransportService#getName()}
   */
  @Test
  void testGetName() {
    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    CaffeineOtaPackageCache otaPackageDataCache = new CaffeineOtaPackageCache(new CaffeineCacheManager());
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
    DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider2 = new InMemoryTbTransportQueueFactory(transportApiSettings3,
        transportNotificationSettings3, serviceInfoProvider7, coreSettings3, storage2, new TopicService());

    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(null);
    TopicService topicService3 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService2 = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService3, serviceInfoProvider8, statsFactory2,
        deviceProfileCache2, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context3, config2, securityStore, clientStore,
        sessionManager, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config5 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache4 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext2 = new LwM2mClientContextImpl(context5, config5, null, clientStore2, null,
        deviceProfileCache4, new LwM2MModelConfigServiceImpl());

    DefaultLwM2mDownlinkMsgHandler downlinkHandler = new DefaultLwM2mDownlinkMsgHandler(context4, config4, logService,
        clientContext2, new LwM2mVersionedModelProvider(null, null, new LwM2mTransportContext()));

    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache5 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService3 = new DefaultTransportService(null, null, null, null, topicService4,
        serviceInfoProvider9, statsFactory3, deviceProfileCache5, tenantProfileCache3, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context6 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config6 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore3 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache6 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext3 = new LwM2mClientContextImpl(context6, config6, null, clientStore3, null,
        deviceProfileCache6, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config7 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context7 = new LwM2mTransportContext();
    DefaultLwM2mDownlinkMsgHandler downlinkHandler2 = new DefaultLwM2mDownlinkMsgHandler(context7,
        new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class), null, null);

    CaffeineOtaPackageCache otaPackageDataCache2 = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    LwM2MTelemetryLogService logService3 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper2 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext, config3, null, downlinkHandler, logService2,
        new DefaultLwM2MOtaUpdateService(transportService3, clientContext3, config7, null, downlinkHandler2,
            otaPackageDataCache2, logService3, helper2, new TbDummyLwM2MClientOtaInfoStore()),
        mock(LwM2mModelProvider.class));

    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider10, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider3 = new InMemoryTbTransportQueueFactory(transportApiSettings4,
        transportNotificationSettings4, serviceInfoProvider11, coreSettings4, storage3, new TopicService());

    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(null);
    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache7 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService3 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler3 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache3 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor3 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService4 = new DefaultTransportService(partitionService3, queueProvider3,
        producerProvider3, ruleEngineProducerService3, topicService5, serviceInfoProvider12, statsFactory4,
        deviceProfileCache7, tenantProfileCache4, rateLimitService3, scheduler3, eventPublisher3,
        transportResourceCache3, notificationRuleProcessor3, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures2 = new HashMap<>();
    TopicService topicService6 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache8 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService5 = new DefaultTransportService(null, null, null, null, topicService6,
        serviceInfoProvider13, statsFactory5, deviceProfileCache8, tenantProfileCache5, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportServerHelper helper3 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mTransportContext context8 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config8 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore4 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache9 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext4 = new LwM2mClientContextImpl(context8, config8, null, clientStore4, null,
        deviceProfileCache9, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config9 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context9 = new LwM2mTransportContext();
    DefaultLwM2mDownlinkMsgHandler downlinkHandler3 = new DefaultLwM2mDownlinkMsgHandler(context9,
        new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class), null, null);

    LwM2MTelemetryLogService logService4 = mock(LwM2MTelemetryLogService.class);
    LwM2MTransportServerConfig config10 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService5 = mock(LwM2MTelemetryLogService.class);
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures2, transportService5,
        helper3, clientContext4, config9, null, downlinkHandler3, logService4, new DefaultLwM2MOtaUpdateService(null,
            null, config10, null, null, null, logService5, null, new TbDummyLwM2MClientOtaInfoStore()),
        mock(LwM2mModelProvider.class));

    TopicService topicService7 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory6 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache10 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache6 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService6 = new DefaultTransportService(null, null, null, null, topicService7,
        serviceInfoProvider14, statsFactory6, deviceProfileCache10, tenantProfileCache6, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context10 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config11 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore5 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache11 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext5 = new LwM2mClientContextImpl(context10, config11, null, clientStore5, null,
        deviceProfileCache11, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context11 = new LwM2mTransportContext();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(transportService4, attributesService2,
        new DefaultLwM2MRpcRequestHandler(transportService6, clientContext5, null,
            new DefaultLwM2mDownlinkMsgHandler(context11, new LwM2MTransportServerConfig(),
                mock(LwM2MTelemetryLogService.class), null, null),
            mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class)),
        null);

    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider15, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    TbQueueTransportApiSettings transportApiSettings5 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings5 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings5 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage4 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider4 = new InMemoryTbTransportQueueFactory(transportApiSettings5,
        transportNotificationSettings5, serviceInfoProvider16, coreSettings5, storage4, new TopicService());

    TbCoreQueueProducerProvider producerProvider4 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService4 = new TbRuleEngineProducerService(null);
    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider17 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory7 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache12 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache7 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService4 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler4 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache4 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor4 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService7 = new DefaultTransportService(partitionService4, queueProvider4,
        producerProvider4, ruleEngineProducerService4, topicService8, serviceInfoProvider17, statsFactory7,
        deviceProfileCache12, tenantProfileCache7, rateLimitService4, scheduler4, eventPublisher4,
        transportResourceCache4, notificationRuleProcessor4, new DefaultEntityLimitsCache(1, 3));

    LwM2mTransportContext context12 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config12 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore6 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager3 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache13 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext6 = new LwM2mClientContextImpl(context12, config12, securityStore2,
        clientStore6, sessionManager3, deviceProfileCache13, new LwM2MModelConfigServiceImpl());

    LwM2MTransportServerConfig config13 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context13 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config14 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService6 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context14 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config15 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore7 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache14 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext7 = new LwM2mClientContextImpl(context14, config15, null, clientStore7, null,
        deviceProfileCache14, new LwM2MModelConfigServiceImpl());

    DefaultLwM2mDownlinkMsgHandler downlinkHandler4 = new DefaultLwM2mDownlinkMsgHandler(context13, config14,
        logService6, clientContext7, new LwM2mVersionedModelProvider(null, null, new LwM2mTransportContext()));

    CaffeineOtaPackageCache otaPackageDataCache3 = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    LwM2MTelemetryLogService logService7 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper4 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2MOtaUpdateService otaService = new DefaultLwM2MOtaUpdateService(transportService7, clientContext6,
        config13, null, downlinkHandler4, otaPackageDataCache3, logService7, helper4,
        new TbDummyLwM2MClientOtaInfoStore());

    LwM2MTransportServerConfig config16 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService8 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper5 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2mTransportContext context15 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config17 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore3 = new TbInMemorySecurityStore();
    LwM2mTransportContext context16 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore4 = new TbLwM2mSecurityStore(securityStore3,
        new LwM2mCredentialsSecurityInfoValidator(context16, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore8 = new TbDummyLwM2MClientStore();
    TopicService topicService9 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider18 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory8 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache15 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache8 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService8 = new DefaultTransportService(null, null, null, null, topicService9,
        serviceInfoProvider18, statsFactory8, deviceProfileCache15, tenantProfileCache8, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures3 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService3 = new DefaultLwM2MAttributesService(futures3, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MSessionManager sessionManager4 = new DefaultLwM2MSessionManager(transportService8, attributesService3,
        new DefaultLwM2MRpcRequestHandler(null, null, null, null, mock(LwM2MTelemetryLogService.class),
            mock(LwM2mModelProvider.class)),
        null);

    DefaultTransportDeviceProfileCache deviceProfileCache16 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext8 = new LwM2mClientContextImpl(context15, config17, securityStore4,
        clientStore8, sessionManager4, deviceProfileCache16, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context17 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config18 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService9 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context18 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config19 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore5 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore9 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager5 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache17 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext9 = new LwM2mClientContextImpl(context18, config19, securityStore5,
        clientStore9, sessionManager5, deviceProfileCache17, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context19 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config20 = new LwM2MTransportServerConfig();
    TbDummyLwM2MClientStore clientStore10 = new TbDummyLwM2MClientStore();
    DefaultTransportDeviceProfileCache deviceProfileCache18 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context19, config20, null, clientStore10,
        null, deviceProfileCache18, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper6 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2MDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context17,
        config18, logService9, clientContext9,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper6, new LwM2mTransportContext()));

    LwM2mTransportContext context20 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config21 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore6 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore11 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager6 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache19 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext2 = new LwM2mClientContextImpl(context20, config21, securityStore6,
        clientStore11, sessionManager6, deviceProfileCache19, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper7 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2mVersionedModelProvider modelProvider = new LwM2mVersionedModelProvider(lwM2mClientContext2, helper7,
        new LwM2mTransportContext());

    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    TbInMemorySecurityStore securityStore7 = new TbInMemorySecurityStore();
    LwM2mTransportContext context21 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore8 = new TbLwM2mSecurityStore(securityStore7,
        new LwM2mCredentialsSecurityInfoValidator(context21, new LwM2MTransportServerConfig()));

    DefaultLwM2mUplinkMsgHandler handler = new DefaultLwM2mUplinkMsgHandler(transportService, context2,
        attributesService, sessionManager2, otaService, config16, logService8, helper5, sessionStore, clientContext8,
        defaultLwM2MDownlinkMsgHandler, modelProvider, registrationStore, securityStore8,
        new LwM2MModelConfigServiceImpl());

    TbInMemoryRegistrationStore registrationStore2 = new TbInMemoryRegistrationStore();
    TbInMemorySecurityStore securityStore9 = new TbInMemorySecurityStore();
    TbL2M2MDtlsSessionInMemoryStore sessionStorage = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2MTransportServerConfig config22 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context22 = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator securityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(context22,
        new LwM2MTransportServerConfig());

    TbInMemorySecurityStore securityStore10 = new TbInMemorySecurityStore();
    LwM2mTransportContext context23 = new LwM2mTransportContext();
    TbLwM2MDtlsCertificateVerifier certificateVerifier = new TbLwM2MDtlsCertificateVerifier(sessionStorage, config22,
        securityInfoValidator, new TbLwM2mSecurityStore(securityStore10,
            new LwM2mCredentialsSecurityInfoValidator(context23, new LwM2MTransportServerConfig())));

    TbL2M2MDtlsSessionInMemoryStore sessionStorage2 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemorySecurityStore securityStore11 = new TbInMemorySecurityStore();
    LwM2mTransportContext context24 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore12 = new TbLwM2mSecurityStore(securityStore11,
        new LwM2mCredentialsSecurityInfoValidator(context24, new LwM2MTransportServerConfig()));

    LwM2mTransportContext context25 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config23 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore13 = new TbInMemorySecurityStore();
    LwM2mTransportContext context26 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore14 = new TbLwM2mSecurityStore(securityStore13,
        new LwM2mCredentialsSecurityInfoValidator(context26, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore12 = new TbDummyLwM2MClientStore();
    TopicService topicService10 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider19 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory9 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache20 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache9 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService9 = new DefaultTransportService(null, null, null, null, topicService10,
        serviceInfoProvider19, statsFactory9, deviceProfileCache20, tenantProfileCache9, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures4 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService4 = new DefaultLwM2MAttributesService(futures4, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context27 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config24 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService10 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore2 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore3 = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager7 = new DefaultLwM2MSessionManager(transportService9, attributesService4,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context27, null, null, null, config24, logService10, null,
            sessionStore2, null, null, null, registrationStore3, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache21 = new DefaultTransportDeviceProfileCache();
    TbLwM2MAuthorizer authorizer = new TbLwM2MAuthorizer(sessionStorage2, securityStore12,
        new LwM2mClientContextImpl(context25, config23, securityStore14, clientStore12, sessionManager7,
            deviceProfileCache21, new LwM2MModelConfigServiceImpl()));

    LwM2mTransportContext context28 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config25 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore15 = new TbInMemorySecurityStore();
    LwM2mTransportContext context29 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore16 = new TbLwM2mSecurityStore(securityStore15,
        new LwM2mCredentialsSecurityInfoValidator(context29, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore13 = new TbDummyLwM2MClientStore();
    TopicService topicService11 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider20 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory10 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache22 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache10 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService10 = new DefaultTransportService(null, null, null, null, topicService11,
        serviceInfoProvider20, statsFactory10, deviceProfileCache22, tenantProfileCache10, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures5 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService5 = new DefaultLwM2MAttributesService(futures5, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler2 = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context30 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config26 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService11 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore3 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore4 = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager8 = new DefaultLwM2MSessionManager(transportService10, attributesService5,
        rpcHandler2, new DefaultLwM2mUplinkMsgHandler(null, context30, null, null, null, config26, logService11, null,
            sessionStore3, null, null, null, registrationStore4, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache23 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext3 = new LwM2mClientContextImpl(context28, config25, securityStore16,
        clientStore13, sessionManager8, deviceProfileCache23, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper8 = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertEquals("LWM2M",
        (new DefaultLwM2mTransportService(context, config, otaPackageDataCache, handler, registrationStore2,
            securityStore9, certificateVerifier, authorizer,
            new LwM2mVersionedModelProvider(lwM2mClientContext3, helper8, new LwM2mTransportContext()))).getName());
  }
}
