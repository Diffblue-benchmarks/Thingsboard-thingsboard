package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChannelClosedExceptionDiffblueTest {
  /**
   * Test {@link ChannelClosedException#ChannelClosedException(String, Throwable)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ChannelClosedException#ChannelClosedException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ChannelClosedException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChannelClosedException.<init>()",
    "void ChannelClosedException.<init>(String)",
    "void ChannelClosedException.<init>(String, Throwable)",
    "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
    "void ChannelClosedException.<init>(Throwable)"
  })
  void testNewChannelClosedException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException =
        new ChannelClosedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChannelClosedException#ChannelClosedException()}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChannelClosedException.<init>()",
    "void ChannelClosedException.<init>(String)",
    "void ChannelClosedException.<init>(String, Throwable)",
    "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
    "void ChannelClosedException.<init>(Throwable)"
  })
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
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ChannelClosedException#ChannelClosedException(String)}
   */
  @Test
  @DisplayName(
      "Test new ChannelClosedException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChannelClosedException.<init>()",
    "void ChannelClosedException.<init>(String)",
    "void ChannelClosedException.<init>(String, Throwable)",
    "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
    "void ChannelClosedException.<init>(Throwable)"
  })
  void testNewChannelClosedException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException =
        new ChannelClosedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link ChannelClosedException#ChannelClosedException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new ChannelClosedException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChannelClosedException.<init>()",
    "void ChannelClosedException.<init>(String)",
    "void ChannelClosedException.<init>(String, Throwable)",
    "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
    "void ChannelClosedException.<init>(Throwable)"
  })
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
   * Test {@link ChannelClosedException#ChannelClosedException(String, Throwable, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ChannelClosedException#ChannelClosedException(String, Throwable,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ChannelClosedException(String, Throwable, boolean, boolean); when 'true'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ChannelClosedException.<init>()",
    "void ChannelClosedException.<init>(String)",
    "void ChannelClosedException.<init>(String, Throwable)",
    "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
    "void ChannelClosedException.<init>(Throwable)"
  })
  void testNewChannelClosedException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException =
        new ChannelClosedException("An error occurred", cause, true, true);

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }
}
