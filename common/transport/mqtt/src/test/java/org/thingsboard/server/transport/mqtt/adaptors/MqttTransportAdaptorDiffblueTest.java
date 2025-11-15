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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
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
  @Autowired
  private MqttTransportAdaptor mqttTransportAdaptor;

  /**
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg() throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg2() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg3() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg4() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg5() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("42"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg6() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg7() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
   * Method under test:
   * {@link MqttTransportAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, byte[])}
   */
  @Test
  void testCreateMqttPublishMsg8() throws UnsupportedEncodingException {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = mqttTransportAdaptor.createMqttPublishMsg(ctx, "Topic",
        "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
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
