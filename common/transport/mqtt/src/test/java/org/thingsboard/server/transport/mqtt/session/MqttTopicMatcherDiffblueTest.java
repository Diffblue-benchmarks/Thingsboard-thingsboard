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
package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MqttTopicMatcherDiffblueTest {
  /**
   * Method under test: {@link MqttTopicMatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = new MqttTopicMatcher("#");

    // Act and Assert
    assertNotEquals(mqttTopicMatcher, new MqttTopicMatcher("Topic"));
  }

  /**
   * Method under test: {@link MqttTopicMatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTopicMatcher("Topic"), null);
  }

  /**
   * Method under test: {@link MqttTopicMatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTopicMatcher("Topic"), "Different type to MqttTopicMatcher");
  }

  /**
   * Method under test: {@link MqttTopicMatcher#getTopic()}
   */
  @Test
  void testGetTopic() {
    // Arrange, Act and Assert
    assertEquals("Topic", (new MqttTopicMatcher("Topic")).getTopic());
  }

  /**
   * Method under test: {@link MqttTopicMatcher#matches(String)}
   */
  @Test
  void testMatches() {
    // Arrange, Act and Assert
    assertTrue((new MqttTopicMatcher("Topic")).matches("Topic"));
    assertFalse((new MqttTopicMatcher("42")).matches("Topic"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTopicMatcher#equals(Object)}
   *   <li>{@link MqttTopicMatcher#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = new MqttTopicMatcher("Topic");
    MqttTopicMatcher mqttTopicMatcher2 = new MqttTopicMatcher("Topic");

    // Act and Assert
    assertEquals(mqttTopicMatcher, mqttTopicMatcher2);
    int expectedHashCodeResult = mqttTopicMatcher.hashCode();
    assertEquals(expectedHashCodeResult, mqttTopicMatcher2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTopicMatcher#equals(Object)}
   *   <li>{@link MqttTopicMatcher#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = new MqttTopicMatcher("Topic");

    // Act and Assert
    assertEquals(mqttTopicMatcher, mqttTopicMatcher);
    int expectedHashCodeResult = mqttTopicMatcher.hashCode();
    assertEquals(expectedHashCodeResult, mqttTopicMatcher.hashCode());
  }

  /**
   * Method under test: {@link MqttTopicMatcher#MqttTopicMatcher(String)}
   */
  @Test
  void testNewMqttTopicMatcher() {
    // Arrange, Act and Assert
    assertEquals("Topic", (new MqttTopicMatcher("Topic")).getTopic());
  }
}
