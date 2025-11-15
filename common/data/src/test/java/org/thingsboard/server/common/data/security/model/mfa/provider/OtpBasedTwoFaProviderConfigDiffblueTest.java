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
package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OtpBasedTwoFaProviderConfigDiffblueTest {
  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new EmailTwoFaProviderConfig()).canEqual("Other"));
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    // Act and Assert
    assertTrue(emailTwoFaProviderConfig.canEqual(new EmailTwoFaProviderConfig()));
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = new EmailTwoFaProviderConfig();

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig2.hashCode());
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig.hashCode());
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, smsTwoFaProviderConfig);
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = mock(EmailTwoFaProviderConfig.class);
    when(emailTwoFaProviderConfig2.getVerificationCodeLifetime()).thenReturn(1);
    when(emailTwoFaProviderConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaProviderConfig(), null);
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaProviderConfig(), "Different type to OtpBasedTwoFaProviderConfig");
  }

  /**
   * Method under test:
   * {@link OtpBasedTwoFaProviderConfig#getVerificationCodeLifetime()}
   */
  @Test
  void testGetVerificationCodeLifetime() {
    // Arrange, Act and Assert
    assertEquals(0, (new EmailTwoFaProviderConfig()).getVerificationCodeLifetime());
  }

  /**
   * Method under test:
   * {@link OtpBasedTwoFaProviderConfig#setVerificationCodeLifetime(int)}
   */
  @Test
  void testSetVerificationCodeLifetime() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    // Act
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Assert
    assertEquals(1, emailTwoFaProviderConfig.getVerificationCodeLifetime());
  }

  /**
   * Method under test: {@link OtpBasedTwoFaProviderConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EmailTwoFaProviderConfig()", (new EmailTwoFaProviderConfig()).toString());
  }
}
