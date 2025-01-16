package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SqlTsDatabaseUpgradeServiceDiffblueTest {
  /**
   * Test {@link SqlTsDatabaseUpgradeService#upgradeDatabase(String)}.
   * <p>
   * Method under test:
   * {@link SqlTsDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String)")
  void testUpgradeDatabase() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new SqlTsDatabaseUpgradeService()).upgradeDatabase("jane.doe@example.org"));
  }
}
