package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <p>Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion,
   * MqttConnectReturnCode)}
   */
  @Test
  @DisplayName("Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"
  })
  void testGetConnectionReturnCode() {
    // Arrange, Act and Assert
    assertEquals(
        MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION,
        ReturnCodeResolver.getConnectionReturnCode(
            MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   *
   * <ul>
   *   <li>Then return {@code CONNECTION_REFUSED_IDENTIFIER_REJECTED}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion,
   * MqttConnectReturnCode)}
   */
  @Test
  @DisplayName(
      "Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); then return 'CONNECTION_REFUSED_IDENTIFIER_REJECTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"
  })
  void testGetConnectionReturnCode_thenReturnConnectionRefusedIdentifierRejected() {
    // Arrange, Act and Assert
    assertEquals(
        MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED,
        ReturnCodeResolver.getConnectionReturnCode(
            MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_CLIENT_IDENTIFIER_NOT_VALID));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   *
   * <ul>
   *   <li>Then return {@code CONNECTION_REFUSED_NOT_AUTHORIZED}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion,
   * MqttConnectReturnCode)}
   */
  @Test
  @DisplayName(
      "Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); then return 'CONNECTION_REFUSED_NOT_AUTHORIZED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"
  })
  void testGetConnectionReturnCode_thenReturnConnectionRefusedNotAuthorized() {
    // Arrange, Act and Assert
    assertEquals(
        MqttConnectReturnCode.CONNECTION_REFUSED_NOT_AUTHORIZED,
        ReturnCodeResolver.getConnectionReturnCode(
            MqttVersion.MQTT_3_1,
            MqttConnectReturnCode.CONNECTION_REFUSED_BAD_USERNAME_OR_PASSWORD));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   *
   * <ul>
   *   <li>Then return {@code CONNECTION_REFUSED_SERVER_UNAVAILABLE}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion,
   * MqttConnectReturnCode)}
   */
  @Test
  @DisplayName(
      "Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); then return 'CONNECTION_REFUSED_SERVER_UNAVAILABLE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"
  })
  void testGetConnectionReturnCode_thenReturnConnectionRefusedServerUnavailable() {
    // Arrange, Act and Assert
    assertEquals(
        MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE,
        ReturnCodeResolver.getConnectionReturnCode(
            MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_REFUSED_SERVER_UNAVAILABLE_5));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   *
   * <ul>
   *   <li>When {@code CONNECTION_ACCEPTED}.
   *   <li>Then return {@code CONNECTION_ACCEPTED}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion,
   * MqttConnectReturnCode)}
   */
  @Test
  @DisplayName(
      "Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); when 'CONNECTION_ACCEPTED'; then return 'CONNECTION_ACCEPTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"
  })
  void testGetConnectionReturnCode_whenConnectionAccepted_thenReturnConnectionAccepted() {
    // Arrange, Act and Assert
    assertEquals(
        MqttConnectReturnCode.CONNECTION_ACCEPTED,
        ReturnCodeResolver.getConnectionReturnCode(
            MqttVersion.MQTT_3_1, MqttConnectReturnCode.CONNECTION_ACCEPTED));
  }

  /**
   * Test {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)}.
   *
   * <ul>
   *   <li>When {@code MQTT_5}.
   *   <li>Then return {@code CONNECTION_ACCEPTED}.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getConnectionReturnCode(MqttVersion,
   * MqttConnectReturnCode)}
   */
  @Test
  @DisplayName(
      "Test getConnectionReturnCode(MqttVersion, MqttConnectReturnCode); when 'MQTT_5'; then return 'CONNECTION_ACCEPTED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttConnectReturnCode ReturnCodeResolver.getConnectionReturnCode(MqttVersion, MqttConnectReturnCode)"
  })
  void testGetConnectionReturnCode_whenMqtt5_thenReturnConnectionAccepted() {
    // Arrange, Act and Assert
    assertEquals(
        MqttConnectReturnCode.CONNECTION_ACCEPTED,
        ReturnCodeResolver.getConnectionReturnCode(
            MqttVersion.MQTT_5, MqttConnectReturnCode.CONNECTION_ACCEPTED));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   *
   * <ul>
   *   <li>Then return one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion,
   * MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName(
      "Test getSubscriptionReturnCode(MqttVersion, SubAck); then return one hundred twenty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"
  })
  void testGetSubscriptionReturnCode_thenReturnOneHundredTwentyEight() {
    // Arrange, Act and Assert
    assertEquals(
        128,
        ReturnCodeResolver.getSubscriptionReturnCode(
            MqttVersion.MQTT_3_1, SubAck.UNSPECIFIED_ERROR));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   *
   * <ul>
   *   <li>When {@code GRANTED_QOS_0}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion,
   * MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName(
      "Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'GRANTED_QOS_0'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"
  })
  void testGetSubscriptionReturnCode_whenGrantedQos0_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.GRANTED_QOS_0));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   *
   * <ul>
   *   <li>When {@code GRANTED_QOS_1}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion,
   * MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName(
      "Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'GRANTED_QOS_1'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"
  })
  void testGetSubscriptionReturnCode_whenGrantedQos1_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(
        1,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.GRANTED_QOS_1));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   *
   * <ul>
   *   <li>When {@code GRANTED_QOS_2}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion,
   * MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName(
      "Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'GRANTED_QOS_2'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"
  })
  void testGetSubscriptionReturnCode_whenGrantedQos2_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(
        2,
        ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_3_1, SubAck.GRANTED_QOS_2));
  }

  /**
   * Test {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion, SubAck)}.
   *
   * <ul>
   *   <li>When {@code MQTT_5}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ReturnCodeResolver#getSubscriptionReturnCode(MqttVersion,
   * MqttReasonCodes.SubAck)}
   */
  @Test
  @DisplayName(
      "Test getSubscriptionReturnCode(MqttVersion, SubAck); when 'MQTT_5'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion, MqttReasonCodes.SubAck)"
  })
  void testGetSubscriptionReturnCode_whenMqtt5_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0, ReturnCodeResolver.getSubscriptionReturnCode(MqttVersion.MQTT_5, SubAck.GRANTED_QOS_0));
  }
}
