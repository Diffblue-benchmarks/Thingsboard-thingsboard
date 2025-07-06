package org.thingsboard.server.service.edge.rpc.processor.edge;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;

@ExtendWith(MockitoExtension.class)
class EdgeProcessorDiffblueTest {
  @InjectMocks private EdgeProcessor edgeProcessor;

  /**
   * Test {@link EdgeProcessor#convertEdgeEventToDownlink(EdgeEvent)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeProcessor#convertEdgeEventToDownlink(EdgeEvent)}
   */
  @Test
  @DisplayName("Test convertEdgeEventToDownlink(EdgeEvent); given 'ADDED'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.DownlinkMsg EdgeProcessor.convertEdgeEventToDownlink(EdgeEvent)"
  })
  void testConvertEdgeEventToDownlink_givenAdded_thenReturnNull() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNull(edgeProcessor.convertEdgeEventToDownlink(edgeEvent));
  }
}
