package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbMsgDeduplicationNodeDiffblueTest {
  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code Queue Name}.
   *   <li>When {@link TbContext} {@link TbContext#getQueueName()} return {@code Queue Name}.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'Queue Name'; when TbContext getQueueName() return 'Queue Name'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenQueueName_whenTbContextGetQueueNameReturnQueueName_thenCallsFields()
      throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgDeduplicationNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgDeduplicationNode} (default constructor).
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given TbMsgDeduplicationNode (default constructor); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTbMsgDeduplicationNode_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMsgDeduplicationNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbNodeConfiguration#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenCallsGetData() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData())
        .thenReturn(new POJONode(new TbMsgDeduplicationNodeConfiguration()));

    // Act
    tbMsgDeduplicationNode.init(ctx, configuration);

    // Assert
    verify(ctx).getQueueName();
    verify(configuration).getData();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgDeduplicationNode} (default constructor).
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbMsgDeduplicationNode (default constructor); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenTbMsgDeduplicationNode_whenOne_thenReturnSecondIsValueOfTen()
      throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbMsgDeduplicationNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then not {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals
   *       {@code true} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then not ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenNotArrayNodeWithNfIsWithExactBigDecimalsTrueIteratorHasNext()
      throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode oldConfiguration = new ArrayNode(nf);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbMsgDeduplicationNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(oldConfiguration.iterator().hasNext());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenObjectNodeWithNcIsWithExactBigDecimalsTrueSizeIsZero()
      throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbMsgDeduplicationNode.upgrade(0, oldConfiguration);

    // Assert
    assertEquals(0, oldConfiguration.size());
    assertFalse(oldConfiguration.iterator().hasNext());
    assertTrue(oldConfiguration.isEmpty());
    assertTrue(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbMsgDeduplicationNode().upgrade(0, oldConfiguration).getSecond());
  }
}
