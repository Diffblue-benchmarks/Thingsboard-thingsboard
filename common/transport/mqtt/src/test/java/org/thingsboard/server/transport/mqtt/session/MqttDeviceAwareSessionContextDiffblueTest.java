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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class MqttDeviceAwareSessionContextDiffblueTest {
  /**
   * Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  void testGetMqttQoSMap() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    ConcurrentMap<MqttTopicMatcher, Integer> actualMqttQoSMap = (new DeviceSessionCtx(sessionId, mqttQoSMap,
        new MqttTransportContext())).getMqttQoSMap();

    // Assert
    assertTrue(actualMqttQoSMap.isEmpty());
    assertSame(mqttQoSMap, actualMqttQoSMap);
  }

  /**
   * Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  void testGetMqttQoSMap2() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    ConcurrentMap<MqttTopicMatcher, Integer> actualMqttQoSMap = (new DeviceSessionCtx(sessionId, mqttQoSMap,
        new MqttTransportContext())).getMqttQoSMap();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(1, actualMqttQoSMap.size());
    assertSame(mqttQoSMap, actualMqttQoSMap);
  }

  /**
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  void testGetQoSForTopic() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }

  /**
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  void testGetQoSForTopic2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }

  /**
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  void testGetQoSForTopic3() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttQoS actualQoSForTopic = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_LEAST_ONCE, actualQoSForTopic);
  }

  /**
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  void testGetQoSForTopic4() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttQoS actualQoSForTopic = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_LEAST_ONCE, actualQoSForTopic);
  }

  /**
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  void testGetQoSForTopic5() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("42"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttQoS actualQoSForTopic = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_LEAST_ONCE, actualQoSForTopic);
  }

  /**
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  void testGetQoSForTopic6() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttQoS actualQoSForTopic = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_MOST_ONCE, actualQoSForTopic);
  }
}
