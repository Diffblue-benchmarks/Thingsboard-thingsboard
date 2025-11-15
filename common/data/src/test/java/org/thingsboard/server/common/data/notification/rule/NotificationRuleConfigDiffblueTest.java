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
package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class NotificationRuleConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleConfig#equals(Object)}
   *   <li>{@link NotificationRuleConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(notificationRuleConfig, notificationRuleConfig2);
    int expectedHashCodeResult = notificationRuleConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleConfig#equals(Object)}
   *   <li>{@link NotificationRuleConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription(null);

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription(null);

    // Act and Assert
    assertEquals(notificationRuleConfig, notificationRuleConfig2);
    int expectedHashCodeResult = notificationRuleConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleConfig#equals(Object)}
   *   <li>{@link NotificationRuleConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals(notificationRuleConfig, notificationRuleConfig);
    int expectedHashCodeResult = notificationRuleConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleConfig.hashCode());
  }

  /**
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("Description");

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, notificationRuleConfig2);
  }

  /**
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription(null);

    NotificationRuleConfig notificationRuleConfig2 = new NotificationRuleConfig();
    notificationRuleConfig2.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, notificationRuleConfig2);
  }

  /**
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, null);
  }

  /**
   * Method under test: {@link NotificationRuleConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRuleConfig notificationRuleConfig = new NotificationRuleConfig();
    notificationRuleConfig.setDescription("The characteristics of someone or something");

    // Act and Assert
    assertNotEquals(notificationRuleConfig, "Different type to NotificationRuleConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationRuleConfig}
   *   <li>{@link NotificationRuleConfig#setDescription(String)}
   *   <li>{@link NotificationRuleConfig#toString()}
   *   <li>{@link NotificationRuleConfig#getDescription()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRuleConfig actualNotificationRuleConfig = new NotificationRuleConfig();
    actualNotificationRuleConfig.setDescription("The characteristics of someone or something");
    String actualToStringResult = actualNotificationRuleConfig.toString();

    // Assert that nothing has changed
    assertEquals("NotificationRuleConfig(description=The characteristics of someone or something)",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualNotificationRuleConfig.getDescription());
  }
}
