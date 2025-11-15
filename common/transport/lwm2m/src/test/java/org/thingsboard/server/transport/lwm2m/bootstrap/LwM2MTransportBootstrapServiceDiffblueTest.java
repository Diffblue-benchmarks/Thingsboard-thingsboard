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
package org.thingsboard.server.transport.lwm2m.bootstrap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.elements.Connector;
import org.eclipse.californium.elements.UDPConnector;
import org.eclipse.leshan.core.endpoint.Protocol;
import org.eclipse.leshan.server.bootstrap.LeshanBootstrapServer;
import org.eclipse.leshan.server.bootstrap.endpoint.LwM2mBootstrapServerEndpoint;
import org.eclipse.leshan.server.bootstrap.endpoint.LwM2mBootstrapServerEndpointsProvider;
import org.eclipse.leshan.server.californium.bootstrap.endpoint.CaliforniumBootstrapServerEndpoint;
import org.eclipse.leshan.server.security.BootstrapSecurityStore;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.config.ssl.KeystoreSslCredentials;
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
import org.thingsboard.server.transport.lwm2m.bootstrap.secure.TbLwM2MDtlsBootstrapCertificateVerifier;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapSecurityStore;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MInMemoryBootstrapConfigStore;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportBootstrapConfig;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;

class LwM2MTransportBootstrapServiceDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2MTransportBootstrapService#getLhBootstrapServer()}
   */
  @Test
  void testGetLhBootstrapServer() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.getHostAddress()).thenReturn("foo");
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);
      LwM2MTransportBootstrapConfig bootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
      when(bootstrapConfig.getSecureHost()).thenReturn("localhost");
      when(bootstrapConfig.getHost()).thenReturn("localhost");
      when(bootstrapConfig.getSslCredentials()).thenReturn(new KeystoreSslCredentials());
      when(bootstrapConfig.getPort()).thenReturn(8080);
      when(bootstrapConfig.getSecurePort()).thenReturn(8080);
      LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
          context, new LwM2MTransportServerConfig());

      LwM2mTransportContext context2 = new LwM2mTransportContext();
      LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
          lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

      LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
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
      DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
          producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
          deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
          notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

      LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore2 = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context3 = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator2 = new LwM2mCredentialsSecurityInfoValidator(
          context3, new LwM2MTransportServerConfig());

      LwM2mTransportContext context4 = new LwM2mTransportContext();

      // Act
      LeshanBootstrapServer actualLhBootstrapServer = (new LwM2MTransportBootstrapService(serverConfig, bootstrapConfig,
          lwM2MBootstrapSecurityStore, lwM2MInMemoryBootstrapConfigStore, transportService,
          new TbLwM2MDtlsBootstrapCertificateVerifier(config,
              new LwM2MBootstrapSecurityStore(bootstrapConfigStore2, lwM2MCredentialsSecurityInfoValidator2, context4,
                  new LwM2mTransportServerHelper(new LwM2mTransportContext())))))
          .getLhBootstrapServer();

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).getHostAddress();
      verify(bootstrapConfig).getHost();
      verify(bootstrapConfig, atLeast(1)).getPort();
      verify(bootstrapConfig).getSecureHost();
      verify(bootstrapConfig, atLeast(1)).getSecurePort();
      verify(bootstrapConfig, atLeast(1)).getSslCredentials();
      Collection<LwM2mBootstrapServerEndpointsProvider> endpointsProvider = actualLhBootstrapServer
          .getEndpointsProvider();
      assertEquals(1, endpointsProvider.size());
      assertTrue(endpointsProvider instanceof Set);
      List<LwM2mBootstrapServerEndpoint> endpoints = actualLhBootstrapServer.getEndpoints();
      assertEquals(1, endpoints.size());
      LwM2mBootstrapServerEndpoint getResult = endpoints.get(0);
      CoapEndpoint coapEndpoint = ((CaliforniumBootstrapServerEndpoint) getResult).getCoapEndpoint();
      Connector connector = coapEndpoint.getConnector();
      assertTrue(connector instanceof UDPConnector);
      assertTrue(getResult instanceof CaliforniumBootstrapServerEndpoint);
      BootstrapSecurityStore securityStore = actualLhBootstrapServer.getSecurityStore();
      assertTrue(securityStore instanceof LwM2MBootstrapSecurityStore);
      Protocol protocol = getResult.getProtocol();
      assertEquals("COAP", protocol.getName());
      assertEquals("CoAP over UDP endpoint based on Californium library", getResult.getDescription());
      assertEquals("UDP", connector.getProtocol());
      assertEquals("[Bootstrap Server-coap://foo:8080] ", coapEndpoint.getTag());
      assertEquals("coap", protocol.getUriScheme());
      assertEquals("coap://foo:8080", coapEndpoint.getUri().toString());
      assertEquals("coap://foo:8080", getResult.getURI().toString());
      assertNull(((UDPConnector) connector).getReceiveBufferSize());
      assertNull(((UDPConnector) connector).getSendBufferSize());
      InetSocketAddress address = coapEndpoint.getAddress();
      assertNull(address.getHostName());
      assertEquals(2, ((UDPConnector) connector).getReceiverThreadCount());
      assertEquals(2, ((UDPConnector) connector).getSenderThreadCount());
      assertEquals(2048, ((UDPConnector) connector).getReceiverPacketSize());
      assertEquals(8080, address.getPort());
      assertFalse(address.isUnresolved());
      assertFalse(coapEndpoint.isStarted());
      assertFalse(connector.isRunning());
      assertFalse(((UDPConnector) connector).getReuseAddress());
      assertTrue(coapEndpoint.getInterceptors().isEmpty());
      assertTrue(coapEndpoint.getPostProcessInterceptors().isEmpty());
      assertSame(lwM2MBootstrapSecurityStore, securityStore);
      assertSame(address, connector.getAddress());
    }
  }

  /**
   * Method under test:
   * {@link LwM2MTransportBootstrapService#getLhBootstrapServer()}
   */
  @Test
  void testGetLhBootstrapServer2() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.getHostAddress()).thenReturn("42");
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);
      LwM2MTransportBootstrapConfig bootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
      when(bootstrapConfig.getSecureHost()).thenReturn("localhost");
      when(bootstrapConfig.getHost()).thenReturn("localhost");
      when(bootstrapConfig.getSslCredentials()).thenReturn(new KeystoreSslCredentials());
      when(bootstrapConfig.getPort()).thenReturn(8080);
      when(bootstrapConfig.getSecurePort()).thenReturn(8080);
      LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
          context, new LwM2MTransportServerConfig());

      LwM2mTransportContext context2 = new LwM2mTransportContext();
      LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
          lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

      LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
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
      DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
          producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
          deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
          notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

      LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore2 = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context3 = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator2 = new LwM2mCredentialsSecurityInfoValidator(
          context3, new LwM2MTransportServerConfig());

      LwM2mTransportContext context4 = new LwM2mTransportContext();

      // Act
      LeshanBootstrapServer actualLhBootstrapServer = (new LwM2MTransportBootstrapService(serverConfig, bootstrapConfig,
          lwM2MBootstrapSecurityStore, lwM2MInMemoryBootstrapConfigStore, transportService,
          new TbLwM2MDtlsBootstrapCertificateVerifier(config,
              new LwM2MBootstrapSecurityStore(bootstrapConfigStore2, lwM2MCredentialsSecurityInfoValidator2, context4,
                  new LwM2mTransportServerHelper(new LwM2mTransportContext())))))
          .getLhBootstrapServer();

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).getHostAddress();
      verify(bootstrapConfig).getHost();
      verify(bootstrapConfig, atLeast(1)).getPort();
      verify(bootstrapConfig).getSecureHost();
      verify(bootstrapConfig, atLeast(1)).getSecurePort();
      verify(bootstrapConfig, atLeast(1)).getSslCredentials();
      Collection<LwM2mBootstrapServerEndpointsProvider> endpointsProvider = actualLhBootstrapServer
          .getEndpointsProvider();
      assertEquals(1, endpointsProvider.size());
      assertTrue(endpointsProvider instanceof Set);
      List<LwM2mBootstrapServerEndpoint> endpoints = actualLhBootstrapServer.getEndpoints();
      assertEquals(1, endpoints.size());
      LwM2mBootstrapServerEndpoint getResult = endpoints.get(0);
      CoapEndpoint coapEndpoint = ((CaliforniumBootstrapServerEndpoint) getResult).getCoapEndpoint();
      Connector connector = coapEndpoint.getConnector();
      assertTrue(connector instanceof UDPConnector);
      assertTrue(getResult instanceof CaliforniumBootstrapServerEndpoint);
      BootstrapSecurityStore securityStore = actualLhBootstrapServer.getSecurityStore();
      assertTrue(securityStore instanceof LwM2MBootstrapSecurityStore);
      Protocol protocol = getResult.getProtocol();
      assertEquals("COAP", protocol.getName());
      assertEquals("CoAP over UDP endpoint based on Californium library", getResult.getDescription());
      assertEquals("UDP", connector.getProtocol());
      assertEquals("[Bootstrap Server-coap://42:8080] ", coapEndpoint.getTag());
      assertEquals("coap", protocol.getUriScheme());
      assertEquals("coap://42:8080", coapEndpoint.getUri().toString());
      assertEquals("coap://42:8080", getResult.getURI().toString());
      assertNull(((UDPConnector) connector).getReceiveBufferSize());
      assertNull(((UDPConnector) connector).getSendBufferSize());
      InetSocketAddress address = coapEndpoint.getAddress();
      assertNull(address.getHostName());
      assertEquals(2, ((UDPConnector) connector).getReceiverThreadCount());
      assertEquals(2, ((UDPConnector) connector).getSenderThreadCount());
      assertEquals(2048, ((UDPConnector) connector).getReceiverPacketSize());
      assertEquals(8080, address.getPort());
      assertFalse(address.isUnresolved());
      assertFalse(coapEndpoint.isStarted());
      assertFalse(connector.isRunning());
      assertFalse(((UDPConnector) connector).getReuseAddress());
      assertTrue(coapEndpoint.getInterceptors().isEmpty());
      assertTrue(coapEndpoint.getPostProcessInterceptors().isEmpty());
      assertSame(lwM2MBootstrapSecurityStore, securityStore);
      assertSame(address, connector.getAddress());
    }
  }

  /**
   * Method under test:
   * {@link LwM2MTransportBootstrapService#getLhBootstrapServer()}
   */
  @Test
  void testGetLhBootstrapServer3() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.getHostAddress()).thenReturn("foo");
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);
      LwM2MTransportBootstrapConfig bootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
      when(bootstrapConfig.getSecureHost()).thenReturn("localhost");
      when(bootstrapConfig.getHost()).thenReturn("localhost");
      when(bootstrapConfig.getSslCredentials()).thenReturn(null);
      when(bootstrapConfig.getPort()).thenReturn(8080);
      when(bootstrapConfig.getSecurePort()).thenReturn(8080);
      LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
          context, new LwM2MTransportServerConfig());

      LwM2mTransportContext context2 = new LwM2mTransportContext();
      LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
          lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

      LwM2MInMemoryBootstrapConfigStore lwM2MInMemoryBootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
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
      DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
          producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
          deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
          notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

      LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore2 = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context3 = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator2 = new LwM2mCredentialsSecurityInfoValidator(
          context3, new LwM2MTransportServerConfig());

      LwM2mTransportContext context4 = new LwM2mTransportContext();

      // Act
      LeshanBootstrapServer actualLhBootstrapServer = (new LwM2MTransportBootstrapService(serverConfig, bootstrapConfig,
          lwM2MBootstrapSecurityStore, lwM2MInMemoryBootstrapConfigStore, transportService,
          new TbLwM2MDtlsBootstrapCertificateVerifier(config,
              new LwM2MBootstrapSecurityStore(bootstrapConfigStore2, lwM2MCredentialsSecurityInfoValidator2, context4,
                  new LwM2mTransportServerHelper(new LwM2mTransportContext())))))
          .getLhBootstrapServer();

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).getHostAddress();
      verify(bootstrapConfig).getHost();
      verify(bootstrapConfig, atLeast(1)).getPort();
      verify(bootstrapConfig).getSecureHost();
      verify(bootstrapConfig, atLeast(1)).getSecurePort();
      verify(bootstrapConfig, atLeast(1)).getSslCredentials();
      Collection<LwM2mBootstrapServerEndpointsProvider> endpointsProvider = actualLhBootstrapServer
          .getEndpointsProvider();
      assertEquals(1, endpointsProvider.size());
      assertTrue(endpointsProvider instanceof Set);
      List<LwM2mBootstrapServerEndpoint> endpoints = actualLhBootstrapServer.getEndpoints();
      assertEquals(1, endpoints.size());
      LwM2mBootstrapServerEndpoint getResult = endpoints.get(0);
      CoapEndpoint coapEndpoint = ((CaliforniumBootstrapServerEndpoint) getResult).getCoapEndpoint();
      Connector connector = coapEndpoint.getConnector();
      assertTrue(connector instanceof UDPConnector);
      assertTrue(getResult instanceof CaliforniumBootstrapServerEndpoint);
      BootstrapSecurityStore securityStore = actualLhBootstrapServer.getSecurityStore();
      assertTrue(securityStore instanceof LwM2MBootstrapSecurityStore);
      Protocol protocol = getResult.getProtocol();
      assertEquals("COAP", protocol.getName());
      assertEquals("CoAP over UDP endpoint based on Californium library", getResult.getDescription());
      assertEquals("UDP", connector.getProtocol());
      assertEquals("[Bootstrap Server-coap://foo:8080] ", coapEndpoint.getTag());
      assertEquals("coap", protocol.getUriScheme());
      assertEquals("coap://foo:8080", coapEndpoint.getUri().toString());
      assertEquals("coap://foo:8080", getResult.getURI().toString());
      assertNull(((UDPConnector) connector).getReceiveBufferSize());
      assertNull(((UDPConnector) connector).getSendBufferSize());
      InetSocketAddress address = coapEndpoint.getAddress();
      assertNull(address.getHostName());
      assertEquals(2, ((UDPConnector) connector).getReceiverThreadCount());
      assertEquals(2, ((UDPConnector) connector).getSenderThreadCount());
      assertEquals(2048, ((UDPConnector) connector).getReceiverPacketSize());
      assertEquals(8080, address.getPort());
      assertFalse(address.isUnresolved());
      assertFalse(coapEndpoint.isStarted());
      assertFalse(connector.isRunning());
      assertFalse(((UDPConnector) connector).getReuseAddress());
      assertTrue(coapEndpoint.getInterceptors().isEmpty());
      assertTrue(coapEndpoint.getPostProcessInterceptors().isEmpty());
      assertSame(lwM2MBootstrapSecurityStore, securityStore);
      assertSame(address, connector.getAddress());
    }
  }

  /**
   * Method under test:
   * {@link LwM2MTransportBootstrapService#getLhBootstrapServer()}
   */
  @Test
  void testGetLhBootstrapServer4() throws UnknownHostException {
    try (MockedStatic<InetAddress> mockInetAddress = mockStatic(InetAddress.class)) {
      //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

      // Arrange
      InetAddress inetAddress = mock(InetAddress.class);
      when(inetAddress.getHostAddress()).thenReturn("foo");
      mockInetAddress.when(() -> InetAddress.getByName(Mockito.<String>any())).thenReturn(inetAddress);
      LwM2MTransportBootstrapConfig bootstrapConfig = mock(LwM2MTransportBootstrapConfig.class);
      when(bootstrapConfig.getSecureHost()).thenReturn("localhost");
      when(bootstrapConfig.getHost()).thenReturn("localhost");
      when(bootstrapConfig.getSslCredentials()).thenReturn(new KeystoreSslCredentials());
      when(bootstrapConfig.getPort()).thenReturn(8080);
      when(bootstrapConfig.getSecurePort()).thenReturn(8080);
      LwM2MTransportServerConfig serverConfig = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator = new LwM2mCredentialsSecurityInfoValidator(
          context, new LwM2MTransportServerConfig());

      LwM2mTransportContext context2 = new LwM2mTransportContext();
      LwM2MBootstrapSecurityStore lwM2MBootstrapSecurityStore = new LwM2MBootstrapSecurityStore(bootstrapConfigStore,
          lwM2MCredentialsSecurityInfoValidator, context2, new LwM2mTransportServerHelper(new LwM2mTransportContext()));

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
      DefaultTransportService transportService = new DefaultTransportService(partitionService, queueProvider,
          producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
          deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
          notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

      LwM2MTransportServerConfig config = new LwM2MTransportServerConfig();
      LwM2MInMemoryBootstrapConfigStore bootstrapConfigStore2 = new LwM2MInMemoryBootstrapConfigStore();
      LwM2mTransportContext context3 = new LwM2mTransportContext();
      LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator2 = new LwM2mCredentialsSecurityInfoValidator(
          context3, new LwM2MTransportServerConfig());

      LwM2mTransportContext context4 = new LwM2mTransportContext();

      // Act
      LeshanBootstrapServer actualLhBootstrapServer = (new LwM2MTransportBootstrapService(serverConfig, bootstrapConfig,
          lwM2MBootstrapSecurityStore, null, transportService,
          new TbLwM2MDtlsBootstrapCertificateVerifier(config,
              new LwM2MBootstrapSecurityStore(bootstrapConfigStore2, lwM2MCredentialsSecurityInfoValidator2, context4,
                  new LwM2mTransportServerHelper(new LwM2mTransportContext())))))
          .getLhBootstrapServer();

      // Assert
      mockInetAddress.verify(() -> InetAddress.getByName(Mockito.<String>any()), atLeast(1));
      verify(inetAddress, atLeast(1)).getHostAddress();
      verify(bootstrapConfig).getHost();
      verify(bootstrapConfig, atLeast(1)).getPort();
      verify(bootstrapConfig).getSecureHost();
      verify(bootstrapConfig, atLeast(1)).getSecurePort();
      verify(bootstrapConfig, atLeast(1)).getSslCredentials();
      Collection<LwM2mBootstrapServerEndpointsProvider> endpointsProvider = actualLhBootstrapServer
          .getEndpointsProvider();
      assertEquals(1, endpointsProvider.size());
      assertTrue(endpointsProvider instanceof Set);
      List<LwM2mBootstrapServerEndpoint> endpoints = actualLhBootstrapServer.getEndpoints();
      assertEquals(1, endpoints.size());
      LwM2mBootstrapServerEndpoint getResult = endpoints.get(0);
      CoapEndpoint coapEndpoint = ((CaliforniumBootstrapServerEndpoint) getResult).getCoapEndpoint();
      Connector connector = coapEndpoint.getConnector();
      assertTrue(connector instanceof UDPConnector);
      assertTrue(getResult instanceof CaliforniumBootstrapServerEndpoint);
      BootstrapSecurityStore securityStore = actualLhBootstrapServer.getSecurityStore();
      assertTrue(securityStore instanceof LwM2MBootstrapSecurityStore);
      Protocol protocol = getResult.getProtocol();
      assertEquals("COAP", protocol.getName());
      assertEquals("CoAP over UDP endpoint based on Californium library", getResult.getDescription());
      assertEquals("UDP", connector.getProtocol());
      assertEquals("[Bootstrap Server-coap://foo:8080] ", coapEndpoint.getTag());
      assertEquals("coap", protocol.getUriScheme());
      assertEquals("coap://foo:8080", coapEndpoint.getUri().toString());
      assertEquals("coap://foo:8080", getResult.getURI().toString());
      assertNull(((UDPConnector) connector).getReceiveBufferSize());
      assertNull(((UDPConnector) connector).getSendBufferSize());
      InetSocketAddress address = coapEndpoint.getAddress();
      assertNull(address.getHostName());
      assertEquals(2, ((UDPConnector) connector).getReceiverThreadCount());
      assertEquals(2, ((UDPConnector) connector).getSenderThreadCount());
      assertEquals(2048, ((UDPConnector) connector).getReceiverPacketSize());
      assertEquals(8080, address.getPort());
      assertFalse(address.isUnresolved());
      assertFalse(coapEndpoint.isStarted());
      assertFalse(connector.isRunning());
      assertFalse(((UDPConnector) connector).getReuseAddress());
      assertTrue(coapEndpoint.getInterceptors().isEmpty());
      assertTrue(coapEndpoint.getPostProcessInterceptors().isEmpty());
      assertSame(lwM2MBootstrapSecurityStore, securityStore);
      assertSame(address, connector.getAddress());
    }
  }
}
