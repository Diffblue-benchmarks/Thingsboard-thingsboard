package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.leshan.core.model.LwM2mModel;
import org.eclipse.leshan.core.model.StaticModel;
import org.eclipse.leshan.core.peer.LwM2mIdentity;
import org.eclipse.leshan.core.peer.LwM2mPeer;
import org.eclipse.leshan.core.request.BootstrapDeleteRequest;
import org.eclipse.leshan.core.request.BootstrapDownlinkRequest;
import org.eclipse.leshan.core.request.BootstrapFinishRequest;
import org.eclipse.leshan.core.request.BootstrapRequest;
import org.eclipse.leshan.core.request.exception.InvalidRequestException;
import org.eclipse.leshan.core.response.BootstrapDeleteResponse;
import org.eclipse.leshan.core.response.LwM2mResponse;
import org.eclipse.leshan.server.bootstrap.BootstrapConfig;
import org.eclipse.leshan.server.bootstrap.BootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.BootstrapFailureCause;
import org.eclipse.leshan.server.bootstrap.BootstrapSession;
import org.eclipse.leshan.server.bootstrap.BootstrapSessionManager;
import org.eclipse.leshan.server.bootstrap.BootstrapTaskProvider;
import org.eclipse.leshan.server.bootstrap.DefaultBootstrapSession;
import org.eclipse.leshan.server.model.LwM2mBootstrapModelProvider;
import org.eclipse.leshan.server.security.BootstrapSecurityStore;
import org.eclipse.leshan.server.security.SecurityChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
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
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapConfigStoreTaskProvider;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapSecurityStore;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapTaskProvider;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MInMemoryBootstrapConfigStore;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MAuthException;

class LwM2mDefaultBootstrapSessionManagerDiffblueTest {
  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)}
   */
  @Test
  @DisplayName("Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)")
  void testNewLwM2mDefaultBootstrapSessionManager() {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    SecurityChecker securityChecker = new SecurityChecker();

    // Act and Assert
    assertFalse((new LwM2mDefaultBootstrapSessionManager(bsSecurityStore, configStore, securityChecker,
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class)),
        mock(LwM2mBootstrapModelProvider.class))).hasConfigFor(null));
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, TransportService)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, TransportService)}
   */
  @Test
  @DisplayName("Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, TransportService)")
  void testNewLwM2mDefaultBootstrapSessionManager2() {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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

    // Act and Assert
    assertFalse((new LwM2mDefaultBootstrapSessionManager(bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3))))
        .hasConfigFor(null));
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#begin(BootstrapRequest, LwM2mPeer, URI)}.
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#begin(BootstrapRequest, LwM2mPeer, URI)}
   */
  @Test
  @DisplayName("Test begin(BootstrapRequest, LwM2mPeer, URI); then throw LwM2MAuthException")
  void testBegin_thenThrowLwM2MAuthException() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mIdentity lwM2mIdentity = mock(LwM2mIdentity.class);
    when(lwM2mIdentity.isSecure()).thenThrow(new LwM2MAuthException());
    LwM2mPeer sender = mock(LwM2mPeer.class);
    when(sender.getIdentity()).thenReturn(lwM2mIdentity);

    // Act and Assert
    assertThrows(LwM2MAuthException.class, () -> lwM2mDefaultBootstrapSessionManager.begin(request, sender,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri()));
    verify(lwM2mIdentity).isSecure();
    verify(sender).getIdentity();
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}
   */
  @Test
  @DisplayName("Test hasConfigFor(BootstrapSession)")
  void testHasConfigFor() throws InvalidRequestException {
    // Arrange
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    when(configStore.get(Mockito.<BootstrapSession>any())).thenReturn(new BootstrapConfig());
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession session = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    boolean actualHasConfigForResult = lwM2mDefaultBootstrapSessionManager.hasConfigFor(session);

    // Assert
    verify(configStore).get(isA(BootstrapSession.class));
    assertTrue(session.getRequests().isEmpty());
    assertTrue(session.getResponses().isEmpty());
    assertTrue(actualHasConfigForResult);
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}
   */
  @Test
  @DisplayName("Test hasConfigFor(BootstrapSession)")
  void testHasConfigFor2() throws InvalidRequestException {
    // Arrange
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    when(configStore.get(Mockito.<BootstrapSession>any())).thenReturn(null);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession session = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    boolean actualHasConfigForResult = lwM2mDefaultBootstrapSessionManager.hasConfigFor(session);

    // Assert
    verify(configStore).get(isA(BootstrapSession.class));
    assertNull(session.getRequests());
    assertNull(session.getResponses());
    assertNull(session.getModel());
    assertFalse(actualHasConfigForResult);
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}
   */
  @Test
  @DisplayName("Test hasConfigFor(BootstrapSession)")
  void testHasConfigFor3() throws InvalidRequestException {
    // Arrange
    BootstrapConfigStore store = mock(BootstrapConfigStore.class);
    when(store.get(Mockito.<BootstrapSession>any())).thenReturn(new BootstrapConfig());
    LwM2MBootstrapConfigStoreTaskProvider tasksProvider = new LwM2MBootstrapConfigStoreTaskProvider(store);
    LwM2mBootstrapModelProvider modelProvider = mock(LwM2mBootstrapModelProvider.class);
    StaticModel staticModel = new StaticModel(new ArrayList<>());
    when(modelProvider.getObjectModel(Mockito.<BootstrapSession>any(), Mockito.<Map<Integer, String>>any()))
        .thenReturn(staticModel);
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore, new SecurityChecker(), tasksProvider, modelProvider);
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession session = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    // Act
    lwM2mDefaultBootstrapSessionManager.hasConfigFor(session);

    // Assert
    verify(store).get(isA(BootstrapSession.class));
    verify(modelProvider).getObjectModel(isA(BootstrapSession.class), isA(Map.class));
    LwM2mModel model = session.getModel();
    assertTrue(model instanceof StaticModel);
    assertTrue(model.getObjectModels().isEmpty());
    assertSame(staticModel, model);
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}.
   * <ul>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#hasConfigFor(BootstrapSession)}
   */
  @Test
  @DisplayName("Test hasConfigFor(BootstrapSession); then throw LwM2MAuthException")
  void testHasConfigFor_thenThrowLwM2MAuthException() throws InvalidRequestException {
    // Arrange
    BootstrapConfigStore store = mock(BootstrapConfigStore.class);
    when(store.get(Mockito.<BootstrapSession>any())).thenReturn(new BootstrapConfig());
    LwM2MBootstrapConfigStoreTaskProvider tasksProvider = new LwM2MBootstrapConfigStoreTaskProvider(store);
    LwM2mBootstrapModelProvider modelProvider = mock(LwM2mBootstrapModelProvider.class);
    when(modelProvider.getObjectModel(Mockito.<BootstrapSession>any(), Mockito.<Map<Integer, String>>any()))
        .thenThrow(new LwM2MAuthException());
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore, new SecurityChecker(), tasksProvider, modelProvider);
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> lwM2mDefaultBootstrapSessionManager.hasConfigFor(new DefaultBootstrapSession(request, client, true,
            new HashMap<>(), Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri())));
    verify(store).get(isA(BootstrapSession.class));
    verify(modelProvider).getObjectModel(isA(BootstrapSession.class), isA(Map.class));
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#initTasks(BootstrapSession, Tasks)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#initTasks(BootstrapSession, BootstrapTaskProvider.Tasks)}
   */
  @Test
  @DisplayName("Test initTasks(BootstrapSession, Tasks)")
  void testInitTasks() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession bssession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    BootstrapTaskProvider.Tasks tasks = new BootstrapTaskProvider.Tasks();
    tasks.last = true;
    tasks.requestsToSend = new ArrayList<>();
    tasks.supportedObjects = new HashMap<>();

    // Act
    lwM2mDefaultBootstrapSessionManager.initTasks(bssession, tasks);

    // Assert
    assertFalse(bssession.hasMoreTasks());
    assertTrue(bssession.getRequests().isEmpty());
    assertTrue(bssession.getResponses().isEmpty());
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#initTasks(BootstrapSession, Tasks)}.
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#initTasks(BootstrapSession, BootstrapTaskProvider.Tasks)}
   */
  @Test
  @DisplayName("Test initTasks(BootstrapSession, Tasks)")
  void testInitTasks2() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession bssession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    BootstrapTaskProvider.Tasks tasks = new BootstrapTaskProvider.Tasks();
    tasks.last = true;
    tasks.requestsToSend = new ArrayList<>();
    tasks.supportedObjects = new HashMap<>();
    tasks.supportedObjects = null;
    tasks.last = false;

    // Act
    lwM2mDefaultBootstrapSessionManager.initTasks(bssession, tasks);

    // Assert
    assertTrue(bssession.getRequests().isEmpty());
    assertTrue(bssession.getResponses().isEmpty());
    assertTrue(bssession.hasMoreTasks());
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#getFirstRequest(BootstrapSession)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link BootstrapFinishRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#getFirstRequest(BootstrapSession)}
   */
  @Test
  @DisplayName("Test getFirstRequest(BootstrapSession); given ArrayList(); then return BootstrapFinishRequest")
  void testGetFirstRequest_givenArrayList_thenReturnBootstrapFinishRequest() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);

    DefaultBootstrapSession bsSession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
    bsSession.setRequests(new ArrayList<>());

    // Act
    BootstrapDownlinkRequest<? extends LwM2mResponse> actualFirstRequest = lwM2mDefaultBootstrapSessionManager
        .getFirstRequest(bsSession);

    // Assert
    assertTrue(actualFirstRequest instanceof BootstrapFinishRequest);
    assertNull(actualFirstRequest.getCoapRequest());
    assertNull(actualFirstRequest.getPath());
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#nextRequest(BootstrapSession)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link BootstrapFinishRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#nextRequest(BootstrapSession)}
   */
  @Test
  @DisplayName("Test nextRequest(BootstrapSession); given ArrayList(); then return BootstrapFinishRequest")
  void testNextRequest_givenArrayList_thenReturnBootstrapFinishRequest() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);

    DefaultBootstrapSession bsSession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());
    bsSession.setRequests(new ArrayList<>());

    // Act
    BootstrapDownlinkRequest<? extends LwM2mResponse> actualNextRequestResult = lwM2mDefaultBootstrapSessionManager
        .nextRequest(bsSession);

    // Assert
    assertTrue(actualNextRequestResult instanceof BootstrapFinishRequest);
    assertNull(actualNextRequestResult.getCoapRequest());
    assertNull(actualNextRequestResult.getPath());
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#onResponseSuccess(BootstrapSession, BootstrapDownlinkRequest, LwM2mResponse)}.
   * <ul>
   *   <li>Then return nextRequest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#onResponseSuccess(BootstrapSession, BootstrapDownlinkRequest, LwM2mResponse)}
   */
  @Test
  @DisplayName("Test onResponseSuccess(BootstrapSession, BootstrapDownlinkRequest, LwM2mResponse); then return nextRequest is 'null'")
  void testOnResponseSuccess_thenReturnNextRequestIsNull() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession bsSession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    BootstrapFinishRequest request2 = new BootstrapFinishRequest();

    // Act
    BootstrapSessionManager.BootstrapPolicy actualOnResponseSuccessResult = lwM2mDefaultBootstrapSessionManager
        .onResponseSuccess(bsSession, request2, BootstrapDeleteResponse.success());

    // Assert
    assertNull(actualOnResponseSuccessResult.nextRequest());
    assertFalse(actualOnResponseSuccessResult.shouldfail());
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#onResponseError(BootstrapSession, BootstrapDownlinkRequest, LwM2mResponse)}.
   * <ul>
   *   <li>Then return nextRequest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#onResponseError(BootstrapSession, BootstrapDownlinkRequest, LwM2mResponse)}
   */
  @Test
  @DisplayName("Test onResponseError(BootstrapSession, BootstrapDownlinkRequest, LwM2mResponse); then return nextRequest is 'null'")
  void testOnResponseError_thenReturnNextRequestIsNull() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession bsSession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    BootstrapFinishRequest request2 = new BootstrapFinishRequest();

    // Act
    BootstrapSessionManager.BootstrapPolicy actualOnResponseErrorResult = lwM2mDefaultBootstrapSessionManager
        .onResponseError(bsSession, request2, BootstrapDeleteResponse.success());

    // Assert
    assertNull(actualOnResponseErrorResult.nextRequest());
    assertTrue(actualOnResponseErrorResult.shouldfail());
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#onRequestFailure(BootstrapSession, BootstrapDownlinkRequest, Throwable)}.
   * <ul>
   *   <li>Then return nextRequest is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#onRequestFailure(BootstrapSession, BootstrapDownlinkRequest, Throwable)}
   */
  @Test
  @DisplayName("Test onRequestFailure(BootstrapSession, BootstrapDownlinkRequest, Throwable); then return nextRequest is 'null'")
  void testOnRequestFailure_thenReturnNextRequestIsNull() throws InvalidRequestException {
    // Arrange
    LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
        context, new LwM2MTransportServerConfig());

    LwM2mTransportContext context2 = new LwM2mTransportContext();
    LwM2MBootstrapSecurityStore bsSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
        lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    BootstrapRequest request = new BootstrapRequest("https://config.us-east-2.amazonaws.com");
    LwM2mPeer client = mock(LwM2mPeer.class);
    DefaultBootstrapSession bsSession = new DefaultBootstrapSession(request, client, true, new HashMap<>(),
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri());

    BootstrapDeleteRequest request2 = new BootstrapDeleteRequest();

    // Act
    BootstrapSessionManager.BootstrapPolicy actualOnRequestFailureResult = lwM2mDefaultBootstrapSessionManager
        .onRequestFailure(bsSession, request2, new Throwable());

    // Assert
    assertNull(actualOnRequestFailureResult.nextRequest());
    assertTrue(actualOnRequestFailureResult.shouldfail());
  }

  /**
   * Test {@link LwM2mDefaultBootstrapSessionManager#end(BootstrapSession)}.
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.</li>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#end(BootstrapSession)}
   */
  @Test
  @DisplayName("Test end(BootstrapSession); given 'https://config.us-east-2.amazonaws.com'; then throw LwM2MAuthException")
  void testEnd_givenHttpsConfigUsEast2AmazonawsCom_thenThrowLwM2MAuthException() {
    // Arrange
    LwM2MBootstrapSecurityStore bsSecurityStore = mock(LwM2MBootstrapSecurityStore.class);
    when(bsSecurityStore.getSessionByEndpoint(Mockito.<String>any())).thenThrow(new LwM2MAuthException());
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    DefaultBootstrapSession bsSession = mock(DefaultBootstrapSession.class);
    when(bsSession.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(LwM2MAuthException.class, () -> lwM2mDefaultBootstrapSessionManager.end(bsSession));
    verify(bsSession).getEndpoint();
    verify(bsSecurityStore).getSessionByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test
   * {@link LwM2mDefaultBootstrapSessionManager#failed(BootstrapSession, BootstrapFailureCause)}.
   * <ul>
   *   <li>Given {@code https://config.us-east-2.amazonaws.com}.</li>
   *   <li>Then throw {@link LwM2MAuthException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mDefaultBootstrapSessionManager#failed(BootstrapSession, BootstrapFailureCause)}
   */
  @Test
  @DisplayName("Test failed(BootstrapSession, BootstrapFailureCause); given 'https://config.us-east-2.amazonaws.com'; then throw LwM2MAuthException")
  void testFailed_givenHttpsConfigUsEast2AmazonawsCom_thenThrowLwM2MAuthException() {
    // Arrange
    LwM2MBootstrapSecurityStore bsSecurityStore = mock(LwM2MBootstrapSecurityStore.class);
    when(bsSecurityStore.getSessionByEndpoint(Mockito.<String>any())).thenThrow(new LwM2MAuthException());
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    LwM2mDefaultBootstrapSessionManager lwM2mDefaultBootstrapSessionManager = new LwM2mDefaultBootstrapSessionManager(
        bsSecurityStore, configStore,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();
    DefaultBootstrapSession bsSession = mock(DefaultBootstrapSession.class);
    when(bsSession.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertThrows(LwM2MAuthException.class,
        () -> lwM2mDefaultBootstrapSessionManager.failed(bsSession, BootstrapFailureCause.UNAUTHORIZED));
    verify(bsSession).getEndpoint();
    verify(bsSecurityStore).getSessionByEndpoint(eq("https://config.us-east-2.amazonaws.com"));
  }
}
