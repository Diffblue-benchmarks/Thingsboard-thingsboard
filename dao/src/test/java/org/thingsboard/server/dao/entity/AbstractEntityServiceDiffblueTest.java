package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.exception.DataValidationException;

public class AbstractEntityServiceDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  public void testExtractConstraintViolationException_thenReturnNotPresent() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Optional AbstractEntityService.extractConstraintViolationException(Exception)"
  })
  public void testExtractConstraintViolationException_thenReturnPresent() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String, String, String)"
  })
  public void
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AbstractEntityService.checkConstraintViolation(Exception, String, String)"
  })
  public void testCheckConstraintViolationWithTConstraintNameConstraintMessage() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractEntityService.checkConstraintViolation(Exception, Map)"})
  public void testCheckConstraintViolationWithTConstraints_thenThrowDataValidationException() {
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
