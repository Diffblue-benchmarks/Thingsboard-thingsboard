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
package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.transport.snmp.AuthenticationProtocol;
import org.thingsboard.server.common.data.transport.snmp.SnmpProtocolVersion;
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
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

class SnmpAuthServiceDiffblueTest {
  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getCommunity()).thenThrow(new UnsupportedOperationException());
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getCommunity();
    verify(deviceTransportConfig).getProtocolVersion();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget2() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getUsername()).thenThrow(new UnsupportedOperationException());
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget3() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getSecurityName()).thenThrow(new UnsupportedOperationException());
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget4() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getEngineId()).thenThrow(new UnsupportedOperationException());
    when(deviceTransportConfig.getSecurityName()).thenReturn("Security Name");
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getEngineId();
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget5() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getAuthenticationPassphrase())
        .thenThrow(new UnsupportedOperationException());
    when(deviceTransportConfig.getEngineId()).thenReturn("42");
    when(deviceTransportConfig.getAuthenticationProtocol())
        .thenReturn(AuthenticationProtocol.SHA_1);
    when(deviceTransportConfig.getSecurityName()).thenReturn("Security Name");
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getAuthenticationPassphrase();
    verify(deviceTransportConfig).getAuthenticationProtocol();
    verify(deviceTransportConfig).getEngineId();
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code SHA_1}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration); given 'SHA_1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget_givenSha1() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getAuthenticationPassphrase())
        .thenReturn("Authentication Passphrase");
    when(deviceTransportConfig.getEngineId()).thenReturn("42");
    when(deviceTransportConfig.getAuthenticationProtocol())
        .thenReturn(AuthenticationProtocol.SHA_1);
    when(deviceTransportConfig.getSecurityName()).thenReturn("Security Name");
    when(deviceTransportConfig.getUsername()).thenReturn("janedoe");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V3);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getAuthenticationPassphrase();
    verify(deviceTransportConfig, atLeast(1)).getAuthenticationProtocol();
    verify(deviceTransportConfig).getEngineId();
    verify(deviceTransportConfig).getProtocolVersion();
    verify(deviceTransportConfig).getSecurityName();
    verify(deviceTransportConfig).getUsername();
  }

  /**
   * Test {@link SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpDeviceTransportConfiguration#getHost()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpAuthService#setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration)}
   */
  @Test
  @DisplayName(
      "Test setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration); then calls getHost()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.snmp4j.Target SnmpAuthService.setUpSnmpTarget(SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration)"
  })
  void testSetUpSnmpTarget_thenCallsGetHost() {
    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);
    SnmpDeviceProfileTransportConfiguration profileTransportConfig =
        new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceTransportConfiguration deviceTransportConfig =
        mock(SnmpDeviceTransportConfiguration.class);
    when(deviceTransportConfig.getHost()).thenThrow(new UnsupportedOperationException());
    when(deviceTransportConfig.getCommunity()).thenReturn("Community");
    when(deviceTransportConfig.getProtocolVersion()).thenReturn(SnmpProtocolVersion.V1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.setUpSnmpTarget(profileTransportConfig, deviceTransportConfig));
    verify(deviceTransportConfig).getCommunity();
    verify(deviceTransportConfig).getHost();
    verify(deviceTransportConfig).getProtocolVersion();
  }

  /**
   * Test {@link SnmpAuthService#cleanUpSnmpAuthInfo(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Given {@link SnmpDeviceTransportConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SnmpAuthService#cleanUpSnmpAuthInfo(DeviceSessionContext)}
   */
  @Test
  @DisplayName(
      "Test cleanUpSnmpAuthInfo(DeviceSessionContext); given SnmpDeviceTransportConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpAuthService.cleanUpSnmpAuthInfo(DeviceSessionContext)"})
  void testCleanUpSnmpAuthInfo_givenSnmpDeviceTransportConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenReturn(new SnmpDeviceTransportConfiguration());

    // Act
    snmpAuthService.cleanUpSnmpAuthInfo(sessionContext);

    // Assert
    verify(sessionContext).getDeviceTransportConfiguration();
  }

  /**
   * Test {@link SnmpAuthService#cleanUpSnmpAuthInfo(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpAuthService#cleanUpSnmpAuthInfo(DeviceSessionContext)}
   */
  @Test
  @DisplayName(
      "Test cleanUpSnmpAuthInfo(DeviceSessionContext); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpAuthService.cleanUpSnmpAuthInfo(DeviceSessionContext)"})
  void testCleanUpSnmpAuthInfo_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    SnmpAuthService snmpAuthService = new SnmpAuthService(snmpTransportService);

    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getDeviceTransportConfiguration())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> snmpAuthService.cleanUpSnmpAuthInfo(sessionContext));
    verify(sessionContext).getDeviceTransportConfiguration();
  }
}
