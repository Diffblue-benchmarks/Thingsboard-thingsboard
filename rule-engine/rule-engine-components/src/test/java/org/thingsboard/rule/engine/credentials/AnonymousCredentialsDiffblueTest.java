package org.thingsboard.rule.engine.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnonymousCredentialsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AnonymousCredentials}
   *   <li>{@link AnonymousCredentials#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AnonymousCredentials.<init>()",
    "CredentialsType AnonymousCredentials.getType()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(CredentialsType.ANONYMOUS, new AnonymousCredentials().getType());
  }
}
