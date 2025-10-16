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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonSyntaxException;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;

class GatewaySessionHandlerDiffblueTest {
  /**
   * Test {@link GatewaySessionHandler#GatewaySessionHandler(DeviceSessionCtx, UUID, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link AbstractGatewaySessionHandler#channel} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link GatewaySessionHandler#GatewaySessionHandler(DeviceSessionCtx,
   * UUID, boolean)}
   */
  @Test
  @DisplayName(
      "Test new GatewaySessionHandler(DeviceSessionCtx, UUID, boolean); then return channel is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GatewaySessionHandler.<init>(DeviceSessionCtx, UUID, boolean)"})
  void testNewGatewaySessionHandler_thenReturnChannelIsNull() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    UUID sessionId2 = UUID.randomUUID();

    // Act
    GatewaySessionHandler actualGatewaySessionHandler =
        new GatewaySessionHandler(deviceSessionCtx, sessionId2, true);

    // Assert
    assertNull(actualGatewaySessionHandler.channel);
    assertNull(actualGatewaySessionHandler.transportService);
    assertNull(actualGatewaySessionHandler.gateway);
    assertNull(actualGatewaySessionHandler.getPayloadAdaptor());
    assertNull(actualGatewaySessionHandler.gatewayMetricsService);
    assertTrue(actualGatewaySessionHandler.mqttQoSMap.isEmpty());
    assertTrue(actualGatewaySessionHandler.isJsonPayloadType());
    assertTrue(actualGatewaySessionHandler.isOverwriteDevicesActivity());
    assertSame(sessionId2, actualGatewaySessionHandler.getSessionId());
    assertSame(actualGatewaySessionHandler.context, deviceSessionCtx.getContext());
    assertSame(actualGatewaySessionHandler.mqttQoSMap, deviceSessionCtx.getMqttQoSMap());
  }

  /**
   * Test {@link GatewaySessionHandler#onDeviceTelemetry(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonSyntaxException}.
   * </ul>
   *
   * <p>Method under test: {@link GatewaySessionHandler#onDeviceTelemetry(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetry(MqttPublishMessage); then throw JsonSyntaxException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GatewaySessionHandler.onDeviceTelemetry(MqttPublishMessage)"})
  void testOnDeviceTelemetry_thenThrowJsonSyntaxException() throws AdaptorException {
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
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceTelemetry(mqttMsg));
  }
}
