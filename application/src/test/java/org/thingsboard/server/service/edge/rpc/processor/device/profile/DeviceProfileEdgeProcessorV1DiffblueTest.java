package org.thingsboard.server.service.edge.rpc.processor.device.profile;

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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceProfileUpdateMsg;

class DeviceProfileEdgeProcessorV1DiffblueTest {
  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)")
  void testSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV1.setDefaultRuleChainId(tenantId, deviceProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, deviceProfile.getDefaultRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfile#setDefaultRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV1#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId); then calls setDefaultRuleChainId(RuleChainId)")
  void testSetDefaultRuleChainId_thenCallsSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setDefaultRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV1.setDefaultRuleChainId(tenantId, deviceProfile, ruleChainId);

    // Assert that nothing has changed
    verify(deviceProfile).setDefaultRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)")
  void testSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    DeviceProfile deviceProfile = new DeviceProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(deviceProfile, ruleChainId,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(ruleChainId, deviceProfile.getDefaultEdgeRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>Then calls
   * {@link DeviceProfile#setDefaultEdgeRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV1#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg); then calls setDefaultEdgeRuleChainId(RuleChainId)")
  void testSetDefaultEdgeRuleChainId_thenCallsSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setDefaultEdgeRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV1.setDefaultEdgeRuleChainId(deviceProfile, ruleChainId,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(deviceProfile).setDefaultEdgeRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} DefaultDashboardId is
   * {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); then DeviceProfile() DefaultDashboardId is DashboardId")
  void testSetDefaultDashboardId_thenDeviceProfileDefaultDashboardIdIsDashboardId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DashboardId dashboardId = mock(DashboardId.class);
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfileEdgeProcessorV1.setDefaultDashboardId(tenantId, dashboardId, deviceProfile,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(dashboardId, deviceProfile.getDefaultDashboardId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} DefaultDashboardId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV1#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); when 'null'; then DeviceProfile() DefaultDashboardId is 'null'")
  void testSetDefaultDashboardId_whenNull_thenDeviceProfileDefaultDashboardIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfileEdgeProcessorV1.setDefaultDashboardId(tenantId, null, deviceProfile,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
  }
}
