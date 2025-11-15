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
package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class MqttSubscriptionDiffblueTest {
  /**
   * Method under test: {@link MqttSubscription#matches(String)}
   */
  @Test
  void testMatches() {
    // Arrange, Act and Assert
    assertTrue((new MqttSubscription("Topic", mock(MqttHandler.class), true)).matches("Topic"));
    assertFalse((new MqttSubscription("42", mock(MqttHandler.class), true)).matches("Topic"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttSubscription#equals(Object)}
   *   <li>{@link MqttSubscription#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), true);

    // Act and Assert
    assertEquals(mqttSubscription, mqttSubscription);
    int expectedHashCodeResult = mqttSubscription.hashCode();
    assertEquals(expectedHashCodeResult, mqttSubscription.hashCode());
  }

  /**
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), true);

    // Act and Assert
    assertNotEquals(mqttSubscription, new MqttSubscription("Topic", mock(MqttHandler.class), true));
  }

  /**
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("#", mock(MqttHandler.class), true);

    // Act and Assert
    assertNotEquals(mqttSubscription, new MqttSubscription("Topic", mock(MqttHandler.class), true));
  }

  /**
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), false);

    // Act and Assert
    assertNotEquals(mqttSubscription, new MqttSubscription("Topic", mock(MqttHandler.class), true));
  }

  /**
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttSubscription("Topic", mock(MqttHandler.class), true), null);
  }

  /**
   * Method under test: {@link MqttSubscription#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttSubscription("Topic", mock(MqttHandler.class), true), "Different type to MqttSubscription");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttSubscription#setCalled(boolean)}
   *   <li>{@link MqttSubscription#getHandler()}
   *   <li>{@link MqttSubscription#getTopic()}
   *   <li>{@link MqttSubscription#isCalled()}
   *   <li>{@link MqttSubscription#isOnce()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MqttSubscription mqttSubscription = new MqttSubscription("Topic", mock(MqttHandler.class), true);

    // Act
    mqttSubscription.setCalled(true);
    mqttSubscription.getHandler();
    String actualTopic = mqttSubscription.getTopic();
    boolean actualIsCalledResult = mqttSubscription.isCalled();

    // Assert that nothing has changed
    assertEquals("Topic", actualTopic);
    assertTrue(actualIsCalledResult);
    assertTrue(mqttSubscription.isOnce());
  }

  /**
   * Method under test:
   * {@link MqttSubscription#MqttSubscription(String, MqttHandler, boolean)}
   */
  @Test
  void testNewMqttSubscription() {
    // Arrange
    MqttHandler handler = mock(MqttHandler.class);

    // Act
    MqttSubscription actualMqttSubscription = new MqttSubscription("Topic", handler, true);

    // Assert
    assertEquals("Topic", actualMqttSubscription.getTopic());
    assertFalse(actualMqttSubscription.isCalled());
    assertTrue(actualMqttSubscription.isOnce());
    assertSame(handler, actualMqttSubscription.getHandler());
  }
}
