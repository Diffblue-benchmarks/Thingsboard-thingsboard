package org.thingsboard.server.service.security.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.ContainerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.common.data.security.model.mfa.PlatformTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderConfig;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.service.security.auth.rest.RestAuthenticationDetails;
import org.thingsboard.server.service.security.model.SecurityUser;
import ua_parser.Client;
import ua_parser.Device;
import ua_parser.OS;
import ua_parser.UserAgent;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {DefaultSystemSecurityService.class, BCryptPasswordEncoder.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultSystemSecurityServiceDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @MockBean
  private AuditLogService auditLogService;

  @Autowired
  private DefaultSystemSecurityService defaultSystemSecurityService;

  @MockBean
  private MailService mailService;

  @MockBean
  private SecuritySettingsService securitySettingsService;

  @MockBean
  private UserService userService;

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateUserCredentials(TenantId, UserCredentials, String, String)}.
   * <ul>
   *   <li>Given {@link SecuritySettings} (default constructor)
   * MaxFailedLoginAttempts is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateUserCredentials(TenantId, UserCredentials, String, String)}
   */
  @Test
  @DisplayName("Test validateUserCredentials(TenantId, UserCredentials, String, String); given SecuritySettings (default constructor) MaxFailedLoginAttempts is three")
  void testValidateUserCredentials_givenSecuritySettingsMaxFailedLoginAttemptsIsThree() throws AuthenticationException {
    // Arrange
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> defaultSystemSecurityService.validateUserCredentials(tenantId,
        new UserCredentials(), "janedoe", "iloveyou"));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateUserCredentials(TenantId, UserCredentials, String, String)}.
   * <ul>
   *   <li>Then calls {@link SecuritySettings#getMaxFailedLoginAttempts()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateUserCredentials(TenantId, UserCredentials, String, String)}
   */
  @Test
  @DisplayName("Test validateUserCredentials(TenantId, UserCredentials, String, String); then calls getMaxFailedLoginAttempts()")
  void testValidateUserCredentials_thenCallsGetMaxFailedLoginAttempts() throws AuthenticationException {
    // Arrange
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);

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
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getMaxFailedLoginAttempts()).thenReturn(-1);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> defaultSystemSecurityService.validateUserCredentials(tenantId,
        new UserCredentials(), "janedoe", "iloveyou"));
    verify(securitySettings, atLeast(1)).getMaxFailedLoginAttempts();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateUserCredentials(TenantId, UserCredentials, String, String)}.
   * <ul>
   *   <li>Then throw {@link LockedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateUserCredentials(TenantId, UserCredentials, String, String)}
   */
  @Test
  @DisplayName("Test validateUserCredentials(TenantId, UserCredentials, String, String); then throw LockedException")
  void testValidateUserCredentials_thenThrowLockedException() throws AuthenticationException {
    // Arrange
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);
    when(securitySettingsService.getSecuritySettings()).thenThrow(new LockedException("Msg"));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.validateUserCredentials(tenantId,
        new UserCredentials(), "janedoe", "iloveyou"));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)")
  void testValidateTwoFaVerification() {
    // Arrange
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);
    SecurityUser securityUser = new SecurityUser();

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act
    defaultSystemSecurityService.validateTwoFaVerification(securityUser, false, twoFaSettings);

    // Assert that nothing has changed
    verify(userService).increaseFailedLoginAttempts(isNull(), isNull());
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)")
  void testValidateTwoFaVerification2() throws ThingsboardException {
    // Arrange
    doNothing().when(userService)
        .setUserCredentialsEnabled(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyBoolean());
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(3);
    doThrow(new LockedException("User account was locked due to exceeded 2FA verification attempts")).when(mailService)
        .sendAccountLockoutEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Integer>any());

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
    SecurityUser securityUser = new SecurityUser();

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertThrows(LockedException.class,
        () -> defaultSystemSecurityService.validateTwoFaVerification(securityUser, false, twoFaSettings));
    verify(mailService).sendAccountLockoutEmail(isNull(), eq("jane.doe@example.org"), eq(3));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isNull(), isNull());
    verify(userService, atLeast(1)).setUserCredentialsEnabled(isA(TenantId.class), isNull(), eq(false));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)")
  void testValidateTwoFaVerification3() throws ThingsboardException {
    // Arrange
    doNothing().when(userService)
        .setUserCredentialsEnabled(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyBoolean());
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(3);
    doThrow(new ThingsboardException(ThingsboardErrorCode.GENERAL)).when(mailService)
        .sendAccountLockoutEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Integer>any());

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
    SecurityUser securityUser = new SecurityUser();

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertThrows(LockedException.class,
        () -> defaultSystemSecurityService.validateTwoFaVerification(securityUser, false, twoFaSettings));
    verify(mailService).sendAccountLockoutEmail(isNull(), eq("jane.doe@example.org"), eq(3));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isNull(), isNull());
    verify(userService, atLeast(1)).setUserCredentialsEnabled(isA(TenantId.class), isNull(), eq(false));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)")
  void testValidateTwoFaVerification4() {
    // Arrange
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(3);

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
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    SecurityUser securityUser = new SecurityUser();
    PlatformTwoFaSettings twoFaSettings = mock(PlatformTwoFaSettings.class);
    when(twoFaSettings.getMaxVerificationFailuresBeforeUserLockout()).thenReturn(-1);
    doNothing().when(twoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(twoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(twoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(twoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(twoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act
    defaultSystemSecurityService.validateTwoFaVerification(securityUser, false, twoFaSettings);

    // Assert that nothing has changed
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(twoFaSettings).getMaxVerificationFailuresBeforeUserLockout();
    verify(twoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(twoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(twoFaSettings).setProviders(isA(List.class));
    verify(twoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(twoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).increaseFailedLoginAttempts(isNull(), isNull());
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <ul>
   *   <li>Given {@link MailService}
   * {@link MailService#sendAccountLockoutEmail(String, String, Integer)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings); given MailService sendAccountLockoutEmail(String, String, Integer) does nothing")
  void testValidateTwoFaVerification_givenMailServiceSendAccountLockoutEmailDoesNothing() throws ThingsboardException {
    // Arrange
    doNothing().when(userService)
        .setUserCredentialsEnabled(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyBoolean());
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(3);
    doNothing().when(mailService)
        .sendAccountLockoutEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<Integer>any());

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
    SecurityUser securityUser = new SecurityUser();

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertThrows(LockedException.class,
        () -> defaultSystemSecurityService.validateTwoFaVerification(securityUser, false, twoFaSettings));
    verify(mailService).sendAccountLockoutEmail(isNull(), eq("jane.doe@example.org"), eq(3));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isNull(), isNull());
    verify(userService, atLeast(1)).setUserCredentialsEnabled(isA(TenantId.class), isNull(), eq(false));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <ul>
   *   <li>Then calls
   * {@link SecuritySettings#getUserLockoutNotificationEmail()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings); then calls getUserLockoutNotificationEmail()")
  void testValidateTwoFaVerification_thenCallsGetUserLockoutNotificationEmail() {
    // Arrange
    doNothing().when(userService)
        .setUserCredentialsEnabled(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyBoolean());
    when(userService.increaseFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(3);

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
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getUserLockoutNotificationEmail()).thenReturn("");
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);
    SecurityUser securityUser = new SecurityUser();

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertThrows(LockedException.class,
        () -> defaultSystemSecurityService.validateTwoFaVerification(securityUser, false, twoFaSettings));
    verify(securitySettings).getUserLockoutNotificationEmail();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(securitySettingsService).getSecuritySettings();
    verify(userService).increaseFailedLoginAttempts(isNull(), isNull());
    verify(userService, atLeast(1)).setUserCredentialsEnabled(isA(TenantId.class), isNull(), eq(false));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}.
   * <ul>
   *   <li>Then calls
   * {@link UserService#resetFailedLoginAttempts(TenantId, UserId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings)}
   */
  @Test
  @DisplayName("Test validateTwoFaVerification(SecurityUser, boolean, PlatformTwoFaSettings); then calls resetFailedLoginAttempts(TenantId, UserId)")
  void testValidateTwoFaVerification_thenCallsResetFailedLoginAttempts() {
    // Arrange
    doNothing().when(userService).resetFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any());
    SecurityUser securityUser = new SecurityUser();

    PlatformTwoFaSettings twoFaSettings = new PlatformTwoFaSettings();
    twoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    twoFaSettings.setMinVerificationCodeSendPeriod(3);
    twoFaSettings.setProviders(new ArrayList<>());
    twoFaSettings.setTotalAllowedTimeForVerification(1);
    twoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act
    defaultSystemSecurityService.validateTwoFaVerification(securityUser, true, twoFaSettings);

    // Assert that nothing has changed
    verify(userService).resetFailedLoginAttempts(isNull(), isNull());
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials)")
  void testValidatePassword() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(-1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy).getMinimumLowercaseLetters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials)")
  void testValidatePassword2() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(-1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(userPasswordPolicy).getMinimumSpecialCharacters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials)")
  void testValidatePassword3() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(-1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(userPasswordPolicy).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <ul>
   *   <li>Given {@link SecuritySettings} (default constructor)
   * MaxFailedLoginAttempts is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials); given SecuritySettings (default constructor) MaxFailedLoginAttempts is three")
  void testValidatePassword_givenSecuritySettingsMaxFailedLoginAttemptsIsThree() throws DataValidationException {
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <ul>
   *   <li>Given {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getAllowWhitespaces()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials); given UserPasswordPolicy getAllowWhitespaces() return 'false'")
  void testValidatePassword_givenUserPasswordPolicyGetAllowWhitespacesReturnFalse() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(false);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <ul>
   *   <li>Given {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getMinimumDigits()} return minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials); given UserPasswordPolicy getMinimumDigits() return minus one")
  void testValidatePassword_givenUserPasswordPolicyGetMinimumDigitsReturnMinusOne() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(-1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <ul>
   *   <li>Given {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getMinimumLength()} return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials); given UserPasswordPolicy getMinimumLength() return one")
  void testValidatePassword_givenUserPasswordPolicyGetMinimumLengthReturnOne() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("iloveyou", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePassword(String, UserCredentials)}
   */
  @Test
  @DisplayName("Test validatePassword(String, UserCredentials); when empty string")
  void testValidatePassword_whenEmptyString() throws DataValidationException {
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
    UserPasswordPolicy userPasswordPolicy = mock(UserPasswordPolicy.class);
    when(userPasswordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(userPasswordPolicy.getMaximumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumDigits()).thenReturn(1);
    when(userPasswordPolicy.getMinimumLength()).thenReturn(3);
    when(userPasswordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(userPasswordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(userPasswordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(userPasswordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(userPasswordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);
    SecuritySettings securitySettings = mock(SecuritySettings.class);
    when(securitySettings.getPasswordPolicy()).thenReturn(userPasswordPolicy);
    doNothing().when(securitySettings).setMaxFailedLoginAttempts(Mockito.<Integer>any());
    doNothing().when(securitySettings).setMobileSecretKeyLength(Mockito.<Integer>any());
    doNothing().when(securitySettings).setPasswordPolicy(Mockito.<UserPasswordPolicy>any());
    doNothing().when(securitySettings).setPasswordResetTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserActivationTokenTtl(Mockito.<Integer>any());
    doNothing().when(securitySettings).setUserLockoutNotificationEmail(Mockito.<String>any());
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePassword("", new UserCredentials()));
    verify(securitySettings).getPasswordPolicy();
    verify(securitySettings).setMaxFailedLoginAttempts(eq(3));
    verify(securitySettings).setMobileSecretKeyLength(eq(3));
    verify(securitySettings).setPasswordPolicy(isA(UserPasswordPolicy.class));
    verify(securitySettings).setPasswordResetTokenTtl(eq(1));
    verify(securitySettings).setUserActivationTokenTtl(eq(1));
    verify(securitySettings).setUserLockoutNotificationEmail(eq("jane.doe@example.org"));
    verify(userPasswordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(userPasswordPolicy).getMaximumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumDigits();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLength();
    verify(userPasswordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(userPasswordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(userPasswordPolicy).setAllowWhitespaces(eq(true));
    verify(userPasswordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(userPasswordPolicy).setMaximumLength(eq(3));
    verify(userPasswordPolicy).setMinimumDigits(eq(1));
    verify(userPasswordPolicy).setMinimumLength(eq(3));
    verify(userPasswordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(userPasswordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(userPasswordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(userPasswordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(userPasswordPolicy).setPasswordReuseFrequencyDays(eq(1));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy)")
  void testValidatePasswordByPolicy() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(0);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy)")
  void testValidatePasswordByPolicy2() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(0);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy)")
  void testValidatePasswordByPolicy3() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(0);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); given 'false'")
  void testValidatePasswordByPolicy_givenFalse() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(false);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>Given {@link Integer#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); given MAX_VALUE")
  void testValidatePasswordByPolicy_givenMax_value() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(Integer.MAX_VALUE);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when empty string; then throw DataValidationException")
  void testValidatePasswordByPolicy_whenEmptyString_thenThrowDataValidationException() {
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("", passwordPolicy));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When lf.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when lf; then throw DataValidationException")
  void testValidatePasswordByPolicy_whenLf_thenThrowDataValidationException() {
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("\n", passwordPolicy));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When {@link UserPasswordPolicy} (default constructor) AllowWhitespaces is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when UserPasswordPolicy (default constructor) AllowWhitespaces is 'true'")
  void testValidatePasswordByPolicy_whenUserPasswordPolicyAllowWhitespacesIsTrue() {
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getAllowWhitespaces()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when UserPasswordPolicy getAllowWhitespaces() return 'null'")
  void testValidatePasswordByPolicy_whenUserPasswordPolicyGetAllowWhitespacesReturnNull() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(null);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getMaximumLength()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when UserPasswordPolicy getMaximumLength() return 'null'")
  void testValidatePasswordByPolicy_whenUserPasswordPolicyGetMaximumLengthReturnNull() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(null);
    when(passwordPolicy.getMinimumDigits()).thenReturn(1);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumDigits();
    verify(passwordPolicy).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getMinimumDigits()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when UserPasswordPolicy getMinimumDigits() return 'null'")
  void testValidatePasswordByPolicy_whenUserPasswordPolicyGetMinimumDigitsReturnNull() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(null);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}.
   * <ul>
   *   <li>When {@link UserPasswordPolicy}
   * {@link UserPasswordPolicy#getMinimumDigits()} return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#validatePasswordByPolicy(String, UserPasswordPolicy)}
   */
  @Test
  @DisplayName("Test validatePasswordByPolicy(String, UserPasswordPolicy); when UserPasswordPolicy getMinimumDigits() return zero")
  void testValidatePasswordByPolicy_whenUserPasswordPolicyGetMinimumDigitsReturnZero() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
    when(passwordPolicy.getAllowWhitespaces()).thenReturn(true);
    when(passwordPolicy.getMaximumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumDigits()).thenReturn(0);
    when(passwordPolicy.getMinimumLength()).thenReturn(3);
    when(passwordPolicy.getMinimumLowercaseLetters()).thenReturn(1);
    when(passwordPolicy.getMinimumSpecialCharacters()).thenReturn(1);
    when(passwordPolicy.getMinimumUppercaseLetters()).thenReturn(1);
    doNothing().when(passwordPolicy).setAllowWhitespaces(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setForceUserToResetPasswordIfNotValid(Mockito.<Boolean>any());
    doNothing().when(passwordPolicy).setMaximumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumDigits(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLength(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumLowercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumSpecialCharacters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setMinimumUppercaseLetters(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordExpirationPeriodDays(Mockito.<Integer>any());
    doNothing().when(passwordPolicy).setPasswordReuseFrequencyDays(Mockito.<Integer>any());
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

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultSystemSecurityService.validatePasswordByPolicy("iloveyou", passwordPolicy));
    verify(passwordPolicy, atLeast(1)).getAllowWhitespaces();
    verify(passwordPolicy).getMaximumLength();
    verify(passwordPolicy).getMinimumDigits();
    verify(passwordPolicy, atLeast(1)).getMinimumLength();
    verify(passwordPolicy, atLeast(1)).getMinimumLowercaseLetters();
    verify(passwordPolicy, atLeast(1)).getMinimumSpecialCharacters();
    verify(passwordPolicy, atLeast(1)).getMinimumUppercaseLetters();
    verify(passwordPolicy).setAllowWhitespaces(eq(true));
    verify(passwordPolicy).setForceUserToResetPasswordIfNotValid(eq(true));
    verify(passwordPolicy).setMaximumLength(eq(3));
    verify(passwordPolicy).setMinimumDigits(eq(1));
    verify(passwordPolicy).setMinimumLength(eq(3));
    verify(passwordPolicy).setMinimumLowercaseLetters(eq(1));
    verify(passwordPolicy).setMinimumSpecialCharacters(eq(1));
    verify(passwordPolicy).setMinimumUppercaseLetters(eq(1));
    verify(passwordPolicy).setPasswordExpirationPeriodDays(eq(1));
    verify(passwordPolicy).setPasswordReuseFrequencyDays(eq(1));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getBaseUrl(TenantId, CustomerId, HttpServletRequest)")
  void testGetBaseUrl() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    String actualBaseUrl = defaultSystemSecurityService.getBaseUrl(tenantId, customerId, new MockHttpServletRequest());

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("general"));
    assertEquals("http://localhost:80", actualBaseUrl);
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getBaseUrl(TenantId, CustomerId, HttpServletRequest); given AdminSettings getJsonValue() return Instance")
  void testGetBaseUrl_givenAdminSettingsGetJsonValueReturnInstance() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    String actualBaseUrl = defaultSystemSecurityService.getBaseUrl(tenantId, customerId, new MockHttpServletRequest());

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("general"));
    assertEquals("http://localhost:80", actualBaseUrl);
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ContainerNode#asText()} return
   * {@code As Text}.</li>
   *   <li>Then return {@code As Text}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getBaseUrl(TenantId, CustomerId, HttpServletRequest); given ArrayNode asText() return 'As Text'; then return 'As Text'")
  void testGetBaseUrl_givenArrayNodeAsTextReturnAsText_thenReturnAsText() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asText()).thenReturn("As Text");
    when(arrayNode.asBoolean()).thenReturn(true);
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode2);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    String actualBaseUrl = defaultSystemSecurityService.getBaseUrl(tenantId, customerId, new MockHttpServletRequest());

    // Assert
    verify(arrayNode).asBoolean();
    verify(arrayNode2, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode).asText();
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("general"));
    assertEquals("As Text", actualBaseUrl);
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ContainerNode#asText()} return empty
   * string.</li>
   *   <li>Then calls {@link JsonNode#asBoolean()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getBaseUrl(TenantId, CustomerId, HttpServletRequest); given ArrayNode asText() return empty string; then calls asBoolean()")
  void testGetBaseUrl_givenArrayNodeAsTextReturnEmptyString_thenCallsAsBoolean() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asText()).thenReturn("");
    when(arrayNode.asBoolean()).thenReturn(true);
    ArrayNode arrayNode2 = mock(ArrayNode.class);
    when(arrayNode2.get(Mockito.<String>any())).thenReturn(arrayNode);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode2);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    String actualBaseUrl = defaultSystemSecurityService.getBaseUrl(tenantId, customerId, new MockHttpServletRequest());

    // Assert
    verify(arrayNode).asBoolean();
    verify(arrayNode2, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode).asText();
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("general"));
    assertEquals("http://localhost:80", actualBaseUrl);
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#get(String)} return
   * Instance.</li>
   *   <li>Then return {@code http://localhost:80}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getBaseUrl(TenantId, CustomerId, HttpServletRequest); given ArrayNode get(String) return Instance; then return 'http://localhost:80'")
  void testGetBaseUrl_givenArrayNodeGetReturnInstance_thenReturnHttpLocalhost80() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    String actualBaseUrl = defaultSystemSecurityService.getBaseUrl(tenantId, customerId, new MockHttpServletRequest());

    // Assert
    verify(arrayNode).get(eq("prohibitDifferentUrl"));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("general"));
    assertEquals("http://localhost:80", actualBaseUrl);
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#getBaseUrl(TenantId, CustomerId, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test getBaseUrl(TenantId, CustomerId, HttpServletRequest); then return '1'")
  void testGetBaseUrl_thenReturn1() {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    String actualBaseUrl = defaultSystemSecurityService.getBaseUrl(tenantId, customerId, new MockHttpServletRequest());

    // Assert
    verify(arrayNode, atLeast(1)).get(Mockito.<String>any());
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("general"));
    assertEquals("1", actualBaseUrl);
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultSystemSecurityService.logLoginAction(user, "Authentication Details", ActionType.ADDED, new Exception("foo"));

    // Assert
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE2() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        "Authentication Details", ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE3() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE4() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE5() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", null, "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE6() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", null, "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE7() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", null);

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE8() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", null, "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE9() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", null, "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE10() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", null, "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE11() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", null);

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code e}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, Exception) with 'user', 'authenticationDetails', 'actionType', 'e'; given 'null'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeE_givenNull() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    when(restAuthenticationDetails.getUserAgent()).thenReturn(null);

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    User user = new User();

    // Act
    defaultSystemSecurityService.logLoginAction(user, "Authentication Details", ActionType.ADDED, "Provider",
        new Exception("foo"));

    // Assert
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE2() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        "Authentication Details", ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE3() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = new RestAuthenticationDetails(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE4() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE5() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", null, "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE6() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", null, "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE7() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", null);

    OS os = new OS("Family", "Major", "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE8() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", null, "Minor", "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE9() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", null, "Patch", "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE10() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", null, "Patch Minor");

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE11() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    UserAgent userAgent = new UserAgent("Family", "Major", "Minor", "Patch");

    OS os = new OS("Family", "Major", "Minor", "Patch", null);

    when(restAuthenticationDetails.getUserAgent()).thenReturn(new Client(userAgent, os, new Device("Family")));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails, atLeast(1)).getUserAgent();
  }

  /**
   * Test
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   * with {@code user}, {@code authenticationDetails}, {@code actionType},
   * {@code provider}, {@code e}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemSecurityService#logLoginAction(User, Object, ActionType, String, Exception)}
   */
  @Test
  @DisplayName("Test logLoginAction(User, Object, ActionType, String, Exception) with 'user', 'authenticationDetails', 'actionType', 'provider', 'e'; given 'null'")
  void testLogLoginActionWithUserAuthenticationDetailsActionTypeProviderE_givenNull() {
    // Arrange
    when(auditLogService.logEntityAction(Mockito.<TenantId>any(), Mockito.<CustomerId>any(), Mockito.<UserId>any(),
        Mockito.<String>any(), Mockito.<EntityId>any(), Mockito.<HasName>any(), Mockito.<ActionType>any(),
        Mockito.<Exception>any(), isA(Object[].class))).thenThrow(new LockedException("Unknown"));
    User user = new User();
    RestAuthenticationDetails restAuthenticationDetails = mock(RestAuthenticationDetails.class);
    when(restAuthenticationDetails.getClientAddress()).thenReturn("42 Main St");
    when(restAuthenticationDetails.getUserAgent()).thenReturn(null);

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultSystemSecurityService.logLoginAction(user,
        restAuthenticationDetails, ActionType.ADDED, "Provider", new Exception("foo")));
    verify(auditLogService).logEntityAction(isNull(), isNull(), isNull(), isNull(), isNull(), isNull(),
        eq(ActionType.ADDED), isA(Exception.class), isA(Object[].class));
    verify(restAuthenticationDetails).getClientAddress();
    verify(restAuthenticationDetails).getUserAgent();
  }
}
