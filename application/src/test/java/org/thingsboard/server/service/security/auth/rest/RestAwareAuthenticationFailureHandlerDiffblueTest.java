package org.thingsboard.server.service.security.auth.rest;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.AuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.exception.AuthMethodNotSupportedException;

@ContextConfiguration(classes = {RestAwareAuthenticationFailureHandler.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class RestAwareAuthenticationFailureHandlerDiffblueTest {
  @Autowired
  private RestAwareAuthenticationFailureHandler restAwareAuthenticationFailureHandler;

  @MockBean
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link RestAwareAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test: {@link RestAwareAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  @DisplayName("Test onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void RestAwareAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"})
  void testOnAuthenticationFailure() throws ServletException, IOException {
    // Arrange
    doNothing().when(thingsboardErrorResponseHandler)
        .handle(Mockito.<Exception>any(), Mockito.<HttpServletResponse>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    Response response = new Response();

    // Act
    restAwareAuthenticationFailureHandler.onAuthenticationFailure(request, response,
        new AuthMethodNotSupportedException("Msg"));

    // Assert
    verify(thingsboardErrorResponseHandler).handle(isA(Exception.class), isA(HttpServletResponse.class));
  }
}
