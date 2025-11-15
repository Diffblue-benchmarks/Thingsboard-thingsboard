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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmCreateOrUpdateActiveRequestDiffblueTest {
  /**
   * Method under test: {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm)}
   */
  @Test
  void testFromAlarm() {
    // Arrange and Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult = AlarmCreateOrUpdateActiveRequest.fromAlarm(new Alarm());

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    assertNull(actualFromAlarmResult.getType());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getCustomerId());
    assertNull(actualFromAlarmResult.getOriginator());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }

  /**
   * Method under test:
   * {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  void testFromAlarm2() {
    // Arrange and Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult = AlarmCreateOrUpdateActiveRequest.fromAlarm(new Alarm(),
        null);

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    assertNull(actualFromAlarmResult.getType());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getCustomerId());
    assertNull(actualFromAlarmResult.getOriginator());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }

  /**
   * Method under test:
   * {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId, AlarmId)}
   */
  @Test
  void testFromAlarm3() {
    // Arrange
    Alarm a = mock(Alarm.class);
    when(a.isPropagate()).thenReturn(true);
    when(a.isPropagateToOwner()).thenReturn(true);
    when(a.isPropagateToTenant()).thenReturn(true);
    MissingNode instance = MissingNode.getInstance();
    when(a.getDetails()).thenReturn(instance);
    when(a.getType()).thenReturn("Type");
    ArrayList<String> stringList = new ArrayList<>();
    when(a.getPropagateRelationTypes()).thenReturn(stringList);
    when(a.getEndTs()).thenReturn(1L);
    when(a.getStartTs()).thenReturn(1L);
    when(a.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    when(a.getCustomerId()).thenReturn(customerId);
    when(a.getOriginator()).thenReturn(TenantId.SYS_TENANT_ID);
    when(a.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult = AlarmCreateOrUpdateActiveRequest.fromAlarm(a, null, null);

    // Assert
    verify(a).getCustomerId();
    verify(a).getDetails();
    verify(a).getEndTs();
    verify(a).getOriginator();
    verify(a).getPropagateRelationTypes();
    verify(a).getSeverity();
    verify(a).getStartTs();
    verify(a).getTenantId();
    verify(a).getType();
    verify(a).isPropagate();
    verify(a).isPropagateToOwner();
    verify(a).isPropagateToTenant();
    EntityId originator = actualFromAlarmResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("Type", actualFromAlarmResult.getType());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(1L, actualFromAlarmResult.getEndTs());
    assertEquals(1L, actualFromAlarmResult.getStartTs());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(AlarmSeverity.CRITICAL, actualFromAlarmResult.getSeverity());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    List<String> propagateRelationTypes = propagation.getPropagateRelationTypes();
    assertTrue(propagateRelationTypes.isEmpty());
    assertTrue(propagation.isPropagate());
    assertTrue(propagation.isPropagateToOwner());
    assertTrue(propagation.isPropagateToTenant());
    assertTrue(originator.isNullUid());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(stringList, propagateRelationTypes);
    assertSame(customerId, actualFromAlarmResult.getCustomerId());
    assertSame(instance, actualFromAlarmResult.getDetails());
    assertSame(originator, actualFromAlarmResult.getTenantId());
  }
}
