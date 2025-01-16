package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThingsboardExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return ErrorCode is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException()}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return ErrorCode is 'null'")
  void testGettersAndSetters_thenReturnErrorCodeIsNull() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException();

    // Assert
    assertNull(actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertNull(actualThingsboardException.getErrorCode());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ThingsboardException#ThingsboardException(String, Throwable, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardException actualThingsboardException = new ThingsboardException("An error occurred", cause,
        ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardException.getMessage());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
    assertSame(cause, actualThingsboardException.getCause());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ThingsboardException#ThingsboardException(String, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException("An error occurred",
        ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code GENERAL}.</li>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException(ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'GENERAL'; then return Message is 'null'")
  void testGettersAndSetters_whenGeneral_thenReturnMessageIsNull() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException(ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertNull(actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ThingsboardException#ThingsboardException(Throwable, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when Throwable(); then return Message is 'java.lang.Throwable'")
  void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardException actualThingsboardException = new ThingsboardException(cause, ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("java.lang.Throwable", actualThingsboardException.getMessage());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
    assertSame(cause, actualThingsboardException.getCause());
  }
}
