package org.thingsboard.server.service.security.auth.rest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.security.model.JwtPair;
import org.thingsboard.server.service.security.auth.JwtAuthenticationToken;
import org.thingsboard.server.service.security.auth.mfa.config.TwoFaConfigManager;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;

@ContextConfiguration(classes = {RestAwareAuthenticationSuccessHandler.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RestAwareAuthenticationSuccessHandlerDiffblueTest {
  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @Autowired
  private RestAwareAuthenticationSuccessHandler restAwareAuthenticationSuccessHandler;

  @MockBean
  private TwoFaConfigManager twoFaConfigManager;

  /**
   * Test
   * {@link RestAwareAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   * with {@code request}, {@code response}, {@code authentication}.
   * <ul>
   *   <li>Then calls {@link HttpServletRequestWrapper#getSession(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestAwareAuthenticationSuccessHandler#onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test onAuthenticationSuccess(HttpServletRequest, HttpServletResponse, Authentication) with 'request', 'response', 'authentication'; then calls getSession(boolean)")
  void testOnAuthenticationSuccessWithRequestResponseAuthentication_thenCallsGetSession()
      throws ServletException, IOException {
    // Arrange
    when(jwtTokenFactory.createTokenPair(Mockito.<SecurityUser>any())).thenReturn(new JwtPair("ABC123", "ABC123"));
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());
    Response response = mock(Response.class);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));
    doNothing().when(response).setContentType(Mockito.<String>any());
    doNothing().when(response).setStatus(anyInt());
    doNothing().when(response).addDateHeader(Mockito.<String>any(), anyLong());
    response.addDateHeader("Name", 42L);
    SecurityUser securityUser = mock(SecurityUser.class);
    when(securityUser.getAuthorities()).thenReturn(new ArrayList<>());

    // Act
    restAwareAuthenticationSuccessHandler.onAuthenticationSuccess(request, response,
        new JwtAuthenticationToken(securityUser));

    // Assert
    verify(request).getSession(eq(false));
    verify(response).addDateHeader(eq("Name"), eq(42L));
    verify(response).getWriter();
    verify(response).setContentType(eq("application/json"));
    verify(response).setStatus(eq(200));
    verify(securityUser).getAuthorities();
    verify(jwtTokenFactory).createTokenPair(isA(SecurityUser.class));
  }

  /**
   * Test
   * {@link RestAwareAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.</li>
   *   <li>Then calls {@link HttpServletRequestWrapper#getSession(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RestAwareAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test clearAuthenticationAttributes(HttpServletRequest); given MockHttpSession(); then calls getSession(boolean)")
  void testClearAuthenticationAttributes_givenMockHttpSession_thenCallsGetSession() {
    // Arrange
    HttpServletRequestWrapper request = mock(HttpServletRequestWrapper.class);
    when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());

    // Act
    restAwareAuthenticationSuccessHandler.clearAuthenticationAttributes(request);

    // Assert
    verify(request).getSession(eq(false));
  }
}
