package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handle(Exception,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test handle(Exception, HttpServletResponse) with 'exception', 'response'; then MockHttpServletResponse (default constructor) HeaderNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ThingsboardErrorResponseHandler.handle(Exception, HttpServletResponse)"})
  void testHandleWithExceptionResponse_thenMockHttpServletResponseHeaderNamesSizeIsOne() {
    // Arrange
    Exception exception = new Exception();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    thingsboardErrorResponseHandler.handle(exception, response);

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("application/json", response.getContentType());
    assertEquals(500, response.getStatus());
    assertTrue(headerNames.contains("Content-Type"));
    assertTrue(response.isCommitted());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardErrorResponseHandler.handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)"
  })
  void testHandleWithRequestResponseAccessDeniedException() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
   * <p>Method under test: {@link ThingsboardErrorResponseHandler#handle(HttpServletRequest,
   * HttpServletResponse, AccessDeniedException)}
   */
  @Test
  @DisplayName(
      "Test handle(HttpServletRequest, HttpServletResponse, AccessDeniedException) with 'request', 'response', 'accessDeniedException'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardErrorResponseHandler.handle(HttpServletRequest, HttpServletResponse, AccessDeniedException)"
  })
  void testHandleWithRequestResponseAccessDeniedException2() throws ServletException, IOException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(true);

    // Act
    thingsboardErrorResponseHandler.handle(request, response, new AccessDeniedException("Msg"));

    // Assert that nothing has changed
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals("", response.getContentAsString());
    assertEquals(200, response.getStatus());
    assertTrue(headerNames.isEmpty());
    assertTrue(response.isCommitted());
    assertArrayEquals(new byte[] {}, response.getContentAsByteArray());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity ThingsboardErrorResponseHandler.handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)"
  })
  void testHandleExceptionInternal_thenReturnBodyStatusIntValueIsFiveHundred() {
    // Arrange
    Exception ex = new Exception();
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
    assertNull(((ThingsboardErrorResponse) body).getMessage());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ResponseEntity ThingsboardErrorResponseHandler.handleExceptionInternal(Exception, Object, HttpHeaders, HttpStatusCode, WebRequest)"
  })
  void testHandleExceptionInternal_whenOk_thenReturnBodyStatusIntValueIsTwoHundred() {
    // Arrange
    Exception ex = new Exception();
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
    assertNull(((ThingsboardErrorResponse) body).getMessage());
    assertEquals(200, ((ThingsboardErrorResponse) body).getStatus().intValue());
    assertEquals(200, actualHandleExceptionInternalResult.getStatusCodeValue());
    assertEquals(HttpStatus.OK, statusCode);
    assertEquals(ThingsboardErrorCode.GENERAL, ((ThingsboardErrorResponse) body).getErrorCode());
    assertTrue(actualHandleExceptionInternalResult.hasBody());
    assertEquals(headers, actualHandleExceptionInternalResult.getHeaders());
  }
}
