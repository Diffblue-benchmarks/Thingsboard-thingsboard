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
package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.rpc.RpcStatus;
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
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;
import org.thingsboard.server.transport.lwm2m.server.downlink.TbLwM2MCancelAllObserveCallback;
import org.thingsboard.server.transport.lwm2m.server.log.LwM2MTelemetryLogService;

class RpcDownlinkRequestCallbackProxyDiffblueTest {
  /**
   * Method under test: {@link RpcDownlinkRequestCallbackProxy#onSent(Object)}
   */
  @Test
  void testOnSent() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    boolean actualOnSentResult = rpcCancelAllObserveCallback.onSent(null);

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.SENT), isA(TransportServiceCallback.class));
    assertEquals("00000000-0000-0000-0000-000000000000",
        rpcCancelAllObserveCallback.client.getLastSentRpcId().toString());
    assertTrue(actualOnSentResult);
  }

  /**
   * Method under test: {@link RpcDownlinkRequestCallbackProxy#onSent(Object)}
   */
  @Test
  void testOnSent2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getLastSentRpcId()).thenReturn(UUID.randomUUID());
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    doNothing().when(client).lock();
    doNothing().when(client).setLastSentRpcId(Mockito.<UUID>any());
    doNothing().when(client).unlock();
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act
    boolean actualOnSentResult = (new RpcCancelAllObserveCallback(transportService, client, requestMsg,
        new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))))
        .onSent(null);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.SENT), isA(TransportServiceCallback.class));
    verify(client).getLastSentRpcId();
    verify(client).getSession();
    verify(client).lock();
    verify(client).setLastSentRpcId(isA(UUID.class));
    verify(client).unlock();
    assertTrue(actualOnSentResult);
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onSuccess(null, 1);

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: Cancel of all observations was successful. Result: [1]"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onSuccess(null, 1);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: Cancel of all observations was successful. Result: [1]"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onSuccess(null, 1);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
    verify(client2).getEndpoint();
    verify(client, atLeast(1)).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: Cancel of all observations was successful. Result: [1]"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess4() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null)).onSuccess(null, 1);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onSuccess(Object, Object)}
   */
  @Test
  void testOnSuccess5() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcRequestMsg>any(),
            Mockito.<RpcStatus>any(), anyBoolean(), Mockito.<TransportServiceCallback<Void>>any());
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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

    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    DefaultTransportService transportService2 = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService, serviceInfoProvider3, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    RpcCancelAllObserveCallback callback2 = new RpcCancelAllObserveCallback(transportService2, client2,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback2)).onSuccess(null, 1);

    // Assert
    verify(notificationRuleProcessor, atLeast(1)).process(isA(NotificationRuleTrigger.class));
    verify(rateLimitService, atLeast(1)).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0),
        eq(false));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcRequestMsg.class), eq(RpcStatus.DELIVERED), eq(true),
        isA(TransportServiceCallback.class));
    verify(client, atLeast(1)).getSession();
    verify(client2, atLeast(1)).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[info]: Cancel of all observations was successful. Result: [1]"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onValidationError("Params", "Msg");

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(logService).log(isA(LwM2mClient.class), eq("[error]: Request [Params] validation failed. Reason: Msg"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onValidationError("Params", "Msg");

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class), eq("[error]: Request [Params] validation failed. Reason: Msg"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onValidationError("Params", "Msg");

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client2).getEndpoint();
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class), eq("[error]: Request [Params] validation failed. Reason: Msg"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError4() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null)).onValidationError("Params", "Msg");

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError5() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onValidationError("Params", "");

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client2).getEndpoint();
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class), eq("[error]: Request [Params] validation failed. Reason: "));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onValidationError(String, String)}
   */
  @Test
  void testOnValidationError6() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback)).onValidationError("Params", null);

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client2).getEndpoint();
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class), eq("[error]: Request [Params] validation failed. Reason: null"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(logService).log(isA(LwM2mClient.class),
        eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception: foo"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError2() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception: foo"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError3() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client2).getEndpoint();
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception: foo"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError4() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), null);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError5() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception(""));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client2).getEndpoint();
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception: "));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError6() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getEndpoint()).thenReturn("https://config.us-east-2.amazonaws.com");
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService, client2);

    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception((String) null));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client2).getEndpoint();
    verify(client).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#onError(String, Exception)}
   */
  @Test
  void testOnError7() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
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

    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    DefaultTransportService transportService2 = new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService, serviceInfoProvider3, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3));

    LwM2mClient client2 = mock(LwM2mClient.class);
    when(client2.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    doNothing().when(logService).log(Mockito.<LwM2mClient>any(), Mockito.<String>any());
    TbLwM2MCancelAllObserveCallback callback = new TbLwM2MCancelAllObserveCallback(logService,
        new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));

    RpcCancelAllObserveCallback callback2 = new RpcCancelAllObserveCallback(transportService2, client2,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback);

    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance(), callback2);

    // Act
    rpcCancelAllObserveCallback.onError("Params", new Exception("foo"));

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(rateLimitService).checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    verify(client).getSession();
    verify(client2).getSession();
    verify(logService).log(isA(LwM2mClient.class),
        eq("[error]: Request [Params] processing failed. Reason: java.lang.Exception: foo"));
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#reply(LwM2MRpcResponseBody)}
   */
  @Test
  void testReply() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.reply(new LwM2MRpcResponseBody("Result", "42", "An error occurred"));

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#reply(LwM2MRpcResponseBody)}
   */
  @Test
  void testReply2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.reply(new LwM2MRpcResponseBody("Result", "42", "An error occurred"));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#reply(LwM2MRpcResponseBody)}
   */
  @Test
  void testReply3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.reply(new LwM2MRpcResponseBody("Result", "42", ""));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnValidationError(String)}
   */
  @Test
  void testSendRpcReplyOnValidationError() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client, requestMsg, new TbLwM2MCancelAllObserveCallback(
        logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))))
        .sendRpcReplyOnValidationError("Msg");

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnValidationError(String)}
   */
  @Test
  void testSendRpcReplyOnValidationError2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client, requestMsg, new TbLwM2MCancelAllObserveCallback(
        logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))))
        .sendRpcReplyOnValidationError("Msg");

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnValidationError(String)}
   */
  @Test
  void testSendRpcReplyOnValidationError3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);

    // Act
    (new RpcCancelAllObserveCallback(transportService, client, requestMsg, new TbLwM2MCancelAllObserveCallback(
        logService, new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"))))
        .sendRpcReplyOnValidationError("");

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnError(Exception)}
   */
  @Test
  void testSendRpcReplyOnError() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = new LwM2mClient("42", "https://config.us-east-2.amazonaws.com");

    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.sendRpcReplyOnError(new Exception("foo"));

    // Assert
    verify(transportService).process((TransportProtos.SessionInfoProto) isNull(),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnError(Exception)}
   */
  @Test
  void testSendRpcReplyOnError2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.sendRpcReplyOnError(new Exception("foo"));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnError(Exception)}
   */
  @Test
  void testSendRpcReplyOnError3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.sendRpcReplyOnError(new Exception(""));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }

  /**
   * Method under test:
   * {@link RpcDownlinkRequestCallbackProxy#sendRpcReplyOnError(Exception)}
   */
  @Test
  void testSendRpcReplyOnError4() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getSession()).thenReturn(TransportProtos.SessionInfoProto.getDefaultInstance());
    TransportProtos.ToDeviceRpcRequestMsg requestMsg = TransportProtos.ToDeviceRpcRequestMsg.getDefaultInstance();
    LwM2MTelemetryLogService logService = mock(LwM2MTelemetryLogService.class);
    RpcCancelAllObserveCallback rpcCancelAllObserveCallback = new RpcCancelAllObserveCallback(transportService, client,
        requestMsg, new TbLwM2MCancelAllObserveCallback(logService,
            new LwM2mClient("42", "https://config.us-east-2.amazonaws.com")));

    // Act
    rpcCancelAllObserveCallback.sendRpcReplyOnError(new Exception((String) null));

    // Assert
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.ToDeviceRpcResponseMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(client).getSession();
  }
}
