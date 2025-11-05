package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetOriginatorFieldsNodeDiffblueTest {
  /**
   * Test {@link TbGetOriginatorFieldsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetOriginatorFieldsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetOriginatorFieldsConfiguration TbGetOriginatorFieldsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetOriginatorFieldsNode tbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetOriginatorFieldsNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(new TbGetOriginatorFieldsConfiguration()))));
  }

  /**
   * Test {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetOriginatorFieldsNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbGetOriginatorFieldsNode tbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("dataMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("dataMapping", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbGetOriginatorFieldsNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return not First.
   * </ul>
   *
   * <p>Method under test: {@link TbGetOriginatorFieldsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return not First")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetOriginatorFieldsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetOriginatorFieldsNode().upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetOriginatorFieldsNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGetOriginatorFieldsNode}
   */
  @Test
  @DisplayName("Test new TbGetOriginatorFieldsNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetOriginatorFieldsNode.<init>()"})
  void testNewTbGetOriginatorFieldsNode() {
    // Arrange and Act
    TbGetOriginatorFieldsNode actualTbGetOriginatorFieldsNode = new TbGetOriginatorFieldsNode();

    // Assert
    assertNull(actualTbGetOriginatorFieldsNode.config);
    assertNull(actualTbGetOriginatorFieldsNode.fetchTo);
  }
}
