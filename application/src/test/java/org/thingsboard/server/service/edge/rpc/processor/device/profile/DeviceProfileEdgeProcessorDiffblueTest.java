package org.thingsboard.server.service.edge.rpc.processor.device.profile;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class DeviceProfileEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileEdgeProcessor#convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertDeviceProfileEventToDownlink(EdgeEvent, EdgeId, EdgeVersion); then throw DataValidationException")
  void testConvertDeviceProfileEventToDownlink_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEdgeProcessorV1 deviceProfileEdgeProcessorV1 = new DeviceProfileEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileEdgeProcessorV1.convertDeviceProfileEventToDownlink(edgeEvent, null, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getEntityId();
  }
}
