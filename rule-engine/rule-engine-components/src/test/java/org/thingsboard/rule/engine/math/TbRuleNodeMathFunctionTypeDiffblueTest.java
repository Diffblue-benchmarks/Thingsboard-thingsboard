package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbRuleNodeMathFunctionTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbRuleNodeMathFunctionType#getMaxArgs()}
   *   <li>{@link TbRuleNodeMathFunctionType#getMinArgs()}
   *   <li>{@link TbRuleNodeMathFunctionType#isIntegerResult()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int TbRuleNodeMathFunctionType.getMaxArgs()",
    "int TbRuleNodeMathFunctionType.getMinArgs()",
    "boolean TbRuleNodeMathFunctionType.isIntegerResult()"
  })
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
