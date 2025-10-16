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
package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.queue.QueueToRuleEngineMsg;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbRuleEngineActorMsgDiffblueTest {
  /**
   * Test {@link TbRuleEngineActorMsg#canEqual(Object)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleEngineActorMsg#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbRuleEngineActorMsg.canEqual(Object)"})
  void testCanEqual_thenReturnFalse() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    QueueToRuleEngineMsg queueToRuleEngineMsg =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act and Assert
    assertFalse(((TbRuleEngineActorMsg) queueToRuleEngineMsg).canEqual("Other"));
  }

  /**
   * Test {@link TbRuleEngineActorMsg#getMsg()}.
   *
   * <p>Method under test: {@link TbRuleEngineActorMsg#getMsg()}
   */
  @Test
  @DisplayName("Test getMsg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbRuleEngineActorMsg.getMsg()"})
  void testGetMsg() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    QueueToRuleEngineMsg queueToRuleEngineMsg =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act
    TbMsg actualMsg = queueToRuleEngineMsg.getMsg();

    // Assert
    assertSame(queueToRuleEngineMsg.msg, actualMsg);
  }
}
