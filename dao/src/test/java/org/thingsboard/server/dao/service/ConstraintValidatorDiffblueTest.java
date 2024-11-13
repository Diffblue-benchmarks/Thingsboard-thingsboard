package org.thingsboard.server.dao.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Path;
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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
  @Autowired
  private ConstraintValidator constraintValidator;

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with
   * {@code constraintViolation}.
   * <p>
   * Method under test:
   * {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  public void testGetErrorMessageWithConstraintViolation() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl = mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());
    PathImpl createRootPathResult = PathImpl.createRootPath();
    createRootPathResult.addCrossParameterNode();
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(createRootPathResult);
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("<cross-parameter> Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with
   * {@code constraintViolation}.
   * <ul>
   *   <li>Then calls {@link Iterable#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  public void testGetErrorMessageWithConstraintViolation_thenCallsIterator() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl = mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());

    ArrayList<Path.Node> nodeList = new ArrayList<>();
    nodeList.add(mock(Path.Node.class));
    nodeList.add(mock(Path.Node.class));
    Path path = mock(Path.class);
    when(path.iterator()).thenReturn(nodeList.iterator());
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(path);
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintViolation).getPropertyPath();
    verify(path).iterator();
    verify(constraintDescriptorImpl).getAnnotation();
    verify(constraintDescriptorImpl).getAttributes();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with
   * {@code constraintViolation}.
   * <ul>
   *   <li>Then return {@code 42 Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  public void testGetErrorMessageWithConstraintViolation_thenReturn42NotAllWhoWanderAreLost() {
    // Arrange
    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("fieldName", "42");
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl = mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(stringObjectMap);
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenReturn(constraintDescriptorImpl);

    // Act
    String actualErrorMessage = ConstraintValidator.getErrorMessage(constraintViolation);

    // Assert
    verify(constraintViolation).getConstraintDescriptor();
    verify(constraintViolation).getMessage();
    verify(constraintDescriptorImpl).getAttributes();
    assertEquals("42 Not all who wander are lost", actualErrorMessage);
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with
   * {@code constraintViolation}.
   * <ul>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  public void testGetErrorMessageWithConstraintViolation_thenReturnNotAllWhoWanderAreLost() {
    // Arrange
    ConstraintDescriptorImpl<Annotation> constraintDescriptorImpl = mock(ConstraintDescriptorImpl.class);
    when(constraintDescriptorImpl.getAnnotation()).thenReturn(null);
    when(constraintDescriptorImpl.getAttributes()).thenReturn(new HashMap<>());
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    when(constraintViolation.getMessage()).thenReturn("Not all who wander are lost");
    when(constraintViolation.getPropertyPath()).thenReturn(PathImpl.createRootPath());
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
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
   * Test {@link ConstraintValidator#getErrorMessage(ConstraintViolation)} with
   * {@code constraintViolation}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ConstraintValidator#getErrorMessage(ConstraintViolation)}
   */
  @Test
  public void testGetErrorMessageWithConstraintViolation_thenThrowDataValidationException() {
    // Arrange
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> ConstraintValidator.getErrorMessage(constraintViolation));
    verify(constraintViolation).getConstraintDescriptor();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with
   * {@code constraintsViolations}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  public void testGetErrorMessageWithConstraintsViolations_thenThrowDataValidationException() {
    // Arrange
    ConstraintViolation<Object> constraintViolation = mock(ConstraintViolation.class);
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation.getConstraintDescriptor()).thenReturn(null);
    ConstraintViolation<Object> constraintViolation2 = mock(ConstraintViolation.class);
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation2.getConstraintDescriptor()).thenReturn(null);
    ConstraintViolation<Object> constraintViolation3 = mock(ConstraintViolation.class);
    Mockito.<ConstraintDescriptor<?>>when(constraintViolation3.getConstraintDescriptor())
        .thenThrow(new DataValidationException("An error occurred"));

    ArrayList<ConstraintViolation<Object>> constraintsViolations = new ArrayList<>();
    constraintsViolations.add(constraintViolation3);
    constraintsViolations.add(constraintViolation2);
    constraintsViolations.add(constraintViolation);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> ConstraintValidator.getErrorMessage(constraintsViolations));
    verify(constraintViolation3).getConstraintDescriptor();
  }

  /**
   * Test {@link ConstraintValidator#getErrorMessage(Collection)} with
   * {@code constraintsViolations}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConstraintValidator#getErrorMessage(Collection)}
   */
  @Test
  public void testGetErrorMessageWithConstraintsViolations_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", ConstraintValidator.getErrorMessage(new ArrayList<>()));
  }

  /**
   * Test {@link ConstraintValidator#validatorFactoryBean()}.
   * <p>
   * Method under test: {@link ConstraintValidator#validatorFactoryBean()}
   */
  @Test
  public void testValidatorFactoryBean() {
    // Arrange and Act
    LocalValidatorFactoryBean actualValidatorFactoryBeanResult = constraintValidator.validatorFactoryBean();

    // Assert
    assertTrue(actualValidatorFactoryBeanResult.getClockProvider() instanceof DefaultClockProvider);
    assertTrue(actualValidatorFactoryBeanResult.getParameterNameProvider() instanceof DefaultParameterNameProvider);
    assertTrue(actualValidatorFactoryBeanResult.getValidator() instanceof ValidatorImpl);
    assertTrue(actualValidatorFactoryBeanResult.getTraversableResolver() instanceof JPATraversableResolver);
    assertTrue(actualValidatorFactoryBeanResult.getMessageInterpolator() instanceof LocaleContextMessageInterpolator);
    assertTrue(
        actualValidatorFactoryBeanResult.getConstraintValidatorFactory() instanceof SpringConstraintValidatorFactory);
    assertTrue(actualValidatorFactoryBeanResult.getValidationPropertyMap().isEmpty());
  }
}
