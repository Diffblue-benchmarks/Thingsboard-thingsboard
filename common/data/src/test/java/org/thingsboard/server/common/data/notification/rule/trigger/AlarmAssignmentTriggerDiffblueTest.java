package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {AlarmAssignmentTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class AlarmAssignmentTriggerDiffblueTest {
  @Autowired private AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder;

  /**
   * Test AlarmAssignmentTriggerBuilder {@link AlarmAssignmentTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTriggerBuilder#build()}
   *   <li>{@link AlarmAssignmentTriggerBuilder#actionType(ActionType)}
   *   <li>{@link AlarmAssignmentTriggerBuilder#alarmInfo(AlarmInfo)}
   *   <li>{@link AlarmAssignmentTriggerBuilder#tenantId(TenantId)}
   *   <li>{@link AlarmAssignmentTriggerBuilder#user(User)}
   * </ul>
   */
  @Test
  @DisplayName("Test AlarmAssignmentTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmAssignmentTriggerBuilder.<init>()",
    "AlarmAssignmentTriggerBuilder AlarmAssignmentTriggerBuilder.actionType(ActionType)",
    "AlarmAssignmentTriggerBuilder AlarmAssignmentTriggerBuilder.alarmInfo(AlarmInfo)",
    "AlarmAssignmentTrigger AlarmAssignmentTriggerBuilder.build()",
    "AlarmAssignmentTriggerBuilder AlarmAssignmentTriggerBuilder.tenantId(TenantId)",
    "String AlarmAssignmentTriggerBuilder.toString()",
    "AlarmAssignmentTriggerBuilder AlarmAssignmentTriggerBuilder.user(User)"
  })
  void testAlarmAssignmentTriggerBuilderBuild() {
    // Arrange and Act
    AlarmAssignmentTriggerBuilder actualActionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmInfo alarmInfo = new AlarmInfo();
    AlarmAssignmentTriggerBuilder actualTenantIdResult =
        actualActionTypeResult.alarmInfo(alarmInfo).tenantId(TenantId.SYS_TENANT_ID);
    User user = new User();
    AlarmAssignmentTrigger actualAlarmAssignmentTrigger = actualTenantIdResult.user(user).build();

    // Assert
    assertNull(actualAlarmAssignmentTrigger.getOriginatorEntityId());
    assertEquals(0L, actualAlarmAssignmentTrigger.getDefaultDeduplicationDuration());
    assertEquals(ActionType.ADDED, actualAlarmAssignmentTrigger.getActionType());
    assertEquals(
        NotificationRuleTriggerType.ALARM_ASSIGNMENT, actualAlarmAssignmentTrigger.getType());
    assertFalse(actualAlarmAssignmentTrigger.deduplicate());
    assertSame(user, actualAlarmAssignmentTrigger.getUser());
    assertSame(alarmInfo, actualAlarmAssignmentTrigger.getAlarmInfo());
    assertSame(TenantId.SYS_TENANT_ID, actualAlarmAssignmentTrigger.getTenantId());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#getOriginatorEntityId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId AlarmAssignmentTrigger.getOriginatorEntityId()"
  })
  void testGetOriginatorEntityId_thenReturnNull() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    AlarmAssignmentTrigger alarmAssignmentTrigger =
        new AlarmAssignmentTrigger(TenantId.SYS_TENANT_ID, alarmInfo, ActionType.ADDED, new User());

    // Act and Assert
    assertNull(alarmAssignmentTrigger.getOriginatorEntityId());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}, and {@link
   * AlarmAssignmentTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(alarmAssignmentTrigger, alarmAssignmentTrigger2);
    assertEquals(alarmAssignmentTrigger.hashCode(), alarmAssignmentTrigger2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}, and {@link
   * AlarmAssignmentTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmAssignmentTriggerBuilder tenantIdResult =
        AlarmAssignmentTrigger.builder()
            .actionType(ActionType.ADDED)
            .alarmInfo(null)
            .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        AlarmAssignmentTrigger.builder()
            .actionType(ActionType.ADDED)
            .alarmInfo(null)
            .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(alarmAssignmentTrigger, alarmAssignmentTrigger2);
    assertEquals(alarmAssignmentTrigger.hashCode(), alarmAssignmentTrigger2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}, and {@link
   * AlarmAssignmentTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTrigger alarmAssignmentTrigger =
        actionTypeResult
            .alarmInfo(new AlarmInfo())
            .tenantId(TenantId.SYS_TENANT_ID)
            .user(null)
            .build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTrigger alarmAssignmentTrigger2 =
        actionTypeResult2
            .alarmInfo(new AlarmInfo())
            .tenantId(TenantId.SYS_TENANT_ID)
            .user(null)
            .build();

    // Act and Assert
    assertEquals(alarmAssignmentTrigger, alarmAssignmentTrigger2);
    assertEquals(alarmAssignmentTrigger.hashCode(), alarmAssignmentTrigger2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}, and {@link
   * AlarmAssignmentTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(null);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(null);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(alarmAssignmentTrigger, alarmAssignmentTrigger2);
    assertEquals(alarmAssignmentTrigger.hashCode(), alarmAssignmentTrigger2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}, and {@link
   * AlarmAssignmentTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(null);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(null);
    AlarmAssignmentTrigger alarmAssignmentTrigger2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(alarmAssignmentTrigger, alarmAssignmentTrigger2);
    assertEquals(alarmAssignmentTrigger.hashCode(), alarmAssignmentTrigger2.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}, and {@link
   * AlarmAssignmentTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertEquals(alarmAssignmentTrigger, alarmAssignmentTrigger);
    int expectedHashCodeResult = alarmAssignmentTrigger.hashCode();
    assertEquals(expectedHashCodeResult, alarmAssignmentTrigger.hashCode());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTriggerBuilder tenantIdResult =
        AlarmAssignmentTrigger.builder()
            .actionType(ActionType.ADDED)
            .alarmInfo(null)
            .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmAssignmentTriggerBuilder tenantIdResult =
        AlarmAssignmentTrigger.builder()
            .actionType(ActionType.ADDED)
            .alarmInfo(mock(AlarmInfo.class))
            .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTrigger alarmAssignmentTrigger =
        actionTypeResult
            .alarmInfo(new AlarmInfo())
            .tenantId(TenantId.SYS_TENANT_ID)
            .user(null)
            .build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger =
        tenantIdResult.user(new User(new User())).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(null);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.DELETED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());

    AlarmAssignmentTriggerBuilder tenantIdResult =
        alarmInfoResult.tenantId(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(null);
    AlarmAssignmentTrigger alarmAssignmentTrigger = tenantIdResult.user(new User()).build();

    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmAssignmentTrigger, tenantIdResult2.user(new User()).build());
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tenantIdResult.user(new User()).build(), null);
  }

  /**
   * Test {@link AlarmAssignmentTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(
        tenantIdResult.user(new User()).build(), "Different type to AlarmAssignmentTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#AlarmAssignmentTrigger(TenantId, AlarmInfo, ActionType,
   *       User)}
   *   <li>{@link AlarmAssignmentTrigger#toString()}
   *   <li>{@link AlarmAssignmentTrigger#getActionType()}
   *   <li>{@link AlarmAssignmentTrigger#getAlarmInfo()}
   *   <li>{@link AlarmAssignmentTrigger#getTenantId()}
   *   <li>{@link AlarmAssignmentTrigger#getType()}
   *   <li>{@link AlarmAssignmentTrigger#getUser()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmAssignmentTrigger.<init>(TenantId, AlarmInfo, ActionType, User)",
    "ActionType AlarmAssignmentTrigger.getActionType()",
    "AlarmInfo AlarmAssignmentTrigger.getAlarmInfo()",
    "TenantId AlarmAssignmentTrigger.getTenantId()",
    "NotificationRuleTriggerType AlarmAssignmentTrigger.getType()",
    "User AlarmAssignmentTrigger.getUser()",
    "String AlarmAssignmentTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    User user = new User();

    // Act
    AlarmAssignmentTrigger actualAlarmAssignmentTrigger =
        new AlarmAssignmentTrigger(TenantId.SYS_TENANT_ID, alarmInfo, ActionType.ADDED, user);
    String actualToStringResult = actualAlarmAssignmentTrigger.toString();
    ActionType actualActionType = actualAlarmAssignmentTrigger.getActionType();
    AlarmInfo actualAlarmInfo = actualAlarmAssignmentTrigger.getAlarmInfo();
    TenantId actualTenantId = actualAlarmAssignmentTrigger.getTenantId();
    NotificationRuleTriggerType actualType = actualAlarmAssignmentTrigger.getType();

    // Assert
    assertEquals(
        "AlarmAssignmentTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, alarmInfo=AlarmInfo(super=Alarm"
            + "(tenantId=null, customerId=null, type=null, originator=null, severity=null, acknowledged=false,"
            + " cleared=false, assigneeId=null, startTs=0, endTs=0, ackTs=0, clearTs=0, assignTs=0, details=null,"
            + " propagate=false, propagateToOwner=false, propagateToTenant=false, propagateRelationTypes=null),"
            + " originatorName=null, originatorLabel=null, assignee=null), actionType=ADDED, user=User [tenantId=null,"
            + " customerId=null, email=null, authority=null, firstName=null, lastName=null, additionalInfo=null,"
            + " createdTime=0, id=null])",
        actualToStringResult);
    assertEquals(ActionType.ADDED, actualActionType);
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT, actualType);
    assertSame(user, actualAlarmAssignmentTrigger.getUser());
    assertSame(alarmInfo, actualAlarmInfo);
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }
}
