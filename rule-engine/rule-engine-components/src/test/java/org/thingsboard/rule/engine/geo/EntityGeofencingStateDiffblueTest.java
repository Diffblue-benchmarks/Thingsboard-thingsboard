package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityGeofencingStateDiffblueTest {
  /**
   * Test {@link EntityGeofencingState#equals(Object)}, and {@link EntityGeofencingState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityGeofencingState#equals(Object)}
   *   <li>{@link EntityGeofencingState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityGeofencingState entityGeofencingState = new EntityGeofencingState(true, 1L, true);
    EntityGeofencingState entityGeofencingState2 = new EntityGeofencingState(true, 1L, true);

    // Act and Assert
    assertEquals(entityGeofencingState, entityGeofencingState2);
    int expectedHashCodeResult = entityGeofencingState.hashCode();
    assertEquals(expectedHashCodeResult, entityGeofencingState2.hashCode());
  }

  /**
   * Test {@link EntityGeofencingState#equals(Object)}, and {@link EntityGeofencingState#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityGeofencingState#equals(Object)}
   *   <li>{@link EntityGeofencingState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityGeofencingState entityGeofencingState = new EntityGeofencingState(true, 1L, true);

    // Act and Assert
    assertEquals(entityGeofencingState, entityGeofencingState);
    int expectedHashCodeResult = entityGeofencingState.hashCode();
    assertEquals(expectedHashCodeResult, entityGeofencingState.hashCode());
  }

  /**
   * Test {@link EntityGeofencingState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityGeofencingState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityGeofencingState entityGeofencingState = new EntityGeofencingState(false, 1L, true);

    // Act and Assert
    assertNotEquals(entityGeofencingState, new EntityGeofencingState(true, 1L, true));
  }

  /**
   * Test {@link EntityGeofencingState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityGeofencingState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityGeofencingState entityGeofencingState = new EntityGeofencingState(true, 3L, true);

    // Act and Assert
    assertNotEquals(entityGeofencingState, new EntityGeofencingState(true, 1L, true));
  }

  /**
   * Test {@link EntityGeofencingState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityGeofencingState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityGeofencingState entityGeofencingState = new EntityGeofencingState(true, 1L, false);

    // Act and Assert
    assertNotEquals(entityGeofencingState, new EntityGeofencingState(true, 1L, true));
  }

  /**
   * Test {@link EntityGeofencingState#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityGeofencingState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityGeofencingState(true, 1L, true), null);
  }

  /**
   * Test {@link EntityGeofencingState#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityGeofencingState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityGeofencingState.equals(Object)", "int EntityGeofencingState.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityGeofencingState(true, 1L, true), "Different type to EntityGeofencingState");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityGeofencingState#setInside(boolean)}
   *   <li>{@link EntityGeofencingState#setStateSwitchTime(long)}
   *   <li>{@link EntityGeofencingState#setStayed(boolean)}
   *   <li>{@link EntityGeofencingState#toString()}
   *   <li>{@link EntityGeofencingState#getStateSwitchTime()}
   *   <li>{@link EntityGeofencingState#isInside()}
   *   <li>{@link EntityGeofencingState#isStayed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EntityGeofencingState.getStateSwitchTime()", "boolean EntityGeofencingState.isInside()",
      "boolean EntityGeofencingState.isStayed()", "void EntityGeofencingState.setInside(boolean)",
      "void EntityGeofencingState.setStateSwitchTime(long)", "void EntityGeofencingState.setStayed(boolean)",
      "String EntityGeofencingState.toString()"})
  void testGettersAndSetters() {
    // Arrange
    EntityGeofencingState entityGeofencingState = new EntityGeofencingState(true, 1L, true);

    // Act
    entityGeofencingState.setInside(true);
    entityGeofencingState.setStateSwitchTime(1L);
    entityGeofencingState.setStayed(true);
    String actualToStringResult = entityGeofencingState.toString();
    long actualStateSwitchTime = entityGeofencingState.getStateSwitchTime();
    boolean actualIsInsideResult = entityGeofencingState.isInside();

    // Assert
    assertEquals("EntityGeofencingState(inside=true, stateSwitchTime=1, stayed=true)", actualToStringResult);
    assertEquals(1L, actualStateSwitchTime);
    assertTrue(actualIsInsideResult);
    assertTrue(entityGeofencingState.isStayed());
  }

  /**
   * Test {@link EntityGeofencingState#EntityGeofencingState(boolean, long, boolean)}.
   * <p>
   * Method under test: {@link EntityGeofencingState#EntityGeofencingState(boolean, long, boolean)}
   */
  @Test
  @DisplayName("Test new EntityGeofencingState(boolean, long, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityGeofencingState.<init>(boolean, long, boolean)"})
  void testNewEntityGeofencingState() {
    // Arrange and Act
    EntityGeofencingState actualEntityGeofencingState = new EntityGeofencingState(true, 1L, true);

    // Assert
    assertEquals(1L, actualEntityGeofencingState.getStateSwitchTime());
    assertTrue(actualEntityGeofencingState.isInside());
    assertTrue(actualEntityGeofencingState.isStayed());
  }
}
