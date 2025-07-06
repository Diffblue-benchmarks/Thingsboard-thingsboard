package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class EscalatedNotificationRuleRecipientsConfigDiffblueTest {
  /**
   * Test {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}, and {@link
   * EscalatedNotificationRuleRecipientsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EscalatedNotificationRuleRecipientsConfig.equals(Object)",
    "int EscalatedNotificationRuleRecipientsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertEquals(
        escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
    int expectedHashCodeResult = escalatedNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, escalatedNotificationRuleRecipientsConfig2.hashCode());
  }

  /**
   * Test {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}, and {@link
   * EscalatedNotificationRuleRecipientsConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EscalatedNotificationRuleRecipientsConfig.equals(Object)",
    "int EscalatedNotificationRuleRecipientsConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertEquals(
        escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig);
    int expectedHashCodeResult = escalatedNotificationRuleRecipientsConfig.hashCode();
    assertEquals(expectedHashCodeResult, escalatedNotificationRuleRecipientsConfig.hashCode());
  }

  /**
   * Test {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EscalatedNotificationRuleRecipientsConfig.equals(Object)",
    "int EscalatedNotificationRuleRecipientsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<Integer, List<UUID>> escalationTable = new HashMap<>();
    escalationTable.put(1, new ArrayList<>());

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(escalationTable);
    escalatedNotificationRuleRecipientsConfig.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(
        escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
  }

  /**
   * Test {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EscalatedNotificationRuleRecipientsConfig.equals(Object)",
    "int EscalatedNotificationRuleRecipientsConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(null);

    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig2 =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig2.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig2.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(
        escalatedNotificationRuleRecipientsConfig, escalatedNotificationRuleRecipientsConfig2);
  }

  /**
   * Test {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EscalatedNotificationRuleRecipientsConfig.equals(Object)",
    "int EscalatedNotificationRuleRecipientsConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(escalatedNotificationRuleRecipientsConfig, null);
  }

  /**
   * Test {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EscalatedNotificationRuleRecipientsConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EscalatedNotificationRuleRecipientsConfig.equals(Object)",
    "int EscalatedNotificationRuleRecipientsConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig escalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    escalatedNotificationRuleRecipientsConfig.setEscalationTable(new HashMap<>());
    escalatedNotificationRuleRecipientsConfig.setTriggerType(
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(
        escalatedNotificationRuleRecipientsConfig,
        "Different type to EscalatedNotificationRuleRecipientsConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EscalatedNotificationRuleRecipientsConfig}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#setEscalationTable(Map)}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#toString()}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#getEscalationTable()}
   *   <li>{@link EscalatedNotificationRuleRecipientsConfig#getTargetsTable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EscalatedNotificationRuleRecipientsConfig.<init>()",
    "Map EscalatedNotificationRuleRecipientsConfig.getEscalationTable()",
    "Map EscalatedNotificationRuleRecipientsConfig.getTargetsTable()",
    "void EscalatedNotificationRuleRecipientsConfig.setEscalationTable(Map)",
    "String EscalatedNotificationRuleRecipientsConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EscalatedNotificationRuleRecipientsConfig actualEscalatedNotificationRuleRecipientsConfig =
        new EscalatedNotificationRuleRecipientsConfig();
    HashMap<Integer, List<UUID>> escalationTable = new HashMap<>();
    actualEscalatedNotificationRuleRecipientsConfig.setEscalationTable(escalationTable);
    String actualToStringResult = actualEscalatedNotificationRuleRecipientsConfig.toString();
    Map<Integer, List<UUID>> actualEscalationTable =
        actualEscalatedNotificationRuleRecipientsConfig.getEscalationTable();
    Map<Integer, List<UUID>> actualTargetsTable =
        actualEscalatedNotificationRuleRecipientsConfig.getTargetsTable();

    // Assert
    assertEquals(
        "EscalatedNotificationRuleRecipientsConfig(escalationTable={})", actualToStringResult);
    assertNull(actualEscalatedNotificationRuleRecipientsConfig.getTriggerType());
    assertTrue(actualEscalationTable.isEmpty());
    assertSame(escalationTable, actualEscalationTable);
    assertSame(escalationTable, actualTargetsTable);
  }
}
