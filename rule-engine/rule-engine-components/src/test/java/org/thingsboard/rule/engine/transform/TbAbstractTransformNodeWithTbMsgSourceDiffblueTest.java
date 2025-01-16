package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbAbstractTransformNodeWithTbMsgSourceDiffblueTest {
  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return Second is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when minus one; then return Second is 'null'")
  void testUpgrade_whenMinusOne_thenReturnSecondIsNull() throws TbNodeException {
    // Arrange and Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = (new TbCopyKeysNode()).upgrade(-1, null);

    // Assert
    assertNull(actualUpgradeResult.getSecond());
    assertFalse(actualUpgradeResult.getFirst());
  }
}
