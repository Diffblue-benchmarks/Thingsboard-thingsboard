package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

@ContextConfiguration(classes = {ProtoMqttAdaptor.class})
@ExtendWith(SpringExtension.class)
class ProtoMqttAdaptorDiffblueTest {
  @Autowired
  private ProtoMqttAdaptor protoMqttAdaptor;

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = protoMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish2() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = protoMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()),
            "org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>When {@code Device Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when 'Device Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_whenDeviceName() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = protoMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_whenEmptyString() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = protoMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "", 1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>When minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_whenMinusOne() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = protoMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", -1);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}.
   * <ul>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)}
   */
  @Test
  @DisplayName("Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Optional ProtoMqttAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"})
  void testConvertToGatewayDeviceDisconnectPublish_whenZero() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    Optional<MqttMessage> actualConvertToGatewayDeviceDisconnectPublishResult = protoMqttAdaptor
        .convertToGatewayDeviceDisconnectPublish(
            new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), "Device Name", 0);

    // Assert
    MqttMessage getResult = actualConvertToGatewayDeviceDisconnectPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/disconnect", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayDeviceDisconnectPublishResult.isPresent());
  }

  /**
   * Test {@link ProtoMqttAdaptor#toBytes(ByteBuf)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   *   <li>Then return empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProtoMqttAdaptor#toBytes(ByteBuf)}
   */
  @Test
  @DisplayName("Test toBytes(ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] ProtoMqttAdaptor.toBytes(ByteBuf)"})
  void testToBytes_whenEmptyByteBufWithAllocIsAllocator_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[]{},
        ProtoMqttAdaptor.toBytes(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }
}
