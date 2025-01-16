package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbMsgTypeSwitchNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellNext(TbMsg, String)} does
   * nothing.</li>
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTypeSwitchNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext tellNext(TbMsg, String) does nothing; then calls tellNext(TbMsg, String)")
  void testOnMsg_whenTbContextTellNextDoesNothing_thenCallsTellNext() {
    // Arrange
    TbMsgTypeSwitchNode tbMsgTypeSwitchNode = new TbMsgTypeSwitchNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
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
    tbMsgTypeSwitchNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Post attributes"));
  }

  /**
   * Test new {@link TbMsgTypeSwitchNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbMsgTypeSwitchNode}
   */
  @Test
  @DisplayName("Test new TbMsgTypeSwitchNode (default constructor)")
  void testNewTbMsgTypeSwitchNode() {
    // Arrange, Act and Assert
    assertNull((new TbMsgTypeSwitchNode()).config);
  }
}
