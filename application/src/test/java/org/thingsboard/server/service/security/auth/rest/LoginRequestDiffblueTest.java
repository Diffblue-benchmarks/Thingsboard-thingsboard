package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LoginRequest#LoginRequest(String, String)}
   *   <li>{@link LoginRequest#getPassword()}
   *   <li>{@link LoginRequest#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    LoginRequest actualLoginRequest = new LoginRequest("janedoe", "iloveyou");
    String actualPassword = actualLoginRequest.getPassword();

    // Assert
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualLoginRequest.getUsername());
  }
}
