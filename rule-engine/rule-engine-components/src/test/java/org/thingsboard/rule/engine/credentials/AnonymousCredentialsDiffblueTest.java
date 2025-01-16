package org.thingsboard.rule.engine.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnonymousCredentialsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AnonymousCredentials}
   *   <li>{@link AnonymousCredentials#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(CredentialsType.ANONYMOUS, (new AnonymousCredentials()).getType());
  }
}
