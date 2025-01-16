package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseDataWithAdditionalInfo;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.exception.DeviceCredentialsValidationException;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.entitiy.device.DefaultTbDeviceService;
import org.thingsboard.server.service.entitiy.device.TbDeviceService;
import org.thingsboard.server.service.security.model.SecurityUser;

class DeviceBulkImportServiceDiffblueTest {
  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with
   * {@code Device}, {@code Map}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Device, Map) with 'Device', 'Map'; given Instance")
  void testSetEntityFieldsWithDeviceMap_givenInstance() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl());
    Device device = mock(Device.class);
    when(device.getAdditionalInfo()).thenReturn(NullNode.getInstance());

    // Act
    deviceBulkImportService.setEntityFields(device, new HashMap<>());

    // Assert
    verify(device, atLeast(1)).getAdditionalInfo();
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with
   * {@code Device}, {@code Map}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#isNull()} return
   * {@code true}.</li>
   *   <li>Then calls {@link JsonNode#isNull()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Device, Map) with 'Device', 'Map'; given JsonNode isNull() return 'true'; then calls isNull()")
  void testSetEntityFieldsWithDeviceMap_givenJsonNodeIsNullReturnTrue_thenCallsIsNull() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl());
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    // Act
    deviceBulkImportService.setEntityFields(device, new HashMap<>());

    // Assert
    verify(jsonNode).isNull();
    verify(device, atLeast(1)).getAdditionalInfo();
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with
   * {@code Device}, {@code Map}.
   * <ul>
   *   <li>Given {@code NAME}.</li>
   *   <li>Then calls
   * {@link BaseDataWithAdditionalInfo#setAdditionalInfo(JsonNode)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Device, Map) with 'Device', 'Map'; given 'NAME'; then calls setAdditionalInfo(JsonNode)")
  void testSetEntityFieldsWithDeviceMap_givenName_thenCallsSetAdditionalInfo() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl());
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    doNothing().when(device).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(device).setName(Mockito.<String>any());
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    deviceBulkImportService.setEntityFields(device, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(device).setAdditionalInfo(isA(JsonNode.class));
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device).setName(eq("foo"));
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with
   * {@code Device}, {@code Map}.
   * <ul>
   *   <li>When {@link Device} {@link Device#setLabel(String)} does nothing.</li>
   *   <li>Then calls {@link Device#setLabel(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Device, Map) with 'Device', 'Map'; when Device setLabel(String) does nothing; then calls setLabel(String)")
  void testSetEntityFieldsWithDeviceMap_whenDeviceSetLabelDoesNothing_thenCallsSetLabel() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl());
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    doNothing().when(device).setLabel(Mockito.<String>any());
    doNothing().when(device).setType(Mockito.<String>any());
    doNothing().when(device).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(device).setName(Mockito.<String>any());
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.LABEL, "");
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    deviceBulkImportService.setEntityFields(device, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(device, atLeast(1)).setAdditionalInfo(isA(JsonNode.class));
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device).setLabel(eq(""));
    verify(device).setName(eq("foo"));
    verify(device).setType(eq("42"));
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with
   * {@code Device}, {@code Map}.
   * <ul>
   *   <li>When {@link Device} {@link Device#setType(String)} does nothing.</li>
   *   <li>Then calls {@link Device#setType(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Device, Map) with 'Device', 'Map'; when Device setType(String) does nothing; then calls setType(String)")
  void testSetEntityFieldsWithDeviceMap_whenDeviceSetTypeDoesNothing_thenCallsSetType() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl());
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    doNothing().when(device).setType(Mockito.<String>any());
    doNothing().when(device).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(device).setName(Mockito.<String>any());
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.TYPE, "42");
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act
    deviceBulkImportService.setEntityFields(device, fields);

    // Assert
    verify(jsonNode).isNull();
    verify(device, atLeast(1)).setAdditionalInfo(isA(JsonNode.class));
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device).setName(eq("foo"));
    verify(device).setType(eq("42"));
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'")
  void testSaveEntityWithSecurityUserDeviceMap() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService, null,
        new DeviceProfileServiceImpl());
    SecurityUser user = new SecurityUser();
    Device device = new Device();

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.saveEntity(user, device, new HashMap<>()));
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'")
  void testSaveEntityWithSecurityUserDeviceMap2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findOrCreateDeviceProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new DeviceProfile());
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device = mock(Device.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred")).when(device)
        .setDeviceProfileId(Mockito.<DeviceProfileId>any());
    when(device.getType()).thenReturn("Type");
    when(device.getId()).thenReturn(null);
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.saveEntity(user, device, new HashMap<>()));
    verify(device).getId();
    verify(device, atLeast(1)).getTenantId();
    verify(device, atLeast(1)).getType();
    verify(device).setDeviceProfileId(isNull());
    verify(deviceProfileService).findOrCreateDeviceProfile(isA(TenantId.class), eq("Type"));
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>Given {@link DeviceId#DeviceId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; given DeviceId(UUID) with id is randomUUID")
  void testSaveEntityWithSecurityUserDeviceMap_givenDeviceIdWithIdIsRandomUUID() {
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

    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        mock(DeviceProfileService.class));
    SecurityUser user = new SecurityUser();
    Device device = mock(Device.class);
    when(device.getId()).thenReturn(new DeviceId(UUID.randomUUID()));
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.saveEntity(user, device, new HashMap<>()));
    verify(device).getId();
    verify(device).getTenantId();
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#getId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; given DeviceProfile getId() return 'null'")
  void testSaveEntityWithSecurityUserDeviceMap_givenDeviceProfileGetIdReturnNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    Device device = new Device();
    when(tbDeviceService.saveDeviceWithCredentials(Mockito.<Device>any(), Mockito.<DeviceCredentials>any(),
        Mockito.<User>any())).thenReturn(device);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenReturn(null);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(deviceProfile);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device2 = new Device();

    // Act
    Device actualSaveEntityResult = deviceBulkImportService.saveEntity(user, device2, new HashMap<>());

    // Assert
    verify(deviceProfile).getId();
    verify(deviceProfileService).findDefaultDeviceProfile(isNull());
    verify(tbDeviceService).saveDeviceWithCredentials(isA(Device.class), isA(DeviceCredentials.class), isA(User.class));
    assertSame(device, actualSaveEntityResult);
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>Given {@code TYPE}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code TYPE} is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; given 'TYPE'; when HashMap() 'TYPE' is '42'")
  void testSaveEntityWithSecurityUserDeviceMap_givenType_whenHashMapTypeIs42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    when(tbDeviceService.saveDeviceWithCredentials(Mockito.<Device>any(), Mockito.<DeviceCredentials>any(),
        Mockito.<User>any())).thenReturn(new Device());
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findOrCreateDeviceProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new DeviceProfile());
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device = mock(Device.class);
    doNothing().when(device).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    when(device.getType()).thenReturn("Type");
    when(device.getId()).thenReturn(null);
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.TYPE, "42");

    // Act
    Device actualSaveEntityResult = deviceBulkImportService.saveEntity(user, device, fields);

    // Assert
    verify(device).getId();
    verify(device, atLeast(1)).getTenantId();
    verify(device, atLeast(1)).getType();
    verify(device).setDeviceProfileId(isNull());
    verify(deviceProfileService).findOrCreateDeviceProfile(isA(TenantId.class), eq("Type"));
    verify(tbDeviceService).saveDeviceWithCredentials(isA(Device.class), isA(DeviceCredentials.class), isA(User.class));
    assertNull(actualSaveEntityResult.getDeviceDataBytes());
    assertNull(actualSaveEntityResult.getAdditionalInfo());
    assertNull(actualSaveEntityResult.getVersion());
    assertNull(actualSaveEntityResult.getLabel());
    assertNull(actualSaveEntityResult.getName());
    assertNull(actualSaveEntityResult.getType());
    assertNull(actualSaveEntityResult.getUuidId());
    assertNull(actualSaveEntityResult.getDeviceData());
    assertNull(actualSaveEntityResult.getCustomerId());
    assertNull(actualSaveEntityResult.getExternalId());
    assertNull(actualSaveEntityResult.getId());
    assertNull(actualSaveEntityResult.getDeviceProfileId());
    assertNull(actualSaveEntityResult.getFirmwareId());
    assertNull(actualSaveEntityResult.getSoftwareId());
    assertNull(actualSaveEntityResult.getTenantId());
    assertEquals(0L, actualSaveEntityResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; then return Device()")
  void testSaveEntityWithSecurityUserDeviceMap_thenReturnDevice() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    Device device = new Device();
    when(tbDeviceService.saveDeviceWithCredentials(Mockito.<Device>any(), Mockito.<DeviceCredentials>any(),
        Mockito.<User>any())).thenReturn(device);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(new DeviceProfile());
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device2 = new Device();

    // Act
    Device actualSaveEntityResult = deviceBulkImportService.saveEntity(user, device2, new HashMap<>());

    // Assert
    verify(deviceProfileService).findDefaultDeviceProfile(isNull());
    verify(tbDeviceService).saveDeviceWithCredentials(isA(Device.class), isA(DeviceCredentials.class), isA(User.class));
    assertSame(device, actualSaveEntityResult);
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>Then return DeviceDataBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; then return DeviceDataBytes is 'null'")
  void testSaveEntityWithSecurityUserDeviceMap_thenReturnDeviceDataBytesIsNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    when(tbDeviceService.saveDeviceWithCredentials(Mockito.<Device>any(), Mockito.<DeviceCredentials>any(),
        Mockito.<User>any())).thenReturn(new Device());
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findOrCreateDeviceProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new DeviceProfile());
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device = mock(Device.class);
    doNothing().when(device).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    when(device.getType()).thenReturn("Type");
    when(device.getId()).thenReturn(null);
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    Device actualSaveEntityResult = deviceBulkImportService.saveEntity(user, device, new HashMap<>());

    // Assert
    verify(device).getId();
    verify(device, atLeast(1)).getTenantId();
    verify(device, atLeast(1)).getType();
    verify(device).setDeviceProfileId(isNull());
    verify(deviceProfileService).findOrCreateDeviceProfile(isA(TenantId.class), eq("Type"));
    verify(tbDeviceService).saveDeviceWithCredentials(isA(Device.class), isA(DeviceCredentials.class), isA(User.class));
    assertNull(actualSaveEntityResult.getDeviceDataBytes());
    assertNull(actualSaveEntityResult.getAdditionalInfo());
    assertNull(actualSaveEntityResult.getVersion());
    assertNull(actualSaveEntityResult.getLabel());
    assertNull(actualSaveEntityResult.getName());
    assertNull(actualSaveEntityResult.getType());
    assertNull(actualSaveEntityResult.getUuidId());
    assertNull(actualSaveEntityResult.getDeviceData());
    assertNull(actualSaveEntityResult.getCustomerId());
    assertNull(actualSaveEntityResult.getExternalId());
    assertNull(actualSaveEntityResult.getId());
    assertNull(actualSaveEntityResult.getDeviceProfileId());
    assertNull(actualSaveEntityResult.getFirmwareId());
    assertNull(actualSaveEntityResult.getSoftwareId());
    assertNull(actualSaveEntityResult.getTenantId());
    assertEquals(0L, actualSaveEntityResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>When {@link Device} {@link Device#getType()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; when Device getType() return empty string")
  void testSaveEntityWithSecurityUserDeviceMap_whenDeviceGetTypeReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(deviceProfile);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device = mock(Device.class);
    when(device.getType()).thenReturn("");
    when(device.getId()).thenReturn(null);
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.saveEntity(user, device, new HashMap<>()));
    verify(device).getId();
    verify(device, atLeast(1)).getTenantId();
    verify(device).getType();
    verify(deviceProfile).getId();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>When {@link Device} {@link Device#getType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; when Device getType() return 'null'")
  void testSaveEntityWithSecurityUserDeviceMap_whenDeviceGetTypeReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.findDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(deviceProfile);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        deviceProfileService);
    SecurityUser user = new SecurityUser();
    Device device = mock(Device.class);
    when(device.getType()).thenReturn(null);
    when(device.getId()).thenReturn(null);
    when(device.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.saveEntity(user, device, new HashMap<>()));
    verify(device).getId();
    verify(device, atLeast(1)).getTenantId();
    verify(device).getType();
    verify(deviceProfile).getId();
    verify(deviceProfileService).findDefaultDeviceProfile(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   * with {@code SecurityUser}, {@code Device}, {@code Map}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#saveEntity(SecurityUser, Device, Map)}
   */
  @Test
  @DisplayName("Test saveEntity(SecurityUser, Device, Map) with 'SecurityUser', 'Device', 'Map'; when 'null'")
  void testSaveEntityWithSecurityUserDeviceMap_whenNull() {
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

    TbDeviceService tbDeviceService = mock(TbDeviceService.class);
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator()),
        mock(DeviceProfileService.class));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.saveEntity(user, null, new HashMap<>()));
  }

  /**
   * Test {@link DeviceBulkImportService#findOrCreateEntity(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#findOrCreateEntity(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateEntity(TenantId, String); then return Device()")
  void testFindOrCreateEntity_thenReturnDevice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
    Device device = new Device();
    when(deviceService.findDeviceByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(device);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

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

    // Act
    Device actualFindOrCreateEntityResult = deviceBulkImportService.findOrCreateEntity(new TenantId(UUID.randomUUID()),
        "Name");

    // Assert
    verify(deviceService).findDeviceByTenantIdAndName(isA(TenantId.class), eq("Name"));
    assertSame(device, actualFindOrCreateEntityResult);
  }

  /**
   * Test {@link DeviceBulkImportService#findOrCreateEntity(TenantId, String)}.
   * <ul>
   *   <li>Then return DeviceDataBytes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#findOrCreateEntity(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateEntity(TenantId, String); then return DeviceDataBytes is 'null'")
  void testFindOrCreateEntity_thenReturnDeviceDataBytesIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
    when(deviceService.findDeviceByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

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

    // Act
    Device actualFindOrCreateEntityResult = deviceBulkImportService.findOrCreateEntity(new TenantId(UUID.randomUUID()),
        "Name");

    // Assert
    verify(deviceService).findDeviceByTenantIdAndName(isA(TenantId.class), eq("Name"));
    assertNull(actualFindOrCreateEntityResult.getDeviceDataBytes());
    assertNull(actualFindOrCreateEntityResult.getAdditionalInfo());
    assertNull(actualFindOrCreateEntityResult.getVersion());
    assertNull(actualFindOrCreateEntityResult.getLabel());
    assertNull(actualFindOrCreateEntityResult.getName());
    assertNull(actualFindOrCreateEntityResult.getType());
    assertNull(actualFindOrCreateEntityResult.getUuidId());
    assertNull(actualFindOrCreateEntityResult.getDeviceData());
    assertNull(actualFindOrCreateEntityResult.getCustomerId());
    assertNull(actualFindOrCreateEntityResult.getExternalId());
    assertNull(actualFindOrCreateEntityResult.getId());
    assertNull(actualFindOrCreateEntityResult.getDeviceProfileId());
    assertNull(actualFindOrCreateEntityResult.getFirmwareId());
    assertNull(actualFindOrCreateEntityResult.getSoftwareId());
    assertNull(actualFindOrCreateEntityResult.getTenantId());
    assertEquals(0L, actualFindOrCreateEntityResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceBulkImportService#setOwners(Device, SecurityUser)} with
   * {@code Device}, {@code SecurityUser}.
   * <ul>
   *   <li>Then calls {@link Device#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceBulkImportService#setOwners(Device, SecurityUser)}
   */
  @Test
  @DisplayName("Test setOwners(Device, SecurityUser) with 'Device', 'SecurityUser'; then calls setCustomerId(CustomerId)")
  void testSetOwnersWithDeviceSecurityUser_thenCallsSetCustomerId() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    DeviceBulkImportService deviceBulkImportService = new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl());
    Device entity = mock(Device.class);
    doNothing().when(entity).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(entity).setTenantId(Mockito.<TenantId>any());

    // Act
    deviceBulkImportService.setOwners(entity, new SecurityUser());

    // Assert that nothing has changed
    verify(entity).setCustomerId(isNull());
    verify(entity).setTenantId(isNull());
  }

  /**
   * Test {@link DeviceBulkImportService#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
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
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService2 = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator2 = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService2 = new DeviceServiceImpl(deviceDao2, deviceCredentialsService2,
        deviceProfileService2, eventService2, tenantService2, deviceValidator2, countService2,
        new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao3 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService3 = new DeviceCredentialsServiceImpl(deviceCredentialsDao3,
        new DeviceCredentialsDataValidator());

    DefaultTbDeviceService tbDeviceService = new DefaultTbDeviceService(deviceService2, deviceCredentialsService3,
        new ClaimDevicesServiceImpl());

    JpaDeviceCredentialsDao deviceCredentialsDao4 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService4 = new DeviceCredentialsServiceImpl(deviceCredentialsDao4,
        new DeviceCredentialsDataValidator());

    // Act and Assert
    assertEquals(EntityType.DEVICE, (new DeviceBulkImportService(deviceService, tbDeviceService,
        deviceCredentialsService4, new DeviceProfileServiceImpl())).getEntityType());
  }
}
