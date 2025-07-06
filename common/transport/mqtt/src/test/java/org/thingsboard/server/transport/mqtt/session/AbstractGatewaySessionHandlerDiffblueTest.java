package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodes;
import io.netty.handler.codec.mqtt.MqttReasonCodes.PubAck;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;

class AbstractGatewaySessionHandlerDiffblueTest {
  /**
   * Test {@link AbstractGatewaySessionHandler#createWeakMap()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#createWeakMap()}
   */
  @Test
  @DisplayName("Test createWeakMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.util.ConcurrentReferenceHashMap AbstractGatewaySessionHandler.createWeakMap()"
  })
  void testCreateWeakMap() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
            .createWeakMap()
            .isEmpty());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}
   */
  @Test
  @DisplayName("Test getPayloadAdaptor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTransportAdaptor AbstractGatewaySessionHandler.getPayloadAdaptor()"})
  void testGetPayloadAdaptor() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertNull(
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
            .getPayloadAdaptor());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#writeAndFlush(MqttMessage)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultChannelProgressivePromise}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#writeAndFlush(MqttMessage)}
   */
  @Test
  @DisplayName("Test writeAndFlush(MqttMessage); then return DefaultChannelProgressivePromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ChannelFuture AbstractGatewaySessionHandler.writeAndFlush(MqttMessage)"})
  void testWriteAndFlush_thenReturnDefaultChannelProgressivePromise() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    when(channel.writeAndFlush(Mockito.<Object>any())).thenReturn(defaultChannelProgressivePromise);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);

    // Act
    ChannelFuture actualWriteAndFlushResult =
        gatewaySessionHandler.writeAndFlush(
            new MqttMessage(
                new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
    assertTrue(actualWriteAndFlushResult instanceof DefaultChannelProgressivePromise);
    assertSame(defaultChannelProgressivePromise, actualWriteAndFlushResult);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#nextMsgId()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AbstractGatewaySessionHandler.nextMsgId()"})
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals(
        1,
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
            .nextMsgId());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isJsonPayloadType()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#isJsonPayloadType()}
   */
  @Test
  @DisplayName("Test isJsonPayloadType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractGatewaySessionHandler.isJsonPayloadType()"})
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
            .isJsonPayloadType());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test getMsgId(MqttPublishMessage); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AbstractGatewaySessionHandler.getMsgId(MqttPublishMessage)"})
  void testGetMsgId_thenReturnOne() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertEquals(
        1,
        gatewaySessionHandler.getMsgId(
            new MqttPublishMessage(
                mqttFixedHeader,
                variableHeader,
                new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   *
   * <ul>
   *   <li>When {@code Device Name}.
   *   <li>Then return {@code Device Name}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when 'Device Name'; then return 'Device Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.checkDeviceName(String)"})
  void testCheckDeviceName_whenDeviceName_thenReturnDeviceName() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals(
        "Device Name",
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
            .checkDeviceName("Device Name"));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when empty string; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.checkDeviceName(String)"})
  void testCheckDeviceName_whenEmptyString_thenThrowRuntimeException() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new GatewaySessionHandler(
                    deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
                .checkDeviceName(""));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when 'null'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractGatewaySessionHandler.checkDeviceName(String)"})
  void testCheckDeviceName_whenNull_thenThrowRuntimeException() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            new GatewaySessionHandler(
                    deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
                .checkDeviceName(null));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}
   */
  @Test
  @DisplayName(
      "Test getBytes(ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] AbstractGatewaySessionHandler.getBytes(ByteBuf)"})
  void testGetBytes_whenEmptyByteBufWithAllocIsAllocator_thenReturnEmptyArrayOfByte() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);

    // Act and Assert
    assertArrayEquals(
        new byte[] {},
        gatewaySessionHandler.getBytes(
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(int, PubAck)} with {@code msgId}, {@code
   * returnCode}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#writeAndFlush(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ack(int, PubAck)}
   */
  @Test
  @DisplayName("Test ack(int, PubAck) with 'msgId', 'returnCode'; then calls writeAndFlush(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ack(int, PubAck)"})
  void testAckWithMsgIdReturnCode_thenCallsWriteAndFlush() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);

    // Act
    new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
        .ack(1, PubAck.SUCCESS);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, PubAck)} with {@code msg},
   * {@code returnCode}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#writeAndFlush(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, PubAck)}
   */
  @Test
  @DisplayName(
      "Test ack(MqttPublishMessage, PubAck) with 'msg', 'returnCode'; then calls writeAndFlush(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ack(MqttPublishMessage, PubAck)"})
  void testAckWithMsgReturnCode_thenCallsWriteAndFlush() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    gatewaySessionHandler.ack(
        new MqttPublishMessage(
            mqttFixedHeader,
            variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))),
        PubAck.SUCCESS);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ackOrClose(int)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#ackOrClose(int)}
   */
  @Test
  @DisplayName("Test ackOrClose(int); then calls close()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractGatewaySessionHandler.ackOrClose(int)"})
  void testAckOrClose_thenCallsClose() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);

    // Act
    new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
        .ackOrClose(1);

    // Assert
    verify(channel).close();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)} with
   * {@code deviceCtxFuture}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test process(ListenableFuture, Consumer, Consumer) with 'deviceCtxFuture', 'onSuccess', 'onFailure'; given 'false'; then calls addListener(Runnable, Executor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.process(ListenableFuture, Consumer, Consumer)"
  })
  void testProcessWithDeviceCtxFutureOnSuccessOnFailure_givenFalse_thenCallsAddListener() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(false);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    gatewaySessionHandler.process(
        new ApiFutureToListenableFuture<>(
            new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))),
        mock(Consumer.class),
        mock(Consumer.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)} with
   * {@code deviceCtxFuture}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Given {@code Get}.
   *   <li>Then calls {@link ListenableFutureTask#get()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test process(ListenableFuture, Consumer, Consumer) with 'deviceCtxFuture', 'onSuccess', 'onFailure'; given 'Get'; then calls get()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.process(ListenableFuture, Consumer, Consumer)"
  })
  void testProcessWithDeviceCtxFutureOnSuccessOnFailure_givenGet_thenCallsGet()
      throws InterruptedException, ExecutionException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.get()).thenReturn("Get");
    when(delegate.isDone()).thenReturn(true);
    ApiFutureToListenableFuture<Object> deviceCtxFuture =
        new ApiFutureToListenableFuture<>(
            new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<Object>any());

    // Act
    gatewaySessionHandler.process(deviceCtxFuture, onSuccess, mock(Consumer.class));

    // Assert
    verify(delegate).get();
    verify(delegate).isDone();
    verify(onSuccess).accept(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)} with
   * {@code deviceCtxFuture}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test process(ListenableFuture, Consumer, Consumer) with 'deviceCtxFuture', 'onSuccess', 'onFailure'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AbstractGatewaySessionHandler.process(ListenableFuture, Consumer, Consumer)"
  })
  void testProcessWithDeviceCtxFutureOnSuccessOnFailure_thenThrowRuntimeException()
      throws InterruptedException, ExecutionException {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.get()).thenReturn("Get");
    when(delegate.isDone()).thenReturn(true);
    ApiFutureToListenableFuture<Object> deviceCtxFuture =
        new ApiFutureToListenableFuture<>(
            new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);
    doThrow(new RuntimeException("foo")).when(onSuccess).accept(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> gatewaySessionHandler.process(deviceCtxFuture, onSuccess, mock(Consumer.class)));
    verify(delegate).get();
    verify(delegate).isDone();
    verify(onSuccess).accept(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getSessionId()}.
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractGatewaySessionHandler.getSessionId()"})
  void testGetSessionId() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler =
        new GatewaySessionHandler(
            deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true);

    // Act
    UUID actualSessionId = gatewaySessionHandler.getSessionId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualSessionId.toString());
    assertSame(gatewaySessionHandler.sessionId, actualSessionId);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractGatewaySessionHandler.isOverwriteDevicesActivity()"})
  void testIsOverwriteDevicesActivity_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), false)
            .isOverwriteDevicesActivity());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractGatewaySessionHandler.isOverwriteDevicesActivity()"})
  void testIsOverwriteDevicesActivity_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(
        new GatewaySessionHandler(
                deviceSessionCtx, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), true)
            .isOverwriteDevicesActivity());
  }
}
