package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbAlarmMsgFactory;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then {@link TbMsgPushToCloudNode} (default constructor) {@link
   *       AbstractTbMsgPushNode#config} Scope is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then TbMsgPushToCloudNode (default constructor) config Scope is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenTbMsgPushToCloudNodeConfigScopeIsNull()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
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
   *
   * <ul>
   *   <li>Given {@code END_ARRAY}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code VALUE_NULL}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code VALUE_NULL}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode asToken() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeAsTokenThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#fields()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode fields() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeFieldsThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertDoesNotThrow(
        () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbNodeConfigurationWithDataIsNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertDoesNotThrow(() -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(null)));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName("Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_thenReturnNull() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    Object actualBuildEventResult = tbMsgPushToCloudNode.buildEvent(msg, ctx);

    // Assert
    verify(ctx).getTenantId();
    assertNull(actualBuildEventResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; when AlarmId(UUID) with id is randomUUID; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_whenAlarmIdWithIdIsRandomUUID_thenReturnNull() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    Object actualBuildEventResult = tbMsgPushToCloudNode.buildEvent(msg, ctx);

    // Assert
    verify(ctx).getTenantId();
    assertNull(actualBuildEventResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}
   */
  @Test
  @DisplayName("Test getUUIDFromMsgData(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractTbMsgPushNode.getUUIDFromMsgData(TbMsg)"})
  void testGetUUIDFromMsgData() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNull(tbMsgPushToCloudNode.getUUIDFromMsgData(msg));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}
   */
  @Test
  @DisplayName("Test getUUIDFromMsgData(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractTbMsgPushNode.getUUIDFromMsgData(TbMsg)"})
  void testGetUUIDFromMsgData2() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNull(tbMsgPushToCloudNode.getUUIDFromMsgData(msg));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getScope(Map)}.
   *
   * <ul>
   *   <li>Given {@code Metadata}.
   *   <li>When {@link HashMap#HashMap()} {@code scope} is {@code Metadata}.
   *   <li>Then return {@code Metadata}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getScope(Map)}
   */
  @Test
  @DisplayName(
      "Test getScope(Map); given 'Metadata'; when HashMap() 'scope' is 'Metadata'; then return 'Metadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTbMsgPushNode.getScope(Map)"})
  void testGetScope_givenMetadata_whenHashMapScopeIsMetadata_thenReturnMetadata() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    HashMap<String, String> metadata = new HashMap<>();
    metadata.put("scope", "Metadata");

    // Act and Assert
    assertEquals("Metadata", tbMsgPushToCloudNode.getScope(metadata));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertEquals(
        EdgeEventActionType.TIMESERIES_UPDATED,
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(msg));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType2() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.ACTIVITY_EVENT);

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
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertEquals(EdgeEventActionType.TIMESERIES_UPDATED, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Then return {@code POST_ATTRIBUTES}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg); then return 'POST_ATTRIBUTES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_thenReturnPostAttributes() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
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
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertEquals(EdgeEventActionType.POST_ATTRIBUTES, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(TbAlarmMsgFactory.alarmMsg(null)));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test isSupportedMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertTrue(tbMsgPushToCloudNode.isSupportedMsgType(msg));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>When alarmMsg {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test isSupportedMsgType(TbMsg); when alarmMsg 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType_whenAlarmMsgNull_thenReturnTrue() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    // Act and Assert
    assertTrue(tbMsgPushToCloudNode.isSupportedMsgType(TbAlarmMsgFactory.alarmMsg(null)));
  }
}
