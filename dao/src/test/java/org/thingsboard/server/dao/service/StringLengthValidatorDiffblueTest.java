/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.validation.ClockProvider;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.validation.Length;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class StringLengthValidatorDiffblueTest {
  /**
   * Test {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringLengthValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValid_whenEmptyString_thenReturnTrue() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);
    ConstraintValidatorContextImpl context =
        new ConstraintValidatorContextImpl(
            clockProvider,
            PathImpl.createRootPath(),
            mock(ConstraintDescriptor.class),
            "Constraint Validator Payload",
            ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT);

    // Act and Assert
    assertTrue(stringLengthValidator.isValid("", context));
  }

  /**
   * Test {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringLengthValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValid_whenFortyTwo_thenReturnTrue() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);
    ConstraintValidatorContextImpl context =
        new ConstraintValidatorContextImpl(
            clockProvider,
            PathImpl.createRootPath(),
            mock(ConstraintDescriptor.class),
            "Constraint Validator Payload",
            ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT);

    // Act and Assert
    assertTrue(stringLengthValidator.isValid(42, context));
  }

  /**
   * Test {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   *
   * <ul>
   *   <li>When {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringLengthValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValid_whenPublic_customer_additional_info_json_thenReturnFalse() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);
    ConstraintValidatorContextImpl context =
        new ConstraintValidatorContextImpl(
            clockProvider,
            PathImpl.createRootPath(),
            mock(ConstraintDescriptor.class),
            "Constraint Validator Payload",
            ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT);

    // Act and Assert
    assertFalse(
        stringLengthValidator.isValid(
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON, context));
  }

  /**
   * Test {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringLengthValidator#isValid(Object, ConstraintValidatorContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringLengthValidator.isValid(Object, ConstraintValidatorContext)"})
  public void testIsValid_whenValue_thenReturnFalse() {
    // Arrange
    StringLengthValidator stringLengthValidator = new StringLengthValidator();
    ClockProvider clockProvider = mock(ClockProvider.class);
    ConstraintValidatorContextImpl context =
        new ConstraintValidatorContextImpl(
            clockProvider,
            PathImpl.createRootPath(),
            mock(ConstraintDescriptor.class),
            "Constraint Validator Payload",
            ExpressionLanguageFeatureLevel.DEFAULT,
            ExpressionLanguageFeatureLevel.DEFAULT);

    // Act and Assert
    assertFalse(stringLengthValidator.isValid("Value", context));
  }

  /**
   * Test {@link StringLengthValidator#initialize(Length)} with {@code Length}.
   *
   * <p>Method under test: {@link StringLengthValidator#initialize(Length)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringLengthValidator.initialize(Length)"})
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
