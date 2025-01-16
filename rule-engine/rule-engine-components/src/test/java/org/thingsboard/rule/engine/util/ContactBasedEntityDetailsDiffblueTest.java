package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactBasedEntityDetailsDiffblueTest {
  /**
   * Test {@link ContactBasedEntityDetails#getRuleEngineName()}.
   * <p>
   * Method under test: {@link ContactBasedEntityDetails#getRuleEngineName()}
   */
  @Test
  @DisplayName("Test getRuleEngineName()")
  void testGetRuleEngineName() {
    // Arrange, Act and Assert
    assertEquals("id", ContactBasedEntityDetails.valueOf("ID").getRuleEngineName());
  }
}
