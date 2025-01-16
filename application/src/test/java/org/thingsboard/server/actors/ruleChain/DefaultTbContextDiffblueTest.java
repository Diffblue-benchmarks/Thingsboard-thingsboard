package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.template.Configuration;
import io.netty.channel.EventLoopGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.NotificationCenter;
import org.thingsboard.rule.engine.api.RuleEngineAlarmService;
import org.thingsboard.rule.engine.api.RuleEngineApiUsageStateService;
import org.thingsboard.rule.engine.api.RuleEngineAssetProfileCache;
import org.thingsboard.rule.engine.api.RuleEngineDeviceProfileCache;
import org.thingsboard.rule.engine.api.RuleEngineDeviceStateManager;
import org.thingsboard.rule.engine.api.RuleEngineRpcService;
import org.thingsboard.rule.engine.api.RuleEngineTelemetryService;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.rule.engine.api.notification.SlackService;
import org.thingsboard.rule.engine.api.sms.SmsSenderFactory;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.JsInvokeStats;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorRef;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasRuleEngineProfile;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.common.msg.TbActorMsg;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.alarm.AlarmCommentService;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.dao.alarm.BaseAlarmService;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.cassandra.CassandraCluster;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.domain.DomainServiceImpl;
import org.thingsboard.server.dao.edge.BaseEdgeEventService;
import org.thingsboard.server.dao.edge.EdgeEventService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.event.EventService;
import org.thingsboard.server.dao.mobile.MobileAppService;
import org.thingsboard.server.dao.mobile.MobileAppServiceImpl;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
import org.thingsboard.server.dao.notification.NotificationRequestService;
import org.thingsboard.server.dao.notification.NotificationRuleService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTemplateService;
import org.thingsboard.server.dao.oauth2.OAuth2ClientService;
import org.thingsboard.server.dao.oauth2.OAuth2ClientServiceImpl;
import org.thingsboard.server.dao.ota.BaseOtaPackageService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.dao.queue.BaseQueueStatsService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.queue.QueueStatsService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rpc.BaseRpcService;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.rule.RuleNodeStateService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.service.validator.EdgeEventDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageInfoDataValidator;
import org.thingsboard.server.dao.service.validator.QueueStatsDataValidator;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.edge.EdgeEventInsertRepository;
import org.thingsboard.server.dao.sql.edge.EdgeEventRepository;
import org.thingsboard.server.dao.sql.edge.JpaBaseEdgeEventDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageDao;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageInfoDao;
import org.thingsboard.server.dao.sql.query.DefaultEntityQueryRepository;
import org.thingsboard.server.dao.sql.query.DefaultQueryLogComponent;
import org.thingsboard.server.dao.sql.queue.JpaQueueStatsDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.rpc.JpaRpcDao;
import org.thingsboard.server.dao.sql.rpc.RpcRepository;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateServiceImpl;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.dao.util.DbTypeInfoComponent;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
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
import org.thingsboard.server.service.apiusage.DefaultTbApiUsageStateService;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmCommentService;
import org.thingsboard.server.service.entitiy.entityview.DefaultTbEntityViewService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.executors.ExternalCallExecutorService;
import org.thingsboard.server.service.executors.NotificationExecutorService;
import org.thingsboard.server.service.executors.PubSubRuleNodeExecutorProvider;
import org.thingsboard.server.service.executors.SharedEventLoopGroupService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.mail.MailExecutorService;
import org.thingsboard.server.service.notification.DefaultNotificationCenter;
import org.thingsboard.server.service.notification.provider.DefaultSlackService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.rpc.DefaultTbRuleEngineRpcService;
import org.thingsboard.server.service.sms.DefaultSmsService;
import org.thingsboard.server.service.sms.SmsExecutorService;
import org.thingsboard.server.service.state.DefaultDeviceStateService;
import org.thingsboard.server.service.state.DefaultRuleEngineDeviceStateManager;
import org.thingsboard.server.service.state.DeviceStateService;
import org.thingsboard.server.service.stats.DefaultJsInvokeStats;
import org.thingsboard.server.service.telemetry.DefaultAlarmSubscriptionService;
import org.thingsboard.server.service.telemetry.DefaultTelemetrySubscriptionService;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {DefaultTbContext.class, String.class, RuleNodeCtx.class, TenantId.class,
    RuleNode.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbContextDiffblueTest {
  @MockBean
  private ActorSystemContext actorSystemContext;

  @Autowired
  private DefaultTbContext defaultTbContext;

  @MockBean
  private TbActorRef tbActorRef;

  @MockBean
  private UUID uUID;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultTbContext#DefaultTbContext(ActorSystemContext, String, RuleNodeCtx)}
   *   <li>{@link DefaultTbContext#getRuleChainName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ActorSystemContext mainCtx = new ActorSystemContext();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    TbActorMailbox chainActor = new TbActorMailbox(system, settings, selfId, null,
        new StatsActor(new ActorSystemContext()), null);

    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);
    TbActorMailbox selfActor = new TbActorMailbox(system2, settings2, selfId2, null,
        new StatsActor(new ActorSystemContext()), null);

    // Act and Assert
    assertEquals("Rule Chain Name", (new DefaultTbContext(mainCtx, "Rule Chain Name",
        new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode()))).getRuleChainName());
  }

  /**
   * Test {@link DefaultTbContext#tellSelf(TbMsg, long)}.
   * <ul>
   *   <li>Given {@link ActorSystemContext}
   * {@link ActorSystemContext#scheduleMsgWithDelay(TbActorRef, TbActorMsg, long)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellSelf(TbMsg, long)}
   */
  @Test
  @DisplayName("Test tellSelf(TbMsg, long); given ActorSystemContext scheduleMsgWithDelay(TbActorRef, TbActorMsg, long) does nothing")
  void testTellSelf_givenActorSystemContextScheduleMsgWithDelayDoesNothing() {
    // Arrange
    doNothing().when(actorSystemContext)
        .scheduleMsgWithDelay(Mockito.<TbActorRef>any(), Mockito.<TbActorMsg>any(), anyLong());

    // Act
    defaultTbContext.tellSelf(null, 1L);

    // Assert
    verify(actorSystemContext).scheduleMsgWithDelay(isA(TbActorRef.class), isA(TbActorMsg.class), eq(1L));
  }

  /**
   * Test {@link DefaultTbContext#tellSelf(TbMsg, long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellSelf(TbMsg, long)}
   */
  @Test
  @DisplayName("Test tellSelf(TbMsg, long); then throw IllegalArgumentException")
  void testTellSelf_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(actorSystemContext)
        .scheduleMsgWithDelay(Mockito.<TbActorRef>any(), Mockito.<TbActorMsg>any(), anyLong());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.tellSelf(null, 1L));
    verify(actorSystemContext).scheduleMsgWithDelay(isA(TbActorRef.class), isA(TbActorMsg.class), eq(1L));
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName("Test isLocalEntity(EntityId); then return 'false'")
  void testIsLocalEntity_thenReturnFalse() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(actorSystemContext.resolve(Mockito.<ServiceType>any(), Mockito.<String>any(), Mockito.<TenantId>any(),
        Mockito.<EntityId>any())).thenReturn(buildResult);

    // Act
    boolean actualIsLocalEntityResult = defaultTbContext.isLocalEntity(null);

    // Assert
    verify(actorSystemContext).resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
    assertFalse(actualIsLocalEntityResult);
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName("Test isLocalEntity(EntityId); then return 'true'")
  void testIsLocalEntity_thenReturnTrue() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(actorSystemContext.resolve(Mockito.<ServiceType>any(), Mockito.<String>any(), Mockito.<TenantId>any(),
        Mockito.<EntityId>any())).thenReturn(buildResult);

    // Act
    boolean actualIsLocalEntityResult = defaultTbContext.isLocalEntity(null);

    // Assert
    verify(actorSystemContext).resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    assertTrue(actualIsLocalEntityResult);
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link TbActorRef} {@link TbActorRef#tell(TbActorMsg)} does
   * nothing.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbMsg, Throwable); given TbActorRef tell(TbActorMsg) does nothing; when 'null'")
  void testTellFailure_givenTbActorRefTellDoesNothing_whenNull() {
    // Arrange
    doNothing().when(tbActorRef).tell(Mockito.<TbActorMsg>any());

    // Act
    defaultTbContext.tellFailure(null, null);

    // Assert
    verify(tbActorRef).tell(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link TbActorRef} {@link TbActorRef#tell(TbActorMsg)} does
   * nothing.</li>
   *   <li>When {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbMsg, Throwable); given TbActorRef tell(TbActorMsg) does nothing; when Throwable()")
  void testTellFailure_givenTbActorRefTellDoesNothing_whenThrowable() {
    // Arrange
    doNothing().when(tbActorRef).tell(Mockito.<TbActorMsg>any());

    // Act
    defaultTbContext.tellFailure(null, new Throwable());

    // Assert
    verify(tbActorRef).tell(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link TbActorRef} {@link TbActorRef#tell(TbActorMsg)} does
   * nothing.</li>
   *   <li>When {@link Throwable#Throwable(String)} with empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbMsg, Throwable); given TbActorRef tell(TbActorMsg) does nothing; when Throwable(String) with empty string")
  void testTellFailure_givenTbActorRefTellDoesNothing_whenThrowableWithEmptyString() {
    // Arrange
    doNothing().when(tbActorRef).tell(Mockito.<TbActorMsg>any());

    // Act
    defaultTbContext.tellFailure(null, new Throwable(""));

    // Assert
    verify(tbActorRef).tell(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link TbActorRef} {@link TbActorRef#tell(TbActorMsg)} does
   * nothing.</li>
   *   <li>When {@link Throwable#Throwable(String)} with {@code Failure}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbMsg, Throwable); given TbActorRef tell(TbActorMsg) does nothing; when Throwable(String) with 'Failure'")
  void testTellFailure_givenTbActorRefTellDoesNothing_whenThrowableWithFailure() {
    // Arrange
    doNothing().when(tbActorRef).tell(Mockito.<TbActorMsg>any());

    // Act
    defaultTbContext.tellFailure(null, new Throwable("Failure"));

    // Assert
    verify(tbActorRef).tell(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbMsg, Throwable); then throw IllegalArgumentException")
  void testTellFailure_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("Failure")).when(tbActorRef).tell(Mockito.<TbActorMsg>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, new Throwable()));
    verify(tbActorRef).tell(isA(TbActorMsg.class));
  }

  /**
   * Test {@link DefaultTbContext#updateSelf(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode#RuleNode()}.</li>
   *   <li>Then {@link DefaultTbContext} Self is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#updateSelf(RuleNode)}
   */
  @Test
  @DisplayName("Test updateSelf(RuleNode); when RuleNode(); then DefaultTbContext Self is RuleNode()")
  void testUpdateSelf_whenRuleNode_thenDefaultTbContextSelfIsRuleNode() {
    // Arrange
    RuleNode self = new RuleNode();

    // Act
    defaultTbContext.updateSelf(self);

    // Assert
    assertSame(self, defaultTbContext.getSelf());
  }

  /**
   * Test {@link DefaultTbContext#updateSelf(RuleNode)}.
   * <ul>
   *   <li>When {@link RuleNode}.</li>
   *   <li>Then {@link DefaultTbContext} Self is {@link RuleNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#updateSelf(RuleNode)}
   */
  @Test
  @DisplayName("Test updateSelf(RuleNode); when RuleNode; then DefaultTbContext Self is RuleNode")
  void testUpdateSelf_whenRuleNode_thenDefaultTbContextSelfIsRuleNode2() {
    // Arrange
    RuleNode self = mock(RuleNode.class);

    // Act
    defaultTbContext.updateSelf(self);

    // Assert
    assertSame(self, defaultTbContext.getSelf());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", "Type", null, customerId, new TbMsgMetaData(),
        "Data");

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");

    // Act and Assert
    Map<String, String> data = defaultTbContext.newMsg("Queue Name", "Type", null, customerId, metaData, "Data")
        .getMetaData()
        .getData();
    assertEquals(1, data.size());
    assertEquals("Value", data.get("42"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("", "");
    metaData.putValue("42", "Value");

    // Act and Assert
    Map<String, String> data = defaultTbContext.newMsg("Queue Name", "Type", null, customerId, metaData, "Data")
        .getMetaData()
        .getData();
    assertEquals(2, data.size());
    assertEquals("", data.get(""));
    assertTrue(data.containsKey("42"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(originator.getId()).thenReturn(randomUUIDResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", "Type", originator, null, new TbMsgMetaData(),
        "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(randomUUIDResult, customerId.getId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'; when AlarmId")
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString_whenAlarmId() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", "Type", originator, customerId,
        new TbMsgMetaData(), "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        defaultTbContext.newMsg("Queue Name", "Type", originator, new TbMsgMetaData(), "Data").getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(originator.getId()).thenReturn(randomUUIDResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", "Type", originator, new TbMsgMetaData(), "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(randomUUIDResult, customerId.getId());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", "Type", originator, metaData, "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    Map<String, String> data = actualNewMsgResult.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get("Key"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData},
   * {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString4() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", "Type", originator, metaData, "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    Map<String, String> data = actualNewMsgResult.getMetaData().getData();
    assertEquals(2, data.size());
    assertEquals("Value", data.get("42"));
    assertTrue(data.containsKey("Key"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null,
        customerId, new TbMsgMetaData(), "Data");

    // Assert
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");

    // Act and Assert
    Map<String, String> data = defaultTbContext
        .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, metaData, "Data")
        .getMetaData()
        .getData();
    assertEquals(1, data.size());
    assertEquals("Value", data.get("42"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("", "");
    metaData.putValue("42", "Value");

    // Act and Assert
    Map<String, String> data = defaultTbContext
        .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, null, customerId, metaData, "Data")
        .getMetaData()
        .getData();
    assertEquals(2, data.size());
    assertEquals("", data.get(""));
    assertTrue(data.containsKey("42"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(originator.getId()).thenReturn(randomUUIDResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        null, new TbMsgMetaData(), "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(randomUUIDResult, customerId.getId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId},
   * {@code TbMsgMetaData}, {@code String}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'; when AlarmId")
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString_whenAlarmId() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        customerId, new TbMsgMetaData(), "Data");

    // Assert
    assertSame(customerId, actualNewMsgResult.getCustomerId());
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(originator,
        defaultTbContext
            .newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator, new TbMsgMetaData(), "Data")
            .getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(originator.getId()).thenReturn(randomUUIDResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        new TbMsgMetaData(), "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(randomUUIDResult, customerId.getId());
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString3() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        metaData, "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    Map<String, String> data = actualNewMsgResult.getMetaData().getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get("Key"));
  }

  /**
   * Test
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   * with {@code String}, {@code TbMsgType}, {@code EntityId},
   * {@code TbMsgMetaData}, {@code String}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)}
   */
  @Test
  @DisplayName("Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString4() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.randomUUID());
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("42", "Value");
    metaData.putValue("Key", "42");

    // Act
    TbMsg actualNewMsgResult = defaultTbContext.newMsg("Queue Name", TbMsgType.POST_ATTRIBUTES_REQUEST, originator,
        metaData, "Data");

    // Assert
    verify(originator).getEntityType();
    verify(originator).getId();
    Map<String, String> data = actualNewMsgResult.getMetaData().getData();
    assertEquals(2, data.size());
    assertEquals("Value", data.get("42"));
    assertTrue(data.containsKey("Key"));
  }

  /**
   * Test {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}.
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}
   */
  @Test
  @DisplayName("Test customerCreatedMsg(Customer, RuleNodeId); given CustomerId(UUID) with id is 'null'")
  void testCustomerCreatedMsg_givenCustomerIdWithIdIsNull() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getCreatedTime()).thenReturn(1L);
    when(customer.getExternalId()).thenReturn(new CustomerId(null));
    when(customer.getId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(customer.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbContext.customerCreatedMsg(customer, new RuleNodeId(UUID.randomUUID())));
    verify(customer).getAddress();
    verify(customer).getAddress2();
    verify(customer).getCity();
    verify(customer).getCountry();
    verify(customer).getCreatedTime();
    verify(customer).getEmail();
    verify(customer).getExternalId();
    verify(customer, atLeast(1)).getId();
    verify(customer).getPhone();
    verify(customer).getState();
    verify(customer).getTenantId();
    verify(customer).getTitle();
    verify(customer).getZip();
  }

  /**
   * Test {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}.
   * <ul>
   *   <li>Then return CustomerId is {@link CustomerId#CustomerId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}
   */
  @Test
  @DisplayName("Test customerCreatedMsg(Customer, RuleNodeId); then return CustomerId is CustomerId(UUID) with id is randomUUID")
  void testCustomerCreatedMsg_thenReturnCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    // Arrange
    CustomerId id = new CustomerId(UUID.randomUUID());
    Customer customer = new Customer(id);

    // Act
    TbMsg actualCustomerCreatedMsgResult = defaultTbContext.customerCreatedMsg(customer,
        new RuleNodeId(UUID.randomUUID()));

    // Assert
    assertEquals(id, actualCustomerCreatedMsgResult.getCustomerId());
    assertSame(id, actualCustomerCreatedMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then calls {@link KvEntry#getBooleanValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List); then calls getBooleanValue()")
  void testAttributesUpdatedActionMsg_thenCallsGetBooleanValue() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Boolean> ofResult = Optional.of(true);
    when(attributeKvEntry.getBooleanValue()).thenReturn(ofResult);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(attributeKvEntry);

    // Act
    defaultTbContext.attributesUpdatedActionMsg(originator, ruleNodeId, "Scope", attributes);

    // Assert
    verify(attributeKvEntry).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then return Data is {@code {"Key":1}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List); then return Data is '{\"Key\":1}'")
  void testAttributesUpdatedActionMsg_thenReturnDataIsKey1() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(attributeKvEntry.getLongValue()).thenReturn(ofResult);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(attributeKvEntry);

    // Act
    TbMsg actualAttributesUpdatedActionMsgResult = defaultTbContext.attributesUpdatedActionMsg(originator, ruleNodeId,
        "Scope", attributes);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getLongValue();
    assertEquals("{\"Key\":1}", actualAttributesUpdatedActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then return Data is {@code {}}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List); then return Data is '{}'")
  void testAttributesUpdatedActionMsg_thenReturnDataIsLeftCurlyBracketRightCurlyBracket() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Long> emptyResult = Optional.empty();
    when(attributeKvEntry.getLongValue()).thenReturn(emptyResult);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getDataType()).thenReturn(DataType.LONG);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(attributeKvEntry);

    // Act
    TbMsg actualAttributesUpdatedActionMsgResult = defaultTbContext.attributesUpdatedActionMsg(originator, ruleNodeId,
        "Scope", attributes);

    // Assert
    verify(attributeKvEntry, atLeast(1)).getDataType();
    verify(attributeKvEntry).getKey();
    verify(attributeKvEntry).getLongValue();
    assertEquals("{}", actualAttributesUpdatedActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then return MetaData Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List); then return MetaData Data size is one")
  void testAttributesUpdatedActionMsg_thenReturnMetaDataDataSizeIsOne() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    AttributeKvEntry attributeKvEntry = mock(AttributeKvEntry.class);
    Optional<Boolean> ofResult = Optional.of(true);
    when(attributeKvEntry.getBooleanValue()).thenReturn(ofResult);
    when(attributeKvEntry.getKey()).thenReturn("Key");
    when(attributeKvEntry.getDataType()).thenReturn(DataType.BOOLEAN);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(attributeKvEntry);

    // Act
    TbMsg actualAttributesUpdatedActionMsgResult = defaultTbContext.attributesUpdatedActionMsg(originator, ruleNodeId,
        null, attributes);

    // Assert
    verify(attributeKvEntry).getBooleanValue();
    verify(attributeKvEntry).getDataType();
    verify(attributeKvEntry).getKey();
    Map<String, String> data = actualAttributesUpdatedActionMsgResult.getMetaData().getData();
    assertEquals(1, data.size());
    assertTrue(data.containsKey("ruleNodeId"));
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)")
  void testAttributesDeletedActionMsg() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualAttributesDeletedActionMsgResult = defaultTbContext.attributesDeletedActionMsg(originator, ruleNodeId,
        "Scope", new ArrayList<>());

    // Assert
    assertEquals(originator, actualAttributesDeletedActionMsgResult.getCustomerId());
    assertSame(originator, actualAttributesDeletedActionMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then Originator return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then Originator return AssetId")
  void testAttributesDeletedActionMsg_thenOriginatorReturnAssetId() {
    // Arrange
    AssetService assetService = mock(AssetService.class);
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(null);
    DefaultTbAssetProfileCache defaultTbAssetProfileCache = new DefaultTbAssetProfileCache(
        new AssetProfileServiceImpl(), assetService);

    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    AssetId originator = new AssetId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualAttributesDeletedActionMsgResult = defaultTbContext.attributesDeletedActionMsg(originator, ruleNodeId,
        "Scope", new ArrayList<>());

    // Assert
    verify(actorSystemContext).getAssetProfileCache();
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof AssetId);
    assertEquals(EntityType.ASSET, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then Originator return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then Originator return DeviceId")
  void testAttributesDeletedActionMsg_thenOriginatorReturnDeviceId() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);
    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache = new DefaultTbDeviceProfileCache(
        new DeviceProfileServiceImpl(), deviceService);

    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    DeviceId originator = new DeviceId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualAttributesDeletedActionMsgResult = defaultTbContext.attributesDeletedActionMsg(originator, ruleNodeId,
        "Scope", new ArrayList<>());

    // Assert
    verify(actorSystemContext).getDeviceProfileCache();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof DeviceId);
    assertEquals(EntityType.DEVICE, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   * <ul>
   *   <li>Then return MetaData Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then return MetaData Data size is one")
  void testAttributesDeletedActionMsg_thenReturnMetaDataDataSizeIsOne() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    Map<String, String> data = defaultTbContext
        .attributesDeletedActionMsg(originator, ruleNodeId, null, new ArrayList<>())
        .getMetaData()
        .getData();
    assertEquals(1, data.size());
    assertTrue(data.containsKey("ruleNodeId"));
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType() {
    // Arrange, Act and Assert
    assertNull(defaultTbContext
        .entityActionMsg("Entity", null, new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST)
        .getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType2() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertSame(alarmId,
        defaultTbContext
            .entityActionMsg("Entity", alarmId, new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST)
            .getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(alarmId.getId()).thenReturn(randomUUIDResult);
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg("Entity", alarmId,
        new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Assert
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
    CustomerId customerId = actualEntityActionMsgResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(randomUUIDResult, customerId.getId());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException("ruleNodeId"));
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.entityActionMsg("Entity", alarmId,
        new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile() {
    // Arrange
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertNull(defaultTbContext
        .entityActionMsg("Entity", null, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile())
        .getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile2() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(alarmId,
        defaultTbContext
            .entityActionMsg("Entity", alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile())
            .getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId,
        TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("\"Entity\"", actualEntityActionMsgResult.getData());
    assertNull(actualEntityActionMsgResult.getCustomerId());
    assertSame(alarmId, actualEntityActionMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg(null, alarmId, ruleNodeId,
        TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("null", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile5() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException("ruleNodeId"));
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId,
        TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'; then calls getId()")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile_thenCallsGetId() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST,
        new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'; then calls getId()")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile_thenCallsGetId2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    defaultTbContext.entityActionMsg("Entity", alarmId, new RuleNodeId(UUID.randomUUID()),
        TbMsgType.POST_ATTRIBUTES_REQUEST, null);

    // Assert
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType},
   * {@code profile}.
   * <ul>
   *   <li>Then return Data is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'; then return Data is '1'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile_thenReturnDataIs1() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.<Object, EntityId, HasRuleEngineProfile>entityActionMsg(1,
        alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("1", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <ul>
   *   <li>Then return Data is {@code "Entity"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; then return Data is '\"Entity\"'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_thenReturnDataIsEntity() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg("Entity", alarmId,
        new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("\"Entity\"", actualEntityActionMsgResult.getData());
    assertSame(alarmId, actualEntityActionMsgResult.getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <ul>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; then return Data is 'null'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_thenReturnDataIsNull() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg(null, alarmId,
        new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("null", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Data is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; when one; then return Data is '1'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_whenOne_thenReturnDataIs1() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.<Object, EntityId>entityActionMsg(1, alarmId,
        new RuleNodeId(UUID.randomUUID()), TbMsgType.POST_ATTRIBUTES_REQUEST);

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("1", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile() {
    // Arrange
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertNull(
        defaultTbContext.entityActionMsg("Entity", null, ruleNodeId, "Action", new DeviceProfile()).getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile2() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(alarmId,
        defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId, "Action", new DeviceProfile()).getOriginator());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.<Object, EntityId, HasRuleEngineProfile>entityActionMsg(
        1636990966, alarmId, ruleNodeId, "Action", new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("1636990966", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenThrow(new IllegalArgumentException("ruleNodeId"));
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; then calls getId()")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_thenCallsGetId() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId, "Action", new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; then calls getId()")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_thenCallsGetId2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getId()).thenReturn(UUID.randomUUID());
    when(alarmId.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    defaultTbContext.entityActionMsg("Entity", alarmId, new RuleNodeId(UUID.randomUUID()), "Action", null);

    // Assert
    verify(alarmId).getEntityType();
    verify(alarmId).getId();
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <ul>
   *   <li>Then return Data is {@code "Entity"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; then return Data is '\"Entity\"'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_thenReturnDataIsEntity() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg("Entity", alarmId, ruleNodeId, "Action",
        new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("\"Entity\"", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <ul>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; then return Data is 'null'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_thenReturnDataIsNull() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.entityActionMsg(null, alarmId, ruleNodeId, "Action",
        new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("null", actualEntityActionMsgResult.getData());
  }

  /**
   * Test
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   * with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Data is {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName("Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; when one; then return Data is '1'")
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_whenOne_thenReturnDataIs1() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());

    // Act
    TbMsg actualEntityActionMsgResult = defaultTbContext.<Object, EntityId, HasRuleEngineProfile>entityActionMsg(1,
        alarmId, ruleNodeId, "Action", new DeviceProfile());

    // Assert
    verify(alarmId).getEntityType();
    assertEquals("1", actualEntityActionMsgResult.getData());
  }

  /**
   * Test {@link DefaultTbContext#getSelfId()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getSelfId()}
   */
  @Test
  @DisplayName("Test getSelfId()")
  void testGetSelfId() {
    // Arrange, Act and Assert
    assertNull(defaultTbContext.getSelfId());
  }

  /**
   * Test {@link DefaultTbContext#getSelf()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getSelf()}
   */
  @Test
  @DisplayName("Test getSelf()")
  void testGetSelf() {
    // Arrange and Act
    RuleNode actualSelf = defaultTbContext.getSelf();

    // Assert
    assertNull(actualSelf.getConfigurationBytes());
    assertNull(actualSelf.getAdditionalInfo());
    assertNull(actualSelf.getConfiguration());
    assertNull(actualSelf.getName());
    assertNull(actualSelf.getQueueName());
    assertNull(actualSelf.getType());
    assertNull(actualSelf.getUuidId());
    assertNull(actualSelf.getRuleChainId());
    assertNull(actualSelf.getExternalId());
    assertNull(actualSelf.getId());
    assertEquals(0, actualSelf.getConfigurationVersion());
    assertEquals(0L, actualSelf.getCreatedTime());
    assertFalse(actualSelf.isDebugMode());
    assertFalse(actualSelf.isSingletonMode());
  }

  /**
   * Test {@link DefaultTbContext#getQueueName()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getQueueName()}
   */
  @Test
  @DisplayName("Test getQueueName()")
  void testGetQueueName() {
    // Arrange, Act and Assert
    assertNull(defaultTbContext.getQueueName());
  }

  /**
   * Test {@link DefaultTbContext#getTenantId()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  void testGetTenantId() {
    // Arrange and Act
    TenantId actualTenantId = defaultTbContext.getTenantId();

    // Assert
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   * <ul>
   *   <li>Then return {@link MailExecutorService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then return MailExecutorService")
  void testGetMailExecutor_thenReturnMailExecutorService() {
    // Arrange
    MailExecutorService mailExecutorService = new MailExecutorService();
    when(actorSystemContext.getMailExecutor()).thenReturn(mailExecutorService);

    // Act
    ListeningExecutor actualMailExecutor = defaultTbContext.getMailExecutor();

    // Assert
    verify(actorSystemContext).getMailExecutor();
    assertTrue(actualMailExecutor instanceof MailExecutorService);
    assertNull(((MailExecutorService) actualMailExecutor).executor());
    assertSame(mailExecutorService, actualMailExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then throw IllegalArgumentException")
  void testGetMailExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getMailExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailExecutor());
    verify(actorSystemContext).getMailExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   * <ul>
   *   <li>Then return {@link SmsExecutorService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then return SmsExecutorService")
  void testGetSmsExecutor_thenReturnSmsExecutorService() {
    // Arrange
    SmsExecutorService smsExecutorService = new SmsExecutorService();
    when(actorSystemContext.getSmsExecutor()).thenReturn(smsExecutorService);

    // Act
    ListeningExecutor actualSmsExecutor = defaultTbContext.getSmsExecutor();

    // Assert
    verify(actorSystemContext).getSmsExecutor();
    assertTrue(actualSmsExecutor instanceof SmsExecutorService);
    assertNull(((SmsExecutorService) actualSmsExecutor).executor());
    assertSame(smsExecutorService, actualSmsExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then throw IllegalArgumentException")
  void testGetSmsExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSmsExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsExecutor());
    verify(actorSystemContext).getSmsExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   * <ul>
   *   <li>Then return {@link DbCallbackExecutorService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then return DbCallbackExecutorService")
  void testGetDbCallbackExecutor_thenReturnDbCallbackExecutorService() {
    // Arrange
    DbCallbackExecutorService dbCallbackExecutorService = new DbCallbackExecutorService();
    when(actorSystemContext.getDbCallbackExecutor()).thenReturn(dbCallbackExecutorService);

    // Act
    ListeningExecutor actualDbCallbackExecutor = defaultTbContext.getDbCallbackExecutor();

    // Assert
    verify(actorSystemContext).getDbCallbackExecutor();
    assertTrue(actualDbCallbackExecutor instanceof DbCallbackExecutorService);
    assertNull(((DbCallbackExecutorService) actualDbCallbackExecutor).executor());
    assertSame(dbCallbackExecutorService, actualDbCallbackExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then throw IllegalArgumentException")
  void testGetDbCallbackExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDbCallbackExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDbCallbackExecutor());
    verify(actorSystemContext).getDbCallbackExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   * <ul>
   *   <li>Then return {@link ExternalCallExecutorService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then return ExternalCallExecutorService")
  void testGetExternalCallExecutor_thenReturnExternalCallExecutorService() {
    // Arrange
    ExternalCallExecutorService externalCallExecutorService = new ExternalCallExecutorService();
    when(actorSystemContext.getExternalCallExecutorService()).thenReturn(externalCallExecutorService);

    // Act
    ListeningExecutor actualExternalCallExecutor = defaultTbContext.getExternalCallExecutor();

    // Assert
    verify(actorSystemContext).getExternalCallExecutorService();
    assertTrue(actualExternalCallExecutor instanceof ExternalCallExecutorService);
    assertNull(((ExternalCallExecutorService) actualExternalCallExecutor).executor());
    assertSame(externalCallExecutorService, actualExternalCallExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then throw IllegalArgumentException")
  void testGetExternalCallExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getExternalCallExecutorService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getExternalCallExecutor());
    verify(actorSystemContext).getExternalCallExecutorService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   * <ul>
   *   <li>Then return {@link NotificationExecutorService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then return NotificationExecutorService")
  void testGetNotificationExecutor_thenReturnNotificationExecutorService() {
    // Arrange
    NotificationExecutorService notificationExecutorService = new NotificationExecutorService();
    when(actorSystemContext.getNotificationExecutor()).thenReturn(notificationExecutorService);

    // Act
    ListeningExecutor actualNotificationExecutor = defaultTbContext.getNotificationExecutor();

    // Assert
    verify(actorSystemContext).getNotificationExecutor();
    assertTrue(actualNotificationExecutor instanceof NotificationExecutorService);
    assertNull(((NotificationExecutorService) actualNotificationExecutor).executor());
    assertSame(notificationExecutorService, actualNotificationExecutor);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then throw IllegalArgumentException")
  void testGetNotificationExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationExecutor()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationExecutor());
    verify(actorSystemContext).getNotificationExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   * <ul>
   *   <li>Then return Executor is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then return Executor is 'null'")
  void testGetPubSubRuleNodeExecutorProvider_thenReturnExecutorIsNull() {
    // Arrange
    PubSubRuleNodeExecutorProvider pubSubRuleNodeExecutorProvider = new PubSubRuleNodeExecutorProvider();
    when(actorSystemContext.getPubSubRuleNodeExecutorProvider()).thenReturn(pubSubRuleNodeExecutorProvider);

    // Act
    PubSubRuleNodeExecutorProvider actualPubSubRuleNodeExecutorProvider = defaultTbContext
        .getPubSubRuleNodeExecutorProvider();

    // Assert
    verify(actorSystemContext).getPubSubRuleNodeExecutorProvider();
    assertNull(actualPubSubRuleNodeExecutorProvider.getExecutor());
    assertSame(pubSubRuleNodeExecutorProvider, actualPubSubRuleNodeExecutorProvider);
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then throw IllegalArgumentException")
  void testGetPubSubRuleNodeExecutorProvider_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getPubSubRuleNodeExecutorProvider()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getPubSubRuleNodeExecutorProvider());
    verify(actorSystemContext).getPubSubRuleNodeExecutorProvider();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   * <ul>
   *   <li>Given {@link ActorSystemContext}
   * {@link ActorSystemContext#isStatisticsEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  void testLogJsEvalRequest_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalRequest();

    // Assert that nothing has changed
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   * <ul>
   *   <li>Then calls {@link JsInvokeStats#incrementRequests()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest(); then calls incrementRequests()")
  void testLogJsEvalRequest_thenCallsIncrementRequests() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementRequests();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalRequest();

    // Assert that nothing has changed
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementRequests();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest(); then throw IllegalArgumentException")
  void testLogJsEvalRequest_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalRequest());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   * <ul>
   *   <li>Given {@link ActorSystemContext}
   * {@link ActorSystemContext#isStatisticsEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  void testLogJsEvalResponse_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalResponse();

    // Assert that nothing has changed
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   * <ul>
   *   <li>Then calls {@link JsInvokeStats#incrementResponses()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse(); then calls incrementResponses()")
  void testLogJsEvalResponse_thenCallsIncrementResponses() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementResponses();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalResponse();

    // Assert that nothing has changed
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementResponses();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse(); then throw IllegalArgumentException")
  void testLogJsEvalResponse_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalResponse());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   * <ul>
   *   <li>Given {@link ActorSystemContext}
   * {@link ActorSystemContext#isStatisticsEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  void testLogJsEvalFailure_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalFailure();

    // Assert that nothing has changed
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   * <ul>
   *   <li>Then calls {@link JsInvokeStats#incrementFailures()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure(); then calls incrementFailures()")
  void testLogJsEvalFailure_thenCallsIncrementFailures() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementFailures();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalFailure();

    // Assert that nothing has changed
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementFailures();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure(); then throw IllegalArgumentException")
  void testLogJsEvalFailure_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalFailure());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#getServiceId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId(); then return 'null'")
  void testGetServiceId_thenReturnNull() {
    // Arrange
    when(actorSystemContext.getServiceInfoProvider()).thenReturn(new DefaultTbServiceInfoProvider());

    // Act
    String actualServiceId = defaultTbContext.getServiceId();

    // Assert
    verify(actorSystemContext).getServiceInfoProvider();
    assertNull(actualServiceId);
  }

  /**
   * Test {@link DefaultTbContext#getServiceId()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId(); then throw IllegalArgumentException")
  void testGetServiceId_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getServiceInfoProvider()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getServiceId());
    verify(actorSystemContext).getServiceInfoProvider();
  }

  /**
   * Test {@link DefaultTbContext#getAttributesService()}.
   * <ul>
   *   <li>Then return {@link BaseAttributesService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAttributesService()}
   */
  @Test
  @DisplayName("Test getAttributesService(); then return BaseAttributesService")
  void testGetAttributesService_thenReturnBaseAttributesService() {
    // Arrange
    BaseAttributesService baseAttributesService = new BaseAttributesService(new JpaAttributeDao());
    when(actorSystemContext.getAttributesService()).thenReturn(baseAttributesService);

    // Act
    AttributesService actualAttributesService = defaultTbContext.getAttributesService();

    // Assert
    verify(actorSystemContext).getAttributesService();
    assertTrue(actualAttributesService instanceof BaseAttributesService);
    assertSame(baseAttributesService, actualAttributesService);
  }

  /**
   * Test {@link DefaultTbContext#getAttributesService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAttributesService()}
   */
  @Test
  @DisplayName("Test getAttributesService(); then throw IllegalArgumentException")
  void testGetAttributesService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAttributesService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAttributesService());
    verify(actorSystemContext).getAttributesService();
  }

  /**
   * Test {@link DefaultTbContext#getCustomerService()}.
   * <ul>
   *   <li>Then return {@link CustomerServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getCustomerService()}
   */
  @Test
  @DisplayName("Test getCustomerService(); then return CustomerServiceImpl")
  void testGetCustomerService_thenReturnCustomerServiceImpl() {
    // Arrange
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    when(actorSystemContext.getCustomerService()).thenReturn(customerServiceImpl);

    // Act
    CustomerService actualCustomerService = defaultTbContext.getCustomerService();

    // Assert
    verify(actorSystemContext).getCustomerService();
    assertTrue(actualCustomerService instanceof CustomerServiceImpl);
    assertEquals(EntityType.CUSTOMER, actualCustomerService.getEntityType());
    assertSame(customerServiceImpl, actualCustomerService);
  }

  /**
   * Test {@link DefaultTbContext#getCustomerService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getCustomerService()}
   */
  @Test
  @DisplayName("Test getCustomerService(); then throw IllegalArgumentException")
  void testGetCustomerService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getCustomerService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getCustomerService());
    verify(actorSystemContext).getCustomerService();
  }

  /**
   * Test {@link DefaultTbContext#getTenantService()}.
   * <ul>
   *   <li>Then return {@link TenantServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getTenantService()}
   */
  @Test
  @DisplayName("Test getTenantService(); then return TenantServiceImpl")
  void testGetTenantService_thenReturnTenantServiceImpl() {
    // Arrange
    TenantServiceImpl tenantServiceImpl = new TenantServiceImpl();
    when(actorSystemContext.getTenantService()).thenReturn(tenantServiceImpl);

    // Act
    TenantService actualTenantService = defaultTbContext.getTenantService();

    // Assert
    verify(actorSystemContext).getTenantService();
    assertTrue(actualTenantService instanceof TenantServiceImpl);
    assertEquals(EntityType.TENANT, actualTenantService.getEntityType());
    assertSame(tenantServiceImpl, actualTenantService);
  }

  /**
   * Test {@link DefaultTbContext#getTenantService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getTenantService()}
   */
  @Test
  @DisplayName("Test getTenantService(); then throw IllegalArgumentException")
  void testGetTenantService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantService());
    verify(actorSystemContext).getTenantService();
  }

  /**
   * Test {@link DefaultTbContext#getUserService()}.
   * <ul>
   *   <li>Then return {@link UserServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getUserService()}
   */
  @Test
  @DisplayName("Test getUserService(); then return UserServiceImpl")
  void testGetUserService_thenReturnUserServiceImpl() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userServiceImpl = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    when(actorSystemContext.getUserService()).thenReturn(userServiceImpl);

    // Act
    UserService actualUserService = defaultTbContext.getUserService();

    // Assert
    verify(actorSystemContext).getUserService();
    assertTrue(actualUserService instanceof UserServiceImpl);
    assertEquals(EntityType.USER, actualUserService.getEntityType());
    assertSame(userServiceImpl, actualUserService);
  }

  /**
   * Test {@link DefaultTbContext#getUserService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getUserService()}
   */
  @Test
  @DisplayName("Test getUserService(); then throw IllegalArgumentException")
  void testGetUserService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getUserService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getUserService());
    verify(actorSystemContext).getUserService();
  }

  /**
   * Test {@link DefaultTbContext#getAssetService()}.
   * <ul>
   *   <li>Then return {@link BaseAssetService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAssetService()}
   */
  @Test
  @DisplayName("Test getAssetService(); then return BaseAssetService")
  void testGetAssetService_thenReturnBaseAssetService() {
    // Arrange
    BaseAssetService baseAssetService = new BaseAssetService();
    when(actorSystemContext.getAssetService()).thenReturn(baseAssetService);

    // Act
    AssetService actualAssetService = defaultTbContext.getAssetService();

    // Assert
    verify(actorSystemContext).getAssetService();
    assertTrue(actualAssetService instanceof BaseAssetService);
    assertEquals(EntityType.ASSET, actualAssetService.getEntityType());
    assertSame(baseAssetService, actualAssetService);
  }

  /**
   * Test {@link DefaultTbContext#getAssetService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAssetService()}
   */
  @Test
  @DisplayName("Test getAssetService(); then throw IllegalArgumentException")
  void testGetAssetService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAssetService());
    verify(actorSystemContext).getAssetService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceService()}.
   * <ul>
   *   <li>Then return {@link DeviceServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceService()}
   */
  @Test
  @DisplayName("Test getDeviceService(); then return DeviceServiceImpl")
  void testGetDeviceService_thenReturnDeviceServiceImpl() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceServiceImpl = new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    when(actorSystemContext.getDeviceService()).thenReturn(deviceServiceImpl);

    // Act
    DeviceService actualDeviceService = defaultTbContext.getDeviceService();

    // Assert
    verify(actorSystemContext).getDeviceService();
    assertTrue(actualDeviceService instanceof DeviceServiceImpl);
    assertEquals(EntityType.DEVICE, actualDeviceService.getEntityType());
    assertSame(deviceServiceImpl, actualDeviceService);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceService()}
   */
  @Test
  @DisplayName("Test getDeviceService(); then throw IllegalArgumentException")
  void testGetDeviceService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceService());
    verify(actorSystemContext).getDeviceService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileService()}.
   * <ul>
   *   <li>Then return {@link DeviceProfileServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceProfileService()}
   */
  @Test
  @DisplayName("Test getDeviceProfileService(); then return DeviceProfileServiceImpl")
  void testGetDeviceProfileService_thenReturnDeviceProfileServiceImpl() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();
    when(actorSystemContext.getDeviceProfileService()).thenReturn(deviceProfileServiceImpl);

    // Act
    DeviceProfileService actualDeviceProfileService = defaultTbContext.getDeviceProfileService();

    // Assert
    verify(actorSystemContext).getDeviceProfileService();
    assertTrue(actualDeviceProfileService instanceof DeviceProfileServiceImpl);
    assertEquals(EntityType.DEVICE_PROFILE, actualDeviceProfileService.getEntityType());
    assertSame(deviceProfileServiceImpl, actualDeviceProfileService);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceProfileService()}
   */
  @Test
  @DisplayName("Test getDeviceProfileService(); then throw IllegalArgumentException")
  void testGetDeviceProfileService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceProfileService());
    verify(actorSystemContext).getDeviceProfileService();
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileService()}.
   * <ul>
   *   <li>Then return {@link AssetProfileServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAssetProfileService()}
   */
  @Test
  @DisplayName("Test getAssetProfileService(); then return AssetProfileServiceImpl")
  void testGetAssetProfileService_thenReturnAssetProfileServiceImpl() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();
    when(actorSystemContext.getAssetProfileService()).thenReturn(assetProfileServiceImpl);

    // Act
    AssetProfileService actualAssetProfileService = defaultTbContext.getAssetProfileService();

    // Assert
    verify(actorSystemContext).getAssetProfileService();
    assertTrue(actualAssetProfileService instanceof AssetProfileServiceImpl);
    assertEquals(EntityType.ASSET_PROFILE, actualAssetProfileService.getEntityType());
    assertSame(assetProfileServiceImpl, actualAssetProfileService);
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAssetProfileService()}
   */
  @Test
  @DisplayName("Test getAssetProfileService(); then throw IllegalArgumentException")
  void testGetAssetProfileService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAssetProfileService());
    verify(actorSystemContext).getAssetProfileService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceCredentialsService()}.
   * <ul>
   *   <li>Then return {@link DeviceCredentialsServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceCredentialsService()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsService(); then return DeviceCredentialsServiceImpl")
  void testGetDeviceCredentialsService_thenReturnDeviceCredentialsServiceImpl() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    when(actorSystemContext.getDeviceCredentialsService()).thenReturn(deviceCredentialsServiceImpl);

    // Act
    DeviceCredentialsService actualDeviceCredentialsService = defaultTbContext.getDeviceCredentialsService();

    // Assert
    verify(actorSystemContext).getDeviceCredentialsService();
    assertTrue(actualDeviceCredentialsService instanceof DeviceCredentialsServiceImpl);
    assertSame(deviceCredentialsServiceImpl, actualDeviceCredentialsService);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceCredentialsService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceCredentialsService()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsService(); then throw IllegalArgumentException")
  void testGetDeviceCredentialsService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceCredentialsService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceCredentialsService());
    verify(actorSystemContext).getDeviceCredentialsService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateManager()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceStateManager()}
   */
  @Test
  @DisplayName("Test getDeviceStateManager()")
  void testGetDeviceStateManager() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider3, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    NamedParameterJdbcTemplate jdbcTemplate = mock(NamedParameterJdbcTemplate.class);
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    DefaultEntityQueryRepository entityQueryRepository = new DefaultEntityQueryRepository(jdbcTemplate,
        transactionTemplate, new DefaultQueryLogComponent());

    DbTypeInfoComponent dbTypeInfoComponent = mock(DbTypeInfoComponent.class);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    Optional<DeviceStateService> deviceStateServiceOptional = Optional.of(
        new DefaultDeviceStateService(deviceService, attributesService, tsService, clusterService, partitionService2,
            entityQueryRepository, dbTypeInfoComponent, new DefaultTbApiUsageReportClient(partitionService3,
                serviceInfoProvider5, scheduler, new TbCoreQueueProducerProvider(null)),
            mock(NotificationRuleProcessor.class)));
    TopicService topicService2 = new TopicService();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache2 = new DefaultTbDeviceProfileCache(deviceProfileService2,
        new DeviceServiceImpl(deviceDao2, deviceCredentialsService2, deviceProfileService3, eventService2,
            tenantService2, deviceValidator2, countService2, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService2 = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache2 = new DefaultTbAssetProfileCache(assetProfileService2,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService2 = new EdgeServiceImpl();
    DefaultRuleEngineDeviceStateManager defaultRuleEngineDeviceStateManager = new DefaultRuleEngineDeviceStateManager(
        serviceInfoProvider, partitionService, deviceStateServiceOptional,
        new DefaultTbClusterService(topicService2, deviceProfileCache2, assetProfileCache2,
            gatewayNotificationsService2, edgeService2, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));

    when(actorSystemContext.getDeviceStateManager()).thenReturn(defaultRuleEngineDeviceStateManager);

    // Act
    RuleEngineDeviceStateManager actualDeviceStateManager = defaultTbContext.getDeviceStateManager();

    // Assert
    verify(actorSystemContext).getDeviceStateManager();
    assertTrue(actualDeviceStateManager instanceof DefaultRuleEngineDeviceStateManager);
    assertSame(defaultRuleEngineDeviceStateManager, actualDeviceStateManager);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   * <ul>
   *   <li>Then return {@code Device State Node Rate Limit Config}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName("Test getDeviceStateNodeRateLimitConfig(); then return 'Device State Node Rate Limit Config'")
  void testGetDeviceStateNodeRateLimitConfig_thenReturnDeviceStateNodeRateLimitConfig() {
    // Arrange
    when(actorSystemContext.getDeviceStateNodeRateLimitConfig()).thenReturn("Device State Node Rate Limit Config");

    // Act
    String actualDeviceStateNodeRateLimitConfig = defaultTbContext.getDeviceStateNodeRateLimitConfig();

    // Assert
    verify(actorSystemContext).getDeviceStateNodeRateLimitConfig();
    assertEquals("Device State Node Rate Limit Config", actualDeviceStateNodeRateLimitConfig);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName("Test getDeviceStateNodeRateLimitConfig(); then throw IllegalArgumentException")
  void testGetDeviceStateNodeRateLimitConfig_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceStateNodeRateLimitConfig()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceStateNodeRateLimitConfig());
    verify(actorSystemContext).getDeviceStateNodeRateLimitConfig();
  }

  /**
   * Test {@link DefaultTbContext#getClusterService()}.
   * <ul>
   *   <li>Then return {@link DefaultTbClusterService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getClusterService()}
   */
  @Test
  @DisplayName("Test getClusterService(); then return DefaultTbClusterService")
  void testGetClusterService_thenReturnDefaultTbClusterService() {
    // Arrange
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
    DefaultTbClusterService defaultTbClusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    when(actorSystemContext.getClusterService()).thenReturn(defaultTbClusterService);

    // Act
    TbClusterService actualClusterService = defaultTbContext.getClusterService();

    // Assert
    verify(actorSystemContext).getClusterService();
    assertTrue(actualClusterService instanceof DefaultTbClusterService);
    assertSame(defaultTbClusterService, actualClusterService);
  }

  /**
   * Test {@link DefaultTbContext#getClusterService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getClusterService()}
   */
  @Test
  @DisplayName("Test getClusterService(); then throw IllegalArgumentException")
  void testGetClusterService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getClusterService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getClusterService());
    verify(actorSystemContext).getClusterService();
  }

  /**
   * Test {@link DefaultTbContext#getDashboardService()}.
   * <ul>
   *   <li>Then return {@link DashboardServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDashboardService()}
   */
  @Test
  @DisplayName("Test getDashboardService(); then return DashboardServiceImpl")
  void testGetDashboardService_thenReturnDashboardServiceImpl() {
    // Arrange
    DashboardServiceImpl dashboardServiceImpl = new DashboardServiceImpl();
    when(actorSystemContext.getDashboardService()).thenReturn(dashboardServiceImpl);

    // Act
    DashboardService actualDashboardService = defaultTbContext.getDashboardService();

    // Assert
    verify(actorSystemContext).getDashboardService();
    assertTrue(actualDashboardService instanceof DashboardServiceImpl);
    assertEquals(EntityType.DASHBOARD, actualDashboardService.getEntityType());
    assertSame(dashboardServiceImpl, actualDashboardService);
  }

  /**
   * Test {@link DefaultTbContext#getDashboardService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDashboardService()}
   */
  @Test
  @DisplayName("Test getDashboardService(); then throw IllegalArgumentException")
  void testGetDashboardService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDashboardService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDashboardService());
    verify(actorSystemContext).getDashboardService();
  }

  /**
   * Test {@link DefaultTbContext#getAlarmService()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getAlarmService()}
   */
  @Test
  @DisplayName("Test getAlarmService()")
  void testGetAlarmService() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService alarmService = new BaseAlarmService(tenantService, alarmDao, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    DefaultTbAlarmCommentService alarmCommentService = new DefaultTbAlarmCommentService(new BaseAlarmCommentService());
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
    DefaultTbApiUsageReportClient apiUsageClient = new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler,
        new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings,
            vcSettings, serviceInfoProvider3, transportApiSettings, transportNotificationSettings, edgeSettings,
            new DefaultInMemoryStorage())));

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService3, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider5, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService3, serviceInfoProvider6, scheduler2,
            new TbCoreQueueProducerProvider(null)));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultAlarmSubscriptionService defaultAlarmSubscriptionService = new DefaultAlarmSubscriptionService(alarmService,
        alarmCommentService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService2, tsService, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()),
        mock(NotificationRuleProcessor.class));

    when(actorSystemContext.getAlarmService()).thenReturn(defaultAlarmSubscriptionService);

    // Act
    RuleEngineAlarmService actualAlarmService = defaultTbContext.getAlarmService();

    // Assert
    verify(actorSystemContext).getAlarmService();
    assertTrue(actualAlarmService instanceof DefaultAlarmSubscriptionService);
    assertSame(defaultAlarmSubscriptionService, actualAlarmService);
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   * <ul>
   *   <li>Then return {@link BaseAlarmCommentService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then return BaseAlarmCommentService")
  void testGetAlarmCommentService_thenReturnBaseAlarmCommentService() {
    // Arrange
    BaseAlarmCommentService baseAlarmCommentService = new BaseAlarmCommentService();
    when(actorSystemContext.getAlarmCommentService()).thenReturn(baseAlarmCommentService);

    // Act
    AlarmCommentService actualAlarmCommentService = defaultTbContext.getAlarmCommentService();

    // Assert
    verify(actorSystemContext).getAlarmCommentService();
    assertTrue(actualAlarmCommentService instanceof BaseAlarmCommentService);
    assertSame(baseAlarmCommentService, actualAlarmCommentService);
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then throw IllegalArgumentException")
  void testGetAlarmCommentService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAlarmCommentService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAlarmCommentService());
    verify(actorSystemContext).getAlarmCommentService();
  }

  /**
   * Test {@link DefaultTbContext#getRuleChainService()}.
   * <ul>
   *   <li>Then return {@link BaseRuleChainService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getRuleChainService()}
   */
  @Test
  @DisplayName("Test getRuleChainService(); then return BaseRuleChainService")
  void testGetRuleChainService_thenReturnBaseRuleChainService() {
    // Arrange
    BaseRuleChainService baseRuleChainService = new BaseRuleChainService();
    when(actorSystemContext.getRuleChainService()).thenReturn(baseRuleChainService);

    // Act
    RuleChainService actualRuleChainService = defaultTbContext.getRuleChainService();

    // Assert
    verify(actorSystemContext).getRuleChainService();
    assertTrue(actualRuleChainService instanceof BaseRuleChainService);
    assertEquals(EntityType.RULE_CHAIN, actualRuleChainService.getEntityType());
    assertSame(baseRuleChainService, actualRuleChainService);
  }

  /**
   * Test {@link DefaultTbContext#getRuleChainService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getRuleChainService()}
   */
  @Test
  @DisplayName("Test getRuleChainService(); then throw IllegalArgumentException")
  void testGetRuleChainService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleChainService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRuleChainService());
    verify(actorSystemContext).getRuleChainService();
  }

  /**
   * Test {@link DefaultTbContext#getTimeseriesService()}.
   * <ul>
   *   <li>Then return {@link BaseTimeseriesService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getTimeseriesService()}
   */
  @Test
  @DisplayName("Test getTimeseriesService(); then return BaseTimeseriesService")
  void testGetTimeseriesService_thenReturnBaseTimeseriesService() {
    // Arrange
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();
    when(actorSystemContext.getTsService()).thenReturn(baseTimeseriesService);

    // Act
    TimeseriesService actualTimeseriesService = defaultTbContext.getTimeseriesService();

    // Assert
    verify(actorSystemContext).getTsService();
    assertTrue(actualTimeseriesService instanceof BaseTimeseriesService);
    assertSame(baseTimeseriesService, actualTimeseriesService);
  }

  /**
   * Test {@link DefaultTbContext#getTimeseriesService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getTimeseriesService()}
   */
  @Test
  @DisplayName("Test getTimeseriesService(); then throw IllegalArgumentException")
  void testGetTimeseriesService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTsService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTimeseriesService());
    verify(actorSystemContext).getTsService();
  }

  /**
   * Test {@link DefaultTbContext#getTelemetryService()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getTelemetryService()}
   */
  @Test
  @DisplayName("Test getTelemetryService()")
  void testGetTelemetryService() {
    // Arrange
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultTbEntityViewService tbEntityViewService = new DefaultTbEntityViewService(entityViewService,
        attributesService, null, new BaseTimeseriesService());

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
    DefaultTbApiUsageReportClient apiUsageClient = new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler,
        new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings,
            vcSettings, serviceInfoProvider3, transportApiSettings, transportNotificationSettings, edgeSettings,
            new DefaultInMemoryStorage())));

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService2, tsService3, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider5, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService3, serviceInfoProvider6, scheduler2,
            new TbCoreQueueProducerProvider(null)));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));

    when(actorSystemContext.getTsSubService()).thenReturn(defaultTelemetrySubscriptionService);

    // Act
    RuleEngineTelemetryService actualTelemetryService = defaultTbContext.getTelemetryService();

    // Assert
    verify(actorSystemContext).getTsSubService();
    assertTrue(actualTelemetryService instanceof DefaultTelemetrySubscriptionService);
    assertSame(defaultTelemetrySubscriptionService, actualTelemetryService);
  }

  /**
   * Test {@link DefaultTbContext#getRelationService()}.
   * <ul>
   *   <li>Then return {@link BaseRelationService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getRelationService()}
   */
  @Test
  @DisplayName("Test getRelationService(); then return BaseRelationService")
  void testGetRelationService_thenReturnBaseRelationService() {
    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService baseRelationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    when(actorSystemContext.getRelationService()).thenReturn(baseRelationService);

    // Act
    RelationService actualRelationService = defaultTbContext.getRelationService();

    // Assert
    verify(actorSystemContext).getRelationService();
    assertTrue(actualRelationService instanceof BaseRelationService);
    assertSame(baseRelationService, actualRelationService);
  }

  /**
   * Test {@link DefaultTbContext#getRelationService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getRelationService()}
   */
  @Test
  @DisplayName("Test getRelationService(); then throw IllegalArgumentException")
  void testGetRelationService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRelationService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRelationService());
    verify(actorSystemContext).getRelationService();
  }

  /**
   * Test {@link DefaultTbContext#getEntityViewService()}.
   * <ul>
   *   <li>Then return {@link EntityViewServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEntityViewService()}
   */
  @Test
  @DisplayName("Test getEntityViewService(); then return EntityViewServiceImpl")
  void testGetEntityViewService_thenReturnEntityViewServiceImpl() {
    // Arrange
    EntityViewServiceImpl entityViewServiceImpl = new EntityViewServiceImpl();
    when(actorSystemContext.getEntityViewService()).thenReturn(entityViewServiceImpl);

    // Act
    EntityViewService actualEntityViewService = defaultTbContext.getEntityViewService();

    // Assert
    verify(actorSystemContext).getEntityViewService();
    assertTrue(actualEntityViewService instanceof EntityViewServiceImpl);
    assertEquals(EntityType.ENTITY_VIEW, actualEntityViewService.getEntityType());
    assertSame(entityViewServiceImpl, actualEntityViewService);
  }

  /**
   * Test {@link DefaultTbContext#getEntityViewService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEntityViewService()}
   */
  @Test
  @DisplayName("Test getEntityViewService(); then throw IllegalArgumentException")
  void testGetEntityViewService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEntityViewService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEntityViewService());
    verify(actorSystemContext).getEntityViewService();
  }

  /**
   * Test {@link DefaultTbContext#getResourceService()}.
   * <ul>
   *   <li>Then return {@link BaseResourceService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getResourceService()}
   */
  @Test
  @DisplayName("Test getResourceService(); then return BaseResourceService")
  void testGetResourceService_thenReturnBaseResourceService() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService baseResourceService = new BaseResourceService(resourceDao, resourceInfoDao,
        new ResourceDataValidator());

    when(actorSystemContext.getResourceService()).thenReturn(baseResourceService);

    // Act
    ResourceService actualResourceService = defaultTbContext.getResourceService();

    // Assert
    verify(actorSystemContext).getResourceService();
    assertTrue(actualResourceService instanceof BaseResourceService);
    assertEquals(EntityType.TB_RESOURCE, actualResourceService.getEntityType());
    assertSame(baseResourceService, actualResourceService);
  }

  /**
   * Test {@link DefaultTbContext#getResourceService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getResourceService()}
   */
  @Test
  @DisplayName("Test getResourceService(); then throw IllegalArgumentException")
  void testGetResourceService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getResourceService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getResourceService());
    verify(actorSystemContext).getResourceService();
  }

  /**
   * Test {@link DefaultTbContext#getOtaPackageService()}.
   * <ul>
   *   <li>Then return {@link BaseOtaPackageService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getOtaPackageService()}
   */
  @Test
  @DisplayName("Test getOtaPackageService(); then return BaseOtaPackageService")
  void testGetOtaPackageService_thenReturnBaseOtaPackageService() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    CaffeineOtaPackageCache otaPackageDataCache = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();
    BaseOtaPackageService baseOtaPackageService = new BaseOtaPackageService(otaPackageDao, otaPackageInfoDao,
        otaPackageDataCache, otaPackageInfoValidator, new OtaPackageDataValidator());

    when(actorSystemContext.getOtaPackageService()).thenReturn(baseOtaPackageService);

    // Act
    OtaPackageService actualOtaPackageService = defaultTbContext.getOtaPackageService();

    // Assert
    verify(actorSystemContext).getOtaPackageService();
    assertTrue(actualOtaPackageService instanceof BaseOtaPackageService);
    assertEquals(EntityType.OTA_PACKAGE, actualOtaPackageService.getEntityType());
    assertSame(baseOtaPackageService, actualOtaPackageService);
  }

  /**
   * Test {@link DefaultTbContext#getOtaPackageService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getOtaPackageService()}
   */
  @Test
  @DisplayName("Test getOtaPackageService(); then throw IllegalArgumentException")
  void testGetOtaPackageService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getOtaPackageService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getOtaPackageService());
    verify(actorSystemContext).getOtaPackageService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileCache()}.
   * <ul>
   *   <li>Then return {@link DefaultTbDeviceProfileCache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceProfileCache()}
   */
  @Test
  @DisplayName("Test getDeviceProfileCache(); then return DefaultTbDeviceProfileCache")
  void testGetDeviceProfileCache_thenReturnDefaultTbDeviceProfileCache() {
    // Arrange
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
    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService()));

    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);

    // Act
    RuleEngineDeviceProfileCache actualDeviceProfileCache = defaultTbContext.getDeviceProfileCache();

    // Assert
    verify(actorSystemContext).getDeviceProfileCache();
    assertTrue(actualDeviceProfileCache instanceof DefaultTbDeviceProfileCache);
    assertSame(defaultTbDeviceProfileCache, actualDeviceProfileCache);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileCache()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDeviceProfileCache()}
   */
  @Test
  @DisplayName("Test getDeviceProfileCache(); then throw IllegalArgumentException")
  void testGetDeviceProfileCache_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceProfileCache());
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileCache()}.
   * <ul>
   *   <li>Then return {@link DefaultTbAssetProfileCache}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAssetProfileCache()}
   */
  @Test
  @DisplayName("Test getAssetProfileCache(); then return DefaultTbAssetProfileCache")
  void testGetAssetProfileCache_thenReturnDefaultTbAssetProfileCache() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);

    // Act
    RuleEngineAssetProfileCache actualAssetProfileCache = defaultTbContext.getAssetProfileCache();

    // Assert
    verify(actorSystemContext).getAssetProfileCache();
    assertTrue(actualAssetProfileCache instanceof DefaultTbAssetProfileCache);
    assertSame(defaultTbAssetProfileCache, actualAssetProfileCache);
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileCache()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAssetProfileCache()}
   */
  @Test
  @DisplayName("Test getAssetProfileCache(); then throw IllegalArgumentException")
  void testGetAssetProfileCache_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAssetProfileCache());
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getEdgeService()}.
   * <ul>
   *   <li>Then return {@link EdgeServiceImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEdgeService()}
   */
  @Test
  @DisplayName("Test getEdgeService(); then return EdgeServiceImpl (default constructor)")
  void testGetEdgeService_thenReturnEdgeServiceImpl() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    when(actorSystemContext.getEdgeService()).thenReturn(edgeServiceImpl);

    // Act
    EdgeService actualEdgeService = defaultTbContext.getEdgeService();

    // Assert
    verify(actorSystemContext).getEdgeService();
    assertSame(edgeServiceImpl, actualEdgeService);
  }

  /**
   * Test {@link DefaultTbContext#getEdgeService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEdgeService()}
   */
  @Test
  @DisplayName("Test getEdgeService(); then throw IllegalArgumentException")
  void testGetEdgeService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEdgeService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEdgeService());
    verify(actorSystemContext).getEdgeService();
  }

  /**
   * Test {@link DefaultTbContext#getEdgeEventService()}.
   * <ul>
   *   <li>Then return {@link BaseEdgeEventService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEdgeEventService()}
   */
  @Test
  @DisplayName("Test getEdgeEventService(); then return BaseEdgeEventService")
  void testGetEdgeEventService_thenReturnBaseEdgeEventService() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    BaseEdgeEventService baseEdgeEventService = new BaseEdgeEventService(edgeEventDao, rateLimitService,
        new EdgeEventDataValidator(), mock(ApplicationEventPublisher.class));

    when(actorSystemContext.getEdgeEventService()).thenReturn(baseEdgeEventService);

    // Act
    EdgeEventService actualEdgeEventService = defaultTbContext.getEdgeEventService();

    // Assert
    verify(actorSystemContext).getEdgeEventService();
    assertTrue(actualEdgeEventService instanceof BaseEdgeEventService);
    assertSame(baseEdgeEventService, actualEdgeEventService);
  }

  /**
   * Test {@link DefaultTbContext#getEdgeEventService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEdgeEventService()}
   */
  @Test
  @DisplayName("Test getEdgeEventService(); then throw IllegalArgumentException")
  void testGetEdgeEventService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEdgeEventService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEdgeEventService());
    verify(actorSystemContext).getEdgeEventService();
  }

  /**
   * Test {@link DefaultTbContext#getQueueService()}.
   * <ul>
   *   <li>Then return {@link BaseQueueService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getQueueService()}
   */
  @Test
  @DisplayName("Test getQueueService(); then return BaseQueueService")
  void testGetQueueService_thenReturnBaseQueueService() {
    // Arrange
    BaseQueueService baseQueueService = new BaseQueueService();
    when(actorSystemContext.getQueueService()).thenReturn(baseQueueService);

    // Act
    QueueService actualQueueService = defaultTbContext.getQueueService();

    // Assert
    verify(actorSystemContext).getQueueService();
    assertTrue(actualQueueService instanceof BaseQueueService);
    assertEquals(EntityType.QUEUE, actualQueueService.getEntityType());
    assertSame(baseQueueService, actualQueueService);
  }

  /**
   * Test {@link DefaultTbContext#getQueueService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getQueueService()}
   */
  @Test
  @DisplayName("Test getQueueService(); then throw IllegalArgumentException")
  void testGetQueueService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getQueueService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getQueueService());
    verify(actorSystemContext).getQueueService();
  }

  /**
   * Test {@link DefaultTbContext#getQueueStatsService()}.
   * <ul>
   *   <li>Then return {@link BaseQueueStatsService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getQueueStatsService()}
   */
  @Test
  @DisplayName("Test getQueueStatsService(); then return BaseQueueStatsService")
  void testGetQueueStatsService_thenReturnBaseQueueStatsService() {
    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService baseQueueStatsService = new BaseQueueStatsService(queueStatsDao,
        new QueueStatsDataValidator());

    when(actorSystemContext.getQueueStatsService()).thenReturn(baseQueueStatsService);

    // Act
    QueueStatsService actualQueueStatsService = defaultTbContext.getQueueStatsService();

    // Assert
    verify(actorSystemContext).getQueueStatsService();
    assertTrue(actualQueueStatsService instanceof BaseQueueStatsService);
    assertEquals(EntityType.QUEUE_STATS, actualQueueStatsService.getEntityType());
    assertSame(baseQueueStatsService, actualQueueStatsService);
  }

  /**
   * Test {@link DefaultTbContext#getQueueStatsService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getQueueStatsService()}
   */
  @Test
  @DisplayName("Test getQueueStatsService(); then throw IllegalArgumentException")
  void testGetQueueStatsService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getQueueStatsService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getQueueStatsService());
    verify(actorSystemContext).getQueueStatsService();
  }

  /**
   * Test {@link DefaultTbContext#getSharedEventLoop()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSharedEventLoop()}
   */
  @Test
  @DisplayName("Test getSharedEventLoop(); then return 'null'")
  void testGetSharedEventLoop_thenReturnNull() {
    // Arrange
    when(actorSystemContext.getSharedEventLoopGroupService()).thenReturn(new SharedEventLoopGroupService());

    // Act
    EventLoopGroup actualSharedEventLoop = defaultTbContext.getSharedEventLoop();

    // Assert
    verify(actorSystemContext).getSharedEventLoopGroupService();
    assertNull(actualSharedEventLoop);
  }

  /**
   * Test {@link DefaultTbContext#getSharedEventLoop()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSharedEventLoop()}
   */
  @Test
  @DisplayName("Test getSharedEventLoop(); then throw IllegalArgumentException")
  void testGetSharedEventLoop_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSharedEventLoopGroupService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSharedEventLoop());
    verify(actorSystemContext).getSharedEventLoopGroupService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   * <ul>
   *   <li>Then return {@link DefaultMailService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then return DefaultMailService")
  void testGetMailService_thenReturnDefaultMailService() {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    when(actorSystemContext.getMailService()).thenReturn(defaultMailService);
    when(actorSystemContext.isAllowSystemMailService()).thenReturn(true);

    // Act
    MailService actualMailService = defaultTbContext.getMailService(true);

    // Assert
    verify(actorSystemContext).getMailService();
    verify(actorSystemContext).isAllowSystemMailService();
    assertTrue(actualMailService instanceof DefaultMailService);
    assertSame(defaultMailService, actualMailService);
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then throw IllegalArgumentException")
  void testGetMailService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getMailService()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isAllowSystemMailService()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailService(true));
    verify(actorSystemContext).getMailService();
    verify(actorSystemContext).isAllowSystemMailService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then throw RuntimeException")
  void testGetMailService_thenThrowRuntimeException() {
    // Arrange
    when(actorSystemContext.isAllowSystemMailService()).thenReturn(false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.getMailService(true));
    verify(actorSystemContext).isAllowSystemMailService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link DefaultMailService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); when 'false'; then return DefaultMailService")
  void testGetMailService_whenFalse_thenReturnDefaultMailService() {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    when(actorSystemContext.getMailService()).thenReturn(defaultMailService);

    // Act
    MailService actualMailService = defaultTbContext.getMailService(false);

    // Assert
    verify(actorSystemContext).getMailService();
    assertTrue(actualMailService instanceof DefaultMailService);
    assertSame(defaultMailService, actualMailService);
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   * <ul>
   *   <li>Then return {@link DefaultSmsService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService(); then return DefaultSmsService")
  void testGetSmsService_thenReturnDefaultSmsService() {
    // Arrange
    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService2, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(null)));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService apiUsageStateService2 = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 = new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService3,
        applicationEventPublisher3, queueRoutingInfoService3, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultSmsService defaultSmsService = new DefaultSmsService(smsSenderFactory, adminSettingsService,
        apiUsageStateService2,
        new DefaultTbApiUsageReportClient(partitionService3, serviceInfoProvider5, scheduler2,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider6, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    when(actorSystemContext.getSmsService()).thenReturn(defaultSmsService);
    when(actorSystemContext.isAllowSystemSmsService()).thenReturn(true);

    // Act
    SmsService actualSmsService = defaultTbContext.getSmsService();

    // Assert
    verify(actorSystemContext).getSmsService();
    verify(actorSystemContext).isAllowSystemSmsService();
    assertTrue(actualSmsService instanceof DefaultSmsService);
    assertSame(defaultSmsService, actualSmsService);
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService(); then throw IllegalArgumentException")
  void testGetSmsService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSmsService()).thenThrow(new IllegalArgumentException("foo"));
    when(actorSystemContext.isAllowSystemSmsService()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsService());
    verify(actorSystemContext).getSmsService();
    verify(actorSystemContext).isAllowSystemSmsService();
  }

  /**
   * Test {@link DefaultTbContext#getSmsSenderFactory()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getSmsSenderFactory()}
   */
  @Test
  @DisplayName("Test getSmsSenderFactory()")
  void testGetSmsSenderFactory() {
    // Arrange
    when(actorSystemContext.getSmsSenderFactory()).thenReturn(mock(SmsSenderFactory.class));

    // Act
    defaultTbContext.getSmsSenderFactory();

    // Assert
    verify(actorSystemContext).getSmsSenderFactory();
  }

  /**
   * Test {@link DefaultTbContext#getSmsSenderFactory()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSmsSenderFactory()}
   */
  @Test
  @DisplayName("Test getSmsSenderFactory(); then throw IllegalArgumentException")
  void testGetSmsSenderFactory_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSmsSenderFactory()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsSenderFactory());
    verify(actorSystemContext).getSmsSenderFactory();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationCenter()}.
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationCenter()}
   */
  @Test
  @DisplayName("Test getNotificationCenter()")
  void testGetNotificationCenter() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationTemplateDao notificationTemplateDao3 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(
        notificationTemplateDao3, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    when(actorSystemContext.getNotificationCenter()).thenReturn(defaultNotificationCenter);

    // Act
    NotificationCenter actualNotificationCenter = defaultTbContext.getNotificationCenter();

    // Assert
    verify(actorSystemContext).getNotificationCenter();
    assertTrue(actualNotificationCenter instanceof DefaultNotificationCenter);
    assertEquals(NotificationDeliveryMethod.WEB,
        ((DefaultNotificationCenter) actualNotificationCenter).getDeliveryMethod());
    assertSame(defaultNotificationCenter, actualNotificationCenter);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTargetService()}.
   * <ul>
   *   <li>Then return {@link DefaultNotificationTargetService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationTargetService()}
   */
  @Test
  @DisplayName("Test getNotificationTargetService(); then return DefaultNotificationTargetService")
  void testGetNotificationTargetService_thenReturnDefaultNotificationTargetService() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService defaultNotificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    when(actorSystemContext.getNotificationTargetService()).thenReturn(defaultNotificationTargetService);

    // Act
    NotificationTargetService actualNotificationTargetService = defaultTbContext.getNotificationTargetService();

    // Assert
    verify(actorSystemContext).getNotificationTargetService();
    assertTrue(actualNotificationTargetService instanceof DefaultNotificationTargetService);
    assertEquals(EntityType.NOTIFICATION_TARGET,
        ((DefaultNotificationTargetService) actualNotificationTargetService).getEntityType());
    assertSame(defaultNotificationTargetService, actualNotificationTargetService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTargetService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationTargetService()}
   */
  @Test
  @DisplayName("Test getNotificationTargetService(); then throw IllegalArgumentException")
  void testGetNotificationTargetService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationTargetService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationTargetService());
    verify(actorSystemContext).getNotificationTargetService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTemplateService()}.
   * <ul>
   *   <li>Then return {@link DefaultNotificationTemplateService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationTemplateService()}
   */
  @Test
  @DisplayName("Test getNotificationTemplateService(); then return DefaultNotificationTemplateService")
  void testGetNotificationTemplateService_thenReturnDefaultNotificationTemplateService() {
    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService defaultNotificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    when(actorSystemContext.getNotificationTemplateService()).thenReturn(defaultNotificationTemplateService);

    // Act
    NotificationTemplateService actualNotificationTemplateService = defaultTbContext.getNotificationTemplateService();

    // Assert
    verify(actorSystemContext).getNotificationTemplateService();
    assertTrue(actualNotificationTemplateService instanceof DefaultNotificationTemplateService);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE,
        ((DefaultNotificationTemplateService) actualNotificationTemplateService).getEntityType());
    assertSame(defaultNotificationTemplateService, actualNotificationTemplateService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTemplateService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationTemplateService()}
   */
  @Test
  @DisplayName("Test getNotificationTemplateService(); then throw IllegalArgumentException")
  void testGetNotificationTemplateService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationTemplateService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationTemplateService());
    verify(actorSystemContext).getNotificationTemplateService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRequestService()}.
   * <ul>
   *   <li>Then return {@link DefaultNotificationRequestService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationRequestService()}
   */
  @Test
  @DisplayName("Test getNotificationRequestService(); then return DefaultNotificationRequestService")
  void testGetNotificationRequestService_thenReturnDefaultNotificationRequestService() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService defaultNotificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    when(actorSystemContext.getNotificationRequestService()).thenReturn(defaultNotificationRequestService);

    // Act
    NotificationRequestService actualNotificationRequestService = defaultTbContext.getNotificationRequestService();

    // Assert
    verify(actorSystemContext).getNotificationRequestService();
    assertTrue(actualNotificationRequestService instanceof DefaultNotificationRequestService);
    assertEquals(EntityType.NOTIFICATION_REQUEST,
        ((DefaultNotificationRequestService) actualNotificationRequestService).getEntityType());
    assertSame(defaultNotificationRequestService, actualNotificationRequestService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRequestService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationRequestService()}
   */
  @Test
  @DisplayName("Test getNotificationRequestService(); then throw IllegalArgumentException")
  void testGetNotificationRequestService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationRequestService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationRequestService());
    verify(actorSystemContext).getNotificationRequestService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRuleService()}.
   * <ul>
   *   <li>Then return {@link DefaultNotificationRuleService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationRuleService()}
   */
  @Test
  @DisplayName("Test getNotificationRuleService(); then return DefaultNotificationRuleService")
  void testGetNotificationRuleService_thenReturnDefaultNotificationRuleService() {
    // Arrange
    DefaultNotificationRuleService defaultNotificationRuleService = new DefaultNotificationRuleService(
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class)));
    when(actorSystemContext.getNotificationRuleService()).thenReturn(defaultNotificationRuleService);

    // Act
    NotificationRuleService actualNotificationRuleService = defaultTbContext.getNotificationRuleService();

    // Assert
    verify(actorSystemContext).getNotificationRuleService();
    assertTrue(actualNotificationRuleService instanceof DefaultNotificationRuleService);
    assertEquals(EntityType.NOTIFICATION_RULE,
        ((DefaultNotificationRuleService) actualNotificationRuleService).getEntityType());
    assertSame(defaultNotificationRuleService, actualNotificationRuleService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRuleService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getNotificationRuleService()}
   */
  @Test
  @DisplayName("Test getNotificationRuleService(); then throw IllegalArgumentException")
  void testGetNotificationRuleService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationRuleService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationRuleService());
    verify(actorSystemContext).getNotificationRuleService();
  }

  /**
   * Test {@link DefaultTbContext#getOAuth2ClientService()}.
   * <ul>
   *   <li>Then return {@link OAuth2ClientServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getOAuth2ClientService()}
   */
  @Test
  @DisplayName("Test getOAuth2ClientService(); then return OAuth2ClientServiceImpl")
  void testGetOAuth2ClientService_thenReturnOAuth2ClientServiceImpl() {
    // Arrange
    OAuth2ClientServiceImpl oAuth2ClientServiceImpl = new OAuth2ClientServiceImpl();
    when(actorSystemContext.getOAuth2ClientService()).thenReturn(oAuth2ClientServiceImpl);

    // Act
    OAuth2ClientService actualOAuth2ClientService = defaultTbContext.getOAuth2ClientService();

    // Assert
    verify(actorSystemContext).getOAuth2ClientService();
    assertTrue(actualOAuth2ClientService instanceof OAuth2ClientServiceImpl);
    assertEquals(EntityType.OAUTH2_CLIENT, actualOAuth2ClientService.getEntityType());
    assertSame(oAuth2ClientServiceImpl, actualOAuth2ClientService);
  }

  /**
   * Test {@link DefaultTbContext#getOAuth2ClientService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getOAuth2ClientService()}
   */
  @Test
  @DisplayName("Test getOAuth2ClientService(); then throw IllegalArgumentException")
  void testGetOAuth2ClientService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getOAuth2ClientService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getOAuth2ClientService());
    verify(actorSystemContext).getOAuth2ClientService();
  }

  /**
   * Test {@link DefaultTbContext#getDomainService()}.
   * <ul>
   *   <li>Then return {@link DomainServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDomainService()}
   */
  @Test
  @DisplayName("Test getDomainService(); then return DomainServiceImpl")
  void testGetDomainService_thenReturnDomainServiceImpl() {
    // Arrange
    DomainServiceImpl domainServiceImpl = new DomainServiceImpl();
    when(actorSystemContext.getDomainService()).thenReturn(domainServiceImpl);

    // Act
    DomainService actualDomainService = defaultTbContext.getDomainService();

    // Assert
    verify(actorSystemContext).getDomainService();
    assertTrue(actualDomainService instanceof DomainServiceImpl);
    assertEquals(EntityType.DOMAIN, actualDomainService.getEntityType());
    assertSame(domainServiceImpl, actualDomainService);
  }

  /**
   * Test {@link DefaultTbContext#getDomainService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getDomainService()}
   */
  @Test
  @DisplayName("Test getDomainService(); then throw IllegalArgumentException")
  void testGetDomainService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDomainService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDomainService());
    verify(actorSystemContext).getDomainService();
  }

  /**
   * Test {@link DefaultTbContext#getMobileAppService()}.
   * <ul>
   *   <li>Then return {@link MobileAppServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMobileAppService()}
   */
  @Test
  @DisplayName("Test getMobileAppService(); then return MobileAppServiceImpl")
  void testGetMobileAppService_thenReturnMobileAppServiceImpl() {
    // Arrange
    MobileAppServiceImpl mobileAppServiceImpl = new MobileAppServiceImpl();
    when(actorSystemContext.getMobileAppService()).thenReturn(mobileAppServiceImpl);

    // Act
    MobileAppService actualMobileAppService = defaultTbContext.getMobileAppService();

    // Assert
    verify(actorSystemContext).getMobileAppService();
    assertTrue(actualMobileAppService instanceof MobileAppServiceImpl);
    assertEquals(EntityType.MOBILE_APP, actualMobileAppService.getEntityType());
    assertSame(mobileAppServiceImpl, actualMobileAppService);
  }

  /**
   * Test {@link DefaultTbContext#getMobileAppService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getMobileAppService()}
   */
  @Test
  @DisplayName("Test getMobileAppService(); then throw IllegalArgumentException")
  void testGetMobileAppService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getMobileAppService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMobileAppService());
    verify(actorSystemContext).getMobileAppService();
  }

  /**
   * Test {@link DefaultTbContext#getSlackService()}.
   * <ul>
   *   <li>Then return {@link DefaultSlackService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSlackService()}
   */
  @Test
  @DisplayName("Test getSlackService(); then return DefaultSlackService")
  void testGetSlackService_thenReturnDefaultSlackService() {
    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));

    DefaultSlackService defaultSlackService = new DefaultSlackService(
        new DefaultNotificationSettingsService(adminSettingsService, notificationTargetService,
            notificationTemplateService, defaultNotifications, new UserSettingsServiceImpl(new JpaUserSettingsDao())));
    when(actorSystemContext.getSlackService()).thenReturn(defaultSlackService);

    // Act
    SlackService actualSlackService = defaultTbContext.getSlackService();

    // Assert
    verify(actorSystemContext).getSlackService();
    assertTrue(actualSlackService instanceof DefaultSlackService);
    assertSame(defaultSlackService, actualSlackService);
  }

  /**
   * Test {@link DefaultTbContext#getSlackService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getSlackService()}
   */
  @Test
  @DisplayName("Test getSlackService(); then throw IllegalArgumentException")
  void testGetSlackService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSlackService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSlackService());
    verify(actorSystemContext).getSlackService();
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then return 'false'")
  void testIsExternalNodeForceAck_thenReturnFalse() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck()).thenReturn(false);

    // Act
    boolean actualIsExternalNodeForceAckResult = defaultTbContext.isExternalNodeForceAck();

    // Assert
    verify(actorSystemContext).isExternalNodeForceAck();
    assertFalse(actualIsExternalNodeForceAckResult);
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then return 'true'")
  void testIsExternalNodeForceAck_thenReturnTrue() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck()).thenReturn(true);

    // Act
    boolean actualIsExternalNodeForceAckResult = defaultTbContext.isExternalNodeForceAck();

    // Assert
    verify(actorSystemContext).isExternalNodeForceAck();
    assertTrue(actualIsExternalNodeForceAckResult);
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then throw IllegalArgumentException")
  void testIsExternalNodeForceAck_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.isExternalNodeForceAck());
    verify(actorSystemContext).isExternalNodeForceAck();
  }

  /**
   * Test {@link DefaultTbContext#getRpcService()}.
   * <ul>
   *   <li>Then return {@link DefaultTbRuleEngineRpcService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getRpcService()}
   */
  @Test
  @DisplayName("Test getRpcService(); then return DefaultTbRuleEngineRpcService")
  void testGetRpcService_thenReturnDefaultTbRuleEngineRpcService() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

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
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultTbRuleEngineRpcService defaultTbRuleEngineRpcService = new DefaultTbRuleEngineRpcService(partitionService,
        clusterService, serviceInfoProvider2, new BaseRpcService(new JpaRpcDao(mock(RpcRepository.class))));

    when(actorSystemContext.getTbRuleEngineDeviceRpcService()).thenReturn(defaultTbRuleEngineRpcService);

    // Act
    RuleEngineRpcService actualRpcService = defaultTbContext.getRpcService();

    // Assert
    verify(actorSystemContext).getTbRuleEngineDeviceRpcService();
    assertTrue(actualRpcService instanceof DefaultTbRuleEngineRpcService);
    assertSame(defaultTbRuleEngineRpcService, actualRpcService);
  }

  /**
   * Test {@link DefaultTbContext#getRpcService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getRpcService()}
   */
  @Test
  @DisplayName("Test getRpcService(); then throw IllegalArgumentException")
  void testGetRpcService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTbRuleEngineDeviceRpcService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRpcService());
    verify(actorSystemContext).getTbRuleEngineDeviceRpcService();
  }

  /**
   * Test {@link DefaultTbContext#getCassandraCluster()}.
   * <ul>
   *   <li>Then return KeyspaceName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getCassandraCluster()}
   */
  @Test
  @DisplayName("Test getCassandraCluster(); then return KeyspaceName is 'null'")
  void testGetCassandraCluster_thenReturnKeyspaceNameIsNull() {
    // Arrange
    CassandraCluster cassandraCluster = new CassandraCluster();
    when(actorSystemContext.getCassandraCluster()).thenReturn(cassandraCluster);

    // Act
    CassandraCluster actualCassandraCluster = defaultTbContext.getCassandraCluster();

    // Assert
    verify(actorSystemContext).getCassandraCluster();
    assertNull(actualCassandraCluster.getKeyspaceName());
    assertSame(cassandraCluster, actualCassandraCluster);
  }

  /**
   * Test {@link DefaultTbContext#getCassandraCluster()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getCassandraCluster()}
   */
  @Test
  @DisplayName("Test getCassandraCluster(); then throw IllegalArgumentException")
  void testGetCassandraCluster_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getCassandraCluster()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getCassandraCluster());
    verify(actorSystemContext).getCassandraCluster();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStates(PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#findRuleNodeStates(PageLink)}
   */
  @Test
  @DisplayName("Test findRuleNodeStates(PageLink); then return EMPTY_PAGE_DATA")
  void testFindRuleNodeStates_thenReturnEmpty_page_data() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    PageData<RuleNodeState> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeStateService.findByRuleNodeId(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);

    // Act
    PageData<RuleNodeState> actualFindRuleNodeStatesResult = defaultTbContext.findRuleNodeStates(new PageLink(3));

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeStateService).findByRuleNodeId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindRuleNodeStatesResult.EMPTY_PAGE_DATA, actualFindRuleNodeStatesResult);
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}.
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test findRuleNodeStateForEntity(EntityId); then return RuleNodeState()")
  void testFindRuleNodeStateForEntity_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateService.findByRuleNodeIdAndEntityId(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any(),
        Mockito.<EntityId>any())).thenReturn(ruleNodeState);
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);

    // Act
    RuleNodeState actualFindRuleNodeStateForEntityResult = defaultTbContext.findRuleNodeStateForEntity(null);

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeStateService).findByRuleNodeIdAndEntityId(isA(TenantId.class), isNull(), isNull());
    assertSame(ruleNodeState, actualFindRuleNodeStateForEntityResult);
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName("Test saveRuleNodeState(RuleNodeState); then return RuleNodeState()")
  void testSaveRuleNodeState_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateService.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any())).thenReturn(ruleNodeState);
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);

    // Act
    RuleNodeState actualSaveRuleNodeStateResult = defaultTbContext.saveRuleNodeState(new RuleNodeState());

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeStateService).save(isA(TenantId.class), isA(RuleNodeState.class));
    assertSame(ruleNodeState, actualSaveRuleNodeStateResult);
  }

  /**
   * Test {@link DefaultTbContext#clearRuleNodeStates()}.
   * <ul>
   *   <li>Then calls
   * {@link RuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#clearRuleNodeStates()}
   */
  @Test
  @DisplayName("Test clearRuleNodeStates(); then calls removeByRuleNodeId(TenantId, RuleNodeId)")
  void testClearRuleNodeStates_thenCallsRemoveByRuleNodeId() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    doNothing().when(ruleNodeStateService).removeByRuleNodeId(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any());
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);

    // Act
    defaultTbContext.clearRuleNodeStates();

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeStateService).removeByRuleNodeId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DefaultTbContext#clearRuleNodeStates()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#clearRuleNodeStates()}
   */
  @Test
  @DisplayName("Test clearRuleNodeStates(); then throw IllegalArgumentException")
  void testClearRuleNodeStates_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.clearRuleNodeStates());
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}.
   * <ul>
   *   <li>Then calls
   * {@link RuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test removeRuleNodeStateForEntity(EntityId); then calls removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)")
  void testRemoveRuleNodeStateForEntity_thenCallsRemoveByRuleNodeIdAndEntityId() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    doNothing().when(ruleNodeStateService)
        .removeByRuleNodeIdAndEntityId(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any(), Mockito.<EntityId>any());
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);

    // Act
    defaultTbContext.removeRuleNodeStateForEntity(null);

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeStateService).removeByRuleNodeIdAndEntityId(isA(TenantId.class), isNull(), isNull());
  }

  /**
   * Test {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test removeRuleNodeStateForEntity(EntityId); then throw IllegalArgumentException")
  void testRemoveRuleNodeStateForEntity_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#addTenantProfileListener(Consumer)}.
   * <ul>
   *   <li>Then calls
   * {@link TbTenantProfileCache#addListener(TenantId, EntityId, Consumer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#addTenantProfileListener(Consumer)}
   */
  @Test
  @DisplayName("Test addTenantProfileListener(Consumer); then calls addListener(TenantId, EntityId, Consumer)")
  void testAddTenantProfileListener_thenCallsAddListener() {
    // Arrange
    TbTenantProfileCache tbTenantProfileCache = mock(TbTenantProfileCache.class);
    doNothing().when(tbTenantProfileCache)
        .addListener(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Consumer<TenantProfile>>any());
    when(actorSystemContext.getTenantProfileCache()).thenReturn(tbTenantProfileCache);

    // Act
    defaultTbContext.addTenantProfileListener(mock(Consumer.class));

    // Assert
    verify(actorSystemContext).getTenantProfileCache();
    verify(tbTenantProfileCache).addListener(isA(TenantId.class), isNull(), isA(Consumer.class));
  }

  /**
   * Test {@link DefaultTbContext#addTenantProfileListener(Consumer)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#addTenantProfileListener(Consumer)}
   */
  @Test
  @DisplayName("Test addTenantProfileListener(Consumer); then throw IllegalArgumentException")
  void testAddTenantProfileListener_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.addTenantProfileListener(mock(Consumer.class)));
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test
   * {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   * <ul>
   *   <li>Then calls
   * {@link RuleEngineDeviceProfileCache#addListener(TenantId, EntityId, Consumer, BiConsumer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addDeviceProfileListeners(Consumer, BiConsumer); then calls addListener(TenantId, EntityId, Consumer, BiConsumer)")
  void testAddDeviceProfileListeners_thenCallsAddListener() {
    // Arrange
    TbDeviceProfileCache tbDeviceProfileCache = mock(TbDeviceProfileCache.class);
    doNothing().when(tbDeviceProfileCache)
        .addListener(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Consumer<DeviceProfile>>any(),
            Mockito.<BiConsumer<DeviceId, DeviceProfile>>any());
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(tbDeviceProfileCache);

    // Act
    defaultTbContext.addDeviceProfileListeners(mock(Consumer.class), mock(BiConsumer.class));

    // Assert
    verify(tbDeviceProfileCache).addListener(isA(TenantId.class), isNull(), isA(Consumer.class), isA(BiConsumer.class));
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test
   * {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addDeviceProfileListeners(Consumer, BiConsumer); then throw IllegalArgumentException")
  void testAddDeviceProfileListeners_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTbContext.addDeviceProfileListeners(mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   * <ul>
   *   <li>Then calls
   * {@link RuleEngineAssetProfileCache#addListener(TenantId, EntityId, Consumer, BiConsumer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addAssetProfileListeners(Consumer, BiConsumer); then calls addListener(TenantId, EntityId, Consumer, BiConsumer)")
  void testAddAssetProfileListeners_thenCallsAddListener() {
    // Arrange
    TbAssetProfileCache tbAssetProfileCache = mock(TbAssetProfileCache.class);
    doNothing().when(tbAssetProfileCache)
        .addListener(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Consumer<AssetProfile>>any(),
            Mockito.<BiConsumer<AssetId, AssetProfile>>any());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(tbAssetProfileCache);

    // Act
    defaultTbContext.addAssetProfileListeners(mock(Consumer.class), mock(BiConsumer.class));

    // Assert
    verify(tbAssetProfileCache).addListener(isA(TenantId.class), isNull(), isA(Consumer.class), isA(BiConsumer.class));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addAssetProfileListeners(Consumer, BiConsumer); then throw IllegalArgumentException")
  void testAddAssetProfileListeners_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultTbContext.addAssetProfileListeners(mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getAssetProfileCache()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners(); then calls getAssetProfileCache()")
  void testRemoveListeners_thenCallsGetAssetProfileCache() {
    // Arrange
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    when(actorSystemContext.getTenantProfileCache())
        .thenReturn(new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()));
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    when(actorSystemContext.getAssetProfileCache())
        .thenReturn(new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService()));
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
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService())));

    // Act
    defaultTbContext.removeListeners();

    // Assert that nothing has changed
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners(); then throw IllegalArgumentException")
  void testRemoveListeners_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException("foo"));
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    when(actorSystemContext.getAssetProfileCache())
        .thenReturn(new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService()));
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
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService())));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getTenantProfile()}.
   * <ul>
   *   <li>Given {@link TenantService}
   * {@link TenantService#findTenantById(TenantId)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getTenantProfile()}
   */
  @Test
  @DisplayName("Test getTenantProfile(); given TenantService findTenantById(TenantId) return 'null'; then return 'null'")
  void testGetTenantProfile_givenTenantServiceFindTenantByIdReturnNull_thenReturnNull() {
    // Arrange
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache = new DefaultTbTenantProfileCache(
        new TenantProfileServiceImpl(), tenantService);

    when(actorSystemContext.getTenantProfileCache()).thenReturn(defaultTbTenantProfileCache);

    // Act
    TenantProfile actualTenantProfile = defaultTbContext.getTenantProfile();

    // Assert
    verify(actorSystemContext).getTenantProfileCache();
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertNull(actualTenantProfile);
  }

  /**
   * Test {@link DefaultTbContext#getTenantProfile()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getTenantProfile()}
   */
  @Test
  @DisplayName("Test getTenantProfile(); then throw IllegalArgumentException")
  void testGetTenantProfile_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantProfile());
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getWidgetBundleService()}.
   * <ul>
   *   <li>Then return {@link WidgetsBundleServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getWidgetBundleService()}
   */
  @Test
  @DisplayName("Test getWidgetBundleService(); then return WidgetsBundleServiceImpl")
  void testGetWidgetBundleService_thenReturnWidgetsBundleServiceImpl() {
    // Arrange
    WidgetsBundleServiceImpl widgetsBundleServiceImpl = new WidgetsBundleServiceImpl();
    when(actorSystemContext.getWidgetsBundleService()).thenReturn(widgetsBundleServiceImpl);

    // Act
    WidgetsBundleService actualWidgetBundleService = defaultTbContext.getWidgetBundleService();

    // Assert
    verify(actorSystemContext).getWidgetsBundleService();
    assertTrue(actualWidgetBundleService instanceof WidgetsBundleServiceImpl);
    assertEquals(EntityType.WIDGETS_BUNDLE, actualWidgetBundleService.getEntityType());
    assertSame(widgetsBundleServiceImpl, actualWidgetBundleService);
  }

  /**
   * Test {@link DefaultTbContext#getWidgetBundleService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getWidgetBundleService()}
   */
  @Test
  @DisplayName("Test getWidgetBundleService(); then throw IllegalArgumentException")
  void testGetWidgetBundleService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getWidgetsBundleService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getWidgetBundleService());
    verify(actorSystemContext).getWidgetsBundleService();
  }

  /**
   * Test {@link DefaultTbContext#getWidgetTypeService()}.
   * <ul>
   *   <li>Then return {@link WidgetTypeServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getWidgetTypeService()}
   */
  @Test
  @DisplayName("Test getWidgetTypeService(); then return WidgetTypeServiceImpl")
  void testGetWidgetTypeService_thenReturnWidgetTypeServiceImpl() {
    // Arrange
    WidgetTypeServiceImpl widgetTypeServiceImpl = new WidgetTypeServiceImpl();
    when(actorSystemContext.getWidgetTypeService()).thenReturn(widgetTypeServiceImpl);

    // Act
    WidgetTypeService actualWidgetTypeService = defaultTbContext.getWidgetTypeService();

    // Assert
    verify(actorSystemContext).getWidgetTypeService();
    assertTrue(actualWidgetTypeService instanceof WidgetTypeServiceImpl);
    assertEquals(EntityType.WIDGET_TYPE, actualWidgetTypeService.getEntityType());
    assertSame(widgetTypeServiceImpl, actualWidgetTypeService);
  }

  /**
   * Test {@link DefaultTbContext#getWidgetTypeService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getWidgetTypeService()}
   */
  @Test
  @DisplayName("Test getWidgetTypeService(); then throw IllegalArgumentException")
  void testGetWidgetTypeService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getWidgetTypeService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getWidgetTypeService());
    verify(actorSystemContext).getWidgetTypeService();
  }

  /**
   * Test {@link DefaultTbContext#getRuleEngineApiUsageStateService()}.
   * <ul>
   *   <li>Then return {@link DefaultTbApiUsageStateService}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#getRuleEngineApiUsageStateService()}
   */
  @Test
  @DisplayName("Test getRuleEngineApiUsageStateService(); then return DefaultTbApiUsageStateService")
  void testGetRuleEngineApiUsageStateService_thenReturnDefaultTbApiUsageStateService() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService2, tsService2, new ApiUsageDataValidator());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService2,
        applicationEventPublisher2, queueRoutingInfoService2, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService defaultTbApiUsageStateService = new DefaultTbApiUsageStateService(partitionService,
        tenantService, tsService, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);

    // Act
    RuleEngineApiUsageStateService actualRuleEngineApiUsageStateService = defaultTbContext
        .getRuleEngineApiUsageStateService();

    // Assert
    verify(actorSystemContext).getApiUsageStateService();
    assertTrue(actualRuleEngineApiUsageStateService instanceof DefaultTbApiUsageStateService);
    assertSame(defaultTbApiUsageStateService, actualRuleEngineApiUsageStateService);
  }

  /**
   * Test {@link DefaultTbContext#getRuleEngineApiUsageStateService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbContext#getRuleEngineApiUsageStateService()}
   */
  @Test
  @DisplayName("Test getRuleEngineApiUsageStateService(); then throw IllegalArgumentException")
  void testGetRuleEngineApiUsageStateService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getApiUsageStateService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRuleEngineApiUsageStateService());
    verify(actorSystemContext).getApiUsageStateService();
  }

  /**
   * Test {@link DefaultTbContext#getEntityService()}.
   * <ul>
   *   <li>Then return {@link BaseEntityService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEntityService()}
   */
  @Test
  @DisplayName("Test getEntityService(); then return BaseEntityService")
  void testGetEntityService_thenReturnBaseEntityService() {
    // Arrange
    BaseEntityService baseEntityService = new BaseEntityService();
    when(actorSystemContext.getEntityService()).thenReturn(baseEntityService);

    // Act
    EntityService actualEntityService = defaultTbContext.getEntityService();

    // Assert
    verify(actorSystemContext).getEntityService();
    assertTrue(actualEntityService instanceof BaseEntityService);
    assertSame(baseEntityService, actualEntityService);
  }

  /**
   * Test {@link DefaultTbContext#getEntityService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEntityService()}
   */
  @Test
  @DisplayName("Test getEntityService(); then throw IllegalArgumentException")
  void testGetEntityService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEntityService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEntityService());
    verify(actorSystemContext).getEntityService();
  }

  /**
   * Test {@link DefaultTbContext#getEventService()}.
   * <ul>
   *   <li>Then return {@link BaseEventService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEventService()}
   */
  @Test
  @DisplayName("Test getEventService(); then return BaseEventService")
  void testGetEventService_thenReturnBaseEventService() {
    // Arrange
    BaseEventService baseEventService = new BaseEventService();
    when(actorSystemContext.getEventService()).thenReturn(baseEventService);

    // Act
    EventService actualEventService = defaultTbContext.getEventService();

    // Assert
    verify(actorSystemContext).getEventService();
    assertTrue(actualEventService instanceof BaseEventService);
    assertNull(((BaseEventService) actualEventService).eventDao);
    assertSame(baseEventService, actualEventService);
  }

  /**
   * Test {@link DefaultTbContext#getEventService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getEventService()}
   */
  @Test
  @DisplayName("Test getEventService(); then throw IllegalArgumentException")
  void testGetEventService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEventService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEventService());
    verify(actorSystemContext).getEventService();
  }

  /**
   * Test {@link DefaultTbContext#getAuditLogService()}.
   * <ul>
   *   <li>Then return {@link AuditLogServiceImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAuditLogService()}
   */
  @Test
  @DisplayName("Test getAuditLogService(); then return AuditLogServiceImpl")
  void testGetAuditLogService_thenReturnAuditLogServiceImpl() {
    // Arrange
    AuditLogServiceImpl auditLogServiceImpl = new AuditLogServiceImpl();
    when(actorSystemContext.getAuditLogService()).thenReturn(auditLogServiceImpl);

    // Act
    AuditLogService actualAuditLogService = defaultTbContext.getAuditLogService();

    // Assert
    verify(actorSystemContext).getAuditLogService();
    assertTrue(actualAuditLogService instanceof AuditLogServiceImpl);
    assertSame(auditLogServiceImpl, actualAuditLogService);
  }

  /**
   * Test {@link DefaultTbContext#getAuditLogService()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbContext#getAuditLogService()}
   */
  @Test
  @DisplayName("Test getAuditLogService(); then throw IllegalArgumentException")
  void testGetAuditLogService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAuditLogService()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAuditLogService());
    verify(actorSystemContext).getAuditLogService();
  }
}
