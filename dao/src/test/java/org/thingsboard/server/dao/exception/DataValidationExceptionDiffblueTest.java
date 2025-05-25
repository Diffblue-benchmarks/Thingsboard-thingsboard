package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataValidationExceptionDiffblueTest {
  /**
   * Test {@link DataValidationException#DataValidationException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidationException#DataValidationException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataValidationException.<init>(String)",
      "void DataValidationException.<init>(String, Throwable)"})
  public void testNewDataValidationException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    DataValidationException actualDataValidationException = new DataValidationException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDataValidationException.getMessage());
    assertNull(actualDataValidationException.getCause());
    assertEquals(0, actualDataValidationException.getSuppressed().length);
  }

  /**
   * Test {@link DataValidationException#DataValidationException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataValidationException#DataValidationException(String, Throwable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DataValidationException.<init>(String)",
      "void DataValidationException.<init>(String, Throwable)"})
  public void testNewDataValidationException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DataValidationException actualDataValidationException = new DataValidationException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDataValidationException.getMessage());
    assertEquals(0, actualDataValidationException.getSuppressed().length);
    assertSame(cause, actualDataValidationException.getCause());
  }
}
