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
package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class TenantEntitiesDeletionHousekeeperTaskDiffblueTest {
  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals("tenants deletion", tenantEntitiesDeletionHousekeeperTask.getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask2 = new TenantEntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask2);
    int expectedHashCodeResult = tenantEntitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT);
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask2 = new TenantEntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT);

    // Act and Assert
    assertEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask2);
    int expectedHashCodeResult = tenantEntitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask);
    int expectedHashCodeResult = tenantEntitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntitiesDeletionHousekeeperTask.hashCode());
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(tenantEntitiesDeletionHousekeeperTask, new TenantEntitiesDeletionHousekeeperTask());
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntitiesDeletionHousekeeperTask(), mock(AlarmsDeletionHousekeeperTask.class));
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(tenantEntitiesDeletionHousekeeperTask, new TenantEntitiesDeletionHousekeeperTask());
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();

    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask2 = new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask2);
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntitiesDeletionHousekeeperTask(), null);
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntitiesDeletionHousekeeperTask(),
        "Different type to TenantEntitiesDeletionHousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TenantEntitiesDeletionHousekeeperTask#TenantEntitiesDeletionHousekeeperTask()}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#setEntityType(EntityType)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#toString()}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#getEntityType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TenantEntitiesDeletionHousekeeperTask actualTenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();
    actualTenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualTenantEntitiesDeletionHousekeeperTask.toString();
    EntityType actualEntityType = actualTenantEntitiesDeletionHousekeeperTask.getEntityType();

    // Assert that nothing has changed
    assertEquals(
        "TenantEntitiesDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
            + " ts=0), entityType=TENANT)",
        actualToStringResult);
    assertEquals(0L, actualTenantEntitiesDeletionHousekeeperTask.getTs());
    assertEquals(EntityType.TENANT, actualEntityType);
  }

  /**
   * Method under test:
   * {@link TenantEntitiesDeletionHousekeeperTask#TenantEntitiesDeletionHousekeeperTask(TenantId, EntityType)}
   */
  @Test
  void testNewTenantEntitiesDeletionHousekeeperTask() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    TenantEntitiesDeletionHousekeeperTask actualTenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask(
        tenantId, EntityType.TENANT);

    // Assert
    assertEquals("tenants deletion", actualTenantEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualTenantEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_TENANT_ENTITIES, actualTenantEntitiesDeletionHousekeeperTask.getTaskType());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualTenantEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId2, actualTenantEntitiesDeletionHousekeeperTask.getTenantId());
  }
}
