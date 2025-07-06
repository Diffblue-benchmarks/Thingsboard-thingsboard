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
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getMqttQoSMap()}
   */
  @Test
  @DisplayName("Test getMqttQoSMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ConcurrentMap MqttDeviceAwareSessionContext.getMqttQoSMap()"})
  void testGetMqttQoSMap() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    ConcurrentMap<MqttTopicMatcher, Integer> actualMqttQoSMap =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()).getMqttQoSMap();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertEquals(
        MqttQoS.AT_LEAST_ONCE,
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())
            .getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@link
   *       MqttTopicMatcher#MqttTopicMatcher(String)} with topic is {@code 42} is one.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName(
      "Test getQoSForTopic(String); given ConcurrentHashMap() MqttTopicMatcher(String) with topic is '42' is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_givenConcurrentHashMapMqttTopicMatcherWithTopicIs42IsOne() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("42"), 1);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertEquals(
        MqttQoS.AT_LEAST_ONCE,
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())
            .getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()} {@link
   *       MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic} is one.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName(
      "Test getQoSForTopic(String); given ConcurrentHashMap() MqttTopicMatcher(String) with 'Topic' is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_givenConcurrentHashMapMqttTopicMatcherWithTopicIsOne() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertEquals(
        MqttQoS.AT_LEAST_ONCE,
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())
            .getQoSForTopic("Topic"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_thenReturnAtLeastOnce() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(
        MqttQoS.AT_LEAST_ONCE,
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())
            .getQoSForTopic("Topic"));
  }

  /**
   * Test {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}.
   *
   * <ul>
   *   <li>Then return {@code AT_MOST_ONCE}.
   * </ul>
   *
   * <p>Method under test: {@link MqttDeviceAwareSessionContext#getQoSForTopic(String)}
   */
  @Test
  @DisplayName("Test getQoSForTopic(String); then return 'AT_MOST_ONCE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttQoS MqttDeviceAwareSessionContext.getQoSForTopic(String)"})
  void testGetQoSForTopic_thenReturnAtMostOnce() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertEquals(
        MqttQoS.AT_MOST_ONCE,
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())
            .getQoSForTopic("Topic"));
  }
}
