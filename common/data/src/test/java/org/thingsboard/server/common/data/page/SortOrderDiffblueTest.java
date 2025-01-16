package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortOrderDiffblueTest {
  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;
    SortOrder sortOrder2 = SortOrder.BY_CREATED_TIME_DESC;

    // Act and Assert
    assertEquals(sortOrder, sortOrder2);
    int expectedHashCodeResult = sortOrder.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder2.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SortOrder ofResult = SortOrder.of("Property", SortOrder.Direction.ASC);
    SortOrder sortOrder = new SortOrder("Property");

    // Act and Assert
    assertEquals(ofResult, sortOrder);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;

    // Act and Assert
    assertEquals(sortOrder, sortOrder);
    int expectedHashCodeResult = sortOrder.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.of("Property", SortOrder.Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
    assertNotEquals(SortOrder.of("createdTime", SortOrder.Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
    assertNotEquals(SortOrder.of(null, SortOrder.Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
    assertNotEquals(SortOrder.of("createdTime", null), SortOrder.BY_CREATED_TIME_DESC);
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.BY_CREATED_TIME_DESC, null);
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.BY_CREATED_TIME_DESC, "Different type to SortOrder");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#SortOrder(String, SortOrder.Direction)}
   *   <li>{@link SortOrder#toString()}
   *   <li>{@link SortOrder#getDirection()}
   *   <li>{@link SortOrder#getProperty()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    SortOrder actualSortOrder = new SortOrder("Property", SortOrder.Direction.ASC);
    String actualToStringResult = actualSortOrder.toString();
    SortOrder.Direction actualDirection = actualSortOrder.getDirection();

    // Assert
    assertEquals("Property", actualSortOrder.getProperty());
    assertEquals("SortOrder(property=Property, direction=ASC)", actualToStringResult);
    assertEquals(SortOrder.Direction.ASC, actualDirection);
  }

  /**
   * Test {@link SortOrder#SortOrder(String)}.
   * <p>
   * Method under test: {@link SortOrder#SortOrder(String)}
   */
  @Test
  @DisplayName("Test new SortOrder(String)")
  void testNewSortOrder() {
    // Arrange and Act
    SortOrder actualSortOrder = new SortOrder("Property");

    // Assert
    assertEquals("Property", actualSortOrder.getProperty());
    assertEquals(SortOrder.Direction.ASC, actualSortOrder.getDirection());
  }

  /**
   * Test {@link SortOrder#of(String, Direction)}.
   * <p>
   * Method under test: {@link SortOrder#of(String, SortOrder.Direction)}
   */
  @Test
  @DisplayName("Test of(String, Direction)")
  void testOf() {
    // Arrange and Act
    SortOrder actualOfResult = SortOrder.of("Property", SortOrder.Direction.ASC);

    // Assert
    assertEquals("Property", actualOfResult.getProperty());
    assertEquals(SortOrder.Direction.ASC, actualOfResult.getDirection());
  }
}
