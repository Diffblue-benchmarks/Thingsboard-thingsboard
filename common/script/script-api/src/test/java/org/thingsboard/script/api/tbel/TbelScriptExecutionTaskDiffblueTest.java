/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mvel2.ExecutionContext;
import org.mvel2.ParserContext;

class TbelScriptExecutionTaskDiffblueTest {
  /**
   * Test {@link TbelScriptExecutionTask#TbelScriptExecutionTask(ExecutionContext,
   * ListenableFuture)}.
   *
   * <p>Method under test: {@link TbelScriptExecutionTask#TbelScriptExecutionTask(ExecutionContext,
   * ListenableFuture)}
   */
  @Test
  @DisplayName("Test new TbelScriptExecutionTask(ExecutionContext, ListenableFuture)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbelScriptExecutionTask.<init>(ExecutionContext, ListenableFuture)"})
  void testNewTbelScriptExecutionTask() {
    // Arrange
    ExecutionContext context = new ExecutionContext(ParserContext.enableSandboxedMode());
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act and Assert
    ListenableFuture<Object> resultFuture2 =
        new TbelScriptExecutionTask(context, resultFuture).getResultFuture();
    assertTrue(resultFuture2 instanceof SettableFuture);
    assertSame(resultFuture, resultFuture2);
  }

  /**
   * Test {@link TbelScriptExecutionTask#stop()}.
   *
   * <ul>
   *   <li>Given {@link ExecutionContext} {@link ExecutionContext#stop()} does nothing.
   *   <li>Then calls {@link ExecutionContext#stop()}.
   * </ul>
   *
   * <p>Method under test: {@link TbelScriptExecutionTask#stop()}
   */
  @Test
  @DisplayName("Test stop(); given ExecutionContext stop() does nothing; then calls stop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbelScriptExecutionTask.stop()"})
  void testStop_givenExecutionContextStopDoesNothing_thenCallsStop() {
    // Arrange
    ExecutionContext context = mock(ExecutionContext.class);
    doNothing().when(context).stop();
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act
    new TbelScriptExecutionTask(context, resultFuture).stop();

    // Assert
    verify(context).stop();
  }
}
