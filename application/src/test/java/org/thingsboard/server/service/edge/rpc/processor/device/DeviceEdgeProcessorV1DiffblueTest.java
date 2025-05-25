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
class DeviceEdgeProcessorV1DiffblueTest {
  @InjectMocks
  private DeviceEdgeProcessorV1 deviceEdgeProcessorV1;

  /**
   * Test {@link DeviceEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <p>
   * Method under test: {@link DeviceEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceEdgeProcessorV1.setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)"})
  void testSetCustomerId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();

    // Act
    deviceEdgeProcessorV1.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, device.getCustomerId());
  }
}
