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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmAssignmentNotificationInfoDiffblueTest {
  /**
   * Method under test: {@link AlarmAssignmentNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
    // Arrange
    AlarmAssignmentNotificationInfo alarmAssignmentNotificationInfo = new AlarmAssignmentNotificationInfo();
    alarmAssignmentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmAssignmentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmAssignmentNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmAssignmentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmAssignmentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(17, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("critical", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("assigneeEmail"));
    assertNull(actualTemplateData.get("assigneeFirstName"));
    assertNull(actualTemplateData.get("assigneeId"));
    assertNull(actualTemplateData.get("assigneeTitle"));
    assertNull(actualTemplateData.get("userFirstName"));
    assertNull(actualTemplateData.get("userLastName"));
    assertNull(actualTemplateData.get("userTitle"));
  }
}
