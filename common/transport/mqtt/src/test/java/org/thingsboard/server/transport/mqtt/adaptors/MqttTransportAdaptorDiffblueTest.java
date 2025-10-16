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
package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {JsonMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class MqttTransportAdaptorDiffblueTest {
  @Autowired private MqttTransportAdaptor mqttTransportAdaptor;

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg() throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName("Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg2() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.putIfAbsent(new MqttTopicMatcher("Topic"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(mqttTopicMatcher).matches("Topic");
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <ul>
   *   <li>Given {@code AT_MOST_ONCE}.
   *   <li>Then calls {@link MqttDeviceAwareSessionContext#nextMsgId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given 'AT_MOST_ONCE'; then calls nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg_givenAtMostOnce_thenCallsNextMsgId()
      throws UnsupportedEncodingException {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <ul>
   *   <li>Given {@link MqttTopicMatcher} {@link MqttTopicMatcher#matches(String)} return {@code
   *       true}.
   *   <li>Then calls {@link MqttTopicMatcher#matches(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given MqttTopicMatcher matches(String) return 'true'; then calls matches(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg_givenMqttTopicMatcherMatchesReturnTrue_thenCallsMatches()
      throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(mqttTopicMatcher).matches("Topic");
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <ul>
   *   <li>Given {@link MqttTopicMatcher#MqttTopicMatcher(String)} with topic is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); given MqttTopicMatcher(String) with topic is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg_givenMqttTopicMatcherWithTopicIs42()
      throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("42"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <ul>
   *   <li>When {@link ConcurrentHashMap#ConcurrentHashMap()} {@link
   *       MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic} is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); when ConcurrentHashMap() MqttTopicMatcher(String) with 'Topic' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg_whenConcurrentHashMapMqttTopicMatcherWithTopicIsOne()
      throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * byte[])}.
   *
   * <ul>
   *   <li>When {@link ConcurrentHashMap#ConcurrentHashMap()} {@link
   *       MqttTopicMatcher#MqttTopicMatcher(String)} with {@code Topic} is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[]); when ConcurrentHashMap() MqttTopicMatcher(String) with 'Topic' is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage MqttTransportAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])"
  })
  void testCreateMqttPublishMsg_whenConcurrentHashMapMqttTopicMatcherWithTopicIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(mqttTopicMatcher).matches("Topic");
    MqttPublishVariableHeader variableHeaderResult =
        actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, variableHeaderResult.packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
  }
}
