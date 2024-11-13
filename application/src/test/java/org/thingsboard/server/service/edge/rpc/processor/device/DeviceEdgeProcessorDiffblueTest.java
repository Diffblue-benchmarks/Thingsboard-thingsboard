package org.thingsboard.server.service.edge.rpc.processor.device;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.DeviceRpcCallMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class DeviceEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)}
   */
  @Test
  @DisplayName("Test processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg); when Edge(); then return get() is 'null'")
  void testProcessDeviceRpcCallFromEdge_whenEdge_thenReturnGetIsNull() throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessDeviceRpcCallFromEdgeResult = deviceEdgeProcessorV1
        .processDeviceRpcCallFromEdge(tenantId, edge, DeviceRpcCallMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessDeviceRpcCallFromEdgeResult.get());
    assertTrue(actualProcessDeviceRpcCallFromEdgeResult.isDone());
  }

  /**
   * Test
   * {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)}.
   * <ul>
   *   <li>When {@link Edge}.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)}
   */
  @Test
  @DisplayName("Test processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg); when Edge; then return get() is 'null'")
  void testProcessDeviceRpcCallFromEdge_whenEdge_thenReturnGetIsNull2()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);

    // Act
    ListenableFuture<Void> actualProcessDeviceRpcCallFromEdgeResult = deviceEdgeProcessorV1
        .processDeviceRpcCallFromEdge(tenantId, edge, DeviceRpcCallMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessDeviceRpcCallFromEdgeResult.get());
    assertTrue(actualProcessDeviceRpcCallFromEdgeResult.isDone());
  }

  /**
   * Test
   * {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); then throw DataValidationException")
  void testConvertDeviceEventToDownlink_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceEdgeProcessorV1.convertDeviceEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getEntityId();
  }
}
