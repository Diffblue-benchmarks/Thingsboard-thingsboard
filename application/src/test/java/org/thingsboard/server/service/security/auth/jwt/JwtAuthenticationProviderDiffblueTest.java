package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.service.security.auth.JwtAuthenticationToken;
import org.thingsboard.server.service.security.auth.TokenOutdatingService;
import org.thingsboard.server.service.security.exception.JwtExpiredTokenException;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.model.token.RawAccessJwtToken;

@ContextConfiguration(classes = {JwtAuthenticationProvider.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class JwtAuthenticationProviderDiffblueTest {
  @Autowired
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @MockBean
  private TokenOutdatingService tokenOutdatingService;

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with
   * {@code accessToken}.
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'")
  void testAuthenticateWithAccessToken() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(new SecurityUser());
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any()))
        .thenThrow(new BadCredentialsException("Msg"));

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider.authenticate("ABC123"));
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with
   * {@code accessToken}.
   * <ul>
   *   <li>Then return {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; then return SecurityUser()")
  void testAuthenticateWithAccessToken_thenReturnSecurityUser() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = new SecurityUser();
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(securityUser);
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any())).thenReturn(false);

    // Act
    SecurityUser actualAuthenticateResult = jwtAuthenticationProvider.authenticate("ABC123");

    // Assert
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
    assertSame(securityUser, actualAuthenticateResult);
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with
   * {@code accessToken}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; then throw JwtExpiredTokenException")
  void testAuthenticateWithAccessToken_thenThrowJwtExpiredTokenException() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(new SecurityUser());
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any())).thenReturn(true);

    // Act and Assert
    assertThrows(JwtExpiredTokenException.class, () -> jwtAuthenticationProvider.authenticate("ABC123"));
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with
   * {@code accessToken}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link BadCredentialsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; when empty string; then throw BadCredentialsException")
  void testAuthenticateWithAccessToken_whenEmptyString_thenThrowBadCredentialsException()
      throws AuthenticationException {
    // Arrange, Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider.authenticate(""));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with
   * {@code authentication}.
   * <p>
   * Method under test:
   * {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'")
  void testAuthenticateWithAuthentication() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(new SecurityUser());
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any()))
        .thenThrow(new BadCredentialsException("Msg"));

    // Act and Assert
    assertThrows(BadCredentialsException.class,
        () -> jwtAuthenticationProvider.authenticate(new JwtAuthenticationToken(new RawAccessJwtToken("ABC123"))));
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with
   * {@code authentication}.
   * <p>
   * Method under test:
   * {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'")
  void testAuthenticateWithAuthentication2() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(new SecurityUser());
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any())).thenReturn(true);
    RawAccessJwtToken rawAccessJwtToken = new RawAccessJwtToken("ABC123");
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    Class<Authentication> originalAuthentication = Authentication.class;

    // Act and Assert
    assertThrows(JwtExpiredTokenException.class, () -> jwtAuthenticationProvider
        .authenticate(new RunAsUserToken("Key", "Principal", rawAccessJwtToken, authorities, originalAuthentication)));
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with
   * {@code authentication}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'; then throw JwtExpiredTokenException")
  void testAuthenticateWithAuthentication_thenThrowJwtExpiredTokenException() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(new SecurityUser());
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any())).thenReturn(true);

    // Act and Assert
    assertThrows(JwtExpiredTokenException.class,
        () -> jwtAuthenticationProvider.authenticate(new JwtAuthenticationToken(new RawAccessJwtToken("ABC123"))));
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with
   * {@code authentication}.
   * <ul>
   *   <li>When {@link RawAccessJwtToken#RawAccessJwtToken(String)} with token is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'; when RawAccessJwtToken(String) with token is empty string")
  void testAuthenticateWithAuthentication_whenRawAccessJwtTokenWithTokenIsEmptyString() throws AuthenticationException {
    // Arrange, Act and Assert
    assertThrows(BadCredentialsException.class,
        () -> jwtAuthenticationProvider.authenticate(new JwtAuthenticationToken(new RawAccessJwtToken(""))));
  }

  /**
   * Test {@link JwtAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    Class<JwtAuthenticationToken> authentication = JwtAuthenticationToken.class;

    // Act and Assert
    assertTrue(jwtAuthenticationProvider.supports(authentication));
  }

  /**
   * Test {@link JwtAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> authentication = Object.class;

    // Act and Assert
    assertFalse(jwtAuthenticationProvider.supports(authentication));
  }
}
