package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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

class TbSplitArrayMsgNodeDiffblueTest {
  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then calls fields()")
  void testInit_givenArrayListIterator_thenCallsFields() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_ARRAY}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_ARRAY'; then throw RuntimeException")
  void testInit_givenStartArray_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code VALUE_NULL}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code VALUE_NULL}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then throw RuntimeException")
  void testOnMsg_thenThrowRuntimeException() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException("Msg data is not a JSON Array!")).when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("42")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSplitArrayMsgNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  void testOnMsg_whenTbContextTellFailureDoesNothing_thenCallsTellFailure()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("42")
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
    tbSplitArrayMsgNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }
}
