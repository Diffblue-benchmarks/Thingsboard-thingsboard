package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import freemarker.template.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.thingsboard.server.common.data.security.model.JwtPair;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.oauth2.HybridClientRegistrationRepository;
import org.thingsboard.server.dao.oauth2.OAuth2ClientServiceImpl;
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
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

class Oauth2AuthenticationSuccessHandlerDiffblueTest {
  /**
   * Test
   * {@link Oauth2AuthenticationSuccessHandler#getRedirectUrl(String, JwtPair)}.
   * <p>
   * Method under test:
   * {@link Oauth2AuthenticationSuccessHandler#getRedirectUrl(String, JwtPair)}
   */
  @Test
  @DisplayName("Test getRedirectUrl(String, JwtPair)")
  void testGetRedirectUrl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    OAuth2ClientMapperProvider oauth2ClientMapperProvider = new OAuth2ClientMapperProvider();
    OAuth2ClientServiceImpl oAuth2ClientService = new OAuth2ClientServiceImpl();
    InMemoryOAuth2AuthorizedClientService oAuth2AuthorizedClientService = new InMemoryOAuth2AuthorizedClientService(
        new HybridClientRegistrationRepository());
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
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
    Oauth2AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler = new Oauth2AuthenticationSuccessHandler(
        tokenFactory, oauth2ClientMapperProvider, oAuth2ClientService, oAuth2AuthorizedClientService,
        httpCookieOAuth2AuthorizationRequestRepository,
        new DefaultSystemSecurityService(adminSettingsService, encoder, userService, mailService, auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())));

    // Act and Assert
    assertEquals("https://example.org/example/?accessToken=ABC123&refreshToken=ABC123",
        oauth2AuthenticationSuccessHandler.getRedirectUrl("https://example.org/example",
            new JwtPair("ABC123", "ABC123")));
  }
}
