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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.junit.jupiter.api.Test;

class MqttPendingPublishDiffblueTest {
  /**
   * Method under test:
   * {@link MqttPendingPublish#startPublishRetransmissionTimer(EventLoop, Consumer)}
   */
  @Test
  void testStartPublishRetransmissionTimer() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(true);
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message, MqttQoS.AT_MOST_ONCE,
        operation);

    // Act
    mqttPendingPublish.startPublishRetransmissionTimer(new DefaultEventLoop(), mock(Consumer.class));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }

  /**
   * Method under test:
   * {@link MqttPendingPublish#startPublishRetransmissionTimer(EventLoop, Consumer)}
   */
  @Test
  void testStartPublishRetransmissionTimer2() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message, MqttQoS.AT_MOST_ONCE,
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
   * Method under test: {@link MqttPendingPublish#onPubackReceived()}
   */
  @Test
  void testOnPubackReceived() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    (new MqttPendingPublish(1, future, new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message,
        MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class))).onPubackReceived();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Method under test: {@link MqttPendingPublish#setPubrelMessage(MqttMessage)}
   */
  @Test
  void testSetPubrelMessage() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message, MqttQoS.AT_MOST_ONCE,
        mock(PendingOperation.class));

    // Act
    mqttPendingPublish.setPubrelMessage(
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Method under test:
   * {@link MqttPendingPublish#startPubrelRetransmissionTimer(EventLoop, Consumer)}
   */
  @Test
  void testStartPubrelRetransmissionTimer() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(true);
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message, MqttQoS.AT_MOST_ONCE,
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
   * Method under test:
   * {@link MqttPendingPublish#startPubrelRetransmissionTimer(EventLoop, Consumer)}
   */
  @Test
  void testStartPubrelRetransmissionTimer2() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message, MqttQoS.AT_MOST_ONCE,
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
   * Method under test: {@link MqttPendingPublish#onPubcompReceived()}
   */
  @Test
  void testOnPubcompReceived() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    (new MqttPendingPublish(1, future, new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message,
        MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class))).onPubcompReceived();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future, payload, message, MqttQoS.AT_MOST_ONCE,
        mock(PendingOperation.class));

    // Act
    mqttPendingPublish.setSent(true);
    Promise<Void> actualFuture = mqttPendingPublish.getFuture();
    MqttPublishMessage actualMessage = mqttPendingPublish.getMessage();
    int actualMessageId = mqttPendingPublish.getMessageId();
    ByteBuf actualPayload = mqttPendingPublish.getPayload();
    MqttQoS actualQos = mqttPendingPublish.getQos();

    // Assert that nothing has changed
    assertTrue(actualFuture instanceof DefaultChannelProgressivePromise);
    assertEquals(1, actualMessageId);
    assertEquals(MqttQoS.AT_MOST_ONCE, actualQos);
    assertTrue(mqttPendingPublish.isSent());
    assertSame(payload, actualPayload);
    assertSame(future, actualFuture);
    assertSame(message, actualMessage);
  }

  /**
   * Method under test: {@link MqttPendingPublish#onChannelClosed()}
   */
  @Test
  void testOnChannelClosed() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    (new MqttPendingPublish(1, future, new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message,
        MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class))).onChannelClosed();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Method under test: {@link MqttPendingPublish#onChannelClosed()}
   */
  @Test
  void testOnChannelClosed2() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    // Act
    (new MqttPendingPublish(1, new DefaultChannelProgressivePromise(new EmbeddedChannel()), null, message,
        MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class))).onChannelClosed();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Method under test: {@link MqttPendingPublish#onChannelClosed()}
   */
  @Test
  void testOnChannelClosed3() {
    // Arrange
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1),
        payload);

    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());

    MqttPendingPublish mqttPendingPublish = new MqttPendingPublish(1, future,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), message, MqttQoS.AT_MOST_ONCE,
        operation);
    mqttPendingPublish.startPublishRetransmissionTimer(new DefaultEventLoop(), mock(Consumer.class));

    // Act
    mqttPendingPublish.onChannelClosed();

    // Assert
    verify(buffer).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(operation).isCanceled();
  }

  /**
   * Method under test:
   * {@link MqttPendingPublish#MqttPendingPublish(int, Promise, ByteBuf, MqttPublishMessage, MqttQoS, PendingOperation)}
   */
  @Test
  void testNewMqttPendingPublish() {
    // Arrange
    DefaultChannelProgressivePromise future = new DefaultChannelProgressivePromise(new EmbeddedChannel());
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    // Act
    MqttPendingPublish actualMqttPendingPublish = new MqttPendingPublish(1, future, payload, message,
        MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    // Assert
    Promise<Void> future2 = actualMqttPendingPublish.getFuture();
    assertTrue(future2 instanceof DefaultChannelProgressivePromise);
    assertEquals(1, actualMqttPendingPublish.getMessageId());
    assertEquals(MqttQoS.AT_MOST_ONCE, actualMqttPendingPublish.getQos());
    assertFalse(actualMqttPendingPublish.isSent());
    assertSame(payload, actualMqttPendingPublish.getPayload());
    assertSame(future, future2);
    assertSame(message, actualMqttPendingPublish.getMessage());
  }
}
