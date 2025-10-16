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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MSoftwareUpdateStrategyDiffblueTest {
  /**
   * Test {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByType(String)}.
   *
   * <ul>
   *   <li>When {@code ObjectId 9, Binary}.
   *   <li>Then return {@code BINARY}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByType(String)}
   */
  @Test
  @DisplayName("Test fromStrategySwByType(String); when 'ObjectId 9, Binary'; then return 'BINARY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2MSoftwareUpdateStrategy LwM2MSoftwareUpdateStrategy.fromStrategySwByType(String)"
  })
  void testFromStrategySwByType_whenObjectId9Binary_thenReturnBinary() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MSoftwareUpdateStrategy.BINARY,
        LwM2MSoftwareUpdateStrategy.fromStrategySwByType("ObjectId 9, Binary"));
  }

  /**
   * Test {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByType(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByType(String)}
   */
  @Test
  @DisplayName(
      "Test fromStrategySwByType(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2MSoftwareUpdateStrategy LwM2MSoftwareUpdateStrategy.fromStrategySwByType(String)"
  })
  void testFromStrategySwByType_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> LwM2MSoftwareUpdateStrategy.fromStrategySwByType("Type"));
  }

  /**
   * Test {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByCode(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code BINARY}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStrategySwByCode(int); when one; then return 'BINARY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2MSoftwareUpdateStrategy LwM2MSoftwareUpdateStrategy.fromStrategySwByCode(int)"
  })
  void testFromStrategySwByCode_whenOne_thenReturnBinary() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MSoftwareUpdateStrategy.BINARY, LwM2MSoftwareUpdateStrategy.fromStrategySwByCode(1));
  }

  /**
   * Test {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByCode(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code TEMP_URL}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStrategySwByCode(int); when two; then return 'TEMP_URL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2MSoftwareUpdateStrategy LwM2MSoftwareUpdateStrategy.fromStrategySwByCode(int)"
  })
  void testFromStrategySwByCode_whenTwo_thenReturnTempUrl() {
    // Arrange, Act and Assert
    assertEquals(
        LwM2MSoftwareUpdateStrategy.TEMP_URL, LwM2MSoftwareUpdateStrategy.fromStrategySwByCode(2));
  }

  /**
   * Test {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByCode(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MSoftwareUpdateStrategy#fromStrategySwByCode(int)}
   */
  @Test
  @DisplayName("Test fromStrategySwByCode(int); when zero; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LwM2MSoftwareUpdateStrategy LwM2MSoftwareUpdateStrategy.fromStrategySwByCode(int)"
  })
  void testFromStrategySwByCode_whenZero_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> LwM2MSoftwareUpdateStrategy.fromStrategySwByCode(0));
  }
}
