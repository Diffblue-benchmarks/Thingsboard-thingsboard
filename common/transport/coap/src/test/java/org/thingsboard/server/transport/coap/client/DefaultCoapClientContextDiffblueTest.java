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
package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.coapserver.CoapServerContext;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
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
import org.thingsboard.server.transport.coap.CoapTransportContext;
import org.thingsboard.server.transport.coap.TransportConfigurationContainer;
import org.thingsboard.server.transport.coap.adaptors.CoapTransportAdaptor;

class DefaultCoapClientContextDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onDeviceUpdate(TransportProtos.SessionInfoProto, Device, Optional)}
   */
  @Test
  void testCoapSessionListenerOnDeviceUpdate() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    doNothing().when(state).onDeviceUpdate(Mockito.<Device>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
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

    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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
        producerProvider, ruleEngineProducerService, topicService, serviceInfoProvider3, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = (new DefaultCoapClientContext(config,
        transportContext, transportService, profileCache,
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()))).new CoapSessionListener(state);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    Device device = new Device();

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    Optional<DeviceProfile> deviceProfileOpt = Optional.of(deviceProfile);

    // Act
    coapSessionListener.onDeviceUpdate(sessionInfo, device, deviceProfileOpt);

    // Assert that nothing has changed
    verify(deviceProfile).getProfileData();
    verify(state).onDeviceUpdate(isA(Device.class));
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testCoapSessionListenerOnRemoteSessionCloseCommand() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext defaultCoapClientContext = new DefaultCoapClientContext(config, transportContext,
        transportService, profileCache, new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
            applicationEventPublisher, queueRoutingInfoService, new TopicService()));

    TbCoapClientState state = mock(TbCoapClientState.class);
    doNothing().when(state).setAttrs(Mockito.<TbCoapObservationState>any());
    when(state.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(state).setRpc(Mockito.<TbCoapObservationState>any());
    when(state.getAttrs()).thenReturn(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123"));
    when(state.getRpc()).thenReturn(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123"));
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = defaultCoapClientContext.new CoapSessionListener(
        state);
    UUID sessionId = UUID.randomUUID();

    // Act
    coapSessionListener.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToAttributeUpdatesMsg.class), isA(TransportServiceCallback.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToRPCMsg.class), isA(TransportServiceCallback.class));
    verify(state, atLeast(1)).getAttrs();
    verify(state, atLeast(1)).getRpc();
    verify(state, atLeast(1)).getSession();
    verify(state).setAttrs(isNull());
    verify(state).setRpc(isNull());
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testCoapSessionListenerOnRemoteSessionCloseCommand2() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext defaultCoapClientContext = new DefaultCoapClientContext(config, transportContext,
        transportService, profileCache, new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
            applicationEventPublisher, queueRoutingInfoService, new TopicService()));

    TbCoapClientState state = mock(TbCoapClientState.class);
    doNothing().when(state).setAdaptor(Mockito.<CoapTransportAdaptor>any());
    doNothing().when(state).setConfiguration(Mockito.<TransportConfigurationContainer>any());
    doNothing().when(state).setCredentials(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(state).setSession(Mockito.<TransportProtos.SessionInfoProto>any());
    when(state.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(state).setRpc(Mockito.<TbCoapObservationState>any());
    when(state.getAttrs()).thenReturn(null);
    when(state.getRpc()).thenReturn(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123"));
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = defaultCoapClientContext.new CoapSessionListener(
        state);
    UUID sessionId = UUID.randomUUID();

    // Act
    coapSessionListener.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(transportService).deregisterSession(isA(TransportProtos.SessionInfoProto.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SessionEventMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToRPCMsg.class), isA(TransportServiceCallback.class));
    verify(state, atLeast(1)).getAttrs();
    verify(state, atLeast(1)).getRpc();
    verify(state, atLeast(1)).getSession();
    verify(state).setAdaptor(isNull());
    verify(state).setConfiguration(isNull());
    verify(state).setCredentials(isNull());
    verify(state).setRpc(isNull());
    verify(state).setSession(isNull());
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testCoapSessionListenerOnRemoteSessionCloseCommand3() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext defaultCoapClientContext = new DefaultCoapClientContext(config, transportContext,
        transportService, profileCache, new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
            applicationEventPublisher, queueRoutingInfoService, new TopicService()));

    TbCoapObservationState tbCoapObservationState = mock(TbCoapObservationState.class);
    when(tbCoapObservationState.getExchange()).thenReturn(new CoapExchange(
        new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))));
    when(tbCoapObservationState.getToken()).thenReturn("ABC123");
    TbCoapClientState state = mock(TbCoapClientState.class);
    doNothing().when(state).setAttrs(Mockito.<TbCoapObservationState>any());
    when(state.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(state).setRpc(Mockito.<TbCoapObservationState>any());
    when(state.getAttrs()).thenReturn(tbCoapObservationState);
    when(state.getRpc()).thenReturn(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123"));
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = defaultCoapClientContext.new CoapSessionListener(
        state);
    UUID sessionId = UUID.randomUUID();

    // Act
    coapSessionListener.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToAttributeUpdatesMsg.class), isA(TransportServiceCallback.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToRPCMsg.class), isA(TransportServiceCallback.class));
    verify(state, atLeast(1)).getAttrs();
    verify(state, atLeast(1)).getRpc();
    verify(state, atLeast(1)).getSession();
    verify(state).setAttrs(isNull());
    verify(state).setRpc(isNull());
    verify(tbCoapObservationState).getExchange();
    verify(tbCoapObservationState).getToken();
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testCoapSessionListenerOnRemoteSessionCloseCommand4() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext defaultCoapClientContext = new DefaultCoapClientContext(config, transportContext,
        transportService, profileCache, new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
            applicationEventPublisher, queueRoutingInfoService, new TopicService()));

    TbCoapObservationState tbCoapObservationState = mock(TbCoapObservationState.class);
    when(tbCoapObservationState.getExchange()).thenReturn(new CoapExchange(
        new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))));
    when(tbCoapObservationState.getToken()).thenReturn("ABC123");
    TbCoapClientState state = mock(TbCoapClientState.class);
    doNothing().when(state).setAdaptor(Mockito.<CoapTransportAdaptor>any());
    doNothing().when(state).setConfiguration(Mockito.<TransportConfigurationContainer>any());
    doNothing().when(state).setCredentials(Mockito.<ValidateDeviceCredentialsResponse>any());
    doNothing().when(state).setSession(Mockito.<TransportProtos.SessionInfoProto>any());
    doNothing().when(state).setAttrs(Mockito.<TbCoapObservationState>any());
    when(state.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    when(state.getAttrs()).thenReturn(tbCoapObservationState);
    when(state.getRpc()).thenReturn(null);
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = defaultCoapClientContext.new CoapSessionListener(
        state);
    UUID sessionId = UUID.randomUUID();

    // Act
    coapSessionListener.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(transportService).deregisterSession(isA(TransportProtos.SessionInfoProto.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SessionEventMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToAttributeUpdatesMsg.class), isA(TransportServiceCallback.class));
    verify(state, atLeast(1)).getAttrs();
    verify(state, atLeast(1)).getRpc();
    verify(state, atLeast(1)).getSession();
    verify(state).setAdaptor(isNull());
    verify(state).setAttrs(isNull());
    verify(state).setConfiguration(isNull());
    verify(state).setCredentials(isNull());
    verify(state).setSession(isNull());
    verify(tbCoapObservationState).getExchange();
    verify(tbCoapObservationState).getToken();
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testCoapSessionListenerOnRemoteSessionCloseCommand5() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(),
            Mockito.<TransportProtos.SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext defaultCoapClientContext = new DefaultCoapClientContext(config, transportContext,
        transportService, profileCache, new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
            applicationEventPublisher, queueRoutingInfoService, new TopicService()));

    TbCoapObservationState tbCoapObservationState = mock(TbCoapObservationState.class);
    when(tbCoapObservationState.getExchange()).thenReturn(new CoapExchange(
        new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))));
    when(tbCoapObservationState.getToken()).thenReturn("ABC123");
    TbCoapObservationState tbCoapObservationState2 = mock(TbCoapObservationState.class);
    when(tbCoapObservationState2.getExchange()).thenReturn(new CoapExchange(
        new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))));
    when(tbCoapObservationState2.getToken()).thenReturn("ABC123");
    TbCoapClientState state = mock(TbCoapClientState.class);
    doNothing().when(state).setAttrs(Mockito.<TbCoapObservationState>any());
    when(state.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(state).setRpc(Mockito.<TbCoapObservationState>any());
    when(state.getAttrs()).thenReturn(tbCoapObservationState);
    when(state.getRpc()).thenReturn(tbCoapObservationState2);
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = defaultCoapClientContext.new CoapSessionListener(
        state);
    UUID sessionId = UUID.randomUUID();

    // Act
    coapSessionListener.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToAttributeUpdatesMsg.class), isA(TransportServiceCallback.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscribeToRPCMsg.class), isA(TransportServiceCallback.class));
    verify(state, atLeast(1)).getAttrs();
    verify(state, atLeast(1)).getRpc();
    verify(state, atLeast(1)).getSession();
    verify(state).setAttrs(isNull());
    verify(state).setRpc(isNull());
    verify(tbCoapObservationState).getExchange();
    verify(tbCoapObservationState2).getExchange();
    verify(tbCoapObservationState).getToken();
    verify(tbCoapObservationState2).getToken();
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext.CoapSessionListener#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  void testCoapSessionListenerOnToServerRpcResponse() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
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

    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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
        producerProvider, ruleEngineProducerService, topicService, serviceInfoProvider3, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    DefaultCoapClientContext.CoapSessionListener coapSessionListener = (new DefaultCoapClientContext(config,
        transportContext, transportService, profileCache,
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()))).new CoapSessionListener(state);

    // Act
    coapSessionListener.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(state).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}
   */
  @Test
  void testGetNotificationCounterByToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
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

    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertNull((new DefaultCoapClientContext(config, transportContext, transportService, profileCache,
        new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3, applicationEventPublisher3,
            queueRoutingInfoService3, new TopicService())))
        .getNotificationCounterByToken("ABC123"));
  }
}
