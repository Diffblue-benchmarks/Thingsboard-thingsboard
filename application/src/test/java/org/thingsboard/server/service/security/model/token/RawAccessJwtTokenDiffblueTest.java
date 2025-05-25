package org.thingsboard.server.service.security.model.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RawAccessJwtTokenDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RawAccessJwtToken#RawAccessJwtToken(String)}
   *   <li>{@link RawAccessJwtToken#getToken()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RawAccessJwtToken.<init>(String)", "String RawAccessJwtToken.getToken()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("ABC123", (new RawAccessJwtToken("ABC123")).getToken());
  }
}
