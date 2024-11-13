package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetRelatedAttributeNodeDiffblueTest {
  /**
   * Test
   * {@link TbGetRelatedAttributeNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetRelatedAttributeNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName("Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'null'; then throw TbNodeException")
  void testCheckDataToFetchSupportedOrElseThrow_whenNull_thenThrowTbNodeException() throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(TbNodeException.class,
        () -> (new TbGetRelatedAttributeNode()).checkDataToFetchSupportedOrElseThrow(null));
  }

  /**
   * Test {@link TbGetRelatedAttributeNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetRelatedAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetRelatedAttributeNode tbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetRelatedAttributeNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetRelatedAttributeNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbGetRelatedAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetRelatedAttributeNode (default constructor)")
  void testNewTbGetRelatedAttributeNode() {
    // Arrange and Act
    TbGetRelatedAttributeNode actualTbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();

    // Assert
    assertNull(actualTbGetRelatedAttributeNode.config);
    assertNull(actualTbGetRelatedAttributeNode.fetchTo);
  }
}
