package org.thingsboard.server.service.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;
import org.thingsboard.server.common.msg.edge.EdgeEventUpdateMsg;
import org.thingsboard.server.common.msg.edge.EdgeSessionMsg;

class EdgeGrpcServiceDiffblueTest {
  /**
   * Test {@link EdgeGrpcService#onToEdgeSessionMsg(TenantId, EdgeSessionMsg)}.
   * <ul>
   *   <li>Given {@code PARTITION_CHANGE_MSG}.</li>
   *   <li>Then calls {@link EdgeEventUpdateMsg#getMsgType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeGrpcService#onToEdgeSessionMsg(TenantId, EdgeSessionMsg)}
   */
  @Test
  @DisplayName("Test onToEdgeSessionMsg(TenantId, EdgeSessionMsg); given 'PARTITION_CHANGE_MSG'; then calls getMsgType()")
  void testOnToEdgeSessionMsg_givenPartitionChangeMsg_thenCallsGetMsgType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeGrpcService edgeGrpcService = new EdgeGrpcService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeEventUpdateMsg msg = mock(EdgeEventUpdateMsg.class);
    when(msg.getMsgType()).thenReturn(MsgType.PARTITION_CHANGE_MSG);

    // Act
    edgeGrpcService.onToEdgeSessionMsg(tenantId, msg);

    // Assert that nothing has changed
    verify(msg).getMsgType();
  }

  /**
   * Test {@link EdgeGrpcService#updateEdge(TenantId, Edge)}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>When {@link Edge} {@link Edge#getName()} return {@code Name}.</li>
   *   <li>Then calls {@link Edge#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeGrpcService#updateEdge(TenantId, Edge)}
   */
  @Test
  @DisplayName("Test updateEdge(TenantId, Edge); given 'Name'; when Edge getName() return 'Name'; then calls getId()")
  void testUpdateEdge_givenName_whenEdgeGetNameReturnName_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeGrpcService edgeGrpcService = new EdgeGrpcService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act
    edgeGrpcService.updateEdge(tenantId, edge);

    // Assert
    verify(edge, atLeast(1)).getId();
    verify(edge).getName();
  }

  /**
   * Test {@link EdgeGrpcService#updateEdge(TenantId, Edge)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeGrpcService#updateEdge(TenantId, Edge)}
   */
  @Test
  @DisplayName("Test updateEdge(TenantId, Edge); then throw RuntimeException")
  void testUpdateEdge_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EdgeGrpcService edgeGrpcService = new EdgeGrpcService();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenThrow(new RuntimeException("[{}] Session doesn't exist for edge [{}] [{}]"));
    when(edge.getId()).thenReturn(new EdgeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeGrpcService.updateEdge(tenantId, edge));
    verify(edge).getId();
    verify(edge).getName();
  }
}
