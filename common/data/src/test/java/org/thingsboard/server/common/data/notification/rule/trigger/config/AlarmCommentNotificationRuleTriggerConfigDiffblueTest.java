package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmCommentNotificationRuleTriggerConfig.AlarmCommentNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {AlarmCommentNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class AlarmCommentNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private AlarmCommentNotificationRuleTriggerConfigBuilder
      alarmCommentNotificationRuleTriggerConfigBuilder;

  /**
   * Test AlarmCommentNotificationRuleTriggerConfigBuilder {@link
   * AlarmCommentNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfigBuilder#build()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfigBuilder#alarmSeverities(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfigBuilder#alarmStatuses(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfigBuilder#alarmTypes(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfigBuilder#notifyOnCommentUpdate(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfigBuilder#onlyUserComments(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmCommentNotificationRuleTriggerConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCommentNotificationRuleTriggerConfigBuilder.<init>()",
    "AlarmCommentNotificationRuleTriggerConfigBuilder AlarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(Set)",
    "AlarmCommentNotificationRuleTriggerConfigBuilder AlarmCommentNotificationRuleTriggerConfigBuilder.alarmStatuses(Set)",
    "AlarmCommentNotificationRuleTriggerConfigBuilder AlarmCommentNotificationRuleTriggerConfigBuilder.alarmTypes(Set)",
    "AlarmCommentNotificationRuleTriggerConfig AlarmCommentNotificationRuleTriggerConfigBuilder.build()",
    "AlarmCommentNotificationRuleTriggerConfigBuilder AlarmCommentNotificationRuleTriggerConfigBuilder.notifyOnCommentUpdate(boolean)",
    "AlarmCommentNotificationRuleTriggerConfigBuilder AlarmCommentNotificationRuleTriggerConfigBuilder.onlyUserComments(boolean)",
    "String AlarmCommentNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testAlarmCommentNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();

    // Act
    AlarmCommentNotificationRuleTriggerConfig actualBuildResult =
        alarmStatusesResult
            .alarmTypes(alarmTypes)
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
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmCommentNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult2 =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult2.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmCommentNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder2 =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder2.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        alarmCommentNotificationRuleTriggerConfigBuilder2.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * AlarmCommentNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());

    HashSet<String> alarmTypes = new HashSet<>();
    alarmTypes.add("foo");
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(alarmTypes)
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(false)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(false)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmStatuses(
            Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder2 =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder2.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmCommentNotificationRuleTriggerConfigBuilder);
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder2.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder3 =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder3.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        alarmCommentNotificationRuleTriggerConfigBuilder3.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder.alarmTypes(Mockito.<Set<String>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder2 =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder2.alarmStatuses(
            Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(alarmCommentNotificationRuleTriggerConfigBuilder);
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder3 =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder3.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmCommentNotificationRuleTriggerConfigBuilder2);
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        alarmCommentNotificationRuleTriggerConfigBuilder3.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();
    AlarmCommentNotificationRuleTriggerConfigBuilder
        alarmCommentNotificationRuleTriggerConfigBuilder4 =
            mock(AlarmCommentNotificationRuleTriggerConfigBuilder.class);
    when(alarmCommentNotificationRuleTriggerConfigBuilder4.alarmSeverities(
            Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmCommentNotificationRuleTriggerConfig.builder());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult2 =
        alarmCommentNotificationRuleTriggerConfigBuilder4.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult2 =
        alarmSeveritiesResult2.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult2 =
        alarmStatusesResult2
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmCommentNotificationRuleTriggerConfig.equals(Object)",
    "int AlarmCommentNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmCommentNotificationRuleTriggerConfigBuilder builderResult =
        AlarmCommentNotificationRuleTriggerConfig.builder();
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult =
        builderResult.alarmSeverities(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfigBuilder alarmStatusesResult =
        alarmSeveritiesResult.alarmStatuses(new HashSet<>());
    AlarmCommentNotificationRuleTriggerConfig buildResult =
        alarmStatusesResult
            .alarmTypes(new HashSet<>())
            .notifyOnCommentUpdate(true)
            .onlyUserComments(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmCommentNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       AlarmCommentNotificationRuleTriggerConfig#AlarmCommentNotificationRuleTriggerConfig()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setNotifyOnCommentUpdate(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setOnlyUserComments(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmStatuses()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#isNotifyOnCommentUpdate()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#isOnlyUserComments()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCommentNotificationRuleTriggerConfig.<init>()",
    "void AlarmCommentNotificationRuleTriggerConfig.<init>(Set, Set, Set, boolean, boolean)",
    "Set AlarmCommentNotificationRuleTriggerConfig.getAlarmSeverities()",
    "Set AlarmCommentNotificationRuleTriggerConfig.getAlarmStatuses()",
    "Set AlarmCommentNotificationRuleTriggerConfig.getAlarmTypes()",
    "NotificationRuleTriggerType AlarmCommentNotificationRuleTriggerConfig.getTriggerType()",
    "boolean AlarmCommentNotificationRuleTriggerConfig.isNotifyOnCommentUpdate()",
    "boolean AlarmCommentNotificationRuleTriggerConfig.isOnlyUserComments()",
    "void AlarmCommentNotificationRuleTriggerConfig.setAlarmSeverities(Set)",
    "void AlarmCommentNotificationRuleTriggerConfig.setAlarmStatuses(Set)",
    "void AlarmCommentNotificationRuleTriggerConfig.setAlarmTypes(Set)",
    "void AlarmCommentNotificationRuleTriggerConfig.setNotifyOnCommentUpdate(boolean)",
    "void AlarmCommentNotificationRuleTriggerConfig.setOnlyUserComments(boolean)",
    "String AlarmCommentNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentNotificationRuleTriggerConfig actualAlarmCommentNotificationRuleTriggerConfig =
        new AlarmCommentNotificationRuleTriggerConfig();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmSeverities(alarmSeverities);
    HashSet<AlarmSearchStatus> alarmStatuses = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmStatuses(alarmStatuses);
    HashSet<String> alarmTypes = new HashSet<>();
    actualAlarmCommentNotificationRuleTriggerConfig.setAlarmTypes(alarmTypes);
    actualAlarmCommentNotificationRuleTriggerConfig.setNotifyOnCommentUpdate(true);
    actualAlarmCommentNotificationRuleTriggerConfig.setOnlyUserComments(true);
    String actualToStringResult = actualAlarmCommentNotificationRuleTriggerConfig.toString();
    Set<AlarmSeverity> actualAlarmSeverities =
        actualAlarmCommentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses =
        actualAlarmCommentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmTypes();
    NotificationRuleTriggerType actualTriggerType =
        actualAlarmCommentNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsNotifyOnCommentUpdateResult =
        actualAlarmCommentNotificationRuleTriggerConfig.isNotifyOnCommentUpdate();
    boolean actualIsOnlyUserCommentsResult =
        actualAlarmCommentNotificationRuleTriggerConfig.isOnlyUserComments();

    // Assert
    assertEquals(
        "AlarmCommentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
            + " onlyUserComments=true, notifyOnCommentUpdate=true)",
        actualToStringResult);
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
   *       AlarmCommentNotificationRuleTriggerConfig#AlarmCommentNotificationRuleTriggerConfig(Set,
   *       Set, Set, boolean, boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmSeverities(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmStatuses(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setAlarmTypes(Set)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setNotifyOnCommentUpdate(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#setOnlyUserComments(boolean)}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#toString()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmSeverities()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmStatuses()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getAlarmTypes()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#getTriggerType()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#isNotifyOnCommentUpdate()}
   *   <li>{@link AlarmCommentNotificationRuleTriggerConfig#isOnlyUserComments()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCommentNotificationRuleTriggerConfig.<init>()",
    "void AlarmCommentNotificationRuleTriggerConfig.<init>(Set, Set, Set, boolean, boolean)",
    "Set AlarmCommentNotificationRuleTriggerConfig.getAlarmSeverities()",
    "Set AlarmCommentNotificationRuleTriggerConfig.getAlarmStatuses()",
    "Set AlarmCommentNotificationRuleTriggerConfig.getAlarmTypes()",
    "NotificationRuleTriggerType AlarmCommentNotificationRuleTriggerConfig.getTriggerType()",
    "boolean AlarmCommentNotificationRuleTriggerConfig.isNotifyOnCommentUpdate()",
    "boolean AlarmCommentNotificationRuleTriggerConfig.isOnlyUserComments()",
    "void AlarmCommentNotificationRuleTriggerConfig.setAlarmSeverities(Set)",
    "void AlarmCommentNotificationRuleTriggerConfig.setAlarmStatuses(Set)",
    "void AlarmCommentNotificationRuleTriggerConfig.setAlarmTypes(Set)",
    "void AlarmCommentNotificationRuleTriggerConfig.setNotifyOnCommentUpdate(boolean)",
    "void AlarmCommentNotificationRuleTriggerConfig.setOnlyUserComments(boolean)",
    "String AlarmCommentNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters_whenHashSet() {
    // Arrange
    HashSet<String> alarmTypes = new HashSet<>();
    HashSet<AlarmSeverity> alarmSeverities = new HashSet<>();

    // Act
    AlarmCommentNotificationRuleTriggerConfig actualAlarmCommentNotificationRuleTriggerConfig =
        new AlarmCommentNotificationRuleTriggerConfig(
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
    Set<AlarmSeverity> actualAlarmSeverities =
        actualAlarmCommentNotificationRuleTriggerConfig.getAlarmSeverities();
    Set<AlarmSearchStatus> actualAlarmStatuses =
        actualAlarmCommentNotificationRuleTriggerConfig.getAlarmStatuses();
    Set<String> actualAlarmTypes = actualAlarmCommentNotificationRuleTriggerConfig.getAlarmTypes();
    NotificationRuleTriggerType actualTriggerType =
        actualAlarmCommentNotificationRuleTriggerConfig.getTriggerType();
    boolean actualIsNotifyOnCommentUpdateResult =
        actualAlarmCommentNotificationRuleTriggerConfig.isNotifyOnCommentUpdate();
    boolean actualIsOnlyUserCommentsResult =
        actualAlarmCommentNotificationRuleTriggerConfig.isOnlyUserComments();

    // Assert
    assertEquals(
        "AlarmCommentNotificationRuleTriggerConfig(alarmTypes=[], alarmSeverities=[], alarmStatuses=[],"
            + " onlyUserComments=true, notifyOnCommentUpdate=true)",
        actualToStringResult);
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
