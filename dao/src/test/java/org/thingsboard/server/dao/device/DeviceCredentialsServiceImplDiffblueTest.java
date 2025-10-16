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
package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.DeviceCredentialsValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;

@ContextConfiguration(classes = {DeviceCredentialsServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceCredentialsServiceImplDiffblueTest {
  @MockBean private DeviceCredentialsDao deviceCredentialsDao;

  @MockBean private DeviceCredentialsDataValidator deviceCredentialsDataValidator;

  @Autowired private DeviceCredentialsServiceImpl deviceCredentialsServiceImpl;

  @MockBean private TbTransactionalCache<String, DeviceCredentials> tbTransactionalCache;

  /**
   * Test {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)} with
   * {@code DeviceCredentialsEvictEvent}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("42", "42"));

    // Assert
    verify(tbTransactionalCache).evict("42");
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)} with
   * {@code DeviceCredentialsEvictEvent}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent2() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.handleEvictEvent(
                new DeviceCredentialsEvictEvent("42", "42")));
    verify(tbTransactionalCache).evict("42");
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)} with
   * {@code DeviceCredentialsEvictEvent}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(
        new DeviceCredentialsEvictEvent("New Cedentials Id", "42"));

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)} with
   * {@code DeviceCredentialsEvictEvent}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("42", ""));

    // Assert
    verify(tbTransactionalCache).evict("42");
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)} with
   * {@code DeviceCredentialsEvictEvent}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceCredentialsEvictEvent#getNewCedentialsId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent_thenCallsGetNewCedentialsId() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentialsEvictEvent event = mock(DeviceCredentialsEvictEvent.class);
    when(event.getOldCredentialsId()).thenReturn(null);
    when(event.getNewCedentialsId()).thenReturn("42");

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict("42");
    verify(event).getNewCedentialsId();
    verify(event).getOldCredentialsId();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Then return {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#findDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  public void testFindDeviceCredentialsByDeviceId_thenReturnDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);

    // Act
    DeviceCredentials actualFindDeviceCredentialsByDeviceIdResult =
        deviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(
            ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceCredentials, actualFindDeviceCredentialsByDeviceIdResult);
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#findDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  public void testFindDeviceCredentialsByDeviceId_thenThrowDataValidationException() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(
                ModelConstants.SYSTEM_TENANT, deviceId));
    verify(deviceId).getId();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}.
   *
   * <ul>
   *   <li>Then return {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId(String)"
  })
  public void testFindDeviceCredentialsByCredentialsId_thenReturnDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<String>any(), Mockito.<Supplier<DeviceCredentials>>any(), anyBoolean()))
        .thenReturn(deviceCredentials);

    // Act
    DeviceCredentials actualFindDeviceCredentialsByCredentialsIdResult =
        deviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId("42");

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(eq("42"), isA(Supplier.class), eq(true));
    assertSame(deviceCredentials, actualFindDeviceCredentialsByCredentialsIdResult);
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId(String)"
  })
  public void testFindDeviceCredentialsByCredentialsId_thenThrowDataValidationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<String>any(), Mockito.<Supplier<DeviceCredentials>>any(), anyBoolean()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId("42"));
    verify(tbTransactionalCache).getAndPutInTransaction(eq("42"), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials2() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials3() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentials deviceCredentials3 =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials3.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials3.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials4() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentialsDao deviceCredentialsDao = mock(DeviceCredentialsDao.class);
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(deviceCredentialsDao, credentialsValidator);

    DeviceCredentials deviceCredentials2 =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials2.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));
    deviceCredentials2.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(deviceCredentials, atLeast(1)).getCredentialsId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code Device Credentials}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_givenDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_givenDeviceId() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setDeviceId(mock(DeviceId.class));
    deviceCredentials.setCredentialsValue("42");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_givenEmptyString() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setDeviceId(mock(DeviceId.class));
    deviceCredentials.setCredentialsValue("");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_givenLwm2mCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.LWM2M_CREDENTIALS);
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_givenLwm2mCredentials2() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.LWM2M_CREDENTIALS);
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_givenMqttBasic() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_thenCallsGetId() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_thenCallsGetId2() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue("42");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testUpdateDeviceCredentials_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setDeviceId(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials2() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.LWM2M_CREDENTIALS);
    deviceCredentials.setDeviceId(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials4() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials5() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceCredentials deviceCredentials3 =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials3.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials6() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(new JpaDeviceCredentialsDao(), credentialsValidator);

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getDeviceId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials7() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            new JpaDeviceCredentialsDao(), mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceCredentials)
        .setCredentialsId(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials)
        .setCredentialsId("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa");
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials8() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            new JpaDeviceCredentialsDao(), mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials9() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            new JpaDeviceCredentialsDao(), mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType())
        .thenReturn(DeviceCredentialsType.LWM2M_CREDENTIALS);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_given42() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(new JpaDeviceCredentialsDao(), credentialsValidator);

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getDeviceId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa");
    verify(deviceCredentials).setCredentialsValue("42");
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code -----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_givenBeginCertificate() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(new JpaDeviceCredentialsDao(), credentialsValidator);

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----BEGIN CERTIFICATE-----");
    when(deviceCredentials.getDeviceId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code -----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_givenBeginCertificate2() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            new JpaDeviceCredentialsDao(), mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----BEGIN CERTIFICATE-----");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given cr.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_givenCr() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(new JpaDeviceCredentialsDao(), credentialsValidator);

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("\r");
    when(deviceCredentials.getDeviceId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code -----END CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_givenEndCertificate() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(new JpaDeviceCredentialsDao(), credentialsValidator);

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----END CERTIFICATE-----");
    when(deviceCredentials.getDeviceId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_givenLf() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(new JpaDeviceCredentialsDao(), credentialsValidator);

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("\n");
    when(deviceCredentials.getDeviceId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_givenLf2() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            new JpaDeviceCredentialsDao(), mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("\n");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_thenCallsGetId() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(deviceId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentialsDataValidator)
        .validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testCreateDeviceCredentials_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("Device Credentials");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals(
        "3a536bbaaf6713ab6fa2af0ba15b2d060cf9baf9424ccacda6e557ce0a5e116c",
        deviceCredentials.getCredentialsId());
    assertEquals("Device Credentials", deviceCredentials.getCredentialsValue());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials2() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("-----BEGIN CERTIFICATE-----42");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("42", deviceCredentials.getCredentialsValue());
    assertEquals(
        "4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_given42() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue("42");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42-----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_given42BeginCertificate() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("42-----BEGIN CERTIFICATE-----");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("42", deviceCredentials.getCredentialsValue());
    assertEquals(
        "4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42-----END CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_given42EndCertificate() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("42-----END CERTIFICATE-----");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("42", deviceCredentials.getCredentialsValue());
    assertEquals(
        "4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_given422() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("42\n");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("42", deviceCredentials.getCredentialsValue());
    assertEquals(
        "4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_given423() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("42\r");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("42", deviceCredentials.getCredentialsValue());
    assertEquals(
        "4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>Then {@link DeviceCredentials#DeviceCredentials()} CredentialsId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenAccessToken_thenDeviceCredentialsCredentialsIdIsNull() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert that nothing has changed
    assertNull(deviceCredentials.getCredentialsId());
    assertNull(deviceCredentials.getCredentialsValue());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code -----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenBeginCertificate() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("-----BEGIN CERTIFICATE-----");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("", deviceCredentials.getCredentialsValue());
    assertEquals(
        "a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given cr.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenCr() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("\r");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("", deviceCredentials.getCredentialsValue());
    assertEquals(
        "a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code Device Credentials}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code -----END CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenEndCertificate() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("-----END CERTIFICATE-----");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("", deviceCredentials.getCredentialsValue());
    assertEquals(
        "a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenLf() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("\n");

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    assertEquals("", deviceCredentials.getCredentialsValue());
    assertEquals(
        "a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a",
        deviceCredentials.getCredentialsId());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenLf2() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue("\n");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenLwm2mCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.LWM2M_CREDENTIALS);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenLwm2mCredentials2() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.LWM2M_CREDENTIALS);
    deviceCredentials.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  public void testFormatCredentials_givenNull() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);

    // Act and Assert
    assertThrows(
        DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("Device Credentials");
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"Device Credentials\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo2() throws JsonProcessingException {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    String credentialsValue = jsonMapper.writeValueAsString(new ArrayNode(nf));
    deviceCredentials.setCredentialsValue(credentialsValue);
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof ArrayNode);
    assertEquals("[ ]", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(0, actualToCredentialsInfoResult.size());
    assertFalse(actualToCredentialsInfoResult.elements().hasNext());
    assertTrue(actualToCredentialsInfoResult.isEmpty());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return toPrettyString is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_given42_thenReturnToPrettyStringIs42() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue("42");
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof IntNode);
    assertEquals("42", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualToCredentialsInfoResult.getNodeType());
    assertFalse(((IntNode) actualToCredentialsInfoResult).isNaN());
    assertTrue(actualToCredentialsInfoResult.isInt());
    assertTrue(actualToCredentialsInfoResult.isIntegralNumber());
    assertTrue(actualToCredentialsInfoResult.isNumber());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code ACCESS_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_givenAccessToken() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(null);
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertSame(((NullNode) actualToCredentialsInfoResult).instance, actualToCredentialsInfoResult);
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given builder findAndAddModules build writeValueAsString {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_givenBuilderFindAndAddModulesBuildWriteValueAsStringNull()
      throws JsonProcessingException {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(null));
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertSame(((NullNode) actualToCredentialsInfoResult).instance, actualToCredentialsInfoResult);
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then elements next iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenElementsNextIteratorNextReturnBooleanNode()
      throws JsonProcessingException {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(arrayNode);

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof ArrayNode);
    Iterator<JsonNode> elementsResult = actualToCredentialsInfoResult.elements();
    JsonNode nextResult = elementsResult.next();
    Iterator<JsonNode> iteratorResult = nextResult.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertEquals("[ {\n  \"isPublic\" : true\n} ]", actualToCredentialsInfoResult.toPrettyString());
    assertEquals("{\n  \"isPublic\" : true\n}", nextResult.toPrettyString());
    assertEquals(1, nextResult.size());
    assertEquals(1, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertFalse(nextResult.isEmpty());
    assertFalse(elementsResult.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isObject());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then iterator next return {@link BooleanNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenIteratorNextReturnBooleanNode()
      throws JsonProcessingException {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder()
            .findAndAddModules()
            .build()
            .writeValueAsString(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    Iterator<JsonNode> iteratorResult = actualToCredentialsInfoResult.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(actualToCredentialsInfoResult instanceof ObjectNode);
    assertEquals("{\n  \"isPublic\" : true\n}", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(1, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.OBJECT, actualToCredentialsInfoResult.getNodeType());
    assertFalse(actualToCredentialsInfoResult.isEmpty());
    assertFalse(iteratorResult.hasNext());
    assertTrue(actualToCredentialsInfoResult.isObject());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return {@link NullNode#instance}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenReturnInstance() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue(null);
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertSame(((NullNode) actualToCredentialsInfoResult).instance, actualToCredentialsInfoResult);
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenReturnNull() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);
    deviceCredentials.setCredentialsId(null);

    // Act and Assert
    assertNull(deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return toPrettyString is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenReturnToPrettyStringIs1() throws JsonProcessingException {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(1));
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof IntNode);
    assertEquals("1", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualToCredentialsInfoResult.getNodeType());
    assertFalse(((IntNode) actualToCredentialsInfoResult).isNaN());
    assertTrue(actualToCredentialsInfoResult.isInt());
    assertTrue(actualToCredentialsInfoResult.isIntegralNumber());
    assertTrue(actualToCredentialsInfoResult.isNumber());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return toPrettyString is {@code "Device Credentials"}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenReturnToPrettyStringIsDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("Device Credentials");
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"Device Credentials\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Then return toPrettyString is {@code ""}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  public void testToCredentialsInfo_thenReturnToPrettyStringIsQuotationMarkQuotationMark() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("");
    deviceCredentials.setCredentialsId(null);

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#deleteDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#deleteDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentials(TenantId, DeviceCredentials)"
  })
  public void testDeleteDeviceCredentials_givenTbTransactionalCache() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceCredentialsDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.deleteDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).removeById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId,
   * DeviceId)}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  public void testDeleteDeviceCredentialsByDeviceId() {
    // Arrange
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(
                ModelConstants.SYSTEM_TENANT, null));
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId,
   * DeviceId)}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  public void testDeleteDeviceCredentialsByDeviceId2() {
    // Arrange
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);

    // Act
    deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(
        ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId,
   * DeviceId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceCredentials#getCredentialsId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  public void testDeleteDeviceCredentialsByDeviceId_thenCallsGetCredentialsId() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(deviceCredentials);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(
                ModelConstants.SYSTEM_TENANT, null));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }
}
