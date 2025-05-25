package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetAttributesNodeDiffblueTest {
  /**
   * Test {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbGetAttributesNodeConfiguration TbGetAttributesNode.loadNodeConfiguration(TbNodeConfiguration)"})
  void testLoadNodeConfiguration_whenPOJONodeWithVIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();

    // Act and Assert
    assertNull(tbGetAttributesNode.loadNodeConfiguration(new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test {@link TbGetAttributesNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetAttributesNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof MissingNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetAttributesNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbGetAttributesNode}
   */
  @Test
  @DisplayName("Test new TbGetAttributesNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetAttributesNode.<init>()"})
  void testNewTbGetAttributesNode() {
    // Arrange and Act
    TbGetAttributesNode actualTbGetAttributesNode = new TbGetAttributesNode();

    // Assert
    assertNull(actualTbGetAttributesNode.config);
    assertNull(actualTbGetAttributesNode.fetchTo);
  }
}
