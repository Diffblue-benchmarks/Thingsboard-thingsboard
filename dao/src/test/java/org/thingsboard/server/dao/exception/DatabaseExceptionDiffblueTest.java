package org.thingsboard.server.dao.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DatabaseExceptionDiffblueTest {
  /**
   * Test {@link DatabaseException#DatabaseException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException()}
   */
  @Test
  @DisplayName("Test new DatabaseException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  void testNewDatabaseException_thenReturnMessageIsNull() {
    // Arrange and Act
    DatabaseException actualDatabaseException = new DatabaseException();

    // Assert
    assertNull(actualDatabaseException.getMessage());
    assertNull(actualDatabaseException.getCause());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
  }

  /**
   * Test {@link DatabaseException#DatabaseException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException(String)}
   */
  @Test
  @DisplayName(
      "Test new DatabaseException(String); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  void testNewDatabaseException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    DatabaseException actualDatabaseException = new DatabaseException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDatabaseException.getMessage());
    assertNull(actualDatabaseException.getCause());
    assertEquals(0, actualDatabaseException.getSuppressed().length);
  }

  /**
   * Test {@link DatabaseException#DatabaseException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new DatabaseException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  void testNewDatabaseException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
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
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseException#DatabaseException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new DatabaseException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DatabaseException.<init>()",
    "void DatabaseException.<init>(String)",
    "void DatabaseException.<init>(String, Throwable)",
    "void DatabaseException.<init>(Throwable)"
  })
  void testNewDatabaseException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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
