package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class SessionTimeoutCheckMsgDiffblueTest {
  /**
   * Test {@link SessionTimeoutCheckMsg#instance()}.
   * <p>
   * Method under test: {@link SessionTimeoutCheckMsg#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  void testInstance() {
    // Arrange, Act and Assert
    assertEquals(MsgType.SESSION_TIMEOUT_MSG, SessionTimeoutCheckMsg.instance().getMsgType());
  }

  /**
   * Test {@link SessionTimeoutCheckMsg#getMsgType()}.
   * <p>
   * Method under test: {@link SessionTimeoutCheckMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(MsgType.SESSION_TIMEOUT_MSG, SessionTimeoutCheckMsg.instance().getMsgType());
  }
}
