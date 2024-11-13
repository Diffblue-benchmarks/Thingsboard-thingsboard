package org.thingsboard.server.service.edge.rpc.processor.device.profile;

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
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceProfileUpdateMsg;

class DeviceProfileEdgeProcessorV2DiffblueTest {
  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)")
  void testSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultRuleChainId(tenantId, deviceProfile, ruleChainId);

    // Assert
    assertSame(ruleChainId, deviceProfile.getDefaultRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfile#setDefaultRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId)}
   */
  @Test
  @DisplayName("Test setDefaultRuleChainId(TenantId, DeviceProfile, RuleChainId); then calls setDefaultRuleChainId(RuleChainId)")
  void testSetDefaultRuleChainId_thenCallsSetDefaultRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setDefaultRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultRuleChainId(tenantId, deviceProfile, ruleChainId);

    // Assert that nothing has changed
    verify(deviceProfile).setDefaultRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)")
  void testSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    DeviceProfile deviceProfile = new DeviceProfile();
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(deviceProfile, ruleChainId,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(ruleChainId, deviceProfile.getDefaultEdgeRuleChainId());
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>Then calls
   * {@link DeviceProfile#setDefaultEdgeRuleChainId(RuleChainId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg); then calls setDefaultEdgeRuleChainId(RuleChainId)")
  void testSetDefaultEdgeRuleChainId_thenCallsSetDefaultEdgeRuleChainId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setDefaultEdgeRuleChainId(Mockito.<RuleChainId>any());
    UUID id = UUID.randomUUID();
    RuleChainId ruleChainId = new RuleChainId(id);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(deviceProfile, ruleChainId,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    verify(deviceProfile).setDefaultEdgeRuleChainId(isA(RuleChainId.class));
    assertSame(id, ruleChainId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} DefaultEdgeRuleChainId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultEdgeRuleChainId(DeviceProfile, RuleChainId, DeviceProfileUpdateMsg); then DeviceProfile() DefaultEdgeRuleChainId is 'null'")
  void testSetDefaultEdgeRuleChainId_thenDeviceProfileDefaultEdgeRuleChainIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfileEdgeProcessorV2.setDefaultEdgeRuleChainId(deviceProfile, null,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertNull(deviceProfile.getDefaultEdgeRuleChainId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)")
  void testSetDefaultDashboardId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DashboardId dashboardId = mock(DashboardId.class);
    UUID randomUUIDResult = UUID.randomUUID();
    when(dashboardId.getId()).thenReturn(randomUUIDResult);
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, dashboardId, deviceProfile,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    verify(dashboardId).getId();
    DashboardId defaultDashboardId = deviceProfile.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId.getEntityType());
    assertFalse(defaultDashboardId.isNullUid());
    assertSame(randomUUIDResult, defaultDashboardId.getId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>Given {@link DashboardId#DashboardId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); given DashboardId(UUID) with id is randomUUID")
  void testSetDefaultDashboardId_givenDashboardIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    DeviceProfile deviceProfile = new DeviceProfile();
    DashboardId defaultDashboardId = new DashboardId(UUID.randomUUID());
    deviceProfile.setDefaultDashboardId(defaultDashboardId);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, null, deviceProfile,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(defaultDashboardId, deviceProfile.getDefaultDashboardId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} DefaultDashboardId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); given 'null'; then DeviceProfile() DefaultDashboardId is 'null'")
  void testSetDefaultDashboardId_givenNull_thenDeviceProfileDefaultDashboardIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultDashboardId(null);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, null, deviceProfile,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
  }

  /**
   * Test
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}.
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName("Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); when DashboardId(UUID) with id is randomUUID")
  void testSetDefaultDashboardId_whenDashboardIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2 = new DeviceProfileEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DashboardId dashboardId = new DashboardId(UUID.randomUUID());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(tenantId, dashboardId, deviceProfile,
        DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(dashboardId, deviceProfile.getDefaultDashboardId());
  }
}
