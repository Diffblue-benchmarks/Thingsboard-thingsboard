package org.thingsboard.server.service.edge.rpc.processor.resource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

@ExtendWith(MockitoExtension.class)
class ResourceEdgeProcessorDiffblueTest {
  @InjectMocks private ResourceEdgeProcessorV1 resourceEdgeProcessorV1;

  /**
   * Test {@link ResourceEdgeProcessor#convertResourceEventToDownlink(EdgeEvent, EdgeVersion)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceEdgeProcessor#convertResourceEventToDownlink(EdgeEvent,
   * EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertResourceEventToDownlink(EdgeEvent, EdgeVersion); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.DownlinkMsg ResourceEdgeProcessor.convertResourceEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertResourceEventToDownlink_thenThrowDataValidationException() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.UPDATED);
    when(edgeEvent.getEntityId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    doNothing().when(edgeEvent).setAction(Mockito.<EdgeEventActionType>any());
    edgeEvent.setAction(EdgeEventActionType.DELETED);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            resourceEdgeProcessorV1.convertResourceEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    verify(edgeEvent).getTenantId();
    verify(edgeEvent).setAction(eq(EdgeEventActionType.DELETED));
  }
}
