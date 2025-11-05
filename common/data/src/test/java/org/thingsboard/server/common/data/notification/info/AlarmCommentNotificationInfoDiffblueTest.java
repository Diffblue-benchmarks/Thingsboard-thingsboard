package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmCommentNotificationInfoDiffblueTest {
  /**
   * Test {@link AlarmCommentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code userLastName} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'userLastName' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmCommentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnUserLastNameIsEmptyString() {
    // Arrange
    AlarmCommentNotificationInfo alarmCommentNotificationInfo = new AlarmCommentNotificationInfo();
    alarmCommentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmCommentNotificationInfo.setUserLastName("");
    alarmCommentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmCommentNotificationInfo.setAlarmSeverity(AlarmSeverity.MAJOR);
    alarmCommentNotificationInfo.setUserFirstName("");
    alarmCommentNotificationInfo.setAlarmId(EntityId.NULL_UUID);

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("userFirstName"));
    assertEquals("", actualTemplateData.get("userLastName"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmId"));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("major", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("comment"));
    assertNull(actualTemplateData.get("userTitle"));
  }

  /**
   * Test {@link AlarmCommentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code userLastName} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'userLastName' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmCommentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnUserLastNameIsNull() {
    // Arrange
    AlarmCommentNotificationInfo alarmCommentNotificationInfo = new AlarmCommentNotificationInfo();
    alarmCommentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmCommentNotificationInfo.setUserLastName(null);
    alarmCommentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmCommentNotificationInfo.setAlarmSeverity(AlarmSeverity.MAJOR);
    alarmCommentNotificationInfo.setUserFirstName("");
    alarmCommentNotificationInfo.setAlarmId(EntityId.NULL_UUID);

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("userFirstName"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmId"));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("major", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("comment"));
    assertNull(actualTemplateData.get("userLastName"));
    assertNull(actualTemplateData.get("userTitle"));
  }

  /**
   * Test {@link AlarmCommentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code userTitle} is {@code Doe}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'userTitle' is 'Doe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmCommentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnUserTitleIsDoe() {
    // Arrange
    AlarmCommentNotificationInfo alarmCommentNotificationInfo = new AlarmCommentNotificationInfo();
    alarmCommentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmCommentNotificationInfo.setUserLastName("Doe");
    alarmCommentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmCommentNotificationInfo.setAlarmSeverity(AlarmSeverity.MAJOR);
    alarmCommentNotificationInfo.setUserFirstName("");
    alarmCommentNotificationInfo.setAlarmId(EntityId.NULL_UUID);

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("userFirstName"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmId"));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Doe", actualTemplateData.get("userLastName"));
    assertEquals("Doe", actualTemplateData.get("userTitle"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("major", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("comment"));
  }

  /**
   * Test {@link AlarmCommentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code userTitle} is {@code Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'userTitle' is 'Jane Doe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmCommentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnUserTitleIsJaneDoe() {
    // Arrange
    AlarmCommentNotificationInfo alarmCommentNotificationInfo = new AlarmCommentNotificationInfo();
    alarmCommentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmCommentNotificationInfo.setUserLastName("Doe");
    alarmCommentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_ACK);
    alarmCommentNotificationInfo.setAlarmSeverity(AlarmSeverity.MAJOR);
    alarmCommentNotificationInfo.setUserFirstName("Jane");
    alarmCommentNotificationInfo.setAlarmId(EntityId.NULL_UUID);

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmId"));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Doe", actualTemplateData.get("userLastName"));
    assertEquals("Jane Doe", actualTemplateData.get("userTitle"));
    assertEquals("Jane", actualTemplateData.get("userFirstName"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("major", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("comment"));
  }
}
