package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;

class HomeDashboardInfoDiffblueTest {
  /**
   * Test {@link HomeDashboardInfo#equals(Object)}, and
   * {@link HomeDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(null, true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    int expectedHashCodeResult = homeDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboardInfo2.hashCode());
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}, and
   * {@link HomeDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    int expectedHashCodeResult = homeDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboardInfo2.hashCode());
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(mock(DashboardId.class), true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboardInfo(mock(DashboardId.class), true), "42");
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(mock(DashboardId.class), false);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo,
        new HomeDashboardInfo(new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true));
  }
}
