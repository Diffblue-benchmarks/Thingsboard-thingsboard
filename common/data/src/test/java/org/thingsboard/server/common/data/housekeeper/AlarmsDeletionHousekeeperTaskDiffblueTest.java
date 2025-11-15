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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmsDeletionHousekeeperTaskDiffblueTest {
  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        (new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID)).getDescription());
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        (new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>()))
            .getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 = new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
    int expectedHashCodeResult = alarmsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>());
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>());

    // Act and Assert
    assertEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
    int expectedHashCodeResult = alarmsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask);
    int expectedHashCodeResult = alarmsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsDeletionHousekeeperTask.hashCode());
  }

  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsDeletionHousekeeperTask(), mock(AlarmsUnassignHousekeeperTask.class));
  }

  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setAlarms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask,
        new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>()));
  }

  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsDeletionHousekeeperTask(), null);
  }

  /**
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsDeletionHousekeeperTask(), "Different type to AlarmsDeletionHousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask()}
   *   <li>{@link AlarmsDeletionHousekeeperTask#setAlarms(List)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#toString()}
   *   <li>{@link AlarmsDeletionHousekeeperTask#getAlarms()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    ArrayList<UUID> alarms = new ArrayList<>();
    actualAlarmsDeletionHousekeeperTask.setAlarms(alarms);
    String actualToStringResult = actualAlarmsDeletionHousekeeperTask.toString();
    List<UUID> actualAlarms = actualAlarmsDeletionHousekeeperTask.getAlarms();

    // Assert that nothing has changed
    assertEquals(
        "AlarmsDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null, ts=0),"
            + " alarms=[])",
        actualToStringResult);
    assertEquals(0L, actualAlarmsDeletionHousekeeperTask.getTs());
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
  }

  /**
   * Method under test:
   * {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId)}
   */
  @Test
  void testNewAlarmsDeletionHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertNull(actualAlarmsDeletionHousekeeperTask.getAlarms());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualAlarmsDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}
   */
  @Test
  void testNewAlarmsDeletionHousekeeperTask2() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;
    ArrayList<UUID> alarms = new ArrayList<>();

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, alarms);

    // Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualAlarmsDeletionHousekeeperTask.getTaskType());
    List<UUID> alarms2 = actualAlarmsDeletionHousekeeperTask.getAlarms();
    assertTrue(alarms2.isEmpty());
    assertSame(alarms, alarms2);
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}
   */
  @Test
  void testNewAlarmsDeletionHousekeeperTask3() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(EntityId.NULL_UUID);

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, alarms);

    // Assert
    List<UUID> alarms2 = actualAlarmsDeletionHousekeeperTask.getAlarms();
    assertEquals(1, alarms2.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarms2.get(0).toString());
    assertEquals(
        "alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([13814000-1dd2-11b2-8080" + "-808080808080])",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualAlarmsDeletionHousekeeperTask.getTaskType());
    assertSame(alarms, alarms2);
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}
   */
  @Test
  void testNewAlarmsDeletionHousekeeperTask4() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(EntityId.NULL_UUID);
    alarms.add(EntityId.NULL_UUID);

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, alarms);

    // Assert
    assertEquals(
        "alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([13814000-1dd2-11b2-8080-808080808080,"
            + " 13814000-1dd2-11b2-8080-808080808080])",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualAlarmsDeletionHousekeeperTask.getTaskType());
    assertSame(alarms, actualAlarmsDeletionHousekeeperTask.getAlarms());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getTenantId());
  }
}
