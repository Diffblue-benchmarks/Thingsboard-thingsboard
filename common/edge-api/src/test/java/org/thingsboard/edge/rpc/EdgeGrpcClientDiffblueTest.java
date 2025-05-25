package org.thingsboard.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeGrpcClientDiffblueTest {
  /**
   * Test {@link EdgeGrpcClient#getServerMaxInboundMessageSize()}.
   * <p>
   * Method under test: {@link EdgeGrpcClient#getServerMaxInboundMessageSize()}
   */
  @Test
  @DisplayName("Test getServerMaxInboundMessageSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int EdgeGrpcClient.getServerMaxInboundMessageSize()"})
  void testGetServerMaxInboundMessageSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new EdgeGrpcClient()).getServerMaxInboundMessageSize());
  }
}
