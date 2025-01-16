package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbActorStopReason;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;

class QueueToRuleEngineMsgDiffblueTest {
  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test:
   * {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  void testOnTbActorStopped() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
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
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test:
   * {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  void testOnTbActorStopped2() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder ruleChainIdResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name")
        .ruleChainId(null);
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test:
   * {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  void testOnTbActorStopped3() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
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
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test:
   * {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  void testOnTbActorStopped4() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder ruleChainIdResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name")
        .ruleChainId(null);
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#isTellNext()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#isTellNext()}
   */
  @Test
  @DisplayName("Test isTellNext(); then return 'false'")
  void testIsTellNext_thenReturnFalse() {
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
    assertFalse((new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message")).isTellNext());
  }
}
