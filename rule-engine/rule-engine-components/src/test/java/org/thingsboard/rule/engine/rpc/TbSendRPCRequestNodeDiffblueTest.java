package org.thingsboard.rule.engine.rpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbSendRPCRequestNodeDiffblueTest {
  /**
   * Test new {@link TbSendRPCRequestNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbSendRPCRequestNode}
   */
  @Test
  @DisplayName("Test new TbSendRPCRequestNode (default constructor)")
  void testNewTbSendRPCRequestNode() throws TbNodeException {
    // Arrange, Act and Assert
    TbPair<Boolean, JsonNode> upgradeResult = (new TbSendRPCRequestNode()).upgrade(1, null);
    assertNull(upgradeResult.getSecond());
    assertFalse(upgradeResult.getFirst());
  }
}
