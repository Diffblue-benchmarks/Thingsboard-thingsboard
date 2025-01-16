package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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

class TbCopyAttributesToEntityViewNodeDiffblueTest {
  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode = new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_TELEMETRY_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbCopyAttributesToEntityViewNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given IllegalArgumentException(String) with 'foo'; then throw IllegalArgumentException")
  void testOnMsg_givenIllegalArgumentExceptionWithFoo_thenThrowIllegalArgumentException() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode = new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEntityViewService()).thenThrow(new IllegalArgumentException("foo"));

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "Message metadata is empty");
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(metaData)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbCopyAttributesToEntityViewNode.onMsg(ctx, msg));
    verify(ctx).getEntityViewService();
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellFailure(TbMsg, Throwable)")
  void testOnMsg_thenCallsTellFailure() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode = new TbCopyAttributesToEntityViewNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
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
    tbCopyAttributesToEntityViewNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test new {@link TbCopyAttributesToEntityViewNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbCopyAttributesToEntityViewNode}
   */
  @Test
  @DisplayName("Test new TbCopyAttributesToEntityViewNode (default constructor)")
  void testNewTbCopyAttributesToEntityViewNode() {
    // Arrange, Act and Assert
    assertNull((new TbCopyAttributesToEntityViewNode()).config);
  }
}
