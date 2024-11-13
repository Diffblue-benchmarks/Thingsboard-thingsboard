package org.thingsboard.server.service.executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GrpcCallbackExecutorServiceDiffblueTest {
  /**
   * Test {@link GrpcCallbackExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link GrpcCallbackExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new GrpcCallbackExecutorService()).getThreadPollSize());
  }
}
