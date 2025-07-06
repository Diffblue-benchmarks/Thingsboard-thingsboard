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
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class NoXssValidatorDiffblueTest {
  /**
   * Test {@link NoXssValidator#isValid(String)} with {@code stringValue}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NoXssValidator#isValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(String)"})
  public void testIsValidWithStringValue_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NoXssValidator.isValid("42"));
  }

  /**
   * Test {@link NoXssValidator#isValid(String)} with {@code stringValue}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NoXssValidator#isValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(String)"})
  public void testIsValidWithStringValue_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NoXssValidator.isValid(""));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with {@code value},
   * {@code constraintValidatorContext}.
   *
   * <p>Method under test: {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValidWithValueConstraintValidatorContext() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(
        noXssValidator.isValid(
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
            new ConstraintValidatorContextImpl(
                clockProvider,
                PathImpl.createRootPath(),
                mock(ConstraintDescriptor.class),
                "Constraint Validator Payload",
                ExpressionLanguageFeatureLevel.DEFAULT,
                ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with {@code value},
   * {@code constraintValidatorContext}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValidWithValueConstraintValidatorContext_whenEmptyString() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(
        noXssValidator.isValid(
            "",
            new ConstraintValidatorContextImpl(
                clockProvider,
                PathImpl.createRootPath(),
                mock(ConstraintDescriptor.class),
                "Constraint Validator Payload",
                ExpressionLanguageFeatureLevel.DEFAULT,
                ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with {@code value},
   * {@code constraintValidatorContext}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValidWithValueConstraintValidatorContext_whenFortyTwo() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(
        noXssValidator.isValid(
            42,
            new ConstraintValidatorContextImpl(
                clockProvider,
                PathImpl.createRootPath(),
                mock(ConstraintDescriptor.class),
                "Constraint Validator Payload",
                ExpressionLanguageFeatureLevel.DEFAULT,
                ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)} with {@code value},
   * {@code constraintValidatorContext}.
   *
   * <ul>
   *   <li>When {@code Value}.
   * </ul>
   *
   * <p>Method under test: {@link NoXssValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean NoXssValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValidWithValueConstraintValidatorContext_whenValue() {
    // Arrange
    NoXssValidator noXssValidator = new NoXssValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(
        noXssValidator.isValid(
            "Value",
            new ConstraintValidatorContextImpl(
                clockProvider,
                PathImpl.createRootPath(),
                mock(ConstraintDescriptor.class),
                "Constraint Validator Payload",
                ExpressionLanguageFeatureLevel.DEFAULT,
                ExpressionLanguageFeatureLevel.DEFAULT)));
  }
}
