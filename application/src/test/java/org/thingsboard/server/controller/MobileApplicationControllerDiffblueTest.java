package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.template.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.security.model.JwtPair;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.mobile.BaseMobileAppSettingsService;
import org.thingsboard.server.dao.service.validator.MobileAppSettingsDataValidator;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.mobile.JpaMobileAppSettingsDao;
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
import org.thingsboard.server.service.mobile.secret.MobileAppSecretServiceImpl;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

class MobileApplicationControllerDiffblueTest {
  /**
   * Test {@link MobileApplicationController#getUserTokenByMobileSecret(String)}.
   * <p>
   * Method under test:
   * {@link MobileApplicationController#getUserTokenByMobileSecret(String)}
   */
  @Test
  @DisplayName("Test getUserTokenByMobileSecret(String)")
  void testGetUserTokenByMobileSecret() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MobileAppSecretServiceImpl mobileAppSecretService = mock(MobileAppSecretServiceImpl.class);
    JwtPair jwtPair = new JwtPair("ABC123", "ABC123");

    when(mobileAppSecretService.getJwtPair(Mockito.<String>any())).thenReturn(jwtPair);
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    JpaMobileAppSettingsDao mobileAppSettingsDao = new JpaMobileAppSettingsDao();

    // Act
    JwtPair actualUserTokenByMobileSecret = (new MobileApplicationController(systemSecurityService,
        mobileAppSecretService,
        new BaseMobileAppSettingsService(mobileAppSettingsDao, new MobileAppSettingsDataValidator())))
        .getUserTokenByMobileSecret("Secret");

    // Assert
    verify(mobileAppSecretService).getJwtPair(eq("Secret"));
    assertSame(jwtPair, actualUserTokenByMobileSecret);
  }
}
