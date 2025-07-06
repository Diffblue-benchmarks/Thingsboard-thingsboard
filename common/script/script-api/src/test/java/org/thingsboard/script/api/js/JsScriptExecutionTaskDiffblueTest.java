package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsScriptExecutionTaskDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsScriptExecutionTask#JsScriptExecutionTask(ListenableFuture)}
   *   <li>{@link JsScriptExecutionTask#stop()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void JsScriptExecutionTask.<init>(ListenableFuture)",
    "void JsScriptExecutionTask.stop()"
  })
  void testGettersAndSetters() {
    // Arrange
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act
    JsScriptExecutionTask actualJsScriptExecutionTask = new JsScriptExecutionTask(resultFuture);
    actualJsScriptExecutionTask.stop();

    // Assert
    ListenableFuture<Object> resultFuture2 = actualJsScriptExecutionTask.getResultFuture();
    assertTrue(resultFuture2 instanceof SettableFuture);
    assertSame(resultFuture, resultFuture2);
  }
}
