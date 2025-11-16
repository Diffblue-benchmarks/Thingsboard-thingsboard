/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.dao.model.ModelConstants;

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent =
        new DashboardTitleEvictEvent(new DashboardId(ModelConstants.NULL_UUID));
    DashboardTitleEvictEvent dashboardTitleEvictEvent2 =
        new DashboardTitleEvictEvent(new DashboardId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DashboardTitleEvictEvent.equals(Object)",
    "int DashboardTitleEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DashboardTitleEvictEvent dashboardTitleEvictEvent =
        new DashboardTitleEvictEvent(new DashboardId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
        new DashboardTitleEvictEvent(new DashboardId(ModelConstants.NULL_UUID)));
  }
}
