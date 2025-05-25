package org.thingsboard.server.service.edge.rpc.processor.asset.profile;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetProfileUpdateMsg;

@ExtendWith(MockitoExtension.class)
class AssetProfileEdgeProcessorV1DiffblueTest {
  @InjectMocks
  private AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1;

  /**
   * Test {@link AssetProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}.
   * <p>
   * Method under test: {@link AssetProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileEdgeProcessorV1.setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)"})
  void testSetDefaultRuleChainId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileEdgeProcessorV1.setDefaultRuleChainId(tenantId, assetProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, assetProfile.getDefaultRuleChainId());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}.
   * <p>
   * Method under test: {@link AssetProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void AssetProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)"})
  void testSetDefaultEdgeRuleChainId() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    RuleChainId ruleChainId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(assetProfile, ruleChainId,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(ruleChainId, assetProfile.getDefaultEdgeRuleChainId());
  }
}
