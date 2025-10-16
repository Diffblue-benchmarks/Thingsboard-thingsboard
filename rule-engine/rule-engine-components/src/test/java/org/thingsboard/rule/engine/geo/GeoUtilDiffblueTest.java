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
package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GeoUtilDiffblueTest {
  /**
   * Test {@link GeoUtil#distance(Coordinates, Coordinates, RangeUnit)}.
   *
   * <ul>
   *   <li>When {@link Coordinates#Coordinates(double, double)} with latitude is ten and longitude
   *       is ten.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link GeoUtil#distance(Coordinates, Coordinates, RangeUnit)}
   */
  @Test
  @DisplayName(
      "Test distance(Coordinates, Coordinates, RangeUnit); when Coordinates(double, double) with latitude is ten and longitude is ten; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double GeoUtil.distance(Coordinates, Coordinates, RangeUnit)"})
  void testDistance_whenCoordinatesWithLatitudeIsTenAndLongitudeIsTen_thenReturnZero() {
    // Arrange
    Coordinates x = new Coordinates(10.0d, 10.0d);

    // Act
    double actualDistanceResult =
        GeoUtil.distance(x, new Coordinates(10.0d, 10.0d), RangeUnit.METER);

    // Assert
    assertEquals(0.0d, actualDistanceResult);
  }

  /**
   * Test {@link GeoUtil#contains(String, Coordinates)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GeoUtil#contains(String, Coordinates)}
   */
  @Test
  @DisplayName("Test contains(String, Coordinates); when empty string; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GeoUtil.contains(String, Coordinates)"})
  void testContains_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> GeoUtil.contains("", new Coordinates(10.0d, 10.0d)));
  }

  /**
   * Test {@link GeoUtil#contains(String, Coordinates)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link GeoUtil#contains(String, Coordinates)}
   */
  @Test
  @DisplayName("Test contains(String, Coordinates); when space; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean GeoUtil.contains(String, Coordinates)"})
  void testContains_whenSpace_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> GeoUtil.contains(" ", new Coordinates(10.0d, 10.0d)));
  }
}
