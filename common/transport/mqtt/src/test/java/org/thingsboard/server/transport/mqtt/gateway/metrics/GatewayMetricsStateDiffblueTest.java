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
package org.thingsboard.server.transport.mqtt.gateway.metrics;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class GatewayMetricsStateDiffblueTest {
  /**
   * Method under test: {@link GatewayMetricsState#getStateResult()}
   */
  @Test
  void testGetStateResult() {
    // Arrange, Act and Assert
    assertTrue(
        (new GatewayMetricsState(TransportProtos.SessionInfoProto.getDefaultInstance())).getStateResult().isEmpty());
  }

  /**
   * Method under test: {@link GatewayMetricsState#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new GatewayMetricsState(TransportProtos.SessionInfoProto.getDefaultInstance())).isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link GatewayMetricsState#GatewayMetricsState(TransportProtos.SessionInfoProto)}
   *   <li>
   * {@link GatewayMetricsState#updateSessionInfo(TransportProtos.SessionInfoProto)}
   *   <li>{@link GatewayMetricsState#getSessionInfo()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GatewayMetricsState actualGatewayMetricsState = new GatewayMetricsState(
        TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    actualGatewayMetricsState.updateSessionInfo(sessionInfo);

    // Assert that nothing has changed
    assertSame(sessionInfo, actualGatewayMetricsState.getSessionInfo());
  }
}
