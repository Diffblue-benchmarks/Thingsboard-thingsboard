package org.thingsboard.server.service.security.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.web.util.UriBuilder;

class HttpCookieOAuth2AuthorizationRequestRepositoryDiffblueTest {
  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest)")
  void testLoadAuthorizationRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("Name", "https://example.org/example")});

    // Act
    OAuth2AuthorizationRequest actualLoadAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .loadAuthorizationRequest(request);

    // Assert
    verify(request).getCookies();
    assertNull(actualLoadAuthorizationRequestResult);
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Given empty array of {@link Cookie}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest); given empty array of Cookie")
  void testLoadAuthorizationRequest_givenEmptyArrayOfCookie() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{});

    // Act
    OAuth2AuthorizationRequest actualLoadAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .loadAuthorizationRequest(request);

    // Assert
    verify(request).getCookies();
    assertNull(actualLoadAuthorizationRequestResult);
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest); then calls getName()")
  void testLoadAuthorizationRequest_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});

    // Act
    OAuth2AuthorizationRequest actualLoadAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .loadAuthorizationRequest(request);

    // Assert
    verify(cookie).getName();
    verify(request).getCookies();
    assertNull(actualLoadAuthorizationRequestResult);
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#loadAuthorizationRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test loadAuthorizationRequest(HttpServletRequest); when MockHttpServletRequest(); then return 'null'")
  void testLoadAuthorizationRequest_whenMockHttpServletRequest_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();

    // Act and Assert
    assertNull(httpCookieOAuth2AuthorizationRequestRepository.loadAuthorizationRequest(new MockHttpServletRequest()));
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse); then calls getName()")
  void testSaveAuthorizationRequest_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    when(cookie.getValue()).thenReturn("https://example.org/example");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setCookies(cookie);

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.saveAuthorizationRequest(null, request, new Response());

    // Assert that nothing has changed
    verify(cookie, atLeast(1)).getName();
    verify(cookie, atLeast(1)).getValue();
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link ServletRequestWrapper#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test saveAuthorizationRequest(OAuth2AuthorizationRequest, HttpServletRequest, HttpServletResponse); then calls getParameter(String)")
  void testSaveAuthorizationRequest_thenCallsGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    OAuth2AuthorizationRequest.Builder redirectUriResult = OAuth2AuthorizationRequest.authorizationCode()
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
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)")
  void testRemoveAuthorizationRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("Name", "https://example.org/example")});

    // Act
    OAuth2AuthorizationRequest actualRemoveAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .removeAuthorizationRequest(request, new Response());

    // Assert
    verify(request).getCookies();
    assertNull(actualRemoveAuthorizationRequestResult);
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given empty array of {@link Cookie}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse); given empty array of Cookie")
  void testRemoveAuthorizationRequest_givenEmptyArrayOfCookie() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{});

    // Act
    OAuth2AuthorizationRequest actualRemoveAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .removeAuthorizationRequest(request, new Response());

    // Assert
    verify(request).getCookies();
    assertNull(actualRemoveAuthorizationRequestResult);
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link Cookie#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse); then calls getName()")
  void testRemoveAuthorizationRequest_thenCallsGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    HttpServletRequest request = mock(HttpServletRequest.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});

    // Act
    OAuth2AuthorizationRequest actualRemoveAuthorizationRequestResult = httpCookieOAuth2AuthorizationRequestRepository
        .removeAuthorizationRequest(request, new Response());

    // Assert
    verify(cookie).getName();
    verify(request).getCookies();
    assertNull(actualRemoveAuthorizationRequestResult);
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequest(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequest(HttpServletRequest, HttpServletResponse); when MockHttpServletRequest(); then return 'null'")
  void testRemoveAuthorizationRequest_whenMockHttpServletRequest_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertNull(httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequest(request, new Response()));
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)")
  void testRemoveAuthorizationRequestCookies() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{new Cookie("Name", "https://example.org/example")});

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, new Response());

    // Assert that nothing has changed
    verify(request).getCookies();
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)")
  void testRemoveAuthorizationRequestCookies2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    when(cookie.getName()).thenReturn("https://example.org/example");
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, new Response());

    // Assert that nothing has changed
    verify(cookie).getName();
    verify(request).getCookies();
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given empty array of {@link Cookie}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse); given empty array of Cookie")
  void testRemoveAuthorizationRequestCookies_givenEmptyArrayOfCookie() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{});

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, new Response());

    // Assert that nothing has changed
    verify(request).getCookies();
  }

  /**
   * Test
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then calls {@link Cookie#setMaxAge(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HttpCookieOAuth2AuthorizationRequestRepository#removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test removeAuthorizationRequestCookies(HttpServletRequest, HttpServletResponse); then calls setMaxAge(int)")
  void testRemoveAuthorizationRequestCookies_thenCallsSetMaxAge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository = new HttpCookieOAuth2AuthorizationRequestRepository();
    Cookie cookie = mock(Cookie.class);
    doNothing().when(cookie).setMaxAge(anyInt());
    doNothing().when(cookie).setPath(Mockito.<String>any());
    doNothing().when(cookie).setValue(Mockito.<String>any());
    when(cookie.getName())
        .thenReturn(HttpCookieOAuth2AuthorizationRequestRepository.OAUTH2_AUTHORIZATION_REQUEST_COOKIE_NAME);
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getCookies()).thenReturn(new Cookie[]{cookie});
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    doNothing().when(response).addCookie(Mockito.<Cookie>any());

    // Act
    httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);

    // Assert that nothing has changed
    verify(cookie).getName();
    verify(cookie).setMaxAge(eq(0));
    verify(cookie).setPath(eq("/"));
    verify(cookie).setValue(eq(""));
    verify(request).getCookies();
    verify(response).addCookie(isA(Cookie.class));
  }
}
