package org.thingsboard.server.service.edge.rpc.processor.device;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.DeviceRpcCallMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class DeviceEdgeProcessorDiffblueTest {
  @InjectMocks
  private DeviceEdgeProcessorV1 deviceEdgeProcessorV1;

  @Mock
  private DeviceMsgConstructorFactory deviceMsgConstructorFactory;

  /**
   * Test {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)}.
   * <ul>
   *   <li>When DefaultInstance.</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEdgeProcessor#processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)}
   */
  @Test
  @DisplayName("Test processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg); when DefaultInstance; then return get() is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ListenableFuture DeviceEdgeProcessor.processDeviceRpcCallFromEdge(TenantId, Edge, DeviceRpcCallMsg)"})
  void testProcessDeviceRpcCallFromEdge_whenDefaultInstance_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    DeviceEdgeProcessorV1 deviceEdgeProcessorV1 = new DeviceEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Edge edge = new Edge();

    // Act
    ListenableFuture<Void> actualProcessDeviceRpcCallFromEdgeResult = deviceEdgeProcessorV1
        .processDeviceRpcCallFromEdge(tenantId, edge, DeviceRpcCallMsg.getDefaultInstance());

    // Assert
    assertNull(actualProcessDeviceRpcCallFromEdgeResult.get());
    assertTrue(actualProcessDeviceRpcCallFromEdgeResult.isDone());
  }

  /**
   * Test {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceEdgeProcessor#convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg DeviceEdgeProcessor.convertDeviceEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"})
  void testConvertDeviceEventToDownlink_thenThrowDataValidationException() {
    // Arrange
    when(deviceMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DeviceMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceEdgeProcessorV1.convertDeviceEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }
}
