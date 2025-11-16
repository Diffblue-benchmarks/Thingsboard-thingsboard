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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class MqttDeviceAwareSessionContextDiffblueTest {
  /**
   * Test {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}.
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  @DisplayName("Test getMqttQoSMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ConcurrentMap MqttDeviceAwareSessionContext.getMqttQoSMap()"})
  void testGetMqttQoSMap() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    ConcurrentMap<MqttTopicMatcher, Integer> actualMqttQoSMap = deviceSessionCtx.getMqttQoSMap();

    // Assert
    assertTrue(actualMqttQoSMap.isEmpty());
    assertSame(mqttQoSMap, actualMqttQoSMap);
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttQoS actualQoSForTopic = deviceSessionCtx.getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_LEAST_ONCE, actualQoSForTopic);
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic2() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("42"), function);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttQoS actualQoSForTopic = deviceSessionCtx.getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_LEAST_ONCE, actualQoSForTopic);
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@link
   *       MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic} is minus one.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName(
      "Test getQoSForTopic(String); given ConcurrentHashMap() MqttTopicMatcher(String) with 'Topic' is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_givenConcurrentHashMapMqttTopicMatcherWithTopicIsMinusOne() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), -1);
    mqttQoSMap.put(new MqttTopicMatcher("42"), 42);
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttQoS actualQoSForTopic = deviceSessionCtx.getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_LEAST_ONCE, actualQoSForTopic);
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return zero.
   *   <li>Then return {@code AT_MOST_ONCE}.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName(
      "Test getQoSForTopic(String); given Function apply(Object) return zero; then return 'AT_MOST_ONCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_givenFunctionApplyReturnZero_thenReturnAtMostOnce() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttQoS actualQoSForTopic = deviceSessionCtx.getQoSForTopic("Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(MqttQoS.AT_MOST_ONCE, actualQoSForTopic);
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <ul>
   *   <li>Then return {@code AT_LEAST_ONCE}.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); then return 'AT_LEAST_ONCE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_thenReturnAtLeastOnce() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals(MqttQoS.AT_LEAST_ONCE, deviceSessionCtx.getQoSForTopic("Topic"));
  }
}
