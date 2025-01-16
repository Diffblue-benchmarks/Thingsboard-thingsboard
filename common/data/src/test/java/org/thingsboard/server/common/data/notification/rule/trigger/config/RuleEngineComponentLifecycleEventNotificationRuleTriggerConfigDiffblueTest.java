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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)},
   * and
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)},
   * and
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(anyBoolean()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(anyBoolean()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(false);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(false)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(anyBoolean()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(false);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(false)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(false)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(anyBoolean()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);

    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    ruleChainEvents.add(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(ruleChainEvents);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(false)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(anyBoolean()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);

    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    ruleChainEvents.add(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(ruleChainEvents);

    HashSet<UUID> ruleChains = new HashSet<>();
    ruleChains.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(ruleChains);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(false)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class);
    when(ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(anyBoolean()))
        .thenReturn(RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());

    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    ruleNodeEvents.add(ComponentLifecycleEvent.CREATED);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(ruleNodeEvents)
        .trackRuleNodeEvents(true)
        .build();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult2 = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(false)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 = onlyRuleNodeLifecycleFailuresResult2
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 = ruleChainEventsResult2
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult2 = ruleChainsResult2
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig buildResult = ruleChainsResult
        .ruleNodeEvents(new HashSet<>())
        .trackRuleNodeEvents(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleChainLifecycleFailures(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleNodeLifecycleFailures(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChainEvents(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChains(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleNodeEvents(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setTrackRuleNodeEvents(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#toString()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChainEvents()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChains()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleNodeEvents()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleChainLifecycleFailures()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleNodeLifecycleFailures()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isTrackRuleNodeEvents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig = new RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleChainLifecycleFailures(true);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleNodeLifecycleFailures(true);
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChainEvents(ruleChainEvents);
    HashSet<UUID> ruleChains = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChains(ruleChains);
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleNodeEvents(ruleNodeEvents);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setTrackRuleNodeEvents(true);
    String actualToStringResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.toString();
    Set<ComponentLifecycleEvent> actualRuleChainEvents = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .getRuleChainEvents();
    Set<UUID> actualRuleChains = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains();
    Set<ComponentLifecycleEvent> actualRuleNodeEvents = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .getRuleNodeEvents();
    NotificationRuleTriggerType actualTriggerType = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .getTriggerType();
    boolean actualIsOnlyRuleChainLifecycleFailuresResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .isOnlyRuleChainLifecycleFailures();
    boolean actualIsOnlyRuleNodeLifecycleFailuresResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .isOnlyRuleNodeLifecycleFailures();
    boolean actualIsTrackRuleNodeEventsResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .isTrackRuleNodeEvents();

    // Assert that nothing has changed
    assertEquals("RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(ruleChains=[], ruleChainEvents=[],"
        + " onlyRuleChainLifecycleFailures=true, trackRuleNodeEvents=true, ruleNodeEvents=[], onlyRuleNodeLifec"
        + "ycleFailures=true)", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT, actualTriggerType);
    assertTrue(actualRuleChainEvents.isEmpty());
    assertTrue(actualRuleChains.isEmpty());
    assertTrue(actualRuleNodeEvents.isEmpty());
    assertTrue(actualIsOnlyRuleChainLifecycleFailuresResult);
    assertTrue(actualIsOnlyRuleNodeLifecycleFailuresResult);
    assertTrue(actualIsTrackRuleNodeEventsResult);
    assertSame(ruleChainEvents, actualRuleChainEvents);
    assertSame(ruleChains, actualRuleChains);
    assertSame(ruleNodeEvents, actualRuleNodeEvents);
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
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(Set, Set, boolean, boolean, Set, boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleChainLifecycleFailures(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleNodeLifecycleFailures(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChainEvents(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChains(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleNodeEvents(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setTrackRuleNodeEvents(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#toString()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChainEvents()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChains()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleNodeEvents()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleChainLifecycleFailures()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleNodeLifecycleFailures()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isTrackRuleNodeEvents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<UUID> ruleChains = new HashSet<>();
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();

    // Act
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig = new RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(
        ruleChains, ruleChainEvents, true, true, new HashSet<>(), true);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleChainLifecycleFailures(true);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleNodeLifecycleFailures(true);
    HashSet<ComponentLifecycleEvent> ruleChainEvents2 = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChainEvents(ruleChainEvents2);
    HashSet<UUID> ruleChains2 = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChains(ruleChains2);
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleNodeEvents(ruleNodeEvents);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setTrackRuleNodeEvents(true);
    String actualToStringResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.toString();
    Set<ComponentLifecycleEvent> actualRuleChainEvents = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .getRuleChainEvents();
    Set<UUID> actualRuleChains = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains();
    Set<ComponentLifecycleEvent> actualRuleNodeEvents = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .getRuleNodeEvents();
    NotificationRuleTriggerType actualTriggerType = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .getTriggerType();
    boolean actualIsOnlyRuleChainLifecycleFailuresResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .isOnlyRuleChainLifecycleFailures();
    boolean actualIsOnlyRuleNodeLifecycleFailuresResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .isOnlyRuleNodeLifecycleFailures();
    boolean actualIsTrackRuleNodeEventsResult = actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .isTrackRuleNodeEvents();

    // Assert that nothing has changed
    assertEquals("RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(ruleChains=[], ruleChainEvents=[],"
        + " onlyRuleChainLifecycleFailures=true, trackRuleNodeEvents=true, ruleNodeEvents=[], onlyRuleNodeLifec"
        + "ycleFailures=true)", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT, actualTriggerType);
    assertTrue(actualRuleChainEvents.isEmpty());
    assertTrue(actualRuleChains.isEmpty());
    assertTrue(actualRuleNodeEvents.isEmpty());
    assertTrue(actualIsOnlyRuleChainLifecycleFailuresResult);
    assertTrue(actualIsOnlyRuleNodeLifecycleFailuresResult);
    assertTrue(actualIsTrackRuleNodeEventsResult);
    assertSame(ruleChainEvents2, actualRuleChainEvents);
    assertSame(ruleChains2, actualRuleChains);
    assertSame(ruleNodeEvents, actualRuleNodeEvents);
  }

  /**
   * Test RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#onlyRuleChainLifecycleFailures(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#onlyRuleNodeLifecycleFailures(boolean)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#ruleChainEvents(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#ruleChains(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#ruleNodeEvents(Set)}
   *   <li>
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#trackRuleNodeEvents(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder build()")
  void testRuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder onlyRuleNodeLifecycleFailuresResult = RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .builder()
        .onlyRuleChainLifecycleFailures(true)
        .onlyRuleNodeLifecycleFailures(true);
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult = onlyRuleNodeLifecycleFailuresResult
        .ruleChainEvents(ruleChainEvents);
    HashSet<UUID> ruleChains = new HashSet<>();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult = ruleChainEventsResult
        .ruleChains(ruleChains);
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();

    // Act
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig actualBuildResult = ruleChainsResult
        .ruleNodeEvents(ruleNodeEvents)
        .trackRuleNodeEvents(true)
        .build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT, actualBuildResult.getTriggerType());
    Set<ComponentLifecycleEvent> ruleChainEvents2 = actualBuildResult.getRuleChainEvents();
    assertTrue(ruleChainEvents2.isEmpty());
    Set<UUID> ruleChains2 = actualBuildResult.getRuleChains();
    assertTrue(ruleChains2.isEmpty());
    Set<ComponentLifecycleEvent> ruleNodeEvents2 = actualBuildResult.getRuleNodeEvents();
    assertTrue(ruleNodeEvents2.isEmpty());
    assertTrue(actualBuildResult.isOnlyRuleChainLifecycleFailures());
    assertTrue(actualBuildResult.isOnlyRuleNodeLifecycleFailures());
    assertTrue(actualBuildResult.isTrackRuleNodeEvents());
    assertSame(ruleChainEvents, ruleChainEvents2);
    assertSame(ruleChains, ruleChains2);
    assertSame(ruleNodeEvents, ruleNodeEvents2);
  }
}
