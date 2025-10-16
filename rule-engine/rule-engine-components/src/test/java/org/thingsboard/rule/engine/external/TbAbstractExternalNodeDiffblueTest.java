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
package org.thingsboard.rule.engine.external;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.aws.lambda.TbAwsLambdaNode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbAbstractExternalNodeDiffblueTest {
  /**
   * Test {@link TbAbstractExternalNode#init(TbContext)} with {@code ctx}.
   *
   * <p>Method under test: {@link TbAbstractExternalNode#init(TbContext)}
   */
  @Test
  @DisplayName("Test init(TbContext) with 'ctx'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.init(TbContext)"})
  void testInitWithCtx() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbAwsLambdaNode.init(ctx);

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test tellSuccess(TbContext, TbMsg); given TbAwsLambdaNode (default constructor); then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellSuccess(TbContext, TbMsg)"})
  void testTellSuccess_givenTbAwsLambdaNode_thenCallsTellSuccess() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbAwsLambdaNode.tellSuccess(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#enqueueForTellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg); then calls enqueueForTellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellSuccess(TbContext, TbMsg)"})
  void testTellSuccess_thenCallsEnqueueForTellNext() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);

    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg tbMsg = mock(TbMsg.class);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

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
    when(tbMsg.copyWithNewCtx())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Act
    tbAwsLambdaNode.tellSuccess(ctx2, tbMsg);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx).isExternalNodeForceAck();
    verify(tbMsg).copyWithNewCtx();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbContext, TbMsg, Throwable); given TbAwsLambdaNode (default constructor); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellFailure(TbContext, TbMsg, Throwable)"})
  void testTellFailure_givenTbAwsLambdaNode_thenCallsTellFailure() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg tbMsg = mock(TbMsg.class);

    // Act
    tbAwsLambdaNode.tellFailure(ctx, tbMsg, new Throwable());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#enqueueForTellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbContext, TbMsg, Throwable); then calls enqueueForTellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellFailure(TbContext, TbMsg, Throwable)"})
  void testTellFailure_thenCallsEnqueueForTellFailure() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);

    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg tbMsg = mock(TbMsg.class);

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

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
    when(tbMsg.copyWithNewCtx())
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, new Throwable());

    // Assert
    verify(ctx2).enqueueForTellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(ctx).isExternalNodeForceAck();
    verify(tbMsg).copyWithNewCtx();
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).
   *   <li>When {@link TbContext}.
   *   <li>Then return {@link TbMsg}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test ackIfNeeded(TbContext, TbMsg); given TbAwsLambdaNode (default constructor); when TbContext; then return TbMsg")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbAbstractExternalNode.ackIfNeeded(TbContext, TbMsg)"})
  void testAckIfNeeded_givenTbAwsLambdaNode_whenTbContext_thenReturnTbMsg() {
    // Arrange
    TbMsg msg = mock(TbMsg.class);

    // Act
    TbMsg actualAckIfNeededResult = new TbAwsLambdaNode().ackIfNeeded(mock(TbContext.class), msg);

    // Assert
    assertSame(msg, actualAckIfNeededResult);
  }
}
