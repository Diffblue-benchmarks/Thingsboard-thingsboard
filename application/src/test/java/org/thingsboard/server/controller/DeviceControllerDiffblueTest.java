package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.device.ClaimDevicesServiceImpl;
import org.thingsboard.server.service.device.DeviceBulkImportService;
import org.thingsboard.server.service.entitiy.device.DefaultTbDeviceService;

class DeviceControllerDiffblueTest {
  /**
   * Test {@link DeviceController#updateDeviceCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceController#updateDeviceCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(DeviceCredentials); then throw IncorrectParameterException")
  void testUpdateDeviceCredentials_thenThrowIncorrectParameterException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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

    JpaDeviceDao deviceDao2 = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, null, deviceProfileService2, eventService2,
        tenantService2, deviceValidator2, countService2, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService2,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService3, new DeviceProfileServiceImpl());

    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();
    DeviceServiceImpl deviceService3 = new DeviceServiceImpl(deviceDao3, deviceCredentialsService4,
        deviceProfileService3, eventService3, tenantService3, deviceValidator3, countService3,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 = new DeviceCredentialsServiceImpl(deviceCredentialsDao5,
        new DeviceCredentialsDataValidator());

    DeviceController deviceController = new DeviceController(deviceBulkImportService,
        new DefaultTbDeviceService(deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl()));
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getDeviceId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> deviceController.updateDeviceCredentials(deviceCredentials));
    verify(deviceCredentials).getDeviceId();
  }
}
