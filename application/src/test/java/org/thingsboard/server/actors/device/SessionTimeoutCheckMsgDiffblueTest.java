package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class SessionTimeoutCheckMsgDiffblueTest {
  /**
   * Test {@link SessionTimeoutCheckMsg#instance()}.
   *
   * <p>Method under test: {@link SessionTimeoutCheckMsg#instance()}
   */
  @Test
  @DisplayName("Test instance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SessionTimeoutCheckMsg SessionTimeoutCheckMsg.instance()"})
  void testInstance() {
    // Arrange, Act and Assert
    assertEquals(MsgType.SESSION_TIMEOUT_MSG, SessionTimeoutCheckMsg.instance().getMsgType());
  }

  /**
   * Test {@link SessionTimeoutCheckMsg#getMsgType()}.
   *
   * <p>Method under test: {@link SessionTimeoutCheckMsg#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MsgType SessionTimeoutCheckMsg.getMsgType()"})
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(MsgType.SESSION_TIMEOUT_MSG, SessionTimeoutCheckMsg.instance().getMsgType());
  }
}
