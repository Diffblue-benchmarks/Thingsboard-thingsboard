package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.device.DeviceCredentialsDao;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.exception.DeviceCredentialsValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {DeviceCredentialsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DeviceCredentialsDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private DeviceCredentialsDao deviceCredentialsDao;

  @Autowired
  private DeviceCredentialsDataValidator deviceCredentialsDataValidator;

  @MockBean
  private DeviceService deviceService;

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateCreateWithTenantIdDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateCreateWithTenantIdDeviceCredentials2() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), eq("42"));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateCreateWithTenantIdDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials);

    // Assert that nothing has changed
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), eq("42"));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateCreateWithTenantIdDeviceCredentials4() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceCredentials2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setId(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>Then calls {@link DeviceCredentials#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceCredentials_thenCallsGetId() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getId()).thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentials).getId();
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateUpdateWithTenantIdDeviceCredentials_thenReturnNull() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act
    DeviceCredentials actualValidateUpdateResult = deviceCredentialsDataValidator
        .validateUpdate(ModelConstants.SYSTEM_TENANT, new DeviceCredentials());

    // Assert
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
    assertNull(actualValidateUpdateResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceCredentials() {
    // Arrange
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceCredentials2() {
    // Arrange
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceCredentials3() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn(null);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceCredentials4() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsType()).thenReturn(null);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceCredentials_givenEmptyString() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);
    when(deviceCredentials.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
  }

  /**
   * Test
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   * with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDeviceCredentials_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }
}
