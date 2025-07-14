package org.thingsboard.server.dao.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.exception.DataValidationException;

class AbstractEntityServiceDiffblueTest {
  /**
   * Test {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  @DisplayName("Test extractConstraintViolationException(Exception); then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  void testExtractConstraintViolationException_thenReturnNotPresent() {
    // Arrange and Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult =
        AbstractEntityService.extractConstraintViolationException(new Exception("foo"));

    // Assert
    assertFalse(actualExtractConstraintViolationExceptionResult.isPresent());
  }

  /**
   * Test {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  @DisplayName("Test extractConstraintViolationException(Exception); then return Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  void testExtractConstraintViolationException_thenReturnPresent() {
    // Arrange
    Exception t = new Exception("foo");
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");

    t.initCause(constraintViolationException);

    // Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult =
        AbstractEntityService.extractConstraintViolationException(t);

    // Assert
    assertTrue(actualExtractConstraintViolationExceptionResult.isPresent());
    assertSame(constraintViolationException, actualExtractConstraintViolationExceptionResult.get());
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String, String,
   * String)} with {@code t}, {@code constraintName1}, {@code constraintMessage1}, {@code
   * constraintName2}, {@code constraintMessage2}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String, String, String) with 't', 'constraintName1', 'constraintMessage1', 'constraintName2', 'constraintMessage2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  void
      testCheckConstraintViolationWithTConstraintName1ConstraintMessage1ConstraintName2ConstraintMessage2() {
    // Arrange
    Exception t = new Exception("foo");
    t.initCause(
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name2"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            AbstractEntityService.checkConstraintViolation(
                t,
                "Constraint Name1",
                "Constraint Message1",
                "Constraint Name2",
                "Constraint Message2"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, String, String)} with
   * {@code t}, {@code constraintName}, {@code constraintMessage}.
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, String, String) with 't', 'constraintName', 'constraintMessage'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  void testCheckConstraintViolationWithTConstraintNameConstraintMessage() {
    // Arrange
    Exception t = new Exception("foo");
    t.initCause(
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            AbstractEntityService.checkConstraintViolation(
                t, "Constraint Name", "Constraint Message"));
  }

  /**
   * Test {@link AbstractEntityService#checkConstraintViolation(Exception, Map)} with {@code t},
   * {@code constraints}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractEntityService#checkConstraintViolation(Exception, Map)}
   */
  @Test
  @DisplayName(
      "Test checkConstraintViolation(Exception, Map) with 't', 'constraints'; then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  void testCheckConstraintViolationWithTConstraints_thenThrowDataValidationException() {
    // Arrange
    Exception t = new Exception("foo");
    t.initCause(new ConstraintViolationException("An error occurred", new SQLException(), "42"));

    HashMap<String, String> constraints = new HashMap<>();
    constraints.put("42", "42");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> AbstractEntityService.checkConstraintViolation(t, constraints));
  }
}
