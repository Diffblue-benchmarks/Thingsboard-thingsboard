package org.thingsboard.server.service.entitiy.device;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.device.claim.ClaimResult;
import org.thingsboard.server.dao.device.claim.ReclaimResult;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.device.ClaimDevicesServiceImpl;

class DefaultTbDeviceServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbDeviceService#claimDevice(TenantId, Device, CustomerId, String, User)}.
   * <ul>
   *   <li>Then calls
   * {@link ClaimDevicesServiceImpl#claimDevice(Device, CustomerId, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceService#claimDevice(TenantId, Device, CustomerId, String, User)}
   */
  @Test
  @DisplayName("Test claimDevice(TenantId, Device, CustomerId, String, User); then calls claimDevice(Device, CustomerId, String)")
  void testClaimDevice_thenCallsClaimDevice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClaimDevicesServiceImpl claimDevicesService = mock(ClaimDevicesServiceImpl.class);
    SettableFuture<ClaimResult> delegate = SettableFuture.create();
    when(claimDevicesService.claimDevice(Mockito.<Device>any(), Mockito.<CustomerId>any(), Mockito.<String>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DefaultTbDeviceService defaultTbDeviceService = new DefaultTbDeviceService(deviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        claimDevicesService);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Device device = new Device();
    CustomerId customerId = new CustomerId(UUID.randomUUID());

    // Act
    defaultTbDeviceService.claimDevice(tenantId, device, customerId, "EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY",
        new User());

    // Assert
    verify(claimDevicesService).claimDevice(isA(Device.class), isA(CustomerId.class),
        eq("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY"));
  }

  /**
   * Test {@link DefaultTbDeviceService#reclaimDevice(TenantId, Device, User)}.
   * <ul>
   *   <li>Then calls
   * {@link ClaimDevicesServiceImpl#reClaimDevice(TenantId, Device)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceService#reclaimDevice(TenantId, Device, User)}
   */
  @Test
  @DisplayName("Test reclaimDevice(TenantId, Device, User); then calls reClaimDevice(TenantId, Device)")
  void testReclaimDevice_thenCallsReClaimDevice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ClaimDevicesServiceImpl claimDevicesService = mock(ClaimDevicesServiceImpl.class);
    SettableFuture<ReclaimResult> delegate = SettableFuture.create();
    when(claimDevicesService.reClaimDevice(Mockito.<TenantId>any(), Mockito.<Device>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DefaultTbDeviceService defaultTbDeviceService = new DefaultTbDeviceService(deviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        claimDevicesService);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Device device = new Device();

    // Act
    defaultTbDeviceService.reclaimDevice(tenantId, device, new User());

    // Assert
    verify(claimDevicesService).reClaimDevice(isA(TenantId.class), isA(Device.class));
  }
}
