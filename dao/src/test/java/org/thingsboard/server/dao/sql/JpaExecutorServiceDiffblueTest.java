package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JpaExecutorServiceDiffblueTest {
  /**
   * Test {@link JpaExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test: {@link JpaExecutorService#getThreadPollSize()}
   */
  @Test
  public void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new JpaExecutorService()).getThreadPollSize());
  }
}
