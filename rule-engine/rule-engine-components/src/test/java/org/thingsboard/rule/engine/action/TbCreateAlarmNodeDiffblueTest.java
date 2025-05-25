package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCreateAlarmNodeDiffblueTest {
  /**
   * Test new {@link TbCreateAlarmNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbCreateAlarmNode}
   */
  @Test
  @DisplayName("Test new TbCreateAlarmNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCreateAlarmNode.<init>()"})
  void testNewTbCreateAlarmNode() {
    // Arrange, Act and Assert
    assertNull((new TbCreateAlarmNode()).config);
  }
}
