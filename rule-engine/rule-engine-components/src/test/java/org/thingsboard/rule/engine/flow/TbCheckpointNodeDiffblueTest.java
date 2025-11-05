package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbCheckpointNodeDiffblueTest {
  /**
   * Test {@link TbCheckpointNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code Queue Name}.
   *   <li>Then calls {@link TbContext#getQueueName()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckpointNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'Queue Name'; then calls getQueueName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckpointNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenQueueName_thenCallsGetQueueName() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act
    tbCheckpointNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbCheckpointNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#enqueueForTellNext(TbMsg, String, String,
   *       Runnable, Consumer)} does nothing.
   *   <li>Then calls {@link TbContext#enqueueForTellNext(TbMsg, String, String, Runnable,
   *       Consumer)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckpointNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext enqueueForTellNext(TbMsg, String, String, Runnable, Consumer) does nothing; then calls enqueueForTellNext(TbMsg, String, String, Runnable, Consumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckpointNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextEnqueueForTellNextDoesNothing_thenCallsEnqueueForTellNext() {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();

    TbContext ctx = mock(TbContext.class);
    doNothing()
        .when(ctx)
        .enqueueForTellNext(
            Mockito.<TbMsg>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<Runnable>any(),
            Mockito.<Consumer<Throwable>>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCheckpointNode.onMsg(ctx, msg);

    // Assert
    verify(ctx)
        .enqueueForTellNext(
            isA(TbMsg.class),
            (String) isNull(),
            eq("Success"),
            isA(Runnable.class),
            isA(Consumer.class));
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then not {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals
   *       {@code true} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then not ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenNotArrayNodeWithNfIsWithExactBigDecimalsTrueIteratorHasNext()
      throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode oldConfiguration = new ArrayNode(nf);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCheckpointNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(oldConfiguration.iterator().hasNext());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenObjectNodeWithNcIsWithExactBigDecimalsTrueSizeIsZero()
      throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCheckpointNode.upgrade(0, oldConfiguration);

    // Assert
    assertEquals(0, oldConfiguration.size());
    assertFalse(oldConfiguration.iterator().hasNext());
    assertTrue(oldConfiguration.isEmpty());
    assertTrue(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new TbCheckpointNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new TbCheckpointNode().upgrade(0, oldConfiguration).getSecond());
  }
}
