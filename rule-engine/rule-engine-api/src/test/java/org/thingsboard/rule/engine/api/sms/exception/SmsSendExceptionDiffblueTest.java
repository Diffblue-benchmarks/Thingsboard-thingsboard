package org.thingsboard.rule.engine.api.sms.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SmsSendExceptionDiffblueTest {
  /**
   * Test {@link SmsSendException#SmsSendException(String)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SmsSendException#SmsSendException(String)}
   */
  @Test
  @DisplayName("Test new SmsSendException(String); when 'Msg'; then return Cause is 'null'")
  void testNewSmsSendException_whenMsg_thenReturnCauseIsNull() {
    // Arrange and Act
    SmsSendException actualSmsSendException = new SmsSendException("Msg");

    // Assert
    assertEquals("Msg", actualSmsSendException.getMessage());
    assertNull(actualSmsSendException.getCause());
    assertEquals(0, actualSmsSendException.getSuppressed().length);
  }

  /**
   * Test {@link SmsSendException#SmsSendException(String, Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Cause is {@link Throwable#Throwable()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SmsSendException#SmsSendException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new SmsSendException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  void testNewSmsSendException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SmsSendException actualSmsSendException = new SmsSendException("Msg", cause);

    // Assert
    assertEquals("Msg", actualSmsSendException.getMessage());
    assertEquals(0, actualSmsSendException.getSuppressed().length);
    assertSame(cause, actualSmsSendException.getCause());
  }
}
