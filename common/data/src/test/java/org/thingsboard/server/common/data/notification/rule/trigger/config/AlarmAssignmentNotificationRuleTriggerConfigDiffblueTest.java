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
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder;

class AlarmAssignmentNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test AlarmAssignmentNotificationRuleTriggerConfigBuilder
   * {@link AlarmAssignmentNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder#build()}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder#alarmSeverities(Set)}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder#alarmStatuses(Set)}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder#alarmTypes(Set)}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder#notifyOn(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmAssignmentNotificationRuleTriggerConfigBuilder build()")
  void testAlarmAssignmentNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(alarmTypes);
    HashSet<AlarmAssignmentNotificationRuleTriggerConfig.Action> notifyOn = new HashSet<>();

    // Act
    AlarmAssignmentNotificationRuleTriggerConfig actualBuildResult = alarmTypesResult.notifyOn(notifyOn).build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT, actualBuildResult.getTriggerType());
    Set<AlarmSeverity> alarmSeverities2 = actualBuildResult.getAlarmSeverities();
    assertTrue(alarmSeverities2.isEmpty());
    Set<AlarmSearchStatus> alarmStatuses2 = actualBuildResult.getAlarmStatuses();
    assertTrue(alarmStatuses2.isEmpty());
    Set<String> alarmTypes2 = actualBuildResult.getAlarmTypes();
    assertTrue(alarmTypes2.isEmpty());
    Set<AlarmAssignmentNotificationRuleTriggerConfig.Action> notifyOn2 = actualBuildResult.getNotifyOn();
    assertTrue(notifyOn2.isEmpty());
    assertSame(alarmSeverities, alarmSeverities2);
    assertSame(alarmStatuses, alarmStatuses2);
    assertSame(alarmTypes, alarmTypes2);
    assertSame(notifyOn, notifyOn2);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult2 = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult2
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 = alarmStatusesResult2
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult2 = alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = alarmAssignmentNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 = alarmStatusesResult2
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult2 = alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}, and
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmAssignmentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 = alarmStatusesResult2
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult2 = alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());

    HashSet<String> alarmTypes = new HashSet<>();
    alarmTypes.add("foo");
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(alarmTypes);
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 = alarmStatusesResult2
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult2 = alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmStatuses(Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder);
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder3 = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder3.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = alarmAssignmentNotificationRuleTriggerConfigBuilder3
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 = alarmStatusesResult2
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult2 = alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmTypes(Mockito.<Set<String>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmStatuses(Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder);
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder3 = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder3.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder2);
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder3
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder4 = mock(
        AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder4.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 = alarmAssignmentNotificationRuleTriggerConfigBuilder4
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 = alarmSeveritiesResult2
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult2 = alarmStatusesResult2
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult2 = alarmTypesResult2.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig buildResult = alarmTypesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmAssignmentNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#AlarmAssignmentNotificationRuleTriggerConfig()}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
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
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmAssignmentNotificationRuleTriggerConfig actualAlarmAssignmentNotificationRuleTriggerConfig = new AlarmAssignmentNotificationRuleTriggerConfig();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes);
    HashSet<AlarmAssignmentNotificationRuleTriggerConfig.Action> notifyOn = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualAlarmAssignmentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes();
    Set<AlarmAssignmentNotificationRuleTriggerConfig.Action> actualNotifyOn = actualAlarmAssignmentNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("AlarmAssignmentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
        + " notifyOn=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT,
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
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#AlarmAssignmentNotificationRuleTriggerConfig(Set, Set, Set, Set)}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>
   * {@link AlarmAssignmentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
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
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();

    // Act
    AlarmAssignmentNotificationRuleTriggerConfig actualAlarmAssignmentNotificationRuleTriggerConfig = new AlarmAssignmentNotificationRuleTriggerConfig(
        alarmTypes, alarmSeverities, alarmStatuses, new HashSet<>());
    HashSet<AlarmSeverity> alarmSeverities2 = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities2);
    HashSet<AlarmSearchStatus> alarmStatuses2 = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses2);
    HashSet<String> alarmTypes2 = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes2);
    HashSet<AlarmAssignmentNotificationRuleTriggerConfig.Action> notifyOn = new HashSet<>();
    actualAlarmAssignmentNotificationRuleTriggerConfig.setNotifyOn(notifyOn);
    String actualToStringResult = actualAlarmAssignmentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes = actualAlarmAssignmentNotificationRuleTriggerConfig.getAlarmTypes();
    Set<AlarmAssignmentNotificationRuleTriggerConfig.Action> actualNotifyOn = actualAlarmAssignmentNotificationRuleTriggerConfig
        .getNotifyOn();

    // Assert that nothing has changed
    assertEquals("AlarmAssignmentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
        + " notifyOn=[])", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT,
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
