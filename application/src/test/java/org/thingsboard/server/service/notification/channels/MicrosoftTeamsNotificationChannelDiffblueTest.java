package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import freemarker.template.Configuration;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

class MicrosoftTeamsNotificationChannelDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MicrosoftTeamsNotificationChannel#setRestTemplate(RestTemplate)}
   *   <li>{@link MicrosoftTeamsNotificationChannel#check(TenantId)}
   *   <li>{@link MicrosoftTeamsNotificationChannel#getDeliveryMethod()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws Exception {
    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(null)));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    MicrosoftTeamsNotificationChannel microsoftTeamsNotificationChannel = new MicrosoftTeamsNotificationChannel(
        new DefaultSystemSecurityService(adminSettingsService, encoder, userService, mailService, auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())));

    // Act
    microsoftTeamsNotificationChannel.setRestTemplate(mock(RestTemplate.class));
    microsoftTeamsNotificationChannel.check(new TenantId(UUID.randomUUID()));

    // Assert that nothing has changed
    assertEquals(NotificationDeliveryMethod.MICROSOFT_TEAMS, microsoftTeamsNotificationChannel.getDeliveryMethod());
  }
}
