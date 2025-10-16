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
package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.script.api.js.JsScriptExecutionTask;

class TbScriptExecutionTaskDiffblueTest {
  /**
   * Test {@link TbScriptExecutionTask#getResultFuture()}.
   *
   * <p>Method under test: {@link TbScriptExecutionTask#getResultFuture()}
   */
  @Test
  @DisplayName("Test getResultFuture()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbScriptExecutionTask.getResultFuture()"})
  void testGetResultFuture() {
    // Arrange
    SettableFuture<Object> resultFuture = SettableFuture.create();

    // Act
    ListenableFuture<Object> actualResultFuture =
        new JsScriptExecutionTask(resultFuture).getResultFuture();

    // Assert
    assertTrue(actualResultFuture instanceof SettableFuture);
    assertSame(resultFuture, actualResultFuture);
  }
}
