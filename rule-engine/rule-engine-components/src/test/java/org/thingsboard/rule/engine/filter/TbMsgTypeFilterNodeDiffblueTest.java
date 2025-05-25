package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgTypeFilterNodeDiffblueTest {
  /**
   * Test new {@link TbMsgTypeFilterNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbMsgTypeFilterNode}
   */
  @Test
  @DisplayName("Test new TbMsgTypeFilterNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbMsgTypeFilterNode.<init>()"})
  void testNewTbMsgTypeFilterNode() {
    // Arrange, Act and Assert
    assertNull((new TbMsgTypeFilterNode()).config);
  }
}
