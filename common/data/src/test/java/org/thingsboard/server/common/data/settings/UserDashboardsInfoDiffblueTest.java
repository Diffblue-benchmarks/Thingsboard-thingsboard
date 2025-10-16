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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class UserDashboardsInfoDiffblueTest {
  /**
   * Test {@link UserDashboardsInfo#equals(Object)}, and {@link UserDashboardsInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserDashboardsInfo#equals(Object)}
   *   <li>{@link UserDashboardsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserDashboardsInfo userDashboardsInfo = UserDashboardsInfo.EMPTY;
    UserDashboardsInfo userDashboardsInfo2 = UserDashboardsInfo.EMPTY;

    // Act and Assert
    assertEquals(userDashboardsInfo, userDashboardsInfo2);
    assertEquals(userDashboardsInfo.hashCode(), userDashboardsInfo2.hashCode());
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}, and {@link UserDashboardsInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserDashboardsInfo#equals(Object)}
   *   <li>{@link UserDashboardsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserDashboardsInfo userDashboardsInfo = new UserDashboardsInfo();
    UserDashboardsInfo userDashboardsInfo2 = UserDashboardsInfo.EMPTY;

    // Act and Assert
    assertEquals(userDashboardsInfo, userDashboardsInfo2);
    assertEquals(userDashboardsInfo.hashCode(), userDashboardsInfo2.hashCode());
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}, and {@link UserDashboardsInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserDashboardsInfo#equals(Object)}
   *   <li>{@link UserDashboardsInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserDashboardsInfo userDashboardsInfo = UserDashboardsInfo.EMPTY;

    // Act and Assert
    assertEquals(userDashboardsInfo, userDashboardsInfo);
    int expectedHashCodeResult = userDashboardsInfo.hashCode();
    assertEquals(expectedHashCodeResult, userDashboardsInfo.hashCode());
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserDashboardsInfo(), 1);
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    ArrayList<LastVisitedDashboardInfo> last = new ArrayList<>();
    last.add(lastVisitedDashboardInfo);
    UserDashboardsInfo userDashboardsInfo = new UserDashboardsInfo(last, new ArrayList<>());

    // Act and Assert
    assertNotEquals(userDashboardsInfo, UserDashboardsInfo.EMPTY);
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    ArrayList<StarredDashboardInfo> starred = new ArrayList<>();
    starred.add(starredDashboardInfo);
    UserDashboardsInfo userDashboardsInfo = new UserDashboardsInfo(new ArrayList<>(), starred);

    // Act and Assert
    assertNotEquals(userDashboardsInfo, UserDashboardsInfo.EMPTY);
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserDashboardsInfo.EMPTY, null);
  }

  /**
   * Test {@link UserDashboardsInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserDashboardsInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserDashboardsInfo.equals(Object)",
    "int UserDashboardsInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserDashboardsInfo.EMPTY, "Different type to UserDashboardsInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserDashboardsInfo.<init>()",
    "void UserDashboardsInfo.<init>(List, List)",
    "List UserDashboardsInfo.getLast()",
    "List UserDashboardsInfo.getStarred()",
    "void UserDashboardsInfo.setLast(List)",
    "void UserDashboardsInfo.setStarred(List)",
    "String UserDashboardsInfo.toString()"
  })
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

    // Assert
    assertEquals("UserDashboardsInfo(last=[], starred=[])", actualToStringResult);
    assertTrue(actualLast.isEmpty());
    assertTrue(actualStarred.isEmpty());
    assertSame(last, actualLast);
    assertSame(starred, actualStarred);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserDashboardsInfo.<init>()",
    "void UserDashboardsInfo.<init>(List, List)",
    "List UserDashboardsInfo.getLast()",
    "List UserDashboardsInfo.getStarred()",
    "void UserDashboardsInfo.setLast(List)",
    "void UserDashboardsInfo.setStarred(List)",
    "String UserDashboardsInfo.toString()"
  })
  void testGettersAndSetters_whenArrayList() {
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

    // Assert
    assertEquals("UserDashboardsInfo(last=[], starred=[])", actualToStringResult);
    assertTrue(actualLast.isEmpty());
    assertTrue(actualStarred.isEmpty());
    assertSame(last2, actualLast);
    assertSame(starred, actualStarred);
  }
}
