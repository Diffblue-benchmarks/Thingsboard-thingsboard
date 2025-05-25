package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
   * Test {@link TaskProcessingFailureTriggerProcessor#matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig)} with {@code TaskProcessingFailureTrigger}, {@code TaskProcessingFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test: {@link TaskProcessingFailureTriggerProcessor#matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig) with 'TaskProcessingFailureTrigger', 'TaskProcessingFailureNotificationRuleTriggerConfig'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean TaskProcessingFailureTriggerProcessor.matchesFilter(TaskProcessingFailureTrigger, TaskProcessingFailureNotificationRuleTriggerConfig)"})
  void testMatchesFilterWithTaskProcessingFailureTriggerTaskProcessingFailureNotificationRuleTriggerConfig() {
    // Arrange, Act and Assert
    assertTrue(taskProcessingFailureTriggerProcessor.matchesFilter(null, null));
  }

  /**
   * Test {@link TaskProcessingFailureTriggerProcessor#constructNotificationInfo(TaskProcessingFailureTrigger)} with {@code TaskProcessingFailureTrigger}.
   * <p>
   * Method under test: {@link TaskProcessingFailureTriggerProcessor#constructNotificationInfo(TaskProcessingFailureTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(TaskProcessingFailureTrigger) with 'TaskProcessingFailureTrigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TaskProcessingFailureNotificationInfo TaskProcessingFailureTriggerProcessor.constructNotificationInfo(TaskProcessingFailureTrigger)"})
  void testConstructNotificationInfoWithTaskProcessingFailureTrigger() {
    // Arrange
    EntitiesDeletionHousekeeperTask task = new EntitiesDeletionHousekeeperTask();
    task.setEntityType(EntityType.TENANT);
    TaskProcessingFailureTrigger trigger = TaskProcessingFailureTrigger.builder()
        .attempt(1)
        .error(null)
        .task(task)
        .build();

    // Act
    TaskProcessingFailureNotificationInfo actualConstructNotificationInfoResult = taskProcessingFailureTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
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
    assertEquals(1, actualConstructNotificationInfoResult.getAttempt());
  }

  /**
   * Test {@link TaskProcessingFailureTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link TaskProcessingFailureTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType TaskProcessingFailureTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        (new TaskProcessingFailureTriggerProcessor()).getTriggerType());
  }
}
