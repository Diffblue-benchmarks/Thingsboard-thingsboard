package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GeoUtilDiffblueTest {
  /**
   * Test {@link GeoUtil#distance(Coordinates, Coordinates, RangeUnit)}.
   * <ul>
   *   <li>When {@link Coordinates#Coordinates(double, double)} with latitude is ten and longitude is ten.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeoUtil#distance(Coordinates, Coordinates, RangeUnit)}
   */
  @Test
  @DisplayName("Test distance(Coordinates, Coordinates, RangeUnit); when Coordinates(double, double) with latitude is ten and longitude is ten; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double GeoUtil.distance(Coordinates, Coordinates, RangeUnit)"})
  void testDistance_whenCoordinatesWithLatitudeIsTenAndLongitudeIsTen_thenReturnZero() {
    // Arrange
    Coordinates x = new Coordinates(10.0d, 10.0d);

    // Act and Assert
    assertEquals(0.0d, GeoUtil.distance(x, new Coordinates(10.0d, 10.0d), RangeUnit.METER));
  }

  /**
   * Test {@link GeoUtil#contains(String, Coordinates)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeoUtil#contains(String, Coordinates)}
   */
  @Test
  @DisplayName("Test contains(String, Coordinates); when empty string; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeoUtil.contains(String, Coordinates)"})
  void testContains_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> GeoUtil.contains("", new Coordinates(10.0d, 10.0d)));
  }

  /**
   * Test {@link GeoUtil#contains(String, Coordinates)}.
   * <ul>
   *   <li>When space.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GeoUtil#contains(String, Coordinates)}
   */
  @Test
  @DisplayName("Test contains(String, Coordinates); when space; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean GeoUtil.contains(String, Coordinates)"})
  void testContains_whenSpace_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> GeoUtil.contains(" ", new Coordinates(10.0d, 10.0d)));
  }
}
