package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.handler.ssl.SslHandler;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.common.util.ThingsBoardForkJoinWorkerThreadFactory;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
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
import org.thingsboard.server.transport.mqtt.adaptors.ProtoMqttAdaptor;
import org.thingsboard.server.transport.mqtt.gateway.GatewayMetricsService;

class MqttTransportContextDiffblueTest {
  /**
   * Test {@link MqttTransportContext#init()}.
   * <ul>
   *   <li>Then {@link MqttTransportContext} (default constructor) Executor
   * {@link ForkJoinPool}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportContext#init()}
   */
  @Test
  @DisplayName("Test init(); then MqttTransportContext (default constructor) Executor ForkJoinPool")
  void testInit_thenMqttTransportContextExecutorForkJoinPool() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
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
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(50, 3));

    MqttTransportContext mqttTransportContext = new MqttTransportContext();
    mqttTransportContext.setTransportService(transportService);

    // Act
    mqttTransportContext.init();

    // Assert
    verify(statsFactory).createGauge(eq("TRANSPORT.openConnections"), isA(AtomicInteger.class), isA(String[].class));
    ExecutorService executor = mqttTransportContext.getExecutor();
    assertTrue(executor instanceof ForkJoinPool);
    assertTrue(((ForkJoinPool) executor).getFactory() instanceof ThingsBoardForkJoinWorkerThreadFactory);
    assertNull(((ForkJoinPool) executor).getUncaughtExceptionHandler());
    assertEquals(0, ((ForkJoinPool) executor).getActiveThreadCount());
    assertEquals(0, ((ForkJoinPool) executor).getPoolSize());
    assertEquals(0, ((ForkJoinPool) executor).getQueuedSubmissionCount());
    assertEquals(0, ((ForkJoinPool) executor).getRunningThreadCount());
    assertEquals(0L, ((ForkJoinPool) executor).getQueuedTaskCount());
    assertEquals(0L, ((ForkJoinPool) executor).getStealCount());
    assertEquals(50, ((ForkJoinPool) executor).getParallelism());
    assertFalse(((ForkJoinPool) executor).hasQueuedSubmissions());
    assertFalse(((ForkJoinPool) executor).isTerminating());
    assertTrue(((ForkJoinPool) executor).getAsyncMode());
    assertTrue(((ForkJoinPool) executor).isQuiescent());
  }

  /**
   * Test {@link MqttTransportContext#checkAddress(InetSocketAddress)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportContext#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress); then return 'false'")
  void testCheckAddress_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService rateLimitService = mock(DefaultTransportRateLimitService.class);
    when(rateLimitService.checkAddress(Mockito.<InetSocketAddress>any())).thenReturn(false);

    MqttTransportContext mqttTransportContext = new MqttTransportContext();
    mqttTransportContext.setRateLimitService(rateLimitService);

    // Act
    boolean actualCheckAddressResult = mqttTransportContext.checkAddress(InetSocketAddress.createUnresolved("foo", 1));

    // Assert
    verify(rateLimitService).checkAddress(isA(InetSocketAddress.class));
    assertFalse(actualCheckAddressResult);
  }

  /**
   * Test {@link MqttTransportContext#checkAddress(InetSocketAddress)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportContext#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress); then return 'true'")
  void testCheckAddress_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MqttTransportContext mqttTransportContext = new MqttTransportContext();
    mqttTransportContext
        .setRateLimitService(new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache()));

    // Act and Assert
    assertTrue(mqttTransportContext.checkAddress(InetSocketAddress.createUnresolved("foo", 1)));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTransportContext#getDisconnectTimeout()}
   *   <li>{@link MqttTransportContext#getGatewayMetricsService()}
   *   <li>{@link MqttTransportContext#getJsonMqttAdaptor()}
   *   <li>{@link MqttTransportContext#getMaxPayloadSize()}
   *   <li>{@link MqttTransportContext#getMessageQueueSizePerDeviceLimit()}
   *   <li>{@link MqttTransportContext#getProtoMqttAdaptor()}
   *   <li>{@link MqttTransportContext#getSslHandler()}
   *   <li>{@link MqttTransportContext#getSslHandlerProvider()}
   *   <li>{@link MqttTransportContext#getTenantProfileCache()}
   *   <li>{@link MqttTransportContext#getTimeout()}
   *   <li>{@link MqttTransportContext#isProxyEnabled()}
   *   <li>{@link MqttTransportContext#isSkipValidityCheckForClientCert()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MqttTransportContext mqttTransportContext = new MqttTransportContext();

    // Act
    long actualDisconnectTimeout = mqttTransportContext.getDisconnectTimeout();
    GatewayMetricsService actualGatewayMetricsService = mqttTransportContext.getGatewayMetricsService();
    JsonMqttAdaptor actualJsonMqttAdaptor = mqttTransportContext.getJsonMqttAdaptor();
    Integer actualMaxPayloadSize = mqttTransportContext.getMaxPayloadSize();
    int actualMessageQueueSizePerDeviceLimit = mqttTransportContext.getMessageQueueSizePerDeviceLimit();
    ProtoMqttAdaptor actualProtoMqttAdaptor = mqttTransportContext.getProtoMqttAdaptor();
    SslHandler actualSslHandler = mqttTransportContext.getSslHandler();
    MqttSslHandlerProvider actualSslHandlerProvider = mqttTransportContext.getSslHandlerProvider();
    TransportTenantProfileCache actualTenantProfileCache = mqttTransportContext.getTenantProfileCache();
    long actualTimeout = mqttTransportContext.getTimeout();
    boolean actualIsProxyEnabledResult = mqttTransportContext.isProxyEnabled();

    // Assert
    assertNull(actualSslHandler);
    assertNull(actualMaxPayloadSize);
    assertNull(actualTenantProfileCache);
    assertNull(actualSslHandlerProvider);
    assertNull(actualJsonMqttAdaptor);
    assertNull(actualProtoMqttAdaptor);
    assertNull(actualGatewayMetricsService);
    assertEquals(0, actualMessageQueueSizePerDeviceLimit);
    assertEquals(0L, actualDisconnectTimeout);
    assertEquals(0L, actualTimeout);
    assertFalse(actualIsProxyEnabledResult);
    assertFalse(mqttTransportContext.isSkipValidityCheckForClientCert());
  }
}
