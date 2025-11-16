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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;

class TbUnassignFromCustomerNodeDiffblueTest {
  /**
   * Test {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}.
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}
   */
  @Test
  @DisplayName("Test createCustomerIfNotExists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbUnassignFromCustomerNode.createCustomerIfNotExists()"})
  void testCreateCustomerIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(new TbUnassignFromCustomerNode().createCustomerIfNotExists());
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return CustomerNamePattern is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadCustomerNodeActionConfig(TbNodeConfiguration); then return CustomerNamePattern is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbUnassignFromCustomerNodeConfiguration TbUnassignFromCustomerNode.loadCustomerNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadCustomerNodeActionConfig_thenReturnCustomerNamePatternIsNull()
      throws TbNodeException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();
    TbUnassignFromCustomerNodeConfiguration tbUnassignFromCustomerNodeConfiguration =
        new TbUnassignFromCustomerNodeConfiguration();

    // Act
    TbUnassignFromCustomerNodeConfiguration actualLoadCustomerNodeActionConfigResult =
        tbUnassignFromCustomerNode.loadCustomerNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbUnassignFromCustomerNodeConfiguration)));

    // Assert
    assertNull(actualLoadCustomerNodeActionConfigResult.getCustomerNamePattern());
    assertSame(tbUnassignFromCustomerNodeConfiguration, actualLoadCustomerNodeActionConfigResult);
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext,
   * TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processCustomerAction(TbContext, TbMsg); given AlarmId(UUID) with id is randomUUID; then return get() is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbUnassignFromCustomerNode.processCustomerAction(TbContext, TbMsg)"
  })
  void testProcessCustomerAction_givenAlarmIdWithIdIsRandomUUID_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    ListenableFuture<Void> actualProcessCustomerActionResult =
        tbUnassignFromCustomerNode.processCustomerAction(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
    verify(msg).getOriginator();
    assertNull(actualProcessCustomerActionResult.get());
    assertTrue(actualProcessCustomerActionResult.isDone());
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext,
   * TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processCustomerAction(TbContext, TbMsg); when TbContext getTenantId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbUnassignFromCustomerNode.processCustomerAction(TbContext, TbMsg)"
  })
  void testProcessCustomerAction_whenTbContextGetTenantIdThrowRuntimeException() {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbUnassignFromCustomerNode.processCustomerAction(ctx, msg));
    verify(ctx).getTenantId();
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getOriginator()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext,
   * TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processCustomerAction(TbContext, TbMsg); when TbMsg getOriginator() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbUnassignFromCustomerNode.processCustomerAction(TbContext, TbMsg)"
  })
  void testProcessCustomerAction_whenTbMsgGetOriginatorThrowRuntimeException() {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbUnassignFromCustomerNode.processCustomerAction(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test new {@link TbUnassignFromCustomerNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbUnassignFromCustomerNode}
   */
  @Test
  @DisplayName("Test new TbUnassignFromCustomerNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbUnassignFromCustomerNode.<init>()"})
  void testNewTbUnassignFromCustomerNode() {
    // Arrange, Act and Assert
    assertNull(new TbUnassignFromCustomerNode().config);
  }
}
