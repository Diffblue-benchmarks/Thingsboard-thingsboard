package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatsTypeDiffblueTest {
  /**
   * Test {@link StatsType#getName()}.
   *
   * <p>Method under test: {@link StatsType#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String StatsType.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("ruleEngine", StatsType.valueOf("RULE_ENGINE").getName());
  }
}
