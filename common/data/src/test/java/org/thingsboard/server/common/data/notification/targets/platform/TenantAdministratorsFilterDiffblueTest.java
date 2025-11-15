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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class TenantAdministratorsFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantAdministratorsFilter#equals(Object)}
   *   <li>{@link TenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    TenantAdministratorsFilter tenantAdministratorsFilter2 = new TenantAdministratorsFilter();
    tenantAdministratorsFilter2.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter2.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertEquals(tenantAdministratorsFilter, tenantAdministratorsFilter2);
    int expectedHashCodeResult = tenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, tenantAdministratorsFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantAdministratorsFilter#equals(Object)}
   *   <li>{@link TenantAdministratorsFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertEquals(tenantAdministratorsFilter, tenantAdministratorsFilter);
    int expectedHashCodeResult = tenantAdministratorsFilter.hashCode();
    assertEquals(expectedHashCodeResult, tenantAdministratorsFilter.hashCode());
  }

  /**
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(EntityId.NULL_UUID);

    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(tenantProfilesIds);
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    TenantAdministratorsFilter tenantAdministratorsFilter2 = new TenantAdministratorsFilter();
    tenantAdministratorsFilter2.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter2.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, tenantAdministratorsFilter2);
  }

  /**
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(EntityId.NULL_UUID);

    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(tenantsIds);

    TenantAdministratorsFilter tenantAdministratorsFilter2 = new TenantAdministratorsFilter();
    tenantAdministratorsFilter2.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter2.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, tenantAdministratorsFilter2);
  }

  /**
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, null);
  }

  /**
   * Method under test: {@link TenantAdministratorsFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantAdministratorsFilter tenantAdministratorsFilter = new TenantAdministratorsFilter();
    tenantAdministratorsFilter.setTenantProfilesIds(new HashSet<>());
    tenantAdministratorsFilter.setTenantsIds(new HashSet<>());

    // Act and Assert
    assertNotEquals(tenantAdministratorsFilter, "Different type to TenantAdministratorsFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TenantAdministratorsFilter}
   *   <li>{@link TenantAdministratorsFilter#setTenantProfilesIds(Set)}
   *   <li>{@link TenantAdministratorsFilter#setTenantsIds(Set)}
   *   <li>{@link TenantAdministratorsFilter#toString()}
   *   <li>{@link TenantAdministratorsFilter#getTenantProfilesIds()}
   *   <li>{@link TenantAdministratorsFilter#getTenantsIds()}
   *   <li>{@link TenantAdministratorsFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TenantAdministratorsFilter actualTenantAdministratorsFilter = new TenantAdministratorsFilter();
    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    actualTenantAdministratorsFilter.setTenantProfilesIds(tenantProfilesIds);
    HashSet<UUID> tenantsIds = new HashSet<>();
    actualTenantAdministratorsFilter.setTenantsIds(tenantsIds);
    String actualToStringResult = actualTenantAdministratorsFilter.toString();
    Set<UUID> actualTenantProfilesIds = actualTenantAdministratorsFilter.getTenantProfilesIds();
    Set<UUID> actualTenantsIds = actualTenantAdministratorsFilter.getTenantsIds();

    // Assert that nothing has changed
    assertEquals("TenantAdministratorsFilter(tenantsIds=[], tenantProfilesIds=[])", actualToStringResult);
    assertEquals(UsersFilterType.TENANT_ADMINISTRATORS, actualTenantAdministratorsFilter.getType());
    assertTrue(actualTenantProfilesIds.isEmpty());
    assertTrue(actualTenantsIds.isEmpty());
    assertSame(tenantProfilesIds, actualTenantProfilesIds);
    assertSame(tenantsIds, actualTenantsIds);
  }
}
