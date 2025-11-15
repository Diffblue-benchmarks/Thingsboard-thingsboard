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
package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import io.netty.handler.codec.mqtt.MqttReasonCodes;
import io.netty.handler.codec.mqtt.MqttVersion;
import org.junit.jupiter.api.Test;

class ReturnCodeResolverDiffblueTest {
  /**
   * Method under test:
   * {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  void testGetConnectionReturnCode() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_ACCEPTED,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_ACCEPTED));
    assertEquals(MqttConnectReturnCode.CONNECTION_ACCEPTED,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_5, MqttConnectReturnCode.CONNECTION_ACCEPTED));
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION));
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED, ReturnCodeResolver
        .getConnectionReturnCode(MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED));
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_CLIENT_IDENTIFIER_NOT_VALID));
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_NOT_AUTHORIZED, ReturnCodeResolver.getConnectionReturnCode(
        MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_BAD_USERNAME_OR_PASSWORD));
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE, ReturnCodeResolver
        .getConnectionReturnCode(MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE_5));
  }

  /**
   * Method under test:
   * {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)}
   */
  @Test
  void testGetSubscriptionReturnCode() {
    // Arrange, Act and Assert
    assertEquals(0,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, MqttReasonCodes.SubAck.GRANTED_QOS_0));
    assertEquals(0,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_5, MqttReasonCodes.SubAck.GRANTED_QOS_0));
    assertEquals(1,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, MqttReasonCodes.SubAck.GRANTED_QOS_1));
    assertEquals(2,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, MqttReasonCodes.SubAck.GRANTED_QOS_2));
    assertEquals(128,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, MqttReasonCodes.SubAck.UNSPECIFIED_ERROR));
  }
}
