package org.thingsboard.server.service.edge.rpc.processor.asset;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;

class AssetEdgeProcessorV2DiffblueTest {
  /**
   * Test
   * {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <ul>
   *   <li>Then calls {@link Asset#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg); then calls getCustomerId()")
  void testSetCustomerId_thenCallsGetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetEdgeProcessorV2 assetEdgeProcessorV2 = new AssetEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    when(asset.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());

    // Act
    assetEdgeProcessorV2.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(asset, atLeast(1)).getCustomerId();
    verify(asset).setCustomerId(isA(CustomerId.class));
  }

  /**
   * Test
   * {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <ul>
   *   <li>When {@link Asset#Asset()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg); when Asset() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenAssetCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetEdgeProcessorV2 assetEdgeProcessorV2 = new AssetEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    Asset asset = new Asset();
    CustomerId customerId2 = new CustomerId(UUID.randomUUID());
    asset.setCustomerId(customerId2);

    // Act
    assetEdgeProcessorV2.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId2, asset.getCustomerId());
  }

  /**
   * Test
   * {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   *   <li>Then {@link Asset#Asset()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg); when Asset(); then Asset() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenAsset_thenAssetCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetEdgeProcessorV2 assetEdgeProcessorV2 = new AssetEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Asset asset = new Asset();

    // Act
    assetEdgeProcessorV2.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, asset.getCustomerId());
  }
}
