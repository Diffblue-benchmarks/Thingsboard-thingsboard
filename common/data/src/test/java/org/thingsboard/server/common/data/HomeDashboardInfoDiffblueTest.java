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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;

class HomeDashboardInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true);
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    int expectedHashCodeResult = homeDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboardInfo2.hashCode());
  }

  /**
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(mock(DashboardId.class), true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboardInfo(mock(DashboardId.class), true), "42");
  }

  /**
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(mock(DashboardId.class), false);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true));
  }
}
