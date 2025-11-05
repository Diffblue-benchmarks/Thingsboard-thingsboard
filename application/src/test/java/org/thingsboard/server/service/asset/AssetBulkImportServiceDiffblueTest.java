package org.thingsboard.server.service.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;

class AssetBulkImportServiceDiffblueTest {
  /**
   * Test {@link AssetBulkImportService#getEntityType()}.
   *
   * <p>Method under test: {@link AssetBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AssetBulkImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());

    AssetBulkImportService assetBulkImportService =
        new AssetBulkImportService(assetService, tbAssetService, new AssetProfileServiceImpl());

    // Act and Assert
    assertEquals(EntityType.ASSET, assetBulkImportService.getEntityType());
  }
}
