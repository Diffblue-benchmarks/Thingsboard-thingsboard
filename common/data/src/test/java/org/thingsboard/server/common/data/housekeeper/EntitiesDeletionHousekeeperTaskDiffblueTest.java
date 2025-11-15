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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesDeletionHousekeeperTaskDiffblueTest {
  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals("tenants deletion (null)", entitiesDeletionHousekeeperTask.getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
    int expectedHashCodeResult = entitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, entitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask);
    int expectedHashCodeResult = entitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, entitiesDeletionHousekeeperTask.hashCode());
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitiesDeletionHousekeeperTask(), mock(AlarmsDeletionHousekeeperTask.class));
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntities(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();

    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();

    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 = new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask2.setEntities(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitiesDeletionHousekeeperTask(), null);
  }

  /**
   * Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitiesDeletionHousekeeperTask(), "Different type to EntitiesDeletionHousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask()}
   *   <li>{@link EntitiesDeletionHousekeeperTask#setEntities(List)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#setEntityType(EntityType)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#toString()}
   *   <li>{@link EntitiesDeletionHousekeeperTask#getEntities()}
   *   <li>{@link EntitiesDeletionHousekeeperTask#getEntityType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask();
    ArrayList<UUID> entities = new ArrayList<>();
    actualEntitiesDeletionHousekeeperTask.setEntities(entities);
    actualEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntitiesDeletionHousekeeperTask.toString();
    List<UUID> actualEntities = actualEntitiesDeletionHousekeeperTask.getEntities();
    EntityType actualEntityType = actualEntitiesDeletionHousekeeperTask.getEntityType();

    // Assert that nothing has changed
    assertEquals("EntitiesDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
        + " ts=0), entityType=TENANT, entities=[])", actualToStringResult);
    assertEquals(0L, actualEntitiesDeletionHousekeeperTask.getTs());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertTrue(actualEntities.isEmpty());
    assertSame(entities, actualEntities);
  }

  /**
   * Method under test:
   * {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  void testNewEntitiesDeletionHousekeeperTask() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    ArrayList<UUID> entities = new ArrayList<>();

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        tenantId, EntityType.TENANT, entities);

    // Assert
    assertEquals("tenants deletion ([])", actualEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_ENTITIES, actualEntitiesDeletionHousekeeperTask.getTaskType());
    List<UUID> entities2 = actualEntitiesDeletionHousekeeperTask.getEntities();
    assertTrue(entities2.isEmpty());
    assertSame(entities, entities2);
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  void testNewEntitiesDeletionHousekeeperTask2() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(EntityId.NULL_UUID);

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        tenantId, EntityType.TENANT, entities);

    // Assert
    List<UUID> entities2 = actualEntitiesDeletionHousekeeperTask.getEntities();
    assertEquals(1, entities2.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entities2.get(0).toString());
    assertEquals("tenants deletion ([13814000-1dd2-11b2-8080-808080808080])",
        actualEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_ENTITIES, actualEntitiesDeletionHousekeeperTask.getTaskType());
    assertSame(entities, entities2);
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  void testNewEntitiesDeletionHousekeeperTask3() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(EntityId.NULL_UUID);
    entities.add(EntityId.NULL_UUID);

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask = new EntitiesDeletionHousekeeperTask(
        tenantId, EntityType.TENANT, entities);

    // Assert
    assertEquals("tenants deletion ([13814000-1dd2-11b2-8080-808080808080, 13814000-1dd2-11b2-8080-808080808080])",
        actualEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_ENTITIES, actualEntitiesDeletionHousekeeperTask.getTaskType());
    assertSame(entities, actualEntitiesDeletionHousekeeperTask.getEntities());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId2, actualEntitiesDeletionHousekeeperTask.getTenantId());
  }
}
