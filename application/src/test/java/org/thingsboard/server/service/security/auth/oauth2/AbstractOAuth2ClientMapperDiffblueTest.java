package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbstractOAuth2ClientMapperDiffblueTest {
  /**
   * Test {@link AbstractOAuth2ClientMapper#isEdgesEnabled()}.
   * <p>
   * Method under test: {@link AbstractOAuth2ClientMapper#isEdgesEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesEnabled()")
  void testIsEdgesEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new AppleOAuth2ClientMapper()).isEdgesEnabled());
  }
}
