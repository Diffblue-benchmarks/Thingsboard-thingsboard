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
package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class HousekeeperTaskDiffblueTest {
  /**
   * Method under test:
   * {@link HousekeeperTask#deleteAttributes(TenantId, EntityId)}
   */
  @Test
  void testDeleteAttributes() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteAttributesResult = HousekeeperTask.deleteAttributes(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteAttributesResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualDeleteAttributesResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteAttributesResult.getEntityId());
    assertSame(tenantId, actualDeleteAttributesResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link HousekeeperTask#deleteTelemetry(TenantId, EntityId)}
   */
  @Test
  void testDeleteTelemetry() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteTelemetryResult = HousekeeperTask.deleteTelemetry(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteTelemetryResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_TELEMETRY, actualDeleteTelemetryResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteTelemetryResult.getEntityId());
    assertSame(tenantId, actualDeleteTelemetryResult.getTenantId());
  }

  /**
   * Method under test: {@link HousekeeperTask#deleteEvents(TenantId, EntityId)}
   */
  @Test
  void testDeleteEvents() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteEventsResult = HousekeeperTask.deleteEvents(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("events deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteEventsResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_EVENTS, actualDeleteEventsResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteEventsResult.getEntityId());
    assertSame(tenantId, actualDeleteEventsResult.getTenantId());
  }

  /**
   * Method under test: {@link HousekeeperTask#unassignAlarms(User)}
   */
  @Test
  void testUnassignAlarms() {
    // Arrange
    User user = mock(User.class);
    when(user.getTitle()).thenReturn("Dr");
    when(user.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    UserId userId = new UserId(EntityId.NULL_UUID);
    when(user.getId()).thenReturn(userId);

    // Act
    HousekeeperTask actualUnassignAlarmsResult = HousekeeperTask.unassignAlarms(user);

    // Assert
    verify(user).getId();
    verify(user).getTenantId();
    verify(user).getTitle();
    assertTrue(actualUnassignAlarmsResult instanceof AlarmsUnassignHousekeeperTask);
    TenantId tenantId = actualUnassignAlarmsResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", ((AlarmsUnassignHousekeeperTask) actualUnassignAlarmsResult).getUserTitle());
    assertEquals("alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080",
        actualUnassignAlarmsResult.getDescription());
    assertNull(((AlarmsUnassignHousekeeperTask) actualUnassignAlarmsResult).getAlarms());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualUnassignAlarmsResult.getTaskType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(userId, actualUnassignAlarmsResult.getEntityId());
  }

  /**
   * Method under test: {@link HousekeeperTask#deleteAlarms(TenantId, EntityId)}
   */
  @Test
  void testDeleteAlarms() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteAlarmsResult = HousekeeperTask.deleteAlarms(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertTrue(actualDeleteAlarmsResult instanceof AlarmsDeletionHousekeeperTask);
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteAlarmsResult.getDescription());
    assertNull(((AlarmsDeletionHousekeeperTask) actualDeleteAlarmsResult).getAlarms());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualDeleteAlarmsResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteAlarmsResult.getEntityId());
    assertSame(tenantId, actualDeleteAlarmsResult.getTenantId());
  }

  /**
   * Method under test:
   * {@link HousekeeperTask#deleteTenantEntities(TenantId, EntityType)}
   */
  @Test
  void testDeleteTenantEntities() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteTenantEntitiesResult = HousekeeperTask.deleteTenantEntities(tenantId,
        EntityType.TENANT);

    // Assert
    assertTrue(actualDeleteTenantEntitiesResult instanceof TenantEntitiesDeletionHousekeeperTask);
    assertEquals("tenants deletion", actualDeleteTenantEntitiesResult.getDescription());
    assertEquals(EntityType.TENANT,
        ((TenantEntitiesDeletionHousekeeperTask) actualDeleteTenantEntitiesResult).getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_TENANT_ENTITIES, actualDeleteTenantEntitiesResult.getTaskType());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualDeleteTenantEntitiesResult.getEntityId());
    assertSame(tenantId2, actualDeleteTenantEntitiesResult.getTenantId());
  }

  /**
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription2() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsDeletionHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription3() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription4() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription5() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    tenantEntitiesDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("tenants deletion", tenantEntitiesDeletionHousekeeperTask.getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    HousekeeperTask housekeeperTask2 = new HousekeeperTask();

    // Act and Assert
    assertEquals(housekeeperTask, housekeeperTask2);
    int expectedHashCodeResult = housekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, housekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
    int notExpectedHashCodeResult = housekeeperTask.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmsDeletionHousekeeperTask.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();

    // Act and Assert
    assertEquals(housekeeperTask, housekeeperTask);
    int expectedHashCodeResult = housekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, housekeeperTask.hashCode());
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new HousekeeperTask());
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();

    // Act and Assert
    assertNotEquals(housekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setEntityId(new AlarmId(EntityId.NULL_UUID));
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HousekeeperTask(), null);
  }

  /**
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HousekeeperTask(), "Different type to HousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#HousekeeperTask()}
   *   <li>{@link HousekeeperTask#setEntityId(EntityId)}
   *   <li>{@link HousekeeperTask#setTaskType(HousekeeperTaskType)}
   *   <li>{@link HousekeeperTask#setTenantId(TenantId)}
   *   <li>{@link HousekeeperTask#setTs(long)}
   *   <li>{@link HousekeeperTask#toString()}
   *   <li>{@link HousekeeperTask#getEntityId()}
   *   <li>{@link HousekeeperTask#getTaskType()}
   *   <li>{@link HousekeeperTask#getTenantId()}
   *   <li>{@link HousekeeperTask#getTs()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HousekeeperTask actualHousekeeperTask = new HousekeeperTask();
    actualHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    actualHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    actualHousekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);
    actualHousekeeperTask.setTs(1L);
    String actualToStringResult = actualHousekeeperTask.toString();
    EntityId actualEntityId = actualHousekeeperTask.getEntityId();
    HousekeeperTaskType actualTaskType = actualHousekeeperTask.getTaskType();
    TenantId actualTenantId = actualHousekeeperTask.getTenantId();

    // Assert that nothing has changed
    assertEquals(
        "HousekeeperTask(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080,"
            + " taskType=DELETE_ATTRIBUTES, ts=1)",
        actualToStringResult);
    assertEquals(1L, actualHousekeeperTask.getTs());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Method under test:
   * {@link HousekeeperTask#HousekeeperTask(TenantId, EntityId, HousekeeperTaskType)}
   */
  @Test
  void testNewHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualHousekeeperTask = new HousekeeperTask(TenantId.SYS_TENANT_ID, entityId,
        HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualHousekeeperTask.getEntityId());
    assertSame(tenantId, actualHousekeeperTask.getTenantId());
  }
}
