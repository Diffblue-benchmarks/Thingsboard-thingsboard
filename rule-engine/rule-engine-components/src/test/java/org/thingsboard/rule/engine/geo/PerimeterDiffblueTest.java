package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PerimeterDiffblueTest {
  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(null);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(null);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(null);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(null);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(null);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(null);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition(null);
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition(null);
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(null);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(null);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(null);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(null);

    // Act and Assert
    assertEquals(perimeter, perimeter2);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter2.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}, and {@link Perimeter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Perimeter#equals(Object)}
   *   <li>{@link Perimeter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertEquals(perimeter, perimeter);
    int expectedHashCodeResult = perimeter.hashCode();
    assertEquals(expectedHashCodeResult, perimeter.hashCode());
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(null);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(0.5d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(null);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(0.5d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(null);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.POLYGON);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition(null);
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("org.thingsboard.rule.engine.geo.Perimeter");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(null);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(0.5d);
    perimeter.setRangeUnit(RangeUnit.METER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(null);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.KILOMETER);

    Perimeter perimeter2 = new Perimeter();
    perimeter2.setCenterLatitude(10.0d);
    perimeter2.setCenterLongitude(10.0d);
    perimeter2.setPerimeterType(PerimeterType.CIRCLE);
    perimeter2.setPolygonsDefinition("Polygons Definition");
    perimeter2.setRange(10.0d);
    perimeter2.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, perimeter2);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, null);
  }

  /**
   * Test {@link Perimeter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Perimeter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Perimeter.equals(Object)", "int Perimeter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Perimeter perimeter = new Perimeter();
    perimeter.setCenterLatitude(10.0d);
    perimeter.setCenterLongitude(10.0d);
    perimeter.setPerimeterType(PerimeterType.CIRCLE);
    perimeter.setPolygonsDefinition("Polygons Definition");
    perimeter.setRange(10.0d);
    perimeter.setRangeUnit(RangeUnit.METER);

    // Act and Assert
    assertNotEquals(perimeter, "Different type to Perimeter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Perimeter}
   *   <li>{@link Perimeter#setCenterLatitude(Double)}
   *   <li>{@link Perimeter#setCenterLongitude(Double)}
   *   <li>{@link Perimeter#setPerimeterType(PerimeterType)}
   *   <li>{@link Perimeter#setPolygonsDefinition(String)}
   *   <li>{@link Perimeter#setRange(Double)}
   *   <li>{@link Perimeter#setRangeUnit(RangeUnit)}
   *   <li>{@link Perimeter#toString()}
   *   <li>{@link Perimeter#getCenterLatitude()}
   *   <li>{@link Perimeter#getCenterLongitude()}
   *   <li>{@link Perimeter#getPerimeterType()}
   *   <li>{@link Perimeter#getPolygonsDefinition()}
   *   <li>{@link Perimeter#getRange()}
   *   <li>{@link Perimeter#getRangeUnit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Perimeter.<init>()",
    "Double Perimeter.getCenterLatitude()",
    "Double Perimeter.getCenterLongitude()",
    "PerimeterType Perimeter.getPerimeterType()",
    "String Perimeter.getPolygonsDefinition()",
    "Double Perimeter.getRange()",
    "RangeUnit Perimeter.getRangeUnit()",
    "void Perimeter.setCenterLatitude(Double)",
    "void Perimeter.setCenterLongitude(Double)",
    "void Perimeter.setPerimeterType(PerimeterType)",
    "void Perimeter.setPolygonsDefinition(String)",
    "void Perimeter.setRange(Double)",
    "void Perimeter.setRangeUnit(RangeUnit)",
    "String Perimeter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Perimeter actualPerimeter = new Perimeter();
    actualPerimeter.setCenterLatitude(10.0d);
    actualPerimeter.setCenterLongitude(10.0d);
    actualPerimeter.setPerimeterType(PerimeterType.CIRCLE);
    actualPerimeter.setPolygonsDefinition("Polygons Definition");
    actualPerimeter.setRange(10.0d);
    actualPerimeter.setRangeUnit(RangeUnit.METER);
    String actualToStringResult = actualPerimeter.toString();
    Double actualCenterLatitude = actualPerimeter.getCenterLatitude();
    Double actualCenterLongitude = actualPerimeter.getCenterLongitude();
    PerimeterType actualPerimeterType = actualPerimeter.getPerimeterType();
    String actualPolygonsDefinition = actualPerimeter.getPolygonsDefinition();
    Double actualRange = actualPerimeter.getRange();
    RangeUnit actualRangeUnit = actualPerimeter.getRangeUnit();

    // Assert
    assertEquals(
        "Perimeter(perimeterType=CIRCLE, polygonsDefinition=Polygons Definition, centerLatitude=10.0,"
            + " centerLongitude=10.0, range=10.0, rangeUnit=METER)",
        actualToStringResult);
    assertEquals("Polygons Definition", actualPolygonsDefinition);
    assertEquals(10.0d, actualCenterLatitude.doubleValue());
    assertEquals(10.0d, actualCenterLongitude.doubleValue());
    assertEquals(10.0d, actualRange.doubleValue());
    assertEquals(PerimeterType.CIRCLE, actualPerimeterType);
    assertEquals(RangeUnit.METER, actualRangeUnit);
  }
}
