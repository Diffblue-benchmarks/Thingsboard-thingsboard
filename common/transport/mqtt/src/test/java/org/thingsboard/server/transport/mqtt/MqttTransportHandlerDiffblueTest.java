package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonParseException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
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
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodeAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.handler.ssl.SslHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.leshan.core.ResponseCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.limits.TransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionCloseNotificationProto;
import org.thingsboard.server.gen.transport.TransportProtos.SessionCloseReason;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcResponseMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ValidateBasicMqttCredRequestMsg;
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

@ExtendWith(MockitoExtension.class)
class MqttTransportHandlerDiffblueTest {
  @Mock private MqttTransportContext mqttTransportContext;

  @InjectMocks private MqttTransportHandler mqttTransportHandler;

  /**
   * Test {@link MqttTransportHandler#MqttTransportHandler(MqttTransportContext, SslHandler)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#MqttTransportHandler(MqttTransportContext,
   * SslHandler)}
   */
  @Test
  @DisplayName("Test new MqttTransportHandler(MqttTransportContext, SslHandler)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.<init>(MqttTransportContext, SslHandler)"})
  void testNewMqttTransportHandler() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(context.getTransportService()).thenReturn(defaultTransportService);
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
    MqttTransportAdaptor payloadAdaptor = deviceSessionCtx.getPayloadAdaptor();
    assertTrue(payloadAdaptor instanceof JsonMqttAdaptor);
    assertEquals(defaultTransportService.sessions, deviceSessionCtx.getMqttQoSMap());
    assertSame(jsonMqttAdaptor, payloadAdaptor);
    assertSame(actualMqttTransportHandler.context, deviceSessionCtx.getContext());
  }

  /**
   * Test {@link MqttTransportHandler#MqttTransportHandler(MqttTransportContext, SslHandler)}.
   *
   * <ul>
   *   <li>Then return {@link MqttTransportHandler#context} SslHandler is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#MqttTransportHandler(MqttTransportContext,
   * SslHandler)}
   */
  @Test
  @DisplayName(
      "Test new MqttTransportHandler(MqttTransportContext, SslHandler); then return context SslHandler is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.<init>(MqttTransportContext, SslHandler)"})
  void testNewMqttTransportHandler_thenReturnContextSslHandlerIsNull() {
    // Arrange and Act
    MqttTransportHandler actualMqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    // Assert
    MqttTransportContext mqttTransportContext = actualMqttTransportHandler.context;
    assertNull(mqttTransportContext.getSslHandler());
    assertNull(mqttTransportContext.getMaxPayloadSize());
    assertNull(mqttTransportContext.getExecutor());
    assertNull(mqttTransportContext.getOtaPackageDataCache());
    assertNull(mqttTransportContext.getTransportResourceCache());
    assertNull(mqttTransportContext.getTransportService());
    assertNull(mqttTransportContext.getTenantProfileCache());
    assertNull(mqttTransportContext.getRateLimitService());
    assertNull(mqttTransportContext.getServiceInfoProvider());
    assertNull(mqttTransportContext.getScheduler());
    assertNull(mqttTransportContext.getSslHandlerProvider());
    assertNull(mqttTransportContext.getJsonMqttAdaptor());
    DeviceSessionCtx deviceSessionCtx = actualMqttTransportHandler.deviceSessionCtx;
    assertNull(deviceSessionCtx.getPayloadAdaptor());
    assertNull(mqttTransportContext.getProtoMqttAdaptor());
    assertNull(mqttTransportContext.getGatewayMetricsService());
    assertEquals(0, mqttTransportContext.getMessageQueueSizePerDeviceLimit());
    assertEquals(0L, mqttTransportContext.getDisconnectTimeout());
    assertEquals(0L, mqttTransportContext.getTimeout());
    assertFalse(mqttTransportContext.isProxyEnabled());
    assertFalse(mqttTransportContext.isSkipValidityCheckForClientCert());
    assertSame(actualMqttTransportHandler.context, deviceSessionCtx.getContext());
  }

  /**
   * Test {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelRegistered(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered() throws Exception {
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
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelRegistered(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered2() throws Exception {
    // Arrange
    doThrow(new JsonParseException("Msg")).when(mqttTransportContext).channelRegistered();

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRegistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRegistered(ctx));
    verify(ctx).fireChannelRegistered();
    verify(mqttTransportContext).channelRegistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelRegistered(ChannelHandlerContext); given JsonParseException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered_givenJsonParseExceptionWithMsg() throws Exception {
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
   * Test {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link MqttTransportContext} {@link MqttTransportContext#channelRegistered()} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRegistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelRegistered(ChannelHandlerContext); given MqttTransportContext channelRegistered() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRegistered(ChannelHandlerContext)"})
  void testChannelRegistered_givenMqttTransportContextChannelRegisteredDoesNothing()
      throws Exception {
    // Arrange
    doNothing().when(mqttTransportContext).channelRegistered();

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelRegistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelRegistered(ctx);

    // Assert
    verify(ctx).fireChannelRegistered();
    verify(mqttTransportContext).channelRegistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelUnregistered(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered() throws Exception {
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
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelUnregistered(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered2() throws Exception {
    // Arrange
    doThrow(new JsonParseException("Msg")).when(mqttTransportContext).channelUnregistered();

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelUnregistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelUnregistered(ctx));
    verify(ctx).fireChannelUnregistered();
    verify(mqttTransportContext).channelUnregistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with {@code Msg}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelUnregistered(ChannelHandlerContext); given JsonParseException(String) with 'Msg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered_givenJsonParseExceptionWithMsg() throws Exception {
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
   * Test {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}.
   *
   * <ul>
   *   <li>Given {@link MqttTransportContext} {@link MqttTransportContext#channelUnregistered()}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelUnregistered(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelUnregistered(ChannelHandlerContext); given MqttTransportContext channelUnregistered() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelUnregistered(ChannelHandlerContext)"})
  void testChannelUnregistered_givenMqttTransportContextChannelUnregisteredDoesNothing()
      throws Exception {
    // Arrange
    doNothing().when(mqttTransportContext).channelUnregistered();

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.fireChannelUnregistered()).thenReturn(mock(ChannelHandlerContext.class));

    // Act
    mqttTransportHandler.channelUnregistered(ctx);

    // Assert
    verify(ctx).fireChannelUnregistered();
    verify(mqttTransportContext).channelUnregistered();
  }

  /**
   * Test {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelRead(ChannelHandlerContext, Object)}
   */
  @Test
  @DisplayName("Test channelRead(ChannelHandlerContext, Object); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelRead(ChannelHandlerContext, Object)"})
  void testChannelRead_thenThrowJsonParseException() {
    // Arrange
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException(" -XX:MaxDirectMemorySize = 9  "));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.channelRead(ctx, "Msg"));
    verify(ctx).channel();
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
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("Msg"));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.getAddress(ctx));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    when(msg.payload())
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processMqttMsg(ctx, msg));
    verify(msg).payload();
    verify(msg, atLeast(1)).fixedHeader();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg2() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    when(msg.variableHeader())
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttConnectPayload mqttConnectPayload =
        new MqttConnectPayload("42", "Will Topic", "Will Message", "provision", "iloveyou");
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processMqttMsg(ctx, msg));
    verify(msg, atLeast(1)).payload();
    verify(msg).variableHeader();
    verify(msg, atLeast(1)).fixedHeader();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg3() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    MqttConnectPayload mqttConnectPayload =
        new MqttConnectPayload("42", "Will Topic", "Will Message", "provision", "iloveyou");
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    verify(msg, atLeast(1)).payload();
    verify(msg, atLeast(1)).variableHeader();
    verify(msg, atLeast(1)).fixedHeader();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg4() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    MqttConnectPayload mqttConnectPayload =
        new MqttConnectPayload("42", "Will Topic", "Will Message", "provision", "iloveyou");
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processMqttMsg(ctx, msg));
    verify(ctx).writeAndFlush(isA(Object.class));
    verify(msg, atLeast(1)).payload();
    verify(msg, atLeast(1)).variableHeader();
    verify(msg, atLeast(1)).fixedHeader();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg5() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, true, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    MqttConnectPayload mqttConnectPayload =
        new MqttConnectPayload("42", "Will Topic", "Will Message", "provision", "iloveyou");
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    verify(msg, atLeast(1)).payload();
    verify(msg, atLeast(1)).variableHeader();
    verify(msg, atLeast(1)).fixedHeader();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg6() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 5, true, true, true, 1, true, true, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    MqttConnectPayload mqttConnectPayload =
        new MqttConnectPayload("42", "Will Topic", "Will Message", "provision", "iloveyou");
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    verify(msg, atLeast(1)).payload();
    verify(msg, atLeast(1)).variableHeader();
    verify(msg, atLeast(1)).fixedHeader();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertEquals(MqttVersion.MQTT_5, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg7() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), mock(SslHandler.class));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.PUBLISH);

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert that nothing has changed
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
    verify(mqttFixedHeader).messageType();
    verify(msg, atLeast(1)).fixedHeader();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertFalse(deviceSessionCtx.isProvisionOnly());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg8() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType())
        .thenThrow(
            new JsonParseException(
                "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
                    + " {} and actual queue size {}"));

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processMqttMsg(ctx, msg));
    verify(mqttFixedHeader).messageType();
    verify(msg, atLeast(1)).fixedHeader();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg9() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(context.getTransportService()).thenReturn(defaultTransportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(context, mock(SslHandler.class));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.PUBLISH);

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert
    verify(mqttFixedHeader).messageType();
    verify(msg, atLeast(1)).fixedHeader();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    verify(context).getMessageQueueSizePerDeviceLimit();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertNull(deviceSessionCtx.getMqttVersion());
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
    assertFalse(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg10() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getMessageQueueSizePerDeviceLimit()).thenReturn(0);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    when(context.getTransportService()).thenReturn(defaultTransportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(context, mock(SslHandler.class));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttFixedHeader mqttFixedHeader = mock(MqttFixedHeader.class);
    when(mqttFixedHeader.messageType()).thenReturn(MqttMessageType.PUBLISH);

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    when(msg.fixedHeader()).thenReturn(mqttFixedHeader);

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert that nothing has changed
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
    verify(mqttFixedHeader).messageType();
    verify(msg, atLeast(1)).fixedHeader();
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    verify(context, atLeast(1)).getMessageQueueSizePerDeviceLimit();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertFalse(deviceSessionCtx.isProvisionOnly());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@link MqttConnectPayload} {@link MqttConnectPayload#clientIdentifier()} return
   *       {@code provision}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test processMqttMsg(ChannelHandlerContext, MqttMessage); given MqttConnectPayload clientIdentifier() return 'provision'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg_givenMqttConnectPayloadClientIdentifierReturnProvision() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttConnectPayload mqttConnectPayload = mock(MqttConnectPayload.class);
    when(mqttConnectPayload.clientIdentifier()).thenReturn("provision");
    when(mqttConnectPayload.userName()).thenReturn("provision");

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act
    mqttTransportHandler.processMqttMsg(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    verify(msg, atLeast(1)).payload();
    verify(msg, atLeast(1)).variableHeader();
    verify(mqttConnectPayload, atLeast(1)).clientIdentifier();
    verify(mqttConnectPayload).userName();
    verify(msg, atLeast(1)).fixedHeader();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Then calls {@link SslHandler#engine()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName("Test processMqttMsg(ChannelHandlerContext, MqttMessage); then calls engine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg_thenCallsEngine() {
    // Arrange
    SslHandler sslHandler = mock(SslHandler.class);
    when(sslHandler.engine())
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), sslHandler);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    MqttConnectPayload mqttConnectPayload = mock(MqttConnectPayload.class);
    when(mqttConnectPayload.clientIdentifier()).thenReturn("42");
    when(mqttConnectPayload.userName()).thenReturn("janedoe");

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processMqttMsg(ctx, msg));
    verify(msg, atLeast(1)).payload();
    verify(msg).variableHeader();
    verify(mqttConnectPayload, atLeast(1)).clientIdentifier();
    verify(mqttConnectPayload).userName();
    verify(msg, atLeast(1)).fixedHeader();
    verify(sslHandler).engine();
  }

  /**
   * Test {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Then calls {@link MqttConnectPayload#passwordInBytes()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processMqttMsg(ChannelHandlerContext,
   * MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test processMqttMsg(ChannelHandlerContext, MqttMessage); then calls passwordInBytes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processMqttMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessMqttMsg_thenCallsPasswordInBytes() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    MqttConnectPayload mqttConnectPayload = mock(MqttConnectPayload.class);
    when(mqttConnectPayload.passwordInBytes())
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    when(mqttConnectPayload.clientIdentifier()).thenReturn("42");
    when(mqttConnectPayload.userName()).thenReturn("janedoe");

    MqttConnectMessage msg = mock(MqttConnectMessage.class);
    MqttConnectVariableHeader mqttConnectVariableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);
    when(msg.variableHeader()).thenReturn(mqttConnectVariableHeader);
    when(msg.payload()).thenReturn(mqttConnectPayload);
    when(msg.fixedHeader())
        .thenReturn(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3));

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processMqttMsg(ctx, msg));
    verify(msg, atLeast(1)).payload();
    verify(msg).variableHeader();
    verify(mqttConnectPayload, atLeast(1)).clientIdentifier();
    verify(mqttConnectPayload).passwordInBytes();
    verify(mqttConnectPayload, atLeast(1)).userName();
    verify(msg, atLeast(1)).fixedHeader();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg() {
    // Arrange
    when(mqttTransportContext.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(mqttTransportContext).getMessageQueueSizePerDeviceLimit();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg2() {
    // Arrange
    when(mqttTransportContext.getMessageQueueSizePerDeviceLimit())
        .thenThrow(
            new JsonParseException(
                "Closing current session because msq queue size for device {} exceed limit {} with msgQueueSize counter"
                    + " {} and actual queue size {}"));
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.enqueueRegularSessionMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(mqttTransportContext).getMessageQueueSizePerDeviceLimit();
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg3() {
    // Arrange
    when(mqttTransportContext.getMessageQueueSizePerDeviceLimit()).thenReturn(0);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert that nothing has changed
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
    verify(mqttTransportContext, atLeast(1)).getMessageQueueSizePerDeviceLimit();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg4() {
    // Arrange
    when(mqttTransportContext.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader =
        new MqttPublishVariableHeader(
            "[{}][{}] Postpone processing msg due to device is not connected. Msg queue size is {}",
            1);

    MqttPublishMessage msg =
        new MqttPublishMessage(mqttFixedHeader, variableHeader, Unpooled.compositeBuffer(3));

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(ctx, msg);

    // Assert
    verify(mqttTransportContext).getMessageQueueSizePerDeviceLimit();
    ByteBuf payloadResult = msg.payload();
    assertTrue(payloadResult instanceof CompositeByteBuf);
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
    assertEquals(2, payloadResult.refCnt());
  }

  /**
   * Test {@link MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@link JsonParseException#JsonParseException(String)} with msg is a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); given JsonParseException(String) with msg is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_givenJsonParseExceptionWithMsgIsAString() {
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
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_thenCallsClose() {
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
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.enqueueRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testEnqueueRegularSessionMsg_whenEmptyByteBufWithAllocIsAllocator() {
    // Arrange
    when(mqttTransportContext.getMessageQueueSizePerDeviceLimit()).thenReturn(3);
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader =
        new MqttPublishVariableHeader(
            "[{}][{}] Postpone processing msg due to device is not connected. Msg queue size is {}",
            1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage msg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttTransportHandler.enqueueRegularSessionMsg(ctx, msg);

    // Assert
    verify(mqttTransportContext).getMessageQueueSizePerDeviceLimit();
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test processRegularSessionMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessRegularSessionMsg() {
    // Arrange
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            mqttTransportHandler.processRegularSessionMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3))));
  }

  /**
   * Test {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test processRegularSessionMsg(ChannelHandlerContext, MqttMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessRegularSessionMsg2() {
    // Arrange
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);

    // Act and Assert
    assertDoesNotThrow(
        () ->
            mqttTransportHandler.processRegularSessionMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.PINGREQ, true, MqttQoS.AT_MOST_ONCE, true, 3))));
  }

  /**
   * Test {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test processRegularSessionMsg(ChannelHandlerContext, MqttMessage); given EmbeddedChannel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessRegularSessionMsg_givenEmbeddedChannel() {
    // Arrange
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.processRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.DISCONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName("Test processRegularSessionMsg(ChannelHandlerContext, MqttMessage); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessRegularSessionMsg_givenNull() {
    // Arrange
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.processRegularSessionMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.DISCONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(ctx).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#processRegularSessionMsg(ChannelHandlerContext, MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test processRegularSessionMsg(ChannelHandlerContext, MqttMessage); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processRegularSessionMsg(ChannelHandlerContext, MqttMessage)"
  })
  void testProcessRegularSessionMsg_thenThrowJsonParseException() {
    // Arrange
    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenThrow(new JsonParseException("[{}] Channel is null, closing ctx..."));

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.processRegularSessionMsg(
                ctx,
                new MqttMessage(
                    new MqttFixedHeader(
                        MqttMessageType.DISCONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3))));
    verify(ctx).channel();
  }

  /**
   * Test {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then {@link ArrayList#ArrayList()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test registerSubQoS(String, List, MqttQoS); given zero; when ArrayList() add zero; then ArrayList() size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.registerSubQoS(String, List, MqttQoS)"})
  void testRegisterSubQoS_givenZero_whenArrayListAddZero_thenArrayListSizeIsTwo() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ArrayList<Integer> grantedQoSList = new ArrayList<>();
    grantedQoSList.add(0);

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(2, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(0).intValue());
    assertEquals(0, grantedQoSList.get(1).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
  }

  /**
   * Test {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}.
   *
   * <ul>
   *   <li>When {@code Topic}.
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#registerSubQoS(String, List, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test registerSubQoS(String, List, MqttQoS); when 'Topic'; then ArrayList() size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.registerSubQoS(String, List, MqttQoS)"})
  void testRegisterSubQoS_whenTopic_thenArrayListSizeIsOne() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);
    ArrayList<Integer> grantedQoSList = new ArrayList<>();

    // Act
    mqttTransportHandler.registerSubQoS("Topic", grantedQoSList, MqttQoS.AT_MOST_ONCE);

    // Assert
    assertEquals(1, grantedQoSList.size());
    assertEquals(0, grantedQoSList.get(0).intValue());
    assertEquals(1, mqttTransportHandler.deviceSessionCtx.getMqttQoSMap().size());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, false, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "provision", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttTransportHandler.processConnect(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect2() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, false, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "provision", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttTransportHandler.processConnect(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect3() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 5, true, true, true, 1, true, false, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "provision", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttTransportHandler.processConnect(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_5, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect4() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, true, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "provision", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttTransportHandler.processConnect(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName("Test processConnect(ChannelHandlerContext, MqttConnectMessage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect5() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, false, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "janedoe", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    mqttTransportHandler.processConnect(ctx, msg);

    // Assert
    verify(ctx).writeAndFlush(isA(Object.class));
    DeviceSessionCtx deviceSessionCtx = mqttTransportHandler.deviceSessionCtx;
    assertEquals(MqttVersion.MQTT_3_1, deviceSessionCtx.getMqttVersion());
    assertTrue(deviceSessionCtx.isProvisionOnly());
  }

  /**
   * Test {@link MqttTransportHandler#processConnect(ChannelHandlerContext, MqttConnectMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#processConnect(ChannelHandlerContext,
   * MqttConnectMessage)}
   */
  @Test
  @DisplayName(
      "Test processConnect(ChannelHandlerContext, MqttConnectMessage); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.processConnect(ChannelHandlerContext, MqttConnectMessage)"
  })
  void testProcessConnect_thenThrowJsonParseException() {
    // Arrange
    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.writeAndFlush(Mockito.<Object>any()))
        .thenThrow(new JsonParseException("[{}][{}] Processing connect msg for client: {}!"));
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 3, true, true, true, 1, true, false, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("provision", "Will Topic", "Will Message", "provision", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    // Act and Assert
    assertThrows(JsonParseException.class, () -> mqttTransportHandler.processConnect(ctx, msg));
    verify(ctx).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName("Test channelReadComplete(ChannelHandlerContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete() {
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
   *   <li>Given {@link MqttTransportContext}.
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#channelReadComplete(ChannelHandlerContext)}
   */
  @Test
  @DisplayName(
      "Test channelReadComplete(ChannelHandlerContext); given MqttTransportContext; then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.channelReadComplete(ChannelHandlerContext)"})
  void testChannelReadComplete_givenMqttTransportContext_thenThrowJsonParseException() {
    // Arrange
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
      when(ctx.channel()).thenReturn(new EmbeddedChannel());
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act and Assert
      assertThrows(
          JsonParseException.class,
          () -> mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError()));
      verify(ctx, atLeast(1)).channel();
      verify(ctx).close();
      mockRuntime.verify(Runtime::getRuntime);
    }
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   *   <li>When {@link IOException#IOException()}.
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given EmbeddedChannel(); when IOException(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEmbeddedChannel_whenIOException_thenCallsClose() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    // Act
    mqttTransportHandler.exceptionCaught(ctx, new IOException());

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx).close();
  }

  /**
   * Test {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel#EmbeddedChannel()}.
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then calls {@link ChannelHandlerContext#close()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#exceptionCaught(ChannelHandlerContext,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test exceptionCaught(ChannelHandlerContext, Throwable); given EmbeddedChannel(); when Throwable(); then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportHandler.exceptionCaught(ChannelHandlerContext, Throwable)"})
  void testExceptionCaught_givenEmbeddedChannel_whenThrowable_thenCallsClose() {
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
      when(ctx.channel()).thenReturn(new EmbeddedChannel());
      when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

      // Act
      mqttTransportHandler.exceptionCaught(ctx, new OutOfMemoryError());

      // Assert
      verify(ctx, atLeast(1)).channel();
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
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName("Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(new EmbeddedChannel());
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason()).thenReturn(SessionCloseReason.CREDENTIALS_UPDATED);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification);

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx, atLeast(1)).close();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <ul>
   *   <li>Given {@link ChannelHandlerContext} {@link ChannelHandlerContext#channel()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName(
      "Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto); given ChannelHandlerContext channel() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand_givenChannelHandlerContextChannelReturnNull() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(null);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason()).thenReturn(SessionCloseReason.CREDENTIALS_UPDATED);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification);

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx, atLeast(1)).close();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedChannel} {@link EmbeddedChannel#isOpen()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName(
      "Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto); given EmbeddedChannel isOpen() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand_givenEmbeddedChannelIsOpenReturnFalse() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.isOpen()).thenReturn(false);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(embeddedChannel);

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason()).thenReturn(SessionCloseReason.CREDENTIALS_UPDATED);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification);

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(embeddedChannel, atLeast(1)).isOpen();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <ul>
   *   <li>Given {@code MAX_CONCURRENT_SESSIONS_LIMIT_REACHED}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName(
      "Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto); given 'MAX_CONCURRENT_SESSIONS_LIMIT_REACHED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand_givenMaxConcurrentSessionsLimitReached() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.isOpen()).thenReturn(true);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(embeddedChannel);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason())
        .thenReturn(SessionCloseReason.MAX_CONCURRENT_SESSIONS_LIMIT_REACHED);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification);

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx, atLeast(1)).close();
    verify(embeddedChannel, atLeast(1)).isOpen();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <ul>
   *   <li>Given {@code SESSION_TIMEOUT}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName(
      "Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto); given 'SESSION_TIMEOUT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand_givenSessionTimeout() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.isOpen()).thenReturn(true);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(embeddedChannel);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason()).thenReturn(SessionCloseReason.SESSION_TIMEOUT);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification);

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx, atLeast(1)).close();
    verify(embeddedChannel, atLeast(1)).isOpen();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <ul>
   *   <li>Given {@code UNKNOWN_REASON}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName(
      "Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto); given 'UNKNOWN_REASON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand_givenUnknownReason() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.isOpen()).thenReturn(true);

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(embeddedChannel);
    when(ctx.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    mqttTransportHandler.processMqttMsg(
        ctx,
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason()).thenReturn(SessionCloseReason.UNKNOWN_REASON);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act
    mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification);

    // Assert
    verify(ctx, atLeast(1)).channel();
    verify(ctx, atLeast(1)).close();
    verify(embeddedChannel, atLeast(1)).isOpen();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * SessionCloseNotificationProto)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#onRemoteSessionCloseCommand(UUID,
   * TransportProtos.SessionCloseNotificationProto)}
   */
  @Test
  @DisplayName(
      "Test onRemoteSessionCloseCommand(UUID, SessionCloseNotificationProto); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.onRemoteSessionCloseCommand(UUID, TransportProtos.SessionCloseNotificationProto)"
  })
  void testOnRemoteSessionCloseCommand_thenThrowJsonParseException() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<DeviceTransportType>any(),
            Mockito.<ValidateBasicMqttCredRequestMsg>any(),
            Mockito.<TransportServiceCallback<ValidateDeviceCredentialsResponse>>any());
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());

    MqttTransportContext context = new MqttTransportContext();
    context.setTransportService(transportService);

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.isOpen())
        .thenThrow(
            new JsonParseException("[{}] Received the remote command to close the session: {}"));

    ChannelHandlerContext ctx = mock(ChannelHandlerContext.class);
    when(ctx.channel()).thenReturn(embeddedChannel);

    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttConnectVariableHeader variableHeader =
        new MqttConnectVariableHeader("Name", 1, true, true, true, 1, true, true, 1);
    MqttConnectPayload payload =
        new MqttConnectPayload("42", "Will Topic", "Will Message", "janedoe", "iloveyou");

    MqttConnectMessage msg = new MqttConnectMessage(mqttFixedHeader, variableHeader, payload);

    mqttTransportHandler.processMqttMsg(ctx, msg);
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    SessionCloseNotificationProto sessionCloseNotification =
        mock(SessionCloseNotificationProto.class);
    when(sessionCloseNotification.getReason()).thenReturn(SessionCloseReason.CREDENTIALS_UPDATED);
    when(sessionCloseNotification.getMessage()).thenReturn("Not all who wander are lost");

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.onRemoteSessionCloseCommand(sessionId, sessionCloseNotification));
    verify(ctx, atLeast(1)).channel();
    verify(embeddedChannel).isOpen();
    verify(transportService).deregisterSession((SessionInfoProto) isNull());
    verify(transportService)
        .process(
            eq(DeviceTransportType.MQTT),
            isA(ValidateBasicMqttCredRequestMsg.class),
            isA(TransportServiceCallback.class));
    verify(sessionCloseNotification).getMessage();
    verify(sessionCloseNotification).getReason();
  }

  /**
   * Test {@link MqttTransportHandler#sendToDeviceRpcRequest(MqttMessage, ToDeviceRpcRequestMsg,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link JsonParseException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportHandler#sendToDeviceRpcRequest(MqttMessage,
   * TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test sendToDeviceRpcRequest(MqttMessage, ToDeviceRpcRequestMsg, SessionInfoProto); then throw JsonParseException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.sendToDeviceRpcRequest(MqttMessage, TransportProtos.ToDeviceRpcRequestMsg, TransportProtos.SessionInfoProto)"
  })
  void testSendToDeviceRpcRequest_thenThrowJsonParseException() {
    // Arrange
    MqttTransportHandler mqttTransportHandler =
        new MqttTransportHandler(new MqttTransportContext(), null);

    MqttPublishMessage payload = mock(MqttPublishMessage.class);
    when(payload.fixedHeader()).thenThrow(new JsonParseException("Msg"));
    when(payload.variableHeader()).thenReturn(new MqttPublishVariableHeader("Topic Name", 1));

    // Act and Assert
    assertThrows(
        JsonParseException.class,
        () ->
            mqttTransportHandler.sendToDeviceRpcRequest(
                payload,
                ToDeviceRpcRequestMsg.getDefaultInstance(),
                SessionInfoProto.getDefaultInstance()));
    verify(payload).fixedHeader();
    verify(payload).variableHeader();
  }

  /**
   * Test {@link MqttTransportHandler#sendErrorRpcResponse(SessionInfoProto, int,
   * ThingsboardErrorCode, String)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int,
   * ThingsboardErrorCode, String)}
   */
  @Test
  @DisplayName(
      "Test sendErrorRpcResponse(SessionInfoProto, int, ThingsboardErrorCode, String); then calls process(NotificationRuleTrigger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)"
  })
  void testSendErrorRpcResponse_thenCallsProcess() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<DeviceId>any(),
            anyInt(),
            anyBoolean()))
        .thenReturn(new TbPair<>(EntityType.TENANT, true));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));

    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    // Act
    mqttTransportHandler.sendErrorRpcResponse(
        SessionInfoProto.getDefaultInstance(),
        1,
        ThingsboardErrorCode.GENERAL,
        "An error occurred");

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(rateLimitService)
        .checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Test {@link MqttTransportHandler#sendErrorRpcResponse(SessionInfoProto, int,
   * ThingsboardErrorCode, String)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTransportService#process(SessionInfoProto,
   *       ToDeviceRpcResponseMsg, TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#sendErrorRpcResponse(TransportProtos.SessionInfoProto, int,
   * ThingsboardErrorCode, String)}
   */
  @Test
  @DisplayName(
      "Test sendErrorRpcResponse(SessionInfoProto, int, ThingsboardErrorCode, String); then calls process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.sendErrorRpcResponse(TransportProtos.SessionInfoProto, int, ThingsboardErrorCode, String)"
  })
  void testSendErrorRpcResponse_thenCallsProcess2() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);

    // Act
    mqttTransportHandler.sendErrorRpcResponse(
        SessionInfoProto.getDefaultInstance(),
        1,
        ThingsboardErrorCode.GENERAL,
        "An error occurred");

    // Assert
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(SessionInfoProto.class),
            isA(ToDeviceRpcResponseMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Test {@link MqttTransportHandler#sendSuccessRpcResponse(SessionInfoProto, int, ResponseCode,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int,
   * ResponseCode, String)}
   */
  @Test
  @DisplayName(
      "Test sendSuccessRpcResponse(SessionInfoProto, int, ResponseCode, String); then calls process(NotificationRuleTrigger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)"
  })
  void testSendSuccessRpcResponse_thenCallsProcess() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<DeviceId>any(),
            anyInt(),
            anyBoolean()))
        .thenReturn(new TbPair<>(EntityType.TENANT, true));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));

    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    mqttTransportHandler.sendSuccessRpcResponse(
        sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg");

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(rateLimitService)
        .checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Test {@link MqttTransportHandler#sendSuccessRpcResponse(SessionInfoProto, int, ResponseCode,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTransportService#process(SessionInfoProto,
   *       ToDeviceRpcResponseMsg, TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MqttTransportHandler#sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int,
   * ResponseCode, String)}
   */
  @Test
  @DisplayName(
      "Test sendSuccessRpcResponse(SessionInfoProto, int, ResponseCode, String); then calls process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MqttTransportHandler.sendSuccessRpcResponse(TransportProtos.SessionInfoProto, int, ResponseCode, String)"
  })
  void testSendSuccessRpcResponse_thenCallsProcess2() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    when(context.getScheduler()).thenReturn(new DefaultSchedulerComponent());
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    MqttTransportHandler mqttTransportHandler = new MqttTransportHandler(context, null);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    mqttTransportHandler.sendSuccessRpcResponse(
        sessionInfo, 1, ResponseCode.fromCode(1), "Success Msg");

    // Assert
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(SessionInfoProto.class),
            isA(ToDeviceRpcResponseMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(context).getJsonMqttAdaptor();
  }
}
