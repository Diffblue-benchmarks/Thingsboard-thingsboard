package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class JwtAuthenticationProviderDiffblueTest {
  @Autowired
  private JwtAuthenticationProvider jwtAuthenticationProvider;

  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @MockBean
  private TokenOutdatingService tokenOutdatingService;

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with {@code accessToken}.
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtAuthenticationProvider.authenticate(String)"})
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
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with {@code accessToken}.
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtAuthenticationProvider.authenticate(String)"})
  void testAuthenticateWithAccessToken2() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenThrow(new BadCredentialsException("Msg"));

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider.authenticate("ExampleToken"));
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ExampleToken"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with {@code accessToken}.
   * <ul>
   *   <li>Given {@link JwtTokenFactory}.</li>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; given JwtTokenFactory; when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtAuthenticationProvider.authenticate(String)"})
  void testAuthenticateWithAccessToken_givenJwtTokenFactory_whenEmptyString() throws AuthenticationException {
    // Arrange, Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider.authenticate(""));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with {@code accessToken}.
   * <ul>
   *   <li>Given {@link JwtTokenFactory}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; given JwtTokenFactory; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtAuthenticationProvider.authenticate(String)"})
  void testAuthenticateWithAccessToken_givenJwtTokenFactory_whenNull() throws AuthenticationException {
    // Arrange, Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider.authenticate((String) null));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with {@code accessToken}.
   * <ul>
   *   <li>Then return {@link SecurityUser#SecurityUser()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; then return SecurityUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtAuthenticationProvider.authenticate(String)"})
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
   * Test {@link JwtAuthenticationProvider#authenticate(String)} with {@code accessToken}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(String)}
   */
  @Test
  @DisplayName("Test authenticate(String) with 'accessToken'; then throw JwtExpiredTokenException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SecurityUser JwtAuthenticationProvider.authenticate(String)"})
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
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with {@code authentication}.
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication JwtAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticateWithAuthentication() throws AuthenticationException {
    // Arrange
    when(jwtTokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(new SecurityUser());
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any()))
        .thenThrow(new BadCredentialsException("Msg"));
    RawAccessJwtToken rawAccessJwtToken = new RawAccessJwtToken("ABC123");
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    Class<Authentication> originalAuthentication = Authentication.class;

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider
        .authenticate(new RunAsUserToken("Key", "Principal", rawAccessJwtToken, authorities, originalAuthentication)));
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(jwtTokenFactory).parseAccessJwtToken(eq("ABC123"));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with {@code authentication}.
   * <ul>
   *   <li>Then Authorities return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'; then Authorities return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication JwtAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticateWithAuthentication_thenAuthoritiesReturnList() throws AuthenticationException {
    // Arrange
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());
    when(securityUser.getId()).thenReturn(null);
    JwtTokenFactory tokenFactory = mock(JwtTokenFactory.class);
    when(tokenFactory.parseAccessJwtToken(Mockito.<String>any())).thenReturn(securityUser);
    TokenOutdatingService tokenOutdatingService = mock(TokenOutdatingService.class);
    when(tokenOutdatingService.isOutdated(Mockito.<String>any(), Mockito.<UserId>any())).thenReturn(false);
    JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(tokenFactory,
        tokenOutdatingService);
    RawAccessJwtToken rawAccessJwtToken = new RawAccessJwtToken("ABC123");
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    Class<Authentication> originalAuthentication = Authentication.class;

    // Act
    Authentication actualAuthenticateResult = jwtAuthenticationProvider
        .authenticate(new RunAsUserToken("Key", "Principal", rawAccessJwtToken, authorities, originalAuthentication));

    // Assert
    verify(securityUser).getId();
    verify(tokenOutdatingService).isOutdated(eq("ABC123"), isNull());
    verify(securityUser).getAuthorities();
    verify(tokenFactory).parseAccessJwtToken(eq("ABC123"));
    Collection<? extends GrantedAuthority> authorities2 = actualAuthenticateResult.getAuthorities();
    assertTrue(authorities2 instanceof List);
    assertTrue(actualAuthenticateResult instanceof JwtAuthenticationToken);
    assertNull(actualAuthenticateResult.getCredentials());
    assertNull(actualAuthenticateResult.getDetails());
    assertTrue(authorities2.isEmpty());
    assertTrue(actualAuthenticateResult.isAuthenticated());
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with {@code authentication}.
   * <ul>
   *   <li>Then throw {@link JwtExpiredTokenException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'; then throw JwtExpiredTokenException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication JwtAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticateWithAuthentication_thenThrowJwtExpiredTokenException() throws AuthenticationException {
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
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with {@code authentication}.
   * <ul>
   *   <li>When {@link RawAccessJwtToken#RawAccessJwtToken(String)} with token is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'; when RawAccessJwtToken(String) with token is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication JwtAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticateWithAuthentication_whenRawAccessJwtTokenWithTokenIsEmptyString() throws AuthenticationException {
    // Arrange
    RawAccessJwtToken rawAccessJwtToken = new RawAccessJwtToken("");
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    Class<Authentication> originalAuthentication = Authentication.class;

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider
        .authenticate(new RunAsUserToken("Key", "Principal", rawAccessJwtToken, authorities, originalAuthentication)));
  }

  /**
   * Test {@link JwtAuthenticationProvider#authenticate(Authentication)} with {@code authentication}.
   * <ul>
   *   <li>When {@link RawAccessJwtToken#RawAccessJwtToken(String)} with token is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#authenticate(Authentication)}
   */
  @Test
  @DisplayName("Test authenticate(Authentication) with 'authentication'; when RawAccessJwtToken(String) with token is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Authentication JwtAuthenticationProvider.authenticate(Authentication)"})
  void testAuthenticateWithAuthentication_whenRawAccessJwtTokenWithTokenIsNull() throws AuthenticationException {
    // Arrange
    RawAccessJwtToken rawAccessJwtToken = new RawAccessJwtToken(null);
    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
    Class<Authentication> originalAuthentication = Authentication.class;

    // Act and Assert
    assertThrows(BadCredentialsException.class, () -> jwtAuthenticationProvider
        .authenticate(new RunAsUserToken("Key", "Principal", rawAccessJwtToken, authorities, originalAuthentication)));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtAuthenticationProvider.supports(Class)"})
  void testSupports_thenReturnTrue() {
    // Arrange
    Class<JwtAuthenticationToken> authentication = JwtAuthenticationToken.class;

    // Act and Assert
    assertTrue(jwtAuthenticationProvider.supports(authentication));
  }

  /**
   * Test {@link JwtAuthenticationProvider#supports(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtAuthenticationProvider#supports(Class)}
   */
  @Test
  @DisplayName("Test supports(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JwtAuthenticationProvider.supports(Class)"})
  void testSupports_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    Class<Object> authentication = Object.class;

    // Act and Assert
    assertFalse(jwtAuthenticationProvider.supports(authentication));
  }
}
