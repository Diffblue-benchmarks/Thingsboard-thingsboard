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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Any;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.UnknownFieldSet;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttTopicSubscription;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.leshan.core.ResponseCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.GetOrCreateDeviceFromGatewayResponse;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload;
import org.thingsboard.server.gen.transport.mqtt.SparkplugBProto.Payload.Metric;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.MqttTransportHandler;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;
import org.thingsboard.server.transport.mqtt.gateway.GatewayMetricsService;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugMessageType;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugTopic;

class SparkplugNodeSessionHandlerDiffblueTest {
  /**
   * Test {@link SparkplugNodeSessionHandler#SparkplugNodeSessionHandler(MqttTransportHandler,
   * DeviceSessionCtx, UUID, boolean, SparkplugTopic)}.
   *
   * <ul>
   *   <li>Then return {@link AbstractGatewaySessionHandler#channel} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#SparkplugNodeSessionHandler(MqttTransportHandler, DeviceSessionCtx,
   * UUID, boolean, SparkplugTopic)}
   */
  @Test
  @DisplayName(
      "Test new SparkplugNodeSessionHandler(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic); then return channel is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.<init>(MqttTransportHandler, DeviceSessionCtx, UUID, boolean, SparkplugTopic)"
  })
  void testNewSparkplugNodeSessionHandler_thenReturnChannelIsNull() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    // Act
    SparkplugNodeSessionHandler actualSparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Assert
    assertNull(actualSparkplugNodeSessionHandler.channel);
    assertNull(actualSparkplugNodeSessionHandler.transportService);
    assertNull(actualSparkplugNodeSessionHandler.gateway);
    assertNull(actualSparkplugNodeSessionHandler.getPayloadAdaptor());
    assertNull(actualSparkplugNodeSessionHandler.gatewayMetricsService);
    assertTrue(actualSparkplugNodeSessionHandler.getNodeBirthMetrics().isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.mqttQoSMap.isEmpty());
    assertTrue(actualSparkplugNodeSessionHandler.isJsonPayloadType());
    assertTrue(actualSparkplugNodeSessionHandler.isOverwriteDevicesActivity());
    assertSame(sparkplugTopicNode, actualSparkplugNodeSessionHandler.getSparkplugTopicNode());
    assertSame(sessionId2, actualSparkplugNodeSessionHandler.getSessionId());
    assertSame(actualSparkplugNodeSessionHandler.context, deviceSessionCtx.getContext());
    assertSame(actualSparkplugNodeSessionHandler.mqttQoSMap, deviceSessionCtx.getMqttQoSMap());
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)} with {@code ctx}, {@code inbound}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage) with 'ctx', 'inbound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg SparkplugNodeSessionHandler.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetryWithCtxInbound() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    Descriptor descriptor = PostTelemetryMsg.getDescriptor();
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(descriptor);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    Descriptor descriptorForType = actualConvertToPostTelemetryResult.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(1, getResult.getKvList().size());
    assertEquals(1, getResult.getKvCount());
    assertSame(descriptor, fields.get(0).getContainingType());
    assertSame(
        descriptor,
        actualConvertToPostTelemetryResult.getDefaultInstanceForType().getDescriptorForType());
    assertSame(descriptor, descriptorForType);
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)} with {@code ctx}, {@code inbound}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage) with 'ctx', 'inbound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg SparkplugNodeSessionHandler.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetryWithCtxInbound2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(SessionInfoProto.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(Short.SIZE, getResult.getKvList().size());
    assertEquals(Short.SIZE, getResult.getKvCount());
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)} with {@code ctx}, {@code inbound}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage) with 'ctx', 'inbound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg SparkplugNodeSessionHandler.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetryWithCtxInbound3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(Any.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    List<TsKvListProto> tsKvListList = actualConvertToPostTelemetryResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TsKvListProto getResult = tsKvListList.get(0);
    assertEquals(0, getResult.getKvCount());
    assertEquals(1, getResult.getAllFields().size());
    assertTrue(getResult.getKvList().isEmpty());
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)} with {@code ctx}, {@code inbound}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage) with 'ctx', 'inbound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg SparkplugNodeSessionHandler.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetryWithCtxInbound4() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenReturn(PostTelemetryMsg.getDescriptor());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act
    PostTelemetryMsg actualConvertToPostTelemetryResult =
        sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound);

    // Assert
    verify(ctx).getTelemetryDynamicMsgDescriptor();
    UnknownFieldSet unknownFields = actualConvertToPostTelemetryResult.getUnknownFields();
    PostTelemetryMsg defaultInstanceForType =
        actualConvertToPostTelemetryResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)} with {@code ctx}, {@code inbound}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage) with 'ctx', 'inbound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg SparkplugNodeSessionHandler.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetryWithCtxInbound5() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenThrow(new RuntimeException());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage inbound =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound));
    verify(ctx).getTelemetryDynamicMsgDescriptor();
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)} with {@code ctx}, {@code inbound}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPublishMessage#payload()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage) with 'ctx', 'inbound'; then calls payload()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg SparkplugNodeSessionHandler.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetryWithCtxInbound_thenCallsPayload() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    DeviceSessionCtx ctx = mock(DeviceSessionCtx.class);
    when(ctx.getTelemetryDynamicMsgDescriptor()).thenThrow(new RuntimeException());

    MqttPublishMessage inbound = mock(MqttPublishMessage.class);
    when(inbound.payload())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sparkplugNodeSessionHandler.convertToPostTelemetry(ctx, inbound));
    verify(inbound).payload();
    verify(ctx).getTelemetryDynamicMsgDescriptor();
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int, Payload,
   * SparkplugTopic)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link SparkplugBProto.Payload}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int,
   * SparkplugBProto.Payload, SparkplugTopic)}
   */
  @Test
  @DisplayName(
      "Test onAttributesTelemetryProto(int, Payload, SparkplugTopic); given empty string; when Payload")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.onAttributesTelemetryProto(int, SparkplugBProto.Payload, SparkplugTopic)"
  })
  void testOnAttributesTelemetryProto_givenEmptyString_whenPayload()
      throws AdaptorException, ThingsboardException {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(mock(TransportService.class));
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.getGatewayMetricsService()).thenReturn(new GatewayMetricsService());
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);
    Payload sparkplugBProto = mock(Payload.class);

    SparkplugTopic topic = mock(SparkplugTopic.class);
    when(topic.getNodeDeviceName()).thenReturn("");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sparkplugNodeSessionHandler.onAttributesTelemetryProto(1, sparkplugBProto, topic));
    verify(context).getTransportService();
    verify(context).getGatewayMetricsService();
    verify(context).getJsonMqttAdaptor();
    verify(topic).getNodeDeviceName();
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int, Payload,
   * SparkplugTopic)}.
   *
   * <ul>
   *   <li>Then calls {@link TransportService#process(SessionInfoProto, PostTelemetryMsg,
   *       TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int,
   * SparkplugBProto.Payload, SparkplugTopic)}
   */
  @Test
  @DisplayName(
      "Test onAttributesTelemetryProto(int, Payload, SparkplugTopic); then calls process(SessionInfoProto, PostTelemetryMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.onAttributesTelemetryProto(int, SparkplugBProto.Payload, SparkplugTopic)"
  })
  void testOnAttributesTelemetryProto_thenCallsProcess()
      throws AdaptorException, ThingsboardException {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.getGatewayMetricsService()).thenReturn(new GatewayMetricsService());
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    Payload sparkplugBProto = mock(Payload.class);
    when(sparkplugBProto.getMetricsList()).thenThrow(new RuntimeException());
    when(sparkplugBProto.getTimestamp()).thenReturn(10L);

    SparkplugTopic topic = mock(SparkplugTopic.class);
    when(topic.isType(Mockito.<SparkplugMessageType>any())).thenReturn(true);
    when(topic.isNode()).thenReturn(true);
    when(topic.getNodeDeviceName()).thenReturn("Node Device Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sparkplugNodeSessionHandler.onAttributesTelemetryProto(1, sparkplugBProto, topic));
    verify(context).getTransportService();
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    verify(sparkplugBProto).getMetricsList();
    verify(sparkplugBProto).getTimestamp();
    verify(context).getGatewayMetricsService();
    verify(context).getJsonMqttAdaptor();
    verify(topic).getNodeDeviceName();
    verify(topic).isNode();
    verify(topic).isType(SparkplugMessageType.NBIRTH);
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int, Payload,
   * SparkplugTopic)}.
   *
   * <ul>
   *   <li>When {@link SparkplugTopic} {@link SparkplugTopic#isNode()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int,
   * SparkplugBProto.Payload, SparkplugTopic)}
   */
  @Test
  @DisplayName(
      "Test onAttributesTelemetryProto(int, Payload, SparkplugTopic); when SparkplugTopic isNode() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.onAttributesTelemetryProto(int, SparkplugBProto.Payload, SparkplugTopic)"
  })
  void testOnAttributesTelemetryProto_whenSparkplugTopicIsNodeThrowRuntimeException()
      throws AdaptorException, ThingsboardException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);
    Payload sparkplugBProto = Payload.getDefaultInstance();

    SparkplugTopic topic = mock(SparkplugTopic.class);
    when(topic.isNode()).thenThrow(new RuntimeException());
    when(topic.getNodeDeviceName()).thenReturn("Node Device Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sparkplugNodeSessionHandler.onAttributesTelemetryProto(1, sparkplugBProto, topic));
    verify(topic).getNodeDeviceName();
    verify(topic).isNode();
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int, Payload,
   * SparkplugTopic)}.
   *
   * <ul>
   *   <li>When {@link SparkplugTopic} {@link SparkplugTopic#isType(SparkplugMessageType)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#onAttributesTelemetryProto(int,
   * SparkplugBProto.Payload, SparkplugTopic)}
   */
  @Test
  @DisplayName(
      "Test onAttributesTelemetryProto(int, Payload, SparkplugTopic); when SparkplugTopic isType(SparkplugMessageType) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.onAttributesTelemetryProto(int, SparkplugBProto.Payload, SparkplugTopic)"
  })
  void testOnAttributesTelemetryProto_whenSparkplugTopicIsTypeThrowRuntimeException()
      throws AdaptorException, ThingsboardException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);
    Payload sparkplugBProto = Payload.getDefaultInstance();

    SparkplugTopic topic = mock(SparkplugTopic.class);
    when(topic.isType(Mockito.<SparkplugMessageType>any())).thenThrow(new RuntimeException());
    when(topic.isNode()).thenReturn(true);
    when(topic.getNodeDeviceName()).thenReturn("Node Device Name");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> sparkplugNodeSessionHandler.onAttributesTelemetryProto(1, sparkplugBProto, topic));
    verify(topic).getNodeDeviceName();
    verify(topic).isNode();
    verify(topic).isType(SparkplugMessageType.NBIRTH);
  }

  /**
   * Test {@link
   * SparkplugNodeSessionHandler#newDeviceSessionCtx(GetOrCreateDeviceFromGatewayResponse)}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#newDeviceSessionCtx(GetOrCreateDeviceFromGatewayResponse)}
   */
  @Test
  @DisplayName("Test newDeviceSessionCtx(GetOrCreateDeviceFromGatewayResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.transport.mqtt.session.SparkplugDeviceSessionContext SparkplugNodeSessionHandler.newDeviceSessionCtx(GetOrCreateDeviceFromGatewayResponse)"
  })
  void testNewDeviceSessionCtx() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    GetOrCreateDeviceFromGatewayResponse msg = mock(GetOrCreateDeviceFromGatewayResponse.class);
    when(msg.getDeviceInfo()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> sparkplugNodeSessionHandler.newDeviceSessionCtx(msg));
    verify(msg).getDeviceInfo();
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#sendToDeviceRpcRequest(MqttMessage,
   * ToDeviceRpcRequestMsg, SessionInfoProto)}.
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#sendToDeviceRpcRequest(MqttMessage,
   * TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test sendToDeviceRpcRequest(MqttMessage, ToDeviceRpcRequestMsg, SessionInfoProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.sendToDeviceRpcRequest(MqttMessage, TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)"
  })
  void testSendToDeviceRpcRequest() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doNothing()
        .when(parent)
        .sendToDeviceRpcRequest(
            Mockito.<MqttMessage>any(),
            Mockito.<ToDeviceRpcRequestMsg>any(),
            Mockito.<SessionInfoProto>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Act
    sparkplugNodeSessionHandler.sendToDeviceRpcRequest(
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)),
        ToDeviceRpcRequestMsg.getDefaultInstance(),
        SessionInfoProto.getDefaultInstance());

    // Assert
    verify(parent)
        .sendToDeviceRpcRequest(
            isA(MqttMessage.class), isA(ToDeviceRpcRequestMsg.class), isA(SessionInfoProto.class));
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#sendToDeviceRpcRequest(MqttMessage,
   * ToDeviceRpcRequestMsg, SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#sendToDeviceRpcRequest(MqttMessage,
   * TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test sendToDeviceRpcRequest(MqttMessage, ToDeviceRpcRequestMsg, SessionInfoProto); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.sendToDeviceRpcRequest(MqttMessage, TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)"
  })
  void testSendToDeviceRpcRequest_thenThrowRuntimeException() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doThrow(new RuntimeException())
        .when(parent)
        .sendToDeviceRpcRequest(
            Mockito.<MqttMessage>any(),
            Mockito.<ToDeviceRpcRequestMsg>any(),
            Mockito.<SessionInfoProto>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            sparkplugNodeSessionHandler.sendToDeviceRpcRequest(
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)),
                ToDeviceRpcRequestMsg.getDefaultInstance(),
                SessionInfoProto.getDefaultInstance()));
    verify(parent)
        .sendToDeviceRpcRequest(
            isA(MqttMessage.class), isA(ToDeviceRpcRequestMsg.class), isA(SessionInfoProto.class));
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#sendErrorRpcResponse(SessionInfoProto, int,
   * ThingsboardErrorCode, String)}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int,
   * ThingsboardErrorCode, String)}
   */
  @Test
  @DisplayName("Test sendErrorRpcResponse(SessionInfoProto, int, ThingsboardErrorCode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)"
  })
  void testSendErrorRpcResponse() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doNothing()
        .when(parent)
        .sendErrorRpcResponse(
            Mockito.<SessionInfoProto>any(),
            anyInt(),
            Mockito.<ThingsboardErrorCode>any(),
            Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Act
    sparkplugNodeSessionHandler.sendErrorRpcResponse(
        SessionInfoProto.getDefaultInstance(),
        1,
        ThingsboardErrorCode.GENERAL,
        "An error occurred");

    // Assert
    verify(parent)
        .sendErrorRpcResponse(
            isA(SessionInfoProto.class),
            eq(1),
            eq(ThingsboardErrorCode.GENERAL),
            eq("An error occurred"));
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#sendErrorRpcResponse(SessionInfoProto, int,
   * ThingsboardErrorCode, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int,
   * ThingsboardErrorCode, String)}
   */
  @Test
  @DisplayName(
      "Test sendErrorRpcResponse(SessionInfoProto, int, ThingsboardErrorCode, String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)"
  })
  void testSendErrorRpcResponse_thenThrowRuntimeException() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doThrow(new RuntimeException())
        .when(parent)
        .sendErrorRpcResponse(
            Mockito.<SessionInfoProto>any(),
            anyInt(),
            Mockito.<ThingsboardErrorCode>any(),
            Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            sparkplugNodeSessionHandler.sendErrorRpcResponse(
                SessionInfoProto.getDefaultInstance(),
                1,
                ThingsboardErrorCode.GENERAL,
                "An error occurred"));
    verify(parent)
        .sendErrorRpcResponse(
            isA(SessionInfoProto.class),
            eq(1),
            eq(ThingsboardErrorCode.GENERAL),
            eq("An error occurred"));
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#sendSuccessRpcResponse(SessionInfoProto, int,
   * ResponseCode, String)}.
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int,
   * ResponseCode, String)}
   */
  @Test
  @DisplayName("Test sendSuccessRpcResponse(SessionInfoProto, int, ResponseCode, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)"
  })
  void testSendSuccessRpcResponse() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doNothing()
        .when(parent)
        .sendSuccessRpcResponse(
            Mockito.<SessionInfoProto>any(),
            anyInt(),
            Mockito.<ResponseCode>any(),
            Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    sparkplugNodeSessionHandler.sendSuccessRpcResponse(
        sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg");

    // Assert
    verify(parent)
        .sendSuccessRpcResponse(
            isA(SessionInfoProto.class), eq(1), isA(ResponseCode.class), eq("Success Msg"));
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#sendSuccessRpcResponse(SessionInfoProto, int,
   * ResponseCode, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SparkplugNodeSessionHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int,
   * ResponseCode, String)}
   */
  @Test
  @DisplayName(
      "Test sendSuccessRpcResponse(SessionInfoProto, int, ResponseCode, String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)"
  })
  void testSendSuccessRpcResponse_thenThrowRuntimeException() {
    // Arrange
    MqttTransportHandler parent = mock(MqttTransportHandler.class);
    doThrow(new RuntimeException())
        .when(parent)
        .sendSuccessRpcResponse(
            Mockito.<SessionInfoProto>any(),
            anyInt(),
            Mockito.<ResponseCode>any(),
            Mockito.<String>any());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            parent, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            sparkplugNodeSessionHandler.sendSuccessRpcResponse(
                sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg"));
    verify(parent)
        .sendSuccessRpcResponse(
            isA(SessionInfoProto.class), eq(1), isA(ResponseCode.class), eq("Success Msg"));
  }

  /**
   * Test {@link SparkplugNodeSessionHandler#handleSparkplugSubscribeMsg(List,
   * MqttTopicSubscription, MqttQoS)}.
   *
   * <ul>
   *   <li>Given {@code spBv1.0}.
   *   <li>Then calls {@link MqttTopicSubscription#topicFilter()}.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugNodeSessionHandler#handleSparkplugSubscribeMsg(List,
   * MqttTopicSubscription, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test handleSparkplugSubscribeMsg(List, MqttTopicSubscription, MqttQoS); given 'spBv1.0'; then calls topicFilter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugNodeSessionHandler.handleSparkplugSubscribeMsg(List, MqttTopicSubscription, MqttQoS)"
  })
  void testHandleSparkplugSubscribeMsg_givenSpBv10_thenCallsTopicFilter()
      throws ThingsboardException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);
    ArrayList<Integer> grantedQoSList = new ArrayList<>();

    MqttTopicSubscription subscription = mock(MqttTopicSubscription.class);
    when(subscription.topicFilter()).thenReturn("spBv1.0");

    // Act
    sparkplugNodeSessionHandler.handleSparkplugSubscribeMsg(
        grantedQoSList, subscription, MqttQoS.AT_MOST_ONCE);

    // Assert
    verify(subscription).topicFilter();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugNodeSessionHandler#getNodeBirthMetrics()}
   *   <li>{@link SparkplugNodeSessionHandler#getSparkplugTopicNode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SparkplugNodeSessionHandler.getNodeBirthMetrics()",
    "SparkplugTopic SparkplugNodeSessionHandler.getSparkplugTopicNode()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();
    SparkplugTopic sparkplugTopicNode =
        new SparkplugTopic("Namespace", "42", "42", SparkplugMessageType.NBIRTH);

    SparkplugNodeSessionHandler sparkplugNodeSessionHandler =
        new SparkplugNodeSessionHandler(
            null, deviceSessionCtx, sessionId2, true, sparkplugTopicNode);

    // Act
    Map<String, Metric> actualNodeBirthMetrics = sparkplugNodeSessionHandler.getNodeBirthMetrics();
    SparkplugTopic actualSparkplugTopicNode = sparkplugNodeSessionHandler.getSparkplugTopicNode();

    // Assert
    assertTrue(actualNodeBirthMetrics.isEmpty());
    assertSame(sparkplugTopicNode, actualSparkplugTopicNode);
  }
}
