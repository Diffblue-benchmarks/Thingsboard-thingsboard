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
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import io.netty.handler.codec.mqtt.MqttReasonCodes;
import io.netty.handler.codec.mqtt.MqttReasonCodes.SubAck;
import io.netty.handler.codec.mqtt.MqttVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReturnCodeResolverDiffblueTest {
  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <ul>
   *   <li>Then return {@code CONNECTION_REFUSED_NOT_AUTHORIZED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); then return 'CONNECTION_REFUSED_NOT_AUTHORIZED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode_thenReturnConnectionRefusedNotAuthorized() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_NOT_AUTHORIZED, ReturnCodeResolver.getConnectionReturnCode(
        MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_BAD_USERNAME_OR_PASSWORD));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <ul>
   *   <li>Then return {@code CONNECTION_REFUSED_SERVER_UNAVAILABLE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); then return 'CONNECTION_REFUSED_SERVER_UNAVAILABLE'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode_thenReturnConnectionRefusedServerUnavailable() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE, ReturnCodeResolver
        .getConnectionReturnCode(MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE_5));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <ul>
   *   <li>When {@code CONNECTION_ACCEPTED}.</li>
   *   <li>Then return {@code CONNECTION_ACCEPTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); when 'CONNECTION_ACCEPTED'; then return 'CONNECTION_ACCEPTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode_whenConnectionAccepted_thenReturnConnectionAccepted() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_ACCEPTED,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_ACCEPTED));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <ul>
   *   <li>When {@code CONNECTION_REFUSED_CLIENT_IDENTIFIER_NOT_VALID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); when 'CONNECTION_REFUSED_CLIENT_IDENTIFIER_NOT_VALID'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode_whenConnectionRefusedClientIdentifierNotValid() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_CLIENT_IDENTIFIER_NOT_VALID));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <ul>
   *   <li>When {@code CONNECTION_REFUSED_IDENTIFIER_REJECTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); when 'CONNECTION_REFUSED_IDENTIFIER_REJECTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode_whenConnectionRefusedIdentifierRejected() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED, ReturnCodeResolver
        .getConnectionReturnCode(MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   * <ul>
   *   <li>When {@code MQTT_5}.</li>
   *   <li>Then return {@code CONNECTION_ACCEPTED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); when 'MQTT_5'; then return 'CONNECTION_ACCEPTED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"})
  void testGetConnectionReturnCode_whenMqtt5_thenReturnConnectionAccepted() {
    // Arrange, Act and Assert
    assertEquals(MqttConnectReturnCode.CONNECTION_ACCEPTED,
        ReturnCodeResolver.getConnectionReturnCode(MqttVersion.MQTT_5, MqttConnectReturnCode.CONNECTION_ACCEPTED));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   * <ul>
   *   <li>Then return one hundred twenty-eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName("Test getSubscriptionReturnCode(MqttVersion, SubAck); then return one hundred twenty-eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"})
  void testGetSubscriptionReturnCode_thenReturnOneHundredTwentyEight() {
    // Arrange, Act and Assert
    assertEquals(128, ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.UNSPECIFIED_ERROR));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   * <ul>
   *   <li>When {@code GRANTED_QOS_0}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName("Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'GRANTED_QOS_0'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"})
  void testGetSubscriptionReturnCode_whenGrantedQos0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.GRANTED_QOS_0));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   * <ul>
   *   <li>When {@code GRANTED_QOS_1}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName("Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'GRANTED_QOS_1'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"})
  void testGetSubscriptionReturnCode_whenGrantedQos1_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.GRANTED_QOS_1));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   * <ul>
   *   <li>When {@code GRANTED_QOS_2}.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName("Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'GRANTED_QOS_2'; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"})
  void testGetSubscriptionReturnCode_whenGrantedQos2_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.GRANTED_QOS_2));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   * <ul>
   *   <li>When {@code MQTT_5}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName("Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'MQTT_5'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"})
  void testGetSubscriptionReturnCode_whenMqtt5_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_5, SubAck.GRANTED_QOS_0));
  }
}
