package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.rabbitmq.client.TrustEverythingTrustManager;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.LazyX509Certificate;
import java.io.UnsupportedEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.config.ssl.SslCredentialsConfig;
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
import org.thingsboard.server.transport.mqtt.MqttSslHandlerProvider.ThingsboardMqttX509TrustManager;

class MqttSslHandlerProviderDiffblueTest {
  /**
   * Test {@link MqttSslHandlerProvider#mqttSslCredentials()}.
   * <p>
   * Method under test: {@link MqttSslHandlerProvider#mqttSslCredentials()}
   */
  @Test
  @DisplayName("Test mqttSslCredentials()")
  void testMqttSslCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SslCredentialsConfig actualMqttSslCredentialsResult = (new MqttSslHandlerProvider()).mqttSslCredentials();

    // Assert
    assertEquals("MQTT SSL Credentials", actualMqttSslCredentialsResult.getName());
    assertNull(actualMqttSslCredentialsResult.getKeystore());
    assertNull(actualMqttSslCredentialsResult.getPem());
    assertNull(actualMqttSslCredentialsResult.getCredentials());
    assertNull(actualMqttSslCredentialsResult.getType());
    assertFalse(actualMqttSslCredentialsResult.isTrustsOnly());
    assertTrue(actualMqttSslCredentialsResult.isEnabled());
  }

  /**
   * Test ThingsboardMqttX509TrustManager
   * {@link ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}.
   * <p>
   * Method under test:
   * {@link MqttSslHandlerProvider.ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}
   */
  @Test
  @DisplayName("Test ThingsboardMqttX509TrustManager checkClientTrusted(X509Certificate[], String)")
  void testThingsboardMqttX509TrustManagerCheckClientTrusted()
      throws UnsupportedEncodingException, CertificateException {
    // Arrange
    TrustEverythingTrustManager trustManager = new TrustEverythingTrustManager();
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
    MqttSslHandlerProvider.ThingsboardMqttX509TrustManager thingsboardMqttX509TrustManager = new MqttSslHandlerProvider.ThingsboardMqttX509TrustManager(
        trustManager,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));
    LazyX509Certificate lazyX509Certificate = new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(CertificateException.class,
        () -> thingsboardMqttX509TrustManager.checkClientTrusted(
            new X509Certificate[]{lazyX509Certificate, new LazyX509Certificate("AXAXAXAX".getBytes("UTF-8"))},
            "Auth Type"));
  }

  /**
   * Test ThingsboardMqttX509TrustManager
   * {@link ThingsboardMqttX509TrustManager#getAcceptedIssuers()}.
   * <p>
   * Method under test:
   * {@link MqttSslHandlerProvider.ThingsboardMqttX509TrustManager#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test ThingsboardMqttX509TrustManager getAcceptedIssuers()")
  void testThingsboardMqttX509TrustManagerGetAcceptedIssuers() {
    // Arrange
    TrustEverythingTrustManager trustManager = new TrustEverythingTrustManager();
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

    // Act and Assert
    assertEquals(0,
        (new MqttSslHandlerProvider.ThingsboardMqttX509TrustManager(trustManager,
            new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
                topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache,
                rateLimitService, scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
                new DefaultEntityLimitsCache(1, 3))))
            .getAcceptedIssuers().length);
  }

  /**
   * Test ThingsboardMqttX509TrustManager
   * {@link ThingsboardMqttX509TrustManager#getAcceptedIssuers()}.
   * <p>
   * Method under test:
   * {@link MqttSslHandlerProvider.ThingsboardMqttX509TrustManager#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test ThingsboardMqttX509TrustManager getAcceptedIssuers()")
  void testThingsboardMqttX509TrustManagerGetAcceptedIssuers2() {
    // Arrange
    TrustEverythingTrustManager trustManager = new TrustEverythingTrustManager();
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
    MqttSslHandlerProvider.ThingsboardMqttX509TrustManager trustManager2 = new MqttSslHandlerProvider.ThingsboardMqttX509TrustManager(
        trustManager,
        new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
            topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache, rateLimitService,
            scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3)));

    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider6, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider2 = new InMemoryTbTransportQueueFactory(transportApiSettings3,
        transportNotificationSettings3, serviceInfoProvider7, coreSettings3, storage2, new TopicService());

    TopicService topicService3 = new TopicService();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService3, coreSettings4, ruleEngineSettings2, vcSettings2, serviceInfoProvider8, transportApiSettings4,
        transportNotificationSettings4, edgeSettings2, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider9, tenantRoutingInfoService4, applicationEventPublisher4,
            queueRoutingInfoService4, new TopicService()));
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(
        mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);

    // Act and Assert
    assertEquals(0,
        (new MqttSslHandlerProvider.ThingsboardMqttX509TrustManager(trustManager2,
            new DefaultTransportService(partitionService2, queueProvider2, producerProvider2,
                ruleEngineProducerService2, topicService4, serviceInfoProvider10, statsFactory2, deviceProfileCache2,
                tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2, transportResourceCache2,
                notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3))))
            .getAcceptedIssuers().length);
  }

  /**
   * Test ThingsboardMqttX509TrustManager
   * {@link ThingsboardMqttX509TrustManager#ThingsboardMqttX509TrustManager(X509TrustManager, TransportService)}.
   * <p>
   * Method under test:
   * {@link MqttSslHandlerProvider.ThingsboardMqttX509TrustManager#ThingsboardMqttX509TrustManager(X509TrustManager, TransportService)}
   */
  @Test
  @DisplayName("Test ThingsboardMqttX509TrustManager new ThingsboardMqttX509TrustManager(X509TrustManager, TransportService)")
  void testThingsboardMqttX509TrustManagerNewThingsboardMqttX509TrustManager() {
    // Arrange
    TrustEverythingTrustManager trustManager = new TrustEverythingTrustManager();
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

    // Act and Assert
    assertEquals(0,
        (new MqttSslHandlerProvider.ThingsboardMqttX509TrustManager(trustManager,
            new DefaultTransportService(partitionService, queueProvider, producerProvider, ruleEngineProducerService,
                topicService2, serviceInfoProvider5, statsFactory, deviceProfileCache, tenantProfileCache,
                rateLimitService, scheduler, eventPublisher, transportResourceCache, notificationRuleProcessor,
                new DefaultEntityLimitsCache(1, 3))))
            .getAcceptedIssuers().length);
  }
}
