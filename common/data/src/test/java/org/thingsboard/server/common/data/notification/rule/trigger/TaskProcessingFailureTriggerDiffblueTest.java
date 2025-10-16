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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.TaskProcessingFailureTrigger.TaskProcessingFailureTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {TaskProcessingFailureTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class TaskProcessingFailureTriggerDiffblueTest {
  @Autowired private TaskProcessingFailureTriggerBuilder taskProcessingFailureTriggerBuilder;

  /**
   * Test {@link TaskProcessingFailureTrigger#getTenantId()}.
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TaskProcessingFailureTrigger.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);
    when(task.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    TenantId actualTenantId =
        new TaskProcessingFailureTrigger(task, 1, new Throwable()).getTenantId();

    // Assert
    verify(task).getTenantId();
    assertSame(TenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#getOriginatorEntityId()}.
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#getOriginatorEntityId()}
   */
  @Test
  @DisplayName("Test getOriginatorEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityId TaskProcessingFailureTrigger.getOriginatorEntityId()"})
  void testGetOriginatorEntityId() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);
    when(task.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    EntityId actualOriginatorEntityId =
        new TaskProcessingFailureTrigger(task, 1, new Throwable()).getOriginatorEntityId();

    // Assert
    verify(task).getEntityId();
    assertSame(((TenantId) actualOriginatorEntityId).SYS_TENANT_ID, actualOriginatorEntityId);
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#deduplicate()}.
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TaskProcessingFailureTrigger.deduplicate()"})
  void testDeduplicate() {
    // Arrange
    HousekeeperTask task = mock(HousekeeperTask.class);

    // Act and Assert
    assertFalse(new TaskProcessingFailureTrigger(task, 1, new Throwable()).deduplicate());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}, and {@link
   * TaskProcessingFailureTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureTrigger#equals(Object)}
   *   <li>{@link TaskProcessingFailureTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        TaskProcessingFailureTrigger.builder().attempt(1).error(null).task(null).build();
    TaskProcessingFailureTrigger taskProcessingFailureTrigger2 =
        TaskProcessingFailureTrigger.builder().attempt(1).error(null).task(null).build();

    // Act and Assert
    assertEquals(taskProcessingFailureTrigger, taskProcessingFailureTrigger2);
    assertEquals(taskProcessingFailureTrigger.hashCode(), taskProcessingFailureTrigger2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}, and {@link
   * TaskProcessingFailureTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureTrigger#equals(Object)}
   *   <li>{@link TaskProcessingFailureTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        attemptResult.error(new Throwable()).task(null).build();

    // Act and Assert
    assertEquals(taskProcessingFailureTrigger, taskProcessingFailureTrigger);
    int expectedHashCodeResult = taskProcessingFailureTrigger.hashCode();
    assertEquals(expectedHashCodeResult, taskProcessingFailureTrigger.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        attemptResult.error(new Throwable()).task(null).build();

    TaskProcessingFailureTriggerBuilder attemptResult2 =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureTrigger, attemptResult2.error(new Throwable()).task(null).build());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(3);
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        attemptResult.error(new Throwable()).task(null).build();

    TaskProcessingFailureTriggerBuilder attemptResult2 =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureTrigger, attemptResult2.error(new Throwable()).task(null).build());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        TaskProcessingFailureTrigger.builder().attempt(1).error(null).task(null).build();

    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureTrigger, attemptResult.error(new Throwable()).task(null).build());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        attemptResult.error(new Throwable()).task(mock(HousekeeperTask.class)).build();

    TaskProcessingFailureTriggerBuilder attemptResult2 =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureTrigger, attemptResult2.error(new Throwable()).task(null).build());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);
    TaskProcessingFailureTrigger taskProcessingFailureTrigger =
        attemptResult.error(new Throwable()).task(null).build();

    TaskProcessingFailureTriggerBuilder attemptResult2 =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(
        taskProcessingFailureTrigger,
        attemptResult2.error(new Throwable()).task(mock(HousekeeperTask.class)).build());
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(attemptResult.error(new Throwable()).task(null).build(), null);
  }

  /**
   * Test {@link TaskProcessingFailureTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureTrigger.equals(Object)",
    "int TaskProcessingFailureTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureTriggerBuilder attemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);

    // Act and Assert
    assertNotEquals(
        attemptResult.error(new Throwable()).task(null).build(),
        "Different type to TaskProcessingFailureTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureTrigger#TaskProcessingFailureTrigger(HousekeeperTask, int,
   *       Throwable)}
   *   <li>{@link TaskProcessingFailureTrigger#toString()}
   *   <li>{@link TaskProcessingFailureTrigger#getAttempt()}
   *   <li>{@link TaskProcessingFailureTrigger#getError()}
   *   <li>{@link TaskProcessingFailureTrigger#getTask()}
   *   <li>{@link TaskProcessingFailureTrigger#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureTrigger.<init>(HousekeeperTask, int, Throwable)",
    "int TaskProcessingFailureTrigger.getAttempt()",
    "Throwable TaskProcessingFailureTrigger.getError()",
    "HousekeeperTask TaskProcessingFailureTrigger.getTask()",
    "NotificationRuleTriggerType TaskProcessingFailureTrigger.getType()",
    "String TaskProcessingFailureTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    TaskProcessingFailureTrigger actualTaskProcessingFailureTrigger =
        new TaskProcessingFailureTrigger(null, 1, error);
    String actualToStringResult = actualTaskProcessingFailureTrigger.toString();
    int actualAttempt = actualTaskProcessingFailureTrigger.getAttempt();
    Throwable actualError = actualTaskProcessingFailureTrigger.getError();
    HousekeeperTask actualTask = actualTaskProcessingFailureTrigger.getTask();

    // Assert
    assertEquals(
        "TaskProcessingFailureTrigger(task=null, attempt=1, error=java.lang.Throwable)",
        actualToStringResult);
    assertNull(actualTask);
    assertEquals(1, actualAttempt);
    assertEquals(
        NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        actualTaskProcessingFailureTrigger.getType());
    assertSame(error, actualError);
  }

  /**
   * Test TaskProcessingFailureTriggerBuilder {@link TaskProcessingFailureTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureTriggerBuilder#build()}
   *   <li>{@link TaskProcessingFailureTriggerBuilder#attempt(int)}
   *   <li>{@link TaskProcessingFailureTriggerBuilder#error(Throwable)}
   *   <li>{@link TaskProcessingFailureTriggerBuilder#task(HousekeeperTask)}
   * </ul>
   */
  @Test
  @DisplayName("Test TaskProcessingFailureTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureTriggerBuilder.<init>()",
    "TaskProcessingFailureTriggerBuilder TaskProcessingFailureTriggerBuilder.attempt(int)",
    "TaskProcessingFailureTrigger TaskProcessingFailureTriggerBuilder.build()",
    "TaskProcessingFailureTriggerBuilder TaskProcessingFailureTriggerBuilder.error(Throwable)",
    "TaskProcessingFailureTriggerBuilder TaskProcessingFailureTriggerBuilder.task(HousekeeperTask)",
    "String TaskProcessingFailureTriggerBuilder.toString()"
  })
  void testTaskProcessingFailureTriggerBuilderBuild() {
    // Arrange and Act
    TaskProcessingFailureTriggerBuilder actualAttemptResult =
        TaskProcessingFailureTrigger.builder().attempt(1);
    Throwable error = new Throwable();
    TaskProcessingFailureTrigger actualTaskProcessingFailureTrigger =
        actualAttemptResult.error(error).task(null).build();

    // Assert
    assertNull(actualTaskProcessingFailureTrigger.getTask());
    assertEquals(0L, actualTaskProcessingFailureTrigger.getDefaultDeduplicationDuration());
    assertEquals(1, actualTaskProcessingFailureTrigger.getAttempt());
    assertEquals(
        NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        actualTaskProcessingFailureTrigger.getType());
    assertFalse(actualTaskProcessingFailureTrigger.deduplicate());
    assertSame(error, actualTaskProcessingFailureTrigger.getError());
  }
}
