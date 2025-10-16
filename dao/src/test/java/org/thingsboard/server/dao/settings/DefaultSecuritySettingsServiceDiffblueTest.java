/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultSecuritySettingsServiceDiffblueTest {
  @MockBean private AdminSettingsService adminSettingsService;

  @Autowired private DefaultSecuritySettingsService defaultSecuritySettingsService;

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings2() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings4() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    adminSettings.setJsonValue(new ArrayNode(nf));
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings5() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    adminSettings.setJsonValue(new ArrayNode(nf, 3));
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings6() throws UnsupportedEncodingException {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(new BinaryNode("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings7() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonValue = new ArrayNode(nf);
    jsonValue.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);

    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new DefaultSecuritySettingsService(adminSettingsService).getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings8() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonValue = new ArrayNode(nf);
    jsonValue.addPOJO("Pojo");
    jsonValue.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);

    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new DefaultSecuritySettingsService(adminSettingsService).getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Given {@link AdminSettings#AdminSettings()} JsonValue is Instance.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_givenAdminSettingsJsonValueIsInstance_thenReturnNull() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(MissingNode.getInstance());

    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    SecuritySettings actualSecuritySettings =
        new DefaultSecuritySettingsService(adminSettingsService).getSecuritySettings();

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    assertNull(actualSecuritySettings);
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)}
   *       does nothing.
   *   <li>Then calls {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_givenArrayNodeSerializeDoesNothing_thenCallsSerialize()
      throws IOException {
    // Arrange
    ArrayNode jsonValue = mock(ArrayNode.class);
    doNothing()
        .when(jsonValue)
        .serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());

    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(jsonValue);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(jsonValue).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#serialize(JsonGenerator, SerializerProvider)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_givenArrayNodeSerializeThrowRuntimeException()
      throws IOException {
    // Arrange
    ArrayNode jsonValue = mock(ArrayNode.class);
    doThrow(new RuntimeException())
        .when(jsonValue)
        .serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());

    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(jsonValue);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(jsonValue).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addArray.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_givenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonValue = new ArrayNode(nf);
    jsonValue.addArray();
    jsonValue.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);

    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new DefaultSecuritySettingsService(adminSettingsService).getSecuritySettings());
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayNode#elements()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_thenCallsElements() throws IOException {
    // Arrange
    ArrayNode value = mock(ArrayNode.class);
    when(value.elements()).thenThrow(new RuntimeException());
    doThrow(new RuntimeException())
        .when(value)
        .serialize(Mockito.<JsonGenerator>any(), Mockito.<SerializerProvider>any());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode jsonValue = new ArrayNode(nf);
    jsonValue.add(value);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);

    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> new DefaultSecuritySettingsService(adminSettingsService).getSecuritySettings());
    verify(value).elements();
    verify(value).serialize(isA(JsonGenerator.class), isA(SerializerProvider.class));
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_thenCallsGetJsonValue() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenThrow(new RuntimeException());
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultSecuritySettingsService.getSecuritySettings());
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Then return MaxFailedLoginAttempts is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_thenReturnMaxFailedLoginAttemptsIsNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    SecuritySettings actualSecuritySettings = defaultSecuritySettingsService.getSecuritySettings();

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
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
    assertEquals(
        DefaultSecuritySettingsService.DEFAULT_MOBILE_SECRET_KEY_LENGTH,
        actualSecuritySettings.getMobileSecretKeyLength().intValue());
  }

  /**
   * Test {@link DefaultSecuritySettingsService#getSecuritySettings()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultSecuritySettingsService#getSecuritySettings()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SecuritySettings DefaultSecuritySettingsService.getSecuritySettings()"})
  public void testGetSecuritySettings_thenReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act
    SecuritySettings actualSecuritySettings = defaultSecuritySettingsService.getSecuritySettings();

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    assertNull(actualSecuritySettings);
  }

  /**
   * Test {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   *
   * <p>Method under test: {@link
   * DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecuritySettings DefaultSecuritySettingsService.saveSecuritySettings(SecuritySettings)"
  })
  public void testSaveSecuritySettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(
            Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
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
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    assertEquals(securitySettings, defaultSecuritySettingsService.getSecuritySettings());
  }

  /**
   * Test {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   *
   * <p>Method under test: {@link
   * DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecuritySettings DefaultSecuritySettingsService.saveSecuritySettings(SecuritySettings)"
  })
  public void testSaveSecuritySettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

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
        RuntimeException.class,
        () -> defaultSecuritySettingsService.saveSecuritySettings(securitySettings));
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   *
   * <p>Method under test: {@link
   * DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecuritySettings DefaultSecuritySettingsService.saveSecuritySettings(SecuritySettings)"
  })
  public void testSaveSecuritySettings3() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings(new AdminSettings());
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(
            Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
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
    assertThrows(
        RuntimeException.class,
        () -> defaultSecuritySettingsService.saveSecuritySettings(securitySettings));
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   *
   * <p>Method under test: {@link
   * DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecuritySettings DefaultSecuritySettingsService.saveSecuritySettings(SecuritySettings)"
  })
  public void testSaveSecuritySettings4() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(adminSettingsService.saveAdminSettings(
            Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
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
    SecuritySettings actualSaveSecuritySettingsResult =
        defaultSecuritySettingsService.saveSecuritySettings(securitySettings);

    // Assert
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    SecuritySettings securitySettings2 = defaultSecuritySettingsService.getSecuritySettings();
    assertNull(securitySettings2.getMaxFailedLoginAttempts());
    assertNull(securitySettings2.getUserLockoutNotificationEmail());
    assertNull(actualSaveSecuritySettingsResult);
    assertEquals(24, securitySettings2.getPasswordResetTokenTtl().intValue());
    assertEquals(24, securitySettings2.getUserActivationTokenTtl().intValue());
    assertEquals(
        DefaultSecuritySettingsService.DEFAULT_MOBILE_SECRET_KEY_LENGTH,
        securitySettings2.getMobileSecretKeyLength().intValue());
  }

  /**
   * Test {@link DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#setJsonValue(JsonNode)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultSecuritySettingsService#saveSecuritySettings(SecuritySettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SecuritySettings DefaultSecuritySettingsService.saveSecuritySettings(SecuritySettings)"
  })
  public void testSaveSecuritySettings_thenCallsSetJsonValue() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new RuntimeException()).when(adminSettings).setJsonValue(Mockito.<JsonNode>any());
    when(adminSettingsService.findAdminSettingsByKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
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
    assertThrows(
        RuntimeException.class,
        () -> defaultSecuritySettingsService.saveSecuritySettings(securitySettings));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(adminSettingsService)
        .findAdminSettingsByKey(isA(TenantId.class), eq("securitySettings"));
  }
}
