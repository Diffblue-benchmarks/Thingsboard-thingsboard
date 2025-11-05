package org.thingsboard.server.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

@ContextConfiguration(classes = {EntityNotFoundException.class, String.class})
@ExtendWith(SpringExtension.class)
class EntityNotFoundExceptionDiffblueTest {
  @Autowired private EntityNotFoundException entityNotFoundException;

  /**
   * Test {@link EntityNotFoundException#EntityNotFoundException(String)}.
   *
   * <p>Method under test: {@link EntityNotFoundException#EntityNotFoundException(String)}
   */
  @Test
  @DisplayName("Test new EntityNotFoundException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityNotFoundException.<init>(String)"})
  void testNewEntityNotFoundException() {
    // Arrange and Act
    EntityNotFoundException actualEntityNotFoundException =
        new EntityNotFoundException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualEntityNotFoundException.getMessage());
    assertNull(actualEntityNotFoundException.getCause());
    assertEquals(0, actualEntityNotFoundException.getSuppressed().length);
  }

  /**
   * Test {@link EntityNotFoundException#toErrorResponseEntity()}.
   *
   * <p>Method under test: {@link EntityNotFoundException#toErrorResponseEntity()}
   */
  @Test
  @DisplayName("Test toErrorResponseEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity EntityNotFoundException.toErrorResponseEntity()"})
  void testToErrorResponseEntity() {
    // Arrange and Act
    ResponseEntity<String> actualToErrorResponseEntityResult =
        entityNotFoundException.toErrorResponseEntity();

    // Assert
    HttpStatusCode statusCode = actualToErrorResponseEntityResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertEquals("", actualToErrorResponseEntityResult.getBody());
    assertEquals(404, actualToErrorResponseEntityResult.getStatusCodeValue());
    assertEquals(HttpStatus.NOT_FOUND, statusCode);
    assertTrue(actualToErrorResponseEntityResult.hasBody());
    assertTrue(actualToErrorResponseEntityResult.getHeaders().isEmpty());
  }
}
