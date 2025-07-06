package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbFetchDeviceCredentialsNodeDiffblueTest {
  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_whenPOJONodeWithVIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act and Assert
    assertNull(
        tbFetchDeviceCredentialsNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is Instance.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_whenTbNodeConfigurationWithDataIsInstance()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act and Assert
    assertNull(
        tbFetchDeviceCredentialsNode.loadNodeConfiguration(
            new TbNodeConfiguration(NullNode.getInstance())));
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_whenTbNodeConfigurationWithDataIsNull_thenReturnNull()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act and Assert
    assertNull(tbFetchDeviceCredentialsNode.loadNodeConfiguration(new TbNodeConfiguration(null)));
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbFetchDeviceCredentialsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbFetchDeviceCredentialsNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbFetchDeviceCredentialsNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbFetchDeviceCredentialsNode}
   */
  @Test
  @DisplayName("Test new TbFetchDeviceCredentialsNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.<init>()"})
  void testNewTbFetchDeviceCredentialsNode() {
    // Arrange and Act
    TbFetchDeviceCredentialsNode actualTbFetchDeviceCredentialsNode =
        new TbFetchDeviceCredentialsNode();

    // Assert
    assertNull(actualTbFetchDeviceCredentialsNode.config);
    assertNull(actualTbFetchDeviceCredentialsNode.fetchTo);
  }
}
