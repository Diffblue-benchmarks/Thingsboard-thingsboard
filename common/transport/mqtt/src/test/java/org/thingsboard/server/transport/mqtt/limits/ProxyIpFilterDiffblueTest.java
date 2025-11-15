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
