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
package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class LastVisitedDashboardInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LastVisitedDashboardInfo#equals(Object)}
   *   <li>{@link LastVisitedDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LastVisitedDashboardInfo#equals(Object)}
   *   <li>{@link LastVisitedDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo.hashCode());
  }

  /**
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(UUID.randomUUID());
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(3L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(false);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, null);
  }

  /**
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, "Different type to LastVisitedDashboardInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LastVisitedDashboardInfo}
   *   <li>{@link LastVisitedDashboardInfo#setLastVisited(long)}
   *   <li>{@link LastVisitedDashboardInfo#setStarred(boolean)}
   *   <li>{@link LastVisitedDashboardInfo#toString()}
   *   <li>{@link LastVisitedDashboardInfo#getLastVisited()}
   *   <li>{@link LastVisitedDashboardInfo#isStarred()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LastVisitedDashboardInfo actualLastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    actualLastVisitedDashboardInfo.setLastVisited(1L);
    actualLastVisitedDashboardInfo.setStarred(true);
    String actualToStringResult = actualLastVisitedDashboardInfo.toString();
    long actualLastVisited = actualLastVisitedDashboardInfo.getLastVisited();

    // Assert that nothing has changed
    assertEquals("LastVisitedDashboardInfo(starred=true, lastVisited=1)", actualToStringResult);
    assertEquals(1L, actualLastVisited);
    assertTrue(actualLastVisitedDashboardInfo.isStarred());
  }
}
