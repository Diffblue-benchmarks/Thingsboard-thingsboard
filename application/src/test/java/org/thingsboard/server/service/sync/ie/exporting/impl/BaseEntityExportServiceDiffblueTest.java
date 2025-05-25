package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings.EntityExportSettingsBuilder;
import org.thingsboard.server.dao.relation.RelationDao;
import org.thingsboard.server.service.sync.ie.exporting.ExportableEntitiesService;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

@ExtendWith(MockitoExtension.class)
class BaseEntityExportServiceDiffblueTest {
  @InjectMocks
  private AssetExportService assetExportService;

  @Mock
  private ExportableEntitiesService exportableEntitiesService;

  @Mock
  private RelationDao relationDao;

  /**
   * Test {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link EntitiesExportCtx#putExternalId(EntityId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); given 'null'; then calls putExternalId(EntityId, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BaseEntityExportService.setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)"})
  void testSetAdditionalExportData_givenNull_thenCallsPutExternalId() throws ThingsboardException {
    // Arrange
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<EntityId>any())).thenReturn(null);
    when(exportableEntitiesService.getExternalIdByInternal(Mockito.<CustomerId>any()))
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(relationDao.findAllByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.findAllByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    EntityExportSettingsBuilder entityExportSettingsBuilder = mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getExternalId(Mockito.<CustomerId>any())).thenReturn(null);
    doNothing().when(ctx).putExternalId(Mockito.<EntityId>any(), Mockito.<EntityId>any());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getSettings()).thenReturn(buildResult);

    Asset asset = new Asset();
    asset.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    EntityExportData<Asset> entityExportData = new EntityExportData<>();

    // Act
    assetExportService.setAdditionalExportData(ctx, asset, entityExportData);

    // Assert
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(relationDao).findAllByFrom(isA(TenantId.class), isNull(), eq(RelationTypeGroup.COMMON));
    verify(relationDao).findAllByTo(isA(TenantId.class), isNull(), eq(RelationTypeGroup.COMMON));
    verify(exportableEntitiesService, atLeast(1)).getExternalIdByInternal(isA(CustomerId.class));
    verify(ctx).getExternalId(isA(CustomerId.class));
    verify(ctx).getSettings();
    verify(ctx, atLeast(1)).getTenantId();
    verify(ctx).putExternalId(isA(EntityId.class), isA(EntityId.class));
    assertTrue(entityExportData.getRelations().isEmpty());
    assertTrue(entityExportData.hasRelations());
  }

  /**
   * Test {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Then {@link EntityExportData} (default constructor) Relations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); then EntityExportData (default constructor) Relations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BaseEntityExportService.setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)"})
  void testSetAdditionalExportData_thenEntityExportDataRelationsEmpty() throws ThingsboardException {
    // Arrange
    when(relationDao.findAllByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.findAllByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    EntityExportSettingsBuilder entityExportSettingsBuilder = mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getSettings()).thenReturn(buildResult);
    Asset asset = new Asset();
    EntityExportData<Asset> entityExportData = new EntityExportData<>();

    // Act
    assetExportService.setAdditionalExportData(ctx, asset, entityExportData);

    // Assert
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(relationDao).findAllByFrom(isA(TenantId.class), isNull(), eq(RelationTypeGroup.COMMON));
    verify(relationDao).findAllByTo(isA(TenantId.class), isNull(), eq(RelationTypeGroup.COMMON));
    verify(ctx).getSettings();
    verify(ctx, atLeast(1)).getTenantId();
    assertTrue(entityExportData.getRelations().isEmpty());
    assertTrue(entityExportData.hasRelations());
  }

  /**
   * Test {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Then {@link EntityExportData} (default constructor) Relations is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); then EntityExportData (default constructor) Relations is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BaseEntityExportService.setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)"})
  void testSetAdditionalExportData_thenEntityExportDataRelationsIsArrayList() throws ThingsboardException {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.findAllByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.findAllByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    EntityExportSettingsBuilder entityExportSettingsBuilder = mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getSettings()).thenReturn(buildResult);
    Asset asset = new Asset();
    EntityExportData<Asset> entityExportData = new EntityExportData<>();

    // Act
    assetExportService.setAdditionalExportData(ctx, asset, entityExportData);

    // Assert
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(relationDao).findAllByFrom(isA(TenantId.class), isNull(), eq(RelationTypeGroup.COMMON));
    verify(relationDao).findAllByTo(isA(TenantId.class), isNull(), eq(RelationTypeGroup.COMMON));
    verify(ctx).getSettings();
    verify(ctx, atLeast(1)).getTenantId();
    assertEquals(entityRelationList, entityExportData.getRelations());
  }

  /**
   * Test {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}.
   * <ul>
   *   <li>Then not {@link EntityExportData} (default constructor) hasRelations.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEntityExportService#setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)}
   */
  @Test
  @DisplayName("Test setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData); then not EntityExportData (default constructor) hasRelations")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BaseEntityExportService.setAdditionalExportData(EntitiesExportCtx, ExportableEntity, EntityExportData)"})
  void testSetAdditionalExportData_thenNotEntityExportDataHasRelations() throws ThingsboardException {
    // Arrange
    EntityExportSettingsBuilder entityExportSettingsBuilder = mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(false)
        .build();
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getSettings()).thenReturn(buildResult);
    Asset asset = new Asset();
    EntityExportData<Asset> entityExportData = new EntityExportData<>();

    // Act
    assetExportService.setAdditionalExportData(ctx, asset, entityExportData);

    // Assert that nothing has changed
    verify(entityExportSettingsBuilder).exportAttributes(eq(true));
    verify(ctx).getSettings();
    assertFalse(entityExportData.hasRelations());
  }

  /**
   * Test {@link BaseEntityExportService#newExportData()}.
   * <p>
   * Method under test: {@link BaseEntityExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityExportData BaseEntityExportService.newExportData()"})
  void testNewExportData() {
    // Arrange and Act
    EntityExportData<Asset> actualNewExportDataResult = (new AssetExportService()).newExportData();

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
