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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.query.AlarmData;

class AlarmInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfo#equals(Object)}
   *   <li>{@link AlarmInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    AlarmInfo alarmInfo2 = new AlarmInfo();

    // Act and Assert
    assertEquals(alarmInfo, alarmInfo2);
    int expectedHashCodeResult = alarmInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfo#equals(Object)}
   *   <li>{@link AlarmInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginatorName("Originator Name");

    AlarmInfo alarmInfo2 = new AlarmInfo();
    alarmInfo2.setOriginatorName("Originator Name");

    // Act and Assert
    assertEquals(alarmInfo, alarmInfo2);
    int expectedHashCodeResult = alarmInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfo#equals(Object)}
   *   <li>{@link AlarmInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginatorLabel("Originator Label");

    AlarmInfo alarmInfo2 = new AlarmInfo();
    alarmInfo2.setOriginatorLabel("Originator Label");

    // Act and Assert
    assertEquals(alarmInfo, alarmInfo2);
    int expectedHashCodeResult = alarmInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfo#equals(Object)}
   *   <li>{@link AlarmInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();

    // Act and Assert
    assertEquals(alarmInfo, alarmInfo);
    int expectedHashCodeResult = alarmInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfo.hashCode());
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmInfo(), 1);
    assertNotEquals(new AlarmInfo(), mock(Alarm.class));
    assertNotEquals(new AlarmInfo(), mock(AlarmData.class));
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginatorName("Originator Name");

    // Act and Assert
    assertNotEquals(alarmInfo, new AlarmInfo());
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginatorLabel("Originator Label");

    // Act and Assert
    assertNotEquals(alarmInfo, new AlarmInfo());
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmInfo, new AlarmInfo());
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();

    AlarmInfo alarmInfo2 = new AlarmInfo();
    alarmInfo2.setOriginatorName("Originator Name");

    // Act and Assert
    assertNotEquals(alarmInfo, alarmInfo2);
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();

    AlarmInfo alarmInfo2 = new AlarmInfo();
    alarmInfo2.setOriginatorLabel("Originator Label");

    // Act and Assert
    assertNotEquals(alarmInfo, alarmInfo2);
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmInfo(), null);
  }

  /**
   * Method under test: {@link AlarmInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmInfo(), "Different type to AlarmInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfo#AlarmInfo()}
   *   <li>{@link AlarmInfo#setOriginatorLabel(String)}
   *   <li>{@link AlarmInfo#setOriginatorName(String)}
   *   <li>{@link AlarmInfo#toString()}
   *   <li>{@link AlarmInfo#getAssignee()}
   *   <li>{@link AlarmInfo#getOriginatorLabel()}
   *   <li>{@link AlarmInfo#getOriginatorName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmInfo actualAlarmInfo = new AlarmInfo();
    actualAlarmInfo.setOriginatorLabel("Originator Label");
    actualAlarmInfo.setOriginatorName("Originator Name");
    String actualToStringResult = actualAlarmInfo.toString();
    actualAlarmInfo.getAssignee();
    String actualOriginatorLabel = actualAlarmInfo.getOriginatorLabel();

    // Assert that nothing has changed
    assertEquals(
        "AlarmInfo(super=Alarm(tenantId=null, customerId=null, type=null, originator=null, severity=null,"
            + " acknowledged=false, cleared=false, assigneeId=null, startTs=0, endTs=0, ackTs=0, clearTs=0, assignTs=0,"
            + " details=null, propagate=false, propagateToOwner=false, propagateToTenant=false, propagateRelationTypes"
            + "=null), originatorName=Originator Name, originatorLabel=Originator Label, assignee=null)",
        actualToStringResult);
    assertEquals("Originator Label", actualOriginatorLabel);
    assertEquals("Originator Name", actualAlarmInfo.getOriginatorName());
    assertEquals(0L, actualAlarmInfo.getAckTs());
    assertEquals(0L, actualAlarmInfo.getAssignTs());
    assertEquals(0L, actualAlarmInfo.getClearTs());
    assertEquals(0L, actualAlarmInfo.getCreatedTime());
    assertEquals(0L, actualAlarmInfo.getEndTs());
    assertEquals(0L, actualAlarmInfo.getStartTs());
    assertFalse(actualAlarmInfo.isAcknowledged());
    assertFalse(actualAlarmInfo.isCleared());
    assertFalse(actualAlarmInfo.isPropagate());
    assertFalse(actualAlarmInfo.isPropagateToOwner());
    assertFalse(actualAlarmInfo.isPropagateToTenant());
  }

  /**
   * Method under test: {@link AlarmInfo#AlarmInfo(Alarm)}
   */
  @Test
  void testNewAlarmInfo() {
    // Arrange and Act
    AlarmInfo actualAlarmInfo = new AlarmInfo(new Alarm());

    // Assert
    assertNull(actualAlarmInfo.getDetails());
    assertNull(actualAlarmInfo.getName());
    assertNull(actualAlarmInfo.getType());
    assertNull(actualAlarmInfo.getOriginatorLabel());
    assertNull(actualAlarmInfo.getOriginatorName());
    assertNull(actualAlarmInfo.getPropagateRelationTypes());
    assertNull(actualAlarmInfo.getUuidId());
    assertNull(actualAlarmInfo.getAssignee());
    assertNull(actualAlarmInfo.getSeverity());
    assertNull(actualAlarmInfo.getId());
    assertNull(actualAlarmInfo.getCustomerId());
    assertNull(actualAlarmInfo.getDashboardId());
    assertNull(actualAlarmInfo.getOriginator());
    assertNull(actualAlarmInfo.getTenantId());
    assertNull(actualAlarmInfo.getAssigneeId());
    assertEquals(0L, actualAlarmInfo.getAckTs());
    assertEquals(0L, actualAlarmInfo.getAssignTs());
    assertEquals(0L, actualAlarmInfo.getClearTs());
    assertEquals(0L, actualAlarmInfo.getCreatedTime());
    assertEquals(0L, actualAlarmInfo.getEndTs());
    assertEquals(0L, actualAlarmInfo.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualAlarmInfo.getStatus());
    assertFalse(actualAlarmInfo.isAcknowledged());
    assertFalse(actualAlarmInfo.isCleared());
    assertFalse(actualAlarmInfo.isPropagate());
    assertFalse(actualAlarmInfo.isPropagateToOwner());
    assertFalse(actualAlarmInfo.isPropagateToTenant());
  }

  /**
   * Method under test: {@link AlarmInfo#AlarmInfo(Alarm)}
   */
  @Test
  void testNewAlarmInfo2() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);

    // Act
    AlarmInfo actualAlarmInfo = new AlarmInfo(alarm);

    // Assert
    assertNull(actualAlarmInfo.getDetails());
    assertNull(actualAlarmInfo.getName());
    assertNull(actualAlarmInfo.getType());
    assertNull(actualAlarmInfo.getOriginatorLabel());
    assertNull(actualAlarmInfo.getOriginatorName());
    assertNull(actualAlarmInfo.getPropagateRelationTypes());
    assertNull(actualAlarmInfo.getUuidId());
    assertNull(actualAlarmInfo.getAssignee());
    assertNull(actualAlarmInfo.getSeverity());
    assertNull(actualAlarmInfo.getId());
    assertNull(actualAlarmInfo.getCustomerId());
    assertNull(actualAlarmInfo.getDashboardId());
    assertNull(actualAlarmInfo.getOriginator());
    assertNull(actualAlarmInfo.getTenantId());
    assertNull(actualAlarmInfo.getAssigneeId());
    assertEquals(0L, actualAlarmInfo.getAckTs());
    assertEquals(0L, actualAlarmInfo.getAssignTs());
    assertEquals(0L, actualAlarmInfo.getClearTs());
    assertEquals(0L, actualAlarmInfo.getCreatedTime());
    assertEquals(0L, actualAlarmInfo.getEndTs());
    assertEquals(0L, actualAlarmInfo.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_ACK, actualAlarmInfo.getStatus());
    assertFalse(actualAlarmInfo.isCleared());
    assertFalse(actualAlarmInfo.isPropagate());
    assertFalse(actualAlarmInfo.isPropagateToOwner());
    assertFalse(actualAlarmInfo.isPropagateToTenant());
    assertTrue(actualAlarmInfo.isAcknowledged());
  }

  /**
   * Method under test:
   * {@link AlarmInfo#AlarmInfo(Alarm, String, String, AlarmAssignee)}
   */
  @Test
  void testNewAlarmInfo3() {
    // Arrange
    Alarm alarm = new Alarm();
    AlarmAssignee assignee = new AlarmAssignee(null, "Jane", "Doe", "jane.doe@example.org");

    // Act
    AlarmInfo actualAlarmInfo = new AlarmInfo(alarm, "Originator Name", "Originator Label", assignee);

    // Assert
    assertEquals("Originator Label", actualAlarmInfo.getOriginatorLabel());
    assertEquals("Originator Name", actualAlarmInfo.getOriginatorName());
    assertNull(actualAlarmInfo.getDetails());
    assertNull(actualAlarmInfo.getName());
    assertNull(actualAlarmInfo.getType());
    assertNull(actualAlarmInfo.getPropagateRelationTypes());
    assertNull(actualAlarmInfo.getUuidId());
    assertNull(actualAlarmInfo.getSeverity());
    assertNull(actualAlarmInfo.getId());
    assertNull(actualAlarmInfo.getCustomerId());
    assertNull(actualAlarmInfo.getDashboardId());
    assertNull(actualAlarmInfo.getOriginator());
    assertNull(actualAlarmInfo.getTenantId());
    assertNull(actualAlarmInfo.getAssigneeId());
    assertEquals(0L, actualAlarmInfo.getAckTs());
    assertEquals(0L, actualAlarmInfo.getAssignTs());
    assertEquals(0L, actualAlarmInfo.getClearTs());
    assertEquals(0L, actualAlarmInfo.getCreatedTime());
    assertEquals(0L, actualAlarmInfo.getEndTs());
    assertEquals(0L, actualAlarmInfo.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualAlarmInfo.getStatus());
    assertFalse(actualAlarmInfo.isAcknowledged());
    assertFalse(actualAlarmInfo.isCleared());
    assertFalse(actualAlarmInfo.isPropagate());
    assertFalse(actualAlarmInfo.isPropagateToOwner());
    assertFalse(actualAlarmInfo.isPropagateToTenant());
    assertSame(assignee, actualAlarmInfo.getAssignee());
  }

  /**
   * Method under test:
   * {@link AlarmInfo#AlarmInfo(Alarm, String, String, AlarmAssignee)}
   */
  @Test
  void testNewAlarmInfo4() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);
    AlarmAssignee assignee = new AlarmAssignee(null, "Jane", "Doe", "jane.doe@example.org");

    // Act
    AlarmInfo actualAlarmInfo = new AlarmInfo(alarm, "Originator Name", "Originator Label", assignee);

    // Assert
    assertEquals("Originator Label", actualAlarmInfo.getOriginatorLabel());
    assertEquals("Originator Name", actualAlarmInfo.getOriginatorName());
    assertNull(actualAlarmInfo.getDetails());
    assertNull(actualAlarmInfo.getName());
    assertNull(actualAlarmInfo.getType());
    assertNull(actualAlarmInfo.getPropagateRelationTypes());
    assertNull(actualAlarmInfo.getUuidId());
    assertNull(actualAlarmInfo.getSeverity());
    assertNull(actualAlarmInfo.getId());
    assertNull(actualAlarmInfo.getCustomerId());
    assertNull(actualAlarmInfo.getDashboardId());
    assertNull(actualAlarmInfo.getOriginator());
    assertNull(actualAlarmInfo.getTenantId());
    assertNull(actualAlarmInfo.getAssigneeId());
    assertEquals(0L, actualAlarmInfo.getAckTs());
    assertEquals(0L, actualAlarmInfo.getAssignTs());
    assertEquals(0L, actualAlarmInfo.getClearTs());
    assertEquals(0L, actualAlarmInfo.getCreatedTime());
    assertEquals(0L, actualAlarmInfo.getEndTs());
    assertEquals(0L, actualAlarmInfo.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_ACK, actualAlarmInfo.getStatus());
    assertFalse(actualAlarmInfo.isCleared());
    assertFalse(actualAlarmInfo.isPropagate());
    assertFalse(actualAlarmInfo.isPropagateToOwner());
    assertFalse(actualAlarmInfo.isPropagateToTenant());
    assertTrue(actualAlarmInfo.isAcknowledged());
    assertSame(assignee, actualAlarmInfo.getAssignee());
  }

  /**
   * Method under test: {@link AlarmInfo#AlarmInfo(AlarmInfo)}
   */
  @Test
  void testNewAlarmInfo5() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();

    // Act and Assert
    assertEquals(alarmInfo, new AlarmInfo(alarmInfo));
  }

  /**
   * Method under test: {@link AlarmInfo#AlarmInfo(AlarmInfo)}
   */
  @Test
  void testNewAlarmInfo6() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setAcknowledged(true);

    // Act and Assert
    assertEquals(alarmInfo, new AlarmInfo(alarmInfo));
  }
}
