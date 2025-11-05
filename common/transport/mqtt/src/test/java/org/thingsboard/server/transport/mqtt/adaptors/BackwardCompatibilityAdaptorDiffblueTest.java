package org.thingsboard.server.transport.mqtt.adaptors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ProvisionDeviceResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttDeviceAwareSessionContext;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

class BackwardCompatibilityAdaptorDiffblueTest {
  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg BackwardCompatibilityAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostTelemetry(
            Mockito.<MqttDeviceAwareSessionContext>any(), Mockito.<MqttPublishMessage>any()))
        .thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(protoAdaptor)
        .convertToPostTelemetry(
            isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPostTelemetry(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostTelemetryMsg BackwardCompatibilityAdaptor.convertToPostTelemetry(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostTelemetry2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostTelemetry(
            Mockito.<MqttDeviceAwareSessionContext>any(), Mockito.<MqttPublishMessage>any()))
        .thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor jsonAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, jsonAdaptor);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostTelemetry(ctx, inbound));
    verify(protoAdaptor)
        .convertToPostTelemetry(
            isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg BackwardCompatibilityAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostAttributes(
            Mockito.<MqttDeviceAwareSessionContext>any(), Mockito.<MqttPublishMessage>any()))
        .thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostAttributes(ctx, inbound));
    verify(protoAdaptor)
        .convertToPostAttributes(
            isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPostAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.PostAttributeMsg BackwardCompatibilityAdaptor.convertToPostAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToPostAttributes2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToPostAttributes(
            Mockito.<MqttDeviceAwareSessionContext>any(), Mockito.<MqttPublishMessage>any()))
        .thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor jsonAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, jsonAdaptor);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToPostAttributes(ctx, inbound));
    verify(protoAdaptor)
        .convertToPostAttributes(
            isA(MqttDeviceAwareSessionContext.class), isA(MqttPublishMessage.class));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.GetAttributeRequestMsg BackwardCompatibilityAdaptor.convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToGetAttributes() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToGetAttributes(
            Mockito.<MqttDeviceAwareSessionContext>any(),
            Mockito.<MqttPublishMessage>any(),
            Mockito.<String>any()))
        .thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToGetAttributes(ctx, inbound, "Topic Base"));
    verify(protoAdaptor)
        .convertToGetAttributes(
            isA(MqttDeviceAwareSessionContext.class),
            isA(MqttPublishMessage.class),
            eq("Topic Base"));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGetAttributes(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}
   */
  @Test
  @DisplayName(
      "Test convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.GetAttributeRequestMsg BackwardCompatibilityAdaptor.convertToGetAttributes(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToGetAttributes2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToGetAttributes(
            Mockito.<MqttDeviceAwareSessionContext>any(),
            Mockito.<MqttPublishMessage>any(),
            Mockito.<String>any()))
        .thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor jsonAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, jsonAdaptor);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToGetAttributes(ctx, inbound, "Topic Base"));
    verify(protoAdaptor)
        .convertToGetAttributes(
            isA(MqttDeviceAwareSessionContext.class),
            isA(MqttPublishMessage.class),
            eq("Topic Base"));
  }

  /**
   * Test {@link
   * BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg BackwardCompatibilityAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToDeviceRpcResponse(
            Mockito.<MqttDeviceAwareSessionContext>any(),
            Mockito.<MqttPublishMessage>any(),
            Mockito.<String>any()))
        .thenThrow(new AdaptorException());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToDeviceRpcResponse(ctx, mqttMsg, "Topic Base"));
    verify(protoAdaptor)
        .convertToDeviceRpcResponse(
            isA(MqttDeviceAwareSessionContext.class),
            isA(MqttPublishMessage.class),
            eq("Topic Base"));
  }

  /**
   * Test {@link
   * BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToDeviceRpcResponse(MqttDeviceAwareSessionContext,
   * MqttPublishMessage, String)}
   */
  @Test
  @DisplayName(
      "Test convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ToDeviceRpcResponseMsg BackwardCompatibilityAdaptor.convertToDeviceRpcResponse(MqttDeviceAwareSessionContext, MqttPublishMessage, String)"
  })
  void testConvertToDeviceRpcResponse2() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = mock(JsonMqttAdaptor.class);
    when(protoAdaptor.convertToDeviceRpcResponse(
            Mockito.<MqttDeviceAwareSessionContext>any(),
            Mockito.<MqttPublishMessage>any(),
            Mockito.<String>any()))
        .thenThrow(new AdaptorException());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor jsonAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());

    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, jsonAdaptor);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage mqttMsg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(
        AdaptorException.class,
        () -> backwardCompatibilityAdaptor.convertToDeviceRpcResponse(ctx, mqttMsg, "Topic Base"));
    verify(protoAdaptor)
        .convertToDeviceRpcResponse(
            isA(MqttDeviceAwareSessionContext.class),
            isA(MqttPublishMessage.class),
            eq("Topic Base"));
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code
   * requestId}, {@code chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        backwardCompatibilityAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code
   * requestId}, {@code chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType2()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        backwardCompatibilityAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code
   * requestId}, {@code chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType3()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 42);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        backwardCompatibilityAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code
   * requestId}, {@code chunk}, {@code firmwareType}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType4()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("Topic"), 3);
    mqttQoSMap.put(new MqttTopicMatcher("v2/%s/response/%s/chunk/%d"), 42);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        backwardCompatibilityAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * byte[], String, int, OtaPackageType)} with {@code ctx}, {@code firmwareChunk}, {@code
   * requestId}, {@code chunk}, {@code firmwareType}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext, byte[], String,
   * int, OtaPackageType)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType) with 'ctx', 'firmwareChunk', 'requestId', 'chunk', 'firmwareType'; given one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, byte[], String, int, OtaPackageType)"
  })
  void testConvertToPublishWithCtxFirmwareChunkRequestIdChunkFirmwareType_givenOne()
      throws UnsupportedEncodingException, AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToPublishResult =
        backwardCompatibilityAdaptor.convertToPublish(
            ctx, "AXAXAXAX".getBytes("UTF-8"), "42", 1, OtaPackageType.FIRMWARE);

    // Assert
    MqttMessage getResult = actualConvertToPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v2/fw/response/42/chunk/1",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)} with {@code ctx}, {@code notificationMsg}, {@code
   * topic}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * AttributeUpdateNotificationMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String) with 'ctx', 'notificationMsg', 'topic'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, AttributeUpdateNotificationMsg, String)"
  })
  void testConvertToPublishWithCtxNotificationMsgTopic_thenReturnNotPresent()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToPublish(ctx, AttributeUpdateNotificationMsg.getDefaultInstance(), "Topic")
            .isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)} with {@code ctx}, {@code provisionResponse}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ProvisionDeviceResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg) with 'ctx', 'provisionResponse'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, ProvisionDeviceResponseMsg)"
  })
  void testConvertToPublishWithCtxProvisionResponse_thenReturnNotPresent() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToPublish(ctx, ProvisionDeviceResponseMsg.getDefaultInstance())
            .isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)} with {@code ctx}, {@code responseMsg}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * GetAttributeResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String) with 'ctx', 'responseMsg', 'topicBase'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, GetAttributeResponseMsg, String)"
  })
  void testConvertToPublishWithCtxResponseMsgTopicBase_thenReturnNotPresent()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToPublish(ctx, GetAttributeResponseMsg.getDefaultInstance(), "Topic Base")
            .isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToDeviceRpcRequestMsg, String)} with {@code ctx}, {@code rpcRequest}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToDeviceRpcRequestMsg, String) with 'ctx', 'rpcRequest', 'topicBase'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToDeviceRpcRequestMsg, String)"
  })
  void testConvertToPublishWithCtxRpcRequestTopicBase_thenReturnNotPresent()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToPublish(ctx, ToDeviceRpcRequestMsg.getDefaultInstance(), "Topic Base")
            .isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * ToServerRpcResponseMsg, String)} with {@code ctx}, {@code rpcResponse}, {@code topicBase}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToPublish(MqttDeviceAwareSessionContext,
   * TransportProtos.ToServerRpcResponseMsg, String)}
   */
  @Test
  @DisplayName(
      "Test convertToPublish(MqttDeviceAwareSessionContext, ToServerRpcResponseMsg, String) with 'ctx', 'rpcResponse', 'topicBase'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToPublish(MqttDeviceAwareSessionContext, TransportProtos.ToServerRpcResponseMsg, String)"
  })
  void testConvertToPublishWithCtxRpcResponseTopicBase_thenReturnNotPresent()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToPublish(ctx, ToServerRpcResponseMsg.getDefaultInstance(), "Topic Base")
            .isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code
   * notificationMsg}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code
   * notificationMsg}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg2() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code
   * notificationMsg}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code
   * notificationMsg}.
   *
   * <ul>
   *   <li>Given forty-two.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; given forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_givenFortyTwo()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("device"), 42);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code
   * notificationMsg}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; given two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_givenTwo()
      throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/attributes"), 2);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, AttributeUpdateNotificationMsg)} with {@code ctx}, {@code deviceName}, {@code
   * notificationMsg}.
   *
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg) with 'ctx', 'deviceName', 'notificationMsg'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, AttributeUpdateNotificationMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameNotificationMsg_thenCallsApply()
      throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("device"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/attributes"), 2);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg2() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>Given forty-two.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'; given forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg_givenFortyTwo()
      throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("id"), 42);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, GetAttributeResponseMsg)} with {@code ctx}, {@code deviceName}, {@code responseMsg}.
   *
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg) with 'ctx', 'deviceName', 'responseMsg'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, GetAttributeResponseMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameResponseMsg_thenCallsApply()
      throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("#"), function);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/attributes/response"), -1);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals(
        "v1/gateway/attributes/response",
        ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest2() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest3() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest4() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("device"), 42);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest5() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("#"), 1);
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 42);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext,
   * String, ToDeviceRpcRequestMsg)} with {@code ctx}, {@code deviceName}, {@code rpcRequest}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayPublish(MqttDeviceAwareSessionContext, String,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayPublish(MqttDeviceAwareSessionContext, String, ToDeviceRpcRequestMsg) with 'ctx', 'deviceName', 'rpcRequest'; given two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayPublish(MqttDeviceAwareSessionContext, String, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testConvertToGatewayPublishWithCtxDeviceNameRpcRequest_givenTwo() throws AdaptorException {
    // Arrange
    ProtoMqttAdaptor protoAdaptor = new ProtoMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.put(new MqttTopicMatcher("v1/gateway/rpc"), 2);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    Optional<MqttMessage> actualConvertToGatewayPublishResult =
        backwardCompatibilityAdaptor.convertToGatewayPublish(
            ctx, "Device Name", ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    MqttMessage getResult = actualConvertToGatewayPublishResult.get();
    assertTrue(getResult instanceof MqttPublishMessage);
    Object variableHeaderResult = getResult.variableHeader();
    assertEquals("v1/gateway/rpc", ((MqttPublishVariableHeader) variableHeaderResult).topicName());
    DecoderResult decoderResultResult = getResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPublishVariableHeader) variableHeaderResult).packetId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(((ByteBuf) getResult.payload()).isContiguous());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPublishVariableHeader) variableHeaderResult).properties().isEmpty());
    assertTrue(actualConvertToGatewayPublishResult.isPresent());
  }

  /**
   * Test {@link
   * BackwardCompatibilityAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToProvisionRequestMsg(MqttDeviceAwareSessionContext,
   * MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.ProvisionDeviceRequestMsg BackwardCompatibilityAdaptor.convertToProvisionRequestMsg(MqttDeviceAwareSessionContext, MqttPublishMessage)"
  })
  void testConvertToProvisionRequestMsg_thenReturnNull() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage inbound = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertNull(backwardCompatibilityAdaptor.convertToProvisionRequestMsg(ctx, inbound));
  }

  /**
   * Test {@link
   * BackwardCompatibilityAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext,
   * String, int)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * BackwardCompatibilityAdaptor#convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext,
   * String, int)}
   */
  @Test
  @DisplayName(
      "Test convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional BackwardCompatibilityAdaptor.convertToGatewayDeviceDisconnectPublish(MqttDeviceAwareSessionContext, String, int)"
  })
  void testConvertToGatewayDeviceDisconnectPublish_thenReturnNotPresent() throws AdaptorException {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx ctx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        backwardCompatibilityAdaptor
            .convertToGatewayDeviceDisconnectPublish(ctx, "Device Name", 1)
            .isPresent());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}, and {@link
   * BackwardCompatibilityAdaptor#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#equals(Object)}
   *   <li>{@link BackwardCompatibilityAdaptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(null, null);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(null, null);

    // Act and Assert
    assertEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
    assertEquals(backwardCompatibilityAdaptor.hashCode(), backwardCompatibilityAdaptor2.hashCode());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}, and {@link
   * BackwardCompatibilityAdaptor#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#equals(Object)}
   *   <li>{@link BackwardCompatibilityAdaptor#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    // Act and Assert
    assertEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor);
    int expectedHashCodeResult = backwardCompatibilityAdaptor.hashCode();
    assertEquals(expectedHashCodeResult, backwardCompatibilityAdaptor.hashCode());
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor protoAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor2, new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor3 = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor3, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor());
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor jsonAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(null, jsonAdaptor);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(null, null);
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor2 =
        new BackwardCompatibilityAdaptor(null, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, backwardCompatibilityAdaptor2);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, null);
  }

  /**
   * Test {@link BackwardCompatibilityAdaptor#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BackwardCompatibilityAdaptor#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BackwardCompatibilityAdaptor.equals(Object)",
    "int BackwardCompatibilityAdaptor.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();
    BackwardCompatibilityAdaptor backwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());

    // Act and Assert
    assertNotEquals(backwardCompatibilityAdaptor, "Different type to BackwardCompatibilityAdaptor");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BackwardCompatibilityAdaptor#BackwardCompatibilityAdaptor(MqttTransportAdaptor,
   *       MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#setJsonAdaptor(MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#setProtoAdaptor(MqttTransportAdaptor)}
   *   <li>{@link BackwardCompatibilityAdaptor#toString()}
   *   <li>{@link BackwardCompatibilityAdaptor#getJsonAdaptor()}
   *   <li>{@link BackwardCompatibilityAdaptor#getProtoAdaptor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BackwardCompatibilityAdaptor.<init>(MqttTransportAdaptor, MqttTransportAdaptor)",
    "MqttTransportAdaptor BackwardCompatibilityAdaptor.getJsonAdaptor()",
    "MqttTransportAdaptor BackwardCompatibilityAdaptor.getProtoAdaptor()",
    "void BackwardCompatibilityAdaptor.setJsonAdaptor(MqttTransportAdaptor)",
    "void BackwardCompatibilityAdaptor.setProtoAdaptor(MqttTransportAdaptor)",
    "String BackwardCompatibilityAdaptor.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    JsonMqttAdaptor protoAdaptor = new JsonMqttAdaptor();

    // Act
    BackwardCompatibilityAdaptor actualBackwardCompatibilityAdaptor =
        new BackwardCompatibilityAdaptor(protoAdaptor, new JsonMqttAdaptor());
    JsonMqttAdaptor jsonAdaptor = new JsonMqttAdaptor();
    actualBackwardCompatibilityAdaptor.setJsonAdaptor(jsonAdaptor);
    JsonMqttAdaptor protoAdaptor2 = new JsonMqttAdaptor();
    actualBackwardCompatibilityAdaptor.setProtoAdaptor(protoAdaptor2);
    actualBackwardCompatibilityAdaptor.toString();
    MqttTransportAdaptor actualJsonAdaptor = actualBackwardCompatibilityAdaptor.getJsonAdaptor();
    MqttTransportAdaptor actualProtoAdaptor = actualBackwardCompatibilityAdaptor.getProtoAdaptor();

    // Assert
    assertTrue(actualJsonAdaptor instanceof JsonMqttAdaptor);
    assertTrue(actualProtoAdaptor instanceof JsonMqttAdaptor);
    assertSame(jsonAdaptor, actualJsonAdaptor);
    assertSame(protoAdaptor2, actualProtoAdaptor);
  }
}
