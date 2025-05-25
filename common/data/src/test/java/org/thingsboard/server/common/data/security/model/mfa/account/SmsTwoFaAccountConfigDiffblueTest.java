package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class SmsTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}, and {@link SmsTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
    int expectedHashCodeResult = smsTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}, and {@link SmsTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber(null);
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber(null);
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
    int expectedHashCodeResult = smsTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}, and {@link SmsTwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SmsTwoFaAccountConfig#equals(Object)}
   *   <li>{@link SmsTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig);
    int expectedHashCodeResult = smsTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("8605550118");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber(null);
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(false);

    SmsTwoFaAccountConfig smsTwoFaAccountConfig2 = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig2.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig2.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, smsTwoFaAccountConfig2);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, null);
  }

  /**
   * Test {@link SmsTwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SmsTwoFaAccountConfig.equals(Object)", "int SmsTwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaAccountConfig smsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    smsTwoFaAccountConfig.setPhoneNumber("6625550144");
    smsTwoFaAccountConfig.setSerializeHiddenFields(true);
    smsTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(smsTwoFaAccountConfig, "Different type to SmsTwoFaAccountConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SmsTwoFaAccountConfig}
   *   <li>{@link SmsTwoFaAccountConfig#setPhoneNumber(String)}
   *   <li>{@link SmsTwoFaAccountConfig#toString()}
   *   <li>{@link SmsTwoFaAccountConfig#getPhoneNumber()}
   *   <li>{@link SmsTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SmsTwoFaAccountConfig.<init>()", "String SmsTwoFaAccountConfig.getPhoneNumber()",
      "TwoFaProviderType SmsTwoFaAccountConfig.getProviderType()", "void SmsTwoFaAccountConfig.setPhoneNumber(String)",
      "String SmsTwoFaAccountConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SmsTwoFaAccountConfig actualSmsTwoFaAccountConfig = new SmsTwoFaAccountConfig();
    actualSmsTwoFaAccountConfig.setPhoneNumber("6625550144");
    String actualToStringResult = actualSmsTwoFaAccountConfig.toString();
    String actualPhoneNumber = actualSmsTwoFaAccountConfig.getPhoneNumber();

    // Assert
    assertEquals("6625550144", actualPhoneNumber);
    assertEquals("SmsTwoFaAccountConfig(phoneNumber=6625550144)", actualToStringResult);
    assertEquals(TwoFaProviderType.SMS, actualSmsTwoFaAccountConfig.getProviderType());
    assertFalse(actualSmsTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualSmsTwoFaAccountConfig.isUseByDefault());
  }
}
