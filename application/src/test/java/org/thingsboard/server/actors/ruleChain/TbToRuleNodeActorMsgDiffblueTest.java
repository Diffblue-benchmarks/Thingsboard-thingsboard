package org.thingsboard.server.actors.ruleChain;

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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.TbActorId;
import org.thingsboard.server.actors.TbActorMailbox;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.TbActorStopReason;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

@ContextConfiguration(classes = {RuleNodeToSelfMsg.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class TbToRuleNodeActorMsgDiffblueTest {
  @MockBean private TbContext tbContext;

  @MockBean private TbMsg tbMsg;

  @Autowired private TbToRuleNodeActorMsg tbToRuleNodeActorMsg;

  /**
   * Test {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#getSelf()} return {@code null}.
   *   <li>Then calls {@link TbContext#getRuleChainName()}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); given TbContext getSelf() return 'null'; then calls getRuleChainName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_givenTbContextGetSelfReturnNull_thenCallsGetRuleChainName() {
    // Arrange
    when(tbContext.getRuleChainName()).thenReturn("Rule Chain Name");
    when(tbContext.getSelf()).thenReturn(null);
    when(tbMsg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    tbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(tbContext).getRuleChainName();
    verify(tbContext).getSelf();
    verify(tbMsg).getCallback();
  }

  /**
   * Test {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onFailure(RuleEngineException)} does
   *       nothing.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); given TbMsgCallback onFailure(RuleEngineException) does nothing; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_givenTbMsgCallbackOnFailureDoesNothing_thenCallsOnFailure() {
    // Arrange
    when(tbContext.getRuleChainName()).thenReturn("Rule Chain Name");
    when(tbContext.getSelf()).thenReturn(new RuleNode());

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    when(tbMsg.getCallback()).thenReturn(tbMsgCallback);

    // Act
    tbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(tbContext).getRuleChainName();
    verify(tbContext).getSelf();
    verify(tbMsg).getCallback();
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Given {@link TbMsg} {@link TbMsg#getCallback()} return {@link TbMsgCallback#EMPTY}.
   *   <li>Then calls {@link TbContext#getRuleChainName()}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); given TbMsg getCallback() return EMPTY; then calls getRuleChainName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_givenTbMsgGetCallbackReturnEmpty_thenCallsGetRuleChainName() {
    // Arrange
    when(tbContext.getRuleChainName()).thenReturn("Rule Chain Name");
    when(tbContext.getSelf()).thenReturn(new RuleNode());
    when(tbMsg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    tbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(tbContext).getRuleChainName();
    verify(tbContext).getSelf();
    verify(tbMsg).getCallback();
  }

  /**
   * Test {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Given {@link TbMsg} {@link TbMsg#getCallback()} return {@link TbMsgCallback#EMPTY}.
   *   <li>When {@code STOPPED}.
   * </ul>
   *
   * <p>Method under test: {@link TbToRuleNodeActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); given TbMsg getCallback() return EMPTY; when 'STOPPED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_givenTbMsgGetCallbackReturnEmpty_whenStopped() {
    // Arrange
    when(tbContext.getRuleChainName()).thenReturn("Rule Chain Name");
    when(tbContext.getSelf()).thenReturn(new RuleNode());
    when(tbMsg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    tbToRuleNodeActorMsg.onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(tbContext).getRuleChainName();
    verify(tbContext).getSelf();
    verify(tbMsg).getCallback();
  }

  /**
   * Test {@link TbToRuleNodeActorMsg#getCtx()}.
   *
   * <p>Method under test: {@link TbToRuleNodeActorMsg#getCtx()}
   */
  @Test
  @DisplayName("Test getCtx()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbContext TbToRuleNodeActorMsg.getCtx()"})
  void testGetCtx() {
    // Arrange
    ActorSystemContext mainCtx = new ActorSystemContext();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbActorMailbox chainActor =
        new TbActorMailbox(null, null, mock(TbActorId.class), null, null, null);
    TbActorMailbox selfActor =
        new TbActorMailbox(null, null, mock(TbActorId.class), null, null, null);

    RuleNodeCtx nodeCtx = new RuleNodeCtx(tenantId, chainActor, selfActor, new RuleNode());

    DefaultTbContext ctx = new DefaultTbContext(mainCtx, "Rule Chain Name", nodeCtx);

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

    RuleNodeToSelfMsg ruleNodeToSelfMsg = new RuleNodeToSelfMsg(ctx, tbMsg);

    // Act and Assert
    assertSame(ctx, ruleNodeToSelfMsg.getCtx());
  }
}
