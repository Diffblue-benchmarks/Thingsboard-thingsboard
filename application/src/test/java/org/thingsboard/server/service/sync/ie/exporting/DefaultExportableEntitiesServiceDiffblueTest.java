package org.thingsboard.server.service.sync.ie.exporting;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.entity.EntityServiceRegistry;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.service.security.permission.DefaultAccessControlService;
import org.thingsboard.server.service.security.permission.Permissions;

class DefaultExportableEntitiesServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultExportableEntitiesService#findEntityByTenantIdAndExternalId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#findEntityByTenantIdAndExternalId(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityByTenantIdAndExternalId(TenantId, EntityId); then return 'null'")
  void testFindEntityByTenantIdAndExternalId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(
        defaultExportableEntitiesService.findEntityByTenantIdAndExternalId(tenantId, new AlarmId(UUID.randomUUID())));
  }

  /**
   * Test
   * {@link DefaultExportableEntitiesService#findEntityByTenantIdAndName(TenantId, EntityType, String)}.
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#findEntityByTenantIdAndName(TenantId, EntityType, String)}
   */
  @Test
  @DisplayName("Test findEntityByTenantIdAndName(TenantId, EntityType, String)")
  void testFindEntityByTenantIdAndName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    // Act and Assert
    assertNull(defaultExportableEntitiesService.findEntityByTenantIdAndName(new TenantId(UUID.randomUUID()),
        EntityType.TENANT, "Name"));
  }

  /**
   * Test
   * {@link DefaultExportableEntitiesService#findDefaultEntityByTenantId(TenantId, EntityType)}.
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#findDefaultEntityByTenantId(TenantId, EntityType)}
   */
  @Test
  @DisplayName("Test findDefaultEntityByTenantId(TenantId, EntityType)")
  void testFindDefaultEntityByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    // Act and Assert
    assertNull(defaultExportableEntitiesService.findDefaultEntityByTenantId(new TenantId(UUID.randomUUID()),
        EntityType.TENANT));
  }

  /**
   * Test
   * {@link DefaultExportableEntitiesService#findEntitiesByTenantId(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#findEntitiesByTenantId(TenantId, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test findEntitiesByTenantId(TenantId, EntityType, PageLink)")
  void testFindEntitiesByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<ExportableEntity<EntityId>> actualFindEntitiesByTenantIdResult = defaultExportableEntitiesService
        .findEntitiesByTenantId(tenantId, EntityType.TENANT, new PageLink(3));

    // Assert
    assertSame(actualFindEntitiesByTenantIdResult.EMPTY_PAGE_DATA, actualFindEntitiesByTenantIdResult);
  }

  /**
   * Test
   * {@link DefaultExportableEntitiesService#findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)}.
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)}
   */
  @Test
  @DisplayName("Test findEntitiesIdsByTenantId(TenantId, EntityType, PageLink)")
  void testFindEntitiesIdsByTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    PageData<EntityId> actualFindEntitiesIdsByTenantIdResult = defaultExportableEntitiesService
        .findEntitiesIdsByTenantId(tenantId, EntityType.TENANT, new PageLink(3));

    // Assert
    assertSame(actualFindEntitiesIdsByTenantIdResult.EMPTY_PAGE_DATA, actualFindEntitiesIdsByTenantIdResult);
  }

  /**
   * Test
   * {@link DefaultExportableEntitiesService#getExternalIdByInternal(EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#getExternalIdByInternal(EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdByInternal(EntityId); when AlarmId(UUID) with id is randomUUID; then return 'null'")
  void testGetExternalIdByInternal_whenAlarmIdWithIdIsRandomUUID_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));

    // Act and Assert
    assertNull(defaultExportableEntitiesService.getExternalIdByInternal(new AlarmId(UUID.randomUUID())));
  }

  /**
   * Test {@link DefaultExportableEntitiesService#removeById(TenantId, EntityId)}.
   * <ul>
   *   <li>Then calls
   * {@link EntityServiceRegistry#getServiceByEntityType(EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultExportableEntitiesService#removeById(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test removeById(TenantId, EntityId); then calls getServiceByEntityType(EntityType)")
  void testRemoveById_thenCallsGetServiceByEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultNotificationRequestService defaultNotificationRequestService = mock(DefaultNotificationRequestService.class);
    doNothing().when(defaultNotificationRequestService)
        .deleteEntity(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyBoolean());
    EntityServiceRegistry entityServiceRegistry = mock(EntityServiceRegistry.class);
    when(entityServiceRegistry.getServiceByEntityType(Mockito.<EntityType>any()))
        .thenReturn(defaultNotificationRequestService);
    DefaultExportableEntitiesService defaultExportableEntitiesService = new DefaultExportableEntitiesService(
        entityServiceRegistry,
        new DefaultAccessControlService(mock(Permissions.class), mock(Permissions.class), mock(Permissions.class)));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    defaultExportableEntitiesService.removeById(tenantId, new AlarmId(UUID.randomUUID()));

    // Assert
    verify(entityServiceRegistry).getServiceByEntityType(eq(EntityType.ALARM));
    verify(defaultNotificationRequestService).deleteEntity(isA(TenantId.class), isA(EntityId.class), eq(false));
  }
}
