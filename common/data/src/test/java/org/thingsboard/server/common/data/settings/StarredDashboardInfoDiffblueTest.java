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
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class StarredDashboardInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StarredDashboardInfo#equals(Object)}
   *   <li>{@link StarredDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link StarredDashboardInfo#equals(Object)}
   *   <li>{@link StarredDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StarredDashboardInfo}
   *   <li>{@link StarredDashboardInfo#setStarredAt(long)}
   *   <li>{@link StarredDashboardInfo#toString()}
   *   <li>{@link StarredDashboardInfo#getStarredAt()}
   * </ul>
   */
  @Test
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
