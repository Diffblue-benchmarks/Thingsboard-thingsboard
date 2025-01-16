package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class AbstractTbMsgPushNodeDiffblueTest {
  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_ARRAY}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code END_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_ARRAY'; then throw RuntimeException")
  void testInit_givenStartArray_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then {@link TbMsgPushToCloudNode} (default constructor)
   * {@link AbstractTbMsgPushNode#config} Scope is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then TbMsgPushToCloudNode (default constructor) config Scope is 'null'")
  void testInit_givenStartObject_thenTbMsgPushToCloudNodeConfigScopeIsNull() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    assertNull(tbMsgPushToCloudNode.config.getScope());
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code VALUE_NULL}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code VALUE_NULL}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with
   * {@code msg}, {@code ctx}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code data}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName("Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; given RuntimeException(String) with 'data'; then throw RuntimeException")
  void testBuildEventWithMsgCtx_givenRuntimeExceptionWithData_thenThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("42")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_TELEMETRY_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException("data"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, ctx));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with
   * {@code msg}, {@code ctx}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName("Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; then throw IllegalArgumentException")
  void testBuildEventWithMsgCtx_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.TO_SERVER_RPC_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, mock(TbContext.class)));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}.
   * <ul>
   *   <li>Given {@link TbMsgBuilder} {@link TbMsgBuilder#metaData(TbMsgMetaData)}
   * return builder.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}
   */
  @Test
  @DisplayName("Test getUUIDFromMsgData(TbMsg); given TbMsgBuilder metaData(TbMsgMetaData) return builder; then return 'null'")
  void testGetUUIDFromMsgData_givenTbMsgBuilderMetaDataReturnBuilder_thenReturnNull() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9.callback(mock(TbMsgCallback.class));
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
    UUID actualUUIDFromMsgData = tbMsgPushToCloudNode.getUUIDFromMsgData(msg);

    // Assert
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
    assertNull(actualUUIDFromMsgData);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getScope(Map)}.
   * <ul>
   *   <li>Given {@code Metadata}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code scope} is {@code Metadata}.</li>
   *   <li>Then return {@code Metadata}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbMsgPushNode#getScope(Map)}
   */
  @Test
  @DisplayName("Test getScope(Map); given 'Metadata'; when HashMap() 'scope' is 'Metadata'; then return 'Metadata'")
  void testGetScope_givenMetadata_whenHashMapScopeIsMetadata_thenReturnMetadata() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    HashMap<String, String> metadata = new HashMap<>();
    metadata.put("scope", "Metadata");

    // Act and Assert
    assertEquals("Metadata", tbMsgPushToCloudNode.getScope(metadata));
  }
}
