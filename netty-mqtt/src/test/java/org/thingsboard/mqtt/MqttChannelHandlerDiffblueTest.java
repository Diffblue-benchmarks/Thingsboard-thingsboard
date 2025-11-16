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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttConnAckMessage;
import io.netty.handler.codec.mqtt.MqttConnAckVariableHeader;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttProperties;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttSubscribeMessage;
import io.netty.handler.codec.mqtt.MqttSubscribePayload;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.handler.ssl.JdkSslClientContext;
import io.netty.util.concurrent.DefaultProgressivePromise;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.UnorderedThreadPoolEventExecutor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.common.util.ListeningExecutor;

class MqttChannelHandlerDiffblueTest {
  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage() throws Exception {
    // Arrange
    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(new MqttClientConfig());
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(false);
    when(decoderResult.cause()).thenReturn(new Throwable());

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).close();
    verify(decoderResult).cause();
    verify(decoderResult).isSuccess();
    verify(msg, atLeast(1)).decoderResult();
    verify(client).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage2() throws Exception {
    // Arrange
    MqttClientImpl client = mock(MqttClientImpl.class);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(decoderResult).isSuccess();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage3() throws Exception {
    // Arrange
    MqttClientImpl client = mock(MqttClientImpl.class);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNECT);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(decoderResult).isSuccess();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage4() throws Exception {
    // Arrange
    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(new ConcurrentHashMap<>());
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage5() throws Exception {
    // Arrange
    ConcurrentHashMap<Integer, MqttPendingSubscription> integerMqttPendingSubscriptionMap =
        new ConcurrentHashMap<>();
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttSubscribeMessage message =
        new MqttSubscribeMessage(
            mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>()));

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(future, "Topic", message, mock(PendingOperation.class));
    integerMqttPendingSubscriptionMap.put(1, mqttPendingSubscription);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(new ConcurrentHashMap<>());
    when(client.getPendingSubscriptions()).thenReturn(integerMqttPendingSubscriptionMap);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage6() throws Exception {
    // Arrange
    ConcurrentHashMap<Integer, MqttPendingSubscription> integerMqttPendingSubscriptionMap =
        new ConcurrentHashMap<>();
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttSubscribeMessage message =
        new MqttSubscribeMessage(
            mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>()));

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(future, "Topic", message, mock(PendingOperation.class));
    integerMqttPendingSubscriptionMap.put(2, mqttPendingSubscription);
    DefaultChannelProgressivePromise future2 =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader2 =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttMessageIdAndPropertiesVariableHeader variableHeader2 =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttSubscribeMessage message2 =
        new MqttSubscribeMessage(
            mqttFixedHeader2, variableHeader2, new MqttSubscribePayload(new ArrayList<>()));

    MqttPendingSubscription mqttPendingSubscription2 =
        new MqttPendingSubscription(future2, "Topic", message2, mock(PendingOperation.class));
    integerMqttPendingSubscriptionMap.put(1, mqttPendingSubscription2);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(new ConcurrentHashMap<>());
    when(client.getPendingSubscriptions()).thenReturn(integerMqttPendingSubscriptionMap);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader3 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader3.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader3);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader3).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage7() throws Exception {
    // Arrange
    ConcurrentHashMap<Integer, MqttPendingSubscription> integerMqttPendingSubscriptionMap =
        new ConcurrentHashMap<>();
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttSubscribeMessage message =
        new MqttSubscribeMessage(
            mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>()));

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(future, "Topic", message, mock(PendingOperation.class));
    integerMqttPendingSubscriptionMap.put(3, mqttPendingSubscription);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(new ConcurrentHashMap<>());
    when(client.getPendingSubscriptions()).thenReturn(integerMqttPendingSubscriptionMap);

    GenericFutureListener<Future<MqttConnectResult>> listener = mock(GenericFutureListener.class);
    doNothing().when(listener).operationComplete(Mockito.<Future<MqttConnectResult>>any());

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(new DefaultEventLoop());
    connectFuture.addListener(listener);

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(listener).operationComplete(isA(Future.class));
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage8() throws Exception {
    // Arrange
    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getCallback()).thenReturn(mqttClientCallback);

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(
            new MqttConnAckVariableHeader(
                MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg, atLeast(1)).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage9() throws Exception {
    // Arrange
    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload2);

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage10() throws Exception {
    // Arrange
    GenericFutureListener<Future<Void>> listener = mock(GenericFutureListener.class);
    doThrow(new IOException()).when(listener).operationComplete(Mockito.<Future<Void>>any());

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    future.addListener(listener);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload2);

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(listener).operationComplete(isA(Future.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage11() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload2);

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(1, future, payload, message, null, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage12() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(future.setSuccess(Mockito.<Void>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload2);

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(future).setSuccess((Void) isNull());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage13() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(future.setSuccess(Mockito.<Void>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));

    MqttPublishMessage message = mock(MqttPublishMessage.class);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage mqttPublishMessage =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);
    when(message.touch(Mockito.<Object>any())).thenReturn(mqttPublishMessage);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload2, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(future).setSuccess((Void) isNull());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(message).touch(isA(Object.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage14() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(future.setSuccess(Mockito.<Void>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));

    MqttPublishMessage message = mock(MqttPublishMessage.class);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishMessage mqttPublishMessage =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), null);
    when(message.touch(Mockito.<Object>any())).thenReturn(mqttPublishMessage);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(future).setSuccess((Void) isNull());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(message).touch(isA(Object.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage15() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(future.setSuccess(Mockito.<Void>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));

    MqttPublishMessage mqttPublishMessage = mock(MqttPublishMessage.class);
    when(mqttPublishMessage.release()).thenReturn(true);
    when(mqttPublishMessage.content()).thenReturn(null);

    MqttPublishMessage message = mock(MqttPublishMessage.class);
    when(message.touch(Mockito.<Object>any())).thenReturn(mqttPublishMessage);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(future).setSuccess((Void) isNull());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(mqttPublishMessage).content();
    verify(mqttPublishMessage).release();
    verify(message).touch(isA(Object.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage16() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1,
            future,
            payload,
            mock(MqttPublishMessage.class),
            MqttQoS.AT_MOST_ONCE,
            mock(PendingOperation.class));
    mqttPendingPublish.setSent(true);

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage17() throws Exception {
    // Arrange
    MqttPendingPublish mqttPendingPublish = mock(MqttPendingPublish.class);
    when(mqttPendingPublish.isSent()).thenReturn(true);

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
    verify(mqttPendingPublish).isSent();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage18() throws Exception {
    // Arrange
    MqttPendingPublish mqttPendingPublish = mock(MqttPendingPublish.class);
    when(mqttPendingPublish.isSent()).thenReturn(true);

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        mock(DefaultProgressivePromise.class);
    when(connectFuture.addListener(Mockito.<GenericFutureListener<Future<MqttConnectResult>>>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    when(connectFuture.setSuccess(Mockito.<MqttConnectResult>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(connectFuture).addListener(isA(GenericFutureListener.class));
    verify(connectFuture).setSuccess(isA(MqttConnectResult.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
    verify(mqttPendingPublish).isSent();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage19() throws Exception {
    // Arrange
    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mock(MqttPendingPublish.class));

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getCallback()).thenReturn(mqttClientCallback);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        mock(DefaultProgressivePromise.class);
    when(connectFuture.addListener(Mockito.<GenericFutureListener<Future<MqttConnectResult>>>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    when(connectFuture.setSuccess(Mockito.<MqttConnectResult>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(
            new MqttConnAckVariableHeader(
                MqttConnectReturnCode.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg, atLeast(1)).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(connectFuture).addListener(isA(GenericFutureListener.class));
    verify(connectFuture).setSuccess(isA(MqttConnectResult.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage20() throws Exception {
    // Arrange
    MqttPendingPublish mqttPendingPublish = mock(MqttPendingPublish.class);
    when(mqttPendingPublish.isSent()).thenReturn(true);

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.isReconnect()).thenReturn(false);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        mock(DefaultProgressivePromise.class);
    when(connectFuture.addListener(Mockito.<GenericFutureListener<Future<MqttConnectResult>>>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    when(connectFuture.setSuccess(Mockito.<MqttConnectResult>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(connectFuture).addListener(isA(GenericFutureListener.class));
    verify(connectFuture).setSuccess(isA(MqttConnectResult.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(mqttPendingPublish).isSent();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsClose() throws Exception {
    // Arrange
    MqttClientImpl client =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(false);
    when(decoderResult.cause()).thenReturn(new Throwable());

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).close();
    verify(decoderResult).cause();
    verify(decoderResult).isSuccess();
    verify(msg, atLeast(1)).decoderResult();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link MqttClientConfig#getClientId()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls getClientId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsGetClientId()
      throws Exception {
    // Arrange
    MqttClientConfig mqttClientConfig = mock(MqttClientConfig.class);
    when(mqttClientConfig.getClientId()).thenReturn("42");

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(mqttClientConfig);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(false);
    when(decoderResult.cause()).thenReturn(new Throwable());

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).close();
    verify(decoderResult).cause();
    verify(decoderResult).isSuccess();
    verify(msg, atLeast(1)).decoderResult();
    verify(mqttClientConfig).getClientId();
    verify(client).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPendingPublish#getFuture()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls getFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsGetFuture() throws Exception {
    // Arrange
    MqttPendingPublish mqttPendingPublish = mock(MqttPendingPublish.class);
    when(mqttPendingPublish.getMessageId()).thenReturn(1);
    when(mqttPendingPublish.getFuture())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(mqttPendingPublish.getQos()).thenReturn(MqttQoS.AT_MOST_ONCE);
    doNothing().when(mqttPendingPublish).setSent(anyBoolean());
    when(mqttPendingPublish.isSent()).thenReturn(false);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage mqttPublishMessage =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);
    when(mqttPendingPublish.getMessage()).thenReturn(mqttPublishMessage);

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        mock(DefaultProgressivePromise.class);
    when(connectFuture.addListener(Mockito.<GenericFutureListener<Future<MqttConnectResult>>>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    when(connectFuture.setSuccess(Mockito.<MqttConnectResult>any()))
        .thenReturn(new DefaultProgressivePromise<>(new DefaultEventLoop()));
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(connectFuture).addListener(isA(GenericFutureListener.class));
    verify(connectFuture).setSuccess(isA(MqttConnectResult.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
    verify(mqttPendingPublish).getFuture();
    verify(mqttPendingPublish).getMessage();
    verify(mqttPendingPublish).getMessageId();
    verify(mqttPendingPublish).getQos();
    verify(mqttPendingPublish).isSent();
    verify(mqttPendingPublish).setSent(true);
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsNewThread() throws Exception {
    // Arrange
    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(new ConcurrentHashMap<>());
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsNewThread2() throws Exception {
    // Arrange
    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(new ConcurrentHashMap<>());
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link GenericFutureListener#operationComplete(Future)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls operationComplete(Future)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsOperationComplete()
      throws Exception {
    // Arrange
    GenericFutureListener<Future<Void>> listener = mock(GenericFutureListener.class);
    doNothing().when(listener).operationComplete(Mockito.<Future<Void>>any());

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    future.addListener(listener);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload2);

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(listener).operationComplete(isA(Future.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link GenericFutureListener#operationComplete(Future)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls operationComplete(Future)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsOperationComplete2()
      throws Exception {
    // Arrange
    GenericFutureListener<Future<Void>> listener = mock(GenericFutureListener.class);
    doNothing().when(listener).operationComplete(Mockito.<Future<Void>>any());

    GenericFutureListener<Future<Void>> listener2 = mock(GenericFutureListener.class);
    doNothing().when(listener2).operationComplete(Mockito.<Future<Void>>any());

    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    future.addListener(listener2);
    future.addListener(listener);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload2);

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(listener2).operationComplete(isA(Future.class));
    verify(listener).operationComplete(isA(Future.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link ByteBuf#refCnt()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls refCnt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsRefCnt() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(future.setSuccess(Mockito.<Void>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));

    ByteBuf payload = mock(ByteBuf.class);
    when(payload.refCnt()).thenReturn(1);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishMessage mqttPublishMessage =
        new MqttPublishMessage(
            mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload);

    MqttPublishMessage message = mock(MqttPublishMessage.class);
    when(message.touch(Mockito.<Object>any())).thenReturn(mqttPublishMessage);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload2, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader2 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader2.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader2);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(future).setSuccess((Void) isNull());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader2).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(message).touch(isA(Object.class));
    verify(payload, atLeast(1)).refCnt();
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelRead0(ChannelHandlerContext, MqttMessage)} with {@code
   * ChannelHandlerContext}, {@code MqttMessage}.
   *
   * <ul>
   *   <li>Then calls {@link MqttPublishMessage#retain()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelRead0(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test channelRead0(ChannelHandlerContext, MqttMessage) with 'ChannelHandlerContext', 'MqttMessage'; then calls retain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelRead0(ChannelHandlerContext, MqttMessage)"})
  void testChannelRead0WithChannelHandlerContextMqttMessage_thenCallsRetain() throws Exception {
    // Arrange
    DefaultChannelProgressivePromise future = mock(DefaultChannelProgressivePromise.class);
    when(future.addListener(Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(future.setSuccess(Mockito.<Void>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    future.addListener(mock(GenericFutureListener.class));
    future.addListener(mock(GenericFutureListener.class));

    MqttPublishMessage mqttPublishMessage = mock(MqttPublishMessage.class);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage mqttPublishMessage2 =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);
    when(mqttPublishMessage.retain()).thenReturn(mqttPublishMessage2);
    MqttFixedHeader mqttFixedHeader2 =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader2 = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload2 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage mqttPublishMessage3 =
        new MqttPublishMessage(mqttFixedHeader2, variableHeader2, payload2);
    when(mqttPublishMessage.touch()).thenReturn(mqttPublishMessage3);
    when(mqttPublishMessage.release()).thenReturn(true);
    when(mqttPublishMessage.content())
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    MqttPublishMessage message = mock(MqttPublishMessage.class);
    when(message.touch(Mockito.<Object>any())).thenReturn(mqttPublishMessage);
    DuplicatedByteBuf payload3 =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPendingPublish mqttPendingPublish =
        new MqttPendingPublish(
            1, future, payload3, message, MqttQoS.AT_MOST_ONCE, mock(PendingOperation.class));

    Function<Integer, MqttPendingPublish> function = mock(Function.class);
    when(function.apply(Mockito.<Integer>any())).thenReturn(mqttPendingPublish);

    ConcurrentHashMap<Integer, MqttPendingPublish> integerMqttPendingPublishMap =
        new ConcurrentHashMap<>();
    integerMqttPendingPublishMap.computeIfAbsent(1, function);

    MqttClientCallback mqttClientCallback = mock(MqttClientCallback.class);
    doNothing().when(mqttClientCallback).onConnAck(Mockito.<MqttConnAckMessage>any());

    MqttClientImpl client = mock(MqttClientImpl.class);
    doNothing().when(client).onSuccessfulReconnect();
    when(client.isReconnect()).thenReturn(true);
    when(client.getCallback()).thenReturn(mqttClientCallback);
    when(client.getPendingPublishes()).thenReturn(integerMqttPendingPublishMap);
    when(client.getPendingSubscriptions()).thenReturn(new ConcurrentHashMap<>());

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    UnorderedThreadPoolEventExecutor executor =
        new UnorderedThreadPoolEventExecutor(3, threadFactory);

    DefaultProgressivePromise<MqttConnectResult> connectFuture =
        new DefaultProgressivePromise<>(executor);
    connectFuture.addListener(mock(GenericFutureListener.class));

    MqttChannelHandler mqttChannelHandler = new MqttChannelHandler(client, connectFuture);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());

    DecoderResult decoderResult = mock(DecoderResult.class);
    when(decoderResult.isSuccess()).thenReturn(true);

    MqttFixedHeader mqttFixedHeader3 = mock(MqttFixedHeader.class);
    when(mqttFixedHeader3.messageType()).thenReturn(MqttMessageType.CONNACK);

    MqttConnAckMessage msg = mock(MqttConnAckMessage.class);
    when(msg.variableHeader())
        .thenReturn(new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, true));
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader3);
    when(msg.decoderResult()).thenReturn(decoderResult);

    // Act
    mqttChannelHandler.channelRead0(ctx, msg);

    // Assert
    verify(ctx).channel();
    verify(future, atLeast(1)).addListener(Mockito.<GenericFutureListener<Future<Void>>>any());
    verify(future).setSuccess((Void) isNull());
    verify(decoderResult).isSuccess();
    verify(msg).variableHeader();
    verify(mqttFixedHeader3).messageType();
    verify(msg).decoderResult();
    verify(msg).fixedHeader();
    verify(mqttPublishMessage, atLeast(1)).content();
    verify(mqttPublishMessage).release();
    verify(mqttPublishMessage).retain();
    verify(mqttPublishMessage).touch();
    verify(message).touch(isA(Object.class));
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(function).apply(1);
    verify(mqttClientCallback).onConnAck(isA(MqttConnAckMessage.class));
    verify(client, atLeast(1)).getCallback();
    verify(client, atLeast(1)).getPendingPublishes();
    verify(client).getPendingSubscriptions();
    verify(client).isReconnect();
    verify(client).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive() throws Exception {
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
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive2() throws Exception {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig(new JdkSslClientContext());
    mqttClientConfig.setUsername("foo");
    mqttClientConfig.setPassword("foo");
    MqttLastWill lastWill =
        new MqttLastWill("Topic", "Not all who wander are lost", false, MqttQoS.AT_MOST_ONCE);
    mqttClientConfig.setLastWill(lastWill);

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(mqttClientConfig);
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
    verify(client, atLeast(1)).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive3() throws Exception {
    // Arrange
    MqttClientConfig mqttClientConfig = new MqttClientConfig(new JdkSslClientContext());
    mqttClientConfig.setUsername("foo");
    mqttClientConfig.setPassword("foo");
    mqttClientConfig.setLastWill(
        MqttLastWill.builder()
            .setMessage("Not all who wander are lost")
            .setQos(MqttQoS.AT_MOST_ONCE)
            .setRetain(true)
            .setTopic("Topic")
            .build());

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(mqttClientConfig);
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
    verify(client, atLeast(1)).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext); given EmbeddedChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive_givenEmbeddedChannel() throws Exception {
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
   *   <li>Given {@link MqttClientImpl} {@link MqttClientImpl#getClientConfig()} return {@link
   *       MqttClientConfig#MqttClientConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelActive(ChannelHandlerContext); given MqttClientImpl getClientConfig() return MqttClientConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive_givenMqttClientImplGetClientConfigReturnMqttClientConfig()
      throws Exception {
    // Arrange
    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(new MqttClientConfig());
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
    verify(client, atLeast(1)).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Then calls {@link MqttClientConfig#getClientId()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#channelActive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelActive(ChannelHandlerContext); then calls getClientId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelActive(ChannelHandlerContext)"})
  void testChannelActive_thenCallsGetClientId() throws Exception {
    // Arrange
    MqttClientConfig mqttClientConfig = mock(MqttClientConfig.class);
    when(mqttClientConfig.isCleanSession()).thenReturn(true);
    when(mqttClientConfig.getTimeoutSeconds()).thenReturn(10);
    when(mqttClientConfig.getClientId()).thenReturn("42");
    when(mqttClientConfig.getPassword()).thenReturn("iloveyou");
    when(mqttClientConfig.getUsername()).thenReturn("janedoe");
    when(mqttClientConfig.getLastWill())
        .thenReturn(
            MqttLastWill.builder()
                .setMessage("Not all who wander are lost")
                .setQos(MqttQoS.AT_MOST_ONCE)
                .setRetain(true)
                .setTopic("Topic")
                .build());
    when(mqttClientConfig.getProtocolVersion()).thenReturn(MqttVersion.MQTT_3_1);

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(mqttClientConfig);
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
    verify(mqttClientConfig).getClientId();
    verify(mqttClientConfig, atLeast(1)).getLastWill();
    verify(mqttClientConfig, atLeast(1)).getPassword();
    verify(mqttClientConfig, atLeast(1)).getProtocolVersion();
    verify(mqttClientConfig).getTimeoutSeconds();
    verify(mqttClientConfig, atLeast(1)).getUsername();
    verify(mqttClientConfig).isCleanSession();
    verify(client, atLeast(1)).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#channelInactive(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttChannelHandler#channelInactive(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelInactive(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.channelInactive(ChannelHandlerContext)"})
  void testChannelInactive() throws Exception {
    // Arrange
    MqttClientImpl client =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelInactive()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttChannelHandler.channelInactive(ctx);

    // Assert
    verify(ctx).fireChannelInactive();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator()));

    MqttPublishMessage message = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttChannelHandler.invokeHandlersForIncomingPublish(message);

    // Assert
    verify(handlerExecutor).execute(isA(Runnable.class));
  }

  /**
   * Test {@link MqttChannelHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link MqttClientConfig} {@link MqttClientConfig#getOwnerId()} return {@code 42}.
   *   <li>Then calls {@link MqttClientConfig#getOwnerId()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given MqttClientConfig getOwnerId() return '42'; then calls getOwnerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenMqttClientConfigGetOwnerIdReturn42_thenCallsGetOwnerId() {
    // Arrange
    MqttClientConfig mqttClientConfig = mock(MqttClientConfig.class);
    when(mqttClientConfig.getOwnerId()).thenReturn("42");

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(mqttClientConfig);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act
    mqttChannelHandler.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(mqttClientConfig).getOwnerId();
    verify(client).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link MqttClientConfig} {@link MqttClientConfig#getOwnerId()} return {@code 42}.
   *   <li>Then calls {@link MqttClientConfig#getOwnerId()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given MqttClientConfig getOwnerId() return '42'; then calls getOwnerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenMqttClientConfigGetOwnerIdReturn42_thenCallsGetOwnerId2() {
    // Arrange
    MqttClientConfig mqttClientConfig = mock(MqttClientConfig.class);
    when(mqttClientConfig.getOwnerId()).thenReturn("42");

    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(mqttClientConfig);
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act
    mqttChannelHandler.exceptionCaught(ctx, new IOException());

    // Assert
    verify(mqttClientConfig).getOwnerId();
    verify(client).getClientConfig();
  }

  /**
   * Test {@link MqttChannelHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link MqttClientImpl} {@link MqttClientImpl#getClientConfig()} return {@link
   *       MqttClientConfig#MqttClientConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttChannelHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given MqttClientImpl getClientConfig() return MqttClientConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttChannelHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenMqttClientImplGetClientConfigReturnMqttClientConfig() {
    // Arrange
    MqttClientImpl client = mock(MqttClientImpl.class);
    when(client.getClientConfig()).thenReturn(new MqttClientConfig());
    MqttChannelHandler mqttChannelHandler =
        new MqttChannelHandler(client, new DefaultProgressivePromise<>(new DefaultEventLoop()));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act
    mqttChannelHandler.exceptionCaught(ctx, new Throwable());

    // Assert
    verify(client).getClientConfig();
  }
}
