package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineActorMsg#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbRuleEngineActorMsg.canEqual(Object)"})
  void testCanEqual_thenReturnFalse() {
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
    assertFalse(((TbRuleEngineActorMsg) new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(), "Failure Message"))
        .canEqual("Other"));
  }

  /**
   * Test {@link TbRuleEngineActorMsg#getMsg()}.
   * <p>
   * Method under test: {@link TbRuleEngineActorMsg#getMsg()}
   */
  @Test
  @DisplayName("Test getMsg()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbMsg TbRuleEngineActorMsg.getMsg()"})
  void testGetMsg() {
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
    QueueToRuleEngineMsg queueToRuleEngineMsg = new QueueToRuleEngineMsg(tenantId, tbMsg, new HashSet<>(),
        "Failure Message");

    // Act and Assert
    assertSame(queueToRuleEngineMsg.msg, queueToRuleEngineMsg.getMsg());
  }
}
