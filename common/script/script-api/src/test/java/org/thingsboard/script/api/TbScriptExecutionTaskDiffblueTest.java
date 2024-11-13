package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.script.api.js.JsScriptExecutionTask;

class TbScriptExecutionTaskDiffblueTest {
  /**
   * Test {@link TbScriptExecutionTask#getResultFuture()}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbScriptExecutionTask#getResultFuture()}
   */
  @Test
  @DisplayName("Test getResultFuture(); then return SettableFuture")
  void testGetResultFuture_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act
    ListenableFuture<Object> actualResultFuture = (new JsScriptExecutionTask(resultFuture)).getResultFuture();

    // Assert
    assertTrue(actualResultFuture instanceof SettableFuture);
    assertSame(resultFuture, actualResultFuture);
  }
}
