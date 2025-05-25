package org.thingsboard.server.service.security.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.security.model.UserPrincipal.Type;

class UserPrincipalDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserPrincipal#UserPrincipal(Type, String)}
   *   <li>{@link UserPrincipal#getType()}
   *   <li>{@link UserPrincipal#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserPrincipal.<init>(Type, String)", "Type UserPrincipal.getType()",
      "String UserPrincipal.getValue()"})
  void testGettersAndSetters() {
    // Arrange and Act
    UserPrincipal actualUserPrincipal = new UserPrincipal(Type.USER_NAME, "42");
    Type actualType = actualUserPrincipal.getType();

    // Assert
    assertEquals("42", actualUserPrincipal.getValue());
    assertEquals(Type.USER_NAME, actualType);
  }
}
