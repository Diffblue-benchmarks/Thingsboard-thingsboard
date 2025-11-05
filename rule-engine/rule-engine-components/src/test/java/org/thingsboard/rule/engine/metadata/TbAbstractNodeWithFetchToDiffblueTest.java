package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbAbstractNodeWithFetchToDiffblueTest {
  /**
   * Test {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractNodeWithFetchTo.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode arrayNode = new ArrayNode(nf);
    SimpleEntry<String, JsonNode> simpleEntry = new SimpleEntry<>("Key", arrayNode);
    entryList.add(simpleEntry);

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbFetchDeviceCredentialsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractNodeWithFetchTo.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbFetchDeviceCredentialsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow() throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    AsyncFunction<EntityId, EntityId> actualCheckIfEntityIsPresentOrThrowResult =
        tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId alarmId = new AlarmId(id);
    ListenableFuture<EntityId> actualApplyResult =
        actualCheckIfEntityIsPresentOrThrowResult.apply(alarmId);

    // Assert
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
    assertTrue(actualApplyResult.isDone());
    assertSame(alarmId, actualApplyResult.get());
    assertSame(id, alarmId.getId());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   *
   * <ul>
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName("Test checkIfEntityIsPresentOrThrow(String); then 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow_thenNull() throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act and Assert
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
    assertNull(null);
    assertTrue(
        tbFetchDeviceCredentialsNode
            .checkIfEntityIsPresentOrThrow("Not all who wander are lost")
            .apply(null)
            .isDone());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}.
   *
   * <ul>
   *   <li>Then {@link TbFetchDeviceCredentialsNode} (default constructor) {@link
   *       TbAbstractNodeWithFetchTo#config} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName(
      "Test checkIfEntityIsPresentOrThrow(String); then TbFetchDeviceCredentialsNode (default constructor) config is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow_thenTbFetchDeviceCredentialsNodeConfigIsNull() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost");

    // Assert that nothing has changed
    assertNull(tbFetchDeviceCredentialsNode.config);
    assertNull(tbFetchDeviceCredentialsNode.fetchTo);
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName("Test getMsgDataAsObjectNode(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode TbAbstractNodeWithFetchTo.getMsgDataAsObjectNode(TbMsg)"})
  void testGetMsgDataAsObjectNode() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName("Test getMsgDataAsObjectNode(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode TbAbstractNodeWithFetchTo.getMsgDataAsObjectNode(TbMsg)"})
  void testGetMsgDataAsObjectNode2() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("")
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName("Test getMsgDataAsObjectNode(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode TbAbstractNodeWithFetchTo.getMsgDataAsObjectNode(TbMsg)"})
  void testGetMsgDataAsObjectNode3() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data(null)
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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <p>Method under test: {@link
   * TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(
                oldConfiguration, "fetchTo", "If True", "If False")
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <p>Method under test: {@link
   * TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo2() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", BooleanNode.getTrue());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(
                oldConfiguration, "fetchTo", "If True", "If False")
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo_givenInstance() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", MissingNode.getInstance());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeRuleNodesWithOldPropertyToUseFetchTo(
                oldConfiguration, "fetchTo", "If True", "If False"));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String); given valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo_givenValueOfTen() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeRuleNodesWithOldPropertyToUseFetchTo(
                oldConfiguration, "fetchTo", "If True", "If False"));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When {@code Old Property}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String); given valueOf ten; when 'Old Property'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo_givenValueOfTen_whenOldProperty()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeRuleNodesWithOldPropertyToUseFetchTo(
                oldConfiguration, "Old Property", "If True", "If False"));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode,
   * String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractNodeWithFetchTo#upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeRuleNodesWithOldPropertyToUseFetchTo(JsonNode, String, String, String)"
  })
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo_whenEmptyString() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(oldConfiguration, "fetchTo", "If True", "")
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", "If True", "If False", newConfig)
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName("Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo2() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", BooleanNode.getTrue());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", "If True", "If False", newConfig)
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_givenInstance() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", MissingNode.getInstance());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
                "fetchTo", "If True", "If False", newConfig));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); given valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_givenValueOfTen() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbFetchDeviceCredentialsNode.upgradeConfigurationToUseFetchTo(
                "fetchTo", "If True", "If False", newConfig));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then Second return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); when empty string; then Second return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_whenEmptyString_thenSecondReturnObjectNode()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", "If True", "", newConfig)
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }
}
