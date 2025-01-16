package org.thingsboard.server.service.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.template.Configuration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.query.AlarmData;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.alarm.AlarmDao;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.dao.alarm.BaseAlarmService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateServiceImpl;
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
import org.thingsboard.server.service.apiusage.DefaultTbApiUsageStateService;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmCommentService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.mail.MailExecutorService;

class DefaultAlarmSubscriptionServiceDiffblueTest {
  /**
   * Test {@link DefaultAlarmSubscriptionService#getExecutorPrefix()}.
   * <p>
   * Method under test:
   * {@link DefaultAlarmSubscriptionService#getExecutorPrefix()}
   */
  @Test
  @DisplayName("Test getExecutorPrefix()")
  void testGetExecutorPrefix() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService alarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    DefaultTbAlarmCommentService alarmCommentService = new DefaultTbAlarmCommentService(new BaseAlarmCommentService());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultTbApiUsageReportClient apiUsageClient = new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler,
        new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings,
            vcSettings, serviceInfoProvider3, transportApiSettings, transportNotificationSettings, edgeSettings,
            new DefaultInMemoryStorage())));

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService3, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider5, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService3, serviceInfoProvider6, scheduler2,
            new TbCoreQueueProducerProvider(null)));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    // Act and Assert
    assertEquals("alarm",
        (new DefaultAlarmSubscriptionService(alarmService, alarmCommentService, apiUsageClient,
            new DefaultTbApiUsageStateService(partitionService2, tenantService2, tsService, apiUsageStateService,
                tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()),
            mock(NotificationRuleProcessor.class))).getExecutorPrefix());
  }

  /**
   * Test
   * {@link DefaultAlarmSubscriptionService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAlarmSubscriptionService#findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection)}
   */
  @Test
  @DisplayName("Test findAlarmDataByQueryForEntities(TenantId, AlarmDataQuery, Collection); then return EMPTY_PAGE_DATA")
  void testFindAlarmDataByQueryForEntities_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAlarmService alarmService = mock(BaseAlarmService.class);
    PageData<AlarmData> emptyPageDataResult = PageData.emptyPageData();
    when(alarmService.findAlarmDataByQueryForEntities(Mockito.<TenantId>any(), Mockito.<AlarmDataQuery>any(),
        Mockito.<Collection<EntityId>>any())).thenReturn(emptyPageDataResult);
    DefaultTbAlarmCommentService alarmCommentService = new DefaultTbAlarmCommentService(new BaseAlarmCommentService());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultTbApiUsageReportClient apiUsageClient = new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler,
        new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings,
            vcSettings, serviceInfoProvider3, transportApiSettings, transportNotificationSettings, edgeSettings,
            new DefaultInMemoryStorage())));

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

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
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultAlarmSubscriptionService defaultAlarmSubscriptionService = new DefaultAlarmSubscriptionService(alarmService,
        alarmCommentService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()),
        mock(NotificationRuleProcessor.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmDataQuery query = new AlarmDataQuery();

    // Act
    PageData<AlarmData> actualFindAlarmDataByQueryForEntitiesResult = defaultAlarmSubscriptionService
        .findAlarmDataByQueryForEntities(tenantId, query, new ArrayList<>());

    // Assert
    verify(alarmService).findAlarmDataByQueryForEntities(isA(TenantId.class), isA(AlarmDataQuery.class),
        isA(Collection.class));
    assertSame(actualFindAlarmDataByQueryForEntitiesResult.EMPTY_PAGE_DATA,
        actualFindAlarmDataByQueryForEntitiesResult);
  }

  /**
   * Test
   * {@link DefaultAlarmSubscriptionService#findAlarmTypesByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultAlarmSubscriptionService#findAlarmTypesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAlarmTypesByTenantId(TenantId, PageLink); then return EMPTY_PAGE_DATA")
  void testFindAlarmTypesByTenantId_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmDao alarmDao = mock(AlarmDao.class);
    PageData<EntitySubtype> emptyPageDataResult = PageData.emptyPageData();
    when(alarmDao.findTenantAlarmTypes(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService alarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    DefaultTbAlarmCommentService alarmCommentService = new DefaultTbAlarmCommentService(new BaseAlarmCommentService());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultTbApiUsageReportClient apiUsageClient = new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler,
        new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings,
            vcSettings, serviceInfoProvider3, transportApiSettings, transportNotificationSettings, edgeSettings,
            new DefaultInMemoryStorage())));

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService3, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultAlarmSubscriptionService defaultAlarmSubscriptionService = new DefaultAlarmSubscriptionService(alarmService,
        alarmCommentService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService2, tsService, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()),
        mock(NotificationRuleProcessor.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<EntitySubtype> actualFindAlarmTypesByTenantIdResult = defaultAlarmSubscriptionService
        .findAlarmTypesByTenantId(tenantId, new PageLink(3));

    // Assert
    verify(alarmDao).findTenantAlarmTypes(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAlarmTypesByTenantIdResult.EMPTY_PAGE_DATA, actualFindAlarmTypesByTenantIdResult);
  }
}
