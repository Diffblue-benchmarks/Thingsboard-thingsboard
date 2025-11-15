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
package org.thingsboard.server.common.data.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SecuritySettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SecuritySettings#equals(Object)}
   *   <li>{@link SecuritySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertEquals(securitySettings, securitySettings2);
    int expectedHashCodeResult = securitySettings.hashCode();
    assertEquals(expectedHashCodeResult, securitySettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SecuritySettings#equals(Object)}
   *   <li>{@link SecuritySettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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

    // Act and Assert
    assertEquals(securitySettings, securitySettings);
    int expectedHashCodeResult = securitySettings.hashCode();
    assertEquals(expectedHashCodeResult, securitySettings.hashCode());
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    securitySettings.setMaxFailedLoginAttempts(1);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    securitySettings.setMaxFailedLoginAttempts(null);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
    securitySettings.setMobileSecretKeyLength(1);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
    securitySettings.setMobileSecretKeyLength(null);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
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

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
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

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(3);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
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

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(null);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
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

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(3);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserPasswordPolicy passwordPolicy = mock(UserPasswordPolicy.class);
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

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(null);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");

    UserPasswordPolicy passwordPolicy2 = new UserPasswordPolicy();
    passwordPolicy2.setAllowWhitespaces(true);
    passwordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy2.setMaximumLength(3);
    passwordPolicy2.setMinimumDigits(1);
    passwordPolicy2.setMinimumLength(3);
    passwordPolicy2.setMinimumLowercaseLetters(1);
    passwordPolicy2.setMinimumSpecialCharacters(1);
    passwordPolicy2.setMinimumUppercaseLetters(1);
    passwordPolicy2.setPasswordExpirationPeriodDays(1);
    passwordPolicy2.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings2 = new SecuritySettings();
    securitySettings2.setMaxFailedLoginAttempts(3);
    securitySettings2.setMobileSecretKeyLength(3);
    securitySettings2.setPasswordPolicy(passwordPolicy2);
    securitySettings2.setPasswordResetTokenTtl(1);
    securitySettings2.setUserActivationTokenTtl(1);
    securitySettings2.setUserLockoutNotificationEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(securitySettings, securitySettings2);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(securitySettings, null);
  }

  /**
   * Method under test: {@link SecuritySettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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

    // Act and Assert
    assertNotEquals(securitySettings, "Different type to SecuritySettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SecuritySettings}
   *   <li>{@link SecuritySettings#setMaxFailedLoginAttempts(Integer)}
   *   <li>{@link SecuritySettings#setMobileSecretKeyLength(Integer)}
   *   <li>{@link SecuritySettings#setPasswordPolicy(UserPasswordPolicy)}
   *   <li>{@link SecuritySettings#setPasswordResetTokenTtl(Integer)}
   *   <li>{@link SecuritySettings#setUserActivationTokenTtl(Integer)}
   *   <li>{@link SecuritySettings#setUserLockoutNotificationEmail(String)}
   *   <li>{@link SecuritySettings#toString()}
   *   <li>{@link SecuritySettings#getMaxFailedLoginAttempts()}
   *   <li>{@link SecuritySettings#getMobileSecretKeyLength()}
   *   <li>{@link SecuritySettings#getPasswordPolicy()}
   *   <li>{@link SecuritySettings#getPasswordResetTokenTtl()}
   *   <li>{@link SecuritySettings#getUserActivationTokenTtl()}
   *   <li>{@link SecuritySettings#getUserLockoutNotificationEmail()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SecuritySettings actualSecuritySettings = new SecuritySettings();
    actualSecuritySettings.setMaxFailedLoginAttempts(3);
    actualSecuritySettings.setMobileSecretKeyLength(3);
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
    actualSecuritySettings.setPasswordPolicy(passwordPolicy);
    actualSecuritySettings.setPasswordResetTokenTtl(1);
    actualSecuritySettings.setUserActivationTokenTtl(1);
    actualSecuritySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    String actualToStringResult = actualSecuritySettings.toString();
    Integer actualMaxFailedLoginAttempts = actualSecuritySettings.getMaxFailedLoginAttempts();
    Integer actualMobileSecretKeyLength = actualSecuritySettings.getMobileSecretKeyLength();
    UserPasswordPolicy actualPasswordPolicy = actualSecuritySettings.getPasswordPolicy();
    Integer actualPasswordResetTokenTtl = actualSecuritySettings.getPasswordResetTokenTtl();
    Integer actualUserActivationTokenTtl = actualSecuritySettings.getUserActivationTokenTtl();

    // Assert that nothing has changed
    assertEquals(
        "SecuritySettings(passwordPolicy=UserPasswordPolicy(minimumLength=3, maximumLength=3, minimumUppercaseLetters"
            + "=1, minimumLowercaseLetters=1, minimumDigits=1, minimumSpecialCharacters=1, allowWhitespaces=true,"
            + " forceUserToResetPasswordIfNotValid=true, passwordExpirationPeriodDays=1, passwordReuseFrequencyDays=1),"
            + " maxFailedLoginAttempts=3, userLockoutNotificationEmail=jane.doe@example.org, mobileSecretKeyLength=3,"
            + " userActivationTokenTtl=1, passwordResetTokenTtl=1)",
        actualToStringResult);
    assertEquals("jane.doe@example.org", actualSecuritySettings.getUserLockoutNotificationEmail());
    assertEquals(1, actualPasswordResetTokenTtl.intValue());
    assertEquals(1, actualUserActivationTokenTtl.intValue());
    assertEquals(3, actualMaxFailedLoginAttempts.intValue());
    assertEquals(3, actualMobileSecretKeyLength.intValue());
    assertSame(passwordPolicy, actualPasswordPolicy);
  }
}
