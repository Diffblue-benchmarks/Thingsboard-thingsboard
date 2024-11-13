package org.thingsboard.server.service.security.model.token;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OAuth2AppTokenFactory.class})
@ExtendWith(SpringExtension.class)
class OAuth2AppTokenFactoryDiffblueTest {
  @Autowired
  private OAuth2AppTokenFactory oAuth2AppTokenFactory;

  /**
   * Test
   * {@link OAuth2AppTokenFactory#validateTokenAndGetCallbackUrlScheme(String, String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OAuth2AppTokenFactory#validateTokenAndGetCallbackUrlScheme(String, String, String)}
   */
  @Test
  @DisplayName("Test validateTokenAndGetCallbackUrlScheme(String, String, String); then throw IllegalArgumentException")
  void testValidateTokenAndGetCallbackUrlScheme_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> oAuth2AppTokenFactory.validateTokenAndGetCallbackUrlScheme("https://example.org/example",
            "https://example.org/example", "https://example.org/example"));
  }
}
