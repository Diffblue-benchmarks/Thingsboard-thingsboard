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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class TaskProcessingFailureTriggerDiffblueTest {
  /**
   * Test {@link TaskProcessingFailureTrigger#getTenantId()}.
   * <p>
   * Method under test: {@link TaskProcessingFailureTrigger#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
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
   * Test {@link TaskProcessingFailureTrigger#getOriginatorEntityId()}.
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId()")
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
   * Test {@link TaskProcessingFailureTrigger#deduplicate()}.
   * <p>
   * Method under test: {@link TaskProcessingFailureTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate()")
  void testDeduplicate() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);

    // Act and Assert
    assertFalse((new TaskProcessingFailureTrigger(task, 1, new Throwable())).deduplicate());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}, and
   * {@link TaskProcessingFailureTrigger#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureTrigger#equals(Object)}
   *   <li>{@link TaskProcessingFailureTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test TaskProcessingFailureTriggerBuilder
   * {@link TaskProcessingFailureTriggerBuilder#build()}.
   * <p>
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
  @DisplayName("Test TaskProcessingFailureTriggerBuilder build()")
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
