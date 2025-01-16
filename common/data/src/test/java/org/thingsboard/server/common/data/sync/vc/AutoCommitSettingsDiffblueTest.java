package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutoCommitSettingsDiffblueTest {
  /**
   * Test new {@link AutoCommitSettings} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AutoCommitSettings}
   */
  @Test
  @DisplayName("Test new AutoCommitSettings (default constructor)")
  void testNewAutoCommitSettings() {
    // Arrange, Act and Assert
    assertTrue((new AutoCommitSettings()).isEmpty());
  }
}
