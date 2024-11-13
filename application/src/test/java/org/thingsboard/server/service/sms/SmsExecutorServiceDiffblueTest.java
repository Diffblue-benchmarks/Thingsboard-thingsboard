package org.thingsboard.server.service.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SmsExecutorServiceDiffblueTest {
  /**
   * Test {@link SmsExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link SmsExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new SmsExecutorService()).getThreadPollSize());
  }
}
