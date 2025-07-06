package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgTypeSwitchNodeDiffblueTest {
  /**
   * Test new {@link TbMsgTypeSwitchNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMsgTypeSwitchNode}
   */
  @Test
  @DisplayName("Test new TbMsgTypeSwitchNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgTypeSwitchNode.<init>()"})
  void testNewTbMsgTypeSwitchNode() {
    // Arrange, Act and Assert
    assertNull(new TbMsgTypeSwitchNode().config);
  }
}
