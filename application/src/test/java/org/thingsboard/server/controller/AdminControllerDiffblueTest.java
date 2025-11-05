package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.FeaturesInfo;
import org.thingsboard.server.common.data.SystemInfo;
import org.thingsboard.server.common.data.SystemInfoData;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.common.data.sms.config.SmsProviderConfiguration;
import org.thingsboard.server.common.data.sms.config.TestSmsRequest;
import org.thingsboard.server.common.data.sync.vc.AutoCommitSettings;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.data.sync.vc.request.create.AutoVersionCreateConfig;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.system.SystemSecurityService;
import org.thingsboard.server.service.sync.vc.EntitiesVersionControlService;
import org.thingsboard.server.service.sync.vc.autocommit.TbAutoCommitSettingsService;
import org.thingsboard.server.service.system.SystemInfoService;
import org.thingsboard.server.service.update.UpdateService;

@ExtendWith(MockitoExtension.class)
class AdminControllerDiffblueTest {
  @InjectMocks private AdminController adminController;

  @Mock private SystemInfoService systemInfoService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @Mock private UpdateService updateService;

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   *
   * <p>Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   *
   * <p>Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName(
      "Test getAdminSettings(String); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#saveAdminSettings(AdminSettings)}.
   *
   * <p>Method under test: {@link AdminController#saveAdminSettings(AdminSettings)}
   */
  @Test
  @DisplayName("Test saveAdminSettings(AdminSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdminSettings AdminController.saveAdminSettings(AdminSettings)"})
  void testSaveAdminSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveAdminSettings(new AdminSettings()));
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   *
   * <p>Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   *
   * <p>Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName(
      "Test getSecuritySettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#saveSecuritySettings(SecuritySettings)}.
   *
   * <p>Method under test: {@link AdminController#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @DisplayName("Test saveSecuritySettings(SecuritySettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings AdminController.saveSecuritySettings(SecuritySettings)"})
  void testSaveSecuritySettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

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

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveSecuritySettings(securitySettings));
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   *
   * <p>Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   *
   * <p>Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#saveJwtSettings(JwtSettings)}.
   *
   * <p>Method under test: {@link AdminController#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair AdminController.saveJwtSettings(JwtSettings)"
  })
  void testSaveJwtSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveJwtSettings(new JwtSettings()));
  }

  /**
   * Test {@link AdminController#sendTestMail(AdminSettings)}.
   *
   * <p>Method under test: {@link AdminController#sendTestMail(AdminSettings)}
   */
  @Test
  @DisplayName("Test sendTestMail(AdminSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminController.sendTestMail(AdminSettings)"})
  void testSendTestMail() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.sendTestMail(new AdminSettings()));
  }

  /**
   * Test {@link AdminController#sendTestSms(TestSmsRequest)}.
   *
   * <p>Method under test: {@link AdminController#sendTestSms(TestSmsRequest)}
   */
  @Test
  @DisplayName("Test sendTestSms(TestSmsRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminController.sendTestSms(TestSmsRequest)"})
  void testSendTestSms() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> adminController.sendTestSms(testSmsRequest));
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   *
   * <p>Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   *
   * <p>Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName(
      "Test getRepositorySettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   *
   * <p>Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   *
   * <p>Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName(
      "Test repositorySettingsExists(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   *
   * <p>Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   *
   * <p>Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName(
      "Test getRepositorySettingsInfo(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#saveRepositorySettings(RepositorySettings)}.
   *
   * <p>Method under test: {@link AdminController#saveRepositorySettings(RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveRepositorySettings(RepositorySettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AdminController.saveRepositorySettings(RepositorySettings)"
  })
  void testSaveRepositorySettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> adminController.saveRepositorySettings(new RepositorySettings()));
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   *
   * <p>Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"
  })
  void testDeleteRepositorySettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   *
   * <p>Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"
  })
  void testDeleteRepositorySettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"
  })
  void testDeleteRepositorySettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName(
      "Test deleteRepositorySettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"
  })
  void testDeleteRepositorySettings_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#checkRepositoryAccess(RepositorySettings)}.
   *
   * <p>Method under test: {@link AdminController#checkRepositoryAccess(RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkRepositoryAccess(RepositorySettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult AdminController.checkRepositoryAccess(RepositorySettings)"
  })
  void testCheckRepositoryAccess() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> adminController.checkRepositoryAccess(new RepositorySettings()));
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   *
   * <p>Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   *
   * <p>Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName(
      "Test getAutoCommitSettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   *
   * <p>Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   *
   * <p>Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName(
      "Test autoCommitSettingsExists(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   *
   * <p>Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName("Test saveAutoCommitSettings(AutoCommitSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"
  })
  void testSaveAutoCommitSettings() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings settings = new AutoCommitSettings();
    settings.put(EntityType.TENANT, autoVersionCreateConfig);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveAutoCommitSettings(settings));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   *
   * <ul>
   *   <li>Given {@link AutoVersionCreateConfig} (default constructor) Branch is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName(
      "Test saveAutoCommitSettings(AutoCommitSettings); given AutoVersionCreateConfig (default constructor) Branch is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"
  })
  void testSaveAutoCommitSettings_givenAutoVersionCreateConfigBranchIs42()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("42");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings settings = new AutoCommitSettings();
    settings.put(EntityType.TENANT, autoVersionCreateConfig);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveAutoCommitSettings(settings));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   *
   * <ul>
   *   <li>Given {@link AutoVersionCreateConfig} (default constructor) Branch is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName(
      "Test saveAutoCommitSettings(AutoCommitSettings); given AutoVersionCreateConfig (default constructor) Branch is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"
  })
  void testSaveAutoCommitSettings_givenAutoVersionCreateConfigBranchIsEmptyString()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings settings = new AutoCommitSettings();
    settings.put(EntityType.TENANT, autoVersionCreateConfig);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveAutoCommitSettings(settings));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   *
   * <ul>
   *   <li>Given {@link AutoVersionCreateConfig} (default constructor) Branch is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName(
      "Test saveAutoCommitSettings(AutoCommitSettings); given AutoVersionCreateConfig (default constructor) Branch is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"
  })
  void testSaveAutoCommitSettings_givenAutoVersionCreateConfigBranchIsNull()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch(null);
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings settings = new AutoCommitSettings();
    settings.put(EntityType.TENANT, autoVersionCreateConfig);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveAutoCommitSettings(settings));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   *
   * <ul>
   *   <li>Given {@link AutoVersionCreateConfig} (default constructor) SaveAttributes is {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName(
      "Test saveAutoCommitSettings(AutoCommitSettings); given AutoVersionCreateConfig (default constructor) SaveAttributes is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"
  })
  void testSaveAutoCommitSettings_givenAutoVersionCreateConfigSaveAttributesIsFalse()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoVersionCreateConfig autoVersionCreateConfig2 = new AutoVersionCreateConfig();
    autoVersionCreateConfig2.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig2.setSaveAttributes(false);
    autoVersionCreateConfig2.setSaveCredentials(false);
    autoVersionCreateConfig2.setSaveRelations(false);

    AutoCommitSettings settings = new AutoCommitSettings();
    settings.put(EntityType.CUSTOMER, autoVersionCreateConfig2);
    settings.put(EntityType.TENANT, autoVersionCreateConfig);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> adminController.saveAutoCommitSettings(settings));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   *
   * <ul>
   *   <li>When {@link AutoCommitSettings} (default constructor).
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName(
      "Test saveAutoCommitSettings(AutoCommitSettings); when AutoCommitSettings (default constructor); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"
  })
  void testSaveAutoCommitSettings_whenAutoCommitSettings_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            mock(SystemSecurityService.class),
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> adminController.saveAutoCommitSettings(new AutoCommitSettings()));
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   *
   * <p>Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   *
   * <p>Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName(
      "Test deleteAutoCommitSettings(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#checkUpdates()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /api/admin/updates}.
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#checkUpdates()}
   */
  @Test
  @DisplayName(
      "Test checkUpdates(); when get(String, Object[]) '/api/admin/updates'; then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UpdateMessage AdminController.checkUpdates()"})
  void testCheckUpdates_whenGetApiAdminUpdates_thenContentStringAString() throws Exception {
    // Arrange
    UpdateMessage updateMessage =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");
    when(updateService.checkUpdates()).thenReturn(updateMessage);

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/updates");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"updateAvailable\":true,\"currentVersion\":\"1.0.2\",\"latestVersion\":\"1.0.2\",\"upgradeInstructionsUrl\":"
                        + "\"https://example.org/example\",\"currentVersionReleaseNotesUrl\":\"https://example.org/example\","
                        + "\"latestVersionReleaseNotesUrl\":\"https://example.org/example\"}"));
  }

  /**
   * Test {@link AdminController#getSystemInfo()}.
   *
   * <ul>
   *   <li>Given {@link SystemInfoData} (default constructor) CpuCount is three.
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getSystemInfo()}
   */
  @Test
  @DisplayName(
      "Test getSystemInfo(); given SystemInfoData (default constructor) CpuCount is three; then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemInfo AdminController.getSystemInfo()"})
  void testGetSystemInfo_givenSystemInfoDataCpuCountIsThree_thenContentStringAString()
      throws Exception {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(3L);
    systemInfoData.setDiscUsage(3L);
    systemInfoData.setMemoryUsage(3L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(3L);
    systemInfoData.setTotalMemory(3L);

    ArrayList<SystemInfoData> systemData = new ArrayList<>();
    systemData.add(systemInfoData);

    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(systemData);
    when(systemInfoService.getSystemInfo()).thenReturn(systemInfo);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/admin/systemInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"systemData\":[{\"serviceId\":\"42\",\"serviceType\":\"Service Type\",\"cpuUsage\":3,\"cpuCount\":3,\"memoryUsage"
                        + "\":3,\"totalMemory\":3,\"discUsage\":3,\"totalDiscSpace\":3}],\"monolith\":true}"));
  }

  /**
   * Test {@link AdminController#getSystemInfo()}.
   *
   * <ul>
   *   <li>Then content string {@code {"systemData":[],"monolith":true}}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getSystemInfo()}
   */
  @Test
  @DisplayName("Test getSystemInfo(); then content string '{\"systemData\":[],\"monolith\":true}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SystemInfo AdminController.getSystemInfo()"})
  void testGetSystemInfo_thenContentStringSystemDataMonolithTrue() throws Exception {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());
    when(systemInfoService.getSystemInfo()).thenReturn(systemInfo);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/admin/systemInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("{\"systemData\":[],\"monolith\":true}"));
  }

  /**
   * Test {@link AdminController#getFeaturesInfo()}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /api/admin/featuresInfo}.
   *   <li>Then content string a string.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getFeaturesInfo()}
   */
  @Test
  @DisplayName(
      "Test getFeaturesInfo(); when get(String, Object[]) '/api/admin/featuresInfo'; then content string a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FeaturesInfo AdminController.getFeaturesInfo()"})
  void testGetFeaturesInfo_whenGetApiAdminFeaturesInfo_thenContentStringAString() throws Exception {
    // Arrange
    FeaturesInfo featuresInfo = new FeaturesInfo();
    featuresInfo.setEmailEnabled(true);
    featuresInfo.setNotificationEnabled(true);
    featuresInfo.setOauthEnabled(true);
    featuresInfo.setSmsEnabled(true);
    featuresInfo.setTwoFaEnabled(true);
    when(systemInfoService.getFeaturesInfo()).thenReturn(featuresInfo);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/admin/featuresInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"emailEnabled\":true,\"notificationEnabled\":true,\"oauthEnabled\":true,\"smsEnabled\":true,\"twoFaEnabled"
                        + "\":true}"));
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   *
   * <p>Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   *
   * <p>Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl(); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName(
      "Test getMailProcessingUrl(); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl_whenLogout_thenContentContentTypeApplicationJson()
      throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName("Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"
  })
  void testGetAuthorizationUrl() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   *
   * <p>Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName("Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"
  })
  void testGetAuthorizationUrl2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse); then status isNotFound()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"
  })
  void testGetAuthorizationUrl_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isNotFound());
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>When logout.
   *   <li>Then content contentType {@code application/json}.
   * </ul>
   *
   * <p>Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse); when logout; then content contentType 'application/json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"
  })
  void testGetAuthorizationUrl_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));

    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("42"));
  }

  /**
   * Test {@link AdminController#codeProcessingUrl(String, String, HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <p>Method under test: {@link AdminController#codeProcessingUrl(String, String,
   * HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test codeProcessingUrl(String, String, HttpServletRequest, HttpServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminController.codeProcessingUrl(String, String, HttpServletRequest, HttpServletResponse)"
  })
  void testCodeProcessingUrl() throws IOException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SystemSecurityService systemSecurityService = mock(SystemSecurityService.class);
    when(systemSecurityService.getBaseUrl(
            Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<HttpServletRequest>any()))
        .thenReturn("https://example.org/example");
    AdminController adminController =
        new AdminController(
            mock(MailService.class),
            mock(SmsService.class),
            mock(AdminSettingsService.class),
            systemSecurityService,
            mock(SecuritySettingsService.class),
            mock(JwtSettingsService.class),
            mock(JwtTokenFactory.class),
            mock(EntitiesVersionControlService.class),
            mock(TbAutoCommitSettingsService.class),
            mock(UpdateService.class),
            mock(SystemInfoService.class),
            mock(AuditLogService.class));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            adminController.codeProcessingUrl(
                "https://example.org/example",
                "https://example.org/example",
                request,
                new MockHttpServletResponse()));
    verify(systemSecurityService)
        .getBaseUrl(isA(TenantId.class), isA(CustomerId.class), isA(HttpServletRequest.class));
  }
}
