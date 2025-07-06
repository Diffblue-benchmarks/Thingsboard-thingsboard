package org.thingsboard.server.service.edge.rpc.processor.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.FileOptions;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceProfileUpdateMsg;

@ExtendWith(MockitoExtension.class)
class DeviceProfileEdgeProcessorV2DiffblueTest {
  @InjectMocks private DeviceProfileEdgeProcessorV2 deviceProfileEdgeProcessorV2;

  /**
   * Test {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * DeviceProfile, DeviceProfileUpdateMsg)}.
   *
   * <p>Method under test: {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceProfile deviceProfile = new DeviceProfile(new DeviceProfile());
    deviceProfile.setDefaultDashboardId(null);
    DeviceProfileUpdateMsg deviceProfileUpdateMsg = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, null, deviceProfile, deviceProfileUpdateMsg);

    // Assert that nothing has changed
    FileOptions options = deviceProfileUpdateMsg.getDescriptorForType().getFile().getOptions();
    assertTrue(options.getGoPackageBytes().isEmpty());
    assertTrue(options.getDescriptorForType().isExtendable());
  }

  /**
   * Test {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * DeviceProfile, DeviceProfileUpdateMsg)}.
   *
   * <p>Method under test: {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceProfile deviceProfile = new DeviceProfile(new DeviceProfile());
    DashboardId defaultDashboardId =
        new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    deviceProfile.setDefaultDashboardId(defaultDashboardId);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, null, deviceProfile, DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert
    assertEquals(defaultDashboardId, deviceProfile.getDefaultDashboardId());
  }

  /**
   * Test {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * DeviceProfile, DeviceProfileUpdateMsg)}.
   *
   * <ul>
   *   <li>Given {@link DashboardId#DashboardId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); given DashboardId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId_givenDashboardIdWithIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceProfile deviceProfile = new DeviceProfile(new DeviceProfile());
    deviceProfile.setDefaultDashboardId(new DashboardId(null));
    DeviceProfileUpdateMsg deviceProfileUpdateMsg = DeviceProfileUpdateMsg.getDefaultInstance();

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, null, deviceProfile, deviceProfileUpdateMsg);

    // Assert
    assertNull(deviceProfile.getDefaultDashboardId());
    FileOptions options = deviceProfileUpdateMsg.getDescriptorForType().getFile().getOptions();
    assertTrue(options.getGoPackageBytes().isEmpty());
    assertTrue(options.getDescriptorForType().isExtendable());
  }

  /**
   * Test {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId, DashboardId,
   * DeviceProfile, DeviceProfileUpdateMsg)}.
   *
   * <ul>
   *   <li>When {@link DashboardId#DashboardId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileEdgeProcessorV2#setDefaultDashboardId(TenantId,
   * DashboardId, DeviceProfile, DeviceProfileUpdateMsg)}
   */
  @Test
  @DisplayName(
      "Test setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg); when DashboardId(UUID) with id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileEdgeProcessorV2.setDefaultDashboardId(TenantId, DashboardId, DeviceProfile, DeviceProfileUpdateMsg)"
  })
  void testSetDefaultDashboardId_whenDashboardIdWithIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DashboardId dashboardId = new DashboardId(null);

    DeviceProfile deviceProfile = new DeviceProfile(new DeviceProfile());
    deviceProfile.setDefaultDashboardId(null);

    // Act
    deviceProfileEdgeProcessorV2.setDefaultDashboardId(
        tenantId, dashboardId, deviceProfile, DeviceProfileUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    assertNull(deviceProfile.getDefaultDashboardId());
  }
}
