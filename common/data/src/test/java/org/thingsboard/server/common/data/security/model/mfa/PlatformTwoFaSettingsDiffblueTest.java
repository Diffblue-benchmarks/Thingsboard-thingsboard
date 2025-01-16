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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class PlatformTwoFaSettingsDiffblueTest {
  /**
   * Test {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.
   * <ul>
   *   <li>Given {@link PlatformTwoFaSettings} (default constructor).</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getProviderConfig(TwoFaProviderType); given PlatformTwoFaSettings (default constructor); then return not Present")
  void testGetProviderConfig_givenPlatformTwoFaSettings_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse((new PlatformTwoFaSettings()).getProviderConfig(TwoFaProviderType.TOTP).isPresent());
  }

  /**
   * Test {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getProviderConfig(TwoFaProviderType); then return not Present")
  void testGetProviderConfig_thenReturnNotPresent() {
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
   * Test {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getProviderConfig(TwoFaProviderType); then return Present")
  void testGetProviderConfig_thenReturnPresent() {
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and
   * {@link PlatformTwoFaSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and
   * {@link PlatformTwoFaSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and
   * {@link PlatformTwoFaSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and
   * {@link PlatformTwoFaSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and
   * {@link PlatformTwoFaSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and
   * {@link PlatformTwoFaSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
