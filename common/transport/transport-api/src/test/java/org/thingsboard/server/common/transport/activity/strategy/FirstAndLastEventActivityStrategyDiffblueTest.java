package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstAndLastEventActivityStrategyDiffblueTest {
  /**
   * Test {@link FirstAndLastEventActivityStrategy#onActivity()}.
   * <p>
   * Method under test: {@link FirstAndLastEventActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue((new FirstAndLastEventActivityStrategy()).onActivity());
  }

  /**
   * Test {@link FirstAndLastEventActivityStrategy#equals(Object)}, and
   * {@link FirstAndLastEventActivityStrategy#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FirstAndLastEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstAndLastEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FirstAndLastEventActivityStrategy firstAndLastEventActivityStrategy = new FirstAndLastEventActivityStrategy();
    FirstAndLastEventActivityStrategy firstAndLastEventActivityStrategy2 = new FirstAndLastEventActivityStrategy();

    // Act and Assert
    assertEquals(firstAndLastEventActivityStrategy, firstAndLastEventActivityStrategy2);
    int expectedHashCodeResult = firstAndLastEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstAndLastEventActivityStrategy2.hashCode());
  }

  /**
   * Test {@link FirstAndLastEventActivityStrategy#equals(Object)}, and
   * {@link FirstAndLastEventActivityStrategy#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FirstAndLastEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstAndLastEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FirstAndLastEventActivityStrategy firstAndLastEventActivityStrategy = new FirstAndLastEventActivityStrategy();

    // Act and Assert
    assertEquals(firstAndLastEventActivityStrategy, firstAndLastEventActivityStrategy);
    int expectedHashCodeResult = firstAndLastEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstAndLastEventActivityStrategy.hashCode());
  }

  /**
   * Test {@link FirstAndLastEventActivityStrategy#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstAndLastEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstAndLastEventActivityStrategy(), 1);
  }

  /**
   * Test {@link FirstAndLastEventActivityStrategy#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstAndLastEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstAndLastEventActivityStrategy(), null);
  }

  /**
   * Test {@link FirstAndLastEventActivityStrategy#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FirstAndLastEventActivityStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstAndLastEventActivityStrategy(), "Different type to FirstAndLastEventActivityStrategy");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FirstAndLastEventActivityStrategy}
   *   <li>{@link FirstAndLastEventActivityStrategy#onReportingPeriodEnd()}
   *   <li>{@link FirstAndLastEventActivityStrategy#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    FirstAndLastEventActivityStrategy actualFirstAndLastEventActivityStrategy = new FirstAndLastEventActivityStrategy();
    boolean actualOnReportingPeriodEndResult = actualFirstAndLastEventActivityStrategy.onReportingPeriodEnd();

    // Assert
    assertEquals("FirstAndLastEventActivityStrategy(firstEventReceived=false)",
        actualFirstAndLastEventActivityStrategy.toString());
    assertTrue(actualOnReportingPeriodEndResult);
  }
}
