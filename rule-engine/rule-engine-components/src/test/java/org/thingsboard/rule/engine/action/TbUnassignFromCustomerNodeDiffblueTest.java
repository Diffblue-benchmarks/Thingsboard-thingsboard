package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbUnassignFromCustomerNodeDiffblueTest {
  /**
   * Test {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}.
   * <p>
   * Method under test:
   * {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}
   */
  @Test
  @DisplayName("Test createCustomerIfNotExists()")
  void testCreateCustomerIfNotExists() throws TbNodeException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();
    TbContext ctx = mock(TbContext.class);
    tbUnassignFromCustomerNode.init(ctx, new TbNodeConfiguration(null));

    // Act and Assert
    assertFalse(tbUnassignFromCustomerNode.createCustomerIfNotExists());
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}.
   * <ul>
   *   <li>Given {@link TbUnassignFromCustomerNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}
   */
  @Test
  @DisplayName("Test createCustomerIfNotExists(); given TbUnassignFromCustomerNode (default constructor)")
  void testCreateCustomerIfNotExists_givenTbUnassignFromCustomerNode() {
    // Arrange, Act and Assert
    assertFalse((new TbUnassignFromCustomerNode()).createCustomerIfNotExists());
  }

  /**
   * Test
   * {@link TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadCustomerNodeActionConfig(TbNodeConfiguration); then return 'null'")
  void testLoadCustomerNodeActionConfig_thenReturnNull() throws TbNodeException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();

    // Act and Assert
    assertNull(tbUnassignFromCustomerNode.loadCustomerNodeActionConfig(new TbNodeConfiguration(null)));
  }

  /**
   * Test
   * {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processCustomerAction(TbContext, TbMsg); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testProcessCustomerAction_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("foo"));
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
    assertThrows(RuntimeException.class, () -> tbUnassignFromCustomerNode.processCustomerAction(ctx, msg));
    verify(ctx).getTenantId();
  }

  /**
   * Test
   * {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).</li>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processCustomerAction(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor); then return get() is 'null'")
  void testProcessCustomerAction_givenTestDbCallbackExecutor_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
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

    // Act
    ListenableFuture<Void> actualProcessCustomerActionResult = tbUnassignFromCustomerNode.processCustomerAction(ctx,
        msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
    assertNull(actualProcessCustomerActionResult.get());
    assertTrue(actualProcessCustomerActionResult.isDone());
  }

  /**
   * Test new {@link TbUnassignFromCustomerNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbUnassignFromCustomerNode}
   */
  @Test
  @DisplayName("Test new TbUnassignFromCustomerNode (default constructor)")
  void testNewTbUnassignFromCustomerNode() {
    // Arrange, Act and Assert
    assertNull((new TbUnassignFromCustomerNode()).config);
  }
}
