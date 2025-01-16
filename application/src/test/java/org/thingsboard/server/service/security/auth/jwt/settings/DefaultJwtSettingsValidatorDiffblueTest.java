package org.thingsboard.server.service.security.auth.jwt.settings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
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
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings)")
  void testValidate() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> defaultJwtSettingsValidator.validate(new JwtSettings(1, 1, "ABC123", "ABC123")));
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings)")
  void testValidate2() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getRefreshTokenExpTime()).thenThrow(new DataValidationException("An error occurred"));
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings).getRefreshTokenExpTime();
    verify(jwtSettings).getTokenIssuer();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings)")
  void testValidate3() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey())
        .thenReturn("JWT token signing key should be a Base64 encoded string representing at least 512 bits of data!");
    when(jwtSettings.getTokenExpirationTime()).thenReturn(60);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings, atLeast(1)).getRefreshTokenExpTime();
    verify(jwtSettings, atLeast(1)).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
    verify(jwtSettings, atLeast(1)).getTokenSigningKey();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings)")
  void testValidate4() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new DataValidationException("An error occurred"));
    when(jwtSettings.getTokenExpirationTime()).thenReturn(60);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings, atLeast(1)).getRefreshTokenExpTime();
    verify(jwtSettings, atLeast(1)).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
    verify(jwtSettings).getTokenSigningKey();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link JwtSettings} {@link JwtSettings#getTokenSigningKey()} return
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); given empty string; when JwtSettings getTokenSigningKey() return empty string")
  void testValidate_givenEmptyString_whenJwtSettingsGetTokenSigningKeyReturnEmptyString() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenReturn("");
    when(jwtSettings.getTokenExpirationTime()).thenReturn(60);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings, atLeast(1)).getRefreshTokenExpTime();
    verify(jwtSettings, atLeast(1)).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
    verify(jwtSettings).getTokenSigningKey();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link JwtSettings} {@link JwtSettings#getTokenExpirationTime()}
   * return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); given one; when JwtSettings getTokenExpirationTime() return one")
  void testValidate_givenOne_whenJwtSettingsGetTokenExpirationTimeReturnOne() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenExpirationTime()).thenReturn(1);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings).getRefreshTokenExpTime();
    verify(jwtSettings).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>Given {@link JwtSettingsService#TOKEN_SIGNING_KEY_DEFAULT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); given TOKEN_SIGNING_KEY_DEFAULT")
  void testValidate_givenToken_signing_key_default() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenReturn(JwtSettingsService.TOKEN_SIGNING_KEY_DEFAULT);
    when(jwtSettings.getTokenExpirationTime()).thenReturn(60);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act
    defaultJwtSettingsValidator.validate(jwtSettings);

    // Assert
    verify(jwtSettings, atLeast(1)).getRefreshTokenExpTime();
    verify(jwtSettings, atLeast(1)).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
    verify(jwtSettings, atLeast(1)).getTokenSigningKey();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>When {@link JwtSettings} {@link JwtSettings#getTokenExpirationTime()}
   * return nine hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); when JwtSettings getTokenExpirationTime() return nine hundred")
  void testValidate_whenJwtSettingsGetTokenExpirationTimeReturnNineHundred() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenExpirationTime()).thenReturn(900);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings, atLeast(1)).getRefreshTokenExpTime();
    verify(jwtSettings, atLeast(1)).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
  }

  /**
   * Test {@link DefaultJwtSettingsValidator#validate(JwtSettings)}.
   * <ul>
   *   <li>When {@link JwtSettings} {@link JwtSettings#getTokenSigningKey()} return
   * {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultJwtSettingsValidator#validate(JwtSettings)}
   */
  @Test
  @DisplayName("Test validate(JwtSettings); when JwtSettings getTokenSigningKey() return 'ABC123'")
  void testValidate_whenJwtSettingsGetTokenSigningKeyReturnAbc123() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenReturn("ABC123");
    when(jwtSettings.getTokenExpirationTime()).thenReturn(60);
    when(jwtSettings.getRefreshTokenExpTime()).thenReturn(900);
    when(jwtSettings.getTokenIssuer()).thenReturn("ABC123");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(jwtSettings));
    verify(jwtSettings, atLeast(1)).getRefreshTokenExpTime();
    verify(jwtSettings, atLeast(1)).getTokenExpirationTime();
    verify(jwtSettings).getTokenIssuer();
    verify(jwtSettings, atLeast(1)).getTokenSigningKey();
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
  void testValidate_whenJwtSettings_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> defaultJwtSettingsValidator.validate(new JwtSettings()));
  }
}
