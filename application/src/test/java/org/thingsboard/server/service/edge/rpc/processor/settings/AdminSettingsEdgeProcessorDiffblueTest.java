package org.thingsboard.server.service.edge.rpc.processor.settings;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class AdminSettingsEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Then calls {@link EdgeEvent#getBody()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion); then calls getBody()")
  void testConvertAdminSettingsEventToDownlink_thenCallsGetBody() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsEdgeProcessor adminSettingsEdgeProcessor = new AdminSettingsEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(MissingNode.getInstance());

    // Act
    DownlinkMsg actualConvertAdminSettingsEventToDownlinkResult = adminSettingsEdgeProcessor
        .convertAdminSettingsEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getBody();
    assertNull(actualConvertAdminSettingsEventToDownlinkResult);
  }

  /**
   * Test
   * {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Body is Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent() Body is Instance")
  void testConvertAdminSettingsEventToDownlink_whenEdgeEventBodyIsInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsEdgeProcessor adminSettingsEdgeProcessor = new AdminSettingsEdgeProcessor();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setBody(MissingNode.getInstance());

    // Act and Assert
    assertNull(adminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  void testConvertAdminSettingsEventToDownlink_whenEdgeEvent_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsEdgeProcessor adminSettingsEdgeProcessor = new AdminSettingsEdgeProcessor();

    // Act and Assert
    assertNull(adminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
