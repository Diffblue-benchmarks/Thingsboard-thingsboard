package org.thingsboard.server.actors.ruleChain;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
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
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.msg.TbActorStopReason;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.service.queue.TbMsgPackCallback;

@ContextConfiguration(classes = {RuleNodeToRuleChainTellNextMsg.class, String.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class RuleNodeToRuleChainTellNextMsgDiffblueTest {
  @MockBean private RuleChainId ruleChainId;

  @MockBean private RuleNodeId ruleNodeId;

  @Autowired private RuleNodeToRuleChainTellNextMsg ruleNodeToRuleChainTellNextMsg;

  @Autowired private Set<String> set;

  @MockBean private TbMsg tbMsg;

  /**
   * Test {@link RuleNodeToRuleChainTellNextMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Given {@link TbMsg} {@link TbMsg#getCallback()} return {@link TbMsgCallback#EMPTY}.
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeToRuleChainTellNextMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); given TbMsg getCallback() return EMPTY; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeToRuleChainTellNextMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_givenTbMsgGetCallbackReturnEmpty_thenCallsGetId() {
    // Arrange
    when(ruleChainId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(tbMsg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    ruleNodeToRuleChainTellNextMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(ruleChainId).getId();
    verify(tbMsg).getCallback();
  }

  /**
   * Test {@link RuleNodeToRuleChainTellNextMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>Then calls {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeToRuleChainTellNextMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeToRuleChainTellNextMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_thenCallsOnFailure() {
    // Arrange
    when(ruleChainId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgPackCallback tbMsgPackCallback = mock(TbMsgPackCallback.class);
    doNothing().when(tbMsgPackCallback).onFailure(Mockito.<RuleEngineException>any());
    when(tbMsg.getCallback()).thenReturn(tbMsgPackCallback);

    // Act
    ruleNodeToRuleChainTellNextMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(ruleChainId).getId();
    verify(tbMsg).getCallback();
    verify(tbMsgPackCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link RuleNodeToRuleChainTellNextMsg#onTbActorStopped(TbActorStopReason)}.
   *
   * <ul>
   *   <li>When {@code STOPPED}.
   *   <li>Then calls {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * RuleNodeToRuleChainTellNextMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName(
      "Test onTbActorStopped(TbActorStopReason); when 'STOPPED'; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeToRuleChainTellNextMsg.onTbActorStopped(TbActorStopReason)"})
  void testOnTbActorStopped_whenStopped_thenCallsOnFailure() {
    // Arrange
    when(ruleChainId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgPackCallback tbMsgPackCallback = mock(TbMsgPackCallback.class);
    doNothing().when(tbMsgPackCallback).onFailure(Mockito.<RuleEngineException>any());
    when(tbMsg.getCallback()).thenReturn(tbMsgPackCallback);

    // Act
    ruleNodeToRuleChainTellNextMsg.onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(ruleChainId).getId();
    verify(tbMsg).getCallback();
    verify(tbMsgPackCallback).onFailure(isA(RuleEngineException.class));
  }
}
