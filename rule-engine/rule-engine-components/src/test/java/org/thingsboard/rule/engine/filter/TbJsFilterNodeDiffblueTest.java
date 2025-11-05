package org.thingsboard.rule.engine.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbJsFilterNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbJsFilterNode tbJsFilterNode;

  /**
   * Test {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Boolean> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Boolean> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Boolean> apiFuture = new ForwardingApiFuture<>(delegate2);
    when(scriptEngine.executeFilterAsync(Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).logJsEvalRequest();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbJsFilterNode.onMsg(ctx, msg);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(scriptEngine).executeFilterAsync(isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).logJsEvalRequest();
  }

  /**
   * Test {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener2() {
    // Arrange
    ListenableFutureTask<Boolean> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Boolean> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Boolean> apiFuture = new ForwardingApiFuture<>(delegate2);
    when(scriptEngine.executeFilterAsync(Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    doNothing().when(ctx).logJsEvalRequest();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbJsFilterNode.onMsg(ctx, msg);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(scriptEngine).executeFilterAsync(isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).logJsEvalRequest();
  }

  /**
   * Test {@link TbJsFilterNode#destroy()}.
   *
   * <p>Method under test: {@link TbJsFilterNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.destroy()"})
  void testDestroy() {
    // Arrange
    doNothing().when(scriptEngine).destroy();

    // Act
    tbJsFilterNode.destroy();

    // Assert
    verify(scriptEngine).destroy();
  }
}
