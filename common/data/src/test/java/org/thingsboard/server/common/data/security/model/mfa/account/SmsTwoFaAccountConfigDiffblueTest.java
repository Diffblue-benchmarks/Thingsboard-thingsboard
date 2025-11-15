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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class SmsTwoFaAccountConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
    int expectedHashCodeResult = smsTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaAccountConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig);
    int expectedHashCodeResult = smsTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaAccountConfig.hashCode());
  }

  /**
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("8605550118");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber(null);
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(false);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, null);
  }

  /**
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, "Different type to SmsTwoFaAccountConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SmsTwoFaAccountConfig}
   *   <li>{@link SmsTwoFaAccountConfig#setPhoneNumber(String)}
   *   <li>{@link SmsTwoFaAccountConfig#toString()}
   *   <li>{@link SmsTwoFaAccountConfig#getPhoneNumber()}
   *   <li>{@link SmsTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SmsTwoFaAccountConfig actualSmsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    actualSmsTwoFaAccountConfig.setPhoneNumber("6625550144");
    String actualToStringResult = actualSmsTwoFaAccountConfig.toString();
    String actualPhoneNumber = actualSmsTwoFaAccountConfig.getPhoneNumber();

    // Assert that nothing has changed
    assertEquals("6625550144", actualPhoneNumber);
    assertEquals("SmsTwoFaAccountConfig(phoneNumber=6625550144)", actualToStringResult);
    assertEquals(TwoFaProviderType.SMS, actualSmsTwoFaAccountConfig.getProviderType());
    assertFalse(actualSmsTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualSmsTwoFaAccountConfig.isUseByDefault());
  }
}
