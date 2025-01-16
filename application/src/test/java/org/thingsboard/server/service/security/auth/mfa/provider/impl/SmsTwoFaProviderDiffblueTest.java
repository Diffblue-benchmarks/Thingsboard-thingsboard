package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.template.Configuration;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.rule.engine.api.sms.SmsSenderFactory;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.model.mfa.account.SmsTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.SmsTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
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
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.mail.MailExecutorService;
import org.thingsboard.server.service.sms.DefaultSmsService;

class SmsTwoFaProviderDiffblueTest {
  /**
   * Test
   * {@link SmsTwoFaProvider#generateNewAccountConfig(User, SmsTwoFaProviderConfig)}
   * with {@code User}, {@code SmsTwoFaProviderConfig}.
   * <p>
   * Method under test:
   * {@link SmsTwoFaProvider#generateNewAccountConfig(User, SmsTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, SmsTwoFaProviderConfig) with 'User', 'SmsTwoFaProviderConfig'")
  void testGenerateNewAccountConfigWithUserSmsTwoFaProviderConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(null, tenantProfileDao, tenantService2,
        tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(),
        null);

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService apiUsageStateService2 = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultSmsService smsService = new DefaultSmsService(smsSenderFactory, adminSettingsService, apiUsageStateService2,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(null)));

    SmsTwoFaProvider smsTwoFaProvider = new SmsTwoFaProvider(cacheManager, smsService, new AuditLogServiceImpl());
    User user = new User();

    SmsTwoFaProviderConfig providerConfig = new SmsTwoFaProviderConfig();
    providerConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    providerConfig.setVerificationCodeLifetime(1);

    // Act
    SmsTwoFaAccountConfig actualGenerateNewAccountConfigResult = smsTwoFaProvider.generateNewAccountConfig(user,
        providerConfig);

    // Assert
    assertNull(actualGenerateNewAccountConfigResult.getPhoneNumber());
    assertEquals(TwoFaProviderType.SMS, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
  }

  /**
   * Test {@link SmsTwoFaProvider#check(TenantId)}.
   * <ul>
   *   <li>Given {@link DefaultSmsService}
   * {@link DefaultSmsService#isConfigured(TenantId)} return {@code true}.</li>
   *   <li>Then calls {@link DefaultSmsService#isConfigured(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProvider#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); given DefaultSmsService isConfigured(TenantId) return 'true'; then calls isConfigured(TenantId)")
  void testCheck_givenDefaultSmsServiceIsConfiguredReturnTrue_thenCallsIsConfigured() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSmsService smsService = mock(DefaultSmsService.class);
    when(smsService.isConfigured(Mockito.<TenantId>any())).thenReturn(true);
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    SmsTwoFaProvider smsTwoFaProvider = new SmsTwoFaProvider(cacheManager, smsService, new AuditLogServiceImpl());

    // Act
    smsTwoFaProvider.check(new TenantId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(smsService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link SmsTwoFaProvider#check(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProvider#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); then throw ThingsboardException")
  void testCheck_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(null, tenantProfileDao, tenantService2,
        tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(),
        null);

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService apiUsageStateService2 = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultSmsService smsService = new DefaultSmsService(smsSenderFactory, adminSettingsService, apiUsageStateService2,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(null)));

    SmsTwoFaProvider smsTwoFaProvider = new SmsTwoFaProvider(cacheManager, smsService, new AuditLogServiceImpl());

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> smsTwoFaProvider.check(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test {@link SmsTwoFaProvider#getType()}.
   * <p>
   * Method under test: {@link SmsTwoFaProvider#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider2, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService apiUsageStateService2 = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultSmsService smsService = new DefaultSmsService(smsSenderFactory, adminSettingsService, apiUsageStateService2,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider4, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider5, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertEquals(TwoFaProviderType.SMS,
        (new SmsTwoFaProvider(cacheManager, smsService, new AuditLogServiceImpl())).getType());
  }
}
