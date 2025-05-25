package org.thingsboard.server.service.security.auth.jwt.settings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.security.model.JwtSettings;

class DefaultJwtSettingsServiceDiffblueTest {
  /**
   * Test {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}.
   * <ul>
   *   <li>Given {@link JwtSettingsService#TOKEN_SIGNING_KEY_DEFAULT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}
   */
  @Test
  @DisplayName("Test isSigningKeyDefault(JwtSettings); given TOKEN_SIGNING_KEY_DEFAULT; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultJwtSettingsService.isSigningKeyDefault(JwtSettings)"})
  void testIsSigningKeyDefault_givenToken_signing_key_default_thenReturnTrue() {
    // Arrange
    JwtSettings settings = new JwtSettings();
    settings.setTokenSigningKey(JwtSettingsService.TOKEN_SIGNING_KEY_DEFAULT);

    // Act and Assert
    assertTrue(DefaultJwtSettingsService.isSigningKeyDefault(settings));
  }

  /**
   * Test {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}.
   * <ul>
   *   <li>When {@link JwtSettings#JwtSettings()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#isSigningKeyDefault(JwtSettings)}
   */
  @Test
  @DisplayName("Test isSigningKeyDefault(JwtSettings); when JwtSettings(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultJwtSettingsService.isSigningKeyDefault(JwtSettings)"})
  void testIsSigningKeyDefault_whenJwtSettings_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DefaultJwtSettingsService.isSigningKeyDefault(new JwtSettings()));
  }

  /**
   * Test {@link DefaultJwtSettingsService#validateKeyLength(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsService#validateKeyLength(String)}
   */
  @Test
  @DisplayName("Test validateKeyLength(String); when 'Key'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultJwtSettingsService.validateKeyLength(String)"})
  void testValidateKeyLength_whenKey_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DefaultJwtSettingsService.validateKeyLength("Key"));
  }
}
