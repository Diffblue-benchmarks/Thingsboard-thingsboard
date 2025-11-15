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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class GatewaySessionHandlerDiffblueTest {
  /**
   * Test {@link GatewaySessionHandler#GatewaySessionHandler(DeviceSessionCtx, UUID, boolean)}.
   * <ul>
   *   <li>Then return {@link AbstractGatewaySessionHandler#channel} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GatewaySessionHandler#GatewaySessionHandler(DeviceSessionCtx, UUID, boolean)}
   */
  @Test
  @DisplayName("Test new GatewaySessionHandler(DeviceSessionCtx, UUID, boolean); then return channel is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GatewaySessionHandler.<init>(DeviceSessionCtx, UUID, boolean)"})
  void testNewGatewaySessionHandler_thenReturnChannelIsNull() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    UUID sessionId2 = UUID.randomUUID();

    // Act
    GatewaySessionHandler actualGatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, sessionId2, true);

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
    MqttTransportContext expectedContext = actualGatewaySessionHandler.context;
    assertSame(expectedContext, deviceSessionCtx.getContext());
    ConcurrentMap<MqttTopicMatcher, Integer> expectedMqttQoSMap = actualGatewaySessionHandler.mqttQoSMap;
    assertSame(expectedMqttQoSMap, deviceSessionCtx.getMqttQoSMap());
  }
}
