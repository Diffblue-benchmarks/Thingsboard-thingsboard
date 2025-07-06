package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.util.concurrent.Promise;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttPendingPublishDiffblueTest {
  /**
   * Test {@link MqttPendingPublish#MqttPendingPublish(int, Promise, ByteBuf, MqttPublishMessage,
   * MqttQoS, PendingOperation)}.
   *
   * <p>Method under test: {@link MqttPendingPublish#MqttPendingPublish(int, Promise, ByteBuf,
   * MqttPublishMessage, MqttQoS, PendingOperation)}
   */
  @Test
  @DisplayName(
      "Test new MqttPendingPublish(int, Promise, ByteBuf, MqttPublishMessage, MqttQoS, PendingOperation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingPublish.<init>(int, Promise, ByteBuf, MqttPublishMessage, MqttQoS, PendingOperation)"
  })
  void testNewMqttPendingPublish() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    EmptyByteBuf buffer = new EmptyByteBuf(new PooledByteBufAllocator());
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader,
            variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    // Act
    MqttPendingPublish actualMqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    // Assert
    ByteBuf payload2 = actualMqttPendingPublish.getPayload();
    assertTrue(payload2 instanceof DuplicatedByteBuf);
    Promise<Void> future2 = actualMqttPendingPublish.getFuture();
    assertTrue(future2 instanceof DefaultChannelProgressivePromise);
    assertEquals(1, actualMqttPendingPublish.getMessageId());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualMqttPendingPublish.getQos());
    assertFalse(actualMqttPendingPublish.isSent());
    assertEquals(buffer, payload2);
    assertSame(payload, payload2);
    assertSame(future, future2);
    assertSame(message, actualMqttPendingPublish.getMessage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttPendingPublish#setSent(boolean)}
   *   <li>{@link MqttPendingPublish#getFuture()}
   *   <li>{@link MqttPendingPublish#getMessage()}
   *   <li>{@link MqttPendingPublish#getMessageId()}
   *   <li>{@link MqttPendingPublish#getPayload()}
   *   <li>{@link MqttPendingPublish#getQos()}
   *   <li>{@link MqttPendingPublish#isSent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Promise MqttPendingPublish.getFuture()",
    "MqttPublishMessage MqttPendingPublish.getMessage()",
    "int MqttPendingPublish.getMessageId()",
    "ByteBuf MqttPendingPublish.getPayload()",
    "MqttQoS MqttPendingPublish.getQos()",
    "boolean MqttPendingPublish.isSent()",
    "void MqttPendingPublish.setSent(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader,
            variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    // Act
    mqttPendingPublish.setSent(true);
    Promise<Void> actualFuture = mqttPendingPublish.getFuture();
    MqttPublishMessage actualMessage = mqttPendingPublish.getMessage();
    int actualMessageId = mqttPendingPublish.getMessageId();
    ByteBuf actualPayload = mqttPendingPublish.getPayload();
    MqttQoS actualQos = mqttPendingPublish.getQos();

    // Assert
    assertTrue(actualFuture instanceof DefaultChannelProgressivePromise);
    assertEquals(1, actualMessageId);
    assertEquals(MqttQoS.AT_MOST_ONCE, actualQos);
    assertTrue(mqttPendingPublish.isSent());
    assertSame(payload, actualPayload);
    assertSame(future, actualFuture);
    assertSame(message, actualMessage);
  }

  /**
   * Test {@link MqttPendingPublish#startPublishRetransmissionTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteBuf#capacity()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#startPublishRetransmissionTimer(EventLoop,
   * Consumer)}
   */
  @Test
  @DisplayName("Test startPublishRetransmissionTimer(EventLoop, Consumer); then calls capacity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingPublish.startPublishRetransmissionTimer(EventLoop, Consumer)"
  })
  void testStartPublishRetransmissionTimer_thenCallsCapacity() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(true);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);

    // Act
    mqttPendingPublish.startPublishRetransmissionTimer(
        new DefaultEventLoop(), mock(Consumer.class));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingPublish#startPublishRetransmissionTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#startPublishRetransmissionTimer(EventLoop,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test startPublishRetransmissionTimer(EventLoop, Consumer); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingPublish.startPublishRetransmissionTimer(EventLoop, Consumer)"
  })
  void testStartPublishRetransmissionTimer_thenNotDefaultEventLoopTerminated() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);
    DefaultEventLoop eventLoop = new DefaultEventLoop();

    // Act
    mqttPendingPublish.startPublishRetransmissionTimer(eventLoop, mock(Consumer.class));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
    assertFalse(eventLoop.isTerminated());
  }

  /**
   * Test {@link MqttPendingPublish#onPubackReceived()}.
   *
   * <p>Method under test: {@link MqttPendingPublish#onPubackReceived()}
   */
  @Test
  @DisplayName("Test onPubackReceived()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onPubackReceived()"})
  void testOnPubackReceived() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            mock(PendingOperation.class))
        .onPubackReceived();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test {@link MqttPendingPublish#onPubackReceived()}.
   *
   * <ul>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#onPubackReceived()}
   */
  @Test
  @DisplayName("Test onPubackReceived(); then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onPubackReceived()"})
  void testOnPubackReceived_thenCallsIsCanceled() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);
    mqttPendingPublish.startPublishRetransmissionTimer(
        new DefaultEventLoop(), mock(Consumer.class));

    // Act
    mqttPendingPublish.onPubackReceived();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingPublish#setPubrelMessage(MqttMessage)}.
   *
   * <p>Method under test: {@link MqttPendingPublish#setPubrelMessage(MqttMessage)}
   */
  @Test
  @DisplayName("Test setPubrelMessage(MqttMessage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.setPubrelMessage(MqttMessage)"})
  void testSetPubrelMessage() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            mock(PendingOperation.class));

    // Act
    mqttPendingPublish.setPubrelMessage(
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test {@link MqttPendingPublish#startPubrelRetransmissionTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteBuf#capacity()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#startPubrelRetransmissionTimer(EventLoop,
   * Consumer)}
   */
  @Test
  @DisplayName("Test startPubrelRetransmissionTimer(EventLoop, Consumer); then calls capacity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.startPubrelRetransmissionTimer(EventLoop, Consumer)"})
  void testStartPubrelRetransmissionTimer_thenCallsCapacity() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(true);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);

    // Act
    mqttPendingPublish.startPubrelRetransmissionTimer(new DefaultEventLoop(), mock(Consumer.class));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingPublish#startPubrelRetransmissionTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#startPubrelRetransmissionTimer(EventLoop,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test startPubrelRetransmissionTimer(EventLoop, Consumer); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.startPubrelRetransmissionTimer(EventLoop, Consumer)"})
  void testStartPubrelRetransmissionTimer_thenNotDefaultEventLoopTerminated() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);
    DefaultEventLoop eventLoop = new DefaultEventLoop();

    // Act
    mqttPendingPublish.startPubrelRetransmissionTimer(eventLoop, mock(Consumer.class));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
    assertFalse(eventLoop.isTerminated());
  }

  /**
   * Test {@link MqttPendingPublish#onPubcompReceived()}.
   *
   * <p>Method under test: {@link MqttPendingPublish#onPubcompReceived()}
   */
  @Test
  @DisplayName("Test onPubcompReceived()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onPubcompReceived()"})
  void testOnPubcompReceived() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            mock(PendingOperation.class))
        .onPubcompReceived();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test {@link MqttPendingPublish#onPubcompReceived()}.
   *
   * <ul>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#onPubcompReceived()}
   */
  @Test
  @DisplayName("Test onPubcompReceived(); then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onPubcompReceived()"})
  void testOnPubcompReceived_thenCallsIsCanceled() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);
    mqttPendingPublish.startPubrelRetransmissionTimer(new DefaultEventLoop(), mock(Consumer.class));

    // Act
    mqttPendingPublish.onPubcompReceived();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingPublish#onChannelClosed()}.
   *
   * <p>Method under test: {@link MqttPendingPublish#onChannelClosed()}
   */
  @Test
  @DisplayName("Test onChannelClosed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onChannelClosed()"})
  void testOnChannelClosed() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            mock(PendingOperation.class))
        .onChannelClosed();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test {@link MqttPendingPublish#onChannelClosed()}.
   *
   * <p>Method under test: {@link MqttPendingPublish#onChannelClosed()}
   */
  @Test
  @DisplayName("Test onChannelClosed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onChannelClosed()"})
  void testOnChannelClosed2() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    // Act
    new MqttPendingPublish(
            1,
            new DefaultChannelProgressivePromise(new EmbeddedChannel()),
            null,
            message,
            MqttQoS.AT_MOST_ONCE,
            mock(PendingOperation.class))
        .onChannelClosed();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test {@link MqttPendingPublish#onChannelClosed()}.
   *
   * <ul>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingPublish#onChannelClosed()}
   */
  @Test
  @DisplayName("Test onChannelClosed(); then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingPublish.onChannelClosed()"})
  void testOnChannelClosed_thenCallsIsCanceled() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
            message,
            MqttQoS.AT_MOST_ONCE,
            operation);
    mqttPendingPublish.startPublishRetransmissionTimer(
        new DefaultEventLoop(), mock(Consumer.class));

    // Act
    mqttPendingPublish.onChannelClosed();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }
}
