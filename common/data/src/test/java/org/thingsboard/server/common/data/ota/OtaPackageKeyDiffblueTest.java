package org.thingsboard.server.common.data.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OtaPackageKeyDiffblueTest {
  /**
   * Test {@link OtaPackageKey#getValue()}.
   * <p>
   * Method under test: {@link OtaPackageKey#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("title", OtaPackageKey.valueOf("TITLE").getValue());
  }
}
