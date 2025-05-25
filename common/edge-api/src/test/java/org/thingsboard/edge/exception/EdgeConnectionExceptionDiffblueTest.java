package org.thingsboard.edge.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeConnectionExceptionDiffblueTest {
  /**
   * Test {@link EdgeConnectionException#EdgeConnectionException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConnectionException#EdgeConnectionException(String)}
   */
  @Test
  @DisplayName("Test new EdgeConnectionException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeConnectionException.<init>(String)",
      "void EdgeConnectionException.<init>(String, Throwable)"})
  void testNewEdgeConnectionException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    EdgeConnectionException actualEdgeConnectionException = new EdgeConnectionException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualEdgeConnectionException.getMessage());
    assertNull(actualEdgeConnectionException.getCause());
    assertEquals(0, actualEdgeConnectionException.getSuppressed().length);
  }

  /**
   * Test {@link EdgeConnectionException#EdgeConnectionException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConnectionException#EdgeConnectionException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new EdgeConnectionException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeConnectionException.<init>(String)",
      "void EdgeConnectionException.<init>(String, Throwable)"})
  void testNewEdgeConnectionException_whenThrowable_thenReturnCauseIsThrowable() {
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
