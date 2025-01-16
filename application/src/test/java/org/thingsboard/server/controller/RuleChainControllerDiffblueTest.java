package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RuleChainControllerDiffblueTest {
  /**
   * Test {@link RuleChainController#isTbelEnabled()}.
   * <p>
   * Method under test: {@link RuleChainController#isTbelEnabled()}
   */
  @Test
  @DisplayName("Test isTbelEnabled()")
  void testIsTbelEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new RuleChainController()).isTbelEnabled());
  }
}
