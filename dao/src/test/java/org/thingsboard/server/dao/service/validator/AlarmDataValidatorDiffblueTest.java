package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AlarmDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AlarmDataValidatorDiffblueTest {
  @Autowired
  private AlarmDataValidator alarmDataValidator;

  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Alarm alarm = mock(Alarm.class);
    when(alarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(alarm.getStatus()).thenReturn(AlarmStatus.ACTIVE_UNACK);
    when(alarm.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    when(alarm.getOriginator()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(alarm.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
    verify(alarm).getOriginator();
    verify(alarm).getSeverity();
    verify(alarm).getStatus();
    verify(alarm, atLeast(1)).getTenantId();
    verify(alarm).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <ul>
   *   <li>Given {@code Alarm type}.</li>
   *   <li>When {@link Alarm#Alarm()} Type is {@code Alarm type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm_givenAlarmType_whenAlarmTypeIsAlarmType() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setType("Alarm type");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Alarm} {@link Alarm#getSeverity()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm_givenNull_whenAlarmGetSeverityReturnNull() {
    // Arrange
    Alarm alarm = mock(Alarm.class);
    when(alarm.getSeverity()).thenReturn(null);
    when(alarm.getOriginator()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(alarm.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
    verify(alarm).getOriginator();
    verify(alarm).getSeverity();
    verify(alarm).getType();
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Alarm} {@link Alarm#getStatus()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm_givenNull_whenAlarmGetStatusReturnNull() {
    // Arrange
    Alarm alarm = mock(Alarm.class);
    when(alarm.getStatus()).thenReturn(null);
    when(alarm.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    when(alarm.getOriginator()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(alarm.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
    verify(alarm).getOriginator();
    verify(alarm).getSeverity();
    verify(alarm).getStatus();
    verify(alarm).getType();
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Alarm} {@link Alarm#getTenantId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm_givenNull_whenAlarmGetTenantIdReturnNull() {
    // Arrange
    Alarm alarm = mock(Alarm.class);
    when(alarm.getTenantId()).thenReturn(null);
    when(alarm.getStatus()).thenReturn(AlarmStatus.ACTIVE_UNACK);
    when(alarm.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    when(alarm.getOriginator()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(alarm.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
    verify(alarm).getOriginator();
    verify(alarm).getSeverity();
    verify(alarm).getStatus();
    verify(alarm).getTenantId();
    verify(alarm).getType();
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    Alarm alarm = mock(Alarm.class);
    when(alarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(alarm.getStatus()).thenReturn(AlarmStatus.ACTIVE_UNACK);
    when(alarm.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    when(alarm.getOriginator()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(alarm.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
    verify(alarm).getOriginator();
    verify(alarm).getSeverity();
    verify(alarm).getStatus();
    verify(alarm, atLeast(1)).getTenantId();
    verify(alarm).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with
   * {@code TenantId}, {@code Alarm}.
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAlarm_givenTenantServiceTenantExistsReturnTrue() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Alarm alarm = mock(Alarm.class);
    when(alarm.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(alarm.getStatus()).thenReturn(AlarmStatus.ACTIVE_UNACK);
    when(alarm.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    when(alarm.getOriginator()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(alarm.getType()).thenReturn("Type");

    // Act
    alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert that nothing has changed
    verify(alarm).getOriginator();
    verify(alarm).getSeverity();
    verify(alarm).getStatus();
    verify(alarm, atLeast(1)).getTenantId();
    verify(alarm).getType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
