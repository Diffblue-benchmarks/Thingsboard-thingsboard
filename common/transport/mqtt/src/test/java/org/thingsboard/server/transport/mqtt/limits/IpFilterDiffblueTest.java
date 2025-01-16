package org.thingsboard.server.transport.mqtt.limits;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;

class IpFilterDiffblueTest {
  /**
   * Test {@link IpFilter#accept(ChannelHandlerContext, InetSocketAddress)} with
   * {@code ChannelHandlerContext}, {@code InetSocketAddress}.
   * <p>
   * Method under test:
   * {@link IpFilter#accept(ChannelHandlerContext, InetSocketAddress)}
   */
  @Test
  @DisplayName("Test accept(ChannelHandlerContext, InetSocketAddress) with 'ChannelHandlerContext', 'InetSocketAddress'")
  void testAcceptWithChannelHandlerContextInetSocketAddress() throws Exception {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setRateLimitService(new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache()));
    IpFilter ipFilter = new IpFilter(context);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    // Act
    boolean actualAcceptResult = ipFilter.accept(ctx, InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(ctx, atLeast(1)).channel();
    assertTrue(actualAcceptResult);
  }

  /**
   * Test {@link IpFilter#accept(ChannelHandlerContext, InetSocketAddress)} with
   * {@code ChannelHandlerContext}, {@code InetSocketAddress}.
   * <p>
   * Method under test:
   * {@link IpFilter#accept(ChannelHandlerContext, InetSocketAddress)}
   */
  @Test
  @DisplayName("Test accept(ChannelHandlerContext, InetSocketAddress) with 'ChannelHandlerContext', 'InetSocketAddress'")
  void testAcceptWithChannelHandlerContextInetSocketAddress2() throws Exception {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setRateLimitService(new DefaultTransportRateLimitService(null));
    IpFilter ipFilter = new IpFilter(context);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    // Act
    boolean actualAcceptResult = ipFilter.accept(ctx, InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(ctx, atLeast(1)).channel();
    assertTrue(actualAcceptResult);
  }
}
