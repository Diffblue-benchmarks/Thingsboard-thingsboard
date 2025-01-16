package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class AssetExportServiceDiffblueTest {
  /**
   * Test
   * {@link AssetExportService#setRelatedEntities(EntitiesExportCtx, Asset, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code Asset}, {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link AssetExportService#setRelatedEntities(EntitiesExportCtx, Asset, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, Asset, EntityExportData) with 'EntitiesExportCtx', 'Asset', 'EntityExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxAssetEntityExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetExportService assetExportService = new AssetExportService();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    User user = mock(User.class);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(user,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    Asset asset = new Asset();

    // Act
    assetExportService.setRelatedEntities(ctx, asset, new EntityExportData<>());

    // Assert
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link AssetExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link AssetExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new AssetExportService()).getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.ASSET));
  }
}
