package org.thingsboard.server.dao.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class IncorrectParameterExceptionDiffblueTest {
  /**
   * Test {@link IncorrectParameterException#IncorrectParameterException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link IncorrectParameterException#IncorrectParameterException(String)}
   */
  @Test
  @DisplayName(
      "Test new IncorrectParameterException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IncorrectParameterException.<init>(String)",
    "void IncorrectParameterException.<init>(String, Throwable)"
  })
  void testNewIncorrectParameterException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    IncorrectParameterException actualIncorrectParameterException =
        new IncorrectParameterException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualIncorrectParameterException.getMessage());
    assertNull(actualIncorrectParameterException.getCause());
    assertEquals(0, actualIncorrectParameterException.getSuppressed().length);
  }

  /**
   * Test {@link IncorrectParameterException#IncorrectParameterException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link IncorrectParameterException#IncorrectParameterException(String,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test new IncorrectParameterException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IncorrectParameterException.<init>(String)",
    "void IncorrectParameterException.<init>(String, Throwable)"
  })
  void testNewIncorrectParameterException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    IncorrectParameterException actualIncorrectParameterException =
        new IncorrectParameterException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualIncorrectParameterException.getMessage());
    assertEquals(0, actualIncorrectParameterException.getSuppressed().length);
    assertSame(cause, actualIncorrectParameterException.getCause());
  }
}
