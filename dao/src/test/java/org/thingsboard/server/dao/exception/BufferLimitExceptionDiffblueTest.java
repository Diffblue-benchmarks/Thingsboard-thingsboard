package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BufferLimitExceptionDiffblueTest {
  /**
   * Test new {@link BufferLimitException} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link BufferLimitException}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BufferLimitException.<init>()"})
  public void testNewBufferLimitException() {
    // Arrange and Act
    BufferLimitException actualBufferLimitException = new BufferLimitException();

    // Assert
    assertEquals("Rate Limit Buffer is full", actualBufferLimitException.getMessage());
    assertNull(actualBufferLimitException.getCause());
    assertEquals(0, actualBufferLimitException.getSuppressed().length);
  }
}
