package org.thingsboard.server.actors.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.msg.MsgType;

class AppInitMsgDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AppInitMsg}
   *   <li>{@link AppInitMsg#getMsgType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AppInitMsg.<init>()", "MsgType AppInitMsg.getMsgType()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(MsgType.APP_INIT_MSG, new AppInitMsg().getMsgType());
  }
}
