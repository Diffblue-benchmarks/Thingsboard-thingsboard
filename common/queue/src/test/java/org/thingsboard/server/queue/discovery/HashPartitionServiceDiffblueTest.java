package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.ByteString;
import com.google.protobuf.LazyStringArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.exception.TenantNotFoundException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ServiceInfo;
import org.thingsboard.server.queue.discovery.HashPartitionService.QueueConfig;

@ContextConfiguration(classes = {HashPartitionService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class HashPartitionServiceDiffblueTest {
  @Autowired private HashPartitionService hashPartitionService;

  @MockBean private QueueRoutingInfoService queueRoutingInfoService;

  @MockBean private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean private TenantRoutingInfoService tenantRoutingInfoService;

  @MockBean private TopicService topicService;

  /**
   * Test {@link HashPartitionService#getMyPartitions(QueueKey)}.
   *
   * <ul>
   *   <li>When {@link QueueKey#QueueKey(ServiceType, Queue)} with type is {@code TB_CORE} and queue
   *       is {@link Queue#Queue()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#getMyPartitions(QueueKey)}
   */
  @Test
  @DisplayName(
      "Test getMyPartitions(QueueKey); when QueueKey(ServiceType, Queue) with type is 'TB_CORE' and queue is Queue(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List HashPartitionService.getMyPartitions(QueueKey)"})
  void testGetMyPartitions_whenQueueKeyWithTypeIsTbCoreAndQueueIsQueue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        hashPartitionService.getMyPartitions(new QueueKey(ServiceType.TB_CORE, new Queue())));
  }

  /**
   * Test QueueConfig getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueConfig#setDuplicateMsgToAllPartitions(boolean)}
   *   <li>{@link QueueConfig#toString()}
   *   <li>{@link QueueConfig#isDuplicateMsgToAllPartitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean QueueConfig.isDuplicateMsgToAllPartitions()",
    "void QueueConfig.setDuplicateMsgToAllPartitions(boolean)",
    "String QueueConfig.toString()"
  })
  void testQueueConfigGettersAndSetters() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act
    queueConfig.setDuplicateMsgToAllPartitions(true);
    String actualToStringResult = queueConfig.toString();

    // Assert
    assertEquals(
        "HashPartitionService.QueueConfig(duplicateMsgToAllPartitions=true)", actualToStringResult);
    assertTrue(queueConfig.isDuplicateMsgToAllPartitions());
  }

  /**
   * Test QueueConfig {@link QueueConfig#QueueConfig(QueueRoutingInfo)}.
   *
   * <ul>
   *   <li>Then return not DuplicateMsgToAllPartitions.
   * </ul>
   *
   * <p>Method under test: {@link QueueConfig#QueueConfig(QueueRoutingInfo)}
   */
  @Test
  @DisplayName(
      "Test QueueConfig new QueueConfig(QueueRoutingInfo); then return not DuplicateMsgToAllPartitions")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueConfig.<init>(QueueRoutingInfo)"})
  void testQueueConfigNewQueueConfig_thenReturnNotDuplicateMsgToAllPartitions() {
    // Arrange, Act and Assert
    assertFalse(new QueueConfig(new QueueRoutingInfo(new Queue())).isDuplicateMsgToAllPartitions());
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)} with {@code
   * serviceType}, {@code tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.queue.TopicPartitionInfo HashPartitionService.resolve(ServiceType, TenantId, EntityId)"
  })
  void testResolveWithServiceTypeTenantIdEntityId_thenThrowRuntimeException() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = mock(TenantRoutingInfo.class);
    when(tenantRoutingInfo.isIsolated()).thenThrow(new RuntimeException());

    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any()))
        .thenReturn(tenantRoutingInfo);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            hashPartitionService.resolve(
                ServiceType.TB_RULE_ENGINE,
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null));
    verify(tenantRoutingInfo).isIsolated();
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)} with {@code
   * serviceType}, {@code tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then throw {@link TenantNotFoundException}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then throw TenantNotFoundException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.queue.TopicPartitionInfo HashPartitionService.resolve(ServiceType, TenantId, EntityId)"
  })
  void testResolveWithServiceTypeTenantIdEntityId_thenThrowTenantNotFoundException() {
    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    // Act and Assert
    assertThrows(
        TenantNotFoundException.class,
        () ->
            hashPartitionService.resolve(
                ServiceType.TB_CORE,
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#resolveAll(ServiceType, String, TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#resolveAll(ServiceType, String, TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test resolveAll(ServiceType, String, TenantId, EntityId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List HashPartitionService.resolveAll(ServiceType, String, TenantId, EntityId)"
  })
  void testResolveAll_thenThrowRuntimeException() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = mock(TenantRoutingInfo.class);
    when(tenantRoutingInfo.isIsolated()).thenThrow(new RuntimeException());

    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any()))
        .thenReturn(tenantRoutingInfo);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            hashPartitionService.resolveAll(
                ServiceType.TB_RULE_ENGINE,
                "Queue Name",
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null));
    verify(tenantRoutingInfo).isIsolated();
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#isMyPartition(ServiceType, TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link TenantRoutingInfoService} {@link
   *       TenantRoutingInfoService#getRoutingInfo(TenantId)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#isMyPartition(ServiceType, TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test isMyPartition(ServiceType, TenantId, EntityId); given TenantRoutingInfoService getRoutingInfo(TenantId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HashPartitionService.isMyPartition(ServiceType, TenantId, EntityId)"})
  void testIsMyPartition_givenTenantRoutingInfoServiceGetRoutingInfoReturnNull() {
    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    // Act
    boolean actualIsMyPartitionResult =
        hashPartitionService.isMyPartition(
            ServiceType.TB_CORE,
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            null);

    // Assert
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
    assertFalse(actualIsMyPartitionResult);
  }

  /**
   * Test {@link HashPartitionService#isMyPartition(ServiceType, TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#isMyPartition(ServiceType, TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test isMyPartition(ServiceType, TenantId, EntityId); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HashPartitionService.isMyPartition(ServiceType, TenantId, EntityId)"})
  void testIsMyPartition_thenThrowIllegalStateException() {
    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, null, true);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any()))
        .thenReturn(tenantRoutingInfo);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            hashPartitionService.isMyPartition(
                null, new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ByteString#isValidUtf8()}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}
   */
  @Test
  @DisplayName("Test recalculatePartitions(ServiceInfo, List); then calls isValidUtf8()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashPartitionService.recalculatePartitions(ServiceInfo, List)"})
  void testRecalculatePartitions_thenCallsIsValidUtf8() {
    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(applicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    ByteString element = mock(ByteString.class);
    when(element.isValidUtf8()).thenReturn(true);
    when(element.toStringUtf8()).thenReturn("String Utf8");

    ByteString element2 = mock(ByteString.class);
    when(element2.isValidUtf8()).thenReturn(true);
    when(element2.toStringUtf8()).thenReturn("String Utf8");

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element2);
    lazyStringArrayList.add(element);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(lazyStringArrayList);
    when(currentService.getServiceTypesList()).thenReturn(LazyStringArrayList.emptyList());
    when(currentService.getServiceId()).thenReturn("42");

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(element2).isValidUtf8();
    verify(element).isValidUtf8();
    verify(element2).toStringUtf8();
    verify(element).toStringUtf8();
    verify(applicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(currentService).getServiceId();
    verify(currentService, atLeast(1)).getServiceTypesList();
    verify(currentService).getTransportsList();
    verify(serviceInfoProvider).isService(ServiceType.TB_RULE_ENGINE);
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   *
   * <ul>
   *   <li>When {@link ServiceInfo} {@link ServiceInfo#getTransportsList()} return emptyList.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}
   */
  @Test
  @DisplayName(
      "Test recalculatePartitions(ServiceInfo, List); when ServiceInfo getTransportsList() return emptyList")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashPartitionService.recalculatePartitions(ServiceInfo, List)"})
  void testRecalculatePartitions_whenServiceInfoGetTransportsListReturnEmptyList() {
    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(applicationEventPublisher).publishEvent(Mockito.<ApplicationEvent>any());
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(LazyStringArrayList.emptyList());
    when(currentService.getServiceTypesList()).thenReturn(LazyStringArrayList.emptyList());
    when(currentService.getServiceId()).thenReturn("42");

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(applicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(currentService).getServiceId();
    verify(currentService, atLeast(1)).getServiceTypesList();
    verify(currentService).getTransportsList();
    verify(serviceInfoProvider).isService(ServiceType.TB_RULE_ENGINE);
  }

  /**
   * Test {@link HashPartitionService#resolvePartitionIndex(UUID, int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#resolvePartitionIndex(UUID, int)}
   */
  @Test
  @DisplayName("Test resolvePartitionIndex(UUID, int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int HashPartitionService.resolvePartitionIndex(UUID, int)"})
  void testResolvePartitionIndex_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        hashPartitionService.resolvePartitionIndex(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }
}
