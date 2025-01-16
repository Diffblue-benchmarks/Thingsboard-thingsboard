package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.datastax.oss.driver.api.core.session.Request;
import com.datastax.oss.driver.internal.core.session.RequestProcessor;
import java.util.concurrent.CompletionStage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuavaRequestAsyncProcessorDiffblueTest {
  /**
   * Test {@link GuavaRequestAsyncProcessor#newFailure(RuntimeException)}.
   * <ul>
   *   <li>When {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GuavaRequestAsyncProcessor#newFailure(RuntimeException)}
   */
  @Test
  @DisplayName("Test newFailure(RuntimeException); when RuntimeException(String) with 'foo'; then return Done")
  void testNewFailure_whenRuntimeExceptionWithFoo_thenReturnDone() {
    // Arrange
    RequestProcessor<Request, CompletionStage<Object>> subProcessor = mock(RequestProcessor.class);
    Class<Object> requestClass = Object.class;
    GuavaRequestAsyncProcessor<Request, Object> guavaRequestAsyncProcessor = new GuavaRequestAsyncProcessor<>(
        subProcessor, requestClass, GuavaSession.ASYNC);

    // Act and Assert
    assertTrue(guavaRequestAsyncProcessor.newFailure(new RuntimeException("foo")).isDone());
  }
}
