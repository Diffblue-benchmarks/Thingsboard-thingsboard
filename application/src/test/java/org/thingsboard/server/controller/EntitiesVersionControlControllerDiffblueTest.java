package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityServiceRegistry;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.entitiy.DefaultTbLogEntityActionService;
import org.thingsboard.server.service.executors.VersionControlExecutor;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
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

class EntitiesVersionControlControllerDiffblueTest {
  /**
   * Test {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)}
   * with {@code future}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)}
   */
  @Test
  @DisplayName("Test wrapFuture(ListenableFuture) with 'future'; then calls addListener(Runnable, Executor)")
  void testWrapFutureWithFuture_thenCallsAddListener() {
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
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

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
    EntitiesVersionControlController entitiesVersionControlController = new EntitiesVersionControlController(
        new DefaultEntitiesVersionControlService(repositorySettingsService, autoCommitSettingsService, gitServiceQueue,
            exportImportService, exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
            new VersionControlExecutor()));
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    DeferredResult<Object> actualWrapFutureResult = entitiesVersionControlController.wrapFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }

  /**
   * Test {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)}
   * with {@code future}.
   * <ul>
   *   <li>When
   * {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   * with delegate is create.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)}
   */
  @Test
  @DisplayName("Test wrapFuture(ListenableFuture) with 'future'; when ListenableFutureToApiFuture(ListenableFuture) with delegate is create")
  void testWrapFutureWithFuture_whenListenableFutureToApiFutureWithDelegateIsCreate() {
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
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

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
    EntitiesVersionControlController entitiesVersionControlController = new EntitiesVersionControlController(
        new DefaultEntitiesVersionControlService(repositorySettingsService, autoCommitSettingsService, gitServiceQueue,
            exportImportService, exportableEntitiesService, logEntityActionService, transactionTemplate, taskCache,
            new VersionControlExecutor()));
    SettableFuture<Object> delegate = SettableFuture.create();

    // Act
    DeferredResult<Object> actualWrapFutureResult = entitiesVersionControlController.wrapFuture(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Assert
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }
}
