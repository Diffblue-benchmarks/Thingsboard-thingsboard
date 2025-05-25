package org.thingsboard.server.service.edge.rpc.processor.asset;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetUpdateMsg;

@ExtendWith(MockitoExtension.class)
class AssetEdgeProcessorV2DiffblueTest {
  @InjectMocks
  private AssetEdgeProcessorV2 assetEdgeProcessorV2;

  /**
   * Test {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <p>
   * Method under test: {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEdgeProcessorV2.setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)"})
  void testSetCustomerId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Asset asset = new Asset();
    CustomerId customerId2 = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    asset.setCustomerId(customerId2);

    // Act
    assetEdgeProcessorV2.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    assertSame(customerId2, asset.getCustomerId());
  }

  /**
   * Test {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}.
   * <ul>
   *   <li>When {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg); when Asset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEdgeProcessorV2.setCustomerId(TenantId, CustomerId, Asset, AssetUpdateMsg)"})
  void testSetCustomerId_whenAsset() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Asset asset = new Asset();

    // Act
    assetEdgeProcessorV2.setCustomerId(tenantId, customerId, asset, AssetUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, asset.getCustomerId());
  }
}
