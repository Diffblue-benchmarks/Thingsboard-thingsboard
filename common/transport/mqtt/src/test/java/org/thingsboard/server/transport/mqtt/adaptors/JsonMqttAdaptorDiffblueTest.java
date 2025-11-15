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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {JsonMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonMqttAdaptorDiffblueTest {
  @Autowired
  private JsonMqttAdaptor jsonMqttAdaptor;

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx,
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx,
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostTelemetry4() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(inbound).payload();
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonMqttAdaptor.convertToPostAttributes(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx,
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx,
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToPostAttributes4() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(inbound).payload();
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToClaimDevice() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    new IllegalStateException("foo");
    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("String");
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToClaimDevice2() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    new IllegalStateException("foo");
    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("Failed to decode claim device request");
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToClaimDevice3() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    new IllegalStateException("foo");
    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("foo");
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToClaimDevice4() throws AdaptorException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    new IllegalStateException("foo");
    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("42");
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToProvisionRequestMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToProvisionRequestMsg2() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx,
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToProvisionRequestMsg3() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx,
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  void testConvertToProvisionRequestMsg4() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getSessionId()).thenReturn(UUID.randomUUID());
    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
    verify(inbound).payload();
    verify(ctx).getSessionId();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToGetAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonMqttAdaptor.convertToGetAttributes(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToGetAttributes2() throws AdaptorException {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(jsonMqttAdaptor);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.variableHeader()).thenReturn(new MqttPublishVariableHeader("Topic Name", 1));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToGetAttributes(ctx, inbound, "Topic Base"));
    verify(inbound).variableHeader();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToDeviceRpcResponse() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> jsonMqttAdaptor.convertToDeviceRpcResponse(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))), "Topic Base"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)}
   */
  @Test
  void testConvertToDeviceRpcResponse2() throws AdaptorException {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(jsonMqttAdaptor);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.variableHeader()).thenReturn(new MqttPublishVariableHeader("Topic Name", 1));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToDeviceRpcResponse(ctx, inbound, "Topic Base"));
    verify(inbound).variableHeader();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish3() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish4() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish5() {
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
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish6() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException("Topic"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic"));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish7() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.AttributeUpdateNotificationMsg, String)}
   */
  @Test
  void testConvertToPublish8() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("foo"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish9() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish10() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish11() throws AdaptorException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish12() throws AdaptorException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish13() throws AdaptorException {
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
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish14() throws AdaptorException {
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
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish15() throws AdaptorException {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.GetAttributeResponseMsg, String)}
   */
  @Test
  void testConvertToPublish16() throws AdaptorException {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("foo"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance(), "Topic Base"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic Base0"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish17() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish18() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish19() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("/provision/response"), function);
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish20() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("credentialsValue"), function);
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish21() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("/provision/response"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish22() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(2);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("/provision/response"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish23() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("/provision/response"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish24() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException("/provision/response"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance()));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("/provision/response"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish25() {
    // Arrange
    new IllegalStateException("/provision/response");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("/provision/response"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ProvisionDeviceResponseMsg)}
   */
  @Test
  void testConvertToPublish26() {
    // Arrange
    new IllegalStateException("/provision/response");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("/provision/response"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, TransportProtos.ProvisionDeviceResponseMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("/provision/response"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish27() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish28() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish29() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("method"), function);
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish30() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("params"), function);
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish31() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish32() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish33() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish34() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException("method"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base"));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish35() {
    // Arrange
    new IllegalStateException("method");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  void testConvertToPublish36() {
    // Arrange
    new IllegalStateException("method");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("method"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic Base0"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish37() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish38() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(null, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish39() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish40() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish41() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish42() {
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
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish43() {
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
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish44() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic Base0"));
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base0", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  void testConvertToPublish45() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("foo"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToPublish(ctx,
        TransportProtos.ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic Base0"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish46() throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish47() throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish48() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish49() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish50() throws UnsupportedEncodingException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish51() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v2/fw/response/42/chunk/1"));
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish52() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(2);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v2/fw/response/42/chunk/1"));
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish53() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v2/fw/response/42/chunk/1"));
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
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish54() throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any()))
        .thenThrow(new IllegalStateException("v2/%s/response/%s/chunk/%d"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 3);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v2/fw/response/42/chunk/1"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)}
   */
  @Test
  void testConvertToPublish55() throws UnsupportedEncodingException {
    // Arrange
    new IllegalStateException("v2/%s/response/%s/chunk/%d");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult = jsonMqttAdaptor.convertToPublish(ctx,
        "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v2/fw/response/42/chunk/1"));
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
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    JsonElement actualValidateJsonPayloadResult = JsonMqttAdaptor.validateJsonPayload(sessionId,
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonNull);
    assertFalse(actualValidateJsonPayloadResult.isJsonArray());
    assertFalse(actualValidateJsonPayloadResult.isJsonObject());
    assertFalse(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(actualValidateJsonPayloadResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualValidateJsonPayloadResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualValidateJsonPayloadResult.getAsJsonNull());
  }

  /**
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    JsonElement actualValidateJsonPayloadResult = JsonMqttAdaptor.validateJsonPayload(sessionId,
        new DuplicatedByteBuf(new EmptyByteBuf(mock(PooledByteBufAllocator.class))));

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonNull);
    assertFalse(actualValidateJsonPayloadResult.isJsonArray());
    assertFalse(actualValidateJsonPayloadResult.isJsonObject());
    assertFalse(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(actualValidateJsonPayloadResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualValidateJsonPayloadResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualValidateJsonPayloadResult.getAsJsonNull());
  }

  /**
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    JsonElement actualValidateJsonPayloadResult = JsonMqttAdaptor.validateJsonPayload(sessionId,
        new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonNull);
    assertFalse(actualValidateJsonPayloadResult.isJsonArray());
    assertFalse(actualValidateJsonPayloadResult.isJsonObject());
    assertFalse(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(actualValidateJsonPayloadResult.isJsonNull());
    JsonNull expectedAsJsonNull = ((JsonNull) actualValidateJsonPayloadResult).INSTANCE;
    assertSame(expectedAsJsonNull, actualValidateJsonPayloadResult.getAsJsonNull());
  }

  /**
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn("String");

    // Act
    JsonElement actualValidateJsonPayloadResult = JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    verify(payloadData).toString(isA(Charset.class));
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("String", actualValidateJsonPayloadResult.getAsString());
    assertEquals("String", asNumber.toString());
    assertEquals('S', actualValidateJsonPayloadResult.getAsCharacter());
    assertFalse(actualValidateJsonPayloadResult.getAsBoolean());
    assertFalse(actualValidateJsonPayloadResult.isJsonArray());
    assertFalse(actualValidateJsonPayloadResult.isJsonNull());
    assertFalse(actualValidateJsonPayloadResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isBoolean());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isNumber());
    assertTrue(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualValidateJsonPayloadResult).isString());
    assertSame(actualValidateJsonPayloadResult, actualValidateJsonPayloadResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn("foo");

    // Act
    JsonElement actualValidateJsonPayloadResult = JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    verify(payloadData).toString(isA(Charset.class));
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("foo", actualValidateJsonPayloadResult.getAsString());
    assertEquals("foo", asNumber.toString());
    assertEquals('f', actualValidateJsonPayloadResult.getAsCharacter());
    assertFalse(actualValidateJsonPayloadResult.getAsBoolean());
    assertFalse(actualValidateJsonPayloadResult.isJsonArray());
    assertFalse(actualValidateJsonPayloadResult.isJsonNull());
    assertFalse(actualValidateJsonPayloadResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isBoolean());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isNumber());
    assertTrue(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualValidateJsonPayloadResult).isString());
    assertSame(actualValidateJsonPayloadResult, actualValidateJsonPayloadResult.getAsJsonPrimitive());
  }

  /**
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload6() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn(null);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData));
    verify(payloadData).toString(isA(Charset.class));
  }

  /**
   * Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  void testValidateJsonPayload7() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn("42");

    // Act
    JsonElement actualValidateJsonPayloadResult = JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    verify(payloadData).toString(isA(Charset.class));
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42", actualValidateJsonPayloadResult.getAsString());
    assertEquals("42", asNumber.toString());
    BigInteger asBigInteger = actualValidateJsonPayloadResult.getAsBigInteger();
    assertEquals("42", asBigInteger.toString());
    assertEquals('4', actualValidateJsonPayloadResult.getAsCharacter());
    assertEquals(1, asBigInteger.getLowestSetBit());
    assertEquals(1, asBigInteger.signum());
    assertEquals(42, actualValidateJsonPayloadResult.getAsInt());
    assertEquals(42.0d, actualValidateJsonPayloadResult.getAsDouble());
    assertEquals(42.0f, actualValidateJsonPayloadResult.getAsFloat());
    assertEquals(42L, actualValidateJsonPayloadResult.getAsLong());
    assertEquals((short) 42, actualValidateJsonPayloadResult.getAsShort());
    assertFalse(actualValidateJsonPayloadResult.getAsBoolean());
    assertFalse(actualValidateJsonPayloadResult.isJsonArray());
    assertFalse(actualValidateJsonPayloadResult.isJsonNull());
    assertFalse(actualValidateJsonPayloadResult.isJsonObject());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isBoolean());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isString());
    assertTrue(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(((JsonPrimitive) actualValidateJsonPayloadResult).isNumber());
    BigDecimal expectedAsBigDecimal = new BigDecimal("42");
    assertEquals(expectedAsBigDecimal, actualValidateJsonPayloadResult.getAsBigDecimal());
    assertEquals('*', actualValidateJsonPayloadResult.getAsByte());
    assertSame(actualValidateJsonPayloadResult, actualValidateJsonPayloadResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, asBigInteger.toByteArray());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg3() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg4() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg5() {
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
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg6() {
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
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg7() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException("Topic"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonArray(3)));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher2).matches(eq("Topic"));
    verify(mqttTopicMatcher).matches(eq("Topic"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg8() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonArray(3));

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg9() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("foo"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonArray(3)));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg10() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonNull());

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg11() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        new JsonObject());

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg12() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg13() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add('A');

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg14() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    Integer number = Integer.valueOf(1);
    json.add(number);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("Topic"));
    MqttPublishVariableHeader variableHeaderResult = actualCreateMqttPublishMsgResult.variableHeader();
    assertEquals("Topic", variableHeaderResult.topicName());
    DecoderResult decoderResultResult = actualCreateMqttPublishMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    int packetIdResult = variableHeaderResult.packetId();
    assertEquals(1, packetIdResult);
    assertFalse(decoderResultResult.isFailure());
    assertTrue(actualCreateMqttPublishMsgResult.payload().isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(variableHeaderResult.properties().isEmpty());
    assertSame(number, packetIdResult);
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg15() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic",
        mock(JsonElement.class));

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg16() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add(false);
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  void testCreateMqttPublishMsg17() {
    // Arrange
    new IllegalStateException("Topic");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = new JsonArray(3);
    json.add('\u0000');
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult = jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish3() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish4() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("data"), function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish5() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/attributes"), function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish6() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/attributes"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish7() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/attributes"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish8() {
    // Arrange
    new IllegalStateException("device");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/attributes"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish9() {
    // Arrange
    new IllegalStateException("device");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("device"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name",
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/attributes"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testConvertToGatewayPublish10() {
    // Arrange
    new IllegalStateException("device");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx, "",
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/attributes"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish11() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish12() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish13() throws AdaptorException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("id"), function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish14() throws AdaptorException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish15() throws AdaptorException {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/attributes/response"), function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish16() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/attributes/response"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish17() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/attributes/response"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish18() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException("id"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name",
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance()));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher2).matches(eq("v1/gateway/attributes/response"));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/attributes/response"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish19() throws AdaptorException {
    // Arrange
    new IllegalStateException("id");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/attributes/response"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish20() throws AdaptorException {
    // Arrange
    new IllegalStateException("id");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("id"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name",
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/attributes/response"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testConvertToGatewayPublish21() throws AdaptorException {
    // Arrange
    new IllegalStateException("id");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx, "",
        TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/attributes/response"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish22() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish23() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx ctx = new DeviceSessionCtx(null, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish24() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish25() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/rpc"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish26() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish27() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/rpc"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish28() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(0);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/rpc"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish29() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException("v1/gateway/rpc"));
    MqttTopicMatcher mqttTopicMatcher2 = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher2.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher2, function);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name",
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance()));
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher2).matches(eq("v1/gateway/rpc"));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/rpc"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish30() {
    // Arrange
    new IllegalStateException("v1/gateway/rpc");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult = jsonMqttAdaptor.convertToGatewayPublish(ctx,
        "Device Name", TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/rpc"));
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
   * {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testConvertToGatewayPublish31() {
    // Arrange
    new IllegalStateException("v1/gateway/rpc");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("v1/gateway/rpc"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name",
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/rpc"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish3() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/gateway/disconnect"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish4() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish5() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(mqttTopicMatcher, function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    verify(mqttTopicMatcher).matches(eq("v1/gateway/disconnect"));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish6() {
    // Arrange
    new IllegalStateException("v1/gateway/disconnect");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/disconnect"));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish7() {
    // Arrange
    new IllegalStateException("v1/gateway/disconnect");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException("v1/gateway/disconnect"));
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/disconnect"));
  }

  /**
   * Method under test:
   * {@link JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  void testConvertToGatewayDeviceDisconnectPublish8() {
    // Arrange
    new IllegalStateException("v1/gateway/disconnect");
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = jsonMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(ctx, "", 1);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic(eq("v1/gateway/disconnect"));
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }
}
