package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class BufferLimitExceptionDiffblueTest {
  /**
   * Test new {@link BufferLimitException} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BufferLimitException}
   */
  @Test
  public void testNewBufferLimitException() {
    // Arrange and Act
    BufferLimitException actualBufferLimitException = new BufferLimitException();

    // Assert
    assertEquals("Rate Limit Buffer is full", actualBufferLimitException.getMessage());
    assertNull(actualBufferLimitException.getCause());
    assertEquals(0, actualBufferLimitException.getSuppressed().length);
  }
}
