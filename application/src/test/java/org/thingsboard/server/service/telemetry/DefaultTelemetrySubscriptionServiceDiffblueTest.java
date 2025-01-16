package org.thingsboard.server.service.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFutureTask;
import freemarker.template.Configuration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseAttributeKvEntry;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvLatestRemovingResult;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.model.sql.ApiUsageStateEntity;
import org.thingsboard.server.dao.service.validator.ApiUsageDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.tenant.JpaTenantProfileDao;
import org.thingsboard.server.dao.sql.usagerecord.ApiUsageStateRepository;
import org.thingsboard.server.dao.sql.usagerecord.JpaApiUsageStateDao;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.PartitionService;
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
import org.thingsboard.server.service.entitiy.entityview.DefaultTbEntityViewService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.mail.MailExecutorService;

class DefaultTelemetrySubscriptionServiceDiffblueTest {
  /**
   * Test {@link DefaultTelemetrySubscriptionService#getExecutorPrefix()}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#getExecutorPrefix()}
   */
  @Test
  @DisplayName("Test getExecutorPrefix()")
  void testGetExecutorPrefix() {
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

    // Act and Assert
    assertEquals("ts",
        (new DefaultTelemetrySubscriptionService(attrService, tsService, tbEntityViewService, apiUsageClient,
            new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
                tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService())))
            .getExecutorPrefix());
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>(), true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, attributes, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, attributes, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdAttributeScopeListFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>(), mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdAttributeScopeListFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, attributes,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdAttributeScopeListFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, attributes,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdStringListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, "Scope", new ArrayList<>(), true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdStringListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, "Scope", attributes, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdStringListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, "Scope", attributes, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, String, List, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdStringListFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, "Scope", new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, String, List, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdStringListFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, "Scope", attributes,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotify(TenantId, EntityId, String, List, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'FutureCallback'")
  void testSaveAndNotifyWithTenantIdEntityIdStringListFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotify(tenantId, entityId, "Scope", attributes,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveWithoutLatestAndNotify(TenantId, CustomerId, EntityId, List, long, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveWithoutLatestAndNotify(TenantId, CustomerId, EntityId, List, long, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveWithoutLatestAndNotify(TenantId, CustomerId, EntityId, List, long, FutureCallback); then calls addListener(Runnable, Executor)")
  void testSaveWithoutLatestAndNotify_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<Integer> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.saveWithoutLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any(),
        anyLong())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);
    ApiUsageStateEntity apiUsageStateEntity = mock(ApiUsageStateEntity.class);
    when(apiUsageStateEntity.toData()).thenReturn(new ApiUsageState());
    doNothing().when(apiUsageStateEntity).setCreatedTime(anyLong());
    doNothing().when(apiUsageStateEntity).setId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setAlarmExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setEntityType(Mockito.<String>any());
    doNothing().when(apiUsageStateEntity).setJsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setSmsExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageStateEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(apiUsageStateEntity).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.randomUUID());
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.randomUUID());
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.randomUUID());
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.randomUUID());
    ApiUsageStateRepository apiUsageStateRepository = mock(ApiUsageStateRepository.class);
    when(apiUsageStateRepository.findByTenantId(Mockito.<UUID>any())).thenReturn(apiUsageStateEntity);
    JpaApiUsageStateDao apiUsageStateDao = new JpaApiUsageStateDao(apiUsageStateRepository);
    JpaTenantProfileDao tenantProfileDao = new JpaTenantProfileDao();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    BaseTimeseriesService tsService2 = new BaseTimeseriesService();
    ApiUsageStateServiceImpl apiUsageStateService = new ApiUsageStateServiceImpl(apiUsageStateDao, tenantProfileDao,
        tenantService, tsService2, new ApiUsageDataValidator());

    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    BaseTimeseriesService tsService3 = new BaseTimeseriesService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTbApiUsageStateService apiUsageStateService2 = new DefaultTbApiUsageStateService(partitionService,
        tenantService2, tsService3, apiUsageStateService, tenantProfileCache, mailService, notificationRuleProcessor,
        dbExecutor, new MailExecutorService());

    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    DefaultTbEntityViewService tbEntityViewService = new DefaultTbEntityViewService(entityViewService,
        attributesService, null, new BaseTimeseriesService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 = new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

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
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService,
        new DefaultTbApiUsageReportClient(partitionService2, serviceInfoProvider3, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider4, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))),
        apiUsageStateService2);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveWithoutLatestAndNotify(tenantId, customerId, entityId, new ArrayList<>(),
        1L, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
    verify(apiUsageStateEntity).setCreatedTime(eq(1L));
    verify(apiUsageStateEntity).setId(isA(UUID.class));
    verify(apiUsageStateEntity).setUuid(isA(UUID.class));
    verify(apiUsageStateEntity).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setEntityId(isA(UUID.class));
    verify(apiUsageStateEntity).setEntityType(eq("Entity Type"));
    verify(apiUsageStateEntity).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).setTenantId(isA(UUID.class));
    verify(apiUsageStateEntity).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageStateEntity).toData();
    verify(apiUsageStateRepository).findByTenantId(isA(UUID.class));
    verify(tsService).saveWithoutLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class), eq(1L));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyInternalWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    // Act
    defaultTelemetrySubscriptionService.saveAndNotifyInternal(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>(), true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyInternalWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotifyInternal(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        attributes, true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyInternalWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotifyInternal(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        attributes, true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyInternalWithTenantIdEntityIdStringListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    // Act
    defaultTelemetrySubscriptionService.saveAndNotifyInternal(tenantId, entityId, "Scope", new ArrayList<>(), true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyInternalWithTenantIdEntityIdStringListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotifyInternal(tenantId, entityId, "Scope", attributes, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testSaveAndNotifyInternalWithTenantIdEntityIdStringListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<AttributeKvEntry> attributes = new ArrayList<>();
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));
    attributes.add(new BaseAttributeKvEntry(4L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveAndNotifyInternal(tenantId, entityId, "Scope", attributes, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotify(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotify(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveLatestAndNotify(TenantId, EntityId, List, FutureCallback); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testSaveLatestAndNotify_givenJsonDataEntryWithKeyAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<TsKvEntry> ts = new ArrayList<>();
    ts.add(new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveLatestAndNotify(tenantId, entityId, ts, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(tsService).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotify(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotify(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveLatestAndNotify(TenantId, EntityId, List, FutureCallback); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testSaveLatestAndNotify_givenJsonDataEntryWithKeyAndValueIs422() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<TsKvEntry> ts = new ArrayList<>();
    ts.add(new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42")));
    ts.add(new BasicTsKvEntry(3L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveLatestAndNotify(tenantId, entityId, ts, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(tsService).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotify(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotify(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveLatestAndNotify(TenantId, EntityId, List, FutureCallback); then calls addListener(Runnable, Executor)")
  void testSaveLatestAndNotify_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveLatestAndNotify(tenantId, entityId, new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(tsService).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testSaveLatestAndNotifyInternal_givenJsonDataEntryWithKeyAndValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    BaseTimeseriesService tsService = mock(BaseTimeseriesService.class);
    when(tsService.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<TsKvEntry> ts = new ArrayList<>();
    ts.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveLatestAndNotifyInternal(tenantId, entityId, ts, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@link JsonDataEntry#JsonDataEntry(String, String)} with
   * {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback); given JsonDataEntry(String, String) with 'Key' and value is '42'")
  void testSaveLatestAndNotifyInternal_givenJsonDataEntryWithKeyAndValueIs422() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    BaseTimeseriesService tsService = mock(BaseTimeseriesService.class);
    when(tsService.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<TsKvEntry> ts = new ArrayList<>();
    ts.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    ts.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act
    defaultTelemetrySubscriptionService.saveLatestAndNotifyInternal(tenantId, entityId, ts, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveLatestAndNotifyInternal(TenantId, EntityId, List, FutureCallback); then calls addListener(Runnable, Executor)")
  void testSaveLatestAndNotifyInternal_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    BaseTimeseriesService tsService = mock(BaseTimeseriesService.class);
    when(tsService.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    // Act
    defaultTelemetrySubscriptionService.saveLatestAndNotifyInternal(tenantId, entityId, new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>(), true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, keys, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, keys, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'FutureCallback'")
  void testDeleteAndNotifyWithTenantIdEntityIdAttributeScopeListFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>(), mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code FutureCallback}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'FutureCallback'; given '42'")
  void testDeleteAndNotifyWithTenantIdEntityIdAttributeScopeListFutureCallback_given42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, keys,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code FutureCallback}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, AttributeScope, List, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'FutureCallback'; given 'foo'")
  void testDeleteAndNotifyWithTenantIdEntityIdAttributeScopeListFutureCallback_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, keys,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyWithTenantIdEntityIdStringListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, "Scope", new ArrayList<>(), true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'; given '42'")
  void testDeleteAndNotifyWithTenantIdEntityIdStringListBooleanFutureCallback_given42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, "Scope", keys, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'; given 'foo'")
  void testDeleteAndNotifyWithTenantIdEntityIdStringListBooleanFutureCallback_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, "Scope", keys, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, String, List, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'FutureCallback'")
  void testDeleteAndNotifyWithTenantIdEntityIdStringListFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, "Scope", new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code FutureCallback}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, String, List, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'FutureCallback'; given '42'")
  void testDeleteAndNotifyWithTenantIdEntityIdStringListFutureCallback_given42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, "Scope", keys, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code FutureCallback}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotify(TenantId, EntityId, String, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotify(TenantId, EntityId, String, List, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'FutureCallback'; given 'foo'")
  void testDeleteAndNotifyWithTenantIdEntityIdStringListFutureCallback_givenFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotify(tenantId, entityId, "Scope", keys, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyInternalWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotifyInternal(tenantId, entityId, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>(), true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyInternalWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotifyInternal(tenantId, entityId, AttributeScope.CLIENT_SCOPE, keys,
        true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotifyInternal(TenantId, EntityId, AttributeScope, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyInternalWithTenantIdEntityIdAttributeScopeListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotifyInternal(tenantId, entityId, AttributeScope.CLIENT_SCOPE, keys,
        true, mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyInternalWithTenantIdEntityIdStringListBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotifyInternal(tenantId, entityId, "Scope", new ArrayList<>(), true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyInternalWithTenantIdEntityIdStringListBooleanFutureCallback2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotifyInternal(tenantId, entityId, "Scope", keys, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code List},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteAndNotifyInternal(TenantId, EntityId, String, List, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'List', 'boolean', 'FutureCallback'")
  void testDeleteAndNotifyInternalWithTenantIdEntityIdStringListBooleanFutureCallback3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.removeAll(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<String>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteAndNotifyInternal(tenantId, entityId, "Scope", keys, true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(attrService).removeAll(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteLatest(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteLatest(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteLatest(TenantId, EntityId, List, FutureCallback); given '42'; when ArrayList() add '42'; then calls addListener(Runnable, Executor)")
  void testDeleteLatest_given42_whenArrayListAdd42_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteLatest(tenantId, entityId, keys, mock(FutureCallback.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isNull());
    verify(entityId).getEntityType();
    verify(tsService).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(Collection.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteLatest(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteLatest(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteLatest(TenantId, EntityId, List, FutureCallback); given 'foo'; when ArrayList() add 'foo'; then calls addListener(Runnable, Executor)")
  void testDeleteLatest_givenFoo_whenArrayListAddFoo_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteLatest(tenantId, entityId, keys, mock(FutureCallback.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isNull());
    verify(entityId).getEntityType();
    verify(tsService).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(Collection.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteLatest(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteLatest(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteLatest(TenantId, EntityId, List, FutureCallback); then calls addListener(Runnable, Executor)")
  void testDeleteLatest_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.deleteLatest(tenantId, entityId, new ArrayList<>(), mock(FutureCallback.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isNull());
    verify(entityId).getEntityType();
    verify(tsService).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(Collection.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteLatestInternal(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteLatestInternal(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteLatestInternal(TenantId, EntityId, List, FutureCallback); given '42'; when ArrayList() add '42'; then calls addListener(Runnable, Executor)")
  void testDeleteLatestInternal_given42_whenArrayListAdd42_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteLatestInternal(tenantId, entityId, keys, mock(FutureCallback.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isNull());
    verify(tsService).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(Collection.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteLatestInternal(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteLatestInternal(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteLatestInternal(TenantId, EntityId, List, FutureCallback); given 'foo'; when ArrayList() add 'foo'; then calls addListener(Runnable, Executor)")
  void testDeleteLatestInternal_givenFoo_whenArrayListAddFoo_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteLatestInternal(tenantId, entityId, keys, mock(FutureCallback.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isNull());
    verify(tsService).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(Collection.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteLatestInternal(TenantId, EntityId, List, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteLatestInternal(TenantId, EntityId, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteLatestInternal(TenantId, EntityId, List, FutureCallback); then calls addListener(Runnable, Executor)")
  void testDeleteLatestInternal_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<Collection<String>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    // Act
    defaultTelemetrySubscriptionService.deleteLatestInternal(tenantId, entityId, new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isNull());
    verify(tsService).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(Collection.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)")
  void testDeleteTimeseriesAndNotify() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<DeleteTsKvQuery>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    ArrayList<String> keys = new ArrayList<>();

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));

    // Act
    defaultTelemetrySubscriptionService.deleteTimeseriesAndNotify(tenantId, entityId, keys, deleteTsKvQueries,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).remove(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)")
  void testDeleteTimeseriesAndNotify2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<DeleteTsKvQuery>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    ArrayList<String> keys = new ArrayList<>();

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 3L, 3L));

    // Act
    defaultTelemetrySubscriptionService.deleteTimeseriesAndNotify(tenantId, entityId, keys, deleteTsKvQueries,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).remove(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback); given '42'; when ArrayList() add '42'; then calls addListener(Runnable, Executor)")
  void testDeleteTimeseriesAndNotify_given42_whenArrayListAdd42_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<DeleteTsKvQuery>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteTimeseriesAndNotify(tenantId, entityId, keys, new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).remove(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback); given 'foo'; when ArrayList() add 'foo'; then calls addListener(Runnable, Executor)")
  void testDeleteTimeseriesAndNotify_givenFoo_whenArrayListAddFoo_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<DeleteTsKvQuery>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);

    ArrayList<String> keys = new ArrayList<>();
    keys.add("foo");

    // Act
    defaultTelemetrySubscriptionService.deleteTimeseriesAndNotify(tenantId, entityId, keys, new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).remove(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback)}
   */
  @Test
  @DisplayName("Test deleteTimeseriesAndNotify(TenantId, EntityId, List, List, FutureCallback); then calls addListener(Runnable, Executor)")
  void testDeleteTimeseriesAndNotify_thenCallsAddListener() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<TsKvLatestRemovingResult>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    TimeseriesService tsService = mock(TimeseriesService.class);
    when(tsService.remove(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<DeleteTsKvQuery>>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    BaseAttributesService attrService = new BaseAttributesService(new JpaAttributeDao());
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    ArrayList<String> keys = new ArrayList<>();

    // Act
    defaultTelemetrySubscriptionService.deleteTimeseriesAndNotify(tenantId, entityId, keys, new ArrayList<>(),
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(tsService).remove(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code String}, {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, boolean, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'String', 'boolean', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdAttributeScopeStringBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new RuntimeException("foo");
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, "Key", true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, double, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code String}, {@code double}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, double, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, double, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'String', 'double', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdAttributeScopeStringDoubleFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new RuntimeException("foo");
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, "Key", 10.0d,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, long, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code String}, {@code long}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, long, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, long, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'String', 'long', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdAttributeScopeStringLongFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new RuntimeException("foo");
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, "Key", 42L,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, String, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code String}, {@code String}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, String, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, AttributeScope, String, String, FutureCallback) with 'TenantId', 'EntityId', 'AttributeScope', 'String', 'String', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdAttributeScopeStringStringFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new RuntimeException("foo");
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<AttributeScope>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, AttributeScope.CLIENT_SCOPE, "Key", "42",
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq(AttributeScope.CLIENT_SCOPE),
        isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, boolean, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code String},
   * {@code boolean}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, boolean, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, String, String, boolean, FutureCallback) with 'TenantId', 'EntityId', 'String', 'String', 'boolean', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdStringStringBooleanFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, "Scope", "Key", true,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, double, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code String},
   * {@code double}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, double, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, String, String, double, FutureCallback) with 'TenantId', 'EntityId', 'String', 'String', 'double', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdStringStringDoubleFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, "Scope", "Key", 10.0d,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, long, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code String},
   * {@code long}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, long, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, String, String, long, FutureCallback) with 'TenantId', 'EntityId', 'String', 'String', 'long', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdStringStringLongFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, "Scope", "Key", 42L,
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }

  /**
   * Test
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, String, FutureCallback)}
   * with {@code TenantId}, {@code EntityId}, {@code String}, {@code String},
   * {@code String}, {@code FutureCallback}.
   * <p>
   * Method under test:
   * {@link DefaultTelemetrySubscriptionService#saveAttrAndNotify(TenantId, EntityId, String, String, String, FutureCallback)}
   */
  @Test
  @DisplayName("Test saveAttrAndNotify(TenantId, EntityId, String, String, String, FutureCallback) with 'TenantId', 'EntityId', 'String', 'String', 'String', 'FutureCallback'")
  void testSaveAttrAndNotifyWithTenantIdEntityIdStringStringStringFutureCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ListenableFutureTask<List<Long>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    AttributesService attrService = mock(AttributesService.class);
    when(attrService.save(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any(),
        Mockito.<List<AttributeKvEntry>>any())).thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
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
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider5, new DefaultSchedulerComponent(), null));

    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DbCallbackExecutorService dbExecutor = new DbCallbackExecutorService();
    DefaultTelemetrySubscriptionService defaultTelemetrySubscriptionService = new DefaultTelemetrySubscriptionService(
        attrService, tsService, tbEntityViewService, apiUsageClient,
        new DefaultTbApiUsageStateService(partitionService2, tenantService, tsService2, apiUsageStateService,
            tenantProfileCache, mailService, notificationRuleProcessor, dbExecutor, new MailExecutorService()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTelemetrySubscriptionService.saveAttrAndNotify(tenantId, entityId, "Scope", "Key", "42",
        mock(FutureCallback.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), isNull());
    verify(entityId).getEntityType();
    verify(attrService).save(isA(TenantId.class), isA(EntityId.class), eq("Scope"), isA(List.class));
  }
}
