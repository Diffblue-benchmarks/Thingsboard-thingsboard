package org.thingsboard.server.service.edge.rpc.processor.device;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceUpdateMsg;

class DeviceEdgeProcessorV1DiffblueTest {
  /**
   * Test
   * {@link DeviceEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <ul>
   *   <li>When {@link Device} {@link Device#setCustomerId(CustomerId)} does
   * nothing.</li>
   *   <li>Then calls {@link Device#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg); when Device setCustomerId(CustomerId) does nothing; then calls setCustomerId(CustomerId)")
  void testSetCustomerId_whenDeviceSetCustomerIdDoesNothing_thenCallsSetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Device device = mock(Device.class);
    doNothing().when(device).setCustomerId(Mockito.<CustomerId>any());

    // Act
    deviceEdgeProcessorV1.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(device).setCustomerId(isA(CustomerId.class));
  }

  /**
   * Test
   * {@link DeviceEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then {@link Device#Device()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessorV1#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg); when Device(); then Device() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenDevice_thenDeviceCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Device device = new Device();

    // Act
    deviceEdgeProcessorV1.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, device.getCustomerId());
  }
}
