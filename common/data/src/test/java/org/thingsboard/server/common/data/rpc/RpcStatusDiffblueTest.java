package org.thingsboard.server.common.data.rpc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RpcStatusDiffblueTest {
  /**
   * Test {@link RpcStatus#isPushDeleteNotificationToCore()}.
   * <p>
   * Method under test: {@link RpcStatus#isPushDeleteNotificationToCore()}
   */
  @Test
  @DisplayName("Test isPushDeleteNotificationToCore()")
  void testIsPushDeleteNotificationToCore() {
    // Arrange, Act and Assert
    assertTrue(RpcStatus.valueOf("QUEUED").isPushDeleteNotificationToCore());
  }
}
