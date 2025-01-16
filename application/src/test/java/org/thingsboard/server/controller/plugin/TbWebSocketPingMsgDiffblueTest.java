package org.thingsboard.server.controller.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbWebSocketPingMsg.class})
@ExtendWith(SpringExtension.class)
class TbWebSocketPingMsgDiffblueTest {
  @Autowired
  private TbWebSocketPingMsg tbWebSocketPingMsg;

  /**
   * Test {@link TbWebSocketPingMsg#getMsg()}.
   * <p>
   * Method under test: {@link TbWebSocketPingMsg#getMsg()}
   */
  @Test
  @DisplayName("Test getMsg()")
  void testGetMsg() {
    // Arrange and Act
    ByteBuffer actualMsg = tbWebSocketPingMsg.getMsg();

    // Assert
    assertEquals(0, actualMsg.capacity());
    assertEquals(0, actualMsg.limit());
    assertEquals(0, actualMsg.position());
    assertEquals(0, actualMsg.array().length);
    assertFalse(actualMsg.hasRemaining());
    assertTrue(actualMsg.hasArray());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbWebSocketPingMsg}
   *   <li>{@link TbWebSocketPingMsg#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(TbWebSocketMsgType.PING, (new TbWebSocketPingMsg()).getType());
  }
}
