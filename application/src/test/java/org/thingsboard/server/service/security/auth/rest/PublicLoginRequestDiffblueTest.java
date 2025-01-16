package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PublicLoginRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PublicLoginRequest#PublicLoginRequest(String)}
   *   <li>{@link PublicLoginRequest#getPublicId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("42", (new PublicLoginRequest("42")).getPublicId());
  }
}
