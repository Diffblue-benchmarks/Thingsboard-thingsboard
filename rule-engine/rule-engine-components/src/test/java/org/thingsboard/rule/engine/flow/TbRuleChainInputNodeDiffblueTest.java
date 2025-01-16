package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbRuleChainInputNodeDiffblueTest {
  /**
   * Test {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbRuleChainInputNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbRuleChainInputNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbRuleChainInputNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).input(Mockito.<TbMsg>any(), Mockito.<RuleChainId>any());

    // Act
    tbRuleChainInputNode.onMsg(ctx, null);

    // Assert
    verify(ctx).input(isNull(), isNull());
  }

  /**
   * Test {@link TbRuleChainInputNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return not First.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleChainInputNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return not First")
  void testUpgrade_whenOne_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbRuleChainInputNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }
}
