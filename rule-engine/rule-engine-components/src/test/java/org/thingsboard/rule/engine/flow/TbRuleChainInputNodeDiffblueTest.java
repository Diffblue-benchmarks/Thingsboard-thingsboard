package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbRuleChainInputNodeDiffblueTest {
  /**
   * Test {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TbRuleChainInputNodeConfiguration} (default constructor) RuleChainId is
   *       {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'foo'; when TbRuleChainInputNodeConfiguration (default constructor) RuleChainId is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRuleChainInputNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenFoo_whenTbRuleChainInputNodeConfigurationRuleChainIdIsFoo()
      throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    TbContext ctx = mock(TbContext.class);

    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setRuleChainId("foo");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRuleChainInputNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRuleChainInputNodeConfiguration))));
  }

  /**
   * Test {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbRuleChainInputNodeConfiguration} (default constructor) RuleChainId is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'null'; when TbRuleChainInputNodeConfiguration (default constructor) RuleChainId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRuleChainInputNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenNull_whenTbRuleChainInputNodeConfigurationRuleChainIdIsNull()
      throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    TbContext ctx = mock(TbContext.class);

    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setRuleChainId(null);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRuleChainInputNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRuleChainInputNodeConfiguration))));
  }

  /**
   * Test {@link TbRuleChainInputNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbRuleChainInputNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbRuleChainInputNode.upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }
}
