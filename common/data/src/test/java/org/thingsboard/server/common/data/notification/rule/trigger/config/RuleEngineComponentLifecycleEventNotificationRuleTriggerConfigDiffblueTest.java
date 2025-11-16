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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

@ContextConfiguration(
    classes = {RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
      ruleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder;

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult2 =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 =
        onlyRuleNodeLifecycleFailuresResult2.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 =
        ruleChainEventsResult2.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig2 =
            ruleChainsResult2.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig2);
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode(),
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    // Act and Assert
    assertEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig);
    int expectedHashCodeResult =
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode();
    assertEquals(
        expectedHashCodeResult,
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(false)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult2 =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 =
        onlyRuleNodeLifecycleFailuresResult2.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 =
        ruleChainEventsResult2.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleChainsResult2.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(false);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult2 =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 =
        onlyRuleNodeLifecycleFailuresResult2.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 =
        ruleChainEventsResult2.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleChainsResult2.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    ruleChainEvents.add(ComponentLifecycleEvent.CREATED);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
            .onlyRuleChainLifecycleFailures(true)
            .onlyRuleNodeLifecycleFailures(true)
            .ruleChainEvents(ruleChainEvents);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 =
        ruleChainEventsResult2.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleChainsResult2.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<UUID> ruleChains = new HashSet<>();
    ruleChains.add(EntityId.NULL_UUID);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>()).ruleChains(ruleChains);
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult2 =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult2.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 =
        ruleChainEventsResult.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleChainsResult2.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    ruleNodeEvents.add(ComponentLifecycleEvent.CREATED);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainEventsResult
                .ruleChains(new HashSet<>())
                .ruleNodeEvents(ruleNodeEvents)
                .trackRuleNodeEvents(true)
                .build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult2 =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 =
        onlyRuleNodeLifecycleFailuresResult2.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult2.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(false).build();

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult2 =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult2 =
        onlyRuleNodeLifecycleFailuresResult2.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult2 =
        ruleChainEventsResult2.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleEngineComponentLifecycleEventNotificationRuleTriggerConfig,
        ruleChainsResult2.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build());
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build(), null);
  }

  /**
   * Test {@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.equals(Object)",
    "int RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        onlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainEventsResult =
        onlyRuleNodeLifecycleFailuresResult.ruleChainEvents(new HashSet<>());

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder ruleChainsResult =
        ruleChainEventsResult.ruleChains(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        ruleChainsResult.ruleNodeEvents(new HashSet<>()).trackRuleNodeEvents(true).build(),
        "Different type to RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleChainLifecycleFailures(boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleNodeLifecycleFailures(boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChainEvents(Set)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChains(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleNodeEvents(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setTrackRuleNodeEvents(boolean)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#toString()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChainEvents()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChains()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleNodeEvents()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleChainLifecycleFailures()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleNodeLifecycleFailures()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isTrackRuleNodeEvents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.<init>()",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.<init>(Set, Set, boolean, boolean, Set, boolean)",
    "Set RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChainEvents()",
    "Set RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains()",
    "Set RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleNodeEvents()",
    "NotificationRuleTriggerType RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getTriggerType()",
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.isOnlyRuleChainLifecycleFailures()",
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.isOnlyRuleNodeLifecycleFailures()",
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.isTrackRuleNodeEvents()",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleChainLifecycleFailures(boolean)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleNodeLifecycleFailures(boolean)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChainEvents(Set)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChains(Set)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleNodeEvents(Set)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setTrackRuleNodeEvents(boolean)",
    "String RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            new RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .setOnlyRuleChainLifecycleFailures(true);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .setOnlyRuleNodeLifecycleFailures(true);
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChainEvents(
        ruleChainEvents);
    HashSet<UUID> ruleChains = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChains(ruleChains);
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleNodeEvents(
        ruleNodeEvents);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setTrackRuleNodeEvents(
        true);
    String actualToStringResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.toString();
    Set<ComponentLifecycleEvent> actualRuleChainEvents =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChainEvents();
    Set<UUID> actualRuleChains =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains();
    Set<ComponentLifecycleEvent> actualRuleNodeEvents =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleNodeEvents();
    NotificationRuleTriggerType actualTriggerType =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsOnlyRuleChainLifecycleFailuresResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isOnlyRuleChainLifecycleFailures();
    boolean actualIsOnlyRuleNodeLifecycleFailuresResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isOnlyRuleNodeLifecycleFailures();
    boolean actualIsTrackRuleNodeEventsResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isTrackRuleNodeEvents();

    // Assert
    assertEquals(
        "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(ruleChains=[], ruleChainEvents=[],"
            + " onlyRuleChainLifecycleFailures=true, trackRuleNodeEvents=true, ruleNodeEvents=[], onlyRuleNodeLifec"
            + "ycleFailures=true)",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT, actualTriggerType);
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
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(Set,
   *       Set, boolean, boolean, Set, boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleChainLifecycleFailures(boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setOnlyRuleNodeLifecycleFailures(boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChainEvents(Set)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleChains(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setRuleNodeEvents(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#setTrackRuleNodeEvents(boolean)}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#toString()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChainEvents()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleChains()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getRuleNodeEvents()}
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleChainLifecycleFailures()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isOnlyRuleNodeLifecycleFailures()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig#isTrackRuleNodeEvents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.<init>()",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.<init>(Set, Set, boolean, boolean, Set, boolean)",
    "Set RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChainEvents()",
    "Set RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains()",
    "Set RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleNodeEvents()",
    "NotificationRuleTriggerType RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getTriggerType()",
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.isOnlyRuleChainLifecycleFailures()",
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.isOnlyRuleNodeLifecycleFailures()",
    "boolean RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.isTrackRuleNodeEvents()",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleChainLifecycleFailures(boolean)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setOnlyRuleNodeLifecycleFailures(boolean)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChainEvents(Set)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChains(Set)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleNodeEvents(Set)",
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setTrackRuleNodeEvents(boolean)",
    "String RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<UUID> ruleChains = new HashSet<>();
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();

    // Act
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            new RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(
                ruleChains, ruleChainEvents, true, true, new HashSet<>(), true);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .setOnlyRuleChainLifecycleFailures(true);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        .setOnlyRuleNodeLifecycleFailures(true);
    HashSet<ComponentLifecycleEvent> ruleChainEvents2 = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChainEvents(
        ruleChainEvents2);
    HashSet<UUID> ruleChains2 = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleChains(ruleChains2);
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setRuleNodeEvents(
        ruleNodeEvents);
    actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.setTrackRuleNodeEvents(
        true);
    String actualToStringResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.toString();
    Set<ComponentLifecycleEvent> actualRuleChainEvents =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChainEvents();
    Set<UUID> actualRuleChains =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains();
    Set<ComponentLifecycleEvent> actualRuleNodeEvents =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleNodeEvents();
    NotificationRuleTriggerType actualTriggerType =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsOnlyRuleChainLifecycleFailuresResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isOnlyRuleChainLifecycleFailures();
    boolean actualIsOnlyRuleNodeLifecycleFailuresResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isOnlyRuleNodeLifecycleFailures();
    boolean actualIsTrackRuleNodeEventsResult =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isTrackRuleNodeEvents();

    // Assert
    assertEquals(
        "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig(ruleChains=[], ruleChainEvents=[],"
            + " onlyRuleChainLifecycleFailures=true, trackRuleNodeEvents=true, ruleNodeEvents=[], onlyRuleNodeLifec"
            + "ycleFailures=true)",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT, actualTriggerType);
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
   * Test RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder {@link
   * RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#onlyRuleChainLifecycleFailures(boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#onlyRuleNodeLifecycleFailures(boolean)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#ruleChainEvents(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#ruleChains(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#ruleNodeEvents(Set)}
   *   <li>{@link
   *       RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder#trackRuleNodeEvents(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.<init>()",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.build()",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.onlyRuleChainLifecycleFailures(boolean)",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.onlyRuleNodeLifecycleFailures(boolean)",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.ruleChainEvents(Set)",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.ruleChains(Set)",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.ruleNodeEvents(Set)",
    "String RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.toString()",
    "RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder.trackRuleNodeEvents(boolean)"
  })
  void testRuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        actualOnlyRuleNodeLifecycleFailuresResult =
            RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.builder()
                .onlyRuleChainLifecycleFailures(true)
                .onlyRuleNodeLifecycleFailures(true);
    HashSet<ComponentLifecycleEvent> ruleChainEvents = new HashSet<>();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder
        actualRuleChainEventsResult =
            actualOnlyRuleNodeLifecycleFailuresResult.ruleChainEvents(ruleChainEvents);
    HashSet<UUID> ruleChains = new HashSet<>();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfigBuilder actualRuleChainsResult =
        actualRuleChainEventsResult.ruleChains(ruleChains);
    HashSet<ComponentLifecycleEvent> ruleNodeEvents = new HashSet<>();
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig =
            actualRuleChainsResult.ruleNodeEvents(ruleNodeEvents).trackRuleNodeEvents(true).build();

    // Assert
    assertEquals(
        "#",
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT,
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getTriggerType());
    Set<ComponentLifecycleEvent> ruleChainEvents2 =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChainEvents();
    assertTrue(ruleChainEvents2.isEmpty());
    Set<UUID> ruleChains2 =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleChains();
    assertTrue(ruleChains2.isEmpty());
    Set<ComponentLifecycleEvent> ruleNodeEvents2 =
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.getRuleNodeEvents();
    assertTrue(ruleNodeEvents2.isEmpty());
    assertTrue(
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isOnlyRuleChainLifecycleFailures());
    assertTrue(
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isOnlyRuleNodeLifecycleFailures());
    assertTrue(
        actualRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig
            .isTrackRuleNodeEvents());
    assertSame(ruleChainEvents, ruleChainEvents2);
    assertSame(ruleChains, ruleChains2);
    assertSame(ruleNodeEvents, ruleNodeEvents2);
  }
}
