package org.thingsboard.server.service.edge.rpc.processor.widget;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class WidgetBundleEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link WidgetBundleEdgeProcessor#convertWidgetsBundleEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetBundleEdgeProcessor#convertWidgetsBundleEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertWidgetsBundleEventToDownlink(EdgeEvent, EdgeVersion); given 'POST_ATTRIBUTES'; then return 'null'")
  void testConvertWidgetsBundleEventToDownlink_givenPostAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WidgetBundleEdgeProcessor widgetBundleEdgeProcessor = new WidgetBundleEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.POST_ATTRIBUTES);

    // Act
    DownlinkMsg actualConvertWidgetsBundleEventToDownlinkResult = widgetBundleEdgeProcessor
        .convertWidgetsBundleEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertWidgetsBundleEventToDownlinkResult);
  }
}
