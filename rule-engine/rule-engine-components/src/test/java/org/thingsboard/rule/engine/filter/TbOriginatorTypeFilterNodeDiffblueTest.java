package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbOriginatorTypeFilterNodeDiffblueTest {
  /**
   * Test new {@link TbOriginatorTypeFilterNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbOriginatorTypeFilterNode}
   */
  @Test
  @DisplayName("Test new TbOriginatorTypeFilterNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbOriginatorTypeFilterNode.<init>()"})
  void testNewTbOriginatorTypeFilterNode() {
    // Arrange, Act and Assert
    assertNull((new TbOriginatorTypeFilterNode()).config);
  }
}
