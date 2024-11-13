package org.thingsboard.server.dao.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DashboardTitleEvictEventDiffblueTest {
  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}, and
   * {@link DashboardTitleEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardTitleEvictEvent#equals(Object)}
   *   <li>{@link DashboardTitleEvictEvent#hashCode()}
   * </ul>
   */
  @Test
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
   * Test {@link DashboardTitleEvictEvent#equals(Object)}, and
   * {@link DashboardTitleEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DashboardTitleEvictEvent#equals(Object)}
   *   <li>{@link DashboardTitleEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(
        new DashboardId(ModelConstants.NULL_UUID));
    DashboardTitleEvictEvent dashboardTitleEvictEvent2 = new DashboardTitleEvictEvent(
        new DashboardId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertEquals(dashboardTitleEvictEvent, dashboardTitleEvictEvent2);
    int expectedHashCodeResult = dashboardTitleEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, dashboardTitleEvictEvent2.hashCode());
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardTitleEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(mock(DashboardId.class));

    // Act and Assert
    assertNotEquals(dashboardTitleEvictEvent, new DashboardTitleEvictEvent(null));
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardTitleEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DashboardTitleEvictEvent(mock(DashboardId.class)), "42");
  }

  /**
   * Test {@link DashboardTitleEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardTitleEvictEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent = new DashboardTitleEvictEvent(null);

    // Act and Assert
    assertNotEquals(dashboardTitleEvictEvent, new DashboardTitleEvictEvent(new DashboardId(ModelConstants.NULL_UUID)));
  }
}
