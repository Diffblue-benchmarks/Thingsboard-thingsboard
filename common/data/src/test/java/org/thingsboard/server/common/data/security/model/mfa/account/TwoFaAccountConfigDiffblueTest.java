package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link TwoFaAccountConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@link BackupCodeTwoFaAccountConfig} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when BackupCodeTwoFaAccountConfig (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.canEqual(Object)"})
  void testCanEqual_whenBackupCodeTwoFaAccountConfig_thenReturnTrue() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act and Assert
    assertTrue(backupCodeTwoFaAccountConfig.canEqual(new BackupCodeTwoFaAccountConfig()));
  }

  /**
   * Test {@link TwoFaAccountConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BackupCodeTwoFaAccountConfig()).canEqual("Other"));
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}, and {@link TwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig2 = new BackupCodeTwoFaAccountConfig();

    // Act and Assert
    assertEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig2);
    int expectedHashCodeResult = backupCodeTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}, and {@link TwoFaAccountConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act and Assert
    assertEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig);
    int expectedHashCodeResult = backupCodeTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, emailTwoFaAccountConfig);
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig2 = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig2.isUseByDefault()).thenReturn(true);
    when(backupCodeTwoFaAccountConfig2.getCodes()).thenReturn(new HashSet<>());
    when(backupCodeTwoFaAccountConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig2);
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setUseByDefault(true);
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig2 = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig2.isUseByDefault()).thenReturn(true);
    when(backupCodeTwoFaAccountConfig2.getCodes()).thenReturn(new HashSet<>());
    when(backupCodeTwoFaAccountConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig2);
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackupCodeTwoFaAccountConfig(), null);
  }

  /**
   * Test {@link TwoFaAccountConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.equals(Object)", "int TwoFaAccountConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackupCodeTwoFaAccountConfig(), "Different type to TwoFaAccountConfig");
  }

  /**
   * Test {@link TwoFaAccountConfig#isSerializeHiddenFields()}.
   * <ul>
   *   <li>Given {@link BackupCodeTwoFaAccountConfig} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#isSerializeHiddenFields()}
   */
  @Test
  @DisplayName("Test isSerializeHiddenFields(); given BackupCodeTwoFaAccountConfig (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.isSerializeHiddenFields()"})
  void testIsSerializeHiddenFields_givenBackupCodeTwoFaAccountConfig_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BackupCodeTwoFaAccountConfig()).isSerializeHiddenFields());
  }

  /**
   * Test {@link TwoFaAccountConfig#isSerializeHiddenFields()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#isSerializeHiddenFields()}
   */
  @Test
  @DisplayName("Test isSerializeHiddenFields(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.isSerializeHiddenFields()"})
  void testIsSerializeHiddenFields_thenReturnTrue() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);

    // Act and Assert
    assertTrue(backupCodeTwoFaAccountConfig.isSerializeHiddenFields());
  }

  /**
   * Test {@link TwoFaAccountConfig#isUseByDefault()}.
   * <ul>
   *   <li>Given {@link BackupCodeTwoFaAccountConfig} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#isUseByDefault()}
   */
  @Test
  @DisplayName("Test isUseByDefault(); given BackupCodeTwoFaAccountConfig (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.isUseByDefault()"})
  void testIsUseByDefault_givenBackupCodeTwoFaAccountConfig_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BackupCodeTwoFaAccountConfig()).isUseByDefault());
  }

  /**
   * Test {@link TwoFaAccountConfig#isUseByDefault()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TwoFaAccountConfig#isUseByDefault()}
   */
  @Test
  @DisplayName("Test isUseByDefault(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TwoFaAccountConfig.isUseByDefault()"})
  void testIsUseByDefault_thenReturnTrue() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertTrue(backupCodeTwoFaAccountConfig.isUseByDefault());
  }

  /**
   * Test {@link TwoFaAccountConfig#setSerializeHiddenFields(boolean)}.
   * <p>
   * Method under test: {@link TwoFaAccountConfig#setSerializeHiddenFields(boolean)}
   */
  @Test
  @DisplayName("Test setSerializeHiddenFields(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TwoFaAccountConfig.setSerializeHiddenFields(boolean)"})
  void testSetSerializeHiddenFields() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);

    // Assert
    assertTrue(backupCodeTwoFaAccountConfig.isSerializeHiddenFields());
  }

  /**
   * Test {@link TwoFaAccountConfig#setUseByDefault(boolean)}.
   * <p>
   * Method under test: {@link TwoFaAccountConfig#setUseByDefault(boolean)}
   */
  @Test
  @DisplayName("Test setUseByDefault(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TwoFaAccountConfig.setUseByDefault(boolean)"})
  void testSetUseByDefault() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Assert
    assertTrue(backupCodeTwoFaAccountConfig.isUseByDefault());
  }

  /**
   * Test {@link TwoFaAccountConfig#toString()}.
   * <p>
   * Method under test: {@link TwoFaAccountConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TwoFaAccountConfig.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("BackupCodeTwoFaAccountConfig(codes=null)", (new BackupCodeTwoFaAccountConfig()).toString());
  }
}
