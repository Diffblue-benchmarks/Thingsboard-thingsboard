package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TimescaleTsDatabaseUpgradeServiceDiffblueTest {
  /**
   * Test {@link TimescaleTsDatabaseUpgradeService#upgradeDatabase(String)}.
   * <p>
   * Method under test:
   * {@link TimescaleTsDatabaseUpgradeService#upgradeDatabase(String)}
   */
  @Test
  @DisplayName("Test upgradeDatabase(String)")
  void testUpgradeDatabase() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TimescaleTsDatabaseUpgradeService()).upgradeDatabase("jane.doe@example.org"));
  }
}
