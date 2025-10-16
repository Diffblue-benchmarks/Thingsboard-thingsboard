/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

@ContextConfiguration(classes = {DeviceCredentialsDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceCredentialsDataValidatorDiffblueTest {
  @MockBean private DeviceCredentialsDao deviceCredentialsDao;

  @Autowired private DeviceCredentialsDataValidator deviceCredentialsDataValidator;

  @MockBean private DeviceService deviceService;

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"
  })
  public void testValidateCreateWithTenantIdDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"
  })
  public void testValidateCreateWithTenantIdDeviceCredentials2() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"
  })
  public void testValidateCreateWithTenantIdDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateCreate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateCreate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateCreate(TenantId, DeviceCredentials)"
  })
  public void testValidateCreateWithTenantIdDeviceCredentials4() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);

    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    deviceCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, deviceCredentials);

    // Assert
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"
  })
  public void testValidateUpdateWithTenantIdDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"
  })
  public void testValidateUpdateWithTenantIdDeviceCredentials2() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"
  })
  public void testValidateUpdateWithTenantIdDeviceCredentials3() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setId(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"
  })
  public void testValidateUpdateWithTenantIdDeviceCredentials4() {
    // Arrange
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceCredentials#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"
  })
  public void testValidateUpdateWithTenantIdDeviceCredentials_thenCallsGetId() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getId())
        .thenThrow(new DeviceCredentialsValidationException("An error occurred"));
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentials).getId();
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateUpdate(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateUpdate(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsDataValidator.validateUpdate(TenantId, DeviceCredentials)"
  })
  public void testValidateUpdateWithTenantIdDeviceCredentials_thenReturnNull() {
    // Arrange
    when(deviceCredentialsDao.findByCredentialsId(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(deviceCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());

    // Act
    DeviceCredentials actualValidateUpdateResult =
        deviceCredentialsDataValidator.validateUpdate(
            ModelConstants.SYSTEM_TENANT, new DeviceCredentials());

    // Assert
    verify(deviceCredentialsDao).findById(isA(TenantId.class), isNull());
    verify(deviceCredentialsDao).findByCredentialsId(isA(TenantId.class), isNull());
    assertNull(actualValidateUpdateResult);
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"
  })
  public void testValidateDataImplWithTenantIdDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(null);
    deviceCredentials.setCredentialsId("Device credentials should be assigned to device!");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"
  })
  public void testValidateDataImplWithTenantIdDeviceCredentials2() {
    // Arrange
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("Device credentials should be assigned to device!");

    // Act
    deviceCredentialsDataValidator.validateDataImpl(
        ModelConstants.SYSTEM_TENANT, deviceCredentials);

    // Assert
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"
  })
  public void testValidateDataImplWithTenantIdDeviceCredentials3() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"
  })
  public void testValidateDataImplWithTenantIdDeviceCredentials4() {
    // Arrange
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("Device credentials should be assigned to device!");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"
  })
  public void testValidateDataImplWithTenantIdDeviceCredentials_givenEmptyString() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsId("");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId, DeviceCredentials)} with
   * {@code TenantId}, {@code DeviceCredentials}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsDataValidator#validateDataImpl(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsDataValidator.validateDataImpl(TenantId, DeviceCredentials)"
  })
  public void testValidateDataImplWithTenantIdDeviceCredentials_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }
}
