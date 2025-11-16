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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FeatureSet;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.FileOptions;
import com.google.protobuf.DescriptorProtos.OneofOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.OneofDescriptor;
import com.google.protobuf.UnknownFieldSet;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import org.eclipse.leshan.core.model.ResourceModel;
import org.eclipse.leshan.core.model.ResourceModel.Type;
import org.eclipse.leshan.core.node.codec.CodecException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.ValidateDeviceCredentialsResponse;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.TransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.common.transport.service.SessionMetaData;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueProto;
import org.thingsboard.server.gen.transport.TransportProtos.KeyValueType;
import org.thingsboard.server.gen.transport.TransportProtos.PostAttributeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.PostTelemetryMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.TsKvListProto;
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
import rx.internal.observers.AssertableSubscriberObservable;
import rx.internal.producers.QueuedProducer;

@ExtendWith(MockitoExtension.class)
class LwM2mTransportServerHelperDiffblueTest {
  @Mock private LwM2mTransportContext lwM2mTransportContext;

  @InjectMocks private LwM2mTransportServerHelper lwM2mTransportServerHelper;

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * SessionInfoProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test sendParametersOnThingsboardAttribute(List, SessionInfoProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)"
  })
  void testSendParametersOnThingsboardAttribute() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostAttributeMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(
        new ArrayList<>(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(context).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostAttributeMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * SessionInfoProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test sendParametersOnThingsboardAttribute(List, SessionInfoProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)"
  })
  void testSendParametersOnThingsboardAttribute2() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostAttributeMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> result = new ArrayList<>();
    result.add(KeyValueProto.getDefaultInstance());

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(
        result, SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostAttributeMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardAttribute(List, SessionInfoProto); then calls process(NotificationRuleTrigger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)"
  })
  void testSendParametersOnThingsboardAttribute_thenCallsProcess() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<DeviceId>any(),
            anyInt(),
            anyBoolean()))
        .thenReturn(new TbPair<>(EntityType.TENANT, true));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);

    DefaultTransportService defaultTransportService =
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

    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(
        new ArrayList<>(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService)
        .checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardAttribute(List, SessionInfoProto); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)"
  })
  void testSendParametersOnThingsboardAttribute_thenThrowCodecException() {
    // Arrange
    when(lwM2mTransportContext.getTransportService())
        .thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(
                new ArrayList<>(), SessionInfoProto.getDefaultInstance()));
    verify(lwM2mTransportContext).getTransportService();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map, Instant)} with {@code kvList}, {@code sessionInfo}, {@code
   * keyTsLatestMap}, {@code ts}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map, Instant) with 'kvList', 'sessionInfo', 'keyTsLatestMap', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<DeviceId>any(),
            anyInt(),
            anyBoolean()))
        .thenReturn(new TbPair<>(EntityType.TENANT, true));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);

    DefaultTransportService defaultTransportService =
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

    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList,
        sessionInfo,
        new HashMap<>(),
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert that nothing has changed
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService)
        .checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    ConcurrentMap<UUID, SessionMetaData> uuidSessionMetaDataMap = defaultTransportService.sessions;
    assertEquals(
        uuidSessionMetaDataMap,
        descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(uuidSessionMetaDataMap, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(uuidSessionMetaDataMap, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(uuidSessionMetaDataMap, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(uuidSessionMetaDataMap, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(uuidSessionMetaDataMap, options.getAllFields());
    OneofOptions options2 = oneofs.get(0).getOptions();
    assertEquals(uuidSessionMetaDataMap, options2.getAllFields());
    assertEquals(uuidSessionMetaDataMap, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(uuidSessionMetaDataMap, features.getAllFieldsRaw());
    assertEquals(uuidSessionMetaDataMap, options.getAllFieldsRaw());
    assertEquals(uuidSessionMetaDataMap, options2.getAllFieldsRaw());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map, Instant)} with {@code kvList}, {@code sessionInfo}, {@code
   * keyTsLatestMap}, {@code ts}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map, Instant) with 'kvList', 'sessionInfo', 'keyTsLatestMap', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs2() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList,
        sessionInfo,
        keyTsLatestMap,
        LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert that nothing has changed
    verify(context).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    assertEquals(
        keyTsLatestMap, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(keyTsLatestMap, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(keyTsLatestMap, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(keyTsLatestMap, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(keyTsLatestMap, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(keyTsLatestMap, options.getAllFields());
    OneofOptions options2 = oneofs.get(0).getOptions();
    assertEquals(keyTsLatestMap, options2.getAllFields());
    assertEquals(keyTsLatestMap, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(keyTsLatestMap, features.getAllFieldsRaw());
    assertEquals(keyTsLatestMap, options.getAllFieldsRaw());
    assertEquals(keyTsLatestMap, options2.getAllFieldsRaw());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map, Instant)} with {@code kvList}, {@code sessionInfo}, {@code
   * keyTsLatestMap}, {@code ts}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map, Instant) with 'kvList', 'sessionInfo', 'keyTsLatestMap', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>(), null);

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    verify(keyValueProto).getKey();
    Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    assertEquals(18, descriptorForType.getFields().size());
    assertEquals(2, descriptorForType.getOneofs().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map, Instant)} with {@code kvList}, {@code sessionInfo}, {@code
   * keyTsLatestMap}, {@code ts}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map, Instant) with 'kvList', 'sessionInfo', 'keyTsLatestMap', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs4() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, SessionInfoProto.getDefaultInstance(), null, null);

    // Assert that nothing has changed
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    assertEquals(7, kvList.get(0).getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map, Instant)} with {@code kvList}, {@code sessionInfo}, {@code
   * keyTsLatestMap}, {@code ts}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map, Instant) with 'kvList', 'sessionInfo', 'keyTsLatestMap', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs5() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>(), null);

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    assertEquals(7, kvList.get(0).getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map, Instant)} with {@code kvList}, {@code sessionInfo}, {@code
   * keyTsLatestMap}, {@code ts}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map, Instant) with 'kvList', 'sessionInfo', 'keyTsLatestMap', 'ts'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map, Instant)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs6() {
    // Arrange
    when(lwM2mTransportContext.getTransportService())
        .thenThrow(new CodecException("An error occurred"));
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
                kvList,
                sessionInfo,
                new HashMap<>(),
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    verify(lwM2mTransportContext).getTransportService();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps() {
    // Arrange
    TransportRateLimitService rateLimitService = mock(TransportRateLimitService.class);
    when(rateLimitService.checkLimits(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<DeviceId>any(),
            anyInt(),
            anyBoolean()))
        .thenReturn(new TbPair<>(EntityType.TENANT, true));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    doNothing().when(notificationRuleProcessor).process(Mockito.<NotificationRuleTrigger>any());
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
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);

    DefaultTransportService defaultTransportService =
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

    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>());

    // Assert that nothing has changed
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(context).getTransportService();
    verify(rateLimitService)
        .checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
    Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    ConcurrentMap<UUID, SessionMetaData> uuidSessionMetaDataMap = defaultTransportService.sessions;
    assertEquals(
        uuidSessionMetaDataMap,
        descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(uuidSessionMetaDataMap, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(uuidSessionMetaDataMap, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(uuidSessionMetaDataMap, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(uuidSessionMetaDataMap, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(uuidSessionMetaDataMap, options.getAllFields());
    OneofOptions options2 = oneofs.get(0).getOptions();
    assertEquals(uuidSessionMetaDataMap, options2.getAllFields());
    assertEquals(uuidSessionMetaDataMap, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(uuidSessionMetaDataMap, features.getAllFieldsRaw());
    assertEquals(uuidSessionMetaDataMap, options.getAllFieldsRaw());
    assertEquals(uuidSessionMetaDataMap, options2.getAllFieldsRaw());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps2() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = mock(LwM2mTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    HashMap<String, AtomicLong> keyTsLatestMaps = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, keyTsLatestMaps);

    // Assert that nothing has changed
    verify(context).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(18, fields.size());
    List<OneofDescriptor> oneofs = descriptorForType.getOneofs();
    assertEquals(2, oneofs.size());
    assertEquals(
        keyTsLatestMaps, descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(keyTsLatestMaps, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(keyTsLatestMaps, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(keyTsLatestMaps, defaultInstanceForType.getAllFields());
    FeatureSet features = descriptorForType.getOptions().getFeatures();
    assertEquals(keyTsLatestMaps, features.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(keyTsLatestMaps, options.getAllFields());
    OneofOptions options2 = oneofs.get(0).getOptions();
    assertEquals(keyTsLatestMaps, options2.getAllFields());
    assertEquals(keyTsLatestMaps, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(keyTsLatestMaps, features.getAllFieldsRaw());
    assertEquals(keyTsLatestMaps, options.getAllFieldsRaw());
    assertEquals(keyTsLatestMaps, options2.getAllFieldsRaw());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps3() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    verify(keyValueProto).getKey();
    Descriptor descriptorForType = sessionInfo.getDescriptorForType();
    assertEquals(18, descriptorForType.getFields().size());
    assertEquals(2, descriptorForType.getOneofs().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps4() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, SessionInfoProto.getDefaultInstance(), null);

    // Assert that nothing has changed
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    assertEquals(7, kvList.get(0).getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps5() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    assertEquals(7, kvList.get(0).getDescriptorForType().getFields().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps6() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    HashMap<String, AtomicLong> keyTsLatestMaps = new HashMap<>();
    keyTsLatestMaps.put("", new AtomicLong());
    HashMap<String, AtomicLong> stringAtomicLongMap = new HashMap<>();
    keyTsLatestMaps.putAll(stringAtomicLongMap);

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, keyTsLatestMaps);

    // Assert that nothing has changed
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    Descriptor descriptorForType = kvList.get(0).getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    assertEquals(
        stringAtomicLongMap,
        descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(stringAtomicLongMap, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(stringAtomicLongMap, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(stringAtomicLongMap, defaultInstanceForType.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(stringAtomicLongMap, options.getAllFields());
    assertEquals(stringAtomicLongMap, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(stringAtomicLongMap, options.getAllFieldsRaw());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps7() {
    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(mock(DefaultTransportService.class));
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.get()).thenThrow(new CodecException("An error occurred"));

    HashMap<String, AtomicLong> keyTsLatestMaps = new HashMap<>();
    keyTsLatestMaps.put("", queuedProducer);
    keyTsLatestMaps.putAll(new HashMap<>());

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
                kvList, sessionInfo, keyTsLatestMaps));
    verify(queuedProducer).get();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps8() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    LwM2mTransportContext context = new LwM2mTransportContext();
    context.setTransportService(transportService);
    LwM2mTransportServerHelper lwM2mTransportServerHelper = new LwM2mTransportServerHelper(context);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.incrementAndGet()).thenReturn(1L);
    when(queuedProducer.get()).thenReturn(Long.MAX_VALUE);

    HashMap<String, AtomicLong> keyTsLatestMaps = new HashMap<>();
    keyTsLatestMaps.put("", queuedProducer);
    HashMap<String, AtomicLong> stringAtomicLongMap = new HashMap<>();
    keyTsLatestMaps.putAll(stringAtomicLongMap);

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, keyTsLatestMaps);

    // Assert that nothing has changed
    verify(queuedProducer).get();
    verify(queuedProducer).incrementAndGet();
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(PostTelemetryMsg.class),
            isA(TransportServiceCallback.class));
    assertEquals(1, kvList.size());
    Descriptor descriptorForType = kvList.get(0).getDescriptorForType();
    List<FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(7, fields.size());
    assertEquals(
        stringAtomicLongMap,
        descriptorForType.toProto().getDefaultInstanceForType().getAllFields());
    FileDescriptor file = descriptorForType.getFile();
    FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(stringAtomicLongMap, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(stringAtomicLongMap, toProtoResult.getSourceCodeInfo().getAllFields());
    FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(stringAtomicLongMap, defaultInstanceForType.getAllFields());
    FieldOptions options = fields.get(0).getOptions();
    assertEquals(stringAtomicLongMap, options.getAllFields());
    assertEquals(stringAtomicLongMap, defaultInstanceForType.getAllFieldsRaw());
    assertEquals(stringAtomicLongMap, options.getAllFieldsRaw());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * SessionInfoProto, Map)} with {@code kvList}, {@code sessionInfo}, {@code keyTsLatestMaps}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardTelemetry(List,
   * TransportProtos.SessionInfoProto, Map)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardTelemetry(List, SessionInfoProto, Map) with 'kvList', 'sessionInfo', 'keyTsLatestMaps'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(List, TransportProtos.SessionInfoProto, Map)"
  })
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps9() {
    // Arrange
    when(lwM2mTransportContext.getTransportService())
        .thenThrow(new CodecException("An error occurred"));
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
                kvList, sessionInfo, new HashMap<>()));
    verify(lwM2mTransportContext).getTransportService();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong()}.
   *   <li>When {@link TreeMap#TreeMap()} {@code Key} is {@link AtomicLong#AtomicLong()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); given AtomicLong(); when TreeMap() 'Key' is AtomicLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_givenAtomicLong_whenTreeMapKeyIsAtomicLong() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);

    TreeMap<String, AtomicLong> keyTsLatestMap = new TreeMap<>();
    keyTsLatestMap.put("Key", new AtomicLong());

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, keyTsLatestMap, null);

    // Assert
    verify(keyValueProto).getKey();
    UnknownFieldSet unknownFields = actualToTsKvListResult.getUnknownFields();
    TsKvListProto defaultInstanceForType = actualToTsKvListResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); given DefaultInstance; then return AllFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_givenDefaultInstance_thenReturnAllFieldsSizeIsOne() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(
            kvList,
            new HashMap<>(),
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    List<KeyValueProto> kvList2 = actualToTsKvListResult.getKvList();
    assertEquals(1, kvList2.size());
    assertEquals(1, actualToTsKvListResult.getAllFields().size());
    assertEquals(2, actualToTsKvListResult.getSerializedSize());
    Descriptor expectedDescriptorForType = actualToTsKvListResult.getDescriptorForType();
    TsKvListProto defaultInstanceForType = actualToTsKvListResult.getDefaultInstanceForType();
    assertSame(expectedDescriptorForType, defaultInstanceForType.getDescriptorForType());
    KeyValueProto getResult = kvList2.get(0);
    KeyValueProto actualDefaultInstanceForType = getResult.getDefaultInstanceForType();
    assertSame(getResult, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Given DefaultInstance.
   *   <li>Then return KvList size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); given DefaultInstance; then return KvList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_givenDefaultInstance_thenReturnKvListSizeIsOne() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());

    // Act and Assert
    List<KeyValueProto> kvList2 =
        lwM2mTransportServerHelper.toTsKvList(kvList, new HashMap<>(), null).getKvList();
    assertEquals(1, kvList2.size());
    KeyValueProto getResult = kvList2.get(0);
    KeyValueProto actualDefaultInstanceForType = getResult.getDefaultInstanceForType();
    assertSame(getResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Given {@link TransportProtos.KeyValueProto} {@link
   *       TransportProtos.KeyValueProto#getKey()} return {@code Key}.
   *   <li>Then calls {@link TransportProtos.KeyValueProto#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); given KeyValueProto getKey() return 'Key'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_givenKeyValueProtoGetKeyReturnKey_thenCallsGetKey() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);

    // Act
    lwM2mTransportServerHelper.toTsKvList(kvList, new HashMap<>(), null);

    // Assert
    verify(keyValueProto).getKey();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Given {@link QueuedProducer} {@link QueuedProducer#incrementAndGet()} return one.
   *   <li>Then return Ts is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); given QueuedProducer incrementAndGet() return one; then return Ts is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_givenQueuedProducerIncrementAndGetReturnOne_thenReturnTsIsOne() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);

    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.incrementAndGet()).thenReturn(1L);
    when(queuedProducer.get()).thenReturn(Long.MAX_VALUE);

    TreeMap<String, AtomicLong> keyTsLatestMap = new TreeMap<>();
    keyTsLatestMap.put("Key", queuedProducer);

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, keyTsLatestMap, null);

    // Assert
    verify(queuedProducer).get();
    verify(queuedProducer).incrementAndGet();
    verify(keyValueProto).getKey();
    assertEquals(1L, actualToTsKvListResult.getTs());
    UnknownFieldSet unknownFields = actualToTsKvListResult.getUnknownFields();
    TsKvListProto defaultInstanceForType = actualToTsKvListResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Then return DefaultInstanceForType UnknownFields is UnknownFields.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); then return DefaultInstanceForType UnknownFields is UnknownFields")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_thenReturnDefaultInstanceForTypeUnknownFieldsIsUnknownFields() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, null, null);

    // Assert
    UnknownFieldSet unknownFields = actualToTsKvListResult.getUnknownFields();
    TsKvListProto defaultInstanceForType = actualToTsKvListResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName("Test toTsKvList(List, Map, Instant); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_thenThrowCodecException() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);

    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.get()).thenThrow(new CodecException("An error occurred"));

    TreeMap<String, AtomicLong> keyTsLatestMap = new TreeMap<>();
    keyTsLatestMap.put("Key", queuedProducer);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> lwM2mTransportServerHelper.toTsKvList(kvList, keyTsLatestMap, null));
    verify(queuedProducer).get();
    verify(keyValueProto).getKey();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return KvCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName("Test toTsKvList(List, Map, Instant); when ArrayList(); then return KvCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_whenArrayList_thenReturnKvCountIsZero() {
    // Arrange
    ArrayList<KeyValueProto> kvList = new ArrayList<>();

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, new HashMap<>(), null);

    // Assert
    assertEquals(0, actualToTsKvListResult.getKvCount());
    assertTrue(actualToTsKvListResult.getKvList().isEmpty());
    assertEquals(
        kvList, actualToTsKvListResult.getDescriptorForType().toProto().getReservedNameList());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return SerializedSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); when ArrayList(); then return SerializedSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_whenArrayList_thenReturnSerializedSizeIsZero() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());
    ArrayList<KeyValueProto> kvList = new ArrayList<>();

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(
            kvList,
            new HashMap<>(),
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    assertEquals(0, actualToTsKvListResult.getKvCount());
    assertEquals(0, actualToTsKvListResult.getSerializedSize());
    assertTrue(actualToTsKvListResult.getKvList().isEmpty());
    assertTrue(actualToTsKvListResult.getAllFields().isEmpty());
    assertEquals(
        kvList, actualToTsKvListResult.getDescriptorForType().toProto().getReservedNameList());
    TsKvListProto actualDefaultInstanceForType = actualToTsKvListResult.getDefaultInstanceForType();
    assertEquals(actualToTsKvListResult, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName("Test getTsByKey(String, Map, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.get()).thenThrow(new CodecException("An error occurred"));

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("Key", queuedProducer);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L));
    verify(queuedProducer).get();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong(long)} with forty-two.
   *   <li>Then {@link HashMap#HashMap()} {@code Key} is forty-three.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given AtomicLong(long) with forty-two; then HashMap() 'Key' is forty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenAtomicLongWithFortyTwo_thenHashMapKeyIsFortyThree() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("Key", new AtomicLong(42L));

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    AtomicLong getResult = keyTsLatestMap.get("Key");
    assertEquals(43L, getResult.get());
    assertEquals(43L, getResult.getAcquire());
    assertEquals(43L, getResult.getOpaque());
    assertEquals(43L, getResult.getPlain());
    assertEquals(43L, actualTsByKey);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong()}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@link AtomicLong#AtomicLong()}.
   *   <li>Then {@link HashMap#HashMap()} {@code Key} is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given AtomicLong(); when HashMap() 'Key' is AtomicLong(); then HashMap() 'Key' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenAtomicLong_whenHashMapKeyIsAtomicLong_thenHashMapKeyIsOne() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("Key", new AtomicLong());

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    AtomicLong getResult = keyTsLatestMap.get("Key");
    assertEquals(1L, getResult.get());
    assertEquals(1L, getResult.getAcquire());
    assertEquals(1L, getResult.getOpaque());
    assertEquals(1L, getResult.getPlain());
    assertEquals(1L, actualTsByKey);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link QueuedProducer} {@link QueuedProducer#get()} return one.
   *   <li>Then calls {@link QueuedProducer#incrementAndGet()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given QueuedProducer get() return one; then calls incrementAndGet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenQueuedProducerGetReturnOne_thenCallsIncrementAndGet() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.incrementAndGet()).thenThrow(new CodecException("An error occurred"));
    when(queuedProducer.get()).thenReturn(1L);

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("Key", queuedProducer);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L));
    verify(queuedProducer).get();
    verify(queuedProducer).incrementAndGet();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then {@link HashMap#HashMap()} {@code Key} is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName("Test getTsByKey(String, Map, long); when HashMap(); then HashMap() 'Key' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_whenHashMap_thenHashMapKeyIsOne() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    AtomicLong getResult = keyTsLatestMap.get("Key");
    assertEquals(1L, getResult.get());
    assertEquals(1L, getResult.getAcquire());
    assertEquals(1L, getResult.getOpaque());
    assertEquals(1L, getResult.getPlain());
    assertEquals(1L, actualTsByKey);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName("Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());
    AssertableSubscriberObservable<? super Object> child =
        AssertableSubscriberObservable.create(5L);
    QueuedProducer<Object> tsLatestAtomic = new QueuedProducer<>(child);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
    assertEquals(5L, tsLatestAtomic.getAcquire());
    assertEquals(5L, tsLatestAtomic.getOpaque());
    assertEquals(5L, tsLatestAtomic.getPlain());
    assertEquals(5L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName("Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically2() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());
    AssertableSubscriberObservable<? super Object> child =
        AssertableSubscriberObservable.create(5L);
    QueuedProducer<Object> tsLatestAtomic = new QueuedProducer<>(child, new LinkedList<>());

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
    assertEquals(5L, tsLatestAtomic.getAcquire());
    assertEquals(5L, tsLatestAtomic.getOpaque());
    assertEquals(5L, tsLatestAtomic.getPlain());
    assertEquals(5L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>Given five.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); given five; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_givenFive_thenThrowCodecException() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());

    QueuedProducer<Object> tsLatestAtomic = mock(QueuedProducer.class);
    when(tsLatestAtomic.incrementAndGet()).thenThrow(new CodecException("An error occurred"));
    when(tsLatestAtomic.get()).thenReturn(5L);

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L));
    verify(tsLatestAtomic).get();
    verify(tsLatestAtomic).incrementAndGet();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>Then {@link AtomicLong#AtomicLong(long)} with forty-two is forty-three.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); then AtomicLong(long) with forty-two is forty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_thenAtomicLongWithFortyTwoIsFortyThree() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());
    AtomicLong tsLatestAtomic = new AtomicLong(42L);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(43L, tsLatestAtomic.get());
    assertEquals(43L, tsLatestAtomic.getAcquire());
    assertEquals(43L, tsLatestAtomic.getOpaque());
    assertEquals(43L, tsLatestAtomic.getPlain());
    assertEquals(43L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong,
   * long)}.
   *
   * <ul>
   *   <li>When {@link AtomicLong#AtomicLong()}.
   *   <li>Then {@link AtomicLong#AtomicLong()} is five.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); when AtomicLong(); then AtomicLong() is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_whenAtomicLong_thenAtomicLongIsFive() {
    // Arrange
    LwM2mTransportServerHelper lwM2mTransportServerHelper =
        new LwM2mTransportServerHelper(new LwM2mTransportContext());
    AtomicLong tsLatestAtomic = new AtomicLong();

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
    assertEquals(5L, tsLatestAtomic.getAcquire());
    assertEquals(5L, tsLatestAtomic.getOpaque());
    assertEquals(5L, tsLatestAtomic.getPlain());
    assertEquals(5L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
  }

  /**
   * Test {@link
   * LwM2mTransportServerHelper#getValidateSessionInfo(ValidateDeviceCredentialsResponse, long,
   * long)}.
   *
   * <ul>
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValidateSessionInfo(ValidateDeviceCredentialsResponse, long,
   * long)}
   */
  @Test
  @DisplayName(
      "Test getValidateSessionInfo(ValidateDeviceCredentialsResponse, long, long); then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto LwM2mTransportServerHelper.getValidateSessionInfo(ValidateDeviceCredentialsResponse, long, long)"
  })
  void testGetValidateSessionInfo_thenThrowCodecException() {
    // Arrange
    when(lwM2mTransportContext.getNodeId()).thenThrow(new CodecException("An error occurred"));

    // Act and Assert
    assertThrows(
        CodecException.class,
        () -> lwM2mTransportServerHelper.getValidateSessionInfo(null, 1L, 1L));
    verify(lwM2mTransportContext).getNodeId();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}.
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[],
   * String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"
  })
  void testParseFromXmlToObjectModel() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .parseFromXmlToObjectModel("AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvStringtoThingsboard(String, String)}.
   *
   * <ul>
   *   <li>When {@code >}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvStringtoThingsboard(String,
   * String)}
   */
  @Test
  @DisplayName("Test getKvStringtoThingsboard(String, String); when '>'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LwM2mTransportServerHelper.getKvStringtoThingsboard(String, String)"})
  void testGetKvStringtoThingsboard_whenGreaterThanSign_thenReturnSizeIsOne() {
    // Arrange and Act
    List<KeyValueProto> actualKvStringtoThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvStringtoThingsboard("Key", ">");

    // Assert
    assertEquals(1, actualKvStringtoThingsboard.size());
    KeyValueProto getResult = actualKvStringtoThingsboard.get(0);
    UnknownFieldSet unknownFields = getResult.getUnknownFields();
    KeyValueProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvStringtoThingsboard(String, String)}.
   *
   * <ul>
   *   <li>When {@code <}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvStringtoThingsboard(String,
   * String)}
   */
  @Test
  @DisplayName("Test getKvStringtoThingsboard(String, String); when '<'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LwM2mTransportServerHelper.getKvStringtoThingsboard(String, String)"})
  void testGetKvStringtoThingsboard_whenLessThanSign_thenReturnSizeIsOne() {
    // Arrange and Act
    List<KeyValueProto> actualKvStringtoThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvStringtoThingsboard("Key", "<");

    // Assert
    assertEquals(1, actualKvStringtoThingsboard.size());
    KeyValueProto getResult = actualKvStringtoThingsboard.get(0);
    UnknownFieldSet unknownFields = getResult.getUnknownFields();
    KeyValueProto defaultInstanceForType = getResult.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type, String, Object,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object,
   * boolean)}
   */
  @Test
  @DisplayName("Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvAttrTelemetryToThingsboard(Type.NONE, "Resource Name", "Value", true);

    // Assert
    ByteString stringVBytes = actualKvAttrTelemetryToThingsboard.getStringVBytes();
    assertEquals("", stringVBytes.toStringUtf8());
    ByteString jsonVBytes = actualKvAttrTelemetryToThingsboard.getJsonVBytes();
    assertEquals("Value", jsonVBytes.toStringUtf8());
    assertEquals("Value", actualKvAttrTelemetryToThingsboard.getJsonV());
    assertEquals(24, actualKvAttrTelemetryToThingsboard.getSerializedSize());
    assertEquals(4, actualKvAttrTelemetryToThingsboard.getTypeValue());
    assertEquals(KeyValueType.JSON_V, actualKvAttrTelemetryToThingsboard.getType());
    assertFalse(jsonVBytes.isEmpty());
    assertFalse(stringVBytes.iterator().hasNext());
    assertTrue(stringVBytes.isEmpty());
    assertTrue(jsonVBytes.iterator().hasNext());
    KeyValueProto defaultInstanceForType =
        actualKvAttrTelemetryToThingsboard.getDefaultInstanceForType();
    assertEquals(stringVBytes, defaultInstanceForType.getJsonVBytes());
    assertEquals(stringVBytes, defaultInstanceForType.getKeyBytes());
    assertEquals(stringVBytes, defaultInstanceForType.getStringVBytes());
    UnknownFieldSet unknownFields = actualKvAttrTelemetryToThingsboard.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type, String, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return TypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when forty-two; then return TypeValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenFortyTwo_thenReturnTypeValueIsOne() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvAttrTelemetryToThingsboard(Type.INTEGER, "Resource Name", 42L, false);

    // Assert
    assertEquals(1, actualKvAttrTelemetryToThingsboard.getTypeValue());
    assertEquals(19, actualKvAttrTelemetryToThingsboard.getSerializedSize());
    assertEquals(42L, actualKvAttrTelemetryToThingsboard.getLongV());
    assertEquals(KeyValueType.LONG_V, actualKvAttrTelemetryToThingsboard.getType());
    UnknownFieldSet unknownFields = actualKvAttrTelemetryToThingsboard.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualKvAttrTelemetryToThingsboard.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type, String, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code NONE}.
   *   <li>Then return AllFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when 'NONE'; then return AllFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenNone_thenReturnAllFieldsSizeIsOne() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvAttrTelemetryToThingsboard(Type.NONE, "Resource Name", "42", false);

    // Assert
    assertEquals(1, actualKvAttrTelemetryToThingsboard.getAllFields().size());
    assertEquals(15, actualKvAttrTelemetryToThingsboard.getSerializedSize());
    UnknownFieldSet unknownFields = actualKvAttrTelemetryToThingsboard.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualKvAttrTelemetryToThingsboard.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type, String, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return DoubleV is ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when ten; then return DoubleV is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenTen_thenReturnDoubleVIsTen() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvAttrTelemetryToThingsboard(Type.FLOAT, "Resource Name", 10.0d, false);

    // Assert
    assertEquals(10.0d, actualKvAttrTelemetryToThingsboard.getDoubleV());
    assertEquals(2, actualKvAttrTelemetryToThingsboard.getTypeValue());
    assertEquals(26, actualKvAttrTelemetryToThingsboard.getSerializedSize());
    assertEquals(KeyValueType.DOUBLE_V, actualKvAttrTelemetryToThingsboard.getType());
    UnknownFieldSet unknownFields = actualKvAttrTelemetryToThingsboard.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualKvAttrTelemetryToThingsboard.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type, String, Object,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return SerializedSize is seventeen.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when 'true'; then return SerializedSize is seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(ResourceModel.Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenTrue_thenReturnSerializedSizeIsSeventeen() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        new LwM2mTransportServerHelper(new LwM2mTransportContext())
            .getKvAttrTelemetryToThingsboard(Type.BOOLEAN, "Resource Name", true, false);

    // Assert
    assertEquals(17, actualKvAttrTelemetryToThingsboard.getSerializedSize());
    assertEquals(2, actualKvAttrTelemetryToThingsboard.getAllFields().size());
    assertTrue(actualKvAttrTelemetryToThingsboard.getBoolV());
    UnknownFieldSet unknownFields = actualKvAttrTelemetryToThingsboard.getUnknownFields();
    KeyValueProto defaultInstanceForType =
        actualKvAttrTelemetryToThingsboard.getDefaultInstanceForType();
    assertSame(unknownFields, defaultInstanceForType.getUnknownFields());
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
    assertSame(
        defaultInstanceForType.getDefaultInstanceForType(),
        defaultInstanceForType.getDefaultInstanceForType());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code BOOLEAN}.
   *   <li>Then return {@code BOOLEAN}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'BOOLEAN'; then return 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenBoolean_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(
        Type.BOOLEAN,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.BOOLEAN, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code FLOAT}.
   *   <li>Then return {@code FLOAT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'FLOAT'; then return 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenFloat_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(
        Type.FLOAT,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.FLOAT, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code INTEGER}.
   *   <li>Then return {@code INTEGER}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'INTEGER'; then return 'INTEGER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenInteger_thenReturnInteger() {
    // Arrange, Act and Assert
    assertEquals(
        Type.INTEGER,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.INTEGER, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code NONE}.
   *   <li>Then throw {@link CodecException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'NONE'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenNone_thenThrowCodecException() {
    // Arrange, Act and Assert
    assertThrows(
        CodecException.class,
        () ->
            LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
                Type.NONE, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type,
   * String)}.
   *
   * <ul>
   *   <li>When {@code STRING}.
   *   <li>Then return {@code STRING}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'STRING'; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResourceModel.Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(ResourceModel.Type, String)"
  })
  void testGetResourceModelTypeEqualsKvProtoValueType_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(
        Type.STRING,
        LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(
            Type.STRING, "Resource Path"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getBoolV()).thenThrow(new CodecException("An error occurred"));
    when(kv.getType()).thenReturn(KeyValueType.BOOLEAN_V);

    // Act and Assert
    assertThrows(CodecException.class, () -> LwM2mTransportServerHelper.getValueFromKvProto(kv));
    verify(kv).getBoolV();
    verify(kv).getType();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto2() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getLongV()).thenThrow(new CodecException("An error occurred"));
    when(kv.getType()).thenReturn(KeyValueType.LONG_V);

    // Act and Assert
    assertThrows(CodecException.class, () -> LwM2mTransportServerHelper.getValueFromKvProto(kv));
    verify(kv).getLongV();
    verify(kv).getType();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto3() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getDoubleV()).thenThrow(new CodecException("An error occurred"));
    when(kv.getType()).thenReturn(KeyValueType.DOUBLE_V);

    // Act and Assert
    assertThrows(CodecException.class, () -> LwM2mTransportServerHelper.getValueFromKvProto(kv));
    verify(kv).getDoubleV();
    verify(kv).getType();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto4() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getStringV()).thenThrow(new CodecException("An error occurred"));
    when(kv.getType()).thenReturn(KeyValueType.STRING_V);

    // Act and Assert
    assertThrows(CodecException.class, () -> LwM2mTransportServerHelper.getValueFromKvProto(kv));
    verify(kv).getStringV();
    verify(kv).getType();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto5() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getJsonV()).thenThrow(new CodecException("An error occurred"));
    when(kv.getType()).thenReturn(KeyValueType.JSON_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getJsonV();
    verify(kv).getType();
    assertNull(actualValueFromKvProto);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return AsString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given '42'; then return AsString is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_given42_thenReturnAsStringIs42() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getJsonV()).thenReturn("42");
    when(kv.getType()).thenReturn(KeyValueType.JSON_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getJsonV();
    verify(kv).getType();
    assertTrue(actualValueFromKvProto instanceof JsonPrimitive);
    assertEquals("42", ((JsonPrimitive) actualValueFromKvProto).getAsString());
    assertEquals('4', ((JsonPrimitive) actualValueFromKvProto).getAsCharacter());
    assertEquals(42, ((JsonPrimitive) actualValueFromKvProto).getAsInt());
    assertEquals(42.0d, ((JsonPrimitive) actualValueFromKvProto).getAsDouble());
    assertEquals(42.0f, ((JsonPrimitive) actualValueFromKvProto).getAsFloat());
    assertEquals(42L, ((JsonPrimitive) actualValueFromKvProto).getAsLong());
    assertEquals((short) 42, ((JsonPrimitive) actualValueFromKvProto).getAsShort());
    assertFalse(((JsonPrimitive) actualValueFromKvProto).isString());
    assertTrue(((JsonPrimitive) actualValueFromKvProto).isNumber());
    assertEquals(new BigDecimal("42"), ((JsonPrimitive) actualValueFromKvProto).getAsBigDecimal());
    assertEquals('*', ((JsonPrimitive) actualValueFromKvProto).getAsByte());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then return {@link JsonNull}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given empty string; then return JsonNull")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenEmptyString_thenReturnJsonNull() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getJsonV()).thenReturn("");
    when(kv.getType()).thenReturn(KeyValueType.JSON_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getJsonV();
    verify(kv).getType();
    assertTrue(actualValueFromKvProto instanceof JsonNull);
    assertFalse(((JsonNull) actualValueFromKvProto).isJsonPrimitive());
    assertTrue(((JsonNull) actualValueFromKvProto).isJsonNull());
    assertSame(
        ((JsonNull) actualValueFromKvProto).INSTANCE,
        ((JsonNull) actualValueFromKvProto).getAsJsonNull());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then AsNumber return {@link LazilyParsedNumber}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName(
      "Test getValueFromKvProto(KeyValueProto); given 'foo'; then AsNumber return LazilyParsedNumber")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenFoo_thenAsNumberReturnLazilyParsedNumber() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getJsonV()).thenReturn("foo");
    when(kv.getType()).thenReturn(KeyValueType.JSON_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getJsonV();
    verify(kv).getType();
    assertTrue(actualValueFromKvProto instanceof JsonPrimitive);
    Number asNumber = ((JsonPrimitive) actualValueFromKvProto).getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("foo", ((JsonPrimitive) actualValueFromKvProto).getAsString());
    assertEquals("foo", asNumber.toString());
    assertEquals('f', ((JsonPrimitive) actualValueFromKvProto).getAsCharacter());
    assertFalse(((JsonPrimitive) actualValueFromKvProto).isNumber());
    assertTrue(((JsonPrimitive) actualValueFromKvProto).isString());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given {@code Json V}.
   *   <li>When {@link TransportProtos.KeyValueProto} {@link
   *       TransportProtos.KeyValueProto#getJsonV()} return {@code Json V}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName(
      "Test getValueFromKvProto(KeyValueProto); given 'Json V'; when KeyValueProto getJsonV() return 'Json V'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenJsonV_whenKeyValueProtoGetJsonVReturnJsonV() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getJsonV()).thenReturn("Json V");
    when(kv.getType()).thenReturn(KeyValueType.JSON_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getJsonV();
    verify(kv).getType();
    assertNull(actualValueFromKvProto);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenOne_thenReturnLongValueIsOne() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getLongV()).thenReturn(1L);
    when(kv.getType()).thenReturn(KeyValueType.LONG_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getLongV();
    verify(kv).getType();
    assertEquals(1L, ((Long) actualValueFromKvProto).longValue());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given {@code String V}.
   *   <li>Then return {@code String V}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given 'String V'; then return 'String V'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenStringV_thenReturnStringV() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getStringV()).thenReturn("String V");
    when(kv.getType()).thenReturn(KeyValueType.STRING_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getStringV();
    verify(kv).getType();
    assertEquals("String V", actualValueFromKvProto);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenTen_thenReturnDoubleValueIsTen() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getDoubleV()).thenReturn(10.0d);
    when(kv.getType()).thenReturn(KeyValueType.DOUBLE_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getDoubleV();
    verify(kv).getType();
    assertEquals(10.0d, ((Double) actualValueFromKvProto).doubleValue());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenTrue_thenReturnTrue() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getBoolV()).thenReturn(true);
    when(kv.getType()).thenReturn(KeyValueType.BOOLEAN_V);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getBoolV();
    verify(kv).getType();
    assertTrue((Boolean) actualValueFromKvProto);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>Given {@code UNRECOGNIZED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); given 'UNRECOGNIZED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_givenUnrecognized() {
    // Arrange
    KeyValueProto kv = mock(KeyValueProto.class);
    when(kv.getType()).thenReturn(KeyValueType.UNRECOGNIZED);

    // Act
    Object actualValueFromKvProto = LwM2mTransportServerHelper.getValueFromKvProto(kv);

    // Assert
    verify(kv).getType();
    assertNull(actualValueFromKvProto);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getValueFromKvProto(KeyValueProto)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#getValueFromKvProto(TransportProtos.KeyValueProto)}
   */
  @Test
  @DisplayName("Test getValueFromKvProto(KeyValueProto); when DefaultInstance; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object LwM2mTransportServerHelper.getValueFromKvProto(TransportProtos.KeyValueProto)"
  })
  void testGetValueFromKvProto_whenDefaultInstance_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        (Boolean)
            LwM2mTransportServerHelper.getValueFromKvProto(KeyValueProto.getDefaultInstance()));
  }
}
