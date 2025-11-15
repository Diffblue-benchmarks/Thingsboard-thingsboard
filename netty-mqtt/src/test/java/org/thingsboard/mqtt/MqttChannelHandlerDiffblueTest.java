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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.util.concurrent.DefaultProgressivePromise;
import io.netty.util.concurrent.Promise;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.common.util.ListeningExecutor;

class MqttChannelHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testChannelRead0() throws Exception {
    // Arrange
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client,
        new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);
    MqttMessage msg = mock(MqttMessage.class);
    when(msg.fixedHeader())
        .thenReturn(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert that nothing has changed
    verify(decoderResult).isSuccess();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
  }

  /**
   * Method under test:
   * {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testChannelRead02() throws Exception {
    // Arrange
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client,
        new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(false);
    when(decoderResult.cause()).thenReturn(new Throwable());
    MqttMessage msg = mock(MqttMessage.class);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert that nothing has changed
    verify(ctx).close();
    verify(decoderResult).cause();
    verify(decoderResult).isSuccess();
    verify(msg, atLeast(1)).decoderResult();
  }

  /**
   * Method under test:
   * {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  void testChannelActive() throws Exception {
    // Arrange
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client,
        new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.fireChannelActive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttChannelHandler.channelActive(ctx);

    // Assert
    verify(ctx).channel();
    verify(ctx).fireChannelActive();
  }

  /**
   * Method under test:
   * {@link MqttChannelHandler#channelInactive(ChannelHandlerContext)}
   */
  @Test
  void testChannelInactive() throws Exception {
    // Arrange
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client,
        new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelInactive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttChannelHandler.channelInactive(ctx);

    // Assert that nothing has changed
    verify(ctx).fireChannelInactive();
  }

  /**
   * Method under test:
   * {@link MqttChannelHandler#invokeHandlersForIncomingPublish(MqttPublishMessage)}
   */
  @Test
  void testInvokeHandlersForIncomingPublish() {
    // Arrange
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);
    doNothing().when(handlerExecutor).execute(Mockito.<Runnable>any());
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), handlerExecutor);

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client,
        new DefaultProgressivePromise<>(new DefaultEventLoop()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    mqttChannelHandler.invokeHandlersForIncomingPublish(new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()))));

    // Assert
    verify(handlerExecutor).execute(isA(Runnable.class));
  }

  /**
   * Method under test:
   * {@link MqttChannelHandler#MqttChannelHandler(MqttClientImpl, Promise)}
   */
  @Test
  void testNewMqttChannelHandler() {
    // Arrange
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act and Assert
    assertFalse((new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()))).isSharable());
  }

  /**
   * Method under test:
   * {@link MqttChannelHandler#MqttChannelHandler(MqttClientImpl, Promise)}
   */
  @Test
  void testNewMqttChannelHandler2() {
    // Arrange, Act and Assert
    assertFalse((new MqttChannelHandler(null, new DefaultProgressivePromise<>(new DefaultEventLoop()))).isSharable());
  }
}
