package org.thingsboard.server.service.security.auth.rest;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.security.auth.mfa.config.TwoFaConfigManager;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;

@ContextConfiguration(classes = {RestAwareAuthenticationSuccessHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class RestAwareAuthenticationSuccessHandlerDiffblueTest {
  @MockBean
  private JwtTokenFactory jwtTokenFactory;

  @Autowired
  private RestAwareAuthenticationSuccessHandler restAwareAuthenticationSuccessHandler;

  @MockBean
  private TwoFaConfigManager twoFaConfigManager;

  /**
   * Test {@link RestAwareAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@link MockHttpSession#MockHttpSession()}.</li>
   *   <li>Then calls {@link HttpServletRequestWrapper#getSession(boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RestAwareAuthenticationSuccessHandler#clearAuthenticationAttributes(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test clearAuthenticationAttributes(HttpServletRequest); given MockHttpSession(); then calls getSession(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RestAwareAuthenticationSuccessHandler.clearAuthenticationAttributes(HttpServletRequest)"})
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
