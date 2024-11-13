package org.thingsboard.server.service.security.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsFilter;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.common.transport.auth.DeviceAuthResult;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
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

class DefaultDeviceAuthServiceDiffblueTest {
  /**
   * Test {@link DefaultDeviceAuthService#process(DeviceCredentialsFilter)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDeviceAuthService#process(DeviceCredentialsFilter)}
   */
  @Test
  @DisplayName("Test process(DeviceCredentialsFilter); given '42'; then return ErrorMsg is 'null'")
  void testProcess_given42_thenReturnErrorMsgIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(deviceCredentials);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultDeviceAuthService defaultDeviceAuthService = new DefaultDeviceAuthService(
        new DeviceServiceImpl(deviceDao, deviceCredentialsService2, deviceProfileService, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService()),
        deviceCredentialsService);
    DeviceCredentials credentialsFilter = mock(DeviceCredentials.class);
    when(credentialsFilter.getCredentialsId()).thenReturn("42");
    when(credentialsFilter.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    DeviceAuthResult actualProcessResult = defaultDeviceAuthService.process(credentialsFilter);

    // Assert
    verify(credentialsFilter).getCredentialsId();
    verify(credentialsFilter).getCredentialsType();
    verify(deviceCredentialsService).findDeviceCredentialsByCredentialsId(eq("42"));
    assertNull(actualProcessResult.getErrorMsg());
    assertNull(actualProcessResult.getDeviceId());
    assertTrue(actualProcessResult.isSuccess());
  }

  /**
   * Test {@link DefaultDeviceAuthService#process(DeviceCredentialsFilter)}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code Credentials Not Found!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDeviceAuthService#process(DeviceCredentialsFilter)}
   */
  @Test
  @DisplayName("Test process(DeviceCredentialsFilter); then return ErrorMsg is 'Credentials Not Found!'")
  void testProcess_thenReturnErrorMsgIsCredentialsNotFound() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any())).thenReturn(null);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultDeviceAuthService defaultDeviceAuthService = new DefaultDeviceAuthService(
        new DeviceServiceImpl(deviceDao, deviceCredentialsService2, deviceProfileService, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService()),
        deviceCredentialsService);

    // Act
    DeviceAuthResult actualProcessResult = defaultDeviceAuthService.process(new DeviceCredentials());

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByCredentialsId(isNull());
    assertEquals("Credentials Not Found!", actualProcessResult.getErrorMsg());
    assertNull(actualProcessResult.getDeviceId());
    assertFalse(actualProcessResult.isSuccess());
  }

  /**
   * Test {@link DefaultDeviceAuthService#process(DeviceCredentialsFilter)}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code Credentials Type mismatch!}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultDeviceAuthService#process(DeviceCredentialsFilter)}
   */
  @Test
  @DisplayName("Test process(DeviceCredentialsFilter); then return ErrorMsg is 'Credentials Type mismatch!'")
  void testProcess_thenReturnErrorMsgIsCredentialsTypeMismatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    when(deviceCredentialsService.findDeviceCredentialsByCredentialsId(Mockito.<String>any()))
        .thenReturn(deviceCredentials);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultDeviceAuthService defaultDeviceAuthService = new DefaultDeviceAuthService(
        new DeviceServiceImpl(deviceDao, deviceCredentialsService2, deviceProfileService, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService()),
        deviceCredentialsService);

    // Act
    DeviceAuthResult actualProcessResult = defaultDeviceAuthService.process(new DeviceCredentials());

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByCredentialsId(isNull());
    assertEquals("Credentials Type mismatch!", actualProcessResult.getErrorMsg());
    assertNull(actualProcessResult.getDeviceId());
    assertFalse(actualProcessResult.isSuccess());
  }
}
