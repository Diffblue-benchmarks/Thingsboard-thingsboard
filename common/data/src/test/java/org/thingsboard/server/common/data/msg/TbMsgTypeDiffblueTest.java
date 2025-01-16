package org.thingsboard.server.common.data.msg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbMsgTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMsgType#getRuleNodeConnection()}
   *   <li>{@link TbMsgType#isTellSelfOnly()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbMsgType valueOfResult = TbMsgType.valueOf("POST_ATTRIBUTES_REQUEST");

    // Act
    String actualRuleNodeConnection = valueOfResult.getRuleNodeConnection();

    // Assert
    assertEquals("Post attributes", actualRuleNodeConnection);
    assertFalse(valueOfResult.isTellSelfOnly());
  }
}
