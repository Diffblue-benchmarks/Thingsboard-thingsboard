package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.device.DeviceCredentialsDao;
import org.thingsboard.server.dao.exception.DeviceCredentialsValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DeviceCredentialsDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceCredentialsDataValidatorDiffblueTest {
  @MockBean
  private DeviceCredentialsDao deviceCredentialsDao;

  @Autowired
  private DeviceCredentialsDataValidator deviceCredentialsDataValidator;

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"})
  public void testValidateCreateWithTenantIdDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"})
  public void testValidateCreateWithTenantIdDeviceCredentials2() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"})
  public void testValidateCreateWithTenantIdDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"})
  public void testValidateCreateWithTenantIdDeviceCredentials4() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials);

    // Assert
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"})
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
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"})
  public void testValidateUpdateWithTenantIdDeviceCredentials2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setId(new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"})
  public void testValidateUpdateWithTenantIdDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>Then calls {@link DeviceCredentials#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"})
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
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"})
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
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"})
  public void testValidateDataImplWithTenantIdDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"})
  public void testValidateDataImplWithTenantIdDeviceCredentials2() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with {@code TenantId}, {@code DeviceCredentials}.
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"})
  public void testValidateDataImplWithTenantIdDeviceCredentials_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }
}
