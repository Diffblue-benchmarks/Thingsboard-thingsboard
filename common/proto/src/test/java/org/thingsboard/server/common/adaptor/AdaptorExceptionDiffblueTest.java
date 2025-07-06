package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdaptorExceptionDiffblueTest {
  /**
   * Test {@link AdaptorException#AdaptorException(Exception)}.
   *
   * <ul>
   *   <li>Then return Message is {@code Exception: foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptorException#AdaptorException(Exception)}
   */
  @Test
  @DisplayName(
      "Test new AdaptorException(Exception); then return Message is 'java.lang.Exception: foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AdaptorException.<init>()",
    "void AdaptorException.<init>(Exception)",
    "void AdaptorException.<init>(String)",
    "void AdaptorException.<init>(String, Exception)"
  })
  void testNewAdaptorException_thenReturnMessageIsJavaLangExceptionFoo() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    AdaptorException actualAdaptorException = new AdaptorException(cause);

    // Assert
    assertEquals("java.lang.Exception: foo", actualAdaptorException.getMessage());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
    assertSame(cause, actualAdaptorException.getCause());
  }

  /**
   * Test {@link AdaptorException#AdaptorException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptorException#AdaptorException()}
   */
  @Test
  @DisplayName("Test new AdaptorException(); then return Message is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AdaptorException.<init>()",
    "void AdaptorException.<init>(Exception)",
    "void AdaptorException.<init>(String)",
    "void AdaptorException.<init>(String, Exception)"
  })
  void testNewAdaptorException_thenReturnMessageIsNull() {
    // Arrange and Act
    AdaptorException actualAdaptorException = new AdaptorException();

    // Assert
    assertNull(actualAdaptorException.getMessage());
    assertNull(actualAdaptorException.getCause());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
  }

  /**
   * Test {@link AdaptorException#AdaptorException(String, Exception)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptorException#AdaptorException(String, Exception)}
   */
  @Test
  @DisplayName(
      "Test new AdaptorException(String, Exception); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AdaptorException.<init>()",
    "void AdaptorException.<init>(Exception)",
    "void AdaptorException.<init>(String)",
    "void AdaptorException.<init>(String, Exception)"
  })
  void testNewAdaptorException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    AdaptorException actualAdaptorException = new AdaptorException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAdaptorException.getMessage());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
    assertSame(cause, actualAdaptorException.getCause());
  }

  /**
   * Test {@link AdaptorException#AdaptorException(String)}.
   *
   * <ul>
   *   <li>When {@code Cause}.
   *   <li>Then return Message is {@code Cause}.
   * </ul>
   *
   * <p>Method under test: {@link AdaptorException#AdaptorException(String)}
   */
  @Test
  @DisplayName("Test new AdaptorException(String); when 'Cause'; then return Message is 'Cause'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AdaptorException.<init>()",
    "void AdaptorException.<init>(Exception)",
    "void AdaptorException.<init>(String)",
    "void AdaptorException.<init>(String, Exception)"
  })
  void testNewAdaptorException_whenCause_thenReturnMessageIsCause() {
    // Arrange and Act
    AdaptorException actualAdaptorException = new AdaptorException("Cause");

    // Assert
    assertEquals("Cause", actualAdaptorException.getMessage());
    assertNull(actualAdaptorException.getCause());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
  }
}
