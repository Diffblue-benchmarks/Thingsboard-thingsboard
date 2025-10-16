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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {ApiUsageDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class ApiUsageDataValidatorDiffblueTest {
  @Autowired private ApiUsageDataValidator apiUsageDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    ApiUsageState apiUsageState = new ApiUsageState(new ApiUsageState());
    apiUsageState.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new DataValidationException("An error occurred"));

    ApiUsageState apiUsageState = new ApiUsageState(new ApiUsageState());
    apiUsageState.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState.setEntityId(entityId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(entityId).getEntityType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState_givenAlarmIdWithIdIsNull_uuid() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    ApiUsageState apiUsageState = new ApiUsageState(new ApiUsageState());
    apiUsageState.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState.setEntityId(new AlarmId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState_givenNull() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    ApiUsageState apiUsageState = new ApiUsageState(new ApiUsageState());
    apiUsageState.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState.setEntityId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    ApiUsageState apiUsageState = new ApiUsageState(new ApiUsageState());
    apiUsageState.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState_thenCallsGetEntityType() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new DataValidationException("An error occurred"));

    ApiUsageState apiUsageState = new ApiUsageState(new ApiUsageState());
    apiUsageState.setTenantId(ModelConstants.SYSTEM_TENANT);
    apiUsageState.setEntityId(entityId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> apiUsageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, apiUsageState));
    verify(entityId).getEntityType();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState_whenApiUsageState() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            apiUsageDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new ApiUsageState()));
  }
}
