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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.netty.handler.codec.mqtt.MqttQoS;
import org.junit.jupiter.api.Test;

class MqttLastWillDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttLastWill.Builder#build()}
   *   <li>{@link MqttLastWill.Builder#setRetain(boolean)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    MqttLastWill actualBuildResult = MqttLastWill.builder()
        .setMessage("Not all who wander are lost")
        .setQos(MqttQoS.AT_MOST_ONCE)
        .setRetain(true)
        .setTopic("Topic")
        .build();

    // Assert
    assertEquals("Not all who wander are lost", actualBuildResult.getMessage());
    assertEquals("Topic", actualBuildResult.getTopic());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualBuildResult.getQos());
    assertTrue(actualBuildResult.isRetain());
  }

  /**
   * Method under test: {@link MqttLastWill.Builder#setMessage(String)}
   */
  @Test
  void testBuilderSetMessage() {
    // Arrange
    MqttLastWill.Builder builderResult = MqttLastWill.builder();

    // Act
    MqttLastWill.Builder actualSetMessageResult = builderResult.setMessage("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", builderResult.getMessage());
    assertSame(builderResult, actualSetMessageResult);
  }

  /**
   * Method under test: {@link MqttLastWill.Builder#setQos(MqttQoS)}
   */
  @Test
  void testBuilderSetQos() {
    // Arrange
    MqttLastWill.Builder builderResult = MqttLastWill.builder();

    // Act
    MqttLastWill.Builder actualSetQosResult = builderResult.setQos(MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(MqttQoS.AT_MOST_ONCE, builderResult.getQos());
    assertSame(builderResult, actualSetQosResult);
  }

  /**
   * Method under test: {@link MqttLastWill.Builder#setTopic(String)}
   */
  @Test
  void testBuilderSetTopic() {
    // Arrange
    MqttLastWill.Builder builderResult = MqttLastWill.builder();

    // Act
    MqttLastWill.Builder actualSetTopicResult = builderResult.setTopic("Topic");

    // Assert
    assertEquals("Topic", builderResult.getTopic());
    assertSame(builderResult, actualSetTopicResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttLastWill#equals(Object)}
   *   <li>{@link MqttLastWill#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE);
    MqttLastWill mqttLastWill2 = new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertEquals(mqttLastWill, mqttLastWill2);
    int expectedHashCodeResult = mqttLastWill.hashCode();
    assertEquals(expectedHashCodeResult, mqttLastWill2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttLastWill#equals(Object)}
   *   <li>{@link MqttLastWill#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertEquals(mqttLastWill, mqttLastWill);
    int expectedHashCodeResult = mqttLastWill.hashCode();
    assertEquals(expectedHashCodeResult, mqttLastWill.hashCode());
  }

  /**
   * Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Not all who wander are lost", "Not all who wander are lost", true,
        MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertNotEquals(mqttLastWill, new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE));
  }

  /**
   * Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Topic", "Topic", true, MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertNotEquals(mqttLastWill, new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE));
  }

  /**
   * Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Topic", "Not all who wander are lost", false, MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertNotEquals(mqttLastWill, new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE));
  }

  /**
   * Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_LEAST_ONCE);

    // Act and Assert
    assertNotEquals(mqttLastWill, new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE));
  }

  /**
   * Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE), null);
  }

  /**
   * Method under test: {@link MqttLastWill#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE),
        "Different type to MqttLastWill");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttLastWill#toString()}
   *   <li>{@link MqttLastWill#getMessage()}
   *   <li>{@link MqttLastWill#getQos()}
   *   <li>{@link MqttLastWill#getTopic()}
   *   <li>{@link MqttLastWill#isRetain()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MqttLastWill mqttLastWill = new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE);

    // Act
    String actualToStringResult = mqttLastWill.toString();
    String actualMessage = mqttLastWill.getMessage();
    MqttQoS actualQos = mqttLastWill.getQos();
    String actualTopic = mqttLastWill.getTopic();

    // Assert
    assertEquals("MqttLastWill{topic='Topic', message='Not all who wander are lost', retain=true, qos=AT_MOST_ONCE}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals("Topic", actualTopic);
    assertEquals(MqttQoS.AT_MOST_ONCE, actualQos);
    assertTrue(mqttLastWill.isRetain());
  }

  /**
   * Method under test:
   * {@link MqttLastWill#MqttLastWill(String, String, boolean, MqttQoS)}
   */
  @Test
  void testNewMqttLastWill() {
    // Arrange and Act
    MqttLastWill actualMqttLastWill = new MqttLastWill("Topic", "Not all who wander are lost", true,
        MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals("Not all who wander are lost", actualMqttLastWill.getMessage());
    assertEquals("Topic", actualMqttLastWill.getTopic());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualMqttLastWill.getQos());
    assertTrue(actualMqttLastWill.isRetain());
  }
}
