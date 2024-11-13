package org.thingsboard.server.dao.cassandra;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractCassandraClusterDiffblueTest {
  /**
   * Test {@link AbstractCassandraCluster#getKeyspaceName()}.
   * <p>
   * Method under test: {@link AbstractCassandraCluster#getKeyspaceName()}
   */
  @Test
  @DisplayName("Test getKeyspaceName()")
  void testGetKeyspaceName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CassandraCluster()).getKeyspaceName());
  }
}
