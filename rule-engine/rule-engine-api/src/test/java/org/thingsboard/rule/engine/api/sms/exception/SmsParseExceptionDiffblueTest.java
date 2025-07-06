package org.thingsboard.rule.engine.api.sms.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmsParseExceptionDiffblueTest {
  /**
   * Test {@link SmsParseException#SmsParseException(String)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SmsParseException#SmsParseException(String)}
   */
  @Test
  @DisplayName("Test new SmsParseException(String); when 'Msg'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SmsParseException.<init>(String)",
    "void SmsParseException.<init>(String, Throwable)"
  })
  void testNewSmsParseException_whenMsg_thenReturnCauseIsNull() {
    // Arrange and Act
    SmsParseException actualSmsParseException = new SmsParseException("Msg");

    // Assert
    assertEquals("Msg", actualSmsParseException.getMessage());
    assertNull(actualSmsParseException.getCause());
    assertEquals(0, actualSmsParseException.getSuppressed().length);
  }

  /**
   * Test {@link SmsParseException#SmsParseException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link SmsParseException#SmsParseException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new SmsParseException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SmsParseException.<init>(String)",
    "void SmsParseException.<init>(String, Throwable)"
  })
  void testNewSmsParseException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SmsParseException actualSmsParseException = new SmsParseException("Msg", cause);

    // Assert
    assertEquals("Msg", actualSmsParseException.getMessage());
    assertEquals(0, actualSmsParseException.getSuppressed().length);
    assertSame(cause, actualSmsParseException.getCause());
  }
}
