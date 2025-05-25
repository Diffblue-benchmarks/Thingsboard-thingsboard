package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbMsgCountNodeDiffblueTest {
  /**
   * Test new {@link TbMsgCountNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbMsgCountNode}
   */
  @Test
  @DisplayName("Test new TbMsgCountNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgCountNode.<init>()"})
  void testNewTbMsgCountNode() throws TbNodeException {
    // Arrange, Act and Assert
    TbPair<Boolean, JsonNode> upgradeResult = (new TbMsgCountNode()).upgrade(1, null);
    assertNull(upgradeResult.getSecond());
    assertFalse(upgradeResult.getFirst());
  }
}
