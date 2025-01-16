package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.TbRuleNodeUpdateException;
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
   * Test
   * {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}.
   * <p>
   * Method under test:
   * {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName("Test new RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)")
  void testNewRuleNodeActorMessageProcessor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any())).thenReturn(null);
    ActorSystemContext systemContext = mock(ActorSystemContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(systemContext.getApiUsageClient())
        .thenReturn(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    when(systemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act
    RuleNodeActorMessageProcessor actualRuleNodeActorMessageProcessor = new RuleNodeActorMessageProcessor(tenantId,
        "Rule Chain Name", ruleNodeId, systemContext, parent,
        new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null));

    // Assert
    verify(systemContext).getApiUsageClient();
    verify(systemContext).getRuleChainService();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
    RuleNodeException inactiveException = actualRuleNodeActorMessageProcessor.getInactiveException();
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
   * Test
   * {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}.
   * <ul>
   *   <li>Then return ComponentName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName("Test new RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef); then return ComponentName is 'null'")
  void testNewRuleNodeActorMessageProcessor_thenReturnComponentNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any()))
        .thenReturn(new RuleNode());
    ActorSystemContext systemContext = mock(ActorSystemContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(systemContext.getApiUsageClient())
        .thenReturn(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    when(systemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act
    RuleNodeActorMessageProcessor actualRuleNodeActorMessageProcessor = new RuleNodeActorMessageProcessor(tenantId,
        "Rule Chain Name", ruleNodeId, systemContext, parent,
        new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null));

    // Assert
    verify(systemContext).getApiUsageClient();
    verify(systemContext).getRuleChainService();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
    assertNull(actualRuleNodeActorMessageProcessor.getComponentName());
    RuleNodeException inactiveException = actualRuleNodeActorMessageProcessor.getInactiveException();
    assertNull(inactiveException.getRuleNodeName());
    assertNull(inactiveException.getRuleChainId());
    assertNull(inactiveException.getRuleNodeId());
  }

  /**
   * Test
   * {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}.
   * <ul>
   *   <li>Then throw {@link TbRuleNodeUpdateException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleNodeActorMessageProcessor#RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName("Test new RuleNodeActorMessageProcessor(TenantId, String, RuleNodeId, ActorSystemContext, TbActorRef, TbActorRef); then throw TbRuleNodeUpdateException")
  void testNewRuleNodeActorMessageProcessor_thenThrowTbRuleNodeUpdateException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getName()).thenThrow(new TbRuleNodeUpdateException("An error occurred", new Throwable()));
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any())).thenReturn(ruleNode);
    ActorSystemContext systemContext = mock(ActorSystemContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(systemContext.getApiUsageClient())
        .thenReturn(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    when(systemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act and Assert
    assertThrows(TbRuleNodeUpdateException.class,
        () -> new RuleNodeActorMessageProcessor(tenantId, "Rule Chain Name", ruleNodeId, systemContext, parent,
            new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null)));

    verify(systemContext).getApiUsageClient();
    verify(systemContext).getRuleChainService();
    verify(ruleNode).getName();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
  }
}
