package org.thingsboard.rule.engine.aws.sqs;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.msg.TbMsg;

class TbSqsNodeDiffblueTest {
  /**
   * Test {@link TbSqsNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then calls {@link TestDbCallbackExecutor#executeAsync(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls executeAsync(Callable)")
  void testOnMsg_thenCallsExecuteAsync() {
    // Arrange
    TbSqsNode tbSqsNode = new TbSqsNode();
    TestDbCallbackExecutor testDbCallbackExecutor = mock(TestDbCallbackExecutor.class);
    SettableFuture<Object> delegate = SettableFuture.create();
    when(testDbCallbackExecutor.executeAsync(Mockito.<Callable<Object>>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenReturn(testDbCallbackExecutor);

    // Act
    tbSqsNode.onMsg(ctx, null);

    // Assert
    verify(testDbCallbackExecutor).executeAsync(isA(Callable.class));
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbSqsNode#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls isExternalNodeForceAck()")
  void testDestroy_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSqsNode tbSqsNode = new TbSqsNode();
    tbSqsNode.init(ctx);

    // Act
    tbSqsNode.destroy();

    // Assert that nothing has changed
    verify(ctx).isExternalNodeForceAck();
  }
}
