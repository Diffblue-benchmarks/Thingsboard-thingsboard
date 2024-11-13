package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.RepositoryAuthMethod;
import org.thingsboard.server.common.data.sync.vc.RepositorySettings;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityServiceRegistry;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
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
import org.thingsboard.server.service.sync.vc.repository.DefaultTbRepositorySettingsService;
import org.thingsboard.server.service.sync.vc.repository.RepositorySettingsCaffeineCache;

class DefaultEntitiesVersionControlServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#getVersionCreateStatus(User, UUID)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#getVersionCreateStatus(User, UUID)}
   */
  @Test
  @DisplayName("Test getVersionCreateStatus(User, UUID)")
  void testGetVersionCreateStatus() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    User user = new User();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.getVersionCreateStatus(user, UUID.randomUUID()));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#getVersionLoadStatus(User, UUID)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#getVersionLoadStatus(User, UUID)}
   */
  @Test
  @DisplayName("Test getVersionLoadStatus(User, UUID)")
  void testGetVersionLoadStatus() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    User user = new User();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.getVersionLoadStatus(user, UUID.randomUUID()));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getVersionControlSettings(TenantId)")
  void testGetVersionControlSettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());

    // Act
    RepositorySettings actualVersionControlSettings = defaultEntitiesVersionControlService
        .getVersionControlSettings(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualVersionControlSettings);
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getVersionControlSettings(TenantId)")
  void testGetVersionControlSettings2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());

    // Act
    RepositorySettings actualVersionControlSettings = defaultEntitiesVersionControlService
        .getVersionControlSettings(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualVersionControlSettings);
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getVersionControlSettings(TenantId); then calls getJsonValue()")
  void testGetVersionControlSettings_thenCallsGetJsonValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());

    // Act
    RepositorySettings actualVersionControlSettings = defaultEntitiesVersionControlService
        .getVersionControlSettings(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
    assertNull(actualVersionControlSettings);
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}.
   * <ul>
   *   <li>Then return {@link RepositorySettings#RepositorySettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#getVersionControlSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getVersionControlSettings(TenantId); then return RepositorySettings()")
  void testGetVersionControlSettings_thenReturnRepositorySettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    RepositorySettings repositorySettings = new RepositorySettings();
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());

    // Act
    RepositorySettings actualVersionControlSettings = defaultEntitiesVersionControlService
        .getVersionControlSettings(new TenantId(UUID.randomUUID()));

    // Assert
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertEquals(repositorySettings, actualVersionControlSettings);
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings)")
  void testCheckVersionControlAccess() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings)")
  void testCheckVersionControlAccess2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then calls
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then calls getAndPutInTransaction(Serializable, Supplier, boolean)")
  void testCheckVersionControlAccess_thenCallsGetAndPutInTransaction() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(new RepositorySettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then calls getJsonValue()")
  void testCheckVersionControlAccess_thenCallsGetJsonValue() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getJsonValue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then calls getJsonValue()")
  void testCheckVersionControlAccess_thenCallsGetJsonValue2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(NullNode.getInstance());
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("entitiesVersionControl"));
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}.
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#checkVersionControlAccess(TenantId, RepositorySettings)}
   */
  @Test
  @DisplayName("Test checkVersionControlAccess(TenantId, RepositorySettings); then calls getServiceId()")
  void testCheckVersionControlAccess_thenCallsGetServiceId() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(new RepositorySettings());
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        mock(AdminSettingsService.class), cache);

    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesVersionControlService.checkVersionControlAccess(tenantId, new RepositorySettings()));
    verify(cache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   * with {@code user}, {@code entityType}, {@code entityIds}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'")
  void testAutoCommitWithUserEntityTypeEntityIds() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(null);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        new AdminSettingsServiceImpl(), cache);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(cache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   * with {@code user}, {@code entityType}, {@code entityIds}.
   * <ul>
   *   <li>Given randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'; given randomUUID")
  void testAutoCommitWithUserEntityTypeEntityIds_givenRandomUUID() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        new AdminSettingsServiceImpl(), cache);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    User user = new User();

    ArrayList<UUID> entityIds = new ArrayList<>();
    entityIds.add(UUID.randomUUID());

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, entityIds);

    // Assert
    verify(cache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   * with {@code user}, {@code entityType}, {@code entityIds}.
   * <ul>
   *   <li>Given randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'; given randomUUID")
  void testAutoCommitWithUserEntityTypeEntityIds_givenRandomUUID2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        new AdminSettingsServiceImpl(), cache);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    User user = new User();

    ArrayList<UUID> entityIds = new ArrayList<>();
    entityIds.add(UUID.randomUUID());
    entityIds.add(UUID.randomUUID());

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, entityIds);

    // Assert
    verify(cache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }

  /**
   * Test
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   * with {@code user}, {@code entityType}, {@code entityIds}.
   * <ul>
   *   <li>Then calls {@link RepositorySettings#getAuthMethod()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesVersionControlService#autoCommit(User, EntityType, List)}
   */
  @Test
  @DisplayName("Test autoCommit(User, EntityType, List) with 'user', 'entityType', 'entityIds'; then calls getAuthMethod()")
  void testAutoCommitWithUserEntityTypeEntityIds_thenCallsGetAuthMethod() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RepositorySettings repositorySettings = mock(RepositorySettings.class);
    when(repositorySettings.isLocalOnly()).thenReturn(true);
    when(repositorySettings.isReadOnly()).thenReturn(true);
    when(repositorySettings.isShowMergeCommits()).thenReturn(true);
    when(repositorySettings.getDefaultBranch()).thenReturn("janedoe/featurebranch");
    when(repositorySettings.getPassword()).thenReturn("iloveyou");
    when(repositorySettings.getPrivateKey()).thenReturn("Private Key");
    when(repositorySettings.getPrivateKeyFileName()).thenReturn("foo.txt");
    when(repositorySettings.getPrivateKeyPassword()).thenReturn("iloveyou");
    when(repositorySettings.getRepositoryUri()).thenReturn("Repository Uri");
    when(repositorySettings.getUsername()).thenReturn("janedoe");
    when(repositorySettings.getAuthMethod()).thenReturn(RepositoryAuthMethod.USERNAME_PASSWORD);
    TbTransactionalCache<TenantId, RepositorySettings> cache = mock(TbTransactionalCache.class);
    when(cache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<RepositorySettings>>any(),
        anyBoolean())).thenReturn(repositorySettings);
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        new AdminSettingsServiceImpl(), cache);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache2 = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache2, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    DefaultEntitiesExportImportService exportImportService = new DefaultEntitiesExportImportService(relationService,
        rateLimitService, new DefaultTbLogEntityActionService(
            new EntityActionService(null, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));

    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService exportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultTbLogEntityActionService logEntityActionService = new DefaultTbLogEntityActionService(
        new EntityActionService(tbClusterService, new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class)));
    TransactionTemplate transactionTemplate = new TransactionTemplate();
    VersionControlTaskCaffeineCache taskCache = new VersionControlTaskCaffeineCache(new CaffeineCacheManager());
    DefaultEntitiesVersionControlService defaultEntitiesVersionControlService = new DefaultEntitiesVersionControlService(
        repositorySettingsService, autoCommitSettingsService, gitServiceQueue, exportImportService,
        exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
        new VersionControlExecutor());
    User user = new User();

    // Act
    ListenableFuture<UUID> actualAutoCommitResult = defaultEntitiesVersionControlService.autoCommit(user,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    verify(cache).getAndPutInTransaction(isNull(), isA(Supplier.class), eq(true));
    verify(repositorySettings).getAuthMethod();
    verify(repositorySettings).getDefaultBranch();
    verify(repositorySettings).getPassword();
    verify(repositorySettings).getPrivateKey();
    verify(repositorySettings).getPrivateKeyFileName();
    verify(repositorySettings).getPrivateKeyPassword();
    verify(repositorySettings).getRepositoryUri();
    verify(repositorySettings).getUsername();
    verify(repositorySettings).isLocalOnly();
    verify(repositorySettings).isReadOnly();
    verify(repositorySettings).isShowMergeCommits();
    assertNull(actualAutoCommitResult.get());
    assertTrue(actualAutoCommitResult.isDone());
  }
}
