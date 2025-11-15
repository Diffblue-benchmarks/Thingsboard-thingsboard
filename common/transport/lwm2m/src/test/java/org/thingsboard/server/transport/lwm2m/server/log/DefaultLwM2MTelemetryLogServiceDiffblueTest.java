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
package org.thingsboard.server.transport.lwm2m.server.log;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
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
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;

class DefaultLwM2MTelemetryLogServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultLwM2MTelemetryLogService#log(LwM2mClient, String)}
   */
  @Test
  void testLog() {
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
    DefaultLwM2MTelemetryLogService defaultLwM2MTelemetryLogService = new DefaultLwM2MTelemetryLogService(
        new LwM2mTransportServerHelper(context));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    defaultLwM2MTelemetryLogService.log(client, "Log Msg");

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(1), eq(false));
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MTelemetryLogService#log(LwM2mClient, String)}
   */
  @Test
  void testLog2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    DefaultLwM2MTelemetryLogService defaultLwM2MTelemetryLogService = new DefaultLwM2MTelemetryLogService(
        new LwM2mTransportServerHelper(context));
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    defaultLwM2MTelemetryLogService.log(client, "Log Msg");

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostTelemetryMsg.class), isA(TransportServiceCallback.class));
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link DefaultLwM2MTelemetryLogService#log(LwM2mClient, String)}
   */
  @Test
  void testLog3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LwM2mTransportServerHelper helper = mock(LwM2mTransportServerHelper.class);
    when(helper.getKvStringtoThingsboard(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new ArrayList<>());
    doNothing().when(helper)
        .sendParametersOnThingsboardTelemetry(Mockito.<List<TransportProtos.KeyValueProto>>any(),
            Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<Map<String, AtomicLong>>any());
    DefaultLwM2MTelemetryLogService defaultLwM2MTelemetryLogService = new DefaultLwM2MTelemetryLogService(helper);
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getKeyTsLatestMap()).thenReturn(new ConcurrentHashMap<>());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    defaultLwM2MTelemetryLogService.log(client, "Log Msg");

    // Assert that nothing has changed
    verify(helper).getKvStringtoThingsboard(eq("transportLog"), eq("Log Msg"));
    verify(helper).sendParametersOnThingsboardTelemetry(isA(List.class), isA(TransportProtos.SessionInfoProto.class),
        isA(Map.class));
    verify(client).getKeyTsLatestMap();
    verify(client, atLeast(1)).getSession();
  }
}
