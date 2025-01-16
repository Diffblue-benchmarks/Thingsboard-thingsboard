package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.TaskProcessingFailureNotificationRuleTriggerConfig.TaskProcessingFailureNotificationRuleTriggerConfigBuilder;

class TaskProcessingFailureNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)},
   * and {@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)},
   * and {@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)},
   * and {@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TaskProcessingFailureNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test TaskProcessingFailureNotificationRuleTriggerConfigBuilder
   * {@link TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Method under test:
   * {@link TaskProcessingFailureNotificationRuleTriggerConfig.TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}
   */
  @Test
  @DisplayName("Test TaskProcessingFailureNotificationRuleTriggerConfigBuilder build()")
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
