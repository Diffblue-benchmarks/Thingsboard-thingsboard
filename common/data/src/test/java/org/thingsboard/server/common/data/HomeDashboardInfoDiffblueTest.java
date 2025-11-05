package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;

class HomeDashboardInfoDiffblueTest {
  /**
   * Test {@link HomeDashboardInfo#equals(Object)}, and {@link HomeDashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HomeDashboardInfo.equals(Object)",
    "int HomeDashboardInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(null, true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    assertEquals(homeDashboardInfo.hashCode(), homeDashboardInfo2.hashCode());
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}, and {@link HomeDashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HomeDashboardInfo.equals(Object)",
    "int HomeDashboardInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DashboardId dashboardId =
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(dashboardId, true);
    DashboardId dashboardId2 =
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(dashboardId2, true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    assertEquals(homeDashboardInfo.hashCode(), homeDashboardInfo2.hashCode());
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HomeDashboardInfo.equals(Object)",
    "int HomeDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardId dashboardId =
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(dashboardId, true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HomeDashboardInfo.equals(Object)",
    "int HomeDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, false);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HomeDashboardInfo.equals(Object)",
    "int HomeDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboardInfo(null, true), 1);
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean HomeDashboardInfo.equals(Object)",
    "int HomeDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);
    DashboardId dashboardId =
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(dashboardId, true));
  }
}
