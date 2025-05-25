package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.AlarmAssignmentNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig.Action;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig.AlarmAssignmentNotificationRuleTriggerConfigBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {AlarmAssignmentTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class AlarmAssignmentTriggerProcessorDiffblueTest {
  @Autowired
  private AlarmAssignmentTriggerProcessor alarmAssignmentTriggerProcessor;

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)} with {@code AlarmAssignmentTrigger}, {@code AlarmAssignmentNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig) with 'AlarmAssignmentTrigger', 'AlarmAssignmentNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AlarmAssignmentTriggerProcessor.matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithAlarmAssignmentTriggerAlarmAssignmentNotificationRuleTriggerConfig() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder tenantIdResult = alarmInfoResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger trigger = tenantIdResult.user(new User()).build();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig triggerConfig = alarmTypesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertFalse(alarmAssignmentTriggerProcessor.matchesFilter(trigger, triggerConfig));
  }

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)} with {@code AlarmAssignmentTrigger}, {@code AlarmAssignmentNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig) with 'AlarmAssignmentTrigger', 'AlarmAssignmentNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AlarmAssignmentTriggerProcessor.matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithAlarmAssignmentTriggerAlarmAssignmentNotificationRuleTriggerConfig2() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder tenantIdResult = alarmInfoResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger trigger = tenantIdResult.user(new User()).build();

    HashSet<Action> notifyOn = new HashSet<>();
    notifyOn.add(Action.UNASSIGNED);
    AlarmAssignmentNotificationRuleTriggerConfigBuilder builderResult = AlarmAssignmentNotificationRuleTriggerConfig
        .builder();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = builderResult
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfig triggerConfig = alarmStatusesResult.alarmTypes(new HashSet<>())
        .notifyOn(notifyOn)
        .build();

    // Act and Assert
    assertTrue(alarmAssignmentTriggerProcessor.matchesFilter(trigger, triggerConfig));
  }

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)} with {@code AlarmAssignmentTrigger}, {@code AlarmAssignmentNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig) with 'AlarmAssignmentTrigger', 'AlarmAssignmentNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AlarmAssignmentTriggerProcessor.matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithAlarmAssignmentTriggerAlarmAssignmentNotificationRuleTriggerConfig3() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder tenantIdResult = alarmInfoResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger trigger = tenantIdResult.user(new User()).build();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());

    HashSet<Action> notifyOn = new HashSet<>();
    notifyOn.add(Action.UNASSIGNED);
    AlarmAssignmentNotificationRuleTriggerConfig triggerConfig = alarmTypesResult.notifyOn(notifyOn).build();

    // Act
    boolean actualMatchesFilterResult = alarmAssignmentTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(alarmAssignmentNotificationRuleTriggerConfigBuilder).alarmSeverities(isA(Set.class));
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)} with {@code AlarmAssignmentTrigger}, {@code AlarmAssignmentNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig) with 'AlarmAssignmentTrigger', 'AlarmAssignmentNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AlarmAssignmentTriggerProcessor.matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithAlarmAssignmentTriggerAlarmAssignmentNotificationRuleTriggerConfig4() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder tenantIdResult = alarmInfoResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger trigger = tenantIdResult.user(new User()).build();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmStatuses(Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder);
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult
        .alarmTypes(new HashSet<>());

    HashSet<Action> notifyOn = new HashSet<>();
    notifyOn.add(Action.UNASSIGNED);
    AlarmAssignmentNotificationRuleTriggerConfig triggerConfig = alarmTypesResult.notifyOn(notifyOn).build();

    // Act
    boolean actualMatchesFilterResult = alarmAssignmentTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(alarmAssignmentNotificationRuleTriggerConfigBuilder2).alarmSeverities(isA(Set.class));
    verify(alarmAssignmentNotificationRuleTriggerConfigBuilder).alarmStatuses(isA(Set.class));
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)} with {@code AlarmAssignmentTrigger}, {@code AlarmAssignmentNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig) with 'AlarmAssignmentTrigger', 'AlarmAssignmentNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean AlarmAssignmentTriggerProcessor.matchesFilter(AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithAlarmAssignmentTriggerAlarmAssignmentNotificationRuleTriggerConfig5() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder tenantIdResult = alarmInfoResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger trigger = tenantIdResult.user(new User()).build();
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder = mock(
        AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder.alarmStatuses(Mockito.<Set<AlarmSearchStatus>>any()))
        .thenReturn(AlarmAssignmentNotificationRuleTriggerConfig.builder());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmAssignmentNotificationRuleTriggerConfigBuilder2 = mock(
        AlarmAssignmentNotificationRuleTriggerConfigBuilder.class);
    when(alarmAssignmentNotificationRuleTriggerConfigBuilder2.alarmSeverities(Mockito.<Set<AlarmSeverity>>any()))
        .thenReturn(alarmAssignmentNotificationRuleTriggerConfigBuilder);
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmSeveritiesResult = alarmAssignmentNotificationRuleTriggerConfigBuilder2
        .alarmSeverities(new HashSet<>());
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmStatusesResult = alarmSeveritiesResult
        .alarmStatuses(new HashSet<>());

    HashSet<String> alarmTypes = new HashSet<>();
    alarmTypes.add("42");
    AlarmAssignmentNotificationRuleTriggerConfigBuilder alarmTypesResult = alarmStatusesResult.alarmTypes(alarmTypes);

    HashSet<Action> notifyOn = new HashSet<>();
    notifyOn.add(Action.UNASSIGNED);
    AlarmAssignmentNotificationRuleTriggerConfig triggerConfig = alarmTypesResult.notifyOn(notifyOn).build();

    // Act
    boolean actualMatchesFilterResult = alarmAssignmentTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(alarmAssignmentNotificationRuleTriggerConfigBuilder2).alarmSeverities(isA(Set.class));
    verify(alarmAssignmentNotificationRuleTriggerConfigBuilder).alarmStatuses(isA(Set.class));
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#constructNotificationInfo(AlarmAssignmentTrigger)} with {@code AlarmAssignmentTrigger}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#constructNotificationInfo(AlarmAssignmentTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(AlarmAssignmentTrigger) with 'AlarmAssignmentTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "RuleOriginatedNotificationInfo AlarmAssignmentTriggerProcessor.constructNotificationInfo(AlarmAssignmentTrigger)"})
  void testConstructNotificationInfoWithAlarmAssignmentTrigger() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder tenantIdResult = alarmInfoResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger trigger = tenantIdResult.user(new User()).build();

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = alarmAssignmentTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    assertTrue(actualConstructNotificationInfoResult instanceof AlarmAssignmentNotificationInfo);
    assertEquals("unassigned", ((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAction());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmOriginatorName());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmType());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAssigneeEmail());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAssigneeFirstName());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAssigneeLastName());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getUserEmail());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getUserFirstName());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getUserLastName());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmId());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmSeverity());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmCustomerId());
    assertNull(actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmOriginator());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAssigneeId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    assertEquals(AlarmStatus.ACTIVE_UNACK,
        ((AlarmAssignmentNotificationInfo) actualConstructNotificationInfoResult).getAlarmStatus());
  }

  /**
   * Test {@link AlarmAssignmentTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link AlarmAssignmentTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType AlarmAssignmentTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT,
        (new AlarmAssignmentTriggerProcessor()).getTriggerType());
  }
}
