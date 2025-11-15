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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmDataDiffblueTest {
  /**
   * Method under test: {@link AlarmData#AlarmData(Alarm, EntityId)}
   */
  @Test
  void testNewAlarmData() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmData actualAlarmData = new AlarmData(new Alarm(), entityId);

    // Assert
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isAcknowledged());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    TenantId expectedEntityId = entityId.SYS_TENANT_ID;
    assertSame(expectedEntityId, actualAlarmData.getEntityId());
  }

  /**
   * Method under test: {@link AlarmData#AlarmData(Alarm, EntityId)}
   */
  @Test
  void testNewAlarmData2() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmData actualAlarmData = new AlarmData(alarm, entityId);

    // Assert
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_ACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    assertTrue(actualAlarmData.isAcknowledged());
    TenantId expectedEntityId = entityId.SYS_TENANT_ID;
    assertSame(expectedEntityId, actualAlarmData.getEntityId());
  }

  /**
   * Method under test: {@link AlarmData#AlarmData(AlarmInfo, AlarmData)}
   */
  @Test
  void testNewAlarmData3() {
    // Arrange
    AlarmInfo main = new AlarmInfo();
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(true);
    Alarm alarm = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act
    AlarmData actualAlarmData = new AlarmData(main, new AlarmData(alarm, TenantId.SYS_TENANT_ID));

    // Assert
    EntityId entityId = actualAlarmData.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isAcknowledged());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Method under test: {@link AlarmData#AlarmData(AlarmInfo, AlarmData)}
   */
  @Test
  void testNewAlarmData4() {
    // Arrange
    AlarmInfo main = new AlarmInfo();
    main.setAcknowledged(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(true);
    Alarm alarm = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act
    AlarmData actualAlarmData = new AlarmData(main, new AlarmData(alarm, TenantId.SYS_TENANT_ID));

    // Assert
    EntityId entityId = actualAlarmData.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(AlarmStatus.ACTIVE_ACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    assertTrue(actualAlarmData.isAcknowledged());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }
}
