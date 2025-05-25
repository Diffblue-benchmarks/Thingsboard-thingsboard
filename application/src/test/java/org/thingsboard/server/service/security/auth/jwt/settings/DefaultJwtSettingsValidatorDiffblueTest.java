package org.thingsboard.server.service.security.auth.jwt.settings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.dao.exception.DataValidationException;

@ContextConfiguration(classes = {DefaultJwtSettingsValidator.class})
@ExtendWith(SpringExtension.class)
class DefaultJwtSettingsValidatorDiffblueTest {
  @Autowired
  private DefaultJwtSettingsValidator defaultJwtSettingsValidator;

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link JwtSettings#JwtSettings()} TokenIssuer is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); given empty string; when JwtSettings() TokenIssuer is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultJwtSettingsValidator.validate(JwtSettings)"})
  void testValidate_givenEmptyString_whenJwtSettingsTokenIssuerIsEmptyString() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenIssuer("");
    jwtSettings.setTokenSigningKey("");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>Given {@code Jwt Settings}.</li>
   *   <li>When {@link JwtSettings#JwtSettings()} TokenIssuer is {@code Jwt Settings}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); given 'Jwt Settings'; when JwtSettings() TokenIssuer is 'Jwt Settings'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultJwtSettingsValidator.validate(JwtSettings)"})
  void testValidate_givenJwtSettings_whenJwtSettingsTokenIssuerIsJwtSettings() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenIssuer("Jwt Settings");
    jwtSettings.setTokenSigningKey("");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>When {@link JwtSettings#JwtSettings()}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); when JwtSettings(); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultJwtSettingsValidator.validate(JwtSettings)"})
  void testValidate_whenJwtSettings_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(new JwtSettings()));
  }
}
