package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mvel2.ExecutionContext;
import org.mvel2.ParserContext;

class TbelScriptExecutionTaskDiffblueTest {
  /**
   * Test
   * {@link TbelScriptExecutionTask#TbelScriptExecutionTask(ExecutionContext, ListenableFuture)}.
   * <p>
   * Method under test:
   * {@link TbelScriptExecutionTask#TbelScriptExecutionTask(ExecutionContext, ListenableFuture)}
   */
  @Test
  @DisplayName("Test new TbelScriptExecutionTask(ExecutionContext, ListenableFuture)")
  void testNewTbelScriptExecutionTask() {
    // Arrange
    ExecutionContext context = new ExecutionContext(ParserContext.enableSandboxedMode());
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act and Assert
    ListenableFuture<Object> resultFuture2 = (new TbelScriptExecutionTask(context, resultFuture)).getResultFuture();
    assertTrue(resultFuture2 instanceof SettableFuture);
    assertSame(resultFuture, resultFuture2);
  }

  /**
   * Test {@link TbelScriptExecutionTask#stop()}.
   * <ul>
   *   <li>Given {@link ExecutionContext} {@link ExecutionContext#stop()} does
   * nothing.</li>
   *   <li>Then calls {@link ExecutionContext#stop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbelScriptExecutionTask#stop()}
   */
  @Test
  @DisplayName("Test stop(); given ExecutionContext stop() does nothing; then calls stop()")
  void testStop_givenExecutionContextStopDoesNothing_thenCallsStop() {
    // Arrange
    ExecutionContext context = mock(ExecutionContext.class);
    doNothing().when(context).stop();
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act
    (new TbelScriptExecutionTask(context, resultFuture)).stop();

    // Assert that nothing has changed
    verify(context).stop();
  }
}
