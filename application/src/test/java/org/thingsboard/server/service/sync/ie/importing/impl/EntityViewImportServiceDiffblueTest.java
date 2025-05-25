package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class EntityViewImportServiceDiffblueTest {
  @InjectMocks
  private EntityViewImportService entityViewImportService;

  /**
   * Test {@link EntityViewImportService#setOwner(TenantId, EntityView, IdProvider)}.
   * <p>
   * Method under test: {@link EntityViewImportService#setOwner(TenantId, EntityView, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, EntityView, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewImportService.setOwner(TenantId, EntityView, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityView entityView = new EntityView();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entityViewImportService.setOwner(tenantId, entityView,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, entityView.getTenantId());
  }

  /**
   * Test {@link EntityViewImportService#setOwner(TenantId, EntityView, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityView} {@link EntityView#getCustomerId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#setOwner(TenantId, EntityView, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, EntityView, IdProvider); given 'null'; when EntityView getCustomerId() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewImportService.setOwner(TenantId, EntityView, IdProvider)"})
  void testSetOwner_givenNull_whenEntityViewGetCustomerIdReturnNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId()).thenReturn(null);
    doNothing().when(entityView).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(entityView).setTenantId(Mockito.<TenantId>any());
    entityView.setCustomerId(new CustomerId(UUID.randomUUID()));
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    entityViewImportService.setOwner(tenantId, entityView,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(entityView).getCustomerId();
    verify(entityView, atLeast(1)).setCustomerId(Mockito.<CustomerId>any());
    verify(entityView).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link EntityViewImportService#setOwner(TenantId, EntityView, IdProvider)}.
   * <ul>
   *   <li>Then calls {@link EntitiesImportCtx#getInternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#setOwner(TenantId, EntityView, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, EntityView, IdProvider); then calls getInternalId(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewImportService.setOwner(TenantId, EntityView, IdProvider)"})
  void testSetOwner_thenCallsGetInternalId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityView entityView = mock(EntityView.class);
    when(entityView.getCustomerId())
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(entityView).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(entityView).setTenantId(Mockito.<TenantId>any());
    entityView.setCustomerId(new CustomerId(UUID.randomUUID()));
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getInternalId(Mockito.<EntityId>any()))
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());

    // Act
    entityViewImportService.setOwner(tenantId, entityView,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(entityView).getCustomerId();
    verify(entityView, atLeast(1)).setCustomerId(Mockito.<CustomerId>any());
    verify(entityView).setTenantId(isA(TenantId.class));
    verify(ctx).getInternalId(isA(EntityId.class));
  }

  /**
   * Test {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link AlarmId} {@link EntityId#isNullUid()} return {@code false}.</li>
   *   <li>Then calls {@link AlarmId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider); given AlarmId isNullUid() return 'false'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityView EntityViewImportService.prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)"})
  void testPrepare_givenAlarmIdIsNullUidReturnFalse_thenCallsGetEntityType() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.isNullUid()).thenReturn(false);
    when(alarmId.getEntityType()).thenReturn(EntityType.TENANT);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenReturn(alarmId);
    doNothing().when(entityView).setEntityId(Mockito.<EntityId>any());
    EntityView old = new EntityView();
    EntityExportData<EntityView> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    EntityView actualPrepareResult = entityViewImportService.prepare(ctx, entityView, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(entityView).getEntityId();
    verify(entityView).setEntityId(isNull());
    verify(alarmId).getEntityType();
    verify(alarmId).isNullUid();
    assertSame(entityView, actualPrepareResult);
  }

  /**
   * Test {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link AlarmId} {@link EntityId#isNullUid()} return {@code true}.</li>
   *   <li>Then calls {@link EntityId#isNullUid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider); given AlarmId isNullUid() return 'true'; then calls isNullUid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityView EntityViewImportService.prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)"})
  void testPrepare_givenAlarmIdIsNullUidReturnTrue_thenCallsIsNullUid() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    AlarmId alarmId = mock(AlarmId.class);
    when(alarmId.isNullUid()).thenReturn(true);
    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenReturn(alarmId);
    doNothing().when(entityView).setEntityId(Mockito.<EntityId>any());
    EntityView old = new EntityView();
    EntityExportData<EntityView> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    EntityView actualPrepareResult = entityViewImportService.prepare(ctx, entityView, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(entityView).getEntityId();
    verify(entityView).setEntityId(isNull());
    verify(alarmId).isNullUid();
    assertSame(entityView, actualPrepareResult);
  }

  /**
   * Test {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link EntityView} {@link EntityView#getEntityId()} return {@code null}.</li>
   *   <li>Then return {@link EntityView}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider); given 'null'; when EntityView getEntityId() return 'null'; then return EntityView")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityView EntityViewImportService.prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)"})
  void testPrepare_givenNull_whenEntityViewGetEntityIdReturnNull_thenReturnEntityView() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityView entityView = mock(EntityView.class);
    when(entityView.getEntityId()).thenReturn(null);
    doNothing().when(entityView).setEntityId(Mockito.<EntityId>any());
    EntityView old = new EntityView();
    EntityExportData<EntityView> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    EntityView actualPrepareResult = entityViewImportService.prepare(ctx, entityView, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(entityView).getEntityId();
    verify(entityView).setEntityId(isNull());
    assertSame(entityView, actualPrepareResult);
  }

  /**
   * Test {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider); then return EntityView()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EntityView EntityViewImportService.prepare(EntitiesImportCtx, EntityView, EntityView, EntityExportData, IdProvider)"})
  void testPrepare_thenReturnEntityView() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityView entityView = new EntityView();
    EntityView old = new EntityView();
    EntityExportData<EntityView> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(entityView, entityViewImportService.prepare(ctx, entityView, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link EntityViewImportService#deepCopy(EntityView)} with {@code EntityView}.
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#deepCopy(EntityView)}
   */
  @Test
  @DisplayName("Test deepCopy(EntityView) with 'EntityView'; when EntityView(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityView EntityViewImportService.deepCopy(EntityView)"})
  void testDeepCopyWithEntityView_whenEntityView_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EntityView actualDeepCopyResult = entityViewImportService.deepCopy(new EntityView());

    // Assert
    assertTrue(actualDeepCopyResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getEntityId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getKeys());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(0L, actualDeepCopyResult.getEndTimeMs());
    assertEquals(0L, actualDeepCopyResult.getStartTimeMs());
  }

  /**
   * Test {@link EntityViewImportService#cleanupForComparison(EntityView)} with {@code EntityView}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewImportService#cleanupForComparison(EntityView)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(EntityView) with 'EntityView'; then calls setCreatedTime(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewImportService.cleanupForComparison(EntityView)"})
  void testCleanupForComparisonWithEntityView_thenCallsSetCreatedTime() {
    // Arrange
    EntityView e = mock(EntityView.class);
    when(e.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(e).setCreatedTime(anyLong());
    doNothing().when(e).setTenantId(Mockito.<TenantId>any());
    doNothing().when(e).setVersion(Mockito.<Long>any());

    // Act
    entityViewImportService.cleanupForComparison(e);

    // Assert
    verify(e).setCreatedTime(eq(0L));
    verify(e, atLeast(1)).getCustomerId();
    verify(e).setTenantId(isNull());
    verify(e).setVersion(isNull());
  }

  /**
   * Test {@link EntityViewImportService#getEntityType()}.
   * <p>
   * Method under test: {@link EntityViewImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType EntityViewImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ENTITY_VIEW, (new EntityViewImportService(new EntityViewServiceImpl())).getEntityType());
  }
}
