package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbCopyAttributesToEntityViewNodeDiffblueTest {
  /**
   * Test new {@link TbCopyAttributesToEntityViewNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbCopyAttributesToEntityViewNode}
   */
  @Test
  @DisplayName("Test new TbCopyAttributesToEntityViewNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.<init>()"})
  void testNewTbCopyAttributesToEntityViewNode() {
    // Arrange, Act and Assert
    assertNull((new TbCopyAttributesToEntityViewNode()).config);
  }
}
