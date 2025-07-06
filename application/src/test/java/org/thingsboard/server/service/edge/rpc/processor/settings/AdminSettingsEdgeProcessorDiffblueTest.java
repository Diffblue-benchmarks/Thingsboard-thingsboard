package org.thingsboard.server.service.edge.rpc.processor.settings;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

@ExtendWith(MockitoExtension.class)
class AdminSettingsEdgeProcessorDiffblueTest {
  @InjectMocks private AdminSettingsEdgeProcessor adminSettingsEdgeProcessor;

  /**
   * Test {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent,
   * EdgeVersion)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then calls {@link EdgeEvent#getBody()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion); given Instance; then calls getBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AdminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAdminSettingsEventToDownlink_givenInstance_thenCallsGetBody() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(MissingNode.getInstance());

    // Act
    DownlinkMsg actualConvertAdminSettingsEventToDownlinkResult =
        adminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(
            edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getBody();
    assertNull(actualConvertAdminSettingsEventToDownlinkResult);
  }

  /**
   * Test {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent,
   * EdgeVersion)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then calls {@link EdgeEvent#getBody()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion); given Instance; then calls getBody()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AdminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAdminSettingsEventToDownlink_givenInstance_thenCallsGetBody2() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getBody()).thenReturn(NullNode.getInstance());

    // Act
    DownlinkMsg actualConvertAdminSettingsEventToDownlinkResult =
        adminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(
            edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getBody();
    assertNull(actualConvertAdminSettingsEventToDownlinkResult);
  }

  /**
   * Test {@link AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent,
   * EdgeVersion)}.
   *
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsEdgeProcessor#convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName(
      "Test convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "DownlinkMsg AdminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(EdgeEvent, EdgeVersion)"
  })
  void testConvertAdminSettingsEventToDownlink_whenEdgeEvent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        adminSettingsEdgeProcessor.convertAdminSettingsEventToDownlink(
            new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
