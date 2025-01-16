package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgCountNodeDiffblueTest {
  /**
   * Test {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#ack(TbMsg)} does nothing.</li>
   *   <li>Then calls {@link TbContext#ack(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext ack(TbMsg) does nothing; then calls ack(TbMsg)")
  void testOnMsg_whenTbContextAckDoesNothing_thenCallsAck() {
    // Arrange
    TbMsgCountNode tbMsgCountNode = new TbMsgCountNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbMsgCountNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
  }

  /**
   * Test new {@link TbMsgCountNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbMsgCountNode}
   */
  @Test
  @DisplayName("Test new TbMsgCountNode (default constructor)")
  void testNewTbMsgCountNode() throws TbNodeException {
    // Arrange, Act and Assert
    TbPair<Boolean, JsonNode> upgradeResult = (new TbMsgCountNode()).upgrade(1, null);
    assertNull(upgradeResult.getSecond());
    assertFalse(upgradeResult.getFirst());
  }
}
