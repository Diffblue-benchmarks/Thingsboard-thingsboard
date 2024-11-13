package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MailExecutorServiceDiffblueTest {
  /**
   * Test {@link MailExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link MailExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new MailExecutorService()).getThreadPollSize());
  }
}
