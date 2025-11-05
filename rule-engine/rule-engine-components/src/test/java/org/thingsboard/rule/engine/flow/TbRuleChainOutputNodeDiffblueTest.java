package org.thingsboard.rule.engine.flow;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.TbMsg;

class TbRuleChainOutputNodeDiffblueTest {
  /**
   * Test {@link TbRuleChainOutputNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.
   *   <li>When {@link TbContext} {@link TbContext#getSelf()} return {@link RuleNode#RuleNode()}.
   *   <li>Then calls {@link TbContext#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainOutputNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuleNode(); when TbContext getSelf() return RuleNode(); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRuleChainOutputNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuleNode_whenTbContextGetSelfReturnRuleNode_thenCallsGetSelf() {
    // Arrange
    TbRuleChainOutputNode tbRuleChainOutputNode = new TbRuleChainOutputNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).output(Mockito.<TbMsg>any(), Mockito.<String>any());
    when(ctx.getSelf()).thenReturn(new RuleNode());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbRuleChainOutputNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getSelf();
    verify(ctx).output(isA(TbMsg.class), isNull());
  }
}
