package org.thingsboard.server.service.edge.rpc.processor.customer;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class CustomerEdgeProcessorDiffblueTest {
  /**
   * Test {@link CustomerEdgeProcessor#convertCustomerEventToDownlink(EdgeEvent, EdgeVersion)}.
   * <ul>
   *   <li>Given {@code POST_ATTRIBUTES}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomerEdgeProcessor#convertCustomerEventToDownlink(EdgeEvent, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertCustomerEventToDownlink(EdgeEvent, EdgeVersion); given 'POST_ATTRIBUTES'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.gen.edge.v1.DownlinkMsg CustomerEdgeProcessor.convertCustomerEventToDownlink(EdgeEvent, EdgeVersion)"})
  void testConvertCustomerEventToDownlink_givenPostAttributes_thenReturnNull() {
    // Arrange
    CustomerEdgeProcessor customerEdgeProcessor = new CustomerEdgeProcessor();

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.POST_ATTRIBUTES);

    // Act and Assert
    assertNull(customerEdgeProcessor.convertCustomerEventToDownlink(edgeEvent, EdgeVersion.V_3_3_0));
  }
}
