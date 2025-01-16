package org.thingsboard.server.dao.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class DatabaseExceptionDiffblueTest {
  /**
   * Test {@link DatabaseException#DatabaseException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseException#DatabaseException()}
   */
  @Test
  public void testNewDatabaseException_thenReturnMessageIsNull() {
    // Arrange and Act
    DatabaseException actualDatabaseException = new DatabaseException();

    // Assert
    assertNull(actualDatabaseException.getMessage());
    assertNull(actualDatabaseException.getCause());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
  }

  /**
   * Test {@link DatabaseException#DatabaseException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseException#DatabaseException(String)}
   */
  @Test
  public void testNewDatabaseException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    DatabaseException actualDatabaseException = new DatabaseException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDatabaseException.getMessage());
    assertNull(actualDatabaseException.getCause());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
  }

  /**
   * Test {@link DatabaseException#DatabaseException(String, Throwable)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseException#DatabaseException(String, Throwable)}
   */
  @Test
  public void testNewDatabaseException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DatabaseException actualDatabaseException = new DatabaseException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDatabaseException.getMessage());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
    assertSame(cause, actualDatabaseException.getCause());
  }

  /**
   * Test {@link DatabaseException#DatabaseException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseException#DatabaseException(Throwable)}
   */
  @Test
  public void testNewDatabaseException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DatabaseException actualDatabaseException = new DatabaseException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDatabaseException.getMessage());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
    assertSame(cause, actualDatabaseException.getCause());
  }
}
