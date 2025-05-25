package org.thingsboard.server.service.edge.rpc.processor.device.profile;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorFactory;
import org.thingsboard.server.service.edge.rpc.constructor.device.DeviceMsgConstructorV1;

@ExtendWith(MockitoExtension.class)
class DeviceProfileEdgeProcessorDiffblueTest {
  @Mock
  private DeviceMsgConstructorFactory deviceMsgConstructorFactory;

  @InjectMocks
  private DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1;

  /**
   * Test {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg DeviceProfileEdgeProcessor.convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)"})
  void testConvertDeviceProfileEventToDownlink_thenThrowDataValidationException() {
    // Arrange
    when(deviceMsgConstructorFactory.getMsgConstructorByEdgeVersion(Mockito.<EdgeVersion>any()))
        .thenReturn(new DeviceMsgConstructorV1());
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);
    when(edgeEvent.getEntityId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileEdgeProcessorV1.convertDeviceProfileEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(deviceMsgConstructorFactory).getMsgConstructorByEdgeVersion(eq(EdgeVersion.V_3_3_0));
  }
}
