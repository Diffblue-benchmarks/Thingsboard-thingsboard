package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.validation.ClockProvider;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.Test;
import org.thingsboard.server.common.data.validation.Length;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class StringLengthValidatorDiffblueTest {
  /**
   * Test
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValid_whenEmptyString_thenReturnTrue() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(stringLengthValidator.isValid("",
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValid_whenFortyTwo_thenReturnTrue() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertTrue(stringLengthValidator.isValid(42,
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   * <ul>
   *   <li>When
   * {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValid_whenPublic_customer_additional_info_json_thenReturnFalse() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertFalse(stringLengthValidator.isValid(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  public void testIsValid_whenValue_thenReturnFalse() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);

    // Act and Assert
    assertFalse(stringLengthValidator.isValid("Value",
        new ConstraintValidatorContextImpl(clockProvider, PathImpl.createRootPath(), mock(ConstraintDescriptor.class),
            "Constraint Validator Payload", ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT)));
  }

  /**
   * Test {@link StringLengthValidator#initialize(Length)} with {@code Length}.
   * <p>
   * Method under test: {@link StringLengthValidator#initialize(Length)}
   */
  @Test
  public void testInitializeWithLength() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    Length constraintAnnotation = mock(Length.class);
    when(constraintAnnotation.max()).thenReturn(3);
    when(constraintAnnotation.min()).thenReturn(1);

    // Act
    stringLengthValidator.initialize(constraintAnnotation);

    // Assert
    verify(constraintAnnotation).max();
    verify(constraintAnnotation).min();
  }
}
