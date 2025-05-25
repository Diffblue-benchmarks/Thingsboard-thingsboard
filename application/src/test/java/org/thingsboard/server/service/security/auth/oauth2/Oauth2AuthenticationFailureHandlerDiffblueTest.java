package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest.Builder;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.service.security.exception.AuthMethodNotSupportedException;
import org.thingsboard.server.service.security.system.SystemSecurityService;

@ExtendWith(MockitoExtension.class)
class Oauth2AuthenticationFailureHandlerDiffblueTest {
  @Mock
  private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

  @InjectMocks
  private Oauth2AuthenticationFailureHandler oauth2AuthenticationFailureHandler;

  @Mock
  private SystemSecurityService systemSecurityService;

  /**
   * Test {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test: {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void Oauth2AuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"})
  void testOnAuthenticationFailure() throws ServletException, IOException {
    // Arrange
    Builder redirectUriResult = OAuth2AuthorizationRequest.authorizationCode()
        .authorizationRequestUri("JaneDoe")
        .authorizationRequestUri(mock(Function.class))
        .authorizationUri("JaneDoe")
        .clientId("42")
        .parameters(mock(Consumer.class))
        .redirectUri("Redirect Uri");
    OAuth2AuthorizationRequest buildResult = redirectUriResult.scopes(new HashSet<>()).state("MD").build();
    when(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(Mockito.<HttpServletRequest>any()))
        .thenReturn(buildResult);
    when(systemSecurityService.getBaseUrl(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<HttpServletRequest>any())).thenThrow(new AuthMethodNotSupportedException("U://U"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();

    // Act and Assert
    assertThrows(AuthMethodNotSupportedException.class, () -> oauth2AuthenticationFailureHandler
        .onAuthenticationFailure(request, response, new AuthMethodNotSupportedException("Msg")));
    verify(httpCookieOAuth2AuthorizationRequestRepository).loadAuthorizationRequest(isA(HttpServletRequest.class));
    verify(systemSecurityService).getBaseUrl(isA(TenantId.class), isA(CustomerId.class), isA(HttpServletRequest.class));
  }

  /**
   * Test {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test: {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void Oauth2AuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"})
  void testOnAuthenticationFailure2() throws ServletException, IOException {
    // Arrange
    when(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(Mockito.<HttpServletRequest>any()))
        .thenThrow(new AuthMethodNotSupportedException("U://U"));

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(null);
    Response response = new Response();

    // Act and Assert
    assertThrows(AuthMethodNotSupportedException.class, () -> oauth2AuthenticationFailureHandler
        .onAuthenticationFailure(request, response, new AuthMethodNotSupportedException("Msg")));
    verify(httpCookieOAuth2AuthorizationRequestRepository).loadAuthorizationRequest(isA(HttpServletRequest.class));
  }

  /**
   * Test {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Oauth2AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException); then MockHttpServletResponse (default constructor) HeaderNames size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void Oauth2AuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"})
  void testOnAuthenticationFailure_thenMockHttpServletResponseHeaderNamesSizeIsOne()
      throws ServletException, IOException {
    // Arrange
    Builder redirectUriResult = OAuth2AuthorizationRequest.authorizationCode()
        .authorizationRequestUri("JaneDoe")
        .authorizationRequestUri(mock(Function.class))
        .authorizationUri("JaneDoe")
        .clientId("42")
        .parameters(mock(Consumer.class))
        .redirectUri("Redirect Uri");
    OAuth2AuthorizationRequest buildResult = redirectUriResult.scopes(new HashSet<>()).state("MD").build();
    when(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(Mockito.<HttpServletRequest>any()))
        .thenReturn(buildResult);
    doNothing().when(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any());
    when(systemSecurityService.getBaseUrl(Mockito.<TenantId>any(), Mockito.<CustomerId>any(),
        Mockito.<HttpServletRequest>any())).thenReturn("https://example.org/example");
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
