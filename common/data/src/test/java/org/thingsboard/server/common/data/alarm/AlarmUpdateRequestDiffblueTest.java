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
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmUpdateRequestDiffblueTest {
  /**
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm)}
   */
  @Test
  void testFromAlarm() {
    // Arrange and Act
    AlarmUpdateRequest actualFromAlarmResult = AlarmUpdateRequest.fromAlarm(new Alarm());

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getAlarmId());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }

  /**
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  void testFromAlarm2() {
    // Arrange and Act
    AlarmUpdateRequest actualFromAlarmResult = AlarmUpdateRequest.fromAlarm(new Alarm(), null);

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getAlarmId());
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
   * {@link AlarmUpdateRequest#AlarmUpdateRequest(TenantId, AlarmId, AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId)}
   */
  @Test
  void testNewAlarmUpdateRequest() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    AlarmId alarmId = mock(AlarmId.class);
    MissingNode details = MissingNode.getInstance();
    AlarmPropagationInfo propagation = new AlarmPropagationInfo(true, true, true, new ArrayList<>());

    // Act
    AlarmUpdateRequest actualAlarmUpdateRequest = new AlarmUpdateRequest(tenantId, alarmId, AlarmSeverity.CRITICAL, 1L,
        1L, details, propagation, null);

    // Assert
    assertNull(actualAlarmUpdateRequest.getUserId());
    assertEquals(1L, actualAlarmUpdateRequest.getEndTs());
    assertEquals(1L, actualAlarmUpdateRequest.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarmUpdateRequest.getSeverity());
    assertSame(propagation, actualAlarmUpdateRequest.getPropagation());
    assertSame(details, actualAlarmUpdateRequest.getDetails());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualAlarmUpdateRequest.getTenantId());
    assertSame(alarmId, actualAlarmUpdateRequest.getAlarmId());
  }
}
