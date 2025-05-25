package org.thingsboard.server.transport.mqtt.limits;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class ProxyIpFilterDiffblueTest {
  /**
   * Test {@link ProxyIpFilter#channelRead(ChannelHandlerContext, Object)}.
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.</li>
   *   <li>Then calls {@link ChannelHandlerContext#channel()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyIpFilter#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); given EmbeddedChannel(); then calls channel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyIpFilter.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenEmbeddedChannel_thenCallsChannel() throws Exception {
    // Arrange
    ProxyIpFilter proxyIpFilter = new ProxyIpFilter(new MqttTransportContext());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    // Act
    proxyIpFilter.channelRead(ctx, "Msg");

    // Assert
    verify(ctx).channel();
  }
}
