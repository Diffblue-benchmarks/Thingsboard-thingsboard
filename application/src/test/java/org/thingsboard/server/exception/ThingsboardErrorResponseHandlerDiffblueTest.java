package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponseWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;

@ContextConfiguration(classes = {ThingsboardErrorResponseHandler.class})
@ExtendWith(SpringExtension.class)
class ThingsboardErrorResponseHandlerDiffblueTest {
  @Autowired
  private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link ThingsboardErrorResponseHandler#handleError(HttpServletRequest)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   *   <li>Then StatusCode return {@link HttpStatus}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handleError(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test handleError(HttpServletRequest); when MockHttpServletRequest(); then StatusCode return HttpStatus")
  void testHandleError_whenMockHttpServletRequest_thenStatusCodeReturnHttpStatus() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThingsboardErrorResponseHandler thingsboardErrorResponseHandler = new ThingsboardErrorResponseHandler();

    // Act
    ResponseEntity<Object> actualHandleErrorResult = thingsboardErrorResponseHandler
        .handleError(new MockHttpServletRequest());

    // Assert
    HttpStatusCode statusCode = actualHandleErrorResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    Object body = actualHandleErrorResult.getBody();
    assertTrue(body instanceof ThingsboardErrorResponse);
    assertEquals("Internal Server Error", ((ThingsboardErrorResponse) body).getMessage());
    assertEquals(500, ((ThingsboardErrorResponse) body).getStatus().intValue());
    assertEquals(500, actualHandleErrorResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertEquals(ThingsboardErrorCode.GENERAL, ((ThingsboardErrorResponse) body).getErrorCode());
    assertTrue(actualHandleErrorResult.hasBody());
    assertTrue(actualHandleErrorResult.getHeaders().isEmpty());
  }

  /**
   * Test
   * {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)}
   * with {@code exception}, {@code response}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handle(Exception, HttpServletResponse) with 'exception', 'response'; given 'true'")
  void testHandleWithExceptionResponse_givenTrue() {
    // Arrange
    Exception exception = new Exception("foo");
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.isCommitted()).thenReturn(true);

    // Act
    thingsboardErrorResponseHandler.handle(exception, response);

    // Assert that nothing has changed
    verify(response).isCommitted();
  }

  /**
   * Test
   * {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)}
   * with {@code exception}, {@code response}.
   * <ul>
   *   <li>Then calls {@link ServletResponseWrapper#getWriter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test handle(Exception, HttpServletResponse) with 'exception', 'response'; then calls getWriter()")
  void testHandleWithExceptionResponse_thenCallsGetWriter() throws IOException {
    // Arrange
    Exception exception = new Exception("foo");
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.isCommitted()).thenReturn(false);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));
    doNothing().when(response).setContentType(Mockito.<String>any());
    doNothing().when(response).setStatus(anyInt());

    // Act
    thingsboardErrorResponseHandler.handle(exception, response);

    // Assert
    verify(response).getWriter();
    verify(response).isCommitted();
    verify(response).setContentType(eq("application/json"));
    verify(response).setStatus(eq(500));
  }

  /**
   * Test
   * {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)}
   * with {@code request}, {@code response}, {@code accessDeniedException}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link ServletResponseWrapper#getWriter()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)}
   */
  @Test
  @DisplayName("Test handle(HttpServletRequest, HttpServletResponse, AccessDeniedException) with 'request', 'response', 'accessDeniedException'; given 'false'; then calls getWriter()")
  void testHandleWithRequestResponseAccessDeniedException_givenFalse_thenCallsGetWriter()
      throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.isCommitted()).thenReturn(false);
    when(response.getWriter()).thenReturn(new PrintWriter(new StringWriter()));
    doNothing().when(response).setContentType(Mockito.<String>any());
    doNothing().when(response).setStatus(anyInt());

    // Act
    thingsboardErrorResponseHandler.handle(request, response, new AccessDeniedException("Msg"));

    // Assert
    verify(response).getWriter();
    verify(response).isCommitted();
    verify(response).setContentType(eq("application/json"));
    verify(response).setStatus(eq(403));
  }

  /**
   * Test
   * {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)}
   * with {@code request}, {@code response}, {@code accessDeniedException}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)}
   */
  @Test
  @DisplayName("Test handle(HttpServletRequest, HttpServletResponse, AccessDeniedException) with 'request', 'response', 'accessDeniedException'; given 'true'")
  void testHandleWithRequestResponseAccessDeniedException_givenTrue() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.isCommitted()).thenReturn(true);

    // Act
    thingsboardErrorResponseHandler.handle(request, response, new AccessDeniedException("Msg"));

    // Assert that nothing has changed
    verify(response).isCommitted();
  }

  /**
   * Test
   * {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)}.
   * <ul>
   *   <li>Then Body return {@link ThingsboardErrorResponse}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)}
   */
  @Test
  @DisplayName("Test handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest); then Body return ThingsboardErrorResponse")
  void testHandleExceptionInternal_thenBodyReturnThingsboardErrorResponse() {
    // Arrange
    Exception ex = new Exception("foo");
    HttpHeaders headers = new HttpHeaders();
    HttpStatusCode statusCode = HttpStatusCode.valueOf(200);

    // Act
    ResponseEntity<Object> actualHandleExceptionInternalResult = thingsboardErrorResponseHandler
        .handleExceptionInternal(ex, "Body", headers, statusCode, new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    Object body = actualHandleExceptionInternalResult.getBody();
    assertTrue(body instanceof ThingsboardErrorResponse);
    assertEquals("foo", ((ThingsboardErrorResponse) body).getMessage());
    assertEquals(200, ((ThingsboardErrorResponse) body).getStatus().intValue());
    assertEquals(200, actualHandleExceptionInternalResult.getStatusCodeValue());
    assertEquals(ThingsboardErrorCode.GENERAL, ((ThingsboardErrorResponse) body).getErrorCode());
    assertTrue(actualHandleExceptionInternalResult.hasBody());
    assertEquals(headers, actualHandleExceptionInternalResult.getHeaders());
    assertSame(statusCode, actualHandleExceptionInternalResult.getStatusCode());
  }

  /**
   * Test
   * {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)}.
   * <ul>
   *   <li>When {@link ServletWebRequest#ServletWebRequest(HttpServletRequest)} with
   * request is {@link HttpServletRequest}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)}
   */
  @Test
  @DisplayName("Test handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest); when ServletWebRequest(HttpServletRequest) with request is HttpServletRequest")
  void testHandleExceptionInternal_whenServletWebRequestWithRequestIsHttpServletRequest() {
    // Arrange
    Exception ex = new Exception("foo");
    HttpHeaders headers = new HttpHeaders();
    HttpStatusCode statusCode = HttpStatusCode.valueOf(200);

    // Act
    ResponseEntity<Object> actualHandleExceptionInternalResult = thingsboardErrorResponseHandler
        .handleExceptionInternal(ex, "Body", headers, statusCode,
            new ServletWebRequest(mock(HttpServletRequest.class)));

    // Assert
    Object body = actualHandleExceptionInternalResult.getBody();
    assertTrue(body instanceof ThingsboardErrorResponse);
    assertEquals("foo", ((ThingsboardErrorResponse) body).getMessage());
    assertEquals(200, ((ThingsboardErrorResponse) body).getStatus().intValue());
    assertEquals(200, actualHandleExceptionInternalResult.getStatusCodeValue());
    assertEquals(ThingsboardErrorCode.GENERAL, ((ThingsboardErrorResponse) body).getErrorCode());
    assertTrue(actualHandleExceptionInternalResult.hasBody());
    assertEquals(headers, actualHandleExceptionInternalResult.getHeaders());
    assertSame(statusCode, actualHandleExceptionInternalResult.getStatusCode());
  }
}
