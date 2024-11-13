package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class TotpTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}, and
   * {@link TotpTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaAccountConfig#equals(Object)}
   *   <li>{@link TotpTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}, and
   * {@link TotpTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaAccountConfig#equals(Object)}
   *   <li>{@link TotpTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link TotpTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
