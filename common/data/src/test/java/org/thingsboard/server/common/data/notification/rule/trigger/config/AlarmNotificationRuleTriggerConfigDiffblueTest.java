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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;

class AlarmNotificationRuleTriggerConfigDiffblueTest {
  /**
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
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig.ClearRule#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   */
  @Test
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
   * Method under test:
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   */
  @Test
  void testClearRuleEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, null);
  }

  /**
   * Method under test:
   * {@link AlarmNotificationRuleTriggerConfig.ClearRule#equals(Object)}
   */
  @Test
  void testClearRuleEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmNotificationRuleTriggerConfig.ClearRule clearRule = new AlarmNotificationRuleTriggerConfig.ClearRule();
    clearRule.setAlarmStatuses(new HashSet<>());

    // Act and Assert
    assertNotEquals(clearRule, "Different type to ClearRule");
  }

  /**
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
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AlarmNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
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
  void testGettersAndSetters2() {
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
