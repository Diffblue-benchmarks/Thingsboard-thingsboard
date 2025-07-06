package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OtpBasedTwoFaProviderConfigDiffblueTest {
  /**
   * Test {@link OtpBasedTwoFaProviderConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link EmailTwoFaProviderConfig} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when EmailTwoFaProviderConfig (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtpBasedTwoFaProviderConfig.canEqual(Object)"})
  void testCanEqual_whenEmailTwoFaProviderConfig_thenReturnTrue() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    // Act and Assert
    assertTrue(emailTwoFaProviderConfig.canEqual(new EmailTwoFaProviderConfig()));
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OtpBasedTwoFaProviderConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmailTwoFaProviderConfig().canEqual("Other"));
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#equals(Object)}, and {@link
   * OtpBasedTwoFaProviderConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaProviderConfig.equals(Object)",
    "int OtpBasedTwoFaProviderConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = new EmailTwoFaProviderConfig();

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig2.hashCode());
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#equals(Object)}, and {@link
   * OtpBasedTwoFaProviderConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaProviderConfig.equals(Object)",
    "int OtpBasedTwoFaProviderConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    // Act and Assert
    assertEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig);
    int expectedHashCodeResult = emailTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaProviderConfig.hashCode());
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaProviderConfig.equals(Object)",
    "int OtpBasedTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    SmsTwoFaProviderConfig smsTwoFaProviderConfig = new SmsTwoFaProviderConfig();
    smsTwoFaProviderConfig.setSmsVerificationMessageTemplate("U${code}U");
    smsTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, smsTwoFaProviderConfig);
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaProviderConfig.equals(Object)",
    "int OtpBasedTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    EmailTwoFaProviderConfig emailTwoFaProviderConfig2 = mock(EmailTwoFaProviderConfig.class);
    when(emailTwoFaProviderConfig2.getVerificationCodeLifetime()).thenReturn(1);
    when(emailTwoFaProviderConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailTwoFaProviderConfig, emailTwoFaProviderConfig2);
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaProviderConfig.equals(Object)",
    "int OtpBasedTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaProviderConfig(), null);
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaProviderConfig.equals(Object)",
    "int OtpBasedTwoFaProviderConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EmailTwoFaProviderConfig(), "Different type to OtpBasedTwoFaProviderConfig");
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#getVerificationCodeLifetime()}.
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#getVerificationCodeLifetime()}
   */
  @Test
  @DisplayName("Test getVerificationCodeLifetime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int OtpBasedTwoFaProviderConfig.getVerificationCodeLifetime()"})
  void testGetVerificationCodeLifetime() {
    // Arrange, Act and Assert
    assertEquals(0, new EmailTwoFaProviderConfig().getVerificationCodeLifetime());
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#setVerificationCodeLifetime(int)}.
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#setVerificationCodeLifetime(int)}
   */
  @Test
  @DisplayName("Test setVerificationCodeLifetime(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OtpBasedTwoFaProviderConfig.setVerificationCodeLifetime(int)"})
  void testSetVerificationCodeLifetime() {
    // Arrange
    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();

    // Act
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    // Assert
    assertEquals(1, emailTwoFaProviderConfig.getVerificationCodeLifetime());
  }

  /**
   * Test {@link OtpBasedTwoFaProviderConfig#toString()}.
   *
   * <p>Method under test: {@link OtpBasedTwoFaProviderConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String OtpBasedTwoFaProviderConfig.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EmailTwoFaProviderConfig()", new EmailTwoFaProviderConfig().toString());
  }
}
