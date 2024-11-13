package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
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

class TbAbstractCustomerActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then throw RuntimeException")
  void testOnMsg_thenThrowRuntimeException() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbContext ctx = mock(TbContext.class);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AlarmId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbAssignToCustomerNode.onMsg(ctx, msg));
  }

  /**
   * Test
   * {@link TbAbstractCustomerActionNode#getCustomerIdFuture(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractCustomerActionNode#getCustomerIdFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getCustomerIdFuture(TbContext, TbMsg); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testGetCustomerIdFuture_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbAssignToCustomerNode.getCustomerIdFuture(ctx, null));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test:
   * {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbContext ctx = mock(TbContext.class);
    tbAssignToCustomerNode.init(ctx, new TbNodeConfiguration(null));
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbAssignToCustomerNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link TbAssignToCustomerNode} (default constructor).</li>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TbAssignToCustomerNode (default constructor); when one")
  void testUpgrade_givenTbAssignToCustomerNode_whenOne() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbAssignToCustomerNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Given {@link TbAssignToCustomerNode} (default constructor).</li>
   *   <li>When zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TbAssignToCustomerNode (default constructor); when zero")
  void testUpgrade_givenTbAssignToCustomerNode_whenZero() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbAssignToCustomerNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }
}
