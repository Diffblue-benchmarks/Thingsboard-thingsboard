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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class AttributesUpdateNodeCallbackDiffblueTest {
  /**
   * Test {@link AttributesUpdateNodeCallback#onSuccess(Void)} with {@code Void}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String,
   *       List)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributesUpdateNodeCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(Void) with 'Void'; then calls attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributesUpdateNodeCallback.onSuccess(Void)"})
  void testOnSuccessWithVoid_thenCallsAttributesUpdatedActionMsg() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

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
    when(ctx.attributesUpdatedActionMsg(
            Mockito.<EntityId>any(),
            Mockito.<RuleNodeId>any(),
            Mockito.<String>any(),
            Mockito.<List<AttributeKvEntry>>any()))
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());
    doNothing()
        .when(ctx)
        .enqueue(Mockito.<TbMsg>any(), Mockito.<Runnable>any(), Mockito.<Consumer<Throwable>>any());

    TbMsgBuilder callbackResult2 = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult2 = callbackResult2.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult2 = correlationIdResult2.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult2 =
        ctxResult2
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult2 =
        dataTypeResult2.id(UUID.randomUUID()).internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult2 =
        internalTypeResult2
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult2 =
        queueNameResult2.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg =
        ruleChainIdResult2
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build();

    AttributesUpdateNodeCallback attributesUpdateNodeCallback =
        new AttributesUpdateNodeCallback(ctx, msg, "Scope", new ArrayList<>());

    // Act
    attributesUpdateNodeCallback.onSuccess(null);

    // Assert
    verify(ctx)
        .attributesUpdatedActionMsg(isNull(), isA(RuleNodeId.class), eq("Scope"), isA(List.class));
    verify(ctx).enqueue(isA(TbMsg.class), isA(Runnable.class), isA(Consumer.class));
    verify(ctx).getSelfId();
  }
}
