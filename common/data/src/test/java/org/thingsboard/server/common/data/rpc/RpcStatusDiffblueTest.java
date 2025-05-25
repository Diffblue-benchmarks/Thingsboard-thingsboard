package org.thingsboard.server.common.data.rpc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcStatusDiffblueTest {
  /**
   * Test {@link RpcStatus#isPushDeleteNotificationToCore()}.
   * <p>
   * Method under test: {@link RpcStatus#isPushDeleteNotificationToCore()}
   */
  @Test
  @DisplayName("Test isPushDeleteNotificationToCore()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcStatus.isPushDeleteNotificationToCore()"})
  void testIsPushDeleteNotificationToCore() {
    // Arrange, Act and Assert
    assertTrue(RpcStatus.valueOf("QUEUED").isPushDeleteNotificationToCore());
  }
}
