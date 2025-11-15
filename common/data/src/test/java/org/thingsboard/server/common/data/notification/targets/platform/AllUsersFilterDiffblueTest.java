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
import org.junit.jupiter.api.Test;

class AllUsersFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AllUsersFilter#equals(Object)}
   *   <li>{@link AllUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AllUsersFilter allUsersFilter = new AllUsersFilter();
    AllUsersFilter allUsersFilter2 = new AllUsersFilter();

    // Act and Assert
    assertEquals(allUsersFilter, allUsersFilter2);
    int expectedHashCodeResult = allUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, allUsersFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AllUsersFilter#equals(Object)}
   *   <li>{@link AllUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AllUsersFilter allUsersFilter = new AllUsersFilter();

    // Act and Assert
    assertEquals(allUsersFilter, allUsersFilter);
    int expectedHashCodeResult = allUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, allUsersFilter.hashCode());
  }

  /**
   * Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), 1);
  }

  /**
   * Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), null);
  }

  /**
   * Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), "Different type to AllUsersFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AllUsersFilter}
   *   <li>{@link AllUsersFilter#toString()}
   *   <li>{@link AllUsersFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AllUsersFilter actualAllUsersFilter = new AllUsersFilter();
    String actualToStringResult = actualAllUsersFilter.toString();

    // Assert
    assertEquals("AllUsersFilter()", actualToStringResult);
    assertEquals(UsersFilterType.ALL_USERS, actualAllUsersFilter.getType());
  }
}
