package org.thingsboard.server.service.executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationExecutorServiceDiffblueTest {
  /**
   * Test {@link NotificationExecutorService#getThreadPollSize()}.
   *
   * <p>Method under test: {@link NotificationExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int NotificationExecutorService.getThreadPollSize()"})
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, new NotificationExecutorService().getThreadPollSize());
  }
}
