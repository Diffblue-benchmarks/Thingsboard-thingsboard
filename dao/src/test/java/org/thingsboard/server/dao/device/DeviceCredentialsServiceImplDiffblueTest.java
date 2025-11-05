package org.thingsboard.server.dao.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
@ExtendWith(SpringExtension.class)
class DeviceCredentialsServiceImplDiffblueTest {
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
  @DisplayName(
      "Test handleEvictEvent(DeviceCredentialsEvictEvent) with 'DeviceCredentialsEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  void testHandleEvictEventWithDeviceCredentialsEvictEvent() {
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
  @DisplayName(
      "Test handleEvictEvent(DeviceCredentialsEvictEvent) with 'DeviceCredentialsEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  void testHandleEvictEventWithDeviceCredentialsEvictEvent2() {
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
  @DisplayName(
      "Test handleEvictEvent(DeviceCredentialsEvictEvent) with 'DeviceCredentialsEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  void testHandleEvictEventWithDeviceCredentialsEvictEvent3() {
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
  @DisplayName(
      "Test handleEvictEvent(DeviceCredentialsEvictEvent) with 'DeviceCredentialsEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.handleEvictEvent(DeviceCredentialsEvictEvent)"
  })
  void testHandleEvictEventWithDeviceCredentialsEvictEvent4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("42", ""));

    // Assert
    verify(tbTransactionalCache).evict("42");
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
  @DisplayName(
      "Test findDeviceCredentialsByDeviceId(TenantId, DeviceId); then return DeviceCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  void testFindDeviceCredentialsByDeviceId_thenReturnDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);

    // Act
    DeviceCredentials actualFindDeviceCredentialsByDeviceIdResult =
        deviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(
            ModelConstants.SYSTEM_TENANT,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @DisplayName(
      "Test findDeviceCredentialsByDeviceId(TenantId, DeviceId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  void testFindDeviceCredentialsByDeviceId_thenThrowDataValidationException() {
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
  @DisplayName("Test findDeviceCredentialsByCredentialsId(String); then return DeviceCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId(String)"
  })
  void testFindDeviceCredentialsByCredentialsId_thenReturnDeviceCredentials() {
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
  @DisplayName(
      "Test findDeviceCredentialsByCredentialsId(String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId(String)"
  })
  void testFindDeviceCredentialsByCredentialsId_thenThrowDataValidationException() {
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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials2() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(null);
    deviceCredentials.setCredentialsValue("Device Credentials");

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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "device_credentials_id_unq_key");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials2 = new DeviceCredentials(id);
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials2.setDeviceId(null);
    deviceCredentials2.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache)
        .evict("3a536bbaaf6713ab6fa2af0ba15b2d060cf9baf9424ccacda6e557ce0a5e116c");
    verify(deviceCredentials).getCredentialsId();
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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials2 = new DeviceCredentials(id);
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials2.setDeviceId(null);
    deviceCredentials2.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache)
        .evict("3a536bbaaf6713ab6fa2af0ba15b2d060cf9baf9424ccacda6e557ce0a5e116c");
    verify(deviceCredentials).getCredentialsId();
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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "device_credentials_device_id_unq_key");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials2 = new DeviceCredentials(id);
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials2.setDeviceId(null);
    deviceCredentials2.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache)
        .evict("3a536bbaaf6713ab6fa2af0ba15b2d060cf9baf9424ccacda6e557ce0a5e116c");
    verify(deviceCredentials).getCredentialsId();
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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials6() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials2 = new DeviceCredentials(id);
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials2.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials2.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache)
        .evict("3a536bbaaf6713ab6fa2af0ba15b2d060cf9baf9424ccacda6e557ce0a5e116c");
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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials7() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials.setCredentialsValue("Device Credentials");

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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials8() {
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
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials3.setCredentialsValue("Device Credentials");

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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials9() {
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
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials2 = new DeviceCredentials(id);
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials2.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials2.setCredentialsValue("Device Credentials");

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
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_given42() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue("42\n");

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
   *   <li>Given {@code 42-----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given '42-----BEGIN CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_given42BeginCertificate() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue("42-----BEGIN CERTIFICATE-----");

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
   *   <li>Given {@code 42-----END CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given '42-----END CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_given42EndCertificate() {
    // Arrange
    DeviceCredentialsDataValidator credentialsValidator =
        mock(DeviceCredentialsDataValidator.class);
    when(credentialsValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(mock(DeviceCredentialsDao.class), credentialsValidator);

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue("42-----END CERTIFICATE-----");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(credentialsValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_given422() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue("42\r");

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
   *   <li>Given {@code -----BEGIN CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given '-----BEGIN CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenBeginCertificate() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials3.setCredentialsValue("-----BEGIN CERTIFICATE-----");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
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
   * <ul>
   *   <li>Given cr.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenCr() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials3.setCredentialsValue("\r");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
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
   * <ul>
   *   <li>Given {@link DeviceCredentials} {@link DeviceCredentials#getCredentialsId()} return
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given DeviceCredentials getCredentialsId() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenDeviceCredentialsGetCredentialsIdReturn42() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials3.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
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
   * <ul>
   *   <li>Given {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenDeviceId() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setDeviceId(mock(DeviceId.class));
    deviceCredentials.setCredentialsValue("42\n");

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
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenEmptyString() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code -----END CERTIFICATE-----}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given '-----END CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenEndCertificate() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials3.setCredentialsValue("-----END CERTIFICATE-----");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
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
   * <ul>
   *   <li>Given lf.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenLf() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    deviceCredentials3.setCredentialsValue("\n");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
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
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given 'LWM2M_CREDENTIALS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenLwm2mCredentials() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); given 'LWM2M_CREDENTIALS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenLwm2mCredentials2() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code MQTT_BASIC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); given 'MQTT_BASIC'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_givenMqttBasic() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Then calls {@link DeviceId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test updateDeviceCredentials(TenantId, DeviceCredentials); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_thenCallsGetId() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setDeviceId(deviceId);
    deviceCredentials.setCredentialsValue("Device Credentials");

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
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_thenThrowConstraintViolationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(deviceCredentials.getCredentialsId()).thenThrow(constraintViolationException);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials2 = new DeviceCredentials(id);
    deviceCredentials2.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials2.setDeviceId(null);
    deviceCredentials2.setCredentialsValue("Device Credentials");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.updateDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache)
        .evict("3a536bbaaf6713ab6fa2af0ba15b2d060cf9baf9424ccacda6e557ce0a5e116c");
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
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
  @DisplayName(
      "Test updateDeviceCredentials(TenantId, DeviceCredentials); when DeviceCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.updateDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testUpdateDeviceCredentials_whenDeviceCredentials() {
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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials2() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials3() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials4() {
    // Arrange
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials5() {
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
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials3 = new DeviceCredentials(id);
    deviceCredentials3.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials3.setDeviceId(
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials6() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(
            Mockito.<DeviceCredentials>any(), Mockito.<Function<DeviceCredentials, TenantId>>any()))
        .thenReturn(new DeviceCredentials());

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials7() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());

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
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials8() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            new JpaDeviceCredentialsDao(), mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing updateDeviceCredentials [{}]");
    when(deviceCredentials.getDeviceId()).thenThrow(constraintViolationException);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials9() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = mock(JpaDeviceCredentialsDao.class);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getDeviceId())
        .thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials10() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));

    JpaDeviceCredentialsDao deviceCredentialsDao = mock(JpaDeviceCredentialsDao.class);
    when(deviceCredentialsDao.saveAndFlush(
            Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, mock(DeviceCredentialsDataValidator.class));

    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId())
        .thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials2.getDeviceId())
        .thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials11() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials12() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials13() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_given42() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getDeviceId()).thenReturn(deviceId);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa");
    verify(deviceCredentials).setCredentialsValue("42");
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
  @DisplayName(
      "Test createDeviceCredentials(TenantId, DeviceCredentials); given '-----BEGIN CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_givenBeginCertificate() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----BEGIN CERTIFICATE-----");
    when(deviceCredentials.getDeviceId()).thenReturn(deviceId);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
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
  @DisplayName(
      "Test createDeviceCredentials(TenantId, DeviceCredentials); given '-----BEGIN CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_givenBeginCertificate2() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials); given cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_givenCr() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("\r");
    when(deviceCredentials.getDeviceId()).thenReturn(deviceId);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
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
  @DisplayName(
      "Test createDeviceCredentials(TenantId, DeviceCredentials); given '-----END CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_givenEndCertificate() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----END CERTIFICATE-----");
    when(deviceCredentials.getDeviceId()).thenReturn(deviceId);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_givenLf() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

    DeviceId deviceId = mock(DeviceId.class);
    when(deviceId.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("\n");
    when(deviceCredentials.getDeviceId()).thenReturn(deviceId);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceCredentialsServiceImpl.createDeviceCredentials(
                ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceId).getId();
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials, atLeast(1)).getDeviceId();
    verify(deviceCredentials)
        .setCredentialsId("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a");
    verify(deviceCredentials).setCredentialsValue("");
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
  @DisplayName("Test createDeviceCredentials(TenantId, DeviceCredentials); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_givenLf2() {
    // Arrange
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            mock(JpaDeviceCredentialsDao.class), mock(DeviceCredentialsDataValidator.class));

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
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId,
   * DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test createDeviceCredentials(TenantId, DeviceCredentials); when DeviceCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceCredentials DeviceCredentialsServiceImpl.createDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testCreateDeviceCredentials_whenDeviceCredentials() {
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
  @DisplayName("Test formatCredentials(DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials2() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test formatCredentials(DeviceCredentials); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_given42() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given '42-----BEGIN CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_given42BeginCertificate() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given '42-----END CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_given42EndCertificate() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_given422() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code ACCESS_TOKEN}.
   *   <li>Then {@link DeviceCredentials#DeviceCredentials()} CredentialsId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test formatCredentials(DeviceCredentials); given 'ACCESS_TOKEN'; then DeviceCredentials() CredentialsId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenAccessToken_thenDeviceCredentialsCredentialsIdIsNull() {
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given '-----BEGIN CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenBeginCertificate() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code -----BEGIN CERTIFICATE-----42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test formatCredentials(DeviceCredentials); given '-----BEGIN CERTIFICATE-----42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenBeginCertificate42() {
    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsServiceImpl =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given cr.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test formatCredentials(DeviceCredentials); given cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenCr() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given 'Device Credentials'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenDeviceCredentials() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given '-----END CERTIFICATE-----'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenEndCertificate() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenLf() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenLf2() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test formatCredentials(DeviceCredentials); given 'LWM2M_CREDENTIALS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenLwm2mCredentials() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code LWM2M_CREDENTIALS}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test formatCredentials(DeviceCredentials); given 'LWM2M_CREDENTIALS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenLwm2mCredentials2() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test formatCredentials(DeviceCredentials); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsServiceImpl.formatCredentials(DeviceCredentials)"})
  void testFormatCredentials_givenNull() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
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
  @DisplayName("Test toCredentialsInfo(DeviceCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo() throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
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
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals(0, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertFalse(actualToCredentialsInfoResult.isContainerNode());
    assertTrue(actualToCredentialsInfoResult.isEmpty());
    assertTrue(actualToCredentialsInfoResult.isTextual());
    assertTrue(actualToCredentialsInfoResult.isValueNode());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toCredentialsInfo(DeviceCredentials); given '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_given42() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue("42");
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof IntNode);
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
  @DisplayName("Test toCredentialsInfo(DeviceCredentials); given 'ACCESS_TOKEN'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_givenAccessToken() throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder()
            .findAndAddModules()
            .build()
            .writeValueAsString(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals(0, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertFalse(actualToCredentialsInfoResult.isContainerNode());
    assertTrue(actualToCredentialsInfoResult.isEmpty());
    assertTrue(actualToCredentialsInfoResult.isTextual());
    assertTrue(actualToCredentialsInfoResult.isValueNode());
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
  @DisplayName(
      "Test toCredentialsInfo(DeviceCredentials); given builder findAndAddModules build writeValueAsString 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_givenBuilderFindAndAddModulesBuildWriteValueAsStringNull()
      throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(null));
    deviceCredentials.setCredentialsId("Device Credentials");

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
   *   <li>Given builder findAndAddModules build writeValueAsString one.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test toCredentialsInfo(DeviceCredentials); given builder findAndAddModules build writeValueAsString one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_givenBuilderFindAndAddModulesBuildWriteValueAsStringOne()
      throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(1));
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof IntNode);
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
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @DisplayName("Test toCredentialsInfo(DeviceCredentials); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_givenEmptyString() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue("");
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals(0, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertFalse(actualToCredentialsInfoResult.isContainerNode());
    assertTrue(actualToCredentialsInfoResult.isEmpty());
    assertTrue(actualToCredentialsInfoResult.isTextual());
    assertTrue(actualToCredentialsInfoResult.isValueNode());
  }

  /**
   * Test {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   *
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.
   *   <li>Then return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test toCredentialsInfo(DeviceCredentials); given 'X509_CERTIFICATE'; then return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_givenX509Certificate_thenReturnTextNode()
      throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder()
            .findAndAddModules()
            .build()
            .writeValueAsString(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals(0, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertFalse(actualToCredentialsInfoResult.isContainerNode());
    assertTrue(actualToCredentialsInfoResult.isEmpty());
    assertTrue(actualToCredentialsInfoResult.isTextual());
    assertTrue(actualToCredentialsInfoResult.isValueNode());
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
  @DisplayName(
      "Test toCredentialsInfo(DeviceCredentials); then elements next iterator next return BooleanNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_thenElementsNextIteratorNextReturnBooleanNode()
      throws JsonProcessingException {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode arrayNode = new ArrayNode(nf);
    arrayNode.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    String credentialsValue =
        JsonMapper.builder().findAndAddModules().build().writeValueAsString(arrayNode);
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(credentialsValue);
    deviceCredentials.setCredentialsId("Device Credentials");

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
    assertEquals(1, nextResult.size());
    assertEquals(1, actualToCredentialsInfoResult.size());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertFalse(nextResult.isArray());
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
  @DisplayName("Test toCredentialsInfo(DeviceCredentials); then iterator next return BooleanNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_thenIteratorNextReturnBooleanNode() throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(
        JsonMapper.builder()
            .findAndAddModules()
            .build()
            .writeValueAsString(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    Iterator<JsonNode> iteratorResult = actualToCredentialsInfoResult.iterator();
    assertTrue(iteratorResult.next() instanceof BooleanNode);
    assertTrue(actualToCredentialsInfoResult instanceof ObjectNode);
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
   *   <li>Then return {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  @DisplayName(
      "Test toCredentialsInfo(DeviceCredentials); then return ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_thenReturnArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws JsonProcessingException {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode arrayNode = new ArrayNode(nf);
    String credentialsValue = jsonMapper.writeValueAsString(arrayNode);
    deviceCredentials.setCredentialsValue(credentialsValue);
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act
    JsonNode actualToCredentialsInfoResult =
        deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertTrue(actualToCredentialsInfoResult instanceof ArrayNode);
    assertEquals(arrayNode, actualToCredentialsInfoResult);
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
  @DisplayName("Test toCredentialsInfo(DeviceCredentials); then return instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_thenReturnInstance() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentials.setCredentialsValue(null);
    deviceCredentials.setCredentialsId("Device Credentials");

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
  @DisplayName("Test toCredentialsInfo(DeviceCredentials); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode DeviceCredentialsServiceImpl.toCredentialsInfo(DeviceCredentials)"})
  void testToCredentialsInfo_thenReturnNull() {
    // Arrange
    DeviceCredentialsId id =
        new DeviceCredentialsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceCredentials deviceCredentials = new DeviceCredentials(id);
    deviceCredentials.setCredentialsType(DeviceCredentialsType.MQTT_BASIC);
    deviceCredentials.setCredentialsValue(null);
    deviceCredentials.setCredentialsId("Device Credentials");

    // Act and Assert
    assertNull(deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials));
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
  @DisplayName(
      "Test deleteDeviceCredentials(TenantId, DeviceCredentials); given TbTransactionalCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentials(TenantId, DeviceCredentials)"
  })
  void testDeleteDeviceCredentials_givenTbTransactionalCache() {
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
  @DisplayName("Test deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  void testDeleteDeviceCredentialsByDeviceId() {
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
  @DisplayName("Test deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  void testDeleteDeviceCredentialsByDeviceId2() {
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
  @DisplayName(
      "Test deleteDeviceCredentialsByDeviceId(TenantId, DeviceId); then calls getCredentialsId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)"
  })
  void testDeleteDeviceCredentialsByDeviceId_thenCallsGetCredentialsId() {
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
