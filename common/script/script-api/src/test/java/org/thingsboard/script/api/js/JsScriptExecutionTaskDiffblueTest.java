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
package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
