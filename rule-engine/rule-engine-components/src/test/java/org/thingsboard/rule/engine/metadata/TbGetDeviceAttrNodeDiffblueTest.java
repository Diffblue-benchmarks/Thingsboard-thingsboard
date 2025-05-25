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

class TbGetDeviceAttrNodeDiffblueTest {
  /**
   * Test {@link TbGetDeviceAttrNode#loadNodeConfiguration(TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbGetDeviceAttrNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbGetDeviceAttrNodeConfiguration TbGetDeviceAttrNode.loadNodeConfiguration(TbNodeConfiguration)"})
  void testLoadNodeConfiguration_whenPOJONodeWithVIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbGetDeviceAttrNode tbGetDeviceAttrNode = new TbGetDeviceAttrNode();

    // Act and Assert
    assertNull(tbGetDeviceAttrNode.loadNodeConfiguration(new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test {@link TbGetDeviceAttrNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetDeviceAttrNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetDeviceAttrNode.upgrade(int, JsonNode)"})
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetDeviceAttrNode tbGetDeviceAttrNode = new TbGetDeviceAttrNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetDeviceAttrNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof MissingNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetDeviceAttrNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbGetDeviceAttrNode}
   */
  @Test
  @DisplayName("Test new TbGetDeviceAttrNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetDeviceAttrNode.<init>()"})
  void testNewTbGetDeviceAttrNode() {
    // Arrange and Act
    TbGetDeviceAttrNode actualTbGetDeviceAttrNode = new TbGetDeviceAttrNode();

    // Assert
    assertNull(actualTbGetDeviceAttrNode.config);
    assertNull(actualTbGetDeviceAttrNode.fetchTo);
  }
}
