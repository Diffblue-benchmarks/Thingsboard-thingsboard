package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import jakarta.validation.ClockProvider;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.Test;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class NoXssValidatorDiffblueTest {
  /**
   * Test {@link NoXssValidator#isValid(String)} with {@code stringValue}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoXssValidator#isValid(String)}
   */
  @Test
  public void testIsValidWithStringValue_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NoXssValidator.isValid("42"));
  }

  /**
   * Test {@link NoXssValidator#isValid(String)} with {@code stringValue}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoXssValidator#isValid(String)}
   */
  @Test
  public void testIsValidWithStringValue_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NoXssValidator.isValid(""));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with
   * {@code value}, {@code constraintValidatorContext}.
   * <p>
   * Method under test:
   * {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValidWithValueConstraintValidatorContext() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(noXssValidator.isValid(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with
   * {@code value}, {@code constraintValidatorContext}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValidWithValueConstraintValidatorContext_whenEmptyString() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(noXssValidator.isValid("",
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with
   * {@code value}, {@code constraintValidatorContext}.
   * <ul>
   *   <li>When forty-two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValidWithValueConstraintValidatorContext_whenFortyTwo() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(noXssValidator.isValid(42,
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with
   * {@code value}, {@code constraintValidatorContext}.
   * <ul>
   *   <li>When {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
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
