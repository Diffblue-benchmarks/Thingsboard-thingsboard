package org.thingsboard.server.service.edge.rpc.processor.dashboard;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class DashboardEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); given CustomerId(UUID) with id is randomUUID")
  void testFilterNonExistingCustomers_givenCustomerIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true));

    // Act and Assert
    assertSame(assignedCustomers, dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); given CustomerId(UUID) with id is randomUUID")
  void testFilterNonExistingCustomers_givenCustomerIdWithIdIsRandomUUID2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true));
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true));

    // Act and Assert
    assertSame(assignedCustomers, dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>Given {@link ShortCustomerInfo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); given ShortCustomerInfo")
  void testFilterNonExistingCustomers_givenShortCustomerInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(mock(ShortCustomerInfo.class));

    // Act and Assert
    assertSame(assignedCustomers, dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); when HashSet(); then return Empty")
  void testFilterNonExistingCustomers_whenHashSet_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertTrue(dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, new HashSet<>()).isEmpty());
  }
}
