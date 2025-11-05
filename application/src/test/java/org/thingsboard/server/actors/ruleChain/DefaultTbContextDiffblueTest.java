package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import freemarker.template.Configuration;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.api.notification.SlackService;
import org.thingsboard.rule.engine.api.sms.SmsSender;
import org.thingsboard.rule.engine.api.sms.SmsSenderFactory;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.DefaultTbActorSystem;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.actors.TbActorSystemSettings;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasRuleEngineProfile;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.data.sms.config.AwsSnsSmsProviderConfiguration;
import org.thingsboard.server.common.data.sms.config.SmsProviderConfiguration;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
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
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.event.EventService;
import org.thingsboard.server.dao.mobile.MobileAppService;
import org.thingsboard.server.dao.mobile.MobileAppServiceImpl;
import org.thingsboard.server.dao.model.sql.ApiUsageStateEntity;
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
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rpc.BaseRpcService;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.BaseRuleNodeStateService;
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
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.rpc.DefaultTbRuleEngineRpcService;
import org.thingsboard.server.service.sms.DefaultSmsService;
import org.thingsboard.server.service.sms.SmsExecutorService;
import org.thingsboard.server.service.sms.aws.AwsSmsSender;
import org.thingsboard.server.service.stats.DefaultJsInvokeStats;
import org.thingsboard.server.service.telemetry.DefaultAlarmSubscriptionService;
import org.thingsboard.server.service.telemetry.DefaultTelemetrySubscriptionService;

@ContextConfiguration(classes = {DefaultTbContext.class, String.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class DefaultTbContextDiffblueTest {
  @MockBean private ActorSystemContext actorSystemContext;

  @Mock private ActorSystemContext actorSystemContext2;

  @Autowired private DefaultTbContext defaultTbContext;

  @InjectMocks private DefaultTbContext defaultTbContext2;

  @MockBean private RuleNodeCtx ruleNodeCtx;

  @Mock private RuleNodeCtx ruleNodeCtx2;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultTbContext#DefaultTbContext(ActorSystemContext, String, RuleNodeCtx)}
   *   <li>{@link DefaultTbContext#getRuleChainName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.<init>(ActorSystemContext, String, RuleNodeCtx)",
    "String DefaultTbContext.getRuleChainName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ActorSystemContext mainCtx = new ActorSystemContext();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings2, selfId2, null, new StatsActor(new ActorSystemContext()), null);

    RuleNodeCtx nodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());

    // Act
    DefaultTbContext actualDefaultTbContext =
        new DefaultTbContext(mainCtx, "Rule Chain Name", nodeCtx);

    // Assert
    assertEquals("Rule Chain Name", actualDefaultTbContext.getRuleChainName());
  }

  /**
   * Test {@link DefaultTbContext#input(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getChainActor()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#input(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test input(TbMsg, RuleChainId); given RuleNodeCtx getChainActor() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.input(TbMsg, RuleChainId)"})
  void testInput_givenRuleNodeCtxGetChainActorThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    TbMsg msg = mock(TbMsg.class);
    doNothing().when(msg).pushToStack(Mockito.<RuleChainId>any(), Mockito.<RuleNodeId>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.input(
                msg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(msg).pushToStack(isNull(), isNull());
  }

  /**
   * Test {@link DefaultTbContext#input(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#input(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName(
      "Test input(TbMsg, RuleChainId); given RuleNodeCtx getSelf() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.input(TbMsg, RuleChainId)"})
  void testInput_givenRuleNodeCtxGetSelfThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.input(
                null, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#input(TbMsg, RuleChainId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeCtx#getChainActor()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#input(TbMsg, RuleChainId)}
   */
  @Test
  @DisplayName("Test input(TbMsg, RuleChainId); then calls getChainActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.input(TbMsg, RuleChainId)"})
  void testInput_thenCallsGetChainActor() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    when(ruleNodeCtx.getChainActor()).thenReturn(tbActorMailbox);
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    TbMsg msg = mock(TbMsg.class);
    doNothing().when(msg).pushToStack(Mockito.<RuleChainId>any(), Mockito.<RuleNodeId>any());

    // Act
    defaultTbContext.input(
        msg, new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(msg).pushToStack(isNull(), isNull());
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName("Test output(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any());

    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.output(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build(),
                "Relation Type"));
    verify(actorSystemContext)
        .persistDebugOutput(isA(TenantId.class), isNull(), isA(TbMsg.class), eq("Relation Type"));
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName("Test output(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput2() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any());

    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    when(ruleNodeCtx.getChainActor()).thenReturn(tbActorMailbox);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);

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

    // Act
    defaultTbContext.output(
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build(),
        "Relation Type");

    // Assert
    verify(actorSystemContext)
        .persistDebugOutput(isA(TenantId.class), isNull(), isA(TbMsg.class), eq("Relation Type"));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext}.
   *   <li>Then calls {@link RuleNodeCtx#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName("Test output(TbMsg, String); given ActorSystemContext; then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput_givenActorSystemContext_thenCallsGetSelf() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

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

    // Act
    defaultTbContext.output(
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build(),
        "Relation Type");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getChainActor()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test output(TbMsg, String); given RuleNodeCtx getChainActor() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput_givenRuleNodeCtxGetChainActorThrowIllegalArgumentException() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any());

    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.output(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build(),
                "Relation Type"));
    verify(actorSystemContext)
        .persistDebugOutput(isA(TenantId.class), isNull(), isA(TbMsg.class), eq("Relation Type"));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test output(TbMsg, String); given RuleNodeCtx getSelf() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput_givenRuleNodeCtxGetSelfThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.output(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build(),
                "Relation Type"));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test output(TbMsg, String); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.output(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build(),
                "Relation Type"));
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()} DebugMode is {@code false}.
   *   <li>Then calls {@link RuleNodeCtx#getChainActor()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test output(TbMsg, String); given RuleNode() DebugMode is 'false'; then calls getChainActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput_givenRuleNodeDebugModeIsFalse_thenCallsGetChainActor() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(false);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    when(ruleNodeCtx.getChainActor()).thenReturn(tbActorMailbox);
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    TbMsgProcessingCtx ctx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ctx.push(ruleChainId, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder ctxResult =
        callbackResult
            .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .ctx(ctx);

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

    // Act
    defaultTbContext.output(
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build(),
        "Relation Type");

    // Assert
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#output(TbMsg, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg,
   *       String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#output(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test output(TbMsg, String); then calls persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.output(TbMsg, String)"})
  void testOutput_thenCallsPersistDebugOutput() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

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

    // Act
    defaultTbContext.output(
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build(),
        "Relation Type");

    // Assert
    verify(actorSystemContext)
        .persistDebugOutput(isA(TenantId.class), isNull(), isA(TbMsg.class), eq("ACK"), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)} with {@code tbMsg}, {@code
   * onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)}
   */
  @Test
  @DisplayName("Test enqueue(TbMsg, Runnable, Consumer) with 'tbMsg', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, Runnable, Consumer)"})
  void testEnqueueWithTbMsgOnSuccessOnFailure() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueue(null, mock(Runnable.class), mock(Consumer.class)));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)} with {@code tbMsg}, {@code
   * onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)}
   */
  @Test
  @DisplayName("Test enqueue(TbMsg, Runnable, Consumer) with 'tbMsg', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, Runnable, Consumer)"})
  void testEnqueueWithTbMsgOnSuccessOnFailure2() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueue(null, mock(Runnable.class), mock(Consumer.class)));
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)} with {@code tbMsg}, {@code
   * onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)}
   */
  @Test
  @DisplayName("Test enqueue(TbMsg, Runnable, Consumer) with 'tbMsg', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, Runnable, Consumer)"})
  void testEnqueueWithTbMsgOnSuccessOnFailure3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getId()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueue(tbMsg, mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)} with {@code tbMsg}, {@code
   * onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueue(TbMsg, Runnable, Consumer) with 'tbMsg', 'onSuccess', 'onFailure'; given 'false'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, Runnable, Consumer)"})
  void testEnqueueWithTbMsgOnSuccessOnFailure_givenFalse_thenCallsAccept() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getOriginator()).thenReturn(null);
    Runnable onSuccess = mock(Runnable.class);

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    defaultTbContext.enqueue(tbMsg, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)} with {@code tbMsg}, {@code
   * onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsg#getTs()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueue(TbMsg, Runnable, Consumer) with 'tbMsg', 'onSuccess', 'onFailure'; then calls getTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, Runnable, Consumer)"})
  void testEnqueueWithTbMsgOnSuccessOnFailure_thenCallsGetTs() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueue(tbMsg, mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, String, Runnable, Consumer)} with {@code tbMsg},
   * {@code queueName}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, String, Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueue(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueWithTbMsgQueueNameOnSuccessOnFailure() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueue(
                null, "Queue Name", mock(Runnable.class), mock(Consumer.class)));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, String, Runnable, Consumer)} with {@code tbMsg},
   * {@code queueName}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, String, Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueue(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'onSuccess', 'onFailure'; given 'false'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueWithTbMsgQueueNameOnSuccessOnFailure_givenFalse_thenCallsAccept() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getOriginator()).thenReturn(null);
    Runnable onSuccess = mock(Runnable.class);

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    defaultTbContext.enqueue(tbMsg, "Queue Name", onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueue(TbMsg, String, Runnable, Consumer)} with {@code tbMsg},
   * {@code queueName}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsg#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueue(TbMsg, String, Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueue(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'onSuccess', 'onFailure'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueue(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueWithTbMsgQueueNameOnSuccessOnFailure_thenCallsGetId() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getId()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueue(
                tbMsg, "Queue Name", mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellFailure(TbMsg, String)} with {@code tbMsg}, {@code
   * failureMessage}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellFailure(TbMsg, String)}
   */
  @Test
  @DisplayName("Test enqueueForTellFailure(TbMsg, String) with 'tbMsg', 'failureMessage'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellFailure(TbMsg, String)"})
  void testEnqueueForTellFailureWithTbMsgFailureMessage() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellFailure(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build(),
                "Failure Message"));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)} with {@code tbMsg},
   * {@code th}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test enqueueForTellFailure(TbMsg, Throwable) with 'tbMsg', 'th'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellFailure(TbMsg, Throwable)"})
  void testEnqueueForTellFailureWithTbMsgTh() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellFailure(tbMsg, new IOException()));
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getQueueName();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)} with {@code tbMsg},
   * {@code th}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test enqueueForTellFailure(TbMsg, Throwable) with 'tbMsg', 'th'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellFailure(TbMsg, Throwable)"})
  void testEnqueueForTellFailureWithTbMsgTh2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellFailure(tbMsg, new IOException()));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)} with {@code tbMsg},
   * {@code th}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isValid()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellFailure(TbMsg, Throwable) with 'tbMsg', 'th'; given 'false'; when TbMsg isValid() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellFailure(TbMsg, Throwable)"})
  void testEnqueueForTellFailureWithTbMsgTh_givenFalse_whenTbMsgIsValidReturnFalse() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act
    defaultTbContext.enqueueForTellFailure(tbMsg, new IOException());

    // Assert
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)} with {@code tbMsg},
   * {@code th}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsg#getDataType()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellFailure(TbMsg, Throwable) with 'tbMsg', 'th'; then calls getDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellFailure(TbMsg, Throwable)"})
  void testEnqueueForTellFailureWithTbMsgTh_thenCallsGetDataType() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getDataType()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getTs()).thenReturn(0L);
    when(tbMsg.getType()).thenReturn("Type");
    when(tbMsg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellFailure(tbMsg, new IOException()));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getDataType();
    verify(tbMsg).getInternalType();
    verify(tbMsg).getMetaData();
    verify(tbMsg, atLeast(1)).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).getType();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)} with {@code tbMsg},
   * {@code th}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getTs()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellFailure(TbMsg, Throwable) with 'tbMsg', 'th'; when TbMsg getTs() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellFailure(TbMsg, Throwable)"})
  void testEnqueueForTellFailureWithTbMsgTh_whenTbMsgGetTsThrowIllegalArgumentException() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellFailure(tbMsg, new IOException()));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)}
   * with {@code tbMsg}, {@code queueName}, {@code relationType}, {@code onSuccess}, {@code
   * onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String,
   * Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypeOnSuccessOnFailure() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                null, "Queue Name", "Relation Type", mock(Runnable.class), mock(Consumer.class)));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)}
   * with {@code tbMsg}, {@code queueName}, {@code relationType}, {@code onSuccess}, {@code
   * onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String,
   * Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypeOnSuccessOnFailure2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getOriginator()).thenReturn(null);
    Runnable onSuccess = mock(Runnable.class);

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    defaultTbContext.enqueueForTellNext(tbMsg, "Queue Name", "Relation Type", onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)}
   * with {@code tbMsg}, {@code queueName}, {@code relationType}, {@code onSuccess}, {@code
   * onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String,
   * Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypeOnSuccessOnFailure3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Queue Name", "Relation Type", mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)}
   * with {@code tbMsg}, {@code queueName}, {@code relationType}, {@code onSuccess}, {@code
   * onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String,
   * Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypeOnSuccessOnFailure4() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Queue Name", "Relation Type", mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)}
   * with {@code tbMsg}, {@code queueName}, {@code relationType}, {@code onSuccess}, {@code
   * onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, String,
   * Runnable, Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, String, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypeOnSuccessOnFailure5() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getDataType()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getTs()).thenReturn(0L);
    when(tbMsg.getType()).thenReturn("Type");
    when(tbMsg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Queue Name", "Relation Type", mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getDataType();
    verify(tbMsg).getInternalType();
    verify(tbMsg).getMetaData();
    verify(tbMsg, atLeast(1)).getOriginator();
    verify(tbMsg).getTs();
    verify(tbMsg).getType();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)} with
   * {@code tbMsg}, {@code queueName}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypesOnSuccessOnFailure() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                null, "Queue Name", new HashSet<>(), mock(Runnable.class), mock(Consumer.class)));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)} with
   * {@code tbMsg}, {@code queueName}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypesOnSuccessOnFailure2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getOriginator()).thenReturn(null);
    HashSet<String> relationTypes = new HashSet<>();
    Runnable onSuccess = mock(Runnable.class);

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    defaultTbContext.enqueueForTellNext(tbMsg, "Queue Name", relationTypes, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)} with
   * {@code tbMsg}, {@code queueName}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypesOnSuccessOnFailure3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Queue Name", new HashSet<>(), mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)} with
   * {@code tbMsg}, {@code queueName}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypesOnSuccessOnFailure4() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Queue Name", new HashSet<>(), mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)} with
   * {@code tbMsg}, {@code queueName}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer) with 'tbMsg', 'queueName', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultTbContext.enqueueForTellNext(TbMsg, String, Set, Runnable, Consumer)"
  })
  void testEnqueueForTellNextWithTbMsgQueueNameRelationTypesOnSuccessOnFailure5() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getDataType()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getTs()).thenReturn(0L);
    when(tbMsg.getType()).thenReturn("Type");
    when(tbMsg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Queue Name", new HashSet<>(), mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getDataType();
    verify(tbMsg).getInternalType();
    verify(tbMsg).getMetaData();
    verify(tbMsg, atLeast(1)).getOriginator();
    verify(tbMsg).getTs();
    verify(tbMsg).getType();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationType}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypeOnSuccessOnFailure() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Relation Type", new Thread(), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationType}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypeOnSuccessOnFailure2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Relation Type", new Thread(), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationType}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'relationType', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypeOnSuccessOnFailure3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getDataType()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getTs()).thenReturn(0L);
    when(tbMsg.getType()).thenReturn("Type");
    when(tbMsg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, "Relation Type", new Thread(), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getDataType();
    verify(tbMsg).getInternalType();
    verify(tbMsg).getMetaData();
    verify(tbMsg, atLeast(1)).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).getType();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationType}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String, Runnable, Consumer) with 'tbMsg', 'relationType', 'onSuccess', 'onFailure'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, String, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypeOnSuccessOnFailure_thenCallsAccept() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);
    Thread onSuccess = new Thread();

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    defaultTbContext.enqueueForTellNext(tbMsg, "Relation Type", onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, String)} with {@code tbMsg}, {@code
   * relationType}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, String)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, String) with 'tbMsg', 'relationType'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, String)"})
  void testEnqueueForTellNextWithTbMsgRelationType_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build(),
                "Relation Type"));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)} with {@code tbMsg}, {@code
   * relationTypes}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)}
   */
  @Test
  @DisplayName("Test enqueueForTellNext(TbMsg, Set) with 'tbMsg', 'relationTypes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set)"})
  void testEnqueueForTellNextWithTbMsgRelationTypes() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellNext(tbMsg, relationTypes));
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getQueueName();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)} with {@code tbMsg}, {@code
   * relationTypes}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)}
   */
  @Test
  @DisplayName("Test enqueueForTellNext(TbMsg, Set) with 'tbMsg', 'relationTypes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set)"})
  void testEnqueueForTellNextWithTbMsgRelationTypes2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellNext(tbMsg, relationTypes));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)} with {@code tbMsg}, {@code
   * relationTypes}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)}
   */
  @Test
  @DisplayName("Test enqueueForTellNext(TbMsg, Set) with 'tbMsg', 'relationTypes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set)"})
  void testEnqueueForTellNextWithTbMsgRelationTypes3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellNext(tbMsg, relationTypes));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, Set, Runnable, Consumer) with 'tbMsg', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypesOnSuccessOnFailure() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, relationTypes, mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, Set, Runnable, Consumer) with 'tbMsg', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypesOnSuccessOnFailure2() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getTs()).thenThrow(new IllegalArgumentException());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, relationTypes, mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, Set, Runnable, Consumer) with 'tbMsg', 'relationTypes', 'onSuccess', 'onFailure'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypesOnSuccessOnFailure3() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getDataType()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getTs()).thenReturn(0L);
    when(tbMsg.getType()).thenReturn("Type");
    when(tbMsg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.enqueueForTellNext(
                tbMsg, relationTypes, mock(Runnable.class), mock(Consumer.class)));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getDataType();
    verify(tbMsg).getInternalType();
    verify(tbMsg).getMetaData();
    verify(tbMsg, atLeast(1)).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).getType();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable, Consumer)} with {@code
   * tbMsg}, {@code relationTypes}, {@code onSuccess}, {@code onFailure}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set, Runnable,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, Set, Runnable, Consumer) with 'tbMsg', 'relationTypes', 'onSuccess', 'onFailure'; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set, Runnable, Consumer)"})
  void testEnqueueForTellNextWithTbMsgRelationTypesOnSuccessOnFailure_thenCallsAccept() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");
    Runnable onSuccess = mock(Runnable.class);

    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());

    // Act
    defaultTbContext.enqueueForTellNext(tbMsg, relationTypes, onSuccess, onFailure);

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)} with {@code tbMsg}, {@code
   * relationTypes}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)}
   */
  @Test
  @DisplayName("Test enqueueForTellNext(TbMsg, Set) with 'tbMsg', 'relationTypes'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set)"})
  void testEnqueueForTellNextWithTbMsgRelationTypes_givenFalse() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.isValid()).thenReturn(false);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act
    defaultTbContext.enqueueForTellNext(tbMsg, relationTypes);

    // Assert
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(tbMsg).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)} with {@code tbMsg}, {@code
   * relationTypes}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsg#getDataType()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#enqueueForTellNext(TbMsg, Set)}
   */
  @Test
  @DisplayName(
      "Test enqueueForTellNext(TbMsg, Set) with 'tbMsg', 'relationTypes'; then calls getDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.enqueueForTellNext(TbMsg, Set)"})
  void testEnqueueForTellNextWithTbMsgRelationTypes_thenCallsGetDataType() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getDataType()).thenThrow(new IllegalArgumentException());
    when(tbMsg.getTs()).thenReturn(0L);
    when(tbMsg.getType()).thenReturn("Type");
    when(tbMsg.getInternalType()).thenReturn(TbMsgType.POST_ATTRIBUTES_REQUEST);
    when(tbMsg.getMetaData()).thenReturn(new TbMsgMetaData());
    when(tbMsg.isValid()).thenReturn(true);
    when(tbMsg.getQueueName()).thenReturn("Queue Name");
    when(tbMsg.getOriginator()).thenReturn(null);

    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.enqueueForTellNext(tbMsg, relationTypes));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), eq("Queue Name"), isA(TenantId.class), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg).getDataType();
    verify(tbMsg).getInternalType();
    verify(tbMsg).getMetaData();
    verify(tbMsg, atLeast(1)).getOriginator();
    verify(tbMsg, atLeast(1)).getQueueName();
    verify(tbMsg).getTs();
    verify(tbMsg).getType();
    verify(tbMsg).isValid();
  }

  /**
   * Test {@link DefaultTbContext#ack(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#persistDebugOutput(TenantId,
   *       EntityId, TbMsg, String, Throwable)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#ack(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test ack(TbMsg); given ActorSystemContext persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.ack(TbMsg)"})
  void testAck_givenActorSystemContextPersistDebugOutputThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.ack(mock(TbMsg.class)));
    verify(actorSystemContext)
        .persistDebugOutput(isA(TenantId.class), isNull(), isA(TbMsg.class), eq("ACK"), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#ack(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback#EMPTY}.
   *   <li>When {@link TbMsg} {@link TbMsg#getCallback()} return {@link TbMsgCallback#EMPTY}.
   *   <li>Then calls {@link TbMsg#getCallback()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#ack(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test ack(TbMsg); given EMPTY; when TbMsg getCallback() return EMPTY; then calls getCallback()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.ack(TbMsg)"})
  void testAck_givenEmpty_whenTbMsgGetCallbackReturnEmpty_thenCallsGetCallback() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    defaultTbContext.ack(tbMsg);

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(tbMsg, atLeast(1)).getCallback();
  }

  /**
   * Test {@link DefaultTbContext#ack(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#ack(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test ack(TbMsg); given RuleNodeCtx getSelf() throw IllegalArgumentException(); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.ack(TbMsg)"})
  void testAck_givenRuleNodeCtxGetSelfThrowIllegalArgumentException_whenNull() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.ack(null));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#ack(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>When {@link TbMsg}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#ack(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test ack(TbMsg); given RuleNodeCtx getTenantId() throw IllegalArgumentException(); when TbMsg")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.ack(TbMsg)"})
  void testAck_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException_whenTbMsg() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.ack(mock(TbMsg.class)));
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#ack(TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg,
   *       String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#ack(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test ack(TbMsg); then calls persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.ack(TbMsg)"})
  void testAck_thenCallsPersistDebugOutput() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = new RuleNode();
    ruleNode.setDebugMode(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    TbMsg tbMsg = mock(TbMsg.class);
    when(tbMsg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    defaultTbContext.ack(tbMsg);

    // Assert
    verify(actorSystemContext)
        .persistDebugOutput(isA(TenantId.class), isNull(), isA(TbMsg.class), eq("ACK"), isNull());
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbMsg, atLeast(1)).getCallback();
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#resolve(ServiceType, String,
   *       TenantId, EntityId)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test isLocalEntity(EntityId); given ActorSystemContext resolve(ServiceType, String, TenantId, EntityId) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isLocalEntity(EntityId)"})
  void testIsLocalEntity_givenActorSystemContextResolveThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.isLocalEntity(null));
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test isLocalEntity(EntityId); given RuleNodeCtx getSelf() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isLocalEntity(EntityId)"})
  void testIsLocalEntity_givenRuleNodeCtxGetSelfThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.isLocalEntity(null));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test isLocalEntity(EntityId); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isLocalEntity(EntityId)"})
  void testIsLocalEntity_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.isLocalEntity(null));
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName("Test isLocalEntity(EntityId); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isLocalEntity(EntityId)"})
  void testIsLocalEntity_thenReturnFalse() {
    // Arrange
    TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean()))
        .thenReturn(TopicPartitionInfo.builder());

    TopicPartitionInfoBuilder partitionResult =
        topicPartitionInfoBuilder.myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    boolean actualIsLocalEntityResult = defaultTbContext.isLocalEntity(null);

    // Assert
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(topicPartitionInfoBuilder).myPartition(true);
    assertFalse(actualIsLocalEntityResult);
  }

  /**
   * Test {@link DefaultTbContext#isLocalEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isLocalEntity(EntityId)}
   */
  @Test
  @DisplayName("Test isLocalEntity(EntityId); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isLocalEntity(EntityId)"})
  void testIsLocalEntity_thenReturnTrue() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(actorSystemContext.resolve(
            Mockito.<ServiceType>any(),
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    boolean actualIsLocalEntityResult = defaultTbContext.isLocalEntity(null);

    // Assert
    verify(actorSystemContext)
        .resolve(eq(ServiceType.TB_RULE_ENGINE), isNull(), isA(TenantId.class), isNull());
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    assertTrue(actualIsLocalEntityResult);
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure() {
    // Arrange
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox tbActorMailbox =
        new TbActorMailbox(
            system, settings, selfId, null, new StatsActor(new ActorSystemContext()), null);
    when(ruleNodeCtx.getChainActor()).thenReturn(tbActorMailbox);
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    defaultTbContext.tellFailure(null, new Throwable());

    // Assert
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then calls {@link RuleNodeCtx#getChainActor()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); given RuleNodeCtx getSelf() return RuleNode(); then calls getChainActor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_givenRuleNodeCtxGetSelfReturnRuleNode_thenCallsGetChainActor() {
    // Arrange
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, new Throwable()));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); given RuleNodeCtx getSelf() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_givenRuleNodeCtxGetSelfThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, new Throwable()));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, new Throwable()));
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNode).isDebugMode();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode} {@link RuleNode#getId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link RuleNode#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); given RuleNode getId() throw IllegalArgumentException(); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_givenRuleNodeGetIdThrowIllegalArgumentException_thenCallsGetId() {
    // Arrange
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId()).thenThrow(new IllegalArgumentException());
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, new Throwable()));
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNode).getId();
    verify(ruleNode).isDebugMode();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg,
   *       String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); then calls persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_thenCallsPersistDebugOutput() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, new Throwable()));
    verify(actorSystemContext)
        .persistDebugOutput(
            isA(TenantId.class),
            isA(EntityId.class),
            isNull(),
            eq("Failure"),
            isA(Throwable.class));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNode).getId();
    verify(ruleNode).isDebugMode();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg,
   *       String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); then calls persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_thenCallsPersistDebugOutput2() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.tellFailure(null, null));
    verify(actorSystemContext)
        .persistDebugOutput(
            isA(TenantId.class), isA(EntityId.class), isNull(), eq("Failure"), isNull());
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNode).getId();
    verify(ruleNode).isDebugMode();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Exception#Exception(String)} with empty string.
   *   <li>Then calls {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg,
   *       String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); when Exception(String) with empty string; then calls persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_whenExceptionWithEmptyString_thenCallsPersistDebugOutput() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.tellFailure(null, new Exception("")));
    verify(actorSystemContext)
        .persistDebugOutput(
            isA(TenantId.class),
            isA(EntityId.class),
            isNull(),
            eq("Failure"),
            isA(Throwable.class));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNode).getId();
    verify(ruleNode).isDebugMode();
  }

  /**
   * Test {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code An error occurred}.
   *   <li>Then calls {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg,
   *       String, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#tellFailure(TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbMsg, Throwable); when IOException(String) with 'An error occurred'; then calls persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.tellFailure(TbMsg, Throwable)"})
  void testTellFailure_whenIOExceptionWithAnErrorOccurred_thenCallsPersistDebugOutput() {
    // Arrange
    doNothing()
        .when(actorSystemContext)
        .persistDebugOutput(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<Throwable>any());

    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNode.isDebugMode()).thenReturn(true);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getChainActor()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.tellFailure(null, new IOException("An error occurred")));
    verify(actorSystemContext)
        .persistDebugOutput(
            isA(TenantId.class),
            isA(EntityId.class),
            isNull(),
            eq("Failure"),
            isA(Throwable.class));
    verify(ruleNodeCtx).getChainActor();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNode).getId();
    verify(ruleNode).isDebugMode();
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name", "Type", null, customerId, new TbMsgMetaData(), "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    assertNull(actualNewMsgResult.getOriginator());
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.newMsg(
                "Queue Name", "Type", null, customerId, new TbMsgMetaData(), "Data"));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name", "Type", originator, null, new TbMsgMetaData(), "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code String}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdCustomerIdTbMsgMetaDataString4() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    EntityId originator = mock(EntityId.class);
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(originator.getId()).thenReturn(fromStringResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name", "Type", originator, null, new TbMsgMetaData(), "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(fromStringResult, id);
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.newMsg("Queue Name", "Type", null, new TbMsgMetaData(), "Data"));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString2() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg("Queue Name", "Type", originator, new TbMsgMetaData(), "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code String}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, String, EntityId, TbMsgMetaData,
   * String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, String, EntityId, TbMsgMetaData, String) with 'String', 'String', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, String, EntityId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringStringEntityIdTbMsgMetaDataString3() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    EntityId originator = mock(EntityId.class);
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(originator.getId()).thenReturn(fromStringResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg("Queue Name", "Type", originator, new TbMsgMetaData(), "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(fromStringResult, id);
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            null,
            customerId,
            new TbMsgMetaData(),
            "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    assertSame(customerId, actualNewMsgResult.getCustomerId());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString2() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null,
                customerId,
                new TbMsgMetaData(),
                "Data"));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData,
   * String)} with {@code String}, {@code TbMsgType}, {@code EntityId}, {@code CustomerId}, {@code
   * TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, CustomerId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'CustomerId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, TbMsgType, EntityId, CustomerId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdCustomerIdTbMsgMetaDataString3() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            null,
            new TbMsgMetaData(),
            "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.newMsg(
                "Queue Name",
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null,
                new TbMsgMetaData(),
                "Data"));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString2() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            new TbMsgMetaData(),
            "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)} with
   * {@code String}, {@code TbMsgType}, {@code EntityId}, {@code TbMsgMetaData}, {@code String}.
   *
   * <p>Method under test: {@link DefaultTbContext#newMsg(String, TbMsgType, EntityId,
   * TbMsgMetaData, String)}
   */
  @Test
  @DisplayName(
      "Test newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String) with 'String', 'TbMsgType', 'EntityId', 'TbMsgMetaData', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.newMsg(String, TbMsgType, EntityId, TbMsgMetaData, String)"
  })
  void testNewMsgWithStringTbMsgTypeEntityIdTbMsgMetaDataString3() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    EntityId originator = mock(EntityId.class);
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(originator.getId()).thenReturn(fromStringResult);
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);

    // Act
    TbMsg actualNewMsgResult =
        defaultTbContext.newMsg(
            "Queue Name",
            TbMsgType.POST_ATTRIBUTES_REQUEST,
            originator,
            new TbMsgMetaData(),
            "Data");

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(originator).getEntityType();
    verify(originator).getId();
    CustomerId customerId = actualNewMsgResult.getCustomerId();
    UUID id = customerId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertFalse(customerId.isNullUid());
    assertSame(fromStringResult, id);
    assertSame(originator, actualNewMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}
   */
  @Test
  @DisplayName("Test customerCreatedMsg(Customer, RuleNodeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.customerCreatedMsg(Customer, RuleNodeId)"})
  void testCustomerCreatedMsg() {
    // Arrange
    CustomerId id = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Customer customer = new Customer(id);

    // Act
    TbMsg actualCustomerCreatedMsgResult =
        defaultTbContext.customerCreatedMsg(
            customer, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"CUSTOMER\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"country"
            + "\":null,\"state\":null,\"city\":null,\"address\":null,\"address2\":null,\"zip\":null,\"phone\":null,\"email\":null,"
            + "\"title\":null,\"tenantId\":null,\"externalId\":null,\"version\":null,\"additionalInfo\":null,\"name\":null}",
        actualCustomerCreatedMsgResult.getData());
    assertEquals(id, actualCustomerCreatedMsgResult.getCustomerId());
    assertSame(id, actualCustomerCreatedMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}
   */
  @Test
  @DisplayName("Test customerCreatedMsg(Customer, RuleNodeId); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.customerCreatedMsg(Customer, RuleNodeId)"})
  void testCustomerCreatedMsg_thenThrowIllegalArgumentException() {
    // Arrange
    CustomerId id = mock(CustomerId.class);
    when(id.getEntityType()).thenThrow(new IllegalArgumentException());
    Customer customer = new Customer(id);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.customerCreatedMsg(
                customer, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(id, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}.
   *
   * <ul>
   *   <li>When {@link CustomerId#CustomerId(UUID)} with id is {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#customerCreatedMsg(Customer, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test customerCreatedMsg(Customer, RuleNodeId); when CustomerId(UUID) with id is 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.customerCreatedMsg(Customer, RuleNodeId)"})
  void testCustomerCreatedMsg_whenCustomerIdWithIdIsNull_thenThrowRuntimeException() {
    // Arrange
    Customer customer = new Customer(new CustomerId(null));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.customerCreatedMsg(
                customer, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}
   */
  @Test
  @DisplayName("Test deviceCreatedMsg(Device, RuleNodeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.deviceCreatedMsg(Device, RuleNodeId)"})
  void testDeviceCreatedMsg() {
    // Arrange
    DeviceId id = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Device device = new Device(id);
    device.setDeviceProfileId(null);

    // Act
    TbMsg actualDeviceCreatedMsgResult =
        defaultTbContext2.deviceCreatedMsg(
            device, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"DEVICE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\""
            + ":null,\"customerId\":null,\"name\":null,\"type\":null,\"label\":null,\"deviceProfileId\":null,\"firmwareId\":null"
            + ",\"softwareId\":null,\"externalId\":null,\"version\":null,\"additionalInfo\":null,\"deviceData\":null}",
        actualDeviceCreatedMsgResult.getData());
    assertSame(id, actualDeviceCreatedMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getDeviceProfileCache()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}
   */
  @Test
  @DisplayName("Test deviceCreatedMsg(Device, RuleNodeId); then calls getDeviceProfileCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.deviceCreatedMsg(Device, RuleNodeId)"})
  void testDeviceCreatedMsg_thenCallsGetDeviceProfileCache() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileById(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new DeviceProfile());
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext2.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    DeviceId id = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Device device = new Device(id);
    device.setDeviceProfileId(
        new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbMsg actualDeviceCreatedMsgResult =
        defaultTbContext2.deviceCreatedMsg(
            device, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(actorSystemContext2).getDeviceProfileCache();
    verify(deviceProfileService)
        .findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    assertEquals(
        "{\"id\":{\"entityType\":\"DEVICE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\""
            + ":null,\"customerId\":null,\"name\":null,\"type\":null,\"label\":null,\"deviceProfileId\":{\"entityType\":\"DEVICE"
            + "_PROFILE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"firmwareId\":null,\"softwareId\":null,\"externalId"
            + "\":null,\"version\":null,\"additionalInfo\":null,\"deviceData\":null}",
        actualDeviceCreatedMsgResult.getData());
    assertSame(id, actualDeviceCreatedMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#deviceCreatedMsg(Device, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test deviceCreatedMsg(Device, RuleNodeId); when DeviceId(UUID) with id is 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.deviceCreatedMsg(Device, RuleNodeId)"})
  void testDeviceCreatedMsg_whenDeviceIdWithIdIsNull_thenThrowRuntimeException() {
    // Arrange
    Device device = new Device(new DeviceId(null));
    device.setDeviceProfileId(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext2.deviceCreatedMsg(
                device, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}
   */
  @Test
  @DisplayName("Test assetCreatedMsg(Asset, RuleNodeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.assetCreatedMsg(Asset, RuleNodeId)"})
  void testAssetCreatedMsg() {
    // Arrange
    AssetId id = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Asset asset = new Asset(id);
    asset.setAssetProfileId(null);

    // Act
    TbMsg actualAssetCreatedMsgResult =
        defaultTbContext2.assetCreatedMsg(
            asset, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals(
        "{\"id\":{\"entityType\":\"ASSET\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\""
            + ":null,\"customerId\":null,\"name\":null,\"type\":null,\"label\":null,\"assetProfileId\":null,\"externalId\":null"
            + ",\"version\":null,\"additionalInfo\":null}",
        actualAssetCreatedMsgResult.getData());
    assertSame(id, actualAssetCreatedMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link AssetId#AssetId(UUID)} with id is {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}
   */
  @Test
  @DisplayName(
      "Test assetCreatedMsg(Asset, RuleNodeId); given 'null'; when AssetId(UUID) with id is 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.assetCreatedMsg(Asset, RuleNodeId)"})
  void testAssetCreatedMsg_givenNull_whenAssetIdWithIdIsNull_thenThrowRuntimeException() {
    // Arrange
    Asset asset = new Asset(new AssetId(null));
    asset.setAssetProfileId(null);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext2.assetCreatedMsg(
                asset, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }

  /**
   * Test {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getAssetProfileCache()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#assetCreatedMsg(Asset, RuleNodeId)}
   */
  @Test
  @DisplayName("Test assetCreatedMsg(Asset, RuleNodeId); then calls getAssetProfileCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg DefaultTbContext.assetCreatedMsg(Asset, RuleNodeId)"})
  void testAssetCreatedMsg_thenCallsGetAssetProfileCache() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = mock(AssetProfileServiceImpl.class);
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(new AssetProfile());
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext2.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    AssetId id = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Asset asset = new Asset(id);
    asset.setAssetProfileId(
        new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbMsg actualAssetCreatedMsgResult =
        defaultTbContext2.assetCreatedMsg(
            asset, new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(actorSystemContext2).getAssetProfileCache();
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    assertEquals(
        "{\"id\":{\"entityType\":\"ASSET\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"createdTime\":0,\"tenantId\""
            + ":null,\"customerId\":null,\"name\":null,\"type\":null,\"label\":null,\"assetProfileId\":{\"entityType\":\"ASSET"
            + "_PROFILE\",\"id\":\"784f394c-42b6-435a-983c-b7beff2784f9\"},\"externalId\":null,\"version\":null,\"additionalInfo"
            + "\":null}",
        actualAssetCreatedMsgResult.getData());
    assertSame(id, actualAssetCreatedMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesUpdatedActionMsg() {
    // Arrange
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesUpdatedActionMsgResult =
        defaultTbContext.attributesUpdatedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    assertNull(actualAttributesUpdatedActionMsgResult.getCustomerId());
    assertSame(originator, actualAttributesUpdatedActionMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesUpdatedActionMsg2() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException());
    AssetId originator = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.attributesUpdatedActionMsg(
                originator, ruleNodeId, "Scope", new ArrayList<>()));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesUpdatedActionMsg3() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    AssetId originator = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.attributesUpdatedActionMsg(
                originator, ruleNodeId, "Scope", new ArrayList<>()));
    verify(actorSystemContext).getAssetProfileCache();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesUpdatedActionMsg4() {
    // Arrange
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesUpdatedActionMsgResult =
        defaultTbContext.attributesUpdatedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    assertEquals(originator, actualAttributesUpdatedActionMsgResult.getCustomerId());
    assertSame(originator, actualAttributesUpdatedActionMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesUpdatedActionMsg5() {
    // Arrange
    AssetService assetService = mock(AssetService.class);
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any()))
        .thenReturn(null);
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(new AssetProfileServiceImpl(), assetService);
    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AssetId originator = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesUpdatedActionMsgResult =
        defaultTbContext.attributesUpdatedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    verify(actorSystemContext).getAssetProfileCache();
    verify(ruleNodeCtx).getTenantId();
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    assertNull(actualAttributesUpdatedActionMsgResult.getCustomerId());
    assertSame(originator, actualAttributesUpdatedActionMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem system = new DefaultTbActorSystem(settings);
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings2, selfId, null, new StatsActor(new ActorSystemContext()), null);

    TbActorSystemSettings settings3 = mock(TbActorSystemSettings.class);
    when(settings3.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(settings3);
    TbActorSystemSettings settings4 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings4, selfId2, null, new StatsActor(new ActorSystemContext()), null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeCtx nodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", nodeCtx);
    CustomerId originator = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext.attributesDeletedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    verify(settings).getSchedulerPoolSize();
    verify(settings3).getSchedulerPoolSize();
    assertEquals(originator, actualAttributesDeletedActionMsgResult.getCustomerId());
    assertSame(originator, actualAttributesDeletedActionMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg2() {
    // Arrange
    when(actorSystemContext2.getAssetProfileCache()).thenThrow(new IllegalArgumentException());
    AssetId originator = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext2.attributesDeletedActionMsg(
                originator, ruleNodeId, "Scope", new ArrayList<>()));
    verify(actorSystemContext2).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg3() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext2.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    when(ruleNodeCtx2.getTenantId()).thenThrow(new IllegalArgumentException());
    AssetId originator = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext2.attributesDeletedActionMsg(
                originator, ruleNodeId, "Scope", new ArrayList<>()));
    verify(actorSystemContext2).getAssetProfileCache();
    verify(ruleNodeCtx2).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName("Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg4() {
    // Arrange
    when(actorSystemContext2.getDeviceProfileCache()).thenThrow(new IllegalArgumentException());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext2.attributesDeletedActionMsg(
                originator, ruleNodeId, "Scope", new ArrayList<>()));
    verify(actorSystemContext2).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <ul>
   *   <li>Then calls {@link TbDeviceProfileCache#get(TenantId, DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then calls get(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg_thenCallsGet() {
    // Arrange
    TbDeviceProfileCache tbDeviceProfileCache = mock(TbDeviceProfileCache.class);
    when(tbDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceProfile());
    when(actorSystemContext2.getDeviceProfileCache()).thenReturn(tbDeviceProfileCache);
    when(ruleNodeCtx2.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("ruleNodeId");

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext2.attributesDeletedActionMsg(originator, ruleNodeId, "Scope", keys);

    // Assert
    verify(tbDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(actorSystemContext2).getDeviceProfileCache();
    verify(ruleNodeCtx2).getTenantId();
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof DeviceId);
    assertEquals(
        "{\"attributes\":[\"ruleNodeId\"]}", actualAttributesDeletedActionMsgResult.getData());
    assertEquals(EntityType.DEVICE, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <ul>
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then Originator return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg_thenOriginatorReturnAssetId() {
    // Arrange
    AssetService assetService = mock(AssetService.class);
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any()))
        .thenReturn(null);
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(new AssetProfileServiceImpl(), assetService);
    when(actorSystemContext2.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    when(ruleNodeCtx2.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AssetId originator = new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext2.attributesDeletedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    verify(actorSystemContext2).getAssetProfileCache();
    verify(ruleNodeCtx2).getTenantId();
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof AssetId);
    assertEquals("{\"attributes\":[]}", actualAttributesDeletedActionMsgResult.getData());
    assertEquals(EntityType.ASSET, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then return CustomerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg_thenReturnCustomerIdIsNull() {
    // Arrange
    TbActorSystemSettings settings = mock(TbActorSystemSettings.class);
    when(settings.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem system = new DefaultTbActorSystem(settings);
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId = mock(TbActorId.class);

    TbActorMailbox chainActor =
        new TbActorMailbox(
            system, settings2, selfId, null, new StatsActor(new ActorSystemContext()), null);

    TbActorSystemSettings settings3 = mock(TbActorSystemSettings.class);
    when(settings3.getSchedulerPoolSize()).thenReturn(3);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(settings3);
    TbActorSystemSettings settings4 = new TbActorSystemSettings(1, 3, 3);
    TbActorId selfId2 = mock(TbActorId.class);

    TbActorMailbox selfActor =
        new TbActorMailbox(
            system2, settings4, selfId2, null, new StatsActor(new ActorSystemContext()), null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeCtx nodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", nodeCtx);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext.attributesDeletedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    verify(settings).getSchedulerPoolSize();
    verify(settings3).getSchedulerPoolSize();
    assertNull(actualAttributesDeletedActionMsgResult.getCustomerId());
    assertSame(originator, actualAttributesDeletedActionMsgResult.getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <ul>
   *   <li>Then return Data is {@code {"attributes":[]}}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then return Data is '{\"attributes\":[]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg_thenReturnDataIsAttributes() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), deviceService);
    when(actorSystemContext2.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx2.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext2.attributesDeletedActionMsg(
            originator, ruleNodeId, "Scope", new ArrayList<>());

    // Assert
    verify(actorSystemContext2).getDeviceProfileCache();
    verify(ruleNodeCtx2).getTenantId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof DeviceId);
    assertEquals("{\"attributes\":[]}", actualAttributesDeletedActionMsgResult.getData());
    assertEquals(EntityType.DEVICE, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <ul>
   *   <li>Then return Data is {@code {"attributes":["ruleNodeId"]}}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then return Data is '{\"attributes\":[\"ruleNodeId\"]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg_thenReturnDataIsAttributesRuleNodeId() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), deviceService);
    when(actorSystemContext2.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx2.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("ruleNodeId");

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext2.attributesDeletedActionMsg(originator, ruleNodeId, "Scope", keys);

    // Assert
    verify(actorSystemContext2).getDeviceProfileCache();
    verify(ruleNodeCtx2).getTenantId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof DeviceId);
    assertEquals(
        "{\"attributes\":[\"ruleNodeId\"]}", actualAttributesDeletedActionMsgResult.getData());
    assertEquals(EntityType.DEVICE, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)}.
   *
   * <ul>
   *   <li>Then return Data is {@code {"attributes":["scope","ruleNodeId"]}}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#attributesDeletedActionMsg(EntityId, RuleNodeId,
   * String, List)}
   */
  @Test
  @DisplayName(
      "Test attributesDeletedActionMsg(EntityId, RuleNodeId, String, List); then return Data is '{\"attributes\":[\"scope\",\"ruleNodeId\"]}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.attributesDeletedActionMsg(EntityId, RuleNodeId, String, List)"
  })
  void testAttributesDeletedActionMsg_thenReturnDataIsAttributesScopeRuleNodeId() {
    // Arrange
    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), deviceService);
    when(actorSystemContext2.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx2.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("scope");
    keys.add("ruleNodeId");

    // Act
    TbMsg actualAttributesDeletedActionMsgResult =
        defaultTbContext2.attributesDeletedActionMsg(originator, ruleNodeId, "Scope", keys);

    // Assert
    verify(actorSystemContext2).getDeviceProfileCache();
    verify(ruleNodeCtx2).getTenantId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    EntityId originator2 = actualAttributesDeletedActionMsgResult.getOriginator();
    assertTrue(originator2 instanceof DeviceId);
    assertEquals(
        "{\"attributes\":[\"scope\",\"ruleNodeId\"]}",
        actualAttributesDeletedActionMsgResult.getData());
    assertEquals(EntityType.DEVICE, originator2.getEntityType());
    assertSame(originator, originator2);
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        alarmId,
        defaultTbContext
            .entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST)
            .getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                null,
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        alarmId,
        defaultTbContext
            .entityActionMsg(
                "Entity",
                alarmId,
                ruleNodeId,
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                new DeviceProfile())
            .getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                ruleNodeId,
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new RuntimeException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                ruleNodeId,
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                new DeviceProfile()));
    verify(alarmId).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST,
                null));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile5() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                null, alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code
   * actionMsgType}, {@code profile}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'actionMsgType', 'profile'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgTypeProfile_whenOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                1, alarmId, ruleNodeId, TbMsgType.POST_ATTRIBUTES_REQUEST, new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_thenThrowRuntimeException() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)} with
   * {@code entity}, {@code id}, {@code ruleNodeId}, {@code actionMsgType}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * TbMsgType)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType) with 'entity', 'id', 'ruleNodeId', 'actionMsgType'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, TbMsgType)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionMsgType_whenOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                1,
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile() {
    // Arrange
    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertSame(
        alarmId,
        defaultTbContext
            .entityActionMsg("Entity", alarmId, ruleNodeId, "Action", new DeviceProfile())
            .getOriginator());
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile2() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity", alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile3() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity",
                alarmId,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Action",
                null));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile4() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                null, alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_thenThrowRuntimeException() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new RuntimeException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            defaultTbContext.entityActionMsg(
                "Entity", alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <ul>
   *   <li>When {@code 1369862294}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; when '1369862294'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_when1369862294() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                1369862294, alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId, String,
   * HasRuleEngineProfile)} with {@code entity}, {@code id}, {@code ruleNodeId}, {@code action},
   * {@code profile}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#entityActionMsg(Object, EntityId, RuleNodeId,
   * String, HasRuleEngineProfile)}
   */
  @Test
  @DisplayName(
      "Test entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile) with 'entity', 'id', 'ruleNodeId', 'action', 'profile'; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsg DefaultTbContext.entityActionMsg(Object, EntityId, RuleNodeId, String, HasRuleEngineProfile)"
  })
  void testEntityActionMsgWithEntityIdRuleNodeIdActionProfile_whenOne() {
    // Arrange
    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.getEntityType()).thenThrow(new IllegalArgumentException());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.entityActionMsg(
                1, alarmId, ruleNodeId, "Action", new DeviceProfile()));
    verify(alarmId, atLeast(1)).getEntityType();
  }

  /**
   * Test {@link DefaultTbContext#getSelfId()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSelfId()}
   */
  @Test
  @DisplayName(
      "Test getSelfId(); given RuleNodeCtx getSelf() return RuleNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeId DefaultTbContext.getSelfId()"})
  void testGetSelfId_givenRuleNodeCtxGetSelfReturnRuleNode_thenReturnNull() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    RuleNodeId actualSelfId = defaultTbContext.getSelfId();

    // Assert
    verify(ruleNodeCtx).getSelf();
    assertNull(actualSelfId);
  }

  /**
   * Test {@link DefaultTbContext#getSelfId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSelfId()}
   */
  @Test
  @DisplayName("Test getSelfId(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeId DefaultTbContext.getSelfId()"})
  void testGetSelfId_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSelfId());
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#getSelf()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then return {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSelf()}
   */
  @Test
  @DisplayName(
      "Test getSelf(); given RuleNodeCtx getSelf() return RuleNode(); then return RuleNode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode DefaultTbContext.getSelf()"})
  void testGetSelf_givenRuleNodeCtxGetSelfReturnRuleNode_thenReturnRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeCtx.getSelf()).thenReturn(ruleNode);

    // Act
    RuleNode actualSelf = defaultTbContext.getSelf();

    // Assert
    verify(ruleNodeCtx).getSelf();
    assertSame(ruleNode, actualSelf);
  }

  /**
   * Test {@link DefaultTbContext#getSelf()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSelf()}
   */
  @Test
  @DisplayName("Test getSelf(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode DefaultTbContext.getSelf()"})
  void testGetSelf_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSelf());
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#getQueueName()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getSelf()} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueName()}
   */
  @Test
  @DisplayName(
      "Test getQueueName(); given RuleNodeCtx getSelf() return RuleNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getQueueName()"})
  void testGetQueueName_givenRuleNodeCtxGetSelfReturnRuleNode_thenReturnNull() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    String actualQueueName = defaultTbContext.getQueueName();

    // Assert
    verify(ruleNodeCtx).getSelf();
    assertNull(actualQueueName);
  }

  /**
   * Test {@link DefaultTbContext#getQueueName()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueName()}
   */
  @Test
  @DisplayName("Test getQueueName(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getQueueName()"})
  void testGetQueueName_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getQueueName());
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#getTenantId()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId DefaultTbContext.getTenantId()"})
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleNodeCtx.getTenantId()).thenReturn(tenantId);

    // Act
    TenantId actualTenantId = defaultTbContext.getTenantId();

    // Assert
    verify(ruleNodeCtx).getTenantId();
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link DefaultTbContext#getTenantId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId DefaultTbContext.getTenantId()"})
  void testGetTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantId());
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link MailExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then return MailExecutorService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getMailExecutor()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getMailExecutor()"})
  void testGetMailExecutor_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getMailExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getMailExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailExecutor()}
   */
  @Test
  @DisplayName("Test getMailExecutor(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getMailExecutor()"})
  void testGetMailExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getMailExecutor()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailExecutor());
    verify(actorSystemContext).getMailExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getSmsExecutor()"})
  void testGetSmsExecutor_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getSmsExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getSmsExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link SmsExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then return SmsExecutorService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getSmsExecutor()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsExecutor()}
   */
  @Test
  @DisplayName("Test getSmsExecutor(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getSmsExecutor()"})
  void testGetSmsExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSmsExecutor()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsExecutor());
    verify(actorSystemContext).getSmsExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link DbCallbackExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then return DbCallbackExecutorService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getDbCallbackExecutor()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getDbCallbackExecutor()"})
  void testGetDbCallbackExecutor_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDbCallbackExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getDbCallbackExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDbCallbackExecutor()}
   */
  @Test
  @DisplayName("Test getDbCallbackExecutor(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getDbCallbackExecutor()"})
  void testGetDbCallbackExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDbCallbackExecutor()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDbCallbackExecutor());
    verify(actorSystemContext).getDbCallbackExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link ExternalCallExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then return ExternalCallExecutorService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getExternalCallExecutor()"})
  void testGetExternalCallExecutor_thenReturnExternalCallExecutorService() {
    // Arrange
    ExternalCallExecutorService externalCallExecutorService = new ExternalCallExecutorService();
    when(actorSystemContext.getExternalCallExecutorService())
        .thenReturn(externalCallExecutorService);

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getExternalCallExecutor()"})
  void testGetExternalCallExecutor_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getExternalCallExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getExternalCallExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getExternalCallExecutor()}
   */
  @Test
  @DisplayName("Test getExternalCallExecutor(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getExternalCallExecutor()"})
  void testGetExternalCallExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getExternalCallExecutorService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getExternalCallExecutor());
    verify(actorSystemContext).getExternalCallExecutorService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   *
   * <ul>
   *   <li>Then return {@link NotificationExecutorService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then return NotificationExecutorService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getNotificationExecutor()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getNotificationExecutor()"})
  void testGetNotificationExecutor_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getNotificationExecutor());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationExecutor()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationExecutor()}
   */
  @Test
  @DisplayName("Test getNotificationExecutor(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListeningExecutor DefaultTbContext.getNotificationExecutor()"})
  void testGetNotificationExecutor_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationExecutor()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationExecutor());
    verify(actorSystemContext).getNotificationExecutor();
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   *
   * <ul>
   *   <li>Then return Executor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then return Executor is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PubSubRuleNodeExecutorProvider DefaultTbContext.getPubSubRuleNodeExecutorProvider()"
  })
  void testGetPubSubRuleNodeExecutorProvider_thenReturnExecutorIsNull() {
    // Arrange
    PubSubRuleNodeExecutorProvider pubSubRuleNodeExecutorProvider =
        new PubSubRuleNodeExecutorProvider();
    when(actorSystemContext.getPubSubRuleNodeExecutorProvider())
        .thenReturn(pubSubRuleNodeExecutorProvider);

    // Act
    PubSubRuleNodeExecutorProvider actualPubSubRuleNodeExecutorProvider =
        defaultTbContext.getPubSubRuleNodeExecutorProvider();

    // Assert
    verify(actorSystemContext).getPubSubRuleNodeExecutorProvider();
    assertNull(actualPubSubRuleNodeExecutorProvider.getExecutor());
    assertSame(pubSubRuleNodeExecutorProvider, actualPubSubRuleNodeExecutorProvider);
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PubSubRuleNodeExecutorProvider DefaultTbContext.getPubSubRuleNodeExecutorProvider()"
  })
  void testGetPubSubRuleNodeExecutorProvider_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getPubSubRuleNodeExecutorProvider());
  }

  /**
   * Test {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getPubSubRuleNodeExecutorProvider()}
   */
  @Test
  @DisplayName("Test getPubSubRuleNodeExecutorProvider(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PubSubRuleNodeExecutorProvider DefaultTbContext.getPubSubRuleNodeExecutorProvider()"
  })
  void testGetPubSubRuleNodeExecutorProvider_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getPubSubRuleNodeExecutorProvider())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getPubSubRuleNodeExecutorProvider());
    verify(actorSystemContext).getPubSubRuleNodeExecutorProvider();
  }

  /**
   * Test {@link DefaultTbContext#createJsScriptEngine(String, String[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createJsScriptEngine(String, String[])}
   */
  @Test
  @DisplayName("Test createJsScriptEngine(String, String[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createJsScriptEngine(String, String[])"
  })
  void testCreateJsScriptEngine_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.createJsScriptEngine("Script", "Arg Names"));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); given RuleNodeCtx; when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_givenRuleNodeCtx_whenNull_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.JS, null, "Arg Names"));
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); given RuleNodeCtx; when 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_givenRuleNodeCtx_whenNull_thenThrowRuntimeException2() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> defaultTbContext.createScriptEngine(null, " ", "Arg Names"));
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx}.
   *   <li>When space.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); given RuleNodeCtx; when space; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_givenRuleNodeCtx_whenSpace_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.JS, " ", "Arg Names"));
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.JS, "Script", "Arg Names"));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#createScriptEngine(ScriptLanguage, String,
   * String[])}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(ScriptLanguage, String, String[]); when empty string; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.api.ScriptEngine DefaultTbContext.createScriptEngine(ScriptLanguage, String, String[])"
  })
  void testCreateScriptEngine_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> defaultTbContext.createScriptEngine(ScriptLanguage.JS, "", "Arg Names"));
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalRequest());
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest2() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException());
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalRequest());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isStatisticsEnabled()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName(
      "Test logJsEvalRequest(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalRequest();

    // Assert
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultJsInvokeStats#incrementRequests()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest(); then calls incrementRequests()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest_thenCallsIncrementRequests() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementRequests();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalRequest();

    // Assert
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementRequests();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalRequest()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalRequest()}
   */
  @Test
  @DisplayName("Test logJsEvalRequest(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalRequest()"})
  void testLogJsEvalRequest_thenDoesNotThrow() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertDoesNotThrow(() -> defaultTbContext.logJsEvalRequest());
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalResponse());
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse2() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException());
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalResponse());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isStatisticsEnabled()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName(
      "Test logJsEvalResponse(); given ActorSystemContext isStatisticsEnabled() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse_givenActorSystemContextIsStatisticsEnabledReturnFalse() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(false);

    // Act
    defaultTbContext.logJsEvalResponse();

    // Assert
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultJsInvokeStats#incrementResponses()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse(); then calls incrementResponses()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse_thenCallsIncrementResponses() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementResponses();
    when(actorSystemContext.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act
    defaultTbContext.logJsEvalResponse();

    // Assert
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementResponses();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalResponse()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalResponse()}
   */
  @Test
  @DisplayName("Test logJsEvalResponse(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalResponse()"})
  void testLogJsEvalResponse_thenDoesNotThrow() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertDoesNotThrow(() -> defaultTbContext.logJsEvalResponse());
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure() {
    // Arrange
    when(actorSystemContext.isStatisticsEnabled()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalFailure());
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure2() {
    // Arrange
    when(actorSystemContext.getJsInvokeStats()).thenThrow(new IllegalArgumentException());
    when(actorSystemContext.isStatisticsEnabled()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.logJsEvalFailure());
    verify(actorSystemContext).getJsInvokeStats();
    verify(actorSystemContext).isStatisticsEnabled();
  }

  /**
   * Test {@link DefaultTbContext#logJsEvalFailure()}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultJsInvokeStats#incrementFailures()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#logJsEvalFailure()}
   */
  @Test
  @DisplayName("Test logJsEvalFailure(); then calls incrementFailures()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.logJsEvalFailure()"})
  void testLogJsEvalFailure_thenCallsIncrementFailures() {
    // Arrange
    DefaultJsInvokeStats defaultJsInvokeStats = mock(DefaultJsInvokeStats.class);
    doNothing().when(defaultJsInvokeStats).incrementFailures();

    ActorSystemContext mainCtx = mock(ActorSystemContext.class);
    when(mainCtx.getJsInvokeStats()).thenReturn(defaultJsInvokeStats);
    when(mainCtx.isStatisticsEnabled()).thenReturn(true);
    DefaultTbContext defaultTbContext = new DefaultTbContext(mainCtx, "Rule Chain Name", null);

    // Act
    defaultTbContext.logJsEvalFailure();

    // Assert
    verify(mainCtx).getJsInvokeStats();
    verify(mainCtx).isStatisticsEnabled();
    verify(defaultJsInvokeStats).incrementFailures();
  }

  /**
   * Test {@link DefaultTbContext#getServiceId()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getServiceId()"})
  void testGetServiceId() {
    // Arrange
    when(actorSystemContext.getServiceInfoProvider())
        .thenReturn(new DefaultTbServiceInfoProvider());

    // Act
    String actualServiceId = defaultTbContext.getServiceId();

    // Assert
    verify(actorSystemContext).getServiceInfoProvider();
    assertNull(actualServiceId);
  }

  /**
   * Test {@link DefaultTbContext#getServiceId()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getServiceId()"})
  void testGetServiceId2() {
    // Arrange
    ActorSystemContext mainCtx = new ActorSystemContext();
    mainCtx.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    DefaultTbContext defaultTbContext = new DefaultTbContext(mainCtx, "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getServiceId());
  }

  /**
   * Test {@link DefaultTbContext#getServiceId()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getServiceId()"})
  void testGetServiceId_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getServiceInfoProvider()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getServiceId());
    verify(actorSystemContext).getServiceInfoProvider();
  }

  /**
   * Test {@link DefaultTbContext#getAttributesService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseAttributesService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAttributesService()}
   */
  @Test
  @DisplayName("Test getAttributesService(); then return BaseAttributesService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributesService DefaultTbContext.getAttributesService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAttributesService()}
   */
  @Test
  @DisplayName("Test getAttributesService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributesService DefaultTbContext.getAttributesService()"})
  void testGetAttributesService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAttributesService());
  }

  /**
   * Test {@link DefaultTbContext#getAttributesService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAttributesService()}
   */
  @Test
  @DisplayName("Test getAttributesService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AttributesService DefaultTbContext.getAttributesService()"})
  void testGetAttributesService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAttributesService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAttributesService());
    verify(actorSystemContext).getAttributesService();
  }

  /**
   * Test {@link DefaultTbContext#getCustomerService()}.
   *
   * <ul>
   *   <li>Then return {@link CustomerServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getCustomerService()}
   */
  @Test
  @DisplayName("Test getCustomerService(); then return CustomerServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerService DefaultTbContext.getCustomerService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getCustomerService()}
   */
  @Test
  @DisplayName("Test getCustomerService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerService DefaultTbContext.getCustomerService()"})
  void testGetCustomerService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getCustomerService());
  }

  /**
   * Test {@link DefaultTbContext#getCustomerService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getCustomerService()}
   */
  @Test
  @DisplayName("Test getCustomerService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CustomerService DefaultTbContext.getCustomerService()"})
  void testGetCustomerService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getCustomerService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getCustomerService());
    verify(actorSystemContext).getCustomerService();
  }

  /**
   * Test {@link DefaultTbContext#getTenantService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantService()}
   */
  @Test
  @DisplayName("Test getTenantService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantService DefaultTbContext.getTenantService()"})
  void testGetTenantService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getTenantService());
  }

  /**
   * Test {@link DefaultTbContext#getTenantService()}.
   *
   * <ul>
   *   <li>Then return {@link TenantServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantService()}
   */
  @Test
  @DisplayName("Test getTenantService(); then return TenantServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantService DefaultTbContext.getTenantService()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantService()}
   */
  @Test
  @DisplayName("Test getTenantService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantService DefaultTbContext.getTenantService()"})
  void testGetTenantService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTenantService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantService());
    verify(actorSystemContext).getTenantService();
  }

  /**
   * Test {@link DefaultTbContext#getUserService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getUserService()}
   */
  @Test
  @DisplayName("Test getUserService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserService DefaultTbContext.getUserService()"})
  void testGetUserService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getUserService());
  }

  /**
   * Test {@link DefaultTbContext#getUserService()}.
   *
   * <ul>
   *   <li>Then return {@link UserServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getUserService()}
   */
  @Test
  @DisplayName("Test getUserService(); then return UserServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserService DefaultTbContext.getUserService()"})
  void testGetUserService_thenReturnUserServiceImpl() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getUserService()}
   */
  @Test
  @DisplayName("Test getUserService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserService DefaultTbContext.getUserService()"})
  void testGetUserService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getUserService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getUserService());
    verify(actorSystemContext).getUserService();
  }

  /**
   * Test {@link DefaultTbContext#getAssetService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseAssetService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetService()}
   */
  @Test
  @DisplayName("Test getAssetService(); then return BaseAssetService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetService DefaultTbContext.getAssetService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetService()}
   */
  @Test
  @DisplayName("Test getAssetService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetService DefaultTbContext.getAssetService()"})
  void testGetAssetService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAssetService());
  }

  /**
   * Test {@link DefaultTbContext#getAssetService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetService()}
   */
  @Test
  @DisplayName("Test getAssetService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetService DefaultTbContext.getAssetService()"})
  void testGetAssetService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAssetService());
    verify(actorSystemContext).getAssetService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceService()}.
   *
   * <ul>
   *   <li>Then return {@link DeviceServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceService()}
   */
  @Test
  @DisplayName("Test getDeviceService(); then return DeviceServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceService DefaultTbContext.getDeviceService()"})
  void testGetDeviceService_thenReturnDeviceServiceImpl() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceServiceImpl =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceService()}
   */
  @Test
  @DisplayName("Test getDeviceService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceService DefaultTbContext.getDeviceService()"})
  void testGetDeviceService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDeviceService());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceService()}
   */
  @Test
  @DisplayName("Test getDeviceService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceService DefaultTbContext.getDeviceService()"})
  void testGetDeviceService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceService());
    verify(actorSystemContext).getDeviceService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileService()}.
   *
   * <ul>
   *   <li>Then return {@link DeviceProfileServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceProfileService()}
   */
  @Test
  @DisplayName("Test getDeviceProfileService(); then return DeviceProfileServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileService DefaultTbContext.getDeviceProfileService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceProfileService()}
   */
  @Test
  @DisplayName("Test getDeviceProfileService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileService DefaultTbContext.getDeviceProfileService()"})
  void testGetDeviceProfileService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDeviceProfileService());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceProfileService()}
   */
  @Test
  @DisplayName("Test getDeviceProfileService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileService DefaultTbContext.getDeviceProfileService()"})
  void testGetDeviceProfileService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceProfileService());
    verify(actorSystemContext).getDeviceProfileService();
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileService()}.
   *
   * <ul>
   *   <li>Then return {@link AssetProfileServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetProfileService()}
   */
  @Test
  @DisplayName("Test getAssetProfileService(); then return AssetProfileServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileService DefaultTbContext.getAssetProfileService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetProfileService()}
   */
  @Test
  @DisplayName("Test getAssetProfileService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileService DefaultTbContext.getAssetProfileService()"})
  void testGetAssetProfileService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAssetProfileService());
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetProfileService()}
   */
  @Test
  @DisplayName("Test getAssetProfileService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileService DefaultTbContext.getAssetProfileService()"})
  void testGetAssetProfileService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAssetProfileService());
    verify(actorSystemContext).getAssetProfileService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceCredentialsService()}.
   *
   * <ul>
   *   <li>Then return {@link DeviceCredentialsServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceCredentialsService()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsService(); then return DeviceCredentialsServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentialsService DefaultTbContext.getDeviceCredentialsService()"})
  void testGetDeviceCredentialsService_thenReturnDeviceCredentialsServiceImpl() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    when(actorSystemContext.getDeviceCredentialsService()).thenReturn(deviceCredentialsServiceImpl);

    // Act
    DeviceCredentialsService actualDeviceCredentialsService =
        defaultTbContext.getDeviceCredentialsService();

    // Assert
    verify(actorSystemContext).getDeviceCredentialsService();
    assertTrue(actualDeviceCredentialsService instanceof DeviceCredentialsServiceImpl);
    assertSame(deviceCredentialsServiceImpl, actualDeviceCredentialsService);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceCredentialsService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceCredentialsService()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentialsService DefaultTbContext.getDeviceCredentialsService()"})
  void testGetDeviceCredentialsService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDeviceCredentialsService());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceCredentialsService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceCredentialsService()}
   */
  @Test
  @DisplayName("Test getDeviceCredentialsService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentialsService DefaultTbContext.getDeviceCredentialsService()"})
  void testGetDeviceCredentialsService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceCredentialsService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getDeviceCredentialsService());
    verify(actorSystemContext).getDeviceCredentialsService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateManager()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateManager()}
   */
  @Test
  @DisplayName("Test getDeviceStateManager()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineDeviceStateManager DefaultTbContext.getDeviceStateManager()"})
  void testGetDeviceStateManager() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDeviceStateManager());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateManager()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#getDeviceStateManager()}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateManager()}
   */
  @Test
  @DisplayName(
      "Test getDeviceStateManager(); given ActorSystemContext getDeviceStateManager() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineDeviceStateManager DefaultTbContext.getDeviceStateManager()"})
  void testGetDeviceStateManager_givenActorSystemContextGetDeviceStateManagerReturnNull() {
    // Arrange
    when(actorSystemContext.getDeviceStateManager()).thenReturn(null);

    // Act
    RuleEngineDeviceStateManager actualDeviceStateManager =
        defaultTbContext.getDeviceStateManager();

    // Assert
    verify(actorSystemContext).getDeviceStateManager();
    assertNull(actualDeviceStateManager);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateManager()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateManager()}
   */
  @Test
  @DisplayName("Test getDeviceStateManager(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineDeviceStateManager DefaultTbContext.getDeviceStateManager()"})
  void testGetDeviceStateManager_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceStateManager()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceStateManager());
    verify(actorSystemContext).getDeviceStateManager();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   *
   * <ul>
   *   <li>Then return {@code Device State Node Rate Limit Config}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName(
      "Test getDeviceStateNodeRateLimitConfig(); then return 'Device State Node Rate Limit Config'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getDeviceStateNodeRateLimitConfig()"})
  void testGetDeviceStateNodeRateLimitConfig_thenReturnDeviceStateNodeRateLimitConfig() {
    // Arrange
    when(actorSystemContext.getDeviceStateNodeRateLimitConfig())
        .thenReturn("Device State Node Rate Limit Config");

    // Act
    String actualDeviceStateNodeRateLimitConfig =
        defaultTbContext.getDeviceStateNodeRateLimitConfig();

    // Assert
    verify(actorSystemContext).getDeviceStateNodeRateLimitConfig();
    assertEquals("Device State Node Rate Limit Config", actualDeviceStateNodeRateLimitConfig);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName("Test getDeviceStateNodeRateLimitConfig(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getDeviceStateNodeRateLimitConfig()"})
  void testGetDeviceStateNodeRateLimitConfig_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDeviceStateNodeRateLimitConfig());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceStateNodeRateLimitConfig()}
   */
  @Test
  @DisplayName("Test getDeviceStateNodeRateLimitConfig(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DefaultTbContext.getDeviceStateNodeRateLimitConfig()"})
  void testGetDeviceStateNodeRateLimitConfig_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceStateNodeRateLimitConfig())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getDeviceStateNodeRateLimitConfig());
    verify(actorSystemContext).getDeviceStateNodeRateLimitConfig();
  }

  /**
   * Test {@link DefaultTbContext#getClusterService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultTbClusterService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getClusterService()}
   */
  @Test
  @DisplayName("Test getClusterService(); then return DefaultTbClusterService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbClusterService DefaultTbContext.getClusterService()"})
  void testGetClusterService_thenReturnDefaultTbClusterService() {
    // Arrange
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getClusterService()}
   */
  @Test
  @DisplayName("Test getClusterService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbClusterService DefaultTbContext.getClusterService()"})
  void testGetClusterService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getClusterService());
  }

  /**
   * Test {@link DefaultTbContext#getClusterService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getClusterService()}
   */
  @Test
  @DisplayName("Test getClusterService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbClusterService DefaultTbContext.getClusterService()"})
  void testGetClusterService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getClusterService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getClusterService());
    verify(actorSystemContext).getClusterService();
  }

  /**
   * Test {@link DefaultTbContext#getDashboardService()}.
   *
   * <ul>
   *   <li>Then return {@link DashboardServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDashboardService()}
   */
  @Test
  @DisplayName("Test getDashboardService(); then return DashboardServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardService DefaultTbContext.getDashboardService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDashboardService()}
   */
  @Test
  @DisplayName("Test getDashboardService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardService DefaultTbContext.getDashboardService()"})
  void testGetDashboardService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDashboardService());
  }

  /**
   * Test {@link DefaultTbContext#getDashboardService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDashboardService()}
   */
  @Test
  @DisplayName("Test getDashboardService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DashboardService DefaultTbContext.getDashboardService()"})
  void testGetDashboardService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDashboardService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDashboardService());
    verify(actorSystemContext).getDashboardService();
  }

  /**
   * Test {@link DefaultTbContext#getAlarmService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultAlarmSubscriptionService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmService()}
   */
  @Test
  @DisplayName("Test getAlarmService(); then return DefaultAlarmSubscriptionService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineAlarmService DefaultTbContext.getAlarmService()"})
  void testGetAlarmService_thenReturnDefaultAlarmSubscriptionService() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();

    BaseAlarmService alarmService =
        new BaseAlarmService(
            tenantService,
            alarmDao,
            entityService,
            new AlarmDataValidator(new TenantServiceImpl()));
    DefaultTbAlarmCommentService alarmCommentService =
        new DefaultTbAlarmCommentService(new BaseAlarmCommentService());
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

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService3,
            tsService2,
            new ApiUsageDataValidator());
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider5,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            partitionService3,
            serviceInfoProvider6,
            scheduler2,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient2);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService2 =
        new DefaultTbApiUsageStateService(
            partitionService2,
            tenantService2,
            tsService,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultAlarmSubscriptionService defaultAlarmSubscriptionService =
        new DefaultAlarmSubscriptionService(
            alarmService,
            alarmCommentService,
            apiUsageClient,
            apiUsageStateService2,
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
   * Test {@link DefaultTbContext#getAlarmService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmService()}
   */
  @Test
  @DisplayName("Test getAlarmService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineAlarmService DefaultTbContext.getAlarmService()"})
  void testGetAlarmService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAlarmService());
  }

  /**
   * Test {@link DefaultTbContext#getAlarmService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmService()}
   */
  @Test
  @DisplayName("Test getAlarmService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineAlarmService DefaultTbContext.getAlarmService()"})
  void testGetAlarmService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAlarmService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAlarmService());
    verify(actorSystemContext).getAlarmService();
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseAlarmCommentService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then return BaseAlarmCommentService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmCommentService DefaultTbContext.getAlarmCommentService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmCommentService DefaultTbContext.getAlarmCommentService()"})
  void testGetAlarmCommentService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAlarmCommentService());
  }

  /**
   * Test {@link DefaultTbContext#getAlarmCommentService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAlarmCommentService()}
   */
  @Test
  @DisplayName("Test getAlarmCommentService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmCommentService DefaultTbContext.getAlarmCommentService()"})
  void testGetAlarmCommentService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAlarmCommentService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAlarmCommentService());
    verify(actorSystemContext).getAlarmCommentService();
  }

  /**
   * Test {@link DefaultTbContext#getRuleChainService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseRuleChainService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRuleChainService()}
   */
  @Test
  @DisplayName("Test getRuleChainService(); then return BaseRuleChainService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainService DefaultTbContext.getRuleChainService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRuleChainService()}
   */
  @Test
  @DisplayName("Test getRuleChainService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainService DefaultTbContext.getRuleChainService()"})
  void testGetRuleChainService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getRuleChainService());
  }

  /**
   * Test {@link DefaultTbContext#getRuleChainService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRuleChainService()}
   */
  @Test
  @DisplayName("Test getRuleChainService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainService DefaultTbContext.getRuleChainService()"})
  void testGetRuleChainService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleChainService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRuleChainService());
    verify(actorSystemContext).getRuleChainService();
  }

  /**
   * Test {@link DefaultTbContext#getTimeseriesService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseTimeseriesService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTimeseriesService()}
   */
  @Test
  @DisplayName("Test getTimeseriesService(); then return BaseTimeseriesService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimeseriesService DefaultTbContext.getTimeseriesService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTimeseriesService()}
   */
  @Test
  @DisplayName("Test getTimeseriesService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimeseriesService DefaultTbContext.getTimeseriesService()"})
  void testGetTimeseriesService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getTimeseriesService());
  }

  /**
   * Test {@link DefaultTbContext#getTimeseriesService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTimeseriesService()}
   */
  @Test
  @DisplayName("Test getTimeseriesService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TimeseriesService DefaultTbContext.getTimeseriesService()"})
  void testGetTimeseriesService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTsService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTimeseriesService());
    verify(actorSystemContext).getTsService();
  }

  /**
   * Test {@link DefaultTbContext#getTelemetryService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultTelemetrySubscriptionService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTelemetryService()}
   */
  @Test
  @DisplayName("Test getTelemetryService(); then return DefaultTelemetrySubscriptionService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineTelemetryService DefaultTbContext.getTelemetryService()"})
  void testGetTelemetryService_thenReturnDefaultTelemetrySubscriptionService() {
    // Arrange
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());

    DefaultTbEntityViewService tbEntityViewService =
        new DefaultTbEntityViewService(
            entityViewService, attributesService, null, new BaseTimeseriesService());
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

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService2,
            tsService3,
            new ApiUsageDataValidator());
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider5,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            partitionService3,
            serviceInfoProvider6,
            scheduler2,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient2);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService2 =
        new DefaultTbApiUsageStateService(
            partitionService2,
            tenantService,
            tsService2,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());

    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService =
        new DefaultTelemetrySubscriptionService(
            attrService, tsService, tbEntityViewService, apiUsageClient, apiUsageStateService2);
    when(actorSystemContext.getTsSubService()).thenReturn(defaultTelemetrySubscriptionService);

    // Act
    RuleEngineTelemetryService actualTelemetryService = defaultTbContext.getTelemetryService();

    // Assert
    verify(actorSystemContext).getTsSubService();
    assertTrue(actualTelemetryService instanceof DefaultTelemetrySubscriptionService);
    assertSame(defaultTelemetrySubscriptionService, actualTelemetryService);
  }

  /**
   * Test {@link DefaultTbContext#getTelemetryService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTelemetryService()}
   */
  @Test
  @DisplayName("Test getTelemetryService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineTelemetryService DefaultTbContext.getTelemetryService()"})
  void testGetTelemetryService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getTelemetryService());
  }

  /**
   * Test {@link DefaultTbContext#getTelemetryService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTelemetryService()}
   */
  @Test
  @DisplayName("Test getTelemetryService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineTelemetryService DefaultTbContext.getTelemetryService()"})
  void testGetTelemetryService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTsSubService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTelemetryService());
    verify(actorSystemContext).getTsSubService();
  }

  /**
   * Test {@link DefaultTbContext#getRelationService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseRelationService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRelationService()}
   */
  @Test
  @DisplayName("Test getRelationService(); then return BaseRelationService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RelationService DefaultTbContext.getRelationService()"})
  void testGetRelationService_thenReturnBaseRelationService() {
    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRelationService()}
   */
  @Test
  @DisplayName("Test getRelationService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RelationService DefaultTbContext.getRelationService()"})
  void testGetRelationService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getRelationService());
  }

  /**
   * Test {@link DefaultTbContext#getRelationService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRelationService()}
   */
  @Test
  @DisplayName("Test getRelationService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RelationService DefaultTbContext.getRelationService()"})
  void testGetRelationService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRelationService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRelationService());
    verify(actorSystemContext).getRelationService();
  }

  /**
   * Test {@link DefaultTbContext#getEntityViewService()}.
   *
   * <ul>
   *   <li>Then return {@link EntityViewServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEntityViewService()}
   */
  @Test
  @DisplayName("Test getEntityViewService(); then return EntityViewServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewService DefaultTbContext.getEntityViewService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEntityViewService()}
   */
  @Test
  @DisplayName("Test getEntityViewService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewService DefaultTbContext.getEntityViewService()"})
  void testGetEntityViewService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getEntityViewService());
  }

  /**
   * Test {@link DefaultTbContext#getEntityViewService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEntityViewService()}
   */
  @Test
  @DisplayName("Test getEntityViewService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityViewService DefaultTbContext.getEntityViewService()"})
  void testGetEntityViewService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEntityViewService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEntityViewService());
    verify(actorSystemContext).getEntityViewService();
  }

  /**
   * Test {@link DefaultTbContext#getResourceService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseResourceService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getResourceService()}
   */
  @Test
  @DisplayName("Test getResourceService(); then return BaseResourceService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceService DefaultTbContext.getResourceService()"})
  void testGetResourceService_thenReturnBaseResourceService() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService baseResourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getResourceService()}
   */
  @Test
  @DisplayName("Test getResourceService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceService DefaultTbContext.getResourceService()"})
  void testGetResourceService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getResourceService());
  }

  /**
   * Test {@link DefaultTbContext#getResourceService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getResourceService()}
   */
  @Test
  @DisplayName("Test getResourceService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceService DefaultTbContext.getResourceService()"})
  void testGetResourceService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getResourceService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getResourceService());
    verify(actorSystemContext).getResourceService();
  }

  /**
   * Test {@link DefaultTbContext#getOtaPackageService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseOtaPackageService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getOtaPackageService()}
   */
  @Test
  @DisplayName("Test getOtaPackageService(); then return BaseOtaPackageService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageService DefaultTbContext.getOtaPackageService()"})
  void testGetOtaPackageService_thenReturnBaseOtaPackageService() {
    // Arrange
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();

    BaseOtaPackageService baseOtaPackageService =
        new BaseOtaPackageService(
            otaPackageDao,
            otaPackageInfoDao,
            null,
            otaPackageInfoValidator,
            new OtaPackageDataValidator());
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getOtaPackageService()}
   */
  @Test
  @DisplayName("Test getOtaPackageService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageService DefaultTbContext.getOtaPackageService()"})
  void testGetOtaPackageService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getOtaPackageService());
  }

  /**
   * Test {@link DefaultTbContext#getOtaPackageService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getOtaPackageService()}
   */
  @Test
  @DisplayName("Test getOtaPackageService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackageService DefaultTbContext.getOtaPackageService()"})
  void testGetOtaPackageService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getOtaPackageService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getOtaPackageService());
    verify(actorSystemContext).getOtaPackageService();
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileCache()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultTbDeviceProfileCache}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceProfileCache()}
   */
  @Test
  @DisplayName("Test getDeviceProfileCache(); then return DefaultTbDeviceProfileCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineDeviceProfileCache DefaultTbContext.getDeviceProfileCache()"})
  void testGetDeviceProfileCache_thenReturnDefaultTbDeviceProfileCache() {
    // Arrange
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);

    // Act
    RuleEngineDeviceProfileCache actualDeviceProfileCache =
        defaultTbContext.getDeviceProfileCache();

    // Assert
    verify(actorSystemContext).getDeviceProfileCache();
    assertTrue(actualDeviceProfileCache instanceof DefaultTbDeviceProfileCache);
    assertSame(defaultTbDeviceProfileCache, actualDeviceProfileCache);
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileCache()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceProfileCache()}
   */
  @Test
  @DisplayName("Test getDeviceProfileCache(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineDeviceProfileCache DefaultTbContext.getDeviceProfileCache()"})
  void testGetDeviceProfileCache_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDeviceProfileCache());
  }

  /**
   * Test {@link DefaultTbContext#getDeviceProfileCache()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDeviceProfileCache()}
   */
  @Test
  @DisplayName("Test getDeviceProfileCache(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineDeviceProfileCache DefaultTbContext.getDeviceProfileCache()"})
  void testGetDeviceProfileCache_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDeviceProfileCache());
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileCache()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultTbAssetProfileCache}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetProfileCache()}
   */
  @Test
  @DisplayName("Test getAssetProfileCache(); then return DefaultTbAssetProfileCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineAssetProfileCache DefaultTbContext.getAssetProfileCache()"})
  void testGetAssetProfileCache_thenReturnDefaultTbAssetProfileCache() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetProfileCache()}
   */
  @Test
  @DisplayName("Test getAssetProfileCache(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineAssetProfileCache DefaultTbContext.getAssetProfileCache()"})
  void testGetAssetProfileCache_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAssetProfileCache());
  }

  /**
   * Test {@link DefaultTbContext#getAssetProfileCache()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAssetProfileCache()}
   */
  @Test
  @DisplayName("Test getAssetProfileCache(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineAssetProfileCache DefaultTbContext.getAssetProfileCache()"})
  void testGetAssetProfileCache_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAssetProfileCache());
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getEdgeService()}.
   *
   * <ul>
   *   <li>Then return {@link EdgeServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEdgeService()}
   */
  @Test
  @DisplayName("Test getEdgeService(); then return EdgeServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeService DefaultTbContext.getEdgeService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEdgeService()}
   */
  @Test
  @DisplayName("Test getEdgeService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeService DefaultTbContext.getEdgeService()"})
  void testGetEdgeService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getEdgeService());
  }

  /**
   * Test {@link DefaultTbContext#getEdgeService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEdgeService()}
   */
  @Test
  @DisplayName("Test getEdgeService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeService DefaultTbContext.getEdgeService()"})
  void testGetEdgeService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEdgeService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEdgeService());
    verify(actorSystemContext).getEdgeService();
  }

  /**
   * Test {@link DefaultTbContext#getEdgeEventService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseEdgeEventService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEdgeEventService()}
   */
  @Test
  @DisplayName("Test getEdgeEventService(); then return BaseEdgeEventService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventService DefaultTbContext.getEdgeEventService()"})
  void testGetEdgeEventService_thenReturnBaseEdgeEventService() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            mock(EdgeEventRepository.class),
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    BaseEdgeEventService baseEdgeEventService =
        new BaseEdgeEventService(
            edgeEventDao,
            rateLimitService,
            new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class));
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEdgeEventService()}
   */
  @Test
  @DisplayName("Test getEdgeEventService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventService DefaultTbContext.getEdgeEventService()"})
  void testGetEdgeEventService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getEdgeEventService());
  }

  /**
   * Test {@link DefaultTbContext#getEdgeEventService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEdgeEventService()}
   */
  @Test
  @DisplayName("Test getEdgeEventService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventService DefaultTbContext.getEdgeEventService()"})
  void testGetEdgeEventService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEdgeEventService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEdgeEventService());
    verify(actorSystemContext).getEdgeEventService();
  }

  /**
   * Test {@link DefaultTbContext#getQueueService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseQueueService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueService()}
   */
  @Test
  @DisplayName("Test getQueueService(); then return BaseQueueService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueService DefaultTbContext.getQueueService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueService()}
   */
  @Test
  @DisplayName("Test getQueueService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueService DefaultTbContext.getQueueService()"})
  void testGetQueueService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getQueueService());
  }

  /**
   * Test {@link DefaultTbContext#getQueueService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueService()}
   */
  @Test
  @DisplayName("Test getQueueService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueService DefaultTbContext.getQueueService()"})
  void testGetQueueService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getQueueService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getQueueService());
    verify(actorSystemContext).getQueueService();
  }

  /**
   * Test {@link DefaultTbContext#getQueueStatsService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseQueueStatsService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueStatsService()}
   */
  @Test
  @DisplayName("Test getQueueStatsService(); then return BaseQueueStatsService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueStatsService DefaultTbContext.getQueueStatsService()"})
  void testGetQueueStatsService_thenReturnBaseQueueStatsService() {
    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService baseQueueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueStatsService()}
   */
  @Test
  @DisplayName("Test getQueueStatsService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueStatsService DefaultTbContext.getQueueStatsService()"})
  void testGetQueueStatsService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getQueueStatsService());
  }

  /**
   * Test {@link DefaultTbContext#getQueueStatsService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getQueueStatsService()}
   */
  @Test
  @DisplayName("Test getQueueStatsService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueStatsService DefaultTbContext.getQueueStatsService()"})
  void testGetQueueStatsService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getQueueStatsService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getQueueStatsService());
    verify(actorSystemContext).getQueueStatsService();
  }

  /**
   * Test {@link DefaultTbContext#getSharedEventLoop()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSharedEventLoop()}
   */
  @Test
  @DisplayName("Test getSharedEventLoop(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventLoopGroup DefaultTbContext.getSharedEventLoop()"})
  void testGetSharedEventLoop_thenReturnNull() {
    // Arrange
    when(actorSystemContext.getSharedEventLoopGroupService())
        .thenReturn(new SharedEventLoopGroupService());

    // Act
    EventLoopGroup actualSharedEventLoop = defaultTbContext.getSharedEventLoop();

    // Assert
    verify(actorSystemContext).getSharedEventLoopGroupService();
    assertNull(actualSharedEventLoop);
  }

  /**
   * Test {@link DefaultTbContext#getSharedEventLoop()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSharedEventLoop()}
   */
  @Test
  @DisplayName("Test getSharedEventLoop(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventLoopGroup DefaultTbContext.getSharedEventLoop()"})
  void testGetSharedEventLoop_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSharedEventLoopGroupService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSharedEventLoop());
    verify(actorSystemContext).getSharedEventLoopGroupService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService() {
    // Arrange
    when(actorSystemContext.isAllowSystemMailService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailService(true));
    verify(actorSystemContext).isAllowSystemMailService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService2() {
    // Arrange
    when(actorSystemContext.getMailService()).thenThrow(new IllegalArgumentException());
    when(actorSystemContext.isAllowSystemMailService()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMailService(true));
    verify(actorSystemContext).getMailService();
    verify(actorSystemContext).isAllowSystemMailService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isAllowSystemMailService()}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName(
      "Test getMailService(boolean); given ActorSystemContext isAllowSystemMailService() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService_givenActorSystemContextIsAllowSystemMailServiceReturnFalse() {
    // Arrange
    when(actorSystemContext.isAllowSystemMailService()).thenReturn(false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.getMailService(true));
    verify(actorSystemContext).isAllowSystemMailService();
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultMailService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then return DefaultMailService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService_thenReturnDefaultMailService() {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService defaultMailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
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
   *
   * <ul>
   *   <li>Then return {@link DefaultMailService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then return DefaultMailService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService_thenReturnDefaultMailService2() {
    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService defaultMailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    when(actorSystemContext.getMailService()).thenReturn(defaultMailService);

    // Act
    MailService actualMailService = defaultTbContext.getMailService(false);

    // Assert
    verify(actorSystemContext).getMailService();
    assertTrue(actualMailService instanceof DefaultMailService);
    assertSame(defaultMailService, actualMailService);
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getMailService(false));
  }

  /**
   * Test {@link DefaultTbContext#getMailService(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMailService(boolean)}
   */
  @Test
  @DisplayName("Test getMailService(boolean); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MailService DefaultTbContext.getMailService(boolean)"})
  void testGetMailService_thenThrowRuntimeException() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.getMailService(true));
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsService DefaultTbContext.getSmsService()"})
  void testGetSmsService() {
    // Arrange
    when(actorSystemContext.isAllowSystemSmsService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsService());
    verify(actorSystemContext).isAllowSystemSmsService();
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsService DefaultTbContext.getSmsService()"})
  void testGetSmsService2() {
    // Arrange
    when(actorSystemContext.getSmsService()).thenThrow(new IllegalArgumentException());
    when(actorSystemContext.isAllowSystemSmsService()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSmsService());
    verify(actorSystemContext).getSmsService();
    verify(actorSystemContext).isAllowSystemSmsService();
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsService DefaultTbContext.getSmsService()"})
  void testGetSmsService3() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.getSmsService());
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#isAllowSystemSmsService()}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName(
      "Test getSmsService(); given ActorSystemContext isAllowSystemSmsService() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsService DefaultTbContext.getSmsService()"})
  void testGetSmsService_givenActorSystemContextIsAllowSystemSmsServiceReturnFalse() {
    // Arrange
    when(actorSystemContext.isAllowSystemSmsService()).thenReturn(false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbContext.getSmsService());
    verify(actorSystemContext).isAllowSystemSmsService();
  }

  /**
   * Test {@link DefaultTbContext#getSmsService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultSmsService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsService()}
   */
  @Test
  @DisplayName("Test getSmsService(); then return DefaultSmsService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsService DefaultTbContext.getSmsService()"})
  void testGetSmsService_thenReturnDefaultSmsService() {
    // Arrange
    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
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
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService2,
            tsService2,
            new ApiUsageDataValidator());
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(null));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService2, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService apiUsageStateService2 =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService,
            tsService,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider6,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient2 =
        new DefaultTbApiUsageReportClient(
            partitionService3,
            serviceInfoProvider5,
            scheduler2,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultSmsService defaultSmsService =
        new DefaultSmsService(
            smsSenderFactory, adminSettingsService, apiUsageStateService2, apiUsageClient2);
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
   * Test {@link DefaultTbContext#getSmsSenderFactory()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsSenderFactory()}
   */
  @Test
  @DisplayName("Test getSmsSenderFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsSenderFactory DefaultTbContext.getSmsSenderFactory()"})
  void testGetSmsSenderFactory() {
    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    config.setRegion("us-east-2");
    config.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    AwsSmsSender awsSmsSender = new AwsSmsSender(config);

    SmsSenderFactory smsSenderFactory = mock(SmsSenderFactory.class);
    when(smsSenderFactory.createSmsSender(Mockito.<SmsProviderConfiguration>any()))
        .thenReturn(awsSmsSender);
    when(actorSystemContext.getSmsSenderFactory()).thenReturn(smsSenderFactory);

    // Act
    SmsSender actualCreateSmsSenderResult =
        defaultTbContext
            .getSmsSenderFactory()
            .createSmsSender(mock(SmsProviderConfiguration.class));

    // Assert
    verify(smsSenderFactory).createSmsSender(isA(SmsProviderConfiguration.class));
    verify(actorSystemContext).getSmsSenderFactory();
    assertTrue(actualCreateSmsSenderResult instanceof AwsSmsSender);
    assertSame(awsSmsSender, actualCreateSmsSenderResult);
  }

  /**
   * Test {@link DefaultTbContext#getSmsSenderFactory()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSmsSenderFactory()}
   */
  @Test
  @DisplayName("Test getSmsSenderFactory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SmsSenderFactory DefaultTbContext.getSmsSenderFactory()"})
  void testGetSmsSenderFactory_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getSmsSenderFactory());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationCenter()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultNotificationCenter}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationCenter()}
   */
  @Test
  @DisplayName("Test getNotificationCenter(); then return DefaultNotificationCenter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationCenter DefaultTbContext.getNotificationCenter()"})
  void testGetNotificationCenter_thenReturnDefaultNotificationCenter() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    JpaNotificationRequestDao notificationRequestDao2 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationDao notificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    DefaultNotificationRequestService notificationRequestService =
        new DefaultNotificationRequestService(
            notificationRequestDao2, notificationDao, mock(ApplicationEventPublisher.class));
    JpaNotificationDao notificationDao2 =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));
    DefaultNotificationService notificationService =
        new DefaultNotificationService(notificationDao2);
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao3);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao4 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();

    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao2,
            userSettingsService2,
            userSettingsDao2,
            securitySettingsService2,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService2,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService2 =
        new DefaultNotificationTargetService(
            notificationTargetDao2, notificationRequestDao4, notificationRuleDao2, userService2);
    JpaNotificationTemplateDao notificationTemplateDao2 =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao5 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService2 =
        new DefaultNotificationTemplateService(notificationTemplateDao2, notificationRequestDao5);
    JpaNotificationTemplateDao notificationTemplateDao3 =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao6 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService templateService =
        new DefaultNotificationTemplateService(notificationTemplateDao3, notificationRequestDao6);
    JpaNotificationRuleDao notificationRuleDao3 =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService ruleService =
        new DefaultNotificationRuleService(notificationRuleDao3);

    DefaultNotifications defaultNotifications =
        new DefaultNotifications(templateService, ruleService);

    DefaultNotificationSettingsService notificationSettingsService =
        new DefaultNotificationSettingsService(
            adminSettingsService,
            notificationTargetService2,
            notificationTemplateService2,
            defaultNotifications,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));
    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    DefaultNotificationCenter defaultNotificationCenter =
        new DefaultNotificationCenter(
            notificationTargetService,
            notificationRequestService,
            notificationService,
            notificationTemplateService,
            notificationSettingsService,
            notificationExecutor,
            topicService,
            producerProvider,
            rateLimitService);
    when(actorSystemContext.getNotificationCenter()).thenReturn(defaultNotificationCenter);

    // Act
    NotificationCenter actualNotificationCenter = defaultTbContext.getNotificationCenter();

    // Assert
    verify(actorSystemContext).getNotificationCenter();
    assertTrue(actualNotificationCenter instanceof DefaultNotificationCenter);
    assertEquals(
        NotificationDeliveryMethod.WEB,
        ((DefaultNotificationCenter) actualNotificationCenter).getDeliveryMethod());
    assertSame(defaultNotificationCenter, actualNotificationCenter);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationCenter()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationCenter()}
   */
  @Test
  @DisplayName("Test getNotificationCenter(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationCenter DefaultTbContext.getNotificationCenter()"})
  void testGetNotificationCenter_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getNotificationCenter());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationCenter()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationCenter()}
   */
  @Test
  @DisplayName("Test getNotificationCenter(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationCenter DefaultTbContext.getNotificationCenter()"})
  void testGetNotificationCenter_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationCenter()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getNotificationCenter());
    verify(actorSystemContext).getNotificationCenter();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTargetService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultNotificationTargetService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationTargetService()}
   */
  @Test
  @DisplayName("Test getNotificationTargetService(); then return DefaultNotificationTargetService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTargetService DefaultTbContext.getNotificationTargetService()"})
  void testGetNotificationTargetService_thenReturnDefaultNotificationTargetService() {
    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService defaultNotificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    when(actorSystemContext.getNotificationTargetService())
        .thenReturn(defaultNotificationTargetService);

    // Act
    NotificationTargetService actualNotificationTargetService =
        defaultTbContext.getNotificationTargetService();

    // Assert
    verify(actorSystemContext).getNotificationTargetService();
    assertTrue(actualNotificationTargetService instanceof DefaultNotificationTargetService);
    assertEquals(
        EntityType.NOTIFICATION_TARGET,
        ((DefaultNotificationTargetService) actualNotificationTargetService).getEntityType());
    assertSame(defaultNotificationTargetService, actualNotificationTargetService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTargetService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationTargetService()}
   */
  @Test
  @DisplayName("Test getNotificationTargetService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTargetService DefaultTbContext.getNotificationTargetService()"})
  void testGetNotificationTargetService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getNotificationTargetService());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTargetService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationTargetService()}
   */
  @Test
  @DisplayName("Test getNotificationTargetService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationTargetService DefaultTbContext.getNotificationTargetService()"})
  void testGetNotificationTargetService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationTargetService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getNotificationTargetService());
    verify(actorSystemContext).getNotificationTargetService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTemplateService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultNotificationTemplateService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationTemplateService()}
   */
  @Test
  @DisplayName(
      "Test getNotificationTemplateService(); then return DefaultNotificationTemplateService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplateService DefaultTbContext.getNotificationTemplateService()"
  })
  void testGetNotificationTemplateService_thenReturnDefaultNotificationTemplateService() {
    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService defaultNotificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);
    when(actorSystemContext.getNotificationTemplateService())
        .thenReturn(defaultNotificationTemplateService);

    // Act
    NotificationTemplateService actualNotificationTemplateService =
        defaultTbContext.getNotificationTemplateService();

    // Assert
    verify(actorSystemContext).getNotificationTemplateService();
    assertTrue(actualNotificationTemplateService instanceof DefaultNotificationTemplateService);
    assertEquals(
        EntityType.NOTIFICATION_TEMPLATE,
        ((DefaultNotificationTemplateService) actualNotificationTemplateService).getEntityType());
    assertSame(defaultNotificationTemplateService, actualNotificationTemplateService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTemplateService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationTemplateService()}
   */
  @Test
  @DisplayName("Test getNotificationTemplateService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplateService DefaultTbContext.getNotificationTemplateService()"
  })
  void testGetNotificationTemplateService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getNotificationTemplateService());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationTemplateService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationTemplateService()}
   */
  @Test
  @DisplayName("Test getNotificationTemplateService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTemplateService DefaultTbContext.getNotificationTemplateService()"
  })
  void testGetNotificationTemplateService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationTemplateService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getNotificationTemplateService());
    verify(actorSystemContext).getNotificationTemplateService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRequestService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultNotificationRequestService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationRequestService()}
   */
  @Test
  @DisplayName(
      "Test getNotificationRequestService(); then return DefaultNotificationRequestService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequestService DefaultTbContext.getNotificationRequestService()"})
  void testGetNotificationRequestService_thenReturnDefaultNotificationRequestService() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationDao notificationDao =
        new JpaNotificationDao(
            mock(NotificationRepository.class), mock(SqlPartitioningRepository.class));

    DefaultNotificationRequestService defaultNotificationRequestService =
        new DefaultNotificationRequestService(
            notificationRequestDao, notificationDao, mock(ApplicationEventPublisher.class));
    when(actorSystemContext.getNotificationRequestService())
        .thenReturn(defaultNotificationRequestService);

    // Act
    NotificationRequestService actualNotificationRequestService =
        defaultTbContext.getNotificationRequestService();

    // Assert
    verify(actorSystemContext).getNotificationRequestService();
    assertTrue(actualNotificationRequestService instanceof DefaultNotificationRequestService);
    assertEquals(
        EntityType.NOTIFICATION_REQUEST,
        ((DefaultNotificationRequestService) actualNotificationRequestService).getEntityType());
    assertSame(defaultNotificationRequestService, actualNotificationRequestService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRequestService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationRequestService()}
   */
  @Test
  @DisplayName("Test getNotificationRequestService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequestService DefaultTbContext.getNotificationRequestService()"})
  void testGetNotificationRequestService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getNotificationRequestService());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRequestService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationRequestService()}
   */
  @Test
  @DisplayName("Test getNotificationRequestService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRequestService DefaultTbContext.getNotificationRequestService()"})
  void testGetNotificationRequestService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationRequestService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getNotificationRequestService());
    verify(actorSystemContext).getNotificationRequestService();
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRuleService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultNotificationRuleService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationRuleService()}
   */
  @Test
  @DisplayName("Test getNotificationRuleService(); then return DefaultNotificationRuleService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRuleService DefaultTbContext.getNotificationRuleService()"})
  void testGetNotificationRuleService_thenReturnDefaultNotificationRuleService() {
    // Arrange
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService defaultNotificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    when(actorSystemContext.getNotificationRuleService())
        .thenReturn(defaultNotificationRuleService);

    // Act
    NotificationRuleService actualNotificationRuleService =
        defaultTbContext.getNotificationRuleService();

    // Assert
    verify(actorSystemContext).getNotificationRuleService();
    assertTrue(actualNotificationRuleService instanceof DefaultNotificationRuleService);
    assertEquals(
        EntityType.NOTIFICATION_RULE,
        ((DefaultNotificationRuleService) actualNotificationRuleService).getEntityType());
    assertSame(defaultNotificationRuleService, actualNotificationRuleService);
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRuleService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationRuleService()}
   */
  @Test
  @DisplayName("Test getNotificationRuleService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRuleService DefaultTbContext.getNotificationRuleService()"})
  void testGetNotificationRuleService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getNotificationRuleService());
  }

  /**
   * Test {@link DefaultTbContext#getNotificationRuleService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getNotificationRuleService()}
   */
  @Test
  @DisplayName("Test getNotificationRuleService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"NotificationRuleService DefaultTbContext.getNotificationRuleService()"})
  void testGetNotificationRuleService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getNotificationRuleService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getNotificationRuleService());
    verify(actorSystemContext).getNotificationRuleService();
  }

  /**
   * Test {@link DefaultTbContext#getOAuth2ClientService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getOAuth2ClientService()}
   */
  @Test
  @DisplayName("Test getOAuth2ClientService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientService DefaultTbContext.getOAuth2ClientService()"})
  void testGetOAuth2ClientService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getOAuth2ClientService());
  }

  /**
   * Test {@link DefaultTbContext#getOAuth2ClientService()}.
   *
   * <ul>
   *   <li>Then return {@link OAuth2ClientServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getOAuth2ClientService()}
   */
  @Test
  @DisplayName("Test getOAuth2ClientService(); then return OAuth2ClientServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientService DefaultTbContext.getOAuth2ClientService()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getOAuth2ClientService()}
   */
  @Test
  @DisplayName("Test getOAuth2ClientService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OAuth2ClientService DefaultTbContext.getOAuth2ClientService()"})
  void testGetOAuth2ClientService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getOAuth2ClientService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getOAuth2ClientService());
    verify(actorSystemContext).getOAuth2ClientService();
  }

  /**
   * Test {@link DefaultTbContext#getDomainService()}.
   *
   * <ul>
   *   <li>Then return {@link DomainServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDomainService()}
   */
  @Test
  @DisplayName("Test getDomainService(); then return DomainServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainService DefaultTbContext.getDomainService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDomainService()}
   */
  @Test
  @DisplayName("Test getDomainService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainService DefaultTbContext.getDomainService()"})
  void testGetDomainService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getDomainService());
  }

  /**
   * Test {@link DefaultTbContext#getDomainService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getDomainService()}
   */
  @Test
  @DisplayName("Test getDomainService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DomainService DefaultTbContext.getDomainService()"})
  void testGetDomainService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getDomainService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getDomainService());
    verify(actorSystemContext).getDomainService();
  }

  /**
   * Test {@link DefaultTbContext#getMobileAppService()}.
   *
   * <ul>
   *   <li>Then return {@link MobileAppServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMobileAppService()}
   */
  @Test
  @DisplayName("Test getMobileAppService(); then return MobileAppServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppService DefaultTbContext.getMobileAppService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMobileAppService()}
   */
  @Test
  @DisplayName("Test getMobileAppService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppService DefaultTbContext.getMobileAppService()"})
  void testGetMobileAppService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getMobileAppService());
  }

  /**
   * Test {@link DefaultTbContext#getMobileAppService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getMobileAppService()}
   */
  @Test
  @DisplayName("Test getMobileAppService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MobileAppService DefaultTbContext.getMobileAppService()"})
  void testGetMobileAppService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getMobileAppService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getMobileAppService());
    verify(actorSystemContext).getMobileAppService();
  }

  /**
   * Test {@link DefaultTbContext#getSlackService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultSlackService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSlackService()}
   */
  @Test
  @DisplayName("Test getSlackService(); then return DefaultSlackService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SlackService DefaultTbContext.getSlackService()"})
  void testGetSlackService_thenReturnDefaultSlackService() {
    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao2);
    JpaNotificationTemplateDao notificationTemplateDao2 =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService templateService =
        new DefaultNotificationTemplateService(notificationTemplateDao2, notificationRequestDao3);
    JpaNotificationRuleDao notificationRuleDao2 =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService ruleService =
        new DefaultNotificationRuleService(notificationRuleDao2);

    DefaultNotifications defaultNotifications =
        new DefaultNotifications(templateService, ruleService);

    DefaultNotificationSettingsService notificationSettingsService =
        new DefaultNotificationSettingsService(
            adminSettingsService,
            notificationTargetService,
            notificationTemplateService,
            defaultNotifications,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));
    DefaultSlackService defaultSlackService = new DefaultSlackService(notificationSettingsService);
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSlackService()}
   */
  @Test
  @DisplayName("Test getSlackService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SlackService DefaultTbContext.getSlackService()"})
  void testGetSlackService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getSlackService());
  }

  /**
   * Test {@link DefaultTbContext#getSlackService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getSlackService()}
   */
  @Test
  @DisplayName("Test getSlackService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SlackService DefaultTbContext.getSlackService()"})
  void testGetSlackService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getSlackService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getSlackService());
    verify(actorSystemContext).getSlackService();
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck() {
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
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck2() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertFalse(defaultTbContext.isExternalNodeForceAck());
  }

  /**
   * Test {@link DefaultTbContext#isExternalNodeForceAck()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#isExternalNodeForceAck()}
   */
  @Test
  @DisplayName("Test isExternalNodeForceAck(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTbContext.isExternalNodeForceAck()"})
  void testIsExternalNodeForceAck_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.isExternalNodeForceAck()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.isExternalNodeForceAck());
    verify(actorSystemContext).isExternalNodeForceAck();
  }

  /**
   * Test {@link DefaultTbContext#getRpcService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultTbRuleEngineRpcService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRpcService()}
   */
  @Test
  @DisplayName("Test getRpcService(); then return DefaultTbRuleEngineRpcService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineRpcService DefaultTbContext.getRpcService()"})
  void testGetRpcService_thenReturnDefaultTbRuleEngineRpcService() {
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

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    JpaRpcDao rpcDao = new JpaRpcDao(mock(RpcRepository.class));
    BaseRpcService rpcService = new BaseRpcService(rpcDao);

    DefaultTbRuleEngineRpcService defaultTbRuleEngineRpcService =
        new DefaultTbRuleEngineRpcService(
            partitionService, clusterService, serviceInfoProvider2, rpcService);
    when(actorSystemContext.getTbRuleEngineDeviceRpcService())
        .thenReturn(defaultTbRuleEngineRpcService);

    // Act
    RuleEngineRpcService actualRpcService = defaultTbContext.getRpcService();

    // Assert
    verify(actorSystemContext).getTbRuleEngineDeviceRpcService();
    assertTrue(actualRpcService instanceof DefaultTbRuleEngineRpcService);
    assertSame(defaultTbRuleEngineRpcService, actualRpcService);
  }

  /**
   * Test {@link DefaultTbContext#getRpcService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRpcService()}
   */
  @Test
  @DisplayName("Test getRpcService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineRpcService DefaultTbContext.getRpcService()"})
  void testGetRpcService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getRpcService());
  }

  /**
   * Test {@link DefaultTbContext#getRpcService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRpcService()}
   */
  @Test
  @DisplayName("Test getRpcService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleEngineRpcService DefaultTbContext.getRpcService()"})
  void testGetRpcService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getTbRuleEngineDeviceRpcService())
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getRpcService());
    verify(actorSystemContext).getTbRuleEngineDeviceRpcService();
  }

  /**
   * Test {@link DefaultTbContext#getCassandraCluster()}.
   *
   * <ul>
   *   <li>Then return KeyspaceName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getCassandraCluster()}
   */
  @Test
  @DisplayName("Test getCassandraCluster(); then return KeyspaceName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CassandraCluster DefaultTbContext.getCassandraCluster()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getCassandraCluster()}
   */
  @Test
  @DisplayName("Test getCassandraCluster(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CassandraCluster DefaultTbContext.getCassandraCluster()"})
  void testGetCassandraCluster_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getCassandraCluster());
  }

  /**
   * Test {@link DefaultTbContext#getCassandraCluster()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getCassandraCluster()}
   */
  @Test
  @DisplayName("Test getCassandraCluster(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CassandraCluster DefaultTbContext.getCassandraCluster()"})
  void testGetCassandraCluster_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getCassandraCluster()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getCassandraCluster());
    verify(actorSystemContext).getCassandraCluster();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStates(PageLink)}.
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStates(PageLink)}
   */
  @Test
  @DisplayName("Test findRuleNodeStates(PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DefaultTbContext.findRuleNodeStates(PageLink)"})
  void testFindRuleNodeStates() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.findRuleNodeStates(new PageLink(3)));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStates(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStates(PageLink)}
   */
  @Test
  @DisplayName(
      "Test findRuleNodeStates(PageLink); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DefaultTbContext.findRuleNodeStates(PageLink)"})
  void testFindRuleNodeStates_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(new BaseRuleNodeStateService());
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.findRuleNodeStates(new PageLink(3)));
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStates(PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStates(PageLink)}
   */
  @Test
  @DisplayName("Test findRuleNodeStates(PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DefaultTbContext.findRuleNodeStates(PageLink)"})
  void testFindRuleNodeStates_thenReturnEmpty_page_data() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    PageData<RuleNodeState> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeStateService.findByRuleNodeId(
            Mockito.<TenantId>any(), Mockito.<RuleNodeId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    PageData<RuleNodeState> actualFindRuleNodeStatesResult =
        defaultTbContext.findRuleNodeStates(new PageLink(3));

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNodeStateService)
        .findByRuleNodeId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleNodeStatesResult);
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test findRuleNodeStateForEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.findRuleNodeStateForEntity(EntityId)"})
  void testFindRuleNodeStateForEntity() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.findRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test findRuleNodeStateForEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.findRuleNodeStateForEntity(EntityId)"})
  void testFindRuleNodeStateForEntity2() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(new BaseRuleNodeStateService());
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.findRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#findRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test findRuleNodeStateForEntity(EntityId); then return RuleNodeState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.findRuleNodeStateForEntity(EntityId)"})
  void testFindRuleNodeStateForEntity_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateService.findByRuleNodeIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<RuleNodeId>any(), Mockito.<EntityId>any()))
        .thenReturn(ruleNodeState);
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    RuleNodeState actualFindRuleNodeStateForEntityResult =
        defaultTbContext.findRuleNodeStateForEntity(null);

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNodeStateService)
        .findByRuleNodeIdAndEntityId(isA(TenantId.class), isNull(), isNull());
    assertSame(ruleNodeState, actualFindRuleNodeStateForEntityResult);
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   *
   * <p>Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName("Test saveRuleNodeState(RuleNodeState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.saveRuleNodeState(RuleNodeState)"})
  void testSaveRuleNodeState() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.saveRuleNodeState(new RuleNodeState()));
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   *
   * <p>Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName("Test saveRuleNodeState(RuleNodeState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.saveRuleNodeState(RuleNodeState)"})
  void testSaveRuleNodeState2() {
    // Arrange
    RuleNodeCtx nodeCtx = mock(RuleNodeCtx.class);
    when(nodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(nodeCtx.getSelf()).thenReturn(new RuleNode());
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", nodeCtx);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.saveRuleNodeState(new RuleNodeState()));
    verify(nodeCtx).getSelf();
    verify(nodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName(
      "Test saveRuleNodeState(RuleNodeState); given ActorSystemContext; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.saveRuleNodeState(RuleNodeState)"})
  void testSaveRuleNodeState_givenActorSystemContext_thenThrowIllegalArgumentException() {
    // Arrange
    when(ruleNodeCtx.getSelf()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.saveRuleNodeState(new RuleNodeState()));
    verify(ruleNodeCtx).getSelf();
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName(
      "Test saveRuleNodeState(RuleNodeState); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.saveRuleNodeState(RuleNodeState)"})
  void testSaveRuleNodeState_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(new BaseRuleNodeStateService());
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.saveRuleNodeState(new RuleNodeState()));
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}.
   *
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#saveRuleNodeState(RuleNodeState)}
   */
  @Test
  @DisplayName("Test saveRuleNodeState(RuleNodeState); then return RuleNodeState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState DefaultTbContext.saveRuleNodeState(RuleNodeState)"})
  void testSaveRuleNodeState_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateService.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenReturn(ruleNodeState);
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    RuleNodeState actualSaveRuleNodeStateResult =
        defaultTbContext.saveRuleNodeState(new RuleNodeState());

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNodeStateService).save(isA(TenantId.class), isA(RuleNodeState.class));
    assertSame(ruleNodeState, actualSaveRuleNodeStateResult);
  }

  /**
   * Test {@link DefaultTbContext#clearRuleNodeStates()}.
   *
   * <p>Method under test: {@link DefaultTbContext#clearRuleNodeStates()}
   */
  @Test
  @DisplayName("Test clearRuleNodeStates()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.clearRuleNodeStates()"})
  void testClearRuleNodeStates() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.clearRuleNodeStates());
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#clearRuleNodeStates()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#clearRuleNodeStates()}
   */
  @Test
  @DisplayName(
      "Test clearRuleNodeStates(); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.clearRuleNodeStates()"})
  void testClearRuleNodeStates_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(new BaseRuleNodeStateService());
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.clearRuleNodeStates());
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#clearRuleNodeStates()}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeCtx#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#clearRuleNodeStates()}
   */
  @Test
  @DisplayName("Test clearRuleNodeStates(); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.clearRuleNodeStates()"})
  void testClearRuleNodeStates_thenCallsGetSelf() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    doNothing()
        .when(ruleNodeStateService)
        .removeByRuleNodeId(Mockito.<TenantId>any(), Mockito.<RuleNodeId>any());
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    defaultTbContext.clearRuleNodeStates();

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNodeStateService).removeByRuleNodeId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test removeRuleNodeStateForEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeRuleNodeStateForEntity(EntityId)"})
  void testRemoveRuleNodeStateForEntity() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.removeRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
  }

  /**
   * Test {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test removeRuleNodeStateForEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeRuleNodeStateForEntity(EntityId)"})
  void testRemoveRuleNodeStateForEntity2() {
    // Arrange
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(new BaseRuleNodeStateService());
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.removeRuleNodeStateForEntity(null));
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeCtx#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#removeRuleNodeStateForEntity(EntityId)}
   */
  @Test
  @DisplayName("Test removeRuleNodeStateForEntity(EntityId); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeRuleNodeStateForEntity(EntityId)"})
  void testRemoveRuleNodeStateForEntity_thenCallsGetSelf() {
    // Arrange
    RuleNodeStateService ruleNodeStateService = mock(RuleNodeStateService.class);
    doNothing()
        .when(ruleNodeStateService)
        .removeByRuleNodeIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<RuleNodeId>any(), Mockito.<EntityId>any());
    when(actorSystemContext.getRuleNodeStateService()).thenReturn(ruleNodeStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    defaultTbContext.removeRuleNodeStateForEntity(null);

    // Assert
    verify(actorSystemContext).getRuleNodeStateService();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(ruleNodeStateService)
        .removeByRuleNodeIdAndEntityId(isA(TenantId.class), isNull(), isNull());
  }

  /**
   * Test {@link DefaultTbContext#addTenantProfileListener(Consumer)}.
   *
   * <p>Method under test: {@link DefaultTbContext#addTenantProfileListener(Consumer)}
   */
  @Test
  @DisplayName("Test addTenantProfileListener(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addTenantProfileListener(Consumer)"})
  void testAddTenantProfileListener() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.addTenantProfileListener(mock(Consumer.class)));
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addTenantProfileListener(Consumer)}.
   *
   * <p>Method under test: {@link DefaultTbContext#addTenantProfileListener(Consumer)}
   */
  @Test
  @DisplayName("Test addTenantProfileListener(Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addTenantProfileListener(Consumer)"})
  void testAddTenantProfileListener2() {
    // Arrange
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    when(actorSystemContext.getTenantProfileCache()).thenReturn(defaultTbTenantProfileCache);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.addTenantProfileListener(mock(Consumer.class)));
    verify(actorSystemContext).getTenantProfileCache();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#addTenantProfileListener(Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeCtx#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addTenantProfileListener(Consumer)}
   */
  @Test
  @DisplayName("Test addTenantProfileListener(Consumer); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addTenantProfileListener(Consumer)"})
  void testAddTenantProfileListener_thenCallsGetSelf() {
    // Arrange
    TbTenantProfileCache tbTenantProfileCache = mock(TbTenantProfileCache.class);
    doNothing()
        .when(tbTenantProfileCache)
        .addListener(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<Consumer<TenantProfile>>any());
    when(actorSystemContext.getTenantProfileCache()).thenReturn(tbTenantProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    defaultTbContext.addTenantProfileListener(mock(Consumer.class));

    // Assert
    verify(actorSystemContext).getTenantProfileCache();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
    verify(tbTenantProfileCache).addListener(isA(TenantId.class), isNull(), isA(Consumer.class));
  }

  /**
   * Test {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addDeviceProfileListeners(Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addDeviceProfileListeners(Consumer, BiConsumer)"})
  void testAddDeviceProfileListeners() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.addDeviceProfileListeners(
                mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addDeviceProfileListeners(Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addDeviceProfileListeners(Consumer, BiConsumer)"})
  void testAddDeviceProfileListeners2() {
    // Arrange
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.addDeviceProfileListeners(
                mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getDeviceProfileCache();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeCtx#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addDeviceProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addDeviceProfileListeners(Consumer, BiConsumer); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addDeviceProfileListeners(Consumer, BiConsumer)"})
  void testAddDeviceProfileListeners_thenCallsGetSelf() {
    // Arrange
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode(id));

    // Act
    defaultTbContext.addDeviceProfileListeners(mock(Consumer.class), mock(BiConsumer.class));

    // Assert
    verify(actorSystemContext).getDeviceProfileCache();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addAssetProfileListeners(Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addAssetProfileListeners(Consumer, BiConsumer)"})
  void testAddAssetProfileListeners() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.addAssetProfileListeners(
                mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getAssetProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   *
   * <p>Method under test: {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addAssetProfileListeners(Consumer, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addAssetProfileListeners(Consumer, BiConsumer)"})
  void testAddAssetProfileListeners2() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.addAssetProfileListeners(
                mock(Consumer.class), mock(BiConsumer.class)));
    verify(actorSystemContext).getAssetProfileCache();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeCtx#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#addAssetProfileListeners(Consumer, BiConsumer)}
   */
  @Test
  @DisplayName("Test addAssetProfileListeners(Consumer, BiConsumer); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.addAssetProfileListeners(Consumer, BiConsumer)"})
  void testAddAssetProfileListeners_thenCallsGetSelf() {
    // Arrange
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode(id));

    // Act
    defaultTbContext.addAssetProfileListeners(mock(Consumer.class), mock(BiConsumer.class));

    // Assert
    verify(actorSystemContext).getAssetProfileCache();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners() {
    // Arrange
    when(actorSystemContext.getDeviceProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getDeviceProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners2() {
    // Arrange
    when(actorSystemContext.getAssetProfileCache()).thenThrow(new IllegalArgumentException());
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(ruleNodeCtx).getSelf();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners3() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException());
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(actorSystemContext).getTenantProfileCache();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName(
      "Test removeListeners(); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.removeListeners());
    verify(actorSystemContext).getDeviceProfileCache();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#removeListeners()}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getTenantProfileCache()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#removeListeners()}
   */
  @Test
  @DisplayName("Test removeListeners(); then calls getTenantProfileCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.removeListeners()"})
  void testRemoveListeners_thenCallsGetTenantProfileCache() {
    // Arrange
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    when(actorSystemContext.getTenantProfileCache()).thenReturn(defaultTbTenantProfileCache);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache defaultTbAssetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    when(actorSystemContext.getAssetProfileCache()).thenReturn(defaultTbAssetProfileCache);
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

    DefaultTbDeviceProfileCache defaultTbDeviceProfileCache =
        new DefaultTbDeviceProfileCache(deviceProfileService, deviceService);
    when(actorSystemContext.getDeviceProfileCache()).thenReturn(defaultTbDeviceProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ruleNodeCtx.getSelf()).thenReturn(new RuleNode());

    // Act
    defaultTbContext.removeListeners();

    // Assert
    verify(actorSystemContext).getAssetProfileCache();
    verify(actorSystemContext).getDeviceProfileCache();
    verify(actorSystemContext).getTenantProfileCache();
    verify(ruleNodeCtx, atLeast(1)).getSelf();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#getTenantProfile()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantProfile()}
   */
  @Test
  @DisplayName("Test getTenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbContext.getTenantProfile()"})
  void testGetTenantProfile() {
    // Arrange
    when(actorSystemContext.getTenantProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantProfile());
    verify(actorSystemContext).getTenantProfileCache();
  }

  /**
   * Test {@link DefaultTbContext#getTenantProfile()}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantProfile()}
   */
  @Test
  @DisplayName(
      "Test getTenantProfile(); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbContext.getTenantProfile()"})
  void testGetTenantProfile_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException() {
    // Arrange
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    when(actorSystemContext.getTenantProfileCache()).thenReturn(defaultTbTenantProfileCache);
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getTenantProfile());
    verify(actorSystemContext).getTenantProfileCache();
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#getTenantProfile()}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#findTenantById(TenantId)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getTenantProfile()}
   */
  @Test
  @DisplayName(
      "Test getTenantProfile(); given TenantService findTenantById(TenantId) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantProfile DefaultTbContext.getTenantProfile()"})
  void testGetTenantProfile_givenTenantServiceFindTenantByIdReturnNull_thenReturnNull() {
    // Arrange
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTbTenantProfileCache defaultTbTenantProfileCache =
        new DefaultTbTenantProfileCache(new TenantProfileServiceImpl(), tenantService);
    when(actorSystemContext.getTenantProfileCache()).thenReturn(defaultTbTenantProfileCache);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TenantProfile actualTenantProfile = defaultTbContext.getTenantProfile();

    // Assert
    verify(actorSystemContext).getTenantProfileCache();
    verify(ruleNodeCtx).getTenantId();
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertNull(actualTenantProfile);
  }

  /**
   * Test {@link DefaultTbContext#getWidgetBundleService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getWidgetBundleService()}
   */
  @Test
  @DisplayName("Test getWidgetBundleService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundleService DefaultTbContext.getWidgetBundleService()"})
  void testGetWidgetBundleService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getWidgetBundleService());
  }

  /**
   * Test {@link DefaultTbContext#getWidgetBundleService()}.
   *
   * <ul>
   *   <li>Then return {@link WidgetsBundleServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getWidgetBundleService()}
   */
  @Test
  @DisplayName("Test getWidgetBundleService(); then return WidgetsBundleServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundleService DefaultTbContext.getWidgetBundleService()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getWidgetBundleService()}
   */
  @Test
  @DisplayName("Test getWidgetBundleService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetsBundleService DefaultTbContext.getWidgetBundleService()"})
  void testGetWidgetBundleService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getWidgetsBundleService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getWidgetBundleService());
    verify(actorSystemContext).getWidgetsBundleService();
  }

  /**
   * Test {@link DefaultTbContext#getWidgetTypeService()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getWidgetTypeService()}
   */
  @Test
  @DisplayName("Test getWidgetTypeService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeService DefaultTbContext.getWidgetTypeService()"})
  void testGetWidgetTypeService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getWidgetTypeService());
  }

  /**
   * Test {@link DefaultTbContext#getWidgetTypeService()}.
   *
   * <ul>
   *   <li>Then return {@link WidgetTypeServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getWidgetTypeService()}
   */
  @Test
  @DisplayName("Test getWidgetTypeService(); then return WidgetTypeServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeService DefaultTbContext.getWidgetTypeService()"})
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getWidgetTypeService()}
   */
  @Test
  @DisplayName("Test getWidgetTypeService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"WidgetTypeService DefaultTbContext.getWidgetTypeService()"})
  void testGetWidgetTypeService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getWidgetTypeService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getWidgetTypeService());
    verify(actorSystemContext).getWidgetTypeService();
  }

  /**
   * Test {@link DefaultTbContext#getRuleEngineApiUsageStateService()}.
   *
   * <p>Method under test: {@link DefaultTbContext#getRuleEngineApiUsageStateService()}
   */
  @Test
  @DisplayName("Test getRuleEngineApiUsageStateService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleEngineApiUsageStateService DefaultTbContext.getRuleEngineApiUsageStateService()"
  })
  void testGetRuleEngineApiUsageStateService() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act
    RuleEngineApiUsageStateService actualRuleEngineApiUsageStateService =
        defaultTbContext.getRuleEngineApiUsageStateService();

    // Assert
    assertEquals("Rule Chain Name", defaultTbContext.getRuleChainName());
    assertNull(defaultTbContext.getDeviceStateNodeRateLimitConfig());
    assertNull(defaultTbContext.getDbCallbackExecutor());
    assertNull(defaultTbContext.getExternalCallExecutor());
    assertNull(defaultTbContext.getMailExecutor());
    assertNull(defaultTbContext.getNotificationExecutor());
    assertNull(defaultTbContext.getSmsExecutor());
    assertNull(defaultTbContext.getNotificationCenter());
    assertNull(defaultTbContext.getAlarmService());
    assertNull(actualRuleEngineApiUsageStateService);
    assertNull(defaultTbContext.getAssetProfileCache());
    assertNull(defaultTbContext.getDeviceProfileCache());
    assertNull(defaultTbContext.getDeviceStateManager());
    assertNull(defaultTbContext.getRpcService());
    assertNull(defaultTbContext.getTelemetryService());
    assertNull(defaultTbContext.getSlackService());
    assertNull(defaultTbContext.getSmsSenderFactory());
    assertNull(defaultTbContext.getClusterService());
    assertNull(defaultTbContext.getAlarmCommentService());
    assertNull(defaultTbContext.getAssetProfileService());
    assertNull(defaultTbContext.getAssetService());
    assertNull(defaultTbContext.getAttributesService());
    assertNull(defaultTbContext.getAuditLogService());
    assertNull(defaultTbContext.getCassandraCluster());
    assertNull(defaultTbContext.getCustomerService());
    assertNull(defaultTbContext.getDashboardService());
    assertNull(defaultTbContext.getDeviceCredentialsService());
    assertNull(defaultTbContext.getDeviceProfileService());
    assertNull(defaultTbContext.getDeviceService());
    assertNull(defaultTbContext.getDomainService());
    assertNull(defaultTbContext.getEdgeEventService());
    assertNull(defaultTbContext.getEdgeService());
    assertNull(defaultTbContext.getEntityService());
    assertNull(defaultTbContext.getEntityViewService());
    assertNull(defaultTbContext.getEventService());
    assertNull(defaultTbContext.getMobileAppService());
    assertNull(defaultTbContext.getNotificationRequestService());
    assertNull(defaultTbContext.getNotificationRuleService());
    assertNull(defaultTbContext.getNotificationTargetService());
    assertNull(defaultTbContext.getNotificationTemplateService());
    assertNull(defaultTbContext.getOAuth2ClientService());
    assertNull(defaultTbContext.getOtaPackageService());
    assertNull(defaultTbContext.getQueueService());
    assertNull(defaultTbContext.getQueueStatsService());
    assertNull(defaultTbContext.getRelationService());
    assertNull(defaultTbContext.getResourceService());
    assertNull(defaultTbContext.getRuleChainService());
    assertNull(defaultTbContext.getTenantService());
    assertNull(defaultTbContext.getTimeseriesService());
    assertNull(defaultTbContext.getUserService());
    assertNull(defaultTbContext.getWidgetTypeService());
    assertNull(defaultTbContext.getWidgetBundleService());
    assertNull(defaultTbContext.getPubSubRuleNodeExecutorProvider());
    assertFalse(defaultTbContext.isExternalNodeForceAck());
  }

  /**
   * Test {@link DefaultTbContext#getRuleEngineApiUsageStateService()}.
   *
   * <ul>
   *   <li>Then return {@link DefaultTbApiUsageStateService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRuleEngineApiUsageStateService()}
   */
  @Test
  @DisplayName(
      "Test getRuleEngineApiUsageStateService(); then return DefaultTbApiUsageStateService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleEngineApiUsageStateService DefaultTbContext.getRuleEngineApiUsageStateService()"
  })
  void testGetRuleEngineApiUsageStateService_thenReturnDefaultTbApiUsageStateService() {
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
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    JpaApiUsageStateDao apiUsageStateDao =
        new JpaApiUsageStateDao(mock(ApiUsageStateRepository.class));
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService2,
            tsService2,
            new ApiUsageDataValidator());
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider4,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService,
            tsService,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);

    // Act
    RuleEngineApiUsageStateService actualRuleEngineApiUsageStateService =
        defaultTbContext.getRuleEngineApiUsageStateService();

    // Assert
    verify(actorSystemContext).getApiUsageStateService();
    assertTrue(actualRuleEngineApiUsageStateService instanceof DefaultTbApiUsageStateService);
    assertSame(defaultTbApiUsageStateService, actualRuleEngineApiUsageStateService);
  }

  /**
   * Test {@link DefaultTbContext#getRuleEngineApiUsageStateService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getRuleEngineApiUsageStateService()}
   */
  @Test
  @DisplayName("Test getRuleEngineApiUsageStateService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleEngineApiUsageStateService DefaultTbContext.getRuleEngineApiUsageStateService()"
  })
  void testGetRuleEngineApiUsageStateService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getApiUsageStateService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.getRuleEngineApiUsageStateService());
    verify(actorSystemContext).getApiUsageStateService();
  }

  /**
   * Test {@link DefaultTbContext#getEntityService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseEntityService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEntityService()}
   */
  @Test
  @DisplayName("Test getEntityService(); then return BaseEntityService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityService DefaultTbContext.getEntityService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEntityService()}
   */
  @Test
  @DisplayName("Test getEntityService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityService DefaultTbContext.getEntityService()"})
  void testGetEntityService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getEntityService());
  }

  /**
   * Test {@link DefaultTbContext#getEntityService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEntityService()}
   */
  @Test
  @DisplayName("Test getEntityService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityService DefaultTbContext.getEntityService()"})
  void testGetEntityService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEntityService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEntityService());
    verify(actorSystemContext).getEntityService();
  }

  /**
   * Test {@link DefaultTbContext#getEventService()}.
   *
   * <ul>
   *   <li>Then return {@link BaseEventService}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEventService()}
   */
  @Test
  @DisplayName("Test getEventService(); then return BaseEventService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventService DefaultTbContext.getEventService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEventService()}
   */
  @Test
  @DisplayName("Test getEventService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventService DefaultTbContext.getEventService()"})
  void testGetEventService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getEventService());
  }

  /**
   * Test {@link DefaultTbContext#getEventService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getEventService()}
   */
  @Test
  @DisplayName("Test getEventService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventService DefaultTbContext.getEventService()"})
  void testGetEventService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getEventService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getEventService());
    verify(actorSystemContext).getEventService();
  }

  /**
   * Test {@link DefaultTbContext#getAuditLogService()}.
   *
   * <ul>
   *   <li>Then return {@link AuditLogServiceImpl}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAuditLogService()}
   */
  @Test
  @DisplayName("Test getAuditLogService(); then return AuditLogServiceImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuditLogService DefaultTbContext.getAuditLogService()"})
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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAuditLogService()}
   */
  @Test
  @DisplayName("Test getAuditLogService(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuditLogService DefaultTbContext.getAuditLogService()"})
  void testGetAuditLogService_thenReturnNull() {
    // Arrange
    DefaultTbContext defaultTbContext =
        new DefaultTbContext(new ActorSystemContext(), "Rule Chain Name", null);

    // Act and Assert
    assertNull(defaultTbContext.getAuditLogService());
  }

  /**
   * Test {@link DefaultTbContext#getAuditLogService()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#getAuditLogService()}
   */
  @Test
  @DisplayName("Test getAuditLogService(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AuditLogService DefaultTbContext.getAuditLogService()"})
  void testGetAuditLogService_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getAuditLogService()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.getAuditLogService());
    verify(actorSystemContext).getAuditLogService();
  }

  /**
   * Test {@link DefaultTbContext#schedule(Runnable, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#getScheduler()} return {@link
   *       DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#schedule(Runnable, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test schedule(Runnable, long, TimeUnit); given ActorSystemContext getScheduler() return DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.schedule(Runnable, long, TimeUnit)"})
  void testSchedule_givenActorSystemContextGetSchedulerReturnDefaultEventLoop() {
    // Arrange
    when(actorSystemContext.getScheduler()).thenReturn(new DefaultEventLoop());

    // Act
    defaultTbContext.schedule(mock(Runnable.class), 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(actorSystemContext).getScheduler();
  }

  /**
   * Test {@link DefaultTbContext#schedule(Runnable, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Given {@link ActorSystemContext} {@link ActorSystemContext#getScheduler()} return {@link
   *       io.netty.channel.DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#schedule(Runnable, long, TimeUnit)}
   */
  @Test
  @DisplayName(
      "Test schedule(Runnable, long, TimeUnit); given ActorSystemContext getScheduler() return DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.schedule(Runnable, long, TimeUnit)"})
  void testSchedule_givenActorSystemContextGetSchedulerReturnDefaultEventLoop2() {
    // Arrange
    when(actorSystemContext.getScheduler()).thenReturn(new io.netty.channel.DefaultEventLoop());

    // Act
    defaultTbContext.schedule(mock(Runnable.class), 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(actorSystemContext).getScheduler();
  }

  /**
   * Test {@link DefaultTbContext#schedule(Runnable, long, TimeUnit)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#schedule(Runnable, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test schedule(Runnable, long, TimeUnit); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.schedule(Runnable, long, TimeUnit)"})
  void testSchedule_thenThrowIllegalArgumentException() {
    // Arrange
    when(actorSystemContext.getScheduler()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultTbContext.schedule(mock(Runnable.class), 1L, TimeUnit.NANOSECONDS));
    verify(actorSystemContext).getScheduler();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName("Test checkTenantEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity() throws TbNodeException {
    // Arrange
    when(actorSystemContext.getApiUsageStateService()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.checkTenantEntity(
                new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getApiUsageStateService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName("Test checkTenantEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity2() throws TbNodeException {
    // Arrange
    when(actorSystemContext.getCustomerService()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> defaultTbContext.checkTenantEntity(entityId));
    verify(actorSystemContext).getCustomerService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateEntity#ApiUsageStateEntity()} EntityId is {@code null}.
   *   <li>Then calls {@link ApiUsageStateRepository#findById(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test checkTenantEntity(EntityId); given ApiUsageStateEntity() EntityId is 'null'; then calls findById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_givenApiUsageStateEntityEntityIdIsNull_thenCallsFindById()
      throws TbNodeException {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Optional<ApiUsageStateEntity> ofResult = Optional.of(apiUsageStateEntity);

    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());
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
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider4,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService2,
            tsService2,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    defaultTbContext.checkTenantEntity(
        new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(apiUsageStateRepository).findById(isA(UUID.class));
    verify(actorSystemContext).getApiUsageStateService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link JpaApiUsageStateDao} {@link JpaApiUsageStateDao#findById(TenantId, UUID)}
   *       return {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test checkTenantEntity(EntityId); given JpaApiUsageStateDao findById(TenantId, UUID) return ApiUsageState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_givenJpaApiUsageStateDaoFindByIdReturnApiUsageState()
      throws TbNodeException {
    // Arrange
    JpaApiUsageStateDao apiUsageStateDao = mock(JpaApiUsageStateDao.class);
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new ApiUsageState());
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());
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
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider4,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService2,
            tsService2,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            defaultTbContext.checkTenantEntity(
                new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getApiUsageStateService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link JpaApiUsageStateDao} {@link JpaApiUsageStateDao#findById(TenantId, UUID)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test checkTenantEntity(EntityId); given JpaApiUsageStateDao findById(TenantId, UUID) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_givenJpaApiUsageStateDaoFindByIdReturnNull() throws TbNodeException {
    // Arrange
    JpaApiUsageStateDao apiUsageStateDao = mock(JpaApiUsageStateDao.class);
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());
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
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider4,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService2,
            tsService2,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            defaultTbContext.checkTenantEntity(
                new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getApiUsageStateService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeCtx} {@link RuleNodeCtx#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test checkTenantEntity(EntityId); given RuleNodeCtx getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_givenRuleNodeCtxGetTenantIdThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    when(ruleNodeCtx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbContext.checkTenantEntity(null));
    verify(ruleNodeCtx).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link EntityId} {@link EntityId#getEntityType()} return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test checkTenantEntity(EntityId); given 'TENANT'; when EntityId getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_givenTenant_whenEntityIdGetEntityTypeReturnTenant()
      throws TbNodeException {
    // Arrange
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    defaultTbContext.checkTenantEntity(entityId);

    // Assert
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerService#findCustomerById(TenantId, CustomerId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName(
      "Test checkTenantEntity(EntityId); then calls findCustomerById(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_thenCallsFindCustomerById() throws TbNodeException {
    // Arrange
    CustomerService customerService = mock(CustomerService.class);
    when(customerService.findCustomerById(Mockito.<TenantId>any(), Mockito.<CustomerId>any()))
        .thenReturn(new Customer());
    when(actorSystemContext.getCustomerService()).thenReturn(customerService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.CUSTOMER);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> defaultTbContext.checkTenantEntity(entityId));
    verify(actorSystemContext).getCustomerService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(customerService).findCustomerById(isA(TenantId.class), isA(CustomerId.class));
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link ActorSystemContext#getAlarmService()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName("Test checkTenantEntity(EntityId); then calls getAlarmService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_thenCallsGetAlarmService() throws TbNodeException {
    // Arrange
    when(actorSystemContext.getAlarmService()).thenThrow(new IllegalArgumentException());
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.checkTenantEntity(
                new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getAlarmService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link DefaultTbContext#checkTenantEntity(EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbContext#checkTenantEntity(EntityId)}
   */
  @Test
  @DisplayName("Test checkTenantEntity(EntityId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTbContext.checkTenantEntity(EntityId)"})
  void testCheckTenantEntity_thenCallsGetTenantId() throws TbNodeException {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getTenantId()).thenThrow(new IllegalArgumentException());

    JpaApiUsageStateDao apiUsageStateDao = mock(JpaApiUsageStateDao.class);
    when(apiUsageStateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(apiUsageState);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService = new BaseTimeseriesService();

    ApiUsageStateServiceImpl apiUsageStateService =
        new ApiUsageStateServiceImpl(
            apiUsageStateDao,
            tenantProfileDao,
            tenantService,
            tsService,
            new ApiUsageDataValidator());
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
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache =
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl());
    AnnotationConfigReactiveWebApplicationContext messages =
        new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
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
            serviceInfoProvider4,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient apiUsageClient =
        new DefaultTbApiUsageReportClient(
            partitionService2,
            serviceInfoProvider3,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));

    DefaultMailService mailService =
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, apiUsageClient);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();

    DefaultTbApiUsageStateService defaultTbApiUsageStateService =
        new DefaultTbApiUsageStateService(
            partitionService,
            tenantService2,
            tsService2,
            apiUsageStateService,
            tenantProfileCache,
            mailService,
            notificationRuleProcessor,
            dbExecutor,
            new MailExecutorService());
    when(actorSystemContext.getApiUsageStateService()).thenReturn(defaultTbApiUsageStateService);
    when(ruleNodeCtx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultTbContext.checkTenantEntity(
                new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(actorSystemContext).getApiUsageStateService();
    verify(ruleNodeCtx, atLeast(1)).getTenantId();
    verify(apiUsageState).getTenantId();
    verify(apiUsageStateDao).findById(isA(TenantId.class), isA(UUID.class));
  }
}
