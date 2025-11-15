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
package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class DefaultNotificationRuleRecipientsConfigDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultNotificationRuleRecipientsConfig#getTargetsTable()}
   */
  @Test
  void testGetTargetsTable() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    ArrayList<UUID> targets = new ArrayList<>();
    defaultNotificationRuleRecipientsConfig.setTargets(targets);
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act
    Map<Integer, List<UUID>> actualTargetsTable = defaultNotificationRuleRecipientsConfig.getTargetsTable();

    // Assert
    assertEquals(1, actualTargetsTable.size());
    List<UUID> getResult = actualTargetsTable.get(0);
    assertTrue(getResult.isEmpty());
    assertSame(targets, getResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig2.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
    int expectedHashCodeResult = defaultNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, defaultNotificationRuleRecipientsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig);
    int expectedHashCodeResult = defaultNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, defaultNotificationRuleRecipientsConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<UUID> targets = new ArrayList<>();
    targets.add(EntityId.NULL_UUID);

    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(targets);
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig2.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test:
   * {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(null);

    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig2.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test:
   * {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, null);
  }

  /**
   * Method under test:
   * {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig,
        "Different type to DefaultNotificationRuleRecipientsConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultNotificationRuleRecipientsConfig}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#setTargets(List)}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#toString()}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#getTargets()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultNotificationRuleRecipientsConfig actualDefaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    ArrayList<UUID> targets = new ArrayList<>();
    actualDefaultNotificationRuleRecipientsConfig.setTargets(targets);
    String actualToStringResult = actualDefaultNotificationRuleRecipientsConfig.toString();

    // Assert that nothing has changed
    assertEquals("DefaultNotificationRuleRecipientsConfig(targets=[])", actualToStringResult);
    assertSame(targets, actualDefaultNotificationRuleRecipientsConfig.getTargets());
  }
}
