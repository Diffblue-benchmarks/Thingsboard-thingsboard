package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OAuth2ClientRegistrationTemplateIdDiffblueTest {
  /**
   * Test
   * {@link OAuth2ClientRegistrationTemplateId#OAuth2ClientRegistrationTemplateId(UUID)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientRegistrationTemplateId#OAuth2ClientRegistrationTemplateId(UUID)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplateId(UUID)")
  void testNewOAuth2ClientRegistrationTemplateId() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act and Assert
    UUID id2 = (new OAuth2ClientRegistrationTemplateId(id)).getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertSame(id, id2);
  }
}
