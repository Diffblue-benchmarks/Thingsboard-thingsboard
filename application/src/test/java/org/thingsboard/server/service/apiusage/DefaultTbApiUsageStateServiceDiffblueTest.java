package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import freemarker.template.Configuration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.PartitionService;
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
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.mail.MailExecutorService;
import org.thingsboard.server.service.telemetry.InternalTelemetryService;

@ContextConfiguration(classes = {DefaultTbApiUsageStateService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbApiUsageStateServiceDiffblueTest {
  @MockBean
  private ApiUsageStateService apiUsageStateService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired
  private DefaultTbApiUsageStateService defaultTbApiUsageStateService;

  @MockBean
  private InternalTelemetryService internalTelemetryService;

  @MockBean
  private MailExecutorService mailExecutorService;

  @MockBean
  private MailService mailService;

  @MockBean
  private NotificationRuleProcessor notificationRuleProcessor;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private TimeseriesService timeseriesService;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbApiUsageStateService#getSchedulerExecutorName()}
   *   <li>{@link DefaultTbApiUsageStateService#getServiceName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService2, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService defaultTbApiUsageStateService = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    // Act
    String actualSchedulerExecutorName = defaultTbApiUsageStateService.getSchedulerExecutorName();

    // Assert
    assertEquals("API Usage", defaultTbApiUsageStateService.getServiceName());
    assertEquals("api-usage-scheduled", actualSchedulerExecutorName);
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#getApiUsageState(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#getApiUsageState(TenantId)}
   */
  @Test
  @DisplayName("Test getApiUsageState(TenantId)")
  void testGetApiUsageState() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);
    when(timeseriesService.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new RuntimeException("foo"));
    when(apiUsageStateService.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(new ApiUsageState());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbApiUsageStateService.getApiUsageState(new TenantId(UUID.randomUUID())));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    verify(timeseriesService).findAllLatest(isA(TenantId.class), isNull());
    verify(apiUsageStateService).findApiUsageStateByEntityId(isA(EntityId.class));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link DefaultTbApiUsageStateService#onTenantProfileUpdate(TenantProfileId)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantProfileId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onTenantProfileUpdate(TenantProfileId)}
   */
  @Test
  @DisplayName("Test onTenantProfileUpdate(TenantProfileId); given TbTenantProfileCache get(TenantProfileId) return TenantProfile()")
  void testOnTenantProfileUpdate_givenTbTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantProfileId>any())).thenReturn(new TenantProfile());

    // Act
    defaultTbApiUsageStateService.onTenantProfileUpdate(null);

    // Assert that nothing has changed
    verify(tbTenantProfileCache).get((TenantProfileId) isNull());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageStateService#onTenantProfileUpdate(TenantProfileId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onTenantProfileUpdate(TenantProfileId)}
   */
  @Test
  @DisplayName("Test onTenantProfileUpdate(TenantProfileId); then throw RuntimeException")
  void testOnTenantProfileUpdate_thenThrowRuntimeException() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantProfileId>any()))
        .thenThrow(new RuntimeException("[{}] On Tenant Profile Update"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbApiUsageStateService.onTenantProfileUpdate(null));
    verify(tbTenantProfileCache).get((TenantProfileId) isNull());
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onTenantUpdate(TenantId)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then calls {@link TbTenantProfileCache#get(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onTenantUpdate(TenantId)}
   */
  @Test
  @DisplayName("Test onTenantUpdate(TenantId); given TbTenantProfileCache get(TenantId) return TenantProfile(); then calls get(TenantId)")
  void testOnTenantUpdate_givenTbTenantProfileCacheGetReturnTenantProfile_thenCallsGet() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    defaultTbApiUsageStateService.onTenantUpdate(new TenantId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onTenantUpdate(TenantId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onTenantUpdate(TenantId)}
   */
  @Test
  @DisplayName("Test onTenantUpdate(TenantId); then throw RuntimeException")
  void testOnTenantUpdate_thenThrowRuntimeException() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenThrow(new RuntimeException("[{}] On Tenant Update."));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbApiUsageStateService.onTenantUpdate(new TenantId(UUID.randomUUID())));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onTenantDelete(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onTenantDelete(TenantId)}
   */
  @Test
  @DisplayName("Test onTenantDelete(TenantId)")
  void testOnTenantDelete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService2, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(null)));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService defaultTbApiUsageStateService = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    // Act
    defaultTbApiUsageStateService.onTenantDelete(new TenantId(UUID.randomUUID()));

    // Assert
    assertEquals(1, defaultTbApiUsageStateService.deletedEntities.size());
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onCustomerDelete(CustomerId)}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onCustomerDelete(CustomerId)}
   */
  @Test
  @DisplayName("Test onCustomerDelete(CustomerId)")
  void testOnCustomerDelete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService2, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(null)));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService defaultTbApiUsageStateService = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    // Act
    defaultTbApiUsageStateService.onCustomerDelete(new CustomerId(UUID.randomUUID()));

    // Assert
    assertEquals(1, defaultTbApiUsageStateService.deletedEntities.size());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}
   */
  @Test
  @DisplayName("Test findApiUsageStateById(TenantId, ApiUsageStateId); then return ApiUsageState()")
  void testFindApiUsageStateById_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateService.findApiUsageStateById(Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult = defaultTbApiUsageStateService
        .findApiUsageStateById(new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(apiUsageStateService).findApiUsageStateById(isA(TenantId.class), isNull());
    assertSame(apiUsageState, actualFindApiUsageStateByIdResult);
  }

  /**
   * Test
   * {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}
   */
  @Test
  @DisplayName("Test findApiUsageStateById(TenantId, ApiUsageStateId); then throw RuntimeException")
  void testFindApiUsageStateById_thenThrowRuntimeException() {
    // Arrange
    when(apiUsageStateService.findApiUsageStateById(Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbApiUsageStateService.findApiUsageStateById(new TenantId(UUID.randomUUID()), null));
    verify(apiUsageStateService).findApiUsageStateById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultTbApiUsageStateService#getOrFetchState(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#getOrFetchState(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test getOrFetchState(TenantId, EntityId); then throw RuntimeException")
  void testGetOrFetchState_thenThrowRuntimeException() {
    // Arrange
    when(timeseriesService.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new RuntimeException("foo"));
    when(apiUsageStateService.findApiUsageStateByEntityId(Mockito.<EntityId>any())).thenReturn(new ApiUsageState());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbApiUsageStateService.getOrFetchState(new TenantId(UUID.randomUUID()), null));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    verify(timeseriesService).findAllLatest(isA(TenantId.class), isNull());
    verify(apiUsageStateService).findApiUsageStateByEntityId(isA(EntityId.class));
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set)")
  void testOnAddedPartitions() {
    // Arrange
    PageData<Tenant> pageData = mock(PageData.class);
    when(pageData.getData()).thenThrow(new RuntimeException("foo"));
    when(tenantService.findTenants(Mockito.<PageLink>any())).thenReturn(pageData);

    HashSet<TopicPartitionInfo> addedPartitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultTbApiUsageStateService
        .onAddedPartitions(addedPartitions);

    // Assert
    verify(pageData).getData();
    verify(tenantService).findTenants(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}.
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set)")
  void testOnAddedPartitions2() {
    // Arrange
    PageData<Tenant> pageData = mock(PageData.class);
    when(pageData.getData()).thenThrow(new RuntimeException("foo"));
    when(tenantService.findTenants(Mockito.<PageLink>any())).thenReturn(pageData);

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
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultTbApiUsageStateService
        .onAddedPartitions(addedPartitions);

    // Assert
    verify(pageData).getData();
    verify(tenantService).findTenants(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#findTenants(PageLink)}
   * return emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set); given TenantService findTenants(PageLink) return emptyPageData")
  void testOnAddedPartitions_givenTenantServiceFindTenantsReturnEmptyPageData() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantService.findTenants(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultTbApiUsageStateService
        .onAddedPartitions(new HashSet<>());

    // Assert
    verify(tenantService).findTenants(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link PageData#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbApiUsageStateService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set); when HashSet(); then calls getData()")
  void testOnAddedPartitions_whenHashSet_thenCallsGetData() {
    // Arrange
    PageData<Tenant> pageData = mock(PageData.class);
    when(pageData.getData()).thenThrow(new RuntimeException("foo"));
    when(tenantService.findTenants(Mockito.<PageLink>any())).thenReturn(pageData);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultTbApiUsageStateService
        .onAddedPartitions(new HashSet<>());

    // Assert
    verify(pageData).getData();
    verify(tenantService).findTenants(isA(PageLink.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }
}
