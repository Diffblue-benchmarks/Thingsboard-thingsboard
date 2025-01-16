package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbRestApiCallNodeDiffblueTest {
  /**
   * Test new {@link TbRestApiCallNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbRestApiCallNode}
   */
  @Test
  @DisplayName("Test new TbRestApiCallNode (default constructor)")
  void testNewTbRestApiCallNode() {
    // Arrange, Act and Assert
    assertNull((new TbRestApiCallNode()).httpClient);
  }
}
