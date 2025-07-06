package org.thingsboard.server.service.edge.rpc.processor.asset.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetProfileUpdateMsg;

@ExtendWith(MockitoExtension.class)
class AssetProfileEdgeProcessorV2DiffblueTest {
  @InjectMocks private AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2;

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, AssetProfile,
   * RuleChainId)}.
   *
   * <p>Method under test: {@link AssetProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId,
   * AssetProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)"
  })
  void testSetDefaultRuleChainId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AssetProfile assetProfile = new AssetProfile();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileEdgeProcessorV2.setDefaultRuleChainId(tenantId, assetProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, assetProfile.getDefaultRuleChainId());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId,
   * AssetProfileUpdateMsg)}.
   *
   * <p>Method under test: {@link
   * AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId,
   * AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)"
  })
  void testSetDefaultEdgeRuleChainId() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    RuleChainId ruleChainId =
        new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(
        assetProfile, ruleChainId, AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(ruleChainId, assetProfile.getDefaultEdgeRuleChainId());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId,
   * AssetProfileUpdateMsg)}.
   *
   * <ul>
   *   <li>Then {@link AssetProfile#AssetProfile()} DefaultEdgeRuleChainId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId,
   * AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg); then AssetProfile() DefaultEdgeRuleChainId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)"
  })
  void testSetDefaultEdgeRuleChainId_thenAssetProfileDefaultEdgeRuleChainIdIsNull() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();

    // Act
    assetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(
        assetProfile, null, AssetProfileUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    assertNull(assetProfile.getDefaultEdgeRuleChainId());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * AssetProfile, AssetProfileUpdateMsg)}.
   *
   * <p>Method under test: {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setDefaultDashboardId(null);
    AssetProfileUpdateMsg assetProfileUpdateMsg = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, null, assetProfile, assetProfileUpdateMsg);

    // Assert that nothing has changed
    FileDescriptorProto defaultInstanceForType =
        assetProfileUpdateMsg
            .getDescriptorForType()
            .getFile()
            .toProto()
            .getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertEquals(0, defaultInstanceForType.getMessageTypeCount());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * AssetProfile, AssetProfileUpdateMsg)}.
   *
   * <p>Method under test: {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    DashboardId defaultDashboardId =
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetProfile.setDefaultDashboardId(defaultDashboardId);

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, null, assetProfile, AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(defaultDashboardId, assetProfile.getDefaultDashboardId());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * AssetProfile, AssetProfileUpdateMsg)}.
   *
   * <ul>
   *   <li>Given {@link DashboardId#DashboardId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); given DashboardId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId_givenDashboardIdWithIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setDefaultDashboardId(new DashboardId(null));
    AssetProfileUpdateMsg assetProfileUpdateMsg = AssetProfileUpdateMsg.getDefaultInstance();

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, null, assetProfile, assetProfileUpdateMsg);

    // Assert
    FileDescriptorProto defaultInstanceForType =
        assetProfileUpdateMsg
            .getDescriptorForType()
            .getFile()
            .toProto()
            .getDefaultInstanceForType();
    assertEquals("", defaultInstanceForType.getInitializationErrorString());
    assertNull(assetProfile.getDefaultDashboardId());
    assertEquals(0, defaultInstanceForType.getMessageTypeCount());
  }

  /**
   * Test {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * AssetProfile, AssetProfileUpdateMsg)}.
   *
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); when DashboardId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AssetProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId_whenDashboardIdWithIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DashboardId dashboardId = new DashboardId(null);

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setDefaultDashboardId(null);

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, dashboardId, assetProfile, AssetProfileUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    assertNull(assetProfile.getDefaultDashboardId());
  }
}
