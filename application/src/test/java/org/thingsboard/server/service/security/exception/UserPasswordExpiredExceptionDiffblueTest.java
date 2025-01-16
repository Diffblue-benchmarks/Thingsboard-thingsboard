package org.thingsboard.server.service.security.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserPasswordExpiredExceptionDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link UserPasswordExpiredException#UserPasswordExpiredException(String, String)}
   *   <li>{@link UserPasswordExpiredException#getResetToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    UserPasswordExpiredException actualUserPasswordExpiredException = new UserPasswordExpiredException("Msg", "ABC123");

    // Assert
    assertEquals("ABC123", actualUserPasswordExpiredException.getResetToken());
    assertEquals("Msg", actualUserPasswordExpiredException.getMessage());
    assertNull(actualUserPasswordExpiredException.getCause());
    assertEquals(0, actualUserPasswordExpiredException.getSuppressed().length);
  }
}
