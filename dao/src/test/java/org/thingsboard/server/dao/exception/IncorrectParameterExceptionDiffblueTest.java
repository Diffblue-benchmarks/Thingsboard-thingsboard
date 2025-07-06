package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IncorrectParameterExceptionDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IncorrectParameterException.<init>(String)",
    "void IncorrectParameterException.<init>(String, Throwable)"
  })
  public void testNewIncorrectParameterException_whenAnErrorOccurred_thenReturnCauseIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IncorrectParameterException.<init>(String)",
    "void IncorrectParameterException.<init>(String, Throwable)"
  })
  public void testNewIncorrectParameterException_whenThrowable_thenReturnCauseIsThrowable() {
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
