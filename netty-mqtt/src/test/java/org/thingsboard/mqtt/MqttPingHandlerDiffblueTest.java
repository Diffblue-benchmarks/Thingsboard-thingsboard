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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MqttPingHandlerDiffblueTest {
  /**
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   *   <li>When {@code Msg}.
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when 'Msg'; then calls fireChannelRead(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenMsg_thenCallsFireChannelRead()
      throws Exception {
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
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given EmbeddedChannel(); then calls channel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEmbeddedChannel_thenCallsChannel() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.PINGREQ, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnAckMessage mqttConnAckMessage =
        new MqttConnAckMessage(
            mqttFixedHeader,
            new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));

    // Act
    mqttPingHandler.channelRead(ctx, mqttConnAckMessage);

    // Assert
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given EmbeddedChannel(); then calls channel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEmbeddedChannel_thenCallsChannel2() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.PINGRESP, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnAckMessage mqttConnAckMessage =
        new MqttConnAckMessage(
            mqttFixedHeader,
            new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));

    // Act
    mqttPingHandler.channelRead(ctx, mqttConnAckMessage);

    // Assert
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); then calls fireChannelRead(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_thenCallsFireChannelRead() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnAckMessage mqttConnAckMessage =
        new MqttConnAckMessage(
            mqttFixedHeader,
            new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));

    // Act
    mqttPingHandler.channelRead(ctx, mqttConnAckMessage);

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       PooledByteBufAllocator#PooledByteBufAllocator()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); when EmptyByteBuf(ByteBufAllocator) with alloc is PooledByteBufAllocator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenEmptyByteBufWithAllocIsPooledByteBufAllocator() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRead(Mockito.<Object>any())).thenReturn(mock(ChannelHandlerContext.class));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage mqttPublishMessage =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttPingHandler.channelRead(ctx, mqttPublishMessage);

    // Assert
    verify(ctx).fireChannelRead(isA(Object.class));
  }

  /**
   * Test {@link MqttPingHandler#userEventTriggered(ChannelHandlerContext, Object)}.
   *
   * <p>Method under test: {@link MqttPingHandler#userEventTriggered(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test userEventTriggered(ChannelHandlerContext, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttPingHandler.userEventTriggered(ChannelHandlerContext, Object)"})
  void testUserEventTriggered() throws Exception {
    // Arrange
    MqttPingHandler mqttPingHandler = new MqttPingHandler(1);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireUserEventTriggered(Mockito.<Object>any()))
        .thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttPingHandler.userEventTriggered(ctx, "Evt");

    // Assert
    verify(ctx).fireUserEventTriggered(isA(Object.class));
  }
}
