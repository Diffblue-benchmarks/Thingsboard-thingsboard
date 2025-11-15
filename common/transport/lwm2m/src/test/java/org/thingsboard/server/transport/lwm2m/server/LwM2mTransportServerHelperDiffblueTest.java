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
package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.TransportDeviceInfo;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.TransportRateLimitService;
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

@DisabledInAotMode
class LwM2mTransportServerHelperDiffblueTest {
  @MockBean
  private LwM2mTransportContext lwM2mTransportContext;

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testSendParametersOnThingsboardAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<TransportProtos.KeyValueProto> result = new ArrayList<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(result,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testSendParametersOnThingsboardAttribute2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostAttributeMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<TransportProtos.KeyValueProto> result = new ArrayList<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(result,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostAttributeMsg.class), isA(TransportServiceCallback.class));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)}
   */
  @Test
  void testSendParametersOnThingsboardAttribute3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostAttributeMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<TransportProtos.KeyValueProto> result = new ArrayList<>();
    result.add(TransportProtos.KeyValueProto.getDefaultInstance());
    result.add(TransportProtos.KeyValueProto.getDefaultInstance());

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(result,
        TransportProtos.SessionInfoProto.getDefaultInstance());

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostAttributeMsg.class), isA(TransportServiceCallback.class));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  void testSendParametersOnThingsboardTelemetry() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    assertTrue(kvList.isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  void testSendParametersOnThingsboardTelemetry2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostTelemetryMsg.class), isA(TransportServiceCallback.class));
    assertTrue(kvList.isEmpty());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  void testSendParametersOnThingsboardTelemetry3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostTelemetryMsg.class), isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  void testSendParametersOnThingsboardTelemetry4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    kvList.add(TransportProtos.KeyValueProto.getDefaultInstance());
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostTelemetryMsg.class), isA(TransportServiceCallback.class));
    assertEquals(2, kvList.size());
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  void testSendParametersOnThingsboardTelemetry5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();

    HashMap<String, AtomicLong> keyTsLatestMaps = new HashMap<>();
    keyTsLatestMaps.put("", new AtomicLong(1L));

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(kvList, sessionInfo, keyTsLatestMaps);

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostTelemetryMsg.class), isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  void testSendParametersOnThingsboardTelemetry6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(Mockito.<TenantId>any(), Mockito.<DeviceId>any(), Mockito.<DeviceId>any(),
        anyInt(), anyBoolean())).thenReturn(new TbPair<>(EntityType.TENANT, true));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.SessionInfoProto sessionInfo = TransportProtos.SessionInfoProto.getDefaultInstance();
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(kvList, sessionInfo, keyTsLatestMap,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
  }

  /**
   * Method under test: {@link LwM2mTransportServerHelper#getTs(List, Map)}
   */
  @Test
  void testGetTs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();

    // Act
    lwM2mTransportServerHelper.getTs(kvList, new HashMap<>());

    // Assert
    assertTrue(kvList.isEmpty());
  }

  /**
   * Method under test: {@link LwM2mTransportServerHelper#getTs(List, Map)}
   */
  @Test
  void testGetTs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(
        mock(LwM2mTransportContext.class));
    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();

    // Act
    lwM2mTransportServerHelper.getTs(kvList, new HashMap<>());

    // Assert
    assertTrue(kvList.isEmpty());
  }

  /**
   * Method under test: {@link LwM2mTransportServerHelper#getTs(List, Map)}
   */
  @Test
  void testGetTs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);

    // Act
    lwM2mTransportServerHelper.getTs(kvList, new HashMap<>());

    // Assert
    assertEquals(1, kvList.size());
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test: {@link LwM2mTransportServerHelper#getTs(List, Map)}
   */
  @Test
  void testGetTs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    kvList.add(TransportProtos.KeyValueProto.getDefaultInstance());
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);

    // Act
    lwM2mTransportServerHelper.getTs(kvList, new HashMap<>());

    // Assert
    assertEquals(2, kvList.size());
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test: {@link LwM2mTransportServerHelper#getTs(List, Map)}
   */
  @Test
  void testGetTs5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", new AtomicLong(1L));

    // Act
    lwM2mTransportServerHelper.getTs(kvList, keyTsLatestMap);

    // Assert
    assertEquals(1, kvList.size());
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test: {@link LwM2mTransportServerHelper#getTs(List, Map)}
   */
  @Test
  void testGetTs6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<TransportProtos.KeyValueProto> kvList = new ArrayList<>();
    TransportProtos.KeyValueProto defaultInstance = TransportProtos.KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", new AtomicLong(Long.MAX_VALUE));

    // Act
    long actualTs = lwM2mTransportServerHelper.getTs(kvList, keyTsLatestMap);

    // Assert
    assertEquals(1, kvList.size());
    assertEquals(Long.MIN_VALUE, actualTs);
    assertSame(defaultInstance, kvList.get(0));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  void testGetTsByKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("Key").get());
    assertEquals(1L, actualTsByKey);
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  void testGetTsByKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(
        mock(LwM2mTransportContext.class));
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("Key").get());
    assertEquals(1L, actualTsByKey);
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  void testGetTsByKey3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    AtomicLong atomicLong = new AtomicLong(1L);
    keyTsLatestMap.put("", atomicLong);

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(2L, actualTsByKey);
    assertSame(atomicLong, keyTsLatestMap.get(""));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  void testGetTsByKey4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    AtomicLong atomicLong = new AtomicLong(0L);
    keyTsLatestMap.put("", atomicLong);

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, actualTsByKey);
    assertSame(atomicLong, keyTsLatestMap.get(""));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#getValidateSessionInfo(ValidateDeviceCredentialsResponse, long, long)}
   */
  @Test
  void testGetValidateSessionInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getNodeId()).thenReturn("42");
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    TransportDeviceInfo transportDeviceInfo = mock(TransportDeviceInfo.class);
    when(transportDeviceInfo.getDeviceProfileId()).thenThrow(new CodecException("An error occurred"));
    when(transportDeviceInfo.getDeviceType()).thenReturn("Device Type");
    when(transportDeviceInfo.getDeviceName()).thenReturn("Device Name");
    when(transportDeviceInfo.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(transportDeviceInfo.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(transportDeviceInfo.getDeviceId()).thenReturn(new DeviceId(UUID.randomUUID()));
    doNothing().when(transportDeviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(transportDeviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setGateway(anyBoolean());
    doNothing().when(transportDeviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(transportDeviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(transportDeviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(transportDeviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setCustomerId(Mockito.<CustomerId>any());
    transportDeviceInfo.setAdditionalInfo("Additional Info");
    transportDeviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    transportDeviceInfo.setDeviceId(null);
    transportDeviceInfo.setDeviceName("Device Name");
    transportDeviceInfo.setDeviceProfileId(null);
    transportDeviceInfo.setDeviceType("Device Type");
    transportDeviceInfo.setEdrxCycle(1L);
    transportDeviceInfo.setGateway(true);
    transportDeviceInfo.setPagingTransmissionWindow(1L);
    transportDeviceInfo.setPowerMode(PowerMode.PSM);
    transportDeviceInfo.setPsmActivityTimer(1L);
    transportDeviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    ValidateDeviceCredentialsResponse msg = mock(ValidateDeviceCredentialsResponse.class);
    when(msg.getDeviceInfo()).thenReturn(transportDeviceInfo);

    // Act and Assert
    assertThrows(CodecException.class, () -> lwM2mTransportServerHelper.getValidateSessionInfo(msg, 1L, 1L));
    verify(context).getNodeId();
    verify(transportDeviceInfo, atLeast(1)).getCustomerId();
    verify(transportDeviceInfo, atLeast(1)).getDeviceId();
    verify(transportDeviceInfo).getDeviceName();
    verify(transportDeviceInfo).getDeviceProfileId();
    verify(transportDeviceInfo).getDeviceType();
    verify(transportDeviceInfo, atLeast(1)).getTenantId();
    verify(transportDeviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(transportDeviceInfo).setCustomerId(isA(CustomerId.class));
    verify(transportDeviceInfo).setDeviceId(isNull());
    verify(transportDeviceInfo).setDeviceName(eq("Device Name"));
    verify(transportDeviceInfo).setDeviceProfileId(isNull());
    verify(transportDeviceInfo).setDeviceType(eq("Device Type"));
    verify(transportDeviceInfo).setEdrxCycle(eq(1L));
    verify(transportDeviceInfo).setGateway(eq(true));
    verify(transportDeviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(transportDeviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(transportDeviceInfo).setPsmActivityTimer(eq(1L));
    verify(transportDeviceInfo).setTenantId(isA(TenantId.class));
    verify(msg, atLeast(1)).getDeviceInfo();
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}
   */
  @Test
  void testParseFromXmlToObjectModel() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(new LwM2mTransportContext());

    // Act and Assert
    assertNull(lwM2mTransportServerHelper.parseFromXmlToObjectModel("AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}
   */
  @Test
  void testParseFromXmlToObjectModel2() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(null);

    // Act and Assert
    assertNull(lwM2mTransportServerHelper.parseFromXmlToObjectModel("AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}
   */
  @Test
  void testParseFromXmlToObjectModel3() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(
        mock(LwM2mTransportContext.class));

    // Act and Assert
    assertNull(lwM2mTransportServerHelper.parseFromXmlToObjectModel("AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type, String)}
   */
  @Test
  void testGetResourceModelTypeEqualsKvProtoValueType() {
    // Arrange, Act and Assert
    assertThrows(CodecException.class, () -> LwM2mTransportServerHelper
        .getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type.NONE, "Resource Path"));
    assertEquals(ResourceModel.Type.STRING, LwM2mTransportServerHelper
        .getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type.STRING, "Resource Path"));
    assertEquals(ResourceModel.Type.INTEGER, LwM2mTransportServerHelper
        .getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type.INTEGER, "Resource Path"));
    assertEquals(ResourceModel.Type.FLOAT, LwM2mTransportServerHelper
        .getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type.FLOAT, "Resource Path"));
    assertEquals(ResourceModel.Type.BOOLEAN, LwM2mTransportServerHelper
        .getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type.BOOLEAN, "Resource Path"));
  }
}
