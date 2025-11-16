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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbGetAttributesNodeDiffblueTest {
  /**
   * Test {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetAttributesNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetAttributesNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetAttributesNodeConfiguration TbGetAttributesNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetAttributesNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();

    // Act
    TbGetAttributesNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetAttributesNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetAttributesNodeConfiguration)));

    // Assert
    assertSame(tbGetAttributesNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test findEntityIdAsync(TbContext, TbMsg); given 'null'; then return get() is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbGetAttributesNode.findEntityIdAsync(TbContext, TbMsg)"})
  void testFindEntityIdAsync_givenNull_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(null);

    // Act
    ListenableFuture<EntityId> actualFindEntityIdAsyncResult =
        tbGetAttributesNode.findEntityIdAsync(ctx, msg);

    // Assert
    verify(msg).getOriginator();
    assertNull(actualFindEntityIdAsyncResult.get());
    assertTrue(actualFindEntityIdAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} is {@link AlarmId#AlarmId(UUID)} with id is
   *       randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test findEntityIdAsync(TbContext, TbMsg); then return get() is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbGetAttributesNode.findEntityIdAsync(TbContext, TbMsg)"})
  void testFindEntityIdAsync_thenReturnGetIsAlarmIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    AlarmId alarmId = new AlarmId(UUID.randomUUID());
    when(msg.getOriginator()).thenReturn(alarmId);

    // Act
    ListenableFuture<EntityId> actualFindEntityIdAsyncResult =
        tbGetAttributesNode.findEntityIdAsync(ctx, msg);

    // Assert
    verify(msg).getOriginator();
    assertSame(alarmId, actualFindEntityIdAsyncResult.get());
  }

  /**
   * Test {@link TbGetAttributesNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetAttributesNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetAttributesNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGetAttributesNode}
   */
  @Test
  @DisplayName("Test new TbGetAttributesNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetAttributesNode.<init>()"})
  void testNewTbGetAttributesNode() {
    // Arrange and Act
    TbGetAttributesNode actualTbGetAttributesNode = new TbGetAttributesNode();

    // Assert
    assertNull(actualTbGetAttributesNode.config);
    assertNull(actualTbGetAttributesNode.fetchTo);
  }
}
