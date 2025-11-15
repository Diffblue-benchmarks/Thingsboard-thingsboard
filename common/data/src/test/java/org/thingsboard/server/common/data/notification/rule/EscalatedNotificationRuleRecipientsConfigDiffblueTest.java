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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class EscalatedNotificationRuleRecipientsConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertEquals(escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
    int expectedHashCodeResult = escalatedNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, escalatedNotificationRuleRecipientsConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertEquals(escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig);
    int expectedHashCodeResult = escalatedNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, escalatedNotificationRuleRecipientsConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<Integer, List<UUID>> escalationTable = new HashMap<>();
    escalationTable.put(1, new ArrayList<>());

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(escalationTable);
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test:
   * {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<Integer, List<UUID>> escalationTable = new HashMap<>();
    escalationTable.computeIfPresent(1, mock(BiFunction.class));
    escalationTable.put(1, new ArrayList<>());

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(escalationTable);
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test:
   * {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(null);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test:
   * {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(escalatedNotificationRuleRecipientsConfig, null);
  }

  /**
   * Method under test:
   * {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(escalatedNotificationRuleRecipientsConfig,
        "Different type to EscalatedNotificationRuleRecipientsConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EscalatedNotificationRuleRecipientsConfig}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#setEscalationTable(Map)}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#toString()}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#getEscalationTable()}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#getTargetsTable()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EscalatedNotificationRuleRecipientsConfig actualEscalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    HashMap<Integer, List<UUID>> escalationTable = new HashMap<>();
    actualEscalatedNotificationRuleRecipientsConfig.setEscalationTable(escalationTable);
    String actualToStringResult = actualEscalatedNotificationRuleRecipientsConfig.toString();
    Map<Integer, List<UUID>> actualEscalationTable = actualEscalatedNotificationRuleRecipientsConfig
        .getEscalationTable();
    Map<Integer, List<UUID>> actualTargetsTable = actualEscalatedNotificationRuleRecipientsConfig.getTargetsTable();

    // Assert that nothing has changed
    assertEquals("EscalatedNotificationRuleRecipientsConfig(escalationTable={})", actualToStringResult);
    assertTrue(actualEscalationTable.isEmpty());
    assertSame(escalationTable, actualEscalationTable);
    assertSame(escalationTable, actualTargetsTable);
  }
}
