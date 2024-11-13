package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChannelClosedExceptionDiffblueTest {
  /**
   * Test
   * {@link ChannelClosedException#ChannelClosedException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(String, Throwable); then return Message is 'An error occurred'")
  void testNewChannelClosedException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChannelClosedException#ChannelClosedException()}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(); then return Message is 'null'")
  void testNewChannelClosedException_thenReturnMessageIsNull() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException();

    // Assert
    assertNull(actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(String)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(String); when 'An error occurred'; then return Cause is 'null'")
  void testNewChannelClosedException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code java.lang.Throwable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(Throwable)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  void testNewChannelClosedException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }

  /**
   * Test
   * {@link ChannelClosedException#ChannelClosedException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(String, Throwable, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(String, Throwable, boolean, boolean); when 'true'; then return Message is 'An error occurred'")
  void testNewChannelClosedException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred", cause, true,
        true);

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }
}
