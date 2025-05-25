package org.thingsboard.server.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.LogoutRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.SystemInfo;
import org.thingsboard.server.common.data.SystemInfoData;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.common.data.sms.config.AwsSnsSmsProviderConfiguration;
import org.thingsboard.server.common.data.sms.config.TestSmsRequest;
import org.thingsboard.server.common.data.sync.vc.AutoCommitSettings;
import org.thingsboard.server.common.data.sync.vc.RepositoryAuthMethod;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.data.sync.vc.request.create.AutoVersionCreateConfig;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.system.SystemInfoService;
import org.thingsboard.server.service.update.UpdateService;

@ExtendWith(MockitoExtension.class)
class AdminControllerDiffblueTest {
  @InjectMocks
  private AdminController adminController;

  @Mock
  private SystemInfoService systemInfoService;

  @Mock
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  @Mock
  private UpdateService updateService;

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   * <p>
   * Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   * <p>
   * Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getAdminSettings(String)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getAdminSettings(String)}
   */
  @Test
  @DisplayName("Test getAdminSettings(String); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdminSettings AdminController.getAdminSettings(String)"})
  void testGetAdminSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#saveAdminSettings(AdminSettings)}.
   * <p>
   * Method under test: {@link AdminController#saveAdminSettings(AdminSettings)}
   */
  @Test
  @DisplayName("Test saveAdminSettings(AdminSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdminSettings AdminController.saveAdminSettings(AdminSettings)"})
  void testSaveAdminSettings() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/settings");
    postResult.characterEncoding("https://example.org/example");

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setCreatedTime(1L);
    adminSettings.setId(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    adminSettings.setJsonValue(MissingNode.getInstance());
    adminSettings.setKey("Key");
    adminSettings.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = (new ObjectMapper()).writeValueAsString(adminSettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   * <p>
   * Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   * <p>
   * Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getSecuritySettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getSecuritySettings()}
   */
  @Test
  @DisplayName("Test getSecuritySettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecuritySettings AdminController.getSecuritySettings()"})
  void testGetSecuritySettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#saveSecuritySettings(SecuritySettings)}.
   * <p>
   * Method under test: {@link AdminController#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @DisplayName("Test saveSecuritySettings(SecuritySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecuritySettings AdminController.saveSecuritySettings(SecuritySettings)"})
  void testSaveSecuritySettings() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/securitySettings");
    postResult.characterEncoding("https://example.org/example");

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
    String content = (new ObjectMapper()).writeValueAsString(securitySettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   * <p>
   * Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   * <p>
   * Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getJwtSettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getJwtSettings()}
   */
  @Test
  @DisplayName("Test getJwtSettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JwtSettings AdminController.getJwtSettings()"})
  void testGetJwtSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#saveJwtSettings(JwtSettings)}.
   * <p>
   * Method under test: {@link AdminController#saveJwtSettings(JwtSettings)}
   */
  @Test
  @DisplayName("Test saveJwtSettings(JwtSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.security.model.JwtPair AdminController.saveJwtSettings(JwtSettings)"})
  void testSaveJwtSettings() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/jwtSettings");
    postResult.characterEncoding("https://example.org/example");

    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setRefreshTokenExpTime(1);
    jwtSettings.setTokenExpirationTime(1);
    jwtSettings.setTokenIssuer("ABC123");
    jwtSettings.setTokenSigningKey("ABC123");
    String content = (new ObjectMapper()).writeValueAsString(jwtSettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#sendTestMail(AdminSettings)}.
   * <p>
   * Method under test: {@link AdminController#sendTestMail(AdminSettings)}
   */
  @Test
  @DisplayName("Test sendTestMail(AdminSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdminController.sendTestMail(AdminSettings)"})
  void testSendTestMail() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/settings/testMail");
    postResult.characterEncoding("https://example.org/example");

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setCreatedTime(1L);
    adminSettings.setId(new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    adminSettings.setJsonValue(MissingNode.getInstance());
    adminSettings.setKey("Key");
    adminSettings.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    String content = (new ObjectMapper()).writeValueAsString(adminSettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#sendTestSms(TestSmsRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then status four hundred fifteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#sendTestSms(TestSmsRequest)}
   */
  @Test
  @DisplayName("Test sendTestSms(TestSmsRequest); given 'https://example.org/example'; then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdminController.sendTestSms(TestSmsRequest)"})
  void testSendTestSms_givenHttpsExampleOrgExample_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/settings/testSms");
    postResult.characterEncoding("https://example.org/example");

    AwsSnsSmsProviderConfiguration providerConfiguration = new AwsSnsSmsProviderConfiguration();
    providerConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    providerConfiguration.setRegion("us-east-2");
    providerConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(providerConfiguration);
    String content = (new ObjectMapper()).writeValueAsString(testSmsRequest);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   * <p>
   * Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   * <p>
   * Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getRepositorySettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getRepositorySettings()}
   */
  @Test
  @DisplayName("Test getRepositorySettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettings AdminController.getRepositorySettings()"})
  void testGetRepositorySettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   * <p>
   * Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   * <p>
   * Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#repositorySettingsExists()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#repositorySettingsExists()}
   */
  @Test
  @DisplayName("Test repositorySettingsExists(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.repositorySettingsExists()"})
  void testRepositorySettingsExists_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   * <p>
   * Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   * <p>
   * Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getRepositorySettingsInfo()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getRepositorySettingsInfo()}
   */
  @Test
  @DisplayName("Test getRepositorySettingsInfo(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RepositorySettingsInfo AdminController.getRepositorySettingsInfo()"})
  void testGetRepositorySettingsInfo_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#saveRepositorySettings(RepositorySettings)}.
   * <p>
   * Method under test: {@link AdminController#saveRepositorySettings(RepositorySettings)}
   */
  @Test
  @DisplayName("Test saveRepositorySettings(RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult AdminController.saveRepositorySettings(RepositorySettings)"})
  void testSaveRepositorySettings() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/repositorySettings");
    postResult.characterEncoding("https://example.org/example");

    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setDefaultBranch("janedoe/featurebranch");
    repositorySettings.setLocalOnly(true);
    repositorySettings.setPassword("iloveyou");
    repositorySettings.setPrivateKey("Private Key");
    repositorySettings.setPrivateKeyFileName("foo.txt");
    repositorySettings.setPrivateKeyPassword("iloveyou");
    repositorySettings.setReadOnly(true);
    repositorySettings.setRepositoryUri("Repository Uri");
    repositorySettings.setShowMergeCommits(true);
    repositorySettings.setUsername("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(repositorySettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   * <p>
   * Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"})
  void testDeleteRepositorySettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   * <p>
   * Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"})
  void testDeleteRepositorySettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"})
  void testDeleteRepositorySettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#deleteRepositorySettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#deleteRepositorySettings()}
   */
  @Test
  @DisplayName("Test deleteRepositorySettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult AdminController.deleteRepositorySettings()"})
  void testDeleteRepositorySettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#checkRepositoryAccess(RepositorySettings)}.
   * <p>
   * Method under test: {@link AdminController#checkRepositoryAccess(RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkRepositoryAccess(RepositorySettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.springframework.web.context.request.async.DeferredResult AdminController.checkRepositoryAccess(RepositorySettings)"})
  void testCheckRepositoryAccess() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/repositorySettings/checkAccess");
    postResult.characterEncoding("https://example.org/example");

    RepositorySettings repositorySettings = new RepositorySettings();
    repositorySettings.setAuthMethod(RepositoryAuthMethod.USERNAME_PASSWORD);
    repositorySettings.setDefaultBranch("janedoe/featurebranch");
    repositorySettings.setLocalOnly(true);
    repositorySettings.setPassword("iloveyou");
    repositorySettings.setPrivateKey("Private Key");
    repositorySettings.setPrivateKeyFileName("foo.txt");
    repositorySettings.setPrivateKeyPassword("iloveyou");
    repositorySettings.setReadOnly(true);
    repositorySettings.setRepositoryUri("Repository Uri");
    repositorySettings.setShowMergeCommits(true);
    repositorySettings.setUsername("janedoe");
    String content = (new ObjectMapper()).writeValueAsString(repositorySettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   * <p>
   * Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   * <p>
   * Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getAutoCommitSettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test getAutoCommitSettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AutoCommitSettings AdminController.getAutoCommitSettings()"})
  void testGetAutoCommitSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   * <p>
   * Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   * <p>
   * Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#autoCommitSettingsExists()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#autoCommitSettingsExists()}
   */
  @Test
  @DisplayName("Test autoCommitSettingsExists(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean AdminController.autoCommitSettingsExists()"})
  void testAutoCommitSettingsExists_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}.
   * <p>
   * Method under test: {@link AdminController#saveAutoCommitSettings(AutoCommitSettings)}
   */
  @Test
  @DisplayName("Test saveAutoCommitSettings(AutoCommitSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AutoCommitSettings AdminController.saveAutoCommitSettings(AutoCommitSettings)"})
  void testSaveAutoCommitSettings() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/api/admin/autoCommitSettings");
    postResult.characterEncoding("https://example.org/example");

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.computeIfPresent(EntityType.TENANT, mock(BiFunction.class));
    autoCommitSettings.replace(EntityType.TENANT, autoVersionCreateConfig);
    autoCommitSettings.replaceAll(mock(BiFunction.class));
    String content = (new ObjectMapper()).writeValueAsString(autoCommitSettings);
    MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   * <p>
   * Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   * <p>
   * Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#deleteAutoCommitSettings()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#deleteAutoCommitSettings()}
   */
  @Test
  @DisplayName("Test deleteAutoCommitSettings(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdminController.deleteAutoCommitSettings()"})
  void testDeleteAutoCommitSettings_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#checkUpdates()}.
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code /api/admin/updates}.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#checkUpdates()}
   */
  @Test
  @DisplayName("Test checkUpdates(); when get(String, Object[]) '/api/admin/updates'; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UpdateMessage AdminController.checkUpdates()"})
  void testCheckUpdates_whenGetApiAdminUpdates_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(updateService.checkUpdates()).thenReturn(new UpdateMessage(true, "1.0.2", "1.0.2",
        "https://example.org/example", "https://example.org/example", "https://example.org/example"));
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/updates");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"updateAvailable\":true,\"currentVersion\":\"1.0.2\",\"latestVersion\":\"1.0.2\",\"upgradeInstructionsUrl\":"
                    + "\"https://example.org/example\",\"currentVersionReleaseNotesUrl\":\"https://example.org/example\","
                    + "\"latestVersionReleaseNotesUrl\":\"https://example.org/example\"}"));
  }

  /**
   * Test {@link AdminController#getSystemInfo()}.
   * <ul>
   *   <li>Given {@link SystemInfoData} (default constructor) CpuCount is three.</li>
   *   <li>Then content string a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getSystemInfo()}
   */
  @Test
  @DisplayName("Test getSystemInfo(); given SystemInfoData (default constructor) CpuCount is three; then content string a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SystemInfo AdminController.getSystemInfo()"})
  void testGetSystemInfo_givenSystemInfoDataCpuCountIsThree_thenContentStringAString() throws Exception {
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
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/systemInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content()
            .string(
                "{\"systemData\":[{\"serviceId\":\"42\",\"serviceType\":\"Service Type\",\"cpuUsage\":3,\"cpuCount\":3,\"memoryUsage"
                    + "\":3,\"totalMemory\":3,\"discUsage\":3,\"totalDiscSpace\":3}],\"monolith\":true}"));
  }

  /**
   * Test {@link AdminController#getSystemInfo()}.
   * <ul>
   *   <li>Then content string {@code {"systemData":[],"monolith":true}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getSystemInfo()}
   */
  @Test
  @DisplayName("Test getSystemInfo(); then content string '{\"systemData\":[],\"monolith\":true}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SystemInfo AdminController.getSystemInfo()"})
  void testGetSystemInfo_thenContentStringSystemDataMonolithTrue() throws Exception {
    // Arrange
    SystemInfo systemInfo = new SystemInfo();
    systemInfo.setMonolith(true);
    systemInfo.setSystemData(new ArrayList<>());
    when(systemInfoService.getSystemInfo()).thenReturn(systemInfo);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/admin/systemInfo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("{\"systemData\":[],\"monolith\":true}"));
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   * <p>
   * Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   * <p>
   * Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl(); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getMailProcessingUrl()}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getMailProcessingUrl()}
   */
  @Test
  @DisplayName("Test getMailProcessingUrl(); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getMailProcessingUrl()"})
  void testGetMailProcessingUrl_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"})
  void testGetAuthorizationUrl() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"})
  void testGetAuthorizationUrl2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("Body"));
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isNotFound()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse); then status isNotFound()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"})
  void testGetAuthorizationUrl_thenStatusIsNotFound() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Test {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When logout.</li>
   *   <li>Then content contentType {@code application/json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminController#getAuthorizationUrl(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test getAuthorizationUrl(HttpServletRequest, HttpServletResponse); when logout; then content contentType 'application/json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdminController.getAuthorizationUrl(HttpServletRequest, HttpServletResponse)"})
  void testGetAuthorizationUrl_whenLogout_thenContentContentTypeApplicationJson() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(42, HttpStatus.OK));
    LogoutRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.logout();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(adminController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("42"));
  }
}
