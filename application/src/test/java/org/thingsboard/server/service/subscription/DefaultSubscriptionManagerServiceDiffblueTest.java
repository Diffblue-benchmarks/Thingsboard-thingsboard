package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TbCallback;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusProducerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.service.queue.TbPackCallback;
import org.thingsboard.server.service.queue.TbPackProcessingContext;
import org.thingsboard.server.service.state.DeviceStateService;

class DefaultSubscriptionManagerServiceDiffblueTest {
  /**
   * Test {@link DefaultSubscriptionManagerService#initExecutor()}.
   * <ul>
   *   <li>Then calls
   * {@link SubscriptionSchedulerComponent#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSubscriptionManagerService#initExecutor()}
   */
  @Test
  @DisplayName("Test initExecutor(); then calls scheduleWithFixedDelay(Runnable, long, long, TimeUnit)")
  void testInitExecutor_thenCallsScheduleWithFixedDelay() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    TbQueueProducerProvider producerProvider = mock(TbQueueProducerProvider.class);
    when(producerProvider.getTbCoreNotificationsMsgProducer())
        .thenReturn(new TbServiceBusProducerTemplate<>(null, new TbServiceBusSettings(), "Default Topic"));
    SubscriptionSchedulerComponent scheduler = mock(SubscriptionSchedulerComponent.class);
    Mockito
        .<ScheduledFuture<?>>when(
            scheduler.scheduleWithFixedDelay(Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    (new DefaultSubscriptionManagerService(mock(TopicService.class), mock(PartitionService.class), serviceInfoProvider,
        producerProvider, mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), scheduler)).initExecutor();

    // Assert
    verify(serviceInfoProvider).getServiceId();
    verify(producerProvider).getTbCoreNotificationsMsgProducer();
    verify(scheduler).scheduleWithFixedDelay(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.HOURS));
  }

  /**
   * Test {@link DefaultSubscriptionManagerService#initExecutor()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSubscriptionManagerService#initExecutor()}
   */
  @Test
  @DisplayName("Test initExecutor(); then throw RuntimeException")
  void testInitExecutor_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    TbQueueProducerProvider producerProvider = mock(TbQueueProducerProvider.class);
    when(producerProvider.getTbCoreNotificationsMsgProducer()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultSubscriptionManagerService(mock(TopicService.class), mock(PartitionService.class),
            serviceInfoProvider, producerProvider, mock(TbLocalSubscriptionService.class),
            mock(DeviceStateService.class), mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class)))
            .initExecutor());
    verify(serviceInfoProvider).getServiceId();
    verify(producerProvider).getTbCoreNotificationsMsgProducer();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onSubEvent(String, TbEntitySubEvent, TbCallback)}.
   * <ul>
   *   <li>Then calls {@link TopicPartitionInfoBuilder#myPartition(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onSubEvent(String, TbEntitySubEvent, TbCallback)}
   */
  @Test
  @DisplayName("Test onSubEvent(String, TbEntitySubEvent, TbCallback); then calls myPartition(boolean)")
  void testOnSubEvent_thenCallsMyPartition() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), partitionService, mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbEntitySubEvent event = new TbEntitySubEvent(tenantId, null, ComponentLifecycleEvent.CREATED,
        new TbSubscriptionsInfo(), 10);

    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultSubscriptionManagerService.onSubEvent("42", event, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onTimeSeriesDelete(TenantId, EntityId, List, TbCallback)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onTimeSeriesDelete(TenantId, EntityId, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onTimeSeriesDelete(TenantId, EntityId, List, TbCallback); given 'foo'; when ArrayList() add 'foo'; then throw RuntimeException")
  void testOnTimeSeriesDelete_givenFoo_whenArrayListAddFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");
    keys.add("[{}] No time-series subscriptions for entity.");
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onTimeSeriesDelete(tenantId, entityId, keys, new TbPackCallback<>(id,
            new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onTimeSeriesDelete(TenantId, EntityId, List, TbCallback)}.
   * <ul>
   *   <li>Given {@code [{}] No time-series subscriptions for entity.}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onTimeSeriesDelete(TenantId, EntityId, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onTimeSeriesDelete(TenantId, EntityId, List, TbCallback); given '[{}] No time-series subscriptions for entity.'")
  void testOnTimeSeriesDelete_givenNoTimeSeriesSubscriptionsForEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("[{}] No time-series subscriptions for entity.");
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onTimeSeriesDelete(tenantId, entityId, keys, new TbPackCallback<>(id,
            new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onTimeSeriesDelete(TenantId, EntityId, List, TbCallback)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onTimeSeriesDelete(TenantId, EntityId, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onTimeSeriesDelete(TenantId, EntityId, List, TbCallback); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testOnTimeSeriesDelete_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));
    ArrayList<String> keys = new ArrayList<>();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onTimeSeriesDelete(tenantId, entityId, keys, new TbPackCallback<>(id,
            new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, TbCallback)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributes},
   * {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(TenantId, EntityId, String, List, TbCallback) with 'tenantId', 'entityId', 'scope', 'attributes', 'callback'")
  void testOnAttributesUpdateWithTenantIdEntityIdScopeAttributesCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));
    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesUpdate(tenantId, entityId, "Scope", attributes,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, TbCallback)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributes},
   * {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(TenantId, EntityId, String, List, TbCallback) with 'tenantId', 'entityId', 'scope', 'attributes', 'callback'")
  void testOnAttributesUpdateWithTenantIdEntityIdScopeAttributesCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes
        .add(new BaseAttributeKvEntry(1L, new JsonDataEntry("[{}] No attributes subscriptions for entity.", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesUpdate(tenantId, entityId, "Scope", attributes,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, TbCallback)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributes},
   * {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(TenantId, EntityId, String, List, TbCallback) with 'tenantId', 'entityId', 'scope', 'attributes', 'callback'")
  void testOnAttributesUpdateWithTenantIdEntityIdScopeAttributesCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes
        .add(new BaseAttributeKvEntry(1L, new JsonDataEntry("[{}] No attributes subscriptions for entity.", "42")));
    attributes
        .add(new BaseAttributeKvEntry(1L, new JsonDataEntry("[{}] No attributes subscriptions for entity.", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesUpdate(tenantId, entityId, "Scope", attributes,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributes},
   * {@code notifyDevice}, {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback) with 'tenantId', 'entityId', 'scope', 'attributes', 'notifyDevice', 'callback'")
  void testOnAttributesUpdateWithTenantIdEntityIdScopeAttributesNotifyDeviceCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));
    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesUpdate(tenantId, entityId, "Scope", attributes, true,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributes},
   * {@code notifyDevice}, {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback) with 'tenantId', 'entityId', 'scope', 'attributes', 'notifyDevice', 'callback'")
  void testOnAttributesUpdateWithTenantIdEntityIdScopeAttributesNotifyDeviceCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes
        .add(new BaseAttributeKvEntry(1L, new JsonDataEntry("[{}] No attributes subscriptions for entity.", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesUpdate(tenantId, entityId, "Scope", attributes, true,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback)}
   * with {@code tenantId}, {@code entityId}, {@code scope}, {@code attributes},
   * {@code notifyDevice}, {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(TenantId, EntityId, String, List, boolean, TbCallback) with 'tenantId', 'entityId', 'scope', 'attributes', 'notifyDevice', 'callback'")
  void testOnAttributesUpdateWithTenantIdEntityIdScopeAttributesNotifyDeviceCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes
        .add(new BaseAttributeKvEntry(1L, new JsonDataEntry("[{}] No attributes subscriptions for entity.", "42")));
    attributes
        .add(new BaseAttributeKvEntry(1L, new JsonDataEntry("[{}] No attributes subscriptions for entity.", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesUpdate(tenantId, entityId, "Scope", attributes, true,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback); given 'foo'; when ArrayList() add 'foo'; then throw RuntimeException")
  void testOnAttributesDelete_givenFoo_whenArrayListAddFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");
    keys.add("[{}] No attributes subscriptions for entity.");
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesDelete(tenantId, entityId, "Scope", keys, true,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback)}.
   * <ul>
   *   <li>Given {@code [{}] No attributes subscriptions for entity.}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback); given '[{}] No attributes subscriptions for entity.'")
  void testOnAttributesDelete_givenNoAttributesSubscriptionsForEntity() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("[{}] No attributes subscriptions for entity.");
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesDelete(tenantId, entityId, "Scope", keys, true,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultSubscriptionManagerService#onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSubscriptionManagerService#onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesDelete(TenantId, EntityId, String, List, boolean, TbCallback); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testOnAttributesDelete_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSubscriptionManagerService defaultSubscriptionManagerService = new DefaultSubscriptionManagerService(
        mock(TopicService.class), mock(PartitionService.class), mock(TbServiceInfoProvider.class),
        mock(TbQueueProducerProvider.class), mock(TbLocalSubscriptionService.class), mock(DeviceStateService.class),
        mock(TbClusterService.class), mock(SubscriptionSchedulerComponent.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new RuntimeException("foo"));
    ArrayList<String> keys = new ArrayList<>();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultSubscriptionManagerService.onAttributesDelete(tenantId, entityId, "Scope", keys, true,
            new TbPackCallback<>(id,
                new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(entityId).getEntityType();
  }
}
