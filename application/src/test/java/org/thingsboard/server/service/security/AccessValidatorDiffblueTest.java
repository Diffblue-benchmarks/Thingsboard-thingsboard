package org.thingsboard.server.service.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.dao.exception.IncorrectParameterException;

class AccessValidatorDiffblueTest {
  /**
   * Test {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}.
   * <ul>
   *   <li>Then {@link DeferredResult#DeferredResult()} Result Body is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}
   */
  @Test
  @DisplayName("Test handleError(Throwable, DeferredResult, HttpStatus); then DeferredResult() Result Body is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccessValidator.handleError(Throwable, DeferredResult, HttpStatus)"})
  void testHandleError_thenDeferredResultResultBodyIsAnErrorOccurred() {
    // Arrange
    IncorrectParameterException e = new IncorrectParameterException("An error occurred");
    DeferredResult<ResponseEntity> response = new DeferredResult<>();

    // Act
    AccessValidator.handleError(e, response, HttpStatus.CONTINUE);

    // Assert
    Object result = response.getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertEquals("An error occurred", ((ResponseEntity<Object>) result).getBody());
    assertEquals(400, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.BAD_REQUEST, statusCode);
    assertTrue(((ResponseEntity<Object>) result).hasBody());
  }

  /**
   * Test {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}.
   * <ul>
   *   <li>Then {@link DeferredResult#DeferredResult()} Result Body is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}
   */
  @Test
  @DisplayName("Test handleError(Throwable, DeferredResult, HttpStatus); then DeferredResult() Result Body is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccessValidator.handleError(Throwable, DeferredResult, HttpStatus)"})
  void testHandleError_thenDeferredResultResultBodyIsFoo() {
    // Arrange
    IllegalArgumentException e = new IllegalArgumentException("foo");
    DeferredResult<ResponseEntity> response = new DeferredResult<>();

    // Act
    AccessValidator.handleError(e, response, HttpStatus.CONTINUE);

    // Assert
    Object result = response.getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertEquals("foo", ((ResponseEntity<Object>) result).getBody());
    assertEquals(400, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.BAD_REQUEST, statusCode);
    assertTrue(((ResponseEntity<Object>) result).hasBody());
  }

  /**
   * Test {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then {@link DeferredResult#DeferredResult()} Result Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccessValidator#handleError(Throwable, DeferredResult, HttpStatus)}
   */
  @Test
  @DisplayName("Test handleError(Throwable, DeferredResult, HttpStatus); when Throwable(); then DeferredResult() Result Body is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccessValidator.handleError(Throwable, DeferredResult, HttpStatus)"})
  void testHandleError_whenThrowable_thenDeferredResultResultBodyIsNull() {
    // Arrange
    Throwable e = new Throwable();
    DeferredResult<ResponseEntity> response = new DeferredResult<>();

    // Act
    AccessValidator.handleError(e, response, HttpStatus.CONTINUE);

    // Assert
    Object result = response.getResult();
    HttpStatusCode statusCode = ((ResponseEntity<Object>) result).getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(result instanceof ResponseEntity);
    assertNull(((ResponseEntity<Object>) result).getBody());
    assertEquals(100, ((ResponseEntity<Object>) result).getStatusCodeValue());
    assertEquals(HttpStatus.CONTINUE, statusCode);
    assertFalse(((ResponseEntity<Object>) result).hasBody());
  }
}
