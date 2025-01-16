package org.thingsboard.server.common.msg.session.ex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SessionAuthExceptionDiffblueTest {
  /**
   * Test {@link SessionAuthException#SessionAuthException(String)}.
   * <p>
   * Method under test: {@link SessionAuthException#SessionAuthException(String)}
   */
  @Test
  @DisplayName("Test new SessionAuthException(String)")
  void testNewSessionAuthException() {
    // Arrange and Act
    SessionAuthException actualSessionAuthException = new SessionAuthException("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualSessionAuthException.getMessage());
    assertNull(actualSessionAuthException.getCause());
    assertEquals(0, actualSessionAuthException.getSuppressed().length);
  }
}
