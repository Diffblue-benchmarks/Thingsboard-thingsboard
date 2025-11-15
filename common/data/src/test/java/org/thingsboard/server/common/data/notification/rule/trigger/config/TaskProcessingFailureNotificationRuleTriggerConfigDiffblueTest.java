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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class TaskProcessingFailureNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult2 = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig.TaskProcessingFailureNotificationRuleTriggerConfigBuilder taskProcessingFailureNotificationRuleTriggerConfigBuilder = mock(
        TaskProcessingFailureNotificationRuleTriggerConfig.TaskProcessingFailureNotificationRuleTriggerConfigBuilder.class);
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();
    when(taskProcessingFailureNotificationRuleTriggerConfigBuilder.build()).thenReturn(buildResult);
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult2 = taskProcessingFailureNotificationRuleTriggerConfigBuilder
        .build();
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult3 = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertEquals(buildResult2, buildResult3);
    int expectedHashCodeResult = buildResult2.hashCode();
    assertEquals(expectedHashCodeResult, buildResult3.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TaskProcessingFailureNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#toString()}
   *   <li>
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TaskProcessingFailureNotificationRuleTriggerConfig actualTaskProcessingFailureNotificationRuleTriggerConfig = new TaskProcessingFailureNotificationRuleTriggerConfig();
    String actualToStringResult = actualTaskProcessingFailureNotificationRuleTriggerConfig.toString();

    // Assert
    assertEquals("TaskProcessingFailureNotificationRuleTriggerConfig()", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.TASK_PROCESSING_FAILURE,
        actualTaskProcessingFailureNotificationRuleTriggerConfig.getTriggerType());
  }

  /**
   * Method under test:
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig.TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}
   */
  @Test
  void testTaskProcessingFailureNotificationRuleTriggerConfigBuilderBuild() {
    // Arrange and Act
    TaskProcessingFailureNotificationRuleTriggerConfig actualBuildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Assert
    assertEquals("#", actualBuildResult.getDeduplicationKey());
    assertEquals(NotificationRuleTriggerType.TASK_PROCESSING_FAILURE, actualBuildResult.getTriggerType());
  }
}
