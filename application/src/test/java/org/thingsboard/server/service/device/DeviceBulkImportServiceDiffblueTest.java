package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
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
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class DeviceBulkImportServiceDiffblueTest {
  @InjectMocks private DeviceBulkImportService deviceBulkImportService;

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with {@code Device}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Given {@code NAME}.
   *   <li>When {@link HashMap#HashMap()} {@code NAME} is {@code foo}.
   *   <li>Then calls {@link Device#setName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Device, Map) with 'Device', 'Map'; given 'NAME'; when HashMap() 'NAME' is 'foo'; then calls setName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceBulkImportService.setEntityFields(Device, Map)"})
  void testSetEntityFieldsWithDeviceMap_givenName_whenHashMapNameIsFoo_thenCallsSetName() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred"))
        .when(device)
        .setName(Mockito.<String>any());
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.NAME, "foo");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.setEntityFields(device, fields));
    verify(jsonNode).isNull();
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device).setName(eq("foo"));
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with {@code Device}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Then calls {@link Device#setAdditionalInfo(JsonNode)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Device, Map) with 'Device', 'Map'; then calls setAdditionalInfo(JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceBulkImportService.setEntityFields(Device, Map)"})
  void testSetEntityFieldsWithDeviceMap_thenCallsSetAdditionalInfo() {
    // Arrange
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
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with {@code Device}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Then calls {@link Device#setLabel(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Device, Map) with 'Device', 'Map'; then calls setLabel(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceBulkImportService.setEntityFields(Device, Map)"})
  void testSetEntityFieldsWithDeviceMap_thenCallsSetLabel() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred"))
        .when(device)
        .setLabel(Mockito.<String>any());
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.LABEL, "foo");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.setEntityFields(device, fields));
    verify(jsonNode).isNull();
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device).setLabel(eq("foo"));
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with {@code Device}, {@code
   * Map}.
   *
   * <ul>
   *   <li>Then calls {@link Device#setType(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName("Test setEntityFields(Device, Map) with 'Device', 'Map'; then calls setType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceBulkImportService.setEntityFields(Device, Map)"})
  void testSetEntityFieldsWithDeviceMap_thenCallsSetType() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isNull()).thenReturn(true);
    Device device = mock(Device.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred"))
        .when(device)
        .setType(Mockito.<String>any());
    when(device.getAdditionalInfo()).thenReturn(jsonNode);

    HashMap<BulkImportColumnType, String> fields = new HashMap<>();
    fields.put(BulkImportColumnType.TYPE, "foo");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceBulkImportService.setEntityFields(device, fields));
    verify(jsonNode).isNull();
    verify(device, atLeast(1)).getAdditionalInfo();
    verify(device).setType(eq("foo"));
  }

  /**
   * Test {@link DeviceBulkImportService#setEntityFields(Device, Map)} with {@code Device}, {@code
   * Map}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then calls {@link JsonNode#isNull()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceBulkImportService#setEntityFields(Device, Map)}
   */
  @Test
  @DisplayName(
      "Test setEntityFields(Device, Map) with 'Device', 'Map'; when HashMap(); then calls isNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceBulkImportService.setEntityFields(Device, Map)"})
  void testSetEntityFieldsWithDeviceMap_whenHashMap_thenCallsIsNull() {
    // Arrange
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
   * Test {@link DeviceBulkImportService#setOwners(Device, SecurityUser)} with {@code Device},
   * {@code SecurityUser}.
   *
   * <ul>
   *   <li>Then calls {@link Device#setCustomerId(CustomerId)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceBulkImportService#setOwners(Device, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test setOwners(Device, SecurityUser) with 'Device', 'SecurityUser'; then calls setCustomerId(CustomerId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceBulkImportService.setOwners(Device, SecurityUser)"})
  void testSetOwnersWithDeviceSecurityUser_thenCallsSetCustomerId() {
    // Arrange
    Device entity = mock(Device.class);
    doNothing().when(entity).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(entity).setTenantId(Mockito.<TenantId>any());

    // Act
    deviceBulkImportService.setOwners(entity, new SecurityUser());

    // Assert
    verify(entity).setCustomerId(isNull());
    verify(entity).setTenantId(isNull());
  }

  /**
   * Test {@link DeviceBulkImportService#getEntityType()}.
   *
   * <p>Method under test: {@link DeviceBulkImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
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

    // Act and Assert
    assertEquals(
        EntityType.DEVICE,
        new DeviceBulkImportService(
                deviceService,
                tbDeviceService,
                deviceCredentialsService4,
                new DeviceProfileServiceImpl())
            .getEntityType());
  }
}
