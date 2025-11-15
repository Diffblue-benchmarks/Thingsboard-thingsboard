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
import org.junit.jupiter.api.Test;

class BackupCodeTwoFaProviderConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackupCodeTwoFaProviderConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link BackupCodeTwoFaProviderConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaProviderConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link BackupCodeTwoFaProviderConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link BackupCodeTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(1);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaProviderConfig, null);
  }

  /**
   * Method under test: {@link BackupCodeTwoFaProviderConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BackupCodeTwoFaProviderConfig backupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    backupCodeTwoFaProviderConfig.setCodesQuantity(1);

    // Act and Assert
    assertNotEquals(backupCodeTwoFaProviderConfig, "Different type to BackupCodeTwoFaProviderConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BackupCodeTwoFaProviderConfig}
   *   <li>{@link BackupCodeTwoFaProviderConfig#setCodesQuantity(int)}
   *   <li>{@link BackupCodeTwoFaProviderConfig#toString()}
   *   <li>{@link BackupCodeTwoFaProviderConfig#getCodesQuantity()}
   *   <li>{@link BackupCodeTwoFaProviderConfig#getProviderType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BackupCodeTwoFaProviderConfig actualBackupCodeTwoFaProviderConfig = new BackupCodeTwoFaProviderConfig();
    actualBackupCodeTwoFaProviderConfig.setCodesQuantity(1);
    String actualToStringResult = actualBackupCodeTwoFaProviderConfig.toString();
    int actualCodesQuantity = actualBackupCodeTwoFaProviderConfig.getCodesQuantity();

    // Assert that nothing has changed
    assertEquals("BackupCodeTwoFaProviderConfig(codesQuantity=1)", actualToStringResult);
    assertEquals(1, actualCodesQuantity);
    assertEquals(TwoFaProviderType.BACKUP_CODE, actualBackupCodeTwoFaProviderConfig.getProviderType());
  }
}
