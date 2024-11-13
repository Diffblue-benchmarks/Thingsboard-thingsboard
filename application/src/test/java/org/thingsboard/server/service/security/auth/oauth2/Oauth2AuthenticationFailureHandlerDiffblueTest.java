package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.util.UriBuilder;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.security.exception.AuthMethodNotSupportedException;
import org.thingsboard.server.service.security.system.SystemSecurityService;

class Oauth2AuthenticationFailureHandlerDiffblueTest {
  /**
   * Test
   * {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException); then MockHttpServletResponse (default constructor) HeaderNames size is one")
  void testOnAuthenticationFailure_thenMockHttpServletResponseHeaderNamesSizeIsOne()
      throws ServletException, IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = mock(
        HttpCookieOAuth2AuthorizationRequestRepository.class);
    doNothing().when(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any());
    OAuth2AuthorizationRequest.Builder redirectUriResult = OAuth2AuthorizationRequest.authorizationCode()
        .authorizationRequestUri("JaneDoe")
        .authorizationRequestUri(mock(Function.class))
        .authorizationUri("JaneDoe")
        .clientId("42")
        .parameters(mock(Consumer.class))
        .redirectUri("Redirect Uri");
    OAuth2AuthorizationRequest buildResult = redirectUriResult.scopes(new HashSet<>()).state("MD").build();
    when(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(Mockito.<HttpServletRequest>any()))
        .thenReturn(buildResult);
    SystemSecurityService systemSecurityService = mock(SystemSecurityService.class);
    when(systemSecurityService.getBaseUrl(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<HttpServletRequest>any())).thenReturn("https://example.org/example");
    Oauth2AuthenticationFailureHandler oauth2AuthenticationFailureHandler = new Oauth2AuthenticationFailureHandler(
        httpCookieOAuth2AuthorizationRequestRepository, systemSecurityService);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    oauth2AuthenticationFailureHandler.onAuthenticationFailure(request, response,
        new AuthMethodNotSupportedException("Msg"));

    // Assert
    verify(httpCookieOAuth2AuthorizationRequestRepository).loadAuthorizationRequest(isA(HttpServletRequest.class));
    verify(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    verify(systemSecurityService).getBaseUrl(isA(TenantId.class), isA(CustomerId.class), isA(HttpServletRequest.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example/login?loginError=Msg", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }
}
