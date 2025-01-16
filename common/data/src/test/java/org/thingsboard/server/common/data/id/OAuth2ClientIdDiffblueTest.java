package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class OAuth2ClientIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientId#OAuth2ClientId(UUID)}
   *   <li>{@link OAuth2ClientId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    OAuth2ClientId actualOAuth2ClientId = new OAuth2ClientId(id);
    EntityType actualEntityType = actualOAuth2ClientId.getEntityType();

    // Assert
    UUID id2 = actualOAuth2ClientId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(EntityType.OAUTH2_CLIENT, actualEntityType);
    assertSame(id, id2);
  }
}
