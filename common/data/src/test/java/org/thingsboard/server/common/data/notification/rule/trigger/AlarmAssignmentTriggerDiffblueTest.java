package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
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
  @Tag("MaintainedByDiffblue")
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
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmInfo alarmInfo = new AlarmInfo();
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(alarmInfo).tenantId(TenantId.SYS_TENANT_ID);
    User user = new User();

    // Act
    AlarmAssignmentTrigger actualBuildResult = tenantIdResult.user(user).build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualBuildResult.getOriginatorEntityId());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(ActionType.ADDED, actualBuildResult.getActionType());
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT, actualBuildResult.getType());
    assertFalse(actualBuildResult.deduplicate());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(user, actualBuildResult.getUser());
    assertSame(alarmInfo, actualBuildResult.getAlarmInfo());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId AlarmAssignmentTrigger.getOriginatorEntityId()"
  })
  void testGetOriginatorEntityId_thenReturnNull() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();

    // Act and Assert
    assertNull(
        new AlarmAssignmentTrigger(TenantId.SYS_TENANT_ID, alarmInfo, ActionType.ADDED, new User())
            .getOriginatorEntityId());
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
  @Tag("MaintainedByDiffblue")
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
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder3.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        alarmAssignmentTriggerBuilder4.actionType(ActionType.ADDED).alarmInfo(null).tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder4.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger buildResult2 =
        alarmAssignmentTriggerBuilder5
            .actionType(ActionType.ADDED)
            .alarmInfo(null)
            .tenantId(null)
            .user(null)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder2.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder3.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder3.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder3.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        AlarmAssignmentTrigger.builder()
            .actionType(ActionType.ADDED)
            .alarmInfo(null)
            .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder3.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder actionTypeResult2 =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        actionTypeResult2.alarmInfo(new AlarmInfo()).tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder4.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        alarmAssignmentTriggerBuilder5.actionType(ActionType.ADDED).alarmInfo(null).tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(builderResult);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder4.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        alarmAssignmentTriggerBuilder5.actionType(ActionType.ADDED).alarmInfo(null).tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(builderResult);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder4.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTriggerBuilder tenantIdResult2 =
        alarmAssignmentTriggerBuilder5.actionType(ActionType.ADDED).alarmInfo(null).tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AlarmAssignmentTrigger.equals(Object)",
    "int AlarmAssignmentTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.user(new User());
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(builderResult);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTriggerBuilder actionTypeResult =
        alarmAssignmentTriggerBuilder4.actionType(ActionType.ADDED);
    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 =
        mock(AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger buildResult2 =
        alarmAssignmentTriggerBuilder5
            .actionType(ActionType.ADDED)
            .alarmInfo(null)
            .tenantId(null)
            .user(null)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
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
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
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
  @Tag("MaintainedByDiffblue")
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
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmAssignmentTrigger");
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
  @Tag("MaintainedByDiffblue")
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
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
