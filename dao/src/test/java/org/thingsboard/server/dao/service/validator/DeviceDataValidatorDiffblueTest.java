package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.device.DeviceDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {DeviceDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DeviceDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private DeviceDao deviceDao;

  @Autowired
  private DeviceDataValidator deviceDataValidator;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link DeviceDataValidator#validateCreate(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <ul>
   *   <li>Then calls
   * {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateCreate(TenantId, Device)}
   */
  @Test
  public void testValidateCreateWithTenantIdDevice_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);

    // Act
    deviceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Device());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.DEVICE));
  }

  /**
   * Test {@link DeviceDataValidator#validateUpdate(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateUpdate(TenantId, Device)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDevice() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Device device = mock(Device.class);
    when(device.getId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, device));
    verify(device).getId();
    verify(device).getTenantId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateUpdate(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <ul>
   *   <li>Given {@link DeviceDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateUpdate(TenantId, Device)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDevice_givenDeviceDaoFindByIdReturnNull() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    Device device = mock(Device.class);
    when(device.getId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, device));
    verify(device).getId();
    verify(device).getTenantId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateUpdate(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <ul>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateUpdate(TenantId, Device)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDevice_thenReturnDevice() {
    // Arrange
    Device device = new Device();
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);
    Device device2 = mock(Device.class);
    when(device2.getId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(device2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    Device actualValidateUpdateResult = deviceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, device2);

    // Assert
    verify(device2).getId();
    verify(device2).getTenantId();
    verify(deviceDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(device, actualValidateUpdateResult);
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <ul>
   *   <li>Given {@code Device name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDevice_givenDeviceName() {
    // Arrange
    Device device = new Device();
    device.setName("Device name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDevice_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    Device device = mock(Device.class);
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(device.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(device).getName();
    verify(device, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with
   * {@code TenantId}, {@code Device}.
   * <ul>
   *   <li>Then calls {@link Device#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDevice_thenCallsGetCustomerId() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getCustomerId()).thenThrow(new DataValidationException("An error occurred"));
    when(device.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(device.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(device).getCustomerId();
    verify(device).getName();
    verify(device, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
