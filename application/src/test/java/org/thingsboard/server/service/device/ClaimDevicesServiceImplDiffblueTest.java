package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.CacheManager;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

@ExtendWith(MockitoExtension.class)
class ClaimDevicesServiceImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @InjectMocks private ClaimDevicesServiceImpl claimDevicesServiceImpl;

  /**
   * Test {@link ClaimDevicesServiceImpl#reClaimDevice(TenantId, Device)}.
   *
   * <p>Method under test: {@link ClaimDevicesServiceImpl#reClaimDevice(TenantId, Device)}
   */
  @Test
  @DisplayName("Test reClaimDevice(TenantId, Device)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture ClaimDevicesServiceImpl.reClaimDevice(TenantId, Device)"
  })
  void testReClaimDevice() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("claimDevices"));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Device device = new Device();
    device.setCustomerId(new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> claimDevicesServiceImpl.reClaimDevice(tenantId, device));
    verify(cacheManager).getCache(eq("claimDevices"));
  }
}
