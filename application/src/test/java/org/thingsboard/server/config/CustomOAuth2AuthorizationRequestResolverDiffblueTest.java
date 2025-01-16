package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletRequestWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

class CustomOAuth2AuthorizationRequestResolverDiffblueTest {
  /**
   * Test
   * {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   * with {@code request}, {@code registrationId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest, String)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest, String) with 'request', 'registrationId'; then return 'null'")
  void testResolveWithRequestRegistrationId_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CustomOAuth2AuthorizationRequestResolver()).resolve(mock(HttpServletRequestWrapper.class), null));
  }

  /**
   * Test
   * {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   * with {@code request}.
   * <ul>
   *   <li>Given {@code Parameter}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest) with 'request'; given 'Parameter'; then calls getParameter(String)")
  void testResolveWithRequest_givenParameter_thenCallsGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver = new CustomOAuth2AuthorizationRequestResolver();
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    when(request.getPathInfo()).thenReturn("https://example.org/example");
    when(request.getServletPath()).thenReturn("https://example.org/example");

    // Act
    OAuth2AuthorizationRequest actualResolveResult = customOAuth2AuthorizationRequestResolver.resolve(request);

    // Assert
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    verify(request).getPathInfo();
    verify(request).getServletPath();
    assertNull(actualResolveResult);
  }

  /**
   * Test
   * {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   * with {@code request}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomOAuth2AuthorizationRequestResolver#resolve(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test resolve(HttpServletRequest) with 'request'; when MockHttpServletRequest(); then return 'null'")
  void testResolveWithRequest_whenMockHttpServletRequest_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomOAuth2AuthorizationRequestResolver customOAuth2AuthorizationRequestResolver = new CustomOAuth2AuthorizationRequestResolver();

    // Act and Assert
    assertNull(customOAuth2AuthorizationRequestResolver.resolve(new MockHttpServletRequest()));
  }
}
