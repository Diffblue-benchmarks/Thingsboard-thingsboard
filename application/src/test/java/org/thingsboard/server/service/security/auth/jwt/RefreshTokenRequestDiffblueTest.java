package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RefreshTokenRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RefreshTokenRequest#RefreshTokenRequest(String)}
   *   <li>{@link RefreshTokenRequest#getRefreshToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RefreshTokenRequest.<init>(String)", "String RefreshTokenRequest.getRefreshToken()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("ABC123", (new RefreshTokenRequest("ABC123")).getRefreshToken());
  }
}
