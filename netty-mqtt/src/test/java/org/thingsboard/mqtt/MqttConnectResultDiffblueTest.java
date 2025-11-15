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
package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import io.netty.channel.ChannelFuture;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import org.junit.jupiter.api.Test;

class MqttConnectResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MqttConnectResult#MqttConnectResult(boolean, MqttConnectReturnCode, ChannelFuture)}
   *   <li>{@link MqttConnectResult#getCloseFuture()}
   *   <li>{@link MqttConnectResult#getReturnCode()}
   *   <li>{@link MqttConnectResult#isSuccess()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise closeFuture = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    MqttConnectResult actualMqttConnectResult = new MqttConnectResult(true, MqttConnectReturnCode.CONNECTION_ACCEPTED,
        closeFuture);
    ChannelFuture actualCloseFuture = actualMqttConnectResult.getCloseFuture();
    MqttConnectReturnCode actualReturnCode = actualMqttConnectResult.getReturnCode();

    // Assert
    assertTrue(actualCloseFuture instanceof DefaultChannelProgressivePromise);
    assertEquals(MqttConnectReturnCode.CONNECTION_ACCEPTED, actualReturnCode);
    assertTrue(actualMqttConnectResult.isSuccess());
    assertSame(closeFuture, actualCloseFuture);
  }
}
