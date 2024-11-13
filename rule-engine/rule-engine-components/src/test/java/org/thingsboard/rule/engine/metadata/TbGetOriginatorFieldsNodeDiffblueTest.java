package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetOriginatorFieldsNodeDiffblueTest {
  /**
   * Test {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return not First.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return not First")
  void testUpgrade_whenOne_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    TbGetOriginatorFieldsNode tbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetOriginatorFieldsNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetOriginatorFieldsNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbGetOriginatorFieldsNode}
   */
  @Test
  @DisplayName("Test new TbGetOriginatorFieldsNode (default constructor)")
  void testNewTbGetOriginatorFieldsNode() {
    // Arrange and Act
    TbGetOriginatorFieldsNode actualTbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();

    // Assert
    assertNull(actualTbGetOriginatorFieldsNode.config);
    assertNull(actualTbGetOriginatorFieldsNode.fetchTo);
  }
}
