package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.QueueToRuleEngineMsg;
import org.thingsboard.server.common.msg.queue.RuleNodeException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
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
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.queue.TbMsgPackCallback;

@ContextConfiguration(classes = {RuleChainActorMessageProcessor.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class RuleChainActorMessageProcessorDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @MockBean private RuleChain ruleChain;

  @Autowired private RuleChainActorMessageProcessor ruleChainActorMessageProcessor;

  @MockBean private TbActorRef tbActorRef;

  @MockBean private TenantId tenantId;

  /**
   * Test {@link RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain,
   * ActorSystemContext, TbActorRef, TbActorRef)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getApiUsageClient()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain,
   * ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test new RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef); then calls getApiUsageClient()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.<init>(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef)"
  })
  void testNewRuleChainActorMessageProcessor_thenCallsGetApiUsageClient() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChain ruleChain = new RuleChain();

    ActorSystemContext systemContext = mock(ActorSystemContext.class);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceService =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService2,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());

    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService defaultTbClusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
    when(systemContext.getClusterService()).thenReturn(defaultTbClusterService);
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
    TopicService topicService2 = new TopicService();
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
            topicService2,
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
    when(systemContext.getRuleChainService()).thenReturn(new BaseRuleChainService());
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
    RuleChainActorMessageProcessor actualRuleChainActorMessageProcessor =
        new RuleChainActorMessageProcessor(tenantId, ruleChain, systemContext, parent, self);

    // Assert
    verify(systemContext).getApiUsageClient();
    verify(systemContext).getClusterService();
    verify(systemContext).getRuleChainService();
    RuleNodeException inactiveException =
        actualRuleChainActorMessageProcessor.getInactiveException();
    assertEquals(
        "Rule Chain is not active!  Failed to initialize.",
        inactiveException.getLocalizedMessage());
    assertEquals(
        "Rule Chain is not active!  Failed to initialize.", inactiveException.getMessage());
    assertEquals("Unknown", inactiveException.getRuleNodeName());
    assertNull(actualRuleChainActorMessageProcessor.getComponentName());
    assertNull(inactiveException.getRuleChainName());
    assertNull(inactiveException.getCause());
    assertEquals(0, inactiveException.getSuppressed().length);
    RuleChainId ruleChainId = inactiveException.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = inactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain,
   * ActorSystemContext, TbActorRef, TbActorRef)}.
   *
   * <ul>
   *   <li>When {@link ActorSystemContext} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain,
   * ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName(
      "Test new RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef); when ActorSystemContext (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.<init>(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef)"
  })
  void testNewRuleChainActorMessageProcessor_whenActorSystemContext() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChain ruleChain = new RuleChain();
    ActorSystemContext systemContext = new ActorSystemContext();
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
    RuleChainActorMessageProcessor actualRuleChainActorMessageProcessor =
        new RuleChainActorMessageProcessor(tenantId, ruleChain, systemContext, parent, self);

    // Assert
    RuleNodeException inactiveException =
        actualRuleChainActorMessageProcessor.getInactiveException();
    assertEquals(
        "Rule Chain is not active!  Failed to initialize.",
        inactiveException.getLocalizedMessage());
    assertEquals(
        "Rule Chain is not active!  Failed to initialize.", inactiveException.getMessage());
    assertEquals("Unknown", inactiveException.getRuleNodeName());
    assertNull(actualRuleChainActorMessageProcessor.getComponentName());
    assertNull(inactiveException.getRuleChainName());
    assertNull(inactiveException.getCause());
    assertEquals(0, inactiveException.getSuppressed().length);
    RuleChainId ruleChainId = inactiveException.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = inactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#getComponentName()}.
   *
   * <p>Method under test: {@link RuleChainActorMessageProcessor#getComponentName()}
   */
  @Test
  @DisplayName("Test getComponentName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RuleChainActorMessageProcessor.getComponentName()"})
  void testGetComponentName() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChain ruleChain = new RuleChain();
    ActorSystemContext systemContext = new ActorSystemContext();
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

    RuleChainActorMessageProcessor ruleChainActorMessageProcessor =
        new RuleChainActorMessageProcessor(tenantId, ruleChain, systemContext, parent, self);

    // Act and Assert
    assertNull(ruleChainActorMessageProcessor.getComponentName());
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}
   */
  @Test
  @DisplayName("Test onQueueToRuleEngineMsg(QueueToRuleEngineMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onQueueToRuleEngineMsg(QueueToRuleEngineMsg)"
  })
  void testOnQueueToRuleEngineMsg() {
    // Arrange
    QueueToRuleEngineMsg envelope = mock(QueueToRuleEngineMsg.class);
    when(envelope.getRelationTypes()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onQueueToRuleEngineMsg(envelope));
    verify(envelope).getMsg();
    verify(envelope).getRelationTypes();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}
   */
  @Test
  @DisplayName("Test onQueueToRuleEngineMsg(QueueToRuleEngineMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onQueueToRuleEngineMsg(QueueToRuleEngineMsg)"
  })
  void testOnQueueToRuleEngineMsg2() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    QueueToRuleEngineMsg envelope = mock(QueueToRuleEngineMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onQueueToRuleEngineMsg(envelope));
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}.
   *
   * <ul>
   *   <li>Given {@code [{}][{}] Processing message [{}]: {}}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}
   */
  @Test
  @DisplayName(
      "Test onQueueToRuleEngineMsg(QueueToRuleEngineMsg); given '[{}][{}] Processing message [{}]: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onQueueToRuleEngineMsg(QueueToRuleEngineMsg)"
  })
  void testOnQueueToRuleEngineMsg_givenProcessingMessage() {
    // Arrange
    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("[{}][{}] Processing message [{}]: {}");

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    QueueToRuleEngineMsg envelope =
        new QueueToRuleEngineMsg(tenantId, tbMsg, relationTypes, "Failure Message");

    // Act and Assert
    assertDoesNotThrow(() -> ruleChainActorMessageProcessor.onQueueToRuleEngineMsg(envelope));
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}
   */
  @Test
  @DisplayName(
      "Test onQueueToRuleEngineMsg(QueueToRuleEngineMsg); given TbMsgPackCallback isMsgValid() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onQueueToRuleEngineMsg(QueueToRuleEngineMsg)"
  })
  void testOnQueueToRuleEngineMsg_givenTbMsgPackCallbackIsMsgValidReturnFalse() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(false);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    QueueToRuleEngineMsg envelope = mock(QueueToRuleEngineMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act
    ruleChainActorMessageProcessor.onQueueToRuleEngineMsg(envelope);

    // Assert
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}
   */
  @Test
  @DisplayName(
      "Test onQueueToRuleEngineMsg(QueueToRuleEngineMsg); given TbMsgPackCallback isMsgValid() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onQueueToRuleEngineMsg(QueueToRuleEngineMsg)"
  })
  void testOnQueueToRuleEngineMsg_givenTbMsgPackCallbackIsMsgValidReturnTrue() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(true);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    QueueToRuleEngineMsg envelope = mock(QueueToRuleEngineMsg.class);
    when(envelope.getRelationTypes()).thenThrow(new IllegalArgumentException());
    when(envelope.getMsg()).thenReturn(tbMsg);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onQueueToRuleEngineMsg(envelope));
    verify(envelope).getMsg();
    verify(envelope).getRelationTypes();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onQueueToRuleEngineMsg(QueueToRuleEngineMsg)}
   */
  @Test
  @DisplayName("Test onQueueToRuleEngineMsg(QueueToRuleEngineMsg); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onQueueToRuleEngineMsg(QueueToRuleEngineMsg)"
  })
  void testOnQueueToRuleEngineMsg_thenDoesNotThrow() {
    // Arrange
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    QueueToRuleEngineMsg envelope =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act and Assert
    assertDoesNotThrow(() -> ruleChainActorMessageProcessor.onQueueToRuleEngineMsg(envelope));
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)} with
   * {@code envelope}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)}
   */
  @Test
  @DisplayName("Test onTellNext(RuleNodeToRuleChainTellNextMsg) with 'envelope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onTellNext(RuleNodeToRuleChainTellNextMsg)"
  })
  void testOnTellNextWithEnvelope() {
    // Arrange
    RuleNodeToRuleChainTellNextMsg envelope = mock(RuleNodeToRuleChainTellNextMsg.class);
    when(envelope.getOriginator()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ruleChainActorMessageProcessor.onTellNext(envelope));
    verify(envelope).getOriginator();
    verify(envelope).getMsg();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)} with
   * {@code envelope}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)}
   */
  @Test
  @DisplayName("Test onTellNext(RuleNodeToRuleChainTellNextMsg) with 'envelope'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onTellNext(RuleNodeToRuleChainTellNextMsg)"
  })
  void testOnTellNextWithEnvelope2() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNodeToRuleChainTellNextMsg envelope = mock(RuleNodeToRuleChainTellNextMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ruleChainActorMessageProcessor.onTellNext(envelope));
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)} with
   * {@code envelope}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)}
   */
  @Test
  @DisplayName(
      "Test onTellNext(RuleNodeToRuleChainTellNextMsg) with 'envelope'; given TbMsgPackCallback isMsgValid() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onTellNext(RuleNodeToRuleChainTellNextMsg)"
  })
  void testOnTellNextWithEnvelope_givenTbMsgPackCallbackIsMsgValidReturnFalse() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(false);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleNodeToRuleChainTellNextMsg envelope = mock(RuleNodeToRuleChainTellNextMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act
    ruleChainActorMessageProcessor.onTellNext(envelope);

    // Assert
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)} with
   * {@code envelope}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)}
   */
  @Test
  @DisplayName(
      "Test onTellNext(RuleNodeToRuleChainTellNextMsg) with 'envelope'; given TbMsgPackCallback isMsgValid() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onTellNext(RuleNodeToRuleChainTellNextMsg)"
  })
  void testOnTellNextWithEnvelope_givenTbMsgPackCallbackIsMsgValidReturnTrue() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(true);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleNodeToRuleChainTellNextMsg envelope = mock(RuleNodeToRuleChainTellNextMsg.class);
    when(envelope.getOriginator()).thenThrow(new IllegalArgumentException());
    when(envelope.getMsg()).thenReturn(tbMsg);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ruleChainActorMessageProcessor.onTellNext(envelope));
    verify(envelope).getOriginator();
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)} with
   * {@code envelope}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onTellNext(RuleNodeToRuleChainTellNextMsg)}
   */
  @Test
  @DisplayName(
      "Test onTellNext(RuleNodeToRuleChainTellNextMsg) with 'envelope'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onTellNext(RuleNodeToRuleChainTellNextMsg)"
  })
  void testOnTellNextWithEnvelope_thenDoesNotThrow() {
    // Arrange
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId originator = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    HashSet<String> relationTypes = new HashSet<>();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleNodeToRuleChainTellNextMsg envelope =
        new RuleNodeToRuleChainTellNextMsg(
            ruleChainId, originator, relationTypes, tbMsg, "Failure Message");

    // Act and Assert
    assertDoesNotThrow(() -> ruleChainActorMessageProcessor.onTellNext(envelope));
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}
   */
  @Test
  @DisplayName("Test onRuleChainInputMsg(RuleChainInputMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainActorMessageProcessor.onRuleChainInputMsg(RuleChainInputMsg)"})
  void testOnRuleChainInputMsg() {
    // Arrange
    RuleChainInputMsg envelope = mock(RuleChainInputMsg.class);
    when(envelope.getRuleChainId()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onRuleChainInputMsg(envelope));
    verify(envelope).getRuleChainId();
    verify(envelope).getMsg();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}
   */
  @Test
  @DisplayName("Test onRuleChainInputMsg(RuleChainInputMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainActorMessageProcessor.onRuleChainInputMsg(RuleChainInputMsg)"})
  void testOnRuleChainInputMsg2() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainInputMsg envelope = mock(RuleChainInputMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onRuleChainInputMsg(envelope));
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}
   */
  @Test
  @DisplayName(
      "Test onRuleChainInputMsg(RuleChainInputMsg); given TbMsgPackCallback isMsgValid() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainActorMessageProcessor.onRuleChainInputMsg(RuleChainInputMsg)"})
  void testOnRuleChainInputMsg_givenTbMsgPackCallbackIsMsgValidReturnFalse() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(false);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainInputMsg envelope = mock(RuleChainInputMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act
    ruleChainActorMessageProcessor.onRuleChainInputMsg(envelope);

    // Assert
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainInputMsg(RuleChainInputMsg)}
   */
  @Test
  @DisplayName(
      "Test onRuleChainInputMsg(RuleChainInputMsg); given TbMsgPackCallback isMsgValid() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleChainActorMessageProcessor.onRuleChainInputMsg(RuleChainInputMsg)"})
  void testOnRuleChainInputMsg_givenTbMsgPackCallbackIsMsgValidReturnTrue() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(true);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleChainInputMsg envelope = mock(RuleChainInputMsg.class);
    when(envelope.getRuleChainId()).thenThrow(new IllegalArgumentException());
    when(envelope.getMsg()).thenReturn(tbMsg);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onRuleChainInputMsg(envelope));
    verify(envelope).getRuleChainId();
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}
   */
  @Test
  @DisplayName("Test onRuleChainOutputMsg(RuleChainOutputMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onRuleChainOutputMsg(RuleChainOutputMsg)"
  })
  void testOnRuleChainOutputMsg() {
    // Arrange
    RuleChainOutputMsg envelope = mock(RuleChainOutputMsg.class);
    when(envelope.getRuleChainId()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onRuleChainOutputMsg(envelope));
    verify(envelope).getRuleChainId();
    verify(envelope).getMsg();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}.
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}
   */
  @Test
  @DisplayName("Test onRuleChainOutputMsg(RuleChainOutputMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onRuleChainOutputMsg(RuleChainOutputMsg)"
  })
  void testOnRuleChainOutputMsg2() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenThrow(new IllegalArgumentException());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainOutputMsg envelope = mock(RuleChainOutputMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onRuleChainOutputMsg(envelope));
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}
   */
  @Test
  @DisplayName(
      "Test onRuleChainOutputMsg(RuleChainOutputMsg); given TbMsgPackCallback isMsgValid() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onRuleChainOutputMsg(RuleChainOutputMsg)"
  })
  void testOnRuleChainOutputMsg_givenTbMsgPackCallbackIsMsgValidReturnFalse() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(false);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    RuleChainOutputMsg envelope = mock(RuleChainOutputMsg.class);
    when(envelope.getMsg())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Act
    ruleChainActorMessageProcessor.onRuleChainOutputMsg(envelope);

    // Assert
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgPackCallback} {@link TbMsgPackCallback#isMsgValid()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleChainActorMessageProcessor#onRuleChainOutputMsg(RuleChainOutputMsg)}
   */
  @Test
  @DisplayName(
      "Test onRuleChainOutputMsg(RuleChainOutputMsg); given TbMsgPackCallback isMsgValid() return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RuleChainActorMessageProcessor.onRuleChainOutputMsg(RuleChainOutputMsg)"
  })
  void testOnRuleChainOutputMsg_givenTbMsgPackCallbackIsMsgValidReturnTrue() {
    // Arrange
    TbMsgPackCallback callback = mock(TbMsgPackCallback.class);
    when(callback.isMsgValid()).thenReturn(true);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleChainOutputMsg envelope = mock(RuleChainOutputMsg.class);
    when(envelope.getRuleChainId()).thenThrow(new IllegalArgumentException());
    when(envelope.getMsg()).thenReturn(tbMsg);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ruleChainActorMessageProcessor.onRuleChainOutputMsg(envelope));
    verify(envelope).getRuleChainId();
    verify(envelope).getMsg();
    verify(callback).isMsgValid();
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#getInactiveException()}.
   *
   * <p>Method under test: {@link RuleChainActorMessageProcessor#getInactiveException()}
   */
  @Test
  @DisplayName("Test getInactiveException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeException RuleChainActorMessageProcessor.getInactiveException()"})
  void testGetInactiveException() {
    // Arrange and Act
    RuleNodeException actualInactiveException =
        ruleChainActorMessageProcessor.getInactiveException();

    // Assert
    assertEquals(
        "Rule Chain is not active!  Failed to initialize.",
        actualInactiveException.getLocalizedMessage());
    assertEquals(
        "Rule Chain is not active!  Failed to initialize.", actualInactiveException.getMessage());
    assertEquals("Unknown", actualInactiveException.getRuleNodeName());
    assertNull(actualInactiveException.getRuleChainName());
    assertNull(actualInactiveException.getCause());
    assertEquals(0, actualInactiveException.getSuppressed().length);
    RuleChainId ruleChainId = actualInactiveException.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = actualInactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
  }
}
