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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

class BackwardCompatibilityAdaptorDiffblueTest {
  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.PostTelemetryMsg defaultInstance = TransportProtos.PostTelemetryMsg.getDefaultInstance();
    when(protoAdaptor.convertToPostTelemetry(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = backwardCompatibilityAdaptor
        .convertToPostTelemetry(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    verify(protoAdaptor).convertToPostTelemetry(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
    assertSame(defaultInstance, actualConvertToPostTelemetryResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostTelemetry(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostTelemetry(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
    verify(protoAdaptor).convertToPostTelemetry(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostTelemetry(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostTelemetry(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
    verify(protoAdaptor).convertToPostTelemetry(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostTelemetry(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor jsonAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.PostTelemetryMsg defaultInstance = TransportProtos.PostTelemetryMsg.getDefaultInstance();
    when(jsonAdaptor.convertToPostTelemetry(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        jsonAdaptor);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.PostTelemetryMsg actualConvertToPostTelemetryResult = backwardCompatibilityAdaptor
        .convertToPostTelemetry(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    verify(protoAdaptor).convertToPostTelemetry(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
    verify(jsonAdaptor).convertToPostTelemetry(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
    assertSame(defaultInstance, actualConvertToPostTelemetryResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.PostAttributeMsg defaultInstance = TransportProtos.PostAttributeMsg.getDefaultInstance();
    when(protoAdaptor.convertToPostAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = backwardCompatibilityAdaptor
        .convertToPostAttributes(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    verify(protoAdaptor).convertToPostAttributes(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
    assertSame(defaultInstance, actualConvertToPostAttributesResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostAttributes(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
    verify(protoAdaptor).convertToPostAttributes(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostAttributes(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
    verify(protoAdaptor).convertToPostAttributes(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor jsonAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.PostAttributeMsg defaultInstance = TransportProtos.PostAttributeMsg.getDefaultInstance();
    when(jsonAdaptor.convertToPostAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        jsonAdaptor);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.PostAttributeMsg actualConvertToPostAttributesResult = backwardCompatibilityAdaptor
        .convertToPostAttributes(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    verify(protoAdaptor).convertToPostAttributes(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
    verify(jsonAdaptor).convertToPostAttributes(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class));
    assertSame(defaultInstance, actualConvertToPostAttributesResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToGetAttributes() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.GetAttributeRequestMsg defaultInstance = TransportProtos.GetAttributeRequestMsg
        .getDefaultInstance();
    when(protoAdaptor.convertToGetAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = backwardCompatibilityAdaptor
        .convertToGetAttributes(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base");

    // Assert
    verify(protoAdaptor).convertToGetAttributes(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class),
        eq("Topic Base"));
    assertSame(defaultInstance, actualConvertToGetAttributesResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToGetAttributes2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToGetAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToGetAttributes(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base"));
    verify(protoAdaptor).convertToGetAttributes(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class),
        eq("Topic Base"));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToGetAttributes3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToGetAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToGetAttributes(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base"));
    verify(protoAdaptor).convertToGetAttributes(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class),
        eq("Topic Base"));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToGetAttributes4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToGetAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor jsonAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.GetAttributeRequestMsg defaultInstance = TransportProtos.GetAttributeRequestMsg
        .getDefaultInstance();
    when(jsonAdaptor.convertToGetAttributes(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        jsonAdaptor);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.GetAttributeRequestMsg actualConvertToGetAttributesResult = backwardCompatibilityAdaptor
        .convertToGetAttributes(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base");

    // Assert
    verify(protoAdaptor).convertToGetAttributes(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class),
        eq("Topic Base"));
    verify(jsonAdaptor).convertToGetAttributes(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class),
        eq("Topic Base"));
    assertSame(defaultInstance, actualConvertToGetAttributesResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToDeviceRpcResponse() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.ToDeviceRpcResponseMsg defaultInstance = TransportProtos.ToDeviceRpcResponseMsg
        .getDefaultInstance();
    when(protoAdaptor.convertToDeviceRpcResponse(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.ToDeviceRpcResponseMsg actualConvertToDeviceRpcResponseResult = backwardCompatibilityAdaptor
        .convertToDeviceRpcResponse(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base");

    // Assert
    verify(protoAdaptor).convertToDeviceRpcResponse(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
    assertSame(defaultInstance, actualConvertToDeviceRpcResponseResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToDeviceRpcResponse2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToDeviceRpcResponse(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToDeviceRpcResponse(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base"));
    verify(protoAdaptor).convertToDeviceRpcResponse(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToDeviceRpcResponse3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToDeviceRpcResponse(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToDeviceRpcResponse(ctx, new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base"));
    verify(protoAdaptor).convertToDeviceRpcResponse(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToDeviceRpcResponse4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToDeviceRpcResponse(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor jsonAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.ToDeviceRpcResponseMsg defaultInstance = TransportProtos.ToDeviceRpcResponseMsg
        .getDefaultInstance();
    when(jsonAdaptor.convertToDeviceRpcResponse(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        jsonAdaptor);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.ToDeviceRpcResponseMsg actualConvertToDeviceRpcResponseResult = backwardCompatibilityAdaptor
        .convertToDeviceRpcResponse(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base");

    // Assert
    verify(protoAdaptor).convertToDeviceRpcResponse(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
    verify(jsonAdaptor).convertToDeviceRpcResponse(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
    assertSame(defaultInstance, actualConvertToDeviceRpcResponseResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToServerRpcRequest() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.ToServerRpcRequestMsg defaultInstance = TransportProtos.ToServerRpcRequestMsg.getDefaultInstance();
    when(protoAdaptor.convertToServerRpcRequest(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.ToServerRpcRequestMsg actualConvertToServerRpcRequestResult = backwardCompatibilityAdaptor
        .convertToServerRpcRequest(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base");

    // Assert
    verify(protoAdaptor).convertToServerRpcRequest(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
    assertSame(defaultInstance, actualConvertToServerRpcRequestResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToServerRpcRequest2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToServerRpcRequest(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor jsonAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.ToServerRpcRequestMsg defaultInstance = TransportProtos.ToServerRpcRequestMsg.getDefaultInstance();
    when(jsonAdaptor.convertToServerRpcRequest(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any(), Mockito.<String>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        jsonAdaptor);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.ToServerRpcRequestMsg actualConvertToServerRpcRequestResult = backwardCompatibilityAdaptor
        .convertToServerRpcRequest(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base");

    // Assert
    verify(protoAdaptor).convertToServerRpcRequest(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
    verify(jsonAdaptor).convertToServerRpcRequest(isA(MqttDeviceAwareSessionContext.class),
        isA(MqttPublishMessage.class), eq("Topic Base"));
    assertSame(defaultInstance, actualConvertToServerRpcRequestResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToClaimDevice() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.ClaimDeviceMsg defaultInstance = TransportProtos.ClaimDeviceMsg.getDefaultInstance();
    when(protoAdaptor.convertToClaimDevice(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = backwardCompatibilityAdaptor
        .convertToClaimDevice(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    verify(protoAdaptor).convertToClaimDevice(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
    assertSame(defaultInstance, actualConvertToClaimDeviceResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToClaimDevice2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToClaimDevice(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenThrow(new AdaptorException());
    JsonMqttAdaptor jsonAdaptor = mock(JsonMqttAdaptor.class);
    TransportProtos.ClaimDeviceMsg defaultInstance = TransportProtos.ClaimDeviceMsg.getDefaultInstance();
    when(jsonAdaptor.convertToClaimDevice(Mockito.<MqttDeviceAwareSessionContext>any(),
        Mockito.<MqttPublishMessage>any())).thenReturn(defaultInstance);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        jsonAdaptor);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    TransportProtos.ClaimDeviceMsg actualConvertToClaimDeviceResult = backwardCompatibilityAdaptor
        .convertToClaimDevice(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    verify(protoAdaptor).convertToClaimDevice(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
    verify(jsonAdaptor).convertToClaimDevice(isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
    assertSame(defaultInstance, actualConvertToClaimDeviceResult);
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(backwardCompatibilityAdaptor
        .convertToPublish(ctx, TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic")
        .isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(backwardCompatibilityAdaptor
        .convertToPublish(ctx, TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base")
        .isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(backwardCompatibilityAdaptor
        .convertToPublish(ctx, TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance())
        .isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(backwardCompatibilityAdaptor
        .convertToPublish(ctx, TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base")
        .isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish5() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(backwardCompatibilityAdaptor
        .convertToPublish(ctx, TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base")
        .isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish6() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = backwardCompatibilityAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish7() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 = new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor2,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = backwardCompatibilityAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish8() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = backwardCompatibilityAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish9() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = backwardCompatibilityAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish10() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = backwardCompatibilityAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish11() throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = backwardCompatibilityAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v2/fw/response/42/chunk/1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish2() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 = new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor2,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish5() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish6() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("data"), function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish7() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/attributes"), function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor.convertToGatewayPublish(
        ctx, "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish8() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish9() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish10() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 = new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor2,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish11() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish12() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("id"), function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish13() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish14() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/attributes/response"), function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/attributes/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish15() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish16() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish17() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 = new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor2,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish18() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish19() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/rpc"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish20() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = backwardCompatibilityAdaptor
        .convertToGatewayPublish(ctx, "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToProvisionRequestMsg() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertNull(backwardCompatibilityAdaptor.convertToProvisionRequestMsg(ctx, new MqttPublishMessage(mqttFixedHeader,
        variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Method under test:
   * {@link BackwardCompatibilityAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToGatewayDeviceDisconnectPublish(
                new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1)
            .isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#equals(Object)}
   *   <li>{@link BackwardCompatibilityAdaptor#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null, null);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 = new BackwardCompatibilityAdaptor(null, null);

    // Act and Assert
    assertEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
    int expectedHashCodeResult = backwardCompatibilityAdaptor.hashCode();
    assertEquals(expectedHashCodeResult, backwardCompatibilityAdaptor2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#equals(Object)}
   *   <li>{@link BackwardCompatibilityAdaptor#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());

    // Act and Assert
    assertEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor);
    int expectedHashCodeResult = backwardCompatibilityAdaptor.hashCode();
    assertEquals(expectedHashCodeResult, backwardCompatibilityAdaptor.hashCode());
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 = new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor2,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor3 = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor3, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MqttTransportAdaptor protoAdaptor = mock(MqttTransportAdaptor.class);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor,
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null,
        new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null,
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()));

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(null, null);

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor()));
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()), null);
  }

  /**
   * Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act and Assert
    assertNotEquals(new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor()),
        "Different type to BackwardCompatibilityAdaptor");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BackwardCompatibilityAdaptor#BackwardCompatibilityAdaptor(MqttTransportAdaptor, MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#setJsonAdaptor(MqttTransportAdaptor)}
   *   <li>
   * {@link BackwardCompatibilityAdaptor#setProtoAdaptor(MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#toString()}
   *   <li>{@link BackwardCompatibilityAdaptor#getJsonAdaptor()}
   *   <li>{@link BackwardCompatibilityAdaptor#getProtoAdaptor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act
    BackwardCompatibilityAdaptor actualBackwardCompatibilityAdaptor = new BackwardCompatibilityAdaptor(protoAdaptor,
        new JsonMqttAdaptor());
    JsonMqttAdaptor jsonAdaptor = new JsonMqttAdaptor();
    actualBackwardCompatibilityAdaptor.setJsonAdaptor(jsonAdaptor);
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    actualBackwardCompatibilityAdaptor.setProtoAdaptor(protoAdaptor2);
    actualBackwardCompatibilityAdaptor.toString();
    MqttTransportAdaptor actualJsonAdaptor = actualBackwardCompatibilityAdaptor.getJsonAdaptor();
    MqttTransportAdaptor actualProtoAdaptor = actualBackwardCompatibilityAdaptor.getProtoAdaptor();

    // Assert that nothing has changed
    assertTrue(actualJsonAdaptor instanceof JsonMqttAdaptor);
    assertTrue(actualProtoAdaptor instanceof JsonMqttAdaptor);
    assertSame(jsonAdaptor, actualJsonAdaptor);
    assertSame(protoAdaptor2, actualProtoAdaptor);
  }
}
