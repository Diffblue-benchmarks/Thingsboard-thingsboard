package org.thingsboard.server.dao.sql.relation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JpaRelationQueryExecutorServiceDiffblueTest {
  /**
   * Test {@link JpaRelationQueryExecutorService#getThreadPollSize()}.
   * <p>
   * Method under test:
   * {@link JpaRelationQueryExecutorService#getThreadPollSize()}
   */
  @Test
  public void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(0, (new JpaRelationQueryExecutorService()).getThreadPollSize());
  }
}
