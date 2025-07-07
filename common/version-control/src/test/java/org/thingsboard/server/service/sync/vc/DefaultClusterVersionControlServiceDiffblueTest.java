package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusProducerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.queue.provider.TbVersionControlQueueFactory;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultClusterVersionControlServiceDiffblueTest {
  @InjectMocks private DefaultClusterVersionControlService defaultClusterVersionControlService;

  @Mock private GitRepositoryService gitRepositoryService;

  @Mock private PartitionService partitionService;

  @Mock private TbQueueProducerProvider tbQueueProducerProvider;

  @Mock private TbVersionControlQueueFactory tbVersionControlQueueFactory;

  /**
   * Test {@link DefaultClusterVersionControlService#init()}.
   *
   * <ul>
   *   <li>Then calls {@link TbVersionControlQueueFactory#createToVersionControlMsgConsumer()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultClusterVersionControlService#init()}
   */
  @Test
  @DisplayName("Test init(); then calls createToVersionControlMsgConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultClusterVersionControlService.init()"})
  void testInit_thenCallsCreateToVersionControlMsgConsumer() {
    // Arrange
    when(tbQueueProducerProvider.getTbCoreNotificationsMsgProducer())
        .thenReturn(
            new TbServiceBusProducerTemplate<>(null, new TbServiceBusSettings(), "Default Topic"));
    when(tbVersionControlQueueFactory.createToVersionControlMsgConsumer())
        .thenReturn(
            new TbServiceBusConsumerTemplate<>(
                null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));

    // Act
    defaultClusterVersionControlService.init();

    // Assert
    verify(tbQueueProducerProvider).getTbCoreNotificationsMsgProducer();
    verify(tbVersionControlQueueFactory).createToVersionControlMsgConsumer();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#init()}.
   *
   * <ul>
   *   <li>Then calls {@link TbVersionControlQueueFactory#createToVersionControlMsgConsumer()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultClusterVersionControlService#init()}
   */
  @Test
  @DisplayName("Test init(); then calls createToVersionControlMsgConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultClusterVersionControlService.init()"})
  void testInit_thenCallsCreateToVersionControlMsgConsumer2() {
    // Arrange
    when(tbQueueProducerProvider.getTbCoreNotificationsMsgProducer())
        .thenReturn(
            new TbServiceBusProducerTemplate<>(null, new TbServiceBusSettings(), "Default Topic"));
    when(tbVersionControlQueueFactory.createToVersionControlMsgConsumer())
        .thenReturn(
            new TbServiceBusConsumerTemplate<>(
                null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));

    // Act
    defaultClusterVersionControlService.init();

    // Assert
    verify(tbQueueProducerProvider).getTbCoreNotificationsMsgProducer();
    verify(tbVersionControlQueueFactory).createToVersionControlMsgConsumer();
  }

  /**
   * Test {@link DefaultClusterVersionControlService#init()}.
   *
   * <ul>
   *   <li>Then throw {@link LargeObjectException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultClusterVersionControlService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw LargeObjectException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultClusterVersionControlService.init()"})
  void testInit_thenThrowLargeObjectException() {
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
   * <ul>
   *   <li>Then throw {@link LargeObjectException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultClusterVersionControlService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw LargeObjectException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultClusterVersionControlService.init()"})
  void testInit_thenThrowLargeObjectException2() {
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent() {
    // Arrange
    when(gitRepositoryService.getActiveRepositoryTenants()).thenThrow(new LargeObjectException());

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () ->
            defaultClusterVersionControlService.onTbApplicationEvent(
                new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent2() {
    // Arrange
    when(gitRepositoryService.getActiveRepositoryTenants()).thenThrow(new LargeObjectException());

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () ->
            defaultClusterVersionControlService.onTbApplicationEvent(
                new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsIsMyPartition() {
    // Arrange
    when(partitionService.isMyPartition(
            Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new LargeObjectException());

    HashSet<TenantId> tenantIdSet = new HashSet<>();
    tenantIdSet.add(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(gitRepositoryService.getActiveRepositoryTenants()).thenReturn(tenantIdSet);

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () ->
            defaultClusterVersionControlService.onTbApplicationEvent(
                new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DefaultClusterVersionControlService.onTbApplicationEvent(PartitionChangeEvent)"
  })
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsIsMyPartition2() {
    // Arrange
    when(partitionService.isMyPartition(
            Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new LargeObjectException());

    HashSet<TenantId> tenantIdSet = new HashSet<>();
    tenantIdSet.add(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(gitRepositoryService.getActiveRepositoryTenants()).thenReturn(tenantIdSet);

    // Act and Assert
    assertThrows(
        LargeObjectException.class,
        () ->
            defaultClusterVersionControlService.onTbApplicationEvent(
                new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        defaultClusterVersionControlService.filterTbApplicationEvent(
            new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(
        defaultClusterVersionControlService.filterTbApplicationEvent(
            new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        defaultClusterVersionControlService.filterTbApplicationEvent(
            new PartitionChangeEvent("Source", ServiceType.TB_VC_EXECUTOR, new HashMap<>())));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DefaultClusterVersionControlService.filterTbApplicationEvent(PartitionChangeEvent)"
  })
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(
        defaultClusterVersionControlService.filterTbApplicationEvent(
            new PartitionChangeEvent("Source", ServiceType.TB_VC_EXECUTOR, new HashMap<>())));
  }
}
