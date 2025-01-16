package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmNotificationInfoDiffblueTest {
  /**
   * Test {@link AlarmNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is eight")
  void testGetTemplateData_thenReturnSizeIsEight() {
    // Arrange
    AlarmNotificationInfo alarmNotificationInfo = new AlarmNotificationInfo();
    alarmNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmNotificationInfo.setAlarmId(EntityId.NULL_UUID);

    // Act
    Map<String, String> actualTemplateData = alarmNotificationInfo.getTemplateData();

    // Assert
    assertEquals(8, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("critical", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmOriginatorName"));
    assertNull(actualTemplateData.get("alarmType"));
  }
}
