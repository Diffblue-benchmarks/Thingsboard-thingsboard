package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {InternalErrorException.class, String.class})
@ExtendWith(SpringExtension.class)
class InternalErrorExceptionDiffblueTest {
  @Autowired private InternalErrorException internalErrorException;

  /**
   * Test {@link InternalErrorException#InternalErrorException(String)}.
   *
   * <p>Method under test: {@link InternalErrorException#InternalErrorException(String)}
   */
  @Test
  @DisplayName("Test new InternalErrorException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InternalErrorException.<init>(String)"})
  void testNewInternalErrorException() {
    // Arrange and Act
    InternalErrorException actualInternalErrorException =
        new InternalErrorException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInternalErrorException.getMessage());
    assertNull(actualInternalErrorException.getCause());
    assertEquals(0, actualInternalErrorException.getSuppressed().length);
  }

  /**
   * Test {@link InternalErrorException#toErrorResponseEntity()}.
   *
   * <p>Method under test: {@link InternalErrorException#toErrorResponseEntity()}
   */
  @Test
  @DisplayName("Test toErrorResponseEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity InternalErrorException.toErrorResponseEntity()"})
  void testToErrorResponseEntity() {
    // Arrange and Act
    ResponseEntity<String> actualToErrorResponseEntityResult =
        internalErrorException.toErrorResponseEntity();

    // Assert
    HttpStatusCode statusCode = actualToErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("", actualToErrorResponseEntityResult.getBody());
    assertEquals(500, actualToErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, statusCode);
    assertTrue(actualToErrorResponseEntityResult.hasBody());
    assertTrue(actualToErrorResponseEntityResult.getHeaders().isEmpty());
  }
}
