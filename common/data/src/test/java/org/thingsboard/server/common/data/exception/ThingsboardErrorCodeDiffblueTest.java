package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThingsboardErrorCodeDiffblueTest {
  /**
   * Test {@link ThingsboardErrorCode#getErrorCode()}.
   * <p>
   * Method under test: {@link ThingsboardErrorCode#getErrorCode()}
   */
  @Test
  @DisplayName("Test getErrorCode()")
  void testGetErrorCode() {
    // Arrange, Act and Assert
    assertEquals(2, ThingsboardErrorCode.valueOf("GENERAL").getErrorCode());
  }
}
