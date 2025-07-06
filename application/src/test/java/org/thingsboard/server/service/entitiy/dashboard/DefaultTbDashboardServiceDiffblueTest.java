package org.thingsboard.server.service.entitiy.dashboard;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;

@ExtendWith(MockitoExtension.class)
class DefaultTbDashboardServiceDiffblueTest {
  @InjectMocks private DefaultTbDashboardService defaultTbDashboardService;

  /**
   * Test {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set, User)}.
   *
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard(Dashboard)} with dashboard is {@link
   *       Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set,
   * User)}
   */
  @Test
  @DisplayName(
      "Test updateDashboardCustomers(Dashboard, Set, User); then return Dashboard(Dashboard) with dashboard is Dashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Dashboard DefaultTbDashboardService.updateDashboardCustomers(Dashboard, Set, User)"
  })
  void testUpdateDashboardCustomers_thenReturnDashboardWithDashboardIsDashboard()
      throws ThingsboardException {
    // Arrange
    LinkedHashSet<ShortCustomerInfo> assignedCustomers = new LinkedHashSet<>();
    assignedCustomers.add(
        new ShortCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));

    Dashboard dashboard = new Dashboard(new Dashboard());
    dashboard.setAssignedCustomers(assignedCustomers);

    LinkedHashSet<CustomerId> customerIds = new LinkedHashSet<>();
    customerIds.add(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertSame(
        dashboard,
        defaultTbDashboardService.updateDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set, User)}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set,
   * User)}
   */
  @Test
  @DisplayName(
      "Test updateDashboardCustomers(Dashboard, Set, User); when Dashboard(); then return Dashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Dashboard DefaultTbDashboardService.updateDashboardCustomers(Dashboard, Set, User)"
  })
  void testUpdateDashboardCustomers_whenDashboard_thenReturnDashboard()
      throws ThingsboardException {
    // Arrange
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(
        dashboard,
        defaultTbDashboardService.updateDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test {@link DefaultTbDashboardService#addDashboardCustomers(Dashboard, Set, User)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbDashboardService#addDashboardCustomers(Dashboard, Set,
   * User)}
   */
  @Test
  @DisplayName(
      "Test addDashboardCustomers(Dashboard, Set, User); when HashSet(); then return Dashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Dashboard DefaultTbDashboardService.addDashboardCustomers(Dashboard, Set, User)"
  })
  void testAddDashboardCustomers_whenHashSet_thenReturnDashboard() throws ThingsboardException {
    // Arrange
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(
        dashboard,
        defaultTbDashboardService.addDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}.
   *
   * <p>Method under test: {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set,
   * User)}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(Dashboard, Set, User)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Dashboard DefaultTbDashboardService.removeDashboardCustomers(Dashboard, Set, User)"
  })
  void testRemoveDashboardCustomers() throws ThingsboardException {
    // Arrange
    Dashboard dashboard = new Dashboard();

    LinkedHashSet<CustomerId> customerIds = new LinkedHashSet<>();
    customerIds.add(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertSame(
        dashboard,
        defaultTbDashboardService.removeDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return {@link Dashboard#Dashboard()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set,
   * User)}
   */
  @Test
  @DisplayName(
      "Test removeDashboardCustomers(Dashboard, Set, User); when Dashboard(); then return Dashboard()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Dashboard DefaultTbDashboardService.removeDashboardCustomers(Dashboard, Set, User)"
  })
  void testRemoveDashboardCustomers_whenDashboard_thenReturnDashboard()
      throws ThingsboardException {
    // Arrange
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(
        dashboard,
        defaultTbDashboardService.removeDashboardCustomers(dashboard, customerIds, new User()));
  }
}
