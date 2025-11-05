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
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmNotificationRuleTriggerConfig.AlarmAction;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmNotificationRuleTriggerConfig.ClearRule;

@ContextConfiguration(classes = {AlarmNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class AlarmNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder;

  /**
   * Test AlarmNotificationRuleTriggerConfigBuilder {@link
   * AlarmNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link AlarmNotificationRuleTriggerConfigBuilder#alarmSeverities(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfigBuilder#alarmTypes(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfigBuilder#clearRule(ClearRule)}
   *   <li>{@link AlarmNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmNotificationRuleTriggerConfigBuilder.<init>()",
    "AlarmNotificationRuleTriggerConfigBuilder AlarmNotificationRuleTriggerConfigBuilder.alarmSeverities(Set)",
    "AlarmNotificationRuleTriggerConfigBuilder AlarmNotificationRuleTriggerConfigBuilder.alarmTypes(Set)",
    "AlarmNotificationRuleTriggerConfig AlarmNotificationRuleTriggerConfigBuilder.build()",
    "AlarmNotificationRuleTriggerConfigBuilder AlarmNotificationRuleTriggerConfigBuilder.clearRule(ClearRule)",
    "AlarmNotificationRuleTriggerConfigBuilder AlarmNotificationRuleTriggerConfigBuilder.notifyOn(Set)",
    "String AlarmNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testAlarmNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    AlarmNotificationRuleTriggerConfigBuilder actualBuilderResult =
        AlarmNotificationRuleTriggerConfig.builder();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    AlarmNotificationRuleTriggerConfigBuilder actualAlarmSeveritiesResult =
        actualBuilderResult.alarmSeverities(alarmSeverities);
    HashSet<String> alarmTypes = new HashSet<>();
    AlarmNotificationRuleTriggerConfigBuilder actualAlarmTypesResult =
        actualAlarmSeveritiesResult.alarmTypes(alarmTypes);
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfigBuilder actualClearRuleResult =
        actualAlarmTypesResult.clearRule(clearRule);
    HashSet<AlarmAction> notifyOn = new HashSet<>();
    AlarmNotificationRuleTriggerConfig actualAlarmNotificationRuleTriggerConfig =
        actualClearRuleResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualAlarmNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.ALARM,
        actualAlarmNotificationRuleTriggerConfig.getTriggerType());
    Set<AlarmSeverity> alarmSeverities2 =
        actualAlarmNotificationRuleTriggerConfig.getAlarmSeverities();
    assertTrue(alarmSeverities2.isEmpty());
    Set<String> alarmTypes2 = actualAlarmNotificationRuleTriggerConfig.getAlarmTypes();
    assertTrue(alarmTypes2.isEmpty());
    Set<AlarmAction> notifyOn2 = actualAlarmNotificationRuleTriggerConfig.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(alarmSeverities, alarmSeverities2);
    assertSame(alarmTypes, alarmTypes2);
    assertSame(notifyOn, notifyOn2);
    assertSame(clearRule, actualAlarmNotificationRuleTriggerConfig.getClearRule());
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}, and {@link ClearRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClearRule#equals(Object)}
   *   <li>{@link ClearRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ClearRule equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClearRule.equals(Object)", "int ClearRule.hashCode()"})
  void testClearRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertEquals(clearRule, clearRule2);
    assertEquals(clearRule.hashCode(), clearRule2.hashCode());
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}, and {@link ClearRule#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClearRule#equals(Object)}
   *   <li>{@link ClearRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test ClearRule equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClearRule.equals(Object)", "int ClearRule.hashCode()"})
  void testClearRuleEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertEquals(clearRule, clearRule);
    int expectedHashCodeResult = clearRule.hashCode();
    assertEquals(expectedHashCodeResult, clearRule.hashCode());
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClearRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ClearRule equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClearRule.equals(Object)", "int ClearRule.hashCode()"})
  void testClearRuleEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    alarmStatuses.add(AlarmSearchStatus.ANY);

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(alarmStatuses);

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, clearRule2);
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClearRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ClearRule equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClearRule.equals(Object)", "int ClearRule.hashCode()"})
  void testClearRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, null);
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClearRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ClearRule equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClearRule.equals(Object)", "int ClearRule.hashCode()"})
  void testClearRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, "Different type to ClearRule");
  }

  /**
   * Test ClearRule getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ClearRule}
   *   <li>{@link ClearRule#setAlarmStatuses(Set)}
   *   <li>{@link ClearRule#toString()}
   *   <li>{@link ClearRule#getAlarmStatuses()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClearRule getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClearRule.<init>()",
    "Set ClearRule.getAlarmStatuses()",
    "void ClearRule.setAlarmStatuses(Set)",
    "String ClearRule.toString()"
  })
  void testClearRuleGettersAndSetters() {
    // Arrange and Act
    ClearRule actualClearRule = new ClearRule();
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualClearRule.setAlarmStatuses(alarmStatuses);
    String actualToStringResult = actualClearRule.toString();
    Set<AlarmSearchStatus> actualAlarmStatuses = actualClearRule.getAlarmStatuses();

    // Assert
    assertEquals(
        "AlarmNotificationRuleTriggerConfig.ClearRule(alarmStatuses=[])", actualToStringResult);
    assertTrue(actualAlarmStatuses.isEmpty());
    assertSame(alarmStatuses, actualAlarmStatuses);
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult2.alarmTypes(new HashSet<>()).clearRule(clearRule2);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig2 =
        clearRuleResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(alarmNotificationRuleTriggerConfig, alarmNotificationRuleTriggerConfig2);
    assertEquals(
        alarmNotificationRuleTriggerConfig.hashCode(),
        alarmNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(alarmNotificationRuleTriggerConfig, alarmNotificationRuleTriggerConfig);
    int expectedHashCodeResult = alarmNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, alarmNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    alarmStatuses.add(AlarmSearchStatus.ANY);

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(alarmStatuses);

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult2.alarmTypes(new HashSet<>()).clearRule(clearRule2);

    // Act and Assert
    assertNotEquals(
        alarmNotificationRuleTriggerConfig, clearRuleResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    alarmSeverities.add(AlarmSeverity.CRITICAL);

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        AlarmNotificationRuleTriggerConfig.builder().alarmSeverities(alarmSeverities);

    AlarmNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>());

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmTypesResult.clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult2.alarmTypes(new HashSet<>()).clearRule(clearRule2);

    // Act and Assert
    assertNotEquals(
        alarmNotificationRuleTriggerConfig, clearRuleResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    alarmTypes.add("foo");

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmTypesResult =
        builderResult.alarmSeverities(new HashSet<>()).alarmTypes(alarmTypes);

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmTypesResult.clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule2);

    // Act and Assert
    assertNotEquals(
        alarmNotificationRuleTriggerConfig, clearRuleResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule);

    HashSet<AlarmAction> notifyOn = new HashSet<>();
    notifyOn.add(AlarmAction.CREATED);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(notifyOn).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult2.alarmTypes(new HashSet<>()).clearRule(clearRule2);

    // Act and Assert
    assertNotEquals(
        alarmNotificationRuleTriggerConfig, clearRuleResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder =
        mock(AlarmNotificationRuleTriggerConfigBuilder.class);
    when(alarmNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmNotificationRuleTriggerConfig.builder());

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>());

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmTypesResult.clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult2.alarmTypes(new HashSet<>()).clearRule(clearRule2);

    // Act and Assert
    assertNotEquals(
        alarmNotificationRuleTriggerConfig, clearRuleResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder =
        mock(AlarmNotificationRuleTriggerConfigBuilder.class);
    when(alarmNotificationRuleTriggerConfigBuilder.alarmTypes(Mockito.<Set<String>>any()))
        .thenReturn(AlarmNotificationRuleTriggerConfig.builder());

    AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder2 =
        mock(AlarmNotificationRuleTriggerConfigBuilder.class);
    when(alarmNotificationRuleTriggerConfigBuilder2.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmNotificationRuleTriggerConfigBuilder);

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmNotificationRuleTriggerConfigBuilder2.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>());

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmTypesResult.clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig alarmNotificationRuleTriggerConfig =
        clearRuleResult.notifyOn(new HashSet<>()).build();

    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 =
        alarmSeveritiesResult2.alarmTypes(new HashSet<>()).clearRule(clearRule2);

    // Act and Assert
    assertNotEquals(
        alarmNotificationRuleTriggerConfig, clearRuleResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule);

    // Act and Assert
    assertNotEquals(clearRuleResult.notifyOn(new HashSet<>()).build(), null);
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder builderResult =
        AlarmNotificationRuleTriggerConfig.builder();

    AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmNotificationRuleTriggerConfigBuilder clearRuleResult =
        alarmSeveritiesResult.alarmTypes(new HashSet<>()).clearRule(clearRule);

    // Act and Assert
    assertNotEquals(
        clearRuleResult.notifyOn(new HashSet<>()).build(),
        "Different type to AlarmNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#AlarmNotificationRuleTriggerConfig()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setClearRule(ClearRule)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getClearRule()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmNotificationRuleTriggerConfig.<init>()",
    "void AlarmNotificationRuleTriggerConfig.<init>(Set, Set, Set, ClearRule)",
    "Set AlarmNotificationRuleTriggerConfig.getAlarmSeverities()",
    "Set AlarmNotificationRuleTriggerConfig.getAlarmTypes()",
    "ClearRule AlarmNotificationRuleTriggerConfig.getClearRule()",
    "Set AlarmNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType AlarmNotificationRuleTriggerConfig.getTriggerType()",
    "void AlarmNotificationRuleTriggerConfig.setAlarmSeverities(Set)",
    "void AlarmNotificationRuleTriggerConfig.setAlarmTypes(Set)",
    "void AlarmNotificationRuleTriggerConfig.setClearRule(ClearRule)",
    "void AlarmNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String AlarmNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmNotificationRuleTriggerConfig actualAlarmNotificationRuleTriggerConfig =
        new AlarmNotificationRuleTriggerConfig();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities);
    HashSet<String> alarmTypes = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes);
    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    actualAlarmNotificationRuleTriggerConfig.setClearRule(clearRule);
    HashSet<AlarmAction> notifyOn = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualAlarmNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities =
        actualAlarmNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<String> actualAlarmTypes = actualAlarmNotificationRuleTriggerConfig.getAlarmTypes();
    ClearRule actualClearRule = actualAlarmNotificationRuleTriggerConfig.getClearRule();
    Set<AlarmAction> actualNotifyOn = actualAlarmNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "AlarmNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], notifyOn=[], clearRule"
            + "=AlarmNotificationRuleTriggerConfig.ClearRule(alarmStatuses=[]))",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.ALARM,
        actualAlarmNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(alarmSeverities, actualAlarmSeverities);
    assertSame(alarmTypes, actualAlarmTypes);
    assertSame(notifyOn, actualNotifyOn);
    assertSame(clearRule, actualClearRule);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#AlarmNotificationRuleTriggerConfig(Set, Set,
   *       Set, ClearRule)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setClearRule(ClearRule)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getClearRule()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; given HashSet(); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmNotificationRuleTriggerConfig.<init>()",
    "void AlarmNotificationRuleTriggerConfig.<init>(Set, Set, Set, ClearRule)",
    "Set AlarmNotificationRuleTriggerConfig.getAlarmSeverities()",
    "Set AlarmNotificationRuleTriggerConfig.getAlarmTypes()",
    "ClearRule AlarmNotificationRuleTriggerConfig.getClearRule()",
    "Set AlarmNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType AlarmNotificationRuleTriggerConfig.getTriggerType()",
    "void AlarmNotificationRuleTriggerConfig.setAlarmSeverities(Set)",
    "void AlarmNotificationRuleTriggerConfig.setAlarmTypes(Set)",
    "void AlarmNotificationRuleTriggerConfig.setClearRule(ClearRule)",
    "void AlarmNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String AlarmNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_givenHashSet_whenHashSet() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    HashSet<AlarmAction> notifyOn = new HashSet<>();

    ClearRule clearRule = new ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act
    AlarmNotificationRuleTriggerConfig actualAlarmNotificationRuleTriggerConfig =
        new AlarmNotificationRuleTriggerConfig(alarmTypes, alarmSeverities, notifyOn, clearRule);
    HashSet<AlarmSeverity> alarmSeverities2 = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities2);
    HashSet<String> alarmTypes2 = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes2);
    ClearRule clearRule2 = new ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());
    actualAlarmNotificationRuleTriggerConfig.setClearRule(clearRule2);
    HashSet<AlarmAction> notifyOn2 = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setNotifyOn(notifyOn2);
    String actualToStringResult = actualAlarmNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities =
        actualAlarmNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<String> actualAlarmTypes = actualAlarmNotificationRuleTriggerConfig.getAlarmTypes();
    ClearRule actualClearRule = actualAlarmNotificationRuleTriggerConfig.getClearRule();
    Set<AlarmAction> actualNotifyOn = actualAlarmNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "AlarmNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], notifyOn=[], clearRule"
            + "=AlarmNotificationRuleTriggerConfig.ClearRule(alarmStatuses=[]))",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.ALARM,
        actualAlarmNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(alarmSeverities2, actualAlarmSeverities);
    assertSame(alarmTypes2, actualAlarmTypes);
    assertSame(notifyOn2, actualNotifyOn);
    assertSame(clearRule2, actualClearRule);
  }
}
