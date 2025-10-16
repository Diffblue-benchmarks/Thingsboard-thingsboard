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
package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.trigger.config.TaskProcessingFailureNotificationRuleTriggerConfig.TaskProcessingFailureNotificationRuleTriggerConfigBuilder;

@ContextConfiguration(classes = {TaskProcessingFailureNotificationRuleTriggerConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class TaskProcessingFailureNotificationRuleTriggerConfigDiffblueTest {
  @Autowired
  private TaskProcessingFailureNotificationRuleTriggerConfigBuilder
      taskProcessingFailureNotificationRuleTriggerConfigBuilder;

  /**
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
    "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig
        taskProcessingFailureNotificationRuleTriggerConfig =
            TaskProcessingFailureNotificationRuleTriggerConfig.builder().build();
    TaskProcessingFailureNotificationRuleTriggerConfig
        taskProcessingFailureNotificationRuleTriggerConfig2 =
            TaskProcessingFailureNotificationRuleTriggerConfig.builder().build();

    // Act and Assert
    assertEquals(
        taskProcessingFailureNotificationRuleTriggerConfig,
        taskProcessingFailureNotificationRuleTriggerConfig2);
    assertEquals(
        taskProcessingFailureNotificationRuleTriggerConfig.hashCode(),
        taskProcessingFailureNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link
   * TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
    "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig
        taskProcessingFailureNotificationRuleTriggerConfig =
            TaskProcessingFailureNotificationRuleTriggerConfig.builder().build();

    // Act and Assert
    assertEquals(
        taskProcessingFailureNotificationRuleTriggerConfig,
        taskProcessingFailureNotificationRuleTriggerConfig);
    int expectedHashCodeResult = taskProcessingFailureNotificationRuleTriggerConfig.hashCode();
    assertEquals(
        expectedHashCodeResult, taskProcessingFailureNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
    "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TaskProcessingFailureNotificationRuleTriggerConfig.builder().build(), null);
  }

  /**
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
    "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        TaskProcessingFailureNotificationRuleTriggerConfig.builder().build(),
        "Different type to TaskProcessingFailureNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       TaskProcessingFailureNotificationRuleTriggerConfig}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#toString()}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureNotificationRuleTriggerConfig.<init>()",
    "NotificationRuleTriggerType TaskProcessingFailureNotificationRuleTriggerConfig.getTriggerType()",
    "String TaskProcessingFailureNotificationRuleTriggerConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TaskProcessingFailureNotificationRuleTriggerConfig
        actualTaskProcessingFailureNotificationRuleTriggerConfig =
            new TaskProcessingFailureNotificationRuleTriggerConfig();
    String actualToStringResult =
        actualTaskProcessingFailureNotificationRuleTriggerConfig.toString();

    // Assert
    assertEquals("TaskProcessingFailureNotificationRuleTriggerConfig()", actualToStringResult);
    assertEquals(
        NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        actualTaskProcessingFailureNotificationRuleTriggerConfig.getTriggerType());
  }

  /**
   * Test TaskProcessingFailureNotificationRuleTriggerConfigBuilder {@link
   * TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}.
   *
   * <p>Method under test: {@link TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}
   */
  @Test
  @DisplayName("Test TaskProcessingFailureNotificationRuleTriggerConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TaskProcessingFailureNotificationRuleTriggerConfigBuilder.<init>()",
    "TaskProcessingFailureNotificationRuleTriggerConfig TaskProcessingFailureNotificationRuleTriggerConfigBuilder.build()",
    "String TaskProcessingFailureNotificationRuleTriggerConfigBuilder.toString()"
  })
  void testTaskProcessingFailureNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    TaskProcessingFailureNotificationRuleTriggerConfig
        actualTaskProcessingFailureNotificationRuleTriggerConfig =
            TaskProcessingFailureNotificationRuleTriggerConfig.builder().build();

    // Assert
    assertEquals(
        "#", actualTaskProcessingFailureNotificationRuleTriggerConfig.getDeduplicationKey());
    assertEquals(
        NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        actualTaskProcessingFailureNotificationRuleTriggerConfig.getTriggerType());
  }
}
