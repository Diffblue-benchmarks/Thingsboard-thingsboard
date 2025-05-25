package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
  private TaskProcessingFailureNotificationRuleTriggerConfigBuilder taskProcessingFailureNotificationRuleTriggerConfigBuilder;

  /**
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
      "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"})
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
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}, and {@link TaskProcessingFailureNotificationRuleTriggerConfig#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
      "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"})
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
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
      "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TaskProcessingFailureNotificationRuleTriggerConfig buildResult = TaskProcessingFailureNotificationRuleTriggerConfig
        .builder()
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TaskProcessingFailureNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TaskProcessingFailureNotificationRuleTriggerConfig.equals(Object)",
      "int TaskProcessingFailureNotificationRuleTriggerConfig.hashCode()"})
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
   *   <li>default or parameterless constructor of {@link TaskProcessingFailureNotificationRuleTriggerConfig}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#toString()}
   *   <li>{@link TaskProcessingFailureNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaskProcessingFailureNotificationRuleTriggerConfig.<init>()",
      "NotificationRuleTriggerType TaskProcessingFailureNotificationRuleTriggerConfig.getTriggerType()",
      "String TaskProcessingFailureNotificationRuleTriggerConfig.toString()"})
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
   * Test TaskProcessingFailureNotificationRuleTriggerConfigBuilder {@link TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}.
   * <p>
   * Method under test: {@link TaskProcessingFailureNotificationRuleTriggerConfigBuilder#build()}
   */
  @Test
  @DisplayName("Test TaskProcessingFailureNotificationRuleTriggerConfigBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TaskProcessingFailureNotificationRuleTriggerConfigBuilder.<init>()",
      "TaskProcessingFailureNotificationRuleTriggerConfig TaskProcessingFailureNotificationRuleTriggerConfigBuilder.build()",
      "String TaskProcessingFailureNotificationRuleTriggerConfigBuilder.toString()"})
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
