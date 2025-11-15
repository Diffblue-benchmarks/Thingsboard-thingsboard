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
package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OtpBasedTwoFaAccountConfigDiffblueTest {
  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new EmailTwoFaAccountConfig()).canEqual("Other"));
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertTrue(emailTwoFaAccountConfig.canEqual(new EmailTwoFaAccountConfig()));
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
    int expectedHashCodeResult = emailTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaAccountConfig2.hashCode());
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig);
    int expectedHashCodeResult = emailTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaAccountConfig.hashCode());
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, backupCodeTwoFaAccountConfig);
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = mock(EmailTwoFaAccountConfig.class);
    when(emailTwoFaAccountConfig2.isUseByDefault()).thenReturn(true);
    when(emailTwoFaAccountConfig2.getEmail()).thenReturn("jane.doe@example.org");
    when(emailTwoFaAccountConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaAccountConfig(), null);
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaAccountConfig(), "Different type to OtpBasedTwoFaAccountConfig");
  }

  /**
   * Method under test: {@link OtpBasedTwoFaAccountConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EmailTwoFaAccountConfig(email=null)", (new EmailTwoFaAccountConfig()).toString());
  }
}
