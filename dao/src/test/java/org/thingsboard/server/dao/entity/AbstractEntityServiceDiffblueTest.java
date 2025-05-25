package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.Optional;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractEntityServiceDiffblueTest {
  /**
   * Test {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional AbstractEntityService.extractConstraintViolationException(Exception)"})
  public void testExtractConstraintViolationException_thenReturnNotPresent() {
    // Arrange and Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult = AbstractEntityService
        .extractConstraintViolationException(new Exception("foo"));

    // Assert
    assertFalse(actualExtractConstraintViolationExceptionResult.isPresent());
  }

  /**
   * Test {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   * <ul>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional AbstractEntityService.extractConstraintViolationException(Exception)"})
  public void testExtractConstraintViolationException_thenReturnPresent() {
    // Arrange
    Exception t = new Exception("foo");
    ConstraintViolationException constraintViolationException = new ConstraintViolationException("An error occurred",
        new SQLException(), "Constraint Name");

    t.initCause(constraintViolationException);

    // Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult = AbstractEntityService
        .extractConstraintViolationException(t);

    // Assert
    assertTrue(actualExtractConstraintViolationExceptionResult.isPresent());
    assertSame(constraintViolationException, actualExtractConstraintViolationExceptionResult.get());
  }
}
