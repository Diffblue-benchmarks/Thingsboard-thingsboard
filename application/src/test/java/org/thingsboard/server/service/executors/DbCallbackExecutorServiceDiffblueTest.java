package org.thingsboard.server.service.executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DbCallbackExecutorServiceDiffblueTest {
  /**
   * Test {@link DbCallbackExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link DbCallbackExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new DbCallbackExecutorService()).getThreadPollSize());
  }
}
