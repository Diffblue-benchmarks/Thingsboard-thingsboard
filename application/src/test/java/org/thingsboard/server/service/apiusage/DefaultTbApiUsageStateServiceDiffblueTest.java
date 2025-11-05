package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import freemarker.template.Configuration;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.model.sql.ApiUsageStateEntity;
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

@ContextConfiguration(classes = {DefaultTbApiUsageStateService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DefaultTbApiUsageStateServiceDiffblueTest {
  @MockBean private ApiUsageStateService apiUsageStateService;

  @MockBean private DbCallbackExecutorService dbCallbackExecutorService;

  @Autowired private DefaultTbApiUsageStateService defaultTbApiUsageStateService;

  @MockBean private MailExecutorService mailExecutorService;

  @MockBean private MailService mailService;

  @MockBean private NotificationRuleProcessor notificationRuleProcessor;

  @MockBean private PartitionService partitionService;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  @MockBean private TenantService tenantService;

  @MockBean private TimeseriesService timeseriesService;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultTbApiUsageStateService#getSchedulerExecutorName()}
   *   <li>{@link DefaultTbApiUsageStateService#getServiceName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultTbApiUsageStateService.getSchedulerExecutorName()",
    "String DefaultTbApiUsageStateService.getServiceName()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService2,
            tsService2,
            new ApiUsageDataValidator());
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider4,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService,
            tsService,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    // Act
    String actualSchedulerExecutorName = defaultTbApiUsageStateService.getSchedulerExecutorName();

    // Assert
    assertEquals("API Usage", defaultTbApiUsageStateService.getServiceName());
    assertEquals("api-usage-scheduled", actualSchedulerExecutorName);
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   *
   * <ul>
   *   <li>Then return {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId,
   * ApiUsageStateId)}
   */
  @Test
  @DisplayName("Test findApiUsageStateById(TenantId, ApiUsageStateId); then return ApiUsageState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState DefaultTbApiUsageStateService.findApiUsageStateById(TenantId, ApiUsageStateId)"
  })
  void testFindApiUsageStateById_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    when(apiUsageStateService.findApiUsageStateById(
            Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenReturn(apiUsageState);

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult =
        defaultTbApiUsageStateService.findApiUsageStateById(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Assert
    verify(apiUsageStateService).findApiUsageStateById(isA(TenantId.class), isNull());
    assertSame(apiUsageState, actualFindApiUsageStateByIdResult);
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   *
   * <ul>
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId,
   * ApiUsageStateId)}
   */
  @Test
  @DisplayName(
      "Test findApiUsageStateById(TenantId, ApiUsageStateId); then return CreatedTime is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState DefaultTbApiUsageStateService.findApiUsageStateById(TenantId, ApiUsageStateId)"
  })
  void testFindApiUsageStateById_thenReturnCreatedTimeIsOne() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setUuid(id);
    Optional<ApiUsageStateEntity> ofResult = Optional.of(apiUsageStateEntity);

    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService2,
            tsService2,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ApiUsageStateId id2 =
        new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ApiUsageState actualFindApiUsageStateByIdResult =
        defaultTbApiUsageStateService.findApiUsageStateById(tenantId, id2);

    // Assert
    verify(apiUsageStateRepository).findById(isA(UUID.class));
    assertEquals(1L, actualFindApiUsageStateByIdResult.getCreatedTime());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualFindApiUsageStateByIdResult.getTransportState());
    assertEquals(id2, actualFindApiUsageStateByIdResult.getId());
    assertEquals(tenantId, actualFindApiUsageStateByIdResult.getTenantId());
    assertSame(id, actualFindApiUsageStateByIdResult.getUuidId());
  }

  /**
   * Test {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId, ApiUsageStateId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbApiUsageStateService#findApiUsageStateById(TenantId,
   * ApiUsageStateId)}
   */
  @Test
  @DisplayName("Test findApiUsageStateById(TenantId, ApiUsageStateId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ApiUsageState DefaultTbApiUsageStateService.findApiUsageStateById(TenantId, ApiUsageStateId)"
  })
  void testFindApiUsageStateById_thenThrowRuntimeException() {
    // Arrange
    when(apiUsageStateService.findApiUsageStateById(
            Mockito.<TenantId>any(), Mockito.<ApiUsageStateId>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbApiUsageStateService.findApiUsageStateById(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(apiUsageStateService).findApiUsageStateById(isA(TenantId.class), isNull());
  }
}
