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
package org.thingsboard.rule.engine.telemetry;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
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

class TelemetryNodeCallbackDiffblueTest {
  /**
   * Test {@link TelemetryNodeCallback#onSuccess(Void)} with {@code Void}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(Void) with 'Void'; given TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryNodeCallback.onSuccess(Void)"})
  void testOnSuccessWithVoid_givenTbContextTellSuccessDoesNothing_thenCallsTellSuccess() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

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
    TbMsg msg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);

    // Act
    telemetryNodeCallback.onSuccess(null);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TelemetryNodeCallback#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryNodeCallback.onFailure(Throwable)"})
  void testOnFailure_givenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

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
    TbMsg msg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);

    // Act
    telemetryNodeCallback.onFailure(new Throwable());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }
}
