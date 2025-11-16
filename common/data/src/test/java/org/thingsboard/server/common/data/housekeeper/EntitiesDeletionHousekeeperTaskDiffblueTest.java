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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesDeletionHousekeeperTaskDiffblueTest {
  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}, and {@link
   * EntitiesDeletionHousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 =
        new EntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
    assertEquals(
        entitiesDeletionHousekeeperTask.hashCode(), entitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}, and {@link
   * EntitiesDeletionHousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask(
            TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 =
        new EntitiesDeletionHousekeeperTask(
            TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
    assertEquals(
        entitiesDeletionHousekeeperTask.hashCode(), entitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}, and {@link
   * EntitiesDeletionHousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link EntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask);
    int expectedHashCodeResult = entitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, entitiesDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask(
            TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntities(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, new EntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();

    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 =
        new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();

    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask2 =
        new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask2.setEntities(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entitiesDeletionHousekeeperTask, entitiesDeletionHousekeeperTask2);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntitiesDeletionHousekeeperTask(), null);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesDeletionHousekeeperTask.equals(Object)",
    "int EntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntitiesDeletionHousekeeperTask(), "Different type to EntitiesDeletionHousekeeperTask");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesDeletionHousekeeperTask.<init>()",
    "List EntitiesDeletionHousekeeperTask.getEntities()",
    "EntityType EntitiesDeletionHousekeeperTask.getEntityType()",
    "void EntitiesDeletionHousekeeperTask.setEntities(List)",
    "void EntitiesDeletionHousekeeperTask.setEntityType(EntityType)",
    "String EntitiesDeletionHousekeeperTask.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();
    ArrayList<UUID> entities = new ArrayList<>();
    actualEntitiesDeletionHousekeeperTask.setEntities(entities);
    actualEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntitiesDeletionHousekeeperTask.toString();
    List<UUID> actualEntities = actualEntitiesDeletionHousekeeperTask.getEntities();
    EntityType actualEntityType = actualEntitiesDeletionHousekeeperTask.getEntityType();

    // Assert
    assertEquals(
        "EntitiesDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
            + " ts=0), entityType=TENANT, entities=[])",
        actualToStringResult);
    assertNull(actualEntitiesDeletionHousekeeperTask.getTaskType());
    assertNull(actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertNull(actualEntitiesDeletionHousekeeperTask.getTenantId());
    assertEquals(0L, actualEntitiesDeletionHousekeeperTask.getTs());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertTrue(actualEntities.isEmpty());
    assertSame(entities, actualEntities);
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId,
   * EntityType, List)}.
   *
   * <p>Method under test: {@link
   * EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  @DisplayName("Test new EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType, List)"})
  void testNewEntitiesDeletionHousekeeperTask() {
    // Arrange
    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(EntityId.NULL_UUID);
    entities.add(EntityId.NULL_UUID);

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, EntityType.TENANT, entities);

    // Assert
    assertTrue(actualEntitiesDeletionHousekeeperTask.getEntityId() instanceof TenantId);
    assertEquals(
        "tenants deletion ([13814000-1dd2-11b2-8080-808080808080, 13814000-1dd2-11b2-8080-808080808080])",
        actualEntitiesDeletionHousekeeperTask.getDescription());
    assertSame(entities, actualEntitiesDeletionHousekeeperTask.getEntities());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId,
   * EntityType, List)}.
   *
   * <ul>
   *   <li>Then return Description is {@code tenants deletion ([])}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesDeletionHousekeeperTask(TenantId, EntityType, List); then return Description is 'tenants deletion ([])'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType, List)"})
  void testNewEntitiesDeletionHousekeeperTask_thenReturnDescriptionIsTenantsDeletion() {
    // Arrange and Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask(
            TenantId.SYS_TENANT_ID, EntityType.TENANT, new ArrayList<>());

    // Assert
    assertEquals("tenants deletion ([])", actualEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(
        HousekeeperTaskType.DELETE_ENTITIES, actualEntitiesDeletionHousekeeperTask.getTaskType());
    assertTrue(actualEntitiesDeletionHousekeeperTask.getEntities().isEmpty());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualEntitiesDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId,
   * EntityType, List)}.
   *
   * <ul>
   *   <li>Then return Entities size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntitiesDeletionHousekeeperTask#EntitiesDeletionHousekeeperTask(TenantId, EntityType, List)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesDeletionHousekeeperTask(TenantId, EntityType, List); then return Entities size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType, List)"})
  void testNewEntitiesDeletionHousekeeperTask_thenReturnEntitiesSizeIsOne() {
    // Arrange
    ArrayList<UUID> entities = new ArrayList<>();
    entities.add(EntityId.NULL_UUID);

    // Act
    EntitiesDeletionHousekeeperTask actualEntitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, EntityType.TENANT, entities);

    // Assert
    EntityId entityId = actualEntitiesDeletionHousekeeperTask.getEntityId();
    assertTrue(entityId instanceof TenantId);
    List<UUID> entities2 = actualEntitiesDeletionHousekeeperTask.getEntities();
    assertEquals(1, entities2.size());
    UUID getResult = entities2.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.toString());
    assertEquals(
        "tenants deletion ([13814000-1dd2-11b2-8080-808080808080])",
        actualEntitiesDeletionHousekeeperTask.getDescription());
    assertSame(entities, entities2);
    assertSame(getResult, entityId.getId());
  }

  /**
   * Test {@link EntitiesDeletionHousekeeperTask#getDescription()}.
   *
   * <ul>
   *   <li>Then return {@code tenants deletion (null)}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'tenants deletion (null)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntitiesDeletionHousekeeperTask.getDescription()"})
  void testGetDescription_thenReturnTenantsDeletionNull() {
    // Arrange
    EntitiesDeletionHousekeeperTask entitiesDeletionHousekeeperTask =
        new EntitiesDeletionHousekeeperTask();
    entitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals("tenants deletion (null)", entitiesDeletionHousekeeperTask.getDescription());
  }
}
