package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class AssetProfileImportServiceDiffblueTest {
  @InjectMocks
  private AssetProfileImportService assetProfileImportService;

  /**
   * Test {@link AssetProfileImportService#setOwner(TenantId, AssetProfile, IdProvider)}.
   * <p>
   * Method under test: {@link AssetProfileImportService#setOwner(TenantId, AssetProfile, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, AssetProfile, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileImportService.setOwner(TenantId, AssetProfile, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetProfileImportService.setOwner(tenantId, assetProfile,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, assetProfile.getTenantId());
  }

  /**
   * Test {@link AssetProfileImportService#setOwner(TenantId, AssetProfile, IdProvider)}.
   * <ul>
   *   <li>When {@link AssetProfile} {@link AssetProfile#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link AssetProfile#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileImportService#setOwner(TenantId, AssetProfile, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, AssetProfile, IdProvider); when AssetProfile setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileImportService.setOwner(TenantId, AssetProfile, IdProvider)"})
  void testSetOwner_whenAssetProfileSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    assetProfileImportService.setOwner(tenantId, assetProfile,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(assetProfile).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileImportService#prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then {@link AssetProfile#AssetProfile()} DefaultRuleChainId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileImportService#prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider); then AssetProfile() DefaultRuleChainId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "AssetProfile AssetProfileImportService.prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider)"})
  void testPrepare_thenAssetProfileDefaultRuleChainIdIsNull() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    AssetProfile assetProfile = new AssetProfile();
    AssetProfile old = new AssetProfile();
    EntityExportData<AssetProfile> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    AssetProfile actualPrepareResult = assetProfileImportService.prepare(ctx, assetProfile, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    assertNull(assetProfile.getDefaultRuleChainId());
    assertSame(assetProfile, actualPrepareResult);
  }

  /**
   * Test {@link AssetProfileImportService#prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>When {@link AssetProfile#AssetProfile()} DefaultRuleChainId is {@link RuleChainId}.</li>
   *   <li>Then calls {@link EntityId#isNullUid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileImportService#prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider); when AssetProfile() DefaultRuleChainId is RuleChainId; then calls isNullUid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "AssetProfile AssetProfileImportService.prepare(EntitiesImportCtx, AssetProfile, AssetProfile, EntityExportData, IdProvider)"})
  void testPrepare_whenAssetProfileDefaultRuleChainIdIsRuleChainId_thenCallsIsNullUid() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    RuleChainId defaultRuleChainId = mock(RuleChainId.class);
    when(defaultRuleChainId.isNullUid()).thenReturn(true);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultRuleChainId(defaultRuleChainId);
    AssetProfile old = new AssetProfile();
    EntityExportData<AssetProfile> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    AssetProfile actualPrepareResult = assetProfileImportService.prepare(ctx, assetProfile, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(defaultRuleChainId).isNullUid();
    assertNull(assetProfile.getDefaultRuleChainId());
    assertSame(assetProfile, actualPrepareResult);
  }

  /**
   * Test {@link AssetProfileImportService#deepCopy(AssetProfile)} with {@code AssetProfile}.
   * <ul>
   *   <li>When {@link AssetProfile#AssetProfile()}.</li>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileImportService#deepCopy(AssetProfile)}
   */
  @Test
  @DisplayName("Test deepCopy(AssetProfile) with 'AssetProfile'; when AssetProfile(); then return AssetProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileImportService.deepCopy(AssetProfile)"})
  void testDeepCopyWithAssetProfile_whenAssetProfile_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfileImportService.deepCopy(assetProfile));
  }

  /**
   * Test {@link AssetProfileImportService#cleanupForComparison(AssetProfile)} with {@code AssetProfile}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileImportService#cleanupForComparison(AssetProfile)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(AssetProfile) with 'AssetProfile'; then calls setCreatedTime(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileImportService.cleanupForComparison(AssetProfile)"})
  void testCleanupForComparisonWithAssetProfile_thenCallsSetCreatedTime() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setCreatedTime(anyLong());
    doNothing().when(assetProfile).setTenantId(Mockito.<TenantId>any());
    doNothing().when(assetProfile).setVersion(Mockito.<Long>any());

    // Act
    assetProfileImportService.cleanupForComparison(assetProfile);

    // Assert
    verify(assetProfile).setCreatedTime(eq(0L));
    verify(assetProfile).setTenantId(isNull());
    verify(assetProfile).setVersion(isNull());
  }

  /**
   * Test {@link AssetProfileImportService#getEntityType()}.
   * <p>
   * Method under test: {@link AssetProfileImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType AssetProfileImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE,
        (new AssetProfileImportService(new AssetProfileServiceImpl())).getEntityType());
  }
}
