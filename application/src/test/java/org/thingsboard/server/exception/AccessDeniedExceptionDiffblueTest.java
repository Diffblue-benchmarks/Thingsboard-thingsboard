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

@ContextConfiguration(classes = {AccessDeniedException.class, String.class})
@ExtendWith(SpringExtension.class)
class AccessDeniedExceptionDiffblueTest {
  @Autowired
  private AccessDeniedException accessDeniedException;

  /**
   * Test {@link AccessDeniedException#AccessDeniedException(String)}.
   * <p>
   * Method under test: {@link AccessDeniedException#AccessDeniedException(String)}
   */
  @Test
  @DisplayName("Test new AccessDeniedException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccessDeniedException.<init>(String)"})
  void testNewAccessDeniedException() {
    // Arrange and Act
    AccessDeniedException actualAccessDeniedException = new AccessDeniedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualAccessDeniedException.getMessage());
    assertNull(actualAccessDeniedException.getCause());
    assertEquals(0, actualAccessDeniedException.getSuppressed().length);
  }

  /**
   * Test {@link AccessDeniedException#toErrorResponseEntity()}.
   * <p>
   * Method under test: {@link AccessDeniedException#toErrorResponseEntity()}
   */
  @Test
  @DisplayName("Test toErrorResponseEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseEntity AccessDeniedException.toErrorResponseEntity()"})
  void testToErrorResponseEntity() {
    // Arrange and Act
    ResponseEntity<String> actualToErrorResponseEntityResult = accessDeniedException.toErrorResponseEntity();

    // Assert
    HttpStatusCode statusCode = actualToErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("", actualToErrorResponseEntityResult.getBody());
    assertEquals(403, actualToErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.FORBIDDEN, statusCode);
    assertTrue(actualToErrorResponseEntityResult.hasBody());
    assertTrue(actualToErrorResponseEntityResult.getHeaders().isEmpty());
  }
}
