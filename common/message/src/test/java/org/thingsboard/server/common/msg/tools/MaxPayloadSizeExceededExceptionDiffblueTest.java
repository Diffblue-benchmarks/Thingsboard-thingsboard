package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxPayloadSizeExceededExceptionDiffblueTest {
  /**
   * Test
   * {@link MaxPayloadSizeExceededException#MaxPayloadSizeExceededException(long)}.
   * <p>
   * Method under test:
   * {@link MaxPayloadSizeExceededException#MaxPayloadSizeExceededException(long)}
   */
  @Test
  @DisplayName("Test new MaxPayloadSizeExceededException(long)")
  void testNewMaxPayloadSizeExceededException() {
    // Arrange and Act
    MaxPayloadSizeExceededException actualMaxPayloadSizeExceededException = new MaxPayloadSizeExceededException(1L);

    // Assert
    assertEquals("Payload size exceeds the limit of 1 bytes",
        actualMaxPayloadSizeExceededException.getLocalizedMessage());
    assertEquals("Payload size exceeds the limit of 1 bytes", actualMaxPayloadSizeExceededException.getMessage());
    assertNull(actualMaxPayloadSizeExceededException.getCause());
    assertEquals(0, actualMaxPayloadSizeExceededException.getSuppressed().length);
    assertEquals(1L, actualMaxPayloadSizeExceededException.getLimit());
  }

  /**
   * Test {@link MaxPayloadSizeExceededException#getLimit()}.
   * <p>
   * Method under test: {@link MaxPayloadSizeExceededException#getLimit()}
   */
  @Test
  @DisplayName("Test getLimit()")
  void testGetLimit() {
    // Arrange, Act and Assert
    assertEquals(1L, (new MaxPayloadSizeExceededException(1L)).getLimit());
  }
}
