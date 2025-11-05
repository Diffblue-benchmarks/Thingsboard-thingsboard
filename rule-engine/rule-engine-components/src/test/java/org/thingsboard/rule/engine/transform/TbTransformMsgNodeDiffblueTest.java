package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
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

class TbTransformMsgNodeDiffblueTest {
  /**
   * Test {@link TbTransformMsgNode#transformFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#logJsEvalFailure()}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNode#transformFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test transformFailure(TbContext, TbMsg, Throwable); then calls logJsEvalFailure()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbTransformMsgNode.transformFailure(TbContext, TbMsg, Throwable)"})
  void testTransformFailure_thenCallsLogJsEvalFailure() {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).logJsEvalFailure();
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbTransformMsgNode.transformFailure(ctx, msg, new Throwable());

    // Assert
    verify(ctx).logJsEvalFailure();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test new {@link TbTransformMsgNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbTransformMsgNode}
   */
  @Test
  @DisplayName("Test new TbTransformMsgNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbTransformMsgNode.<init>()"})
  void testNewTbTransformMsgNode() {
    // Arrange, Act and Assert
    assertNull(new TbTransformMsgNode().config);
  }
}
