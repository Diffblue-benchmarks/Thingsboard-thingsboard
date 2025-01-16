package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbAckNodeDiffblueTest {
  /**
   * Test {@link TbAckNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbAckNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbAckNode tbAckNode = new TbAckNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbAckNode.onMsg(ctx, null);

    // Assert
    verify(ctx).ack(isNull());
    verify(ctx).tellSuccess(isNull());
  }

  /**
   * Test new {@link TbAckNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbAckNode}
   */
  @Test
  @DisplayName("Test new TbAckNode (default constructor)")
  void testNewTbAckNode() {
    // Arrange, Act and Assert
    assertNull((new TbAckNode()).config);
  }
}
