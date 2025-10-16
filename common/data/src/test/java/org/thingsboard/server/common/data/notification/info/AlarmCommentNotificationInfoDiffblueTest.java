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
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
    alarmCommentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("userFirstName"));
    assertEquals("", actualTemplateData.get("userLastName"));
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("alarmOriginatorId"));
    assertEquals("ACTIVE_ACK", actualTemplateData.get("alarmStatus"));
    assertEquals("Tenant", actualTemplateData.get("alarmOriginatorEntityType"));
    assertEquals("major", actualTemplateData.get("alarmSeverity"));
    assertNull(actualTemplateData.get("action"));
    assertNull(actualTemplateData.get("alarmType"));
    assertNull(actualTemplateData.get("comment"));
    assertNull(actualTemplateData.get("userTitle"));
    assertTrue(actualTemplateData.containsKey("alarmId"));
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
    alarmCommentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("userFirstName"));
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
    assertTrue(actualTemplateData.containsKey("alarmId"));
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
    alarmCommentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("userFirstName"));
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
    assertTrue(actualTemplateData.containsKey("alarmId"));
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
    alarmCommentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmCommentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(13, actualTemplateData.size());
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
    assertTrue(actualTemplateData.containsKey("alarmId"));
  }
}
