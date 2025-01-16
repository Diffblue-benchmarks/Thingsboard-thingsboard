package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserSettingsTypeDiffblueTest {
  /**
   * Test {@link UserSettingsType#isReserved()}.
   * <p>
   * Method under test: {@link UserSettingsType#isReserved()}
   */
  @Test
  @DisplayName("Test isReserved()")
  void testIsReserved() {
    // Arrange, Act and Assert
    assertFalse(UserSettingsType.valueOf("GENERAL").isReserved());
  }
}
