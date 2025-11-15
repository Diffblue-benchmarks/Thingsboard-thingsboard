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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonParseException;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelId;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.mqtt.MqttConnectMessage;
import io.netty.handler.codec.mqtt.MqttConnectPayload;
import io.netty.handler.codec.mqtt.MqttConnectVariableHeader;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPubReplyMessageVariableHeader;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodeAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import org.eclipse.leshan.core.ResponseCode;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TransportPayloadType;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.limits.TransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;
import org.thingsboard.server.transport.mqtt.session.MqttTopicMatcher;

class MqttTransportHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("[{}] Processing msg: {}"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRead(ctx, "Msg"));
    verify(ctx).channel();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  void testChannelRead2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel())
        .thenReturn(new EmbeddedChannel(new MqttTransportServerInitializer(new MqttTransportContext(), true)));

    // Act
    mqttTransportHandler.channelRead(ctx, "Msg");

    // Assert
    verify(ctx, atLeast(1)).channel();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  void testChannelReadComplete() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelReadComplete(ctx);

    // Assert that nothing has changed
    verify(ctx).flush();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  void testChannelReadComplete2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.flush()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelReadComplete(ctx));
    verify(ctx).flush();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  void testChannelRegistered() throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRegistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelRegistered(ctx);

    // Assert
    verify(ctx).fireChannelRegistered();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  void testChannelUnregistered() throws Exception {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelUnregistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelUnregistered(ctx);

    // Assert
    verify(ctx).fireChannelUnregistered();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx, byte)}
   */
  @Test
  void testCreateMqttDisconnectMsg() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    MqttMessage actualCreateMqttDisconnectMsgResult = MqttTransportHandler
        .createMqttDisconnectMsg(new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), (byte) 'A');

    // Assert
    Object variableHeaderResult = actualCreateMqttDisconnectMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttReasonCodeAndPropertiesVariableHeader);
    assertNull(actualCreateMqttDisconnectMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttDisconnectMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals((byte) 0, ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).reasonCode());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).properties().isEmpty());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#createMqttDisconnectMsg(DeviceSessionCtx, byte)}
   */
  @Test
  void testCreateMqttDisconnectMsg2() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttMessage actualCreateMqttDisconnectMsgResult = MqttTransportHandler
        .createMqttDisconnectMsg(new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), (byte) 'A');

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    Object variableHeaderResult = actualCreateMqttDisconnectMsgResult.variableHeader();
    assertTrue(variableHeaderResult instanceof MqttReasonCodeAndPropertiesVariableHeader);
    assertNull(actualCreateMqttDisconnectMsgResult.payload());
    DecoderResult decoderResultResult = actualCreateMqttDisconnectMsgResult.decoderResult();
    assertNull(decoderResultResult.cause());
    assertEquals((byte) 0, ((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).reasonCode());
    assertFalse(decoderResultResult.isFailure());
    assertTrue(decoderResultResult.isFinished());
    assertTrue(decoderResultResult.isSuccess());
    assertTrue(((MqttReasonCodeAndPropertiesVariableHeader) variableHeaderResult).properties().isEmpty());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int, byte)}
   */
  @Test
  void testCreateMqttPubAckMsg() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act
    MqttMessage actualCreateMqttPubAckMsgResult = MqttTransportHandler
        .createMqttPubAckMsg(new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), 1, (byte) 'A');

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
   * Method under test:
   * {@link MqttTransportHandler#createMqttPubAckMsg(DeviceSessionCtx, int, byte)}
   */
  @Test
  void testCreateMqttPubAckMsg2() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttMessage actualCreateMqttPubAckMsgResult = MqttTransportHandler
        .createMqttPubAckMsg(new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()), 1, (byte) 'A');

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
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
   * Method under test: {@link MqttTransportHandler#doDisconnect()}
   */
  @Test
  void testDoDisconnect() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());

    // Act
    (new MqttTransportHandler(context, null)).doDisconnect();

    // Assert that nothing has changed
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testEnqueueRegularSessionMsg() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testEnqueueRegularSessionMsg2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testEnqueueRegularSessionMsg3() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new RuntimeException(
        "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
            + " {} and actual queue size {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mqttTransportHandler.enqueueRegularSessionMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(ctx).channel();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
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
   * Method under test:
   * {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
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
   * Method under test:
   * {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught3() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new IOException("[{}] Unexpected Exception"));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught4() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doNothing().when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
      ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
      when(ctx.channel()).thenReturn(new EmbeddedChannel());
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act
      mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError("[{}] Unexpected Exception"));

      // Assert
      verify(ctx, atLeast(1)).channel();
      verify(ctx).close();
      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}
   */
  @Test
  void testExceptionCaught5() {
    try (MockedStatic<Runtime> mockRuntime = mockStatic(Runtime.class)) {
      // Arrange
      Runtime runtime = mock(Runtime.class);
      doThrow(new JsonParseException("[{}] Unexpected Exception")).when(runtime).exit(anyInt());
      mockRuntime.when(Runtime::getRuntime).thenReturn(runtime);
      MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
      ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
      when(ctx.channel()).thenReturn(new EmbeddedChannel());
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act and Assert
      assertThrows(JsonParseException.class,
          () -> mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError("[{}] Unexpected Exception")));
      verify(ctx, atLeast(1)).channel();
      verify(ctx).close();
      verify(runtime).exit(eq(1));
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#getAddress(ChannelHandlerContext)}
   */
  @Test
  void testGetAddress() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    Attribute<Object> attribute = mock(Attribute.class);
    when(attribute.get()).thenThrow(new JsonParseException("[{}] Received empty address."));
    Channel channel = mock(Channel.class);
    when(channel.attr(Mockito.<AttributeKey<Object>>any())).thenReturn(attribute);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(channel);

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.getAddress(ctx));
    verify(ctx).channel();
    verify(attribute).get();
    verify(channel).attr(isA(AttributeKey.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#getAddress(ChannelHandlerContext)}
   */
  @Test
  void testGetAddress2() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    Attribute<Object> attribute = mock(Attribute.class);
    InetSocketAddress createUnresolvedResult = InetSocketAddress.createUnresolved("foo", 1);
    when(attribute.get()).thenReturn(createUnresolvedResult);
    Channel channel = mock(Channel.class);
    when(channel.id()).thenReturn(DefaultChannelId.newInstance());
    when(channel.attr(Mockito.<AttributeKey<Object>>any())).thenReturn(attribute);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(channel);

    // Act
    InetSocketAddress actualAddress = mqttTransportHandler.getAddress(ctx);

    // Assert
    verify(channel).id();
    verify(ctx, atLeast(1)).channel();
    verify(attribute).get();
    verify(channel).attr(isA(AttributeKey.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    assertSame(createUnresolvedResult, actualAddress);
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#MqttTransportHandler(MqttTransportContext, SslHandler)}
   */
  @Test
  void testNewMqttTransportHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    when(context.getJsonMqttAdaptor()).thenReturn(jsonMqttAdaptor);

    // Act
    MqttTransportHandler actualMqttTransportHandler = new MqttTransportHandler(context, null);

    // Assert
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    DeviceSessionCtx deviceSessionCtx = actualMqttTransportHandler.deviceSessionCtx;
    Lock msgQueueProcessorLock = deviceSessionCtx.getMsgQueueProcessorLock();
    assertTrue(msgQueueProcessorLock instanceof ReentrantLock);
    MqttTransportAdaptor payloadAdaptor = deviceSessionCtx.getPayloadAdaptor();
    assertTrue(payloadAdaptor instanceof JsonMqttAdaptor);
    assertNull(deviceSessionCtx.getAttributesDynamicMessageDescriptor());
    assertNull(deviceSessionCtx.getRpcResponseDynamicMessageDescriptor());
    assertNull(deviceSessionCtx.getTelemetryDynamicMsgDescriptor());
    assertNull(deviceSessionCtx.getRpcRequestDynamicMessageBuilder());
    assertNull(deviceSessionCtx.getChannel());
    assertNull(deviceSessionCtx.getMqttVersion());
    assertNull(actualMqttTransportHandler.address);
    assertNull(deviceSessionCtx.getDeviceProfile());
    assertNull(deviceSessionCtx.getDeviceId());
    assertNull(deviceSessionCtx.getTenantId());
    assertNull(deviceSessionCtx.getDeviceInfo());
    assertNull(deviceSessionCtx.getSessionInfo());
    assertNull(actualMqttTransportHandler.gatewaySessionHandler);
    assertNull(actualMqttTransportHandler.sparkplugSessionHandler);
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getQueueLength());
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertEquals(TransportPayloadType.JSON, deviceSessionCtx.getPayloadType());
    assertEquals(TransportPayloadType.JSON, deviceSessionCtx.getProvisionPayloadType());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isFair());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isLocked());
    assertFalse(deviceSessionCtx.isConnected());
    assertFalse(deviceSessionCtx.isDeviceProfileMqttTransportType());
    assertFalse(deviceSessionCtx.isProvisionOnly());
    assertFalse(deviceSessionCtx.isSendAckOnValidationException());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    assertTrue(deviceSessionCtx.getMqttQoSMap().isEmpty());
    assertTrue(deviceSessionCtx.isJsonPayloadType());
    assertSame(jsonMqttAdaptor, payloadAdaptor);
    MqttTransportContext expectedContext = actualMqttTransportHandler.context;
    assertSame(expectedContext, deviceSessionCtx.getContext());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#onAttributeUpdate(UUID, TransportProtos.AttributeUpdateNotificationMsg)}
   */
  @Test
  void testOnAttributeUpdate() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    UUID sessionId = UUID.randomUUID();

    // Act
    mqttTransportHandler.onAttributeUpdate(sessionId,
        TransportProtos.AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testOnRemoteSessionCloseCommand() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.randomUUID();

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).deregisterSession(isNull());
    verify(context).getJsonMqttAdaptor();
    verify(context).getMessageQueueSizePerDeviceLimit();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testOnRemoteSessionCloseCommand2() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.randomUUID();

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).deregisterSession(isNull());
    verify(context).getJsonMqttAdaptor();
    verify(context).getMessageQueueSizePerDeviceLimit();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testOnRemoteSessionCloseCommand3() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    Channel channel = mock(Channel.class);
    when(channel.isOpen()).thenReturn(false);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(channel);

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.randomUUID();

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance());

    // Assert
    verify(channel).isOpen();
    verify(ctx, atLeast(1)).channel();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).deregisterSession(isNull());
    verify(context).getJsonMqttAdaptor();
    verify(context).getMessageQueueSizePerDeviceLimit();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  void testOnRemoteSessionCloseCommand4() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    Channel channel = mock(Channel.class);
    when(channel.isOpen())
        .thenThrow(new JsonParseException("[{}] Received the remote command to close the session: {}"));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(channel);

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.randomUUID();

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.onRemoteSessionCloseCommand(sessionId,
        TransportProtos.SessionCloseNotificationProto.getDefaultInstance()));
    verify(channel).isOpen();
    verify(ctx, atLeast(1)).channel();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).deregisterSession(isNull());
    verify(context).getJsonMqttAdaptor();
    verify(context).getMessageQueueSizePerDeviceLimit();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  void testOnToDeviceRpcRequest() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    UUID sessionId = UUID.randomUUID();

    // Act
    mqttTransportHandler.onToDeviceRpcRequest(sessionId, TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test: {@link MqttTransportHandler#operationComplete(Future)}
   */
  @Test
  void testOperationComplete() throws Exception {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    // Act
    mqttTransportHandler.operationComplete(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Assert that nothing has changed
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect() {
    // Arrange
    SslHandler sslHandler = mock(SslHandler.class);
    when(sslHandler.engine()).thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), sslHandler);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, true,
        1);

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
            new MqttConnectPayload("42", "Will Topic", "Will Message", "janedoe", "iloveyou"))));
    verify(sslHandler).engine();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect2() {
    // Arrange
    SslHandler sslHandler = mock(SslHandler.class);
    when(sslHandler.engine()).thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), sslHandler);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 5, true, true, true, 1, true, true,
        1);

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
            new MqttConnectPayload("42", "Will Topic", "Will Message", "janedoe", "iloveyou"))));
    verify(sslHandler).engine();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect3() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(),
        mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, true,
        1);

    // Act
    mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "janedoe", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect4() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(),
        mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 5, true, true, true, 1, true, true,
        1);

    // Act
    mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "janedoe", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_5, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect5() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(),
        mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true,
        false, 1);

    // Act
    mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "janedoe", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect6() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(),
        mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, true,
        1);

    // Act
    mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "provision", "iloveyou")));

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}
   */
  @Test
  void testProcessConnect7() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(),
        mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttConnectVariableHeader variableHeader = new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, true,
        1);

    // Act and Assert
    assertThrows(JsonParseException.class,
        () -> mqttTransportHandler.processConnect(ctx, new MqttConnectMessage(mqttFixedHeader, variableHeader,
            new MqttConnectPayload("provision", "Will Topic", "Will Message", "janedoe", "iloveyou"))));
    verify(ctx).writeAndFlush(isA(Object.class));
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testProcessMqttMsg() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
    assertSame(ctx, mqttTransportHandler.deviceSessionCtx.getChannel());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testProcessMqttMsg2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
    assertSame(ctx, mqttTransportHandler.deviceSessionCtx.getChannel());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testProcessMqttMsg3() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new RuntimeException(
        "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
            + " {} and actual queue size {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mqttTransportHandler.processMqttMsg(ctx,
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(ctx).channel();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testProcessRegularSessionMsg() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    MqttPublishMessage msg = mock(MqttPublishMessage.class);
    when(msg.fixedHeader())
        .thenReturn(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act
    mqttTransportHandler.processRegularSessionMsg(ctx, msg);

    // Assert that nothing has changed
    verify(msg).fixedHeader();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  void testProcessRegularSessionMsg2() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    MqttPublishMessage msg = mock(MqttPublishMessage.class);
    when(msg.fixedHeader())
        .thenReturn(new MqttFixedHeader(MqttMessageType.PUBLISH, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act
    mqttTransportHandler.processRegularSessionMsg(ctx, msg);

    // Assert that nothing has changed
    verify(msg).fixedHeader();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  void testRegisterSubQoS() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);
    ArrayList<Integer> grantedQoSList = new ArrayList<>();

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(1, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(0).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  void testRegisterSubQoS2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(new MqttTransportContext(), null);

    ArrayList<Integer> grantedQoSList = new ArrayList<>();
    grantedQoSList.add(2);

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(2, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(1).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
    assertEquals(2, grantedQoSList.get(0).intValue());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  void testRegisterSubQoS3() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(
        mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    context.setTransportService(new DefaultTransportService(partitionService, queueProvider, producerProvider,
        ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache,
        tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    ArrayList<Integer> grantedQoSList = new ArrayList<>();

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(1, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(0).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)}
   */
  @Test
  void testSendErrorRpcResponse() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    // Act
    mqttTransportHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto.getDefaultInstance(), 1,
        ThingsboardErrorCode.GENERAL, "An error occurred");

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)}
   */
  @Test
  void testSendErrorRpcResponse2() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    // Act
    mqttTransportHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto.getDefaultInstance(), 1,
        ThingsboardErrorCode.GENERAL, "An error occurred");

    // Assert
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)}
   */
  @Test
  void testSendSuccessRpcResponse() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    mqttTransportHandler.sendSuccessRpcResponse(sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg");

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Method under test:
   * {@link MqttTransportHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)}
   */
  @Test
  void testSendSuccessRpcResponse2() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    mqttTransportHandler.sendSuccessRpcResponse(sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg");

    // Assert
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(context).getJsonMqttAdaptor();
  }
}
