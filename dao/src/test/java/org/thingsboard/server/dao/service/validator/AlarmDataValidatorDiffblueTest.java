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

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.Alarm.AlarmBuilder;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {AlarmDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AlarmDataValidatorDiffblueTest {
  @Autowired private AlarmDataValidator alarmDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Alarm alarm = new Alarm();
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setType("Alarm type");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <ul>
   *   <li>Given {@code CRITICAL}.
   *   <li>When {@link Alarm#Alarm()} Severity is {@code CRITICAL}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_givenCritical_whenAlarmSeverityIsCritical() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setType("Alarm type");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_givenNull_customer_id() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setType("Alarm type");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_givenTenantService() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setType("Alarm type");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_givenTenantServiceTenantExistsReturnTrue() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Alarm alarm = new Alarm();
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setSeverity(AlarmSeverity.CRITICAL);
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setType("Alarm type");

    // Act
    alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, alarm);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link Alarm#Alarm()}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_givenTenantService_whenAlarm() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Alarm()));
  }

  /**
   * Test {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)} with {@code TenantId}, {@code
   * Alarm}.
   *
   * <ul>
   *   <li>Then calls {@link TenantServiceImpl#tenantExists(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_thenCallsTenantExists() {
    // Arrange
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    AlarmDataValidator alarmDataValidator = new AlarmDataValidator(tenantService);

    AlarmBuilder propagateResult =
        Alarm.builder()
            .ackTs(1L)
            .acknowledged(true)
            .assignTs(1L)
            .assigneeId(null)
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            alarmDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT,
                propagateResult
                    .propagateRelationTypes(new ArrayList<>())
                    .propagateToOwner(true)
                    .propagateToTenant(true)
                    .severity(AlarmSeverity.CRITICAL)
                    .startTs(1L)
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .type("Type")
                    .build()));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
