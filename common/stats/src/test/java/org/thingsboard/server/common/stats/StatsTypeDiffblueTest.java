package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatsTypeDiffblueTest {
  /**
   * Test {@link StatsType#getName()}.
   * <p>
   * Method under test: {@link StatsType#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ruleEngine", StatsType.valueOf("RULE_ENGINE").getName());
  }
}
