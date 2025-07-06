package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbAckNodeDiffblueTest {
  /**
   * Test new {@link TbAckNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbAckNode}
   */
  @Test
  @DisplayName("Test new TbAckNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAckNode.<init>()"})
  void testNewTbAckNode() {
    // Arrange, Act and Assert
    assertNull(new TbAckNode().config);
  }
}
