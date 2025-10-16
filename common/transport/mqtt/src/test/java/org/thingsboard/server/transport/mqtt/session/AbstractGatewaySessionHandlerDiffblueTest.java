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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonSyntaxException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.ReadOnlyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodes;
import io.netty.handler.codec.mqtt.MqttReasonCodes.PubAck;
import io.netty.handler.codec.mqtt.MqttVersion;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;

class AbstractGatewaySessionHandlerDiffblueTest {
  /**
   * Test {@link AbstractGatewaySessionHandler#createWeakMap()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#createWeakMap()}
   */
  @Test
  @DisplayName("Test createWeakMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.springframework.util.ConcurrentReferenceHashMap AbstractGatewaySessionHandler.createWeakMap()"
  })
  void testCreateWeakMap() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertTrue(gatewaySessionHandler.createWeakMap().isEmpty());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceClaim(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceClaim(MqttPublishMessage)"})
  void testOnDeviceClaim() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceClaim(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceClaim(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceClaim(MqttPublishMessage)"})
  void testOnDeviceClaim2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceClaim(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceClaim(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceClaim(MqttPublishMessage)"})
  void testOnDeviceClaim3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceClaim(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceAttributes(MqttPublishMessage)"})
  void testOnDeviceAttributes() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributes(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceAttributes(MqttPublishMessage)"})
  void testOnDeviceAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributes(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceAttributes(MqttPublishMessage)"})
  void testOnDeviceAttributes3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributes(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributesRequest(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.onDeviceAttributesRequest(MqttPublishMessage)"
  })
  void testOnDeviceAttributesRequest() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributesRequest(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributesRequest(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.onDeviceAttributesRequest(MqttPublishMessage)"
  })
  void testOnDeviceAttributesRequest2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributesRequest(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test onDeviceAttributesRequest(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.onDeviceAttributesRequest(MqttPublishMessage)"
  })
  void testOnDeviceAttributesRequest_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributesRequest(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)} with {@code
   * mqttMsg}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceRpcResponse(MqttPublishMessage) with 'mqttMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceRpcResponse(MqttPublishMessage)"})
  void testOnDeviceRpcResponseWithMqttMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceRpcResponse(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)} with {@code
   * mqttMsg}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceRpcResponse(MqttPublishMessage) with 'mqttMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceRpcResponse(MqttPublishMessage)"})
  void testOnDeviceRpcResponseWithMqttMsg2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceRpcResponse(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)} with {@code
   * mqttMsg}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceRpcResponse(MqttPublishMessage) with 'mqttMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceRpcResponse(MqttPublishMessage)"})
  void testOnDeviceRpcResponseWithMqttMsg3() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceRpcResponse(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getNodeId()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getNodeId()}
   */
  @Test
  @DisplayName("Test getNodeId(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.getNodeId()"})
  void testGetNodeId_thenReturnNull() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertNull(gatewaySessionHandler.getNodeId());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}
   */
  @Test
  @DisplayName("Test getPayloadAdaptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttTransportAdaptor AbstractGatewaySessionHandler.getPayloadAdaptor()"})
  void testGetPayloadAdaptor() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertNull(gatewaySessionHandler.getPayloadAdaptor());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#nextMsgId()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractGatewaySessionHandler.nextMsgId()"})
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertEquals(1, gatewaySessionHandler.nextMsgId());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isJsonPayloadType()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#isJsonPayloadType()}
   */
  @Test
  @DisplayName("Test isJsonPayloadType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGatewaySessionHandler.isJsonPayloadType()"})
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertTrue(gatewaySessionHandler.isJsonPayloadType());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test getMsgId(MqttPublishMessage); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractGatewaySessionHandler.getMsgId(MqttPublishMessage)"})
  void testGetMsgId_thenReturnOne() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    int actualMsgId = gatewaySessionHandler.getMsgId(mqttMsg);

    // Assert
    assertEquals(1, actualMsgId);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceConnectJson(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceConnectJson(MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test onDeviceConnectJson(MqttPublishMessage); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceConnectJson(MqttPublishMessage)"})
  void testOnDeviceConnectJson_givenRuntimeException_thenThrowRuntimeException()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    CompositeByteBuf payload = mock(CompositeByteBuf.class);
    when(payload.refCnt()).thenThrow(new RuntimeException());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> gatewaySessionHandler.onDeviceConnectJson(mqttMsg));
    verify(payload).refCnt();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceConnectProto(MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceConnectProto(MqttPublishMessage)"})
  void testOnDeviceConnectProto() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceConnectProto(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link ByteBuf#capacity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceConnectProto(MqttPublishMessage); given three; then calls capacity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceConnectProto(MqttPublishMessage)"})
  void testOnDeviceConnectProto_givenThree_thenCallsCapacity() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    when(buffer.refCnt()).thenReturn(1);
    DuplicatedByteBuf buffer2 = new DuplicatedByteBuf(buffer);
    ReadOnlyByteBuf payload = new ReadOnlyByteBuf(buffer2);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceConnectProto(mqttMsg));
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(buffer).refCnt();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test onDeviceConnectProto(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceConnectProto(MqttPublishMessage)"})
  void testOnDeviceConnectProto_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceConnectProto(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link ByteBuf#capacity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test onGatewayDeviceDisconnectProto(MqttPublishMessage); given three; then calls capacity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.onGatewayDeviceDisconnectProto(MqttPublishMessage)"
  })
  void testOnGatewayDeviceDisconnectProto_givenThree_thenCallsCapacity() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    when(buffer.refCnt()).thenReturn(1);
    DuplicatedByteBuf buffer2 = new DuplicatedByteBuf(buffer);
    ReadOnlyByteBuf payload = new ReadOnlyByteBuf(buffer2);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage mqttMsg =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> gatewaySessionHandler.onGatewayDeviceDisconnectProto(mqttMsg));
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(buffer).refCnt();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test onGatewayDeviceDisconnectProto(MqttPublishMessage); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.onGatewayDeviceDisconnectProto(MqttPublishMessage)"
  })
  void testOnGatewayDeviceDisconnectProto_whenEmptyByteBufWithAllocIsAllocator()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> gatewaySessionHandler.onGatewayDeviceDisconnectProto(mqttMsg));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryJson(int, ByteBuf); then throw JsonSyntaxException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceTelemetryJson(int, ByteBuf)"})
  void testOnDeviceTelemetryJson_thenThrowJsonSyntaxException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () ->
            gatewaySessionHandler.onDeviceTelemetryJson(
                1, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is {@link
   *       EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test onDeviceTelemetryJson(int, ByteBuf); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceTelemetryJson(int, ByteBuf)"})
  void testOnDeviceTelemetryJson_whenDuplicatedByteBufWithBufferIsEmptyByteBuf()
      throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(
        JsonSyntaxException.class,
        () ->
            gatewaySessionHandler.onDeviceTelemetryJson(
                1, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceTelemetryProto(int, ByteBuf)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#onDeviceTelemetryProto(int,
   * ByteBuf)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryProto(int, ByteBuf); given one; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.onDeviceTelemetryProto(int, ByteBuf)"})
  void testOnDeviceTelemetryProto_givenOne_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    ByteBuf payload = mock(ByteBuf.class);
    when(payload.readableBytes()).thenReturn(1);
    when(payload.readerIndex()).thenReturn(1);
    when(payload.getBytes(anyInt(), Mockito.<byte[]>any()))
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(
        AdaptorException.class, () -> gatewaySessionHandler.onDeviceTelemetryProto(1, payload));
    verify(payload).getBytes(eq(1), isA(byte[].class));
    verify(payload).readableBytes();
    verify(payload).readerIndex();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(KeyValueProto, long)}.
   *
   * <p>Method under test: {@link
   * AbstractGatewaySessionHandler#postTelemetryMsgCreated(KeyValueProto, long)}
   */
  @Test
  @DisplayName("Test postTelemetryMsgCreated(KeyValueProto, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg AbstractGatewaySessionHandler.postTelemetryMsgCreated(KeyValueProto, long)"
  })
  void testPostTelemetryMsgCreated() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    PostTelemetryMsg actualPostTelemetryMsgCreatedResult =
        gatewaySessionHandler.postTelemetryMsgCreated(KeyValueProto.getDefaultInstance(), 1L);

    // Assert
    assertEquals("", actualPostTelemetryMsgCreatedResult.getInitializationErrorString());
    List<TsKvListProto> tsKvListList = actualPostTelemetryMsgCreatedResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    assertEquals(1, actualPostTelemetryMsgCreatedResult.getAllFields().size());
    assertEquals(1, actualPostTelemetryMsgCreatedResult.getTsKvListCount());
    assertEquals(6, actualPostTelemetryMsgCreatedResult.getSerializedSize());
    assertTrue(actualPostTelemetryMsgCreatedResult.findInitializationErrors().isEmpty());
    assertTrue(actualPostTelemetryMsgCreatedResult.isInitialized());
    assertSame(tsKvListList, actualPostTelemetryMsgCreatedResult.getTsKvListOrBuilderList());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   *
   * <ul>
   *   <li>When {@code Device Name}.
   *   <li>Then return {@code Device Name}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when 'Device Name'; then return 'Device Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.checkDeviceName(String)"})
  void testCheckDeviceName_whenDeviceName_thenReturnDeviceName() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertEquals("Device Name", gatewaySessionHandler.checkDeviceName("Device Name"));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when empty string; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.checkDeviceName(String)"})
  void testCheckDeviceName_whenEmptyString_thenThrowRuntimeException() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> gatewaySessionHandler.checkDeviceName(""));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.checkDeviceName(String)"})
  void testCheckDeviceName_whenNull_thenThrowRuntimeException() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> gatewaySessionHandler.checkDeviceName(null));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test getBytes(ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] AbstractGatewaySessionHandler.getBytes(ByteBuf)"})
  void testGetBytes_whenEmptyByteBufWithAllocIsAllocator_thenReturnEmptyArrayOfByte() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    byte[] actualBytes =
        gatewaySessionHandler.getBytes(
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Assert
    assertArrayEquals(new byte[] {}, actualBytes);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(int, PubAck)} with {@code msgId}, {@code
   * returnCode}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ack(int, PubAck)}
   */
  @Test
  @DisplayName("Test ack(int, PubAck) with 'msgId', 'returnCode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ack(int, PubAck)"})
  void testAckWithMsgIdReturnCode() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_5);
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    gatewaySessionHandler.ack(1, PubAck.SUCCESS);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(int, PubAck)} with {@code msgId}, {@code
   * returnCode}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#writeAndFlush(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ack(int, PubAck)}
   */
  @Test
  @DisplayName("Test ack(int, PubAck) with 'msgId', 'returnCode'; then calls writeAndFlush(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ack(int, PubAck)"})
  void testAckWithMsgIdReturnCode_thenCallsWriteAndFlush() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    gatewaySessionHandler.ack(1, PubAck.SUCCESS);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, PubAck)} with {@code msg},
   * {@code returnCode}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#writeAndFlush(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, PubAck)}
   */
  @Test
  @DisplayName(
      "Test ack(MqttPublishMessage, PubAck) with 'msg', 'returnCode'; then calls writeAndFlush(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ack(MqttPublishMessage, PubAck)"})
  void testAckWithMsgReturnCode_thenCallsWriteAndFlush() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage msg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    gatewaySessionHandler.ack(msg, PubAck.SUCCESS);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ackOrClose(int)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ackOrClose(int)}
   */
  @Test
  @DisplayName("Test ackOrClose(int); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ackOrClose(int)"})
  void testAckOrClose_thenCallsClose() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    gatewaySessionHandler.ackOrClose(1);

    // Assert
    verify(channel).close();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ackOrClose(int)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#writeAndFlush(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ackOrClose(int)}
   */
  @Test
  @DisplayName("Test ackOrClose(int); then calls writeAndFlush(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ackOrClose(int)"})
  void testAckOrClose_thenCallsWriteAndFlush() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_5);
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    gatewaySessionHandler.ackOrClose(1);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ackOrClose(int)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ackOrClose(int)}
   */
  @Test
  @DisplayName("Test ackOrClose(int); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ackOrClose(int)"})
  void testAckOrClose_thenThrowRuntimeException() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any())).thenThrow(new RuntimeException());
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_5);
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> gatewaySessionHandler.ackOrClose(1));
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getSessionId()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractGatewaySessionHandler.getSessionId()"})
  void testGetSessionId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    UUID actualSessionId = gatewaySessionHandler.getSessionId();

    // Assert
    assertSame(gatewaySessionHandler.sessionId, actualSessionId);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGatewaySessionHandler.isOverwriteDevicesActivity()"})
  void testIsOverwriteDevicesActivity_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), false);

    // Act and Assert
    assertFalse(gatewaySessionHandler.isOverwriteDevicesActivity());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractGatewaySessionHandler.isOverwriteDevicesActivity()"})
  void testIsOverwriteDevicesActivity_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertTrue(gatewaySessionHandler.isOverwriteDevicesActivity());
  }
}
