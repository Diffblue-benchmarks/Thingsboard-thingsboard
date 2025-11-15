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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UserPasswordPolicyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserPasswordPolicy#equals(Object)}
   *   <li>{@link UserPasswordPolicy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
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

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertEquals(userPasswordPolicy, userPasswordPolicy2);
    int expectedHashCodeResult = userPasswordPolicy.hashCode();
    assertEquals(expectedHashCodeResult, userPasswordPolicy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserPasswordPolicy#equals(Object)}
   *   <li>{@link UserPasswordPolicy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(null);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(null);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertEquals(userPasswordPolicy, userPasswordPolicy2);
    int expectedHashCodeResult = userPasswordPolicy.hashCode();
    assertEquals(expectedHashCodeResult, userPasswordPolicy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserPasswordPolicy#equals(Object)}
   *   <li>{@link UserPasswordPolicy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(null);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(null);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertEquals(userPasswordPolicy, userPasswordPolicy2);
    int expectedHashCodeResult = userPasswordPolicy.hashCode();
    assertEquals(expectedHashCodeResult, userPasswordPolicy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserPasswordPolicy#equals(Object)}
   *   <li>{@link UserPasswordPolicy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
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

    // Act and Assert
    assertEquals(userPasswordPolicy, userPasswordPolicy);
    int expectedHashCodeResult = userPasswordPolicy.hashCode();
    assertEquals(expectedHashCodeResult, userPasswordPolicy.hashCode());
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(false);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(null);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(false);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(null);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(1);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(null);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(3);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(null);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(1);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(null);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(3);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(null);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(3);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(null);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(3);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(null);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(3);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(null);
    userPasswordPolicy.setPasswordReuseFrequencyDays(1);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(3);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
    userPasswordPolicy.setAllowWhitespaces(true);
    userPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy.setMaximumLength(3);
    userPasswordPolicy.setMinimumDigits(1);
    userPasswordPolicy.setMinimumLength(3);
    userPasswordPolicy.setMinimumLowercaseLetters(1);
    userPasswordPolicy.setMinimumSpecialCharacters(1);
    userPasswordPolicy.setMinimumUppercaseLetters(1);
    userPasswordPolicy.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy.setPasswordReuseFrequencyDays(null);

    UserPasswordPolicy userPasswordPolicy2 = new UserPasswordPolicy();
    userPasswordPolicy2.setAllowWhitespaces(true);
    userPasswordPolicy2.setForceUserToResetPasswordIfNotValid(true);
    userPasswordPolicy2.setMaximumLength(3);
    userPasswordPolicy2.setMinimumDigits(1);
    userPasswordPolicy2.setMinimumLength(3);
    userPasswordPolicy2.setMinimumLowercaseLetters(1);
    userPasswordPolicy2.setMinimumSpecialCharacters(1);
    userPasswordPolicy2.setMinimumUppercaseLetters(1);
    userPasswordPolicy2.setPasswordExpirationPeriodDays(1);
    userPasswordPolicy2.setPasswordReuseFrequencyDays(1);

    // Act and Assert
    assertNotEquals(userPasswordPolicy, userPasswordPolicy2);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
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

    // Act and Assert
    assertNotEquals(userPasswordPolicy, null);
  }

  /**
   * Method under test: {@link UserPasswordPolicy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserPasswordPolicy userPasswordPolicy = new UserPasswordPolicy();
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

    // Act and Assert
    assertNotEquals(userPasswordPolicy, "Different type to UserPasswordPolicy");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserPasswordPolicy}
   *   <li>{@link UserPasswordPolicy#setAllowWhitespaces(Boolean)}
   *   <li>{@link UserPasswordPolicy#setForceUserToResetPasswordIfNotValid(Boolean)}
   *   <li>{@link UserPasswordPolicy#setMaximumLength(Integer)}
   *   <li>{@link UserPasswordPolicy#setMinimumDigits(Integer)}
   *   <li>{@link UserPasswordPolicy#setMinimumLength(Integer)}
   *   <li>{@link UserPasswordPolicy#setMinimumLowercaseLetters(Integer)}
   *   <li>{@link UserPasswordPolicy#setMinimumSpecialCharacters(Integer)}
   *   <li>{@link UserPasswordPolicy#setMinimumUppercaseLetters(Integer)}
   *   <li>{@link UserPasswordPolicy#setPasswordExpirationPeriodDays(Integer)}
   *   <li>{@link UserPasswordPolicy#setPasswordReuseFrequencyDays(Integer)}
   *   <li>{@link UserPasswordPolicy#toString()}
   *   <li>{@link UserPasswordPolicy#getAllowWhitespaces()}
   *   <li>{@link UserPasswordPolicy#getForceUserToResetPasswordIfNotValid()}
   *   <li>{@link UserPasswordPolicy#getMaximumLength()}
   *   <li>{@link UserPasswordPolicy#getMinimumDigits()}
   *   <li>{@link UserPasswordPolicy#getMinimumLength()}
   *   <li>{@link UserPasswordPolicy#getMinimumLowercaseLetters()}
   *   <li>{@link UserPasswordPolicy#getMinimumSpecialCharacters()}
   *   <li>{@link UserPasswordPolicy#getMinimumUppercaseLetters()}
   *   <li>{@link UserPasswordPolicy#getPasswordExpirationPeriodDays()}
   *   <li>{@link UserPasswordPolicy#getPasswordReuseFrequencyDays()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserPasswordPolicy actualUserPasswordPolicy = new UserPasswordPolicy();
    actualUserPasswordPolicy.setAllowWhitespaces(true);
    actualUserPasswordPolicy.setForceUserToResetPasswordIfNotValid(true);
    actualUserPasswordPolicy.setMaximumLength(3);
    actualUserPasswordPolicy.setMinimumDigits(1);
    actualUserPasswordPolicy.setMinimumLength(3);
    actualUserPasswordPolicy.setMinimumLowercaseLetters(1);
    actualUserPasswordPolicy.setMinimumSpecialCharacters(1);
    actualUserPasswordPolicy.setMinimumUppercaseLetters(1);
    actualUserPasswordPolicy.setPasswordExpirationPeriodDays(1);
    actualUserPasswordPolicy.setPasswordReuseFrequencyDays(1);
    String actualToStringResult = actualUserPasswordPolicy.toString();
    Boolean actualAllowWhitespaces = actualUserPasswordPolicy.getAllowWhitespaces();
    Boolean actualForceUserToResetPasswordIfNotValid = actualUserPasswordPolicy.getForceUserToResetPasswordIfNotValid();
    Integer actualMaximumLength = actualUserPasswordPolicy.getMaximumLength();
    Integer actualMinimumDigits = actualUserPasswordPolicy.getMinimumDigits();
    Integer actualMinimumLength = actualUserPasswordPolicy.getMinimumLength();
    Integer actualMinimumLowercaseLetters = actualUserPasswordPolicy.getMinimumLowercaseLetters();
    Integer actualMinimumSpecialCharacters = actualUserPasswordPolicy.getMinimumSpecialCharacters();
    Integer actualMinimumUppercaseLetters = actualUserPasswordPolicy.getMinimumUppercaseLetters();
    Integer actualPasswordExpirationPeriodDays = actualUserPasswordPolicy.getPasswordExpirationPeriodDays();
    Integer actualPasswordReuseFrequencyDays = actualUserPasswordPolicy.getPasswordReuseFrequencyDays();

    // Assert that nothing has changed
    assertEquals(
        "UserPasswordPolicy(minimumLength=3, maximumLength=3, minimumUppercaseLetters=1, minimumLowercaseLetters=1,"
            + " minimumDigits=1, minimumSpecialCharacters=1, allowWhitespaces=true, forceUserToResetPasswordIfNotValid=true,"
            + " passwordExpirationPeriodDays=1, passwordReuseFrequencyDays=1)",
        actualToStringResult);
    assertEquals(1, actualMinimumDigits.intValue());
    assertEquals(1, actualMinimumLowercaseLetters.intValue());
    assertEquals(1, actualMinimumSpecialCharacters.intValue());
    assertEquals(1, actualMinimumUppercaseLetters.intValue());
    assertEquals(1, actualPasswordExpirationPeriodDays.intValue());
    assertEquals(1, actualPasswordReuseFrequencyDays.intValue());
    assertEquals(3, actualMaximumLength.intValue());
    assertEquals(3, actualMinimumLength.intValue());
    assertTrue(actualAllowWhitespaces);
    assertTrue(actualForceUserToResetPasswordIfNotValid);
  }
}
