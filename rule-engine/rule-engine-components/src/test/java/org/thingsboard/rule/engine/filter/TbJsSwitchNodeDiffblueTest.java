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
import java.util.Set;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbJsSwitchNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbJsSwitchNode tbJsSwitchNode;

  /**
   * Test {@link TbJsSwitchNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsSwitchNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsSwitchNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Set<String>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Set<String>> delegate2 =
        new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Set<String>> apiFuture = new ForwardingApiFuture<>(delegate2);
    when(scriptEngine.executeSwitchAsync(Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).logJsEvalRequest();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbJsSwitchNode.onMsg(ctx, msg);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(scriptEngine).executeSwitchAsync(isA(TbMsg.class));
    verify(ctx).logJsEvalRequest();
  }

  /**
   * Test {@link TbJsSwitchNode#destroy()}.
   *
   * <p>Method under test: {@link TbJsSwitchNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsSwitchNode.destroy()"})
  void testDestroy() {
    // Arrange
    doNothing().when(scriptEngine).destroy();

    // Act
    tbJsSwitchNode.destroy();

    // Assert
    verify(scriptEngine).destroy();
  }
}
