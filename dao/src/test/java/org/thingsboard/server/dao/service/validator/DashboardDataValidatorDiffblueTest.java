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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {DashboardDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DashboardDataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @Autowired private DashboardDataValidator dashboardDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link DashboardDataValidator#validateCreate(TenantId, Dashboard)} with {@code TenantId},
   * {@code Dashboard}.
   *
   * <ul>
   *   <li>Then calls {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardDataValidator#validateCreate(TenantId, Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardDataValidator.validateCreate(TenantId, Dashboard)"})
  public void testValidateCreateWithTenantIdDashboard_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    // Act
    dashboardDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Dashboard());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.DASHBOARD));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)} with {@code
   * TenantId}, {@code Dashboard}.
   *
   * <p>Method under test: {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardDataValidator.validateDataImpl(TenantId, Dashboard)"})
  public void testValidateDataImplWithTenantIdDashboard() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboard.setTitle("Dr");

    // Act
    dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)} with {@code
   * TenantId}, {@code Dashboard}.
   *
   * <p>Method under test: {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardDataValidator.validateDataImpl(TenantId, Dashboard)"})
  public void testValidateDataImplWithTenantIdDashboard2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboard.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)} with {@code
   * TenantId}, {@code Dashboard}.
   *
   * <p>Method under test: {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardDataValidator.validateDataImpl(TenantId, Dashboard)"})
  public void testValidateDataImplWithTenantIdDashboard3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    Dashboard dashboard = new Dashboard();
    dashboard.setTenantId(ModelConstants.SYSTEM_TENANT);
    dashboard.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)} with {@code
   * TenantId}, {@code Dashboard}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardDataValidator.validateDataImpl(TenantId, Dashboard)"})
  public void testValidateDataImplWithTenantIdDashboard_givenTenantService() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)} with {@code
   * TenantId}, {@code Dashboard}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DashboardDataValidator.validateDataImpl(TenantId, Dashboard)"})
  public void testValidateDataImplWithTenantIdDashboard_givenTenantService_whenDashboard() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Dashboard()));
  }
}
