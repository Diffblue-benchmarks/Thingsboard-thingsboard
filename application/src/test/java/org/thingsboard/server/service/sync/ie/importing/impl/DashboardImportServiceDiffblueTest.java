package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

class DashboardImportServiceDiffblueTest {
  /**
   * Test {@link DashboardImportService#deepCopy(Dashboard)} with
   * {@code Dashboard}.
   * <ul>
   *   <li>Given
   * {@link DashboardImportService#DashboardImportService(DashboardService)} with
   * {@link DashboardService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#deepCopy(Dashboard)}
   */
  @Test
  @DisplayName("Test deepCopy(Dashboard) with 'Dashboard'; given DashboardImportService(DashboardService) with DashboardService")
  void testDeepCopyWithDashboard_givenDashboardImportServiceWithDashboardService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardImportService dashboardImportService = new DashboardImportService(mock(DashboardService.class));
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, dashboardImportService.deepCopy(dashboard));
  }

  /**
   * Test {@link DashboardImportService#deepCopy(Dashboard)} with
   * {@code Dashboard}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardImportService#deepCopy(Dashboard)}
   */
  @Test
  @DisplayName("Test deepCopy(Dashboard) with 'Dashboard'; then return Dashboard()")
  void testDeepCopyWithDashboard_thenReturnDashboard() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardImportService dashboardImportService = new DashboardImportService(new DashboardServiceImpl());
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, dashboardImportService.deepCopy(dashboard));
  }

  /**
   * Test
   * {@link DashboardImportService#compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard)}
   * with {@code EntitiesImportCtx}, {@code EntityExportData}, {@code Dashboard},
   * {@code Dashboard}.
   * <p>
   * Method under test:
   * {@link DashboardImportService#compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard)}
   */
  @Test
  @DisplayName("Test compare(EntitiesImportCtx, EntityExportData, Dashboard, Dashboard) with 'EntitiesImportCtx', 'EntityExportData', 'Dashboard', 'Dashboard'")
  void testCompareWithEntitiesImportCtxEntityExportDataDashboardDashboard() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardImportService dashboardImportService = new DashboardImportService(new DashboardServiceImpl());
    UUID requestId = UUID.randomUUID();
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    EntityExportData<Dashboard> exportData = new EntityExportData<>();

    Dashboard prepared = new Dashboard();
    prepared.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertTrue(dashboardImportService.compare(ctx, exportData, prepared, new Dashboard()));
  }

  /**
   * Test {@link DashboardImportService#getEntityType()}.
   * <p>
   * Method under test: {@link DashboardImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, (new DashboardImportService(new DashboardServiceImpl())).getEntityType());
  }
}
