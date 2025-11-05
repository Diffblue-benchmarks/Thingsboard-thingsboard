package org.thingsboard.rule.engine.transaction;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbSynchronizationEndNodeDiffblueTest {
  /**
   * Test {@link TbSynchronizationEndNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSynchronizationEndNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSynchronizationEndNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellSuccessDoesNothing_thenCallsTellSuccess() {
    // Arrange
    TbSynchronizationEndNode tbSynchronizationEndNode = new TbSynchronizationEndNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSynchronizationEndNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }
}
