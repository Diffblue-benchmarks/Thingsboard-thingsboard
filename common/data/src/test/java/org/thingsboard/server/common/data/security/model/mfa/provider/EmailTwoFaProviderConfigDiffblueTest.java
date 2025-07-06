package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmailTwoFaProviderConfigDiffblueTest {
  /**
   * Test {@link EmailTwoFaProviderConfig#equals(Object)}, and {@link
   * EmailTwoFaProviderConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTwoFaProviderConfig#equals(Object)}
   *   <li>{@link EmailTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EmailTwoFaProviderConfig.equals(Object)",
    "int EmailTwoFaProviderConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig2.hashCode());
  }

  /**
   * Test {@link EmailTwoFaProviderConfig#equals(Object)}, and {@link
   * EmailTwoFaProviderConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EmailTwoFaProviderConfig#equals(Object)}
   *   <li>{@link EmailTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EmailTwoFaProviderConfig.equals(Object)",
    "int EmailTwoFaProviderConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig.hashCode());
  }

  /**
   * Test {@link EmailTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EmailTwoFaProviderConfig.equals(Object)",
    "int EmailTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(3);

    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig2.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
  }

  /**
   * Test {@link EmailTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EmailTwoFaProviderConfig.equals(Object)",
    "int EmailTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, null);
  }

  /**
   * Test {@link EmailTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EmailTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EmailTwoFaProviderConfig.equals(Object)",
    "int EmailTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, "Different type to EmailTwoFaProviderConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EmailTwoFaProviderConfig}
   *   <li>{@link EmailTwoFaProviderConfig#toString()}
   *   <li>{@link EmailTwoFaProviderConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EmailTwoFaProviderConfig.<init>()",
    "TwoFaProviderType EmailTwoFaProviderConfig.getProviderType()",
    "String EmailTwoFaProviderConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EmailTwoFaProviderConfig actualEmailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    String actualToStringResult = actualEmailTwoFaProviderConfig.toString();
    TwoFaProviderType actualProviderType = actualEmailTwoFaProviderConfig.getProviderType();

    // Assert
    assertEquals("EmailTwoFaProviderConfig()", actualToStringResult);
    assertEquals(0, actualEmailTwoFaProviderConfig.getVerificationCodeLifetime());
    assertEquals(TwoFaProviderType.EMAIL, actualProviderType);
  }
}
