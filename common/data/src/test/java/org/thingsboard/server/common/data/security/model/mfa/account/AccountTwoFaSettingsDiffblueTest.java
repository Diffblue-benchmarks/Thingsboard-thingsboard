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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class AccountTwoFaSettingsDiffblueTest {
  /**
   * Test {@link AccountTwoFaSettings#equals(Object)}, and {@link AccountTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccountTwoFaSettings#equals(Object)}
   *   <li>{@link AccountTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AccountTwoFaSettings.equals(Object)",
    "int AccountTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings2 = new AccountTwoFaSettings();
    accountTwoFaSettings2.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertEquals(accountTwoFaSettings, accountTwoFaSettings2);
    assertEquals(accountTwoFaSettings.hashCode(), accountTwoFaSettings2.hashCode());
  }

  /**
   * Test {@link AccountTwoFaSettings#equals(Object)}, and {@link AccountTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AccountTwoFaSettings#equals(Object)}
   *   <li>{@link AccountTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AccountTwoFaSettings.equals(Object)",
    "int AccountTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertEquals(accountTwoFaSettings, accountTwoFaSettings);
    int expectedHashCodeResult = accountTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, accountTwoFaSettings.hashCode());
  }

  /**
   * Test {@link AccountTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AccountTwoFaSettings.equals(Object)",
    "int AccountTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);

    AccountTwoFaSettings accountTwoFaSettings2 = new AccountTwoFaSettings();
    accountTwoFaSettings2.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertNotEquals(accountTwoFaSettings, accountTwoFaSettings2);
  }

  /**
   * Test {@link AccountTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AccountTwoFaSettings.equals(Object)",
    "int AccountTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertNotEquals(accountTwoFaSettings, null);
  }

  /**
   * Test {@link AccountTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AccountTwoFaSettings.equals(Object)",
    "int AccountTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertNotEquals(accountTwoFaSettings, "Different type to AccountTwoFaSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AccountTwoFaSettings}
   *   <li>{@link AccountTwoFaSettings#setConfigs(LinkedHashMap)}
   *   <li>{@link AccountTwoFaSettings#toString()}
   *   <li>{@link AccountTwoFaSettings#getConfigs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccountTwoFaSettings.<init>()",
    "LinkedHashMap AccountTwoFaSettings.getConfigs()",
    "void AccountTwoFaSettings.setConfigs(LinkedHashMap)",
    "String AccountTwoFaSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AccountTwoFaSettings actualAccountTwoFaSettings = new AccountTwoFaSettings();
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    actualAccountTwoFaSettings.setConfigs(configs);
    String actualToStringResult = actualAccountTwoFaSettings.toString();

    // Assert
    assertEquals("AccountTwoFaSettings(configs={})", actualToStringResult);
    assertSame(configs, actualAccountTwoFaSettings.getConfigs());
  }
}
