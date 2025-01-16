package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmAssignmentNotificationInfoDiffblueTest {
  /**
   * Test {@link AlarmAssignmentNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is seventeen.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignmentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is seventeen")
  void testGetTemplateData_thenReturnSizeIsSeventeen() {
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
