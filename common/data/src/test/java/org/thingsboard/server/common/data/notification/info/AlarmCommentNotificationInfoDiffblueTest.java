package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
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
