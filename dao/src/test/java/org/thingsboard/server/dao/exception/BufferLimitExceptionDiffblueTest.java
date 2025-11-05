package org.thingsboard.server.dao.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BufferLimitExceptionDiffblueTest {
  /**
   * Test new {@link BufferLimitException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BufferLimitException}
   */
  @Test
  @DisplayName("Test new BufferLimitException (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferLimitException.<init>()"})
  void testNewBufferLimitException() {
    // Arrange and Act
    BufferLimitException actualBufferLimitException = new BufferLimitException();

    // Assert
    assertEquals("Rate Limit Buffer is full", actualBufferLimitException.getMessage());
    assertNull(actualBufferLimitException.getCause());
    assertEquals(0, actualBufferLimitException.getSuppressed().length);
  }
}
