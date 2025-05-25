package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TotpTwoFaProviderConfigDiffblueTest {
  /**
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}, and {@link TotpTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaProviderConfig#equals(Object)}
   *   <li>{@link TotpTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
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
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}, and {@link TotpTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaProviderConfig#equals(Object)}
   *   <li>{@link TotpTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
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
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}, and {@link TotpTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TotpTwoFaProviderConfig#equals(Object)}
   *   <li>{@link TotpTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
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
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
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
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
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
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName("Issuer Name");

    // Act and Assert
    assertNotEquals(totpTwoFaProviderConfig, null);
  }

  /**
   * Test {@link TotpTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TotpTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TotpTwoFaProviderConfig.equals(Object)", "int TotpTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TotpTwoFaProviderConfig totpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    totpTwoFaProviderConfig.setIssuerName("Issuer Name");

    // Act and Assert
    assertNotEquals(totpTwoFaProviderConfig, "Different type to TotpTwoFaProviderConfig");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TotpTwoFaProviderConfig.<init>()", "String TotpTwoFaProviderConfig.getIssuerName()",
      "TwoFaProviderType TotpTwoFaProviderConfig.getProviderType()",
      "void TotpTwoFaProviderConfig.setIssuerName(String)", "String TotpTwoFaProviderConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TotpTwoFaProviderConfig actualTotpTwoFaProviderConfig = new TotpTwoFaProviderConfig();
    actualTotpTwoFaProviderConfig.setIssuerName("Issuer Name");
    String actualToStringResult = actualTotpTwoFaProviderConfig.toString();
    String actualIssuerName = actualTotpTwoFaProviderConfig.getIssuerName();

    // Assert
    assertEquals("Issuer Name", actualIssuerName);
    assertEquals("TotpTwoFaProviderConfig(issuerName=Issuer Name)", actualToStringResult);
    assertEquals(TwoFaProviderType.TOTP, actualTotpTwoFaProviderConfig.getProviderType());
  }
}
