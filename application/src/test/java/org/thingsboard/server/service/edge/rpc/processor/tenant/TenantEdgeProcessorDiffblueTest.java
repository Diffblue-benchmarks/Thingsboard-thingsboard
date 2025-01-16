package org.thingsboard.server.service.edge.rpc.processor.tenant;

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

class TenantEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link TenantEdgeProcessor#convertTenantEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>Then calls {@link EdgeEvent#getAction()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEdgeProcessor#convertTenantEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertTenantEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; then calls getAction()")
  void testConvertTenantEventToDownlink_givenAdded_thenCallsGetAction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantEdgeProcessor tenantEdgeProcessor = new TenantEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);

    // Act
    DownlinkMsg actualConvertTenantEventToDownlinkResult = tenantEdgeProcessor.convertTenantEventToDownlink(edgeEvent,
        EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertTenantEventToDownlinkResult);
  }

  /**
   * Test
   * {@link TenantEdgeProcessor#convertTenantEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEdgeProcessor#convertTenantEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertTenantEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  void testConvertTenantEventToDownlink_whenEdgeEvent_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantEdgeProcessor tenantEdgeProcessor = new TenantEdgeProcessor();

    // Act and Assert
    assertNull(tenantEdgeProcessor.convertTenantEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
