package org.thingsboard.server.dao.cache;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CacheExecutorServiceDiffblueTest {
  /**
   * Test {@link CacheExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link CacheExecutorService#getThreadPollSize()}
   */
  @Test
  public void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new CacheExecutorService()).getThreadPollSize());
  }
}
