package org.thingsboard.server.service.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.FutureCallback;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.script.api.ScriptStatCallback;
import org.thingsboard.server.exception.AccessDeniedException;
import org.thingsboard.server.exception.EntityNotFoundException;
import org.thingsboard.server.exception.InternalErrorException;
import org.thingsboard.server.exception.UnauthorizedException;

@DisabledInAotMode
class ValidationCallbackDiffblueTest {
  @MockBean
  private FutureCallback<Object> futureCallback;

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with
   * {@code ValidationResult}.
   * <ul>
   *   <li>Given {@code OK}.</li>
   *   <li>Then calls {@link ValidationResult#getResultCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; given 'OK'; then calls getResultCode()")
  void testOnSuccessWithValidationResult_givenOk_thenCallsGetResultCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);
    ValidationCallback<Object> validationCallback = new ValidationCallback<>("Response",
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));
    ValidationResult result = mock(ValidationResult.class);
    when(result.getResultCode()).thenReturn(ValidationResultCode.OK);

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(result).getResultCode();
  }

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with
   * {@code ValidationResult}.
   * <ul>
   *   <li>Then calls {@link ValidationResult#getMessage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; then calls getMessage()")
  void testOnSuccessWithValidationResult_thenCallsGetMessage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AtomicInteger successMsgs = new AtomicInteger(1);
    AtomicInteger timeoutMsgs = new AtomicInteger(1);
    ValidationCallback<Object> validationCallback = new ValidationCallback<>("Response",
        new ScriptStatCallback<>(successMsgs, timeoutMsgs, new AtomicInteger(1)));
    ValidationResult result = mock(ValidationResult.class);
    when(result.getMessage()).thenReturn("Not all who wander are lost");
    when(result.getResultCode()).thenReturn(ValidationResultCode.UNAUTHORIZED);

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(result).getMessage();
    verify(result, atLeast(1)).getResultCode();
  }

  /**
   * Test {@link ValidationCallback#getException(ValidationResult)}.
   * <ul>
   *   <li>Given {@code Not all who wander are lost}.</li>
   *   <li>Then calls {@link ValidationResult#getMessage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#getException(ValidationResult)}
   */
  @Test
  @DisplayName("Test getException(ValidationResult); given 'Not all who wander are lost'; then calls getMessage()")
  void testGetException_givenNotAllWhoWanderAreLost_thenCallsGetMessage() {
    // Arrange
    ValidationResult result = mock(ValidationResult.class);
    when(result.getMessage()).thenReturn("Not all who wander are lost");
    when(result.getResultCode()).thenReturn(ValidationResultCode.UNAUTHORIZED);

    // Act
    Exception actualException = ValidationCallback.getException(result);

    // Assert
    verify(result).getMessage();
    verify(result).getResultCode();
    ResponseEntity<String> toErrorResponseEntityResult = ((UnauthorizedException) actualException)
        .toErrorResponseEntity();
    HttpStatusCode statusCode = toErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(actualException instanceof UnauthorizedException);
    assertEquals("Not all who wander are lost", toErrorResponseEntityResult.getBody());
    assertEquals(401, toErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertTrue(toErrorResponseEntityResult.hasBody());
    assertTrue(toErrorResponseEntityResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link ValidationCallback#getException(ValidationResult)}.
   * <ul>
   *   <li>Given {@code OK}.</li>
   *   <li>Then return LocalizedMessage is {@code Permission denied.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#getException(ValidationResult)}
   */
  @Test
  @DisplayName("Test getException(ValidationResult); given 'OK'; then return LocalizedMessage is 'Permission denied.'")
  void testGetException_givenOk_thenReturnLocalizedMessageIsPermissionDenied() {
    // Arrange
    ValidationResult result = mock(ValidationResult.class);
    when(result.getResultCode()).thenReturn(ValidationResultCode.OK);

    // Act
    Exception actualException = ValidationCallback.getException(result);

    // Assert
    verify(result).getResultCode();
    ResponseEntity<String> toErrorResponseEntityResult = ((UnauthorizedException) actualException)
        .toErrorResponseEntity();
    HttpStatusCode statusCode = toErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(actualException instanceof UnauthorizedException);
    assertEquals("Permission denied.", actualException.getLocalizedMessage());
    assertEquals("Permission denied.", actualException.getMessage());
    assertEquals("Permission denied.", toErrorResponseEntityResult.getBody());
    assertEquals(401, toErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertTrue(toErrorResponseEntityResult.hasBody());
    assertTrue(toErrorResponseEntityResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link ValidationCallback#getException(ValidationResult)}.
   * <ul>
   *   <li>Then return {@link AccessDeniedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#getException(ValidationResult)}
   */
  @Test
  @DisplayName("Test getException(ValidationResult); then return AccessDeniedException")
  void testGetException_thenReturnAccessDeniedException() {
    // Arrange
    ValidationResult<Object> result = ValidationResult.accessDenied("Not all who wander are lost");

    // Act
    Exception actualException = ValidationCallback.getException(result);

    // Assert
    ResponseEntity<String> toErrorResponseEntityResult = ((AccessDeniedException) actualException)
        .toErrorResponseEntity();
    HttpStatusCode statusCode = toErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(actualException instanceof AccessDeniedException);
    assertEquals("Not all who wander are lost", toErrorResponseEntityResult.getBody());
    assertEquals(403, toErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.FORBIDDEN, statusCode);
    assertTrue(toErrorResponseEntityResult.hasBody());
    assertTrue(toErrorResponseEntityResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link ValidationCallback#getException(ValidationResult)}.
   * <ul>
   *   <li>Then return {@link EntityNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#getException(ValidationResult)}
   */
  @Test
  @DisplayName("Test getException(ValidationResult); then return EntityNotFoundException")
  void testGetException_thenReturnEntityNotFoundException() {
    // Arrange
    ValidationResult<Object> result = ValidationResult.entityNotFound("Not all who wander are lost");

    // Act
    Exception actualException = ValidationCallback.getException(result);

    // Assert
    ResponseEntity<String> toErrorResponseEntityResult = ((EntityNotFoundException) actualException)
        .toErrorResponseEntity();
    HttpStatusCode statusCode = toErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(actualException instanceof EntityNotFoundException);
    assertEquals("Not all who wander are lost", toErrorResponseEntityResult.getBody());
    assertEquals(404, toErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.NOT_FOUND, statusCode);
    assertTrue(toErrorResponseEntityResult.hasBody());
    assertTrue(toErrorResponseEntityResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link ValidationCallback#getException(ValidationResult)}.
   * <ul>
   *   <li>Then return {@link InternalErrorException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#getException(ValidationResult)}
   */
  @Test
  @DisplayName("Test getException(ValidationResult); then return InternalErrorException")
  void testGetException_thenReturnInternalErrorException() {
    // Arrange
    ValidationResult<Object> result = ValidationResult.internalError("Not all who wander are lost");

    // Act
    Exception actualException = ValidationCallback.getException(result);

    // Assert
    ResponseEntity<String> toErrorResponseEntityResult = ((InternalErrorException) actualException)
        .toErrorResponseEntity();
    HttpStatusCode statusCode = toErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertTrue(actualException instanceof InternalErrorException);
    assertEquals("Not all who wander are lost", toErrorResponseEntityResult.getBody());
    assertEquals(500, toErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertTrue(toErrorResponseEntityResult.hasBody());
    assertTrue(toErrorResponseEntityResult.getHeaders().isEmpty());
  }
}
