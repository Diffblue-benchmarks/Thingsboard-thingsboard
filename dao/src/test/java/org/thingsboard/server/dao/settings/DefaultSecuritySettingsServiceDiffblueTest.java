package org.thingsboard.server.dao.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

@ContextConfiguration(classes = {DefaultSecuritySettingsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DefaultSecuritySettingsServiceDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @Autowired
  private DefaultSecuritySettingsService defaultSecuritySettingsService;

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    SecuritySettings actualSecuritySettings = defaultSecuritySettingsService.getSecuritySettings();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    assertNull(actualSecuritySettings);
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings2() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings3() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings4() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3));
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings5() throws IOException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    doThrow(new RuntimeException("securitySettings")).when(arrayNode)
        .serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(arrayNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings6() {
    // Arrange
    ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    arrayNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings_givenAdminSettingsGetJsonValueReturnInstance() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    SecuritySettings actualSecuritySettings = defaultSecuritySettingsService.getSecuritySettings();

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    assertNull(actualSecuritySettings);
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <ul>
   *   <li>Given {@link ArrayNode}
   * {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings_givenArrayNodeSerializeDoesNothing_thenCallsSerialize() throws IOException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    doNothing().when(arrayNode).serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(arrayNode).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   * <ul>
   *   <li>Then return MaxFailedLoginAttempts is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  public void testGetSecuritySettings_thenReturnMaxFailedLoginAttemptsIsNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    SecuritySettings actualSecuritySettings = defaultSecuritySettingsService.getSecuritySettings();

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    assertNull(actualSecuritySettings.getMaxFailedLoginAttempts());
    UserPasswordPolicy passwordPolicy = actualSecuritySettings.getPasswordPolicy();
    assertNull(passwordPolicy.getMinimumDigits());
    assertNull(passwordPolicy.getMinimumLowercaseLetters());
    assertNull(passwordPolicy.getMinimumSpecialCharacters());
    assertNull(passwordPolicy.getMinimumUppercaseLetters());
    assertNull(passwordPolicy.getPasswordExpirationPeriodDays());
    assertNull(passwordPolicy.getPasswordReuseFrequencyDays());
    assertNull(actualSecuritySettings.getUserLockoutNotificationEmail());
    assertEquals(24, actualSecuritySettings.getPasswordResetTokenTtl().intValue());
    assertEquals(24, actualSecuritySettings.getUserActivationTokenTtl().intValue());
    assertEquals(6, passwordPolicy.getMinimumLength().intValue());
    assertEquals(72, passwordPolicy.getMaximumLength().intValue());
    assertFalse(passwordPolicy.getForceUserToResetPasswordIfNotValid());
    assertTrue(passwordPolicy.getAllowWhitespaces());
    assertEquals(DefaultSecuritySettingsService.DEFAULT_MOBILE_SECRET_KEY_LENGTH,
        actualSecuritySettings.getMobileSecretKeyLength().intValue());
  }

  /**
   * Test
   * {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  public void testSaveSecuritySettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

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

    // Act
    defaultSecuritySettingsService.saveSecuritySettings(securitySettings);

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    assertEquals(securitySettings, defaultSecuritySettingsService.getSecuritySettings());
  }

  /**
   * Test
   * {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  public void testSaveSecuritySettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

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

    // Act
    SecuritySettings actualSaveSecuritySettingsResult = defaultSecuritySettingsService
        .saveSecuritySettings(securitySettings);

    // Assert
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    SecuritySettings securitySettings2 = defaultSecuritySettingsService.getSecuritySettings();
    assertNull(securitySettings2.getMaxFailedLoginAttempts());
    assertNull(securitySettings2.getUserLockoutNotificationEmail());
    assertNull(actualSaveSecuritySettingsResult);
    assertEquals(24, securitySettings2.getPasswordResetTokenTtl().intValue());
    assertEquals(24, securitySettings2.getUserActivationTokenTtl().intValue());
    assertEquals(DefaultSecuritySettingsService.DEFAULT_MOBILE_SECRET_KEY_LENGTH,
        securitySettings2.getMobileSecretKeyLength().intValue());
  }

  /**
   * Test
   * {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  public void testSaveSecuritySettings_thenThrowRuntimeException() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new RuntimeException("foo")).when(adminSettings).setJsonValue(Mockito.<JsonNode>any());
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

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
    assertThrows(RuntimeException.class, () -> defaultSecuritySettingsService.saveSecuritySettings(securitySettings));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }
}
