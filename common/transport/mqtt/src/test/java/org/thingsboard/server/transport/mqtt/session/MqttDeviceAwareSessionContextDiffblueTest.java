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
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class MqttDeviceAwareSessionContextDiffblueTest {
  /**
   * Test {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}.
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  @DisplayName("Test getMqttQoSMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConcurrentMap MqttDeviceAwareSessionContext.getMqttQoSMap()"})
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
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@link MqttTopicMatcher#MqttTopicMatcher(String)} with topic is {@code 42} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); given ConcurrentHashMap() MqttTopicMatcher(String) with topic is '42' is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_givenConcurrentHashMapMqttTopicMatcherWithTopicIs42IsOne() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("42"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@link MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); given ConcurrentHashMap() MqttTopicMatcher(String) with 'Topic' is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_givenConcurrentHashMapMqttTopicMatcherWithTopicIsOne() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <ul>
   *   <li>Then return {@code AT_LEAST_ONCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); then return 'AT_LEAST_ONCE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_thenReturnAtLeastOnce() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <ul>
   *   <li>Then return {@code AT_MOST_ONCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); then return 'AT_MOST_ONCE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_thenReturnAtMostOnce() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertEquals(MqttQoS.AT_MOST_ONCE,
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getQoSForTopic("Topic"));
  }
}
