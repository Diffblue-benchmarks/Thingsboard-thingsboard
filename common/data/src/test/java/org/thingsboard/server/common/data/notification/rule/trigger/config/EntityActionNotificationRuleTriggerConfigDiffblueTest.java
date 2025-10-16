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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntityActionNotificationRuleTriggerConfig.EntityActionNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {EntityActionNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityActionNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private EntityActionNotificationRuleTriggerConfigBuilder
      entityActionNotificationRuleTriggerConfigBuilder;

  /**
   * Test EntityActionNotificationRuleTriggerConfigBuilder {@link
   * EntityActionNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link EntityActionNotificationRuleTriggerConfigBuilder#created(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfigBuilder#deleted(boolean)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfigBuilder#entityTypes(Set)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfigBuilder#updated(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityActionNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionNotificationRuleTriggerConfigBuilder.<init>()",
    "EntityActionNotificationRuleTriggerConfig EntityActionNotificationRuleTriggerConfigBuilder.build()",
    "EntityActionNotificationRuleTriggerConfigBuilder EntityActionNotificationRuleTriggerConfigBuilder.created(boolean)",
    "EntityActionNotificationRuleTriggerConfigBuilder EntityActionNotificationRuleTriggerConfigBuilder.deleted(boolean)",
    "EntityActionNotificationRuleTriggerConfigBuilder EntityActionNotificationRuleTriggerConfigBuilder.entityTypes(Set)",
    "String EntityActionNotificationRuleTriggerConfigBuilder.toString()",
    "EntityActionNotificationRuleTriggerConfigBuilder EntityActionNotificationRuleTriggerConfigBuilder.updated(boolean)"
  })
  void testEntityActionNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    EntityActionNotificationRuleTriggerConfigBuilder actualDeletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);
    HashSet<EntityType> entityTypes = new HashSet<>();
    EntityActionNotificationRuleTriggerConfig actualEntityActionNotificationRuleTriggerConfig =
        actualDeletedResult.entityTypes(entityTypes).updated(true).build();

    // Assert
    assertEquals("#", actualEntityActionNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.ENTITY_ACTION,
        actualEntityActionNotificationRuleTriggerConfig.getTriggerType());
    Set<EntityType> entityTypes2 = actualEntityActionNotificationRuleTriggerConfig.getEntityTypes();
    assertTrue(entityTypes2.isEmpty());
    assertTrue(actualEntityActionNotificationRuleTriggerConfig.isCreated());
    assertTrue(actualEntityActionNotificationRuleTriggerConfig.isDeleted());
    assertTrue(actualEntityActionNotificationRuleTriggerConfig.isUpdated());
    assertSame(entityTypes, entityTypes2);
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EntityActionNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig =
        deletedResult.entityTypes(new HashSet<>()).updated(true).build();

    EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig2 =
        deletedResult2.entityTypes(new HashSet<>()).updated(true).build();

    // Act and Assert
    assertEquals(
        entityActionNotificationRuleTriggerConfig, entityActionNotificationRuleTriggerConfig2);
    assertEquals(
        entityActionNotificationRuleTriggerConfig.hashCode(),
        entityActionNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EntityActionNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntityActionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig =
        deletedResult.entityTypes(new HashSet<>()).updated(true).build();

    // Act and Assert
    assertEquals(
        entityActionNotificationRuleTriggerConfig, entityActionNotificationRuleTriggerConfig);
    int expectedHashCodeResult = entityActionNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityActionNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(false).deleted(true);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig =
        deletedResult.entityTypes(new HashSet<>()).updated(true).build();

    EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);

    // Act and Assert
    assertNotEquals(
        entityActionNotificationRuleTriggerConfig,
        deletedResult2.entityTypes(new HashSet<>()).updated(true).build());
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(false);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig =
        deletedResult.entityTypes(new HashSet<>()).updated(true).build();

    EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);

    // Act and Assert
    assertNotEquals(
        entityActionNotificationRuleTriggerConfig,
        deletedResult2.entityTypes(new HashSet<>()).updated(true).build());
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<EntityType> entityTypes = new HashSet<>();
    entityTypes.add(EntityType.TENANT);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig =
        EntityActionNotificationRuleTriggerConfig.builder()
            .created(true)
            .deleted(true)
            .entityTypes(entityTypes)
            .updated(true)
            .build();

    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);

    // Act and Assert
    assertNotEquals(
        entityActionNotificationRuleTriggerConfig,
        deletedResult.entityTypes(new HashSet<>()).updated(true).build());
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);
    EntityActionNotificationRuleTriggerConfig entityActionNotificationRuleTriggerConfig =
        deletedResult.entityTypes(new HashSet<>()).updated(false).build();

    EntityActionNotificationRuleTriggerConfigBuilder deletedResult2 =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);

    // Act and Assert
    assertNotEquals(
        entityActionNotificationRuleTriggerConfig,
        deletedResult2.entityTypes(new HashSet<>()).updated(true).build());
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);

    // Act and Assert
    assertNotEquals(deletedResult.entityTypes(new HashSet<>()).updated(true).build(), null);
  }

  /**
   * Test {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationRuleTriggerConfig.equals(Object)",
    "int EntityActionNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationRuleTriggerConfigBuilder deletedResult =
        EntityActionNotificationRuleTriggerConfig.builder().created(true).deleted(true);

    // Act and Assert
    assertNotEquals(
        deletedResult.entityTypes(new HashSet<>()).updated(true).build(),
        "Different type to EntityActionNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EntityActionNotificationRuleTriggerConfig#EntityActionNotificationRuleTriggerConfig()}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionNotificationRuleTriggerConfig.<init>()",
    "void EntityActionNotificationRuleTriggerConfig.<init>(Set, boolean, boolean, boolean)",
    "Set EntityActionNotificationRuleTriggerConfig.getEntityTypes()",
    "NotificationRuleTriggerType EntityActionNotificationRuleTriggerConfig.getTriggerType()",
    "boolean EntityActionNotificationRuleTriggerConfig.isCreated()",
    "boolean EntityActionNotificationRuleTriggerConfig.isDeleted()",
    "boolean EntityActionNotificationRuleTriggerConfig.isUpdated()",
    "void EntityActionNotificationRuleTriggerConfig.setCreated(boolean)",
    "void EntityActionNotificationRuleTriggerConfig.setDeleted(boolean)",
    "void EntityActionNotificationRuleTriggerConfig.setEntityTypes(Set)",
    "void EntityActionNotificationRuleTriggerConfig.setUpdated(boolean)",
    "String EntityActionNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityActionNotificationRuleTriggerConfig actualEntityActionNotificationRuleTriggerConfig =
        new EntityActionNotificationRuleTriggerConfig();
    actualEntityActionNotificationRuleTriggerConfig.setCreated(true);
    actualEntityActionNotificationRuleTriggerConfig.setDeleted(true);
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntityActionNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntityActionNotificationRuleTriggerConfig.setUpdated(true);
    String actualToStringResult = actualEntityActionNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes =
        actualEntityActionNotificationRuleTriggerConfig.getEntityTypes();
    NotificationRuleTriggerType actualTriggerType =
        actualEntityActionNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsCreatedResult = actualEntityActionNotificationRuleTriggerConfig.isCreated();
    boolean actualIsDeletedResult = actualEntityActionNotificationRuleTriggerConfig.isDeleted();
    boolean actualIsUpdatedResult = actualEntityActionNotificationRuleTriggerConfig.isUpdated();

    // Assert
    assertEquals(
        "EntityActionNotificationRuleTriggerConfig(entityTypes=[], created=true, updated=true, deleted=true)",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsCreatedResult);
    assertTrue(actualIsDeletedResult);
    assertTrue(actualIsUpdatedResult);
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EntityActionNotificationRuleTriggerConfig#EntityActionNotificationRuleTriggerConfig(Set,
   *       boolean, boolean, boolean)}
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
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionNotificationRuleTriggerConfig.<init>()",
    "void EntityActionNotificationRuleTriggerConfig.<init>(Set, boolean, boolean, boolean)",
    "Set EntityActionNotificationRuleTriggerConfig.getEntityTypes()",
    "NotificationRuleTriggerType EntityActionNotificationRuleTriggerConfig.getTriggerType()",
    "boolean EntityActionNotificationRuleTriggerConfig.isCreated()",
    "boolean EntityActionNotificationRuleTriggerConfig.isDeleted()",
    "boolean EntityActionNotificationRuleTriggerConfig.isUpdated()",
    "void EntityActionNotificationRuleTriggerConfig.setCreated(boolean)",
    "void EntityActionNotificationRuleTriggerConfig.setDeleted(boolean)",
    "void EntityActionNotificationRuleTriggerConfig.setEntityTypes(Set)",
    "void EntityActionNotificationRuleTriggerConfig.setUpdated(boolean)",
    "String EntityActionNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange and Act
    EntityActionNotificationRuleTriggerConfig actualEntityActionNotificationRuleTriggerConfig =
        new EntityActionNotificationRuleTriggerConfig(new HashSet<>(), true, true, true);
    actualEntityActionNotificationRuleTriggerConfig.setCreated(true);
    actualEntityActionNotificationRuleTriggerConfig.setDeleted(true);
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntityActionNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntityActionNotificationRuleTriggerConfig.setUpdated(true);
    String actualToStringResult = actualEntityActionNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes =
        actualEntityActionNotificationRuleTriggerConfig.getEntityTypes();
    NotificationRuleTriggerType actualTriggerType =
        actualEntityActionNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsCreatedResult = actualEntityActionNotificationRuleTriggerConfig.isCreated();
    boolean actualIsDeletedResult = actualEntityActionNotificationRuleTriggerConfig.isDeleted();
    boolean actualIsUpdatedResult = actualEntityActionNotificationRuleTriggerConfig.isUpdated();

    // Assert
    assertEquals(
        "EntityActionNotificationRuleTriggerConfig(entityTypes=[], created=true, updated=true, deleted=true)",
        actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsCreatedResult);
    assertTrue(actualIsDeletedResult);
    assertTrue(actualIsUpdatedResult);
    assertSame(entityTypes, actualEntityTypes);
  }
}
