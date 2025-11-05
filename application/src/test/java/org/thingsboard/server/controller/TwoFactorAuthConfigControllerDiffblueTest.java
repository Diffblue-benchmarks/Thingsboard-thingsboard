package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import freemarker.template.Configuration;
import java.util.ArrayList;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.security.model.mfa.PlatformTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.controller.TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
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
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.auth.mfa.DefaultTwoFactorAuthService;
import org.thingsboard.server.service.security.auth.mfa.config.DefaultTwoFaConfigManager;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

@ExtendWith(MockitoExtension.class)
class TwoFactorAuthConfigControllerDiffblueTest {
  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @InjectMocks private TwoFactorAuthConfigController twoFactorAuthConfigController;

  /**
   * Test {@link TwoFactorAuthConfigController#getAccountTwoFaSettings()}.
   *
   * <p>Method under test: {@link TwoFactorAuthConfigController#getAccountTwoFaSettings()}
   */
  @Test
  @DisplayName("Test getAccountTwoFaSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.getAccountTwoFaSettings()"
  })
  void testGetAccountTwoFaSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> twoFactorAuthConfigController.getAccountTwoFaSettings());
  }

  /**
   * Test {@link TwoFactorAuthConfigController#generateTwoFaAccountConfig(TwoFaProviderType)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#generateTwoFaAccountConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateTwoFaAccountConfig(TwoFaProviderType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TwoFaAccountConfig TwoFactorAuthConfigController.generateTwoFaAccountConfig(TwoFaProviderType)"
  })
  void testGenerateTwoFaAccountConfig() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> twoFactorAuthConfigController.generateTwoFaAccountConfig(TwoFaProviderType.TOTP));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test submitTwoFaAccountConfig(TwoFaAccountConfig)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwoFactorAuthConfigController.submitTwoFaAccountConfig(TwoFaAccountConfig)"
  })
  void testSubmitTwoFaAccountConfig() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config/submit")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#submitTwoFaAccountConfig(TwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test submitTwoFaAccountConfig(TwoFaAccountConfig); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwoFactorAuthConfigController.submitTwoFaAccountConfig(TwoFaAccountConfig)"
  })
  void testSubmitTwoFaAccountConfig_givenTrue() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config/submit");
    postResult.secure(true);

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)},
   * and {@link TwoFaAccountConfigUpdateRequest#hashCode()}.
   *
   * <ul>
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaAccountConfigUpdateRequest equals(Object), and hashCode(); then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEqualsAndHashCode_thenReturnEqual() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest);
    int expectedHashCodeResult = twoFaAccountConfigUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, twoFaAccountConfigUpdateRequest.hashCode());
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)},
   * and {@link TwoFaAccountConfigUpdateRequest#hashCode()}.
   *
   * <ul>
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test TwoFaAccountConfigUpdateRequest equals(Object), and hashCode(); then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEqualsAndHashCode_thenReturnEqual2() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest2 =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest2.setUseByDefault(true);

    // Act and Assert
    assertEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest2);
    assertEquals(
        twoFaAccountConfigUpdateRequest.hashCode(), twoFaAccountConfigUpdateRequest2.hashCode());
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEquals_thenReturnNotEqual() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(
        twoFaAccountConfigUpdateRequest, "Different type to TwoFaAccountConfigUpdateRequest");
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest equals(Object); then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEquals_thenReturnNotEqual2() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(false);

    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest2 =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, twoFaAccountConfigUpdateRequest2);
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest {@link TwoFaAccountConfigUpdateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TwoFaAccountConfigUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName(
      "Test TwoFaAccountConfigUpdateRequest equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TwoFaAccountConfigUpdateRequest.equals(Object)",
    "int TwoFaAccountConfigUpdateRequest.hashCode()"
  })
  void testTwoFaAccountConfigUpdateRequestEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwoFaAccountConfigUpdateRequest twoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    twoFaAccountConfigUpdateRequest.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(twoFaAccountConfigUpdateRequest, null);
  }

  /**
   * Test TwoFaAccountConfigUpdateRequest getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TwoFaAccountConfigUpdateRequest}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#setUseByDefault(boolean)}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#toString()}
   *   <li>{@link TwoFaAccountConfigUpdateRequest#isUseByDefault()}
   * </ul>
   */
  @Test
  @DisplayName("Test TwoFaAccountConfigUpdateRequest getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TwoFaAccountConfigUpdateRequest.<init>()",
    "boolean TwoFaAccountConfigUpdateRequest.isUseByDefault()",
    "void TwoFaAccountConfigUpdateRequest.setUseByDefault(boolean)",
    "String TwoFaAccountConfigUpdateRequest.toString()"
  })
  void testTwoFaAccountConfigUpdateRequestGettersAndSetters() {
    // Arrange and Act
    TwoFaAccountConfigUpdateRequest actualTwoFaAccountConfigUpdateRequest =
        new TwoFaAccountConfigUpdateRequest();
    actualTwoFaAccountConfigUpdateRequest.setUseByDefault(true);
    String actualToStringResult = actualTwoFaAccountConfigUpdateRequest.toString();

    // Assert
    assertEquals(
        "TwoFactorAuthConfigController.TwoFaAccountConfigUpdateRequest(useByDefault=true)",
        actualToStringResult);
    assertTrue(actualTwoFaAccountConfigUpdateRequest.isUseByDefault());
  }

  /**
   * Test {@link TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code Encoding}.
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String); given 'Encoding'; then status four hundred fifteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)"
  })
  void testVerifyAndSaveTwoFaAccountConfig_givenEncoding_thenStatusFourHundredFifteen()
      throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config");
    postResult.characterEncoding("Encoding");

    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(415));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig,
   * String)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)}
   */
  @Test
  @DisplayName(
      "Test verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String); then status four hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.verifyAndSaveTwoFaAccountConfig(TwoFaAccountConfig, String)"
  })
  void testVerifyAndSaveTwoFaAccountConfig_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder contentTypeResult =
        MockMvcRequestBuilders.post("/api/2fa/account/config")
            .contentType(MediaType.APPLICATION_JSON);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();

    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            jsonMapper.writeValueAsString(new BackupCodeTwoFaAccountConfig()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(twoFactorAuthConfigController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#updateTwoFaAccountConfig(TwoFaProviderType,
   * TwoFaAccountConfigUpdateRequest)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#updateTwoFaAccountConfig(TwoFaProviderType,
   * TwoFaAccountConfigUpdateRequest)}
   */
  @Test
  @DisplayName("Test updateTwoFaAccountConfig(TwoFaProviderType, TwoFaAccountConfigUpdateRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.updateTwoFaAccountConfig(TwoFaProviderType, TwoFaAccountConfigUpdateRequest)"
  })
  void testUpdateTwoFaAccountConfig() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    TwoFaAccountConfigUpdateRequest updateRequest = new TwoFaAccountConfigUpdateRequest();
    updateRequest.setUseByDefault(true);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            twoFactorAuthConfigController.updateTwoFaAccountConfig(
                TwoFaProviderType.TOTP, updateRequest));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#deleteTwoFaAccountConfig(TwoFaProviderType)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#deleteTwoFaAccountConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test deleteTwoFaAccountConfig(TwoFaProviderType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings TwoFactorAuthConfigController.deleteTwoFaAccountConfig(TwoFaProviderType)"
  })
  void testDeleteTwoFaAccountConfig() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> twoFactorAuthConfigController.deleteTwoFaAccountConfig(TwoFaProviderType.TOTP));
  }

  /**
   * Test {@link TwoFactorAuthConfigController#getAvailableTwoFaProviders()}.
   *
   * <p>Method under test: {@link TwoFactorAuthConfigController#getAvailableTwoFaProviders()}
   */
  @Test
  @DisplayName("Test getAvailableTwoFaProviders()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TwoFactorAuthConfigController.getAvailableTwoFaProviders()"})
  void testGetAvailableTwoFaProviders() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> twoFactorAuthConfigController.getAvailableTwoFaProviders());
  }

  /**
   * Test {@link TwoFactorAuthConfigController#getPlatformTwoFaSettings()}.
   *
   * <p>Method under test: {@link TwoFactorAuthConfigController#getPlatformTwoFaSettings()}
   */
  @Test
  @DisplayName("Test getPlatformTwoFaSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTwoFaSettings TwoFactorAuthConfigController.getPlatformTwoFaSettings()"
  })
  void testGetPlatformTwoFaSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> twoFactorAuthConfigController.getPlatformTwoFaSettings());
  }

  /**
   * Test {@link TwoFactorAuthConfigController#savePlatformTwoFaSettings(PlatformTwoFaSettings)}.
   *
   * <p>Method under test: {@link
   * TwoFactorAuthConfigController#savePlatformTwoFaSettings(PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test savePlatformTwoFaSettings(PlatformTwoFaSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PlatformTwoFaSettings TwoFactorAuthConfigController.savePlatformTwoFaSettings(PlatformTwoFaSettings)"
  })
  void testSavePlatformTwoFaSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager twoFaConfigManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao, adminSettingsService, new JpaAdminSettingsDao());
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();

    DefaultTwoFaConfigManager configManager =
        new DefaultTwoFaConfigManager(
            userAuthSettingsDao2, adminSettingsService2, new JpaAdminSettingsDao());
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, new AdminSettingsServiceImpl(), null);
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();

    DefaultSystemSecurityService systemSecurityService =
        new DefaultSystemSecurityService(
            adminSettingsService3,
            encoder,
            userService,
            mailService,
            auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao3,
            userSettingsService,
            userSettingsDao2,
            securitySettingsService,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultTwoFactorAuthService twoFactorAuthService =
        new DefaultTwoFactorAuthService(
            configManager, systemSecurityService, userService2, rateLimitService);

    TwoFactorAuthConfigController twoFactorAuthConfigController =
        new TwoFactorAuthConfigController(twoFaConfigManager, twoFactorAuthService);

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> twoFactorAuthConfigController.savePlatformTwoFaSettings(twoFaSettings));
  }
}
