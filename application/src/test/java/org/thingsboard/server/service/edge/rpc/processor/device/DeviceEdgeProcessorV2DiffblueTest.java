package org.thingsboard.server.service.edge.rpc.processor.device;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceUpdateMsg;

@ExtendWith(MockitoExtension.class)
class DeviceEdgeProcessorV2DiffblueTest {
  @InjectMocks
  private DeviceEdgeProcessorV2 deviceEdgeProcessorV2;

  /**
   * Test {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <p>
   * Method under test: {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceEdgeProcessorV2.setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)"})
  void testSetCustomerId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Device device = new Device();
    CustomerId customerId2 = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    device.setCustomerId(customerId2);

    // Act
    deviceEdgeProcessorV2.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    assertSame(customerId2, device.getCustomerId());
  }

  /**
   * Test {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg); when Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceEdgeProcessorV2.setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)"})
  void testSetCustomerId_whenDevice() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();

    // Act
    deviceEdgeProcessorV2.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, device.getCustomerId());
  }
}
