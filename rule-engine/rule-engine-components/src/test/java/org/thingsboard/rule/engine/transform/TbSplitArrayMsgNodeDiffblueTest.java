package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.EmptyNodeConfiguration;
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

class TbSplitArrayMsgNodeDiffblueTest {
  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenCallsFields() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
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
   *
   * <ul>
   *   <li>Given {@code END_ARRAY}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code VALUE_NULL}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code VALUE_NULL}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode asToken() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeAsTokenThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#fields()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode fields() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeFieldsThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link EmptyNodeConfiguration} (default
   *       constructor).
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is EmptyNodeConfiguration (default constructor); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsEmptyNodeConfiguration_thenDoesNotThrow()
      throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertDoesNotThrow(
        () ->
            tbSplitArrayMsgNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new EmptyNodeConfiguration()))));
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertDoesNotThrow(
        () -> tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbNodeConfigurationWithDataIsNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertDoesNotThrow(() -> tbSplitArrayMsgNode.init(ctx, new TbNodeConfiguration(null)));
  }

  /**
   * Test {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbSplitArrayMsgNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSplitArrayMsgNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSplitArrayMsgNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellFailure()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbSplitArrayMsgNode tbSplitArrayMsgNode = new TbSplitArrayMsgNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSplitArrayMsgNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }
}
