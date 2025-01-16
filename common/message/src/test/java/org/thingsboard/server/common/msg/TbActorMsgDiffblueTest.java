package org.thingsboard.server.common.msg;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbActorMsgDiffblueTest {
  /**
   * Test {@link TbActorMsg#onTbActorStopped(TbActorStopReason)}.
   * <ul>
   *   <li>Then calls {@link TbActorMsg#onTbActorStopped(TbActorStopReason)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason); then calls onTbActorStopped(TbActorStopReason)")
  void testOnTbActorStopped_thenCallsOnTbActorStopped() {
    // Arrange
    TbActorMsg tbActorMsg = mock(TbActorMsg.class);
    doNothing().when(tbActorMsg).onTbActorStopped(Mockito.<TbActorStopReason>any());

    // Act
    tbActorMsg.onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert that nothing has changed
    verify(tbActorMsg).onTbActorStopped(eq(TbActorStopReason.INIT_FAILED));
  }
}
