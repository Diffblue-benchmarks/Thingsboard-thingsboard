package org.thingsboard.server.service.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuthMethodNotSupportedExceptionDiffblueTest {
  /**
   * Test {@link AuthMethodNotSupportedException#AuthMethodNotSupportedException(String)}.
   * <p>
   * Method under test: {@link AuthMethodNotSupportedException#AuthMethodNotSupportedException(String)}
   */
  @Test
  @DisplayName("Test new AuthMethodNotSupportedException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuthMethodNotSupportedException.<init>(String)"})
  void testNewAuthMethodNotSupportedException() {
    // Arrange and Act
    AuthMethodNotSupportedException actualAuthMethodNotSupportedException = new AuthMethodNotSupportedException("Msg");

    // Assert
    assertEquals("Msg", actualAuthMethodNotSupportedException.getMessage());
    assertNull(actualAuthMethodNotSupportedException.getCause());
    assertEquals(0, actualAuthMethodNotSupportedException.getSuppressed().length);
  }
}
