package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {EntitiesLimitNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class EntitiesLimitNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private EntitiesLimitNotificationRuleTriggerConfigBuilder
      entitiesLimitNotificationRuleTriggerConfigBuilder;

  /**
   * Test EntitiesLimitNotificationRuleTriggerConfigBuilder {@link
   * EntitiesLimitNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfigBuilder#entityTypes(Set)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfigBuilder#threshold(float)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntitiesLimitNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitNotificationRuleTriggerConfigBuilder.<init>()",
    "EntitiesLimitNotificationRuleTriggerConfig EntitiesLimitNotificationRuleTriggerConfigBuilder.build()",
    "EntitiesLimitNotificationRuleTriggerConfigBuilder EntitiesLimitNotificationRuleTriggerConfigBuilder.entityTypes(Set)",
    "EntitiesLimitNotificationRuleTriggerConfigBuilder EntitiesLimitNotificationRuleTriggerConfigBuilder.threshold(float)",
    "String EntitiesLimitNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testEntitiesLimitNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    EntitiesLimitNotificationRuleTriggerConfigBuilder actualBuilderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();
    HashSet<EntityType> entityTypes = new HashSet<>();
    EntitiesLimitNotificationRuleTriggerConfig actualEntitiesLimitNotificationRuleTriggerConfig =
        actualBuilderResult.entityTypes(entityTypes).threshold(10.0f).build();

    // Assert
    assertEquals("#", actualEntitiesLimitNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(10.0f, actualEntitiesLimitNotificationRuleTriggerConfig.getThreshold());
    assertEquals(
        NotificationRuleTriggerType.ENTITIES_LIMIT,
        actualEntitiesLimitNotificationRuleTriggerConfig.getTriggerType());
    Set<EntityType> entityTypes2 =
        actualEntitiesLimitNotificationRuleTriggerConfig.getEntityTypes();
    assertTrue(entityTypes2.isEmpty());
    assertSame(entityTypes, entityTypes2);
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EntitiesLimitNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig =
        builderResult.entityTypes(new HashSet<>()).threshold(10.0f).build();

    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult2 =
        EntitiesLimitNotificationRuleTriggerConfig.builder();
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig2 =
        builderResult2.entityTypes(new HashSet<>()).threshold(10.0f).build();

    // Act and Assert
    assertEquals(
        entitiesLimitNotificationRuleTriggerConfig, entitiesLimitNotificationRuleTriggerConfig2);
    assertEquals(
        entitiesLimitNotificationRuleTriggerConfig.hashCode(),
        entitiesLimitNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EntitiesLimitNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder
        entitiesLimitNotificationRuleTriggerConfigBuilder =
            mock(EntitiesLimitNotificationRuleTriggerConfigBuilder.class);
    when(entitiesLimitNotificationRuleTriggerConfigBuilder.entityTypes(
            Mockito.<Set<EntityType>>any()))
        .thenReturn(EntitiesLimitNotificationRuleTriggerConfig.builder());
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig =
        entitiesLimitNotificationRuleTriggerConfigBuilder
            .entityTypes(new HashSet<>())
            .threshold(10.0f)
            .build();

    EntitiesLimitNotificationRuleTriggerConfigBuilder
        entitiesLimitNotificationRuleTriggerConfigBuilder2 =
            mock(EntitiesLimitNotificationRuleTriggerConfigBuilder.class);
    when(entitiesLimitNotificationRuleTriggerConfigBuilder2.entityTypes(
            Mockito.<Set<EntityType>>any()))
        .thenReturn(EntitiesLimitNotificationRuleTriggerConfig.builder());
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig2 =
        entitiesLimitNotificationRuleTriggerConfigBuilder2
            .entityTypes(new HashSet<>())
            .threshold(10.0f)
            .build();

    // Act and Assert
    assertEquals(
        entitiesLimitNotificationRuleTriggerConfig, entitiesLimitNotificationRuleTriggerConfig2);
    assertEquals(
        entitiesLimitNotificationRuleTriggerConfig.hashCode(),
        entitiesLimitNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * EntitiesLimitNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig =
        builderResult.entityTypes(new HashSet<>()).threshold(10.0f).build();

    // Act and Assert
    assertEquals(
        entitiesLimitNotificationRuleTriggerConfig, entitiesLimitNotificationRuleTriggerConfig);
    int expectedHashCodeResult = entitiesLimitNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, entitiesLimitNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<EntityType> entityTypes = new HashSet<>();
    entityTypes.add(EntityType.TENANT);
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig =
        EntitiesLimitNotificationRuleTriggerConfig.builder()
            .entityTypes(entityTypes)
            .threshold(10.0f)
            .build();

    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationRuleTriggerConfig,
        builderResult.entityTypes(new HashSet<>()).threshold(10.0f).build());
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig =
        builderResult.entityTypes(new HashSet<>()).threshold(0.5f).build();

    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult2 =
        EntitiesLimitNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationRuleTriggerConfig,
        builderResult2.entityTypes(new HashSet<>()).threshold(10.0f).build());
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder
        entitiesLimitNotificationRuleTriggerConfigBuilder =
            mock(EntitiesLimitNotificationRuleTriggerConfigBuilder.class);
    when(entitiesLimitNotificationRuleTriggerConfigBuilder.entityTypes(
            Mockito.<Set<EntityType>>any()))
        .thenReturn(EntitiesLimitNotificationRuleTriggerConfig.builder());
    EntitiesLimitNotificationRuleTriggerConfig entitiesLimitNotificationRuleTriggerConfig =
        entitiesLimitNotificationRuleTriggerConfigBuilder
            .entityTypes(new HashSet<>())
            .threshold(10.0f)
            .build();

    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        entitiesLimitNotificationRuleTriggerConfig,
        builderResult.entityTypes(new HashSet<>()).threshold(10.0f).build());
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(builderResult.entityTypes(new HashSet<>()).threshold(10.0f).build(), null);
  }

  /**
   * Test {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationRuleTriggerConfig.equals(Object)",
    "int EntitiesLimitNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult =
        EntitiesLimitNotificationRuleTriggerConfig.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.entityTypes(new HashSet<>()).threshold(10.0f).build(),
        "Different type to EntitiesLimitNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       EntitiesLimitNotificationRuleTriggerConfig#EntitiesLimitNotificationRuleTriggerConfig()}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitNotificationRuleTriggerConfig.<init>()",
    "void EntitiesLimitNotificationRuleTriggerConfig.<init>(Set, float)",
    "Set EntitiesLimitNotificationRuleTriggerConfig.getEntityTypes()",
    "float EntitiesLimitNotificationRuleTriggerConfig.getThreshold()",
    "NotificationRuleTriggerType EntitiesLimitNotificationRuleTriggerConfig.getTriggerType()",
    "void EntitiesLimitNotificationRuleTriggerConfig.setEntityTypes(Set)",
    "void EntitiesLimitNotificationRuleTriggerConfig.setThreshold(float)",
    "String EntitiesLimitNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesLimitNotificationRuleTriggerConfig actualEntitiesLimitNotificationRuleTriggerConfig =
        new EntitiesLimitNotificationRuleTriggerConfig();
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntitiesLimitNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntitiesLimitNotificationRuleTriggerConfig.setThreshold(10.0f);
    String actualToStringResult = actualEntitiesLimitNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes =
        actualEntitiesLimitNotificationRuleTriggerConfig.getEntityTypes();
    float actualThreshold = actualEntitiesLimitNotificationRuleTriggerConfig.getThreshold();

    // Assert
    assertEquals(
        "EntitiesLimitNotificationRuleTriggerConfig(entityTypes=[], threshold=10.0)",
        actualToStringResult);
    assertEquals(10.0f, actualThreshold);
    assertEquals(
        NotificationRuleTriggerType.ENTITIES_LIMIT,
        actualEntitiesLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEntityTypes.isEmpty());
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
   *       EntitiesLimitNotificationRuleTriggerConfig#EntitiesLimitNotificationRuleTriggerConfig(Set,
   *       float)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntitiesLimitNotificationRuleTriggerConfig.<init>()",
    "void EntitiesLimitNotificationRuleTriggerConfig.<init>(Set, float)",
    "Set EntitiesLimitNotificationRuleTriggerConfig.getEntityTypes()",
    "float EntitiesLimitNotificationRuleTriggerConfig.getThreshold()",
    "NotificationRuleTriggerType EntitiesLimitNotificationRuleTriggerConfig.getTriggerType()",
    "void EntitiesLimitNotificationRuleTriggerConfig.setEntityTypes(Set)",
    "void EntitiesLimitNotificationRuleTriggerConfig.setThreshold(float)",
    "String EntitiesLimitNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange and Act
    EntitiesLimitNotificationRuleTriggerConfig actualEntitiesLimitNotificationRuleTriggerConfig =
        new EntitiesLimitNotificationRuleTriggerConfig(new HashSet<>(), 10.0f);
    HashSet<EntityType> entityTypes = new HashSet<>();
    actualEntitiesLimitNotificationRuleTriggerConfig.setEntityTypes(entityTypes);
    actualEntitiesLimitNotificationRuleTriggerConfig.setThreshold(10.0f);
    String actualToStringResult = actualEntitiesLimitNotificationRuleTriggerConfig.toString();
    Set<EntityType> actualEntityTypes =
        actualEntitiesLimitNotificationRuleTriggerConfig.getEntityTypes();
    float actualThreshold = actualEntitiesLimitNotificationRuleTriggerConfig.getThreshold();

    // Assert
    assertEquals(
        "EntitiesLimitNotificationRuleTriggerConfig(entityTypes=[], threshold=10.0)",
        actualToStringResult);
    assertEquals(10.0f, actualThreshold);
    assertEquals(
        NotificationRuleTriggerType.ENTITIES_LIMIT,
        actualEntitiesLimitNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualEntityTypes.isEmpty());
    assertSame(entityTypes, actualEntityTypes);
  }
}
