package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActor;
import org.thingsboard.server.actors.TbActorCtx;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.TbEntityActorId;
import org.thingsboard.server.actors.ruleChain.RuleNodeActor.ActorCreator;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.TbActorMsg;
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

@ContextConfiguration(classes = {RuleNodeActor.class, TenantId.class, String.class, RuleNodeActor.ActorCreator.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class RuleNodeActorDiffblueTest {
  @Autowired
  private RuleNodeActor.ActorCreator actorCreator;

  @MockBean
  private ActorSystemContext actorSystemContext;

  @MockBean
  private RuleChainId ruleChainId;

  @Autowired
  private RuleNodeActor ruleNodeActor;

  @MockBean
  private RuleNodeId ruleNodeId;

  @MockBean
  private UUID uUID;

  /**
   * Test ActorCreator {@link ActorCreator#createActor()}.
   * <p>
   * Method under test: {@link RuleNodeActor.ActorCreator#createActor()}
   */
  @Test
  @DisplayName("Test ActorCreator createActor()")
  void testActorCreatorCreateActor() {
    // Arrange and Act
    TbActor actualCreateActorResult = actorCreator.createActor();

    // Assert
    assertTrue(actualCreateActorResult instanceof RuleNodeActor);
    assertEquals("", ((RuleNodeActor) actualCreateActorResult).getRuleChainName());
    assertNull(((RuleNodeActor) actualCreateActorResult).getCtx());
    assertNull(actualCreateActorResult.getActorRef());
    assertEquals(0L, ((RuleNodeActor) actualCreateActorResult).getErrorPersistFrequency());
  }

  /**
   * Test ActorCreator {@link ActorCreator#createActorId()}.
   * <p>
   * Method under test: {@link RuleNodeActor.ActorCreator#createActorId()}
   */
  @Test
  @DisplayName("Test ActorCreator createActorId()")
  void testActorCreatorCreateActorId() {
    // Arrange and Act
    TbActorId actualCreateActorIdResult = actorCreator.createActorId();

    // Assert
    assertTrue(actualCreateActorIdResult instanceof TbEntityActorId);
    assertNull(actualCreateActorIdResult.getEntityType());
  }

  /**
   * Test {@link RuleNodeActor#createProcessor(TbActorCtx)}.
   * <p>
   * Method under test: {@link RuleNodeActor#createProcessor(TbActorCtx)}
   */
  @Test
  @DisplayName("Test createProcessor(TbActorCtx)")
  void testCreateProcessor() {
    // Arrange
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any())).thenReturn(null);
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
    when(actorSystemContext.getApiUsageClient())
        .thenReturn(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    when(actorSystemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);

    // Act
    RuleNodeActorMessageProcessor actualCreateProcessorResult = ruleNodeActor
        .createProcessor(new TbActorMailbox(system, settings, selfId, null, new StatsActor(actorSystemContext), null));

    // Assert
    verify(actorSystemContext).getApiUsageClient();
    verify(actorSystemContext).getRuleChainService();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
    RuleNodeException inactiveException = actualCreateProcessorResult.getInactiveException();
    RuleChainId ruleChainId2 = inactiveException.getRuleChainId();
    UUID id = ruleChainId2.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Unknown", actualCreateProcessorResult.getComponentName());
    assertEquals("Unknown", inactiveException.getRuleNodeName());
    assertEquals(EntityType.RULE_CHAIN, ruleChainId2.getEntityType());
    RuleNodeId ruleNodeId2 = inactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId2.getEntityType());
    assertTrue(ruleChainId2.isNullUid());
    assertTrue(ruleNodeId2.isNullUid());
    assertSame(id, ruleNodeId2.getId());
  }

  /**
   * Test {@link RuleNodeActor#createProcessor(TbActorCtx)}.
   * <ul>
   *   <li>Then return ComponentName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeActor#createProcessor(TbActorCtx)}
   */
  @Test
  @DisplayName("Test createProcessor(TbActorCtx); then return ComponentName is 'null'")
  void testCreateProcessor_thenReturnComponentNameIsNull() {
    // Arrange
    RuleChainService ruleChainService = mock(RuleChainService.class);
    when(ruleChainService.findRuleNodeById(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any()))
        .thenReturn(new RuleNode());
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
    when(actorSystemContext.getApiUsageClient())
        .thenReturn(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    when(actorSystemContext.getRuleChainService()).thenReturn(ruleChainService);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);

    // Act
    RuleNodeActorMessageProcessor actualCreateProcessorResult = ruleNodeActor
        .createProcessor(new TbActorMailbox(system, settings, selfId, null, new StatsActor(actorSystemContext), null));

    // Assert
    verify(actorSystemContext).getApiUsageClient();
    verify(actorSystemContext).getRuleChainService();
    verify(ruleChainService).findRuleNodeById(isA(TenantId.class), isA(RuleNodeId.class));
    assertNull(actualCreateProcessorResult.getComponentName());
    RuleNodeException inactiveException = actualCreateProcessorResult.getInactiveException();
    assertNull(inactiveException.getRuleNodeName());
    assertNull(inactiveException.getRuleChainId());
    assertNull(inactiveException.getRuleNodeId());
  }

  /**
   * Test {@link RuleNodeActor#doProcess(TbActorMsg)}.
   * <p>
   * Method under test: {@link RuleNodeActor#doProcess(TbActorMsg)}
   */
  @Test
  @DisplayName("Test doProcess(TbActorMsg)")
  void testDoProcess() {
    // Arrange
    TbActorMsg msg = mock(TbActorMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.APP_INIT_MSG);

    // Act
    boolean actualDoProcessResult = ruleNodeActor.doProcess(msg);

    // Assert
    verify(msg).getMsgType();
    assertFalse(actualDoProcessResult);
  }

  /**
   * Test {@link RuleNodeActor#getErrorPersistFrequency()}.
   * <p>
   * Method under test: {@link RuleNodeActor#getErrorPersistFrequency()}
   */
  @Test
  @DisplayName("Test getErrorPersistFrequency()")
  void testGetErrorPersistFrequency() {
    // Arrange
    when(actorSystemContext.getRuleNodeErrorPersistFrequency()).thenReturn(-1L);

    // Act
    long actualErrorPersistFrequency = ruleNodeActor.getErrorPersistFrequency();

    // Assert
    verify(actorSystemContext).getRuleNodeErrorPersistFrequency();
    assertEquals(-1L, actualErrorPersistFrequency);
  }
}
