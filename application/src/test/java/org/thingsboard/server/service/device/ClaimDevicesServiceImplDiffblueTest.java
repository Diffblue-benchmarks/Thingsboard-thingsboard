package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.attributes.AttributesService;

@ExtendWith(MockitoExtension.class)
class ClaimDevicesServiceImplDiffblueTest {
  @Mock private AttributesService attributesService;

  @Mock private CacheManager cacheManager;

  @InjectMocks private ClaimDevicesServiceImpl claimDevicesServiceImpl;

  /**
   * Test {@link ClaimDevicesServiceImpl#claimDevice(Device, CustomerId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDevicesServiceImpl#claimDevice(Device, CustomerId, String)}
   */
  @Test
  @DisplayName("Test claimDevice(Device, CustomerId, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture ClaimDevicesServiceImpl.claimDevice(Device, CustomerId, String)"
  })
  void testClaimDevice_thenThrowIllegalArgumentException() {
    // Arrange
    when(attributesService.find(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    Device device = new Device();
    device.setId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            claimDevicesServiceImpl.claimDevice(
                device,
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
    verify(cacheManager).getCache("claimDevices");
    verify(attributesService)
        .find(
            (TenantId) isNull(),
            isA(EntityId.class),
            eq(AttributeScope.SERVER_SCOPE),
            eq("claimingData"));
  }
}
