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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;
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
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.CredentialsType;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ResponseStatus;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {JsonMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class JsonMqttAdaptorDiffblueTest {
  @Autowired private JsonMqttAdaptor jsonMqttAdaptor;

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any()))
        .thenReturn("Failed to decode post telemetry request");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_givenCompositeByteBufToStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("42");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_givenCompositeByteBufToStringReturnFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("foo");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_givenCompositeByteBufToStringReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn(null);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_givenCompositeByteBufToStringReturnString()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("String");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); given EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_givenEmptyByteBufWithAllocIsAllocator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg JsonMqttAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostTelemetry(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any()))
        .thenReturn("Failed to decode post attributes request");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenCompositeByteBufToStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("42");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenCompositeByteBufToStringReturnFoo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("foo");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenCompositeByteBufToStringReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn(null);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenCompositeByteBufToStringReturnString()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("String");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); given EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_givenEmptyByteBufWithAllocIsAllocator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg JsonMqttAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToPostAttributes(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ClaimDeviceMsg JsonMqttAdaptor.convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToClaimDevice() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any()))
        .thenReturn("Failed to decode claim device request");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ClaimDeviceMsg JsonMqttAdaptor.convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToClaimDevice_givenCompositeByteBufToStringReturn42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("42");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ClaimDeviceMsg JsonMqttAdaptor.convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToClaimDevice_givenCompositeByteBufToStringReturnFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("foo");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ClaimDeviceMsg JsonMqttAdaptor.convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToClaimDevice_givenCompositeByteBufToStringReturnString()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("String");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ClaimDeviceMsg JsonMqttAdaptor.convertToClaimDevice(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToClaimDevice_thenThrowIllegalStateException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf payload = mock(CompositeByteBuf.class);
    when(payload.refCnt()).thenThrow(new IllegalStateException());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> jsonMqttAdaptor.convertToClaimDevice(ctx, inbound));
    verify(payload).refCnt();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_givenCompositeByteBufToStringReturn42()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("42");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_givenCompositeByteBufToStringReturnFoo()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("foo");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_givenCompositeByteBufToStringReturnNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn(null);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link CompositeByteBuf} {@link CompositeByteBuf#toString(Charset)} return {@code
   *       String}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); given CompositeByteBuf toString(Charset) return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_givenCompositeByteBufToStringReturnString()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn("String");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); given EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_givenEmptyByteBufWithAllocIsAllocator()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
    verify(inbound).payload();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg JsonMqttAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> jsonMqttAdaptor.convertToProvisionRequestMsg(ctx, inbound));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.GetAttributeRequestMsg JsonMqttAdaptor.convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToGetAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToGetAttributes(ctx, inbound, "Topic Base"));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.GetAttributeRequestMsg JsonMqttAdaptor.convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToGetAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.variableHeader()).thenReturn(new MqttPublishVariableHeader("Topic Name", 1));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToGetAttributes(ctx, inbound, "Topic Base"));
    verify(inbound).variableHeader();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPublishVariableHeader#topicName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String); then calls topicName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.GetAttributeRequestMsg JsonMqttAdaptor.convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToGetAttributes_thenCallsTopicName() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishVariableHeader mqttPublishVariableHeader = mock(MqttPublishVariableHeader.class);
    when(mqttPublishVariableHeader.topicName()).thenReturn("Topic Name");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.variableHeader()).thenReturn(mqttPublishVariableHeader);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToGetAttributes(ctx, inbound, "Topic Base"));
    verify(inbound).variableHeader();
    verify(mqttPublishVariableHeader).topicName();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg JsonMqttAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToDeviceRpcResponse(ctx, inbound, "Topic Base"));
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg JsonMqttAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.variableHeader()).thenReturn(new MqttPublishVariableHeader("Topic Name", 1));

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToDeviceRpcResponse(ctx, inbound, "Topic Base"));
    verify(inbound).variableHeader();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPublishVariableHeader#topicName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String); then calls topicName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg JsonMqttAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse_thenCallsTopicName() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishVariableHeader mqttPublishVariableHeader = mock(MqttPublishVariableHeader.class);
    when(mqttPublishVariableHeader.topicName()).thenReturn("Topic Name");

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.variableHeader()).thenReturn(mqttPublishVariableHeader);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToDeviceRpcResponse(ctx, inbound, "Topic Base"));
    verify(inbound).variableHeader();
    verify(mqttPublishVariableHeader).topicName();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToServerRpcRequest(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <ul>
   *   <li>Given {@link JsonMqttAdaptor} (default constructor).
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage, String); given JsonMqttAdaptor (default constructor); then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToServerRpcRequestMsg JsonMqttAdaptor.convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToServerRpcRequest_givenJsonMqttAdaptor_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttPublishVariableHeader mqttPublishVariableHeader = mock(MqttPublishVariableHeader.class);
    when(mqttPublishVariableHeader.topicName()).thenReturn("Topic Name");

    CompositeByteBuf compositeByteBuf = mock(CompositeByteBuf.class);
    when(compositeByteBuf.toString(Mockito.<Charset>any())).thenReturn(null);

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload()).thenReturn(compositeByteBuf);
    when(inbound.variableHeader()).thenReturn(mqttPublishVariableHeader);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToServerRpcRequest(ctx, inbound, "Topic Base"));
    verify(compositeByteBuf).toString(isA(Charset.class));
    verify(inbound).payload();
    verify(inbound).variableHeader();
    verify(mqttPublishVariableHeader).topicName();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToServerRpcRequest(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage,
   * String)}
   */
  @Test
  @DisplayName(
      "Test convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage, String); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToServerRpcRequestMsg JsonMqttAdaptor.convertToServerRpcRequest(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToServerRpcRequest_thenThrowIllegalStateException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    CompositeByteBuf payload = mock(CompositeByteBuf.class);
    when(payload.refCnt()).thenThrow(new IllegalStateException());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToServerRpcRequest(ctx, inbound, "Topic Base"));
    verify(payload).refCnt();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code
   * chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType()
      throws UnsupportedEncodingException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code
   * chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType2()
      throws UnsupportedEncodingException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 3);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code
   * chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType3()
      throws UnsupportedEncodingException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 3);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE));
    verify(mqttTopicMatcher).matches("v2/fw/response/42/chunk/1");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code requestId}, {@code
   * chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType4()
      throws UnsupportedEncodingException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v2/fw/response/42/chunk/1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic3() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(mqttTopicMatcher).matches("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic"));
    verify(mqttTopicMatcher).matches("Topic");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic5() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(mqttTopicMatcher).matches("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic6() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic7() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedCount()).thenReturn(0);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(0);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic8() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedUpdatedList()).thenThrow(new IllegalStateException());
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic"));
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic9() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenThrow(new IllegalStateException());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(0);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic"));
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic10() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic11() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    ByteString element = mock(ByteString.class);
    when(element.toStringUtf8()).thenThrow(new IllegalStateException());

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic"));
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic12() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(false);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic13() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic14() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    ByteString element2 = mock(ByteString.class);
    when(element2.isValidUtf8()).thenReturn(true);
    when(element2.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element2);
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(element2).isValidUtf8();
    verify(element).isValidUtf8();
    verify(element2).toStringUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <ul>
   *   <li>Given emptyList.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'; given emptyList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic_givenEmptyList() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(LazyStringArrayList.emptyList());
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, notificationMsg, "Topic");

    // Assert
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceSessionCtx#nextMsgId()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'; then calls nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic_thenCallsNextMsgId() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("/provision/response"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse3() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("/provision/response");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance()));
    verify(mqttTopicMatcher).matches("/provision/response");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse5() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("/provision/response");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; given 'ACCESS_TOKEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_givenAccessToken() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.getCredentialsValue()).thenThrow(new IllegalStateException());
    when(provisionResponse.getCredentialsType()).thenReturn(CredentialsType.ACCESS_TOKEN);
    when(provisionResponse.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, provisionResponse));
    verify(provisionResponse).getCredentialsType();
    verify(provisionResponse).getCredentialsValue();
    verify(provisionResponse, atLeast(1)).getStatus();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.ResponseStatus#FAILURE}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; given FAILURE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_givenFailure() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.getStatus()).thenReturn(ResponseStatus.FAILURE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, provisionResponse);

    // Assert
    verify(provisionResponse, atLeast(1)).getStatus();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("/provision/response");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; given 'LWM2M_CREDENTIALS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_givenLwm2mCredentials() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.getCredentialsType()).thenReturn(CredentialsType.LWM2M_CREDENTIALS);
    when(provisionResponse.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, provisionResponse);

    // Assert
    verify(provisionResponse, atLeast(1)).getCredentialsType();
    verify(provisionResponse, atLeast(1)).getStatus();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("/provision/response");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.ResponseStatus#NOT_FOUND}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; given NOT_FOUND")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_givenNot_found() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.getStatus()).thenReturn(ResponseStatus.NOT_FOUND);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, provisionResponse);

    // Assert
    verify(provisionResponse).getStatus();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("/provision/response");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_givenNull() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.getCredentialsValue()).thenReturn(null);
    when(provisionResponse.getCredentialsType()).thenReturn(CredentialsType.ACCESS_TOKEN);
    when(provisionResponse.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, provisionResponse);

    // Assert
    verify(provisionResponse, atLeast(1)).getCredentialsType();
    verify(provisionResponse).getCredentialsValue();
    verify(provisionResponse, atLeast(1)).getStatus();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("/provision/response");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceSessionCtx#nextMsgId()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; then calls nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_thenCallsNextMsgId() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("/provision/response");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "/provision/response", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>When {@link DeviceSessionCtx}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; when DeviceSessionCtx")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_whenDeviceSessionCtx() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    ProvisionDeviceResponseMsg provisionResponse = mock(ProvisionDeviceResponseMsg.class);
    when(provisionResponse.getCredentialsValue()).thenThrow(new IllegalStateException());
    when(provisionResponse.getCredentialsType()).thenReturn(CredentialsType.MQTT_BASIC);
    when(provisionResponse.getStatus()).thenReturn(ResponseStatus.UNKNOWN);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, provisionResponse));
    verify(provisionResponse).getCredentialsType();
    verify(provisionResponse).getCredentialsValue();
    verify(provisionResponse, atLeast(1)).getStatus();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase2() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase3() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase4() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(mqttTopicMatcher).matches("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase5() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base"));
    verify(mqttTopicMatcher).matches("Topic Base0");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase6() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(mqttTopicMatcher).matches("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase7() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase8() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase9() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getClientAttributeListCount()).thenReturn(3);
    when(responseMsg.getRequestId()).thenReturn(0);
    when(responseMsg.getSharedAttributeListCount()).thenReturn(0);
    when(responseMsg.getError()).thenReturn("");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base");

    // Assert
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    verify(responseMsg).getSharedAttributeListCount();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase10() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getClientAttributeListList()).thenThrow(new IllegalStateException());
    when(responseMsg.getClientAttributeListCount()).thenReturn(3);
    when(responseMsg.getRequestId()).thenReturn(0);
    when(responseMsg.getError()).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base"));
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase11() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getClientAttributeListCount()).thenReturn(3);
    when(responseMsg.getRequestId()).thenReturn(0);
    when(responseMsg.getSharedAttributeListCount()).thenReturn(3);
    when(responseMsg.getError()).thenReturn("");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base");

    // Assert
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    verify(responseMsg).getSharedAttributeListCount();
    verify(responseMsg).getSharedAttributeListList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase12() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getSharedAttributeListList()).thenThrow(new IllegalStateException());
    when(responseMsg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getClientAttributeListCount()).thenReturn(3);
    when(responseMsg.getRequestId()).thenReturn(0);
    when(responseMsg.getSharedAttributeListCount()).thenReturn(3);
    when(responseMsg.getError()).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base"));
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    verify(responseMsg).getSharedAttributeListCount();
    verify(responseMsg).getSharedAttributeListList();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_thenReturnNotPresent()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getRequestId()).thenReturn(-1);
    when(responseMsg.getError()).thenReturn(null);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base");

    // Assert
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    assertFalse(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_thenThrowAdaptorException()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("An error occurred");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToPublish(ctx, responseMsg, "Topic Base"));
    verify(responseMsg, atLeast(1)).getError();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("method"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase3() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(mqttTopicMatcher).matches("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase5() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base"));
    verify(mqttTopicMatcher).matches("Topic Base0");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase6() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_given42() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("42");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcRequest, "Topic Base");

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; given 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_givenFoo() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("foo");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcRequest, "Topic Base");

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_givenIllegalStateException() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code Params}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; given 'Params'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_givenParams() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("Params");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcRequest, "Topic Base");

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_givenZero() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("method"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(mqttTopicMatcher).matches("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase3() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(mqttTopicMatcher).matches("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase5() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base"));
    verify(mqttTopicMatcher).matches("Topic Base0");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase6() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_given42() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToServerRpcResponseMsg rpcResponse = mock(ToServerRpcResponseMsg.class);
    when(rpcResponse.getError()).thenReturn("");
    when(rpcResponse.getRequestId()).thenReturn(1);
    when(rpcResponse.getPayload()).thenReturn("42");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcResponse, "Topic Base");

    // Assert
    verify(rpcResponse).getError();
    verify(rpcResponse).getPayload();
    verify(rpcResponse).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_givenAnErrorOccurred() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToServerRpcResponseMsg rpcResponse = mock(ToServerRpcResponseMsg.class);
    when(rpcResponse.getRequestId()).thenReturn(1);
    when(rpcResponse.getError()).thenReturn("An error occurred");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcResponse, "Topic Base");

    // Assert
    verify(rpcResponse, atLeast(1)).getError();
    verify(rpcResponse).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_givenFoo() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToServerRpcResponseMsg rpcResponse = mock(ToServerRpcResponseMsg.class);
    when(rpcResponse.getError()).thenReturn("");
    when(rpcResponse.getRequestId()).thenReturn(1);
    when(rpcResponse.getPayload()).thenReturn("foo");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcResponse, "Topic Base");

    // Assert
    verify(rpcResponse).getError();
    verify(rpcResponse).getPayload();
    verify(rpcResponse).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_givenIllegalStateException() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToPublish(
                ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base"));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base0");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_givenNull() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToServerRpcResponseMsg rpcResponse = mock(ToServerRpcResponseMsg.class);
    when(rpcResponse.getError()).thenReturn(null);
    when(rpcResponse.getRequestId()).thenReturn(1);
    when(rpcResponse.getPayload()).thenReturn("Payload");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcResponse, "Topic Base");

    // Assert
    verify(rpcResponse).getError();
    verify(rpcResponse).getPayload();
    verify(rpcResponse).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given {@code Payload}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given 'Payload'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_givenPayload() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToServerRpcResponseMsg rpcResponse = mock(ToServerRpcResponseMsg.class);
    when(rpcResponse.getError()).thenReturn("");
    when(rpcResponse.getRequestId()).thenReturn(1);
    when(rpcResponse.getPayload()).thenReturn("Payload");

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(ctx, rpcResponse, "Topic Base");

    // Assert
    verify(rpcResponse).getError();
    verify(rpcResponse).getPayload();
    verify(rpcResponse).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic Base1");
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("Topic Base1", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_givenZero() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        jsonMqttAdaptor.convertToPublish(
            ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base");

    // Assert
    verify(mqttTopicMatcher).matches("Topic Base0");
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
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return AsString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName("Test validateJsonPayload(UUID, ByteBuf); given '42'; then return AsString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_given42_thenReturnAsStringIs42() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn("42");

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    verify(payloadData).toString(isA(Charset.class));
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    assertEquals("42", actualValidateJsonPayloadResult.getAsString());
    assertEquals('4', actualValidateJsonPayloadResult.getAsCharacter());
    assertEquals(42, actualValidateJsonPayloadResult.getAsInt());
    assertEquals(42.0d, actualValidateJsonPayloadResult.getAsDouble());
    assertEquals(42.0f, actualValidateJsonPayloadResult.getAsFloat());
    assertEquals(42L, actualValidateJsonPayloadResult.getAsLong());
    assertEquals((short) 42, actualValidateJsonPayloadResult.getAsShort());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isString());
    assertTrue(((JsonPrimitive) actualValidateJsonPayloadResult).isNumber());
    assertEquals(new BigDecimal("42"), actualValidateJsonPayloadResult.getAsBigDecimal());
    assertEquals('*', actualValidateJsonPayloadResult.getAsByte());
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test validateJsonPayload(UUID, ByteBuf); given EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_givenEmptyByteBufWithAllocIsAllocator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    CompositeByteBuf payloadData = Unpooled.compositeBuffer(3);
    payloadData.addComponent(
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));
    payloadData.writeByte(42);

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("*", actualValidateJsonPayloadResult.getAsString());
    assertEquals("*", asNumber.toString());
    assertEquals('*', actualValidateJsonPayloadResult.getAsCharacter());
    JsonPrimitive actualAsJsonPrimitive = actualValidateJsonPayloadResult.getAsJsonPrimitive();
    assertSame(actualValidateJsonPayloadResult, actualAsJsonPrimitive);
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return AsString is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test validateJsonPayload(UUID, ByteBuf); given 'foo'; then return AsString is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_givenFoo_thenReturnAsStringIsFoo() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn("foo");

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    verify(payloadData).toString(isA(Charset.class));
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("foo", actualValidateJsonPayloadResult.getAsString());
    assertEquals("foo", asNumber.toString());
    assertEquals('f', actualValidateJsonPayloadResult.getAsCharacter());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isNumber());
    assertTrue(((JsonPrimitive) actualValidateJsonPayloadResult).isString());
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>Then return AsString is {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test validateJsonPayload(UUID, ByteBuf); given forty-two; then return AsString is '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_givenFortyTwo_thenReturnAsStringIsAsterisk()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    CompositeByteBuf payloadData = Unpooled.compositeBuffer(3);
    payloadData.writeByte(42);

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("*", actualValidateJsonPayloadResult.getAsString());
    assertEquals("*", asNumber.toString());
    assertEquals('*', actualValidateJsonPayloadResult.getAsCharacter());
    JsonPrimitive actualAsJsonPrimitive = actualValidateJsonPayloadResult.getAsJsonPrimitive();
    assertSame(actualValidateJsonPayloadResult, actualAsJsonPrimitive);
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName("Test validateJsonPayload(UUID, ByteBuf); given 'null'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_givenNull_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData));
    verify(payloadData).toString(isA(Charset.class));
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return AsString is {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test validateJsonPayload(UUID, ByteBuf); given 'String'; then return AsString is 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_givenString_thenReturnAsStringIsString() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    CompositeByteBuf payloadData = mock(CompositeByteBuf.class);
    when(payloadData.toString(Mockito.<Charset>any())).thenReturn("String");

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(sessionId, payloadData);

    // Assert
    verify(payloadData).toString(isA(Charset.class));
    assertTrue(actualValidateJsonPayloadResult instanceof JsonPrimitive);
    Number asNumber = actualValidateJsonPayloadResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("String", actualValidateJsonPayloadResult.getAsString());
    assertEquals("String", asNumber.toString());
    assertEquals('S', actualValidateJsonPayloadResult.getAsCharacter());
    assertFalse(((JsonPrimitive) actualValidateJsonPayloadResult).isNumber());
    assertTrue(((JsonPrimitive) actualValidateJsonPayloadResult).isString());
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test validateJsonPayload(UUID, ByteBuf); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(
            sessionId, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonNull);
    assertFalse(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(actualValidateJsonPayloadResult.isJsonNull());
    assertSame(
        ((JsonNull) actualValidateJsonPayloadResult).INSTANCE,
        actualValidateJsonPayloadResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   *   <li>Then return {@link JsonNull}.
   * </ul>
   *
   * <p>Method under test: {@link JsonMqttAdaptor#validateJsonPayload(UUID, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test validateJsonPayload(UUID, ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then return JsonNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonElement JsonMqttAdaptor.validateJsonPayload(UUID, ByteBuf)"})
  void testValidateJsonPayload_whenEmptyByteBufWithAllocIsAllocator_thenReturnJsonNull()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    JsonElement actualValidateJsonPayloadResult =
        JsonMqttAdaptor.validateJsonPayload(
            sessionId, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Assert
    assertTrue(actualValidateJsonPayloadResult instanceof JsonNull);
    assertFalse(actualValidateJsonPayloadResult.isJsonPrimitive());
    assertTrue(actualValidateJsonPayloadResult.isJsonNull());
    assertSame(
        ((JsonNull) actualValidateJsonPayloadResult).INSTANCE,
        actualValidateJsonPayloadResult.getAsJsonNull());
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonArray(3));

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson2() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = mock(JsonArray.class);
    doNothing().when(json).add(Mockito.<Boolean>any());
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(json).add(true);
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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson3() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, -1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    JsonArray json = mock(JsonArray.class);
    doNothing().when(json).add(Mockito.<Boolean>any());
    json.add(true);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json));
    verify(json).add(true);
    verify(mqttTopicMatcher).matches("Topic");
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_givenA() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    JsonArray json = new JsonArray(3);
    json.add('A');
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_givenFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    JsonArray json = new JsonArray(3);
    json.add(false);
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_givenIllegalStateException() {
    // Arrange
    MqttDeviceAwareSessionContext ctx = mock(MqttDeviceAwareSessionContext.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    JsonArray json = mock(JsonArray.class);
    doNothing().when(json).add(Mockito.<Boolean>any());
    json.add(true);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json));
    verify(json).add(true);
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("Topic");
  }

  /**
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>Given valueOf one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; given valueOf one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_givenValueOfOne() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    JsonArray json = new JsonArray(3);
    json.add(Integer.valueOf(1));
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>Then calls {@link JsonArray#add(Boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; then calls add(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_thenCallsAdd() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    JsonArray json = mock(JsonArray.class);
    doNothing().when(json).add(Mockito.<Boolean>any());
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

    // Assert
    verify(json).add(true);
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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonArray(int) with capacity is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonArrayWithCapacityIsThree() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonArray(3));

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>When {@link JsonArray#JsonArray(int)} with capacity is three add {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonArray(int) with capacity is three add 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonArrayWithCapacityIsThreeAddTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    JsonArray json = new JsonArray(3);
    json.add(true);

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", json);

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>When {@link JsonNull} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonNull (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonNull() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonNull());

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
   * Test {@link JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String,
   * JsonElement)} with {@code ctx}, {@code topic}, {@code json}.
   *
   * <ul>
   *   <li>When {@link JsonObject} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)}
   */
  @Test
  @DisplayName(
      "Test createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement) with 'ctx', 'topic', 'json'; when JsonObject (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttPublishMessage JsonMqttAdaptor.createMqttPublishMsg(MqttDeviceAwareSessionContext, String, JsonElement)"
  })
  void testCreateMqttPublishMsgWithCtxTopicJson_whenJsonObject() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttPublishMessage actualCreateMqttPublishMsgResult =
        jsonMqttAdaptor.createMqttPublishMsg(ctx, "Topic", new JsonObject());

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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("device"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg3() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/attributes"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg5() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToGatewayPublish(
                ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance()));
    verify(mqttTopicMatcher).matches("v1/gateway/attributes");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg6() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("device"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg7() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToGatewayPublish(
                ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg8() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedCount()).thenReturn(0);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(0);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg);

    // Assert
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg9() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg10() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    ByteString element = mock(ByteString.class);
    when(element.toStringUtf8()).thenThrow(new IllegalStateException());

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg));
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg11() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(false);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg12() {
    // Arrange
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    ByteString element2 = mock(ByteString.class);
    when(element2.isValidUtf8()).thenReturn(true);
    when(element2.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element2);
    lazyStringArrayList.add(element);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(lazyStringArrayList);
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg);

    // Assert
    verify(element2).isValidUtf8();
    verify(element).isValidUtf8();
    verify(element2).toStringUtf8();
    verify(element).toStringUtf8();
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>Given emptyList.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; given emptyList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_givenEmptyList() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(LazyStringArrayList.emptyList());
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg);

    // Assert
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>Given minus one.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; given minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_givenMinusOne() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenThrow(new IllegalStateException());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(-1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", notificationMsg));
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceSessionCtx#nextMsgId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; then calls nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_thenCallsNextMsgId() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code notificationMsg}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_whenEmptyString() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    AttributeUpdateNotificationMsg notificationMsg = mock(AttributeUpdateNotificationMsg.class);
    when(notificationMsg.getSharedDeletedList()).thenReturn(LazyStringArrayList.emptyList());
    when(notificationMsg.getSharedUpdatedList()).thenReturn(new ArrayList<>());
    when(notificationMsg.getSharedDeletedCount()).thenReturn(1);
    when(notificationMsg.getSharedUpdatedCount()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "", notificationMsg);

    // Assert
    verify(notificationMsg).getSharedDeletedCount();
    verify(notificationMsg).getSharedDeletedList();
    verify(notificationMsg).getSharedUpdatedCount();
    verify(notificationMsg).getSharedUpdatedList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg2() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("id"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg3() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/attributes/response"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg4() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/attributes/response");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg5() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToGatewayPublish(
                ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance()));
    verify(mqttTopicMatcher).matches("v1/gateway/attributes/response");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg6() throws AdaptorException {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("id"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/attributes/response");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg7() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes/response");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg8() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToGatewayPublish(
                ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes/response");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg9() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getError()).thenReturn("An error occurred");

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", responseMsg));
    verify(responseMsg, atLeast(1)).getError();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg10() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getIsMultipleAttributesRequest()).thenReturn(false);
    when(responseMsg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getClientAttributeListCount()).thenReturn(1);
    when(responseMsg.getSharedAttributeListCount()).thenReturn(1);
    when(responseMsg.getError()).thenReturn(null);
    when(responseMsg.getRequestId()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", responseMsg);

    // Assert
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg, atLeast(1)).getIsMultipleAttributesRequest();
    verify(responseMsg).getRequestId();
    verify(responseMsg).getSharedAttributeListCount();
    verify(responseMsg).getSharedAttributeListList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes/response");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg11() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getClientAttributeListList()).thenThrow(new IllegalStateException());
    when(responseMsg.getClientAttributeListCount()).thenReturn(1);
    when(responseMsg.getError()).thenReturn(null);
    when(responseMsg.getRequestId()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", responseMsg));
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg12() throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getSharedAttributeListList()).thenThrow(new IllegalStateException());
    when(responseMsg.getClientAttributeListCount()).thenReturn(0);
    when(responseMsg.getSharedAttributeListCount()).thenReturn(1);
    when(responseMsg.getError()).thenReturn(null);
    when(responseMsg.getRequestId()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", responseMsg));
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getError();
    verify(responseMsg).getRequestId();
    verify(responseMsg).getSharedAttributeListCount();
    verify(responseMsg).getSharedAttributeListList();
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg_whenEmptyString()
      throws AdaptorException {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    GetAttributeResponseMsg responseMsg = mock(GetAttributeResponseMsg.class);
    when(responseMsg.getIsMultipleAttributesRequest()).thenReturn(false);
    when(responseMsg.getClientAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getSharedAttributeListList()).thenReturn(new ArrayList<>());
    when(responseMsg.getClientAttributeListCount()).thenReturn(1);
    when(responseMsg.getSharedAttributeListCount()).thenReturn(1);
    when(responseMsg.getError()).thenReturn(null);
    when(responseMsg.getRequestId()).thenReturn(1);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "", responseMsg);

    // Assert
    verify(responseMsg).getClientAttributeListCount();
    verify(responseMsg).getClientAttributeListList();
    verify(responseMsg).getError();
    verify(responseMsg, atLeast(1)).getIsMultipleAttributesRequest();
    verify(responseMsg).getRequestId();
    verify(responseMsg).getSharedAttributeListCount();
    verify(responseMsg).getSharedAttributeListList();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/attributes/response");
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest3() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/rpc");
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToGatewayPublish(
                ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance()));
    verify(mqttTopicMatcher).matches("v1/gateway/rpc");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest5() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            jsonMqttAdaptor.convertToGatewayPublish(
                ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance()));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/rpc");
  }

  /**
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_given42() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("42");

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", rpcRequest);

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/rpc");
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Given {@code data}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; given 'data'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_givenData() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("data");

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", rpcRequest);

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/rpc");
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; given 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_givenFoo() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("foo");

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", rpcRequest);

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/rpc");
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Given {@code Params}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; given 'Params'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_givenParams() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    ToDeviceRpcRequestMsg rpcRequest = mock(ToDeviceRpcRequestMsg.class);
    when(rpcRequest.getMethodName()).thenReturn(null);
    when(rpcRequest.getRequestId()).thenReturn(1);
    when(rpcRequest.getParams()).thenReturn("Params");

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(ctx, "Device Name", rpcRequest);

    // Assert
    verify(rpcRequest).getMethodName();
    verify(rpcRequest).getParams();
    verify(rpcRequest).getRequestId();
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/rpc");
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_givenZero() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/rpc");
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
   * Test {@link JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceSessionCtx#nextMsgId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; then calls nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_thenCallsNextMsgId() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        jsonMqttAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/rpc");
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish2() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish3() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/disconnect");
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish4() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenThrow(new IllegalStateException());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1));
    verify(mqttTopicMatcher).matches("v1/gateway/disconnect");
  }

  /**
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish5() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/disconnect");
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); given IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_givenIllegalStateException() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenThrow(new IllegalStateException());
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1));
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/disconnect");
  }

  /**
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); given zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_givenZero() {
    // Arrange
    MqttTopicMatcher mqttTopicMatcher = mock(MqttTopicMatcher.class);
    when(mqttTopicMatcher.matches(Mockito.<String>any())).thenReturn(true);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/disconnect"), 0);
    mqttQoSMap.put(mqttTopicMatcher, 1);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1);

    // Assert
    verify(mqttTopicMatcher).matches("v1/gateway/disconnect");
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then calls {@link DeviceSessionCtx#nextMsgId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when empty string; then calls nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_whenEmptyString_thenCallsNextMsgId() {
    // Arrange
    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.nextMsgId()).thenReturn(1);
    when(ctx.getQoSForTopic(Mockito.<String>any())).thenReturn(MqttQoS.AT_MOST_ONCE);

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, "", 1);

    // Assert
    verify(ctx).nextMsgId();
    verify(ctx).getQoSForTopic("v1/gateway/disconnect");
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
   * Test {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * JsonMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String,
   * int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional JsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_whenNull() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult =
        jsonMqttAdaptor.convertToGatewayDeviceDisconnectPublish(ctx, null, 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
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
