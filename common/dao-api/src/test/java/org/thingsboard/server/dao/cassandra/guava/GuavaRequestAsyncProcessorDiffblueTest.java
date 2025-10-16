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
package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.datastax.oss.driver.api.core.session.Request;
import com.datastax.oss.driver.internal.core.session.RequestProcessor;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GuavaRequestAsyncProcessorDiffblueTest {
  /**
   * Test {@link GuavaRequestAsyncProcessor#newFailure(RuntimeException)}.
   *
   * <ul>
   *   <li>When {@link RuntimeException#RuntimeException()}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link GuavaRequestAsyncProcessor#newFailure(RuntimeException)}
   */
  @Test
  @DisplayName("Test newFailure(RuntimeException); when RuntimeException(); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture GuavaRequestAsyncProcessor.newFailure(RuntimeException)"
  })
  void testNewFailure_whenRuntimeException_thenReturnDone() {
    // Arrange
    RequestProcessor<Request, CompletionStage<Object>> subProcessor = mock(RequestProcessor.class);
    Class<Object> requestClass = Object.class;

    GuavaRequestAsyncProcessor<Request, Object> guavaRequestAsyncProcessor =
        new GuavaRequestAsyncProcessor<>(subProcessor, requestClass, GuavaSession.ASYNC);

    // Act and Assert
    assertTrue(guavaRequestAsyncProcessor.newFailure(new RuntimeException()).isDone());
  }
}
