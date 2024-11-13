package org.thingsboard.rule.engine.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbCheckMessageNodeDiffblueTest {
  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbCheckMessageNode tbCheckMessageNode = new TbCheckMessageNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbCheckMessageNode.onMsg(ctx, null);

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }
}
