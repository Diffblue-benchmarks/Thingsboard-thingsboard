package org.thingsboard.server.actors.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class StatsPersistTickDiffblueTest {
  /**
   * Test {@link StatsPersistTick#getMsgType()}.
   *
   * <p>Method under test: {@link StatsPersistTick#getMsgType()}
   */
  @Test
  @DisplayName("Test getMsgType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MsgType StatsPersistTick.getMsgType()"})
  void testGetMsgType() {
    // Arrange, Act and Assert
    assertEquals(MsgType.STATS_PERSIST_TICK_MSG, StatsPersistTick.valueOf("INSTANCE").getMsgType());
  }
}
