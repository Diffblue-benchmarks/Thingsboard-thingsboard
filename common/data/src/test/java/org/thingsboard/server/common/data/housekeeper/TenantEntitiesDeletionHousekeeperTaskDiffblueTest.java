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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class TenantEntitiesDeletionHousekeeperTaskDiffblueTest {
  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}, and {@link
   * TenantEntitiesDeletionHousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask2 =
        new TenantEntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask2);
    assertEquals(
        tenantEntitiesDeletionHousekeeperTask.hashCode(),
        tenantEntitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}, and {@link
   * TenantEntitiesDeletionHousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, EntityType.TENANT);
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask2 =
        new TenantEntitiesDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, EntityType.TENANT);

    // Act and Assert
    assertEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask2);
    assertEquals(
        tenantEntitiesDeletionHousekeeperTask.hashCode(),
        tenantEntitiesDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}, and {@link
   * TenantEntitiesDeletionHousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask);
    int expectedHashCodeResult = tenantEntitiesDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntitiesDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        tenantEntitiesDeletionHousekeeperTask, new TenantEntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(
        tenantEntitiesDeletionHousekeeperTask, new TenantEntitiesDeletionHousekeeperTask());
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();

    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask2 =
        new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(tenantEntitiesDeletionHousekeeperTask, tenantEntitiesDeletionHousekeeperTask2);
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntitiesDeletionHousekeeperTask(), null);
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntitiesDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TenantEntitiesDeletionHousekeeperTask.equals(Object)",
    "int TenantEntitiesDeletionHousekeeperTask.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TenantEntitiesDeletionHousekeeperTask(),
        "Different type to TenantEntitiesDeletionHousekeeperTask");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#TenantEntitiesDeletionHousekeeperTask()}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#setEntityType(EntityType)}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#toString()}
   *   <li>{@link TenantEntitiesDeletionHousekeeperTask#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TenantEntitiesDeletionHousekeeperTask.<init>()",
    "EntityType TenantEntitiesDeletionHousekeeperTask.getEntityType()",
    "void TenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType)",
    "String TenantEntitiesDeletionHousekeeperTask.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TenantEntitiesDeletionHousekeeperTask actualTenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();
    actualTenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualTenantEntitiesDeletionHousekeeperTask.toString();
    EntityType actualEntityType = actualTenantEntitiesDeletionHousekeeperTask.getEntityType();

    // Assert
    assertEquals(
        "TenantEntitiesDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
            + " ts=0), entityType=TENANT)",
        actualToStringResult);
    assertNull(actualTenantEntitiesDeletionHousekeeperTask.getTaskType());
    assertNull(actualTenantEntitiesDeletionHousekeeperTask.getEntityId());
    assertNull(actualTenantEntitiesDeletionHousekeeperTask.getTenantId());
    assertEquals(0L, actualTenantEntitiesDeletionHousekeeperTask.getTs());
    assertEquals(EntityType.TENANT, actualEntityType);
  }

  /**
   * Test {@link
   * TenantEntitiesDeletionHousekeeperTask#TenantEntitiesDeletionHousekeeperTask(TenantId,
   * EntityType)}.
   *
   * <p>Method under test: {@link
   * TenantEntitiesDeletionHousekeeperTask#TenantEntitiesDeletionHousekeeperTask(TenantId,
   * EntityType)}
   */
  @Test
  @DisplayName("Test new TenantEntitiesDeletionHousekeeperTask(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantEntitiesDeletionHousekeeperTask.<init>(TenantId, EntityType)"})
  void testNewTenantEntitiesDeletionHousekeeperTask() {
    // Arrange and Act
    TenantEntitiesDeletionHousekeeperTask actualTenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, EntityType.TENANT);

    // Assert
    assertEquals("tenants deletion", actualTenantEntitiesDeletionHousekeeperTask.getDescription());
    assertEquals(EntityType.TENANT, actualTenantEntitiesDeletionHousekeeperTask.getEntityType());
    assertEquals(
        HousekeeperTaskType.DELETE_TENANT_ENTITIES,
        actualTenantEntitiesDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualTenantEntitiesDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualTenantEntitiesDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link TenantEntitiesDeletionHousekeeperTask#getDescription()}.
   *
   * <ul>
   *   <li>Then return {@code tenants deletion}.
   * </ul>
   *
   * <p>Method under test: {@link TenantEntitiesDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'tenants deletion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TenantEntitiesDeletionHousekeeperTask.getDescription()"})
  void testGetDescription_thenReturnTenantsDeletion() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals("tenants deletion", tenantEntitiesDeletionHousekeeperTask.getDescription());
  }
}
