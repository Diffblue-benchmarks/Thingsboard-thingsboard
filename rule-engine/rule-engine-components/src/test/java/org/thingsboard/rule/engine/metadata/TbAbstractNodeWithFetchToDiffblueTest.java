/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
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
    TbContext ctx = mock(TbContext.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode arrayNode = new ArrayNode(nf);
    SimpleEntry<String, JsonNode> simpleEntry = new SimpleEntry<>("foo", arrayNode);
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
    TbContext ctx = mock(TbContext.class);

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
   * <ul>
   *   <li>Then {@link AlarmId#AlarmId(UUID)} with id is randomUUID EntityType is {@code ALARM}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#checkIfEntityIsPresentOrThrow(String)}
   */
  @Test
  @DisplayName(
      "Test checkIfEntityIsPresentOrThrow(String); then AlarmId(UUID) with id is randomUUID EntityType is 'ALARM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AsyncFunction TbAbstractNodeWithFetchTo.checkIfEntityIsPresentOrThrow(String)"
  })
  void testCheckIfEntityIsPresentOrThrow_thenAlarmIdWithIdIsRandomUUIDEntityTypeIsAlarm()
      throws Exception {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    AsyncFunction<EntityId, EntityId> actualCheckIfEntityIsPresentOrThrowResult =
        tbFetchDeviceCredentialsNode.checkIfEntityIsPresentOrThrow("Not all who wander are lost");
    UUID id = UUID.randomUUID();
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

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data(null)
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(
                ruleChainIdResult
                    .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test getMsgDataAsObjectNode(TbMsg); given '42'; when TbMsg getData() return '42'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode TbAbstractNodeWithFetchTo.getMsgDataAsObjectNode(TbMsg)"})
  void testGetMsgDataAsObjectNode_given42_whenTbMsgGetDataReturn42_thenCallsGetData() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test getMsgDataAsObjectNode(TbMsg); given empty string; when TbMsg getData() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode TbAbstractNodeWithFetchTo.getMsgDataAsObjectNode(TbMsg)"})
  void testGetMsgDataAsObjectNode_givenEmptyString_whenTbMsgGetDataReturnEmptyString() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(msg));
    verify(msg).getData();
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#getMsgDataAsObjectNode(TbMsg)}
   */
  @Test
  @DisplayName("Test getMsgDataAsObjectNode(TbMsg); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ObjectNode TbAbstractNodeWithFetchTo.getMsgDataAsObjectNode(TbMsg)"})
  void testGetMsgDataAsObjectNode_givenIllegalArgumentException() {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbFetchDeviceCredentialsNode.getMsgDataAsObjectNode(msg));
    verify(msg).getData();
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
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(oldConfiguration, "fetchTo", null, null)
            .getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", oldConfiguration.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isTextual());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
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
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(oldConfiguration, "fetchTo", null, null)
            .getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", oldConfiguration.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isTextual());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
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
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo3() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(
                oldConfiguration, "fetchTo", null, Boolean.TRUE.toString())
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("\"true\"", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"true\"\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"true\"\n}", oldConfiguration.toPrettyString());
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
  void testUpgradeRuleNodesWithOldPropertyToUseFetchTo4() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeRuleNodesWithOldPropertyToUseFetchTo(oldConfiguration, "fetchTo", null, "")
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("\"\"", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"\"\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"\"\n}", oldConfiguration.toPrettyString());
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
                oldConfiguration, "fetchTo", null, null));
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
                oldConfiguration, "fetchTo", null, null));
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
                oldConfiguration, "Old Property", null, null));
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
    newConfig.put("fetchTo", BooleanNode.getTrue());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", null, null, newConfig)
            .getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", newConfig.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isTextual());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
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
    String ifFalse = Boolean.TRUE.toString();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", null, ifFalse, newConfig)
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("\"true\"", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"true\"\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"true\"\n}", newConfig.toPrettyString());
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
  void testUpgradeConfigurationToUseFetchTo3() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", null, "", newConfig)
            .getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("\"\"", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"\"\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : \"\"\n}", newConfig.toPrettyString());
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
                "fetchTo", null, null, newConfig));
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
                "fetchTo", null, null, newConfig));
  }

  /**
   * Test {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String, String, String,
   * ObjectNode)}.
   *
   * <ul>
   *   <li>Then Second iterator next return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractNodeWithFetchTo#upgradeConfigurationToUseFetchTo(String,
   * String, String, ObjectNode)}
   */
  @Test
  @DisplayName(
      "Test upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode); then Second iterator next return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractNodeWithFetchTo.upgradeConfigurationToUseFetchTo(String, String, String, ObjectNode)"
  })
  void testUpgradeConfigurationToUseFetchTo_thenSecondIteratorNextReturnNullNode()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode newConfig = new ObjectNode(nc);
    newConfig.put("fetchTo", BooleanNode.getFalse());

    // Act and Assert
    JsonNode second =
        tbFetchDeviceCredentialsNode
            .upgradeConfigurationToUseFetchTo("fetchTo", null, null, newConfig)
            .getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", second.toPrettyString());
    assertEquals("{\n  \"fetchTo\" : null\n}", newConfig.toPrettyString());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(nextResult.isTextual());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }
}
