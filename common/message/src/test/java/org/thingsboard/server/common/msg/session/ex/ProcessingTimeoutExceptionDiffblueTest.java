package org.thingsboard.server.common.msg.session.ex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProcessingTimeoutExceptionDiffblueTest {
  /**
   * Test new {@link ProcessingTimeoutException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ProcessingTimeoutException}
   */
  @Test
  @DisplayName("Test new ProcessingTimeoutException (default constructor)")
  void testNewProcessingTimeoutException() {
    // Arrange and Act
    ProcessingTimeoutException actualProcessingTimeoutException = new ProcessingTimeoutException();

    // Assert
    assertNull(actualProcessingTimeoutException.getMessage());
    assertNull(actualProcessingTimeoutException.getCause());
    assertEquals(0, actualProcessingTimeoutException.getSuppressed().length);
  }
}
