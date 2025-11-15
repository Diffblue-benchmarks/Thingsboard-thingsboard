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
package org.thingsboard.server.common.data.sync.vc.request.create;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class EntityTypeVersionCreateConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionCreateConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
    int expectedHashCodeResult = entityTypeVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionCreateConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionCreateConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionCreateConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig);
    int expectedHashCodeResult = entityTypeVersionCreateConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionCreateConfig.hashCode());
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(false);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<UUID> entityIds = new ArrayList<>();
    entityIds.add(EntityId.NULL_UUID);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(entityIds);
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(false);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(null);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.OVERWRITE);

    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig2 = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig2.setAllEntities(true);
    entityTypeVersionCreateConfig2.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig2.setSaveAttributes(true);
    entityTypeVersionCreateConfig2.setSaveCredentials(true);
    entityTypeVersionCreateConfig2.setSaveRelations(true);
    entityTypeVersionCreateConfig2.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, entityTypeVersionCreateConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, null);
  }

  /**
   * Method under test: {@link EntityTypeVersionCreateConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionCreateConfig entityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    entityTypeVersionCreateConfig.setAllEntities(true);
    entityTypeVersionCreateConfig.setEntityIds(new ArrayList<>());
    entityTypeVersionCreateConfig.setSaveAttributes(true);
    entityTypeVersionCreateConfig.setSaveCredentials(true);
    entityTypeVersionCreateConfig.setSaveRelations(true);
    entityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);

    // Act and Assert
    assertNotEquals(entityTypeVersionCreateConfig, "Different type to EntityTypeVersionCreateConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityTypeVersionCreateConfig}
   *   <li>{@link EntityTypeVersionCreateConfig#setAllEntities(boolean)}
   *   <li>{@link EntityTypeVersionCreateConfig#setEntityIds(List)}
   *   <li>{@link EntityTypeVersionCreateConfig#setSyncStrategy(SyncStrategy)}
   *   <li>{@link EntityTypeVersionCreateConfig#toString()}
   *   <li>{@link EntityTypeVersionCreateConfig#getEntityIds()}
   *   <li>{@link EntityTypeVersionCreateConfig#getSyncStrategy()}
   *   <li>{@link EntityTypeVersionCreateConfig#isAllEntities()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeVersionCreateConfig actualEntityTypeVersionCreateConfig = new EntityTypeVersionCreateConfig();
    actualEntityTypeVersionCreateConfig.setAllEntities(true);
    ArrayList<UUID> entityIds = new ArrayList<>();
    actualEntityTypeVersionCreateConfig.setEntityIds(entityIds);
    actualEntityTypeVersionCreateConfig.setSyncStrategy(SyncStrategy.MERGE);
    String actualToStringResult = actualEntityTypeVersionCreateConfig.toString();
    List<UUID> actualEntityIds = actualEntityTypeVersionCreateConfig.getEntityIds();
    SyncStrategy actualSyncStrategy = actualEntityTypeVersionCreateConfig.getSyncStrategy();
    boolean actualIsAllEntitiesResult = actualEntityTypeVersionCreateConfig.isAllEntities();

    // Assert that nothing has changed
    assertEquals("EntityTypeVersionCreateConfig(syncStrategy=MERGE, entityIds=[], allEntities=true)",
        actualToStringResult);
    assertEquals(SyncStrategy.MERGE, actualSyncStrategy);
    assertFalse(actualEntityTypeVersionCreateConfig.isSaveAttributes());
    assertFalse(actualEntityTypeVersionCreateConfig.isSaveCredentials());
    assertFalse(actualEntityTypeVersionCreateConfig.isSaveRelations());
    assertTrue(actualEntityIds.isEmpty());
    assertTrue(actualIsAllEntitiesResult);
    assertSame(entityIds, actualEntityIds);
  }
}
