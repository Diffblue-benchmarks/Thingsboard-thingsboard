package org.thingsboard.server.transport.lwm2m.server.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.SettableFuture;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import java.util.HashMap;
import java.util.List;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.eclipse.leshan.server.registration.RegistrationStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.TransportRateLimitService;
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
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.DefaultLwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.attributes.LwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContext;
import org.thingsboard.server.transport.lwm2m.server.downlink.LwM2mDownlinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfigService;
import org.thingsboard.server.transport.lwm2m.server.ota.LwM2MOtaUpdateService;
import org.thingsboard.server.transport.lwm2m.server.rpc.DefaultLwM2MRpcRequestHandler;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2MDtlsSessionStore;
import org.thingsboard.server.transport.lwm2m.server.store.TbLwM2mSecurityStore;
import org.thingsboard.server.transport.lwm2m.server.uplink.DefaultLwM2mUplinkMsgHandler;
import org.thingsboard.server.transport.lwm2m.server.uplink.LwM2mUplinkMsgHandler;

class DefaultLwM2MSessionManagerDiffblueTest {
  /**
   * Test {@link DefaultLwM2MSessionManager#register(SessionInfoProto)}.
   * <ul>
   *   <li>Then DefaultInstance DescriptorForType Fields size is eighteen.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2MSessionManager#register(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test register(SessionInfoProto); then DefaultInstance DescriptorForType Fields size is eighteen")
  void testRegister_thenDefaultInstanceDescriptorForTypeFieldsSizeIsEighteen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportService transportService3 = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService2 = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2MSessionManager defaultLwM2MSessionManager = new DefaultLwM2MSessionManager(transportService,
        attributesService, rpcHandler,
        new DefaultLwM2mUplinkMsgHandler(transportService3, context, attributesService2, sessionManager, otaService,
            new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class), mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class),
            mock(LwM2mDownlinkMsgHandler.class), mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class),
            mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class)));
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    defaultLwM2MSessionManager.register(sessionInfo);

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    Descriptors.Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    List<Descriptors.OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    assertEquals(futures, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(futures, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(futures, toProtoResult.getSourceCodeInfo().getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(futures, defaultInstanceForType.getAllFields());
    DescriptorProtos.FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(futures, features.getAllFields());
    DescriptorProtos.FieldOptions options = fields.get(0).getOptions();
    assertEquals(futures, options.getAllFields());
    DescriptorProtos.OneofOptions options2 = oneofs.get(0).getOptions();
    assertEquals(futures, options2.getAllFields());
    assertEquals(futures, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(futures, features.getAllFieldsRaw());
    assertEquals(futures, options.getAllFieldsRaw());
    assertEquals(futures, options2.getAllFieldsRaw());
  }

  /**
   * Test {@link DefaultLwM2MSessionManager#deregister(SessionInfoProto)}.
   * <ul>
   *   <li>Then calls
   * {@link TransportService#deregisterSession(SessionInfoProto)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2MSessionManager#deregister(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test deregister(SessionInfoProto); then calls deregisterSession(SessionInfoProto)")
  void testDeregister_thenCallsDeregisterSession() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportService transportService3 = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService2 = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2MSessionManager defaultLwM2MSessionManager = new DefaultLwM2MSessionManager(transportService,
        attributesService, rpcHandler,
        new DefaultLwM2mUplinkMsgHandler(transportService3, context, attributesService2, sessionManager, otaService,
            new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class), mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class),
            mock(LwM2mDownlinkMsgHandler.class), mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class),
            mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class)));

    // Act
    defaultLwM2MSessionManager.deregister(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService).deregisterSession(isA(TransportProtos.SessionInfoProto.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SessionEventMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Test {@link DefaultLwM2MSessionManager#deregister(SessionInfoProto)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationRuleProcessor#process(NotificationRuleTrigger)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2MSessionManager#deregister(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test deregister(SessionInfoProto); then calls process(NotificationRuleTrigger)")
  void testDeregister_thenCallsProcess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TransportService transportService2 = mock(TransportService.class);
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    LwM2mClientContext clientContext = mock(LwM2mClientContext.class);
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, clientContext, new LwM2MTransportServerConfig(), mock(LwM2mUplinkMsgHandler.class),
        mock(LwM2mDownlinkMsgHandler.class), mock(LwM2MTelemetryLogService.class), mock(LwM2MOtaUpdateService.class),
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(mock(TransportService.class),
        mock(LwM2mClientContext.class), mock(LwM2mUplinkMsgHandler.class), mock(LwM2mDownlinkMsgHandler.class),
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TransportService transportService3 = mock(TransportService.class);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    LwM2MAttributesService attributesService2 = mock(LwM2MAttributesService.class);
    LwM2MSessionManager sessionManager = mock(LwM2MSessionManager.class);
    LwM2MOtaUpdateService otaService = mock(LwM2MOtaUpdateService.class);
    DefaultLwM2MSessionManager defaultLwM2MSessionManager = new DefaultLwM2MSessionManager(transportService,
        attributesService, rpcHandler,
        new DefaultLwM2mUplinkMsgHandler(transportService3, context, attributesService2, sessionManager, otaService,
            new LwM2MTransportServerConfig(), mock(LwM2MTelemetryLogService.class),
            mock(LwM2mTransportServerHelper.class), mock(TbLwM2MDtlsSessionStore.class), mock(LwM2mClientContext.class),
            mock(LwM2mDownlinkMsgHandler.class), mock(LwM2mVersionedModelProvider.class), mock(RegistrationStore.class),
            mock(TbLwM2mSecurityStore.class), mock(LwM2MModelConfigService.class)));

    // Act
    defaultLwM2MSessionManager.deregister(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
  }
}
