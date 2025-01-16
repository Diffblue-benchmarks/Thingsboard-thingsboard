package org.thingsboard.server.transport.lwm2m.server.downlink;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.eclipse.leshan.core.model.ObjectModel;
import org.eclipse.leshan.core.request.ContentFormat;
import org.eclipse.leshan.core.request.CreateRequest;
import org.eclipse.leshan.core.request.ObserveCompositeRequest;
import org.eclipse.leshan.core.request.ReadCompositeRequest;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.core.response.CreateResponse;
import org.eclipse.leshan.core.response.ObserveCompositeResponse;
import org.eclipse.leshan.core.response.ReadCompositeResponse;
import org.eclipse.leshan.server.model.LwM2mModelProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
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
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.LwM2mVersionedModelProvider;
import org.thingsboard.server.transport.lwm2m.server.attributes.DefaultLwM2MAttributesService;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClientContextImpl;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MObserveCompositeRequest;
import org.thingsboard.server.transport.lwm2m.server.downlink.composite.TbLwM2MReadCompositeRequest;
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

class DefaultLwM2mDownlinkMsgHandlerDiffblueTest {
  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#getExecutorSize()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#getExecutorSize()}
   */
  @Test
  @DisplayName("Test getExecutorSize(); then return zero")
  void testGetExecutorSize_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null, config3, logService2, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context5, config4, securityStore3,
        clientStore2, sessionManager2, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertEquals(0,
        (new DefaultLwM2mDownlinkMsgHandler(context, config, logService, clientContext,
            new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext())))
            .getExecutorSize());
  }

  /**
   * Test {@link DefaultLwM2mDownlinkMsgHandler#getExecutorName()}.
   * <p>
   * Method under test: {@link DefaultLwM2mDownlinkMsgHandler#getExecutorName()}
   */
  @Test
  @DisplayName("Test getExecutorName()")
  void testGetExecutorName() {
    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
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

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService2 = new DefaultTransportService(null, null, null, null, topicService2,
        serviceInfoProvider4, statsFactory2, deviceProfileCache2, tenantProfileCache2, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2mUplinkMsgHandler uplinkHandler = new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null,
        config4, logService2, null, sessionStore, null, null, null, registrationStore, null,
        new LwM2MModelConfigServiceImpl());

    LwM2MTelemetryLogService logService3 = mock(LwM2MTelemetryLogService.class);
    LwM2MTransportServerConfig config5 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService4 = mock(LwM2MTelemetryLogService.class);
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, transportService2,
        helper, null, config3, uplinkHandler, null, logService3, new DefaultLwM2MOtaUpdateService(null, null, config5,
            null, null, null, logService4, null, new TbDummyLwM2MClientOtaInfoStore()),
        mock(LwM2mModelProvider.class));

    TopicService topicService3 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService3 = new DefaultTransportService(null, null, null, null, topicService3,
        serviceInfoProvider5, statsFactory3, deviceProfileCache3, tenantProfileCache3, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config6 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService5 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore2 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore2 = new TbInMemoryRegistrationStore();
    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(transportService3, null,
        new DefaultLwM2mUplinkMsgHandler(null, context5, null, null, null, config6, logService5, null, sessionStore2,
            null, null, null, registrationStore2, null, new LwM2MModelConfigServiceImpl()),
        null, mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache4 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService4 = new DefaultTransportService(null, null, null, null, topicService4,
        serviceInfoProvider6, statsFactory4, deviceProfileCache4, tenantProfileCache4, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    LwM2mTransportContext context6 = new LwM2mTransportContext();
    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures2 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService2 = new DefaultLwM2MAttributesService(futures2, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    LwM2MTransportServerConfig config7 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService6 = mock(LwM2MTelemetryLogService.class);
    DefaultLwM2MOtaUpdateService otaService = new DefaultLwM2MOtaUpdateService(null, null, config7, null, null, null,
        logService6, null, new TbDummyLwM2MClientOtaInfoStore());

    LwM2MTransportServerConfig config8 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService7 = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportServerHelper helper2 = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    TbL2M2MDtlsSessionInMemoryStore sessionStore3 = new TbL2M2MDtlsSessionInMemoryStore();
    LwM2mVersionedModelProvider modelProvider = new LwM2mVersionedModelProvider(null, null,
        new LwM2mTransportContext());

    TbInMemoryRegistrationStore registrationStore3 = new TbInMemoryRegistrationStore();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler,
        new DefaultLwM2mUplinkMsgHandler(transportService4, context6, attributesService2, null, otaService, config8,
            logService7, helper2, sessionStore3, null, null, modelProvider, registrationStore3, securityStore3,
            new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache5 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache5, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context7 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config9 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore4 = new TbInMemorySecurityStore();
    LwM2mTransportContext context8 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore5 = new TbLwM2mSecurityStore(securityStore4,
        new LwM2mCredentialsSecurityInfoValidator(context8, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache6 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService5 = new DefaultTransportService(null, null, null, null, topicService5,
        serviceInfoProvider7, statsFactory5, deviceProfileCache6, tenantProfileCache5, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures3 = new HashMap<>();
    DefaultLwM2MAttributesService attributesService3 = new DefaultLwM2MAttributesService(futures3, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler2 = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context9 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config10 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService8 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore4 = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore4 = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(transportService5, attributesService3,
        rpcHandler2, new DefaultLwM2mUplinkMsgHandler(null, context9, null, null, null, config10, logService8, null,
            sessionStore4, null, null, null, registrationStore4, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache7 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context7, config9, securityStore5,
        clientStore2, sessionManager2, deviceProfileCache7, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper3 = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertEquals("LwM2M Downlink",
        (new DefaultLwM2mDownlinkMsgHandler(context, config, logService, clientContext,
            new LwM2mVersionedModelProvider(lwM2mClientContext, helper3, new LwM2mTransportContext())))
            .getExecutorName());
  }

  /**
   * Test
   * {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add fromCode two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback); given HashSet() add fromCode two")
  void testSendReadCompositeRequest_givenHashSetAddFromCodeTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null, config3, logService2, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context5, config4, securityStore3,
        clientStore2, sessionManager2, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context, config,
        logService, clientContext,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));

    HashSet<ContentFormat> contentFormatSet = new HashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(2));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(client,
        mock(TbLwM2MReadCompositeRequest.class), mock(DownlinkRequestCallback.class)));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test
   * {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mDownlinkMsgHandler#sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendReadCompositeRequest(LwM2mClient, TbLwM2MReadCompositeRequest, DownlinkRequestCallback); given HashSet(); then throw RuntimeException")
  void testSendReadCompositeRequest_givenHashSet_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null, config3, logService2, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context5, config4, securityStore3,
        clientStore2, sessionManager2, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context, config,
        logService, clientContext,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultLwM2mDownlinkMsgHandler.sendReadCompositeRequest(client,
        mock(TbLwM2MReadCompositeRequest.class), mock(DownlinkRequestCallback.class)));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test
   * {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add fromCode two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback); given HashSet() add fromCode two")
  void testSendObserveCompositeRequest_givenHashSetAddFromCodeTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null, config3, logService2, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context5, config4, securityStore3,
        clientStore2, sessionManager2, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context, config,
        logService, clientContext,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));

    HashSet<ContentFormat> contentFormatSet = new HashSet<>();
    contentFormatSet.add(ContentFormat.fromCode(2));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(contentFormatSet);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(client,
        mock(TbLwM2MObserveCompositeRequest.class), mock(DownlinkRequestCallback.class)));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test
   * {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mDownlinkMsgHandler#sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendObserveCompositeRequest(LwM2mClient, TbLwM2MObserveCompositeRequest, DownlinkRequestCallback); given HashSet(); then throw RuntimeException")
  void testSendObserveCompositeRequest_givenHashSet_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null, config3, logService2, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context5, config4, securityStore3,
        clientStore2, sessionManager2, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context, config,
        logService, clientContext,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getClientSupportContentFormats()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultLwM2mDownlinkMsgHandler.sendObserveCompositeRequest(client,
        mock(TbLwM2MObserveCompositeRequest.class), mock(DownlinkRequestCallback.class)));
    verify(client).getClientSupportContentFormats();
  }

  /**
   * Test
   * {@link DefaultLwM2mDownlinkMsgHandler#sendCreateRequest(LwM2mClient, TbLwM2MCreateRequest, DownlinkRequestCallback)}.
   * <ul>
   *   <li>Then throw {@link InvalidRequestException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultLwM2mDownlinkMsgHandler#sendCreateRequest(LwM2mClient, TbLwM2MCreateRequest, DownlinkRequestCallback)}
   */
  @Test
  @DisplayName("Test sendCreateRequest(LwM2mClient, TbLwM2MCreateRequest, DownlinkRequestCallback); then throw InvalidRequestException")
  void testSendCreateRequest_thenThrowInvalidRequestException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config2 = new LwM2MTransportServerConfig();
    TbInMemorySecurityStore securityStore = new TbInMemorySecurityStore();
    LwM2mTransportContext context3 = new LwM2mTransportContext();
    TbLwM2mSecurityStore securityStore2 = new TbLwM2mSecurityStore(securityStore,
        new LwM2mCredentialsSecurityInfoValidator(context3, new LwM2MTransportServerConfig()));

    TbDummyLwM2MClientStore clientStore = new TbDummyLwM2MClientStore();
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService = new DefaultTransportService(null, null, null, null, topicService,
        serviceInfoProvider, statsFactory, deviceProfileCache, tenantProfileCache, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    HashMap<Integer, SettableFuture<List<TransportProtos.TsKvProto>>> futures = new HashMap<>();
    DefaultLwM2MAttributesService attributesService = new DefaultLwM2MAttributesService(futures, null, null, null,
        new LwM2MTransportServerConfig(), null, null, mock(LwM2MTelemetryLogService.class), null,
        mock(LwM2mModelProvider.class));

    DefaultLwM2MRpcRequestHandler rpcHandler = new DefaultLwM2MRpcRequestHandler(null, null, null, null,
        mock(LwM2MTelemetryLogService.class), mock(LwM2mModelProvider.class));

    LwM2mTransportContext context4 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config3 = new LwM2MTransportServerConfig();
    LwM2MTelemetryLogService logService2 = mock(LwM2MTelemetryLogService.class);
    TbL2M2MDtlsSessionInMemoryStore sessionStore = new TbL2M2MDtlsSessionInMemoryStore();
    TbInMemoryRegistrationStore registrationStore = new TbInMemoryRegistrationStore();
    DefaultLwM2MSessionManager sessionManager = new DefaultLwM2MSessionManager(transportService, attributesService,
        rpcHandler, new DefaultLwM2mUplinkMsgHandler(null, context4, null, null, null, config3, logService2, null,
            sessionStore, null, null, null, registrationStore, null, new LwM2MModelConfigServiceImpl()));

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl clientContext = new LwM2mClientContextImpl(context2, config2, securityStore2, clientStore,
        sessionManager, deviceProfileCache2, new LwM2MModelConfigServiceImpl());

    LwM2mTransportContext context5 = new LwM2mTransportContext();
    LwM2MTransportServerConfig config4 = new LwM2MTransportServerConfig();
    TbLwM2mSecurityStore securityStore3 = new TbLwM2mSecurityStore(new TbInMemorySecurityStore(), null);

    TbDummyLwM2MClientStore clientStore2 = new TbDummyLwM2MClientStore();
    DefaultLwM2MSessionManager sessionManager2 = new DefaultLwM2MSessionManager(null, null, null, null);

    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    LwM2mClientContextImpl lwM2mClientContext = new LwM2mClientContextImpl(context5, config4, securityStore3,
        clientStore2, sessionManager2, deviceProfileCache3, new LwM2MModelConfigServiceImpl());

    LwM2mTransportServerHelper helper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    DefaultLwM2mDownlinkMsgHandler defaultLwM2mDownlinkMsgHandler = new DefaultLwM2mDownlinkMsgHandler(context, config,
        logService, clientContext,
        new LwM2mVersionedModelProvider(lwM2mClientContext, helper, new LwM2mTransportContext()));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getRegistration()).thenThrow(new InvalidRequestException("/"));
    when(client.getObjectModel(Mockito.<String>any(), Mockito.<LwM2mModelProvider>any())).thenReturn(new ObjectModel(1,
        "Name", "The characteristics of someone or something", "1.0.2", true, true, new ArrayList<>()));
    when(client.isValidObjectVersion(Mockito.<String>any())).thenReturn("");
    TbLwM2MCreateRequest request = mock(TbLwM2MCreateRequest.class);
    when(request.getVersionedId()).thenReturn("42");
    when(request.getObjectId()).thenReturn("42");

    // Act and Assert
    assertThrows(InvalidRequestException.class,
        () -> defaultLwM2mDownlinkMsgHandler.sendCreateRequest(client, request, mock(DownlinkRequestCallback.class)));
    verify(client).getObjectModel(eq("42"), isA(LwM2mModelProvider.class));
    verify(client).getRegistration();
    verify(client).isValidObjectVersion(eq("42"));
    verify(request, atLeast(1)).getVersionedId();
    verify(request, atLeast(1)).getObjectId();
  }
}
