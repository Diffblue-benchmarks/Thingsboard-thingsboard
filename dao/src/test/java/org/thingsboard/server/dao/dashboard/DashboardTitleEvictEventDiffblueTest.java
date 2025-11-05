package org.thingsboard.server.dao.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;

class DashboardTitleEvictEventDiffblueTest {
  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}, and {@link
   * DashboardTitleEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardTitleEvictEvent#equals(Object)}
   *   <li>{@link DashboardTitleEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(null);
    DashboardTitleEvictEvent dashboardTitleEvictEvent2 = new DashboardTitleEvictEvent(null);

    // Act and Assert
    assertEquals(dashboardTitleEvictEvent, dashboardTitleEvictEvent2);
    assertEquals(dashboardTitleEvictEvent.hashCode(), dashboardTitleEvictEvent2.hashCode());
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}, and {@link
   * DashboardTitleEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DashboardTitleEvictEvent#equals(Object)}
   *   <li>{@link DashboardTitleEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DashboardId key = new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(key);
    DashboardId key2 = new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DashboardTitleEvictEvent dashboardTitleEvictEvent2 = new DashboardTitleEvictEvent(key2);

    // Act and Assert
    assertEquals(dashboardTitleEvictEvent, dashboardTitleEvictEvent2);
    assertEquals(dashboardTitleEvictEvent.hashCode(), dashboardTitleEvictEvent2.hashCode());
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardTitleEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardId key = new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(key);

    // Act and Assert
    assertNotEquals(dashboardTitleEvictEvent, new DashboardTitleEvictEvent(null));
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardTitleEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardTitleEvictEvent(null), 1);
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DashboardTitleEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(null);
    DashboardId key = new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(dashboardTitleEvictEvent, new DashboardTitleEvictEvent(key));
  }
}
