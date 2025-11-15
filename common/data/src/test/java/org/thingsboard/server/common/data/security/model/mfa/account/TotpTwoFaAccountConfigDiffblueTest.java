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

class TotpTwoFaAccountConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaAccountConfig#equals(Object)}
   *   <li>{@link TotpTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
    int expectedHashCodeResult = totpTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, totpTwoFaAccountConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaAccountConfig#equals(Object)}
   *   <li>{@link TotpTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig);
    int expectedHashCodeResult = totpTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, totpTwoFaAccountConfig.hashCode());
  }

  /**
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("Auth Url");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl(null);
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(false);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
  }

  /**
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, null);
  }

  /**
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("https://example.org/example");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, "Different type to TotpTwoFaAccountConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TotpTwoFaAccountConfig}
   *   <li>{@link TotpTwoFaAccountConfig#setAuthUrl(String)}
   *   <li>{@link TotpTwoFaAccountConfig#toString()}
   *   <li>{@link TotpTwoFaAccountConfig#getAuthUrl()}
   *   <li>{@link TotpTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TotpTwoFaAccountConfig actualTotpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    actualTotpTwoFaAccountConfig.setAuthUrl("https://example.org/example");
    String actualToStringResult = actualTotpTwoFaAccountConfig.toString();
    String actualAuthUrl = actualTotpTwoFaAccountConfig.getAuthUrl();

    // Assert that nothing has changed
    assertEquals("TotpTwoFaAccountConfig(authUrl=https://example.org/example)", actualToStringResult);
    assertEquals("https://example.org/example", actualAuthUrl);
    assertEquals(TwoFaProviderType.TOTP, actualTotpTwoFaAccountConfig.getProviderType());
    assertFalse(actualTotpTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualTotpTwoFaAccountConfig.isUseByDefault());
  }
}
