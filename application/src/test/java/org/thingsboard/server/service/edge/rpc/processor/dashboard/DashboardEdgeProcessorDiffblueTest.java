package org.thingsboard.server.service.edge.rpc.processor.dashboard;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.dashboard.DashboardMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.dashboard.DashboardMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class DashboardEdgeProcessorDiffblueTest {
  @InjectMocks
  private DashboardEdgeProcessorV1 dashboardEdgeProcessorV1;

  @Mock
  private DashboardMsgConstructorFactory dashboardMsgConstructorFactory;

  /**
   * Test {@link DashboardEdgeProcessor#convertDashboardEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEdgeProcessor#convertDashboardEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDashboardEventToDownlink(EdgeEvent, EdgeVersion); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg DashboardEdgeProcessor.convertDashboardEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertDashboardEventToDownlink_thenThrowDataValidationException() {
    // Arrange
    when(dashboardMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DashboardMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> dashboardEdgeProcessorV1.convertDashboardEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(dashboardMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }

  /**
   * Test {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
   */
  @Test
  @DisplayName("Test filterNonExistingCustomers(TenantId, Set); given CustomerId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set DashboardEdgeProcessor.filterNonExistingCustomers(TenantId, Set)"})
  void testFilterNonExistingCustomers_givenCustomerIdWithIdIsRandomUUID() {
    // Arrange
    DashboardEdgeProcessorV1 dashboardEdgeProcessorV1 = new DashboardEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    HashSet<ShortCustomerInfo> assignedCustomers = new HashSet<>();
    assignedCustomers.add(new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true));
    assignedCustomers.add(
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));

    // Act and Assert
    assertSame(assignedCustomers, dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
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
        new ShortCustomerInfo(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr", true));

    // Act and Assert
    assertSame(assignedCustomers, dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, assignedCustomers));
  }

  /**
   * Test {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DashboardEdgeProcessor#filterNonExistingCustomers(TenantId, Set)}
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
    assertTrue(dashboardEdgeProcessorV1.filterNonExistingCustomers(tenantId, new HashSet<>()).isEmpty());
  }
}
