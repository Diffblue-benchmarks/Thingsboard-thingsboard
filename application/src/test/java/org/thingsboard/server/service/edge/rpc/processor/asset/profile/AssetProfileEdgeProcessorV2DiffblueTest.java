package org.thingsboard.server.service.edge.rpc.processor.asset.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.AssetProfileUpdateMsg;

class AssetProfileEdgeProcessorV2DiffblueTest {
  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)")
  void testSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV2.setDefaultRuleChainId(tenantId, assetProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, assetProfile.getDefaultRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}.
   * <ul>
   *   <li>Then calls {@link AssetProfile#setDefaultRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, AssetProfile, RuleChainId); then calls setDefaultRuleChainId(RuleChainId)")
  void testSetDefaultRuleChainId_thenCallsSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setDefaultRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV2.setDefaultRuleChainId(tenantId, assetProfile, ruleChainId);

    // Assert that nothing has changed
    verify(assetProfile).setDefaultRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)")
  void testSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    AssetProfile assetProfile = new AssetProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(assetProfile, ruleChainId,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(ruleChainId, assetProfile.getDefaultEdgeRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>Then {@link AssetProfile#AssetProfile()} DefaultEdgeRuleChainId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg); then AssetProfile() DefaultEdgeRuleChainId is 'null'")
  void testSetDefaultEdgeRuleChainId_thenAssetProfileDefaultEdgeRuleChainIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    AssetProfile assetProfile = new AssetProfile();

    // Act
    assetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(assetProfile, null,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertNull(assetProfile.getDefaultEdgeRuleChainId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>Then calls
   * {@link AssetProfile#setDefaultEdgeRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(AssetProfile, RuleChainId, AssetProfileUpdateMsg); then calls setDefaultEdgeRuleChainId(RuleChainId)")
  void testSetDefaultEdgeRuleChainId_thenCallsSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    AssetProfile assetProfile = mock(AssetProfile.class);
    doNothing().when(assetProfile).setDefaultEdgeRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    assetProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(assetProfile, ruleChainId,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    verify(assetProfile).setDefaultEdgeRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)")
  void testSetDefaultDashboardId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DashboardId dashboardId = mock(DashboardId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(dashboardId.getId()).thenReturn(randomUUIDResult);
    AssetProfile assetProfile = new AssetProfile();

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, dashboardId, assetProfile,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    verify(dashboardId).getId();
    DashboardId defaultDashboardId = assetProfile.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    assertFalse(defaultDashboardId.isNullUid());
    assertSame(randomUUIDResult, defaultDashboardId.getId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>Given {@link DashboardId#DashboardId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); given DashboardId(UUID) with id is randomUUID")
  void testSetDefaultDashboardId_givenDashboardIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    AssetProfile assetProfile = new AssetProfile();
    DashboardId defaultDashboardId = new DashboardId(UUID.randomUUID());
    assetProfile.setDefaultDashboardId(defaultDashboardId);

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, null, assetProfile,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(defaultDashboardId, assetProfile.getDefaultDashboardId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link AssetProfile#AssetProfile()} DefaultDashboardId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); given 'null'; then AssetProfile() DefaultDashboardId is 'null'")
  void testSetDefaultDashboardId_givenNull_thenAssetProfileDefaultDashboardIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefaultDashboardId(null);

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, null, assetProfile,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertNull(assetProfile.getDefaultDashboardId());
  }

  /**
   * Test
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, AssetProfile, AssetProfileUpdateMsg); when DashboardId(UUID) with id is randomUUID")
  void testSetDefaultDashboardId_whenDashboardIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEdgeProcessorV2 assetProfileEdgeProcessorV2 = new AssetProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DashboardId dashboardId = new DashboardId(UUID.randomUUID());
    AssetProfile assetProfile = new AssetProfile();

    // Act
    assetProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, dashboardId, assetProfile,
        AssetProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(dashboardId, assetProfile.getDefaultDashboardId());
  }
}
