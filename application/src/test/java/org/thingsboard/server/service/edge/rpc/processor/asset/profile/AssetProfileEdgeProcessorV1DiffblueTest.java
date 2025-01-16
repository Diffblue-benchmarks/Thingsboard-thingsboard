package org.thingsboard.server.service.edge.rpc.processor.asset.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetProfileUpdateMsg;

class AssetProfileEdgeProcessorV1DiffblueTest {
  /**
   * Test
   * {@link AssetProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)")
  void testSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1 = new AssetProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV1.setDefaultRuleChainId(tenantId, assetProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, assetProfile.getDefaultRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}.
   * <ul>
   *   <li>Then calls {@link AssetProfile#setDefaultRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId); then calls setDefaultRuleChainId(RuleChainId)")
  void testSetDefaultRuleChainId_thenCallsSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1 = new AssetProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setDefaultRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV1.setDefaultRuleChainId(tenantId, assetProfile, ruleChainId);

    // Assert that nothing has changed
    verify(assetProfile).setDefaultRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)")
  void testSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1 = new AssetProfileEdgeProcessorV1();
    AssetProfile assetProfile = new AssetProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(assetProfile, ruleChainId,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(ruleChainId, assetProfile.getDefaultEdgeRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>Then calls
   * {@link AssetProfile#setDefaultEdgeRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg); then calls setDefaultEdgeRuleChainId(RuleChainId)")
  void testSetDefaultEdgeRuleChainId_thenCallsSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1 = new AssetProfileEdgeProcessorV1();
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setDefaultEdgeRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(assetProfile, ruleChainId,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(assetProfile).setDefaultEdgeRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>Then {@link AssetProfile#AssetProfile()} DefaultDashboardId is
   * {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); then AssetProfile() DefaultDashboardId is DashboardId")
  void testSetDefaultDashboardId_thenAssetProfileDefaultDashboardIdIsDashboardId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1 = new AssetProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DashboardId dashboardId = mock(DashboardId.class);
    AssetProfile assetProfile = new AssetProfile();

    // Act
    assetProfileEdgeProcessorV1.setDefaultDashboardId(tenantId, dashboardId, assetProfile,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(dashboardId, assetProfile.getDefaultDashboardId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link AssetProfile#AssetProfile()} DefaultDashboardId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); when 'null'; then AssetProfile() DefaultDashboardId is 'null'")
  void testSetDefaultDashboardId_whenNull_thenAssetProfileDefaultDashboardIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV1 assetProfileEdgeProcessorV1 = new AssetProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();

    // Act
    assetProfileEdgeProcessorV1.setDefaultDashboardId(tenantId, null, assetProfile,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertNull(assetProfile.getDefaultDashboardId());
  }
}
