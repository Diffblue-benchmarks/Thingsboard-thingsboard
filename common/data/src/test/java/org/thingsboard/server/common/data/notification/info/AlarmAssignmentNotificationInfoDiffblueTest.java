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

class AlarmAssignmentNotificationInfoDiffblueTest {
  /**
   * Test {@link AlarmAssignmentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code assigneeFirstName} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'assigneeFirstName' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmAssignmentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnAssigneeFirstNameIsEmptyString() {
    // Arrange
    AlarmAssignmentNotificationInfo alarmAssignmentNotificationInfo =
        new AlarmAssignmentNotificationInfo();
    alarmAssignmentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmAssignmentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_UNACK);
    alarmAssignmentNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmAssignmentNotificationInfo.setAssigneeFirstName("");
    alarmAssignmentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmAssignmentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(17, actualTemplateData.size());
    assertEquals("", actualTemplateData.get("assigneeFirstName"));
    assertNull(actualTemplateData.get("assigneeTitle"));
    assertNull(actualTemplateData.get("userLastName"));
    assertNull(actualTemplateData.get("userTitle"));
    assertTrue(actualTemplateData.containsKey("alarmOriginatorId"));
    assertTrue(actualTemplateData.containsKey("alarmSeverity"));
    assertTrue(actualTemplateData.containsKey("alarmStatus"));
    assertTrue(actualTemplateData.containsKey("alarmType"));
    assertTrue(actualTemplateData.containsKey("assigneeEmail"));
    assertTrue(actualTemplateData.containsKey("assigneeId"));
    assertTrue(actualTemplateData.containsKey("userFirstName"));
  }

  /**
   * Test {@link AlarmAssignmentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code assigneeTitle} is {@code Jane}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'assigneeTitle' is 'Jane'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmAssignmentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnAssigneeTitleIsJane() {
    // Arrange
    AlarmAssignmentNotificationInfo alarmAssignmentNotificationInfo =
        new AlarmAssignmentNotificationInfo();
    alarmAssignmentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmAssignmentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_UNACK);
    alarmAssignmentNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmAssignmentNotificationInfo.setAssigneeFirstName("Jane");
    alarmAssignmentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmAssignmentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(17, actualTemplateData.size());
    assertEquals("Jane", actualTemplateData.get("assigneeFirstName"));
    assertEquals("Jane", actualTemplateData.get("assigneeTitle"));
    assertNull(actualTemplateData.get("userLastName"));
    assertNull(actualTemplateData.get("userTitle"));
    assertTrue(actualTemplateData.containsKey("alarmOriginatorId"));
    assertTrue(actualTemplateData.containsKey("alarmSeverity"));
    assertTrue(actualTemplateData.containsKey("alarmStatus"));
    assertTrue(actualTemplateData.containsKey("alarmType"));
    assertTrue(actualTemplateData.containsKey("assigneeEmail"));
    assertTrue(actualTemplateData.containsKey("assigneeId"));
    assertTrue(actualTemplateData.containsKey("userFirstName"));
  }

  /**
   * Test {@link AlarmAssignmentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code assigneeTitle} is {@code Jane Doe}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'assigneeTitle' is 'Jane Doe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmAssignmentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnAssigneeTitleIsJaneDoe() {
    // Arrange
    AlarmAssignmentNotificationInfo alarmAssignmentNotificationInfo =
        new AlarmAssignmentNotificationInfo();
    alarmAssignmentNotificationInfo.setAssigneeLastName("Doe");
    alarmAssignmentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmAssignmentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_UNACK);
    alarmAssignmentNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmAssignmentNotificationInfo.setAssigneeFirstName("Jane");
    alarmAssignmentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmAssignmentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(17, actualTemplateData.size());
    assertEquals("Jane Doe", actualTemplateData.get("assigneeTitle"));
    assertEquals("Jane", actualTemplateData.get("assigneeFirstName"));
    assertNull(actualTemplateData.get("userLastName"));
    assertNull(actualTemplateData.get("userTitle"));
    assertTrue(actualTemplateData.containsKey("alarmOriginatorId"));
    assertTrue(actualTemplateData.containsKey("alarmSeverity"));
    assertTrue(actualTemplateData.containsKey("alarmStatus"));
    assertTrue(actualTemplateData.containsKey("alarmType"));
    assertTrue(actualTemplateData.containsKey("assigneeEmail"));
    assertTrue(actualTemplateData.containsKey("assigneeId"));
    assertTrue(actualTemplateData.containsKey("userFirstName"));
  }

  /**
   * Test {@link AlarmAssignmentNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code userLastName} is {@code Doe}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmAssignmentNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'userLastName' is 'Doe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map AlarmAssignmentNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnUserLastNameIsDoe() {
    // Arrange
    AlarmAssignmentNotificationInfo alarmAssignmentNotificationInfo =
        new AlarmAssignmentNotificationInfo();
    alarmAssignmentNotificationInfo.setUserLastName("Doe");
    alarmAssignmentNotificationInfo.setAlarmOriginator(TenantId.SYS_TENANT_ID);
    alarmAssignmentNotificationInfo.setAlarmStatus(AlarmStatus.ACTIVE_UNACK);
    alarmAssignmentNotificationInfo.setAlarmSeverity(AlarmSeverity.CRITICAL);
    alarmAssignmentNotificationInfo.setAssigneeFirstName("Jane");
    alarmAssignmentNotificationInfo.setAlarmId(UUID.randomUUID());

    // Act
    Map<String, String> actualTemplateData = alarmAssignmentNotificationInfo.getTemplateData();

    // Assert
    assertEquals(17, actualTemplateData.size());
    assertEquals("Doe", actualTemplateData.get("userLastName"));
    assertEquals("Doe", actualTemplateData.get("userTitle"));
    assertEquals("Jane", actualTemplateData.get("assigneeFirstName"));
    assertEquals("Jane", actualTemplateData.get("assigneeTitle"));
    assertTrue(actualTemplateData.containsKey("alarmOriginatorId"));
    assertTrue(actualTemplateData.containsKey("alarmSeverity"));
    assertTrue(actualTemplateData.containsKey("alarmStatus"));
    assertTrue(actualTemplateData.containsKey("alarmType"));
    assertTrue(actualTemplateData.containsKey("assigneeEmail"));
    assertTrue(actualTemplateData.containsKey("assigneeId"));
    assertTrue(actualTemplateData.containsKey("userFirstName"));
  }
}
