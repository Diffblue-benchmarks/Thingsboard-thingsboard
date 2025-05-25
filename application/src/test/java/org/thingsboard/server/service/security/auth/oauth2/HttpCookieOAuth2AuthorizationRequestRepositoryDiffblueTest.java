package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest.Builder;

class HttpCookieOAuth2AuthorizationRequestRepositoryDiffblueTest {
  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest HttpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(HttpServletRequest)"})
  void testLoadAuthorizationRequest() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertNull(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(request));
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest); then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest HttpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(HttpServletRequest)"})
  void testLoadAuthorizationRequest_thenCallsGetName() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    when(cookie.getValue()).thenReturn("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(cookie);

    // Act
    OAuth2AuthorizationRequest actualLoadAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .loadAuthorizationRequest(request);

    // Assert
    verify(cookie, atLeast(1)).getName();
    verify(cookie, atLeast(1)).getValue();
    assertNull(actualLoadAuthorizationRequestResult);
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest); when MockHttpServletRequest(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest HttpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(HttpServletRequest)"})
  void testLoadAuthorizationRequest_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();

    // Act and Assert
    assertNull(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(new MockHttpServletRequest()));
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void HttpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)"})
  void testSaveAuthorizationRequest_givenNull() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Builder redirectUriResult = OAuth2AuthorizationRequest.authorizationCode()
        .authorizationRequestUri("JaneDoe")
        .authorizationRequestUri(mock(Function.class))
        .authorizationUri("JaneDoe")
        .clientId("42")
        .parameters(mock(Consumer.class))
        .redirectUri("Redirect Uri");
    OAuth2AuthorizationRequest authorizationRequest = redirectUriResult.scopes(new HashSet<>()).state("MD").build();
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(null);
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    doNothing().when(response).addCookie(Mockito.<Cookie>any());

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(authorizationRequest, request, response);

    // Assert
    verify(request).getParameter(eq("prevUri"));
    verify(response).addCookie(isA(Cookie.class));
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code Parameter}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse); given 'Parameter'; then calls getParameter(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void HttpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)"})
  void testSaveAuthorizationRequest_givenParameter_thenCallsGetParameter() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Builder redirectUriResult = OAuth2AuthorizationRequest.authorizationCode()
        .authorizationRequestUri("JaneDoe")
        .authorizationRequestUri(mock(Function.class))
        .authorizationUri("JaneDoe")
        .clientId("42")
        .parameters(mock(Consumer.class))
        .redirectUri("Redirect Uri");
    OAuth2AuthorizationRequest authorizationRequest = redirectUriResult.scopes(new HashSet<>()).state("MD").build();
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    doNothing().when(response).addCookie(Mockito.<Cookie>any());

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(authorizationRequest, request, response);

    // Assert
    verify(request, atLeast(1)).getParameter(eq("prevUri"));
    verify(response, atLeast(1)).addCookie(Mockito.<Cookie>any());
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse); then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void HttpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)"})
  void testSaveAuthorizationRequest_thenCallsGetName() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    when(cookie.getValue()).thenReturn("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(cookie);

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(null, request, new Response());

    // Assert
    verify(cookie, atLeast(1)).getName();
    verify(cookie, atLeast(1)).getValue();
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest HttpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)"})
  void testRemoveAuthorizationRequest() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(new Cookie("Name", "https://example.org/example"));

    // Act and Assert
    assertNull(httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequest(request, new Response()));
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse); then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest HttpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)"})
  void testRemoveAuthorizationRequest_thenCallsGetName() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    when(cookie.getValue()).thenReturn("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(cookie);

    // Act
    OAuth2AuthorizationRequest actualRemoveAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .removeAuthorizationRequest(request, new Response());

    // Assert
    verify(cookie, atLeast(1)).getName();
    verify(cookie, atLeast(1)).getValue();
    assertNull(actualRemoveAuthorizationRequestResult);
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse); when MockHttpServletRequest(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "OAuth2AuthorizationRequest HttpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)"})
  void testRemoveAuthorizationRequest_whenMockHttpServletRequest_thenReturnNull() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertNull(httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequest(request, new Response()));
  }

  /**
   * Test {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse); then calls getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void HttpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)"})
  void testRemoveAuthorizationRequestCookies_thenCallsGetName() {
    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    when(cookie.getValue()).thenReturn("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(cookie);

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, new Response());

    // Assert
    verify(cookie, atLeast(1)).getName();
    verify(cookie, atLeast(1)).getValue();
  }
}
