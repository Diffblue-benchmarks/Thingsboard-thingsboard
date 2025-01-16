package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.query.EntityData;
import org.thingsboard.server.common.data.query.EntityDataQuery;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.controller.plugin.TbWebSocketHandler;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.notification.DefaultNotificationService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.query.DefaultEntityQueryRepository;
import org.thingsboard.server.dao.sql.query.DefaultQueryLogComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.util.DbTypeInfoComponent;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.executors.NotificationExecutorService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.notification.DefaultNotificationCenter;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.security.AccessValidator;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.state.DefaultDeviceStateService;
import org.thingsboard.server.service.ws.DefaultWebSocketService;
import org.thingsboard.server.service.ws.WebSocketMsgEndpoint;
import org.thingsboard.server.service.ws.WebSocketService;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionType;
import org.thingsboard.server.service.ws.notification.DefaultNotificationCommandsHandler;
import org.thingsboard.server.service.ws.notification.NotificationCommandsHandler;

class TbEntityDataSubCtxDiffblueTest {
  /**
   * Test
   * {@link TbEntityDataSubCtx#TbEntityDataSubCtx(String, WebSocketService, EntityService, TbLocalSubscriptionService, AttributesService, SubscriptionServiceStatistics, WebSocketSessionRef, int, int)}.
   * <p>
   * Method under test:
   * {@link TbEntityDataSubCtx#TbEntityDataSubCtx(String, WebSocketService, EntityService, TbLocalSubscriptionService, AttributesService, SubscriptionServiceStatistics, WebSocketSessionRef, int, int)}
   */
  @Test
  @DisplayName("Test new TbEntityDataSubCtx(String, WebSocketService, EntityService, TbLocalSubscriptionService, AttributesService, SubscriptionServiceStatistics, WebSocketSessionRef, int, int)")
  void testNewTbEntityDataSubCtx() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultWebSocketService wsService = new DefaultWebSocketService(mock(TbLocalSubscriptionService.class),
        mock(TbEntityDataSubscriptionService.class), mock(NotificationCommandsHandler.class),
        mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class), mock(AttributesService.class),
        mock(TimeseriesService.class), mock(TbServiceInfoProvider.class), mock(TbTenantProfileCache.class));

    BaseEntityService entityService = new BaseEntityService();
    DefaultTbLocalSubscriptionService localSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), mock(RateLimitService.class));

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    SubscriptionServiceStatistics stats = new SubscriptionServiceStatistics();
    stats.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    stats.setAlarmQueryTimeSpent(new AtomicLong(1L));
    stats.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    stats.setDynamicQueryTimeSpent(new AtomicLong(1L));
    stats.setRegularQueryInvocationCnt(new AtomicInteger(1));
    stats.setRegularQueryTimeSpent(new AtomicLong(1L));

    // Act
    TbEntityDataSubCtx actualTbEntityDataSubCtx = new TbEntityDataSubCtx("42", wsService, entityService,
        localSubscriptionService, attributesService, stats, null, 1, 3);

    // Assert
    Lock wsLock = actualTbEntityDataSubCtx.getWsLock();
    assertTrue(wsLock instanceof ReentrantLock);
    AttributesService attributesService2 = actualTbEntityDataSubCtx.getAttributesService();
    assertTrue(attributesService2 instanceof BaseAttributesService);
    EntityService entityService2 = actualTbEntityDataSubCtx.getEntityService();
    assertTrue(entityService2 instanceof BaseEntityService);
    TbLocalSubscriptionService localSubscriptionService2 = actualTbEntityDataSubCtx.getLocalSubscriptionService();
    assertTrue(localSubscriptionService2 instanceof DefaultTbLocalSubscriptionService);
    WebSocketService wsService2 = actualTbEntityDataSubCtx.getWsService();
    assertTrue(wsService2 instanceof DefaultWebSocketService);
    assertEquals("42", actualTbEntityDataSubCtx.getServiceId());
    assertNull(actualTbEntityDataSubCtx.getRefreshTask());
    assertNull(actualTbEntityDataSubCtx.getData());
    assertNull(actualTbEntityDataSubCtx.getQuery());
    assertNull(actualTbEntityDataSubCtx.getSessionRef());
    assertEquals(0, ((ReentrantLock) wsLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) wsLock).getQueueLength());
    assertEquals(1, actualTbEntityDataSubCtx.getCmdId());
    assertEquals(3, actualTbEntityDataSubCtx.getMaxEntitiesPerDataSubscription());
    assertEquals(Aggregation.NONE, actualTbEntityDataSubCtx.getCurrentAggregation());
    assertFalse(((ReentrantLock) wsLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) wsLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) wsLock).isLocked());
    assertFalse(actualTbEntityDataSubCtx.isDynamic());
    assertFalse(actualTbEntityDataSubCtx.isStopped());
    assertFalse(actualTbEntityDataSubCtx.isInitialDataSent());
    assertTrue(actualTbEntityDataSubCtx.getDynamicValues().isEmpty());
    assertTrue(actualTbEntityDataSubCtx.subToEntityIdMap.isEmpty());
    assertTrue(actualTbEntityDataSubCtx.getSubToDynamicValueKeySet().isEmpty());
    assertTrue(((ReentrantLock) wsLock).isFair());
    assertSame(attributesService, attributesService2);
    assertSame(entityService, entityService2);
    assertSame(localSubscriptionService, localSubscriptionService2);
    assertSame(stats, actualTbEntityDataSubCtx.getStats());
    assertSame(wsService, wsService2);
  }

  /**
   * Test {@link TbEntityDataSubCtx#fetchData()}.
   * <p>
   * Method under test: {@link TbEntityDataSubCtx#fetchData()}
   */
  @Test
  @DisplayName("Test fetchData()")
  void testFetchData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityService entityService = mock(EntityService.class);
    PageData<EntityData> emptyPageDataResult = PageData.emptyPageData();
    when(entityService.findEntityDataByQuery(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<EntityDataQuery>any())).thenReturn(emptyPageDataResult);
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSecurityCtx()).thenReturn(new SecurityUser());
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", mock(WebSocketService.class), entityService,
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), sessionRef, 1, 3);

    // Act
    tbEntityDataSubCtx.fetchData();

    // Assert
    verify(entityService).findEntityDataByQuery(isNull(), isNull(), isNull());
    verify(sessionRef, atLeast(1)).getSecurityCtx();
    assertTrue(tbEntityDataSubCtx.getEntitiesData().isEmpty());
    PageData expectedData = emptyPageDataResult.EMPTY_PAGE_DATA;
    assertSame(expectedData, tbEntityDataSubCtx.getData());
  }

  /**
   * Test {@link TbEntityDataSubCtx#getCurrentAggregation()}.
   * <p>
   * Method under test: {@link TbEntityDataSubCtx#getCurrentAggregation()}
   */
  @Test
  @DisplayName("Test getCurrentAggregation()")
  void testGetCurrentAggregation() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(Aggregation.NONE,
        (new TbEntityDataSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
            mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
            mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3)).getCurrentAggregation());
  }

  /**
   * Test {@link TbEntityDataSubCtx#buildEntityDataQuery()}.
   * <p>
   * Method under test: {@link TbEntityDataSubCtx#buildEntityDataQuery()}
   */
  @Test
  @DisplayName("Test buildEntityDataQuery()")
  void testBuildEntityDataQuery() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbEntityDataSubCtx("42", mock(WebSocketService.class), mock(EntityService.class),
        mock(TbLocalSubscriptionService.class), mock(AttributesService.class),
        mock(SubscriptionServiceStatistics.class), mock(WebSocketSessionRef.class), 1, 3)).buildEntityDataQuery());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbEntityDataSubCtx#setInitialDataSent(boolean)}
   *   <li>{@link TbEntityDataSubCtx#getMaxEntitiesPerDataSubscription()}
   *   <li>{@link TbEntityDataSubCtx#isInitialDataSent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    SubscriptionServiceStatistics stats = new SubscriptionServiceStatistics();
    stats.setAlarmQueryInvocationCnt(new AtomicInteger(1));
    stats.setAlarmQueryTimeSpent(new AtomicLong(1L));
    stats.setDynamicQueryInvocationCnt(new AtomicInteger(1));
    stats.setDynamicQueryTimeSpent(new AtomicLong(1L));
    stats.setRegularQueryInvocationCnt(new AtomicInteger(1));
    stats.setRegularQueryTimeSpent(new AtomicLong(1L));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    DefaultDeviceStateService deviceStateService = new DefaultDeviceStateService(null, null,
        new BaseTimeseriesService(), null, null, null, mock(DbTypeInfoComponent.class), null,
        mock(NotificationRuleProcessor.class));

    TopicService topicService3 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService2 = new DefaultTbClusterService(topicService3, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultSubscriptionManagerService subscriptionManagerService = new DefaultSubscriptionManagerService(topicService2,
        partitionService2, serviceInfoProvider4, producerProvider, null, deviceStateService, clusterService2,
        new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService oldSubService = new DefaultTbLocalSubscriptionService(attrService, tsService,
        serviceInfoProvider, partitionService, clusterService, subscriptionManagerService, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultTbEntityDataSubscriptionService entityDataSubService = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    BaseAttributesService attrService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TopicService topicService4 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService3 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService3 = new DefaultTbClusterService(topicService4, null, null,
        gatewayNotificationsService3, new EdgeServiceImpl(), null);

    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    DefaultSubscriptionManagerService subscriptionManagerService2 = new DefaultSubscriptionManagerService(topicService5,
        null, serviceInfoProvider7, null, null, null, null, new SubscriptionSchedulerComponent());

    DefaultTbLocalSubscriptionService localSubscriptionService = new DefaultTbLocalSubscriptionService(attrService2,
        tsService2, serviceInfoProvider5, partitionService3, clusterService3, subscriptionManagerService2, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(null, null,
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService2 = new DefaultNotificationService(null);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        new AdminSettingsServiceImpl(), null, null, null, null);

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService6 = new TopicService();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(null);
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService2, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService6, producerProvider2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationCommandsHandler notificationCmdsHandler = new DefaultNotificationCommandsHandler(
        notificationService, localSubscriptionService, notificationCenter, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint = new TbWebSocketHandler();
    AccessValidator accessValidator = new AccessValidator();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultWebSocketService wsService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        notificationCmdsHandler, msgEndpoint, accessValidator, attributesService, tsService3, serviceInfoProvider8,
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));

    BaseEntityService entityService = new BaseEntityService();
    BaseAttributesService attrService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService4 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider10, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TopicService topicService7 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache2 = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService2 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache2 = new DefaultTbAssetProfileCache(assetProfileService2,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService4 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService2 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService4 = new DefaultTbClusterService(topicService7, deviceProfileCache2,
        assetProfileCache2, gatewayNotificationsService4, edgeService2,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TopicService topicService9 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService9, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider13, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao2, null, deviceProfileService3, eventService2,
        tenantService2, deviceValidator2, countService2, new JpaExecutorService());

    BaseAttributesService attributesService2 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService5 = new BaseTimeseriesService();
    TopicService topicService10 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService5 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService5 = new DefaultTbClusterService(topicService10, null, null,
        gatewayNotificationsService5, new EdgeServiceImpl(), null);

    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider14, tenantRoutingInfoService6,
        applicationEventPublisher6, queueRoutingInfoService6, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
    DefaultDeviceStateService deviceStateService2 = new DefaultDeviceStateService(deviceService, attributesService2,
        tsService5, clusterService5, partitionService6, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider15, new DefaultSchedulerComponent(), null),
        mock(NotificationRuleProcessor.class));

    TopicService topicService11 = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache3 = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService3 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache3 = new DefaultTbAssetProfileCache(assetProfileService3,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService6 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService3 = new EdgeServiceImpl();
    DefaultTbClusterService clusterService6 = new DefaultTbClusterService(topicService11, deviceProfileCache3,
        assetProfileCache3, gatewayNotificationsService6, edgeService3,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSubscriptionManagerService subscriptionManagerService3 = new DefaultSubscriptionManagerService(topicService8,
        partitionService5, serviceInfoProvider12, producerProvider3, null, deviceStateService2, clusterService6,
        new SubscriptionSchedulerComponent());

    DefaultTbEntityDataSubscriptionService entityDataSubService2 = new DefaultTbEntityDataSubscriptionService();
    DefaultNotificationService notificationService3 = new DefaultNotificationService(null);
    NotificationExecutorService notificationExecutor2 = new NotificationExecutorService();
    DefaultNotificationCenter notificationCenter2 = new DefaultNotificationCenter(null, null, null, null, null,
        notificationExecutor2, new TopicService(), null, null);

    DefaultNotificationCommandsHandler notificationCmdsHandler2 = new DefaultNotificationCommandsHandler(
        notificationService3, null, notificationCenter2, new DefaultTbServiceInfoProvider());

    TbWebSocketHandler msgEndpoint2 = new TbWebSocketHandler();
    AccessValidator accessValidator2 = new AccessValidator();
    BaseAttributesService attributesService3 = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService6 = new BaseTimeseriesService();
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TenantProfileServiceImpl tenantProfileService2 = new TenantProfileServiceImpl();
    DefaultWebSocketService webSocketService = new DefaultWebSocketService(null, entityDataSubService2,
        notificationCmdsHandler2, msgEndpoint2, accessValidator2, attributesService3, tsService6, serviceInfoProvider16,
        new DefaultTbTenantProfileCache(tenantProfileService2, new TenantServiceImpl()));

    DefaultTbLocalSubscriptionService localSubscriptionService2 = new DefaultTbLocalSubscriptionService(attrService3,
        tsService4, serviceInfoProvider9, partitionService4, clusterService4, subscriptionManagerService3,
        webSocketService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    BaseAttributesService attributesService4 = new BaseAttributesService(new JpaAttributeDao());
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TbEntityDataSubCtx tbEntityDataSubCtx = new TbEntityDataSubCtx("42", wsService, entityService,
        localSubscriptionService2, attributesService4, stats, sessionRef, 1, 3);

    // Act
    tbEntityDataSubCtx.setInitialDataSent(true);
    int actualMaxEntitiesPerDataSubscription = tbEntityDataSubCtx.getMaxEntitiesPerDataSubscription();

    // Assert that nothing has changed
    assertEquals(3, actualMaxEntitiesPerDataSubscription);
    assertTrue(tbEntityDataSubCtx.isInitialDataSent());
  }
}
