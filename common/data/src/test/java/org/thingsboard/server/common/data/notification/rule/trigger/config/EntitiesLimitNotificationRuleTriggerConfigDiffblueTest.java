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
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;

class EntitiesLimitNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder#entityTypes(Set)}
   *   <li>
   * {@link EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder#threshold(float)}
   * </ul>
   */
  @Test
  void testEntitiesLimitNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    HashSet<EntityType> entityTypes = new HashSet<>();

    // Act
    EntitiesLimitNotificationRuleTriggerConfig actualBuildResult = builderResult.entityTypes(entityTypes)
        .threshold(10.0f)
        .build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(10.0f, actualBuildResult.getThreshold());
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT, actualBuildResult.getTriggerType());
    Set<EntityType> entityTypes2 = actualBuildResult.getEntityTypes();
    assertTrue(entityTypes2.isEmpty());
    assertSame(entityTypes, entityTypes2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult2 = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult2 = builderResult2.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder entitiesLimitNotificationRuleTriggerConfigBuilder = mock(
        EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder.class);
    when(entitiesLimitNotificationRuleTriggerConfigBuilder.entityTypes(Mockito.<Set<EntityType>>any()))
        .thenReturn(EntitiesLimitNotificationRuleTriggerConfig.builder());
    EntitiesLimitNotificationRuleTriggerConfig buildResult = entitiesLimitNotificationRuleTriggerConfigBuilder
        .entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult2 = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder entitiesLimitNotificationRuleTriggerConfigBuilder = mock(
        EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder.class);
    when(entitiesLimitNotificationRuleTriggerConfigBuilder.threshold(anyFloat()))
        .thenReturn(EntitiesLimitNotificationRuleTriggerConfig.builder());
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder entitiesLimitNotificationRuleTriggerConfigBuilder2 = mock(
        EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder.class);
    when(entitiesLimitNotificationRuleTriggerConfigBuilder2.entityTypes(Mockito.<Set<EntityType>>any()))
        .thenReturn(entitiesLimitNotificationRuleTriggerConfigBuilder);
    EntitiesLimitNotificationRuleTriggerConfig buildResult = entitiesLimitNotificationRuleTriggerConfigBuilder2
        .entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult2 = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig buildResult = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntitiesLimitNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntitiesLimitNotificationRuleTriggerConfig#EntitiesLimitNotificationRuleTriggerConfig()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#setEntityTypes(Set)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#setThreshold(float)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#getEntityTypes()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#getThreshold()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesLimitNotificationRuleTriggerConfig actualEntitiesLimitNotificationRuleTriggerConfig = new EntitiesLimitNotificationRuleTriggerConfig();
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntitiesLimitNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntitiesLimitNotificationRuleTriggerConfig.setThreshold(10.0f);
    String actualToStringResult = actualEntitiesLimitNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes = actualEntitiesLimitNotificationRuleTriggerConfig.getEntityTypes();
    float actualThreshold = actualEntitiesLimitNotificationRuleTriggerConfig.getThreshold();

    // Assert that nothing has changed
    assertEquals("EntitiesLimitNotificationRuleTriggerConfig(entityTypes=[], threshold=10.0)", actualToStringResult);
    assertEquals(10.0f, actualThreshold);
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT,
        actualEntitiesLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEntityTypes.isEmpty());
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntitiesLimitNotificationRuleTriggerConfig#EntitiesLimitNotificationRuleTriggerConfig(Set, float)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#setEntityTypes(Set)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#setThreshold(float)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#toString()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#getEntityTypes()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#getThreshold()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EntitiesLimitNotificationRuleTriggerConfig actualEntitiesLimitNotificationRuleTriggerConfig = new EntitiesLimitNotificationRuleTriggerConfig(
        new HashSet<>(), 10.0f);
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntitiesLimitNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntitiesLimitNotificationRuleTriggerConfig.setThreshold(10.0f);
    String actualToStringResult = actualEntitiesLimitNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes = actualEntitiesLimitNotificationRuleTriggerConfig.getEntityTypes();
    float actualThreshold = actualEntitiesLimitNotificationRuleTriggerConfig.getThreshold();

    // Assert that nothing has changed
    assertEquals("EntitiesLimitNotificationRuleTriggerConfig(entityTypes=[], threshold=10.0)", actualToStringResult);
    assertEquals(10.0f, actualThreshold);
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT,
        actualEntitiesLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEntityTypes.isEmpty());
    assertSame(entityTypes, actualEntityTypes);
  }
}
