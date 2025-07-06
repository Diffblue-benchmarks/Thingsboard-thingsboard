package org.thingsboard.server.dao.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.DashboardId;

public class DashboardTitleEvictEventDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(null);
    DashboardTitleEvictEvent dashboardTitleEvictEvent2 = new DashboardTitleEvictEvent(null);

    // Act and Assert
    assertEquals(dashboardTitleEvictEvent, dashboardTitleEvictEvent2);
    int expectedHashCodeResult = dashboardTitleEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, dashboardTitleEvictEvent2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent =
        new DashboardTitleEvictEvent(
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DashboardTitleEvictEvent dashboardTitleEvictEvent2 =
        new DashboardTitleEvictEvent(
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(dashboardTitleEvictEvent, dashboardTitleEvictEvent2);
    int expectedHashCodeResult = dashboardTitleEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, dashboardTitleEvictEvent2.hashCode());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent =
        new DashboardTitleEvictEvent(
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(null);

    // Act and Assert
    assertNotEquals(
        dashboardTitleEvictEvent,
        new DashboardTitleEvictEvent(
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
