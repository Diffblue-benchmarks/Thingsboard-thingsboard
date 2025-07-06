package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class BackupCodeTwoFaAccountConfigDiffblueTest {
  /**
   * Test {@link BackupCodeTwoFaAccountConfig#equals(Object)}, and {@link
   * BackupCodeTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackupCodeTwoFaAccountConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BackupCodeTwoFaAccountConfig.equals(Object)",
    "int BackupCodeTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig2 = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig2.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig2.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig2);
    int expectedHashCodeResult = backupCodeTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaAccountConfig2.hashCode());
  }

  /**
   * Test {@link BackupCodeTwoFaAccountConfig#equals(Object)}, and {@link
   * BackupCodeTwoFaAccountConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackupCodeTwoFaAccountConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BackupCodeTwoFaAccountConfig.equals(Object)",
    "int BackupCodeTwoFaAccountConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig);
    int expectedHashCodeResult = backupCodeTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaAccountConfig.hashCode());
  }

  /**
   * Test {@link BackupCodeTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BackupCodeTwoFaAccountConfig.equals(Object)",
    "int BackupCodeTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<String> codes = new HashSet<>();
    codes.add("foo");

    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(codes);
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig2 = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig2.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig2.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig2);
  }

  /**
   * Test {@link BackupCodeTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BackupCodeTwoFaAccountConfig.equals(Object)",
    "int BackupCodeTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(false);

    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig2 = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig2.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig2.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig2.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig2);
  }

  /**
   * Test {@link BackupCodeTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BackupCodeTwoFaAccountConfig.equals(Object)",
    "int BackupCodeTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, null);
  }

  /**
   * Test {@link BackupCodeTwoFaAccountConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean BackupCodeTwoFaAccountConfig.equals(Object)",
    "int BackupCodeTwoFaAccountConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setCodes(new HashSet<>());
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaAccountConfig, "Different type to BackupCodeTwoFaAccountConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BackupCodeTwoFaAccountConfig}
   *   <li>{@link BackupCodeTwoFaAccountConfig#setCodes(Set)}
   *   <li>{@link BackupCodeTwoFaAccountConfig#toString()}
   *   <li>{@link BackupCodeTwoFaAccountConfig#getCodes()}
   *   <li>{@link BackupCodeTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void BackupCodeTwoFaAccountConfig.<init>()",
    "Set BackupCodeTwoFaAccountConfig.getCodes()",
    "TwoFaProviderType BackupCodeTwoFaAccountConfig.getProviderType()",
    "void BackupCodeTwoFaAccountConfig.setCodes(Set)",
    "String BackupCodeTwoFaAccountConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BackupCodeTwoFaAccountConfig actualBackupCodeTwoFaAccountConfig =
        new BackupCodeTwoFaAccountConfig();
    HashSet<String> codes = new HashSet<>();
    actualBackupCodeTwoFaAccountConfig.setCodes(codes);
    String actualToStringResult = actualBackupCodeTwoFaAccountConfig.toString();
    Set<String> actualCodes = actualBackupCodeTwoFaAccountConfig.getCodes();

    // Assert
    assertEquals("BackupCodeTwoFaAccountConfig(codes=[])", actualToStringResult);
    assertEquals(
        TwoFaProviderType.BACKUP_CODE, actualBackupCodeTwoFaAccountConfig.getProviderType());
    assertFalse(actualBackupCodeTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualBackupCodeTwoFaAccountConfig.isUseByDefault());
    assertTrue(actualCodes.isEmpty());
    assertSame(codes, actualCodes);
  }
}
