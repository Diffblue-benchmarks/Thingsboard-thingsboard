package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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

class ClaimDevicesServiceImplDiffblueTest {
  /**
   * Test {@link ClaimDevicesServiceImpl#reClaimDevice(TenantId, Device)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ClaimDevicesServiceImpl#reClaimDevice(TenantId, Device)}
   */
  @Test
  @DisplayName("Test reClaimDevice(TenantId, Device); then throw IllegalArgumentException")
  void testReClaimDevice_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClaimDevicesServiceImpl claimDevicesServiceImpl = new ClaimDevicesServiceImpl();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Device device = mock(Device.class);
    when(device.getId()).thenThrow(new IllegalArgumentException("claimDevices"));
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    doNothing().when(device).setCustomerId(Mockito.<CustomerId>any());
    device.setCustomerId(new CustomerId(null));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> claimDevicesServiceImpl.reClaimDevice(tenantId, device));
    verify(device).getCustomerId();
    verify(device).getId();
    verify(device).setCustomerId(isA(CustomerId.class));
  }
}
