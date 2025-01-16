package org.thingsboard.rule.engine.flow;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.TbMsg;

class TbRuleChainOutputNodeDiffblueTest {
  /**
   * Test {@link TbRuleChainOutputNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.</li>
   *   <li>When {@link TbContext} {@link TbContext#getSelf()} return
   * {@link RuleNode#RuleNode()}.</li>
   *   <li>Then calls {@link TbContext#getSelf()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleChainOutputNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given RuleNode(); when TbContext getSelf() return RuleNode(); then calls getSelf()")
  void testOnMsg_givenRuleNode_whenTbContextGetSelfReturnRuleNode_thenCallsGetSelf() {
    // Arrange
    TbRuleChainOutputNode tbRuleChainOutputNode = new TbRuleChainOutputNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).output(Mockito.<TbMsg>any(), Mockito.<String>any());
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act
    tbRuleChainOutputNode.onMsg(ctx, null);

    // Assert
    verify(ctx).getSelf();
    verify(ctx).output(isNull(), isNull());
  }
}
