package org.thingsboard.server.service.update;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultUpdateServiceDiffblueTest {
  /**
   * Test {@link DefaultUpdateService#checkUpdates()}.
   * <p>
   * Method under test: {@link DefaultUpdateService#checkUpdates()}
   */
  @Test
  @DisplayName("Test checkUpdates()")
  void testCheckUpdates() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new DefaultUpdateService()).checkUpdates());
  }
}
