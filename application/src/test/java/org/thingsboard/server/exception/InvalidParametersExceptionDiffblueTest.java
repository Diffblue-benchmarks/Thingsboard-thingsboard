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

@ContextConfiguration(classes = {InvalidParametersException.class, String.class})
@ExtendWith(SpringExtension.class)
class InvalidParametersExceptionDiffblueTest {
  @Autowired
  private InvalidParametersException invalidParametersException;

  /**
   * Test {@link InvalidParametersException#InvalidParametersException(String)}.
   * <p>
   * Method under test: {@link InvalidParametersException#InvalidParametersException(String)}
   */
  @Test
  @DisplayName("Test new InvalidParametersException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InvalidParametersException.<init>(String)"})
  void testNewInvalidParametersException() {
    // Arrange and Act
    InvalidParametersException actualInvalidParametersException = new InvalidParametersException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualInvalidParametersException.getMessage());
    assertNull(actualInvalidParametersException.getCause());
    assertEquals(0, actualInvalidParametersException.getSuppressed().length);
  }

  /**
   * Test {@link InvalidParametersException#toErrorResponseEntity()}.
   * <p>
   * Method under test: {@link InvalidParametersException#toErrorResponseEntity()}
   */
  @Test
  @DisplayName("Test toErrorResponseEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity InvalidParametersException.toErrorResponseEntity()"})
  void testToErrorResponseEntity() {
    // Arrange and Act
    ResponseEntity<String> actualToErrorResponseEntityResult = invalidParametersException.toErrorResponseEntity();

    // Assert
    HttpStatusCode statusCode = actualToErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("", actualToErrorResponseEntityResult.getBody());
    assertEquals(400, actualToErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.BAD_REQUEST, statusCode);
    assertTrue(actualToErrorResponseEntityResult.hasBody());
    assertTrue(actualToErrorResponseEntityResult.getHeaders().isEmpty());
  }
}
