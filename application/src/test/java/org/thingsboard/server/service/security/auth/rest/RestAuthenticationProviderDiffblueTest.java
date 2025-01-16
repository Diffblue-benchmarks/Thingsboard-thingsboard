package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import freemarker.template.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.settings.JpaAdminSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.auth.mfa.DefaultTwoFactorAuthService;
import org.thingsboard.server.service.security.auth.mfa.config.DefaultTwoFaConfigManager;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

class RestAuthenticationProviderDiffblueTest {
  /**
   * Test {@link RestAuthenticationProvider#supports(Class)}.
   * <p>
   * Method under test: {@link RestAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class)")
  void testSupports() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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

    CustomerServiceImpl customerService = new CustomerServiceImpl();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService2, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultSecuritySettingsService securitySettingsService3 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    JpaUserAuthSettingsDao userAuthSettingsDao3 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTwoFaConfigManager configManager = new DefaultTwoFaConfigManager(userAuthSettingsDao3, adminSettingsService3,
        new JpaAdminSettingsDao());

    AdminSettingsServiceImpl adminSettingsService4 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
    JpaUserDao userDao3 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao3 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao3 = new JpaUserSettingsDao();
    UserDataValidator userValidator3 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator3 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService3 = new BaseEntityCountService();
    UserServiceImpl userService3 = new UserServiceImpl(userDao3, userCredentialsDao3, null, null, userSettingsDao3,
        null, userValidator3, userCredentialsValidator3, eventPublisher3, countService3, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages2 = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    DefaultMailService mailService2 = new DefaultMailService(messages2, freemarkerConfig2,
        new AdminSettingsServiceImpl(), null);

    AuditLogServiceImpl auditLogService2 = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService2 = new DefaultSystemSecurityService(adminSettingsService4,
        encoder2, userService3, mailService2, auditLogService2,
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    JpaUserDao userDao4 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao4 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao4 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService3 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao4 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService4 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator4 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator4 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService4 = new BaseEntityCountService();
    UserServiceImpl userService4 = new UserServiceImpl(userDao4, userCredentialsDao4, userAuthSettingsDao4,
        userSettingsService3, userSettingsDao4, securitySettingsService4, userValidator4, userCredentialsValidator4,
        eventPublisher4, countService4, new JpaExecutorService());

    RestAuthenticationProvider restAuthenticationProvider = new RestAuthenticationProvider(userService, customerService,
        systemSecurityService, securitySettingsService3,
        new DefaultTwoFactorAuthService(configManager, systemSecurityService2, userService4,
            new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1,
                3)));
    Class<Object> authentication = Object.class;

    // Act and Assert
    assertFalse(restAuthenticationProvider.supports(authentication));
  }
}
