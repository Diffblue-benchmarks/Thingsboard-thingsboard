package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
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
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {DashboardDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class DashboardDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private DashboardDataValidator dashboardDataValidator;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link DashboardDataValidator#validateCreate(TenantId, Dashboard)} with
   * {@code TenantId}, {@code Dashboard}.
   * <ul>
   *   <li>Then calls
   * {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardDataValidator#validateCreate(TenantId, Dashboard)}
   */
  @Test
  public void testValidateCreateWithTenantIdDashboard_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);

    // Act
    dashboardDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Dashboard());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.DASHBOARD));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   * with {@code TenantId}, {@code Dashboard}.
   * <p>
   * Method under test:
   * {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDashboard() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(dashboard.getTitle()).thenReturn("Dr");

    // Act
    dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard);

    // Assert that nothing has changed
    verify(dashboard, atLeast(1)).getTenantId();
    verify(dashboard).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   * with {@code TenantId}, {@code Dashboard}.
   * <p>
   * Method under test:
   * {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDashboard2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(dashboard.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard));
    verify(dashboard, atLeast(1)).getTenantId();
    verify(dashboard).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   * with {@code TenantId}, {@code Dashboard}.
   * <p>
   * Method under test:
   * {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDashboard3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    Dashboard dashboard = mock(Dashboard.class);
    when(dashboard.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(dashboard.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard));
    verify(dashboard, atLeast(1)).getTenantId();
    verify(dashboard).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   * with {@code TenantId}, {@code Dashboard}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()} Title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardDataValidator#validateDataImpl(TenantId, Dashboard)}
   */
  @Test
  public void testValidateDataImplWithTenantIdDashboard_whenDashboardTitleIsDr() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setTitle("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, dashboard));
  }
}
