package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MailSenderInternalExecutorServiceDiffblueTest {
  /**
   * Test {@link MailSenderInternalExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test:
   * {@link MailSenderInternalExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new MailSenderInternalExecutorService()).getThreadPollSize());
  }
}
