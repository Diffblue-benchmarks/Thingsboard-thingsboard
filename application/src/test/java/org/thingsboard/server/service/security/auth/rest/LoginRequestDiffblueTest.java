package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LoginRequest.<init>(String, String)", "String LoginRequest.getPassword()",
      "String LoginRequest.getUsername()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LoginRequest actualLoginRequest = new LoginRequest("janedoe", "iloveyou");
    String actualPassword = actualLoginRequest.getPassword();

    // Assert
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualLoginRequest.getUsername());
  }
}
