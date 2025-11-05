package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoordinatesDiffblueTest {
  /**
   * Test {@link Coordinates#equals(Object)}, and {@link Coordinates#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Coordinates#equals(Object)}
   *   <li>{@link Coordinates#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Coordinates.equals(Object)", "int Coordinates.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Coordinates coordinates = new Coordinates(10.0d, 10.0d);
    Coordinates coordinates2 = new Coordinates(10.0d, 10.0d);

    // Act and Assert
    assertEquals(coordinates, coordinates2);
    assertEquals(coordinates.hashCode(), coordinates2.hashCode());
  }

  /**
   * Test {@link Coordinates#equals(Object)}, and {@link Coordinates#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Coordinates#equals(Object)}
   *   <li>{@link Coordinates#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Coordinates.equals(Object)", "int Coordinates.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Coordinates coordinates = new Coordinates(10.0d, 10.0d);

    // Act and Assert
    assertEquals(coordinates, coordinates);
    int expectedHashCodeResult = coordinates.hashCode();
    assertEquals(expectedHashCodeResult, coordinates.hashCode());
  }

  /**
   * Test {@link Coordinates#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Coordinates#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Coordinates.equals(Object)", "int Coordinates.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Coordinates coordinates = new Coordinates(0.5d, 10.0d);

    // Act and Assert
    assertNotEquals(coordinates, new Coordinates(10.0d, 10.0d));
  }

  /**
   * Test {@link Coordinates#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Coordinates#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Coordinates.equals(Object)", "int Coordinates.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Coordinates coordinates = new Coordinates(10.0d, 0.5d);

    // Act and Assert
    assertNotEquals(coordinates, new Coordinates(10.0d, 10.0d));
  }

  /**
   * Test {@link Coordinates#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Coordinates#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Coordinates.equals(Object)", "int Coordinates.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Coordinates(10.0d, 10.0d), null);
  }

  /**
   * Test {@link Coordinates#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Coordinates#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Coordinates.equals(Object)", "int Coordinates.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Coordinates(10.0d, 10.0d), "Different type to Coordinates");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Coordinates#toString()}
   *   <li>{@link Coordinates#getLatitude()}
   *   <li>{@link Coordinates#getLongitude()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double Coordinates.getLatitude()",
    "double Coordinates.getLongitude()",
    "String Coordinates.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Coordinates coordinates = new Coordinates(10.0d, 10.0d);

    // Act
    String actualToStringResult = coordinates.toString();
    double actualLatitude = coordinates.getLatitude();

    // Assert
    assertEquals("Coordinates(latitude=10.0, longitude=10.0)", actualToStringResult);
    assertEquals(10.0d, actualLatitude);
    assertEquals(10.0d, coordinates.getLongitude());
  }

  /**
   * Test {@link Coordinates#Coordinates(double, double)}.
   *
   * <p>Method under test: {@link Coordinates#Coordinates(double, double)}
   */
  @Test
  @DisplayName("Test new Coordinates(double, double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Coordinates.<init>(double, double)"})
  void testNewCoordinates() {
    // Arrange and Act
    Coordinates actualCoordinates = new Coordinates(10.0d, 10.0d);

    // Assert
    assertEquals(10.0d, actualCoordinates.getLatitude());
    assertEquals(10.0d, actualCoordinates.getLongitude());
  }
}
