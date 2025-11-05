package org.thingsboard.rule.engine.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
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
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.msg.queue.PartitionChangeMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;

class TbMsgGeneratorNodeDiffblueTest {
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
