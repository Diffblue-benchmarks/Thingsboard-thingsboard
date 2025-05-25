package org.thingsboard.server.service.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.FutureCallback;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.thingsboard.server.exception.AccessDeniedException;
import org.thingsboard.server.exception.EntityNotFoundException;
import org.thingsboard.server.exception.InternalErrorException;
import org.thingsboard.server.exception.UnauthorizedException;

@ExtendWith(MockitoExtension.class)
class ValidationCallbackDiffblueTest {
  @Mock
  private FutureCallback<Object> futureCallback;

  @InjectMocks
  private ValidationCallback<Object> validationCallback;

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with {@code ValidationResult}.
   * <ul>
   *   <li>Then calls {@link ValidationResult#getMessage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; then calls getMessage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationCallback.onSuccess(ValidationResult)"})
  void testOnSuccessWithValidationResult_thenCallsGetMessage() {
    // Arrange
    doNothing().when(futureCallback).onFailure(Mockito.<Throwable>any());
    ValidationResult result = mock(ValidationResult.class);
    when(result.getMessage()).thenReturn("Not all who wander are lost");
    when(result.getResultCode()).thenReturn(ValidationResultCode.UNAUTHORIZED);

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(futureCallback).onFailure(isA(Throwable.class));
    verify(result).getMessage();
    verify(result, atLeast(1)).getResultCode();
  }

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with {@code ValidationResult}.
   * <ul>
   *   <li>Then calls {@link FutureCallback#onSuccess(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; then calls onSuccess(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationCallback.onSuccess(ValidationResult)"})
  void testOnSuccessWithValidationResult_thenCallsOnSuccess() {
    // Arrange
    doNothing().when(futureCallback).onSuccess(Mockito.<Object>any());
    ValidationResult result = mock(ValidationResult.class);
    when(result.getResultCode()).thenReturn(ValidationResultCode.OK);

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(futureCallback).onSuccess(isA(Object.class));
    verify(result).getResultCode();
  }

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with {@code ValidationResult}.
   * <ul>
   *   <li>When accessDenied {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; when accessDenied 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationCallback.onSuccess(ValidationResult)"})
  void testOnSuccessWithValidationResult_whenAccessDeniedNotAllWhoWanderAreLost() {
    // Arrange
    doNothing().when(futureCallback).onFailure(Mockito.<Throwable>any());
    ValidationResult<Object> result = ValidationResult.accessDenied("Not all who wander are lost");

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(futureCallback).onFailure(isA(Throwable.class));
  }

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with {@code ValidationResult}.
   * <ul>
   *   <li>When entityNotFound {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; when entityNotFound 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationCallback.onSuccess(ValidationResult)"})
  void testOnSuccessWithValidationResult_whenEntityNotFoundNotAllWhoWanderAreLost() {
    // Arrange
    doNothing().when(futureCallback).onFailure(Mockito.<Throwable>any());
    ValidationResult<Object> result = ValidationResult.entityNotFound("Not all who wander are lost");

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(futureCallback).onFailure(isA(Throwable.class));
  }

  /**
   * Test {@link ValidationCallback#onSuccess(ValidationResult)} with {@code ValidationResult}.
   * <ul>
   *   <li>When internalError {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidationCallback#onSuccess(ValidationResult)}
   */
  @Test
  @DisplayName("Test onSuccess(ValidationResult) with 'ValidationResult'; when internalError 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationCallback.onSuccess(ValidationResult)"})
  void testOnSuccessWithValidationResult_whenInternalErrorNotAllWhoWanderAreLost() {
    // Arrange
    doNothing().when(futureCallback).onFailure(Mockito.<Throwable>any());
    ValidationResult<Object> result = ValidationResult.internalError("Not all who wander are lost");

    // Act
    validationCallback.onSuccess(result);

    // Assert
    verify(futureCallback).onFailure(isA(Throwable.class));
  }

  /**
   * Test {@link ValidationCallback#onFailure(Throwable)}.
   * <p>
   * Method under test: {@link ValidationCallback#onFailure(Throwable)}
   */
  @Test
  @DisplayName("Test onFailure(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ValidationCallback.onFailure(Throwable)"})
  void testOnFailure() {
    // Arrange
    doNothing().when(futureCallback).onFailure(Mockito.<Throwable>any());

    // Act
    validationCallback.onFailure(new Throwable());

    // Assert
    verify(futureCallback).onFailure(isA(Throwable.class));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ValidationCallback.getException(ValidationResult)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ValidationCallback.getException(ValidationResult)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ValidationCallback.getException(ValidationResult)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ValidationCallback.getException(ValidationResult)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ValidationCallback.getException(ValidationResult)"})
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
