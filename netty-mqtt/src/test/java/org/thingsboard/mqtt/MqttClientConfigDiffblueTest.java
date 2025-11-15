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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.handler.ssl.JdkSslClientContext;
import io.netty.handler.ssl.SslContext;
import javax.net.ssl.SSLException;
import org.junit.jupiter.api.Test;

class MqttClientConfigDiffblueTest {
  /**
   * Method under test: {@link MqttClientConfig#setTimeoutSeconds(int)}
   */
  @Test
  void testSetTimeoutSeconds() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setTimeoutSeconds(10);

    // Assert
    assertEquals(10, mqttClientConfig.getTimeoutSeconds());
  }

  /**
   * Method under test: {@link MqttClientConfig#setTimeoutSeconds(int)}
   */
  @Test
  void testSetTimeoutSeconds2() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setTimeoutSeconds(-1);

    // Assert
    assertEquals(-1, mqttClientConfig.getTimeoutSeconds());
  }

  /**
   * Method under test: {@link MqttClientConfig#setTimeoutSeconds(int)}
   */
  @Test
  void testSetTimeoutSeconds3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MqttClientConfig()).setTimeoutSeconds(0));
  }

  /**
   * Method under test: {@link MqttClientConfig#setReconnectDelay(long)}
   */
  @Test
  void testSetReconnectDelay() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MqttClientConfig()).setReconnectDelay(0L));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttClientConfig#setChannelClass(Class)}
   *   <li>{@link MqttClientConfig#setCleanSession(boolean)}
   *   <li>{@link MqttClientConfig#setLastWill(MqttLastWill)}
   *   <li>{@link MqttClientConfig#setOwnerId(String)}
   *   <li>{@link MqttClientConfig#setPassword(String)}
   *   <li>{@link MqttClientConfig#setReconnect(boolean)}
   *   <li>{@link MqttClientConfig#setUsername(String)}
   *   <li>{@link MqttClientConfig#getChannelClass()}
   *   <li>{@link MqttClientConfig#getClientId()}
   *   <li>{@link MqttClientConfig#getLastWill()}
   *   <li>{@link MqttClientConfig#getMaxBytesInMessage()}
   *   <li>{@link MqttClientConfig#getOwnerId()}
   *   <li>{@link MqttClientConfig#getPassword()}
   *   <li>{@link MqttClientConfig#getProtocolVersion()}
   *   <li>{@link MqttClientConfig#getReconnectDelay()}
   *   <li>{@link MqttClientConfig#getSslContext()}
   *   <li>{@link MqttClientConfig#getTimeoutSeconds()}
   *   <li>{@link MqttClientConfig#getUsername()}
   *   <li>{@link MqttClientConfig#isCleanSession()}
   *   <li>{@link MqttClientConfig#isReconnect()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();
    Class<Channel> channelClass = Channel.class;

    // Act
    mqttClientConfig.setChannelClass(channelClass);
    mqttClientConfig.setCleanSession(true);
    MqttLastWill lastWill = new MqttLastWill("Topic", "Not all who wander are lost", true, MqttQoS.AT_MOST_ONCE);

    mqttClientConfig.setLastWill(lastWill);
    mqttClientConfig.setOwnerId("42");
    mqttClientConfig.setPassword("iloveyou");
    mqttClientConfig.setReconnect(true);
    mqttClientConfig.setUsername("janedoe");
    Class<? extends Channel> actualChannelClass = mqttClientConfig.getChannelClass();
    mqttClientConfig.getClientId();
    MqttLastWill actualLastWill = mqttClientConfig.getLastWill();
    int actualMaxBytesInMessage = mqttClientConfig.getMaxBytesInMessage();
    String actualOwnerId = mqttClientConfig.getOwnerId();
    String actualPassword = mqttClientConfig.getPassword();
    MqttVersion actualProtocolVersion = mqttClientConfig.getProtocolVersion();
    long actualReconnectDelay = mqttClientConfig.getReconnectDelay();
    mqttClientConfig.getSslContext();
    int actualTimeoutSeconds = mqttClientConfig.getTimeoutSeconds();
    String actualUsername = mqttClientConfig.getUsername();
    boolean actualIsCleanSessionResult = mqttClientConfig.isCleanSession();

    // Assert that nothing has changed
    assertEquals("42", actualOwnerId);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualUsername);
    assertEquals(1L, actualReconnectDelay);
    assertEquals(60, actualTimeoutSeconds);
    assertEquals(8092, actualMaxBytesInMessage);
    assertEquals(MqttVersion.MQTT_3_1, actualProtocolVersion);
    assertTrue(actualIsCleanSessionResult);
    assertTrue(mqttClientConfig.isReconnect());
    Class<Channel> expectedChannelClass = Channel.class;
    assertEquals(expectedChannelClass, actualChannelClass);
    assertSame(lastWill, actualLastWill);
    assertSame(channelClass, actualChannelClass);
  }

  /**
   * Method under test: {@link MqttClientConfig#setMaxBytesInMessage(int)}
   */
  @Test
  void testSetMaxBytesInMessage() {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig();

    // Act
    mqttClientConfig.setMaxBytesInMessage(3);

    // Assert
    assertEquals(3, mqttClientConfig.getMaxBytesInMessage());
  }

  /**
   * Method under test: {@link MqttClientConfig#setMaxBytesInMessage(int)}
   */
  @Test
  void testSetMaxBytesInMessage2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MqttClientConfig()).setMaxBytesInMessage(0));
  }

  /**
   * Method under test: {@link MqttClientConfig#setMaxBytesInMessage(int)}
   */
  @Test
  void testSetMaxBytesInMessage3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new MqttClientConfig()).setMaxBytesInMessage(256000001));
  }

  /**
   * Method under test: {@link MqttClientConfig#MqttClientConfig()}
   */
  @Test
  void testNewMqttClientConfig() {
    // Arrange and Act
    MqttClientConfig actualMqttClientConfig = new MqttClientConfig();

    // Assert
    assertNull(actualMqttClientConfig.getSslContext());
    assertNull(actualMqttClientConfig.getOwnerId());
    assertNull(actualMqttClientConfig.getPassword());
    assertNull(actualMqttClientConfig.getUsername());
    assertNull(actualMqttClientConfig.getLastWill());
    assertEquals(1L, actualMqttClientConfig.getReconnectDelay());
    assertEquals(60, actualMqttClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualMqttClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualMqttClientConfig.getProtocolVersion());
    assertTrue(actualMqttClientConfig.isCleanSession());
    assertTrue(actualMqttClientConfig.isReconnect());
    Class<NioSocketChannel> expectedChannelClass = NioSocketChannel.class;
    assertEquals(expectedChannelClass, actualMqttClientConfig.getChannelClass());
  }

  /**
   * Method under test: {@link MqttClientConfig#MqttClientConfig(SslContext)}
   */
  @Test
  void testNewMqttClientConfig2() throws SSLException {
    // Arrange
    JdkSslClientContext sslContext = new JdkSslClientContext();

    // Act
    MqttClientConfig actualMqttClientConfig = new MqttClientConfig(sslContext);

    // Assert
    assertNull(actualMqttClientConfig.getOwnerId());
    assertNull(actualMqttClientConfig.getPassword());
    assertNull(actualMqttClientConfig.getUsername());
    assertNull(actualMqttClientConfig.getLastWill());
    assertEquals(1L, actualMqttClientConfig.getReconnectDelay());
    assertEquals(60, actualMqttClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualMqttClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualMqttClientConfig.getProtocolVersion());
    assertTrue(actualMqttClientConfig.isCleanSession());
    assertTrue(actualMqttClientConfig.isReconnect());
    Class<NioSocketChannel> expectedChannelClass = NioSocketChannel.class;
    assertEquals(expectedChannelClass, actualMqttClientConfig.getChannelClass());
    assertSame(sslContext, actualMqttClientConfig.getSslContext());
  }
}
