package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class StarredDashboardInfoDiffblueTest {
  /**
   * Test {@link StarredDashboardInfo#equals(Object)}, and
   * {@link StarredDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StarredDashboardInfo#equals(Object)}
   *   <li>{@link StarredDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    StarredDashboardInfo starredDashboardInfo2 = new StarredDashboardInfo();
    starredDashboardInfo2.setId(EntityId.NULL_UUID);
    starredDashboardInfo2.setStarredAt(1L);
    starredDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertEquals(starredDashboardInfo, starredDashboardInfo2);
    int expectedHashCodeResult = starredDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, starredDashboardInfo2.hashCode());
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}, and
   * {@link StarredDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StarredDashboardInfo#equals(Object)}
   *   <li>{@link StarredDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertEquals(starredDashboardInfo, starredDashboardInfo);
    int expectedHashCodeResult = starredDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, starredDashboardInfo.hashCode());
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(UUID.randomUUID());
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    StarredDashboardInfo starredDashboardInfo2 = new StarredDashboardInfo();
    starredDashboardInfo2.setId(EntityId.NULL_UUID);
    starredDashboardInfo2.setStarredAt(1L);
    starredDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, starredDashboardInfo2);
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(3L);
    starredDashboardInfo.setTitle("Dr");

    StarredDashboardInfo starredDashboardInfo2 = new StarredDashboardInfo();
    starredDashboardInfo2.setId(EntityId.NULL_UUID);
    starredDashboardInfo2.setStarredAt(1L);
    starredDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, starredDashboardInfo2);
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, null);
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, "Different type to StarredDashboardInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StarredDashboardInfo}
   *   <li>{@link StarredDashboardInfo#setStarredAt(long)}
   *   <li>{@link StarredDashboardInfo#toString()}
   *   <li>{@link StarredDashboardInfo#getStarredAt()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    StarredDashboardInfo actualStarredDashboardInfo = new StarredDashboardInfo();
    actualStarredDashboardInfo.setStarredAt(1L);
    String actualToStringResult = actualStarredDashboardInfo.toString();

    // Assert that nothing has changed
    assertEquals("StarredDashboardInfo(starredAt=1)", actualToStringResult);
    assertEquals(1L, actualStarredDashboardInfo.getStarredAt());
  }
}
