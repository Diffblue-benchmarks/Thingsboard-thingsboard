package org.thingsboard.server.service.security.model.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccessJwtTokenDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccessJwtToken#AccessJwtToken(String)}
   *   <li>{@link AccessJwtToken#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccessJwtToken.<init>(String)", "String AccessJwtToken.getToken()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("ABC123", (new AccessJwtToken("ABC123")).getToken());
  }
}
