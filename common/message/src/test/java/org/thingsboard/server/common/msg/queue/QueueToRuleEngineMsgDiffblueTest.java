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
package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbActorStopReason;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;

class QueueToRuleEngineMsgDiffblueTest {
  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <p>Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    QueueToRuleEngineMsg queueToRuleEngineMsg =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act
    queueToRuleEngineMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <p>Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped2() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    QueueToRuleEngineMsg queueToRuleEngineMsg =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act
    queueToRuleEngineMsg.onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <p>Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped3() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder ruleChainIdResult =
        dataTypeResult
            .id(UUID.randomUUID())
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(TbMsgMetaData.EMPTY)
            .originator(null)
            .partition(1)
            .queueName("Queue Name")
            .ruleChainId(null);
    TbMsg tbMsg =
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    QueueToRuleEngineMsg queueToRuleEngineMsg =
        new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message");

    // Act
    queueToRuleEngineMsg.onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#isTellNext()}.
   *
   * <p>Method under test: {@link QueueToRuleEngineMsg#isTellNext()}
   */
  @Test
  @DisplayName("Test isTellNext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueToRuleEngineMsg.isTellNext()"})
  void testIsTellNext() {
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
        new QueueToRuleEngineMsg(tenantId, tbMsg, null, "Failure Message");

    // Act and Assert
    assertFalse(queueToRuleEngineMsg.isTellNext());
  }

  /**
   * Test {@link QueueToRuleEngineMsg#isTellNext()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code foo}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link QueueToRuleEngineMsg#isTellNext()}
   */
  @Test
  @DisplayName("Test isTellNext(); given HashSet() add 'foo'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueToRuleEngineMsg.isTellNext()"})
  void testIsTellNext_givenHashSetAddFoo_thenReturnTrue() {
    // Arrange
    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("foo");
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
        new QueueToRuleEngineMsg(tenantId, tbMsg, relationTypes, "Failure Message");

    // Act and Assert
    assertTrue(queueToRuleEngineMsg.isTellNext());
  }

  /**
   * Test {@link QueueToRuleEngineMsg#isTellNext()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link QueueToRuleEngineMsg#isTellNext()}
   */
  @Test
  @DisplayName("Test isTellNext(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean QueueToRuleEngineMsg.isTellNext()"})
  void testIsTellNext_thenReturnFalse() {
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
    assertFalse(queueToRuleEngineMsg.isTellNext());
  }
}
