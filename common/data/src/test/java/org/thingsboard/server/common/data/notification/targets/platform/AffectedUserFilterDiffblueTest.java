package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AffectedUserFilterDiffblueTest {
  /**
   * Test {@link AffectedUserFilter#equals(Object)}, and
   * {@link AffectedUserFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AffectedUserFilter#equals(Object)}
   *   <li>{@link AffectedUserFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AffectedUserFilter affectedUserFilter = new AffectedUserFilter();
    AffectedUserFilter affectedUserFilter2 = new AffectedUserFilter();

    // Act and Assert
    assertEquals(affectedUserFilter, affectedUserFilter2);
    int expectedHashCodeResult = affectedUserFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedUserFilter2.hashCode());
  }

  /**
   * Test {@link AffectedUserFilter#equals(Object)}, and
   * {@link AffectedUserFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AffectedUserFilter#equals(Object)}
   *   <li>{@link AffectedUserFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AffectedUserFilter affectedUserFilter = new AffectedUserFilter();

    // Act and Assert
    assertEquals(affectedUserFilter, affectedUserFilter);
    int expectedHashCodeResult = affectedUserFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedUserFilter.hashCode());
  }

  /**
   * Test {@link AffectedUserFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AffectedUserFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedUserFilter(), 1);
  }

  /**
   * Test {@link AffectedUserFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AffectedUserFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedUserFilter(), null);
  }

  /**
   * Test {@link AffectedUserFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AffectedUserFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedUserFilter(), "Different type to AffectedUserFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AffectedUserFilter}
   *   <li>{@link AffectedUserFilter#toString()}
   *   <li>{@link AffectedUserFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AffectedUserFilter actualAffectedUserFilter = new AffectedUserFilter();
    String actualToStringResult = actualAffectedUserFilter.toString();

    // Assert
    assertEquals("AffectedUserFilter()", actualToStringResult);
    assertEquals(UsersFilterType.AFFECTED_USER, actualAffectedUserFilter.getType());
  }
}
