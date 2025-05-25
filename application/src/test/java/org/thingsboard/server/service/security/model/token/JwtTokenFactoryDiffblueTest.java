package org.thingsboard.server.service.security.model.token;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.jsonwebtoken.SignatureException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;
import org.thingsboard.server.service.security.exception.JwtExpiredTokenException;
import org.thingsboard.server.service.security.model.SecurityUser;

@ContextConfiguration(classes = {JwtTokenFactory.class})
@DisabledInAotMode
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class JwtTokenFactoryDiffblueTest {
  @MockBean
  private JwtSettingsService jwtSettingsService;

  @Autowired
  private JwtTokenFactory jwtTokenFactory;

  /**
   * Test {@link JwtTokenFactory#parseAccessJwtToken(String)}.
   * <ul>
   *   <li>Then throw {@link BadCredentialsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#parseAccessJwtToken(String)}
   */
  @Test
  @DisplayName("Test parseAccessJwtToken(String); then throw BadCredentialsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtTokenFactory.parseAccessJwtToken(String)"})
  void testParseAccessJwtToken_thenThrowBadCredentialsException() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new IllegalArgumentException("foo"));
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtTokenFactory.parseAccessJwtToken("ABC123"));
    verify(jwtSettings).getTokenSigningKey();
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#parseAccessJwtToken(String)}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#parseAccessJwtToken(String)}
   */
  @Test
  @DisplayName("Test parseAccessJwtToken(String); then throw JwtExpiredTokenException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtTokenFactory.parseAccessJwtToken(String)"})
  void testParseAccessJwtToken_thenThrowJwtExpiredTokenException() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new SignatureException("An error occurred"));
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(JwtExpiredTokenException.class, () -> jwtTokenFactory.parseAccessJwtToken("ABC123"));
    verify(jwtSettings).getTokenSigningKey();
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#parseRefreshToken(String)}.
   * <ul>
   *   <li>Then throw {@link BadCredentialsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#parseRefreshToken(String)}
   */
  @Test
  @DisplayName("Test parseRefreshToken(String); then throw BadCredentialsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtTokenFactory.parseRefreshToken(String)"})
  void testParseRefreshToken_thenThrowBadCredentialsException() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new IllegalArgumentException("foo"));
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtTokenFactory.parseRefreshToken("ABC123"));
    verify(jwtSettings).getTokenSigningKey();
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#parseRefreshToken(String)}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#parseRefreshToken(String)}
   */
  @Test
  @DisplayName("Test parseRefreshToken(String); then throw JwtExpiredTokenException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtTokenFactory.parseRefreshToken(String)"})
  void testParseRefreshToken_thenThrowJwtExpiredTokenException() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new SignatureException("An error occurred"));
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(JwtExpiredTokenException.class, () -> jwtTokenFactory.parseRefreshToken("ABC123"));
    verify(jwtSettings).getTokenSigningKey();
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#reload()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#reload()}
   */
  @Test
  @DisplayName("Test reload(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JwtTokenFactory.reload()"})
  void testReload_thenThrowIllegalArgumentException() {
    // Arrange
    when(jwtSettingsService.getJwtSettings()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.reload());
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#parseTokenClaims(String)}.
   * <ul>
   *   <li>Then throw {@link BadCredentialsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#parseTokenClaims(String)}
   */
  @Test
  @DisplayName("Test parseTokenClaims(String); then throw BadCredentialsException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.jsonwebtoken.Jws JwtTokenFactory.parseTokenClaims(String)"})
  void testParseTokenClaims_thenThrowBadCredentialsException() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new IllegalArgumentException("foo"));
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtTokenFactory.parseTokenClaims("ABC123"));
    verify(jwtSettings).getTokenSigningKey();
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#parseTokenClaims(String)}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#parseTokenClaims(String)}
   */
  @Test
  @DisplayName("Test parseTokenClaims(String); then throw JwtExpiredTokenException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"io.jsonwebtoken.Jws JwtTokenFactory.parseTokenClaims(String)"})
  void testParseTokenClaims_thenThrowJwtExpiredTokenException() {
    // Arrange
    JwtSettings jwtSettings = mock(JwtSettings.class);
    when(jwtSettings.getTokenSigningKey()).thenThrow(new SignatureException("An error occurred"));
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(JwtExpiredTokenException.class, () -> jwtTokenFactory.parseTokenClaims("ABC123"));
    verify(jwtSettings).getTokenSigningKey();
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link JwtTokenFactory#createTokenPair(SecurityUser)}.
   * <ul>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createTokenPair(SecurityUser)}
   */
  @Test
  @DisplayName("Test createTokenPair(SecurityUser); when SecurityUser(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.security.model.JwtPair JwtTokenFactory.createTokenPair(SecurityUser)"})
  void testCreateTokenPair_whenSecurityUser_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createTokenPair(new SecurityUser()));
  }
}
