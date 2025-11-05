package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import freemarker.template.Configuration;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.model.ChangePasswordRequest;
import org.thingsboard.server.service.security.model.ResetPasswordEmailRequest;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

@ExtendWith(MockitoExtension.class)
class AuthControllerDiffblueTest {
  @InjectMocks private AuthController authController;

  @Mock private SecuritySettingsService securitySettingsService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AuthController#getUser()}.
   *
   * <p>Method under test: {@link AuthController#getUser()}
   */
  @Test
  @DisplayName("Test getUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.thingsboard.server.common.data.User AuthController.getUser()"})
  void testGetUser() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService3, apiUsageClient2);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService2,
            encoder,
            userService,
            mailService2,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    DefaultSecuritySettingsService securitySettingsService2 =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    AuthController authController =
        new AuthController(
            passwordEncoder,
            tokenFactory,
            mailService,
            systemSecurityService,
            securitySettingsService2,
            rateLimitService,
            mock(ApplicationEventPublisher.class));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> authController.getUser());
  }

  /**
   * Test {@link AuthController#logout(HttpServletRequest)}.
   *
   * <p>Method under test: {@link AuthController#logout(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test logout(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuthController.logout(HttpServletRequest)"})
  void testLogout() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService3, apiUsageClient2);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService2,
            encoder,
            userService,
            mailService2,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    DefaultSecuritySettingsService securitySettingsService2 =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    AuthController authController =
        new AuthController(
            passwordEncoder,
            tokenFactory,
            mailService,
            systemSecurityService,
            securitySettingsService2,
            rateLimitService,
            mock(ApplicationEventPublisher.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> authController.logout(new MockHttpServletRequest()));
  }

  /**
   * Test {@link AuthController#changePassword(ChangePasswordRequest)}.
   *
   * <p>Method under test: {@link AuthController#changePassword(ChangePasswordRequest)}
   */
  @Test
  @DisplayName("Test changePassword(ChangePasswordRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair AuthController.changePassword(ChangePasswordRequest)"
  })
  void testChangePassword() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(null);
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages2 =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig2 = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            null, serviceInfoProvider3, new DefaultSchedulerComponent(), null);

    DefaultMailService mailService2 =
        new DefaultMailService(
            messages2, freemarkerConfig2, adminSettingsService3, apiUsageClient2);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService2,
            encoder,
            userService,
            mailService2,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    DefaultSecuritySettingsService securitySettingsService2 =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    AuthController authController =
        new AuthController(
            passwordEncoder,
            tokenFactory,
            mailService,
            systemSecurityService,
            securitySettingsService2,
            rateLimitService,
            mock(ApplicationEventPublisher.class));

    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("iloveyou");

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> authController.changePassword(changePasswordRequest));
  }

  /**
   * Test {@link AuthController#getUserPasswordPolicy()}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link AuthController#getUserPasswordPolicy()}
   */
  @Test
  @DisplayName("Test getUserPasswordPolicy(); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserPasswordPolicy AuthController.getUserPasswordPolicy()"})
  void testGetUserPasswordPolicy_thenStatusFourHundredSix() throws Exception {
    // Arrange
    UserPasswordPolicy passwordPolicy = new UserPasswordPolicy();
    passwordPolicy.setAllowWhitespaces(true);
    passwordPolicy.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy.setMaximumLength(3);
    passwordPolicy.setMinimumDigits(1);
    passwordPolicy.setMinimumLength(3);
    passwordPolicy.setMinimumLowercaseLetters(1);
    passwordPolicy.setMinimumSpecialCharacters(1);
    passwordPolicy.setMinimumUppercaseLetters(1);
    passwordPolicy.setPasswordExpirationPeriodDays(1);
    passwordPolicy.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/noauth/userPasswordPolicy");
    requestBuilder.accept("Requested item wasn't found!");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link AuthController#getUserPasswordPolicy()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /api/noauth/userPasswordPolicy}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link AuthController#getUserPasswordPolicy()}
   */
  @Test
  @DisplayName(
      "Test getUserPasswordPolicy(); when get(String, Object[]) '/api/noauth/userPasswordPolicy'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserPasswordPolicy AuthController.getUserPasswordPolicy()"})
  void testGetUserPasswordPolicy_whenGetApiNoauthUserPasswordPolicy_thenStatusIsOk()
      throws Exception {
    // Arrange
    UserPasswordPolicy passwordPolicy = new UserPasswordPolicy();
    passwordPolicy.setAllowWhitespaces(true);
    passwordPolicy.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy.setMaximumLength(3);
    passwordPolicy.setMinimumDigits(1);
    passwordPolicy.setMinimumLength(3);
    passwordPolicy.setMinimumLowercaseLetters(1);
    passwordPolicy.setMinimumSpecialCharacters(1);
    passwordPolicy.setMinimumUppercaseLetters(1);
    passwordPolicy.setPasswordExpirationPeriodDays(1);
    passwordPolicy.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/noauth/userPasswordPolicy");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"minimumLength\":3,\"maximumLength\":3,\"minimumUppercaseLetters\":1,\"minimumLowercaseLetters\":1,\"minimumDigits"
                        + "\":1,\"minimumSpecialCharacters\":1,\"allowWhitespaces\":true,\"forceUserToResetPasswordIfNotValid\":true,"
                        + "\"passwordExpirationPeriodDays\":1,\"passwordReuseFrequencyDays\":1}"));
  }

  /**
   * Test {@link AuthController#requestResetPasswordByEmail(ResetPasswordEmailRequest,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@code Encoding}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthController#requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest); given 'Encoding'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthController.requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)"
  })
  void testRequestResetPasswordByEmail_givenEncoding_thenStatusFourHundredFifteen()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/noauth/resetPasswordByEmail");
    postResult.characterEncoding("Encoding");

    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");

    MockHttpServletRequestBuilder requestBuilder =
        postResult
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder()
                    .findAndAddModules()
                    .build()
                    .writeValueAsString(resetPasswordEmailRequest));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link AuthController#requestResetPasswordByEmail(ResetPasswordEmailRequest,
   * HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthController#requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AuthController.requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)"
  })
  void testRequestResetPasswordByEmail_thenStatusIsOk() throws Exception {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/noauth/resetPasswordByEmail")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                JsonMapper.builder()
                    .findAndAddModules()
                    .build()
                    .writeValueAsString(resetPasswordEmailRequest));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }
}
