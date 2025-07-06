package org.thingsboard.server.common.msg.session;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SessionMsgTypeDiffblueTest {
  /**
   * Test {@link SessionMsgType#requiresRulesProcessing()}.
   *
   * <p>Method under test: {@link SessionMsgType#requiresRulesProcessing()}
   */
  @Test
  @DisplayName("Test requiresRulesProcessing()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionMsgType.requiresRulesProcessing()"})
  void testRequiresRulesProcessing() {
    // Arrange, Act and Assert
    assertTrue(SessionMsgType.valueOf("GET_ATTRIBUTES_REQUEST").requiresRulesProcessing());
  }
}
