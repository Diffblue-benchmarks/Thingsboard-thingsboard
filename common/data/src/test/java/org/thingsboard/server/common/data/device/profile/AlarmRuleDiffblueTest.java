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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;

class AlarmRuleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AlarmRule}
   *   <li>{@link AlarmRule#setAlarmDetails(String)}
   *   <li>{@link AlarmRule#setCondition(AlarmCondition)}
   *   <li>{@link AlarmRule#setSchedule(AlarmSchedule)}
   *   <li>{@link AlarmRule#toString()}
   *   <li>{@link AlarmRule#getAlarmDetails()}
   *   <li>{@link AlarmRule#getCondition()}
   *   <li>{@link AlarmRule#getDashboardId()}
   *   <li>{@link AlarmRule#getSchedule()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmRule.<init>()",
    "String AlarmRule.getAlarmDetails()",
    "AlarmCondition AlarmRule.getCondition()",
    "DashboardId AlarmRule.getDashboardId()",
    "AlarmSchedule AlarmRule.getSchedule()",
    "void AlarmRule.setAlarmDetails(String)",
    "void AlarmRule.setCondition(AlarmCondition)",
    "void AlarmRule.setDashboardId(DashboardId)",
    "void AlarmRule.setSchedule(AlarmSchedule)",
    "String AlarmRule.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmRule actualAlarmRule = new AlarmRule();
    actualAlarmRule.setAlarmDetails("Alarm Details");
    AlarmCondition condition = new AlarmCondition();
    condition.setCondition(new ArrayList<>());
    condition.setSpec(mock(AlarmConditionSpec.class));
    actualAlarmRule.setCondition(condition);
    AnyTimeSchedule schedule = new AnyTimeSchedule();
    actualAlarmRule.setSchedule(schedule);
    actualAlarmRule.toString();
    String actualAlarmDetails = actualAlarmRule.getAlarmDetails();
    AlarmCondition actualCondition = actualAlarmRule.getCondition();
    DashboardId actualDashboardId = actualAlarmRule.getDashboardId();

    // Assert
    assertEquals("Alarm Details", actualAlarmDetails);
    assertNull(actualDashboardId);
    assertSame(condition, actualCondition);
    assertSame(schedule, actualAlarmRule.getSchedule());
  }
}
