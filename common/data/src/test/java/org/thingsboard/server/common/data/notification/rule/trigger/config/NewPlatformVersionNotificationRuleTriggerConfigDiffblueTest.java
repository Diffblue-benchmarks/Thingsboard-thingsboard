package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NewPlatformVersionNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)},
   * and {@link NewPlatformVersionNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NewPlatformVersionNotificationRuleTriggerConfig newPlatformVersionNotificationRuleTriggerConfig = new NewPlatformVersionNotificationRuleTriggerConfig();
    NewPlatformVersionNotificationRuleTriggerConfig newPlatformVersionNotificationRuleTriggerConfig2 = new NewPlatformVersionNotificationRuleTriggerConfig();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationRuleTriggerConfig, newPlatformVersionNotificationRuleTriggerConfig2);
    int expectedHashCodeResult = newPlatformVersionNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, newPlatformVersionNotificationRuleTriggerConfig2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)},
   * and {@link NewPlatformVersionNotificationRuleTriggerConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NewPlatformVersionNotificationRuleTriggerConfig newPlatformVersionNotificationRuleTriggerConfig = new NewPlatformVersionNotificationRuleTriggerConfig();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationRuleTriggerConfig, newPlatformVersionNotificationRuleTriggerConfig);
    int expectedHashCodeResult = newPlatformVersionNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, newPlatformVersionNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NewPlatformVersionNotificationRuleTriggerConfig(), 1);
  }

  /**
   * Test {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NewPlatformVersionNotificationRuleTriggerConfig(), null);
  }

  /**
   * Test {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NewPlatformVersionNotificationRuleTriggerConfig(),
        "Different type to NewPlatformVersionNotificationRuleTriggerConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NewPlatformVersionNotificationRuleTriggerConfig}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NewPlatformVersionNotificationRuleTriggerConfig actualNewPlatformVersionNotificationRuleTriggerConfig = new NewPlatformVersionNotificationRuleTriggerConfig();
    String actualToStringResult = actualNewPlatformVersionNotificationRuleTriggerConfig.toString();

    // Assert
    assertEquals("NewPlatformVersionNotificationRuleTriggerConfig()", actualToStringResult);
    assertEquals(NotificationRuleTriggerType.NEW_PLATFORM_VERSION,
        actualNewPlatformVersionNotificationRuleTriggerConfig.getTriggerType());
  }
}
