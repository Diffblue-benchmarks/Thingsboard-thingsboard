package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractOAuth2ClientMapperDiffblueTest {
  /**
   * Test {@link AbstractOAuth2ClientMapper#isEdgesEnabled()}.
   * <p>
   * Method under test: {@link AbstractOAuth2ClientMapper#isEdgesEnabled()}
   */
  @Test
  @DisplayName("Test isEdgesEnabled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractOAuth2ClientMapper.isEdgesEnabled()"})
  void testIsEdgesEnabled() {
    // Arrange, Act and Assert
    assertFalse((new AppleOAuth2ClientMapper()).isEdgesEnabled());
  }
}
