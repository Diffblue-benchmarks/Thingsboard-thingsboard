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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NotificationRuleRecipientsConfigDiffblueTest {
  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new DefaultNotificationRuleRecipientsConfig()).canEqual("Other"));
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    // Act and Assert
    assertTrue(defaultNotificationRuleRecipientsConfig.canEqual(new DefaultNotificationRuleRecipientsConfig()));
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = new DefaultNotificationRuleRecipientsConfig();

    // Act and Assert
    assertEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
    int expectedHashCodeResult = defaultNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, defaultNotificationRuleRecipientsConfig2.hashCode());
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    // Act and Assert
    assertEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig);
    int expectedHashCodeResult = defaultNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, defaultNotificationRuleRecipientsConfig.hashCode());
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig);
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = mock(
        DefaultNotificationRuleRecipientsConfig.class);
    when(defaultNotificationRuleRecipientsConfig2.getTargets()).thenReturn(new ArrayList<>());
    when(defaultNotificationRuleRecipientsConfig2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(defaultNotificationRuleRecipientsConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = mock(
        DefaultNotificationRuleRecipientsConfig.class);
    when(defaultNotificationRuleRecipientsConfig2.getTargets()).thenReturn(new ArrayList<>());
    when(defaultNotificationRuleRecipientsConfig2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(defaultNotificationRuleRecipientsConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ALARM);
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig2 = mock(
        DefaultNotificationRuleRecipientsConfig.class);
    when(defaultNotificationRuleRecipientsConfig2.getTargets()).thenReturn(new ArrayList<>());
    when(defaultNotificationRuleRecipientsConfig2.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(defaultNotificationRuleRecipientsConfig2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig2);
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultNotificationRuleRecipientsConfig(), null);
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultNotificationRuleRecipientsConfig(),
        "Different type to NotificationRuleRecipientsConfig");
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#getTriggerType()}
   */
  @Test
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertNull((new DefaultNotificationRuleRecipientsConfig()).getTriggerType());
  }

  /**
   * Method under test:
   * {@link NotificationRuleRecipientsConfig#setTriggerType(NotificationRuleTriggerType)}
   */
  @Test
  void testSetTriggerType() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    // Act
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Assert
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, defaultNotificationRuleRecipientsConfig.getTriggerType());
  }

  /**
   * Method under test: {@link NotificationRuleRecipientsConfig#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("DefaultNotificationRuleRecipientsConfig(targets=null)",
        (new DefaultNotificationRuleRecipientsConfig()).toString());
  }
}
