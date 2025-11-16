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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.discovery.event.ServiceListChangedEvent;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ExtendWith(MockitoExtension.class)
class SnmpTransportBalancingServiceDiffblueTest {
  @InjectMocks private SnmpTransportBalancingService snmpTransportBalancingService;

  @Mock private SnmpTransportService snmpTransportService;

  /**
   * Test {@link SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}.
   *
   * <p>Method under test: {@link
   * SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName("Test onServiceListChanged(ServiceListChangedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportBalancingService.onServiceListChanged(ServiceListChangedEvent)"
  })
  void testOnServiceListChanged() {
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
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider3,
            coreSettings,
            storage,
            new TopicService());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService2,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider4,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher2,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());

    SnmpTransportBalancingService snmpTransportBalancingService =
        new SnmpTransportBalancingService(partitionService, eventPublisher, snmpTransportService);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(LazyStringArrayList.emptyList());
    ServiceListChangedEvent event = new ServiceListChangedEvent(new ArrayList<>(), currentService);

    // Act
    snmpTransportBalancingService.onServiceListChanged(event);

    // Assert
    verify(currentService).getTransportsList();
  }

  /**
   * Test {@link SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}.
   *
   * <p>Method under test: {@link
   * SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName("Test onServiceListChanged(ServiceListChangedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportBalancingService.onServiceListChanged(ServiceListChangedEvent)"
  })
  void testOnServiceListChanged2() {
    // Arrange
    when(snmpTransportService.getName()).thenReturn("Name");

    // Act
    snmpTransportBalancingService.onServiceListChanged(
        new ServiceListChangedEvent(new ArrayList<>(), ServiceInfo.getDefaultInstance()));

    // Assert
    verify(snmpTransportService).getName();
  }

  /**
   * Test {@link SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then calls {@link ByteString#isValidUtf8()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName(
      "Test onServiceListChanged(ServiceListChangedEvent); given 'A'; then calls isValidUtf8()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportBalancingService.onServiceListChanged(ServiceListChangedEvent)"
  })
  void testOnServiceListChanged_givenA_thenCallsIsValidUtf8() {
    // Arrange
    when(snmpTransportService.getName()).thenReturn("Name");

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(new byte[] {'A', 7, 'A', 7, 'A', 7, 'A', 7});
    lazyStringArrayList.add(element);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(lazyStringArrayList);
    ServiceListChangedEvent event = new ServiceListChangedEvent(new ArrayList<>(), currentService);

    // Act
    snmpTransportBalancingService.onServiceListChanged(event);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(currentService).getTransportsList();
    verify(snmpTransportService).getName();
  }

  /**
   * Test {@link SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isValidUtf8()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName(
      "Test onServiceListChanged(ServiceListChangedEvent); given ByteString isValidUtf8() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportBalancingService.onServiceListChanged(ServiceListChangedEvent)"
  })
  void testOnServiceListChanged_givenByteStringIsValidUtf8ReturnFalse() {
    // Arrange
    when(snmpTransportService.getName()).thenReturn("Name");

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(false);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(lazyStringArrayList);
    ServiceListChangedEvent event = new ServiceListChangedEvent(new ArrayList<>(), currentService);

    // Act
    snmpTransportBalancingService.onServiceListChanged(event);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(currentService).getTransportsList();
    verify(snmpTransportService).getName();
  }

  /**
   * Test {@link SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isValidUtf8()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SnmpTransportBalancingService#onServiceListChanged(ServiceListChangedEvent)}
   */
  @Test
  @DisplayName(
      "Test onServiceListChanged(ServiceListChangedEvent); given ByteString isValidUtf8() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportBalancingService.onServiceListChanged(ServiceListChangedEvent)"
  })
  void testOnServiceListChanged_givenByteStringIsValidUtf8ReturnTrue() {
    // Arrange
    when(snmpTransportService.getName()).thenReturn("Name");

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(lazyStringArrayList);
    ServiceListChangedEvent event = new ServiceListChangedEvent(new ArrayList<>(), currentService);

    // Act
    snmpTransportBalancingService.onServiceListChanged(event);

    // Assert
    verify(element).isValidUtf8();
    verify(element).toStringUtf8();
    verify(currentService).getTransportsList();
    verify(snmpTransportService).getName();
  }

  /**
   * Test {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentTransport(UUID); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SnmpTransportBalancingService.isManagedByCurrentTransport(UUID)"})
  void testIsManagedByCurrentTransport_thenReturnFalse() {
    // Arrange
    HashPartitionService partitionService = mock(HashPartitionService.class);
    when(partitionService.resolvePartitionIndex(Mockito.<UUID>any(), anyInt())).thenReturn(1);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
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
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService2,
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
            eventPublisher2,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());

    SnmpTransportBalancingService snmpTransportBalancingService =
        new SnmpTransportBalancingService(partitionService, eventPublisher, snmpTransportService);

    // Act
    boolean actualIsManagedByCurrentTransportResult =
        snmpTransportBalancingService.isManagedByCurrentTransport(UUID.randomUUID());

    // Assert
    verify(partitionService).resolvePartitionIndex(isA(UUID.class), eq(1));
    assertFalse(actualIsManagedByCurrentTransportResult);
  }

  /**
   * Test {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportBalancingService#isManagedByCurrentTransport(UUID)}
   */
  @Test
  @DisplayName("Test isManagedByCurrentTransport(UUID); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SnmpTransportBalancingService.isManagedByCurrentTransport(UUID)"})
  void testIsManagedByCurrentTransport_thenReturnTrue() {
    // Arrange
    HashPartitionService partitionService = mock(HashPartitionService.class);
    when(partitionService.resolvePartitionIndex(Mockito.<UUID>any(), anyInt())).thenReturn(0);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
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
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService2,
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
            eventPublisher2,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());

    SnmpTransportBalancingService snmpTransportBalancingService =
        new SnmpTransportBalancingService(partitionService, eventPublisher, snmpTransportService);

    // Act
    boolean actualIsManagedByCurrentTransportResult =
        snmpTransportBalancingService.isManagedByCurrentTransport(UUID.randomUUID());

    // Assert
    verify(partitionService).resolvePartitionIndex(isA(UUID.class), eq(1));
    assertTrue(actualIsManagedByCurrentTransportResult);
  }
}
