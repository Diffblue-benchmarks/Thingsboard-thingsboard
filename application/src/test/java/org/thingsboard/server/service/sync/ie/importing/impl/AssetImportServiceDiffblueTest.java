package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class AssetImportServiceDiffblueTest {
  /**
   * Test {@link AssetImportService#setOwner(TenantId, Asset, IdProvider)}.
   * <ul>
   *   <li>Given {@link AssetImportService#AssetImportService(AssetService)} with
   * {@link AssetService}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#setOwner(TenantId, Asset, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Asset, IdProvider); given AssetImportService(AssetService) with AssetService")
  void testSetOwner_givenAssetImportServiceWithAssetService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(mock(AssetService.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Asset asset = new Asset();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.setOwner(tenantId, asset, assetImportService2.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, asset.getTenantId());
  }

  /**
   * Test {@link AssetImportService#setOwner(TenantId, Asset, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Asset} {@link Asset#getCustomerId()} return
   * {@code null}.</li>
   *   <li>Then calls {@link Asset#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#setOwner(TenantId, Asset, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Asset, IdProvider); given 'null'; when Asset getCustomerId() return 'null'; then calls getCustomerId()")
  void testSetOwner_givenNull_whenAssetGetCustomerIdReturnNull_thenCallsGetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(null);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(asset).setTenantId(Mockito.<TenantId>any());
    asset.setCustomerId(new CustomerId(null));
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.setOwner(tenantId, asset, assetImportService2.new IdProvider(ctx, new EntityImportResult()));

    // Assert that nothing has changed
    verify(asset).getCustomerId();
    verify(asset, atLeast(1)).setCustomerId(Mockito.<CustomerId>any());
    verify(asset).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link AssetImportService#setOwner(TenantId, Asset, IdProvider)}.
   * <ul>
   *   <li>Then calls {@link EntitiesImportCtx#getInternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#setOwner(TenantId, Asset, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Asset, IdProvider); then calls getInternalId(EntityId)")
  void testSetOwner_thenCallsGetInternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(asset).setTenantId(Mockito.<TenantId>any());
    asset.setCustomerId(new CustomerId(null));
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getInternalId(Mockito.<EntityId>any())).thenReturn(new CustomerId(UUID.randomUUID()));
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());

    // Act
    assetImportService.setOwner(tenantId, asset, assetImportService2.new IdProvider(ctx, new EntityImportResult()));

    // Assert that nothing has changed
    verify(asset).getCustomerId();
    verify(asset, atLeast(1)).setCustomerId(Mockito.<CustomerId>any());
    verify(asset).setTenantId(isA(TenantId.class));
    verify(ctx).getInternalId(isA(EntityId.class));
  }

  /**
   * Test {@link AssetImportService#setOwner(TenantId, Asset, IdProvider)}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   *   <li>Then {@link Asset#Asset()} TenantId is {@link TenantId#TenantId(UUID)}
   * with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#setOwner(TenantId, Asset, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Asset, IdProvider); when Asset(); then Asset() TenantId is TenantId(UUID) with id is randomUUID")
  void testSetOwner_whenAsset_thenAssetTenantIdIsTenantIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Asset asset = new Asset();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetImportService.setOwner(tenantId, asset, assetImportService2.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, asset.getTenantId());
  }

  /**
   * Test
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link AssetImportService#AssetImportService(AssetService)} with
   * {@link AssetService}.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider); given AssetImportService(AssetService) with AssetService; then return Asset()")
  void testPrepare_givenAssetImportServiceWithAssetService_thenReturnAsset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(mock(AssetService.class));
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset = new Asset();
    Asset old = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(asset, assetImportService.prepare(ctx, asset, old, exportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link AssetProfileId} {@link EntityId#isNullUid()} return
   * {@code false}.</li>
   *   <li>Then calls {@link AssetProfileId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider); given AssetProfileId isNullUid() return 'false'; then calls getEntityType()")
  void testPrepare_givenAssetProfileIdIsNullUidReturnFalse_thenCallsGetEntityType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.isNullUid()).thenReturn(false);
    when(assetProfileId.getEntityType()).thenReturn(EntityType.TENANT);
    Asset asset = mock(Asset.class);
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    doNothing().when(asset).setAssetProfileId(Mockito.<AssetProfileId>any());
    Asset old = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Asset actualPrepareResult = assetImportService.prepare(ctx, asset, old, exportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(asset).getAssetProfileId();
    verify(asset).setAssetProfileId(isNull());
    verify(assetProfileId).getEntityType();
    verify(assetProfileId).isNullUid();
    assertSame(asset, actualPrepareResult);
  }

  /**
   * Test
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link AssetProfileId} {@link EntityId#isNullUid()} return
   * {@code true}.</li>
   *   <li>Then calls {@link EntityId#isNullUid()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider); given AssetProfileId isNullUid() return 'true'; then calls isNullUid()")
  void testPrepare_givenAssetProfileIdIsNullUidReturnTrue_thenCallsIsNullUid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.isNullUid()).thenReturn(true);
    Asset asset = mock(Asset.class);
    when(asset.getAssetProfileId()).thenReturn(assetProfileId);
    doNothing().when(asset).setAssetProfileId(Mockito.<AssetProfileId>any());
    Asset old = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Asset actualPrepareResult = assetImportService.prepare(ctx, asset, old, exportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(asset).getAssetProfileId();
    verify(asset).setAssetProfileId(isNull());
    verify(assetProfileId).isNullUid();
    assertSame(asset, actualPrepareResult);
  }

  /**
   * Test
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link AssetProfileId}.</li>
   *   <li>Then calls {@link IdProvider#getInternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider); given AssetProfileId; then calls getInternalId(EntityId)")
  void testPrepare_givenAssetProfileId_thenCallsGetInternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset = mock(Asset.class);
    when(asset.getAssetProfileId()).thenReturn(mock(AssetProfileId.class));
    doNothing().when(asset).setAssetProfileId(Mockito.<AssetProfileId>any());
    Asset old = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    BaseEntityImportService<AssetId, Asset, EntityExportData<Asset>>.IdProvider idProvider = mock(
        BaseEntityImportService.IdProvider.class);
    when(idProvider.getInternalId(Mockito.<EntityId>any())).thenReturn(null);

    // Act
    Asset actualPrepareResult = assetImportService.prepare(ctx, asset, old, exportData, idProvider);

    // Assert
    verify(asset).getAssetProfileId();
    verify(asset).setAssetProfileId(isNull());
    verify(idProvider).getInternalId(isA(EntityId.class));
    assertSame(asset, actualPrepareResult);
  }

  /**
   * Test
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Asset} {@link Asset#getAssetProfileId()} return
   * {@code null}.</li>
   *   <li>Then return {@link Asset}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider); given 'null'; when Asset getAssetProfileId() return 'null'; then return Asset")
  void testPrepare_givenNull_whenAssetGetAssetProfileIdReturnNull_thenReturnAsset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset = mock(Asset.class);
    when(asset.getAssetProfileId()).thenReturn(null);
    doNothing().when(asset).setAssetProfileId(Mockito.<AssetProfileId>any());
    Asset old = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Asset actualPrepareResult = assetImportService.prepare(ctx, asset, old, exportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(asset).getAssetProfileId();
    verify(asset).setAssetProfileId(isNull());
    assertSame(asset, actualPrepareResult);
  }

  /**
   * Test
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Asset, Asset, EntityExportData, IdProvider); then return Asset()")
  void testPrepare_thenReturnAsset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset = new Asset();
    Asset old = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(asset, assetImportService.prepare(ctx, asset, old, exportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test
   * {@link AssetImportService#saveOrUpdate(EntitiesImportCtx, Asset, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link BaseAssetService} {@link BaseAssetService#saveAsset(Asset)}
   * return {@link Asset#Asset()}.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetImportService#saveOrUpdate(EntitiesImportCtx, Asset, EntityExportData, BaseEntityImportService.IdProvider)}
   */
  @Test
  @DisplayName("Test saveOrUpdate(EntitiesImportCtx, Asset, EntityExportData, IdProvider); given BaseAssetService saveAsset(Asset) return Asset(); then return Asset()")
  void testSaveOrUpdate_givenBaseAssetServiceSaveAssetReturnAsset_thenReturnAsset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = mock(BaseAssetService.class);
    Asset asset = new Asset();
    when(assetService.saveAsset(Mockito.<Asset>any())).thenReturn(asset);
    AssetImportService assetImportService = new AssetImportService(assetService);
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Asset asset2 = new Asset();
    EntityExportData<Asset> exportData = new EntityExportData<>();
    AssetImportService assetImportService2 = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.randomUUID();
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Asset actualSaveOrUpdateResult = assetImportService.saveOrUpdate(ctx, asset2, exportData,
        assetImportService2.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(assetService).saveAsset(isA(Asset.class));
    assertSame(asset, actualSaveOrUpdateResult);
  }

  /**
   * Test {@link AssetImportService#deepCopy(Asset)} with {@code Asset}.
   * <ul>
   *   <li>Given {@link AssetImportService#AssetImportService(AssetService)} with
   * {@link AssetService}.</li>
   *   <li>When {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetImportService#deepCopy(Asset)}
   */
  @Test
  @DisplayName("Test deepCopy(Asset) with 'Asset'; given AssetImportService(AssetService) with AssetService; when Asset()")
  void testDeepCopyWithAsset_givenAssetImportServiceWithAssetService_whenAsset() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(mock(AssetService.class));

    // Act
    Asset actualDeepCopyResult = assetImportService.deepCopy(new Asset());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDeepCopyResult.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getAssetProfileId());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetImportService#deepCopy(Asset)} with {@code Asset}.
   * <ul>
   *   <li>When {@link Asset#Asset(Asset)} with asset is {@link Asset#Asset()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetImportService#deepCopy(Asset)}
   */
  @Test
  @DisplayName("Test deepCopy(Asset) with 'Asset'; when Asset(Asset) with asset is Asset(); then AdditionalInfo return NullNode")
  void testDeepCopyWithAsset_whenAssetWithAssetIsAsset_thenAdditionalInfoReturnNullNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());

    // Act
    Asset actualDeepCopyResult = assetImportService.deepCopy(new Asset(new Asset()));

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDeepCopyResult.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getAssetProfileId());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetImportService#deepCopy(Asset)} with {@code Asset}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetImportService#deepCopy(Asset)}
   */
  @Test
  @DisplayName("Test deepCopy(Asset) with 'Asset'; when Asset(); then AdditionalInfo return NullNode")
  void testDeepCopyWithAsset_whenAsset_thenAdditionalInfoReturnNullNode() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());

    // Act
    Asset actualDeepCopyResult = assetImportService.deepCopy(new Asset());

    // Assert
    JsonNode additionalInfo = actualDeepCopyResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualDeepCopyResult.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getAssetProfileId());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AssetImportService#cleanupForComparison(Asset)} with
   * {@code Asset}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetImportService#cleanupForComparison(Asset)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(Asset) with 'Asset'; then calls setCreatedTime(long)")
  void testCleanupForComparisonWithAsset_thenCallsSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    Asset e = mock(Asset.class);
    when(e.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(e).setCreatedTime(anyLong());
    doNothing().when(e).setTenantId(Mockito.<TenantId>any());
    doNothing().when(e).setVersion(Mockito.<Long>any());

    // Act
    assetImportService.cleanupForComparison(e);

    // Assert that nothing has changed
    verify(e).setCreatedTime(eq(0L));
    verify(e, atLeast(1)).getCustomerId();
    verify(e).setTenantId(isNull());
    verify(e).setVersion(isNull());
  }

  /**
   * Test {@link AssetImportService#getEntityType()}.
   * <p>
   * Method under test: {@link AssetImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET, (new AssetImportService(new BaseAssetService())).getEntityType());
  }
}
