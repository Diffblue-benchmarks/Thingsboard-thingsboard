package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.entitiy.device.DefaultTbDeviceService;

class DeviceBulkImportServiceDiffblueTest {
  /**
   * Test {@link DeviceBulkImportService#getEntityType()}.
   *
   * <p>Method under test: {@link DeviceBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType DeviceBulkImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceService =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            deviceCredentialsService2,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService3, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService4,
            new DeviceProfileServiceImpl());

    // Act and Assert
    assertEquals(EntityType.DEVICE, deviceBulkImportService.getEntityType());
  }
}
