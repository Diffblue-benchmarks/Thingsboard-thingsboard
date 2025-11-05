package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;
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
import org.thingsboard.server.actors.tenant.DebugTbRateLimits;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
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

class ActorSystemContextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ActorSystemContext#setActorService(ActorService)}
   *   <li>{@link ActorSystemContext#setActorSystem(TbActorSystem)}
   *   <li>{@link ActorSystemContext#setComponentService(ComponentDiscoveryService)}
   *   <li>{@link ActorSystemContext#setServiceInfoProvider(TbServiceInfoProvider)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ActorService ActorSystemContext.getActorService()",
    "TbActorSystem ActorSystemContext.getActorSystem()",
    "AlarmCommentService ActorSystemContext.getAlarmCommentService()",
    "AlarmSubscriptionService ActorSystemContext.getAlarmService()",
    "TbApiUsageReportClient ActorSystemContext.getApiUsageClient()",
    "TbApiUsageStateService ActorSystemContext.getApiUsageStateService()",
    "TbAssetProfileCache ActorSystemContext.getAssetProfileCache()",
    "AssetProfileService ActorSystemContext.getAssetProfileService()",
    "AssetService ActorSystemContext.getAssetService()",
    "AttributesService ActorSystemContext.getAttributesService()",
    "AuditLogService ActorSystemContext.getAuditLogService()",
    "String ActorSystemContext.getCacheType()",
    "CassandraBufferedRateReadExecutor ActorSystemContext.getCassandraBufferedRateReadExecutor()",
    "CassandraBufferedRateWriteExecutor ActorSystemContext.getCassandraBufferedRateWriteExecutor()",
    "CassandraCluster ActorSystemContext.getCassandraCluster()",
    "ClaimDevicesService ActorSystemContext.getClaimDevicesService()",
    "TbClusterService ActorSystemContext.getClusterService()",
    "ComponentDiscoveryService ActorSystemContext.getComponentService()",
    "CustomerService ActorSystemContext.getCustomerService()",
    "DashboardService ActorSystemContext.getDashboardService()",
    "DbCallbackExecutorService ActorSystemContext.getDbCallbackExecutor()",
    "ConcurrentMap ActorSystemContext.getDebugPerTenantLimits()",
    "String ActorSystemContext.getDebugPerTenantLimitsConfiguration()",
    "DeviceCredentialsService ActorSystemContext.getDeviceCredentialsService()",
    "TbDeviceProfileCache ActorSystemContext.getDeviceProfileCache()",
    "DeviceProfileService ActorSystemContext.getDeviceProfileService()",
    "DeviceService ActorSystemContext.getDeviceService()",
    "DeviceSessionCacheService ActorSystemContext.getDeviceSessionCacheService()",
    "RuleEngineDeviceStateManager ActorSystemContext.getDeviceStateManager()",
    "String ActorSystemContext.getDeviceStateNodeRateLimitConfig()",
    "DeviceStateService ActorSystemContext.getDeviceStateService()",
    "DiscoveryService ActorSystemContext.getDiscoveryService()",
    "DomainService ActorSystemContext.getDomainService()",
    "EdgeEventService ActorSystemContext.getEdgeEventService()",
    "EdgeRpcService ActorSystemContext.getEdgeRpcService()",
    "EdgeService ActorSystemContext.getEdgeService()",
    "EntityService ActorSystemContext.getEntityService()",
    "EntityViewService ActorSystemContext.getEntityViewService()",
    "EventService ActorSystemContext.getEventService()",
    "ExternalCallExecutorService ActorSystemContext.getExternalCallExecutorService()",
    "JsInvokeService ActorSystemContext.getJsInvokeService()",
    "JsInvokeStats ActorSystemContext.getJsInvokeStats()",
    "MailExecutorService ActorSystemContext.getMailExecutor()",
    "MailService ActorSystemContext.getMailService()",
    "long ActorSystemContext.getMaxConcurrentSessionsPerDevice()",
    "int ActorSystemContext.getMaxRpcRetries()",
    "MobileAppService ActorSystemContext.getMobileAppService()",
    "NotificationCenter ActorSystemContext.getNotificationCenter()",
    "NotificationExecutorService ActorSystemContext.getNotificationExecutor()",
    "NotificationRequestService ActorSystemContext.getNotificationRequestService()",
    "NotificationRuleProcessor ActorSystemContext.getNotificationRuleProcessor()",
    "NotificationRuleService ActorSystemContext.getNotificationRuleService()",
    "NotificationTargetService ActorSystemContext.getNotificationTargetService()",
    "NotificationTemplateService ActorSystemContext.getNotificationTemplateService()",
    "OAuth2ClientService ActorSystemContext.getOAuth2ClientService()",
    "OtaPackageService ActorSystemContext.getOtaPackageService()",
    "PartitionService ActorSystemContext.getPartitionService()",
    "PubSubRuleNodeExecutorProvider ActorSystemContext.getPubSubRuleNodeExecutorProvider()",
    "QueueService ActorSystemContext.getQueueService()",
    "QueueStatsService ActorSystemContext.getQueueStatsService()",
    "RedisTemplate ActorSystemContext.getRedisTemplate()",
    "RelationService ActorSystemContext.getRelationService()",
    "ResourceService ActorSystemContext.getResourceService()",
    "long ActorSystemContext.getRpcResponseTimeout()",
    "String ActorSystemContext.getRpcSubmitStrategy()",
    "long ActorSystemContext.getRuleChainErrorPersistFrequency()",
    "RuleChainService ActorSystemContext.getRuleChainService()",
    "long ActorSystemContext.getRuleNodeErrorPersistFrequency()",
    "RuleNodeStateService ActorSystemContext.getRuleNodeStateService()",
    "TbServiceInfoProvider ActorSystemContext.getServiceInfoProvider()",
    "long ActorSystemContext.getSessionInactivityTimeout()",
    "long ActorSystemContext.getSessionReportTimeout()",
    "SharedEventLoopGroupService ActorSystemContext.getSharedEventLoopGroupService()",
    "SlackService ActorSystemContext.getSlackService()",
    "SmsExecutorService ActorSystemContext.getSmsExecutor()",
    "SmsSenderFactory ActorSystemContext.getSmsSenderFactory()",
    "SmsService ActorSystemContext.getSmsService()",
    "long ActorSystemContext.getStatisticsPersistFrequency()",
    "TbActorRef ActorSystemContext.getStatsActor()",
    "long ActorSystemContext.getSyncSessionTimeout()",
    "TbCoreDeviceRpcService ActorSystemContext.getTbCoreDeviceRpcService()",
    "TbCoreToTransportService ActorSystemContext.getTbCoreToTransportService()",
    "TbEntityViewService ActorSystemContext.getTbEntityViewService()",
    "TbRpcService ActorSystemContext.getTbRpcService()",
    "TbRuleEngineDeviceRpcService ActorSystemContext.getTbRuleEngineDeviceRpcService()",
    "TbelInvokeService ActorSystemContext.getTbelInvokeService()",
    "TbTenantProfileCache ActorSystemContext.getTenantProfileCache()",
    "TenantProfileService ActorSystemContext.getTenantProfileService()",
    "TenantService ActorSystemContext.getTenantService()",
    "TimeseriesService ActorSystemContext.getTsService()",
    "TelemetrySubscriptionService ActorSystemContext.getTsSubService()",
    "UserService ActorSystemContext.getUserService()",
    "WidgetTypeService ActorSystemContext.getWidgetTypeService()",
    "WidgetsBundleService ActorSystemContext.getWidgetsBundleService()",
    "boolean ActorSystemContext.isAllowSystemMailService()",
    "boolean ActorSystemContext.isAllowSystemSmsService()",
    "boolean ActorSystemContext.isDebugPerTenantEnabled()",
    "boolean ActorSystemContext.isEdgesEnabled()",
    "boolean ActorSystemContext.isExternalNodeForceAck()",
    "boolean ActorSystemContext.isLocalCacheType()",
    "boolean ActorSystemContext.isStatisticsEnabled()",
    "boolean ActorSystemContext.isTenantComponentsInitEnabled()",
    "void ActorSystemContext.setActorService(ActorService)",
    "void ActorSystemContext.setActorSystem(TbActorSystem)",
    "void ActorSystemContext.setAppActor(TbActorRef)",
    "void ActorSystemContext.setComponentService(ComponentDiscoveryService)",
    "void ActorSystemContext.setServiceInfoProvider(TbServiceInfoProvider)",
    "void ActorSystemContext.setStatsActor(TbActorRef)"
  })
  void testGettersAndSetters() {
    // Arrange
    ActorSystemContext actorSystemContext = new ActorSystemContext();
    DefaultActorService actorService = new DefaultActorService();

    // Act
    actorSystemContext.setActorService(actorService);
    DefaultTbActorSystem actorSystem = new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3));
    actorSystemContext.setActorSystem(actorSystem);
    AnnotationComponentDiscoveryService componentService =
        new AnnotationComponentDiscoveryService();
    actorSystemContext.setComponentService(componentService);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    actorSystemContext.setServiceInfoProvider(serviceInfoProvider);
    ActorService actualActorService = actorSystemContext.getActorService();
    TbActorSystem actualActorSystem = actorSystemContext.getActorSystem();
    AlarmCommentService actualAlarmCommentService = actorSystemContext.getAlarmCommentService();
    AlarmSubscriptionService actualAlarmService = actorSystemContext.getAlarmService();
    TbApiUsageReportClient actualApiUsageClient = actorSystemContext.getApiUsageClient();
    TbApiUsageStateService actualApiUsageStateService =
        actorSystemContext.getApiUsageStateService();
    TbAssetProfileCache actualAssetProfileCache = actorSystemContext.getAssetProfileCache();
    AssetProfileService actualAssetProfileService = actorSystemContext.getAssetProfileService();
    AssetService actualAssetService = actorSystemContext.getAssetService();
    AttributesService actualAttributesService = actorSystemContext.getAttributesService();
    AuditLogService actualAuditLogService = actorSystemContext.getAuditLogService();
    String actualCacheType = actorSystemContext.getCacheType();
    CassandraBufferedRateReadExecutor actualCassandraBufferedRateReadExecutor =
        actorSystemContext.getCassandraBufferedRateReadExecutor();
    CassandraBufferedRateWriteExecutor actualCassandraBufferedRateWriteExecutor =
        actorSystemContext.getCassandraBufferedRateWriteExecutor();
    CassandraCluster actualCassandraCluster = actorSystemContext.getCassandraCluster();
    ClaimDevicesService actualClaimDevicesService = actorSystemContext.getClaimDevicesService();
    TbClusterService actualClusterService = actorSystemContext.getClusterService();
    ComponentDiscoveryService actualComponentService = actorSystemContext.getComponentService();
    CustomerService actualCustomerService = actorSystemContext.getCustomerService();
    DashboardService actualDashboardService = actorSystemContext.getDashboardService();
    DbCallbackExecutorService actualDbCallbackExecutor = actorSystemContext.getDbCallbackExecutor();
    ConcurrentMap<TenantId, DebugTbRateLimits> actualDebugPerTenantLimits =
        actorSystemContext.getDebugPerTenantLimits();
    String actualDebugPerTenantLimitsConfiguration =
        actorSystemContext.getDebugPerTenantLimitsConfiguration();
    DeviceCredentialsService actualDeviceCredentialsService =
        actorSystemContext.getDeviceCredentialsService();
    TbDeviceProfileCache actualDeviceProfileCache = actorSystemContext.getDeviceProfileCache();
    DeviceProfileService actualDeviceProfileService = actorSystemContext.getDeviceProfileService();
    DeviceService actualDeviceService = actorSystemContext.getDeviceService();
    DeviceSessionCacheService actualDeviceSessionCacheService =
        actorSystemContext.getDeviceSessionCacheService();
    RuleEngineDeviceStateManager actualDeviceStateManager =
        actorSystemContext.getDeviceStateManager();
    String actualDeviceStateNodeRateLimitConfig =
        actorSystemContext.getDeviceStateNodeRateLimitConfig();
    DeviceStateService actualDeviceStateService = actorSystemContext.getDeviceStateService();
    DiscoveryService actualDiscoveryService = actorSystemContext.getDiscoveryService();
    DomainService actualDomainService = actorSystemContext.getDomainService();
    EdgeEventService actualEdgeEventService = actorSystemContext.getEdgeEventService();
    EdgeRpcService actualEdgeRpcService = actorSystemContext.getEdgeRpcService();
    EdgeService actualEdgeService = actorSystemContext.getEdgeService();
    EntityService actualEntityService = actorSystemContext.getEntityService();
    EntityViewService actualEntityViewService = actorSystemContext.getEntityViewService();
    EventService actualEventService = actorSystemContext.getEventService();
    ExternalCallExecutorService actualExternalCallExecutorService =
        actorSystemContext.getExternalCallExecutorService();
    JsInvokeService actualJsInvokeService = actorSystemContext.getJsInvokeService();
    JsInvokeStats actualJsInvokeStats = actorSystemContext.getJsInvokeStats();
    MailExecutorService actualMailExecutor = actorSystemContext.getMailExecutor();
    MailService actualMailService = actorSystemContext.getMailService();
    long actualMaxConcurrentSessionsPerDevice =
        actorSystemContext.getMaxConcurrentSessionsPerDevice();
    int actualMaxRpcRetries = actorSystemContext.getMaxRpcRetries();
    MobileAppService actualMobileAppService = actorSystemContext.getMobileAppService();
    NotificationCenter actualNotificationCenter = actorSystemContext.getNotificationCenter();
    NotificationExecutorService actualNotificationExecutor =
        actorSystemContext.getNotificationExecutor();
    NotificationRequestService actualNotificationRequestService =
        actorSystemContext.getNotificationRequestService();
    NotificationRuleProcessor actualNotificationRuleProcessor =
        actorSystemContext.getNotificationRuleProcessor();
    NotificationRuleService actualNotificationRuleService =
        actorSystemContext.getNotificationRuleService();
    NotificationTargetService actualNotificationTargetService =
        actorSystemContext.getNotificationTargetService();
    NotificationTemplateService actualNotificationTemplateService =
        actorSystemContext.getNotificationTemplateService();
    OAuth2ClientService actualOAuth2ClientService = actorSystemContext.getOAuth2ClientService();
    OtaPackageService actualOtaPackageService = actorSystemContext.getOtaPackageService();
    PartitionService actualPartitionService = actorSystemContext.getPartitionService();
    PubSubRuleNodeExecutorProvider actualPubSubRuleNodeExecutorProvider =
        actorSystemContext.getPubSubRuleNodeExecutorProvider();
    QueueService actualQueueService = actorSystemContext.getQueueService();
    QueueStatsService actualQueueStatsService = actorSystemContext.getQueueStatsService();
    RedisTemplate<String, Object> actualRedisTemplate = actorSystemContext.getRedisTemplate();
    RelationService actualRelationService = actorSystemContext.getRelationService();
    ResourceService actualResourceService = actorSystemContext.getResourceService();
    long actualRpcResponseTimeout = actorSystemContext.getRpcResponseTimeout();
    String actualRpcSubmitStrategy = actorSystemContext.getRpcSubmitStrategy();
    long actualRuleChainErrorPersistFrequency =
        actorSystemContext.getRuleChainErrorPersistFrequency();
    RuleChainService actualRuleChainService = actorSystemContext.getRuleChainService();
    long actualRuleNodeErrorPersistFrequency =
        actorSystemContext.getRuleNodeErrorPersistFrequency();
    RuleNodeStateService actualRuleNodeStateService = actorSystemContext.getRuleNodeStateService();
    TbServiceInfoProvider actualServiceInfoProvider = actorSystemContext.getServiceInfoProvider();
    long actualSessionInactivityTimeout = actorSystemContext.getSessionInactivityTimeout();
    long actualSessionReportTimeout = actorSystemContext.getSessionReportTimeout();
    SharedEventLoopGroupService actualSharedEventLoopGroupService =
        actorSystemContext.getSharedEventLoopGroupService();
    SlackService actualSlackService = actorSystemContext.getSlackService();
    SmsExecutorService actualSmsExecutor = actorSystemContext.getSmsExecutor();
    SmsSenderFactory actualSmsSenderFactory = actorSystemContext.getSmsSenderFactory();
    SmsService actualSmsService = actorSystemContext.getSmsService();
    long actualStatisticsPersistFrequency = actorSystemContext.getStatisticsPersistFrequency();
    TbActorRef actualStatsActor = actorSystemContext.getStatsActor();
    long actualSyncSessionTimeout = actorSystemContext.getSyncSessionTimeout();
    TbCoreDeviceRpcService actualTbCoreDeviceRpcService =
        actorSystemContext.getTbCoreDeviceRpcService();
    TbCoreToTransportService actualTbCoreToTransportService =
        actorSystemContext.getTbCoreToTransportService();
    TbEntityViewService actualTbEntityViewService = actorSystemContext.getTbEntityViewService();
    TbRpcService actualTbRpcService = actorSystemContext.getTbRpcService();
    TbRuleEngineDeviceRpcService actualTbRuleEngineDeviceRpcService =
        actorSystemContext.getTbRuleEngineDeviceRpcService();
    TbelInvokeService actualTbelInvokeService = actorSystemContext.getTbelInvokeService();
    TbTenantProfileCache actualTenantProfileCache = actorSystemContext.getTenantProfileCache();
    TenantProfileService actualTenantProfileService = actorSystemContext.getTenantProfileService();
    TenantService actualTenantService = actorSystemContext.getTenantService();
    TimeseriesService actualTsService = actorSystemContext.getTsService();
    TelemetrySubscriptionService actualTsSubService = actorSystemContext.getTsSubService();
    UserService actualUserService = actorSystemContext.getUserService();
    WidgetTypeService actualWidgetTypeService = actorSystemContext.getWidgetTypeService();
    WidgetsBundleService actualWidgetsBundleService = actorSystemContext.getWidgetsBundleService();
    boolean actualIsAllowSystemMailServiceResult = actorSystemContext.isAllowSystemMailService();
    boolean actualIsAllowSystemSmsServiceResult = actorSystemContext.isAllowSystemSmsService();
    boolean actualIsDebugPerTenantEnabledResult = actorSystemContext.isDebugPerTenantEnabled();
    boolean actualIsEdgesEnabledResult = actorSystemContext.isEdgesEnabled();
    boolean actualIsExternalNodeForceAckResult = actorSystemContext.isExternalNodeForceAck();
    boolean actualIsLocalCacheTypeResult = actorSystemContext.isLocalCacheType();
    boolean actualIsStatisticsEnabledResult = actorSystemContext.isStatisticsEnabled();

    // Assert
    assertTrue(actualActorService instanceof DefaultActorService);
    assertTrue(actualComponentService instanceof AnnotationComponentDiscoveryService);
    assertNull(actualCacheType);
    assertNull(actualDebugPerTenantLimitsConfiguration);
    assertNull(actualDeviceStateNodeRateLimitConfig);
    assertNull(actualRpcSubmitStrategy);
    assertNull(actualRedisTemplate);
    assertNull(actualMailService);
    assertNull(actualNotificationCenter);
    assertNull(actualDeviceStateManager);
    assertNull(actualSmsService);
    assertNull(actualSlackService);
    assertNull(actualSmsSenderFactory);
    assertNull(actualJsInvokeService);
    assertNull(actualTbelInvokeService);
    assertNull(actualJsInvokeStats);
    assertNull(actualStatsActor);
    assertNull(actualClusterService);
    assertNull(actualNotificationRuleProcessor);
    assertNull(actualApiUsageClient);
    assertNull(actualAlarmCommentService);
    assertNull(actualAssetProfileService);
    assertNull(actualAssetService);
    assertNull(actualAttributesService);
    assertNull(actualAuditLogService);
    assertNull(actualCassandraCluster);
    assertNull(actualCustomerService);
    assertNull(actualDashboardService);
    assertNull(actualClaimDevicesService);
    assertNull(actualDeviceCredentialsService);
    assertNull(actualDeviceProfileService);
    assertNull(actualDeviceService);
    assertNull(actualDomainService);
    assertNull(actualEdgeEventService);
    assertNull(actualEdgeService);
    assertNull(actualEntityService);
    assertNull(actualEntityViewService);
    assertNull(actualEventService);
    assertNull(actualMobileAppService);
    assertNull(actualCassandraBufferedRateReadExecutor);
    assertNull(actualCassandraBufferedRateWriteExecutor);
    assertNull(actualNotificationRequestService);
    assertNull(actualNotificationRuleService);
    assertNull(actualNotificationTargetService);
    assertNull(actualNotificationTemplateService);
    assertNull(actualOAuth2ClientService);
    assertNull(actualOtaPackageService);
    assertNull(actualQueueService);
    assertNull(actualQueueStatsService);
    assertNull(actualRelationService);
    assertNull(actualResourceService);
    assertNull(actualRuleChainService);
    assertNull(actualRuleNodeStateService);
    assertNull(actualTenantProfileCache);
    assertNull(actualTenantProfileService);
    assertNull(actualTenantService);
    assertNull(actualTsService);
    assertNull(actualUserService);
    assertNull(actualWidgetTypeService);
    assertNull(actualWidgetsBundleService);
    assertNull(actualDiscoveryService);
    assertNull(actualPartitionService);
    assertNull(actualApiUsageStateService);
    assertNull(actualEdgeRpcService);
    assertNull(actualTbEntityViewService);
    assertNull(actualDbCallbackExecutor);
    assertNull(actualExternalCallExecutorService);
    assertNull(actualNotificationExecutor);
    assertNull(actualPubSubRuleNodeExecutorProvider);
    assertNull(actualSharedEventLoopGroupService);
    assertNull(actualMailExecutor);
    assertNull(actualAssetProfileCache);
    assertNull(actualDeviceProfileCache);
    assertNull(actualTbCoreDeviceRpcService);
    assertNull(actualTbRpcService);
    assertNull(actualTbRuleEngineDeviceRpcService);
    assertNull(actualDeviceSessionCacheService);
    assertNull(actualSmsExecutor);
    assertNull(actualDeviceStateService);
    assertNull(actualAlarmService);
    assertNull(actualTsSubService);
    assertNull(actualTbCoreToTransportService);
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
    assertSame(actorService, actualActorService);
    assertSame(serviceInfoProvider, actualServiceInfoProvider);
    assertSame(componentService, actualComponentService);
  }
}
