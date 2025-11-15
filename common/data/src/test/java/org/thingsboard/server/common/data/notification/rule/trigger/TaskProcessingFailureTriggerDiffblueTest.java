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
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class TaskProcessingFailureTriggerDiffblueTest {
  /**
   * Method under test: {@link TaskProcessingFailureTrigger#getTenantId()}
   */
  @Test
  void testGetTenantId() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);
    when(task.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    TenantId actualTenantId = (new TaskProcessingFailureTrigger(task, 1, new Throwable())).getTenantId();

    // Assert
    verify(task).getTenantId();
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureTrigger#getOriginatorEntityId()}
   */
  @Test
  void testGetOriginatorEntityId() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);
    when(task.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    EntityId actualOriginatorEntityId = (new TaskProcessingFailureTrigger(task, 1, new Throwable()))
        .getOriginatorEntityId();

    // Assert
    verify(task).getEntityId();
    assertSame(((TenantId) actualOriginatorEntityId).SYS_TENANT_ID, actualOriginatorEntityId);
  }

  /**
   * Method under test: {@link TaskProcessingFailureTrigger#deduplicate()}
   */
  @Test
  void testDeduplicate() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);

    // Act and Assert
    assertFalse((new TaskProcessingFailureTrigger(task, 1, new Throwable())).deduplicate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureTrigger#equals(Object)}
   *   <li>{@link TaskProcessingFailureTrigger#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    TaskProcessingFailureTrigger buildResult = attemptResult.error(new Throwable()).task(null).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    TaskProcessingFailureTrigger buildResult = attemptResult.error(new Throwable()).task(null).build();
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult2 = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    TaskProcessingFailureTrigger buildResult2 = attemptResult2.error(new Throwable()).task(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder taskProcessingFailureTriggerBuilder = mock(
        TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder.class);
    when(taskProcessingFailureTriggerBuilder.attempt(anyInt())).thenReturn(TaskProcessingFailureTrigger.builder());
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = taskProcessingFailureTriggerBuilder
        .attempt(1);
    TaskProcessingFailureTrigger buildResult = attemptResult.error(new Throwable()).task(null).build();
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult2 = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    TaskProcessingFailureTrigger buildResult2 = attemptResult2.error(new Throwable()).task(null).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    TaskProcessingFailureTrigger buildResult = attemptResult.error(new Throwable()).task(null).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    TaskProcessingFailureTrigger buildResult = attemptResult.error(new Throwable()).task(null).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TaskProcessingFailureTrigger");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TaskProcessingFailureTrigger#TaskProcessingFailureTrigger(HousekeeperTask, int, Throwable)}
   *   <li>{@link TaskProcessingFailureTrigger#toString()}
   *   <li>{@link TaskProcessingFailureTrigger#getAttempt()}
   *   <li>{@link TaskProcessingFailureTrigger#getError()}
   *   <li>{@link TaskProcessingFailureTrigger#getTask()}
   *   <li>{@link TaskProcessingFailureTrigger#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    TaskProcessingFailureTrigger actualTaskProcessingFailureTrigger = new TaskProcessingFailureTrigger(null, 1, error);
    String actualToStringResult = actualTaskProcessingFailureTrigger.toString();
    int actualAttempt = actualTaskProcessingFailureTrigger.getAttempt();
    Throwable actualError = actualTaskProcessingFailureTrigger.getError();
    HousekeeperTask actualTask = actualTaskProcessingFailureTrigger.getTask();

    // Assert
    assertEquals("TaskProcessingFailureTrigger(task=null, attempt=1, error=java.lang.Throwable)", actualToStringResult);
    assertNull(actualTask);
    assertEquals(1, actualAttempt);
    assertEquals(NotificationRuleTriggerType.TASK_PROCESSING_FAILURE, actualTaskProcessingFailureTrigger.getType());
    assertSame(error, actualError);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder#build()}
   *   <li>
   * {@link TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder#attempt(int)}
   *   <li>
   * {@link TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder#error(Throwable)}
   *   <li>
   * {@link TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder#task(HousekeeperTask)}
   * </ul>
   */
  @Test
  void testTaskProcessingFailureTriggerBuilderBuild() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = TaskProcessingFailureTrigger
        .builder()
        .attempt(1);
    Throwable error = new Throwable();

    // Act
    TaskProcessingFailureTrigger actualBuildResult = attemptResult.error(error).task(null).build();

    // Assert
    assertNull(actualBuildResult.getTask());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(1, actualBuildResult.getAttempt());
    assertEquals(NotificationRuleTriggerType.TASK_PROCESSING_FAILURE, actualBuildResult.getType());
    assertFalse(actualBuildResult.deduplicate());
    assertSame(error, actualBuildResult.getError());
  }
}
