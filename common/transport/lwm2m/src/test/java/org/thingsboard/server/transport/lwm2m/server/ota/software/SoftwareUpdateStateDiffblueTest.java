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
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SoftwareUpdateStateDiffblueTest {
  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}.
   * <ul>
   *   <li>When {@code Initial}.</li>
   *   <li>Then return {@code INITIAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByType(String); when 'Initial'; then return 'INITIAL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByType(String)"})
  void testFromUpdateStateSwByType_whenInitial_thenReturnInitial() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateState.INITIAL, SoftwareUpdateState.fromUpdateStateSwByType("Initial"));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByType(String)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByType(String)"})
  void testFromUpdateStateSwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByType("Type"));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByCode(int); when five; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByCode(int)"})
  void testFromUpdateStateSwByCode_whenFive_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> SoftwareUpdateState.fromUpdateStateSwByCode(5));
  }

  /**
   * Test {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code DOWNLOAD_STARTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SoftwareUpdateState#fromUpdateStateSwByCode(int)}
   */
  @Test
  @DisplayName("Test fromUpdateStateSwByCode(int); when one; then return 'DOWNLOAD_STARTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SoftwareUpdateState SoftwareUpdateState.fromUpdateStateSwByCode(int)"})
  void testFromUpdateStateSwByCode_whenOne_thenReturnDownloadStarted() {
    // Arrange, Act and Assert
    assertEquals(SoftwareUpdateState.DOWNLOAD_STARTED, SoftwareUpdateState.fromUpdateStateSwByCode(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SoftwareUpdateState#getCode()}
   *   <li>{@link SoftwareUpdateState#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SoftwareUpdateState.getCode()", "String SoftwareUpdateState.getType()"})
  void testGettersAndSetters() {
    // Arrange
    SoftwareUpdateState valueOfResult = SoftwareUpdateState.valueOf("INITIAL");

    // Act
    int actualCode = valueOfResult.getCode();

    // Assert
    assertEquals("Initial", valueOfResult.getType());
    assertEquals(0, actualCode);
  }
}
