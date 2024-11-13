package org.thingsboard.rule.engine.transaction;

import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbSynchronizationEndNodeDiffblueTest {
  /**
   * Test {@link TbSynchronizationEndNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbSynchronizationEndNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbSynchronizationEndNode tbSynchronizationEndNode = new TbSynchronizationEndNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbSynchronizationEndNode.onMsg(ctx, null);

    // Assert
    verify(ctx).tellSuccess(isNull());
  }
}
