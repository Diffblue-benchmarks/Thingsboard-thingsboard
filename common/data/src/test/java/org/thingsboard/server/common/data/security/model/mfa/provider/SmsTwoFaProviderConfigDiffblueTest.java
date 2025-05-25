package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmsTwoFaProviderConfigDiffblueTest {
  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}, and {@link SmsTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaProviderConfig#equals(Object)}
   *   <li>{@link SmsTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
    int expectedHashCodeResult = smsTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaProviderConfig2.hashCode());
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}, and {@link SmsTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaProviderConfig#equals(Object)}
   *   <li>{@link SmsTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate(null);
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate(null);
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
    int expectedHashCodeResult = smsTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaProviderConfig2.hashCode());
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}, and {@link SmsTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaProviderConfig#equals(Object)}
   *   <li>{@link SmsTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig);
    int expectedHashCodeResult = smsTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaProviderConfig.hashCode());
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate(null);
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate(
        "org.thingsboard.server.common.data.security.model.mfa.provider.SmsTwoFaProviderConfig");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(3);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, null);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaProviderConfig.equals(Object)", "int SmsTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, "Different type to SmsTwoFaProviderConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SmsTwoFaProviderConfig}
   *   <li>{@link SmsTwoFaProviderConfig#setSmsVerificationMessageTemplate(String)}
   *   <li>{@link SmsTwoFaProviderConfig#toString()}
   *   <li>{@link SmsTwoFaProviderConfig#getProviderType()}
   *   <li>{@link SmsTwoFaProviderConfig#getSmsVerificationMessageTemplate()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmsTwoFaProviderConfig.<init>()",
      "TwoFaProviderType SmsTwoFaProviderConfig.getProviderType()",
      "String SmsTwoFaProviderConfig.getSmsVerificationMessageTemplate()",
      "void SmsTwoFaProviderConfig.setSmsVerificationMessageTemplate(String)",
      "String SmsTwoFaProviderConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SmsTwoFaProviderConfig actualSmsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    actualSmsTwoFaProviderConfig.setSmsVerificationMessageTemplate("Sms Verification Message Template");
    String actualToStringResult = actualSmsTwoFaProviderConfig.toString();
    TwoFaProviderType actualProviderType = actualSmsTwoFaProviderConfig.getProviderType();

    // Assert
    assertEquals("Sms Verification Message Template", actualSmsTwoFaProviderConfig.getSmsVerificationMessageTemplate());
    assertEquals("SmsTwoFaProviderConfig(smsVerificationMessageTemplate=Sms Verification Message Template)",
        actualToStringResult);
    assertEquals(0, actualSmsTwoFaProviderConfig.getVerificationCodeLifetime());
    assertEquals(TwoFaProviderType.SMS, actualProviderType);
  }
}
