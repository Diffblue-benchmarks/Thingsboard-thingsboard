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

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
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

class MqttTransportServerInitializerDiffblueTest {
  /**
   * Test {@link MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext, boolean)}
   */
  @Test
  @DisplayName("Test new MqttTransportServerInitializer(MqttTransportContext, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportServerInitializer.<init>(MqttTransportContext, boolean)"})
  void testNewMqttTransportServerInitializer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue(new MqttTransportServerInitializer(new MqttTransportContext(), true).isSharable());
  }

  /**
   * Test {@link MqttTransportServerInitializer#initChannel(SocketChannel)} with {@code
   * SocketChannel}.
   *
   * <p>Method under test: {@link MqttTransportServerInitializer#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportServerInitializer.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel() {
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
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.isProxyEnabled()).thenReturn(true);
    when(context.getMaxPayloadSize()).thenReturn(3);
    when(context.getSslHandlerProvider()).thenReturn(null);
    MqttTransportServerInitializer mqttTransportServerInitializer =
        new MqttTransportServerInitializer(context, true);

    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.addLast(isA(ChannelHandler[].class)))
        .thenReturn(mock(ChannelPipeline.class));
    when(channelPipeline.addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));

    NioSocketChannel ch = mock(NioSocketChannel.class);
    when(ch.closeFuture()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ch.pipeline()).thenReturn(channelPipeline);

    // Act
    mqttTransportServerInitializer.initChannel(ch);

    // Assert
    verify(ch).closeFuture();
    verify(ch).pipeline();
    verify(channelPipeline).addLast(isA(ChannelHandler[].class));
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    verify(context).getMaxPayloadSize();
    verify(context).getSslHandlerProvider();
    verify(context).isProxyEnabled();
  }

  /**
   * Test {@link MqttTransportServerInitializer#initChannel(SocketChannel)} with {@code
   * SocketChannel}.
   *
   * <p>Method under test: {@link MqttTransportServerInitializer#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportServerInitializer.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel2() {
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
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.isProxyEnabled()).thenReturn(true);
    when(context.getMaxPayloadSize()).thenReturn(3);
    MqttTransportServerInitializer mqttTransportServerInitializer =
        new MqttTransportServerInitializer(context, false);

    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.addLast(isA(ChannelHandler[].class)))
        .thenReturn(mock(ChannelPipeline.class));
    when(channelPipeline.addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));

    NioSocketChannel ch = mock(NioSocketChannel.class);
    when(ch.closeFuture()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(ch.pipeline()).thenReturn(channelPipeline);

    // Act
    mqttTransportServerInitializer.initChannel(ch);

    // Assert
    verify(ch).closeFuture();
    verify(ch).pipeline();
    verify(channelPipeline).addLast(isA(ChannelHandler[].class));
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    verify(context).getMaxPayloadSize();
    verify(context).isProxyEnabled();
  }

  /**
   * Test {@link MqttTransportServerInitializer#initChannel(SocketChannel)} with {@code
   * SocketChannel}.
   *
   * <p>Method under test: {@link MqttTransportServerInitializer#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName("Test initChannel(SocketChannel) with 'SocketChannel'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportServerInitializer.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel3() {
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
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.isProxyEnabled()).thenReturn(false);
    when(context.getMaxPayloadSize()).thenReturn(3);
    when(context.getSslHandlerProvider()).thenReturn(null);
    MqttTransportServerInitializer mqttTransportServerInitializer =
        new MqttTransportServerInitializer(context, true);

    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.addLast(isA(ChannelHandler[].class)))
        .thenReturn(mock(ChannelPipeline.class));
    when(channelPipeline.addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));

    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.addListener(
            Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    NioSocketChannel ch = mock(NioSocketChannel.class);
    when(ch.closeFuture()).thenReturn(defaultChannelProgressivePromise);
    when(ch.pipeline()).thenReturn(channelPipeline);

    // Act
    mqttTransportServerInitializer.initChannel(ch);

    // Assert
    verify(ch).closeFuture();
    verify(ch).pipeline();
    verify(channelPipeline).addLast(isA(ChannelHandler[].class));
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(defaultChannelProgressivePromise).addListener(isA(GenericFutureListener.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    verify(context).getMaxPayloadSize();
    verify(context).getSslHandlerProvider();
    verify(context).isProxyEnabled();
  }

  /**
   * Test {@link MqttTransportServerInitializer#initChannel(SocketChannel)} with {@code
   * SocketChannel}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultChannelProgressivePromise#addListener(GenericFutureListener)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttTransportServerInitializer#initChannel(SocketChannel)}
   */
  @Test
  @DisplayName(
      "Test initChannel(SocketChannel) with 'SocketChannel'; then calls addListener(GenericFutureListener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttTransportServerInitializer.initChannel(SocketChannel)"})
  void testInitChannelWithSocketChannel_thenCallsAddListener() {
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
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.isProxyEnabled()).thenReturn(true);
    when(context.getMaxPayloadSize()).thenReturn(3);
    when(context.getSslHandlerProvider()).thenReturn(null);
    MqttTransportServerInitializer mqttTransportServerInitializer =
        new MqttTransportServerInitializer(context, true);

    ChannelPipeline channelPipeline = mock(ChannelPipeline.class);
    when(channelPipeline.addLast(isA(ChannelHandler[].class)))
        .thenReturn(mock(ChannelPipeline.class));
    when(channelPipeline.addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any()))
        .thenReturn(mock(ChannelPipeline.class));

    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.addListener(
            Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    NioSocketChannel ch = mock(NioSocketChannel.class);
    when(ch.closeFuture()).thenReturn(defaultChannelProgressivePromise);
    when(ch.pipeline()).thenReturn(channelPipeline);

    // Act
    mqttTransportServerInitializer.initChannel(ch);

    // Assert
    verify(ch).closeFuture();
    verify(ch).pipeline();
    verify(channelPipeline).addLast(isA(ChannelHandler[].class));
    verify(channelPipeline, atLeast(1))
        .addLast(Mockito.<String>any(), Mockito.<ChannelHandler>any());
    verify(defaultChannelProgressivePromise).addListener(isA(GenericFutureListener.class));
    verify(context).getScheduler();
    verify(context).getTransportService();
    verify(context).getJsonMqttAdaptor();
    verify(context).getMaxPayloadSize();
    verify(context).getSslHandlerProvider();
    verify(context).isProxyEnabled();
  }
}
