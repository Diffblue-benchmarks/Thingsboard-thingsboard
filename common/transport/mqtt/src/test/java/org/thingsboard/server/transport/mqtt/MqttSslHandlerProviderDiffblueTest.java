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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.handler.ssl.PemX509Certificate;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.FingerprintTrustManagerFactory;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.KeyManagerFactoryWrapper;
import io.grpc.netty.shaded.io.netty.handler.ssl.util.LazyX509Certificate;
import io.grpc.util.AdvancedTlsX509KeyManager;
import io.grpc.util.AdvancedTlsX509TrustManager;
import io.grpc.util.AdvancedTlsX509TrustManager.SslSocketAndEnginePeerVerifier;
import io.grpc.util.AdvancedTlsX509TrustManager.Verification;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.util.TrustManagerFactoryWrapper;
import java.io.UnsupportedEncodingException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.PemSslCredentials;
import org.thingsboard.server.common.transport.config.ssl.SslCredentials;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class MqttSslHandlerProviderDiffblueTest {
  @InjectMocks private MqttSslHandlerProvider mqttSslHandlerProvider;

  @Mock private SslCredentialsConfig sslCredentialsConfig;

  /**
   * Test {@link MqttSslHandlerProvider#mqttSslCredentials()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#mqttSslCredentials()}
   */
  @Test
  @DisplayName("Test mqttSslCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslCredentialsConfig MqttSslHandlerProvider.mqttSslCredentials()"})
  void testMqttSslCredentials() {
    // Arrange and Act
    SslCredentialsConfig actualMqttSslCredentialsResult =
        mqttSslHandlerProvider.mqttSslCredentials();

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
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler() {
    // Arrange
    when(sslCredentialsConfig.getCredentials()).thenReturn(new KeystoreSslCredentials());

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler2() {
    // Arrange
    when(sslCredentialsConfig.getCredentials()).thenReturn(new PemSslCredentials());

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler3()
      throws KeyStoreException,
          NoSuchAlgorithmException,
          UnrecoverableKeyException,
          CertificateException {
    // Arrange
    FingerprintTrustManagerFactory fingerprintTrustManagerFactory =
        mock(FingerprintTrustManagerFactory.class);
    AdvancedTlsX509TrustManager advancedTlsX509TrustManager =
        AdvancedTlsX509TrustManager.newBuilder()
            .setSslSocketAndEnginePeerVerifier(mock(SslSocketAndEnginePeerVerifier.class))
            .setVerification(Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION)
            .build();
    when(fingerprintTrustManagerFactory.getTrustManagers())
        .thenReturn(new TrustManager[] {advancedTlsX509TrustManager});

    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.createKeyManagerFactory())
        .thenReturn(
            new io.netty.handler.ssl.util.KeyManagerFactoryWrapper(
                new AdvancedTlsX509KeyManager()));
    when(sslCredentials.createTrustManagerFactory()).thenReturn(fingerprintTrustManagerFactory);
    when(sslCredentialsConfig.getCredentials()).thenReturn(sslCredentials);

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(fingerprintTrustManagerFactory).getTrustManagers();
    verify(sslCredentials).createKeyManagerFactory();
    verify(sslCredentials).createTrustManagerFactory();
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler4()
      throws KeyStoreException,
          NoSuchAlgorithmException,
          UnrecoverableKeyException,
          CertificateException {
    // Arrange
    FingerprintTrustManagerFactory fingerprintTrustManagerFactory =
        mock(FingerprintTrustManagerFactory.class);
    when(fingerprintTrustManagerFactory.getTrustManagers()).thenReturn(new TrustManager[] {});

    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.createKeyManagerFactory())
        .thenReturn(new KeyManagerFactoryWrapper(new AdvancedTlsX509KeyManager()));
    when(sslCredentials.createTrustManagerFactory()).thenReturn(fingerprintTrustManagerFactory);
    when(sslCredentialsConfig.getCredentials()).thenReturn(sslCredentials);

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(fingerprintTrustManagerFactory).getTrustManagers();
    verify(sslCredentials).createKeyManagerFactory();
    verify(sslCredentials).createTrustManagerFactory();
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler5()
      throws KeyStoreException,
          NoSuchAlgorithmException,
          UnrecoverableKeyException,
          CertificateException {
    // Arrange
    SslCredentials sslCredentials = mock(SslCredentials.class);
    when(sslCredentials.createKeyManagerFactory())
        .thenReturn(new KeyManagerFactoryWrapper(new AdvancedTlsX509KeyManager()));
    AdvancedTlsX509TrustManager tm =
        AdvancedTlsX509TrustManager.newBuilder()
            .setSslSocketAndEnginePeerVerifier(mock(SslSocketAndEnginePeerVerifier.class))
            .setVerification(Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION)
            .build();
    when(sslCredentials.createTrustManagerFactory()).thenReturn(new TrustManagerFactoryWrapper(tm));
    when(sslCredentialsConfig.getCredentials()).thenReturn(sslCredentials);

    // Act
    SslHandler actualSslHandler = mqttSslHandlerProvider.getSslHandler();

    // Assert
    verify(sslCredentials).createKeyManagerFactory();
    verify(sslCredentials).createTrustManagerFactory();
    verify(sslCredentialsConfig).getCredentials();
    SSLEngine engineResult = actualSslHandler.engine();
    assertNull(engineResult.getApplicationProtocol());
    assertNull(engineResult.getHandshakeApplicationProtocol());
    assertNull(engineResult.getPeerHost());
    assertNull(engineResult.getHandshakeApplicationProtocolSelector());
    assertNull(engineResult.getHandshakeSession());
    assertEquals(-1, engineResult.getPeerPort());
    assertEquals(0L, actualSslHandler.getCloseNotifyReadTimeoutMillis());
    assertEquals(10000L, actualSslHandler.getHandshakeTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyFlushTimeoutMillis());
    assertEquals(3000L, actualSslHandler.getCloseNotifyTimeoutMillis());
    assertFalse(actualSslHandler.isSingleDecode());
  }

  /**
   * Test {@link MqttSslHandlerProvider#getSslHandler()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttSslHandlerProvider#getSslHandler()}
   */
  @Test
  @DisplayName("Test getSslHandler(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SslHandler MqttSslHandlerProvider.getSslHandler()"})
  void testGetSslHandler_thenThrowRuntimeException() {
    // Arrange
    when(sslCredentialsConfig.getCredentials()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mqttSslHandlerProvider.getSslHandler());
    verify(sslCredentialsConfig).getCredentials();
  }

  /**
   * Test ThingsboardMqttX509TrustManager {@link
   * ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}.
   *
   * <p>Method under test: {@link
   * ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}
   */
  @Test
  @DisplayName("Test ThingsboardMqttX509TrustManager checkClientTrusted(X509Certificate[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardMqttX509TrustManager.checkClientTrusted(X509Certificate[], String)"
  })
  void testThingsboardMqttX509TrustManagerCheckClientTrusted() throws CertificateException {
    // Arrange
    AdvancedTlsX509TrustManager trustManager =
        AdvancedTlsX509TrustManager.newBuilder()
            .setSslSocketAndEnginePeerVerifier(mock(SslSocketAndEnginePeerVerifier.class))
            .setVerification(Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION)
            .build();
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
    DefaultTransportResourceCache transportResourceCache =
        new DefaultTransportResourceCache(mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
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

    ThingsboardMqttX509TrustManager thingsboardMqttX509TrustManager =
        new ThingsboardMqttX509TrustManager(trustManager, transportService);
    LazyX509Certificate lazyX509Certificate =
        new LazyX509Certificate(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    LazyX509Certificate lazyX509Certificate2 =
        new LazyX509Certificate(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertThrows(
        CertificateException.class,
        () ->
            thingsboardMqttX509TrustManager.checkClientTrusted(
                new X509Certificate[] {lazyX509Certificate, lazyX509Certificate2}, "Auth Type"));
  }

  /**
   * Test ThingsboardMqttX509TrustManager {@link
   * ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}
   */
  @Test
  @DisplayName(
      "Test ThingsboardMqttX509TrustManager checkClientTrusted(X509Certificate[], String); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardMqttX509TrustManager.checkClientTrusted(X509Certificate[], String)"
  })
  void testThingsboardMqttX509TrustManagerCheckClientTrusted_givenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, CertificateException {
    // Arrange
    AdvancedTlsX509TrustManager trustManager =
        AdvancedTlsX509TrustManager.newBuilder()
            .setSslSocketAndEnginePeerVerifier(mock(SslSocketAndEnginePeerVerifier.class))
            .setVerification(Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION)
            .build();
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
    DefaultTransportResourceCache transportResourceCache =
        new DefaultTransportResourceCache(mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
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

    ThingsboardMqttX509TrustManager thingsboardMqttX509TrustManager =
        new ThingsboardMqttX509TrustManager(trustManager, transportService);

    PemX509Certificate pemX509Certificate = mock(PemX509Certificate.class);
    when(pemX509Certificate.getEncoded()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    thingsboardMqttX509TrustManager.checkClientTrusted(
        new X509Certificate[] {pemX509Certificate}, "Auth Type");

    // Assert
    verify(pemX509Certificate, atLeast(1)).getEncoded();
  }

  /**
   * Test ThingsboardMqttX509TrustManager {@link
   * ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ThingsboardMqttX509TrustManager#checkClientTrusted(X509Certificate[], String)}
   */
  @Test
  @DisplayName(
      "Test ThingsboardMqttX509TrustManager checkClientTrusted(X509Certificate[], String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardMqttX509TrustManager.checkClientTrusted(X509Certificate[], String)"
  })
  void testThingsboardMqttX509TrustManagerCheckClientTrusted_thenThrowRuntimeException()
      throws CertificateException {
    // Arrange
    AdvancedTlsX509TrustManager trustManager =
        AdvancedTlsX509TrustManager.newBuilder()
            .setSslSocketAndEnginePeerVerifier(mock(SslSocketAndEnginePeerVerifier.class))
            .setVerification(Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION)
            .build();
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
    DefaultTransportResourceCache transportResourceCache =
        new DefaultTransportResourceCache(mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
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

    ThingsboardMqttX509TrustManager thingsboardMqttX509TrustManager =
        new ThingsboardMqttX509TrustManager(trustManager, transportService);

    PemX509Certificate pemX509Certificate = mock(PemX509Certificate.class);
    when(pemX509Certificate.getEncoded()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            thingsboardMqttX509TrustManager.checkClientTrusted(
                new X509Certificate[] {pemX509Certificate}, "Auth Type"));
    verify(pemX509Certificate).getEncoded();
  }

  /**
   * Test ThingsboardMqttX509TrustManager {@link
   * ThingsboardMqttX509TrustManager#getAcceptedIssuers()}.
   *
   * <p>Method under test: {@link ThingsboardMqttX509TrustManager#getAcceptedIssuers()}
   */
  @Test
  @DisplayName("Test ThingsboardMqttX509TrustManager getAcceptedIssuers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"X509Certificate[] ThingsboardMqttX509TrustManager.getAcceptedIssuers()"})
  void testThingsboardMqttX509TrustManagerGetAcceptedIssuers() throws CertificateException {
    // Arrange
    AdvancedTlsX509TrustManager trustManager =
        AdvancedTlsX509TrustManager.newBuilder()
            .setSslSocketAndEnginePeerVerifier(mock(SslSocketAndEnginePeerVerifier.class))
            .setVerification(Verification.CERTIFICATE_AND_HOST_NAME_VERIFICATION)
            .build();
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
    DefaultTransportResourceCache transportResourceCache =
        new DefaultTransportResourceCache(mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
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

    ThingsboardMqttX509TrustManager thingsboardMqttX509TrustManager =
        new ThingsboardMqttX509TrustManager(trustManager, transportService);

    // Act and Assert
    assertEquals(0, thingsboardMqttX509TrustManager.getAcceptedIssuers().length);
  }
}
