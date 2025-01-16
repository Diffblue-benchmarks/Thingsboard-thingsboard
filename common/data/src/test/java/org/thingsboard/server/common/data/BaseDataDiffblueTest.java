package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseDataDiffblueTest {
  /**
   * Test {@link BaseData#getCreatedTime()}.
   * <p>
   * Method under test: {@link BaseData#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new ApiUsageState()).getCreatedTime());
  }

  /**
   * Test {@link BaseData#setCreatedTime(long)}.
   * <p>
   * Method under test: {@link BaseData#setCreatedTime(long)}
   */
  @Test
  @DisplayName("Test setCreatedTime(long)")
  void testSetCreatedTime() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();

    // Act
    adminSettings.setCreatedTime(1L);

    // Assert
    assertEquals(1L, adminSettings.getCreatedTime());
  }
}
