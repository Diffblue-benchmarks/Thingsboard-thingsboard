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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
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
   * Test {@link HashPartitionService#removeQueues(List)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(ApplicationEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#removeQueues(List)}
   */
  @Test
  @DisplayName("Test removeQueues(List); then calls publishEvent(ApplicationEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashPartitionService.removeQueues(List)"})
  void testRemoveQueues_thenCallsPublishEvent() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    doThrow(new RuntimeException())
        .when(applicationEventPublisher)
        .publishEvent(Mockito.<ApplicationEvent>any());
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService hashPartitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    // Act
    hashPartitionService.removeQueues(new ArrayList<>());

    // Assert
    verify(applicationEventPublisher).publishEvent(isA(ApplicationEvent.class));
    verify(serviceInfoProvider).isService(ServiceType.TB_RULE_ENGINE);
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, String, TenantId, EntityId)} with {@code
   * serviceType}, {@code queueName}, {@code tenantId}, {@code entityId}.
   *
   * <p>Method under test: {@link HashPartitionService#resolve(ServiceType, String, TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test resolve(ServiceType, String, TenantId, EntityId) with 'serviceType', 'queueName', 'tenantId', 'entityId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.queue.TopicPartitionInfo HashPartitionService.resolve(ServiceType, String, TenantId, EntityId)"
  })
  void testResolveWithServiceTypeQueueNameTenantIdEntityId() {
    // Arrange
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        TenantNotFoundException.class,
        () ->
            hashPartitionService.resolve(
                ServiceType.TB_CORE, "Queue Name", new TenantId(UUID.randomUUID()), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)} with {@code
   * serviceType}, {@code tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.msg.queue.TopicPartitionInfo HashPartitionService.resolve(ServiceType, TenantId, EntityId)"
  })
  void testResolveWithServiceTypeTenantIdEntityId_thenThrowIllegalStateException() {
    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    TenantRoutingInfo tenantRoutingInfo =
        new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true);
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
        () -> hashPartitionService.resolve(null, new TenantId(UUID.randomUUID()), null));
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
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        TenantNotFoundException.class,
        () ->
            hashPartitionService.resolve(
                ServiceType.TB_CORE, new TenantId(UUID.randomUUID()), null));
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}.
   *
   * <ul>
   *   <li>Given {@link ByteString} {@link ByteString#isValidUtf8()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#recalculatePartitions(ServiceInfo, List)}
   */
  @Test
  @DisplayName(
      "Test recalculatePartitions(ServiceInfo, List); given ByteString isValidUtf8() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HashPartitionService.recalculatePartitions(ServiceInfo, List)"})
  void testRecalculatePartitions_givenByteStringIsValidUtf8ReturnTrue() {
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

    LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
    lazyStringArrayList.add(element);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(lazyStringArrayList);
    when(currentService.getServiceTypesList()).thenReturn(LazyStringArrayList.emptyList());
    when(currentService.getServiceId()).thenReturn("42");

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(element).isValidUtf8();
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
    when(tbServiceInfoProvider.isService(Mockito.<ServiceType>any())).thenReturn(true);

    ServiceInfo currentService = mock(ServiceInfo.class);
    when(currentService.getTransportsList()).thenReturn(LazyStringArrayList.emptyList());
    when(currentService.getServiceTypesList()).thenReturn(LazyStringArrayList.emptyList());
    when(currentService.getServiceId()).thenReturn("42");

    // Act
    hashPartitionService.recalculatePartitions(currentService, new ArrayList<>());

    // Assert
    verify(currentService).getServiceId();
    verify(currentService, atLeast(1)).getServiceTypesList();
    verify(currentService).getTransportsList();
    verify(tbServiceInfoProvider).isService(ServiceType.TB_RULE_ENGINE);
  }

  /**
   * Test {@link HashPartitionService#getOtherServices(ServiceType)}.
   *
   * <p>Method under test: {@link HashPartitionService#getOtherServices(ServiceType)}
   */
  @Test
  @DisplayName("Test getOtherServices(ServiceType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set HashPartitionService.getOtherServices(ServiceType)"})
  void testGetOtherServices() {
    // Arrange, Act and Assert
    assertTrue(hashPartitionService.getOtherServices(ServiceType.TB_CORE).isEmpty());
  }

  /**
   * Test {@link HashPartitionService#forName(String)}.
   *
   * <ul>
   *   <li>When {@code murmur3_32}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'murmur3_32'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.google.common.hash.HashFunction HashPartitionService.forName(String)"})
  void testForName_whenMurmur332_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> HashPartitionService.forName("murmur3_32"));
  }

  /**
   * Test {@link HashPartitionService#forName(String)}.
   *
   * <ul>
   *   <li>When {@code sha256}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'sha256'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"com.google.common.hash.HashFunction HashPartitionService.forName(String)"})
  void testForName_whenSha256_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> HashPartitionService.forName("sha256"));
  }
}
