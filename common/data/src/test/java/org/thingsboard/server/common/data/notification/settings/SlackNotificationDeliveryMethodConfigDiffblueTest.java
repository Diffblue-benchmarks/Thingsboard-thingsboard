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
package org.thingsboard.server.common.data.notification.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class SlackNotificationDeliveryMethodConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("ABC123");

    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig2 = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig2.setBotToken("ABC123");

    // Act and Assert
    assertEquals(slackNotificationDeliveryMethodConfig, slackNotificationDeliveryMethodConfig2);
    int expectedHashCodeResult = slackNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, slackNotificationDeliveryMethodConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken(null);

    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig2 = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig2.setBotToken(null);

    // Act and Assert
    assertEquals(slackNotificationDeliveryMethodConfig, slackNotificationDeliveryMethodConfig2);
    int expectedHashCodeResult = slackNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, slackNotificationDeliveryMethodConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("ABC123");

    // Act and Assert
    assertEquals(slackNotificationDeliveryMethodConfig, slackNotificationDeliveryMethodConfig);
    int expectedHashCodeResult = slackNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, slackNotificationDeliveryMethodConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("Bot Token");

    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig2 = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig2.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(slackNotificationDeliveryMethodConfig, slackNotificationDeliveryMethodConfig2);
  }

  /**
   * Method under test:
   * {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken(null);

    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig2 = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig2.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(slackNotificationDeliveryMethodConfig, slackNotificationDeliveryMethodConfig2);
  }

  /**
   * Method under test:
   * {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(slackNotificationDeliveryMethodConfig, null);
  }

  /**
   * Method under test:
   * {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(slackNotificationDeliveryMethodConfig, "Different type to SlackNotificationDeliveryMethodConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SlackNotificationDeliveryMethodConfig}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#setBotToken(String)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#toString()}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#getBotToken()}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#getMethod()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SlackNotificationDeliveryMethodConfig actualSlackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    actualSlackNotificationDeliveryMethodConfig.setBotToken("ABC123");
    String actualToStringResult = actualSlackNotificationDeliveryMethodConfig.toString();
    String actualBotToken = actualSlackNotificationDeliveryMethodConfig.getBotToken();

    // Assert that nothing has changed
    assertEquals("ABC123", actualBotToken);
    assertEquals("SlackNotificationDeliveryMethodConfig(botToken=ABC123)", actualToStringResult);
    assertEquals(NotificationDeliveryMethod.SLACK, actualSlackNotificationDeliveryMethodConfig.getMethod());
  }
}
