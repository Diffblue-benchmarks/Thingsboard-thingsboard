package org.thingsboard.server.service.edge.rpc.constructor.dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.gen.edge.v1.DashboardUpdateMsg;
import org.thingsboard.server.gen.edge.v1.UpdateMsgType;

class BaseDashboardMsgConstructorDiffblueTest {
  /**
   * Test {@link BaseDashboardMsgConstructor#constructDashboardDeleteMsg(DashboardId)}.
   *
   * <ul>
   *   <li>Then return InitializationErrorString is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseDashboardMsgConstructor#constructDashboardDeleteMsg(DashboardId)}
   */
  @Test
  @DisplayName(
      "Test constructDashboardDeleteMsg(DashboardId); then return InitializationErrorString is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DashboardUpdateMsg BaseDashboardMsgConstructor.constructDashboardDeleteMsg(DashboardId)"
  })
  void testConstructDashboardDeleteMsg_thenReturnInitializationErrorStringIsEmptyString() {
    // Arrange
    DashboardMsgConstructorV1 dashboardMsgConstructorV1 = new DashboardMsgConstructorV1();

    // Act
    DashboardUpdateMsg actualConstructDashboardDeleteMsgResult =
        dashboardMsgConstructorV1.constructDashboardDeleteMsg(
            new DashboardId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertEquals("", actualConstructDashboardDeleteMsgResult.getInitializationErrorString());
    assertEquals("", actualConstructDashboardDeleteMsgResult.getAssignedCustomers());
    assertEquals("", actualConstructDashboardDeleteMsgResult.getConfiguration());
    assertEquals("", actualConstructDashboardDeleteMsgResult.getEntity());
    assertEquals("", actualConstructDashboardDeleteMsgResult.getImage());
    assertEquals("", actualConstructDashboardDeleteMsgResult.getTitle());
    assertEquals(-7476899250389416711L, actualConstructDashboardDeleteMsgResult.getIdLSB());
    assertEquals(0, actualConstructDashboardDeleteMsgResult.getMobileOrder());
    assertEquals(0L, actualConstructDashboardDeleteMsgResult.getCustomerIdLSB());
    assertEquals(0L, actualConstructDashboardDeleteMsgResult.getCustomerIdMSB());
    assertEquals(2, actualConstructDashboardDeleteMsgResult.getMsgTypeValue());
    assertEquals(23, actualConstructDashboardDeleteMsgResult.getSerializedSize());
    assertEquals(3, actualConstructDashboardDeleteMsgResult.getAllFields().size());
    assertEquals(8669210807411032922L, actualConstructDashboardDeleteMsgResult.getIdMSB());
    assertEquals(
        UpdateMsgType.ENTITY_DELETED_RPC_MESSAGE,
        actualConstructDashboardDeleteMsgResult.getMsgType());
    assertFalse(actualConstructDashboardDeleteMsgResult.getMobileHide());
    assertFalse(actualConstructDashboardDeleteMsgResult.hasAssignedCustomers());
    assertFalse(actualConstructDashboardDeleteMsgResult.hasCustomerIdLSB());
    assertFalse(actualConstructDashboardDeleteMsgResult.hasCustomerIdMSB());
    assertFalse(actualConstructDashboardDeleteMsgResult.hasImage());
    assertFalse(actualConstructDashboardDeleteMsgResult.hasMobileOrder());
    assertTrue(actualConstructDashboardDeleteMsgResult.findInitializationErrors().isEmpty());
    assertTrue(actualConstructDashboardDeleteMsgResult.isInitialized());
  }
}
