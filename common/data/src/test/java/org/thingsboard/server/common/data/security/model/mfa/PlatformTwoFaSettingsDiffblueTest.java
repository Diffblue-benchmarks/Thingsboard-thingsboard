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
package org.thingsboard.server.common.data.security.model.mfa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class PlatformTwoFaSettingsDiffblueTest {
  /**
   * Method under test:
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  void testGetProviderConfig() {
    // Arrange, Act and Assert
    assertFalse((new PlatformTwoFaSettings()).getProviderConfig(TwoFaProviderType.TOTP).isPresent());
  }

  /**
   * Method under test:
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  void testGetProviderConfig2() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertFalse(platformTwoFaSettings.getProviderConfig(TwoFaProviderType.TOTP).isPresent());
  }

  /**
   * Method under test:
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  void testGetProviderConfig3() {
    // Arrange
    TwoFaProviderConfig twoFaProviderConfig = mock(TwoFaProviderConfig.class);
    when(twoFaProviderConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);

    ArrayList<TwoFaProviderConfig> providers = new ArrayList<>();
    providers.add(twoFaProviderConfig);

    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(providers);
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act
    Optional<TwoFaProviderConfig> actualProviderConfig = platformTwoFaSettings
        .getProviderConfig(TwoFaProviderType.TOTP);

    // Assert
    verify(twoFaProviderConfig).getProviderType();
    assertTrue(actualProviderConfig.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(null);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(null);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(null);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(null);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(null);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(null);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit(null);

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit(null);

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings.hashCode());
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(1);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(null);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(1);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(null);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<TwoFaProviderConfig> providers = new ArrayList<>();
    providers.add(mock(TwoFaProviderConfig.class));

    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(providers);
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(3);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(null);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit(null);

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit(
        "org.thingsboard.server.common.data.security.model.mfa.PlatformTwoFaSettings");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, null);
  }

  /**
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, "Different type to PlatformTwoFaSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PlatformTwoFaSettings}
   *   <li>
   * {@link PlatformTwoFaSettings#setMaxVerificationFailuresBeforeUserLockout(Integer)}
   *   <li>{@link PlatformTwoFaSettings#setMinVerificationCodeSendPeriod(Integer)}
   *   <li>{@link PlatformTwoFaSettings#setProviders(List)}
   *   <li>{@link PlatformTwoFaSettings#setTotalAllowedTimeForVerification(Integer)}
   *   <li>{@link PlatformTwoFaSettings#setVerificationCodeCheckRateLimit(String)}
   *   <li>{@link PlatformTwoFaSettings#toString()}
   *   <li>
   * {@link PlatformTwoFaSettings#getMaxVerificationFailuresBeforeUserLockout()}
   *   <li>{@link PlatformTwoFaSettings#getMinVerificationCodeSendPeriod()}
   *   <li>{@link PlatformTwoFaSettings#getProviders()}
   *   <li>{@link PlatformTwoFaSettings#getTotalAllowedTimeForVerification()}
   *   <li>{@link PlatformTwoFaSettings#getVerificationCodeCheckRateLimit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PlatformTwoFaSettings actualPlatformTwoFaSettings = new PlatformTwoFaSettings();
    actualPlatformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    actualPlatformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    ArrayList<TwoFaProviderConfig> providers = new ArrayList<>();
    actualPlatformTwoFaSettings.setProviders(providers);
    actualPlatformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    actualPlatformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    String actualToStringResult = actualPlatformTwoFaSettings.toString();
    Integer actualMaxVerificationFailuresBeforeUserLockout = actualPlatformTwoFaSettings
        .getMaxVerificationFailuresBeforeUserLockout();
    Integer actualMinVerificationCodeSendPeriod = actualPlatformTwoFaSettings.getMinVerificationCodeSendPeriod();
    List<TwoFaProviderConfig> actualProviders = actualPlatformTwoFaSettings.getProviders();
    Integer actualTotalAllowedTimeForVerification = actualPlatformTwoFaSettings.getTotalAllowedTimeForVerification();

    // Assert that nothing has changed
    assertEquals("PlatformTwoFaSettings(providers=[], minVerificationCodeSendPeriod=3, verificationCodeCheckRateLimit"
        + "=Verification Code Check Rate Limit, maxVerificationFailuresBeforeUserLockout=3, totalAllowedTimeFor"
        + "Verification=1)", actualToStringResult);
    assertEquals("Verification Code Check Rate Limit", actualPlatformTwoFaSettings.getVerificationCodeCheckRateLimit());
    assertEquals(1, actualTotalAllowedTimeForVerification.intValue());
    assertEquals(3, actualMaxVerificationFailuresBeforeUserLockout.intValue());
    assertEquals(3, actualMinVerificationCodeSendPeriod.intValue());
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
