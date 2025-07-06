package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetRelatedAttributeNodeDiffblueTest {
  /**
   * Test {@link TbGetRelatedAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code foo} is {@code foo}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetRelatedAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); given HashMap() 'foo' is 'foo'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetRelatedDataNodeConfiguration TbGetRelatedAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenHashMapFooIsFoo_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbGetRelatedAttributeNode tbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("foo", "foo");

    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration.setDataMapping(dataMapping);
    tbGetRelatedDataNodeConfiguration.setDataToFetch(null);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGetRelatedAttributeNode.loadNodeConfiguration(
                new TbNodeConfiguration(new POJONode(tbGetRelatedDataNodeConfiguration))));
  }

  /**
   * Test {@link TbGetRelatedAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetRelatedDataNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetRelatedAttributeNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetRelatedDataNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbGetRelatedDataNodeConfiguration TbGetRelatedAttributeNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetRelatedDataNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetRelatedAttributeNode tbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();

    HashMap<String, String> dataMapping = new HashMap<>();
    dataMapping.put("foo", "foo");

    TbGetRelatedDataNodeConfiguration tbGetRelatedDataNodeConfiguration =
        new TbGetRelatedDataNodeConfiguration();
    tbGetRelatedDataNodeConfiguration.setDataMapping(dataMapping);
    tbGetRelatedDataNodeConfiguration.setDataToFetch(DataToFetch.ATTRIBUTES);

    // Act and Assert
    assertSame(
        tbGetRelatedDataNodeConfiguration,
        tbGetRelatedAttributeNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetRelatedDataNodeConfiguration))));
  }

  /**
   * Test {@link TbGetRelatedAttributeNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbGetRelatedAttributeNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName(
      "Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'null'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbGetRelatedAttributeNode.checkDataToFetchSupportedOrElseThrow(DataToFetch)"
  })
  void testCheckDataToFetchSupportedOrElseThrow_whenNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbGetRelatedAttributeNode().checkDataToFetchSupportedOrElseThrow(null));
  }

  /**
   * Test {@link TbGetRelatedAttributeNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetRelatedAttributeNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbGetRelatedAttributeNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbGetRelatedAttributeNode tbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbGetRelatedAttributeNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetRelatedAttributeNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGetRelatedAttributeNode}
   */
  @Test
  @DisplayName("Test new TbGetRelatedAttributeNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbGetRelatedAttributeNode.<init>()"})
  void testNewTbGetRelatedAttributeNode() {
    // Arrange and Act
    TbGetRelatedAttributeNode actualTbGetRelatedAttributeNode = new TbGetRelatedAttributeNode();

    // Assert
    assertNull(actualTbGetRelatedAttributeNode.config);
    assertNull(actualTbGetRelatedAttributeNode.fetchTo);
  }
}
