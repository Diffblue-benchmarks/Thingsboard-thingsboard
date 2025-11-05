package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
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
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

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
    tenantIdSet.add(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider2,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultGitRepositoryService vcService = new DefaultGitRepositoryService();

    DefaultClusterVersionControlService defaultClusterVersionControlService =
        new DefaultClusterVersionControlService(
            partitionService, producerProvider, null, vcService, new TopicService());
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>());

    // Act
    boolean actualFilterTbApplicationEventResult =
        defaultClusterVersionControlService.filterTbApplicationEvent(event);

    // Assert
    assertFalse(actualFilterTbApplicationEventResult);
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
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider2,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultGitRepositoryService vcService = new DefaultGitRepositoryService();

    DefaultClusterVersionControlService defaultClusterVersionControlService =
        new DefaultClusterVersionControlService(
            partitionService, producerProvider, null, vcService, new TopicService());
    PartitionChangeEvent event =
        new PartitionChangeEvent("Source", ServiceType.TB_VC_EXECUTOR, new HashMap<>());

    // Act
    boolean actualFilterTbApplicationEventResult =
        defaultClusterVersionControlService.filterTbApplicationEvent(event);

    // Assert
    assertTrue(actualFilterTbApplicationEventResult);
  }
}
