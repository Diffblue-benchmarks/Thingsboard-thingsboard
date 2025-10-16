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
package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonParseException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.local.LocalChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPubReplyMessageVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodeAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttVersion;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

class MqttTransportHandlerDiffblueTest {
  /**
   * Test {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelRegistered(ChannelHandlerContext); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered_givenChannelHandlerContext() throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRegistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelRegistered(ctx);

    // Assert
    verify(ctx).fireChannelRegistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with {@code Msg}.
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelRegistered(ChannelHandlerContext); given JsonParseException(String) with 'Msg'; then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered_givenJsonParseExceptionWithMsg_thenThrowJsonParseException()
      throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRegistered()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRegistered(ctx));
    verify(ctx).fireChannelRegistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelUnregistered(ChannelHandlerContext); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered_givenChannelHandlerContext() throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelUnregistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelUnregistered(ctx);

    // Assert
    verify(ctx).fireChannelUnregistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelUnregistered(ChannelHandlerContext); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered_thenThrowJsonParseException() throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelUnregistered()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelUnregistered(ctx));
    verify(ctx).fireChannelUnregistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with msg is {@code [{}]
   *       Processing msg: {}}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given JsonParseException(String) with msg is '[{}] Processing msg: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenJsonParseExceptionWithMsgIsProcessingMsg() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenThrow(new JsonParseException("[{}] Processing msg: {}"));
    when(ctx.channel()).thenReturn(new LocalChannel());

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRead(ctx, "Msg"));
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with msg is {@code
   *       -XX:MaxDirectMemorySize = 9}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName(
      "Test channelRead(ChannelHandlerContext, Object); given JsonParseException(String) with msg is '-XX:MaxDirectMemorySize = 9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_givenJsonParseExceptionWithMsgIsXxMaxDirectMemorySize9() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException(" -XX:MaxDirectMemorySize = 9  "));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRead(ctx, "Msg"));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); when 'Msg'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_whenMsg_thenCallsClose() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ctx.channel()).thenReturn(new LocalChannel());

    // Act
    mqttTransportHandler.channelRead(ctx, "Msg");

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#getAddress(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with {@code Msg}.
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#getAddress(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test getAddress(ChannelHandlerContext); given JsonParseException(String) with 'Msg'; then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.net.InetSocketAddress MqttTransportHandler.getAddress(ChannelHandlerContext)"
  })
  void testGetAddress_givenJsonParseExceptionWithMsg_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.getAddress(ctx));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); given EmbeddedChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_givenEmbeddedChannel() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_givenNull() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel())
        .thenThrow(
            new JsonParseException(
                "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
                    + " {} and actual queue size {}"));

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.enqueueRegularSessionMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelReadComplete(ChannelHandlerContext); given ChannelHandlerContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_givenChannelHandlerContext() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelReadComplete(ctx);

    // Assert
    verify(ctx).flush();
  }

  /**
   * Test {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelReadComplete(ChannelHandlerContext); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelReadComplete(ctx));
    verify(ctx).flush();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught() {
    // Arrange
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      mockRuntime
          .when(Runtime::getRuntime)
          .thenThrow(new JsonParseException("[{}] Unexpected Exception"));
      MqttTransportHandler mqttTransportHandler =
          new MqttTransportHandler(new MqttTransportContext(), null);

      ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
      when(ctx.channel()).thenReturn(null);
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act and Assert
      assertThrows(
          JsonParseException.class,
          () -> mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError()));
      verify(ctx).channel();
      verify(ctx).close();
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName("Test exceptionCaught(ChannelHandlerContext, Throwable); given EmbeddedChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEmbeddedChannel() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with msg is {@code [{}]
   *       Unexpected Exception}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given JsonParseException(String) with msg is '[{}] Unexpected Exception'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenJsonParseExceptionWithMsgIsUnexpectedException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("[{}] Unexpected Exception"));

    // Act and Assert
    assertThrows(
        JsonParseException.class, () -> mqttTransportHandler.exceptionCaught(ctx, new Throwable()));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ChannelHandlerContext} {@link ChannelHandlerContext#channel()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given 'null'; when ChannelHandlerContext channel() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenNull_whenChannelHandlerContextChannelReturnNull() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link IOException#IOException()}.
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given 'null'; when IOException(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenNull_whenIOException_thenCallsClose() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new IOException());

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Runtime} {@link Runtime#exit(int)} does nothing.
   *   <li>Then calls {@link Runtime#exit(int)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given Runtime exit(int) does nothing; then calls exit(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenRuntimeExitDoesNothing_thenCallsExit() {
    // Arrange
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {

      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      MqttTransportHandler mqttTransportHandler =
          new MqttTransportHandler(new MqttTransportContext(), null);

      ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
      when(ctx.channel()).thenReturn(null);
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act
      mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError());

      // Assert
      verify(ctx).channel();
      verify(ctx).close();
      verify(runtime).exit(1);
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int, byte)}.
   *
   * <ul>
   *   <li>Given {@code MQTT_5}.
   *   <li>Then return variableHeader reasonCode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int,
   * byte)}
   */
  @Test
  @DisplayName(
      "Test createMqttPubAckMsg(DeviceSessionCtx, int, byte); given 'MQTT_5'; then return variableHeader reasonCode is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttPubAckMsg(DeviceSessionCtx, int, byte)"
  })
  void testCreateMqttPubAckMsg_givenMqtt5_thenReturnVariableHeaderReasonCodeIsA() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_5);

    // Act
    MqttMessage actualCreateMqttPubAckMsgResult =
        MqttTransportHandler.createMqttPubAckMsg(deviceSessionCtx, 1, (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttPubAckMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttPubReplyMessageVariableHeader);
    assertNull(actualCreateMqttPubAckMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttPubAckMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(1, ((MqttPubReplyMessageVariableHeader) variableHeaderResult).messageId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPubReplyMessageVariableHeader) variableHeaderResult).properties().isEmpty());
    assertEquals('A', ((MqttPubReplyMessageVariableHeader) variableHeaderResult).reasonCode());
  }

  /**
   * Test {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int, byte)}.
   *
   * <ul>
   *   <li>Then return variableHeader reasonCode is zero.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int,
   * byte)}
   */
  @Test
  @DisplayName(
      "Test createMqttPubAckMsg(DeviceSessionCtx, int, byte); then return variableHeader reasonCode is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttPubAckMsg(DeviceSessionCtx, int, byte)"
  })
  void testCreateMqttPubAckMsg_thenReturnVariableHeaderReasonCodeIsZero() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttMessage actualCreateMqttPubAckMsgResult =
        MqttTransportHandler.createMqttPubAckMsg(deviceSessionCtx, 1, (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttPubAckMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttPubReplyMessageVariableHeader);
    assertNull(actualCreateMqttPubAckMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttPubAckMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals((byte) 0, ((MqttPubReplyMessageVariableHeader) variableHeaderResult).reasonCode());
    assertEquals(1, ((MqttPubReplyMessageVariableHeader) variableHeaderResult).messageId());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttPubReplyMessageVariableHeader) variableHeaderResult).properties().isEmpty());
  }

  /**
   * Test {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx, byte)}.
   *
   * <ul>
   *   <li>Given {@code MQTT_5}.
   *   <li>Then return variableHeader reasonCode is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx,
   * byte)}
   */
  @Test
  @DisplayName(
      "Test createMqttDisconnectMsg(DeviceSessionCtx, byte); given 'MQTT_5'; then return variableHeader reasonCode is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttDisconnectMsg(DeviceSessionCtx, byte)"
  })
  void testCreateMqttDisconnectMsg_givenMqtt5_thenReturnVariableHeaderReasonCodeIsA() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_5);

    // Act
    MqttMessage actualCreateMqttDisconnectMsgResult =
        MqttTransportHandler.createMqttDisconnectMsg(deviceSessionCtx, (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttDisconnectMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttReasonCodeAndPropertiesVariableHeader);
    assertNull(actualCreateMqttDisconnectMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttDisconnectMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(
        ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).properties().isEmpty());
    assertEquals(
        'A', ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).reasonCode());
  }

  /**
   * Test {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx, byte)}.
   *
   * <ul>
   *   <li>Then return variableHeader reasonCode is zero.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx,
   * byte)}
   */
  @Test
  @DisplayName(
      "Test createMqttDisconnectMsg(DeviceSessionCtx, byte); then return variableHeader reasonCode is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MqttMessage MqttTransportHandler.createMqttDisconnectMsg(DeviceSessionCtx, byte)"
  })
  void testCreateMqttDisconnectMsg_thenReturnVariableHeaderReasonCodeIsZero() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttMessage actualCreateMqttDisconnectMsgResult =
        MqttTransportHandler.createMqttDisconnectMsg(deviceSessionCtx, (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttDisconnectMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttReasonCodeAndPropertiesVariableHeader);
    assertNull(actualCreateMqttDisconnectMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttDisconnectMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals(
        (byte) 0, ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).reasonCode());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(
        ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).properties().isEmpty());
  }
}
