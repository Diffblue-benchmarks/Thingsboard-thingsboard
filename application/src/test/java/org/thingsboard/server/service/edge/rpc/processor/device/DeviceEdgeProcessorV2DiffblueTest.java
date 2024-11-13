package org.thingsboard.server.service.edge.rpc.processor.device;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.DeviceUpdateMsg;

class DeviceEdgeProcessorV2DiffblueTest {
  /**
   * Test
   * {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <ul>
   *   <li>Then calls {@link Device#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg); then calls getCustomerId()")
  void testSetCustomerId_thenCallsGetCustomerId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV2 deviceEdgeProcessorV2 = new DeviceEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Device device = mock(Device.class);
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(device).setCustomerId(Mockito.<CustomerId>any());

    // Act
    deviceEdgeProcessorV2.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert that nothing has changed
    verify(device, atLeast(1)).getCustomerId();
    verify(device).setCustomerId(isA(CustomerId.class));
  }

  /**
   * Test
   * {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <ul>
   *   <li>When {@link Device#Device()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg); when Device() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenDeviceCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV2 deviceEdgeProcessorV2 = new DeviceEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    Device device = new Device();
    CustomerId customerId2 = new CustomerId(UUID.randomUUID());
    device.setCustomerId(customerId2);

    // Act
    deviceEdgeProcessorV2.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId2, device.getCustomerId());
  }

  /**
   * Test
   * {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then {@link Device#Device()} CustomerId is
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessorV2#setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg)}
   */
  @Test
  @DisplayName("Test setCustomerId(TenantId, CustomerId, Device, DeviceUpdateMsg); when Device(); then Device() CustomerId is CustomerId(UUID) with id is randomUUID")
  void testSetCustomerId_whenDevice_thenDeviceCustomerIdIsCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV2 deviceEdgeProcessorV2 = new DeviceEdgeProcessorV2();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    Device device = new Device();

    // Act
    deviceEdgeProcessorV2.setCustomerId(tenantId, customerId, device, DeviceUpdateMsg.getDefaultInstance());

    // Assert
    assertSame(customerId, device.getCustomerId());
  }
}
