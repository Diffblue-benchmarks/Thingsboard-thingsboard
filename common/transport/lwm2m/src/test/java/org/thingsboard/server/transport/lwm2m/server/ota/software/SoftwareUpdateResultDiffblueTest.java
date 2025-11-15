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
package org.thingsboard.server.transport.lwm2m.server.ota.software;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SoftwareUpdateResultDiffblueTest {
  /**
   * Test {@link SoftwareUpdateResult#fromUpdateResultSwByType(String)}.
   * <ul>
   *   <li>When {@code Initial value}.</li>
   *   <li>Then return {@code INITIAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateResult#fromUpdateResultSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateResultSwByType(String); when 'Initial value'; then return 'INITIAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateResult SoftwareUpdateResult.fromUpdateResultSwByType(String)"})
  void testFromUpdateResultSwByType_whenInitialValue_thenReturnInitial() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateResult.INITIAL, SoftwareUpdateResult.fromUpdateResultSwByType("Initial value"));
  }

  /**
   * Test {@link SoftwareUpdateResult#fromUpdateResultSwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateResult#fromUpdateResultSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateResultSwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateResult SoftwareUpdateResult.fromUpdateResultSwByType(String)"})
  void testFromUpdateResultSwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateResult.fromUpdateResultSwByType("Type"));
  }

  /**
   * Test {@link SoftwareUpdateResult#fromUpdateResultSwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DOWNLOADING}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateResult#fromUpdateResultSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateResultSwByCode(int); when one; then return 'DOWNLOADING'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateResult SoftwareUpdateResult.fromUpdateResultSwByCode(int)"})
  void testFromUpdateResultSwByCode_whenOne_thenReturnDownloading() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateResult.DOWNLOADING, SoftwareUpdateResult.fromUpdateResultSwByCode(1));
  }

  /**
   * Test {@link SoftwareUpdateResult#fromUpdateResultSwByCode(int)}.
   * <ul>
   *   <li>When thirteen.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateResult#fromUpdateResultSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateResultSwByCode(int); when thirteen; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateResult SoftwareUpdateResult.fromUpdateResultSwByCode(int)"})
  void testFromUpdateResultSwByCode_whenThirteen_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateResult.fromUpdateResultSwByCode(13));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SoftwareUpdateResult#getCode()}
   *   <li>{@link SoftwareUpdateResult#getType()}
   *   <li>{@link SoftwareUpdateResult#isAgain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SoftwareUpdateResult.getCode()", "String SoftwareUpdateResult.getType()",
      "boolean SoftwareUpdateResult.isAgain()"})
  void testGettersAndSetters() {
    // Arrange
    SoftwareUpdateResult valueOfResult = SoftwareUpdateResult.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();

    // Assert
    assertEquals("Initial value", actualType);
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isAgain());
  }
}
