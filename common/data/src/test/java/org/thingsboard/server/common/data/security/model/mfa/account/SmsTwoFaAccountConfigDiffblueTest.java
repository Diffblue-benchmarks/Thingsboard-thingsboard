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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class SmsTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}, and {@link
   * SmsTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaAccountConfig.equals(Object)",
    "int SmsTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("+9999");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("+9999");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
    assertEquals(smsTwoFaAccountConfig.hashCode(), smsTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}, and {@link
   * SmsTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaAccountConfig.equals(Object)",
    "int SmsTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("+9999");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig);
    int expectedHashCodeResult = smsTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaAccountConfig.equals(Object)",
    "int SmsTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("+9999");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(false);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("+9999");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaAccountConfig.equals(Object)",
    "int SmsTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("+9999+9999");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("+9999");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaAccountConfig.equals(Object)",
    "int SmsTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("+9999");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, null);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaAccountConfig.equals(Object)",
    "int SmsTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("+9999");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, "Different type to SmsTwoFaAccountConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SmsTwoFaAccountConfig}
   *   <li>{@link SmsTwoFaAccountConfig#setPhoneNumber(String)}
   *   <li>{@link SmsTwoFaAccountConfig#toString()}
   *   <li>{@link SmsTwoFaAccountConfig#getPhoneNumber()}
   *   <li>{@link SmsTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmsTwoFaAccountConfig.<init>()",
    "String SmsTwoFaAccountConfig.getPhoneNumber()",
    "TwoFaProviderType SmsTwoFaAccountConfig.getProviderType()",
    "void SmsTwoFaAccountConfig.setPhoneNumber(String)",
    "String SmsTwoFaAccountConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SmsTwoFaAccountConfig actualSmsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    actualSmsTwoFaAccountConfig.setPhoneNumber("+9999");
    String actualToStringResult = actualSmsTwoFaAccountConfig.toString();
    String actualPhoneNumber = actualSmsTwoFaAccountConfig.getPhoneNumber();

    // Assert
    assertEquals("+9999", actualPhoneNumber);
    assertEquals("SmsTwoFaAccountConfig(phoneNumber=+9999)", actualToStringResult);
    assertEquals(TwoFaProviderType.SMS, actualSmsTwoFaAccountConfig.getProviderType());
    assertFalse(actualSmsTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualSmsTwoFaAccountConfig.isUseByDefault());
  }
}
