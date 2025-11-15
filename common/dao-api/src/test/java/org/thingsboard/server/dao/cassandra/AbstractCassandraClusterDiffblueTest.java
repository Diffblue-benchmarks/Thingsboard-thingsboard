package org.thingsboard.server.dao.cassandra;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractCassandraClusterDiffblueTest {
  /**
   * Test {@link AbstractCassandraCluster#getKeyspaceName()}.
   * <p>
   * Method under test: {@link AbstractCassandraCluster#getKeyspaceName()}
   */
  @Test
  @DisplayName("Test getKeyspaceName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AbstractCassandraCluster.getKeyspaceName()"})
  void testGetKeyspaceName() {
    // Arrange, Act and Assert
    assertNull((new CassandraCluster()).getKeyspaceName());
  }
}
