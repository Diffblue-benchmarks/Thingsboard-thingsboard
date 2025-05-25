package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.EntityTypeVersionCreateConfig;
import org.thingsboard.server.common.data.sync.vc.request.create.SyncStrategy;
import org.thingsboard.server.service.sync.ie.exporting.ExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntityTypeExportCtx;

@ExtendWith(MockitoExtension.class)
class DefaultEntityExportServiceDiffblueTest {
  @InjectMocks
  private DefaultEntityExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> defaultEntityExportService;

  @Mock
  private ExportableEntitiesService exportableEntitiesService;

  /**
   * Test {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void DefaultEntityExportService.setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)"})
  void testSetAdditionalExportData_thenThrowIllegalArgumentException() throws ThingsboardException {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx parent = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    EntityTypeVersionCreateConfig config = new EntityTypeVersionCreateConfig();
    config.setAllEntities(true);
    config.setEntityIds(new ArrayList<>());
    config.setSaveAttributes(true);
    config.setSaveCredentials(true);
    config.setSaveRelations(true);
    config.setSyncStrategy(SyncStrategy.MERGE);
    EntityTypeExportCtx ctx = new EntityTypeExportCtx(parent, config, SyncStrategy.MERGE, EntityType.TENANT);

    ExportableEntity<EntityId> exportableEntity = mock(ExportableEntity.class);
    when(exportableEntity.getId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultEntityExportService.setAdditionalExportData(ctx, exportableEntity, new EntityExportData<>()));
    verify(exportableEntity).getId();
  }

  /**
   * Test {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}.
   * <p>
   * Method under test: {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId DefaultEntityExportService.getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)"})
  void testGetExternalIdOrElseInternal() {
    // Arrange
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<AlarmId>any())).thenReturn(null);

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    AlarmId alarmId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntityId actualExternalIdOrElseInternal = defaultEntityExportService.getExternalIdOrElseInternal(ctx, alarmId);

    // Assert
    verify(exportableEntitiesService).getExternalIdByInternal(isA(AlarmId.class));
    assertEquals(1, ctx.getExternalIdMap().size());
    assertSame(alarmId, actualExternalIdOrElseInternal);
  }

  /**
   * Test {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}.
   * <ul>
   *   <li>Given {@code janedoe/featurebranch}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternal(EntitiesExportCtx, EntityId); given 'janedoe/featurebranch'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId DefaultEntityExportService.getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)"})
  void testGetExternalIdOrElseInternal_givenJanedoeFeaturebranch_thenReturnNull() {
    // Arrange
    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    // Act and Assert
    assertNull(defaultEntityExportService.getExternalIdOrElseInternal(ctx, null));
    assertTrue(ctx.getExternalIdMap().isEmpty());
  }

  /**
   * Test {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityExportService#getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternal(EntitiesExportCtx, EntityId); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId DefaultEntityExportService.getExternalIdOrElseInternal(EntitiesExportCtx, EntityId)"})
  void testGetExternalIdOrElseInternal_thenThrowIllegalArgumentException() {
    // Arrange
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<AlarmId>any()))
        .thenThrow(new IllegalArgumentException("[{}][{}] Local cache {} for id"));

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultEntityExportService.getExternalIdOrElseInternal(ctx,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(exportableEntitiesService).getExternalIdByInternal(isA(AlarmId.class));
  }

  /**
   * Test {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}.
   * <p>
   * Method under test: {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID DefaultEntityExportService.getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)"})
  void testGetExternalIdOrElseInternalByUuid() {
    // Arrange
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<EntityId>any())).thenReturn(null);

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    UUID internalUuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    UUID actualExternalIdOrElseInternalByUuid = defaultEntityExportService.getExternalIdOrElseInternalByUuid(ctx,
        internalUuid);

    // Assert
    verify(exportableEntitiesService, atLeast(1)).getExternalIdByInternal(Mockito.<EntityId>any());
    assertTrue(ctx.getExternalIdMap().isEmpty());
    assertSame(internalUuid, actualExternalIdOrElseInternalByUuid);
  }

  /**
   * Test {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}.
   * <p>
   * Method under test: {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID DefaultEntityExportService.getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)"})
  void testGetExternalIdOrElseInternalByUuid2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<EntityId>any())).thenReturn(new AlarmId(id));

    ComplexVersionCreateRequest request = new ComplexVersionCreateRequest();
    request.setBranch("janedoe/featurebranch");
    request.setEntityTypes(new HashMap<>());
    request.setSyncStrategy(SyncStrategy.MERGE);
    request.setVersionName("1.0.2");
    User user = new User();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    // Act
    UUID actualExternalIdOrElseInternalByUuid = defaultEntityExportService.getExternalIdOrElseInternalByUuid(ctx,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(exportableEntitiesService).getExternalIdByInternal(isA(TenantId.class));
    assertEquals(1, ctx.getExternalIdMap().size());
    assertSame(id, actualExternalIdOrElseInternalByUuid);
  }

  /**
   * Test {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}.
   * <ul>
   *   <li>Then calls {@link EntitiesExportCtx#getExternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultEntityExportService#getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)}
   */
  @Test
  @DisplayName("Test getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID); then calls getExternalId(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID DefaultEntityExportService.getExternalIdOrElseInternalByUuid(EntitiesExportCtx, UUID)"})
  void testGetExternalIdOrElseInternalByUuid_thenCallsGetExternalId() {
    // Arrange
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(ctx.getExternalId(Mockito.<EntityId>any())).thenReturn(new AlarmId(id));

    // Act
    UUID actualExternalIdOrElseInternalByUuid = defaultEntityExportService.getExternalIdOrElseInternalByUuid(ctx,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(ctx).getExternalId(isA(TenantId.class));
    assertSame(id, actualExternalIdOrElseInternalByUuid);
  }

  /**
   * Test {@link DefaultEntityExportService#newExportData()}.
   * <p>
   * Method under test: {@link DefaultEntityExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData DefaultEntityExportService.newExportData()"})
  void testNewExportData() {
    // Arrange and Act
    EntityExportData<ExportableEntity<EntityId>> actualNewExportDataResult = defaultEntityExportService.newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getEntity());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasRelations());
  }
}
