package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.template.Configuration;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.rule.engine.api.sms.SmsSenderFactory;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.template.SmsDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
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
import org.thingsboard.server.service.notification.NotificationProcessingContext;
import org.thingsboard.server.service.sms.DefaultSmsService;

@ContextConfiguration(classes = {SmsNotificationChannel.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class SmsNotificationChannelDiffblueTest {
  @Autowired
  private SmsNotificationChannel smsNotificationChannel;

  @MockBean
  private SmsService smsService;

  /**
   * Test
   * {@link SmsNotificationChannel#sendNotification(User, SmsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   * with {@code User}, {@code SmsDeliveryMethodNotificationTemplate},
   * {@code NotificationProcessingContext}.
   * <p>
   * Method under test:
   * {@link SmsNotificationChannel#sendNotification(User, SmsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(User, SmsDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'User', 'SmsDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  void testSendNotificationWithUserSmsDeliveryMethodNotificationTemplateNotificationProcessingContext()
      throws Exception {
    // Arrange
    User recipient = new User();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> smsNotificationChannel.sendNotification(recipient, new SmsDeliveryMethodNotificationTemplate(), null));
  }

  /**
   * Test
   * {@link SmsNotificationChannel#sendNotification(User, SmsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   * with {@code User}, {@code SmsDeliveryMethodNotificationTemplate},
   * {@code NotificationProcessingContext}.
   * <p>
   * Method under test:
   * {@link SmsNotificationChannel#sendNotification(User, SmsDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(User, SmsDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'User', 'SmsDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  void testSendNotificationWithUserSmsDeliveryMethodNotificationTemplateNotificationProcessingContext2()
      throws Exception {
    // Arrange
    doNothing().when(smsService)
        .sendSms(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<String[]>any(), Mockito.<String>any());
    User recipient = mock(User.class);
    when(recipient.getPhone()).thenReturn("6625550144");
    SmsDeliveryMethodNotificationTemplate processedTemplate = new SmsDeliveryMethodNotificationTemplate();
    NotificationProcessingContext ctx = mock(NotificationProcessingContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    smsNotificationChannel.sendNotification(recipient, processedTemplate, ctx);

    // Assert
    verify(smsService).sendSms(isA(TenantId.class), isNull(), isA(String[].class), isNull());
    verify(recipient).getPhone();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link SmsNotificationChannel#check(TenantId)}.
   * <p>
   * Method under test: {@link SmsNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId)")
  void testCheck() throws Exception {
    // Arrange
    when(smsService.isConfigured(Mockito.<TenantId>any()))
        .thenThrow(new RuntimeException("SMS provider is not configured"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> smsNotificationChannel.check(new TenantId(UUID.randomUUID())));
    verify(smsService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link SmsNotificationChannel#check(TenantId)}.
   * <ul>
   *   <li>Given {@link SmsService} {@link SmsService#isConfigured(TenantId)} return
   * {@code false}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); given SmsService isConfigured(TenantId) return 'false'; then throw RuntimeException")
  void testCheck_givenSmsServiceIsConfiguredReturnFalse_thenThrowRuntimeException() throws Exception {
    // Arrange
    when(smsService.isConfigured(Mockito.<TenantId>any())).thenReturn(false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> smsNotificationChannel.check(new TenantId(UUID.randomUUID())));
    verify(smsService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link SmsNotificationChannel#check(TenantId)}.
   * <ul>
   *   <li>Given {@link SmsService} {@link SmsService#isConfigured(TenantId)} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); given SmsService isConfigured(TenantId) return 'true'")
  void testCheck_givenSmsServiceIsConfiguredReturnTrue() throws Exception {
    // Arrange
    when(smsService.isConfigured(Mockito.<TenantId>any())).thenReturn(true);

    // Act
    smsNotificationChannel.check(new TenantId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(smsService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link SmsNotificationChannel#getDeliveryMethod()}.
   * <p>
   * Method under test: {@link SmsNotificationChannel#getDeliveryMethod()}
   */
  @Test
  @DisplayName("Test getDeliveryMethod()")
  void testGetDeliveryMethod() {
    // Arrange
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

    // Act and Assert
    assertEquals(NotificationDeliveryMethod.SMS,
        (new SmsNotificationChannel(new DefaultSmsService(smsSenderFactory, adminSettingsService, apiUsageStateService2,
            new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider4, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider5, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))))))
            .getDeliveryMethod());
  }
}
