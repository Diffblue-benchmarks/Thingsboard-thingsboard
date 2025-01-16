package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateRequest;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityServiceRegistry;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.scheduler.SchedulerComponent;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.entitiy.DefaultTbLogEntityActionService;
import org.thingsboard.server.service.executors.VersionControlExecutor;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.security.permission.DefaultAccessControlService;
import org.thingsboard.server.service.security.permission.Permissions;
import org.thingsboard.server.service.sync.ie.DefaultEntitiesExportImportService;
import org.thingsboard.server.service.sync.ie.exporting.DefaultExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.autocommit.AutoCommitSettingsCaffeineCache;
import org.thingsboard.server.service.sync.vc.autocommit.DefaultTbAutoCommitSettingsService;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.repository.DefaultTbRepositorySettingsService;
import org.thingsboard.server.service.sync.vc.repository.RepositorySettingsCaffeineCache;

class DefaultGitVersionControlQueueServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#prepareCommit(User, VersionCreateRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#prepareCommit(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test prepareCommit(User, VersionCreateRequest)")
  void testPrepareCommit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.prepareCommit(user, new ComplexVersionCreateRequest()));
    verify(user).getTenantId();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#prepareCommit(User, VersionCreateRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#prepareCommit(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test prepareCommit(User, VersionCreateRequest)")
  void testPrepareCommit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.prepareCommit(user, new ComplexVersionCreateRequest()));
    verify(user).getTenantId();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#prepareCommit(User, VersionCreateRequest)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#prepareCommit(User, VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test prepareCommit(User, VersionCreateRequest); then calls getJsonValue()")
  void testPrepareCommit_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.prepareCommit(user, new ComplexVersionCreateRequest()));
    verify(adminSettings).getJsonValue();
    verify(user).getTenantId();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}
   */
  @Test
  @DisplayName("Test deleteAll(CommitGitRequest, EntityType)")
  void testDeleteAll() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .deleteAll(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), EntityType.TENANT));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}
   */
  @Test
  @DisplayName("Test deleteAll(CommitGitRequest, EntityType)")
  void testDeleteAll2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .deleteAll(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), EntityType.TENANT));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}
   */
  @Test
  @DisplayName("Test deleteAll(CommitGitRequest, EntityType); given AdminSettings getJsonValue() return Instance; then calls getJsonValue()")
  void testDeleteAll_givenAdminSettingsGetJsonValueReturnInstance_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .deleteAll(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), EntityType.TENANT));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#deleteAll(CommitGitRequest, EntityType)}
   */
  @Test
  @DisplayName("Test deleteAll(CommitGitRequest, EntityType); then calls getRepositoryUri()")
  void testDeleteAll_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .deleteAll(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), EntityType.TENANT));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}
   */
  @Test
  @DisplayName("Test push(CommitGitRequest)")
  void testPush() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .push(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest())));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}.
   * <ul>
   *   <li>Given {@link AdminSettings} {@link AdminSettings#getJsonValue()} return
   * Instance.</li>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}
   */
  @Test
  @DisplayName("Test push(CommitGitRequest); given AdminSettings getJsonValue() return Instance; then calls getJsonValue()")
  void testPush_givenAdminSettingsGetJsonValueReturnInstance_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .push(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest())));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByTenantIdAndKey(TenantId, String)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}
   */
  @Test
  @DisplayName("Test push(CommitGitRequest); given AdminSettingsService findAdminSettingsByTenantIdAndKey(TenantId, String) return 'null'")
  void testPush_givenAdminSettingsServiceFindAdminSettingsByTenantIdAndKeyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .push(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest())));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#push(CommitGitRequest)}
   */
  @Test
  @DisplayName("Test push(CommitGitRequest); then calls getRepositoryUri()")
  void testPush_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .push(new CommitGitRequest(tenantId, new ComplexVersionCreateRequest())));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code entityType}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, EntityType, PageLink) with 'tenantId', 'branch', 'entityType', 'pageLink'")
  void testListVersionsWithTenantIdBranchEntityTypePageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.listVersions(tenantId,
        "janedoe/featurebranch", EntityType.TENANT, new PageLink(3)));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code entityType}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, EntityType, PageLink) with 'tenantId', 'branch', 'entityType', 'pageLink'")
  void testListVersionsWithTenantIdBranchEntityTypePageLink2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.listVersions(tenantId,
        "janedoe/featurebranch", EntityType.TENANT, new PageLink(3)));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code entityType}, {@code pageLink}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, EntityType, PageLink) with 'tenantId', 'branch', 'entityType', 'pageLink'; then calls getJsonValue()")
  void testListVersionsWithTenantIdBranchEntityTypePageLink_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.listVersions(tenantId,
        "janedoe/featurebranch", EntityType.TENANT, new PageLink(3)));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code entityType}, {@code pageLink}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, EntityType, PageLink) with 'tenantId', 'branch', 'entityType', 'pageLink'; then calls getRepositoryUri()")
  void testListVersionsWithTenantIdBranchEntityTypePageLink_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService.listVersions(tenantId,
        "janedoe/featurebranch", EntityType.TENANT, new PageLink(3)));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, PageLink) with 'tenantId', 'branch', 'pageLink'")
  void testListVersionsWithTenantIdBranchPageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listVersions(tenantId, "janedoe/featurebranch", new PageLink(3)));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, PageLink) with 'tenantId', 'branch', 'pageLink'")
  void testListVersionsWithTenantIdBranchPageLink2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listVersions(tenantId, "janedoe/featurebranch", new PageLink(3)));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code pageLink}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, PageLink) with 'tenantId', 'branch', 'pageLink'; then calls getJsonValue()")
  void testListVersionsWithTenantIdBranchPageLink_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listVersions(tenantId, "janedoe/featurebranch", new PageLink(3)));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   * with {@code tenantId}, {@code branch}, {@code pageLink}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listVersions(TenantId, String, PageLink)}
   */
  @Test
  @DisplayName("Test listVersions(TenantId, String, PageLink) with 'tenantId', 'branch', 'pageLink'; then calls getRepositoryUri()")
  void testListVersionsWithTenantIdBranchPageLink_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listVersions(tenantId, "janedoe/featurebranch", new PageLink(3)));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   * with {@code tenantId}, {@code versionId}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String) with 'tenantId', 'versionId'")
  void testListEntitiesAtVersionWithTenantIdVersionId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42"));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   * with {@code tenantId}, {@code versionId}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String) with 'tenantId', 'versionId'")
  void testListEntitiesAtVersionWithTenantIdVersionId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42"));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   * with {@code tenantId}, {@code versionId}, {@code entityType}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, EntityType) with 'tenantId', 'versionId', 'entityType'")
  void testListEntitiesAtVersionWithTenantIdVersionIdEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   * with {@code tenantId}, {@code versionId}, {@code entityType}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, EntityType) with 'tenantId', 'versionId', 'entityType'")
  void testListEntitiesAtVersionWithTenantIdVersionIdEntityType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   * with {@code tenantId}, {@code versionId}, {@code entityType}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, EntityType) with 'tenantId', 'versionId', 'entityType'")
  void testListEntitiesAtVersionWithTenantIdVersionIdEntityType3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   * with {@code tenantId}, {@code versionId}, {@code entityType}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String, EntityType)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String, EntityType) with 'tenantId', 'versionId', 'entityType'; then calls getJsonValue()")
  void testListEntitiesAtVersionWithTenantIdVersionIdEntityType_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   * with {@code tenantId}, {@code versionId}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String) with 'tenantId', 'versionId'; then calls getJsonValue()")
  void testListEntitiesAtVersionWithTenantIdVersionId_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42"));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   * with {@code tenantId}, {@code versionId}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listEntitiesAtVersion(TenantId, String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(TenantId, String) with 'tenantId', 'versionId'; then calls getRepositoryUri()")
  void testListEntitiesAtVersionWithTenantIdVersionId_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listEntitiesAtVersion(new TenantId(UUID.randomUUID()), "42"));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId)")
  void testListBranches() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listBranches(new TenantId(UUID.randomUUID())));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId)")
  void testListBranches2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listBranches(new TenantId(UUID.randomUUID())));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId); then calls getJsonValue()")
  void testListBranches_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listBranches(new TenantId(UUID.randomUUID())));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#listBranches(TenantId)}
   */
  @Test
  @DisplayName("Test listBranches(TenantId); then calls getRepositoryUri()")
  void testListBranches_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultGitVersionControlQueueService.listBranches(new TenantId(UUID.randomUUID())));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}
   */
  @Test
  @DisplayName("Test getEntities(TenantId, String, EntityType, int, int)")
  void testGetEntities() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .getEntities(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT, 2, 1));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}.
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}
   */
  @Test
  @DisplayName("Test getEntities(TenantId, String, EntityType, int, int)")
  void testGetEntities2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .getEntities(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT, 2, 1));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}
   */
  @Test
  @DisplayName("Test getEntities(TenantId, String, EntityType, int, int); then calls getJsonValue()")
  void testGetEntities_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(MissingNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .getEntities(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT, 2, 1));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getRepositoryUri()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#getEntities(TenantId, String, EntityType, int, int)}
   */
  @Test
  @DisplayName("Test getEntities(TenantId, String, EntityType, int, int); then calls getRepositoryUri()")
  void testGetEntities_thenCallsGetRepositoryUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.getRepositoryUri()).thenThrow(new RuntimeException("foo"));
    DefaultEntitiesVersionControlService entitiesVersionControlService = mock(
        DefaultEntitiesVersionControlService.class);
    when(entitiesVersionControlService.getVersionControlSettings(Mockito.<TenantId>any()))
        .thenReturn(repositorySettings);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultGitVersionControlQueueService
        .getEntities(new TenantId(UUID.randomUUID()), "42", EntityType.TENANT, 2, 1));
    verify(repositorySettings).getRepositoryUri();
    verify(serviceInfoProvider).getServiceId();
    verify(entitiesVersionControlService).getVersionControlSettings(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultGitVersionControlQueueService#clearRepository(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link TbClusterService#pushMsgToVersionControl(TenantId, ToVersionControlServiceMsg, TbQueueCallback)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultGitVersionControlQueueService#clearRepository(TenantId)}
   */
  @Test
  @DisplayName("Test clearRepository(TenantId); then calls pushMsgToVersionControl(TenantId, ToVersionControlServiceMsg, TbQueueCallback)")
  void testClearRepository_thenCallsPushMsgToVersionControl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = mock(DefaultTbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    TbClusterService clusterService = mock(TbClusterService.class);
    doNothing().when(clusterService)
        .pushMsgToVersionControl(Mockito.<TenantId>any(), Mockito.<TransportProtos.ToVersionControlServiceMsg>any(),
            Mockito.<TbQueueCallback>any());
    SchedulerComponent scheduler = mock(SchedulerComponent.class);
    Mockito.<ScheduledFuture<?>>when(scheduler.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, null, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(null));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService entitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, null, exportImportService, exportableEntitiesService,
        logEntityActionService, transactionTemplate, taskCache, new VersionControlExecutor());

    DefaultGitVersionControlQueueService defaultGitVersionControlQueueService = new DefaultGitVersionControlQueueService(
        serviceInfoProvider, clusterService, entitiesVersionControlService, scheduler, new VersionControlExecutor());

    // Act
    defaultGitVersionControlQueueService.clearRepository(new TenantId(UUID.randomUUID()));

    // Assert
    verify(clusterService).pushMsgToVersionControl(isA(TenantId.class),
        isA(TransportProtos.ToVersionControlServiceMsg.class), isA(TbQueueCallback.class));
    verify(serviceInfoProvider).getServiceId();
    verify(scheduler).schedule(isA(Runnable.class), eq(0L), eq(TimeUnit.MILLISECONDS));
  }
}
