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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NotificationRuleRecipientsConfigDiffblueTest {
  /**
   * Test {@link NotificationRuleRecipientsConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@link DefaultNotificationRuleRecipientsConfig} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when DefaultNotificationRuleRecipientsConfig (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.canEqual(Object)"})
  void testCanEqual_whenDefaultNotificationRuleRecipientsConfig_thenReturnTrue() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    // Act and Assert
    assertTrue(defaultNotificationRuleRecipientsConfig.canEqual(new DefaultNotificationRuleRecipientsConfig()));
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DefaultNotificationRuleRecipientsConfig()).canEqual("Other"));
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}, and {@link NotificationRuleRecipientsConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}, and {@link NotificationRuleRecipientsConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    // Act and Assert
    assertEquals(defaultNotificationRuleRecipientsConfig, defaultNotificationRuleRecipientsConfig);
    int expectedHashCodeResult = defaultNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, defaultNotificationRuleRecipientsConfig.hashCode());
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultNotificationRuleRecipientsConfig(), null);
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRuleRecipientsConfig.equals(Object)",
      "int NotificationRuleRecipientsConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultNotificationRuleRecipientsConfig(),
        "Different type to NotificationRuleRecipientsConfig");
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#getTriggerType()}.
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType NotificationRuleRecipientsConfig.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertNull((new DefaultNotificationRuleRecipientsConfig()).getTriggerType());
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#setTriggerType(NotificationRuleTriggerType)}.
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#setTriggerType(NotificationRuleTriggerType)}
   */
  @Test
  @DisplayName("Test setTriggerType(NotificationRuleTriggerType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType)"})
  void testSetTriggerType() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();

    // Act
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Assert
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, defaultNotificationRuleRecipientsConfig.getTriggerType());
  }

  /**
   * Test {@link NotificationRuleRecipientsConfig#toString()}.
   * <p>
   * Method under test: {@link NotificationRuleRecipientsConfig#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String NotificationRuleRecipientsConfig.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("DefaultNotificationRuleRecipientsConfig(targets=null)",
        (new DefaultNotificationRuleRecipientsConfig()).toString());
  }
}
