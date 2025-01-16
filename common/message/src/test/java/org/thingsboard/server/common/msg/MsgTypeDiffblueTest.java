package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MsgTypeDiffblueTest {
  /**
   * Test {@link MsgType#isIgnoreOnStart()}.
   * <p>
   * Method under test: {@link MsgType#isIgnoreOnStart()}
   */
  @Test
  @DisplayName("Test isIgnoreOnStart()")
  void testIsIgnoreOnStart() {
    // Arrange, Act and Assert
    assertTrue(MsgType.valueOf("PARTITION_CHANGE_MSG").isIgnoreOnStart());
  }
}
