package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OAuth2ClientRegistrationTemplateIdDiffblueTest {
  /**
   * Test {@link OAuth2ClientRegistrationTemplateId#OAuth2ClientRegistrationTemplateId(UUID)}.
   *
   * <p>Method under test: {@link
   * OAuth2ClientRegistrationTemplateId#OAuth2ClientRegistrationTemplateId(UUID)}
   */
  @Test
  @DisplayName("Test new OAuth2ClientRegistrationTemplateId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OAuth2ClientRegistrationTemplateId.<init>(UUID)"})
  void testNewOAuth2ClientRegistrationTemplateId() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    UUID id2 = new OAuth2ClientRegistrationTemplateId(id).getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
  }
}
