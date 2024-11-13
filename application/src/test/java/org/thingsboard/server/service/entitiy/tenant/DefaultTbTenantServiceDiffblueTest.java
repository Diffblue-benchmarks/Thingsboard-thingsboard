package org.thingsboard.server.service.entitiy.tenant;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityServiceRegistry;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.entitiy.DefaultTbLogEntityActionService;
import org.thingsboard.server.service.entitiy.queue.DefaultTbQueueService;
import org.thingsboard.server.service.executors.VersionControlExecutor;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.install.InstallScripts;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.security.permission.DefaultAccessControlService;
import org.thingsboard.server.service.security.permission.Permissions;
import org.thingsboard.server.service.sync.ie.DefaultEntitiesExportImportService;
import org.thingsboard.server.service.sync.ie.exporting.DefaultExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.DefaultEntitiesVersionControlService;
import org.thingsboard.server.service.sync.vc.DefaultGitVersionControlQueueService;
import org.thingsboard.server.service.sync.vc.VersionControlTaskCaffeineCache;
import org.thingsboard.server.service.sync.vc.autocommit.AutoCommitSettingsCaffeineCache;
import org.thingsboard.server.service.sync.vc.autocommit.DefaultTbAutoCommitSettingsService;
import org.thingsboard.server.service.sync.vc.repository.DefaultTbRepositorySettingsService;
import org.thingsboard.server.service.sync.vc.repository.RepositorySettingsCaffeineCache;

class DefaultTbTenantServiceDiffblueTest {
  /**
   * Test {@link DefaultTbTenantService#save(Tenant)}.
   * <ul>
   *   <li>Then return {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbTenantService#save(Tenant)}
   */
  @Test
  @DisplayName("Test save(Tenant); then return Tenant()")
  void testSave_thenReturnTenant() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantService tenantService = mock(TenantService.class);
    Tenant tenant = new Tenant();
    when(tenantService.saveTenant(Mockito.<Tenant>any(), Mockito.<Consumer<TenantId>>any())).thenReturn(tenant);
    TbTenantProfileCache tenantProfileCache = mock(TbTenantProfileCache.class);
    doNothing().when(tenantProfileCache).evict(Mockito.<TenantId>any());
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    when(tenantProfileService.findTenantProfileById(Mockito.<TenantId>any(), Mockito.<TenantProfileId>any()))
        .thenReturn(new TenantProfile());
    InstallScripts installScripts = new InstallScripts();
    BaseQueueService queueService = new BaseQueueService();
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbQueueService tbQueueService = new DefaultTbQueueService(queueService,
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())),
        null);

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbRepositorySettingsService repositorySettingsService = new DefaultTbRepositorySettingsService(
        adminSettingsService, new RepositorySettingsCaffeineCache(new CaffeineCacheManager()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbAutoCommitSettingsService autoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService2, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TopicService topicService2 = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService2 = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService2, null, null,
        gatewayNotificationsService2, new EdgeServiceImpl(), null);

    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    DefaultGitVersionControlQueueService gitServiceQueue = new DefaultGitVersionControlQueueService(serviceInfoProvider,
        clusterService, null, scheduler, new VersionControlExecutor());

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
    DefaultTbTenantService defaultTbTenantService = new DefaultTbTenantService(tenantService, tenantProfileCache,
        installScripts, tbQueueService, tenantProfileService,
        new DefaultEntitiesVersionControlService(repositorySettingsService, autoCommitSettingsService, gitServiceQueue,
            exportImportService, exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
            new VersionControlExecutor()));

    // Act
    Tenant actualSaveResult = defaultTbTenantService.save(new Tenant());

    // Assert
    verify(tenantProfileCache).evict((TenantId) isNull());
    verify(tenantProfileService).findTenantProfileById(isA(TenantId.class), isNull());
    verify(tenantService).saveTenant(isA(Tenant.class), isA(Consumer.class));
    assertSame(tenant, actualSaveResult);
  }
}
