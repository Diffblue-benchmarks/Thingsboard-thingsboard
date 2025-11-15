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
import static org.mockito.Mockito.mock;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class AccountTwoFaSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountTwoFaSettings#equals(Object)}
   *   <li>{@link AccountTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    AccountTwoFaSettings accountTwoFaSettings2 = new AccountTwoFaSettings();
    accountTwoFaSettings2.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertEquals(accountTwoFaSettings, accountTwoFaSettings2);
    int expectedHashCodeResult = accountTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, accountTwoFaSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AccountTwoFaSettings#equals(Object)}
   *   <li>{@link AccountTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.replaceAll(mock(BiFunction.class));
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);

    AccountTwoFaSettings accountTwoFaSettings2 = new AccountTwoFaSettings();
    accountTwoFaSettings2.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertNotEquals(accountTwoFaSettings, accountTwoFaSettings2);
  }

  /**
   * Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertNotEquals(accountTwoFaSettings, null);
  }

  /**
   * Method under test: {@link AccountTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());

    // Act and Assert
    assertNotEquals(accountTwoFaSettings, "Different type to AccountTwoFaSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AccountTwoFaSettings}
   *   <li>{@link AccountTwoFaSettings#setConfigs(LinkedHashMap)}
   *   <li>{@link AccountTwoFaSettings#toString()}
   *   <li>{@link AccountTwoFaSettings#getConfigs()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AccountTwoFaSettings actualAccountTwoFaSettings = new AccountTwoFaSettings();
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    actualAccountTwoFaSettings.setConfigs(configs);
    String actualToStringResult = actualAccountTwoFaSettings.toString();

    // Assert that nothing has changed
    assertEquals("AccountTwoFaSettings(configs={})", actualToStringResult);
    assertSame(configs, actualAccountTwoFaSettings.getConfigs());
  }
}
