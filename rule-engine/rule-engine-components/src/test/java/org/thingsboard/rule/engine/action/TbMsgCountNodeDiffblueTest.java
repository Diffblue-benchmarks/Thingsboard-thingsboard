package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbMsgCountNodeDiffblueTest {
  /**
   * Test {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#ack(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#ack(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgCountNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext ack(TbMsg) does nothing; then calls ack(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextAckDoesNothing_thenCallsAck() {
    // Arrange
    TbMsgCountNode tbMsgCountNode = new TbMsgCountNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgCountNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
  }

  /**
   * Test new {@link TbMsgCountNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMsgCountNode}
   */
  @Test
  @DisplayName("Test new TbMsgCountNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgCountNode.<init>()"})
  void testNewTbMsgCountNode() throws TbNodeException {
    // Arrange, Act and Assert
    TbPair<Boolean, JsonNode> upgradeResult = new TbMsgCountNode().upgrade(1, null);
    assertNull(upgradeResult.getSecond());
    assertFalse(upgradeResult.getFirst());
  }
}
