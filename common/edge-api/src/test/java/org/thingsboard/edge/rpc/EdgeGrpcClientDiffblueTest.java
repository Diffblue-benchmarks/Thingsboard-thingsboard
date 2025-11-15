package org.thingsboard.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class EdgeGrpcClientDiffblueTest {
  /**
   * Method under test: {@link EdgeGrpcClient#getServerMaxInboundMessageSize()}
   */
  @Test
  void testGetServerMaxInboundMessageSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new EdgeGrpcClient()).getServerMaxInboundMessageSize());
  }
}
