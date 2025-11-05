package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
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
   *
   * <ul>
   *   <li>Then return {@link TbGetDeviceAttrNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbGetDeviceAttrNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetDeviceAttrNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetDeviceAttrNodeConfiguration TbGetDeviceAttrNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetDeviceAttrNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetDeviceAttrNode tbGetDeviceAttrNode = new TbGetDeviceAttrNode();
    TbGetDeviceAttrNodeConfiguration tbGetDeviceAttrNodeConfiguration =
        new TbGetDeviceAttrNodeConfiguration();

    // Act
    TbGetDeviceAttrNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetDeviceAttrNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetDeviceAttrNodeConfiguration)));

    // Assert
    assertSame(tbGetDeviceAttrNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetDeviceAttrNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetDeviceAttrNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetDeviceAttrNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetDeviceAttrNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetDeviceAttrNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGetDeviceAttrNode}
   */
  @Test
  @DisplayName("Test new TbGetDeviceAttrNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetDeviceAttrNode.<init>()"})
  void testNewTbGetDeviceAttrNode() {
    // Arrange and Act
    TbGetDeviceAttrNode actualTbGetDeviceAttrNode = new TbGetDeviceAttrNode();

    // Assert
    assertNull(actualTbGetDeviceAttrNode.config);
    assertNull(actualTbGetDeviceAttrNode.fetchTo);
  }
}
