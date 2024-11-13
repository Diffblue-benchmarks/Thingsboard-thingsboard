package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.housekeeper.EntitiesDeletionHousekeeperTask;
import org.thingsboard.server.common.data.notification.info.TaskProcessingFailureNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.TaskProcessingFailureTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.TaskProcessingFailureNotificationRuleTriggerConfig;

@ContextConfiguration(classes = {TaskProcessingFailureTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class TaskProcessingFailureTriggerProcessorDiffblueTest {
  @Autowired
  private TaskProcessingFailureTriggerProcessor taskProcessingFailureTriggerProcessor;

  /**
   * Test
   * {@link TaskProcessingFailureTriggerProcessor#matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig)}
   * with {@code TaskProcessingFailureTrigger},
   * {@code TaskProcessingFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureTriggerProcessor#matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig) with 'TaskProcessingFailureTrigger', 'TaskProcessingFailureNotificationRuleTriggerConfig'")
  void testMatchesFilterWithTaskProcessingFailureTriggerTaskProcessingFailureNotificationRuleTriggerConfig() {
    // Arrange, Act and Assert
    assertTrue(taskProcessingFailureTriggerProcessor.matchesFilter(null, null));
    assertTrue(taskProcessingFailureTriggerProcessor.matchesFilter(mock(TaskProcessingFailureTrigger.class), null));
  }

  /**
   * Test
   * {@link TaskProcessingFailureTriggerProcessor#constructNotificationInfo(TaskProcessingFailureTrigger)}
   * with {@code TaskProcessingFailureTrigger}.
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureTriggerProcessor#constructNotificationInfo(TaskProcessingFailureTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(TaskProcessingFailureTrigger) with 'TaskProcessingFailureTrigger'")
  void testConstructNotificationInfoWithTaskProcessingFailureTrigger() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder taskProcessingFailureTriggerBuilder = mock(
        TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder.class);
    when(taskProcessingFailureTriggerBuilder.attempt(anyInt())).thenReturn(TaskProcessingFailureTrigger.builder());
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = taskProcessingFailureTriggerBuilder
        .attempt(1);
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder errorResult = attemptResult.error(new Throwable());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.TENANT);
    TaskProcessingFailureTrigger trigger = errorResult.task(task).build();

    // Act
    TaskProcessingFailureNotificationInfo actualConstructNotificationInfoResult = taskProcessingFailureTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(taskProcessingFailureTriggerBuilder).attempt(eq(1));
    assertEquals("tenants deletion (null)", actualConstructNotificationInfoResult.getTaskDescription());
    assertNull(actualConstructNotificationInfoResult.getTaskType());
    assertNull(actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(actualConstructNotificationInfoResult.getTenantId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    assertEquals(0, actualConstructNotificationInfoResult.getAttempt());
  }

  /**
   * Test
   * {@link TaskProcessingFailureTriggerProcessor#constructNotificationInfo(TaskProcessingFailureTrigger)}
   * with {@code TaskProcessingFailureTrigger}.
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureTriggerProcessor#constructNotificationInfo(TaskProcessingFailureTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(TaskProcessingFailureTrigger) with 'TaskProcessingFailureTrigger'")
  void testConstructNotificationInfoWithTaskProcessingFailureTrigger2() {
    // Arrange
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder taskProcessingFailureTriggerBuilder = mock(
        TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder.class);
    when(taskProcessingFailureTriggerBuilder.error(Mockito.<Throwable>any()))
        .thenReturn(TaskProcessingFailureTrigger.builder());
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder taskProcessingFailureTriggerBuilder2 = mock(
        TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder.class);
    when(taskProcessingFailureTriggerBuilder2.attempt(anyInt())).thenReturn(taskProcessingFailureTriggerBuilder);
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder attemptResult = taskProcessingFailureTriggerBuilder2
        .attempt(1);
    TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder errorResult = attemptResult.error(new Throwable());

    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.TENANT);
    TaskProcessingFailureTrigger trigger = errorResult.task(task).build();

    // Act
    TaskProcessingFailureNotificationInfo actualConstructNotificationInfoResult = taskProcessingFailureTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(taskProcessingFailureTriggerBuilder2).attempt(eq(1));
    verify(taskProcessingFailureTriggerBuilder).error(isA(Throwable.class));
    assertEquals("", actualConstructNotificationInfoResult.getError());
    assertEquals("tenants deletion (null)", actualConstructNotificationInfoResult.getTaskDescription());
    assertNull(actualConstructNotificationInfoResult.getTaskType());
    assertNull(actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedTenantId());
    assertNull(actualConstructNotificationInfoResult.getTenantId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    assertEquals(0, actualConstructNotificationInfoResult.getAttempt());
  }

  /**
   * Test {@link TaskProcessingFailureTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        (new TaskProcessingFailureTriggerProcessor()).getTriggerType());
  }
}
