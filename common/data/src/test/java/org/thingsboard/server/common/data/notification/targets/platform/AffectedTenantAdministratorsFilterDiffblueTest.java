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

class AffectedTenantAdministratorsFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AffectedTenantAdministratorsFilter#equals(Object)}
   *   <li>{@link AffectedTenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AffectedTenantAdministratorsFilter affectedTenantAdministratorsFilter = new AffectedTenantAdministratorsFilter();
    AffectedTenantAdministratorsFilter affectedTenantAdministratorsFilter2 = new AffectedTenantAdministratorsFilter();

    // Act and Assert
    assertEquals(affectedTenantAdministratorsFilter, affectedTenantAdministratorsFilter2);
    int expectedHashCodeResult = affectedTenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedTenantAdministratorsFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AffectedTenantAdministratorsFilter#equals(Object)}
   *   <li>{@link AffectedTenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AffectedTenantAdministratorsFilter affectedTenantAdministratorsFilter = new AffectedTenantAdministratorsFilter();

    // Act and Assert
    assertEquals(affectedTenantAdministratorsFilter, affectedTenantAdministratorsFilter);
    int expectedHashCodeResult = affectedTenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, affectedTenantAdministratorsFilter.hashCode());
  }

  /**
   * Method under test: {@link AffectedTenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedTenantAdministratorsFilter(), 1);
  }

  /**
   * Method under test: {@link AffectedTenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedTenantAdministratorsFilter(), null);
  }

  /**
   * Method under test: {@link AffectedTenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AffectedTenantAdministratorsFilter(), "Different type to AffectedTenantAdministratorsFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AffectedTenantAdministratorsFilter}
   *   <li>{@link AffectedTenantAdministratorsFilter#toString()}
   *   <li>{@link AffectedTenantAdministratorsFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AffectedTenantAdministratorsFilter actualAffectedTenantAdministratorsFilter = new AffectedTenantAdministratorsFilter();
    String actualToStringResult = actualAffectedTenantAdministratorsFilter.toString();

    // Assert
    assertEquals("AffectedTenantAdministratorsFilter()", actualToStringResult);
    assertEquals(UsersFilterType.AFFECTED_TENANT_ADMINISTRATORS, actualAffectedTenantAdministratorsFilter.getType());
  }
}
