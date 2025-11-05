package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbActorStopReason;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.service.queue.TbMsgPackCallback;

@ContextConfiguration(classes = {RuleChainInputMsg.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class TbToRuleChainActorMsgDiffblueTest {
  @Mock private RuleChainId ruleChainId;

  @MockBean private RuleChainId ruleChainId2;

  @Mock private TbMsg tbMsg;

  @MockBean private TbMsg tbMsg2;

  @Autowired private TbToRuleChainActorMsg tbToRuleChainActorMsg;

  /**
   * Test {@link TbToRuleChainActorMsg#getRuleChainId()}.
   *
   * <p>Method under test: {@link TbToRuleChainActorMsg#getRuleChainId()}
   */
  @Test
  @DisplayName("Test getRuleChainId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId TbToRuleChainActorMsg.getRuleChainId()"})
  void testGetRuleChainId() {
    // Arrange
    RuleChainId target = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleChainInputMsg ruleChainInputMsg = new RuleChainInputMsg(target, tbMsg);

    // Act and Assert
    assertSame(target, ruleChainInputMsg.getRuleChainId());
  }

  /**
   * Test {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Given {@link TbMsg} {@link TbMsg#getCallback()} return {@link TbMsgCallback#EMPTY}.
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); given TbMsg getCallback() return EMPTY; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleChainActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_givenTbMsgGetCallbackReturnEmpty_thenCallsGetId() {
    // Arrange
    when(ruleChainId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tbMsg2.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    tbToRuleChainActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(ruleChainId2).getId();
    verify(tbMsg2).getCallback();
  }

  /**
   * Test {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleChainActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_thenCallsOnFailure() {
    // Arrange
    when(ruleChainId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgPackCallback tbMsgPackCallback = mock(TbMsgPackCallback.class);
    doNothing().when(tbMsgPackCallback).onFailure(Mockito.<RuleEngineException>any());
    when(tbMsg2.getCallback()).thenReturn(tbMsgPackCallback);

    // Act
    tbToRuleChainActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(ruleChainId2).getId();
    verify(tbMsg2).getCallback();
    verify(tbMsgPackCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>When {@code STOPPED}.
   *   <li>Then calls {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); when 'STOPPED'; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleChainActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_whenStopped_thenCallsOnFailure() {
    // Arrange
    when(ruleChainId2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgPackCallback tbMsgPackCallback = mock(TbMsgPackCallback.class);
    doNothing().when(tbMsgPackCallback).onFailure(Mockito.<RuleEngineException>any());
    when(tbMsg2.getCallback()).thenReturn(tbMsgPackCallback);

    // Act
    tbToRuleChainActorMsg.onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(ruleChainId2).getId();
    verify(tbMsg2).getCallback();
    verify(tbMsgPackCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link TbToRuleChainActorMsg#getTarget()}.
   *
   * <p>Method under test: {@link TbToRuleChainActorMsg#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChainId TbToRuleChainActorMsg.getTarget()"})
  void testGetTarget() {
    // Arrange
    RuleChainId target = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg tbMsg =
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build();

    RuleChainInputMsg ruleChainInputMsg = new RuleChainInputMsg(target, tbMsg);

    // Act and Assert
    assertSame(target, ruleChainInputMsg.getTarget());
  }

  /**
   * Test {@link TbToRuleChainActorMsg#toString()}.
   *
   * <p>Method under test: {@link TbToRuleChainActorMsg#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TbToRuleChainActorMsg.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("RuleChainInputMsg()", new RuleChainInputMsg(ruleChainId, tbMsg).toString());
  }
}
