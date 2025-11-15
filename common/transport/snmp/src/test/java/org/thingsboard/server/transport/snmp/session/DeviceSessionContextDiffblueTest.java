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
package org.thingsboard.server.transport.snmp.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.snmp4j.CommunityTarget;
import org.snmp4j.smi.Address;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
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
import org.thingsboard.server.transport.snmp.SnmpTransportContext;
import org.thingsboard.server.transport.snmp.service.PduService;
import org.thingsboard.server.transport.snmp.service.ProtoTransportEntityService;
import org.thingsboard.server.transport.snmp.service.SnmpAuthService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportBalancingService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportService;

class DeviceSessionContextDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceSessionContext#builder()}
   *   <li>{@link DeviceSessionContext#device(Device)}
   *   <li>{@link DeviceSessionContext#deviceProfile(DeviceProfile)}
   *   <li>
   * {@link DeviceSessionContext#deviceTransportConfiguration(SnmpDeviceTransportConfiguration)}
   *   <li>
   * {@link DeviceSessionContext#profileTransportConfiguration(SnmpDeviceProfileTransportConfiguration)}
   *   <li>{@link DeviceSessionContext#snmpTransportContext(SnmpTransportContext)}
   *   <li>{@link DeviceSessionContext#tenantId(TenantId)}
   *   <li>{@link DeviceSessionContext#token(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    DeviceSessionContext.DeviceSessionContextBuilder actualBuilderResult = DeviceSessionContext.builder();
    DeviceSessionContext.DeviceSessionContextBuilder actualDeviceResult = actualBuilderResult.device(new Device());
    DeviceSessionContext.DeviceSessionContextBuilder actualDeviceProfileResult = actualDeviceResult
        .deviceProfile(new DeviceProfile());
    DeviceSessionContext.DeviceSessionContextBuilder actualDeviceTransportConfigurationResult = actualDeviceProfileResult
        .deviceTransportConfiguration(new SnmpDeviceTransportConfiguration());
    DeviceSessionContext.DeviceSessionContextBuilder actualProfileTransportConfigurationResult = actualDeviceTransportConfigurationResult
        .profileTransportConfiguration(new SnmpDeviceProfileTransportConfiguration());
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

    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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
        producerProvider, ruleEngineProducerService, topicService, serviceInfoProvider3, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    SnmpTransportService snmpTransportService = new SnmpTransportService(transportService, new PduService());

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider2 = new InMemoryTbTransportQueueFactory(transportApiSettings2,
        transportNotificationSettings2, serviceInfoProvider5, coreSettings2, storage2, new TopicService());

    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider2 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings3, ruleEngineSettings, vcSettings, serviceInfoProvider6, transportApiSettings3,
        transportNotificationSettings3, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService2 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider7, tenantRoutingInfoService3, applicationEventPublisher3,
            queueRoutingInfoService3, new TopicService()));
    TopicService topicService3 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService2 = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService3, serviceInfoProvider8, statsFactory2,
        deviceProfileCache3, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider9, tenantRoutingInfoService4,
        applicationEventPublisher4, queueRoutingInfoService4, new TopicService());

    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider3 = new InMemoryTbTransportQueueFactory(transportApiSettings4,
        transportNotificationSettings4, serviceInfoProvider10, coreSettings4, storage3, new TopicService());

    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(null);
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache4 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService3 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler3 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache3 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor3 = mock(NotificationRuleProcessor.class);
    ProtoTransportEntityService protoEntityService = new ProtoTransportEntityService(new DefaultTransportService(
        partitionService3, queueProvider3, producerProvider3, ruleEngineProducerService3, topicService4,
        serviceInfoProvider11, statsFactory3, deviceProfileCache4, tenantProfileCache3, rateLimitService3, scheduler3,
        eventPublisher3, transportResourceCache3, notificationRuleProcessor3, new DefaultEntityLimitsCache(1, 3)));
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider12, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache5 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService3 = new DefaultTransportService(null, null, null, null, topicService5,
        serviceInfoProvider13, statsFactory4, deviceProfileCache5, tenantProfileCache4, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    SnmpTransportBalancingService balancingService = new SnmpTransportBalancingService(partitionService4,
        eventPublisher4, new SnmpTransportService(transportService3, new PduService()));

    TopicService topicService6 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache6 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 = new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService4 = new DefaultTransportService(null, null, null, null, topicService6,
        serviceInfoProvider14, statsFactory5, deviceProfileCache6, tenantProfileCache5, null,
        new DefaultSchedulerComponent(), mock(ApplicationEventPublisher.class), null,
        mock(NotificationRuleProcessor.class), null);

    DeviceSessionContext.DeviceSessionContextBuilder actualSnmpTransportContextResult = actualProfileTransportConfigurationResult
        .snmpTransportContext(
            new SnmpTransportContext(snmpTransportService, deviceProfileCache2, transportService2, protoEntityService,
                balancingService, new SnmpAuthService(new SnmpTransportService(transportService4, new PduService()))));
    DeviceSessionContext.DeviceSessionContextBuilder actualTenantIdResult = actualSnmpTransportContextResult
        .tenantId(new TenantId(UUID.randomUUID()));

    // Assert
    assertSame(actualTenantIdResult, actualTenantIdResult.token("ABC123"));
  }

  /**
   * Method under test:
   * {@link DeviceSessionContext#DeviceSessionContext(TenantId, Device, DeviceProfile, String, SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration, SnmpTransportContext)}
   */
  @Test
  void testNewDeviceSessionContext() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfiguration = new SnmpDeviceTransportConfiguration();
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    CommunityTarget<Address> communityTarget = new CommunityTarget<>();
    when(snmpAuthService.setUpSnmpTarget(Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
        Mockito.<SnmpDeviceTransportConfiguration>any())).thenReturn(communityTarget);

    // Act
    DeviceSessionContext actualDeviceSessionContext = new DeviceSessionContext(tenantId, device, deviceProfile,
        "ABC123", profileTransportConfiguration, deviceTransportConfiguration,
        new SnmpTransportContext(mock(SnmpTransportService.class), mock(TransportDeviceProfileCache.class),
            mock(TransportService.class), mock(ProtoTransportEntityService.class),
            mock(SnmpTransportBalancingService.class), snmpAuthService));

    // Assert
    verify(snmpAuthService).setUpSnmpTarget(isA(SnmpDeviceProfileTransportConfiguration.class),
        isA(SnmpDeviceTransportConfiguration.class));
    assertEquals("ABC123", actualDeviceSessionContext.getToken());
    assertNull(actualDeviceSessionContext.getDeviceId());
    assertNull(actualDeviceSessionContext.getDeviceInfo());
    assertNull(actualDeviceSessionContext.getSessionInfo());
    assertFalse(actualDeviceSessionContext.isConnected());
    assertTrue(actualDeviceSessionContext.getQueryingTasks().isEmpty());
    assertTrue(actualDeviceSessionContext.isActive());
    assertSame(communityTarget, actualDeviceSessionContext.getTarget());
    assertSame(device, actualDeviceSessionContext.getDevice());
    assertSame(deviceProfile, actualDeviceSessionContext.getDeviceProfile());
    assertSame(deviceTransportConfiguration, actualDeviceSessionContext.getDeviceTransportConfiguration());
    assertSame(profileTransportConfiguration, actualDeviceSessionContext.getProfileTransportConfiguration());
    assertSame(tenantId, actualDeviceSessionContext.getTenantId());
  }
}
