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
package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class UserListFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserListFilter#equals(Object)}
   *   <li>{@link UserListFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserListFilter userListFilter = new UserListFilter();
    userListFilter.setUsersIds(new ArrayList<>());

    UserListFilter userListFilter2 = new UserListFilter();
    userListFilter2.setUsersIds(new ArrayList<>());

    // Act and Assert
    assertEquals(userListFilter, userListFilter2);
    int expectedHashCodeResult = userListFilter.hashCode();
    assertEquals(expectedHashCodeResult, userListFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserListFilter#equals(Object)}
   *   <li>{@link UserListFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserListFilter userListFilter = new UserListFilter();
    userListFilter.setUsersIds(new ArrayList<>());

    // Act and Assert
    assertEquals(userListFilter, userListFilter);
    int expectedHashCodeResult = userListFilter.hashCode();
    assertEquals(expectedHashCodeResult, userListFilter.hashCode());
  }

  /**
   * Method under test: {@link UserListFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<UUID> usersIds = new ArrayList<>();
    usersIds.add(EntityId.NULL_UUID);

    UserListFilter userListFilter = new UserListFilter();
    userListFilter.setUsersIds(usersIds);

    UserListFilter userListFilter2 = new UserListFilter();
    userListFilter2.setUsersIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(userListFilter, userListFilter2);
  }

  /**
   * Method under test: {@link UserListFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserListFilter userListFilter = new UserListFilter();
    userListFilter.setUsersIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(userListFilter, null);
  }

  /**
   * Method under test: {@link UserListFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserListFilter userListFilter = new UserListFilter();
    userListFilter.setUsersIds(new ArrayList<>());

    // Act and Assert
    assertNotEquals(userListFilter, "Different type to UserListFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserListFilter}
   *   <li>{@link UserListFilter#setUsersIds(List)}
   *   <li>{@link UserListFilter#toString()}
   *   <li>{@link UserListFilter#getType()}
   *   <li>{@link UserListFilter#getUsersIds()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserListFilter actualUserListFilter = new UserListFilter();
    ArrayList<UUID> usersIds = new ArrayList<>();
    actualUserListFilter.setUsersIds(usersIds);
    String actualToStringResult = actualUserListFilter.toString();
    UsersFilterType actualType = actualUserListFilter.getType();
    List<UUID> actualUsersIds = actualUserListFilter.getUsersIds();

    // Assert that nothing has changed
    assertEquals("UserListFilter(usersIds=[])", actualToStringResult);
    assertEquals(UsersFilterType.USER_LIST, actualType);
    assertTrue(actualUsersIds.isEmpty());
    assertSame(usersIds, actualUsersIds);
  }
}
