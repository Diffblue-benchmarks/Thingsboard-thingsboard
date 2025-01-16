package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings.EntityExportSettingsBuilder;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class DefaultEntityExportServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <p>
   * Method under test:
   * {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)")
  void testSetAdditionalExportData() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService = new DefaultEntityExportService<>();
    ComplexEntitiesExportCtx ctx = mock(ComplexEntitiesExportCtx.class);
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(false)
        .build();
    when(ctx.getSettings()).thenReturn(buildResult);
    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntityExportService.setAdditionalExportData(ctx, exportableEntity, new EntityExportData<>()));
    verify(exportableEntity).getId();
    verify(ctx).getSettings();
  }

  /**
   * Test
   * {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link EntitiesExportCtx#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); given TenantId(UUID) with id is randomUUID; then calls getTenantId()")
  void testSetAdditionalExportData_givenTenantIdWithIdIsRandomUUID_thenCallsGetTenantId() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService = new DefaultEntityExportService<>();
    ComplexEntitiesExportCtx ctx = mock(ComplexEntitiesExportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    when(ctx.getSettings()).thenReturn(buildResult);
    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntityExportService.setAdditionalExportData(ctx, exportableEntity, new EntityExportData<>()));
    verify(exportableEntity).getId();
    verify(ctx).getSettings();
    verify(ctx).getTenantId();
  }

  /**
   * Test
   * {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Then calls
   * {@link EntityExportSettingsBuilder#exportAttributes(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); then calls exportAttributes(boolean)")
  void testSetAdditionalExportData_thenCallsExportAttributes() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService = new DefaultEntityExportService<>();
    EntityExportSettings.EntityExportSettingsBuilder entityExportSettingsBuilder = mock(
        EntityExportSettings.EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(false)
        .build();
    ComplexEntitiesExportCtx ctx = mock(ComplexEntitiesExportCtx.class);
    when(ctx.getSettings()).thenReturn(buildResult);
    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);

    // Act
    defaultEntityExportService.setAdditionalExportData(ctx, exportableEntity, new EntityExportData<>());

    // Assert that nothing has changed
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(ctx).getSettings();
  }

  /**
   * Test
   * {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternal(EntitiesExportCtx, EntityId); given HashMap(); when 'null'; then return 'null'")
  void testGetExternalIdOrElseInternal_givenHashMap_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService = new DefaultEntityExportService<>();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EntityId actualExternalIdOrElseInternal = defaultEntityExportService.getExternalIdOrElseInternal(
        new ComplexEntitiesExportCtx(user, new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request),
        null);

    // Assert
    verify(request).getEntityTypes();
    assertNull(actualExternalIdOrElseInternal);
  }

  /**
   * Test
   * {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternal(EntitiesExportCtx, EntityId); given 'true'; then return AlarmId")
  void testGetExternalIdOrElseInternal_givenTrue_thenReturnAlarmId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService = new DefaultEntityExportService<>();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.isNullUid()).thenReturn(true);

    // Act
    EntityId actualExternalIdOrElseInternal = defaultEntityExportService.getExternalIdOrElseInternal(ctx, alarmId);

    // Assert
    verify(alarmId).isNullUid();
    verify(request).getEntityTypes();
    assertSame(alarmId, actualExternalIdOrElseInternal);
  }

  /**
   * Test
   * {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}.
   * <ul>
   *   <li>Then return randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID); then return randomUUID")
  void testGetExternalIdOrElseInternalByUuid_thenReturnRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService = new DefaultEntityExportService<>();
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    UUID id = UUID.randomUUID();
    when(ctx.getExternalId(Mockito.<EntityId>any())).thenReturn(new AlarmId(id));

    // Act
    UUID actualExternalIdOrElseInternalByUuid = defaultEntityExportService.getExternalIdOrElseInternalByUuid(ctx,
        UUID.randomUUID());

    // Assert
    verify(ctx).getExternalId(isA(TenantId.class));
    assertSame(id, actualExternalIdOrElseInternalByUuid);
  }
}
