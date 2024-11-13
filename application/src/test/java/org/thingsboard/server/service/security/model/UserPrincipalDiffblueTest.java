package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserPrincipalDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserPrincipal#UserPrincipal(UserPrincipal.Type, String)}
   *   <li>{@link UserPrincipal#getType()}
   *   <li>{@link UserPrincipal#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    UserPrincipal actualUserPrincipal = new UserPrincipal(UserPrincipal.Type.USER_NAME, "42");
    UserPrincipal.Type actualType = actualUserPrincipal.getType();

    // Assert
    assertEquals("42", actualUserPrincipal.getValue());
    assertEquals(UserPrincipal.Type.USER_NAME, actualType);
  }
}
