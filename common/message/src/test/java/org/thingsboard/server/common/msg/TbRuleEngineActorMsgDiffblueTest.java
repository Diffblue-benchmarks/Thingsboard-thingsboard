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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.queue.QueueToRuleEngineMsg;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbRuleEngineActorMsgDiffblueTest {
  /**
   * Method under test: {@link TbRuleEngineActorMsg#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertFalse(((TbRuleEngineActorMsg) new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .canEqual("Other"));
  }

  /**
   * Method under test: {@link TbRuleEngineActorMsg#getMsg()}
   */
  @Test
  void testGetMsg() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    QueueToRuleEngineMsg queueToRuleEngineMsg = new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(),
        "Failure Message");

    // Act and Assert
    assertSame(queueToRuleEngineMsg.msg, queueToRuleEngineMsg.getMsg());
  }

  /**
   * Method under test: {@link TbRuleEngineActorMsg#toString()}
   */
  @Test
  void testToString() {
    // Arrange
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9.callback(TbMsgCallback.EMPTY);
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message")).toString();

    // Assert
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
  }
}
