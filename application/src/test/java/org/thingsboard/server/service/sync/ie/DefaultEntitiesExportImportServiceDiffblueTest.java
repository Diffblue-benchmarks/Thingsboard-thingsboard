package org.thingsboard.server.service.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.entitiy.DefaultTbLogEntityActionService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class DefaultEntitiesExportImportServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}
   */
  @Test
  @DisplayName("Test importEntity(EntitiesImportCtx, EntityExportData)")
  void testImportEntity() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultEntitiesExportImportService defaultEntitiesExportImportService = new DefaultEntitiesExportImportService(
        relationService, rateLimitService, new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService,
            new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenThrow(new DataValidationException("An error occurred"));
    EntityExportData<ExportableEntity<EntityId>> exportData = mock(EntityExportData.class);
    when(exportData.getEntity()).thenReturn(exportableEntity);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultEntitiesExportImportService.importEntity(ctx, exportData));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.ENTITY_IMPORT), isNull());
    verify(exportableEntity).getId();
    verify(exportData, atLeast(1)).getEntity();
  }

  /**
   * Test
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}.
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)}
   * with message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}
   */
  @Test
  @DisplayName("Test importEntity(EntitiesImportCtx, EntityExportData); given DataValidationException(String) with message is 'An error occurred'")
  void testImportEntity_givenDataValidationExceptionWithMessageIsAnErrorOccurred() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultEntitiesExportImportService defaultEntitiesExportImportService = new DefaultEntitiesExportImportService(
        relationService, rateLimitService, new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService,
            new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenReturn(new AlarmId(UUID.randomUUID()));
    EntityExportData<ExportableEntity<EntityId>> exportData = mock(EntityExportData.class);
    when(exportData.getEntityType()).thenThrow(new DataValidationException("An error occurred"));
    when(exportData.getEntity()).thenReturn(exportableEntity);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultEntitiesExportImportService.importEntity(ctx, exportData));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.ENTITY_IMPORT), isNull());
    verify(exportableEntity).getId();
    verify(exportData, atLeast(1)).getEntity();
    verify(exportData).getEntityType();
  }

  /**
   * Test
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}.
   * <ul>
   *   <li>Given {@link ExportableEntity} {@link HasId#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}
   */
  @Test
  @DisplayName("Test importEntity(EntitiesImportCtx, EntityExportData); given ExportableEntity getId() return 'null'")
  void testImportEntity_givenExportableEntityGetIdReturnNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultEntitiesExportImportService defaultEntitiesExportImportService = new DefaultEntitiesExportImportService(
        relationService, rateLimitService, new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService,
            new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenReturn(null);
    EntityExportData<ExportableEntity<EntityId>> exportData = mock(EntityExportData.class);
    when(exportData.getEntity()).thenReturn(exportableEntity);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultEntitiesExportImportService.importEntity(ctx, exportData));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.ENTITY_IMPORT), isNull());
    verify(exportableEntity).getId();
    verify(exportData, atLeast(1)).getEntity();
  }

  /**
   * Test
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}
   */
  @Test
  @DisplayName("Test importEntity(EntitiesImportCtx, EntityExportData); given 'TENANT'; then throw IllegalArgumentException")
  void testImportEntity_givenTenant_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultEntitiesExportImportService defaultEntitiesExportImportService = new DefaultEntitiesExportImportService(
        relationService, rateLimitService, new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService,
            new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenReturn(new AlarmId(UUID.randomUUID()));
    EntityExportData<ExportableEntity<EntityId>> exportData = mock(EntityExportData.class);
    when(exportData.getEntityType()).thenReturn(EntityType.TENANT);
    when(exportData.getEntity()).thenReturn(exportableEntity);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntitiesExportImportService.importEntity(ctx, exportData));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.ENTITY_IMPORT), isNull());
    verify(exportableEntity).getId();
    verify(exportData, atLeast(1)).getEntity();
    verify(exportData).getEntityType();
  }

  /**
   * Test
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}.
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}
   */
  @Test
  @DisplayName("Test importEntity(EntitiesImportCtx, EntityExportData); then throw ThingsboardException")
  void testImportEntity_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(false);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultEntitiesExportImportService defaultEntitiesExportImportService = new DefaultEntitiesExportImportService(
        relationService, rateLimitService, new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService,
            new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultEntitiesExportImportService.importEntity(ctx, new EntityExportData<>()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.ENTITY_IMPORT), isNull());
  }

  /**
   * Test
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}.
   * <ul>
   *   <li>When {@link EntityExportData} (default constructor).</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#importEntity(EntitiesImportCtx, EntityExportData)}
   */
  @Test
  @DisplayName("Test importEntity(EntitiesImportCtx, EntityExportData); when EntityExportData (default constructor); then throw DataValidationException")
  void testImportEntity_whenEntityExportData_thenThrowDataValidationException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    DefaultEntitiesExportImportService defaultEntitiesExportImportService = new DefaultEntitiesExportImportService(
        relationService, rateLimitService, new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService,
            new AuditLogServiceImpl(), mock(NotificationRuleProcessor.class))));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultEntitiesExportImportService.importEntity(ctx, new EntityExportData<>()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.ENTITY_IMPORT), isNull());
  }

  /**
   * Test
   * {@link DefaultEntitiesExportImportService#getEntityTypeComparatorForImport()}.
   * <p>
   * Method under test:
   * {@link DefaultEntitiesExportImportService#getEntityTypeComparatorForImport()}
   */
  @Test
  @DisplayName("Test getEntityTypeComparatorForImport()")
  void testGetEntityTypeComparatorForImport() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    BaseRelationService relationService = new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService());

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    TopicService topicService = new TopicService();
    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, null, null,
        gatewayNotificationsService, new EdgeServiceImpl(), null);

    // Act and Assert
    assertEquals(0,
        (new DefaultEntitiesExportImportService(relationService, rateLimitService,
            new DefaultTbLogEntityActionService(new EntityActionService(tbClusterService, new AuditLogServiceImpl(),
                mock(NotificationRuleProcessor.class)))))
            .getEntityTypeComparatorForImport()
            .compare(EntityType.TENANT, EntityType.TENANT));
  }
}
