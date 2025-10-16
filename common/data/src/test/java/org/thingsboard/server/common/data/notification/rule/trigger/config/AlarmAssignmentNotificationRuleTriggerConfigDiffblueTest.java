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
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig.Action;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {AlarmAssignmentNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class AlarmAssignmentNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private AlarmAssignmentNotificationRuleTriggerConfigBuilder
      alarmAssignmentNotificationRuleTriggerConfigBuilder;

  /**
   * Test AlarmAssignmentNotificationRuleTriggerConfigBuilder {@link
   * AlarmAssignmentNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfigBuilder#alarmSeverities(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfigBuilder#alarmStatuses(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfigBuilder#alarmTypes(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmAssignmentNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmAssignmentNotificationRuleTriggerConfigBuilder.<init>()",
    "AlarmAssignmentNotificationRuleTriggerConfigBuilder AlarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(Set)",
    "AlarmAssignmentNotificationRuleTriggerConfigBuilder AlarmAssignmentNotificationRuleTriggerConfigBuilder.alarmStatuses(Set)",
    "AlarmAssignmentNotificationRuleTriggerConfigBuilder AlarmAssignmentNotificationRuleTriggerConfigBuilder.alarmTypes(Set)",
    "AlarmAssignmentNotificationRuleTriggerConfig AlarmAssignmentNotificationRuleTriggerConfigBuilder.build()",
    "AlarmAssignmentNotificationRuleTriggerConfigBuilder AlarmAssignmentNotificationRuleTriggerConfigBuilder.notifyOn(Set)",
    "String AlarmAssignmentNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testAlarmAssignmentNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    AlarmAssignmentNotificationRuleTriggerConfigBuilder actualBuilderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder actualAlarmSeveritiesResult =
        actualBuilderResult.alarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder actualAlarmStatusesResult =
        actualAlarmSeveritiesResult.alarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder actualAlarmTypesResult =
        actualAlarmStatusesResult.alarmTypes(alarmTypes);
    HashSet<Action> notifyOn = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfig
        actualAlarmAssignmentNotificationRuleTriggerConfig =
            actualAlarmTypesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualAlarmAssignmentNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.ALARM_ASSIGNMENT,
        actualAlarmAssignmentNotificationRuleTriggerConfig.getTriggerType());
    Set<AlarmSeverity> alarmSeverities2 =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities();
    assertTrue(alarmSeverities2.isEmpty());
    Set<AlarmSearchStatus> alarmStatuses2 =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses();
    assertTrue(alarmStatuses2.isEmpty());
    Set<String> alarmTypes2 = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes();
    assertTrue(alarmTypes2.isEmpty());
    Set<Action> notifyOn2 = actualAlarmAssignmentNotificationRuleTriggerConfig.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(alarmSeverities, alarmSeverities2);
    assertSame(alarmStatuses, alarmStatuses2);
    assertSame(alarmTypes, alarmTypes2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig2 =
        alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmAssignmentNotificationRuleTriggerConfig2);
    assertEquals(
        alarmAssignmentNotificationRuleTriggerConfig.hashCode(),
        alarmAssignmentNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder2 =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig2 =
        alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmAssignmentNotificationRuleTriggerConfig2);
    assertEquals(
        alarmAssignmentNotificationRuleTriggerConfig.hashCode(),
        alarmAssignmentNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(
        alarmAssignmentNotificationRuleTriggerConfig, alarmAssignmentNotificationRuleTriggerConfig);
    int expectedHashCodeResult = alarmAssignmentNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, alarmAssignmentNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    alarmSeverities.add(AlarmSeverity.CRITICAL);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder().alarmSeverities(alarmSeverities);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    alarmStatuses.add(AlarmSearchStatus.ANY);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        builderResult.alarmSeverities(new HashSet<>()).alarmStatuses(alarmStatuses);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    alarmTypes.add("foo");

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>()).alarmTypes(alarmTypes);
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<Action> notifyOn = new HashSet<>();
    notifyOn.add(Action.ASSIGNED);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmStatusesResult.alarmTypes(new HashSet<>()).notifyOn(notifyOn).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult2.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmStatuses(
            Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder2 =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder3 =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder3.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        alarmAssignmentNotificationRuleTriggerConfigBuilder3.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmTypes(Mockito.<Set<String>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder2 =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmStatuses(
            Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder3 =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder3.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder2);

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmAssignmentNotificationRuleTriggerConfigBuilder3.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig alarmAssignmentNotificationRuleTriggerConfig =
        alarmTypesResult.notifyOn(new HashSet<>()).build();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder
        alarmAssignmentNotificationRuleTriggerConfigBuilder4 =
            mock(AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder4.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        alarmAssignmentNotificationRuleTriggerConfigBuilder4.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 =
        alarmStatusesResult2.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmAssignmentNotificationRuleTriggerConfig,
        alarmTypesResult2.notifyOn(new HashSet<>()).build());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(alarmTypesResult.notifyOn(new HashSet<>()).build(), null);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmAssignmentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmAssignmentNotificationRuleTriggerConfig.builder();

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult =
        alarmStatusesResult.alarmTypes(new HashSet<>());

    // Act and Assert
    assertNotEquals(
        alarmTypesResult.notifyOn(new HashSet<>()).build(),
        "Different type to AlarmAssignmentNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       AlarmAssignmentNotificationRuleTriggerConfig#AlarmAssignmentNotificationRuleTriggerConfig()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getAlarmStatuses()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmAssignmentNotificationRuleTriggerConfig.<init>()",
    "void AlarmAssignmentNotificationRuleTriggerConfig.<init>(Set, Set, Set, Set)",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities()",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses()",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes()",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType AlarmAssignmentNotificationRuleTriggerConfig.getTriggerType()",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setAlarmSeverities(Set)",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setAlarmStatuses(Set)",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setAlarmTypes(Set)",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String AlarmAssignmentNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmAssignmentNotificationRuleTriggerConfig
        actualAlarmAssignmentNotificationRuleTriggerConfig =
            new AlarmAssignmentNotificationRuleTriggerConfig();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes);
    HashSet<Action> notifyOn = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualAlarmAssignmentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes();
    Set<Action> actualNotifyOn = actualAlarmAssignmentNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "AlarmAssignmentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
            + " notifyOn=[])",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.ALARM_ASSIGNMENT,
        actualAlarmAssignmentNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmStatuses.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(alarmSeverities, actualAlarmSeverities);
    assertSame(alarmStatuses, actualAlarmStatuses);
    assertSame(alarmTypes, actualAlarmTypes);
    assertSame(notifyOn, actualNotifyOn);
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
   *       AlarmAssignmentNotificationRuleTriggerConfig#AlarmAssignmentNotificationRuleTriggerConfig(Set,
   *       Set, Set, Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#setNotifyOn(Set)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getAlarmStatuses()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getNotifyOn()}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmAssignmentNotificationRuleTriggerConfig.<init>()",
    "void AlarmAssignmentNotificationRuleTriggerConfig.<init>(Set, Set, Set, Set)",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities()",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses()",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes()",
    "Set AlarmAssignmentNotificationRuleTriggerConfig.getNotifyOn()",
    "NotificationRuleTriggerType AlarmAssignmentNotificationRuleTriggerConfig.getTriggerType()",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setAlarmSeverities(Set)",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setAlarmStatuses(Set)",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setAlarmTypes(Set)",
    "void AlarmAssignmentNotificationRuleTriggerConfig.setNotifyOn(Set)",
    "String AlarmAssignmentNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();

    // Act
    AlarmAssignmentNotificationRuleTriggerConfig
        actualAlarmAssignmentNotificationRuleTriggerConfig =
            new AlarmAssignmentNotificationRuleTriggerConfig(
                alarmTypes, alarmSeverities, alarmStatuses, new HashSet<>());
    HashSet<AlarmSeverity> alarmSeverities2 = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities2);
    HashSet<AlarmSearchStatus> alarmStatuses2 = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses2);
    HashSet<String> alarmTypes2 = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes2);
    HashSet<Action> notifyOn = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualAlarmAssignmentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes =
        actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes();
    Set<Action> actualNotifyOn = actualAlarmAssignmentNotificationRuleTriggerConfig.getNotifyOn();

    // Assert
    assertEquals(
        "AlarmAssignmentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
            + " notifyOn=[])",
        actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.ALARM_ASSIGNMENT,
        actualAlarmAssignmentNotificationRuleTriggerConfig.getTriggerType());
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmStatuses.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualNotifyOn.isEmpty());
    assertSame(alarmSeverities2, actualAlarmSeverities);
    assertSame(alarmStatuses2, actualAlarmStatuses);
    assertSame(alarmTypes2, actualAlarmTypes);
    assertSame(notifyOn, actualNotifyOn);
  }
}
