package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.validation.ClockProvider;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NoXssValidatorDiffblueTest {
  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with {@code value}, {@code constraintValidatorContext}.
   * <ul>
   *   <li>When {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValidWithValueConstraintValidatorContext_whenValue() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(noXssValidator.isValid("Value",
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }
}
