package org.thingsboard.server.service.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceIdInfo;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.TbCallback;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.query.DefaultEntityQueryRepository;
import org.thingsboard.server.dao.sql.query.DefaultQueryLogComponent;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.util.DbTypeInfoComponent;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
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
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.queue.TbPackCallback;
import org.thingsboard.server.service.queue.TbPackProcessingContext;

class DefaultDeviceStateServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultDeviceStateService#onQueueMsg(DeviceStateServiceMsgProto, TbCallback)}.
   * <ul>
   *   <li>Given {@link DeviceService}
   * {@link DeviceService#findDeviceById(TenantId, DeviceId)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDeviceStateService#onQueueMsg(TransportProtos.DeviceStateServiceMsgProto, TbCallback)}
   */
  @Test
  @DisplayName("Test onQueueMsg(DeviceStateServiceMsgProto, TbCallback); given DeviceService findDeviceById(TenantId, DeviceId) return 'null'")
  void testOnQueueMsg_givenDeviceServiceFindDeviceByIdReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));
    TransportProtos.DeviceStateServiceMsgProto proto = TransportProtos.DeviceStateServiceMsgProto.getDefaultInstance();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultDeviceStateService.onQueueMsg(proto, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
  }

  /**
   * Test
   * {@link DefaultDeviceStateService#onQueueMsg(DeviceStateServiceMsgProto, TbCallback)}.
   * <ul>
   *   <li>Then calls {@link DeviceService#findDeviceById(TenantId, DeviceId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDeviceStateService#onQueueMsg(TransportProtos.DeviceStateServiceMsgProto, TbCallback)}
   */
  @Test
  @DisplayName("Test onQueueMsg(DeviceStateServiceMsgProto, TbCallback); then calls findDeviceById(TenantId, DeviceId)")
  void testOnQueueMsg_thenCallsFindDeviceById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));
    TransportProtos.DeviceStateServiceMsgProto proto = TransportProtos.DeviceStateServiceMsgProto.getDefaultInstance();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultDeviceStateService.onQueueMsg(proto, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
  }

  /**
   * Test {@link DefaultDeviceStateService#onAddedPartitions(Set)}.
   * <p>
   * Method under test: {@link DefaultDeviceStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set)")
  void testOnAddedPartitions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceService.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));

    HashSet<TopicPartitionInfo> addedPartitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultDeviceStateService
        .onAddedPartitions(addedPartitions);

    // Assert
    verify(deviceService).findDeviceIdInfos(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultDeviceStateService#onAddedPartitions(Set)}.
   * <p>
   * Method under test: {@link DefaultDeviceStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set)")
  void testOnAddedPartitions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceService.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));

    HashSet<TopicPartitionInfo> addedPartitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult2);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultDeviceStateService
        .onAddedPartitions(addedPartitions);

    // Assert
    verify(deviceService).findDeviceIdInfos(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultDeviceStateService#onAddedPartitions(Set)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set); then return Empty")
  void testOnAddedPartitions_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
    PageData<DeviceIdInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceService.findDeviceIdInfos(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultDeviceStateService
        .onAddedPartitions(new HashSet<>());

    // Assert
    verify(deviceService).findDeviceIdInfos(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultDeviceStateService#isActive(long, DeviceState)}.
   * <p>
   * Method under test:
   * {@link DefaultDeviceStateService#isActive(long, DeviceState)}
   */
  @Test
  @DisplayName("Test isActive(long, DeviceState)")
  void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService2,
        new DeviceServiceImpl(deviceDao2, null, deviceProfileService3, eventService2, tenantService2, deviceValidator2,
            countService2, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));

    // Act and Assert
    assertTrue(defaultDeviceStateService.isActive(1L, new DeviceState(true, 1L, 1L, 1L, 1L, 1L)));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceStateService#setDefaultInactivityTimeoutInSec(long)}
   *   <li>{@link DefaultDeviceStateService#setDefaultInactivityTimeoutMs(long)}
   *   <li>{@link DefaultDeviceStateService#setPersistToTelemetry(boolean)}
   *   <li>{@link DefaultDeviceStateService#getDefaultActivityStatsIntervalInSec()}
   *   <li>{@link DefaultDeviceStateService#getDefaultInactivityTimeoutInSec()}
   *   <li>{@link DefaultDeviceStateService#getDefaultInactivityTimeoutMs()}
   *   <li>{@link DefaultDeviceStateService#getDefaultStateCheckIntervalInSec()}
   *   <li>{@link DefaultDeviceStateService#getInitFetchPackSize()}
   *   <li>{@link DefaultDeviceStateService#getSchedulerExecutorName()}
   *   <li>{@link DefaultDeviceStateService#getServiceName()}
   *   <li>{@link DefaultDeviceStateService#getTelemetryTtl()}
   *   <li>{@link DefaultDeviceStateService#isPersistToTelemetry()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService2,
        new DeviceServiceImpl(deviceDao2, deviceCredentialsService2, deviceProfileService3, eventService2,
            tenantService2, deviceValidator2, countService2, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultDeviceStateService defaultDeviceStateService = new DefaultDeviceStateService(deviceService,
        attributesService, tsService, clusterService, partitionService, entityQueryRepository, dbTypeInfoComponent,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        mock(NotificationRuleProcessor.class));

    // Act
    defaultDeviceStateService.setDefaultInactivityTimeoutInSec(1L);
    defaultDeviceStateService.setDefaultInactivityTimeoutMs(1L);
    defaultDeviceStateService.setPersistToTelemetry(true);
    int actualDefaultActivityStatsIntervalInSec = defaultDeviceStateService.getDefaultActivityStatsIntervalInSec();
    long actualDefaultInactivityTimeoutInSec = defaultDeviceStateService.getDefaultInactivityTimeoutInSec();
    long actualDefaultInactivityTimeoutMs = defaultDeviceStateService.getDefaultInactivityTimeoutMs();
    int actualDefaultStateCheckIntervalInSec = defaultDeviceStateService.getDefaultStateCheckIntervalInSec();
    int actualInitFetchPackSize = defaultDeviceStateService.getInitFetchPackSize();
    String actualSchedulerExecutorName = defaultDeviceStateService.getSchedulerExecutorName();
    String actualServiceName = defaultDeviceStateService.getServiceName();
    int actualTelemetryTtl = defaultDeviceStateService.getTelemetryTtl();

    // Assert that nothing has changed
    assertEquals("Device State", actualServiceName);
    assertEquals("device-state-scheduled", actualSchedulerExecutorName);
    assertEquals(0, actualDefaultActivityStatsIntervalInSec);
    assertEquals(0, actualDefaultStateCheckIntervalInSec);
    assertEquals(0, actualInitFetchPackSize);
    assertEquals(0, actualTelemetryTtl);
    assertEquals(1L, actualDefaultInactivityTimeoutInSec);
    assertEquals(1L, actualDefaultInactivityTimeoutMs);
    assertTrue(defaultDeviceStateService.isPersistToTelemetry());
  }
}
