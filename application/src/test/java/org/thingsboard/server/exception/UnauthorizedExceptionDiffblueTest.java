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

@ContextConfiguration(classes = {UnauthorizedException.class, String.class})
@ExtendWith(SpringExtension.class)
class UnauthorizedExceptionDiffblueTest {
  @Autowired private UnauthorizedException unauthorizedException;

  /**
   * Test {@link UnauthorizedException#UnauthorizedException(String)}.
   *
   * <p>Method under test: {@link UnauthorizedException#UnauthorizedException(String)}
   */
  @Test
  @DisplayName("Test new UnauthorizedException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UnauthorizedException.<init>(String)"})
  void testNewUnauthorizedException() {
    // Arrange and Act
    UnauthorizedException actualUnauthorizedException =
        new UnauthorizedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualUnauthorizedException.getMessage());
    assertNull(actualUnauthorizedException.getCause());
    assertEquals(0, actualUnauthorizedException.getSuppressed().length);
  }

  /**
   * Test {@link UnauthorizedException#toErrorResponseEntity()}.
   *
   * <p>Method under test: {@link UnauthorizedException#toErrorResponseEntity()}
   */
  @Test
  @DisplayName("Test toErrorResponseEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity UnauthorizedException.toErrorResponseEntity()"})
  void testToErrorResponseEntity() {
    // Arrange and Act
    ResponseEntity<String> actualToErrorResponseEntityResult =
        unauthorizedException.toErrorResponseEntity();

    // Assert
    HttpStatusCode statusCode = actualToErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("", actualToErrorResponseEntityResult.getBody());
    assertEquals(401, actualToErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.UNAUTHORIZED, statusCode);
    assertTrue(actualToErrorResponseEntityResult.hasBody());
    assertTrue(actualToErrorResponseEntityResult.getHeaders().isEmpty());
  }
}
