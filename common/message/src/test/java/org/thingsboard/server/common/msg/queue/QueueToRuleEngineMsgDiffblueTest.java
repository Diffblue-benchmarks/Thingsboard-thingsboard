package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped2() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder ruleChainIdResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name")
        .ruleChainId(null);
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped3() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}.
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueToRuleEngineMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped4() {
    // Arrange
    TbMsgCallback callback = mock(TbMsgCallback.class);
    doNothing().when(callback).onFailure(Mockito.<RuleEngineException>any());
    TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder ruleChainIdResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name")
        .ruleChainId(null);
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    (new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(callback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link QueueToRuleEngineMsg#isTellNext()}.
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#isTellNext()}
   */
  @Test
  @DisplayName("Test isTellNext()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueToRuleEngineMsg.isTellNext()"})
  void testIsTellNext() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();

    // Act and Assert
    assertFalse((new QueueToRuleEngineMsg(tenantId, tbMsg, null, "Failure Message")).isTellNext());
  }

  /**
   * Test {@link QueueToRuleEngineMsg#isTellNext()}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueToRuleEngineMsg#isTellNext()}
   */
  @Test
  @DisplayName("Test isTellNext(); given HashSet() add '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueToRuleEngineMsg.isTellNext()"})
  void testIsTellNext_givenHashSetAdd42_thenReturnTrue() {
    // Arrange
    HashSet<String> relationTypes = new HashSet<>();
    relationTypes.add("42");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();

    // Act and Assert
    assertTrue((new QueueToRuleEngineMsg(tenantId, tbMsg, relationTypes, "Failure Message")).isTellNext());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueToRuleEngineMsg.isTellNext()"})
  void testIsTellNext_thenReturnFalse() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);
    TbMsgBuilder correlationIdResult = callbackResult
        .correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsgBuilder dataTypeResult = ctxResult
        .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsgBuilder queueNameResult = dataTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
        .metaData(TbMsgMetaData.EMPTY)
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsgBuilder ruleChainIdResult = queueNameResult
        .ruleChainId(new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .ts(1L)
        .type("Type")
        .build();

    // Act and Assert
    assertFalse((new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message")).isTellNext());
  }
}
