package org.thingsboard.server.common.msg.session;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionMsgTypeDiffblueTest {
  /**
   * Test {@link SessionMsgType#requiresRulesProcessing()}.
   * <p>
   * Method under test: {@link SessionMsgType#requiresRulesProcessing()}
   */
  @Test
  @DisplayName("Test requiresRulesProcessing()")
  void testRequiresRulesProcessing() {
    // Arrange, Act and Assert
    assertTrue(SessionMsgType.valueOf("GET_ATTRIBUTES_REQUEST").requiresRulesProcessing());
  }
}
