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
import org.junit.jupiter.api.Test;

class NewPlatformVersionNotificationRuleTriggerConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NewPlatformVersionNotificationRuleTriggerConfig newPlatformVersionNotificationRuleTriggerConfig = new NewPlatformVersionNotificationRuleTriggerConfig();

    // Act and Assert
    assertEquals(newPlatformVersionNotificationRuleTriggerConfig, newPlatformVersionNotificationRuleTriggerConfig);
    int expectedHashCodeResult = newPlatformVersionNotificationRuleTriggerConfig.hashCode();
    assertEquals(expectedHashCodeResult, newPlatformVersionNotificationRuleTriggerConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NewPlatformVersionNotificationRuleTriggerConfig(), 1);
  }

  /**
   * Method under test:
   * {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NewPlatformVersionNotificationRuleTriggerConfig(), null);
  }

  /**
   * Method under test:
   * {@link NewPlatformVersionNotificationRuleTriggerConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NewPlatformVersionNotificationRuleTriggerConfig(),
        "Different type to NewPlatformVersionNotificationRuleTriggerConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link NewPlatformVersionNotificationRuleTriggerConfig}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#toString()}
   *   <li>{@link NewPlatformVersionNotificationRuleTriggerConfig#getTriggerType()}
   * </ul>
   */
  @Test
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
