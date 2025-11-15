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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmCommentNotificationInfoDiffblueTest {
  /**
   * Test {@link AlarmCommentNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is thirteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCommentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is thirteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AlarmCommentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsThirteen() {
    // Arrange
    AlarmCommentNotificationInfo alarmCommentNotificationInfo = new AlarmCommentNotificationInfo();
    alarmCommentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmCommentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmCommentNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmCommentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("critical", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("comment"));
    assertNull(actualTemplateData.get("userFirstName"));
    assertNull(actualTemplateData.get("userLastName"));
    assertNull(actualTemplateData.get("userTitle"));
    assertTrue(actualTemplateData.containsKey("alarmId"));
  }
}
