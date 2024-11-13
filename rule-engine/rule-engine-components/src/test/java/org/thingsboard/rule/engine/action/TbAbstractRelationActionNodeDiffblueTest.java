package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractRelationActionNodeDiffblueTest {
  /**
   * Test
   * {@link TbAbstractRelationActionNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractRelationActionNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCreateRelationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test
   * {@link TbAbstractRelationActionNode#deleteRelationsByTypeAndDirection(TbContext, TbMsg, String, Executor)}
   * with {@code ctx}, {@code msg}, {@code relationType}, {@code executor}.
   * <p>
   * Method under test:
   * {@link TbAbstractRelationActionNode#deleteRelationsByTypeAndDirection(TbContext, TbMsg, String, Executor)}
   */
  @Test
  @DisplayName("Test deleteRelationsByTypeAndDirection(TbContext, TbMsg, String, Executor) with 'ctx', 'msg', 'relationType', 'executor'")
  void testDeleteRelationsByTypeAndDirectionWithCtxMsgRelationTypeExecutor() {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbCreateRelationNode.deleteRelationsByTypeAndDirection(ctx, null, "Relation Type", mock(Executor.class)));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbAbstractRelationActionNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test:
   * {@link TbAbstractRelationActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange and Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = (new TbCreateRelationNode()).upgrade(1, null);

    // Assert
    assertNull(actualUpgradeResult.getSecond());
    assertFalse(actualUpgradeResult.getFirst());
  }
}
