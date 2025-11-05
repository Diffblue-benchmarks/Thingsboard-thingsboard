package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmsTwoFaProviderConfigDiffblueTest {
  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}, and {@link
   * SmsTwoFaProviderConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmsTwoFaProviderConfig#equals(Object)}
   *   <li>{@link SmsTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaProviderConfig.equals(Object)",
    "int SmsTwoFaProviderConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
    assertEquals(smsTwoFaProviderConfig.hashCode(), smsTwoFaProviderConfig2.hashCode());
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}, and {@link
   * SmsTwoFaProviderConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SmsTwoFaProviderConfig#equals(Object)}
   *   <li>{@link SmsTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaProviderConfig.equals(Object)",
    "int SmsTwoFaProviderConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig);
    int expectedHashCodeResult = smsTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, smsTwoFaProviderConfig.hashCode());
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaProviderConfig.equals(Object)",
    "int SmsTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(3);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaProviderConfig.equals(Object)",
    "int SmsTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}UU${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    SmsTwoFaProviderConfig smsTwoFaProviderConfig2 = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig2.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, smsTwoFaProviderConfig2);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaProviderConfig.equals(Object)",
    "int SmsTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, null);
  }

  /**
   * Test {@link SmsTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SmsTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SmsTwoFaProviderConfig.equals(Object)",
    "int SmsTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(smsTwoFaProviderConfig, "Different type to SmsTwoFaProviderConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmsTwoFaProviderConfig.<init>()",
    "TwoFaProviderType SmsTwoFaProviderConfig.getProviderType()",
    "String SmsTwoFaProviderConfig.getSmsVerificationMessageTemplate()",
    "void SmsTwoFaProviderConfig.setSmsVerificationMessageTemplate(String)",
    "String SmsTwoFaProviderConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SmsTwoFaProviderConfig actualSmsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    actualSmsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    String actualToStringResult = actualSmsTwoFaProviderConfig.toString();
    TwoFaProviderType actualProviderType = actualSmsTwoFaProviderConfig.getProviderType();

    // Assert
    assertEquals(
        "SmsTwoFaProviderConfig(smsVerificationMessageTemplate=U${code}U)", actualToStringResult);
    assertEquals("U${code}U", actualSmsTwoFaProviderConfig.getSmsVerificationMessageTemplate());
    assertEquals(0, actualSmsTwoFaProviderConfig.getVerificationCodeLifetime());
    assertEquals(TwoFaProviderType.SMS, actualProviderType);
  }
}
