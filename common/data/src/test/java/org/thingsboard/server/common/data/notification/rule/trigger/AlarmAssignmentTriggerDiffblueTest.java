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
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class AlarmAssignmentTriggerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder#build()}
   *   <li>
   * {@link AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder#actionType(ActionType)}
   *   <li>
   * {@link AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder#alarmInfo(AlarmInfo)}
   *   <li>
   * {@link AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder#tenantId(TenantId)}
   *   <li>{@link AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder#user(User)}
   * </ul>
   */
  @Test
  void testAlarmAssignmentTriggerBuilderBuild() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmInfo alarmInfo = new AlarmInfo();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(alarmInfo)
        .tenantId(TenantId.SYS_TENANT_ID);
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
   * Method under test: {@link AlarmAssignmentTrigger#getOriginatorEntityId()}
   */
  @Test
  void testGetOriginatorEntityId() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();

    // Act and Assert
    assertNull((new AlarmAssignmentTrigger(TenantId.SYS_TENANT_ID, alarmInfo, ActionType.ADDED, new User()))
        .getOriginatorEntityId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = actionTypeResult2.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder3
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = alarmAssignmentTriggerBuilder4
        .actionType(ActionType.ADDED)
        .alarmInfo(null)
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder4
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger buildResult2 = alarmAssignmentTriggerBuilder5.actionType(ActionType.ADDED)
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
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmAssignmentTrigger#equals(Object)}
   *   <li>{@link AlarmAssignmentTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = actionTypeResult2.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.alarmInfo(Mockito.<AlarmInfo>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder2
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = actionTypeResult2.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder3
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = actionTypeResult2.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder3
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = actionTypeResult2.alarmInfo(new AlarmInfo())
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder3
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED)
        .alarmInfo(null)
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder3
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult2 = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = actionTypeResult2.alarmInfo(new AlarmInfo())
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder4
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = alarmAssignmentTriggerBuilder5
        .actionType(ActionType.ADDED)
        .alarmInfo(null)
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.alarmInfo(new AlarmInfo());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(builderResult);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder4
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = alarmAssignmentTriggerBuilder5
        .actionType(ActionType.ADDED)
        .alarmInfo(null)
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(builderResult);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder4
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult2 = alarmAssignmentTriggerBuilder5
        .actionType(ActionType.ADDED)
        .alarmInfo(null)
        .tenantId(null);
    AlarmAssignmentTrigger buildResult2 = tenantIdResult2.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder builderResult = AlarmAssignmentTrigger.builder();
    builderResult.user(new User());
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder.user(Mockito.<User>any())).thenReturn(builderResult);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder2 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder2.tenantId(Mockito.<TenantId>any())).thenReturn(alarmAssignmentTriggerBuilder);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder3 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder3.alarmInfo(Mockito.<AlarmInfo>any())).thenReturn(alarmAssignmentTriggerBuilder2);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder4 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(alarmAssignmentTriggerBuilder3);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = alarmAssignmentTriggerBuilder4
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder alarmAssignmentTriggerBuilder5 = mock(
        AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder.class);
    when(alarmAssignmentTriggerBuilder5.actionType(Mockito.<ActionType>any()))
        .thenReturn(AlarmAssignmentTrigger.builder());
    AlarmAssignmentTrigger buildResult2 = alarmAssignmentTriggerBuilder5.actionType(ActionType.ADDED)
        .alarmInfo(null)
        .tenantId(null)
        .user(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link AlarmAssignmentTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder actionTypeResult = AlarmAssignmentTrigger.builder()
        .actionType(ActionType.ADDED);
    AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder tenantIdResult = actionTypeResult.alarmInfo(new AlarmInfo())
        .tenantId(TenantId.SYS_TENANT_ID);
    AlarmAssignmentTrigger buildResult = tenantIdResult.user(new User()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AlarmAssignmentTrigger");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AlarmAssignmentTrigger#AlarmAssignmentTrigger(TenantId, AlarmInfo, ActionType, User)}
   *   <li>{@link AlarmAssignmentTrigger#toString()}
   *   <li>{@link AlarmAssignmentTrigger#getActionType()}
   *   <li>{@link AlarmAssignmentTrigger#getAlarmInfo()}
   *   <li>{@link AlarmAssignmentTrigger#getTenantId()}
   *   <li>{@link AlarmAssignmentTrigger#getType()}
   *   <li>{@link AlarmAssignmentTrigger#getUser()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    User user = new User();

    // Act
    AlarmAssignmentTrigger actualAlarmAssignmentTrigger = new AlarmAssignmentTrigger(TenantId.SYS_TENANT_ID, alarmInfo,
        ActionType.ADDED, user);
    String actualToStringResult = actualAlarmAssignmentTrigger.toString();
    ActionType actualActionType = actualAlarmAssignmentTrigger.getActionType();
    AlarmInfo actualAlarmInfo = actualAlarmAssignmentTrigger.getAlarmInfo();
    TenantId actualTenantId = actualAlarmAssignmentTrigger.getTenantId();
    NotificationRuleTriggerType actualType = actualAlarmAssignmentTrigger.getType();

    // Assert
    assertEquals("AlarmAssignmentTrigger(tenantId=13814000-1dd2-11b2-8080-808080808080, alarmInfo=AlarmInfo(super=Alarm"
        + "(tenantId=null, customerId=null, type=null, originator=null, severity=null, acknowledged=false,"
        + " cleared=false, assigneeId=null, startTs=0, endTs=0, ackTs=0, clearTs=0, assignTs=0, details=null,"
        + " propagate=false, propagateToOwner=false, propagateToTenant=false, propagateRelationTypes=null),"
        + " originatorName=null, originatorLabel=null, assignee=null), actionType=ADDED, user=User [tenantId=null,"
        + " customerId=null, email=null, authority=null, firstName=null, lastName=null, additionalInfo=null,"
        + " createdTime=0, id=null])", actualToStringResult);
    assertEquals(ActionType.ADDED, actualActionType);
    assertEquals(NotificationRuleTriggerType.ALARM_ASSIGNMENT, actualType);
    assertSame(user, actualAlarmAssignmentTrigger.getUser());
    assertSame(alarmInfo, actualAlarmInfo);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
