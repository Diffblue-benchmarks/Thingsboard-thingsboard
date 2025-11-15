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

class OriginatorEntityOwnerUsersFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter = new OriginatorEntityOwnerUsersFilter();
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter2 = new OriginatorEntityOwnerUsersFilter();

    // Act and Assert
    assertEquals(originatorEntityOwnerUsersFilter, originatorEntityOwnerUsersFilter2);
    int expectedHashCodeResult = originatorEntityOwnerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, originatorEntityOwnerUsersFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter = new OriginatorEntityOwnerUsersFilter();

    // Act and Assert
    assertEquals(originatorEntityOwnerUsersFilter, originatorEntityOwnerUsersFilter);
    int expectedHashCodeResult = originatorEntityOwnerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, originatorEntityOwnerUsersFilter.hashCode());
  }

  /**
   * Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), 1);
  }

  /**
   * Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), null);
  }

  /**
   * Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), "Different type to OriginatorEntityOwnerUsersFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link OriginatorEntityOwnerUsersFilter}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#toString()}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    OriginatorEntityOwnerUsersFilter actualOriginatorEntityOwnerUsersFilter = new OriginatorEntityOwnerUsersFilter();
    String actualToStringResult = actualOriginatorEntityOwnerUsersFilter.toString();

    // Assert
    assertEquals("OriginatorEntityOwnerUsersFilter()", actualToStringResult);
    assertEquals(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS, actualOriginatorEntityOwnerUsersFilter.getType());
  }
}
