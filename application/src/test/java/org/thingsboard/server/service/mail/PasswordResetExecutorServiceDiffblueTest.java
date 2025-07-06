package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PasswordResetExecutorServiceDiffblueTest {
  /**
   * Test {@link PasswordResetExecutorService#getThreadPollSize()}.
   *
   * <p>Method under test: {@link PasswordResetExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PasswordResetExecutorService.getThreadPollSize()"})
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, new PasswordResetExecutorService().getThreadPollSize());
  }
}
