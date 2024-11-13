package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.caffeine.CaffeineCacheManager;
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
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.msg.queue.RuleNodeException;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
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

@ContextConfiguration(classes = {RuleChainActorMessageProcessor.class, TenantId.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class RuleChainActorMessageProcessorDiffblueTest {
  @MockBean
  private ActorSystemContext actorSystemContext;

  @MockBean
  private RuleChain ruleChain;

  @Autowired
  private RuleChainActorMessageProcessor ruleChainActorMessageProcessor;

  @MockBean
  private TbActorRef tbActorRef;

  @MockBean
  private UUID uUID;

  /**
   * Test
   * {@link RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef)}.
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getApiUsageClient()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName("Test new RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef); then calls getApiUsageClient()")
  void testNewRuleChainActorMessageProcessor_thenCallsGetApiUsageClient() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChain ruleChain = new RuleChain();
    ActorSystemContext systemContext = mock(ActorSystemContext.class);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    when(systemContext.getClusterService())
        .thenReturn(new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache,
            gatewayNotificationsService, edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(systemContext.getApiUsageClient())
        .thenReturn(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService2, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    when(systemContext.getRuleChainService()).thenReturn(new BaseRuleChainService());
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act
    RuleChainActorMessageProcessor actualRuleChainActorMessageProcessor = new RuleChainActorMessageProcessor(tenantId,
        ruleChain, systemContext, parent,
        new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null));

    // Assert
    verify(systemContext).getApiUsageClient();
    verify(systemContext).getClusterService();
    verify(systemContext).getRuleChainService();
    RuleNodeException inactiveException = actualRuleChainActorMessageProcessor.getInactiveException();
    RuleChainId ruleChainId = inactiveException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Rule Chain is not active!  Failed to initialize.", inactiveException.getLocalizedMessage());
    assertEquals("Rule Chain is not active!  Failed to initialize.", inactiveException.getMessage());
    assertEquals("Unknown", inactiveException.getRuleNodeName());
    assertNull(actualRuleChainActorMessageProcessor.getComponentName());
    assertNull(inactiveException.getRuleChainName());
    assertNull(inactiveException.getCause());
    assertEquals(0, inactiveException.getSuppressed().length);
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = inactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
    assertSame(id, ruleNodeId.getId());
  }

  /**
   * Test
   * {@link RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef)}.
   * <ul>
   *   <li>When {@link ActorSystemContext} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleChainActorMessageProcessor#RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef)}
   */
  @Test
  @DisplayName("Test new RuleChainActorMessageProcessor(TenantId, RuleChain, ActorSystemContext, TbActorRef, TbActorRef); when ActorSystemContext (default constructor)")
  void testNewRuleChainActorMessageProcessor_whenActorSystemContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChain ruleChain = new RuleChain();
    ActorSystemContext systemContext = new ActorSystemContext();
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act
    RuleChainActorMessageProcessor actualRuleChainActorMessageProcessor = new RuleChainActorMessageProcessor(tenantId,
        ruleChain, systemContext, parent,
        new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null));

    // Assert
    RuleNodeException inactiveException = actualRuleChainActorMessageProcessor.getInactiveException();
    RuleChainId ruleChainId = inactiveException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Rule Chain is not active!  Failed to initialize.", inactiveException.getLocalizedMessage());
    assertEquals("Rule Chain is not active!  Failed to initialize.", inactiveException.getMessage());
    assertEquals("Unknown", inactiveException.getRuleNodeName());
    assertNull(actualRuleChainActorMessageProcessor.getComponentName());
    assertNull(inactiveException.getRuleChainName());
    assertNull(inactiveException.getCause());
    assertEquals(0, inactiveException.getSuppressed().length);
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = inactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
    assertSame(id, ruleNodeId.getId());
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#getComponentName()}.
   * <p>
   * Method under test: {@link RuleChainActorMessageProcessor#getComponentName()}
   */
  @Test
  @DisplayName("Test getComponentName()")
  void testGetComponentName() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChain ruleChain = new RuleChain();
    ActorSystemContext systemContext = new ActorSystemContext();
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox parent = new TbActorMailbox(system, settings, selfId, null, new StatsActor(new ActorSystemContext()),
        null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);

    // Act and Assert
    assertNull((new RuleChainActorMessageProcessor(tenantId, ruleChain, systemContext, parent,
        new TbActorMailbox(system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null)))
        .getComponentName());
  }

  /**
   * Test {@link RuleChainActorMessageProcessor#getInactiveException()}.
   * <p>
   * Method under test:
   * {@link RuleChainActorMessageProcessor#getInactiveException()}
   */
  @Test
  @DisplayName("Test getInactiveException()")
  void testGetInactiveException() {
    // Arrange and Act
    RuleNodeException actualInactiveException = ruleChainActorMessageProcessor.getInactiveException();

    // Assert
    RuleChainId ruleChainId = actualInactiveException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Rule Chain is not active!  Failed to initialize.", actualInactiveException.getLocalizedMessage());
    assertEquals("Rule Chain is not active!  Failed to initialize.", actualInactiveException.getMessage());
    assertEquals("Unknown", actualInactiveException.getRuleNodeName());
    assertNull(actualInactiveException.getRuleChainName());
    assertNull(actualInactiveException.getCause());
    assertEquals(0, actualInactiveException.getSuppressed().length);
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = actualInactiveException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
    assertSame(id, ruleNodeId.getId());
  }
}
