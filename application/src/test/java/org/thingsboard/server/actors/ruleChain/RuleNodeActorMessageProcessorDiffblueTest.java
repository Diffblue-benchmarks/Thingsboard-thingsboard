package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.queue.RuleNodeException;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;

class RuleNodeActorMessageProcessorDiffblueTest {
  /**
   * Test {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String,
   * RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}.
   *
   * <p>Method under test: {@link
   * RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId,
   * ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNodeActorMessageProcessor.<init>(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)"
  })
  void testNewRuleNodeActorMessageProcessor() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any()))
        .thenReturn(null);

    ActorSystemContext systemContext = mock(ActorSystemContext.class);
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider3,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient defaultTbApiUsageReportClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));
    when(systemContext.getApiUsageClient()).thenReturn(defaultTbApiUsageReportClient);
    when(systemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox parent =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox self =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act
    RuleNodeActorMessageProcessor actualRuleNodeActorMessageProcessor =
        new RuleNodeActorMessageProcessor(
            tenantId, "Rule Chain Name", ruleNodeId, systemContext, parent, self);

    // Assert
    verify(systemContext).getApiUsageClient();
    verify(systemContext).getRuleChainService();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
    RuleNodeException inactiveException =
        actualRuleNodeActorMessageProcessor.getInactiveException();
    RuleChainId ruleChainId = inactiveException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Unknown", actualRuleNodeActorMessageProcessor.getComponentName());
    assertEquals("Unknown", inactiveException.getRuleNodeName());
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId2 = inactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId2.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId2.isNullUid());
    assertSame(id, ruleNodeId2.getId());
  }

  /**
   * Test {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String,
   * RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}.
   *
   * <ul>
   *   <li>Then return ComponentName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId,
   * ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef); then return ComponentName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleNodeActorMessageProcessor.<init>(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)"
  })
  void testNewRuleNodeActorMessageProcessor_thenReturnComponentNameIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any()))
        .thenReturn(new RuleNode());

    ActorSystemContext systemContext = mock(ActorSystemContext.class);
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider3,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient defaultTbApiUsageReportClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));
    when(systemContext.getApiUsageClient()).thenReturn(defaultTbApiUsageReportClient);
    when(systemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox parent =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox self =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    // Act
    RuleNodeActorMessageProcessor actualRuleNodeActorMessageProcessor =
        new RuleNodeActorMessageProcessor(
            tenantId, "Rule Chain Name", ruleNodeId, systemContext, parent, self);

    // Assert
    verify(systemContext).getApiUsageClient();
    verify(systemContext).getRuleChainService();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
    assertNull(actualRuleNodeActorMessageProcessor.getComponentName());
    RuleNodeException inactiveException =
        actualRuleNodeActorMessageProcessor.getInactiveException();
    assertNull(inactiveException.getRuleNodeName());
    assertNull(inactiveException.getRuleChainId());
    assertNull(inactiveException.getRuleNodeId());
  }
}
