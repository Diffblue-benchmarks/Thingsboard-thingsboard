package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlreadySentExceptionDiffblueTest {
  /**
   * Test new {@link AlreadySentException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AlreadySentException}
   */
  @Test
  @DisplayName("Test new AlreadySentException (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlreadySentException.<init>()"})
  void testNewAlreadySentException() {
    // Arrange and Act
    AlreadySentException actualAlreadySentException = new AlreadySentException();

    // Assert
    assertNull(actualAlreadySentException.getMessage());
    assertNull(actualAlreadySentException.getCause());
    assertEquals(0, actualAlreadySentException.getSuppressed().length);
  }
}
