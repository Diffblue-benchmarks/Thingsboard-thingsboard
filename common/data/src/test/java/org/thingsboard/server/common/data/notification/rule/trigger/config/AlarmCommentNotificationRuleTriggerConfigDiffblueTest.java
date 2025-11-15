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

class AlarmCommentNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder#alarmSeverities(Set)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder#alarmStatuses(Set)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder#alarmTypes(Set)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder#notifyOnCommentUpdate(boolean)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder#onlyUserComments(boolean)}
   * </ul>
   */
  @Test
  void testAlarmCommentNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();

    // Act
    AlarmCommentNotificationRuleTriggerConfig actualBuildResult = alarmStatusesResult.alarmTypes(alarmTypes)
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.ALARM_COMMENT, actualBuildResult.getTriggerType());
    Set<AlarmSeverity> alarmSeverities2 = actualBuildResult.getAlarmSeverities();
    assertTrue(alarmSeverities2.isEmpty());
    Set<AlarmSearchStatus> alarmStatuses2 = actualBuildResult.getAlarmStatuses();
    assertTrue(alarmStatuses2.isEmpty());
    Set<String> alarmTypes2 = actualBuildResult.getAlarmTypes();
    assertTrue(alarmTypes2.isEmpty());
    assertTrue(actualBuildResult.isNotifyOnCommentUpdate());
    assertTrue(actualBuildResult.isOnlyUserComments());
    assertSame(alarmSeverities, alarmSeverities2);
    assertSame(alarmStatuses, alarmStatuses2);
    assertSame(alarmTypes, alarmTypes2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult2 = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult2
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = alarmCommentNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());

    HashSet<String> alarmTypes = new HashSet<>();
    alarmTypes.add("foo");
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(alarmTypes)
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(false)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(false)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmStatuses(Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmCommentNotificationRuleTriggerConfigBuilder);
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder3 = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder3.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = alarmCommentNotificationRuleTriggerConfigBuilder3
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmTypes(Mockito.<Set<String>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder2.alarmStatuses(Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(alarmCommentNotificationRuleTriggerConfigBuilder);
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder3 = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder3.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmCommentNotificationRuleTriggerConfigBuilder2);
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmCommentNotificationRuleTriggerConfigBuilder3
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmCommentNotificationRuleTriggerConfigBuilder4 = mock(
        AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder4.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = alarmCommentNotificationRuleTriggerConfigBuilder4
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 = alarmStatusesResult2.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder builderResult = AlarmCommentNotificationRuleTriggerConfig
        .builder();
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOnCommentUpdate(true)
        .onlyUserComments(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmCommentNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#AlarmCommentNotificationRuleTriggerConfig()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#setNotifyOnCommentUpdate(boolean)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#setOnlyUserComments(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmStatuses()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#isNotifyOnCommentUpdate()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#isOnlyUserComments()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentNotificationRuleTriggerConfig actualAlarmCommentNotificationRuleTriggerConfig = new AlarmCommentNotificationRuleTriggerConfig();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes);
    actualAlarmCommentNotificationRuleTriggerConfig.setNotifyOnCommentUpdate(true);
    actualAlarmCommentNotificationRuleTriggerConfig.setOnlyUserComments(true);
    String actualToStringResult = actualAlarmCommentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmTypes();
    NotificationRuleTriggerType actualTriggerType = actualAlarmCommentNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsNotifyOnCommentUpdateResult = actualAlarmCommentNotificationRuleTriggerConfig
        .isNotifyOnCommentUpdate();
    boolean actualIsOnlyUserCommentsResult = actualAlarmCommentNotificationRuleTriggerConfig.isOnlyUserComments();

    // Assert that nothing has changed
    assertEquals("AlarmCommentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
        + " onlyUserComments=true, notifyOnCommentUpdate=true)", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ALARM_COMMENT, actualTriggerType);
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmStatuses.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualIsNotifyOnCommentUpdateResult);
    assertTrue(actualIsOnlyUserCommentsResult);
    assertSame(alarmSeverities, actualAlarmSeverities);
    assertSame(alarmStatuses, actualAlarmStatuses);
    assertSame(alarmTypes, actualAlarmTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#AlarmCommentNotificationRuleTriggerConfig(Set, Set, Set, boolean, boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#setNotifyOnCommentUpdate(boolean)}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#setOnlyUserComments(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmStatuses()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>
   * {@link AlarmCommentNotificationRuleTriggerConfig#isNotifyOnCommentUpdate()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#isOnlyUserComments()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();

    // Act
    AlarmCommentNotificationRuleTriggerConfig actualAlarmCommentNotificationRuleTriggerConfig = new AlarmCommentNotificationRuleTriggerConfig(
        alarmTypes, alarmSeverities, new HashSet<>(), true, true);
    HashSet<AlarmSeverity> alarmSeverities2 = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities2);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes2 = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes2);
    actualAlarmCommentNotificationRuleTriggerConfig.setNotifyOnCommentUpdate(true);
    actualAlarmCommentNotificationRuleTriggerConfig.setOnlyUserComments(true);
    String actualToStringResult = actualAlarmCommentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmTypes();
    NotificationRuleTriggerType actualTriggerType = actualAlarmCommentNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsNotifyOnCommentUpdateResult = actualAlarmCommentNotificationRuleTriggerConfig
        .isNotifyOnCommentUpdate();
    boolean actualIsOnlyUserCommentsResult = actualAlarmCommentNotificationRuleTriggerConfig.isOnlyUserComments();

    // Assert that nothing has changed
    assertEquals("AlarmCommentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
        + " onlyUserComments=true, notifyOnCommentUpdate=true)", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ALARM_COMMENT, actualTriggerType);
    assertTrue(actualAlarmSeverities.isEmpty());
    assertTrue(actualAlarmStatuses.isEmpty());
    assertTrue(actualAlarmTypes.isEmpty());
    assertTrue(actualIsNotifyOnCommentUpdateResult);
    assertTrue(actualIsOnlyUserCommentsResult);
    assertSame(alarmSeverities2, actualAlarmSeverities);
    assertSame(alarmStatuses, actualAlarmStatuses);
    assertSame(alarmTypes2, actualAlarmTypes);
  }
}
