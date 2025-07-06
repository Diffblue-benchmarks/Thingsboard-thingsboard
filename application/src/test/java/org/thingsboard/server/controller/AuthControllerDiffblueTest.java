package org.thingsboard.server.controller;

import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.model.ChangePasswordRequest;
import org.thingsboard.server.service.security.model.ResetPasswordEmailRequest;
import org.thingsboard.server.service.security.model.ResetPasswordRequest;

@ExtendWith(MockitoExtension.class)
class AuthControllerDiffblueTest {
  @InjectMocks private AuthController authController;

  @Mock private SecuritySettingsService securitySettingsService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link AuthController#changePassword(ChangePasswordRequest)}.
   *
   * <p>Method under test: {@link AuthController#changePassword(ChangePasswordRequest)}
   */
  @Test
  @DisplayName("Test changePassword(ChangePasswordRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair AuthController.changePassword(ChangePasswordRequest)"
  })
  void testChangePassword() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/auth/changePassword");
    postResult.characterEncoding("https://example.org/example");

    ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
    changePasswordRequest.setCurrentPassword("iloveyou");
    changePasswordRequest.setNewPassword("iloveyou");
    String content = new ObjectMapper().writeValueAsString(changePasswordRequest);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
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
  @Tag("MaintainedByDiffblue")
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
    requestBuilder.accept("https://example.org/example");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(406));
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
  @Tag("MaintainedByDiffblue")
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
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(
            MockMvcResultMatchers.content()
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
   *   <li>Then status four hundred fifteen.
   * </ul>
   *
   * <p>Method under test: {@link
   * AuthController#requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)}
   */
  @Test
  @DisplayName(
      "Test requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest); then status four hundred fifteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AuthController.requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)"
  })
  void testRequestResetPasswordByEmail_thenStatusFourHundredFifteen() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/noauth/resetPasswordByEmail");
    postResult.characterEncoding("https://example.org/example");

    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");
    String content = new ObjectMapper().writeValueAsString(resetPasswordEmailRequest);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AuthController.requestResetPasswordByEmail(ResetPasswordEmailRequest, HttpServletRequest)"
  })
  void testRequestResetPasswordByEmail_thenStatusIsOk() throws Exception {
    // Arrange
    ResetPasswordEmailRequest resetPasswordEmailRequest = new ResetPasswordEmailRequest();
    resetPasswordEmailRequest.setEmail("jane.doe@example.org");
    String content = new ObjectMapper().writeValueAsString(resetPasswordEmailRequest);
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/noauth/resetPasswordByEmail")
            .contentType(MediaType.APPLICATION_JSON)
            .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Test {@link AuthController#resetPassword(ResetPasswordRequest, HttpServletRequest)}.
   *
   * <p>Method under test: {@link AuthController#resetPassword(ResetPasswordRequest,
   * HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resetPassword(ResetPasswordRequest, HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.security.model.JwtPair AuthController.resetPassword(ResetPasswordRequest, HttpServletRequest)"
  })
  void testResetPassword() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/noauth/resetPassword");
    postResult.characterEncoding("https://example.org/example");

    ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
    resetPasswordRequest.setPassword("iloveyou");
    resetPasswordRequest.setResetToken("ABC123");
    String content = new ObjectMapper().writeValueAsString(resetPasswordRequest);
    MockHttpServletRequestBuilder requestBuilder =
        postResult.contentType(MediaType.APPLICATION_JSON).content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(authController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }
}
