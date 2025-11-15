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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class SlackNotificationDeliveryMethodConfigDiffblueTest {
  /**
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}, and {@link SlackNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
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
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}, and {@link SlackNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
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
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}, and {@link SlackNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
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
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
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
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
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
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(slackNotificationDeliveryMethodConfig, null);
  }

  /**
   * Test {@link SlackNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SlackNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SlackNotificationDeliveryMethodConfig.equals(Object)",
      "int SlackNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SlackNotificationDeliveryMethodConfig slackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    slackNotificationDeliveryMethodConfig.setBotToken("ABC123");

    // Act and Assert
    assertNotEquals(slackNotificationDeliveryMethodConfig, "Different type to SlackNotificationDeliveryMethodConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SlackNotificationDeliveryMethodConfig}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#setBotToken(String)}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#toString()}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#getBotToken()}
   *   <li>{@link SlackNotificationDeliveryMethodConfig#getMethod()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SlackNotificationDeliveryMethodConfig.<init>()",
      "String SlackNotificationDeliveryMethodConfig.getBotToken()",
      "NotificationDeliveryMethod SlackNotificationDeliveryMethodConfig.getMethod()",
      "void SlackNotificationDeliveryMethodConfig.setBotToken(String)",
      "String SlackNotificationDeliveryMethodConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SlackNotificationDeliveryMethodConfig actualSlackNotificationDeliveryMethodConfig = new SlackNotificationDeliveryMethodConfig();
    actualSlackNotificationDeliveryMethodConfig.setBotToken("ABC123");
    String actualToStringResult = actualSlackNotificationDeliveryMethodConfig.toString();
    String actualBotToken = actualSlackNotificationDeliveryMethodConfig.getBotToken();

    // Assert
    assertEquals("ABC123", actualBotToken);
    assertEquals("SlackNotificationDeliveryMethodConfig(botToken=ABC123)", actualToStringResult);
    assertEquals(NotificationDeliveryMethod.SLACK, actualSlackNotificationDeliveryMethodConfig.getMethod());
  }
}
