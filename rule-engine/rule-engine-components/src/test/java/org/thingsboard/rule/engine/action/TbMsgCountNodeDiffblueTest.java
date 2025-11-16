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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgCountNodeDiffblueTest {
  /**
   * Test {@link TbMsgCountNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbMsgCountNodeConfiguration}
   *       (default constructor).
   *   <li>Then calls {@link TbContext#getSelfId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgCountNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is TbMsgCountNodeConfiguration (default constructor); then calls getSelfId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsTbMsgCountNodeConfiguration_thenCallsGetSelfId()
      throws TbNodeException {
    // Arrange
    TbMsgCountNode tbMsgCountNode = new TbMsgCountNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());
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

    // Act
    tbMsgCountNode.init(
        ctx, new TbNodeConfiguration(new POJONode(new TbMsgCountNodeConfiguration())));

    // Assert
    verify(ctx).getSelfId();
    verify(ctx)
        .newMsg(
            (String) isNull(),
            eq(TbMsgType.MSG_COUNT_SELF_MSG),
            isA(EntityId.class),
            (CustomerId) isNull(),
            isA(TbMsgMetaData.class),
            eq(""));
    verify(ctx).tellSelf(isA(TbMsg.class), eq(0L));
  }

  /**
   * Test {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    TbMsgCountNode tbMsgCountNode = new TbMsgCountNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());

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

    // Act
    tbMsgCountNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
  }

  /**
   * Test {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} return {@code false}.
   *   <li>Then calls {@link TbMsg#isTypeOf(TbMsgType)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbMsg isTypeOf(TbMsgType) return 'false'; then calls isTypeOf(TbMsgType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbMsgIsTypeOfReturnFalse_thenCallsIsTypeOf() {
    // Arrange
    TbMsgCountNode tbMsgCountNode = new TbMsgCountNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);

    // Act
    tbMsgCountNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
    verify(msg).isTypeOf(TbMsgType.MSG_COUNT_SELF_MSG);
  }

  /**
   * Test {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given randomUUID.
   *   <li>When {@link TbMsg} {@link TbMsg#getId()} return randomUUID.
   *   <li>Then calls {@link TbMsg#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given randomUUID; when TbMsg getId() return randomUUID; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRandomUUID_whenTbMsgGetIdReturnRandomUUID_thenCallsGetId() {
    // Arrange
    TbMsgCountNode tbMsgCountNode = new TbMsgCountNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getId()).thenReturn(UUID.randomUUID());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    tbMsgCountNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
    verify(msg).getId();
    verify(msg).isTypeOf(TbMsgType.MSG_COUNT_SELF_MSG);
  }

  /**
   * Test new {@link TbMsgCountNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMsgCountNode}
   */
  @Test
  @DisplayName("Test new TbMsgCountNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.<init>()"})
  void testNewTbMsgCountNode() throws TbNodeException {
    // Arrange, Act and Assert
    TbPair<Boolean, JsonNode> upgradeResult = new TbMsgCountNode().upgrade(1, null);
    assertNull(upgradeResult.getSecond());
    assertFalse(upgradeResult.getFirst());
  }
}
