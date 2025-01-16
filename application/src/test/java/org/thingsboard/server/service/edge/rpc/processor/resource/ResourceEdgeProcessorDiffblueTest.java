package org.thingsboard.server.service.edge.rpc.processor.resource;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class ResourceEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link ResourceEdgeProcessor#convertResourceEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceEdgeProcessor#convertResourceEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertResourceEventToDownlink(EdgeEvent, EdgeVersion); given 'POST_ATTRIBUTES'; then return 'null'")
  void testConvertResourceEventToDownlink_givenPostAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceEdgeProcessorV1 resourceEdgeProcessorV1 = new ResourceEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.POST_ATTRIBUTES);

    // Act
    DownlinkMsg actualConvertResourceEventToDownlinkResult = resourceEdgeProcessorV1
        .convertResourceEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertResourceEventToDownlinkResult);
  }

  /**
   * Test
   * {@link ResourceEdgeProcessor#convertResourceEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ResourceEdgeProcessor#convertResourceEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertResourceEventToDownlink(EdgeEvent, EdgeVersion); then throw DataValidationException")
  void testConvertResourceEventToDownlink_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourceEdgeProcessorV1 resourceEdgeProcessorV1 = new ResourceEdgeProcessorV1();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> resourceEdgeProcessorV1.convertResourceEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
  }
}
