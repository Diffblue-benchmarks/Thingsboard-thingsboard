package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetDeviceAttrNodeDiffblueTest {
  /**
   * Test {@link TbGetDeviceAttrNode#loadNodeConfiguration(TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetDeviceAttrNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  void testLoadNodeConfiguration_whenTbNodeConfigurationWithDataIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbGetDeviceAttrNode tbGetDeviceAttrNode = new TbGetDeviceAttrNode();

    // Act and Assert
    assertNull(tbGetDeviceAttrNode.loadNodeConfiguration(new TbNodeConfiguration(null)));
  }

  /**
   * Test {@link TbGetDeviceAttrNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetDeviceAttrNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetDeviceAttrNode tbGetDeviceAttrNode = new TbGetDeviceAttrNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetDeviceAttrNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetDeviceAttrNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbGetDeviceAttrNode}
   */
  @Test
  @DisplayName("Test new TbGetDeviceAttrNode (default constructor)")
  void testNewTbGetDeviceAttrNode() {
    // Arrange and Act
    TbGetDeviceAttrNode actualTbGetDeviceAttrNode = new TbGetDeviceAttrNode();

    // Assert
    assertNull(actualTbGetDeviceAttrNode.config);
    assertNull(actualTbGetDeviceAttrNode.fetchTo);
  }
}
