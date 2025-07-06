package org.thingsboard.server.common.data.security.model.mfa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class PlatformTwoFaSettingsDiffblueTest {
  /**
   * Test {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.
   *
   * <ul>
   *   <li>Given {@link PlatformTwoFaSettings} (default constructor).
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName(
      "Test getProviderConfig(TwoFaProviderType); given PlatformTwoFaSettings (default constructor); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional PlatformTwoFaSettings.getProviderConfig(TwoFaProviderType)"})
  void testGetProviderConfig_givenPlatformTwoFaSettings_thenReturnNotPresent() {
    // Arrange, Act and Assert
    assertFalse(new PlatformTwoFaSettings().getProviderConfig(TwoFaProviderType.TOTP).isPresent());
  }

  /**
   * Test {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getProviderConfig(TwoFaProviderType); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional PlatformTwoFaSettings.getProviderConfig(TwoFaProviderType)"})
  void testGetProviderConfig_thenReturnNotPresent() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertFalse(platformTwoFaSettings.getProviderConfig(TwoFaProviderType.TOTP).isPresent());
  }

  /**
   * Test {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test getProviderConfig(TwoFaProviderType); then return Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional PlatformTwoFaSettings.getProviderConfig(TwoFaProviderType)"})
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
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    // Act
    Optional<TwoFaProviderConfig> actualProviderConfig =
        platformTwoFaSettings.getProviderConfig(TwoFaProviderType.TOTP);

    // Assert
    verify(twoFaProviderConfig).getProviderType();
    assertTrue(actualProviderConfig.isPresent());
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and {@link
   * PlatformTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and {@link
   * PlatformTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(null);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(null);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and {@link
   * PlatformTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(null);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(null);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and {@link
   * PlatformTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(null);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(null);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings2);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings2.hashCode());
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}, and {@link
   * PlatformTwoFaSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PlatformTwoFaSettings#equals(Object)}
   *   <li>{@link PlatformTwoFaSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertEquals(platformTwoFaSettings, platformTwoFaSettings);
    int expectedHashCodeResult = platformTwoFaSettings.hashCode();
    assertEquals(expectedHashCodeResult, platformTwoFaSettings.hashCode());
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(1);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(null);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(1);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(null);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<TwoFaProviderConfig> providers = new ArrayList<>();
    providers.add(mock(TwoFaProviderConfig.class));

    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(providers);
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(3);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(null);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:9999:99");

    PlatformTwoFaSettings platformTwoFaSettings2 = new PlatformTwoFaSettings();
    platformTwoFaSettings2.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings2.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings2.setProviders(new ArrayList<>());
    platformTwoFaSettings2.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings2.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, platformTwoFaSettings2);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, null);
  }

  /**
   * Test {@link PlatformTwoFaSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PlatformTwoFaSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean PlatformTwoFaSettings.equals(Object)",
    "int PlatformTwoFaSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");

    // Act and Assert
    assertNotEquals(platformTwoFaSettings, "Different type to PlatformTwoFaSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PlatformTwoFaSettings}
   *   <li>{@link PlatformTwoFaSettings#setMaxVerificationFailuresBeforeUserLockout(Integer)}
   *   <li>{@link PlatformTwoFaSettings#setMinVerificationCodeSendPeriod(Integer)}
   *   <li>{@link PlatformTwoFaSettings#setProviders(List)}
   *   <li>{@link PlatformTwoFaSettings#setTotalAllowedTimeForVerification(Integer)}
   *   <li>{@link PlatformTwoFaSettings#setVerificationCodeCheckRateLimit(String)}
   *   <li>{@link PlatformTwoFaSettings#toString()}
   *   <li>{@link PlatformTwoFaSettings#getMaxVerificationFailuresBeforeUserLockout()}
   *   <li>{@link PlatformTwoFaSettings#getMinVerificationCodeSendPeriod()}
   *   <li>{@link PlatformTwoFaSettings#getProviders()}
   *   <li>{@link PlatformTwoFaSettings#getTotalAllowedTimeForVerification()}
   *   <li>{@link PlatformTwoFaSettings#getVerificationCodeCheckRateLimit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void PlatformTwoFaSettings.<init>()",
    "Integer PlatformTwoFaSettings.getMaxVerificationFailuresBeforeUserLockout()",
    "Integer PlatformTwoFaSettings.getMinVerificationCodeSendPeriod()",
    "List PlatformTwoFaSettings.getProviders()",
    "Integer PlatformTwoFaSettings.getTotalAllowedTimeForVerification()",
    "String PlatformTwoFaSettings.getVerificationCodeCheckRateLimit()",
    "void PlatformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(Integer)",
    "void PlatformTwoFaSettings.setMinVerificationCodeSendPeriod(Integer)",
    "void PlatformTwoFaSettings.setProviders(List)",
    "void PlatformTwoFaSettings.setTotalAllowedTimeForVerification(Integer)",
    "void PlatformTwoFaSettings.setVerificationCodeCheckRateLimit(String)",
    "String PlatformTwoFaSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PlatformTwoFaSettings actualPlatformTwoFaSettings = new PlatformTwoFaSettings();
    actualPlatformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    actualPlatformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    ArrayList<TwoFaProviderConfig> providers = new ArrayList<>();
    actualPlatformTwoFaSettings.setProviders(providers);
    actualPlatformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    actualPlatformTwoFaSettings.setVerificationCodeCheckRateLimit("99:99");
    String actualToStringResult = actualPlatformTwoFaSettings.toString();
    Integer actualMaxVerificationFailuresBeforeUserLockout =
        actualPlatformTwoFaSettings.getMaxVerificationFailuresBeforeUserLockout();
    Integer actualMinVerificationCodeSendPeriod =
        actualPlatformTwoFaSettings.getMinVerificationCodeSendPeriod();
    List<TwoFaProviderConfig> actualProviders = actualPlatformTwoFaSettings.getProviders();
    Integer actualTotalAllowedTimeForVerification =
        actualPlatformTwoFaSettings.getTotalAllowedTimeForVerification();

    // Assert
    assertEquals("99:99", actualPlatformTwoFaSettings.getVerificationCodeCheckRateLimit());
    assertEquals(
        "PlatformTwoFaSettings(providers=[], minVerificationCodeSendPeriod=3, verificationCodeCheckRateLimit=99:99,"
            + " maxVerificationFailuresBeforeUserLockout=3, totalAllowedTimeForVerification=1)",
        actualToStringResult);
    assertEquals(1, actualTotalAllowedTimeForVerification.intValue());
    assertEquals(3, actualMaxVerificationFailuresBeforeUserLockout.intValue());
    assertEquals(3, actualMinVerificationCodeSendPeriod.intValue());
    assertTrue(actualProviders.isEmpty());
    assertSame(providers, actualProviders);
  }
}
