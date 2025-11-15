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

class SystemAdministratorsFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SystemAdministratorsFilter#equals(Object)}
   *   <li>{@link SystemAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemAdministratorsFilter systemAdministratorsFilter = new SystemAdministratorsFilter();
    SystemAdministratorsFilter systemAdministratorsFilter2 = new SystemAdministratorsFilter();

    // Act and Assert
    assertEquals(systemAdministratorsFilter, systemAdministratorsFilter2);
    int expectedHashCodeResult = systemAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, systemAdministratorsFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SystemAdministratorsFilter#equals(Object)}
   *   <li>{@link SystemAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemAdministratorsFilter systemAdministratorsFilter = new SystemAdministratorsFilter();

    // Act and Assert
    assertEquals(systemAdministratorsFilter, systemAdministratorsFilter);
    int expectedHashCodeResult = systemAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, systemAdministratorsFilter.hashCode());
  }

  /**
   * Method under test: {@link SystemAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemAdministratorsFilter(), 1);
  }

  /**
   * Method under test: {@link SystemAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemAdministratorsFilter(), null);
  }

  /**
   * Method under test: {@link SystemAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SystemAdministratorsFilter(), "Different type to SystemAdministratorsFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SystemAdministratorsFilter}
   *   <li>{@link SystemAdministratorsFilter#toString()}
   *   <li>{@link SystemAdministratorsFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SystemAdministratorsFilter actualSystemAdministratorsFilter = new SystemAdministratorsFilter();
    String actualToStringResult = actualSystemAdministratorsFilter.toString();

    // Assert
    assertEquals("SystemAdministratorsFilter()", actualToStringResult);
    assertEquals(UsersFilterType.SYSTEM_ADMINISTRATORS, actualSystemAdministratorsFilter.getType());
  }
}
