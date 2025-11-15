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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class DefaultNotificationRuleRecipientsConfigDiffblueTest {
  /**
   * Test {@link DefaultNotificationRuleRecipientsConfig#getTargetsTable()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleRecipientsConfig#getTargetsTable()}
   */
  @Test
  @DisplayName("Test getTargetsTable(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map DefaultNotificationRuleRecipientsConfig.getTargetsTable()"})
  void testGetTargetsTable_thenReturnSizeIsOne() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act
    Map<Integer, List<UUID>> actualTargetsTable = defaultNotificationRuleRecipientsConfig.getTargetsTable();

    // Assert
    assertEquals(1, actualTargetsTable.size());
    assertTrue(actualTargetsTable.get(0).isEmpty());
  }

  /**
   * Test {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}, and {@link DefaultNotificationRuleRecipientsConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationRuleRecipientsConfig.equals(Object)",
      "int DefaultNotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}, and {@link DefaultNotificationRuleRecipientsConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationRuleRecipientsConfig.equals(Object)",
      "int DefaultNotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationRuleRecipientsConfig.equals(Object)",
      "int DefaultNotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationRuleRecipientsConfig.equals(Object)",
      "int DefaultNotificationRuleRecipientsConfig.hashCode()"})
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
   * Test {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationRuleRecipientsConfig.equals(Object)",
      "int DefaultNotificationRuleRecipientsConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    defaultNotificationRuleRecipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(defaultNotificationRuleRecipientsConfig, null);
  }

  /**
   * Test {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationRuleRecipientsConfig.equals(Object)",
      "int DefaultNotificationRuleRecipientsConfig.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultNotificationRuleRecipientsConfig}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#setTargets(List)}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#toString()}
   *   <li>{@link DefaultNotificationRuleRecipientsConfig#getTargets()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultNotificationRuleRecipientsConfig.<init>()",
      "List DefaultNotificationRuleRecipientsConfig.getTargets()",
      "void DefaultNotificationRuleRecipientsConfig.setTargets(List)",
      "String DefaultNotificationRuleRecipientsConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultNotificationRuleRecipientsConfig actualDefaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    ArrayList<UUID> targets = new ArrayList<>();
    actualDefaultNotificationRuleRecipientsConfig.setTargets(targets);
    String actualToStringResult = actualDefaultNotificationRuleRecipientsConfig.toString();
    List<UUID> actualTargets = actualDefaultNotificationRuleRecipientsConfig.getTargets();

    // Assert
    assertEquals("DefaultNotificationRuleRecipientsConfig(targets=[])", actualToStringResult);
    assertNull(actualDefaultNotificationRuleRecipientsConfig.getTriggerType());
    assertSame(targets, actualTargets);
  }
}
