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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmDiffblueTest {
  /**
   * Method under test: {@link Alarm#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Alarm()).getId());
  }

  /**
   * Method under test: {@link Alarm#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Alarm()).getCreatedTime());
  }

  /**
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  void testGetStatus() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.ACTIVE_UNACK, (new Alarm()).getStatus());
  }

  /**
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  void testGetStatus2() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);

    // Act and Assert
    assertEquals(AlarmStatus.ACTIVE_ACK, alarm.getStatus());
  }

  /**
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  void testGetStatus3() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setCleared(true);

    // Act and Assert
    assertEquals(AlarmStatus.CLEARED_UNACK, alarm.getStatus());
  }

  /**
   * Method under test: {@link Alarm#getStatus()}
   */
  @Test
  void testGetStatus4() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setCleared(true);
    alarm.setAcknowledged(true);

    // Act and Assert
    assertEquals(AlarmStatus.CLEARED_ACK, alarm.getStatus());
  }

  /**
   * Method under test: {@link Alarm#toStatus(boolean, boolean)}
   */
  @Test
  void testToStatus() {
    // Arrange, Act and Assert
    assertEquals(AlarmStatus.CLEARED_ACK, Alarm.toStatus(true, true));
    assertEquals(AlarmStatus.ACTIVE_UNACK, Alarm.toStatus(false, false));
    assertEquals(AlarmStatus.ACTIVE_ACK, Alarm.toStatus(false, true));
    assertEquals(AlarmStatus.CLEARED_UNACK, Alarm.toStatus(true, false));
  }

  /**
   * Method under test: {@link Alarm#getDashboardId()}
   */
  @Test
  void testGetDashboardId() {
    // Arrange, Act and Assert
    assertNull((new Alarm()).getDashboardId());
  }

  /**
   * Method under test: {@link Alarm#getDashboardId()}
   */
  @Test
  void testGetDashboardId2() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setDetails(MissingNode.getInstance());

    // Act and Assert
    assertNull(alarm.getDashboardId());
  }

  /**
   * Method under test: {@link Alarm#Alarm(Alarm)}
   */
  @Test
  void testNewAlarm() {
    // Arrange
    Alarm alarm = new Alarm();

    // Act and Assert
    assertEquals(alarm, new Alarm(alarm));
  }

  /**
   * Method under test: {@link Alarm#Alarm(Alarm)}
   */
  @Test
  void testNewAlarm2() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);

    // Act and Assert
    assertEquals(alarm, new Alarm(alarm));
  }

  /**
   * Method under test:
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}
   */
  @Test
  void testNewAlarm3() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TenantId originator = TenantId.SYS_TENANT_ID;
    MissingNode details = MissingNode.getInstance();
    ArrayList<String> propagateRelationTypes = new ArrayList<>();

    // Act
    Alarm actualAlarm = new Alarm(TenantId.SYS_TENANT_ID, customerId, "Type", originator, AlarmSeverity.CRITICAL, true,
        true, null, 1L, 1L, 1L, 1L, 1L, details, true, true, true, propagateRelationTypes);

    // Assert
    assertEquals("Type", actualAlarm.getName());
    assertEquals("Type", actualAlarm.getType());
    assertNull(actualAlarm.getUuidId());
    assertNull(actualAlarm.getId());
    assertNull(actualAlarm.getDashboardId());
    assertNull(actualAlarm.getAssigneeId());
    assertEquals(0L, actualAlarm.getCreatedTime());
    assertEquals(1L, actualAlarm.getAckTs());
    assertEquals(1L, actualAlarm.getAssignTs());
    assertEquals(1L, actualAlarm.getClearTs());
    assertEquals(1L, actualAlarm.getEndTs());
    assertEquals(1L, actualAlarm.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarm.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualAlarm.getStatus());
    List<String> propagateRelationTypes2 = actualAlarm.getPropagateRelationTypes();
    assertTrue(propagateRelationTypes2.isEmpty());
    assertTrue(actualAlarm.isAcknowledged());
    assertTrue(actualAlarm.isCleared());
    assertTrue(actualAlarm.isPropagate());
    assertTrue(actualAlarm.isPropagateToOwner());
    assertTrue(actualAlarm.isPropagateToTenant());
    assertSame(propagateRelationTypes, propagateRelationTypes2);
    assertSame(customerId, actualAlarm.getCustomerId());
    assertSame(details, actualAlarm.getDetails());
    TenantId tenantId = originator.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarm.getOriginator());
    assertSame(tenantId, actualAlarm.getTenantId());
  }

  /**
   * Method under test:
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}
   */
  @Test
  void testNewAlarm4() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TenantId originator = TenantId.SYS_TENANT_ID;
    MissingNode details = MissingNode.getInstance();

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    // Act
    Alarm actualAlarm = new Alarm(TenantId.SYS_TENANT_ID, customerId, "Type", originator, AlarmSeverity.CRITICAL, true,
        true, null, 1L, 1L, 1L, 1L, 1L, details, true, true, true, propagateRelationTypes);

    // Assert
    assertEquals("Type", actualAlarm.getName());
    assertEquals("Type", actualAlarm.getType());
    List<String> propagateRelationTypes2 = actualAlarm.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes2.size());
    assertEquals("foo", propagateRelationTypes2.get(0));
    assertNull(actualAlarm.getUuidId());
    assertNull(actualAlarm.getId());
    assertNull(actualAlarm.getDashboardId());
    assertNull(actualAlarm.getAssigneeId());
    assertEquals(0L, actualAlarm.getCreatedTime());
    assertEquals(1L, actualAlarm.getAckTs());
    assertEquals(1L, actualAlarm.getAssignTs());
    assertEquals(1L, actualAlarm.getClearTs());
    assertEquals(1L, actualAlarm.getEndTs());
    assertEquals(1L, actualAlarm.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarm.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualAlarm.getStatus());
    assertTrue(actualAlarm.isAcknowledged());
    assertTrue(actualAlarm.isCleared());
    assertTrue(actualAlarm.isPropagate());
    assertTrue(actualAlarm.isPropagateToOwner());
    assertTrue(actualAlarm.isPropagateToTenant());
    assertSame(propagateRelationTypes, propagateRelationTypes2);
    assertSame(customerId, actualAlarm.getCustomerId());
    assertSame(details, actualAlarm.getDetails());
    TenantId tenantId = originator.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarm.getOriginator());
    assertSame(tenantId, actualAlarm.getTenantId());
  }

  /**
   * Method under test:
   * {@link Alarm#Alarm(TenantId, CustomerId, String, EntityId, AlarmSeverity, boolean, boolean, UserId, long, long, long, long, long, JsonNode, boolean, boolean, boolean, List)}
   */
  @Test
  void testNewAlarm5() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TenantId originator = TenantId.SYS_TENANT_ID;
    MissingNode details = MissingNode.getInstance();

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("42");
    propagateRelationTypes.add("foo");

    // Act
    Alarm actualAlarm = new Alarm(TenantId.SYS_TENANT_ID, customerId, "Type", originator, AlarmSeverity.CRITICAL, true,
        true, null, 1L, 1L, 1L, 1L, 1L, details, true, true, true, propagateRelationTypes);

    // Assert
    assertEquals("Type", actualAlarm.getName());
    assertEquals("Type", actualAlarm.getType());
    assertNull(actualAlarm.getUuidId());
    assertNull(actualAlarm.getId());
    assertNull(actualAlarm.getDashboardId());
    assertNull(actualAlarm.getAssigneeId());
    assertEquals(0L, actualAlarm.getCreatedTime());
    assertEquals(1L, actualAlarm.getAckTs());
    assertEquals(1L, actualAlarm.getAssignTs());
    assertEquals(1L, actualAlarm.getClearTs());
    assertEquals(1L, actualAlarm.getEndTs());
    assertEquals(1L, actualAlarm.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarm.getSeverity());
    assertEquals(AlarmStatus.CLEARED_ACK, actualAlarm.getStatus());
    assertTrue(actualAlarm.isAcknowledged());
    assertTrue(actualAlarm.isCleared());
    assertTrue(actualAlarm.isPropagate());
    assertTrue(actualAlarm.isPropagateToOwner());
    assertTrue(actualAlarm.isPropagateToTenant());
    assertSame(propagateRelationTypes, actualAlarm.getPropagateRelationTypes());
    assertSame(customerId, actualAlarm.getCustomerId());
    assertSame(details, actualAlarm.getDetails());
    TenantId tenantId = originator.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarm.getOriginator());
    assertSame(tenantId, actualAlarm.getTenantId());
  }
}
