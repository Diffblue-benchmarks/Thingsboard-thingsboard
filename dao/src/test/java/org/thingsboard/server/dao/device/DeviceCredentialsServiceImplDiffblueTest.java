package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.sql.SQLException;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.DeviceCredentialsValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;

@ContextConfiguration(classes = {DeviceCredentialsServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DeviceCredentialsServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DeviceCredentialsDao deviceCredentialsDao;

  @MockBean
  private DeviceCredentialsDataValidator deviceCredentialsDataValidator;

  @Autowired
  private DeviceCredentialsServiceImpl deviceCredentialsServiceImpl;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<String, DeviceCredentials> tbTransactionalCache;

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   * with {@code DeviceCredentialsEvictEvent}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("42", "42"));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(eq("42"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   * with {@code DeviceCredentialsEvictEvent}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("New Cedentials Id", "42"));

    // Assert that nothing has changed
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   * with {@code DeviceCredentialsEvictEvent}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act
    deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("42", ""));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(eq("42"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   * with {@code DeviceCredentialsEvictEvent}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#handleEvictEvent(DeviceCredentialsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithDeviceCredentialsEvictEvent4() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache).evict(Mockito.<String>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.handleEvictEvent(new DeviceCredentialsEvictEvent("42", "42")));
    verify(tbTransactionalCache).evict(eq("42"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   * <ul>
   *   <li>Then return {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  public void testFindDeviceCredentialsByDeviceId_thenReturnDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);

    // Act
    DeviceCredentials actualFindDeviceCredentialsByDeviceIdResult = deviceCredentialsServiceImpl
        .findDeviceCredentialsByDeviceId(ModelConstants.SYSTEM_TENANT, new DeviceId(ModelConstants.NULL_UUID));

    // Assert
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    assertSame(deviceCredentials, actualFindDeviceCredentialsByDeviceIdResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}.
   * <ul>
   *   <li>Then return {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}
   */
  @Test
  public void testFindDeviceCredentialsByCredentialsId_thenReturnDeviceCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<String>any(), Mockito.<Supplier<DeviceCredentials>>any(),
        anyBoolean())).thenReturn(deviceCredentials);

    // Act
    DeviceCredentials actualFindDeviceCredentialsByCredentialsIdResult = deviceCredentialsServiceImpl
        .findDeviceCredentialsByCredentialsId("42");

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(eq("42"), isA(Supplier.class), eq(true));
    assertSame(deviceCredentials, actualFindDeviceCredentialsByCredentialsIdResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#findDeviceCredentialsByCredentialsId(String)}
   */
  @Test
  public void testFindDeviceCredentialsByCredentialsId_thenThrowDataValidationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<String>any(), Mockito.<Supplier<DeviceCredentials>>any(),
        anyBoolean())).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.findDeviceCredentialsByCredentialsId("42"));
    verify(tbTransactionalCache).getAndPutInTransaction(eq("42"), isA(Supplier.class), eq(true));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getDeviceId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    DeviceCredentials actualUpdateDeviceCredentialsResult = deviceCredentialsServiceImpl
        .updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2);

    // Assert
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
    assertSame(deviceCredentials, actualUpdateDeviceCredentialsResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials2.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("Executing updateDeviceCredentials [{}]");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials6() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "device_credentials_id_unq_key"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials7() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "device_credentials_device_id_unq_key"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials8() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceCredentials} {@link DeviceCredentials#getDeviceId()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials_givenNull_whenDeviceCredentialsGetDeviceIdReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentials2.getDeviceId()).thenReturn(null);
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2).getDeviceId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.</li>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials_givenTbTransactionalCache_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> deviceCredentialsServiceImpl
        .updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then return {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials_thenReturnDeviceCredentials() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getDeviceId()).thenReturn(null);
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    DeviceCredentials actualUpdateDeviceCredentialsResult = deviceCredentialsServiceImpl
        .updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2);

    // Assert
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2).getDeviceId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
    assertSame(deviceCredentials, actualUpdateDeviceCredentialsResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials_thenThrowConstraintViolationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then throw {@link DeviceCredentialsValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#updateDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testUpdateDeviceCredentials_thenThrowDeviceCredentialsValidationException() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred")).when(deviceCredentials)
        .setCredentialsId(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.updateDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials() {
    // Arrange
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getDeviceId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getDeviceId();
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    DeviceCredentials actualCreateDeviceCredentialsResult = deviceCredentialsServiceImpl
        .createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2);

    // Assert
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
    assertSame(deviceCredentials, actualCreateDeviceCredentialsResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(new DeviceCredentials());
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials2.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials4() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("Executing updateDeviceCredentials [{}]");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<String>any());
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials5() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials6() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "device_credentials_id_unq_key"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials7() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "device_credentials_device_id_unq_key"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials8() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link DeviceCredentials} {@link DeviceCredentials#getDeviceId()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials_givenNull_whenDeviceCredentialsGetDeviceIdReturnNull() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentials2.getDeviceId()).thenReturn(null);
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2).getDeviceId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.</li>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials_givenTbTransactionalCache_whenDeviceCredentials() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> deviceCredentialsServiceImpl
        .createDeviceCredentials(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then return {@link DeviceCredentials#DeviceCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials_thenReturnDeviceCredentials() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getDeviceId()).thenReturn(null);
    when(deviceCredentials2.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    DeviceCredentials actualCreateDeviceCredentialsResult = deviceCredentialsServiceImpl
        .createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials2);

    // Assert
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentials2, atLeast(1)).getCredentialsType();
    verify(deviceCredentials2).getDeviceId();
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
    assertSame(deviceCredentials, actualCreateDeviceCredentialsResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials_thenThrowConstraintViolationException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new ConstraintViolationException("An error occurred",
        new SQLException(), "Executing updateDeviceCredentials [{}]"));
    DeviceCredentials deviceCredentials2 = mock(DeviceCredentials.class);
    when(deviceCredentials2.getCredentialsId()).thenReturn("42");
    when(deviceCredentialsDao.findByDeviceId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceCredentials2);
    when(deviceCredentialsDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<DeviceCredentials>any()))
        .thenReturn(deviceCredentials);
    when(deviceCredentialsDataValidator.validate(Mockito.<DeviceCredentials>any(),
        Mockito.<Function<DeviceCredentials, TenantId>>any())).thenReturn(new DeviceCredentials());
    DeviceCredentials deviceCredentials3 = mock(DeviceCredentials.class);
    when(deviceCredentials3.getCredentialsId()).thenReturn("42");
    when(deviceCredentials3.getDeviceId()).thenReturn(new DeviceId(ModelConstants.NULL_UUID));
    when(deviceCredentials3.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials3));
    verify(tbTransactionalCache).evict(eq("42"));
    verify(deviceCredentials2).getCredentialsId();
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials3).getCredentialsId();
    verify(deviceCredentials3, atLeast(1)).getCredentialsType();
    verify(deviceCredentials3, atLeast(1)).getDeviceId();
    verify(deviceCredentialsDao).findByDeviceId(isA(TenantId.class), isA(UUID.class));
    verify(deviceCredentialsDao).saveAndFlush(isA(TenantId.class), isA(DeviceCredentials.class));
    verify(deviceCredentialsDataValidator).validate(isA(DeviceCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then throw {@link DeviceCredentialsValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#createDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testCreateDeviceCredentials_thenThrowDeviceCredentialsValidationException() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred")).when(deviceCredentials)
        .setCredentialsId(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.createDeviceCredentials(ModelConstants.SYSTEM_TENANT, deviceCredentials));
    verify(deviceCredentials, atLeast(1)).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doThrow(new DeviceCredentialsValidationException("An error occurred")).when(deviceCredentials)
        .setCredentialsId(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then calls {@link DeviceCredentials#setCredentialsValue(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_given42_thenCallsSetCredentialsValue() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("4e169ddf479c8cd9b4c45e0284181730cb42df3a8be892a7f379bd690db1eafa"));
    verify(deviceCredentials).setCredentialsValue(eq("42"));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenBeginCertificate() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----BEGIN CERTIFICATE-----");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a"));
    verify(deviceCredentials).setCredentialsValue(eq(""));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code -----BEGIN CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenBeginCertificate2() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----BEGIN CERTIFICATE-----");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given cr.</li>
   *   <li>When {@link DeviceCredentials}
   * {@link DeviceCredentials#getCredentialsValue()} return cr.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenCr_whenDeviceCredentialsGetCredentialsValueReturnCr() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("\r");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a"));
    verify(deviceCredentials).setCredentialsValue(eq(""));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code -----END CERTIFICATE-----}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenEndCertificate() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("-----END CERTIFICATE-----");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a"));
    verify(deviceCredentials).setCredentialsValue(eq(""));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given lf.</li>
   *   <li>When {@link DeviceCredentials}
   * {@link DeviceCredentials#getCredentialsValue()} return lf.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenLf_whenDeviceCredentialsGetCredentialsValueReturnLf() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    doNothing().when(deviceCredentials).setCredentialsId(Mockito.<String>any());
    doNothing().when(deviceCredentials).setCredentialsValue(Mockito.<String>any());
    when(deviceCredentials.getCredentialsValue()).thenReturn("\n");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    verify(deviceCredentials).setCredentialsId(eq("a7ffc6f8bf1ed76651c14756a061d662f580ff4de43b49fa82d80a4b80f8434a"));
    verify(deviceCredentials).setCredentialsValue(eq(""));
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given lf.</li>
   *   <li>When {@link DeviceCredentials}
   * {@link DeviceCredentials#getCredentialsValue()} return lf.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenLf_whenDeviceCredentialsGetCredentialsValueReturnLf2() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("\n");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code LWM2M_CREDENTIALS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenLwm2mCredentials() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.LWM2M_CREDENTIALS);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenMqttBasic() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code MQTT_BASIC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_givenMqttBasic2() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(DeviceCredentialsValidationException.class,
        () -> deviceCredentialsServiceImpl.formatCredentials(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}.
   * <ul>
   *   <li>When {@link DeviceCredentials}
   * {@link DeviceCredentials#getCredentialsType()} return
   * {@code ACCESS_TOKEN}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#formatCredentials(DeviceCredentials)}
   */
  @Test
  public void testFormatCredentials_whenDeviceCredentialsGetCredentialsTypeReturnAccessToken() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    deviceCredentialsServiceImpl.formatCredentials(deviceCredentials);

    // Assert that nothing has changed
    verify(deviceCredentials).getCredentialsType();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo2() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_givenX509Certificate() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials));
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Given {@code X509_CERTIFICATE}.</li>
   *   <li>Then return toPrettyString is {@code "42"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_givenX509Certificate_thenReturnToPrettyStringIs42() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.X509_CERTIFICATE);

    // Act
    JsonNode actualToCredentialsInfoResult = deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"42\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_thenReturnInstance() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    deviceCredentials.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    JsonNode actualToCredentialsInfoResult = deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    assertSame(((NullNode) actualToCredentialsInfoResult).instance, actualToCredentialsInfoResult);
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Then return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_thenReturnIntNode() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsValue()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.MQTT_BASIC);

    // Act
    JsonNode actualToCredentialsInfoResult = deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsType();
    verify(deviceCredentials).getCredentialsValue();
    assertTrue(actualToCredentialsInfoResult instanceof IntNode);
    assertEquals("42", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualToCredentialsInfoResult.getNodeType());
    assertFalse(((IntNode) actualToCredentialsInfoResult).isNaN());
    assertTrue(actualToCredentialsInfoResult.isInt());
    assertTrue(actualToCredentialsInfoResult.isIntegralNumber());
    assertTrue(actualToCredentialsInfoResult.isNumber());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Then return toPrettyString is {@code "42"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_thenReturnToPrettyStringIs42() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("42");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    JsonNode actualToCredentialsInfoResult = deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"42\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Then return toPrettyString is {@code "foo"}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_thenReturnToPrettyStringIsFoo() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("foo");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    JsonNode actualToCredentialsInfoResult = deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"foo\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}.
   * <ul>
   *   <li>Then return toPrettyString is {@code ""}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#toCredentialsInfo(DeviceCredentials)}
   */
  @Test
  public void testToCredentialsInfo_thenReturnToPrettyStringIsQuotationMarkQuotationMark() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenReturn("");
    when(deviceCredentials.getCredentialsType()).thenReturn(DeviceCredentialsType.ACCESS_TOKEN);

    // Act
    JsonNode actualToCredentialsInfoResult = deviceCredentialsServiceImpl.toCredentialsInfo(deviceCredentials);

    // Assert
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentials).getCredentialsType();
    assertTrue(actualToCredentialsInfoResult instanceof TextNode);
    assertEquals("\"\"", actualToCredentialsInfoResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToCredentialsInfoResult.getNodeType());
    assertTrue(actualToCredentialsInfoResult.isTextual());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testDeleteDeviceCredentials_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    doNothing().when(deviceCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    deviceCredentialsServiceImpl.deleteDeviceCredentials(ModelConstants.SYSTEM_TENANT, new DeviceCredentials());

    // Assert
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentialsDao).removeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentials(TenantId, DeviceCredentials)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentials(TenantId, DeviceCredentials)}
   */
  @Test
  public void testDeleteDeviceCredentials_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(deviceCredentialsDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> deviceCredentialsServiceImpl
        .deleteDeviceCredentials(ModelConstants.SYSTEM_TENANT, new DeviceCredentials()));
    verify(deviceCredentialsDao).removeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  public void testDeleteDeviceCredentialsByDeviceId() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache).evict(Mockito.<String>any());
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(ModelConstants.SYSTEM_TENANT, null));
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  public void testDeleteDeviceCredentialsByDeviceId2() {
    // Arrange
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);

    // Act
    deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(ModelConstants.SYSTEM_TENANT, null);

    // Assert that nothing has changed
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   * <ul>
   *   <li>Given {@link TbTransactionalCache}
   * {@link TbTransactionalCache#evict(Serializable)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  public void testDeleteDeviceCredentialsByDeviceId_givenTbTransactionalCacheEvictDoesNothing() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<String>any());
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());

    // Act
    deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(tbTransactionalCache).evict((String) isNull());
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}.
   * <ul>
   *   <li>Then calls {@link DeviceCredentials#getCredentialsId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceCredentialsServiceImpl#deleteDeviceCredentialsByDeviceId(TenantId, DeviceId)}
   */
  @Test
  public void testDeleteDeviceCredentialsByDeviceId_thenCallsGetCredentialsId() {
    // Arrange
    DeviceCredentials deviceCredentials = mock(DeviceCredentials.class);
    when(deviceCredentials.getCredentialsId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceCredentialsDao.removeByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(deviceCredentials);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceCredentialsServiceImpl.deleteDeviceCredentialsByDeviceId(ModelConstants.SYSTEM_TENANT, null));
    verify(deviceCredentials).getCredentialsId();
    verify(deviceCredentialsDao).removeByDeviceId(isA(TenantId.class), isNull());
  }
}
