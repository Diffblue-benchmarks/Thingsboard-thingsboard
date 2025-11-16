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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
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

@ExtendWith(MockitoExtension.class)
class CalculateDeltaNodeDiffblueTest {
  @InjectMocks private CalculateDeltaNode calculateDeltaNode;

  @Mock private CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration;

  /**
   * Test {@link CalculateDeltaNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            calculateDeltaNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new CalculateDeltaNodeConfiguration()))));
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

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
    calculateDeltaNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_TELEMETRY_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act
    calculateDeltaNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg3() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data(null)
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_TELEMETRY_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act
    calculateDeltaNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg4() {
    // Arrange
    when(calculateDeltaNodeConfiguration.getInputValueKey()).thenThrow(new NumberFormatException());
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(calculateDeltaNodeConfiguration).getInputValueKey();
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CalculateDeltaNodeConfiguration} {@link
   *       CalculateDeltaNodeConfiguration#getInputValueKey()} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given CalculateDeltaNodeConfiguration getInputValueKey() return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenCalculateDeltaNodeConfigurationGetInputValueKeyReturn42() {
    // Arrange
    when(calculateDeltaNodeConfiguration.getInputValueKey()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(calculateDeltaNodeConfiguration).getInputValueKey();
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbContext} {@link TbContext#tellNext(TbMsg, String)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbContext tellNext(TbMsg, String) throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbContextTellNextThrowNumberFormatException() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new NumberFormatException())
        .when(ctx)
        .tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsg getData() return empty string; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString_thenCallsGetData() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbContext} {@link TbContext#tellNext(TbMsg, String)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbContext tellNext(TbMsg, String) throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbContextTellNextThrowNumberFormatException() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new NumberFormatException())
        .when(ctx)
        .tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} return {@code false}.
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbMsg isTypeOf(TbMsgType) return 'false'; then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbMsgIsTypeOfReturnFalse_thenCallsTellNext() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given NumberFormatException(); when TbMsg getData() throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNumberFormatException_whenTbMsgGetDataThrowNumberFormatException() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new NumberFormatException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given NumberFormatException(); when TbMsg isTypeOf(TbMsgType) throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNumberFormatException_whenTbMsgIsTypeOfThrowNumberFormatException() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link CalculateDeltaNode} (default constructor).
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given CalculateDeltaNode (default constructor); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair CalculateDeltaNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenCalculateDeltaNode_whenOne_thenReturnSecondIsValueOfTen()
      throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new CalculateDeltaNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link CalculateDeltaNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CalculateDeltaNode} (default constructor).
   *   <li>Then calls {@link TbMsg#getOriginator()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); given CalculateDeltaNode (default constructor); then calls getOriginator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture CalculateDeltaNode.processMsgAsync(TbContext, TbMsg)"
  })
  void testProcessMsgAsync_givenCalculateDeltaNode_thenCallsGetOriginator() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new NumberFormatException());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.processMsgAsync(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link CalculateDeltaNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link CalculateDeltaNodeConfiguration#isUseCache()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg); then calls isUseCache()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture CalculateDeltaNode.processMsgAsync(TbContext, TbMsg)"
  })
  void testProcessMsgAsync_thenCallsIsUseCache() {
    // Arrange
    when(calculateDeltaNodeConfiguration.isUseCache()).thenThrow(new NumberFormatException());
    TbContext ctx = mock(TbContext.class);

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

    // Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            calculateDeltaNode.processMsgAsync(
                ctx,
                ruleChainIdResult
                    .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                    .ts(1L)
                    .type("Type")
                    .build()));
    verify(calculateDeltaNodeConfiguration).isUseCache();
  }
}
