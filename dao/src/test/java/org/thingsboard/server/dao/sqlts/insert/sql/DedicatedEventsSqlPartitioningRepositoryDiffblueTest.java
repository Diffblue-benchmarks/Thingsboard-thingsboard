package org.thingsboard.server.dao.sqlts.insert.sql;

import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DedicatedEventsSqlPartitioningRepositoryDiffblueTest {
  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#getJdbcTemplate()}.
   * <p>
   * Method under test:
   * {@link DedicatedEventsSqlPartitioningRepository#getJdbcTemplate()}
   */
  @Test
  public void testGetJdbcTemplate() {
    // Arrange, Act and Assert
    assertNull((new DedicatedEventsSqlPartitioningRepository()).getJdbcTemplate());
  }
}
