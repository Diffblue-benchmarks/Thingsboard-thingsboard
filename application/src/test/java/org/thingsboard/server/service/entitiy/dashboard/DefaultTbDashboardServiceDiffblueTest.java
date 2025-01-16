package org.thingsboard.server.service.entitiy.dashboard;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;

class DefaultTbDashboardServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test updateDashboardCustomers(Dashboard, Set, User); when HashSet(); then return Dashboard()")
  void testUpdateDashboardCustomers_whenHashSet_thenReturnDashboard() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(new DashboardServiceImpl());
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.updateDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#updateDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test updateDashboardCustomers(Dashboard, Set, User); when HashSet(); then return Dashboard()")
  void testUpdateDashboardCustomers_whenHashSet_thenReturnDashboard2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(mock(DashboardService.class));
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.updateDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#addDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#addDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test addDashboardCustomers(Dashboard, Set, User); then return Dashboard()")
  void testAddDashboardCustomers_thenReturnDashboard() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(new DashboardServiceImpl());
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.addDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#addDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#addDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test addDashboardCustomers(Dashboard, Set, User); when HashSet(); then return Dashboard()")
  void testAddDashboardCustomers_whenHashSet_thenReturnDashboard() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(mock(DashboardService.class));
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.addDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>Given
   * {@link DefaultTbDashboardService#DefaultTbDashboardService(DashboardService)}
   * with {@link DashboardService}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(Dashboard, Set, User); given DefaultTbDashboardService(DashboardService) with DashboardService")
  void testRemoveDashboardCustomers_givenDefaultTbDashboardServiceWithDashboardService() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(mock(DashboardService.class));
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.removeDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@link CustomerId#CustomerId(UUID)}
   * with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(Dashboard, Set, User); when HashSet() add CustomerId(UUID) with id is randomUUID")
  void testRemoveDashboardCustomers_whenHashSetAddCustomerIdWithIdIsRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(new DashboardServiceImpl());
    Dashboard dashboard = new Dashboard();

    HashSet<CustomerId> customerIds = new HashSet<>();
    customerIds.add(new CustomerId(UUID.randomUUID()));
    customerIds.add(new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.removeDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(Dashboard, Set, User); when HashSet(); then return Dashboard()")
  void testRemoveDashboardCustomers_whenHashSet_thenReturnDashboard() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(new DashboardServiceImpl());
    Dashboard dashboard = new Dashboard();
    HashSet<CustomerId> customerIds = new HashSet<>();

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.removeDashboardCustomers(dashboard, customerIds, new User()));
  }

  /**
   * Test
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}.
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add
   * {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDashboardService#removeDashboardCustomers(Dashboard, Set, User)}
   */
  @Test
  @DisplayName("Test removeDashboardCustomers(Dashboard, Set, User); when LinkedHashSet() add CustomerId(UUID) with id is randomUUID")
  void testRemoveDashboardCustomers_whenLinkedHashSetAddCustomerIdWithIdIsRandomUUID() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbDashboardService defaultTbDashboardService = new DefaultTbDashboardService(new DashboardServiceImpl());
    Dashboard dashboard = new Dashboard();

    LinkedHashSet<CustomerId> customerIds = new LinkedHashSet<>();
    customerIds.add(new CustomerId(UUID.randomUUID()));

    // Act and Assert
    assertSame(dashboard, defaultTbDashboardService.removeDashboardCustomers(dashboard, customerIds, new User()));
  }
}
