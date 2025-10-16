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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.hibernate.validator.internal.engine.DefaultClockProvider;
import org.hibernate.validator.internal.engine.DefaultParameterNameProvider;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.hibernate.validator.internal.engine.resolver.JPATraversableResolver;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.LocaleContextMessageInterpolator;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;
import org.thingsboard.server.dao.exception.DataValidationException;

@ContextConfiguration(classes = {ConstraintValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ConstraintValidatorDiffblueTest {
  @Autowired private ConstraintValidator constraintValidator;

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation() {
    // Arrange
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintViolation));
    verify(constraintViolation).getConstraintDescriptor();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation2() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage())
        .thenThrow(new DataValidationException("An error occurred"));
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintViolation));
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation3() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    PathImpl createRootPathResult = PathImpl.createRootPath();
    createRootPathResult.addPropertyNode("Node Name");

    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(createRootPathResult);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("Node Name Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation4() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    PathImpl createRootPathResult = PathImpl.createRootPath();
    createRootPathResult.addPropertyNode("");
    createRootPathResult.addPropertyNode("Node Name");

    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(createRootPathResult);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("Node Name Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with {@code
   * constraintViolation}.
   *
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(ConstraintViolation)"})
  public void testGetErrorMessageWithConstraintViolation_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with {@code
   * constraintsViolations}.
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(Collection)"})
  public void testGetErrorMessageWithConstraintsViolations() {
    // Arrange
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<ConstraintViolation<Object>> constraintsViolations = new ArrayList<>();
    constraintsViolations.add(constraintViolation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintsViolations));
    verify(constraintViolation).getConstraintDescriptor();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with {@code
   * constraintsViolations}.
   *
   * <ul>
   *   <li>Then calls {@link ConstraintViolation#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(Collection)"})
  public void testGetErrorMessageWithConstraintsViolations_thenCallsGetMessage() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl =
        mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage())
        .thenThrow(new DataValidationException("An error occurred"));
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    org.mockito.Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    ArrayList<ConstraintViolation<Object>> constraintsViolations = new ArrayList<>();
    constraintsViolations.add(constraintViolation);
    constraintsViolations.add(mock(ConstraintViolation.class));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> ConstraintValidator.getErrorMessage(constraintsViolations));
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with {@code
   * constraintsViolations}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ConstraintValidator.getErrorMessage(Collection)"})
  public void testGetErrorMessageWithConstraintsViolations_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ConstraintValidator.getErrorMessage(new ArrayList<>()));
  }

  /**
   * Test {@link ConstraintValidator#validatorFactoryBean()}.
   *
   * <ul>
   *   <li>Given {@link ConstraintValidator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#validatorFactoryBean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalValidatorFactoryBean ConstraintValidator.validatorFactoryBean()"})
  public void testValidatorFactoryBean_givenConstraintValidator() {
    // Arrange, Act and Assert
    assertTrue(
        new ConstraintValidator().validatorFactoryBean().getValidationPropertyMap().isEmpty());
  }

  /**
   * Test {@link ConstraintValidator#validatorFactoryBean()}.
   *
   * <ul>
   *   <li>Then ClockProvider return {@link DefaultClockProvider}.
   * </ul>
   *
   * <p>Method under test: {@link ConstraintValidator#validatorFactoryBean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalValidatorFactoryBean ConstraintValidator.validatorFactoryBean()"})
  public void testValidatorFactoryBean_thenClockProviderReturnDefaultClockProvider() {
    // Arrange and Act
    LocalValidatorFactoryBean actualValidatorFactoryBeanResult =
        constraintValidator.validatorFactoryBean();

    // Assert
    assertTrue(actualValidatorFactoryBeanResult.getClockProvider() instanceof DefaultClockProvider);
    assertTrue(
        actualValidatorFactoryBeanResult.getParameterNameProvider()
            instanceof DefaultParameterNameProvider);
    assertTrue(actualValidatorFactoryBeanResult.getValidator() instanceof ValidatorImpl);
    assertTrue(
        actualValidatorFactoryBeanResult.getTraversableResolver()
            instanceof JPATraversableResolver);
    assertTrue(
        actualValidatorFactoryBeanResult.getMessageInterpolator()
            instanceof LocaleContextMessageInterpolator);
    assertTrue(
        actualValidatorFactoryBeanResult.getConstraintValidatorFactory()
            instanceof SpringConstraintValidatorFactory);
    assertTrue(actualValidatorFactoryBeanResult.getValidationPropertyMap().isEmpty());
  }
}
