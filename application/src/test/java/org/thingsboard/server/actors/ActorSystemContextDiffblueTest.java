package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.NotificationCenter;
import org.thingsboard.rule.engine.api.RuleEngineDeviceStateManager;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.rule.engine.api.notification.SlackService;
import org.thingsboard.rule.engine.api.sms.SmsSenderFactory;
import org.thingsboard.script.api.js.JsInvokeService;
import org.thingsboard.script.api.tbel.TbelInvokeService;
import org.thingsboard.server.actors.service.ActorService;
import org.thingsboard.server.actors.service.DefaultActorService;
import org.thingsboard.server.actors.stats.StatsActor;
import org.thingsboard.server.actors.tenant.DebugTbRateLimits;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.dao.alarm.AlarmCommentService;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.audit.AuditLogService;
import org.thingsboard.server.dao.cassandra.CassandraCluster;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.device.ClaimDevicesService;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.edge.EdgeEventService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.event.EventService;
import org.thingsboard.server.dao.mobile.MobileAppService;
import org.thingsboard.server.dao.nosql.CassandraBufferedRateReadExecutor;
import org.thingsboard.server.dao.nosql.CassandraBufferedRateWriteExecutor;
import org.thingsboard.server.dao.notification.NotificationRequestService;
import org.thingsboard.server.dao.notification.NotificationRuleService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTemplateService;
import org.thingsboard.server.dao.oauth2.OAuth2ClientService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.queue.QueueStatsService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.rule.RuleNodeStateService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.DiscoveryService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.service.apiusage.TbApiUsageStateService;
import org.thingsboard.server.service.component.AnnotationComponentDiscoveryService;
import org.thingsboard.server.service.component.ComponentDiscoveryService;
import org.thingsboard.server.service.edge.rpc.EdgeRpcService;
import org.thingsboard.server.service.entitiy.entityview.TbEntityViewService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.executors.ExternalCallExecutorService;
import org.thingsboard.server.service.executors.NotificationExecutorService;
import org.thingsboard.server.service.executors.PubSubRuleNodeExecutorProvider;
import org.thingsboard.server.service.executors.SharedEventLoopGroupService;
import org.thingsboard.server.service.mail.MailExecutorService;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.rpc.TbCoreDeviceRpcService;
import org.thingsboard.server.service.rpc.TbRpcService;
import org.thingsboard.server.service.rpc.TbRuleEngineDeviceRpcService;
import org.thingsboard.server.service.session.DeviceSessionCacheService;
import org.thingsboard.server.service.sms.SmsExecutorService;
import org.thingsboard.server.service.state.DeviceStateService;
import org.thingsboard.server.service.telemetry.AlarmSubscriptionService;
import org.thingsboard.server.service.telemetry.TelemetrySubscriptionService;
import org.thingsboard.server.service.transport.TbCoreToTransportService;

@ContextConfiguration(classes = {ActorSystemContext.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class ActorSystemContextDiffblueTest {
  @Autowired
  private ActorSystemContext actorSystemContext;

  @MockBean
  private AlarmCommentService alarmCommentService;

  @MockBean
  private AlarmSubscriptionService alarmSubscriptionService;

  @MockBean
  private AssetProfileService assetProfileService;

  @MockBean
  private AssetService assetService;

  @MockBean
  private AttributesService attributesService;

  @MockBean
  private AuditLogService auditLogService;

  @MockBean
  private CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor;

  @MockBean
  private CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor;

  @MockBean(name = "CassandraCluster")
  private CassandraCluster cassandraCluster;

  @MockBean
  private ClaimDevicesService claimDevicesService;

  @MockBean
  private ComponentDiscoveryService componentDiscoveryService;

  @MockBean
  private CustomerService customerService;

  @MockBean
  private DashboardService dashboardService;

  @MockBean
  private DbCallbackExecutorService dbCallbackExecutorService;

  @MockBean
  private DeviceCredentialsService deviceCredentialsService;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private DeviceService deviceService;

  @MockBean
  private DeviceSessionCacheService deviceSessionCacheService;

  @MockBean
  private DeviceStateService deviceStateService;

  @MockBean
  private DiscoveryService discoveryService;

  @MockBean
  private DomainService domainService;

  @MockBean
  private EdgeEventService edgeEventService;

  @MockBean
  private EdgeRpcService edgeRpcService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityService entityService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private EventService eventService;

  @MockBean
  private ExternalCallExecutorService externalCallExecutorService;

  @MockBean
  private JsInvokeService jsInvokeService;

  @MockBean
  private JsInvokeStats jsInvokeStats;

  @MockBean
  private MailExecutorService mailExecutorService;

  @MockBean
  private MailService mailService;

  @MockBean
  private MobileAppService mobileAppService;

  @MockBean
  private NotificationCenter notificationCenter;

  @MockBean
  private NotificationExecutorService notificationExecutorService;

  @MockBean
  private NotificationRequestService notificationRequestService;

  @MockBean
  private NotificationRuleProcessor notificationRuleProcessor;

  @MockBean
  private NotificationRuleService notificationRuleService;

  @MockBean
  private NotificationTargetService notificationTargetService;

  @MockBean
  private NotificationTemplateService notificationTemplateService;

  @MockBean
  private OAuth2ClientService oAuth2ClientService;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private PubSubRuleNodeExecutorProvider pubSubRuleNodeExecutorProvider;

  @MockBean
  private QueueService queueService;

  @MockBean
  private QueueStatsService queueStatsService;

  @MockBean
  private RedisTemplate redisTemplate;

  @MockBean
  private RelationService relationService;

  @MockBean
  private ResourceService resourceService;

  @MockBean
  private RuleChainService ruleChainService;

  @MockBean
  private RuleEngineDeviceStateManager ruleEngineDeviceStateManager;

  @MockBean
  private RuleNodeStateService ruleNodeStateService;

  @MockBean
  private SharedEventLoopGroupService sharedEventLoopGroupService;

  @MockBean
  private SlackService slackService;

  @MockBean
  private SmsExecutorService smsExecutorService;

  @MockBean
  private SmsSenderFactory smsSenderFactory;

  @MockBean
  private SmsService smsService;

  @MockBean
  private TbApiUsageReportClient tbApiUsageReportClient;

  @MockBean
  private TbApiUsageStateService tbApiUsageStateService;

  @MockBean
  private TbAssetProfileCache tbAssetProfileCache;

  @MockBean
  private TbClusterService tbClusterService;

  @MockBean
  private TbCoreDeviceRpcService tbCoreDeviceRpcService;

  @MockBean
  private TbCoreToTransportService tbCoreToTransportService;

  @MockBean
  private TbDeviceProfileCache tbDeviceProfileCache;

  @MockBean
  private TbEntityViewService tbEntityViewService;

  @MockBean
  private TbRpcService tbRpcService;

  @MockBean
  private TbRuleEngineDeviceRpcService tbRuleEngineDeviceRpcService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TbelInvokeService tbelInvokeService;

  @MockBean
  private TelemetrySubscriptionService telemetrySubscriptionService;

  @MockBean
  private TenantProfileService tenantProfileService;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private TimeseriesService timeseriesService;

  @MockBean
  private UserService userService;

  @MockBean
  private WidgetTypeService widgetTypeService;

  @MockBean
  private WidgetsBundleService widgetsBundleService;

  /**
   * Test {@link ActorSystemContext#printStats()}.
   * <ul>
   *   <li>Given {@link JsInvokeStats} {@link JsInvokeStats#getFailures()} return
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given JsInvokeStats getFailures() return zero")
  void testPrintStats_givenJsInvokeStatsGetFailuresReturnZero() {
    // Arrange
    when(jsInvokeStats.getFailures()).thenReturn(0);
    when(jsInvokeStats.getRequests()).thenReturn(0);
    when(jsInvokeStats.getResponses()).thenReturn(0);

    // Act
    actorSystemContext.printStats();

    // Assert that nothing has changed
    verify(jsInvokeStats).getFailures();
    verify(jsInvokeStats).getRequests();
    verify(jsInvokeStats).getResponses();
  }

  /**
   * Test {@link ActorSystemContext#printStats()}.
   * <ul>
   *   <li>Given {@link JsInvokeStats} {@link JsInvokeStats#getRequests()} return
   * one.</li>
   *   <li>Then calls {@link JsInvokeStats#reset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given JsInvokeStats getRequests() return one; then calls reset()")
  void testPrintStats_givenJsInvokeStatsGetRequestsReturnOne_thenCallsReset() {
    // Arrange
    doNothing().when(jsInvokeStats).reset();
    when(jsInvokeStats.getFailures()).thenReturn(1);
    when(jsInvokeStats.getRequests()).thenReturn(1);
    when(jsInvokeStats.getResponses()).thenReturn(1);

    // Act
    actorSystemContext.printStats();

    // Assert
    verify(jsInvokeStats).getFailures();
    verify(jsInvokeStats, atLeast(1)).getRequests();
    verify(jsInvokeStats).getResponses();
    verify(jsInvokeStats).reset();
  }

  /**
   * Test {@link ActorSystemContext#printStats()}.
   * <ul>
   *   <li>Given {@link JsInvokeStats} {@link JsInvokeStats#getResponses()} return
   * zero.</li>
   *   <li>Then calls {@link JsInvokeStats#reset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given JsInvokeStats getResponses() return zero; then calls reset()")
  void testPrintStats_givenJsInvokeStatsGetResponsesReturnZero_thenCallsReset() {
    // Arrange
    doNothing().when(jsInvokeStats).reset();
    when(jsInvokeStats.getFailures()).thenReturn(1);
    when(jsInvokeStats.getRequests()).thenReturn(0);
    when(jsInvokeStats.getResponses()).thenReturn(0);

    // Act
    actorSystemContext.printStats();

    // Assert
    verify(jsInvokeStats, atLeast(1)).getFailures();
    verify(jsInvokeStats, atLeast(1)).getRequests();
    verify(jsInvokeStats, atLeast(1)).getResponses();
    verify(jsInvokeStats).reset();
  }

  /**
   * Test {@link ActorSystemContext#printStats()}.
   * <ul>
   *   <li>Given {@link JsInvokeStats} {@link JsInvokeStats#reset()} does
   * nothing.</li>
   *   <li>Then calls {@link JsInvokeStats#reset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given JsInvokeStats reset() does nothing; then calls reset()")
  void testPrintStats_givenJsInvokeStatsResetDoesNothing_thenCallsReset() {
    // Arrange
    doNothing().when(jsInvokeStats).reset();
    when(jsInvokeStats.getFailures()).thenReturn(1);
    when(jsInvokeStats.getRequests()).thenReturn(0);
    when(jsInvokeStats.getResponses()).thenReturn(1);

    // Act
    actorSystemContext.printStats();

    // Assert
    verify(jsInvokeStats).getFailures();
    verify(jsInvokeStats, atLeast(1)).getRequests();
    verify(jsInvokeStats, atLeast(1)).getResponses();
    verify(jsInvokeStats).reset();
  }

  /**
   * Test {@link ActorSystemContext#printStats()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); then throw IllegalArgumentException")
  void testPrintStats_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("Rule Engine JS Invoke Stats: requests [{}] responses [{}] failures [{}]"))
        .when(jsInvokeStats)
        .reset();
    when(jsInvokeStats.getFailures()).thenReturn(1);
    when(jsInvokeStats.getRequests()).thenReturn(1);
    when(jsInvokeStats.getResponses()).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorSystemContext.printStats());
    verify(jsInvokeStats).getFailures();
    verify(jsInvokeStats, atLeast(1)).getRequests();
    verify(jsInvokeStats).getResponses();
    verify(jsInvokeStats).reset();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistError(TenantId, EntityId, String, Exception)}.
   * <ul>
   *   <li>Then calls {@link EventService#saveAsync(Event)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistError(TenantId, EntityId, String, Exception)}
   */
  @Test
  @DisplayName("Test persistError(TenantId, EntityId, String, Exception); then calls saveAsync(Event)")
  void testPersistError_thenCallsSaveAsync() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(eventService.saveAsync(Mockito.<Event>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    actorSystemContext.persistError(tenantId, entityId, "Method", new Exception("foo"));

    // Assert
    verify(eventService).saveAsync(isA(Event.class));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistError(TenantId, EntityId, String, Exception)}.
   * <ul>
   *   <li>Then calls {@link EventService#saveAsync(Event)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistError(TenantId, EntityId, String, Exception)}
   */
  @Test
  @DisplayName("Test persistError(TenantId, EntityId, String, Exception); then calls saveAsync(Event)")
  void testPersistError_thenCallsSaveAsync2() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(eventService.saveAsync(Mockito.<Event>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    actorSystemContext.persistError(null, entityId, "Method", new Exception("foo"));

    // Assert
    verify(eventService).saveAsync(isA(Event.class));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistError(TenantId, EntityId, String, Exception)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistError(TenantId, EntityId, String, Exception)}
   */
  @Test
  @DisplayName("Test persistError(TenantId, EntityId, String, Exception); then throw IllegalArgumentException")
  void testPersistError_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> actorSystemContext.persistError(tenantId, entityId, "Method", new Exception("foo")));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}.
   * <ul>
   *   <li>Then calls {@link EventService#saveAsync(Event)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception); then calls saveAsync(Event)")
  void testPersistLifecycleEvent_thenCallsSaveAsync() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(eventService.saveAsync(Mockito.<Event>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    actorSystemContext.persistLifecycleEvent(tenantId, entityId, ComponentLifecycleEvent.CREATED, new Exception("foo"));

    // Assert
    verify(eventService).saveAsync(isA(Event.class));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}.
   * <ul>
   *   <li>Then calls {@link EventService#saveAsync(Event)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception); then calls saveAsync(Event)")
  void testPersistLifecycleEvent_thenCallsSaveAsync2() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(eventService.saveAsync(Mockito.<Event>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act
    actorSystemContext.persistLifecycleEvent(null, entityId, ComponentLifecycleEvent.CREATED, new Exception("foo"));

    // Assert
    verify(eventService).saveAsync(isA(Event.class));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}.
   * <ul>
   *   <li>Then calls {@link EventService#saveAsync(Event)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception); then calls saveAsync(Event)")
  void testPersistLifecycleEvent_thenCallsSaveAsync3() {
    // Arrange
    SettableFuture<Void> delegate = SettableFuture.create();
    when(eventService.saveAsync(Mockito.<Event>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    actorSystemContext.persistLifecycleEvent(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED,
        null);

    // Assert
    verify(eventService).saveAsync(isA(Event.class));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception)}
   */
  @Test
  @DisplayName("Test persistLifecycleEvent(TenantId, EntityId, ComponentLifecycleEvent, Exception); then throw IllegalArgumentException")
  void testPersistLifecycleEvent_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new IllegalArgumentException("foo"));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = new AlarmId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorSystemContext.persistLifecycleEvent(tenantId, entityId,
        ComponentLifecycleEvent.CREATED, new Exception("foo")));
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#resolve(ServiceType, String, TenantId, EntityId)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}.
   * <p>
   * Method under test:
   * {@link ActorSystemContext#resolve(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId) with 'serviceType', 'queueName', 'tenantId', 'entityId'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityId() {
    // Arrange
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<String>any(), Mockito.<TenantId>any(),
        Mockito.<EntityId>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> actorSystemContext.resolve(ServiceType.TB_CORE, "Queue Name", new TenantId(UUID.randomUUID()), null));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), eq("Queue Name"), isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link ActorSystemContext#resolve(ServiceType, String, TenantId, EntityId)}
   * with {@code serviceType}, {@code queueName}, {@code tenantId},
   * {@code entityId}.
   * <ul>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#resolve(ServiceType, String, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, String, TenantId, EntityId) with 'serviceType', 'queueName', 'tenantId', 'entityId'; then return 'Topic'")
  void testResolveWithServiceTypeQueueNameTenantIdEntityId_thenReturnTopic() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TopicPartitionInfo buildResult = partitionResult.tenantId(tenantId).topic("Topic").build();
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<String>any(), Mockito.<TenantId>any(),
        Mockito.<EntityId>any())).thenReturn(buildResult);

    // Act
    TopicPartitionInfo actualResolveResult = actorSystemContext.resolve(ServiceType.TB_CORE, "Queue Name",
        new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), eq("Queue Name"), isA(TenantId.class), isNull());
    assertEquals("Topic", actualResolveResult.getTopic());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertTrue(actualResolveResult.isMyPartition());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Test {@link ActorSystemContext#resolve(ServiceType, TenantId, EntityId)} with
   * {@code serviceType}, {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then return 'Topic'")
  void testResolveWithServiceTypeTenantIdEntityId_thenReturnTopic() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TopicPartitionInfo buildResult = partitionResult.tenantId(tenantId).topic("Topic").build();
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);

    // Act
    TopicPartitionInfo actualResolveResult = actorSystemContext.resolve(ServiceType.TB_CORE,
        new TenantId(UUID.randomUUID()), null);

    // Assert
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isNull());
    assertEquals("Topic", actualResolveResult.getTopic());
    Optional<Integer> partition = actualResolveResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualResolveResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertTrue(actualResolveResult.isMyPartition());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Test {@link ActorSystemContext#resolve(ServiceType, TenantId, EntityId)} with
   * {@code serviceType}, {@code tenantId}, {@code entityId}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#resolve(ServiceType, TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test resolve(ServiceType, TenantId, EntityId) with 'serviceType', 'tenantId', 'entityId'; then throw IllegalArgumentException")
  void testResolveWithServiceTypeTenantIdEntityId_thenThrowIllegalArgumentException() {
    // Arrange
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> actorSystemContext.resolve(ServiceType.TB_CORE, new TenantId(UUID.randomUUID()), null));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isNull());
  }

  /**
   * Test {@link ActorSystemContext#getServiceId()}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#getServiceId()} return {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId(); given TbServiceInfoProvider getServiceId() return '42'; then return '42'")
  void testGetServiceId_givenTbServiceInfoProviderGetServiceIdReturn42_thenReturn42() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act
    String actualServiceId = actorSystemContext.getServiceId();

    // Assert
    verify(tbServiceInfoProvider).getServiceId();
    assertEquals("42", actualServiceId);
  }

  /**
   * Test {@link ActorSystemContext#getServiceId()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId(); then throw IllegalArgumentException")
  void testGetServiceId_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> actorSystemContext.getServiceId());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugInput(TenantId, EntityId, TbMsg, String, Throwable)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType},
   * {@code error}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugInput(TenantId, EntityId, TbMsg, String, Throwable)}
   */
  @Test
  @DisplayName("Test persistDebugInput(TenantId, EntityId, TbMsg, String, Throwable) with 'tenantId', 'entityId', 'tbMsg', 'relationType', 'error'; then calls getId()")
  void testPersistDebugInputWithTenantIdEntityIdTbMsgRelationTypeError_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugInput(tenantId, entityId, null, "Relation Type", new Throwable());

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugInput(TenantId, EntityId, TbMsg, String, Throwable)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType},
   * {@code error}.
   * <ul>
   *   <li>When {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugInput(TenantId, EntityId, TbMsg, String, Throwable)}
   */
  @Test
  @DisplayName("Test persistDebugInput(TenantId, EntityId, TbMsg, String, Throwable) with 'tenantId', 'entityId', 'tbMsg', 'relationType', 'error'; when ','")
  void testPersistDebugInputWithTenantIdEntityIdTbMsgRelationTypeError_whenComma() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugInput(tenantId, entityId, null, ",", new Throwable());

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugInput(TenantId, EntityId, TbMsg, String)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugInput(TenantId, EntityId, TbMsg, String)}
   */
  @Test
  @DisplayName("Test persistDebugInput(TenantId, EntityId, TbMsg, String) with 'tenantId', 'entityId', 'tbMsg', 'relationType'; then calls getId()")
  void testPersistDebugInputWithTenantIdEntityIdTbMsgRelationType_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugInput(tenantId, entityId, null, "Relation Type");

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType}.
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String)}
   */
  @Test
  @DisplayName("Test persistDebugOutput(TenantId, EntityId, TbMsg, String) with 'tenantId', 'entityId', 'tbMsg', 'relationType'")
  void testPersistDebugOutputWithTenantIdEntityIdTbMsgRelationType() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugOutput(tenantId, entityId, null, "Relation Type");

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType}.
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String)}
   */
  @Test
  @DisplayName("Test persistDebugOutput(TenantId, EntityId, TbMsg, String) with 'tenantId', 'entityId', 'tbMsg', 'relationType'")
  void testPersistDebugOutputWithTenantIdEntityIdTbMsgRelationType2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException(""));

    // Act
    actorSystemContext.persistDebugOutput(tenantId, entityId, null, "Relation Type");

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType},
   * {@code error}.
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)}
   */
  @Test
  @DisplayName("Test persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable) with 'tenantId', 'entityId', 'tbMsg', 'relationType', 'error'")
  void testPersistDebugOutputWithTenantIdEntityIdTbMsgRelationTypeError() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugOutput(tenantId, entityId, null, "Relation Type", new IllegalStateException());

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable, String)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType},
   * {@code error}, {@code failureMessage}.
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable, String)}
   */
  @Test
  @DisplayName("Test persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable, String) with 'tenantId', 'entityId', 'tbMsg', 'relationType', 'error', 'failureMessage'")
  void testPersistDebugOutputWithTenantIdEntityIdTbMsgRelationTypeErrorFailureMessage() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugOutput(tenantId, entityId, null, "Relation Type", new Throwable(),
        "Failure Message");

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable, String)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType},
   * {@code error}, {@code failureMessage}.
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable, String)}
   */
  @Test
  @DisplayName("Test persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable, String) with 'tenantId', 'entityId', 'tbMsg', 'relationType', 'error', 'failureMessage'")
  void testPersistDebugOutputWithTenantIdEntityIdTbMsgRelationTypeErrorFailureMessage2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugOutput(tenantId, entityId, null, "42", new Throwable(), "Failure Message");

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)}
   * with {@code tenantId}, {@code entityId}, {@code tbMsg}, {@code relationType},
   * {@code error}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ActorSystemContext#persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable)}
   */
  @Test
  @DisplayName("Test persistDebugOutput(TenantId, EntityId, TbMsg, String, Throwable) with 'tenantId', 'entityId', 'tbMsg', 'relationType', 'error'; then calls getId()")
  void testPersistDebugOutputWithTenantIdEntityIdTbMsgRelationTypeError_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act
    actorSystemContext.persistDebugOutput(tenantId, entityId, null, "Relation Type", new Throwable());

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test {@link ActorSystemContext#toException(Throwable)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when IOException(String) with 'foo'; then return LocalizedMessage is 'foo'")
  void testToException_whenIOExceptionWithFoo_thenReturnLocalizedMessageIsFoo() {
    // Arrange and Act
    Exception actualToExceptionResult = ActorSystemContext.toException(new IOException("foo"));

    // Assert
    assertEquals("foo", actualToExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualToExceptionResult.getMessage());
    assertNull(actualToExceptionResult.getCause());
    assertEquals(0, actualToExceptionResult.getSuppressed().length);
  }

  /**
   * Test {@link ActorSystemContext#toException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return LocalizedMessage is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#toException(Throwable)}
   */
  @Test
  @DisplayName("Test toException(Throwable); when Throwable(); then return LocalizedMessage is 'java.lang.Throwable'")
  void testToException_whenThrowable_thenReturnLocalizedMessageIsJavaLangThrowable() {
    // Arrange
    Throwable error = new Throwable();

    // Act
    Exception actualToExceptionResult = ActorSystemContext.toException(error);

    // Assert
    assertEquals("java.lang.Throwable", actualToExceptionResult.getLocalizedMessage());
    assertEquals("java.lang.Throwable", actualToExceptionResult.getMessage());
    assertSame(error, actualToExceptionResult.getCause());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActorSystemContext#setActorService(ActorService)}
   *   <li>{@link ActorSystemContext#setActorSystem(TbActorSystem)}
   *   <li>{@link ActorSystemContext#setAppActor(TbActorRef)}
   *   <li>{@link ActorSystemContext#setComponentService(ComponentDiscoveryService)}
   *   <li>{@link ActorSystemContext#setServiceInfoProvider(TbServiceInfoProvider)}
   *   <li>{@link ActorSystemContext#setStatsActor(TbActorRef)}
   *   <li>{@link ActorSystemContext#getActorService()}
   *   <li>{@link ActorSystemContext#getActorSystem()}
   *   <li>{@link ActorSystemContext#getAlarmCommentService()}
   *   <li>{@link ActorSystemContext#getAlarmService()}
   *   <li>{@link ActorSystemContext#getApiUsageClient()}
   *   <li>{@link ActorSystemContext#getApiUsageStateService()}
   *   <li>{@link ActorSystemContext#getAssetProfileCache()}
   *   <li>{@link ActorSystemContext#getAssetProfileService()}
   *   <li>{@link ActorSystemContext#getAssetService()}
   *   <li>{@link ActorSystemContext#getAttributesService()}
   *   <li>{@link ActorSystemContext#getAuditLogService()}
   *   <li>{@link ActorSystemContext#getCacheType()}
   *   <li>{@link ActorSystemContext#getCassandraBufferedRateReadExecutor()}
   *   <li>{@link ActorSystemContext#getCassandraBufferedRateWriteExecutor()}
   *   <li>{@link ActorSystemContext#getCassandraCluster()}
   *   <li>{@link ActorSystemContext#getClaimDevicesService()}
   *   <li>{@link ActorSystemContext#getClusterService()}
   *   <li>{@link ActorSystemContext#getComponentService()}
   *   <li>{@link ActorSystemContext#getCustomerService()}
   *   <li>{@link ActorSystemContext#getDashboardService()}
   *   <li>{@link ActorSystemContext#getDbCallbackExecutor()}
   *   <li>{@link ActorSystemContext#getDebugPerTenantLimits()}
   *   <li>{@link ActorSystemContext#getDebugPerTenantLimitsConfiguration()}
   *   <li>{@link ActorSystemContext#getDeviceCredentialsService()}
   *   <li>{@link ActorSystemContext#getDeviceProfileCache()}
   *   <li>{@link ActorSystemContext#getDeviceProfileService()}
   *   <li>{@link ActorSystemContext#getDeviceService()}
   *   <li>{@link ActorSystemContext#getDeviceSessionCacheService()}
   *   <li>{@link ActorSystemContext#getDeviceStateManager()}
   *   <li>{@link ActorSystemContext#getDeviceStateNodeRateLimitConfig()}
   *   <li>{@link ActorSystemContext#getDeviceStateService()}
   *   <li>{@link ActorSystemContext#getDiscoveryService()}
   *   <li>{@link ActorSystemContext#getDomainService()}
   *   <li>{@link ActorSystemContext#getEdgeEventService()}
   *   <li>{@link ActorSystemContext#getEdgeRpcService()}
   *   <li>{@link ActorSystemContext#getEdgeService()}
   *   <li>{@link ActorSystemContext#getEntityService()}
   *   <li>{@link ActorSystemContext#getEntityViewService()}
   *   <li>{@link ActorSystemContext#getEventService()}
   *   <li>{@link ActorSystemContext#getExternalCallExecutorService()}
   *   <li>{@link ActorSystemContext#getJsInvokeService()}
   *   <li>{@link ActorSystemContext#getJsInvokeStats()}
   *   <li>{@link ActorSystemContext#getMailExecutor()}
   *   <li>{@link ActorSystemContext#getMailService()}
   *   <li>{@link ActorSystemContext#getMaxConcurrentSessionsPerDevice()}
   *   <li>{@link ActorSystemContext#getMaxRpcRetries()}
   *   <li>{@link ActorSystemContext#getMobileAppService()}
   *   <li>{@link ActorSystemContext#getNotificationCenter()}
   *   <li>{@link ActorSystemContext#getNotificationExecutor()}
   *   <li>{@link ActorSystemContext#getNotificationRequestService()}
   *   <li>{@link ActorSystemContext#getNotificationRuleProcessor()}
   *   <li>{@link ActorSystemContext#getNotificationRuleService()}
   *   <li>{@link ActorSystemContext#getNotificationTargetService()}
   *   <li>{@link ActorSystemContext#getNotificationTemplateService()}
   *   <li>{@link ActorSystemContext#getOAuth2ClientService()}
   *   <li>{@link ActorSystemContext#getOtaPackageService()}
   *   <li>{@link ActorSystemContext#getPartitionService()}
   *   <li>{@link ActorSystemContext#getPubSubRuleNodeExecutorProvider()}
   *   <li>{@link ActorSystemContext#getQueueService()}
   *   <li>{@link ActorSystemContext#getQueueStatsService()}
   *   <li>{@link ActorSystemContext#getRedisTemplate()}
   *   <li>{@link ActorSystemContext#getRelationService()}
   *   <li>{@link ActorSystemContext#getResourceService()}
   *   <li>{@link ActorSystemContext#getRpcResponseTimeout()}
   *   <li>{@link ActorSystemContext#getRpcSubmitStrategy()}
   *   <li>{@link ActorSystemContext#getRuleChainErrorPersistFrequency()}
   *   <li>{@link ActorSystemContext#getRuleChainService()}
   *   <li>{@link ActorSystemContext#getRuleNodeErrorPersistFrequency()}
   *   <li>{@link ActorSystemContext#getRuleNodeStateService()}
   *   <li>{@link ActorSystemContext#getServiceInfoProvider()}
   *   <li>{@link ActorSystemContext#getSessionInactivityTimeout()}
   *   <li>{@link ActorSystemContext#getSessionReportTimeout()}
   *   <li>{@link ActorSystemContext#getSharedEventLoopGroupService()}
   *   <li>{@link ActorSystemContext#getSlackService()}
   *   <li>{@link ActorSystemContext#getSmsExecutor()}
   *   <li>{@link ActorSystemContext#getSmsSenderFactory()}
   *   <li>{@link ActorSystemContext#getSmsService()}
   *   <li>{@link ActorSystemContext#getStatisticsPersistFrequency()}
   *   <li>{@link ActorSystemContext#getStatsActor()}
   *   <li>{@link ActorSystemContext#getSyncSessionTimeout()}
   *   <li>{@link ActorSystemContext#getTbCoreDeviceRpcService()}
   *   <li>{@link ActorSystemContext#getTbCoreToTransportService()}
   *   <li>{@link ActorSystemContext#getTbEntityViewService()}
   *   <li>{@link ActorSystemContext#getTbRpcService()}
   *   <li>{@link ActorSystemContext#getTbRuleEngineDeviceRpcService()}
   *   <li>{@link ActorSystemContext#getTbelInvokeService()}
   *   <li>{@link ActorSystemContext#getTenantProfileCache()}
   *   <li>{@link ActorSystemContext#getTenantProfileService()}
   *   <li>{@link ActorSystemContext#getTenantService()}
   *   <li>{@link ActorSystemContext#getTsService()}
   *   <li>{@link ActorSystemContext#getTsSubService()}
   *   <li>{@link ActorSystemContext#getUserService()}
   *   <li>{@link ActorSystemContext#getWidgetTypeService()}
   *   <li>{@link ActorSystemContext#getWidgetsBundleService()}
   *   <li>{@link ActorSystemContext#isAllowSystemMailService()}
   *   <li>{@link ActorSystemContext#isAllowSystemSmsService()}
   *   <li>{@link ActorSystemContext#isDebugPerTenantEnabled()}
   *   <li>{@link ActorSystemContext#isEdgesEnabled()}
   *   <li>{@link ActorSystemContext#isExternalNodeForceAck()}
   *   <li>{@link ActorSystemContext#isLocalCacheType()}
   *   <li>{@link ActorSystemContext#isStatisticsEnabled()}
   *   <li>{@link ActorSystemContext#isTenantComponentsInitEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ActorSystemContext actorSystemContext = new ActorSystemContext();
    DefaultActorService actorService = new DefaultActorService();

    // Act
    actorSystemContext.setActorService(actorService);
    DefaultTbActorSystem actorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    actorSystemContext.setActorSystem(actorSystem);
    DefaultTbActorSystem system = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId = mock(TbActorId.class);
    StatsActor actor = new StatsActor(new ActorSystemContext());
    actorSystemContext.setAppActor(
        new TbActorMailbox(system, settings, selfId, null, actor, new Dispatcher("42", new DefaultEventLoop())));
    AnnotationComponentDiscoveryService componentService = new AnnotationComponentDiscoveryService();
    actorSystemContext.setComponentService(componentService);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    actorSystemContext.setServiceInfoProvider(serviceInfoProvider);
    DefaultTbActorSystem system2 = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    TbActorSystemSettings settings2 = new TbActorSystemSettings(1, 3, 3);

    TbActorId selfId2 = mock(TbActorId.class);
    StatsActor actor2 = new StatsActor(new ActorSystemContext());
    TbActorMailbox statsActor = new TbActorMailbox(system2, settings2, selfId2, null, actor2,
        new Dispatcher("42", new DefaultEventLoop()));

    actorSystemContext.setStatsActor(statsActor);
    ActorService actualActorService = actorSystemContext.getActorService();
    TbActorSystem actualActorSystem = actorSystemContext.getActorSystem();
    actorSystemContext.getAlarmCommentService();
    actorSystemContext.getAlarmService();
    actorSystemContext.getApiUsageClient();
    actorSystemContext.getApiUsageStateService();
    actorSystemContext.getAssetProfileCache();
    actorSystemContext.getAssetProfileService();
    actorSystemContext.getAssetService();
    actorSystemContext.getAttributesService();
    actorSystemContext.getAuditLogService();
    actorSystemContext.getCacheType();
    actorSystemContext.getCassandraBufferedRateReadExecutor();
    actorSystemContext.getCassandraBufferedRateWriteExecutor();
    actorSystemContext.getCassandraCluster();
    actorSystemContext.getClaimDevicesService();
    actorSystemContext.getClusterService();
    ComponentDiscoveryService actualComponentService = actorSystemContext.getComponentService();
    actorSystemContext.getCustomerService();
    actorSystemContext.getDashboardService();
    actorSystemContext.getDbCallbackExecutor();
    ConcurrentMap<TenantId, DebugTbRateLimits> actualDebugPerTenantLimits = actorSystemContext
        .getDebugPerTenantLimits();
    actorSystemContext.getDebugPerTenantLimitsConfiguration();
    actorSystemContext.getDeviceCredentialsService();
    actorSystemContext.getDeviceProfileCache();
    actorSystemContext.getDeviceProfileService();
    actorSystemContext.getDeviceService();
    actorSystemContext.getDeviceSessionCacheService();
    actorSystemContext.getDeviceStateManager();
    actorSystemContext.getDeviceStateNodeRateLimitConfig();
    actorSystemContext.getDeviceStateService();
    actorSystemContext.getDiscoveryService();
    actorSystemContext.getDomainService();
    actorSystemContext.getEdgeEventService();
    actorSystemContext.getEdgeRpcService();
    actorSystemContext.getEdgeService();
    actorSystemContext.getEntityService();
    actorSystemContext.getEntityViewService();
    actorSystemContext.getEventService();
    actorSystemContext.getExternalCallExecutorService();
    actorSystemContext.getJsInvokeService();
    actorSystemContext.getJsInvokeStats();
    actorSystemContext.getMailExecutor();
    actorSystemContext.getMailService();
    long actualMaxConcurrentSessionsPerDevice = actorSystemContext.getMaxConcurrentSessionsPerDevice();
    int actualMaxRpcRetries = actorSystemContext.getMaxRpcRetries();
    actorSystemContext.getMobileAppService();
    actorSystemContext.getNotificationCenter();
    actorSystemContext.getNotificationExecutor();
    actorSystemContext.getNotificationRequestService();
    actorSystemContext.getNotificationRuleProcessor();
    actorSystemContext.getNotificationRuleService();
    actorSystemContext.getNotificationTargetService();
    actorSystemContext.getNotificationTemplateService();
    actorSystemContext.getOAuth2ClientService();
    actorSystemContext.getOtaPackageService();
    actorSystemContext.getPartitionService();
    actorSystemContext.getPubSubRuleNodeExecutorProvider();
    actorSystemContext.getQueueService();
    actorSystemContext.getQueueStatsService();
    actorSystemContext.getRedisTemplate();
    actorSystemContext.getRelationService();
    actorSystemContext.getResourceService();
    long actualRpcResponseTimeout = actorSystemContext.getRpcResponseTimeout();
    actorSystemContext.getRpcSubmitStrategy();
    long actualRuleChainErrorPersistFrequency = actorSystemContext.getRuleChainErrorPersistFrequency();
    actorSystemContext.getRuleChainService();
    long actualRuleNodeErrorPersistFrequency = actorSystemContext.getRuleNodeErrorPersistFrequency();
    actorSystemContext.getRuleNodeStateService();
    TbServiceInfoProvider actualServiceInfoProvider = actorSystemContext.getServiceInfoProvider();
    long actualSessionInactivityTimeout = actorSystemContext.getSessionInactivityTimeout();
    long actualSessionReportTimeout = actorSystemContext.getSessionReportTimeout();
    actorSystemContext.getSharedEventLoopGroupService();
    actorSystemContext.getSlackService();
    actorSystemContext.getSmsExecutor();
    actorSystemContext.getSmsSenderFactory();
    actorSystemContext.getSmsService();
    long actualStatisticsPersistFrequency = actorSystemContext.getStatisticsPersistFrequency();
    TbActorRef actualStatsActor = actorSystemContext.getStatsActor();
    long actualSyncSessionTimeout = actorSystemContext.getSyncSessionTimeout();
    actorSystemContext.getTbCoreDeviceRpcService();
    actorSystemContext.getTbCoreToTransportService();
    actorSystemContext.getTbEntityViewService();
    actorSystemContext.getTbRpcService();
    actorSystemContext.getTbRuleEngineDeviceRpcService();
    actorSystemContext.getTbelInvokeService();
    actorSystemContext.getTenantProfileCache();
    actorSystemContext.getTenantProfileService();
    actorSystemContext.getTenantService();
    actorSystemContext.getTsService();
    actorSystemContext.getTsSubService();
    actorSystemContext.getUserService();
    actorSystemContext.getWidgetTypeService();
    actorSystemContext.getWidgetsBundleService();
    boolean actualIsAllowSystemMailServiceResult = actorSystemContext.isAllowSystemMailService();
    boolean actualIsAllowSystemSmsServiceResult = actorSystemContext.isAllowSystemSmsService();
    boolean actualIsDebugPerTenantEnabledResult = actorSystemContext.isDebugPerTenantEnabled();
    boolean actualIsEdgesEnabledResult = actorSystemContext.isEdgesEnabled();
    boolean actualIsExternalNodeForceAckResult = actorSystemContext.isExternalNodeForceAck();
    boolean actualIsLocalCacheTypeResult = actorSystemContext.isLocalCacheType();
    boolean actualIsStatisticsEnabledResult = actorSystemContext.isStatisticsEnabled();

    // Assert that nothing has changed
    assertTrue(actualActorService instanceof DefaultActorService);
    assertTrue(actualComponentService instanceof AnnotationComponentDiscoveryService);
    assertEquals(0, actualMaxRpcRetries);
    assertEquals(0L, actualMaxConcurrentSessionsPerDevice);
    assertEquals(0L, actualRpcResponseTimeout);
    assertEquals(0L, actualRuleChainErrorPersistFrequency);
    assertEquals(0L, actualRuleNodeErrorPersistFrequency);
    assertEquals(0L, actualSessionInactivityTimeout);
    assertEquals(0L, actualSessionReportTimeout);
    assertEquals(0L, actualStatisticsPersistFrequency);
    assertEquals(0L, actualSyncSessionTimeout);
    assertFalse(actualIsAllowSystemMailServiceResult);
    assertFalse(actualIsAllowSystemSmsServiceResult);
    assertFalse(actualIsDebugPerTenantEnabledResult);
    assertFalse(actualIsEdgesEnabledResult);
    assertFalse(actualIsExternalNodeForceAckResult);
    assertFalse(actualIsLocalCacheTypeResult);
    assertFalse(actualIsStatisticsEnabledResult);
    assertFalse(actorSystemContext.isTenantComponentsInitEnabled());
    assertTrue(actualDebugPerTenantLimits.isEmpty());
    assertSame(actorSystem, actualActorSystem);
    assertSame(statsActor, actualStatsActor);
    assertSame(actorService, actualActorService);
    assertSame(serviceInfoProvider, actualServiceInfoProvider);
    assertSame(componentService, actualComponentService);
  }
}
