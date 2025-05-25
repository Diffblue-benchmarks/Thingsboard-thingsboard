package org.thingsboard.server.service.security.auth.jwt;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.service.security.auth.JwtAuthenticationToken;
import org.thingsboard.server.service.security.auth.jwt.extractor.TokenExtractor;
import org.thingsboard.server.service.security.exception.AuthMethodNotSupportedException;
import org.thingsboard.server.service.security.model.SecurityUser;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class JwtTokenAuthenticationProcessingFilterDiffblueTest {
  @Mock
  private AuthenticationFailureHandler authenticationFailureHandler;

  @InjectMocks
  private JwtTokenAuthenticationProcessingFilter jwtTokenAuthenticationProcessingFilter;

  @Mock
  private RequestMatcher requestMatcher;

  @Mock
  private TokenExtractor tokenExtractor;

  /**
   * Test {@link JwtTokenAuthenticationProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then throw {@link AuthMethodNotSupportedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenAuthenticationProcessingFilter#attemptAuthentication(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test attemptAuthentication(HttpServletRequest, HttpServletResponse); then throw AuthMethodNotSupportedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Authentication JwtTokenAuthenticationProcessingFilter.attemptAuthentication(HttpServletRequest, HttpServletResponse)"})
  void testAttemptAuthentication_thenThrowAuthMethodNotSupportedException()
      throws ServletException, IOException, AuthenticationException {
    // Arrange
    when(tokenExtractor.extract(Mockito.<HttpServletRequest>any()))
        .thenThrow(new AuthMethodNotSupportedException("Msg"));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(AuthMethodNotSupportedException.class,
        () -> jwtTokenAuthenticationProcessingFilter.attemptAuthentication(request, new Response()));
    verify(tokenExtractor).extract(isA(HttpServletRequest.class));
  }

  /**
   * Test {@link JwtTokenAuthenticationProcessingFilter#successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenAuthenticationProcessingFilter#successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)}
   */
  @Test
  @DisplayName("Test successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication); given ArrayList(); then calls doFilter(ServletRequest, ServletResponse)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void JwtTokenAuthenticationProcessingFilter.successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)"})
  void testSuccessfulAuthentication_givenArrayList_thenCallsDoFilter() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    jwtTokenAuthenticationProcessingFilter.successfulAuthentication(request, response, chain,
        new JwtAuthenticationToken(securityUser));

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(securityUser).getAuthorities();
  }

  /**
   * Test {@link JwtTokenAuthenticationProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test: {@link JwtTokenAuthenticationProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void JwtTokenAuthenticationProcessingFilter.unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)"})
  void testUnsuccessfulAuthentication() throws ServletException, IOException {
    // Arrange
    doNothing().when(authenticationFailureHandler)
        .onAuthenticationFailure(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();

    // Act
    jwtTokenAuthenticationProcessingFilter.unsuccessfulAuthentication(request, response,
        new AuthMethodNotSupportedException("Msg"));

    // Assert
    verify(authenticationFailureHandler).onAuthenticationFailure(isA(HttpServletRequest.class),
        isA(HttpServletResponse.class), isA(AuthenticationException.class));
  }

  /**
   * Test {@link JwtTokenAuthenticationProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then throw {@link AuthMethodNotSupportedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JwtTokenAuthenticationProcessingFilter#unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException); then throw AuthMethodNotSupportedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void JwtTokenAuthenticationProcessingFilter.unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)"})
  void testUnsuccessfulAuthentication_thenThrowAuthMethodNotSupportedException() throws ServletException, IOException {
    // Arrange
    doThrow(new AuthMethodNotSupportedException("Msg")).when(authenticationFailureHandler)
        .onAuthenticationFailure(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();

    // Act and Assert
    assertThrows(AuthMethodNotSupportedException.class, () -> jwtTokenAuthenticationProcessingFilter
        .unsuccessfulAuthentication(request, response, new AuthMethodNotSupportedException("Msg")));
    verify(authenticationFailureHandler).onAuthenticationFailure(isA(HttpServletRequest.class),
        isA(HttpServletResponse.class), isA(AuthenticationException.class));
  }
}
