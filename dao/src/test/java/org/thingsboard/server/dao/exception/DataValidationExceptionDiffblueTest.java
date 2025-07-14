package org.thingsboard.server.dao.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataValidationExceptionDiffblueTest {
  /**
   * Test {@link DataValidationException#DataValidationException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidationException#DataValidationException(String)}
   */
  @Test
  @DisplayName(
      "Test new DataValidationException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DataValidationException.<init>(String)",
    "void DataValidationException.<init>(String, Throwable)"
  })
  void testNewDataValidationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    DataValidationException actualDataValidationException =
        new DataValidationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDataValidationException.getMessage());
    assertNull(actualDataValidationException.getCause());
    assertEquals(0, actualDataValidationException.getSuppressed().length);
  }

  /**
   * Test {@link DataValidationException#DataValidationException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link DataValidationException#DataValidationException(String,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test new DataValidationException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DataValidationException.<init>(String)",
    "void DataValidationException.<init>(String, Throwable)"
  })
  void testNewDataValidationException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DataValidationException actualDataValidationException =
        new DataValidationException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDataValidationException.getMessage());
    assertEquals(0, actualDataValidationException.getSuppressed().length);
    assertSame(cause, actualDataValidationException.getCause());
  }
}
