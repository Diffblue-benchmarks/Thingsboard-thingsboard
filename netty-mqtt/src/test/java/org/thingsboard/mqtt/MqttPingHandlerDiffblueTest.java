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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.ReadOnlyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttConnAckMessage;
import io.netty.handler.codec.mqtt.MqttConnAckVariableHeader;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MqttPingHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttPingHandler.channelRead(ctx, "Msg");

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act
    mqttPingHandler.channelRead(ctx, new MqttConnAckMessage(mqttFixedHeader,
        new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true)));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead3() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    mqttPingHandler.channelRead(ctx, new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()))));

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead4() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.PINGREQ, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act
    mqttPingHandler.channelRead(ctx,
        new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload));

    // Assert
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(ctx).channel();
  }

  /**
   * Method under test:
   * {@link MqttPingHandler#userEventTriggered(ChannelHandlerContext, Object)}
   */
  @Test
  void testUserEventTriggered() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireUserEventTriggered(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttPingHandler.userEventTriggered(ctx, "Evt");

    // Assert
    verify(ctx).fireUserEventTriggered(isA(Object.class));
  }
}
