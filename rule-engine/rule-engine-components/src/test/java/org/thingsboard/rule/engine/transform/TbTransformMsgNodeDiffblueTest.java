package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbTransformMsgNodeDiffblueTest {
  /**
   * Test new {@link TbTransformMsgNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbTransformMsgNode}
   */
  @Test
  @DisplayName("Test new TbTransformMsgNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbTransformMsgNode.<init>()"})
  void testNewTbTransformMsgNode() {
    // Arrange, Act and Assert
    assertNull((new TbTransformMsgNode()).config);
  }
}
