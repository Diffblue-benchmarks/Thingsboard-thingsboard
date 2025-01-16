package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.server.resources.Resource;
import org.eclipse.californium.core.server.resources.ResourceAttributes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.coapserver.CoapServerContext;
import org.thingsboard.server.coapserver.CoapServerService;
import org.thingsboard.server.coapserver.DefaultCoapServerService;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.session.FeatureType;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.common.transport.service.SessionMetaData;
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
import org.thingsboard.server.transport.coap.client.DefaultCoapClientContext;

class CoapTransportResourceDiffblueTest {
  /**
   * Test
   * {@link CoapTransportResource#CoapTransportResource(CoapTransportContext, CoapServerService, String)}.
   * <ul>
   *   <li>Then {@link AbstractCoapTransportResource#transportService} return
   * {@link DefaultTransportService}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapTransportResource#CoapTransportResource(CoapTransportContext, CoapServerService, String)}
   */
  @Test
  @DisplayName("Test new CoapTransportResource(CoapTransportContext, CoapServerService, String); then transportService return DefaultTransportService")
  void testNewCoapTransportResource_thenTransportServiceReturnDefaultTransportService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    Mockito
        .<ScheduledFuture<?>>when(defaultSchedulerComponent.scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(),
            anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    CoapTransportContext ctx = mock(CoapTransportContext.class);
    when(ctx.getPiggybackTimeout()).thenReturn(1L);
    when(ctx.getTimeout()).thenReturn(10L);
    when(ctx.getSessionReportTimeout()).thenReturn(1L);
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
    DefaultTransportService defaultTransportService = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    when(ctx.getTransportService()).thenReturn(defaultTransportService);
    when(ctx.getScheduler()).thenReturn(defaultSchedulerComponent);
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
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

    TopicService topicService3 = new TopicService();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService3, coreSettings4, ruleEngineSettings2, vcSettings2, serviceInfoProvider8, transportApiSettings4,
        transportNotificationSettings4, edgeSettings2, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider9, tenantRoutingInfoService4, applicationEventPublisher4,
            queueRoutingInfoService4, new TopicService()));
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService4, serviceInfoProvider10, statsFactory2,
        deviceProfileCache2, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    when(ctx.getClientContext()).thenReturn(new DefaultCoapClientContext(config, transportContext, transportService,
        profileCache, new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
            applicationEventPublisher5, queueRoutingInfoService5, new TopicService())));

    // Act
    CoapTransportResource actualCoapTransportResource = new CoapTransportResource(ctx, new DefaultCoapServerService(),
        "Name");

    // Assert
    verify(ctx).getScheduler();
    verify(ctx).getTransportService();
    verify(defaultSchedulerComponent).scheduleAtFixedRate(isA(Runnable.class), eq(0L), eq(1L),
        eq(TimeUnit.MILLISECONDS));
    verify(ctx).getClientContext();
    verify(ctx).getPiggybackTimeout();
    verify(ctx).getSessionReportTimeout();
    verify(ctx).getTimeout();
    TransportService transportService2 = actualCoapTransportResource.transportService;
    assertTrue(transportService2 instanceof DefaultTransportService);
    assertEquals("", actualCoapTransportResource.getPath());
    assertEquals("Name", actualCoapTransportResource.getName());
    assertEquals("Name", actualCoapTransportResource.getURI());
    ResourceAttributes attributes = actualCoapTransportResource.getAttributes();
    assertNull(attributes.getMaximumSizeEstimate());
    assertNull(attributes.getTitle());
    assertNull(actualCoapTransportResource.getExecutor());
    assertNull(transportService2.getCallbackExecutor());
    assertNull(actualCoapTransportResource.getObserveType());
    assertNull(actualCoapTransportResource.getParent());
    assertEquals(0, actualCoapTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualCoapTransportResource.getObserverCount());
    Set<String> attributeKeySet = attributes.getAttributeKeySet();
    assertEquals(1, attributeKeySet.size());
    assertEquals(1, attributes.getCount());
    assertFalse(attributes.hasOscoreOnly());
    assertTrue(actualCoapTransportResource.getChildren().isEmpty());
    List<String> contentTypes = attributes.getContentTypes();
    assertTrue(contentTypes.isEmpty());
    ConcurrentMap<UUID, SessionMetaData> uuidSessionMetaDataMap = ((DefaultTransportService) transportService2).sessions;
    assertTrue(uuidSessionMetaDataMap.isEmpty());
    assertTrue(attributeKeySet.contains("obs"));
    assertTrue(actualCoapTransportResource.isCachable());
    assertTrue(actualCoapTransportResource.isObservable());
    assertTrue(actualCoapTransportResource.isVisible());
    assertTrue(attributes.hasObservable());
    assertSame(contentTypes, attributes.getInterfaceDescriptions());
    assertSame(contentTypes, attributes.getResourceTypes());
    assertSame(defaultTransportService.sessions, uuidSessionMetaDataMap);
  }

  /**
   * Test {@link CoapTransportResource#getFeatureType(Request)}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapTransportResource#getFeatureType(Request)}
   */
  @Test
  @DisplayName("Test getFeatureType(Request); then return not Present")
  void testGetFeatureType_thenReturnNotPresent() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    Mockito
        .<ScheduledFuture<?>>when(defaultSchedulerComponent.scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(),
            anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    CoapTransportContext ctx = mock(CoapTransportContext.class);
    when(ctx.getPiggybackTimeout()).thenReturn(1L);
    when(ctx.getTimeout()).thenReturn(10L);
    when(ctx.getSessionReportTimeout()).thenReturn(1L);
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
    when(ctx.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(ctx.getScheduler()).thenReturn(defaultSchedulerComponent);
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
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

    TopicService topicService3 = new TopicService();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService3, coreSettings4, ruleEngineSettings2, vcSettings2, serviceInfoProvider8, transportApiSettings4,
        transportNotificationSettings4, edgeSettings2, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider9, tenantRoutingInfoService4, applicationEventPublisher4,
            queueRoutingInfoService4, new TopicService()));
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService4, serviceInfoProvider10, statsFactory2,
        deviceProfileCache2, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    when(ctx.getClientContext()).thenReturn(new DefaultCoapClientContext(config, transportContext, transportService,
        profileCache, new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
            applicationEventPublisher5, queueRoutingInfoService5, new TopicService())));
    CoapTransportResource coapTransportResource = new CoapTransportResource(ctx, new DefaultCoapServerService(),
        "Name");

    // Act
    Optional<FeatureType> actualFeatureType = coapTransportResource.getFeatureType(Request.newDelete());

    // Assert
    verify(ctx).getScheduler();
    verify(ctx).getTransportService();
    verify(defaultSchedulerComponent).scheduleAtFixedRate(isA(Runnable.class), eq(0L), eq(1L),
        eq(TimeUnit.MILLISECONDS));
    verify(ctx).getClientContext();
    verify(ctx).getPiggybackTimeout();
    verify(ctx).getSessionReportTimeout();
    verify(ctx).getTimeout();
    assertFalse(actualFeatureType.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   * <p>
   * Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request)")
  void testGetRequestId() {
    // Arrange
    Request request = Request.newDelete();
    request.addMessageObserver(new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class)));

    // Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(request);

    // Assert
    assertFalse(actualRequestId.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   * <ul>
   *   <li>Given {@code Failed to decode feature type: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request); given 'Failed to decode feature type: {}'")
  void testGetRequestId_givenFailedToDecodeFeatureType() {
    // Arrange
    Request request = Request.newDelete();
    request.setProxyUri("Failed to decode feature type: {}");
    request.addMessageObserver(new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class)));

    // Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(request);

    // Assert
    assertFalse(actualRequestId.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   * <ul>
   *   <li>When newDelete.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request); when newDelete; then return not Present")
  void testGetRequestId_whenNewDelete_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(Request.newDelete());

    // Assert
    assertFalse(actualRequestId.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getChild(String)}.
   * <p>
   * Method under test: {@link CoapTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  void testGetChild() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    Mockito
        .<ScheduledFuture<?>>when(defaultSchedulerComponent.scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(),
            anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    CoapTransportContext ctx = mock(CoapTransportContext.class);
    when(ctx.getPiggybackTimeout()).thenReturn(1L);
    when(ctx.getTimeout()).thenReturn(10L);
    when(ctx.getSessionReportTimeout()).thenReturn(1L);
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
    when(ctx.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(ctx.getScheduler()).thenReturn(defaultSchedulerComponent);
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
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

    TopicService topicService3 = new TopicService();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService3, coreSettings4, ruleEngineSettings2, vcSettings2, serviceInfoProvider8, transportApiSettings4,
        transportNotificationSettings4, edgeSettings2, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider9, tenantRoutingInfoService4, applicationEventPublisher4,
            queueRoutingInfoService4, new TopicService()));
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService4, serviceInfoProvider10, statsFactory2,
        deviceProfileCache2, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    when(ctx.getClientContext()).thenReturn(new DefaultCoapClientContext(config, transportContext, transportService,
        profileCache, new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
            applicationEventPublisher5, queueRoutingInfoService5, new TopicService())));
    CoapTransportResource coapTransportResource = new CoapTransportResource(ctx, new DefaultCoapServerService(),
        "Name");

    // Act
    Resource actualChild = coapTransportResource.getChild("Name");

    // Assert
    verify(ctx).getScheduler();
    verify(ctx).getTransportService();
    verify(defaultSchedulerComponent).scheduleAtFixedRate(isA(Runnable.class), eq(0L), eq(1L),
        eq(TimeUnit.MILLISECONDS));
    verify(ctx).getClientContext();
    verify(ctx).getPiggybackTimeout();
    verify(ctx).getSessionReportTimeout();
    verify(ctx).getTimeout();
    assertSame(coapTransportResource, actualChild);
  }
}
