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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttTopicMatcherDiffblueTest {
  /**
   * Test {@link MqttTopicMatcher#MqttTopicMatcher(String)}.
   * <ul>
   *   <li>When {@code Topic}.</li>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicMatcher#MqttTopicMatcher(String)}
   */
  @Test
  @DisplayName("Test new MqttTopicMatcher(String); when 'Topic'; then return 'Topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTopicMatcher.<init>(String)"})
  void testNewMqttTopicMatcher_whenTopic_thenReturnTopic() {
    // Arrange, Act and Assert
    assertEquals("Topic", (new MqttTopicMatcher("Topic")).getTopic());
  }

  /**
   * Test {@link MqttTopicMatcher#getTopic()}.
   * <p>
   * Method under test: {@link MqttTopicMatcher#getTopic()}
   */
  @Test
  @DisplayName("Test getTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttTopicMatcher.getTopic()"})
  void testGetTopic() {
    // Arrange, Act and Assert
    assertEquals("Topic", (new MqttTopicMatcher("Topic")).getTopic());
  }

  /**
   * Test {@link MqttTopicMatcher#matches(String)}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with topic is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); given MqttTopicMatcher(String) with topic is '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.matches(String)"})
  void testMatches_givenMqttTopicMatcherWithTopicIs42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new MqttTopicMatcher("42")).matches("Topic"));
  }

  /**
   * Test {@link MqttTopicMatcher#matches(String)}.
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicMatcher#matches(String)}
   */
  @Test
  @DisplayName("Test matches(String); given MqttTopicMatcher(String) with 'Topic'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.matches(String)"})
  void testMatches_givenMqttTopicMatcherWithTopic_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new MqttTopicMatcher("Topic")).matches("Topic"));
  }

  /**
   * Test {@link MqttTopicMatcher#equals(Object)}, and {@link MqttTopicMatcher#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTopicMatcher#equals(Object)}
   *   <li>{@link MqttTopicMatcher#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.equals(Object)", "int MqttTopicMatcher.hashCode()"})
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
   * Test {@link MqttTopicMatcher#equals(Object)}, and {@link MqttTopicMatcher#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTopicMatcher#equals(Object)}
   *   <li>{@link MqttTopicMatcher#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.equals(Object)", "int MqttTopicMatcher.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = new MqttTopicMatcher("Topic");

    // Act and Assert
    assertEquals(mqttTopicMatcher, mqttTopicMatcher);
    int expectedHashCodeResult = mqttTopicMatcher.hashCode();
    assertEquals(expectedHashCodeResult, mqttTopicMatcher.hashCode());
  }

  /**
   * Test {@link MqttTopicMatcher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicMatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.equals(Object)", "int MqttTopicMatcher.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = new MqttTopicMatcher("#");

    // Act and Assert
    assertNotEquals(mqttTopicMatcher, new MqttTopicMatcher("Topic"));
  }

  /**
   * Test {@link MqttTopicMatcher#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicMatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.equals(Object)", "int MqttTopicMatcher.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTopicMatcher("Topic"), null);
  }

  /**
   * Test {@link MqttTopicMatcher#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTopicMatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttTopicMatcher.equals(Object)", "int MqttTopicMatcher.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTopicMatcher("Topic"), "Different type to MqttTopicMatcher");
  }
}
