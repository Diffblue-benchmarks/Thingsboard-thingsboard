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

class TotpTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}, and {@link
   * TotpTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TotpTwoFaAccountConfig#equals(Object)}
   *   <li>{@link TotpTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TotpTwoFaAccountConfig.equals(Object)",
    "int TotpTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
    assertEquals(totpTwoFaAccountConfig.hashCode(), totpTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}, and {@link
   * TotpTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TotpTwoFaAccountConfig#equals(Object)}
   *   <li>{@link TotpTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TotpTwoFaAccountConfig.equals(Object)",
    "int TotpTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig);
    int expectedHashCodeResult = totpTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, totpTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TotpTwoFaAccountConfig.equals(Object)",
    "int TotpTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(false);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
  }

  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TotpTwoFaAccountConfig.equals(Object)",
    "int TotpTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl(
        "otpauth://totp/UUU:UUU?issuer=UUU&secret=UUUotpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    TotpTwoFaAccountConfig totpTwoFaAccountConfig2 = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig2.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig2.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, totpTwoFaAccountConfig2);
  }

  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TotpTwoFaAccountConfig.equals(Object)",
    "int TotpTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, null);
  }

  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TotpTwoFaAccountConfig.equals(Object)",
    "int TotpTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaAccountConfig totpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    totpTwoFaAccountConfig.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    totpTwoFaAccountConfig.setSerializeHiddenFields(true);
    totpTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(totpTwoFaAccountConfig, "Different type to TotpTwoFaAccountConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TotpTwoFaAccountConfig}
   *   <li>{@link TotpTwoFaAccountConfig#setAuthUrl(String)}
   *   <li>{@link TotpTwoFaAccountConfig#toString()}
   *   <li>{@link TotpTwoFaAccountConfig#getAuthUrl()}
   *   <li>{@link TotpTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TotpTwoFaAccountConfig.<init>()",
    "String TotpTwoFaAccountConfig.getAuthUrl()",
    "TwoFaProviderType TotpTwoFaAccountConfig.getProviderType()",
    "void TotpTwoFaAccountConfig.setAuthUrl(String)",
    "String TotpTwoFaAccountConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TotpTwoFaAccountConfig actualTotpTwoFaAccountConfig = new TotpTwoFaAccountConfig();
    actualTotpTwoFaAccountConfig.setAuthUrl("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU");
    String actualToStringResult = actualTotpTwoFaAccountConfig.toString();
    String actualAuthUrl = actualTotpTwoFaAccountConfig.getAuthUrl();

    // Assert
    assertEquals(
        "TotpTwoFaAccountConfig(authUrl=otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU)",
        actualToStringResult);
    assertEquals("otpauth://totp/UUU:UUU?issuer=UUU&secret=UUU", actualAuthUrl);
    assertEquals(TwoFaProviderType.TOTP, actualTotpTwoFaAccountConfig.getProviderType());
    assertFalse(actualTotpTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualTotpTwoFaAccountConfig.isUseByDefault());
  }
}
