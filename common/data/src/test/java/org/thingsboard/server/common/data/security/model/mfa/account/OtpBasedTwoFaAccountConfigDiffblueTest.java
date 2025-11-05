package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OtpBasedTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link OtpBasedTwoFaAccountConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link EmailTwoFaAccountConfig} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when EmailTwoFaAccountConfig (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtpBasedTwoFaAccountConfig.canEqual(Object)"})
  void testCanEqual_whenEmailTwoFaAccountConfig_thenReturnTrue() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertTrue(emailTwoFaAccountConfig.canEqual(new EmailTwoFaAccountConfig()));
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtpBasedTwoFaAccountConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmailTwoFaAccountConfig().canEqual("Other"));
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#equals(Object)}, and {@link
   * OtpBasedTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaAccountConfig.equals(Object)",
    "int OtpBasedTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
    assertEquals(emailTwoFaAccountConfig.hashCode(), emailTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#equals(Object)}, and {@link
   * OtpBasedTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaAccountConfig.equals(Object)",
    "int OtpBasedTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig);
    int expectedHashCodeResult = emailTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, emailTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaAccountConfig.equals(Object)",
    "int OtpBasedTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, backupCodeTwoFaAccountConfig);
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaAccountConfig.equals(Object)",
    "int OtpBasedTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();

    EmailTwoFaAccountConfig emailTwoFaAccountConfig2 = mock(EmailTwoFaAccountConfig.class);
    when(emailTwoFaAccountConfig2.isUseByDefault()).thenReturn(true);
    when(emailTwoFaAccountConfig2.getEmail()).thenReturn("jane.doe@example.org");
    when(emailTwoFaAccountConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(emailTwoFaAccountConfig, emailTwoFaAccountConfig2);
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaAccountConfig.equals(Object)",
    "int OtpBasedTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaAccountConfig(), null);
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OtpBasedTwoFaAccountConfig.equals(Object)",
    "int OtpBasedTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EmailTwoFaAccountConfig(), "Different type to OtpBasedTwoFaAccountConfig");
  }

  /**
   * Test {@link OtpBasedTwoFaAccountConfig#toString()}.
   *
   * <p>Method under test: {@link OtpBasedTwoFaAccountConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String OtpBasedTwoFaAccountConfig.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EmailTwoFaAccountConfig(email=null)", new EmailTwoFaAccountConfig().toString());
  }
}
