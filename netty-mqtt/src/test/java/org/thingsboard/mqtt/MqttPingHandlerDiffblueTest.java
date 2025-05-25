package org.thingsboard.mqtt;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MqttPingHandlerDiffblueTest {
  /**
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   * <p>
   * Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead() throws Exception {
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
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.</li>
   *   <li>When {@code Msg}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#fireChannelRead(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given ChannelHandlerContext; when 'Msg'; then calls fireChannelRead(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenChannelHandlerContext_whenMsg_thenCallsFireChannelRead() throws Exception {
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
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.</li>
   *   <li>Then calls {@link ByteBuf#capacity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given EmbeddedChannel(); then calls capacity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEmbeddedChannel_thenCallsCapacity() throws Exception {
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
   * Test {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link PooledByteBufAllocator#PooledByteBufAllocator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttPingHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when EmptyByteBuf(ByteBufAllocator) with alloc is PooledByteBufAllocator()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPingHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenEmptyByteBufWithAllocIsPooledByteBufAllocator() throws Exception {
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
   * Test {@link MqttPingHandler#userEventTriggered(ChannelHandlerContext, Object)}.
   * <p>
   * Method under test: {@link MqttPingHandler#userEventTriggered(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test userEventTriggered(ChannelHandlerContext, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPingHandler.userEventTriggered(ChannelHandlerContext, Object)"})
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
