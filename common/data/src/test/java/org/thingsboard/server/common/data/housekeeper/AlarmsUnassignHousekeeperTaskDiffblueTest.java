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
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmsUnassignHousekeeperTaskDiffblueTest {
  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Act and Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Act and Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setUserTitle("Dr");

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setUserTitle("Dr");

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setAlarms(new ArrayList<>());

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask.hashCode());
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), 1);
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), mock(AlarmsDeletionHousekeeperTask.class));
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setUserTitle("Dr");

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, new AlarmsUnassignHousekeeperTask());
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, new AlarmsUnassignHousekeeperTask());
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, new AlarmsUnassignHousekeeperTask());
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setUserTitle("Dr");

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setAlarms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), null);
  }

  /**
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), "Different type to AlarmsUnassignHousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask()}
   *   <li>{@link AlarmsUnassignHousekeeperTask#setAlarms(List)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#setUserTitle(String)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#toString()}
   *   <li>{@link AlarmsUnassignHousekeeperTask#getAlarms()}
   *   <li>{@link AlarmsUnassignHousekeeperTask#getUserTitle()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    ArrayList<UUID> alarms = new ArrayList<>();
    actualAlarmsUnassignHousekeeperTask.setAlarms(alarms);
    actualAlarmsUnassignHousekeeperTask.setUserTitle("Dr");
    String actualToStringResult = actualAlarmsUnassignHousekeeperTask.toString();
    List<UUID> actualAlarms = actualAlarmsUnassignHousekeeperTask.getAlarms();

    // Assert that nothing has changed
    assertEquals(
        "AlarmsUnassignHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null, ts=0),"
            + " userTitle=Dr, alarms=[])",
        actualToStringResult);
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals(0L, actualAlarmsUnassignHousekeeperTask.getTs());
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
  }

  /**
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(User)}
   */
  @Test
  void testNewAlarmsUnassignHousekeeperTask() {
    // Arrange
    User user = mock(User.class);
    when(user.getTitle()).thenReturn("Dr");
    when(user.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    UserId userId = new UserId(EntityId.NULL_UUID);
    when(user.getId()).thenReturn(userId);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(user);

    // Assert
    verify(user).getId();
    verify(user).getTenantId();
    verify(user).getTitle();
    TenantId tenantId = actualAlarmsUnassignHousekeeperTask.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals("alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertNull(actualAlarmsUnassignHousekeeperTask.getAlarms());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualAlarmsUnassignHousekeeperTask.getTaskType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(userId, actualAlarmsUnassignHousekeeperTask.getEntityId());
  }

  /**
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  void testNewAlarmsUnassignHousekeeperTask2() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    UserId userId = new UserId(EntityId.NULL_UUID);
    ArrayList<UUID> alarms = new ArrayList<>();

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(tenantId,
        userId, "Dr", alarms);

    // Assert
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals("alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080 ([])",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualAlarmsUnassignHousekeeperTask.getTaskType());
    List<UUID> alarms2 = actualAlarmsUnassignHousekeeperTask.getAlarms();
    assertTrue(alarms2.isEmpty());
    assertSame(alarms, alarms2);
    assertSame(userId, actualAlarmsUnassignHousekeeperTask.getEntityId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualAlarmsUnassignHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  void testNewAlarmsUnassignHousekeeperTask3() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    UserId userId = new UserId(EntityId.NULL_UUID);

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(EntityId.NULL_UUID);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(tenantId,
        userId, "Dr", alarms);

    // Assert
    List<UUID> alarms2 = actualAlarmsUnassignHousekeeperTask.getAlarms();
    assertEquals(1, alarms2.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarms2.get(0).toString());
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals("alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080 ([13814000-1dd2-11b2-8080"
        + "-808080808080])", actualAlarmsUnassignHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualAlarmsUnassignHousekeeperTask.getTaskType());
    assertSame(alarms, alarms2);
    assertSame(userId, actualAlarmsUnassignHousekeeperTask.getEntityId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualAlarmsUnassignHousekeeperTask.getTenantId());
  }

  /**
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  void testNewAlarmsUnassignHousekeeperTask4() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    UserId userId = new UserId(EntityId.NULL_UUID);

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(EntityId.NULL_UUID);
    alarms.add(EntityId.NULL_UUID);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(tenantId,
        userId, "Dr", alarms);

    // Assert
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals(
        "alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080 ([13814000-1dd2-11b2-8080-808080808080,"
            + " 13814000-1dd2-11b2-8080-808080808080])",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualAlarmsUnassignHousekeeperTask.getTaskType());
    assertSame(alarms, actualAlarmsUnassignHousekeeperTask.getAlarms());
    assertSame(userId, actualAlarmsUnassignHousekeeperTask.getEntityId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualAlarmsUnassignHousekeeperTask.getTenantId());
  }
}
