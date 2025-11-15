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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TwoFaAccountConfigDiffblueTest {
  /**
   * Method under test: {@link TwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new BackupCodeTwoFaAccountConfig()).canEqual("Other"));
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act and Assert
    assertTrue(backupCodeTwoFaAccountConfig.canEqual(new BackupCodeTwoFaAccountConfig()));
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act and Assert
    assertEquals(backupCodeTwoFaAccountConfig, backupCodeTwoFaAccountConfig);
    int expectedHashCodeResult = backupCodeTwoFaAccountConfig.hashCode();
    assertEquals(expectedHashCodeResult, backupCodeTwoFaAccountConfig.hashCode());
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackupCodeTwoFaAccountConfig(), null);
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BackupCodeTwoFaAccountConfig(), "Different type to TwoFaAccountConfig");
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#isSerializeHiddenFields()}
   */
  @Test
  void testIsSerializeHiddenFields() {
    // Arrange, Act and Assert
    assertFalse((new BackupCodeTwoFaAccountConfig()).isSerializeHiddenFields());
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#isSerializeHiddenFields()}
   */
  @Test
  void testIsSerializeHiddenFields2() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);

    // Act and Assert
    assertTrue(backupCodeTwoFaAccountConfig.isSerializeHiddenFields());
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#isUseByDefault()}
   */
  @Test
  void testIsUseByDefault() {
    // Arrange, Act and Assert
    assertFalse((new BackupCodeTwoFaAccountConfig()).isUseByDefault());
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#isUseByDefault()}
   */
  @Test
  void testIsUseByDefault2() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertTrue(backupCodeTwoFaAccountConfig.isUseByDefault());
  }

  /**
   * Method under test:
   * {@link TwoFaAccountConfig#setSerializeHiddenFields(boolean)}
   */
  @Test
  void testSetSerializeHiddenFields() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act
    backupCodeTwoFaAccountConfig.setSerializeHiddenFields(true);

    // Assert
    assertTrue(backupCodeTwoFaAccountConfig.isSerializeHiddenFields());
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#setUseByDefault(boolean)}
   */
  @Test
  void testSetUseByDefault() {
    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();

    // Act
    backupCodeTwoFaAccountConfig.setUseByDefault(true);

    // Assert
    assertTrue(backupCodeTwoFaAccountConfig.isUseByDefault());
  }

  /**
   * Method under test: {@link TwoFaAccountConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("BackupCodeTwoFaAccountConfig(codes=null)", (new BackupCodeTwoFaAccountConfig()).toString());
  }
}
