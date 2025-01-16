package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.HasOtaPackage;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
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
public class AbstractHasOtaPackageValidatorDiffblueTest {
  @Autowired
  private AbstractHasOtaPackageValidator<Device> abstractHasOtaPackageValidator;

  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private DeviceDao deviceDao;

  @MockBean
  private OtaPackageService otaPackageService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   * with {@code tenantId}, {@code entity}, {@code deviceProfileId}.
   * <p>
   * Method under test:
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   */
  @Test
  public void testValidateOtaPackageWithTenantIdEntityDeviceProfileId() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getFirmwareId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> abstractHasOtaPackageValidator.validateOtaPackage(ModelConstants.SYSTEM_TENANT, device, null));
    verify(device).getFirmwareId();
  }

  /**
   * Test
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   * with {@code tenantId}, {@code entity}, {@code deviceProfileId}.
   * <p>
   * Method under test:
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   */
  @Test
  public void testValidateOtaPackageWithTenantIdEntityDeviceProfileId2() {
    // Arrange
    Device device = mock(Device.class);
    when(device.getFirmwareId()).thenReturn(null);
    when(device.getSoftwareId()).thenReturn(null);

    // Act
    abstractHasOtaPackageValidator.validateOtaPackage(ModelConstants.SYSTEM_TENANT, device, null);

    // Assert that nothing has changed
    verify(device).getFirmwareId();
    verify(device).getSoftwareId();
  }

  /**
   * Test
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   * with {@code tenantId}, {@code entity}, {@code deviceProfileId}.
   * <p>
   * Method under test:
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   */
  @Test
  public void testValidateOtaPackageWithTenantIdEntityDeviceProfileId3() {
    // Arrange
    when(otaPackageService.findOtaPackageById(Mockito.<TenantId>any(), Mockito.<OtaPackageId>any())).thenReturn(null);
    Device device = mock(Device.class);
    when(device.getFirmwareId()).thenReturn(null);
    when(device.getSoftwareId()).thenReturn(new OtaPackageId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> abstractHasOtaPackageValidator.validateOtaPackage(ModelConstants.SYSTEM_TENANT, device, null));
    verify(device).getFirmwareId();
    verify(device, atLeast(1)).getSoftwareId();
    verify(otaPackageService).findOtaPackageById(isA(TenantId.class), isA(OtaPackageId.class));
  }

  /**
   * Test
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   * with {@code tenantId}, {@code entity}, {@code deviceProfileId}.
   * <p>
   * Method under test:
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   */
  @Test
  public void testValidateOtaPackageWithTenantIdEntityDeviceProfileId4() {
    // Arrange
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getType()).thenReturn(OtaPackageType.FIRMWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageService.findOtaPackageById(Mockito.<TenantId>any(), Mockito.<OtaPackageId>any()))
        .thenReturn(otaPackage);
    Device device = mock(Device.class);
    when(device.getFirmwareId()).thenReturn(null);
    when(device.getSoftwareId()).thenReturn(new OtaPackageId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> abstractHasOtaPackageValidator.validateOtaPackage(ModelConstants.SYSTEM_TENANT, device, null));
    verify(device).getFirmwareId();
    verify(device, atLeast(1)).getSoftwareId();
    verify(otaPackage).getTenantId();
    verify(otaPackage, atLeast(1)).getType();
    verify(otaPackageService).findOtaPackageById(isA(TenantId.class), isA(OtaPackageId.class));
  }

  /**
   * Test
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   * with {@code tenantId}, {@code entity}, {@code deviceProfileId}.
   * <ul>
   *   <li>Then calls {@link OtaPackage#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractHasOtaPackageValidator#validateOtaPackage(TenantId, HasOtaPackage, DeviceProfileId)}
   */
  @Test
  public void testValidateOtaPackageWithTenantIdEntityDeviceProfileId_thenCallsGetData()
      throws UnsupportedEncodingException {
    // Arrange
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.getDeviceProfileId()).thenReturn(new DeviceProfileId(ModelConstants.NULL_UUID));
    when(otaPackage.getData()).thenReturn(ByteBuffer.wrap("AXAXAXAX".getBytes("UTF-8")));
    when(otaPackage.getType()).thenReturn(OtaPackageType.SOFTWARE);
    when(otaPackage.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(otaPackageService.findOtaPackageById(Mockito.<TenantId>any(), Mockito.<OtaPackageId>any()))
        .thenReturn(otaPackage);
    Device device = mock(Device.class);
    when(device.getFirmwareId()).thenReturn(null);
    when(device.getSoftwareId()).thenReturn(new OtaPackageId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> abstractHasOtaPackageValidator.validateOtaPackage(ModelConstants.SYSTEM_TENANT, device, null));
    verify(device).getFirmwareId();
    verify(device, atLeast(1)).getSoftwareId();
    verify(otaPackage).getData();
    verify(otaPackage).getDeviceProfileId();
    verify(otaPackage).getTenantId();
    verify(otaPackage).getType();
    verify(otaPackageService).findOtaPackageById(isA(TenantId.class), isA(OtaPackageId.class));
  }
}
