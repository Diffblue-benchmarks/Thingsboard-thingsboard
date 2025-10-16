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
package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbMsgDeduplicationNodeDiffblueTest {
  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code Queue Name}.
   *   <li>When {@link TbContext} {@link TbContext#getQueueName()} return {@code Queue Name}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'Queue Name'; when TbContext getQueueName() return 'Queue Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenQueueName_whenTbContextGetQueueNameReturnQueueName() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    // Act
    tbMsgDeduplicationNode.init(
        ctx, new TbNodeConfiguration(new POJONode(new TbMsgDeduplicationNodeConfiguration())));

    // Assert
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenRuntimeException_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbMsgDeduplicationNode.init(
                ctx,
                new TbNodeConfiguration(new POJONode(new TbMsgDeduplicationNodeConfiguration()))));
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbMsgDeduplicationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDeduplicationNode.onMsg(ctx, msg));
    verify(msg).isTypeOf(TbMsgType.DEDUPLICATION_TIMEOUT_SELF_MSG);
  }

  /**
   * Test {@link TbMsgDeduplicationNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} return {@code true}.
   *   <li>Then calls {@link TbMsg#getOriginator()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'true'; when TbMsg isTypeOf(TbMsgType) return 'true'; then calls getOriginator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeduplicationNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTrue_whenTbMsgIsTypeOfReturnTrue_thenCallsGetOriginator()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getOriginator()).thenReturn(null);

    // Act
    tbMsgDeduplicationNode.onMsg(ctx, msg);

    // Assert
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.DEDUPLICATION_TIMEOUT_SELF_MSG);
  }

  /**
   * Test {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}.
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbMsgDeduplicationNode tbMsgDeduplicationNode = new TbMsgDeduplicationNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("queueName", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbMsgDeduplicationNode.upgrade(0, oldConfiguration);

    // Assert
    assertEquals("{ }", oldConfiguration.toPrettyString());
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
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbMsgDeduplicationNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
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
