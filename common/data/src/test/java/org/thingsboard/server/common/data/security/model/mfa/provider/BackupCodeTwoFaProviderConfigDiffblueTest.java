/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.security.model.mfa.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BackupCodeTwoFaProviderConfigDiffblueTest {
  /**
   * Test {@link BackupCodeTwoFaProviderConfig#equals(Object)}, and {@link BackupCodeTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackupCodeTwoFaProviderConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackupCodeTwoFaProviderConfig.equals(Object)",
      "int BackupCodeTwoFaProviderConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(1);

    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig2 = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig2.setCodesQuantity(1);

    // Act and Assert
    assertEquals(backupCodeTwoFaProviderConfig, backupCodeTwoFaProviderConfig2);
    int expectedHashCodeResult = backupCodeTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaProviderConfig2.hashCode());
  }

  /**
   * Test {@link BackupCodeTwoFaProviderConfig#equals(Object)}, and {@link BackupCodeTwoFaProviderConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BackupCodeTwoFaProviderConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackupCodeTwoFaProviderConfig.equals(Object)",
      "int BackupCodeTwoFaProviderConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(1);

    // Act and Assert
    assertEquals(backupCodeTwoFaProviderConfig, backupCodeTwoFaProviderConfig);
    int expectedHashCodeResult = backupCodeTwoFaProviderConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaProviderConfig.hashCode());
  }

  /**
   * Test {@link BackupCodeTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackupCodeTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackupCodeTwoFaProviderConfig.equals(Object)",
      "int BackupCodeTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(3);

    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig2 = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig2.setCodesQuantity(1);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaProviderConfig, backupCodeTwoFaProviderConfig2);
  }

  /**
   * Test {@link BackupCodeTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackupCodeTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackupCodeTwoFaProviderConfig.equals(Object)",
      "int BackupCodeTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(1);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaProviderConfig, null);
  }

  /**
   * Test {@link BackupCodeTwoFaProviderConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BackupCodeTwoFaProviderConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BackupCodeTwoFaProviderConfig.equals(Object)",
      "int BackupCodeTwoFaProviderConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(1);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaProviderConfig, "Different type to BackupCodeTwoFaProviderConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BackupCodeTwoFaProviderConfig}
   *   <li>{@link BackupCodeTwoFaProviderConfig#setCodesQuantity(int)}
   *   <li>{@link BackupCodeTwoFaProviderConfig#toString()}
   *   <li>{@link BackupCodeTwoFaProviderConfig#getCodesQuantity()}
   *   <li>{@link BackupCodeTwoFaProviderConfig#getProviderType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BackupCodeTwoFaProviderConfig.<init>()",
      "int BackupCodeTwoFaProviderConfig.getCodesQuantity()",
      "TwoFaProviderType BackupCodeTwoFaProviderConfig.getProviderType()",
      "void BackupCodeTwoFaProviderConfig.setCodesQuantity(int)", "String BackupCodeTwoFaProviderConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    BackupCodeTwoFaProviderConfig actualBackupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    actualBackupCodeTwoFaProviderConfig.setCodesQuantity(1);
    String actualToStringResult = actualBackupCodeTwoFaProviderConfig.toString();
    int actualCodesQuantity = actualBackupCodeTwoFaProviderConfig.getCodesQuantity();

    // Assert
    assertEquals("BackupCodeTwoFaProviderConfig(codesQuantity=1)", actualToStringResult);
    assertEquals(1, actualCodesQuantity);
    assertEquals(TwoFaProviderType.BACKUP_CODE, actualBackupCodeTwoFaProviderConfig.getProviderType());
  }
}
