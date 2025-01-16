package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.service.security.auth.JwtAuthenticationToken;
import org.thingsboard.server.service.security.auth.RefreshAuthenticationToken;
import org.thingsboard.server.service.security.auth.TokenOutdatingService;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.UserPrincipal;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;
import org.thingsboard.server.service.security.model.token.RawAccessJwtToken;

@ContextConfiguration(classes = {RefreshTokenAuthenticationProvider.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RefreshTokenAuthenticationProviderDiffblueTest {
  @MockBean
  private CustomerService customerService;

  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @Autowired
  private RefreshTokenAuthenticationProvider refreshTokenAuthenticationProvider;

  @MockBean
  private TokenOutdatingService tokenOutdatingService;

  @MockBean
  private UserService userService;

  /**
   * Test {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}.
   * <ul>
   *   <li>Given {@link SecurityUser} {@link User#getId()} return {@code null}.</li>
   *   <li>Then calls {@link User#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication); given SecurityUser getId() return 'null'; then calls getId()")
  void testAuthenticate_givenSecurityUserGetIdReturnNull_thenCallsGetId() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getId()).thenReturn(null);
    when(securityUser.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    doNothing().when(securityUser).setUserPrincipal(Mockito.<UserPrincipal>any());
    securityUser.setUserPrincipal(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(jwtTokenFactory.parseRefreshToken(Mockito.<String>any())).thenReturn(securityUser);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(new User());

    // Act and Assert
    assertThrows(DisabledException.class, () -> refreshTokenAuthenticationProvider
        .authenticate(new JwtAuthenticationToken(new RawAccessJwtToken("ABC123"))));
    verify(securityUser).getId();
    verify(userService).findUserById(isA(TenantId.class), isNull());
    verify(userService).findUserCredentialsByUserId(isA(TenantId.class), isNull());
    verify(securityUser).getUserPrincipal();
    verify(securityUser).setUserPrincipal(isA(UserPrincipal.class));
    verify(jwtTokenFactory).parseRefreshToken(eq("ABC123"));
  }

  /**
   * Test {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}.
   * <ul>
   *   <li>Then throw {@link BadCredentialsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication); then throw BadCredentialsException")
  void testAuthenticate_thenThrowBadCredentialsException() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getUserPrincipal()).thenReturn(new UserPrincipal(UserPrincipal.Type.PUBLIC_ID, "42"));
    doNothing().when(securityUser).setUserPrincipal(Mockito.<UserPrincipal>any());
    securityUser.setUserPrincipal(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(jwtTokenFactory.parseRefreshToken(Mockito.<String>any())).thenReturn(securityUser);

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> refreshTokenAuthenticationProvider
        .authenticate(new JwtAuthenticationToken(new RawAccessJwtToken("ABC123"))));
    verify(securityUser).getUserPrincipal();
    verify(securityUser).setUserPrincipal(isA(UserPrincipal.class));
    verify(jwtTokenFactory).parseRefreshToken(eq("ABC123"));
  }

  /**
   * Test {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}.
   * <ul>
   *   <li>Then throw {@link CredentialsExpiredException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication); then throw CredentialsExpiredException")
  void testAuthenticate_thenThrowCredentialsExpiredException() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = new SecurityUser();
    securityUser.setUserPrincipal(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(jwtTokenFactory.parseRefreshToken(Mockito.<String>any())).thenReturn(securityUser);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new CredentialsExpiredException("No authentication data provided"));
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(new User());

    // Act and Assert
    assertThrows(CredentialsExpiredException.class, () -> refreshTokenAuthenticationProvider
        .authenticate(new JwtAuthenticationToken(new RawAccessJwtToken("ABC123"))));
    verify(userService).findUserById(isA(TenantId.class), isNull());
    verify(userService).findUserCredentialsByUserId(isA(TenantId.class), isNull());
    verify(jwtTokenFactory).parseRefreshToken(eq("ABC123"));
  }

  /**
   * Test {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}.
   * <ul>
   *   <li>Then throw {@link DisabledException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RefreshTokenAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication); then throw DisabledException")
  void testAuthenticate_thenThrowDisabledException() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = new SecurityUser();
    securityUser.setUserPrincipal(new UserPrincipal(UserPrincipal.Type.USER_NAME, "42"));
    when(jwtTokenFactory.parseRefreshToken(Mockito.<String>any())).thenReturn(securityUser);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(new User());

    // Act and Assert
    assertThrows(DisabledException.class, () -> refreshTokenAuthenticationProvider
        .authenticate(new JwtAuthenticationToken(new RawAccessJwtToken("ABC123"))));
    verify(userService).findUserById(isA(TenantId.class), isNull());
    verify(userService).findUserCredentialsByUserId(isA(TenantId.class), isNull());
    verify(jwtTokenFactory).parseRefreshToken(eq("ABC123"));
  }

  /**
   * Test {@link RefreshTokenAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); then return 'true'")
  void testSupports_thenReturnTrue() {
    // Arrange
    Class<RefreshAuthenticationToken> authentication = RefreshAuthenticationToken.class;

    // Act and Assert
    assertTrue(refreshTokenAuthenticationProvider.supports(authentication));
  }

  /**
   * Test {@link RefreshTokenAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RefreshTokenAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> authentication = Object.class;

    // Act and Assert
    assertFalse(refreshTokenAuthenticationProvider.supports(authentication));
  }
}
