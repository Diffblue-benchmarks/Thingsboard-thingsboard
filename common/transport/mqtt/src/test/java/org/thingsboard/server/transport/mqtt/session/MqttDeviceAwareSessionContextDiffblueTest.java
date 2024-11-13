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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class MqttDeviceAwareSessionContextDiffblueTest {
  /**
   * Test {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  @DisplayName("Test getMqttQoSMap(); given Function apply(Object) return one; then return size is one")
  void testGetMqttQoSMap_givenFunctionApplyReturnOne_thenReturnSizeIsOne() {
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
   * Test {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  @DisplayName("Test getMqttQoSMap(); then return Empty")
  void testGetMqttQoSMap_thenReturnEmpty() {
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
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String)")
  void testGetQoSForTopic() {
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
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <p>
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String)")
  void testGetQoSForTopic2() {
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
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <p>
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String)")
  void testGetQoSForTopic3() {
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
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()}
   * {@link MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic} is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); given ConcurrentHashMap() MqttTopicMatcher(String) with 'Topic' is one")
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
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); then return 'AT_LEAST_ONCE'")
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
   * Method under test:
   * {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); then return 'AT_MOST_ONCE'")
  void testGetQoSForTopic_thenReturnAtMostOnce() {
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
