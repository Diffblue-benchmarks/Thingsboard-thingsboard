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
package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;
import org.eclipse.jgit.errors.LargeObjectException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultClusterVersionControlServiceDiffblueTest {
  @InjectMocks private DefaultClusterVersionControlService defaultClusterVersionControlService;

  @Mock private GitRepositoryService gitRepositoryService;

  @Mock private PartitionService partitionService;

  @Mock private TbQueueProducerProvider tbQueueProducerProvider;

  /**
   * Test {@link DefaultClusterVersionControlService#init()}.
   *
   * <p>Method under test: {@link DefaultClusterVersionControlService#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultClusterVersionControlService.init()"})
  void testInit() {
    // Arrange
    when(tbQueueProducerProvider.getTbCoreNotificationsMsgProducer())
        .thenThrow(new LargeObjectException());

    // Act and Assert
    assertThrows(LargeObjectException.class, () -> defaultClusterVersionControlService.init());
    verify(tbQueueProducerProvider).getTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#init()}.
   *
   * <p>Method under test: {@link DefaultClusterVersionControlService#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultClusterVersionControlService.init()"})
  void testInit2() {
    // Arrange
    when(tbQueueProducerProvider.getTbCoreNotificationsMsgProducer())
        .thenThrow(new LargeObjectException());

    // Act and Assert
    assertThrows(LargeObjectException.class, () -> defaultClusterVersionControlService.init());
    verify(tbQueueProducerProvider).getTbCoreNotificationsMsgProducer();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent() {
    // Arrange
    when(gitRepositoryService.getActiveRepositoryTenants()).thenThrow(new LargeObjectException());
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () -> defaultClusterVersionControlService.onTbApplicationEvent(event));
    verify(gitRepositoryService).getActiveRepositoryTenants();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent2() {
    // Arrange
    when(gitRepositoryService.getActiveRepositoryTenants()).thenThrow(new LargeObjectException());
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () -> defaultClusterVersionControlService.onTbApplicationEvent(event));
    verify(gitRepositoryService).getActiveRepositoryTenants();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then calls {@link PartitionService#isMyPartition(ServiceType, TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then calls isMyPartition(ServiceType, TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsIsMyPartition() {
    // Arrange
    when(partitionService.isMyPartition(
            Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new LargeObjectException());

    HashSet<TenantId> tenantIdSet = new HashSet<>();
    tenantIdSet.add(new TenantId(UUID.randomUUID()));
    when(gitRepositoryService.getActiveRepositoryTenants()).thenReturn(tenantIdSet);
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () -> defaultClusterVersionControlService.onTbApplicationEvent(event));
    verify(partitionService)
        .isMyPartition(eq(ServiceType.TB_VC_EXECUTOR), isA(TenantId.class), isA(EntityId.class));
    verify(gitRepositoryService).getActiveRepositoryTenants();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then calls {@link PartitionService#isMyPartition(ServiceType, TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then calls isMyPartition(ServiceType, TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsIsMyPartition2() {
    // Arrange
    when(partitionService.isMyPartition(
            Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new LargeObjectException());

    HashSet<TenantId> tenantIdSet = new HashSet<>();
    tenantIdSet.add(new TenantId(UUID.randomUUID()));
    when(gitRepositoryService.getActiveRepositoryTenants()).thenReturn(tenantIdSet);
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () -> defaultClusterVersionControlService.onTbApplicationEvent(event));
    verify(partitionService)
        .isMyPartition(eq(ServiceType.TB_VC_EXECUTOR), isA(TenantId.class), isA(EntityId.class));
    verify(gitRepositoryService).getActiveRepositoryTenants();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertFalse(defaultClusterVersionControlService.filterTbApplicationEvent(event));
  }

  /**
   * Test {@link DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse2() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act and Assert
    assertFalse(defaultClusterVersionControlService.filterTbApplicationEvent(event));
  }

  /**
   * Test {@link DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnTrue() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_VC_EXECUTOR, new HashMap<>());

    // Act and Assert
    assertTrue(defaultClusterVersionControlService.filterTbApplicationEvent(event));
  }

  /**
   * Test {@link DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultClusterVersionControlService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName(
      "Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnTrue2() {
    // Arrange
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_VC_EXECUTOR, new HashMap<>());

    // Act and Assert
    assertTrue(defaultClusterVersionControlService.filterTbApplicationEvent(event));
  }
}
