package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;

class AssetProfileImportServiceDiffblueTest {
  /**
   * Test {@link AssetProfileImportService#deepCopy(AssetProfile)} with
   * {@code AssetProfile}.
   * <p>
   * Method under test: {@link AssetProfileImportService#deepCopy(AssetProfile)}
   */
  @Test
  @DisplayName("Test deepCopy(AssetProfile) with 'AssetProfile'")
  void testDeepCopyWithAssetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileImportService assetProfileImportService = new AssetProfileImportService(
        mock(AssetProfileService.class));
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfileImportService.deepCopy(assetProfile));
  }

  /**
   * Test {@link AssetProfileImportService#deepCopy(AssetProfile)} with
   * {@code AssetProfile}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileImportService#deepCopy(AssetProfile)}
   */
  @Test
  @DisplayName("Test deepCopy(AssetProfile) with 'AssetProfile'; then return AssetProfile()")
  void testDeepCopyWithAssetProfile_thenReturnAssetProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileImportService assetProfileImportService = new AssetProfileImportService(new AssetProfileServiceImpl());
    AssetProfile assetProfile = new AssetProfile();

    // Act and Assert
    assertEquals(assetProfile, assetProfileImportService.deepCopy(assetProfile));
  }

  /**
   * Test {@link AssetProfileImportService#cleanupForComparison(AssetProfile)}
   * with {@code AssetProfile}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileImportService#cleanupForComparison(AssetProfile)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(AssetProfile) with 'AssetProfile'; then calls setCreatedTime(long)")
  void testCleanupForComparisonWithAssetProfile_thenCallsSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileImportService assetProfileImportService = new AssetProfileImportService(new AssetProfileServiceImpl());
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setCreatedTime(anyLong());
    doNothing().when(assetProfile).setTenantId(Mockito.<TenantId>any());
    doNothing().when(assetProfile).setVersion(Mockito.<Long>any());

    // Act
    assetProfileImportService.cleanupForComparison(assetProfile);

    // Assert that nothing has changed
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
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE,
        (new AssetProfileImportService(new AssetProfileServiceImpl())).getEntityType());
  }
}
