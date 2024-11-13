package org.thingsboard.server.service.edge.rpc.processor.asset;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;

class AssetEdgeProcessorV1DiffblueTest {
  /**
   * Test
   * {@link AssetEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <ul>
   *   <li>When {@link Asset} {@link Asset#setCustomerId(CustomerId)} does
   * nothing.</li>
   *   <li>Then calls {@link Asset#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg); when Asset setCustomerId(CustomerId) does nothing; then calls setCustomerId(CustomerId)")
  void testSetCustomerId_whenAssetSetCustomerIdDoesNothing_thenCallsSetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetEdgeProcessorV1 assetEdgeProcessorV1 = new AssetEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Asset asset = mock(Asset.class);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());

    // Act
    assetEdgeProcessorV1.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(asset).setCustomerId(isA(CustomerId.class));
  }

  /**
   * Test
   * {@link AssetEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   *   <li>Then {@link Asset#Asset()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg); when Asset(); then Asset() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenAsset_thenAssetCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetEdgeProcessorV1 assetEdgeProcessorV1 = new AssetEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Asset asset = new Asset();

    // Act
    assetEdgeProcessorV1.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, asset.getCustomerId());
  }
}
