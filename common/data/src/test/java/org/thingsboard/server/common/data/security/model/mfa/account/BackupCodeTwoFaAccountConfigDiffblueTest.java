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
package org.thingsboard.server.common.data.security.model.mfa.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;

class BackupCodeTwoFaAccountConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackupCodeTwoFaAccountConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link BackupCodeTwoFaAccountConfig#equals(Object)}
   *   <li>{@link BackupCodeTwoFaAccountConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link BackupCodeTwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BackupCodeTwoFaAccountConfig}
   *   <li>{@link BackupCodeTwoFaAccountConfig#setCodes(Set)}
   *   <li>{@link BackupCodeTwoFaAccountConfig#toString()}
   *   <li>{@link BackupCodeTwoFaAccountConfig#getCodes()}
   *   <li>{@link BackupCodeTwoFaAccountConfig#getProviderType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BackupCodeTwoFaAccountConfig actualBackupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    HashSet<String> codes = new HashSet<>();
    actualBackupCodeTwoFaAccountConfig.setCodes(codes);
    String actualToStringResult = actualBackupCodeTwoFaAccountConfig.toString();
    Set<String> actualCodes = actualBackupCodeTwoFaAccountConfig.getCodes();

    // Assert that nothing has changed
    assertEquals("BackupCodeTwoFaAccountConfig(codes=[])", actualToStringResult);
    assertEquals(TwoFaProviderType.BACKUP_CODE, actualBackupCodeTwoFaAccountConfig.getProviderType());
    assertFalse(actualBackupCodeTwoFaAccountConfig.isSerializeHiddenFields());
    assertFalse(actualBackupCodeTwoFaAccountConfig.isUseByDefault());
    assertTrue(actualCodes.isEmpty());
    assertSame(codes, actualCodes);
  }
}
