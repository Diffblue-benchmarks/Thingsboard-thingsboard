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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class EmailTwoFaProviderConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTwoFaProviderConfig#equals(Object)}
   *   <li>{@link EmailTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EmailTwoFaProviderConfig#equals(Object)}
   *   <li>{@link EmailTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig.hashCode());
  }

  /**
   * Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(3);

    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
  }

  /**
   * Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = mock(SmsTwoFaProviderConfig.class);
    doNothing().when(smsTwoFaProviderConfig).setVerificationCodeLifetime(anyInt());
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, smsTwoFaProviderConfig);
  }

  /**
   * Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, null);
  }

  /**
   * Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, "Different type to EmailTwoFaProviderConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTwoFaProviderConfig}
   *   <li>{@link EmailTwoFaProviderConfig#toString()}
   *   <li>{@link EmailTwoFaProviderConfig#getProviderType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EmailTwoFaProviderConfig actualEmailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    String actualToStringResult = actualEmailTwoFaProviderConfig.toString();
    TwoFaProviderType actualProviderType = actualEmailTwoFaProviderConfig.getProviderType();

    // Assert
    assertEquals("EmailTwoFaProviderConfig()", actualToStringResult);
    assertEquals(0, actualEmailTwoFaProviderConfig.getVerificationCodeLifetime());
    assertEquals(TwoFaProviderType.EMAIL, actualProviderType);
  }
}
