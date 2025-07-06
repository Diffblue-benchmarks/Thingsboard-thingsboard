package org.thingsboard.server.service.edge.rpc.processor.dashboard;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;

class DashboardEdgeProcessorDiffblueTest {
  /**
   * Test {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName(
      "Test filterNonExistingCustomers(TenantId, Set); given CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set DashboardEdgeProcessor.filterNonExistingCustomers(TenantId, Set)"})
  void testFilterNonExistingCustomers_givenCustomerIdWithIdIsRandomUUID() {
    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true));
    assignedCustomers.add(
        new ShortCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));

    // Act and Assert
    assertSame(
        assignedCustomers,
        dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   *
   * <ul>
   *   <li>Then return {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); then return HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set DashboardEdgeProcessor.filterNonExistingCustomers(TenantId, Set)"})
  void testFilterNonExistingCustomers_thenReturnHashSet() {
    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(
        new ShortCustomerInfo(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));

    // Act and Assert
    assertSame(
        assignedCustomers,
        dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); when HashSet(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set DashboardEdgeProcessor.filterNonExistingCustomers(TenantId, Set)"})
  void testFilterNonExistingCustomers_whenHashSet_thenReturnEmpty() {
    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertTrue(
        dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, new HashSet<>()).isEmpty());
  }
}
