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
import org.junit.jupiter.api.Test;

class TotpTwoFaProviderConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaProviderConfig#equals(Object)}
   *   <li>{@link TotpTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName("Issuer Name");

    TotpTwoFaProviderConfig totpTwoFaProviderConfig2 = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig2.setIssuerName("Issuer Name");

    // Act and Assert
    assertEquals(totpTwoFaProviderConfig, totpTwoFaProviderConfig2);
    int expectedHashCodeResult = totpTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, totpTwoFaProviderConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaProviderConfig#equals(Object)}
   *   <li>{@link TotpTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName(null);

    TotpTwoFaProviderConfig totpTwoFaProviderConfig2 = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig2.setIssuerName(null);

    // Act and Assert
    assertEquals(totpTwoFaProviderConfig, totpTwoFaProviderConfig2);
    int expectedHashCodeResult = totpTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, totpTwoFaProviderConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaProviderConfig#equals(Object)}
   *   <li>{@link TotpTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName("Issuer Name");

    // Act and Assert
    assertEquals(totpTwoFaProviderConfig, totpTwoFaProviderConfig);
    int expectedHashCodeResult = totpTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, totpTwoFaProviderConfig.hashCode());
  }

  /**
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName(null);

    TotpTwoFaProviderConfig totpTwoFaProviderConfig2 = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig2.setIssuerName("Issuer Name");

    // Act and Assert
    assertNotEquals(totpTwoFaProviderConfig, totpTwoFaProviderConfig2);
  }

  /**
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig
        .setIssuerName("org.thingsboard.server.common.data.security.model.mfa.provider.TotpTwoFaProviderConfig");

    TotpTwoFaProviderConfig totpTwoFaProviderConfig2 = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig2.setIssuerName("Issuer Name");

    // Act and Assert
    assertNotEquals(totpTwoFaProviderConfig, totpTwoFaProviderConfig2);
  }

  /**
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName("Issuer Name");

    // Act and Assert
    assertNotEquals(totpTwoFaProviderConfig, null);
  }

  /**
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName("Issuer Name");

    // Act and Assert
    assertNotEquals(totpTwoFaProviderConfig, "Different type to TotpTwoFaProviderConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TotpTwoFaProviderConfig}
   *   <li>{@link TotpTwoFaProviderConfig#setIssuerName(String)}
   *   <li>{@link TotpTwoFaProviderConfig#toString()}
   *   <li>{@link TotpTwoFaProviderConfig#getIssuerName()}
   *   <li>{@link TotpTwoFaProviderConfig#getProviderType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TotpTwoFaProviderConfig actualTotpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    actualTotpTwoFaProviderConfig.setIssuerName("Issuer Name");
    String actualToStringResult = actualTotpTwoFaProviderConfig.toString();
    String actualIssuerName = actualTotpTwoFaProviderConfig.getIssuerName();

    // Assert that nothing has changed
    assertEquals("Issuer Name", actualIssuerName);
    assertEquals("TotpTwoFaProviderConfig(issuerName=Issuer Name)", actualToStringResult);
    assertEquals(TwoFaProviderType.TOTP, actualTotpTwoFaProviderConfig.getProviderType());
  }
}
