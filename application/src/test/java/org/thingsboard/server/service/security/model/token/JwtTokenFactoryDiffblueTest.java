package org.thingsboard.server.service.security.model.token;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;
import org.thingsboard.server.service.security.exception.JwtExpiredTokenException;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.UserPrincipal;

@ContextConfiguration(classes = {JwtTokenFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class JwtTokenFactoryDiffblueTest {
  @MockBean
  private JwtSettingsService jwtSettingsService;

  @Autowired
  private JwtTokenFactory jwtTokenFactory;

  /**
   * Test {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createAccessJwtToken(SecurityUser); given empty string")
  void testCreateAccessJwtToken_givenEmptyString() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    jwtSettings.setTokenExpirationTime(1);
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getEmail()).thenReturn("");
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());
    when(securityUser.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(securityUser.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createAccessJwtToken(securityUser));
    verify(securityUser).getAuthority();
    verify(securityUser).getEmail();
    verify(jwtSettingsService).getJwtSettings();
    verify(securityUser).getAuthorities();
    verify(securityUser).getUserPrincipal();
  }

  /**
   * Test {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}.
   * <ul>
   *   <li>Given {@link JwtSettingsService}.</li>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createAccessJwtToken(SecurityUser); given JwtSettingsService; when SecurityUser()")
  void testCreateAccessJwtToken_givenJwtSettingsService_whenSecurityUser() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createAccessJwtToken(new SecurityUser()));
  }

  /**
   * Test {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link JwtException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createAccessJwtToken(SecurityUser); then throw JwtException")
  void testCreateAccessJwtToken_thenThrowJwtException() {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getUserPrincipal()).thenThrow(new JwtException("An error occurred"));
    when(securityUser.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(JwtException.class, () -> jwtTokenFactory.createAccessJwtToken(securityUser));
    verify(securityUser).getAuthority();
    verify(securityUser).getUserPrincipal();
  }

  /**
   * Test {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}.
   * <ul>
   *   <li>When {@link SecurityUser} {@link User#getEmail()} return
   * {@code null}.</li>
   *   <li>Then calls {@link User#getEmail()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createAccessJwtToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createAccessJwtToken(SecurityUser); when SecurityUser getEmail() return 'null'; then calls getEmail()")
  void testCreateAccessJwtToken_whenSecurityUserGetEmailReturnNull_thenCallsGetEmail() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    jwtSettings.setTokenExpirationTime(1);
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getEmail()).thenReturn(null);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());
    when(securityUser.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(securityUser.getAuthority()).thenReturn(Authority.SYS_ADMIN);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createAccessJwtToken(securityUser));
    verify(securityUser).getAuthority();
    verify(securityUser).getEmail();
    verify(jwtSettingsService).getJwtSettings();
    verify(securityUser).getAuthorities();
    verify(securityUser).getUserPrincipal();
  }

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
   * Test {@link JwtTokenFactory#createRefreshToken(SecurityUser)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createRefreshToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createRefreshToken(SecurityUser); given empty string")
  void testCreateRefreshToken_givenEmptyString() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setRefreshTokenExpTime(1);
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getEmail()).thenReturn("");
    when(securityUser.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createRefreshToken(securityUser));
    verify(securityUser).getEmail();
    verify(jwtSettingsService).getJwtSettings();
    verify(securityUser).getUserPrincipal();
  }

  /**
   * Test {@link JwtTokenFactory#createRefreshToken(SecurityUser)}.
   * <ul>
   *   <li>Then calls {@link User#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createRefreshToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createRefreshToken(SecurityUser); then calls getId()")
  void testCreateRefreshToken_thenCallsGetId() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setRefreshTokenExpTime(1);
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getSessionId()).thenThrow(new IllegalArgumentException("userId"));
    when(securityUser.getId()).thenReturn(new UserId(UUID.randomUUID()));
    when(securityUser.getEmail()).thenReturn("jane.doe@example.org");
    when(securityUser.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createRefreshToken(securityUser));
    verify(securityUser).getEmail();
    verify(securityUser).getId();
    verify(jwtSettingsService).getJwtSettings();
    verify(securityUser).getSessionId();
    verify(securityUser, atLeast(1)).getUserPrincipal();
  }

  /**
   * Test {@link JwtTokenFactory#createRefreshToken(SecurityUser)}.
   * <ul>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createRefreshToken(SecurityUser)}
   */
  @Test
  @DisplayName("Test createRefreshToken(SecurityUser); when SecurityUser(); then throw IllegalArgumentException")
  void testCreateRefreshToken_whenSecurityUser_thenThrowIllegalArgumentException() {
    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setRefreshTokenExpTime(1);
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createRefreshToken(new SecurityUser()));
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
   * Test
   * {@link JwtTokenFactory#createPreVerificationToken(SecurityUser, Integer)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtTokenFactory#createPreVerificationToken(SecurityUser, Integer)}
   */
  @Test
  @DisplayName("Test createPreVerificationToken(SecurityUser, Integer); given empty string")
  void testCreatePreVerificationToken_givenEmptyString() {
    // Arrange
    SecurityUser user = mock(SecurityUser.class);
    when(user.getEmail()).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createPreVerificationToken(user, 1));
    verify(user).getEmail();
  }

  /**
   * Test
   * {@link JwtTokenFactory#createPreVerificationToken(SecurityUser, Integer)}.
   * <ul>
   *   <li>Then calls {@link User#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtTokenFactory#createPreVerificationToken(SecurityUser, Integer)}
   */
  @Test
  @DisplayName("Test createPreVerificationToken(SecurityUser, Integer); then calls getId()")
  void testCreatePreVerificationToken_thenCallsGetId() {
    // Arrange
    SecurityUser user = mock(SecurityUser.class);
    when(user.getSessionId()).thenThrow(new IllegalArgumentException("userId"));
    when(user.getId()).thenReturn(new UserId(UUID.randomUUID()));
    when(user.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createPreVerificationToken(user, 1));
    verify(user).getEmail();
    verify(user).getId();
    verify(user).getSessionId();
    verify(user).getUserPrincipal();
  }

  /**
   * Test
   * {@link JwtTokenFactory#createPreVerificationToken(SecurityUser, Integer)}.
   * <ul>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtTokenFactory#createPreVerificationToken(SecurityUser, Integer)}
   */
  @Test
  @DisplayName("Test createPreVerificationToken(SecurityUser, Integer); when SecurityUser()")
  void testCreatePreVerificationToken_whenSecurityUser() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jwtTokenFactory.createPreVerificationToken(new SecurityUser(), 1));
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
   *   <li>Given {@link JwtSettingsService}.</li>
   *   <li>When {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenFactory#createTokenPair(SecurityUser)}
   */
  @Test
  @DisplayName("Test createTokenPair(SecurityUser); given JwtSettingsService; when SecurityUser()")
  void testCreateTokenPair_givenJwtSettingsService_whenSecurityUser() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jwtTokenFactory.createTokenPair(new SecurityUser()));
  }
}
