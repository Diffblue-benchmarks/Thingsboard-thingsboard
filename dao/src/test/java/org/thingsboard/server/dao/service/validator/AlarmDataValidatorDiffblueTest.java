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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;

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
   * <ul>
   *   <li>Given {@code Alarm type}.
   *   <li>When {@link Alarm#Alarm()} Type is {@code Alarm type}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_givenAlarmType_whenAlarmTypeIsAlarmType() {
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
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmDataValidator#validateDataImpl(TenantId, Alarm)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmDataValidator.validateDataImpl(TenantId, Alarm)"})
  public void testValidateDataImplWithTenantIdAlarm_whenAlarm_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> alarmDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Alarm()));
  }
}
