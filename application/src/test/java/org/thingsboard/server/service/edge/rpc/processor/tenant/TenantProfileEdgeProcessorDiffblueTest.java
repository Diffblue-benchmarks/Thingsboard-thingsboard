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

class TenantProfileEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link TenantProfileEdgeProcessor#convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>Then calls {@link EdgeEvent#getAction()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileEdgeProcessor#convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion); given 'ADDED'; then calls getAction()")
  void testConvertTenantProfileEventToDownlink_givenAdded_thenCallsGetAction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileEdgeProcessor tenantProfileEdgeProcessor = new TenantProfileEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.ADDED);

    // Act
    DownlinkMsg actualConvertTenantProfileEventToDownlinkResult = tenantProfileEdgeProcessor
        .convertTenantProfileEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertTenantProfileEventToDownlinkResult);
  }

  /**
   * Test
   * {@link TenantProfileEdgeProcessor#convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileEdgeProcessor#convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertTenantProfileEventToDownlink(EdgeEvent, EdgeVersion); when EdgeEvent(); then return 'null'")
  void testConvertTenantProfileEventToDownlink_whenEdgeEvent_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileEdgeProcessor tenantProfileEdgeProcessor = new TenantProfileEdgeProcessor();

    // Act and Assert
    assertNull(tenantProfileEdgeProcessor.convertTenantProfileEventToDownlink(new EdgeEvent(), EdgeVersion.V_3_3_0));
  }
}
