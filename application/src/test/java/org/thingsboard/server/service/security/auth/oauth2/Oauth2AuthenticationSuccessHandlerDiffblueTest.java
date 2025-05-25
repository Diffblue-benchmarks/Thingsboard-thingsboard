package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest.Builder;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.model.JwtPair;
import org.thingsboard.server.service.security.system.SystemSecurityService;

@ExtendWith(MockitoExtension.class)
class Oauth2AuthenticationSuccessHandlerDiffblueTest {
  @Mock
  private HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

  @InjectMocks
  private Oauth2AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler;

  @Mock
  private SystemSecurityService systemSecurityService;

  /**
   * Test {@link Oauth2AuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)} with {@code request}, {@code response}, {@code authentication}.
   * <p>
   * Method under test: {@link Oauth2AuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authentication'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void Oauth2AuthenticationSuccessHandler.onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)"})
  void testOnAuthenticationSuccessWithRequestResponseAuthentication() throws IOException {
    // Arrange
    doNothing().when(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any());
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
        Mockito.<HttpServletRequest>any())).thenReturn("https://example.org/example");
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    oauth2AuthenticationSuccessHandler.onAuthenticationSuccess(request, response, null);

    // Assert
    verify(httpCookieOAuth2AuthorizationRequestRepository).loadAuthorizationRequest(isA(HttpServletRequest.class));
    verify(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    verify(systemSecurityService).getBaseUrl(isA(TenantId.class), isA(CustomerId.class), isA(HttpServletRequest.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example/login?loginError=Cannot+invoke+%22org.springframework.security.oauth2"
        + ".client.authentication.OAuth2AuthenticationToken.getAuthorizedClientRegistrationId%28%29%22+because+"
        + "%22token%22+is+null", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link Oauth2AuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest, HttpServletResponse)} with {@code request}, {@code response}.
   * <p>
   * Method under test: {@link Oauth2AuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test clearAuthenticationAttributes(HttpServletRequest, HttpServletResponse) with 'request', 'response'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void Oauth2AuthenticationSuccessHandler.clearAuthenticationAttributes(HttpServletRequest, HttpServletResponse)"})
  void testClearAuthenticationAttributesWithRequestResponse() {
    // Arrange
    doNothing().when(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act
    oauth2AuthenticationSuccessHandler.clearAuthenticationAttributes(request, new Response());

    // Assert
    verify(httpCookieOAuth2AuthorizationRequestRepository)
        .removeAuthorizationRequestCookies(isA(HttpServletRequest.class), isA(HttpServletResponse.class));
  }

  /**
   * Test {@link Oauth2AuthenticationSuccessHandler#getRedirectUrl(String, JwtPair)}.
   * <p>
   * Method under test: {@link Oauth2AuthenticationSuccessHandler#getRedirectUrl(String, JwtPair)}
   */
  @Test
  @DisplayName("Test getRedirectUrl(String, JwtPair)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Oauth2AuthenticationSuccessHandler.getRedirectUrl(String, JwtPair)"})
  void testGetRedirectUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example/?accessToken=ABC123&refreshToken=ABC123",
        oauth2AuthenticationSuccessHandler.getRedirectUrl("https://example.org/example",
            new JwtPair("ABC123", "ABC123")));
  }
}
