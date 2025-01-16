package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.sync.ie.AttributeExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.common.data.util.ThrowingRunnable;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class BaseEntityImportServiceDiffblueTest {
  /**
   * Test IdProvider {@link IdProvider#getInternalId(EntityId, boolean)} with
   * {@code externalId}, {@code throwExceptionIfNotFound}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService.IdProvider#getInternalId(EntityId, boolean)}
   */
  @Test
  @DisplayName("Test IdProvider getInternalId(EntityId, boolean) with 'externalId', 'throwExceptionIfNotFound'; then return 'null'")
  void testIdProviderGetInternalIdWithExternalIdThrowExceptionIfNotFound_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).addRelations(Mockito.<Collection<EntityRelation>>any());
    ctx.addRelations(new ArrayList<>());
    AssetImportService assetImportService = new AssetImportService(mock(BaseAssetService.class));

    // Act
    EntityId actualInternalId = (assetImportService.new IdProvider(ctx, new EntityImportResult())).getInternalId(null,
        true);

    // Assert
    verify(ctx).addRelations(isA(Collection.class));
    assertNull(actualInternalId);
  }

  /**
   * Test IdProvider {@link IdProvider#getInternalId(EntityId)} with
   * {@code externalId}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService.IdProvider#getInternalId(EntityId)}
   */
  @Test
  @DisplayName("Test IdProvider getInternalId(EntityId) with 'externalId'; when 'null'; then return 'null'")
  void testIdProviderGetInternalIdWithExternalId_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    doNothing().when(ctx).addRelations(Mockito.<Collection<EntityRelation>>any());
    ctx.addRelations(new ArrayList<>());
    AssetImportService assetImportService = new AssetImportService(mock(BaseAssetService.class));

    // Act
    EntityId actualInternalId = (assetImportService.new IdProvider(ctx, new EntityImportResult())).getInternalId(null);

    // Assert
    verify(ctx).addRelations(isA(Collection.class));
    assertNull(actualInternalId);
  }

  /**
   * Test
   * {@link BaseEntityImportService#updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, ExportableEntity, EntityExportData, IdProvider)}.
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, ExportableEntity, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, ExportableEntity, EntityExportData, IdProvider)")
  void testUpdateRelatedEntitiesIfUnmodified() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset = new Asset();
    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertFalse(assetImportService.updateRelatedEntitiesIfUnmodified(ctx, asset, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test
   * {@link BaseEntityImportService#updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, ExportableEntity, EntityExportData, IdProvider)}.
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, ExportableEntity, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, ExportableEntity, EntityExportData, IdProvider)")
  void testUpdateRelatedEntitiesIfUnmodified2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(mock(BaseAssetService.class));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset = new Asset();
    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertFalse(assetImportService.updateRelatedEntitiesIfUnmodified(ctx, asset, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}.
   * <ul>
   *   <li>Given {@link AssetImportService#AssetImportService(AssetService)} with
   * {@link AssetService}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity); given AssetImportService(AssetService) with AssetService; then return 'false'")
  void testCompare_givenAssetImportServiceWithAssetService_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(mock(AssetService.class));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    Asset asset = new Asset();

    // Act and Assert
    assertFalse(assetImportService.compare(ctx, entityExportData, asset, new Asset()));
  }

  /**
   * Test
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}.
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity); given CustomerId(UUID) with id is randomUUID; then return 'true'")
  void testCompare_givenCustomerIdWithIdIsRandomUUID_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Asset> entityExportData = new EntityExportData<>();

    Asset asset = new Asset();
    asset.setCustomerId(new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(assetImportService.compare(ctx, entityExportData, asset, new Asset()));
  }

  /**
   * Test
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity); then return 'false'")
  void testCompare_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    Asset asset = new Asset();

    // Act and Assert
    assertFalse(assetImportService.compare(ctx, entityExportData, asset, new Asset()));
  }

  /**
   * Test
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}.
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity); when Asset(Asset) with asset is Asset(); then return 'false'")
  void testCompare_whenAssetWithAssetIsAsset_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    Asset asset = new Asset(new Asset());

    // Act and Assert
    assertFalse(assetImportService.compare(ctx, entityExportData, asset, new Asset()));
  }

  /**
   * Test
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}.
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, ExportableEntity, ExportableEntity); when Asset(Asset) with asset is Asset(); then return 'false'")
  void testCompare_whenAssetWithAssetIsAsset_thenReturnFalse2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    Asset asset = new Asset();

    // Act and Assert
    assertFalse(assetImportService.compare(ctx, entityExportData, asset, new Asset(new Asset())));
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link EntityExportData#getRelations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); given HashMap() '42' is ArrayList(); then calls getRelations()")
  void testProcessAfterSaved_givenHashMap42IsArrayList_thenCallsGetRelations() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getUser()).thenReturn(new User());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());

    HashMap<String, List<AttributeExportData>> stringListMap = new HashMap<>();
    stringListMap.put("42", new ArrayList<>());
    stringListMap.put("foo", new ArrayList<>());
    EntityExportData<Asset> entityExportData = mock(EntityExportData.class);
    when(entityExportData.getRelations()).thenReturn(new ArrayList<>());
    when(entityExportData.getAttributes()).thenReturn(stringListMap);
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(entityExportData, atLeast(1)).getAttributes();
    verify(entityExportData, atLeast(1)).getRelations();
    verify(importResult, atLeast(1)).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult, atLeast(1)).getSavedEntity();
    verify(importResult).isCreated();
    verify(ctx).getTenantId();
    verify(ctx).getUser();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link EntityExportData#getRelations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); given HashMap() 'foo' is ArrayList(); then calls getRelations()")
  void testProcessAfterSaved_givenHashMapFooIsArrayList_thenCallsGetRelations() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getUser()).thenReturn(new User());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());

    HashMap<String, List<AttributeExportData>> stringListMap = new HashMap<>();
    stringListMap.put("foo", new ArrayList<>());
    EntityExportData<Asset> entityExportData = mock(EntityExportData.class);
    when(entityExportData.getRelations()).thenReturn(new ArrayList<>());
    when(entityExportData.getAttributes()).thenReturn(stringListMap);
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(entityExportData, atLeast(1)).getAttributes();
    verify(entityExportData, atLeast(1)).getRelations();
    verify(importResult, atLeast(1)).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult, atLeast(1)).getSavedEntity();
    verify(importResult).isCreated();
    verify(ctx).getTenantId();
    verify(ctx).getUser();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link EntityExportData#getRelations()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); given HashMap(); then calls getRelations()")
  void testProcessAfterSaved_givenHashMap_thenCallsGetRelations() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getUser()).thenReturn(new User());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());
    EntityExportData<Asset> entityExportData = mock(EntityExportData.class);
    when(entityExportData.getRelations()).thenReturn(new ArrayList<>());
    when(entityExportData.getAttributes()).thenReturn(new HashMap<>());
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(entityExportData, atLeast(1)).getAttributes();
    verify(entityExportData, atLeast(1)).getRelations();
    verify(importResult, atLeast(1)).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult, atLeast(1)).getSavedEntity();
    verify(importResult).isCreated();
    verify(ctx).getTenantId();
    verify(ctx).getUser();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link EntityImportResult} (default constructor).</li>
   *   <li>Then calls {@link EntitiesImportCtx#isSaveAttributes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); given 'true'; when EntityImportResult (default constructor); then calls isSaveAttributes()")
  void testProcessAfterSaved_givenTrue_whenEntityImportResult_thenCallsIsSaveAttributes() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = new EntityImportResult<>();
    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then calls
   * {@link EntityImportResult#addSendEventsCallback(ThrowingRunnable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); then calls addSendEventsCallback(ThrowingRunnable)")
  void testProcessAfterSaved_thenCallsAddSendEventsCallback() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());
    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult).getSavedEntity();
    verify(importResult).isCreated();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then calls {@link EntityImportResult#isUpdated()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); then calls isUpdated()")
  void testProcessAfterSaved_thenCallsIsUpdated() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(false);
    when(importResult.isUpdated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());
    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult).getSavedEntity();
    verify(importResult).isCreated();
    verify(importResult).isUpdated();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then calls
   * {@link EntityImportResult#setUpdatedRelatedEntities(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); then calls setUpdatedRelatedEntities(boolean)")
  void testProcessAfterSaved_thenCallsSetUpdatedRelatedEntities() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getUser()).thenReturn(new User());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(true);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).setUpdatedRelatedEntities(anyBoolean());
    doNothing().when(importResult).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());

    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    ArrayList<AttributeExportData> attributeExportDataList = new ArrayList<>();
    attributeExportDataList.add(attributeExportData);

    HashMap<String, List<AttributeExportData>> stringListMap = new HashMap<>();
    stringListMap.put("foo", attributeExportDataList);
    EntityExportData<Asset> entityExportData = mock(EntityExportData.class);
    when(entityExportData.getRelations()).thenReturn(new ArrayList<>());
    when(entityExportData.getAttributes()).thenReturn(stringListMap);
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.processAfterSaved(ctx, importResult, entityExportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert that nothing has changed
    verify(entityExportData, atLeast(1)).getAttributes();
    verify(entityExportData, atLeast(1)).getRelations();
    verify(importResult, atLeast(1)).addSaveReferencesCallback(Mockito.<ThrowingRunnable>any());
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult, atLeast(1)).getSavedEntity();
    verify(importResult).isCreated();
    verify(importResult).setUpdatedRelatedEntities(eq(true));
    verify(ctx).getTenantId();
    verify(ctx).getUser();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>When {@link EntitiesImportCtx}
   * {@link EntitiesImportCtx#isUpdateRelations()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); when EntitiesImportCtx isUpdateRelations() return 'false'")
  void testProcessAfterSaved_whenEntitiesImportCtxIsUpdateRelationsReturnFalse() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.isSaveAttributes()).thenReturn(true);
    when(ctx.isUpdateRelations()).thenReturn(false);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doNothing().when(importResult).addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());
    EntityExportData<Asset> entityExportData = mock(EntityExportData.class);
    when(entityExportData.getAttributes()).thenThrow(new IllegalArgumentException("foo"));
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> assetImportService.processAfterSaved(ctx, importResult,
        entityExportData, assetImportService2.new IdProvider(ctx2, new EntityImportResult())));
    verify(entityExportData).getAttributes();
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult).getSavedEntity();
    verify(importResult).isCreated();
    verify(ctx).isSaveAttributes();
    verify(ctx).isUpdateRelations();
  }

  /**
   * Test
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>When {@link EntitiesImportCtx}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test processAfterSaved(EntitiesImportCtx, EntityImportResult, EntityExportData, IdProvider); when EntitiesImportCtx; then throw IllegalArgumentException")
  void testProcessAfterSaved_whenEntitiesImportCtx_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    EntityImportResult<Asset> importResult = mock(EntityImportResult.class);
    doThrow(new IllegalArgumentException("foo")).when(importResult)
        .addSendEventsCallback(Mockito.<ThrowingRunnable>any());
    when(importResult.isCreated()).thenReturn(true);
    when(importResult.getOldEntity()).thenReturn(new Asset());
    when(importResult.getSavedEntity()).thenReturn(new Asset());
    EntityExportData<Asset> entityExportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId, new User(), "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> assetImportService.processAfterSaved(ctx, importResult,
        entityExportData, assetImportService2.new IdProvider(ctx2, new EntityImportResult())));
    verify(importResult).addSendEventsCallback(isA(ThrowingRunnable.class));
    verify(importResult).getOldEntity();
    verify(importResult).getSavedEntity();
    verify(importResult).isCreated();
  }

  /**
   * Test {@link BaseEntityImportService#getOldEntityField(Object, Function)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#getOldEntityField(Object, Function)}
   */
  @Test
  @DisplayName("Test getOldEntityField(Object, Function); given 'null'; when Function apply(Object) return 'null'; then return 'null'")
  void testGetOldEntityField_givenNull_whenFunctionApplyReturnNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    Function<Object, EntityId> getter = mock(Function.class);
    when(getter.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    EntityId actualOldEntityField = assetImportService.getOldEntityField("Old Entity", getter);

    // Assert
    verify(getter).apply(isA(Object.class));
    assertNull(actualOldEntityField);
  }

  /**
   * Test {@link BaseEntityImportService#getOldEntityField(Object, Function)}.
   * <ul>
   *   <li>Then throw {@link MissingEntityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#getOldEntityField(Object, Function)}
   */
  @Test
  @DisplayName("Test getOldEntityField(Object, Function); then throw MissingEntityException")
  void testGetOldEntityField_thenThrowMissingEntityException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    Function<Object, EntityId> getter = mock(Function.class);
    when(getter.apply(Mockito.<Object>any())).thenThrow(new MissingEntityException(null));

    // Act and Assert
    assertThrows(MissingEntityException.class, () -> assetImportService.getOldEntityField("Old Entity", getter));
    verify(getter).apply(isA(Object.class));
  }

  /**
   * Test {@link BaseEntityImportService#getOldEntityField(Object, Function)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEntityImportService#getOldEntityField(Object, Function)}
   */
  @Test
  @DisplayName("Test getOldEntityField(Object, Function); when 'null'; then return 'null'")
  void testGetOldEntityField_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AssetImportService(new BaseAssetService())).<EntityId, Object>getOldEntityField(null,
        mock(Function.class)));
  }
}
