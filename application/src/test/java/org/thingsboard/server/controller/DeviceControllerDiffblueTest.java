package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
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
import org.thingsboard.server.service.device.ClaimDevicesServiceImpl;
import org.thingsboard.server.service.device.DeviceBulkImportService;
import org.thingsboard.server.service.entitiy.device.DefaultTbDeviceService;

class DeviceControllerDiffblueTest {
  /**
   * Test {@link DeviceController#assignDeviceToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDeviceToCustomer(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToCustomer(String, String)"
  })
  void testAssignDeviceToCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceController.assignDeviceToCustomer("42", "42"));
  }

  /**
   * Test {@link DeviceController#assignDeviceToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDeviceToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToCustomer(String, String)"
  })
  void testAssignDeviceToCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceController.assignDeviceToCustomer("", "42"));
  }

  /**
   * Test {@link DeviceController#assignDeviceToCustomer(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToCustomer(String, String)}
   */
  @Test
  @DisplayName("Test assignDeviceToCustomer(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToCustomer(String, String)"
  })
  void testAssignDeviceToCustomer_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceController.assignDeviceToCustomer("42", ""));
  }

  /**
   * Test {@link DeviceController#assignDeviceToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDeviceToPublicCustomer(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToPublicCustomer(String)"
  })
  void testAssignDeviceToPublicCustomer_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceController.assignDeviceToPublicCustomer("42"));
  }

  /**
   * Test {@link DeviceController#assignDeviceToPublicCustomer(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToPublicCustomer(String)}
   */
  @Test
  @DisplayName("Test assignDeviceToPublicCustomer(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToPublicCustomer(String)"
  })
  void testAssignDeviceToPublicCustomer_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceController.assignDeviceToPublicCustomer(""));
  }

  /**
   * Test {@link DeviceController#assignDeviceToEdge(String, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDeviceToEdge(String, String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToEdge(String, String)"
  })
  void testAssignDeviceToEdge_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceController.assignDeviceToEdge("42", "42"));
  }

  /**
   * Test {@link DeviceController#assignDeviceToEdge(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDeviceToEdge(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToEdge(String, String)"
  })
  void testAssignDeviceToEdge_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceController.assignDeviceToEdge("", "42"));
  }

  /**
   * Test {@link DeviceController#assignDeviceToEdge(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceController#assignDeviceToEdge(String, String)}
   */
  @Test
  @DisplayName("Test assignDeviceToEdge(String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.Device DeviceController.assignDeviceToEdge(String, String)"
  })
  void testAssignDeviceToEdge_whenEmptyString2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();

    DeviceServiceImpl deviceService2 =
        new DeviceServiceImpl(
            deviceDao2,
            null,
            deviceProfileService2,
            eventService2,
            tenantService2,
            deviceValidator2,
            countService2,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService =
        new DefaultTbDeviceService(
            deviceService2, deviceCredentialsService2, new ClaimDevicesServiceImpl());
    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao3, new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService =
        new DeviceBulkImportService(
            deviceService,
            tbDeviceService,
            deviceCredentialsService3,
            new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao3 = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao4, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService3 = new DeviceProfileServiceImpl();
    BaseEventService eventService3 = new BaseEventService();
    TenantServiceImpl tenantService3 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator3 = new DeviceDataValidator();
    BaseEntityCountService countService3 = new BaseEntityCountService();

    DeviceServiceImpl deviceService3 =
        new DeviceServiceImpl(
            deviceDao3,
            deviceCredentialsService4,
            deviceProfileService3,
            eventService3,
            tenantService3,
            deviceValidator3,
            countService3,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao5 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService5 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao5, new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService2 =
        new DefaultTbDeviceService(
            deviceService3, deviceCredentialsService5, new ClaimDevicesServiceImpl());

    DeviceController deviceController =
        new DeviceController(deviceBulkImportService, tbDeviceService2);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceController.assignDeviceToEdge("42", ""));
  }
}
