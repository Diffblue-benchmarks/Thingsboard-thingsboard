package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRestApiCallNodeDiffblueTest {
  /**
   * Test new {@link TbRestApiCallNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link TbRestApiCallNode}
   */
  @Test
  @DisplayName("Test new TbRestApiCallNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbRestApiCallNode.<init>()"})
  void testNewTbRestApiCallNode() {
    // Arrange, Act and Assert
    assertNull((new TbRestApiCallNode()).httpClient);
  }
}
