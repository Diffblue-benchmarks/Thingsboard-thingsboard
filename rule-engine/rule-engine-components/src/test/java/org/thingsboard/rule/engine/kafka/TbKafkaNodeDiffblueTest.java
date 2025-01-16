package org.thingsboard.rule.engine.kafka;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbKafkaNodeDiffblueTest {
  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw RuntimeException")
  void testInitWithCtxConfiguration_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenThrow(new RuntimeException("client.id"));
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   * <p>
   * Method under test:
   * {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName("Test publish(TbContext, TbMsg, String, String)")
  void testPublish() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
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
    tbKafkaNode.publish(ctx, msg, "Topic", "Key");

    // Assert
    verify(ctx).getSelfId();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName("Test publish(TbContext, TbMsg, String, String); given RuleNodeId(UUID) with id is randomUUID")
  void testPublish_givenRuleNodeIdWithIdIsRandomUUID() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    // Act
    tbKafkaNode.publish(ctx, null, "Topic", "Key");

    // Assert
    verify(ctx).getSelfId();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName("Test publish(TbContext, TbMsg, String, String); then throw RuntimeException")
  void testPublish_thenThrowRuntimeException() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenThrow(new RuntimeException("[{}] Failed to process message: {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.publish(ctx, null, "Topic", "Key"));
    verify(ctx).getSelfId();
  }

  /**
   * Test {@link TbKafkaNode#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbKafkaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls isExternalNodeForceAck()")
  void testDestroy_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbKafkaNode tbKafkaNode = new TbKafkaNode();
    tbKafkaNode.init(ctx);

    // Act
    tbKafkaNode.destroy();

    // Assert that nothing has changed
    verify(ctx).isExternalNodeForceAck();
  }
}
