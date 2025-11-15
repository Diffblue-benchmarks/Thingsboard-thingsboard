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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.TenantProfileType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.profile.TenantProfileUpdateResult;
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

class DefaultTransportTenantProfileCacheDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)}
   */
  @Test
  void testPut() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache = new DefaultTransportTenantProfileCache();

    // Act and Assert
    assertFalse(defaultTransportTenantProfileCache.put(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Method under test:
   * {@link DefaultTransportTenantProfileCache#put(TenantId, TenantProfileId)}
   */
  @Test
  void testPut2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache = new DefaultTransportTenantProfileCache();

    // Act and Assert
    assertFalse(defaultTransportTenantProfileCache.put(new TenantId(UUID.randomUUID()), mock(TenantProfileId.class)));
  }

  /**
   * Method under test:
   * {@link DefaultTransportTenantProfileCache#put(TransportProtos.TenantProfileProto)}
   */
  @Test
  void testPut3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache = new DefaultTransportTenantProfileCache();

    // Act
    TenantProfileUpdateResult actualPutResult = defaultTransportTenantProfileCache
        .put(TransportProtos.TenantProfileProto.getDefaultInstance());

    // Assert
    TenantProfile profile = actualPutResult.getProfile();
    assertEquals("", profile.getName());
    UUID uuidId = profile.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    assertNull(profile.getProfileDataBytes());
    DefaultTenantProfileConfiguration defaultProfileConfiguration = profile.getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(profile.getDescription());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = profile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, profile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    TenantProfileId id = profile.getId();
    assertEquals(EntityType.TENANT_PROFILE, id.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(profile.isDefault());
    assertFalse(profile.isIsolatedTbRuleEngine());
    assertFalse(id.isNullUid());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = profile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertTrue(actualPutResult.getAffectedTenants().isEmpty());
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
    assertSame(uuidId, id.getId());
  }

  /**
   * Method under test:
   * {@link DefaultTransportTenantProfileCache#put(TransportProtos.TenantProfileProto)}
   */
  @Test
  void testPut4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache = new DefaultTransportTenantProfileCache();
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
    defaultTransportTenantProfileCache.setTransportService(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));

    // Act
    TenantProfileUpdateResult actualPutResult = defaultTransportTenantProfileCache
        .put(TransportProtos.TenantProfileProto.getDefaultInstance());

    // Assert
    TenantProfile profile = actualPutResult.getProfile();
    assertEquals("", profile.getName());
    UUID uuidId = profile.getUuidId();
    assertEquals("00000000-0000-0000-0000-000000000000", uuidId.toString());
    assertNull(profile.getProfileDataBytes());
    DefaultTenantProfileConfiguration defaultProfileConfiguration = profile.getDefaultProfileConfiguration();
    assertNull(defaultProfileConfiguration.getSmsEnabled());
    assertNull(profile.getDescription());
    assertNull(defaultProfileConfiguration.getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getCustomerServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeEventRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimits());
    assertNull(defaultProfileConfiguration.getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(defaultProfileConfiguration.getTenantEntityExportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantEntityImportRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(defaultProfileConfiguration.getTenantNotificationRequestsRateLimit());
    assertNull(defaultProfileConfiguration.getTenantServerRestLimitsConfiguration());
    assertNull(defaultProfileConfiguration.getTransportDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportGatewayTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantMsgRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(defaultProfileConfiguration.getTransportTenantTelemetryMsgRateLimit());
    assertNull(defaultProfileConfiguration.getWsUpdatesPerSessionRateLimit());
    TenantProfileData profileData = profile.getProfileData();
    assertNull(profileData.getQueueConfiguration());
    assertEquals(0, defaultProfileConfiguration.getAlarmsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getDefaultStorageTtlDays());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerCustomer());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerPublicUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerRegularUser());
    assertEquals(0, defaultProfileConfiguration.getMaxWsSessionsPerTenant());
    assertEquals(0, defaultProfileConfiguration.getQueueStatsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRpcTtlDays());
    assertEquals(0, defaultProfileConfiguration.getRuleEngineExceptionsTtlDays());
    assertEquals(0, defaultProfileConfiguration.getWsMsgQueueLimitPerSession());
    assertEquals(0.0d, defaultProfileConfiguration.getWarnThreshold());
    assertEquals(0L, profile.getCreatedTime());
    assertEquals(0L, defaultProfileConfiguration.getMaxAssets());
    assertEquals(0L, defaultProfileConfiguration.getMaxCreatedAlarms());
    assertEquals(0L, defaultProfileConfiguration.getMaxCustomers());
    assertEquals(0L, defaultProfileConfiguration.getMaxDPStorageDays());
    assertEquals(0L, defaultProfileConfiguration.getMaxDashboards());
    assertEquals(0L, defaultProfileConfiguration.getMaxDevices());
    assertEquals(0L, defaultProfileConfiguration.getMaxEmails());
    assertEquals(0L, defaultProfileConfiguration.getMaxJSExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxOtaPackagesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxREExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourceSize());
    assertEquals(0L, defaultProfileConfiguration.getMaxResourcesInBytes());
    assertEquals(0L, defaultProfileConfiguration.getMaxRuleChains());
    assertEquals(0L, defaultProfileConfiguration.getMaxSms());
    assertEquals(0L, defaultProfileConfiguration.getMaxTbelExecutions());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportDataPoints());
    assertEquals(0L, defaultProfileConfiguration.getMaxTransportMessages());
    assertEquals(0L, defaultProfileConfiguration.getMaxUsers());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, defaultProfileConfiguration.getMaxWsSubscriptionsPerTenant());
    TenantProfileId id = profile.getId();
    assertEquals(EntityType.TENANT_PROFILE, id.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, defaultProfileConfiguration.getType());
    assertFalse(profile.isDefault());
    assertFalse(profile.isIsolatedTbRuleEngine());
    assertFalse(id.isNullUid());
    Optional<DefaultTenantProfileConfiguration> profileConfiguration = profile.getProfileConfiguration();
    assertTrue(profileConfiguration.isPresent());
    assertTrue(actualPutResult.getAffectedTenants().isEmpty());
    assertSame(defaultProfileConfiguration, profileConfiguration.get());
    assertSame(defaultProfileConfiguration, profileData.getConfiguration());
    assertSame(uuidId, id.getId());
  }

  /**
   * Method under test:
   * {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}
   */
  @Test
  void testRemove() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportTenantProfileCache defaultTransportTenantProfileCache = new DefaultTransportTenantProfileCache();

    // Act and Assert
    assertNull(defaultTransportTenantProfileCache.remove(new TenantProfileId(UUID.randomUUID())));
  }

  /**
   * Method under test:
   * {@link DefaultTransportTenantProfileCache#remove(TenantProfileId)}
   */
  @Test
  void testRemove2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DefaultTransportTenantProfileCache()).remove(mock(TenantProfileId.class)));
  }
}
