package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.auth.jwt.extractor.TokenExtractor;
import org.thingsboard.server.service.security.auth.rest.RestAwareAuthenticationFailureHandler;
import org.thingsboard.server.service.security.exception.AuthMethodNotSupportedException;

class JwtTokenAuthenticationProcessingFilterDiffblueTest {
  /**
   * Test
   * {@link JwtTokenAuthenticationProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then throw {@link AuthMethodNotSupportedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtTokenAuthenticationProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test attemptAuthentication(HttpServletRequest, HttpServletResponse); then throw AuthMethodNotSupportedException")
  void testAttemptAuthentication_thenThrowAuthMethodNotSupportedException()
      throws ServletException, IOException, AuthenticationException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TokenExtractor tokenExtractor = mock(TokenExtractor.class);
    when(tokenExtractor.extract(Mockito.<HttpServletRequest>any()))
        .thenThrow(new AuthMethodNotSupportedException("Msg"));

    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    SkipPathRequestMatcher matcher = new SkipPathRequestMatcher(pathsToSkip, "Processing Path");

    JwtTokenAuthenticationProcessingFilter jwtTokenAuthenticationProcessingFilter = new JwtTokenAuthenticationProcessingFilter(
        new RestAwareAuthenticationFailureHandler(new ThingsboardErrorResponseHandler()), tokenExtractor, matcher);
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(AuthMethodNotSupportedException.class,
        () -> jwtTokenAuthenticationProcessingFilter.attemptAuthentication(request, new Response()));
    verify(tokenExtractor).extract(isA(HttpServletRequest.class));
  }

  /**
   * Test
   * {@link JwtTokenAuthenticationProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then calls
   * {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JwtTokenAuthenticationProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}
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

    ArrayList<String> pathsToSkip = new ArrayList<>();
    pathsToSkip.add("foo");
    JwtTokenAuthenticationProcessingFilter jwtTokenAuthenticationProcessingFilter = new JwtTokenAuthenticationProcessingFilter(
        failureHandler, mock(TokenExtractor.class), new SkipPathRequestMatcher(pathsToSkip, "Processing Path"));
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();

    // Act
    jwtTokenAuthenticationProcessingFilter.unsuccessfulAuthentication(request, response,
        new AuthMethodNotSupportedException("Msg"));

    // Assert
    verify(errorResponseHandler).handle(isA(Exception.class), isA(HttpServletResponse.class));
  }
}
