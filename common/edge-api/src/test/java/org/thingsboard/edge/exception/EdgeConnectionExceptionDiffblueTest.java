package org.thingsboard.edge.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class EdgeConnectionExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link EdgeConnectionException#EdgeConnectionException(String)}
   */
  @Test
  void testNewEdgeConnectionException() {
    // Arrange and Act
    EdgeConnectionException actualEdgeConnectionException = new EdgeConnectionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualEdgeConnectionException.getMessage());
    assertNull(actualEdgeConnectionException.getCause());
    assertEquals(0, actualEdgeConnectionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link EdgeConnectionException#EdgeConnectionException(String, Throwable)}
   */
  @Test
  void testNewEdgeConnectionException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    EdgeConnectionException actualEdgeConnectionException = new EdgeConnectionException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualEdgeConnectionException.getMessage());
    assertEquals(0, actualEdgeConnectionException.getSuppressed().length);
    assertSame(cause, actualEdgeConnectionException.getCause());
  }
}
