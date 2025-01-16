package org.thingsboard.rule.engine.debug;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.queue.PartitionChangeMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;

class TbMsgGeneratorNodeDiffblueTest {
  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbMsgGeneratorNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).getQueueName();
  }

  /**
   * Test
   * {@link TbMsgGeneratorNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link TbContext#isLocalEntity(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgGeneratorNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}
   */
  @Test
  @DisplayName("Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); given 'false'; then calls isLocalEntity(EntityId)")
  void testOnPartitionChangeMsg_givenFalse_thenCallsIsLocalEntity() {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(false);

    // Act
    tbMsgGeneratorNode.onPartitionChangeMsg(ctx, new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(ctx).isLocalEntity(isNull());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return not First.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when minus one; then return not First")
  void testUpgrade_whenMinusOne_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMsgGeneratorNode.upgrade(-1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }
}
