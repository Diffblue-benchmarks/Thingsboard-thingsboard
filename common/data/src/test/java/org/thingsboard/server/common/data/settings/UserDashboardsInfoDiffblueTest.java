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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;

class UserDashboardsInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserDashboardsInfo#equals(Object)}
   *   <li>{@link UserDashboardsInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserDashboardsInfo userDashboardsInfo = UserDashboardsInfo.EMPTY;
    UserDashboardsInfo userDashboardsInfo2 = UserDashboardsInfo.EMPTY;

    // Act and Assert
    assertEquals(userDashboardsInfo, userDashboardsInfo2);
    int expectedHashCodeResult = userDashboardsInfo.hashCode();
    assertEquals(expectedHashCodeResult, userDashboardsInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserDashboardsInfo#equals(Object)}
   *   <li>{@link UserDashboardsInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserDashboardsInfo userDashboardsInfo = new UserDashboardsInfo();
    UserDashboardsInfo userDashboardsInfo2 = UserDashboardsInfo.EMPTY;

    // Act and Assert
    assertEquals(userDashboardsInfo, userDashboardsInfo2);
    int expectedHashCodeResult = userDashboardsInfo.hashCode();
    assertEquals(expectedHashCodeResult, userDashboardsInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserDashboardsInfo#equals(Object)}
   *   <li>{@link UserDashboardsInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserDashboardsInfo userDashboardsInfo = UserDashboardsInfo.EMPTY;

    // Act and Assert
    assertEquals(userDashboardsInfo, userDashboardsInfo);
    int expectedHashCodeResult = userDashboardsInfo.hashCode();
    assertEquals(expectedHashCodeResult, userDashboardsInfo.hashCode());
  }

  /**
   * Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserDashboardsInfo.EMPTY, 1);
  }

  /**
   * Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    ArrayList<LastVisitedDashboardInfo> last = new ArrayList<>();
    last.add(lastVisitedDashboardInfo);

    // Act and Assert
    assertNotEquals(new UserDashboardsInfo(last, new ArrayList<>()), UserDashboardsInfo.EMPTY);
  }

  /**
   * Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = mock(LastVisitedDashboardInfo.class);
    doNothing().when(lastVisitedDashboardInfo).setId(Mockito.<UUID>any());
    doNothing().when(lastVisitedDashboardInfo).setTitle(Mockito.<String>any());
    doNothing().when(lastVisitedDashboardInfo).setLastVisited(anyLong());
    doNothing().when(lastVisitedDashboardInfo).setStarred(anyBoolean());
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    ArrayList<LastVisitedDashboardInfo> last = new ArrayList<>();
    last.add(lastVisitedDashboardInfo);

    // Act and Assert
    assertNotEquals(new UserDashboardsInfo(last, new ArrayList<>()), UserDashboardsInfo.EMPTY);
  }

  /**
   * Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserDashboardsInfo.EMPTY, null);
  }

  /**
   * Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserDashboardsInfo.EMPTY, "Different type to UserDashboardsInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserDashboardsInfo#UserDashboardsInfo()}
   *   <li>{@link UserDashboardsInfo#setLast(List)}
   *   <li>{@link UserDashboardsInfo#setStarred(List)}
   *   <li>{@link UserDashboardsInfo#toString()}
   *   <li>{@link UserDashboardsInfo#getLast()}
   *   <li>{@link UserDashboardsInfo#getStarred()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserDashboardsInfo actualUserDashboardsInfo = new UserDashboardsInfo();
    ArrayList<LastVisitedDashboardInfo> last = new ArrayList<>();
    actualUserDashboardsInfo.setLast(last);
    ArrayList<StarredDashboardInfo> starred = new ArrayList<>();
    actualUserDashboardsInfo.setStarred(starred);
    String actualToStringResult = actualUserDashboardsInfo.toString();
    List<LastVisitedDashboardInfo> actualLast = actualUserDashboardsInfo.getLast();
    List<StarredDashboardInfo> actualStarred = actualUserDashboardsInfo.getStarred();

    // Assert that nothing has changed
    assertEquals("UserDashboardsInfo(last=[], starred=[])", actualToStringResult);
    assertTrue(actualLast.isEmpty());
    assertTrue(actualStarred.isEmpty());
    assertSame(last, actualLast);
    assertSame(starred, actualStarred);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserDashboardsInfo#UserDashboardsInfo(List, List)}
   *   <li>{@link UserDashboardsInfo#setLast(List)}
   *   <li>{@link UserDashboardsInfo#setStarred(List)}
   *   <li>{@link UserDashboardsInfo#toString()}
   *   <li>{@link UserDashboardsInfo#getLast()}
   *   <li>{@link UserDashboardsInfo#getStarred()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    ArrayList<LastVisitedDashboardInfo> last = new ArrayList<>();

    // Act
    UserDashboardsInfo actualUserDashboardsInfo = new UserDashboardsInfo(last, new ArrayList<>());
    ArrayList<LastVisitedDashboardInfo> last2 = new ArrayList<>();
    actualUserDashboardsInfo.setLast(last2);
    ArrayList<StarredDashboardInfo> starred = new ArrayList<>();
    actualUserDashboardsInfo.setStarred(starred);
    String actualToStringResult = actualUserDashboardsInfo.toString();
    List<LastVisitedDashboardInfo> actualLast = actualUserDashboardsInfo.getLast();
    List<StarredDashboardInfo> actualStarred = actualUserDashboardsInfo.getStarred();

    // Assert that nothing has changed
    assertEquals("UserDashboardsInfo(last=[], starred=[])", actualToStringResult);
    assertTrue(actualLast.isEmpty());
    assertTrue(actualStarred.isEmpty());
    assertSame(last2, actualLast);
    assertSame(starred, actualStarred);
  }
}
