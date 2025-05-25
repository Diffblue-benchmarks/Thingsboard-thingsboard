package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.BaseAssetService;

@ExtendWith(MockitoExtension.class)
class AssetImportServiceDiffblueTest {
  @InjectMocks
  private AssetImportService assetImportService;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetImportService.deepCopy(Asset)"})
  void testDeepCopyWithAsset_whenAssetWithAssetIsAsset_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Asset actualDeepCopyResult = assetImportService.deepCopy(new Asset(new Asset()));

    // Assert
    assertTrue(actualDeepCopyResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getAssetProfileId());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetImportService.deepCopy(Asset)"})
  void testDeepCopyWithAsset_whenAsset_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Asset actualDeepCopyResult = assetImportService.deepCopy(new Asset());

    // Assert
    assertTrue(actualDeepCopyResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getAssetProfileId());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
  }

  /**
   * Test {@link AssetImportService#cleanupForComparison(Asset)} with {@code Asset}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetImportService#cleanupForComparison(Asset)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(Asset) with 'Asset'; then calls setCreatedTime(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetImportService.cleanupForComparison(Asset)"})
  void testCleanupForComparisonWithAsset_thenCallsSetCreatedTime() {
    // Arrange
    Asset e = mock(Asset.class);
    when(e.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(e).setCreatedTime(anyLong());
    doNothing().when(e).setTenantId(Mockito.<TenantId>any());
    doNothing().when(e).setVersion(Mockito.<Long>any());

    // Act
    assetImportService.cleanupForComparison(e);

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType AssetImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET, (new AssetImportService(new BaseAssetService())).getEntityType());
  }
}
