package org.thingsboard.mqtt;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.util.concurrent.DefaultProgressivePromise;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.common.util.ListeningExecutor;

class MqttChannelHandlerDiffblueTest {
  /**
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelActive(ChannelHandlerContext); given EmbeddedChannel(); then calls channel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive_givenEmbeddedChannel_thenCallsChannel() throws Exception {
    // Arrange
    MqttClientImpl client =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
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
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then calls {@link EmbeddedChannel#writeAndFlush(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext); then calls writeAndFlush(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive_thenCallsWriteAndFlush() throws Exception {
    // Arrange
    MqttClientImpl client =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(embeddedChannel);
    when(ctx.fireChannelActive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttChannelHandler.channelActive(ctx);

    // Assert
    verify(embeddedChannel).writeAndFlush(isA(Object.class));
    verify(ctx).channel();
    verify(ctx).fireChannelActive();
  }

  /**
   * Test {@link MqttChannelHandler#invokeHandlersForIncomingPublish(MqttPublishMessage)}.
   *
   * <ul>
   *   <li>Then calls {@link ListeningExecutor#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttChannelHandler#invokeHandlersForIncomingPublish(MqttPublishMessage)}
   */
  @Test
  @DisplayName(
      "Test invokeHandlersForIncomingPublish(MqttPublishMessage); then calls execute(Runnable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture MqttChannelHandler.invokeHandlersForIncomingPublish(MqttPublishMessage)"
  })
  void testInvokeHandlersForIncomingPublish_thenCallsExecute() {
    // Arrange
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);
    doNothing().when(handlerExecutor).execute(Mockito.<Runnable>any());
    MqttClientImpl client = new MqttClientImpl(mock(MqttHandler.class), handlerExecutor);

    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    mqttChannelHandler.invokeHandlersForIncomingPublish(
        new MqttPublishMessage(
            mqttFixedHeader,
            variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()))));

    // Assert
    verify(handlerExecutor).execute(isA(Runnable.class));
  }
}
