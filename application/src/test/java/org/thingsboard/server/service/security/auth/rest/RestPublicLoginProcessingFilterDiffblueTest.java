package org.thingsboard.server.service.security.auth.rest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.settings.JpaAdminSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.auth.JwtAuthenticationToken;
import org.thingsboard.server.service.security.auth.jwt.settings.DefaultJwtSettingsService;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsValidator;
import org.thingsboard.server.service.security.auth.mfa.config.DefaultTwoFaConfigManager;
import org.thingsboard.server.service.security.exception.AuthMethodNotSupportedException;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;

class RestPublicLoginProcessingFilterDiffblueTest {
  /**
   * Test
   * {@link RestPublicLoginProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link RestPublicLoginProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test attemptAuthentication(HttpServletRequest, HttpServletResponse)")
  void testAttemptAuthentication() throws ServletException, IOException, AuthenticationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    Optional<TbClusterService> tbClusterService = Optional.empty();
    JwtSettingsValidator jwtSettingsValidator = mock(JwtSettingsValidator.class);
    Optional<JwtTokenFactory> jwtTokenFactory = Optional.empty();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(
        new DefaultJwtSettingsService(adminSettingsService, tbClusterService, jwtSettingsValidator, jwtTokenFactory));
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    RestAwareAuthenticationSuccessHandler successHandler = new RestAwareAuthenticationSuccessHandler(tokenFactory,
        new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService2, new JpaAdminSettingsDao()));

    RestPublicLoginProcessingFilter restPublicLoginProcessingFilter = new RestPublicLoginProcessingFilter(
        "https://example.org/example", successHandler,
        new RestAwareAuthenticationFailureHandler(new ThingsboardErrorResponseHandler()));
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest(new MockServletContext());

    // Act and Assert
    assertThrows(AuthenticationServiceException.class,
        () -> restPublicLoginProcessingFilter.attemptAuthentication(request, new Response()));
  }

  /**
   * Test
   * {@link RestPublicLoginProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then throw {@link AuthMethodNotSupportedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestPublicLoginProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test attemptAuthentication(HttpServletRequest, HttpServletResponse); then throw AuthMethodNotSupportedException")
  void testAttemptAuthentication_thenThrowAuthMethodNotSupportedException()
      throws ServletException, IOException, AuthenticationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    Optional<TbClusterService> tbClusterService = Optional.empty();
    JwtSettingsValidator jwtSettingsValidator = mock(JwtSettingsValidator.class);
    Optional<JwtTokenFactory> jwtTokenFactory = Optional.empty();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(
        new DefaultJwtSettingsService(adminSettingsService, tbClusterService, jwtSettingsValidator, jwtTokenFactory));
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    RestAwareAuthenticationSuccessHandler successHandler = new RestAwareAuthenticationSuccessHandler(tokenFactory,
        new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService2, new JpaAdminSettingsDao()));

    RestPublicLoginProcessingFilter restPublicLoginProcessingFilter = new RestPublicLoginProcessingFilter(
        "https://example.org/example", successHandler,
        new RestAwareAuthenticationFailureHandler(new ThingsboardErrorResponseHandler()));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(AuthMethodNotSupportedException.class,
        () -> restPublicLoginProcessingFilter.attemptAuthentication(request, new Response()));
  }

  /**
   * Test
   * {@link RestPublicLoginProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When
   * {@link MockMultipartHttpServletRequest#MockMultipartHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestPublicLoginProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test attemptAuthentication(HttpServletRequest, HttpServletResponse); when MockMultipartHttpServletRequest()")
  void testAttemptAuthentication_whenMockMultipartHttpServletRequest()
      throws ServletException, IOException, AuthenticationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    Optional<TbClusterService> tbClusterService = Optional.empty();
    JwtSettingsValidator jwtSettingsValidator = mock(JwtSettingsValidator.class);
    Optional<JwtTokenFactory> jwtTokenFactory = Optional.empty();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(
        new DefaultJwtSettingsService(adminSettingsService, tbClusterService, jwtSettingsValidator, jwtTokenFactory));
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    RestAwareAuthenticationSuccessHandler successHandler = new RestAwareAuthenticationSuccessHandler(tokenFactory,
        new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService2, new JpaAdminSettingsDao()));

    RestPublicLoginProcessingFilter restPublicLoginProcessingFilter = new RestPublicLoginProcessingFilter(
        "https://example.org/example", successHandler,
        new RestAwareAuthenticationFailureHandler(new ThingsboardErrorResponseHandler()));
    MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();

    // Act and Assert
    assertThrows(AuthenticationServiceException.class,
        () -> restPublicLoginProcessingFilter.attemptAuthentication(request, new Response()));
  }

  /**
   * Test
   * {@link RestPublicLoginProcessingFilter#successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)}.
   * <ul>
   *   <li>Then calls
   * {@link RestAwareAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestPublicLoginProcessingFilter#successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)}
   */
  @Test
  @DisplayName("Test successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication); then calls onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)")
  void testSuccessfulAuthentication_thenCallsOnAuthenticationSuccess() throws ServletException, IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new AuthenticationServiceException("Executing getJwtSettings");
    RestAwareAuthenticationSuccessHandler successHandler = mock(RestAwareAuthenticationSuccessHandler.class);
    doNothing().when(successHandler)
        .onAuthenticationSuccess(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any(),
            Mockito.<Authentication>any());
    RestPublicLoginProcessingFilter restPublicLoginProcessingFilter = new RestPublicLoginProcessingFilter(
        "https://example.org/example", successHandler,
        new RestAwareAuthenticationFailureHandler(new ThingsboardErrorResponseHandler()));
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    FilterChain chain = mock(FilterChain.class);
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    restPublicLoginProcessingFilter.successfulAuthentication(request, response, chain,
        new JwtAuthenticationToken(securityUser));

    // Assert that nothing has changed
    verify(successHandler).onAuthenticationSuccess(isA(HttpServletRequest.class), isA(HttpServletResponse.class),
        isA(Authentication.class));
    verify(securityUser).getAuthorities();
  }

  /**
   * Test
   * {@link RestPublicLoginProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then calls
   * {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestPublicLoginProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException); then calls handle(Exception, HttpServletResponse)")
  void testUnsuccessfulAuthentication_thenCallsHandle() throws ServletException, IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThingsboardErrorResponseHandler errorResponseHandler = mock(ThingsboardErrorResponseHandler.class);
    doNothing().when(errorResponseHandler).handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    RestAwareAuthenticationFailureHandler failureHandler = new RestAwareAuthenticationFailureHandler(
        errorResponseHandler);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    Optional<TbClusterService> tbClusterService = Optional.empty();
    JwtSettingsValidator jwtSettingsValidator = mock(JwtSettingsValidator.class);
    Optional<JwtTokenFactory> jwtTokenFactory = Optional.empty();
    JwtTokenFactory tokenFactory = new JwtTokenFactory(
        new DefaultJwtSettingsService(adminSettingsService, tbClusterService, jwtSettingsValidator, jwtTokenFactory));
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    RestPublicLoginProcessingFilter restPublicLoginProcessingFilter = new RestPublicLoginProcessingFilter(
        "https://example.org/example",
        new RestAwareAuthenticationSuccessHandler(tokenFactory,
            new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService2, new JpaAdminSettingsDao())),
        failureHandler);
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();

    // Act
    restPublicLoginProcessingFilter.unsuccessfulAuthentication(request, response,
        new AuthMethodNotSupportedException("Msg"));

    // Assert
    verify(errorResponseHandler).handle(isA(Exception.class), isA(HttpServletResponse.class));
  }
}
