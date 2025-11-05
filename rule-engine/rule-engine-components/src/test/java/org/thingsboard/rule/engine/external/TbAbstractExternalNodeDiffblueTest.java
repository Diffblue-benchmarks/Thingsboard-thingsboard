package org.thingsboard.rule.engine.external;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.rule.engine.aws.lambda.TbAwsLambdaNode;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractExternalNodeDiffblueTest {
  /**
   * Test {@link TbAbstractExternalNode#init(TbContext)} with {@code ctx}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#init(TbContext)}
   */
  @Test
  @DisplayName("Test init(TbContext) with 'ctx'; given 'true'; then calls isExternalNodeForceAck()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.init(TbContext)"})
  void testInitWithCtx_givenTrue_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbAwsLambdaNode.init(ctx);

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test tellSuccess(TbContext, TbMsg); given TbAwsLambdaNode (default constructor); then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellSuccess(TbContext, TbMsg)"})
  void testTellSuccess_givenTbAwsLambdaNode_thenCallsTellSuccess() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg tbMsg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbAwsLambdaNode.tellSuccess(ctx, tbMsg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbContext, TbMsg, Throwable); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellFailure(TbContext, TbMsg, Throwable)"})
  void testTellFailure_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg tbMsg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbAwsLambdaNode.tellFailure(ctx, tbMsg, new Throwable());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellNext(TbMsg, String)} does nothing.
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName(
      "Test tellFailure(TbContext, TbMsg, Throwable); when TbContext tellNext(TbMsg, String) does nothing; then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractExternalNode.tellFailure(TbContext, TbMsg, Throwable)"})
  void testTellFailure_whenTbContextTellNextDoesNothing_thenCallsTellNext() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg tbMsg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbAwsLambdaNode.tellFailure(ctx, tbMsg, null);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Failure"));
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbAbstractExternalNode.ackIfNeeded(TbContext, TbMsg)"})
  void testAckIfNeeded() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    TbMsg actualAckIfNeededResult = tbAwsLambdaNode.ackIfNeeded(ctx, msg);

    // Assert
    assertSame(msg, actualAckIfNeededResult);
  }
}
