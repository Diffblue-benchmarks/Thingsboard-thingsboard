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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class DeviceSearchQueryFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceSearchQueryFilter#equals(Object)}
   *   <li>{@link DeviceSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
    int expectedHashCodeResult = deviceSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQueryFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceSearchQueryFilter#equals(Object)}
   *   <li>{@link DeviceSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(deviceSearchQueryFilter, deviceSearchQueryFilter);
    int expectedHashCodeResult = deviceSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, deviceSearchQueryFilter.hashCode());
  }

  /**
   * Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> deviceTypes = new ArrayList<>();
    deviceTypes.add("Relation Type");

    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(deviceTypes);
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
  }

  /**
   * Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(null);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
  }

  /**
   * Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(mock(EntityId.class));

    DeviceSearchQueryFilter deviceSearchQueryFilter2 = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter2.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter2.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter2.setMaxLevel(3);
    deviceSearchQueryFilter2.setRelationType("Relation Type");
    deviceSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, deviceSearchQueryFilter2);
  }

  /**
   * Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, null);
  }

  /**
   * Method under test: {@link DeviceSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceSearchQueryFilter deviceSearchQueryFilter = new DeviceSearchQueryFilter();
    deviceSearchQueryFilter.setDeviceTypes(new ArrayList<>());
    deviceSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    deviceSearchQueryFilter.setFetchLastLevelOnly(true);
    deviceSearchQueryFilter.setMaxLevel(3);
    deviceSearchQueryFilter.setRelationType("Relation Type");
    deviceSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceSearchQueryFilter, "Different type to DeviceSearchQueryFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceSearchQueryFilter}
   *   <li>{@link DeviceSearchQueryFilter#setDeviceTypes(List)}
   *   <li>{@link DeviceSearchQueryFilter#toString()}
   *   <li>{@link DeviceSearchQueryFilter#getDeviceTypes()}
   *   <li>{@link DeviceSearchQueryFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceSearchQueryFilter actualDeviceSearchQueryFilter = new DeviceSearchQueryFilter();
    ArrayList<String> deviceTypes = new ArrayList<>();
    actualDeviceSearchQueryFilter.setDeviceTypes(deviceTypes);
    String actualToStringResult = actualDeviceSearchQueryFilter.toString();
    List<String> actualDeviceTypes = actualDeviceSearchQueryFilter.getDeviceTypes();
    EntityFilterType actualType = actualDeviceSearchQueryFilter.getType();

    // Assert that nothing has changed
    assertEquals(
        "DeviceSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), deviceTypes=[])",
        actualToStringResult);
    assertEquals(0, actualDeviceSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.DEVICE_SEARCH_QUERY, actualType);
    assertFalse(actualDeviceSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualDeviceTypes.isEmpty());
    assertSame(deviceTypes, actualDeviceTypes);
  }
}
