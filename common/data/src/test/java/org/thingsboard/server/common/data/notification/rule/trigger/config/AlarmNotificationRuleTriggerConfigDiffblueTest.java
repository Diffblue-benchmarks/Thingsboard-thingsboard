package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmNotificationRuleTriggerConfig.ClearRule;

class AlarmNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test AlarmNotificationRuleTriggerConfigBuilder
   * {@link AlarmNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder#alarmSeverities(Set)}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder#alarmTypes(Set)}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder#clearRule(AlarmNotificationRuleTriggerConfig.ClearRule)}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmNotificationRuleTriggerConfigBuilder build()")
  void testAlarmNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(alarmSeverities);
    HashSet<String> alarmTypes = new HashSet<>();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmSeveritiesResult
        .alarmTypes(alarmTypes)
        .clearRule(clearRule);
    HashSet<AlarmNotificationRuleTriggerConfig.AlarmAction> notifyOn = new HashSet<>();

    // Act
    AlarmNotificationRuleTriggerConfig actualBuildResult = clearRuleResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.ALARM, actualBuildResult.getTriggerType());
    Set<AlarmSeverity> alarmSeverities2 = actualBuildResult.getAlarmSeverities();
    assertTrue(alarmSeverities2.isEmpty());
    Set<String> alarmTypes2 = actualBuildResult.getAlarmTypes();
    assertTrue(alarmTypes2.isEmpty());
    Set<AlarmNotificationRuleTriggerConfig.AlarmAction> notifyOn2 = actualBuildResult.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(alarmSeverities, alarmSeverities2);
    assertSame(alarmTypes, alarmTypes2);
    assertSame(notifyOn, notifyOn2);
    assertSame(clearRule, actualBuildResult.getClearRule());
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}, and
   * {@link ClearRule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClearRule equals(Object), and hashCode(); when other is equal; then return equal")
  void testClearRuleEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule2 = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertEquals(clearRule, clearRule2);
    int expectedHashCodeResult = clearRule.hashCode();
    assertEquals(expectedHashCodeResult, clearRule2.hashCode());
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}, and
   * {@link ClearRule#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClearRule equals(Object), and hashCode(); when other is same; then return equal")
  void testClearRuleEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertEquals(clearRule, clearRule);
    int expectedHashCodeResult = clearRule.hashCode();
    assertEquals(expectedHashCodeResult, clearRule.hashCode());
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ClearRule equals(Object); when other is different; then return not equal")
  void testClearRuleEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    alarmStatuses.add(AlarmSearchStatus.ANY);

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(alarmStatuses);

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule2 = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, clearRule2);
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ClearRule equals(Object); when other is 'null'; then return not equal")
  void testClearRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, null);
  }

  /**
   * Test ClearRule {@link ClearRule#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   */
  @Test
  @DisplayName("Test ClearRule equals(Object); when other is wrong type; then return not equal")
  void testClearRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, "Different type to ClearRule");
  }

  /**
   * Test ClearRule getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#setAlarmStatuses(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#toString()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#getAlarmStatuses()}
   * </ul>
   */
  @Test
  @DisplayName("Test ClearRule getters and setters")
  void testClearRuleGettersAndSetters() {
    // Arrange and Act
    AlarmNotificationRuleTriggerConfig.ClearRule actualClearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualClearRule.setAlarmStatuses(alarmStatuses);
    String actualToStringResult = actualClearRule.toString();
    Set<AlarmSearchStatus> actualAlarmStatuses = actualClearRule.getAlarmStatuses();

    // Assert that nothing has changed
    assertEquals("AlarmNotificationRuleTriggerConfig.ClearRule(alarmStatuses=[])", actualToStringResult);
    assertTrue(actualAlarmStatuses.isEmpty());
    assertSame(alarmStatuses, actualAlarmStatuses);
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link AlarmNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmSeveritiesResult
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig buildResult = clearRuleResult.notifyOn(new HashSet<>()).build();

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule2 = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult2 = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult2
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 = alarmSeveritiesResult2
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule2);
    AlarmNotificationRuleTriggerConfig buildResult2 = clearRuleResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link AlarmNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmSeveritiesResult
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig buildResult = clearRuleResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder = mock(
        AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder.class);
    when(alarmNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmNotificationRuleTriggerConfig.builder());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmSeveritiesResult
        .alarmTypes(new HashSet<>());

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmTypesResult
        .clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig buildResult = clearRuleResult.notifyOn(new HashSet<>()).build();

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule2 = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 = alarmSeveritiesResult2
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule2);
    AlarmNotificationRuleTriggerConfig buildResult2 = clearRuleResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder = mock(
        AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder.class);
    when(alarmNotificationRuleTriggerConfigBuilder.alarmTypes(Mockito.<Set<String>>any()))
        .thenReturn(AlarmNotificationRuleTriggerConfig.builder());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder.class);
    when(alarmNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmNotificationRuleTriggerConfigBuilder);
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmSeveritiesResult
        .alarmTypes(new HashSet<>());

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmTypesResult
        .clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig buildResult = clearRuleResult.notifyOn(new HashSet<>()).build();

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule2 = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult2 = alarmSeveritiesResult2
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule2);
    AlarmNotificationRuleTriggerConfig buildResult2 = clearRuleResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmSeveritiesResult
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig buildResult = clearRuleResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link AlarmNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder builderResult = AlarmNotificationRuleTriggerConfig
        .builder();
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmNotificationRuleTriggerConfig.AlarmNotificationRuleTriggerConfigBuilder clearRuleResult = alarmSeveritiesResult
        .alarmTypes(new HashSet<>())
        .clearRule(clearRule);
    AlarmNotificationRuleTriggerConfig buildResult = clearRuleResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig#AlarmNotificationRuleTriggerConfig()}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig#setClearRule(AlarmNotificationRuleTriggerConfig.ClearRule)}
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
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmNotificationRuleTriggerConfig actualAlarmNotificationRuleTriggerConfig = new AlarmNotificationRuleTriggerConfig();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities);
    HashSet<String> alarmTypes = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes);
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());
    actualAlarmNotificationRuleTriggerConfig.setClearRule(clearRule);
    HashSet<AlarmNotificationRuleTriggerConfig.AlarmAction> notifyOn = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualAlarmNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities = actualAlarmNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<String> actualAlarmTypes = actualAlarmNotificationRuleTriggerConfig.getAlarmTypes();
    AlarmNotificationRuleTriggerConfig.ClearRule actualClearRule = actualAlarmNotificationRuleTriggerConfig
        .getClearRule();
    Set<AlarmNotificationRuleTriggerConfig.AlarmAction> actualNotifyOn = actualAlarmNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("AlarmNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], notifyOn=[], clearRule"
        + "=AlarmNotificationRuleTriggerConfig.ClearRule(alarmStatuses=[]))", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ALARM, actualAlarmNotificationRuleTriggerConfig.getTriggerType());
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig#AlarmNotificationRuleTriggerConfig(Set, Set, Set, AlarmNotificationRuleTriggerConfig.ClearRule)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>
   * {@link AlarmNotificationRuleTriggerConfig#setClearRule(AlarmNotificationRuleTriggerConfig.ClearRule)}
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
  void testGettersAndSetters_givenHashSet_whenHashSet() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    HashSet<AlarmNotificationRuleTriggerConfig.AlarmAction> notifyOn = new HashSet<>();

    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act
    AlarmNotificationRuleTriggerConfig actualAlarmNotificationRuleTriggerConfig = new AlarmNotificationRuleTriggerConfig(
        alarmTypes, alarmSeverities, notifyOn, clearRule);
    HashSet<AlarmSeverity> alarmSeverities2 = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities2);
    HashSet<String> alarmTypes2 = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes2);
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule2 = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule2.setAlarmStatuses(new HashSet<>());
    actualAlarmNotificationRuleTriggerConfig.setClearRule(clearRule2);
    HashSet<AlarmNotificationRuleTriggerConfig.AlarmAction> notifyOn2 = new HashSet<>();
    actualAlarmNotificationRuleTriggerConfig.setNotifyOn(notifyOn2);
    String actualToStringResult = actualAlarmNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities = actualAlarmNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<String> actualAlarmTypes = actualAlarmNotificationRuleTriggerConfig.getAlarmTypes();
    AlarmNotificationRuleTriggerConfig.ClearRule actualClearRule = actualAlarmNotificationRuleTriggerConfig
        .getClearRule();
    Set<AlarmNotificationRuleTriggerConfig.AlarmAction> actualNotifyOn = actualAlarmNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("AlarmNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], notifyOn=[], clearRule"
        + "=AlarmNotificationRuleTriggerConfig.ClearRule(alarmStatuses=[]))", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ALARM, actualAlarmNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(alarmSeverities2, actualAlarmSeverities);
    assertSame(alarmTypes2, actualAlarmTypes);
    assertSame(notifyOn2, actualNotifyOn);
    assertSame(clearRule2, actualClearRule);
  }
}
