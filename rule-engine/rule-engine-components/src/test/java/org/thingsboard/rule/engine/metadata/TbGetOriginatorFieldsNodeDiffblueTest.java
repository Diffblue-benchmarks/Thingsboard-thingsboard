package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetOriginatorFieldsNodeDiffblueTest {
  /**
   * Test {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then Second return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetOriginatorFieldsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnMissingNode() throws TbNodeException {
    // Arrange
    TbGetOriginatorFieldsNode tbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetOriginatorFieldsNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof MissingNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetOriginatorFieldsNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbGetOriginatorFieldsNode}
   */
  @Test
  @DisplayName("Test new TbGetOriginatorFieldsNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetOriginatorFieldsNode.<init>()"})
  void testNewTbGetOriginatorFieldsNode() {
    // Arrange and Act
    TbGetOriginatorFieldsNode actualTbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();

    // Assert
    assertNull(actualTbGetOriginatorFieldsNode.config);
    assertNull(actualTbGetOriginatorFieldsNode.fetchTo);
  }
}
