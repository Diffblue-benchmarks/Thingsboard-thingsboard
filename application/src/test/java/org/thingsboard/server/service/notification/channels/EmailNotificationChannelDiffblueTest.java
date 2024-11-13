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
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.TbEmail;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
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
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.notification.NotificationProcessingContext;

@ContextConfiguration(classes = {EmailNotificationChannel.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EmailNotificationChannelDiffblueTest {
  @Autowired
  private EmailNotificationChannel emailNotificationChannel;

  @MockBean
  private MailService mailService;

  /**
   * Test
   * {@link EmailNotificationChannel#sendNotification(User, EmailDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   * with {@code User}, {@code EmailDeliveryMethodNotificationTemplate},
   * {@code NotificationProcessingContext}.
   * <p>
   * Method under test:
   * {@link EmailNotificationChannel#sendNotification(User, EmailDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(User, EmailDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'User', 'EmailDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  void testSendNotificationWithUserEmailDeliveryMethodNotificationTemplateNotificationProcessingContext()
      throws Exception {
    // Arrange
    doNothing().when(mailService).send(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<TbEmail>any());
    User recipient = new User();
    EmailDeliveryMethodNotificationTemplate processedTemplate = new EmailDeliveryMethodNotificationTemplate();
    NotificationProcessingContext ctx = mock(NotificationProcessingContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    emailNotificationChannel.sendNotification(recipient, processedTemplate, ctx);

    // Assert
    verify(mailService).send(isA(TenantId.class), isNull(), isA(TbEmail.class));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EmailNotificationChannel#check(TenantId)}.
   * <p>
   * Method under test: {@link EmailNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId)")
  void testCheck() throws Exception {
    // Arrange
    when(mailService.isConfigured(Mockito.<TenantId>any()))
        .thenThrow(new RuntimeException("Mail server is not configured"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emailNotificationChannel.check(new TenantId(UUID.randomUUID())));
    verify(mailService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link EmailNotificationChannel#check(TenantId)}.
   * <ul>
   *   <li>Given {@link MailService} {@link MailService#isConfigured(TenantId)}
   * return {@code false}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); given MailService isConfigured(TenantId) return 'false'; then throw RuntimeException")
  void testCheck_givenMailServiceIsConfiguredReturnFalse_thenThrowRuntimeException() throws Exception {
    // Arrange
    when(mailService.isConfigured(Mockito.<TenantId>any())).thenReturn(false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> emailNotificationChannel.check(new TenantId(UUID.randomUUID())));
    verify(mailService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link EmailNotificationChannel#check(TenantId)}.
   * <ul>
   *   <li>Given {@link MailService} {@link MailService#isConfigured(TenantId)}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); given MailService isConfigured(TenantId) return 'true'")
  void testCheck_givenMailServiceIsConfiguredReturnTrue() throws Exception {
    // Arrange
    when(mailService.isConfigured(Mockito.<TenantId>any())).thenReturn(true);

    // Act
    emailNotificationChannel.check(new TenantId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(mailService).isConfigured(isA(TenantId.class));
  }

  /**
   * Test {@link EmailNotificationChannel#getDeliveryMethod()}.
   * <p>
   * Method under test: {@link EmailNotificationChannel#getDeliveryMethod()}
   */
  @Test
  @DisplayName("Test getDeliveryMethod()")
  void testGetDeliveryMethod() {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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

    // Act and Assert
    assertEquals(NotificationDeliveryMethod.EMAIL,
        (new EmailNotificationChannel(new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))))))
            .getDeliveryMethod());
  }
}
