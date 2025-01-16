package org.thingsboard.rule.engine.filter;

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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
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

class TbCheckAlarmStatusNodeDiffblueTest {
  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_ARRAY}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code VALUE_NULL}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code VALUE_NULL}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
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

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg2() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("[{}][{}] Failed to parse alarm: [{}] error [{}]")
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
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg3() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
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
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg4() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("")
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
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
  }
}
