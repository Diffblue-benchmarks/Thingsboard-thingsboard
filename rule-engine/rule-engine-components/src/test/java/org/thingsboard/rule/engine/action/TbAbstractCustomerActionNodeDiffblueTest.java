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
package org.thingsboard.rule.engine.action;

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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractCustomerActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractCustomerActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbAssignToCustomerNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getOriginator()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); when TbMsg getOriginator() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractCustomerActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_whenTbMsgGetOriginatorThrowRuntimeException() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbAssignToCustomerNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#getCustomerIdFuture(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#getCustomerIdFuture(TbContext,
   * TbMsg)}
   */
  @Test
  @DisplayName(
      "Test getCustomerIdFuture(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbAbstractCustomerActionNode.getCustomerIdFuture(TbContext, TbMsg)"
  })
  void testGetCustomerIdFuture_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbAssignToCustomerNode.getCustomerIdFuture(ctx, mock(TbMsg.class)));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("customerCacheExpiration", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("customerCacheExpiration", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbAssignToCustomerNode.upgrade(0, oldConfiguration);

    // Assert
    assertEquals("{ }", oldConfiguration.toPrettyString());
    assertEquals(0, oldConfiguration.size());
    assertFalse(oldConfiguration.iterator().hasNext());
    assertTrue(oldConfiguration.isEmpty());
    assertTrue(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then not {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals
   *       {@code true} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then not ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenNotArrayNodeWithNfIsWithExactBigDecimalsTrueIteratorHasNext() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode oldConfiguration = new ArrayNode(nf);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbAssignToCustomerNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(oldConfiguration.iterator().hasNext());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbAssignToCustomerNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbAssignToCustomerNode().upgrade(0, oldConfiguration).getSecond());
  }
}
