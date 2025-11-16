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
package org.thingsboard.rule.engine.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.PartitionChangeMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgGeneratorNodeDiffblueTest {
  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code CUSTOMER}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'CUSTOMER'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenCustomer_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration =
        new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.CUSTOMER);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbMsgGeneratorNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbMsgGeneratorNodeConfiguration))));
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEmptyString() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration =
        new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorId("");
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.CUSTOMER);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbMsgGeneratorNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbMsgGeneratorNodeConfiguration))));
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbContext} {@link TbContext#isLocalEntity(EntityId)} return {@code false}.
   *   <li>Then calls {@link TbContext#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'false'; when TbContext isLocalEntity(EntityId) return 'false'; then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenFalse_whenTbContextIsLocalEntityReturnFalse_thenCallsGetTenantId()
      throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(false);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration =
        new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.TENANT);

    // Act
    tbMsgGeneratorNode.init(
        ctx, new TbNodeConfiguration(new POJONode(tbMsgGeneratorNodeConfiguration)));

    // Assert
    verify(ctx).getQueueName();
    verify(ctx).getTenantId();
    verify(ctx).isLocalEntity(isA(EntityId.class));
  }

  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code RULE_NODE}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'RULE_NODE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenRuleNode() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
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
    when(ctx.newMsg(
            Mockito.<String>any(),
            Mockito.<TbMsgType>any(),
            Mockito.<EntityId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<TbMsgMetaData>any(),
            Mockito.<String>any()))
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(true);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration =
        new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.RULE_NODE);

    // Act
    tbMsgGeneratorNode.init(
        ctx, new TbNodeConfiguration(new POJONode(tbMsgGeneratorNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    verify(ctx).getQueueName();
    verify(ctx, atLeast(1)).getSelfId();
    verify(ctx).isLocalEntity(isA(EntityId.class));
    verify(ctx)
        .newMsg(
            eq("Queue Name"),
            eq(TbMsgType.GENERATOR_NODE_SELF_MSG),
            isA(EntityId.class),
            (CustomerId) isNull(),
            isA(TbMsgMetaData.class),
            eq(""));
    verify(ctx).tellSelf(isA(TbMsg.class), eq(0L));
  }

  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'TENANT'; then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTenant_thenCallsCreateScriptEngine() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
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
    when(ctx.newMsg(
            Mockito.<String>any(),
            Mockito.<TbMsgType>any(),
            Mockito.<EntityId>any(),
            Mockito.<CustomerId>any(),
            Mockito.<TbMsgMetaData>any(),
            Mockito.<String>any()))
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(true);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbMsgGeneratorNodeConfiguration tbMsgGeneratorNodeConfiguration =
        new TbMsgGeneratorNodeConfiguration();
    tbMsgGeneratorNodeConfiguration.setOriginatorType(EntityType.TENANT);

    // Act
    tbMsgGeneratorNode.init(
        ctx, new TbNodeConfiguration(new POJONode(tbMsgGeneratorNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    verify(ctx).getQueueName();
    verify(ctx).getSelfId();
    verify(ctx).getTenantId();
    verify(ctx).isLocalEntity(isA(EntityId.class));
    verify(ctx)
        .newMsg(
            eq("Queue Name"),
            eq(TbMsgType.GENERATOR_NODE_SELF_MSG),
            isA(EntityId.class),
            (CustomerId) isNull(),
            isA(TbMsgMetaData.class),
            eq(""));
    verify(ctx).tellSelf(isA(TbMsg.class), eq(0L));
  }

  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbMsgGeneratorNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbMsgGeneratorNodeConfiguration()))));
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgGeneratorNode#onPartitionChangeMsg(TbContext, PartitionChangeMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link TbContext#isLocalEntity(EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#onPartitionChangeMsg(TbContext,
   * PartitionChangeMsg)}
   */
  @Test
  @DisplayName(
      "Test onPartitionChangeMsg(TbContext, PartitionChangeMsg); given 'false'; then calls isLocalEntity(EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.onPartitionChangeMsg(TbContext, PartitionChangeMsg)"})
  void testOnPartitionChangeMsg_givenFalse_thenCallsIsLocalEntity() {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(false);

    // Act
    tbMsgGeneratorNode.onPartitionChangeMsg(ctx, new PartitionChangeMsg(ServiceType.TB_CORE));

    // Assert
    verify(ctx).isLocalEntity(isNull());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"
  })
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode value = new ArrayNode(nf);
    oldConfiguration.put("originatorId", value);
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(value, actualNextResult);
    assertTrue(nextResult instanceof TextNode);
    assertFalse(nextResult.iterator().hasNext());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then Second iterator next return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given 'null'; then Second iterator next return NullNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenNull_thenSecondIteratorNextReturnNullNode() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("originatorId", (JsonNode) null);
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(0, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isNull());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code queueName}.
   *   <li>When minus one.
   *   <li>Then return Second iterator next.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given 'queueName'; when minus one; then return Second iterator next")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenQueueName_whenMinusOne_thenReturnSecondIteratorNext()
      throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(-1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertEquals(nextResult, nextResult2);
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code queueName}.
   *   <li>When one.
   *   <li>Then Second iterator next return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given 'queueName'; when one; then Second iterator next return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenQueueName_whenOne_thenSecondIteratorNextReturnDoubleNode()
      throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgGeneratorNode} (default constructor).
   *   <li>When zero.
   *   <li>Then return Second size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbMsgGeneratorNode (default constructor); when zero; then return Second size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTbMsgGeneratorNode_whenZero_thenReturnSecondSizeIsOne()
      throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(1, second.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second size is one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondSizeIsOne() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals(1, second.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }
}
