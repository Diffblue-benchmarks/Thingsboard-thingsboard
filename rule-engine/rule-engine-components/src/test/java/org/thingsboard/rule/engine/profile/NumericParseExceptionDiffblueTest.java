package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumericParseExceptionDiffblueTest {
  /**
   * Test {@link NumericParseException#NumericParseException(String)}.
   * <p>
   * Method under test:
   * {@link NumericParseException#NumericParseException(String)}
   */
  @Test
  @DisplayName("Test new NumericParseException(String)")
  void testNewNumericParseException() {
    // Arrange and Act
    NumericParseException actualNumericParseException = new NumericParseException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualNumericParseException.getMessage());
    assertNull(actualNumericParseException.getCause());
    assertEquals(0, actualNumericParseException.getSuppressed().length);
  }
}
