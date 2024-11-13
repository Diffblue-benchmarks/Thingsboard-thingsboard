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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder;

class EntitiesLimitNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test EntitiesLimitNotificationRuleTriggerConfigBuilder
   * {@link EntitiesLimitNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
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
  @DisplayName("Test EntitiesLimitNotificationRuleTriggerConfigBuilder build()")
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
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when HashSet()")
  void testGettersAndSetters_whenHashSet() {
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
