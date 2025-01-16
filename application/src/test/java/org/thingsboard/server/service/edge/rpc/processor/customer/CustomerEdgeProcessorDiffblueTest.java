package org.thingsboard.server.service.edge.rpc.processor.customer;

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

class CustomerEdgeProcessorDiffblueTest {
  /**
   * Test
   * {@link CustomerEdgeProcessor#convertCustomerEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerEdgeProcessor#convertCustomerEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertCustomerEventToDownlink(EdgeEvent, EdgeVersion); given 'POST_ATTRIBUTES'; then return 'null'")
  void testConvertCustomerEventToDownlink_givenPostAttributes_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerEdgeProcessor customerEdgeProcessor = new CustomerEdgeProcessor();
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEntityId()).thenReturn(UUID.randomUUID());
    when(edgeEvent.getAction()).thenReturn(EdgeEventActionType.POST_ATTRIBUTES);

    // Act
    DownlinkMsg actualConvertCustomerEventToDownlinkResult = customerEdgeProcessor
        .convertCustomerEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0);

    // Assert
    verify(edgeEvent).getAction();
    verify(edgeEvent).getEntityId();
    assertNull(actualConvertCustomerEventToDownlinkResult);
  }
}
