package org.thingsboard.server.service.entitiy.asset.profile;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileService;

class DefaultTbAssetProfileServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbAssetProfileService#setDefaultAssetProfile(AssetProfile, AssetProfile, User)}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileService#setDefaultAssetProfile(AssetProfile, AssetProfile, User)}
   */
  @Test
  @DisplayName("Test setDefaultAssetProfile(AssetProfile, AssetProfile, User); then return AssetProfile()")
  void testSetDefaultAssetProfile_thenReturnAssetProfile() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileService assetProfileService = mock(AssetProfileService.class);
    when(assetProfileService.setDefaultAssetProfile(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(false);
    DefaultTbAssetProfileService defaultTbAssetProfileService = new DefaultTbAssetProfileService(assetProfileService);
    AssetProfile assetProfile = new AssetProfile();
    AssetProfile previousDefaultAssetProfile = new AssetProfile();

    // Act
    AssetProfile actualSetDefaultAssetProfileResult = defaultTbAssetProfileService.setDefaultAssetProfile(assetProfile,
        previousDefaultAssetProfile, new User());

    // Assert
    verify(assetProfileService).setDefaultAssetProfile(isNull(), isNull());
    assertSame(assetProfile, actualSetDefaultAssetProfileResult);
  }
}
