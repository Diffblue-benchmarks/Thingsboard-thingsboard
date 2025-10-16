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
import org.thingsboard.server.common.transport.TransportService;
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
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(
        new ArrayList<>(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(lwM2mTransportContext).getTransportService();
    verify(rateLimitService)
        .checkLimits(isA(TenantId.class), isNull(), isA(DeviceId.class), eq(0), eq(false));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * SessionInfoProto)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTransportService#process(SessionInfoProto, PostAttributeMsg,
   *       TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#sendParametersOnThingsboardAttribute(List,
   * TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test sendParametersOnThingsboardAttribute(List, SessionInfoProto); then calls process(SessionInfoProto, PostAttributeMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(List, TransportProtos.SessionInfoProto)"
  })
  void testSendParametersOnThingsboardAttribute_thenCallsProcess2() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostAttributeMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardAttribute(
        new ArrayList<>(), SessionInfoProto.getDefaultInstance());

    // Assert
    verify(lwM2mTransportContext).getTransportService();
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
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
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
    verify(lwM2mTransportContext).getTransportService();
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
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs3() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
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
    verify(lwM2mTransportContext).getTransportService();
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
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs4() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(transportService);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, keyTsLatestMap, null);

    // Assert that nothing has changed
    verify(lwM2mTransportContext).getTransportService();
    verify(transportService)
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
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMapTs5() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(transportService);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>(), null);

    // Assert
    verify(lwM2mTransportContext).getTransportService();
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
    TransportService transportService = mock(TransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(transportService);

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>(), null);

    // Assert
    verify(lwM2mTransportContext).getTransportService();
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
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps() {
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
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>());

    // Assert that nothing has changed
    verify(notificationRuleProcessor).process(isA(NotificationRuleTrigger.class));
    verify(lwM2mTransportContext).getTransportService();
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
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps3() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(defaultTransportService);
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();
    HashMap<String, AtomicLong> keyTsLatestMaps = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, keyTsLatestMaps);

    // Assert that nothing has changed
    verify(lwM2mTransportContext).getTransportService();
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
  void testSendParametersOnThingsboardTelemetryWithKvListSessionInfoKeyTsLatestMaps4() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(transportService);

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(KeyValueProto.getDefaultInstance());
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(lwM2mTransportContext).getTransportService();
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
    TransportService transportService = mock(TransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    when(lwM2mTransportContext.getTransportService()).thenReturn(transportService);

    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);
    SessionInfoProto sessionInfo = SessionInfoProto.getDefaultInstance();

    // Act
    lwM2mTransportServerHelper.sendParametersOnThingsboardTelemetry(
        kvList, sessionInfo, new HashMap<>());

    // Assert
    verify(lwM2mTransportContext).getTransportService();
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
    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    KeyValueProto defaultInstance = KeyValueProto.getDefaultInstance();
    kvList.add(defaultInstance);

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, new HashMap<>(), null);

    // Assert
    List<KeyValueProto> kvList2 = actualToTsKvListResult.getKvList();
    assertEquals(1, kvList2.size());
    assertEquals(2, actualToTsKvListResult.getDescriptorForType().getFields().size());
    assertSame(defaultInstance, kvList2.get(0));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Then return AllFields size is two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName("Test toTsKvList(List, Map, Instant); then return AllFields size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_thenReturnAllFieldsSizeIsTwo() {
    // Arrange
    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);

    TreeMap<String, AtomicLong> keyTsLatestMap = new TreeMap<>();
    keyTsLatestMap.put("", new AtomicLong());

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, keyTsLatestMap, null);

    // Assert
    verify(keyValueProto).getKey();
    assertEquals(2, actualToTsKvListResult.getAllFields().size());
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
   *   <li>Then return DescriptorForType File MessageTypes size is one hundred eighty.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); then return DescriptorForType File MessageTypes size is one hundred eighty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_thenReturnDescriptorForTypeFileMessageTypesSizeIsOneHundredEighty() {
    // Arrange
    KeyValueProto keyValueProto = mock(KeyValueProto.class);
    when(keyValueProto.getKey()).thenReturn("Key");

    ArrayList<KeyValueProto> kvList = new ArrayList<>();
    kvList.add(keyValueProto);

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(kvList, new HashMap<>(), null);

    // Assert
    verify(keyValueProto).getKey();
    Descriptor descriptorForType = actualToTsKvListResult.getDescriptorForType();
    assertEquals(180, descriptorForType.getFile().getMessageTypes().size());
    assertEquals(2, descriptorForType.getFields().size());
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>Then return UnknownFields DefaultInstanceForType is UnknownFields.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); then return UnknownFields DefaultInstanceForType is UnknownFields")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_thenReturnUnknownFieldsDefaultInstanceForTypeIsUnknownFields() {
    // Arrange, Act and Assert
    UnknownFieldSet unknownFields =
        lwM2mTransportServerHelper.toTsKvList(new ArrayList<>(), null, null).getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}.
   *
   * <ul>
   *   <li>When {@link LocalDate} with {@code 1970} and one and one atStartOfDay atZone {@link
   *       ZoneOffset#UTC} toInstant.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#toTsKvList(List, Map, Instant)}
   */
  @Test
  @DisplayName(
      "Test toTsKvList(List, Map, Instant); when LocalDate with '1970' and one and one atStartOfDay atZone UTC toInstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.TsKvListProto LwM2mTransportServerHelper.toTsKvList(List, Map, Instant)"
  })
  void testToTsKvList_whenLocalDateWith1970AndOneAndOneAtStartOfDayAtZoneUtcToInstant() {
    // Arrange
    ArrayList<KeyValueProto> kvList = new ArrayList<>();

    // Act
    TsKvListProto actualToTsKvListResult =
        lwM2mTransportServerHelper.toTsKvList(
            kvList,
            new HashMap<>(),
            LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());

    // Assert
    TsKvListProto actualDefaultInstanceForType = actualToTsKvListResult.getDefaultInstanceForType();
    assertEquals(actualToTsKvListResult, actualDefaultInstanceForType);
    UnknownFieldSet unknownFields = actualToTsKvListResult.getUnknownFields();
    UnknownFieldSet actualDefaultInstanceForType2 = unknownFields.getDefaultInstanceForType();
    assertSame(unknownFields, actualDefaultInstanceForType2);
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
    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.get()).thenThrow(new CodecException("An error occurred"));

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", queuedProducer);

    // Act and Assert
    assertThrows(
        CodecException.class, () -> lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L));
    verify(queuedProducer).get();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong(long)} with one.
   *   <li>Then {@link HashMap#HashMap()} empty string is two.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given AtomicLong(long) with one; then HashMap() empty string is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenAtomicLongWithOne_thenHashMapEmptyStringIsTwo() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", new AtomicLong(1L));

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(2L, keyTsLatestMap.get("").get());
    assertEquals(2L, actualTsByKey);
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>Given {@link AtomicLong#AtomicLong()}.
   *   <li>Then {@link HashMap#HashMap()} empty string is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName(
      "Test getTsByKey(String, Map, long); given AtomicLong(); then HashMap() empty string is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_givenAtomicLong_thenHashMapEmptyStringIsOne() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", new AtomicLong());

    // Act
    long actualTsByKey = lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("").get());
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
    QueuedProducer<Object> queuedProducer = mock(QueuedProducer.class);
    when(queuedProducer.incrementAndGet()).thenThrow(new CodecException("An error occurred"));
    when(queuedProducer.get()).thenReturn(1L);

    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();
    keyTsLatestMap.put("", queuedProducer);

    // Act and Assert
    assertThrows(
        CodecException.class, () -> lwM2mTransportServerHelper.getTsByKey("", keyTsLatestMap, 1L));
    verify(queuedProducer).get();
    verify(queuedProducer).incrementAndGet();
  }

  /**
   * Test {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}.
   *
   * <ul>
   *   <li>When {@code Key}.
   *   <li>Then {@link HashMap#HashMap()} {@code Key} is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getTsByKey(String, Map, long)}
   */
  @Test
  @DisplayName("Test getTsByKey(String, Map, long); when 'Key'; then HashMap() 'Key' is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long LwM2mTransportServerHelper.getTsByKey(String, Map, long)"})
  void testGetTsByKey_whenKey_thenHashMapKeyIsOne() {
    // Arrange
    HashMap<String, AtomicLong> keyTsLatestMap = new HashMap<>();

    // Act
    lwM2mTransportServerHelper.getTsByKey("Key", keyTsLatestMap, 1L);

    // Assert
    assertEquals(1, keyTsLatestMap.size());
    assertEquals(1L, keyTsLatestMap.get("Key").get());
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
    AssertableSubscriberObservable<? super Object> child =
        AssertableSubscriberObservable.create(5L);
    QueuedProducer<Object> tsLatestAtomic = new QueuedProducer<>(child);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
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
    AssertableSubscriberObservable<? super Object> child =
        AssertableSubscriberObservable.create(5L);
    QueuedProducer<Object> tsLatestAtomic = new QueuedProducer<>(child, new LinkedList<>());

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
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
   *   <li>Then {@link AtomicLong#AtomicLong(long)} with five is six.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportServerHelper#compareAndSwapOrIncrementTsAtomically(AtomicLong, long)}
   */
  @Test
  @DisplayName(
      "Test compareAndSwapOrIncrementTsAtomically(AtomicLong, long); then AtomicLong(long) with five is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(AtomicLong, long)"
  })
  void testCompareAndSwapOrIncrementTsAtomically_thenAtomicLongWithFiveIsSix() {
    // Arrange
    AtomicLong tsLatestAtomic = new AtomicLong(5L);

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(6L, tsLatestAtomic.get());
    assertEquals(6L, actualCompareAndSwapOrIncrementTsAtomicallyResult);
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
    AtomicLong tsLatestAtomic = new AtomicLong();

    // Act
    long actualCompareAndSwapOrIncrementTsAtomicallyResult =
        lwM2mTransportServerHelper.compareAndSwapOrIncrementTsAtomically(tsLatestAtomic, 5L);

    // Assert
    assertEquals(5L, tsLatestAtomic.get());
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
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[],
   * String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String); when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"
  })
  void testParseFromXmlToObjectModel_whenA() {
    // Arrange, Act and Assert
    assertNull(
        lwM2mTransportServerHelper.parseFromXmlToObjectModel(
            new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "Stream Name"));
  }

  /**
   * Test {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[], String)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#parseFromXmlToObjectModel(byte[],
   * String)}
   */
  @Test
  @DisplayName("Test parseFromXmlToObjectModel(byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.eclipse.leshan.core.model.ObjectModel LwM2mTransportServerHelper.parseFromXmlToObjectModel(byte[], String)"
  })
  void testParseFromXmlToObjectModel_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertNull(
        lwM2mTransportServerHelper.parseFromXmlToObjectModel(
            "AXAXAXAX".getBytes("UTF-8"), "Stream Name"));
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
        lwM2mTransportServerHelper.getKvStringtoThingsboard("Key", ">");

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
        lwM2mTransportServerHelper.getKvStringtoThingsboard("Key", "<");

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
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type,
   * String, Object, boolean)}
   */
  @Test
  @DisplayName("Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        lwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(
            Type.NONE, "Resource Name", "Value", true);

    // Assert
    ByteString stringVBytes = actualKvAttrTelemetryToThingsboard.getStringVBytes();
    assertEquals("", stringVBytes.toStringUtf8());
    ByteString jsonVBytes = actualKvAttrTelemetryToThingsboard.getJsonVBytes();
    assertEquals("Value", jsonVBytes.toStringUtf8());
    assertEquals("Value", actualKvAttrTelemetryToThingsboard.getJsonV());
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
   *   <li>Then return StringVBytes toStringUtf8 is {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type,
   * String, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); then return StringVBytes toStringUtf8 is 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_thenReturnStringVBytesToStringUtf8IsValue() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        lwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(
            Type.STRING, "Resource Name", "Value", false);

    // Assert
    ByteString stringVBytes = actualKvAttrTelemetryToThingsboard.getStringVBytes();
    assertEquals("Value", stringVBytes.toStringUtf8());
    assertEquals("Value", actualKvAttrTelemetryToThingsboard.getStringV());
    assertEquals(3, actualKvAttrTelemetryToThingsboard.getTypeValue());
    assertEquals(KeyValueType.STRING_V, actualKvAttrTelemetryToThingsboard.getType());
    assertFalse(stringVBytes.isEmpty());
    assertTrue(stringVBytes.iterator().hasNext());
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
   *   <li>When forty-two.
   *   <li>Then return TypeValue is one.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type,
   * String, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when forty-two; then return TypeValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenFortyTwo_thenReturnTypeValueIsOne() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        lwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(
            Type.INTEGER, "Resource Name", 42L, false);

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
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type,
   * String, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when 'NONE'; then return AllFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenNone_thenReturnAllFieldsSizeIsOne() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        lwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(
            Type.NONE, "Resource Name", "Value", false);

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
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type,
   * String, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when ten; then return DoubleV is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenTen_thenReturnDoubleVIsTen() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        lwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(
            Type.FLOAT, "Resource Name", 10.0d, false);

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
   * <p>Method under test: {@link LwM2mTransportServerHelper#getKvAttrTelemetryToThingsboard(Type,
   * String, Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test getKvAttrTelemetryToThingsboard(Type, String, Object, boolean); when 'true'; then return SerializedSize is seventeen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.KeyValueProto LwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(Type, String, Object, boolean)"
  })
  void testGetKvAttrTelemetryToThingsboard_whenTrue_thenReturnSerializedSizeIsSeventeen() {
    // Arrange and Act
    KeyValueProto actualKvAttrTelemetryToThingsboard =
        lwM2mTransportServerHelper.getKvAttrTelemetryToThingsboard(
            Type.BOOLEAN, "Resource Name", true, false);

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
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'BOOLEAN'; then return 'BOOLEAN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
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
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'FLOAT'; then return 'FLOAT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
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
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'INTEGER'; then return 'INTEGER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
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
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'NONE'; then throw CodecException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
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
   * LwM2mTransportServerHelper#getResourceModelTypeEqualsKvProtoValueType(Type, String)}
   */
  @Test
  @DisplayName(
      "Test getResourceModelTypeEqualsKvProtoValueType(Type, String); when 'STRING'; then return 'STRING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Type LwM2mTransportServerHelper.getResourceModelTypeEqualsKvProtoValueType(Type, String)"
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
