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
package org.thingsboard.server.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.DeviceUpdatedEvent;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
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
import org.thingsboard.server.transport.snmp.service.PduService;
import org.thingsboard.server.transport.snmp.service.ProtoTransportEntityService;
import org.thingsboard.server.transport.snmp.service.SnmpAuthService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportBalancingService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportService;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

class SnmpTransportContextDiffblueTest {
  /**
   * Method under test:
   * {@link SnmpTransportContext#fetchDevicesAndEstablishSessions()}
   */
  @Test
  void testFetchDevicesAndEstablishSessions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ProtoTransportEntityService protoEntityService = mock(ProtoTransportEntityService.class);
    when(protoEntityService.getSnmpDevicesIds(anyInt(), anyInt()))
        .thenReturn(TransportProtos.GetSnmpDevicesResponseMsg.getDefaultInstance());

    // Act
    (new SnmpTransportContext(mock(SnmpTransportService.class), mock(TransportDeviceProfileCache.class),
        mock(TransportService.class), protoEntityService, mock(SnmpTransportBalancingService.class),
        mock(SnmpAuthService.class))).fetchDevicesAndEstablishSessions();

    // Assert that nothing has changed
    verify(protoEntityService).getSnmpDevicesIds(eq(0), eq(512));
  }

  /**
   * Method under test:
   * {@link SnmpTransportContext#onDeviceUpdatedOrCreated(DeviceUpdatedEvent)}
   */
  @Test
  void testOnDeviceUpdatedOrCreated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SnmpTransportContext snmpTransportContext = new SnmpTransportContext(mock(SnmpTransportService.class),
        mock(TransportDeviceProfileCache.class), mock(TransportService.class), mock(ProtoTransportEntityService.class),
        mock(SnmpTransportBalancingService.class), mock(SnmpAuthService.class));
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);
    Device device = mock(Device.class);
    when(device.getId()).thenReturn(null);
    when(device.getDeviceData()).thenReturn(deviceData);

    // Act
    snmpTransportContext.onDeviceUpdatedOrCreated(new DeviceUpdatedEvent(device));

    // Assert
    verify(device).getDeviceData();
    verify(device).getId();
    verify(transportConfiguration).getType();
  }

  /**
   * Method under test:
   * {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}
   */
  @Test
  void testOnDeviceDeleted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SnmpTransportService snmpTransportService = mock(SnmpTransportService.class);
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .lifecycleEvent(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(), Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());
    SnmpTransportContext snmpTransportContext = new SnmpTransportContext(snmpTransportService,
        mock(TransportDeviceProfileCache.class), transportService, mock(ProtoTransportEntityService.class),
        mock(SnmpTransportBalancingService.class), snmpAuthService);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(sessionContext.getDeviceId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(sessionContext.getSessionInfo()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(sessionContext).close();
    when(sessionContext.getDevice()).thenReturn(new Device());

    // Act
    snmpTransportContext.onDeviceDeleted(sessionContext);

    // Assert
    verify(transportService).deregisterSession(isA(TransportProtos.SessionInfoProto.class));
    verify(transportService).lifecycleEvent(isA(TenantId.class), isA(DeviceId.class),
        eq(ComponentLifecycleEvent.STOPPED), eq(true), isNull());
    verify(sessionContext, atLeast(1)).getDeviceId();
    verify(sessionContext).getSessionInfo();
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    verify(sessionContext).close();
    verify(sessionContext).getDevice();
    verify(sessionContext).getTenantId();
  }

  /**
   * Method under test:
   * {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}
   */
  @Test
  void testOnDeviceDeleted2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SnmpTransportService snmpTransportService = mock(SnmpTransportService.class);
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .lifecycleEvent(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(), Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<TransportProtos.SessionInfoProto>any());
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());
    SnmpTransportContext snmpTransportContext = new SnmpTransportContext(snmpTransportService,
        mock(TransportDeviceProfileCache.class), transportService, mock(ProtoTransportEntityService.class),
        mock(SnmpTransportBalancingService.class), snmpAuthService);
    Device device = mock(Device.class);
    when(device.getId()).thenReturn(null);
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);
    when(sessionContext.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(sessionContext.getDeviceId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(sessionContext.getSessionInfo()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(sessionContext).close();
    when(sessionContext.getDevice()).thenReturn(device);

    // Act
    snmpTransportContext.onDeviceDeleted(sessionContext);

    // Assert
    verify(device).getId();
    verify(transportService).deregisterSession(isA(TransportProtos.SessionInfoProto.class));
    verify(transportService).lifecycleEvent(isA(TenantId.class), isA(DeviceId.class),
        eq(ComponentLifecycleEvent.STOPPED), eq(true), isNull());
    verify(sessionContext, atLeast(1)).getDeviceId();
    verify(sessionContext).getSessionInfo();
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    verify(sessionContext).close();
    verify(sessionContext).getDevice();
    verify(sessionContext).getTenantId();
  }

  /**
   * Method under test: {@link SnmpTransportContext#getSessions()}
   */
  @Test
  void testGetSessions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SnmpTransportContext(mock(SnmpTransportService.class), mock(TransportDeviceProfileCache.class),
        mock(TransportService.class), mock(ProtoTransportEntityService.class),
        mock(SnmpTransportBalancingService.class), mock(SnmpAuthService.class))).getSessions().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpTransportContext#getSnmpAuthService()}
   *   <li>{@link SnmpTransportContext#getSnmpTransportService()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
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

    SnmpTransportService snmpTransportService = new SnmpTransportService(transportService, new PduService());

    DefaultTransportDeviceProfileCache deviceProfileCache2 = new DefaultTransportDeviceProfileCache();
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
    DefaultTransportDeviceProfileCache deviceProfileCache3 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService2 = new DefaultTransportService(partitionService2, queueProvider2,
        producerProvider2, ruleEngineProducerService2, topicService4, serviceInfoProvider10, statsFactory2,
        deviceProfileCache3, tenantProfileCache2, rateLimitService2, scheduler2, eventPublisher2,
        transportResourceCache2, notificationRuleProcessor2, new DefaultEntityLimitsCache(1, 3));

    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider11, tenantRoutingInfoService5,
        applicationEventPublisher5, queueRoutingInfoService5, new TopicService());

    TbQueueTransportApiSettings transportApiSettings5 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings5 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings5 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider3 = new InMemoryTbTransportQueueFactory(transportApiSettings5,
        transportNotificationSettings5, serviceInfoProvider12, coreSettings5, storage3, new TopicService());

    TopicService topicService5 = new TopicService();
    TbQueueCoreSettings coreSettings6 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings3 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings3 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings6 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings6 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings3 = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService5, coreSettings6, ruleEngineSettings3, vcSettings3, serviceInfoProvider13, transportApiSettings6,
        transportNotificationSettings6, edgeSettings3, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService6 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher6 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService6 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider14, tenantRoutingInfoService6, applicationEventPublisher6,
            queueRoutingInfoService6, new TopicService()));
    TopicService topicService6 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider15 = new DefaultTbServiceInfoProvider();
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
        partitionService3, queueProvider3, producerProvider3, ruleEngineProducerService3, topicService6,
        serviceInfoProvider15, statsFactory3, deviceProfileCache4, tenantProfileCache3, rateLimitService3, scheduler3,
        eventPublisher3, transportResourceCache3, notificationRuleProcessor3, new DefaultEntityLimitsCache(1, 3)));
    DefaultTbServiceInfoProvider serviceInfoProvider16 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService7 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher7 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService7 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 = new HashPartitionService(serviceInfoProvider16, tenantRoutingInfoService7,
        applicationEventPublisher7, queueRoutingInfoService7, new TopicService());

    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    DefaultTbServiceInfoProvider serviceInfoProvider17 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService8 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher8 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService8 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 = new HashPartitionService(serviceInfoProvider17, tenantRoutingInfoService8,
        applicationEventPublisher8, queueRoutingInfoService8, new TopicService());

    TbQueueTransportApiSettings transportApiSettings7 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings7 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider18 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings7 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage4 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider4 = new InMemoryTbTransportQueueFactory(transportApiSettings7,
        transportNotificationSettings7, serviceInfoProvider18, coreSettings7, storage4, new TopicService());

    TbCoreQueueProducerProvider producerProvider4 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService4 = new TbRuleEngineProducerService(null);
    TopicService topicService7 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider19 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache5 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService4 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler4 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher5 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache4 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor4 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService3 = new DefaultTransportService(partitionService5, queueProvider4,
        producerProvider4, ruleEngineProducerService4, topicService7, serviceInfoProvider19, statsFactory4,
        deviceProfileCache5, tenantProfileCache4, rateLimitService4, scheduler4, eventPublisher5,
        transportResourceCache4, notificationRuleProcessor4, new DefaultEntityLimitsCache(1, 3));

    SnmpTransportBalancingService balancingService = new SnmpTransportBalancingService(partitionService4,
        eventPublisher4, new SnmpTransportService(transportService3, new PduService()));

    DefaultTbServiceInfoProvider serviceInfoProvider20 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService9 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher9 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService9 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService6 = new HashPartitionService(serviceInfoProvider20, tenantRoutingInfoService9,
        applicationEventPublisher9, queueRoutingInfoService9, new TopicService());

    TbQueueTransportApiSettings transportApiSettings8 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings8 = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider21 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings8 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage5 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider5 = new InMemoryTbTransportQueueFactory(transportApiSettings8,
        transportNotificationSettings8, serviceInfoProvider21, coreSettings8, storage5, new TopicService());

    TbCoreQueueProducerProvider producerProvider5 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService5 = new TbRuleEngineProducerService(null);
    TopicService topicService8 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider22 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache6 = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService5 = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler5 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher6 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache5 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor5 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService4 = new DefaultTransportService(partitionService6, queueProvider5,
        producerProvider5, ruleEngineProducerService5, topicService8, serviceInfoProvider22, statsFactory5,
        deviceProfileCache6, tenantProfileCache5, rateLimitService5, scheduler5, eventPublisher6,
        transportResourceCache5, notificationRuleProcessor5, new DefaultEntityLimitsCache(1, 3));

    SnmpAuthService snmpAuthService = new SnmpAuthService(
        new SnmpTransportService(transportService4, new PduService()));
    SnmpTransportContext snmpTransportContext = new SnmpTransportContext(snmpTransportService, deviceProfileCache2,
        transportService2, protoEntityService, balancingService, snmpAuthService);

    // Act
    SnmpAuthService actualSnmpAuthService = snmpTransportContext.getSnmpAuthService();

    // Assert
    assertSame(snmpAuthService, actualSnmpAuthService);
    assertSame(snmpTransportService, snmpTransportContext.getSnmpTransportService());
  }
}
