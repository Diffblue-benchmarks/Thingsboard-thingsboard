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

class TbSynchronizationBeginNodeDiffblueTest {
  /**
   * Test {@link TbSynchronizationBeginNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbSynchronizationBeginNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbSynchronizationBeginNode tbSynchronizationBeginNode = new TbSynchronizationBeginNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbSynchronizationBeginNode.onMsg(ctx, null);

    // Assert
    verify(ctx).tellSuccess(isNull());
  }
}
