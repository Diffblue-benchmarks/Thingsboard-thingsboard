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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantDao;

@ContextConfiguration(classes = {TenantDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TenantDataValidatorDiffblueTest {
  @MockBean private TenantDao tenantDao;

  @Autowired private TenantDataValidator tenantDataValidator;

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with {@code TenantId},
   * {@code Tenant}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantDataValidator.validateDataImpl(TenantId, Tenant)"})
  public void testValidateDataImplWithTenantIdTenant_givenDr_thenDoesNotThrow() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setTitle("Dr");

    // Act and Assert
    tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant);
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with {@code TenantId},
   * {@code Tenant}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantDataValidator.validateDataImpl(TenantId, Tenant)"})
  public void testValidateDataImplWithTenantIdTenant_givenDr_thenThrowDataValidationException() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setTitle("Dr\u0000");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant));
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with {@code TenantId},
   * {@code Tenant}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantDataValidator.validateDataImpl(TenantId, Tenant)"})
  public void testValidateDataImplWithTenantIdTenant_givenEmptyString() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setTitle("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant));
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with {@code TenantId},
   * {@code Tenant}.
   *
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantDataValidator.validateDataImpl(TenantId, Tenant)"})
  public void testValidateDataImplWithTenantIdTenant_givenJaneDoeExampleOrg() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setEmail("jane.doe@example.org");
    tenant.setTitle("Dr");

    // Act and Assert
    tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant);
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with {@code TenantId},
   * {@code Tenant}.
   *
   * <ul>
   *   <li>Given {@code U@U.U}.
   *   <li>When {@link Tenant#Tenant()} Email is {@code U@U.U}.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantDataValidator.validateDataImpl(TenantId, Tenant)"})
  public void testValidateDataImplWithTenantIdTenant_givenUUU_whenTenantEmailIsUUU() {
    // Arrange
    Tenant tenant = new Tenant();
    tenant.setEmail("U@U.U");
    tenant.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenant));
  }

  /**
   * Test {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)} with {@code TenantId},
   * {@code Tenant}.
   *
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateDataImpl(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantDataValidator.validateDataImpl(TenantId, Tenant)"})
  public void testValidateDataImplWithTenantIdTenant_whenTenant() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tenantDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Tenant()));
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with {@code TenantId}, {@code
   * Tenant}.
   *
   * <p>Method under test: {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantDataValidator.validateUpdate(TenantId, Tenant)"})
  public void testValidateUpdateWithTenantIdTenant() {
    // Arrange
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant()));
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with {@code TenantId}, {@code
   * Tenant}.
   *
   * <ul>
   *   <li>Given {@link TenantDao} {@link TenantDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantDataValidator.validateUpdate(TenantId, Tenant)"})
  public void testValidateUpdateWithTenantIdTenant_givenTenantDaoFindByIdReturnNull() {
    // Arrange
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant()));
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantDataValidator#validateUpdate(TenantId, Tenant)} with {@code TenantId}, {@code
   * Tenant}.
   *
   * <ul>
   *   <li>Then return {@link Tenant#Tenant()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantDataValidator#validateUpdate(TenantId, Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantDataValidator.validateUpdate(TenantId, Tenant)"})
  public void testValidateUpdateWithTenantIdTenant_thenReturnTenant() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tenantDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenant);

    // Act
    Tenant actualValidateUpdateResult =
        tenantDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Tenant());

    // Assert
    verify(tenantDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(tenant, actualValidateUpdateResult);
  }
}
