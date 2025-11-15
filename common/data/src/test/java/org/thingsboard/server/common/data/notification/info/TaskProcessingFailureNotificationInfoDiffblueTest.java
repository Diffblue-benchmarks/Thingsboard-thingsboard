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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TaskProcessingFailureNotificationInfoDiffblueTest {
  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
    // Arrange
    TaskProcessingFailureNotificationInfo buildResult = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(7, actualTemplateData.size());
    assertEquals("1", actualTemplateData.get("attempt"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("entityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("An error occurred", actualTemplateData.get("error"));
    assertEquals("Task Description", actualTemplateData.get("taskDescription"));
    assertEquals("Tenant", actualTemplateData.get("entityType"));
    assertEquals("attributes deletion", actualTemplateData.get("taskType"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo buildResult = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TaskProcessingFailureNotificationInfo buildResult2 = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationInfo#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo buildResult = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder taskProcessingFailureNotificationInfoBuilder = mock(
        TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder.class);
    when(taskProcessingFailureNotificationInfoBuilder.attempt(anyInt()))
        .thenReturn(TaskProcessingFailureNotificationInfo.builder());
    TaskProcessingFailureNotificationInfo buildResult = taskProcessingFailureNotificationInfoBuilder.attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();
    TaskProcessingFailureNotificationInfo buildResult2 = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo buildResult = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationInfo buildResult = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TaskProcessingFailureNotificationInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo#TaskProcessingFailureNotificationInfo()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setAttempt(int)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setEntityId(EntityId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setError(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTaskDescription(String)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo#setTaskType(HousekeeperTaskType)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#toString()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAffectedTenantId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAttempt()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getEntityId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getError()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskDescription()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskType()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TaskProcessingFailureNotificationInfo actualTaskProcessingFailureNotificationInfo = new TaskProcessingFailureNotificationInfo();
    actualTaskProcessingFailureNotificationInfo.setAttempt(1);
    actualTaskProcessingFailureNotificationInfo.setEntityId(TenantId.SYS_TENANT_ID);
    actualTaskProcessingFailureNotificationInfo.setError("An error occurred");
    actualTaskProcessingFailureNotificationInfo.setTaskDescription("Task Description");
    actualTaskProcessingFailureNotificationInfo.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    actualTaskProcessingFailureNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualTaskProcessingFailureNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualTaskProcessingFailureNotificationInfo.getAffectedTenantId();
    int actualAttempt = actualTaskProcessingFailureNotificationInfo.getAttempt();
    EntityId actualEntityId = actualTaskProcessingFailureNotificationInfo.getEntityId();
    String actualError = actualTaskProcessingFailureNotificationInfo.getError();
    String actualTaskDescription = actualTaskProcessingFailureNotificationInfo.getTaskDescription();
    HousekeeperTaskType actualTaskType = actualTaskProcessingFailureNotificationInfo.getTaskType();
    TenantId actualTenantId = actualTaskProcessingFailureNotificationInfo.getTenantId();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Task Description", actualTaskDescription);
    assertEquals(
        "TaskProcessingFailureNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000"
            + "-1dd2-11b2-8080-808080808080, taskType=DELETE_ATTRIBUTES, taskDescription=Task Description, error=An"
            + " error occurred, attempt=1)",
        actualToStringResult);
    assertEquals(1, actualAttempt);
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo#TaskProcessingFailureNotificationInfo(TenantId, EntityId, HousekeeperTaskType, String, String, int)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setAttempt(int)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setEntityId(EntityId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setError(String)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTaskDescription(String)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo#setTaskType(HousekeeperTaskType)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link TaskProcessingFailureNotificationInfo#toString()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAffectedTenantId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getAttempt()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getEntityId()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getError()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskDescription()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTaskType()}
   *   <li>{@link TaskProcessingFailureNotificationInfo#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    TaskProcessingFailureNotificationInfo actualTaskProcessingFailureNotificationInfo = new TaskProcessingFailureNotificationInfo(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, HousekeeperTaskType.DELETE_ATTRIBUTES, "Task Description",
        "An error occurred", 1);
    actualTaskProcessingFailureNotificationInfo.setAttempt(1);
    actualTaskProcessingFailureNotificationInfo.setEntityId(TenantId.SYS_TENANT_ID);
    actualTaskProcessingFailureNotificationInfo.setError("An error occurred");
    actualTaskProcessingFailureNotificationInfo.setTaskDescription("Task Description");
    actualTaskProcessingFailureNotificationInfo.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    actualTaskProcessingFailureNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualTaskProcessingFailureNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualTaskProcessingFailureNotificationInfo.getAffectedTenantId();
    int actualAttempt = actualTaskProcessingFailureNotificationInfo.getAttempt();
    EntityId actualEntityId = actualTaskProcessingFailureNotificationInfo.getEntityId();
    String actualError = actualTaskProcessingFailureNotificationInfo.getError();
    String actualTaskDescription = actualTaskProcessingFailureNotificationInfo.getTaskDescription();
    HousekeeperTaskType actualTaskType = actualTaskProcessingFailureNotificationInfo.getTaskType();
    TenantId actualTenantId = actualTaskProcessingFailureNotificationInfo.getTenantId();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Task Description", actualTaskDescription);
    assertEquals(
        "TaskProcessingFailureNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000"
            + "-1dd2-11b2-8080-808080808080, taskType=DELETE_ATTRIBUTES, taskDescription=Task Description, error=An"
            + " error occurred, attempt=1)",
        actualToStringResult);
    assertEquals(1, actualAttempt);
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#build()}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#attempt(int)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#entityId(EntityId)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#error(String)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#taskDescription(String)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#taskType(HousekeeperTaskType)}
   *   <li>
   * {@link TaskProcessingFailureNotificationInfo.TaskProcessingFailureNotificationInfoBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  void testTaskProcessingFailureNotificationInfoBuilderBuild() {
    // Arrange and Act
    TaskProcessingFailureNotificationInfo actualBuildResult = TaskProcessingFailureNotificationInfo.builder()
        .attempt(1)
        .entityId(TenantId.SYS_TENANT_ID)
        .error("An error occurred")
        .taskDescription("Task Description")
        .taskType(HousekeeperTaskType.DELETE_ATTRIBUTES)
        .tenantId(TenantId.SYS_TENANT_ID)
        .build();

    // Assert
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(7, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("entityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    TenantId affectedTenantId = actualBuildResult.getAffectedTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", affectedTenantId.getId().toString());
    assertEquals("An error occurred", templateData.get("error"));
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Task Description", templateData.get("taskDescription"));
    assertEquals("Task Description", actualBuildResult.getTaskDescription());
    assertEquals("Tenant", templateData.get("entityType"));
    assertEquals("attributes deletion", templateData.get("taskType"));
    assertNull(actualBuildResult.getAffectedCustomerId());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getStateEntityId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(1, actualBuildResult.getAttempt());
    assertEquals(EntityType.TENANT, affectedTenantId.getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualBuildResult.getTaskType());
    assertTrue(affectedTenantId.isNullUid());
    assertTrue(affectedTenantId.isSysTenantId());
  }
}
