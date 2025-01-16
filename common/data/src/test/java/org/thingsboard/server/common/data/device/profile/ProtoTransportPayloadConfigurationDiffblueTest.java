package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TransportPayloadType;

class ProtoTransportPayloadConfigurationDiffblueTest {
  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getTelemetryDynamicMessageDescriptor(String)}.
   * <ul>
   *   <li>When {@code Device Telemetry Proto Schema}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getTelemetryDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getTelemetryDynamicMessageDescriptor(String); when 'Device Telemetry Proto Schema'")
  void testGetTelemetryDynamicMessageDescriptor_whenDeviceTelemetryProtoSchema() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration())
        .getTelemetryDynamicMessageDescriptor("Device Telemetry Proto Schema"));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getTelemetryDynamicMessageDescriptor(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getTelemetryDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getTelemetryDynamicMessageDescriptor(String); when empty string")
  void testGetTelemetryDynamicMessageDescriptor_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration()).getTelemetryDynamicMessageDescriptor(""));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getAttributesDynamicMessageDescriptor(String)}.
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getAttributesDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getAttributesDynamicMessageDescriptor(String)")
  void testGetAttributesDynamicMessageDescriptor() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration())
        .getAttributesDynamicMessageDescriptor("Device Attributes Proto Schema"));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getAttributesDynamicMessageDescriptor(String)}.
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getAttributesDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getAttributesDynamicMessageDescriptor(String)")
  void testGetAttributesDynamicMessageDescriptor2() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertNull(
        protoTransportPayloadConfiguration.getAttributesDynamicMessageDescriptor("Device Attributes Proto Schema"));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getAttributesDynamicMessageDescriptor(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getAttributesDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getAttributesDynamicMessageDescriptor(String); when empty string")
  void testGetAttributesDynamicMessageDescriptor_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration()).getAttributesDynamicMessageDescriptor(""));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getRpcResponseDynamicMessageDescriptor(String)}.
   * <ul>
   *   <li>When {@code Device Rpc Response Proto Schema}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getRpcResponseDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getRpcResponseDynamicMessageDescriptor(String); when 'Device Rpc Response Proto Schema'")
  void testGetRpcResponseDynamicMessageDescriptor_whenDeviceRpcResponseProtoSchema() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration())
        .getRpcResponseDynamicMessageDescriptor("Device Rpc Response Proto Schema"));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getRpcResponseDynamicMessageDescriptor(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getRpcResponseDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getRpcResponseDynamicMessageDescriptor(String); when empty string")
  void testGetRpcResponseDynamicMessageDescriptor_whenEmptyString() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration()).getRpcResponseDynamicMessageDescriptor(""));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getRpcResponseDynamicMessageDescriptor(String)}.
   * <ul>
   *   <li>When
   * {@link ProtoTransportPayloadConfiguration#RPC_RESPONSE_PROTO_SCHEMA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getRpcResponseDynamicMessageDescriptor(String)}
   */
  @Test
  @DisplayName("Test getRpcResponseDynamicMessageDescriptor(String); when RPC_RESPONSE_PROTO_SCHEMA")
  void testGetRpcResponseDynamicMessageDescriptor_whenRpc_response_proto_schema() {
    // Arrange, Act and Assert
    assertNull((new ProtoTransportPayloadConfiguration())
        .getRpcResponseDynamicMessageDescriptor(ProtoTransportPayloadConfiguration.RPC_RESPONSE_PROTO_SCHEMA));
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getDeviceRpcResponseProtoSchema()}.
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getDeviceRpcResponseProtoSchema()}
   */
  @Test
  @DisplayName("Test getDeviceRpcResponseProtoSchema()")
  void testGetDeviceRpcResponseProtoSchema() {
    // Arrange, Act and Assert
    assertEquals("syntax =\"proto3\";\npackage rpc;\n\nmessage RpcResponseMsg {\n  optional string payload = 1;\n}",
        (new ProtoTransportPayloadConfiguration()).getDeviceRpcResponseProtoSchema());
  }

  /**
   * Test
   * {@link ProtoTransportPayloadConfiguration#getDeviceRpcRequestProtoSchema()}.
   * <p>
   * Method under test:
   * {@link ProtoTransportPayloadConfiguration#getDeviceRpcRequestProtoSchema()}
   */
  @Test
  @DisplayName("Test getDeviceRpcRequestProtoSchema()")
  void testGetDeviceRpcRequestProtoSchema() {
    // Arrange, Act and Assert
    assertEquals(
        "syntax =\"proto3\";\n" + "package rpc;\n" + "\n" + "message RpcRequestMsg {\n"
            + "  optional string method = 1;\n" + "  optional int32 requestId = 2;\n"
            + "  optional string params = 3;\n" + "}",
        (new ProtoTransportPayloadConfiguration()).getDeviceRpcRequestProtoSchema());
  }

  /**
   * Test {@link ProtoTransportPayloadConfiguration#equals(Object)}, and
   * {@link ProtoTransportPayloadConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoTransportPayloadConfiguration#equals(Object)}
   *   <li>{@link ProtoTransportPayloadConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration2 = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration2.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration2.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertEquals(protoTransportPayloadConfiguration, protoTransportPayloadConfiguration2);
    int expectedHashCodeResult = protoTransportPayloadConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, protoTransportPayloadConfiguration2.hashCode());
  }

  /**
   * Test {@link ProtoTransportPayloadConfiguration#equals(Object)}, and
   * {@link ProtoTransportPayloadConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProtoTransportPayloadConfiguration#equals(Object)}
   *   <li>{@link ProtoTransportPayloadConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertEquals(protoTransportPayloadConfiguration, protoTransportPayloadConfiguration);
    int expectedHashCodeResult = protoTransportPayloadConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, protoTransportPayloadConfiguration.hashCode());
  }

  /**
   * Test {@link ProtoTransportPayloadConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(false);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration2 = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration2.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration2.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertNotEquals(protoTransportPayloadConfiguration, protoTransportPayloadConfiguration2);
  }

  /**
   * Test {@link ProtoTransportPayloadConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(false);

    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration2 = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration2.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration2.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertNotEquals(protoTransportPayloadConfiguration, protoTransportPayloadConfiguration2);
  }

  /**
   * Test {@link ProtoTransportPayloadConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertNotEquals(protoTransportPayloadConfiguration, null);
  }

  /**
   * Test {@link ProtoTransportPayloadConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProtoTransportPayloadConfiguration protoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    protoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    protoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);

    // Act and Assert
    assertNotEquals(protoTransportPayloadConfiguration, "Different type to ProtoTransportPayloadConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ProtoTransportPayloadConfiguration}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#setEnableCompatibilityWithJsonPayloadFormat(boolean)}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#setUseJsonPayloadFormatForDefaultDownlinkTopics(boolean)}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#setDeviceAttributesProtoSchema(String)}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#setDeviceRpcRequestProtoSchema(String)}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#setDeviceRpcResponseProtoSchema(String)}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#setDeviceTelemetryProtoSchema(String)}
   *   <li>{@link ProtoTransportPayloadConfiguration#toString()}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#getDeviceAttributesProtoSchema()}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#getDeviceTelemetryProtoSchema()}
   *   <li>{@link ProtoTransportPayloadConfiguration#getTransportPayloadType()}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#isEnableCompatibilityWithJsonPayloadFormat()}
   *   <li>
   * {@link ProtoTransportPayloadConfiguration#isUseJsonPayloadFormatForDefaultDownlinkTopics()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ProtoTransportPayloadConfiguration actualProtoTransportPayloadConfiguration = new ProtoTransportPayloadConfiguration();
    actualProtoTransportPayloadConfiguration.setEnableCompatibilityWithJsonPayloadFormat(true);
    actualProtoTransportPayloadConfiguration.setUseJsonPayloadFormatForDefaultDownlinkTopics(true);
    actualProtoTransportPayloadConfiguration.setDeviceAttributesProtoSchema("Device Attributes Proto Schema");
    actualProtoTransportPayloadConfiguration.setDeviceRpcRequestProtoSchema("Device Rpc Request Proto Schema");
    actualProtoTransportPayloadConfiguration.setDeviceRpcResponseProtoSchema("Device Rpc Response Proto Schema");
    actualProtoTransportPayloadConfiguration.setDeviceTelemetryProtoSchema("Device Telemetry Proto Schema");
    String actualToStringResult = actualProtoTransportPayloadConfiguration.toString();
    String actualDeviceAttributesProtoSchema = actualProtoTransportPayloadConfiguration
        .getDeviceAttributesProtoSchema();
    String actualDeviceTelemetryProtoSchema = actualProtoTransportPayloadConfiguration.getDeviceTelemetryProtoSchema();
    TransportPayloadType actualTransportPayloadType = actualProtoTransportPayloadConfiguration
        .getTransportPayloadType();
    boolean actualIsEnableCompatibilityWithJsonPayloadFormatResult = actualProtoTransportPayloadConfiguration
        .isEnableCompatibilityWithJsonPayloadFormat();

    // Assert that nothing has changed
    assertEquals("Device Attributes Proto Schema", actualDeviceAttributesProtoSchema);
    assertEquals("Device Telemetry Proto Schema", actualDeviceTelemetryProtoSchema);
    assertEquals(
        "ProtoTransportPayloadConfiguration(deviceTelemetryProtoSchema=Device Telemetry Proto Schema,"
            + " deviceAttributesProtoSchema=Device Attributes Proto Schema, deviceRpcRequestProtoSchema=Device Rpc"
            + " Request Proto Schema, deviceRpcResponseProtoSchema=Device Rpc Response Proto Schema, enableCompatib"
            + "ilityWithJsonPayloadFormat=true, useJsonPayloadFormatForDefaultDownlinkTopics=true)",
        actualToStringResult);
    assertEquals(TransportPayloadType.PROTOBUF, actualTransportPayloadType);
    assertTrue(actualIsEnableCompatibilityWithJsonPayloadFormatResult);
    assertTrue(actualProtoTransportPayloadConfiguration.isUseJsonPayloadFormatForDefaultDownlinkTopics());
  }
}
