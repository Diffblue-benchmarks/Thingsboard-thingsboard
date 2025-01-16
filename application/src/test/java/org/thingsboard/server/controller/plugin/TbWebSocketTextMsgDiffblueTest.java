package org.thingsboard.server.controller.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbWebSocketTextMsg.class, String.class})
@ExtendWith(SpringExtension.class)
class TbWebSocketTextMsgDiffblueTest {
  @Autowired
  private TbWebSocketTextMsg tbWebSocketTextMsg;

  /**
   * Test {@link TbWebSocketTextMsg#getMsg()}.
   * <p>
   * Method under test: {@link TbWebSocketTextMsg#getMsg()}
   */
  @Test
  @DisplayName("Test getMsg()")
  void testGetMsg() {
    // Arrange, Act and Assert
    assertEquals("", tbWebSocketTextMsg.getMsg());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbWebSocketTextMsg#TbWebSocketTextMsg(String)}
   *   <li>{@link TbWebSocketTextMsg#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbWebSocketTextMsg actualTbWebSocketTextMsg = new TbWebSocketTextMsg("42");
    TbWebSocketMsgType actualType = actualTbWebSocketTextMsg.getType();

    // Assert
    assertEquals("42", actualTbWebSocketTextMsg.getMsg());
    assertEquals(TbWebSocketMsgType.TEXT, actualType);
  }
}
