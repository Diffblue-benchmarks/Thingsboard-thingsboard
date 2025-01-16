package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbRuleNodeMathFunctionTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbRuleNodeMathFunctionType#getMaxArgs()}
   *   <li>{@link TbRuleNodeMathFunctionType#getMinArgs()}
   *   <li>{@link TbRuleNodeMathFunctionType#isIntegerResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TbRuleNodeMathFunctionType valueOfResult = TbRuleNodeMathFunctionType.valueOf("ADD");

    // Act
    int actualMaxArgs = valueOfResult.getMaxArgs();
    int actualMinArgs = valueOfResult.getMinArgs();

    // Assert
    assertEquals(2, actualMaxArgs);
    assertEquals(2, actualMinArgs);
    assertFalse(valueOfResult.isIntegerResult());
  }
}
