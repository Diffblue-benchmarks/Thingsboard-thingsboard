package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractTransformNodeDiffblueTest {
  /**
   * Test {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg, Throwable)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformFailure(TbContext, TbMsg,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test transformFailure(TbContext, TbMsg, Throwable); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformFailure(TbContext, TbMsg, Throwable)"})
  void testTransformFailure_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbChangeOriginatorNode.transformFailure(ctx, msg, new Throwable());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException()).when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    ArrayList<TbMsg> msgs = new ArrayList<>();
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    msgs.add(telemetryMsgResult);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbChangeOriginatorNode.transformSuccess(ctx, msg, msgs));
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, msg, new ArrayList<>());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNode#transformSuccess(TbContext, TbMsg, List)}
   */
  @Test
  @DisplayName(
      "Test transformSuccess(TbContext, TbMsg, List); when TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractTransformNode.transformSuccess(TbContext, TbMsg, List)"})
  void testTransformSuccess_whenTbContextTellSuccessDoesNothing_thenCallsTellSuccess() {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    ArrayList<TbMsg> msgs = new ArrayList<>();
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    msgs.add(telemetryMsgResult);

    // Act
    tbChangeOriginatorNode.transformSuccess(ctx, msg, msgs);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }
}
