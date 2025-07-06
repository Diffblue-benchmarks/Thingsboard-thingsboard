package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;

@ContextConfiguration(classes = {ThingsboardErrorResponseHandler.class})
@ExtendWith(SpringExtension.class)
class ThingsboardErrorResponseHandlerDiffblueTest {
  @Autowired private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)} with {@code
   * exception}, {@code response}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handle(Exception,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test handle(Exception, HttpServletResponse) with 'exception', 'response'; given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ThingsboardErrorResponseHandler.handle(Exception, HttpServletResponse)"})
  void testHandleWithExceptionResponse_givenTrue() {
    // Arrange
    Exception exception = new Exception("foo");
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.isCommitted()).thenReturn(true);

    // Act
    thingsboardErrorResponseHandler.handle(exception, response);

    // Assert
    verify(response).isCommitted();
  }

  /**
   * Test {@link ThingsboardErrorResponseHandler#handle(Exception, HttpServletResponse)} with {@code
   * exception}, {@code response}.
   *
   * <ul>
   *   <li>Then calls {@link HttpServletResponseWrapper#getWriter()}.
   * </ul>
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handle(Exception,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test handle(Exception, HttpServletResponse) with 'exception', 'response'; then calls getWriter()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ThingsboardErrorResponseHandler.handle(Exception, HttpServletResponse)"})
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
   * Test {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest, HttpServletResponse,
   * AccessDeniedException)} with {@code request}, {@code response}, {@code accessDeniedException}.
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest,
   * HttpServletResponse, AccessDeniedException)}
   */
  @Test
  @DisplayName(
      "Test handle(HttpServletRequest, HttpServletResponse, AccessDeniedException) with 'request', 'response', 'accessDeniedException'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ThingsboardErrorResponseHandler.handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)"
  })
  void testHandleWithRequestResponseAccessDeniedException() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(false);

    // Act
    thingsboardErrorResponseHandler.handle(request, response, new AccessDeniedException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest, HttpServletResponse,
   * AccessDeniedException)} with {@code request}, {@code response}, {@code accessDeniedException}.
   *
   * <ul>
   *   <li>Then calls {@link HttpServletResponseWrapper#isCommitted()}.
   * </ul>
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest,
   * HttpServletResponse, AccessDeniedException)}
   */
  @Test
  @DisplayName(
      "Test handle(HttpServletRequest, HttpServletResponse, AccessDeniedException) with 'request', 'response', 'accessDeniedException'; then calls isCommitted()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void ThingsboardErrorResponseHandler.handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)"
  })
  void testHandleWithRequestResponseAccessDeniedException_thenCallsIsCommitted()
      throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpServletResponseWrapper response = mock(HttpServletResponseWrapper.class);
    when(response.isCommitted()).thenReturn(true);

    // Act
    thingsboardErrorResponseHandler.handle(request, response, new AccessDeniedException("Msg"));

    // Assert
    verify(response).isCommitted();
  }

  /**
   * Test {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception, Object,
   * HttpHeaders, HttpStatusCode, WebRequest)}.
   *
   * <ul>
   *   <li>Then return Body Status intValue is five hundred.
   * </ul>
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception,
   * Object, HttpHeaders, HttpStatusCode, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest); then return Body Status intValue is five hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity ThingsboardErrorResponseHandler.handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)"
  })
  void testHandleExceptionInternal_thenReturnBodyStatusIntValueIsFiveHundred() {
    // Arrange
    Exception ex = new Exception("foo");
    HttpHeaders headers = new HttpHeaders();

    // Act
    ResponseEntity<Object> actualHandleExceptionInternalResult =
        thingsboardErrorResponseHandler.handleExceptionInternal(
            ex,
            "Body",
            headers,
            HttpStatus.INTERNAL_SERVER_ERROR,
            new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    HttpStatusCode statusCode = actualHandleExceptionInternalResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    Object body = actualHandleExceptionInternalResult.getBody();
    assertTrue(body instanceof ThingsboardErrorResponse);
    assertEquals("foo", ((ThingsboardErrorResponse) body).getMessage());
    assertEquals(500, ((ThingsboardErrorResponse) body).getStatus().intValue());
    assertEquals(500, actualHandleExceptionInternalResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertEquals(ThingsboardErrorCode.GENERAL, ((ThingsboardErrorResponse) body).getErrorCode());
    assertTrue(actualHandleExceptionInternalResult.hasBody());
    assertEquals(headers, actualHandleExceptionInternalResult.getHeaders());
  }

  /**
   * Test {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception, Object,
   * HttpHeaders, HttpStatusCode, WebRequest)}.
   *
   * <ul>
   *   <li>When {@link HttpStatus#OK}.
   *   <li>Then return Body Status intValue is two hundred.
   * </ul>
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handleExceptionInternal(Exception,
   * Object, HttpHeaders, HttpStatusCode, WebRequest)}
   */
  @Test
  @DisplayName(
      "Test handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest); when OK; then return Body Status intValue is two hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ResponseEntity ThingsboardErrorResponseHandler.handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)"
  })
  void testHandleExceptionInternal_whenOk_thenReturnBodyStatusIntValueIsTwoHundred() {
    // Arrange
    Exception ex = new Exception("foo");
    HttpHeaders headers = new HttpHeaders();

    // Act
    ResponseEntity<Object> actualHandleExceptionInternalResult =
        thingsboardErrorResponseHandler.handleExceptionInternal(
            ex,
            "Body",
            headers,
            HttpStatus.OK,
            new ServletWebRequest(new MockHttpServletRequest()));

    // Assert
    HttpStatusCode statusCode = actualHandleExceptionInternalResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    Object body = actualHandleExceptionInternalResult.getBody();
    assertTrue(body instanceof ThingsboardErrorResponse);
    assertEquals("foo", ((ThingsboardErrorResponse) body).getMessage());
    assertEquals(200, ((ThingsboardErrorResponse) body).getStatus().intValue());
    assertEquals(200, actualHandleExceptionInternalResult.getStatusCodeValue());
    assertEquals(HttpStatus.OK, statusCode);
    assertEquals(ThingsboardErrorCode.GENERAL, ((ThingsboardErrorResponse) body).getErrorCode());
    assertTrue(actualHandleExceptionInternalResult.hasBody());
    assertEquals(headers, actualHandleExceptionInternalResult.getHeaders());
  }
}
