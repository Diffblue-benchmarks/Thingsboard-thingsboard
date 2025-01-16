package org.thingsboard.server.service.edge.rpc.processor.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TelemetryEdgeProcessorDiffblueTest {
  /**
   * Test {@link TelemetryEdgeProcessor#getMsgSourceKey()}.
   * <p>
   * Method under test: {@link TelemetryEdgeProcessor#getMsgSourceKey()}
   */
  @Test
  @DisplayName("Test getMsgSourceKey()")
  void testGetMsgSourceKey() {
    // Arrange, Act and Assert
    assertEquals("edge", (new TelemetryEdgeProcessor()).getMsgSourceKey());
  }
}
