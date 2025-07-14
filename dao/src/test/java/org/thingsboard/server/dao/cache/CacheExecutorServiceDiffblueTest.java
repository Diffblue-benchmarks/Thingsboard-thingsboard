package org.thingsboard.server.dao.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CacheExecutorServiceDiffblueTest {
  /**
   * Test {@link CacheExecutorService#getThreadPollSize()}.
   *
   * <p>Method under test: {@link CacheExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CacheExecutorService.getThreadPollSize()"})
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, new CacheExecutorService().getThreadPollSize());
  }
}
