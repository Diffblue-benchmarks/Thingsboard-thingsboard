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
package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FirmwareUpdateResultDiffblueTest {
  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Initial value}.
   *   <li>Then return {@code INITIAL}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByType(String); when 'Initial value'; then return 'INITIAL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FirmwareUpdateResult FirmwareUpdateResult.fromUpdateResultFwByType(String)"})
  void testFromUpdateResultFwByType_whenInitialValue_thenReturnInitial() {
    // Arrange, Act and Assert
    assertEquals(
        FirmwareUpdateResult.INITIAL,
        FirmwareUpdateResult.fromUpdateResultFwByType("Initial value"));
  }

  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByType(String)}
   */
  @Test
  @DisplayName(
      "Test fromUpdateResultFwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FirmwareUpdateResult FirmwareUpdateResult.fromUpdateResultFwByType(String)"})
  void testFromUpdateResultFwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> FirmwareUpdateResult.fromUpdateResultFwByType("Type"));
  }

  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code UPDATE_SUCCESSFULLY}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByCode(int); when one; then return 'UPDATE_SUCCESSFULLY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FirmwareUpdateResult FirmwareUpdateResult.fromUpdateResultFwByCode(int)"})
  void testFromUpdateResultFwByCode_whenOne_thenReturnUpdateSuccessfully() {
    // Arrange, Act and Assert
    assertEquals(
        FirmwareUpdateResult.UPDATE_SUCCESSFULLY, FirmwareUpdateResult.fromUpdateResultFwByCode(1));
  }

  /**
   * Test {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link FirmwareUpdateResult#fromUpdateResultFwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateResultFwByCode(int); when ten; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FirmwareUpdateResult FirmwareUpdateResult.fromUpdateResultFwByCode(int)"})
  void testFromUpdateResultFwByCode_whenTen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> FirmwareUpdateResult.fromUpdateResultFwByCode(10));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FirmwareUpdateResult#getCode()}
   *   <li>{@link FirmwareUpdateResult#getType()}
   *   <li>{@link FirmwareUpdateResult#isAgain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int FirmwareUpdateResult.getCode()",
    "String FirmwareUpdateResult.getType()",
    "boolean FirmwareUpdateResult.isAgain()"
  })
  void testGettersAndSetters() {
    // Arrange
    FirmwareUpdateResult valueOfResult = FirmwareUpdateResult.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();

    // Assert
    assertEquals("Initial value", actualType);
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isAgain());
  }
}
