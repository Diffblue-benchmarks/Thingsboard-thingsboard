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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.queue.PartitionChangeMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;

class TbMsgGeneratorNodeDiffblueTest {
  /**
   * Test {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgGeneratorNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbMsgGeneratorNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
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
   * <ul>
   *   <li>Then return not First.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return not First")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnNotFirst() throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("originatorId", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbMsgGeneratorNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode expectedDoubleNode = iteratorResult.next();
    JsonNode nextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DoubleNode);
    assertEquals(expectedDoubleNode, nextResult);
    assertEquals(
        "{\n  \"originatorId\" : 10.0,\n  \"originatorType\" : 10.0\n}", second.toPrettyString());
    assertEquals(
        "{\n  \"originatorId\" : 10.0,\n  \"originatorType\" : 10.0\n}",
        oldConfiguration.toPrettyString());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then Second iterator next traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then Second iterator next traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenSecondIteratorNextTraverseReturnTreeTraversingParser()
      throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("originatorType", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(-1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\n  \"queueName\" : 10.0,\n  \"originatorType\" : 10.0\n}", second.toPrettyString());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Second iterator next toPrettyString is {@code "RULE_NODE"}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgGeneratorNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when zero; then return Second iterator next toPrettyString is '\"RULE_NODE\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgGeneratorNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenZero_thenReturnSecondIteratorNextToPrettyStringIsRuleNode()
      throws TbNodeException {
    // Arrange
    TbMsgGeneratorNode tbMsgGeneratorNode = new TbMsgGeneratorNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbMsgGeneratorNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals("\"RULE_NODE\"", nextResult.toPrettyString());
    assertEquals("{\n  \"originatorType\" : \"RULE_NODE\"\n}", second.toPrettyString());
    assertEquals("{\n  \"originatorType\" : \"RULE_NODE\"\n}", oldConfiguration.toPrettyString());
    assertEquals(1, second.size());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
  }
}
