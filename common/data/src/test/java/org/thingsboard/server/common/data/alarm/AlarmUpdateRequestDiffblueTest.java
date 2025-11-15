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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class AlarmUpdateRequestDiffblueTest {
  /**
   * Test {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)} with {@code a}, {@code userId}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm, UserId) with 'a', 'userId'; when Alarm(); then return Details is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmUpdateRequest AlarmUpdateRequest.fromAlarm(Alarm, UserId)"})
  void testFromAlarmWithAUserId_whenAlarm_thenReturnDetailsIsNull() {
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
   * Test {@link AlarmUpdateRequest#fromAlarm(Alarm)} with {@code a}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm) with 'a'; when Alarm(); then return Details is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AlarmUpdateRequest AlarmUpdateRequest.fromAlarm(Alarm)"})
  void testFromAlarmWithA_whenAlarm_thenReturnDetailsIsNull() {
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
}
