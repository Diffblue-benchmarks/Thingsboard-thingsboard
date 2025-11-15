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
package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityActionNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder#created(boolean)}
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder#deleted(boolean)}
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder#entityTypes(Set)}
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder#updated(boolean)}
   * </ul>
   */
  @Test
  void testEntityActionNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    HashSet<EntityType> entityTypes = new HashSet<>();

    // Act
    EntityActionNotificationRuleTriggerConfig actualBuildResult = deletedResult.entityTypes(entityTypes)
        .updated(true)
        .build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualBuildResult.getTriggerType());
    Set<EntityType> entityTypes2 = actualBuildResult.getEntityTypes();
    assertTrue(entityTypes2.isEmpty());
    assertTrue(actualBuildResult.isCreated());
    assertTrue(actualBuildResult.isDeleted());
    assertTrue(actualBuildResult.isUpdated());
    assertSame(entityTypes, entityTypes2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult2 = deletedResult2.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder entityActionNotificationRuleTriggerConfigBuilder = mock(
        EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder.class);
    when(entityActionNotificationRuleTriggerConfigBuilder.created(anyBoolean()))
        .thenReturn(EntityActionNotificationRuleTriggerConfig.builder());
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = entityActionNotificationRuleTriggerConfigBuilder
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult2 = deletedResult2.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder entityActionNotificationRuleTriggerConfigBuilder = mock(
        EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder.class);
    when(entityActionNotificationRuleTriggerConfigBuilder.created(anyBoolean()))
        .thenReturn(EntityActionNotificationRuleTriggerConfig.builder());
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = entityActionNotificationRuleTriggerConfigBuilder
        .created(true)
        .deleted(false);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(false)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult2 = deletedResult2.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder entityActionNotificationRuleTriggerConfigBuilder = mock(
        EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder.class);
    when(entityActionNotificationRuleTriggerConfigBuilder.created(anyBoolean()))
        .thenReturn(EntityActionNotificationRuleTriggerConfig.builder());
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = entityActionNotificationRuleTriggerConfigBuilder
        .created(true)
        .deleted(false);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(false)
        .build();
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(false)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult2 = deletedResult2.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder entityActionNotificationRuleTriggerConfigBuilder = mock(
        EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder.class);
    when(entityActionNotificationRuleTriggerConfigBuilder.created(anyBoolean()))
        .thenReturn(EntityActionNotificationRuleTriggerConfig.builder());
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = entityActionNotificationRuleTriggerConfigBuilder
        .created(true)
        .deleted(true);

    HashSet<EntityType> entityTypes = new HashSet<>();
    entityTypes.add(EntityType.TENANT);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(entityTypes)
        .updated(true)
        .build();
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(false)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult2 = deletedResult2.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder deletedResult = EntityActionNotificationRuleTriggerConfig
        .builder()
        .created(true)
        .deleted(true);
    EntityActionNotificationRuleTriggerConfig buildResult = deletedResult.entityTypes(new HashSet<>())
        .updated(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityActionNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig#EntityActionNotificationRuleTriggerConfig()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setCreated(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setDeleted(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setEntityTypes(Set)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setUpdated(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#getEntityTypes()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#isCreated()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#isDeleted()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#isUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityActionNotificationRuleTriggerConfig actualEntityActionNotificationRuleTriggerConfig = new EntityActionNotificationRuleTriggerConfig();
    actualEntityActionNotificationRuleTriggerConfig.setCreated(true);
    actualEntityActionNotificationRuleTriggerConfig.setDeleted(true);
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntityActionNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntityActionNotificationRuleTriggerConfig.setUpdated(true);
    String actualToStringResult = actualEntityActionNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes = actualEntityActionNotificationRuleTriggerConfig.getEntityTypes();
    NotificationRuleTriggerType actualTriggerType = actualEntityActionNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsCreatedResult = actualEntityActionNotificationRuleTriggerConfig.isCreated();
    boolean actualIsDeletedResult = actualEntityActionNotificationRuleTriggerConfig.isDeleted();
    boolean actualIsUpdatedResult = actualEntityActionNotificationRuleTriggerConfig.isUpdated();

    // Assert that nothing has changed
    assertEquals("EntityActionNotificationRuleTriggerConfig(entityTypes=[], created=true, updated=true, deleted=true)",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsCreatedResult);
    assertTrue(actualIsDeletedResult);
    assertTrue(actualIsUpdatedResult);
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityActionNotificationRuleTriggerConfig#EntityActionNotificationRuleTriggerConfig(Set, boolean, boolean, boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setCreated(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setDeleted(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setEntityTypes(Set)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#setUpdated(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#getEntityTypes()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#isCreated()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#isDeleted()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#isUpdated()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EntityActionNotificationRuleTriggerConfig actualEntityActionNotificationRuleTriggerConfig = new EntityActionNotificationRuleTriggerConfig(
        new HashSet<>(), true, true, true);
    actualEntityActionNotificationRuleTriggerConfig.setCreated(true);
    actualEntityActionNotificationRuleTriggerConfig.setDeleted(true);
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntityActionNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntityActionNotificationRuleTriggerConfig.setUpdated(true);
    String actualToStringResult = actualEntityActionNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes = actualEntityActionNotificationRuleTriggerConfig.getEntityTypes();
    NotificationRuleTriggerType actualTriggerType = actualEntityActionNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsCreatedResult = actualEntityActionNotificationRuleTriggerConfig.isCreated();
    boolean actualIsDeletedResult = actualEntityActionNotificationRuleTriggerConfig.isDeleted();
    boolean actualIsUpdatedResult = actualEntityActionNotificationRuleTriggerConfig.isUpdated();

    // Assert that nothing has changed
    assertEquals("EntityActionNotificationRuleTriggerConfig(entityTypes=[], created=true, updated=true, deleted=true)",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsCreatedResult);
    assertTrue(actualIsDeletedResult);
    assertTrue(actualIsUpdatedResult);
    assertSame(entityTypes, actualEntityTypes);
  }
}
