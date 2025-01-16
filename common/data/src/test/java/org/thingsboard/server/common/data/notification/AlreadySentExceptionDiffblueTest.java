package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlreadySentExceptionDiffblueTest {
  /**
   * Test new {@link AlreadySentException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AlreadySentException}
   */
  @Test
  @DisplayName("Test new AlreadySentException (default constructor)")
  void testNewAlreadySentException() {
    // Arrange and Act
    AlreadySentException actualAlreadySentException = new AlreadySentException();

    // Assert
    assertNull(actualAlreadySentException.getMessage());
    assertNull(actualAlreadySentException.getCause());
    assertEquals(0, actualAlreadySentException.getSuppressed().length);
  }
}
