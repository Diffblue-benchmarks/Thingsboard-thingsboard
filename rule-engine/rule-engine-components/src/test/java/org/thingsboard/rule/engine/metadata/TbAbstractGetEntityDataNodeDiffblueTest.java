package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.dao.cache.CacheExecutorService;

class TbAbstractGetEntityDataNodeDiffblueTest {
  /**
   * Test {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link CacheExecutorService} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given CacheExecutorService (default constructor)")
  void testOnMsg_givenCacheExecutorService() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new CacheExecutorService());
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
    tbGetCustomerAttributeNode.onMsg(ctx, msg);

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
  }

  /**
   * Test {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDataNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor); then calls tellFailure(TbMsg, Throwable)")
  void testOnMsg_givenTestDbCallbackExecutor_thenCallsTellFailure() {
    // Arrange
    TbGetCustomerAttributeNode tbGetCustomerAttributeNode = new TbGetCustomerAttributeNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
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
    tbGetCustomerAttributeNode.onMsg(ctx, msg);

    // Assert
    verify(ctx, atLeast(1)).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test
   * {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   * <ul>
   *   <li>When {@code FIELDS}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName("Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'FIELDS'; then throw TbNodeException")
  void testCheckDataToFetchSupportedOrElseThrow_whenFields_thenThrowTbNodeException() throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(TbNodeException.class,
        () -> (new TbGetCustomerAttributeNode()).checkDataToFetchSupportedOrElseThrow(DataToFetch.FIELDS));
  }

  /**
   * Test
   * {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractGetEntityDataNode#checkDataToFetchSupportedOrElseThrow(DataToFetch)}
   */
  @Test
  @DisplayName("Test checkDataToFetchSupportedOrElseThrow(DataToFetch); when 'null'; then throw TbNodeException")
  void testCheckDataToFetchSupportedOrElseThrow_whenNull_thenThrowTbNodeException() throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(TbNodeException.class,
        () -> (new TbGetCustomerAttributeNode()).checkDataToFetchSupportedOrElseThrow(null));
  }
}
